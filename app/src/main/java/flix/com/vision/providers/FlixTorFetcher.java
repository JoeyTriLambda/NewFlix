package flix.com.vision.providers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Minimal FlixTor scraper used to locate direct HLS URLs.
 * Not perfect, but mirrors the StreamVerse port sufficiently for NewFlix.
 */
public final class FlixTorFetcher {

    private static final String BASE_URL = "https://flixtor.to";
    private static final Pattern WATCH_ID = Pattern.compile("/watch/(?:movie|tv)/(?<id>\\d+)");
    private static final Pattern M3U8_PATTERN = Pattern.compile("https?://[^\"'\\s]+\\.m3u8[^\"'\\s]*", Pattern.CASE_INSENSITIVE);
    private static final Pattern XCDN_PATTERN = Pattern.compile("https?://[^\"'\\s]*xcdn\\.to[^\"'\\s]*", Pattern.CASE_INSENSITIVE);

    private final OkHttpClient client;
    private final String userAgent;

    public FlixTorFetcher(OkHttpClient client, String userAgent) {
        this.client = client;
        this.userAgent = userAgent;
    }

    public String buildTvWatchUrl(int showId, int season, int episode) {
        return BASE_URL + "/watch/tv/" + showId + "?ep=" + season + ":" + episode;
    }

    public String buildMovieWatchUrl(int movieId) {
        return BASE_URL + "/watch/movie/" + movieId;
    }

    /**
     * Search FlixTor and return first matching watch URL path.
     */
    public String search(String query, boolean tv) throws IOException {
        String normalized = query.trim().toLowerCase(Locale.US).replace(' ', '-');
        HttpUrl ajaxUrl = HttpUrl.parse(BASE_URL + "/ajax/show/search/" + normalized + "/from/1800/to/2099/rating/0/votes/0/language/all/type/all/genre/all/relevance/page/1")
                .newBuilder()
                .addQueryParameter("_", String.valueOf(System.currentTimeMillis()))
                .build();

        Request req = new Request.Builder()
                .url(ajaxUrl)
                .header("User-Agent", userAgent)
                .header("X-Requested-With", "XMLHttpRequest")
                .header("Referer", BASE_URL + "/show/search/" + normalized)
                .build();

        try (Response resp = client.newCall(req).execute()) {
            if (!resp.isSuccessful() || resp.body() == null) {
                return null;
            }
            String html = resp.body().string();
            Document doc = Jsoup.parse(html);
            Elements anchors = doc.select("[data-href], a[href]");
            for (Element el : anchors) {
                String href = el.hasAttr("data-href") ? el.attr("data-href") : el.attr("href");
                if (href == null) continue;
                if (!href.startsWith("http")) {
                    href = BASE_URL + href;
                }
                if (tv && href.contains("/watch/tv/")) {
                    return href;
                }
                if (!tv && href.contains("/watch/movie/")) {
                    return href;
                }
            }
        }
        return null;
    }

    /**
     * Resolve a FlixTor watch URL to a direct stream (m3u8) if possible.
     */
    public String resolveStream(String watchUrl, Integer season, Integer episode) throws IOException {
        if (watchUrl == null) return null;
        String id = extractWatchId(watchUrl);
        if (id == null) return null;

        // Try AJAX v4 (movie or episode)
        String ajaxUrl;
        if (season != null && episode != null) {
            ajaxUrl = BASE_URL + "/ajax/v4/e/" + id + "/" + season + "/" + episode + "?_=" + System.currentTimeMillis();
        } else {
            ajaxUrl = BASE_URL + "/ajax/v4/m/" + id + "?_=" + System.currentTimeMillis();
        }

        List<String> candidates = new ArrayList<>();
        candidates.add(fetchBody(ajaxUrl));

        // Fall back to page scrape if needed
        String pageHtml = null;
        if (candidates.get(0) == null || candidates.get(0).isEmpty()) {
            pageHtml = fetchBody(watchUrl);
            if (pageHtml != null) {
                candidates.add(pageHtml);
            }
        }

        // Decode permutations
        List<String> decoded = new ArrayList<>();
        for (String c : candidates) {
            if (c == null) continue;
            decoded.add(c);
            decoded.add(rot13(c));
            decoded.add(asciiShift(c, -1));
            decoded.add(asciiShift(c, 1));
            String b64 = base64DecodeSafe(c);
            if (b64 != null) {
                decoded.add(b64);
                decoded.add(rot13(b64));
                decoded.add(asciiShift(b64, -1));
                decoded.add(asciiShift(b64, 1));
            }
        }

        // Look for HLS URLs
        for (String s : decoded) {
            if (s == null) continue;
            String hit = findBestUrl(s);
            if (hit != null) {
                return hit;
            }
        }

        // Last resort: parse watch page html for video/m3u8
        if (pageHtml == null) {
            pageHtml = fetchBody(watchUrl);
        }
        if (pageHtml != null) {
            String hit = findBestUrl(pageHtml);
            if (hit != null) return hit;
            Document doc = Jsoup.parse(pageHtml);
            for (Element script : doc.select("script")) {
                String hit2 = findBestUrl(script.data());
                if (hit2 != null) return hit2;
            }
        }
        return null;
    }

    private String fetchBody(String url) throws IOException {
        if (url == null) return null;
        Request req = new Request.Builder()
                .url(url)
                .header("User-Agent", userAgent)
                .header("Referer", BASE_URL)
                .build();
        try (Response resp = client.newCall(req).execute()) {
            if (resp.body() == null) return null;
            return resp.body().string();
        }
    }

    private static String extractWatchId(String watchUrl) {
        Matcher m = WATCH_ID.matcher(watchUrl);
        if (m.find()) {
            return m.group("id");
        }
        return null;
    }

    private static String findBestUrl(String text) {
        if (text == null) return null;
        List<String> urls = new ArrayList<>();
        Matcher m3u8 = M3U8_PATTERN.matcher(text);
        while (m3u8.find()) {
            urls.add(m3u8.group());
        }
        Matcher xcdn = XCDN_PATTERN.matcher(text);
        while (xcdn.find()) {
            urls.add(0, xcdn.group());
        }
        return urls.isEmpty() ? null : urls.get(0);
    }

    private static String rot13(String input) {
        if (input == null) return null;
        StringBuilder sb = new StringBuilder(input.length());
        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' + 13) % 26 + 'a'));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ((c - 'A' + 13) % 26 + 'A'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String asciiShift(String input, int delta) {
        if (input == null) return null;
        StringBuilder sb = new StringBuilder(input.length());
        for (char c : input.toCharArray()) {
            sb.append((char) (c + delta));
        }
        return sb.toString();
    }

    private static String base64DecodeSafe(String input) {
        try {
            byte[] decoded = Base64.getDecoder().decode(input.replaceAll("\\s", ""));
            return new String(decoded, StandardCharsets.UTF_8);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
