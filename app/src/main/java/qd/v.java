package qd;

import android.content.Context;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import org.adblockplus.libadblockplus.android.webview.AdblockWebView;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: NoxxSeries.java */
/* loaded from: classes2.dex */
public final class v extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f18131f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f18132g;

    /* renamed from: h, reason: collision with root package name */
    public int f18133h;

    /* renamed from: i, reason: collision with root package name */
    public int f18134i;

    /* renamed from: j, reason: collision with root package name */
    public AdblockWebView f18135j;

    /* compiled from: NoxxSeries.java */
    public class a extends WebViewClient {

        /* compiled from: NoxxSeries.java */
        /* renamed from: qd.v$a$a, reason: collision with other inner class name */
        public class C0231a implements ValueCallback<String> {
            public C0231a() {
            }

            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                Element elementById;
                a aVar = a.this;
                v.this.getClass();
                if (str == null || str.length() < 100) {
                    return;
                }
                try {
                    String strUnescapeJava = StringEscapeUtils.unescapeJava(str);
                    if (strUnescapeJava.contains("Checking if the site connection is secure") || strUnescapeJava.contains("Checking your browser before accessing") || (elementById = ch.a.parse(strUnescapeJava).getElementById("serverselector")) == null) {
                        return;
                    }
                    Elements elementsByTag = elementById.getElementsByTag("BUTTON");
                    for (int i10 = 0; i10 < elementsByTag.size(); i10++) {
                        Element element = elementsByTag.get(i10);
                        hd.o oVar = new hd.o();
                        oVar.D = element.attr("value");
                        oVar.F = true;
                        oVar.C = v.this.checkLinkLabel(oVar.D) + " NOXX";
                        v.this.addLink(oVar);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }

        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AdblockWebView adblockWebView = v.this.f18135j;
            if (adblockWebView == null) {
                return;
            }
            adblockWebView.evaluateJavascript("(function(){var el = document.documentElement; var xml = el.innerHTML; return xml;})()", new C0231a());
        }
    }

    public v(Context context, Movie movie, gd.f fVar) {
        this.f18131f = movie;
        this.f18132g = context;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://noxx.to";
    }

    public void process(int i10, int i11) {
        this.f18134i = i10;
        this.f18133h = i11;
        String str = this.f12433d + "/tv/" + this.f18131f.getTitle().replace(",", "").replace("(", "").replace(")", "").replace(":", "").replace("'", "").replace("-", "").replace(StringUtils.SPACE, "-") + "/" + this.f18134i + "/" + this.f18133h;
        AdblockWebView adblockWebView = new AdblockWebView(this.f18132g);
        this.f18135j = adblockWebView;
        adblockWebView.setWebViewClient(new a());
        this.f18135j.getSettings().setAllowContentAccess(true);
        this.f18135j.getSettings().setJavaScriptEnabled(true);
        this.f18135j.loadUrl(str.replace("--", "-"));
    }
}
