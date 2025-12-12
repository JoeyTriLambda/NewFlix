package vd;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import flix.com.vision.App;
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

/* compiled from: DDLValleyMovies.java */
/* loaded from: classes2.dex */
public final class b extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f20682f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f20683g;

    /* renamed from: m, reason: collision with root package name */
    public AdblockWebView f20689m;

    /* renamed from: h, reason: collision with root package name */
    public final String f20684h = "https://www.scnsrc.me";

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList<String> f20685i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public int f20686j = 0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20687k = true;

    /* renamed from: l, reason: collision with root package name */
    public int f20688l = 0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f20690n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f20691o = false;

    /* compiled from: DDLValleyMovies.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f20692a;
    }

    /* compiled from: DDLValleyMovies.java */
    /* renamed from: vd.b$b, reason: collision with other inner class name */
    public class C0299b extends WebViewClient {

        /* compiled from: DDLValleyMovies.java */
        /* renamed from: vd.b$b$a */
        public class a implements ValueCallback<String> {
            public a() {
            }

            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                C0299b c0299b = C0299b.this;
                b.this.getClass();
                if (str == null || str.length() < 100) {
                    return;
                }
                try {
                    String strUnescapeJava = StringEscapeUtils.unescapeJava(str);
                    if (strUnescapeJava.contains("Just a moment...") || strUnescapeJava.contains("Checking if the site connection is secure") || strUnescapeJava.contains("Checking your browser before accessing")) {
                        return;
                    }
                    b bVar = b.this;
                    if (bVar.f20687k) {
                        bVar.b(strUnescapeJava, true);
                    } else {
                        bVar.c(strUnescapeJava, true);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }

        public C0299b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            AdblockWebView adblockWebView;
            super.onPageFinished(webView, str);
            b bVar = b.this;
            if (bVar.f20691o || (adblockWebView = bVar.f20689m) == null) {
                return;
            }
            try {
                adblockWebView.evaluateJavascript("(function(){var el = document.documentElement; var xml = el.innerHTML; return xml;})()", new a());
            } catch (Exception unused) {
            }
        }
    }

    public b(Context context, Movie movie, gd.f fVar) {
        this.f20683g = context;
        this.f20682f = movie;
        this.f12431b = fVar;
        EventBus.getDefault().register(this);
    }

    public final void b(String str, boolean z10) {
        ArrayList<String> arrayList;
        Movie movie = this.f20682f;
        try {
            Iterator<Element> it = ch.a.parse(str).getElementsByTag("A").iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                arrayList = this.f20685i;
                if (!zHasNext) {
                    break;
                }
                Element next = it.next();
                String lowerCase = next.text().toLowerCase();
                if (!lowerCase.isEmpty() && lowerCase.length() >= 15) {
                    String strAttr = next.attr("href");
                    String str2 = movie.getTitle() + StringUtils.SPACE + movie.getYear();
                    String strReplace = movie.getTitle().replace(":", "").replace(" - ", StringUtils.SPACE).replace("-", StringUtils.SPACE);
                    String str3 = strReplace + StringUtils.SPACE + movie.getYear();
                    String strRemoveSpecialChars = be.f.removeSpecialChars(movie.getTitle());
                    String strRemoveSpecialChars2 = be.f.removeSpecialChars(lowerCase);
                    String str4 = strReplace.replace("&", StringUtils.SPACE) + StringUtils.SPACE + movie.getYear();
                    if (strRemoveSpecialChars2.toLowerCase().contains(strRemoveSpecialChars.toLowerCase()) || lowerCase.contains(str3.toLowerCase()) || lowerCase.contains(str4.toLowerCase()) || lowerCase.contains(str2.toLowerCase())) {
                        if (strAttr.startsWith("/")) {
                            strAttr = this.f20684h + strAttr;
                        }
                        arrayList.add(strAttr);
                    }
                }
            }
            if (arrayList.size() <= 0 || this.f20691o) {
                return;
            }
            if (z10) {
                this.f20687k = false;
                this.f20689m.loadUrl(arrayList.get(this.f20686j));
                this.f20686j++;
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
        if (this.f20688l > 40) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = ch.a.parse(str).getElementsByTag("A").iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (this.f20688l > 40) {
                return;
            }
            String strAttr = next.attr("href");
            if (!strAttr.startsWith("/") && !strAttr.contains(this.f20684h) && next.text().length() >= 10 && !strAttr.contains(".rar") && App.isRdSupported(strAttr)) {
                this.f20688l++;
                o oVar = new o();
                oVar.f13047w = false;
                oVar.f13048x = true;
                oVar.f13044t = true;
                oVar.F = true;
                oVar.D = strAttr;
                try {
                    addLink(oVar);
                    arrayList.add(oVar);
                } catch (Exception unused) {
                }
            }
        }
        if (z10) {
            ArrayList<String> arrayList2 = this.f20685i;
            if (arrayList2.size() <= 0 || this.f20686j >= 2 || arrayList2.size() <= 1) {
                return;
            }
            this.f20687k = false;
            this.f20689m.loadUrl(arrayList2.get(this.f20686j));
            this.f20686j++;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Constants.a aVar) {
        this.f20691o = true;
        EventBus.getDefault().unregister(this);
    }

    public void process(int i10) {
        String strReplace;
        AdblockWebView adblockWebView = new AdblockWebView(this.f20683g);
        this.f20689m = adblockWebView;
        adblockWebView.setWebViewClient(new C0299b());
        this.f20689m.getSettings().setAllowContentAccess(true);
        this.f20689m.getSettings().setJavaScriptEnabled(true);
        StringBuilder sb2 = new StringBuilder();
        Movie movie = this.f20682f;
        sb2.append(movie.getTitle().replace("&", ""));
        sb2.append(StringUtils.SPACE);
        sb2.append(movie.getYear());
        String strRemoveSpecialCharsKeepSpace = be.f.removeSpecialCharsKeepSpace(sb2.toString());
        String strO = ac.c.o(new StringBuilder(), this.f20684h, "/?s=");
        try {
            strReplace = URLEncoder.encode(strRemoveSpecialCharsKeepSpace, StandardCharsets.UTF_8.toString());
        } catch (Exception unused) {
            strReplace = strO.replace(StringUtils.SPACE, "%20");
        }
        new vd.a(this, ac.c.B(strO, strReplace)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(a aVar) {
        String str;
        if (this.f20690n || aVar == null || (str = aVar.f20692a) == null) {
            return;
        }
        this.f20690n = true;
        try {
            this.f20689m.loadUrl(str);
        } catch (Exception unused) {
        }
        new Handler().postDelayed(new vb.d(this, 6), 1000L);
    }
}
