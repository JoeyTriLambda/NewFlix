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
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jsoup.nodes.Element;

/* compiled from: ReleasesBBMovies.java */
/* loaded from: classes2.dex */
public final class j extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f20746f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f20747g;

    /* renamed from: h, reason: collision with root package name */
    public final String f20748h = "https://search.rlsbb.to/";

    /* renamed from: i, reason: collision with root package name */
    public final boolean f20749i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList<String> f20750j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20751k;

    /* renamed from: l, reason: collision with root package name */
    public int f20752l;

    /* renamed from: m, reason: collision with root package name */
    public WebView f20753m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f20754n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f20755o;

    /* compiled from: ReleasesBBMovies.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f20756a;
    }

    /* compiled from: ReleasesBBMovies.java */
    public class b extends WebViewClient {

        /* compiled from: ReleasesBBMovies.java */
        public class a implements ValueCallback<String> {
            public a() {
            }

            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                b bVar = b.this;
                j.this.getClass();
                if (str == null || str.length() < 100) {
                    return;
                }
                try {
                    String strUnescapeJava = StringEscapeUtils.unescapeJava(str);
                    if (strUnescapeJava.contains("Just a moment...") || strUnescapeJava.contains("Checking if the site connection is secure") || strUnescapeJava.contains("Checking your browser before accessing")) {
                        return;
                    }
                    j jVar = j.this;
                    if (jVar.f20749i) {
                        jVar.b(strUnescapeJava, true);
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
            WebView webView2;
            super.onPageFinished(webView, str);
            j jVar = j.this;
            if (jVar.f20755o || (webView2 = jVar.f20753m) == null) {
                return;
            }
            try {
                webView2.evaluateJavascript("(function(){var el = document.documentElement; var xml = el.innerHTML; return xml;})()", new a());
            } catch (Exception unused) {
            }
        }
    }

    public j(Context context, Movie movie, gd.f fVar) {
        new ArrayList();
        this.f20749i = true;
        this.f20750j = new ArrayList<>();
        this.f20751k = false;
        this.f20752l = 0;
        this.f20754n = false;
        this.f20755o = false;
        this.f20747g = context;
        this.f20746f = movie;
        this.f12431b = fVar;
        EventBus.getDefault().register(this);
    }

    public final void b(String str, boolean z10) {
        Element elementLast;
        boolean z11;
        ArrayList<String> arrayList = this.f20750j;
        arrayList.add("NiTROFLARE.".toLowerCase());
        arrayList.add("RAPiDGATOR.".toLowerCase());
        arrayList.add("FIKPER.".toLowerCase());
        try {
            Iterator<Element> it = ch.a.parse(str).getElementsByTag("A").iterator();
            while (it.hasNext()) {
                Element next = it.next();
                next.text().toLowerCase().getClass();
                String strTrim = next.attr("href").toLowerCase().trim();
                if (!strTrim.isEmpty() && strTrim.length() >= 15) {
                    Iterator<String> it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z11 = false;
                            break;
                        } else if (strTrim.contains(it2.next())) {
                            z11 = true;
                            break;
                        }
                    }
                    if (z11 && this.f20752l < 50) {
                        String strAttr = next.attr("href");
                        if (!strAttr.contains("protected.")) {
                            o oVar = new o();
                            oVar.f13047w = false;
                            oVar.f13048x = true;
                            oVar.f13044t = true;
                            oVar.F = true;
                            oVar.D = strAttr;
                            try {
                                addLink(oVar);
                                this.f20752l++;
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            if (this.f20752l != 0 || this.f20751k) {
                return;
            }
            this.f20751k = true;
            try {
                elementLast = ch.a.parse(str).getElementsByClass("more-link").last();
            } catch (Exception unused2) {
            }
            String strAttr2 = elementLast != null ? elementLast.attr("href") : null;
            if (strAttr2 != null) {
                new i(this, strAttr2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Constants.a aVar) {
        this.f20755o = true;
        EventBus.getDefault().unregister(this);
    }

    public void process(int i10) {
        String strReplace;
        WebView webView = new WebView(this.f20747g);
        this.f20753m = webView;
        webView.setWebViewClient(new b());
        this.f20753m.getSettings().setAllowContentAccess(true);
        this.f20753m.getSettings().setJavaScriptEnabled(true);
        StringBuilder sb2 = new StringBuilder();
        Movie movie = this.f20746f;
        sb2.append(movie.getTitle().replace("&", ""));
        sb2.append(StringUtils.SPACE);
        sb2.append(movie.getYear());
        String strRemoveSpecialCharsKeepSpace = be.f.removeSpecialCharsKeepSpace(sb2.toString());
        String strO = ac.c.o(new StringBuilder(), this.f20748h, "/?s=");
        try {
            strReplace = URLEncoder.encode(strRemoveSpecialCharsKeepSpace, StandardCharsets.UTF_8.toString());
        } catch (Exception unused) {
            strReplace = strO.replace(StringUtils.SPACE, "+");
        }
        new i(this, ac.c.B(strO, strReplace)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(a aVar) {
        String str;
        if (this.f20754n || aVar == null || (str = aVar.f20756a) == null) {
            return;
        }
        this.f20754n = true;
        try {
            this.f20753m.loadUrl(str);
        } catch (Exception unused) {
        }
        new Handler().postDelayed(new vb.d(this, 10), 1000L);
    }
}
