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

/* compiled from: RapidMovies.java */
/* loaded from: classes2.dex */
public final class f extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f20715f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f20716g;

    /* renamed from: l, reason: collision with root package name */
    public AdblockWebView f20721l;

    /* renamed from: h, reason: collision with root package name */
    public final String f20717h = "https://rmz.cr";

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList<String> f20718i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public int f20719j = 0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20720k = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20722m = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f20723n = false;

    /* compiled from: RapidMovies.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f20724a;
    }

    /* compiled from: RapidMovies.java */
    public class b extends WebViewClient {

        /* compiled from: RapidMovies.java */
        public class a implements ValueCallback<String> {
            public a() {
            }

            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                b bVar = b.this;
                f.this.getClass();
                if (str == null || str.length() < 100) {
                    return;
                }
                try {
                    String strUnescapeJava = StringEscapeUtils.unescapeJava(str);
                    if (strUnescapeJava.contains("Checking if the site connection is secure") || strUnescapeJava.contains("Checking your browser before accessing")) {
                        return;
                    }
                    f fVar = f.this;
                    if (fVar.f20720k) {
                        fVar.b(strUnescapeJava, true);
                    } else {
                        fVar.c(strUnescapeJava, true);
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
            f fVar = f.this;
            if (fVar.f20722m || (adblockWebView = fVar.f20721l) == null) {
                return;
            }
            adblockWebView.evaluateJavascript("(function(){var el = document.documentElement; var xml = el.innerHTML; return xml;})()", new a());
        }
    }

    public f(Context context, Movie movie, gd.f fVar) {
        this.f20716g = context;
        this.f20715f = movie;
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
        String str2 = StringUtils.SPACE;
        Movie movie = this.f20715f;
        try {
            Iterator<Element> it = ch.a.parse(str).getElementsByClass("title").iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                arrayList = this.f20718i;
                if (!zHasNext) {
                    break;
                }
                Element next = it.next();
                String lowerCase = next.text().toLowerCase();
                String strAttr = next.attr("href");
                if (strAttr.contains("/release/") && !lowerCase.isEmpty()) {
                    String str3 = movie.getTitle() + str2 + movie.getYear();
                    String strReplace = movie.getTitle().replace(":", "").replace(" - ", str2).replace("-", str2);
                    String str4 = strReplace + str2 + movie.getYear();
                    String str5 = strReplace.replace("&", "and") + str2 + movie.getYear();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(strReplace);
                    sb2.append(" (");
                    String str6 = str2;
                    sb2.append(movie.getYear());
                    sb2.append(")");
                    String string = sb2.toString();
                    String str7 = strReplace.replace("&", "and") + " (" + movie.getYear() + ")";
                    if (lowerCase.contains(str4.toLowerCase()) || lowerCase.contains(str5.toLowerCase()) || lowerCase.contains(string.toLowerCase()) || lowerCase.contains(str7.toLowerCase()) || lowerCase.contains(str3.toLowerCase())) {
                        if (strAttr.startsWith("/")) {
                            strAttr = this.f20717h + strAttr;
                        }
                        arrayList.add(strAttr);
                    }
                    str2 = str6;
                }
            }
            if (arrayList.size() <= 0 || this.f20722m) {
                return;
            }
            if (z10) {
                this.f20720k = false;
                this.f20721l.loadUrl(arrayList.get(this.f20719j));
                this.f20719j++;
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
            ArrayList<String> arrayList = this.f20718i;
            if (arrayList.size() <= 0 || this.f20719j >= arrayList.size()) {
                return;
            }
            this.f20720k = false;
            this.f20721l.loadUrl(arrayList.get(this.f20719j));
            this.f20719j++;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Constants.a aVar) {
        this.f20722m = true;
        EventBus.getDefault().unregister(this);
    }

    public void process(int i10) {
        String strReplace;
        AdblockWebView adblockWebView = new AdblockWebView(this.f20716g);
        this.f20721l = adblockWebView;
        adblockWebView.setWebViewClient(new b());
        this.f20721l.getSettings().setAllowContentAccess(true);
        this.f20721l.getSettings().setJavaScriptEnabled(true);
        String strReplace2 = this.f20715f.getTitle().replace("&", "");
        String strO = ac.c.o(new StringBuilder(), this.f20717h, "/search/");
        try {
            strReplace = URLEncoder.encode(strReplace2, StandardCharsets.UTF_8.toString());
        } catch (Exception unused) {
            strReplace = strO.replace(StringUtils.SPACE, "%20");
        }
        new e(this, ac.c.C(strO, strReplace, "/releases")).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(a aVar) {
        String str;
        if (this.f20723n || aVar == null || (str = aVar.f20724a) == null) {
            return;
        }
        this.f20723n = true;
        try {
            this.f20721l.loadUrl(str);
        } catch (Exception unused) {
        }
        new Handler().postDelayed(new vb.d(this, 8), 1000L);
    }
}
