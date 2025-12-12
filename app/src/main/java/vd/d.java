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

/* compiled from: DDLValleySeries.java */
/* loaded from: classes2.dex */
public final class d extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f20697f;

    /* renamed from: h, reason: collision with root package name */
    public int f20699h;

    /* renamed from: i, reason: collision with root package name */
    public int f20700i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f20701j;

    /* renamed from: k, reason: collision with root package name */
    public String f20702k;

    /* renamed from: p, reason: collision with root package name */
    public AdblockWebView f20707p;

    /* renamed from: g, reason: collision with root package name */
    public final String f20698g = "https://www.scnsrc.me";

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList<String> f20703l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    public int f20704m = 0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f20705n = true;

    /* renamed from: o, reason: collision with root package name */
    public int f20706o = 0;

    /* renamed from: q, reason: collision with root package name */
    public boolean f20708q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f20709r = false;

    /* compiled from: DDLValleySeries.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f20710a;
    }

    /* compiled from: DDLValleySeries.java */
    public class b extends WebViewClient {

        /* compiled from: DDLValleySeries.java */
        public class a implements ValueCallback<String> {
            public a() {
            }

            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                b bVar = b.this;
                d.this.getClass();
                if (str == null || str.length() < 100) {
                    return;
                }
                try {
                    String strUnescapeJava = StringEscapeUtils.unescapeJava(str);
                    if (strUnescapeJava.contains("Just a moment...") || strUnescapeJava.contains("Checking if the site connection is secure") || strUnescapeJava.contains("Checking your browser before accessing")) {
                        return;
                    }
                    d dVar = d.this;
                    if (dVar.f20705n) {
                        dVar.b(strUnescapeJava, true);
                    } else {
                        dVar.c(strUnescapeJava, true);
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
            d dVar = d.this;
            if (dVar.f20709r || (adblockWebView = dVar.f20707p) == null) {
                return;
            }
            adblockWebView.evaluateJavascript("(function(){var el = document.documentElement; var xml = el.innerHTML; return xml;})()", new a());
        }
    }

    public d(Context context, Movie movie, gd.f fVar) {
        this.f20701j = context;
        this.f20697f = movie;
        this.f12431b = fVar;
        EventBus.getDefault().register(this);
    }

    public final void b(String str, boolean z10) {
        ArrayList<String> arrayList;
        Movie movie = this.f20697f;
        try {
            Iterator<Element> it = ch.a.parse(str).getElementsByTag("A").iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                arrayList = this.f20703l;
                if (!zHasNext) {
                    break;
                }
                Element next = it.next();
                String lowerCase = next.text().toLowerCase();
                if (!lowerCase.isEmpty() && lowerCase.length() >= 12) {
                    String strAttr = next.attr("href");
                    String str2 = movie.getTitle() + StringUtils.SPACE + this.f20702k;
                    String strReplace = movie.getTitle().replace(":", "").replace(" - ", StringUtils.SPACE).replace("-", StringUtils.SPACE);
                    String str3 = strReplace + StringUtils.SPACE + this.f20702k;
                    String strRemoveSpecialChars = be.f.removeSpecialChars(movie.getTitle() + StringUtils.SPACE + this.f20702k);
                    String strRemoveSpecialChars2 = be.f.removeSpecialChars(lowerCase);
                    String str4 = strReplace.replace("&", StringUtils.SPACE) + StringUtils.SPACE + this.f20702k;
                    if (strRemoveSpecialChars2.toLowerCase().contains(strRemoveSpecialChars.toLowerCase()) || lowerCase.contains(str3.toLowerCase()) || lowerCase.contains(str4.toLowerCase()) || lowerCase.contains(str2.toLowerCase())) {
                        if (strAttr.startsWith("/")) {
                            strAttr = this.f20698g + strAttr;
                        }
                        arrayList.add(strAttr);
                    }
                }
            }
            if (arrayList.size() <= 0 || this.f20709r) {
                return;
            }
            if (z10) {
                this.f20705n = false;
                this.f20707p.loadUrl(arrayList.get(this.f20704m));
                this.f20704m++;
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
        if (this.f20706o > 40) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = ch.a.parse(str).getElementsByTag("A").iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (this.f20706o > 40) {
                return;
            }
            String strAttr = next.attr("href");
            if (!strAttr.startsWith("/") && !strAttr.contains(this.f20698g) && next.text().length() >= 10 && !strAttr.contains(".rar") && App.isRdSupported(strAttr)) {
                this.f20706o++;
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
            ArrayList<String> arrayList2 = this.f20703l;
            if (arrayList2.size() <= 0 || this.f20704m >= 2 || arrayList2.size() <= 1) {
                return;
            }
            this.f20705n = false;
            this.f20707p.loadUrl(arrayList2.get(this.f20704m));
            this.f20704m++;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Constants.a aVar) {
        this.f20709r = true;
        EventBus.getDefault().unregister(this);
    }

    public void process(int i10, int i11) {
        String strReplace;
        this.f20699h = i10;
        this.f20700i = i11;
        AdblockWebView adblockWebView = new AdblockWebView(this.f20701j);
        this.f20707p = adblockWebView;
        adblockWebView.setWebViewClient(new b());
        this.f20707p.getSettings().setAllowContentAccess(true);
        this.f20707p.getSettings().setJavaScriptEnabled(true);
        this.f20702k = "S" + be.f.formatSeasonnumber(this.f20699h) + "E" + be.f.formatSeasonnumber(this.f20700i);
        String strRemoveSpecialCharsKeepSpace = be.f.removeSpecialCharsKeepSpace(this.f20697f.getTitle().replace("&", "") + StringUtils.SPACE + this.f20702k);
        String strO = ac.c.o(new StringBuilder(), this.f20698g, "/?s=");
        try {
            strReplace = URLEncoder.encode(strRemoveSpecialCharsKeepSpace, StandardCharsets.UTF_8.toString());
        } catch (Exception unused) {
            strReplace = strO.replace(StringUtils.SPACE, "%20");
        }
        new c(this, ac.c.B(strO, strReplace)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(a aVar) {
        String str;
        if (this.f20708q || aVar == null || (str = aVar.f20710a) == null) {
            return;
        }
        this.f20708q = true;
        this.f20707p.loadUrl(str);
        new Handler().postDelayed(new vb.d(this, 7), 1000L);
    }
}
