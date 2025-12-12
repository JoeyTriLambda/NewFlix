package flix.com.vision.providers;

import java.io.IOException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Minimal 9animetv.to scraper to retrieve RapidCloud/stream links.
 */
public final class NineAnimeFetcher {

    private static final String BASE_URL = "https://9animetv.to";
    private static final Pattern EPISODE_ID = Pattern.compile("episodeId\\s*=\\s*\"(?<id>\\d+)\"");

    private final OkHttpClient client;
    private final String userAgent;

    public NineAnimeFetcher(OkHttpClient client, String userAgent) {
        this.client = client;
        this.userAgent = userAgent;
    }

    /**
     * Search anime and return first watch URL.
     */
    public String search(String title) throws IOException {
        String query = title.trim().toLowerCase(Locale.US);
        HttpUrl url = HttpUrl.parse(BASE_URL + "/search")
                .newBuilder()
                .addQueryParameter("keyword", query)
                .build();
        String body = fetch(url.toString(), BASE_URL);
        if (body == null) return null;
        Document doc = Jsoup.parse(body);
        Element first = doc.selectFirst(".flw-item a[href^=/watch/]");
        if (first == null) return null;
        String href = first.attr("href");
        if (!href.startsWith("http")) {
            href = BASE_URL + href;
        }
        return href;
    }

    /**
     * Resolve a given episode (1-based) to a stream or embed URL.
     */
    public String resolveEpisode(String watchUrl, int episodeNumber) throws IOException {
        if (watchUrl == null) return null;
        String watchHtml = fetch(watchUrl, BASE_URL);
        if (watchHtml == null) return null;
        Document doc = Jsoup.parse(watchHtml);
        // Episodes list often has data-id attributes
        Elements eps = doc.select("[data-id]");
        String episodeId = null;
        for (Element el : eps) {
            if (!el.hasAttr("data-number")) continue;
            String num = el.attr("data-number");
            try {
                int parsed = Integer.parseInt(num);
                if (parsed == episodeNumber) {
                    episodeId = el.attr("data-id");
                    break;
                }
            } catch (NumberFormatException ignored) {
            }
        }
        if (episodeId == null) {
            Matcher m = EPISODE_ID.matcher(watchHtml);
            if (m.find()) {
                episodeId = m.group("id");
            }
        }
        if (episodeId == null) {
            return null;
        }

        // server list
        HttpUrl serversUrl = HttpUrl.parse(BASE_URL + "/ajax/episode/servers")
                .newBuilder()
                .addQueryParameter("episodeId", episodeId)
                .build();
        String serversJson = fetch(serversUrl.toString(), watchUrl);
        if (serversJson == null) return null;
        JSONObject serversObj = new JSONObject(serversJson);
        JSONArray servers = serversObj.optJSONArray("data");
        if (servers == null) {
            servers = serversObj.optJSONArray("servers");
        }
        String serverId = null;
        // The response shape varies; try to pull the first server id regardless of field name
        if (servers != null) {
            for (int i = 0; i < servers.length() && serverId == null; i++) {
                JSONObject srv = servers.optJSONObject(i);
                if (srv != null && srv.has("id")) {
                    serverId = srv.optString("id", null);
                }
            }
        }
        if (serverId == null) {
            // fallback: regex for id="12345"
            Matcher m2 = Pattern.compile("id\\\\\"\\\\s*:\\s*\\\\\"(?<sid>\\\\d+)\\\\\"").matcher(serversJson);
            if (m2.find()) {
                serverId = m2.group("sid");
            }
        }
        if (serverId == null) return null;

        HttpUrl sourcesUrl = HttpUrl.parse(BASE_URL + "/ajax/episode/sources")
                .newBuilder()
                .addQueryParameter("id", serverId)
                .build();
        String sourcesJson = fetch(sourcesUrl.toString(), watchUrl);
        if (sourcesJson == null) return null;
        JSONObject sourcesObj = new JSONObject(sourcesJson);
        return sourcesObj.optString("link", null);
    }

    private String fetch(String url, String referer) throws IOException {
        Request req = new Request.Builder()
                .url(url)
                .header("User-Agent", userAgent)
                .header("Referer", referer)
                .header("X-Requested-With", "XMLHttpRequest")
                .build();
        try (Response resp = client.newCall(req).execute()) {
            if (resp.body() == null) return null;
            return resp.body().string();
        }
    }
}
