package vd;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import flix.com.vision.helpers.Constants;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import hd.o;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import org.adblockplus.libadblockplus.android.webview.AdblockWebView;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jsoup.nodes.Element;

/* compiled from: RapidMoviesSeries.java */
/* loaded from: classes2.dex */
public final class h extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f20729f;

    /* renamed from: h, reason: collision with root package name */
    public int f20731h;

    /* renamed from: i, reason: collision with root package name */
    public int f20732i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f20733j;

    /* renamed from: k, reason: collision with root package name */
    public String f20734k;

    /* renamed from: o, reason: collision with root package name */
    public AdblockWebView f20738o;

    /* renamed from: g, reason: collision with root package name */
    public final String f20730g = "https://rmz.cr";

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList<String> f20735l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    public int f20736m = 0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f20737n = true;

    /* renamed from: p, reason: collision with root package name */
    public boolean f20739p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f20740q = false;

    /* compiled from: RapidMoviesSeries.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f20741a;
    }

    /* compiled from: RapidMoviesSeries.java */
    public class b extends WebViewClient {

        /* compiled from: RapidMoviesSeries.java */
        public class a implements ValueCallback<String> {
            public a() {
            }

            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                b bVar = b.this;
                h.this.getClass();
                if (str == null || str.length() < 100) {
                    return;
                }
                try {
                    String strUnescapeJava = StringEscapeUtils.unescapeJava(str);
                    if (strUnescapeJava.contains("Checking if the site connection is secure") || strUnescapeJava.contains("Checking your browser before accessing")) {
                        return;
                    }
                    h hVar = h.this;
                    if (hVar.f20737n) {
                        hVar.b(strUnescapeJava, true);
                    } else {
                        hVar.c(strUnescapeJava, true);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }

        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            AdblockWebView adblockWebView;
            super.onPageFinished(webView, str);
            h hVar = h.this;
            if (hVar.f20739p || (adblockWebView = hVar.f20738o) == null) {
                return;
            }
            adblockWebView.evaluateJavascript("(function(){var el = document.documentElement; var xml = el.innerHTML; return xml;})()", new a());
        }
    }

    public h(Context context, Movie movie, gd.f fVar) {
        this.f20733j = context;
        this.f20729f = movie;
        this.f12431b = fVar;
        EventBus.getDefault().register(this);
    }

    public static String parseLink(String str) {
        try {
            return str.split("--")[2].replace(">", "").trim().replace("<!", "").trim();
        } catch (Exception unused) {
            return null;
        }
    }

    public final void b(String str, boolean z10) {
        ArrayList<String> arrayList;
        Movie movie;
        try {
            Iterator<Element> it = ch.a.parse(str).getElementsByClass("title").iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                arrayList = this.f20735l;
                movie = this.f20729f;
                if (!zHasNext) {
                    break;
                }
                Element next = it.next();
                String lowerCase = next.text().toLowerCase();
                String strAttr = next.attr("href");
                if (strAttr.contains("/release/") && !lowerCase.isEmpty()) {
                    String str2 = movie.getTitle() + StringUtils.SPACE + movie.getYear();
                    String strReplace = movie.getTitle().replace(":", "").replace(" - ", StringUtils.SPACE).replace("-", StringUtils.SPACE);
                    String str3 = strReplace + StringUtils.SPACE + movie.getYear();
                    String str4 = strReplace + " (" + movie.getYear() + ")";
                    if (be.f.removeSpecialChars(lowerCase).toLowerCase().contains(be.f.removeSpecialChars(movie.getTitle() + StringUtils.SPACE + this.f20734k).toLowerCase()) || lowerCase.contains(str3.toLowerCase()) || lowerCase.contains(str4.toLowerCase()) || lowerCase.contains(str2.toLowerCase())) {
                        if (strAttr.startsWith("/")) {
                            strAttr = this.f20730g + strAttr;
                        }
                        arrayList.add(strAttr);
                    }
                }
            }
            if (movie.getMovieId() == 225634) {
                arrayList.add("https://rmz.cr/monster-the-jeffrey-dahmer-story");
            }
            if (arrayList.size() <= 0 || this.f20739p) {
                return;
            }
            if (z10) {
                this.f20737n = false;
                this.f20738o.loadUrl(arrayList.get(this.f20736m));
                this.f20736m++;
            } else {
                Iterator<String> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    c(((dh.b) ch.a.connect(it2.next())).get().html(), false);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void c(String str, boolean z10) {
        Iterator<Element> it = ch.a.parse(str).getElementsByTag("PRE").iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (next.attr("class") != null && next.attr("class").length() > 0) {
                o oVar = new o();
                oVar.f13047w = false;
                oVar.f13044t = true;
                oVar.F = true;
                Element elementFirst = next.getElementsByTag("A").first();
                if (elementFirst != null) {
                    oVar.D = elementFirst.attr("href");
                } else {
                    oVar.D = parseLink(next.toString());
                }
                if (oVar.D != null) {
                    try {
                        addLink(oVar);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        if (z10) {
            ArrayList<String> arrayList = this.f20735l;
            if (arrayList.size() <= 0 || this.f20736m >= arrayList.size()) {
                return;
            }
            this.f20737n = false;
            this.f20738o.loadUrl(arrayList.get(this.f20736m));
            this.f20736m++;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Constants.a aVar) {
        this.f20739p = true;
        EventBus.getDefault().unregister(this);
    }

    public void process(int i10, int i11) {
        String strReplace;
        this.f20731h = i10;
        this.f20732i = i11;
        AdblockWebView adblockWebView = new AdblockWebView(this.f20733j);
        this.f20738o = adblockWebView;
        adblockWebView.setWebViewClient(new b());
        this.f20738o.getSettings().setAllowContentAccess(true);
        this.f20738o.getSettings().setJavaScriptEnabled(true);
        this.f20734k = "S" + be.f.formatSeasonnumber(this.f20731h) + "E" + be.f.formatSeasonnumber(this.f20732i);
        String str = this.f20729f.getTitle().replace("&", "") + StringUtils.SPACE + this.f20734k;
        String strO = ac.c.o(new StringBuilder(), this.f20730g, "/search/");
        try {
            strReplace = URLEncoder.encode(str, StandardCharsets.UTF_8.toString());
        } catch (Exception unused) {
            strReplace = strO.replace(StringUtils.SPACE, "%20");
        }
        new g(this, ac.c.C(strO, strReplace, "/releases")).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(a aVar) {
        String str;
        if (this.f20740q || aVar == null || (str = aVar.f20741a) == null) {
            return;
        }
        this.f20740q = true;
        try {
            this.f20738o.loadUrl(str);
        } catch (Exception unused) {
        }
        new Handler().postDelayed(new vb.d(this, 9), 1000L);
    }
}
