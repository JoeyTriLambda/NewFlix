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

/* compiled from: ReleasesBBSeries.java */
/* loaded from: classes2.dex */
public final class l extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public int f20761f;

    /* renamed from: g, reason: collision with root package name */
    public int f20762g;

    /* renamed from: h, reason: collision with root package name */
    public final Movie f20763h;

    /* renamed from: i, reason: collision with root package name */
    public final Context f20764i;

    /* renamed from: j, reason: collision with root package name */
    public final String f20765j = "https://search.rlsbb.to/";

    /* renamed from: k, reason: collision with root package name */
    public final boolean f20766k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList<String> f20767l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20768m;

    /* renamed from: n, reason: collision with root package name */
    public int f20769n;

    /* renamed from: o, reason: collision with root package name */
    public WebView f20770o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f20771p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f20772q;

    /* compiled from: ReleasesBBSeries.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f20773a;
    }

    /* compiled from: ReleasesBBSeries.java */
    public class b extends WebViewClient {

        /* compiled from: ReleasesBBSeries.java */
        public class a implements ValueCallback<String> {
            public a() {
            }

            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                b bVar = b.this;
                l.this.getClass();
                if (str == null || str.length() < 100) {
                    return;
                }
                try {
                    String strUnescapeJava = StringEscapeUtils.unescapeJava(str);
                    if (strUnescapeJava.contains("Just a moment...") || strUnescapeJava.contains("Checking if the site connection is secure") || strUnescapeJava.contains("Checking your browser before accessing")) {
                        return;
                    }
                    l lVar = l.this;
                    if (lVar.f20766k) {
                        lVar.b(strUnescapeJava, true);
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
            l lVar = l.this;
            if (lVar.f20772q || (webView2 = lVar.f20770o) == null) {
                return;
            }
            try {
                webView2.evaluateJavascript("(function(){var el = document.documentElement; var xml = el.innerHTML; return xml;})()", new a());
            } catch (Exception unused) {
            }
        }
    }

    public l(Context context, Movie movie, gd.f fVar) {
        new ArrayList();
        this.f20766k = true;
        this.f20767l = new ArrayList<>();
        this.f20768m = false;
        this.f20769n = 0;
        this.f20771p = false;
        this.f20772q = false;
        this.f20764i = context;
        this.f20763h = movie;
        this.f12431b = fVar;
        EventBus.getDefault().register(this);
    }

    public final void b(String str, boolean z10) {
        Element elementLast;
        boolean z11;
        ArrayList<String> arrayList = this.f20767l;
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
                    if (z11 && this.f20769n < 50) {
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
                                this.f20769n++;
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            if (this.f20769n != 0 || this.f20768m) {
                return;
            }
            this.f20768m = true;
            try {
                elementLast = ch.a.parse(str).getElementsByClass("more-link").last();
            } catch (Exception unused2) {
            }
            String strAttr2 = elementLast != null ? elementLast.attr("href") : null;
            if (strAttr2 != null) {
                new k(this, strAttr2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Constants.a aVar) {
        this.f20772q = true;
        EventBus.getDefault().unregister(this);
    }

    public void process(int i10, int i11, int i12) {
        String strReplace;
        this.f20761f = i11;
        this.f20762g = i12;
        WebView webView = new WebView(this.f20764i);
        this.f20770o = webView;
        webView.setWebViewClient(new b());
        this.f20770o.getSettings().setAllowContentAccess(true);
        this.f20770o.getSettings().setJavaScriptEnabled(true);
        String strReplace2 = this.f20763h.getTitle().replace("&", "");
        String str = be.f.removeSpecialCharsKeepSpace(strReplace2) + StringUtils.SPACE + ("S" + be.f.formatSeasonnumber(this.f20761f) + "E" + be.f.formatSeasonnumber(this.f20762g));
        String strO = ac.c.o(new StringBuilder(), this.f20765j, "/?s=");
        try {
            strReplace = URLEncoder.encode(str, StandardCharsets.UTF_8.toString());
        } catch (Exception unused) {
            strReplace = strO.replace(StringUtils.SPACE, "+");
        }
        new k(this, ac.c.B(strO, strReplace)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(a aVar) {
        String str;
        if (this.f20771p || aVar == null || (str = aVar.f20773a) == null) {
            return;
        }
        this.f20771p = true;
        try {
            this.f20770o.loadUrl(str);
        } catch (Exception unused) {
        }
        new Handler().postDelayed(new vb.d(this, 11), 1000L);
    }
}
