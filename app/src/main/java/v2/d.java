package v2;

import android.os.Looper;
import android.webkit.TracingConfig;
import android.webkit.TracingController;
import android.webkit.WebView;
import java.io.OutputStream;
import java.util.concurrent.Executor;

/* compiled from: ApiHelperForP.java */
/* loaded from: classes.dex */
public final class d {
    public static TracingController getTracingControllerInstance() {
        return TracingController.getInstance();
    }

    public static ClassLoader getWebViewClassLoader() {
        return WebView.getWebViewClassLoader();
    }

    public static Looper getWebViewLooper(WebView webView) {
        return webView.getWebViewLooper();
    }

    public static boolean isTracing(TracingController tracingController) {
        return tracingController.isTracing();
    }

    public static void setDataDirectorySuffix(String str) {
        WebView.setDataDirectorySuffix(str);
    }

    public static void start(TracingController tracingController, u2.b bVar) {
        new TracingConfig.Builder();
        throw null;
    }

    public static boolean stop(TracingController tracingController, OutputStream outputStream, Executor executor) {
        return tracingController.stop(outputStream, executor);
    }
}
