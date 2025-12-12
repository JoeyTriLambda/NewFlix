package u2;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import v2.l;
import v2.m;
import v2.n;

/* compiled from: WebViewCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* compiled from: WebViewCompat.java */
    public interface a {
    }

    static {
        Uri.parse("*");
        Uri.parse("");
    }

    @SuppressLint({"PrivateApi"})
    public static PackageInfo a() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0]);
    }

    public static void addWebMessageListener(WebView webView, String str, Set<String> set, a aVar) {
        if (!l.f20440b.isSupportedByWebView()) {
            throw l.getUnsupportedOperationException();
        }
        new n(m.getFactory().createWebView(webView)).addWebMessageListener(str, (String[]) set.toArray(new String[0]), aVar);
    }

    public static PackageInfo getCurrentLoadedWebViewPackage() {
        if (Build.VERSION.SDK_INT >= 26) {
            return v2.c.getCurrentWebViewPackage();
        }
        try {
            return a();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
