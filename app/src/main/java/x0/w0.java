package x0;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* compiled from: WindowCompat.java */
/* loaded from: classes.dex */
public final class w0 {

    /* compiled from: WindowCompat.java */
    public static class a {
        public static void a(Window window, boolean z10) {
            window.setDecorFitsSystemWindows(z10);
        }
    }

    public static a1 getInsetsController(Window window, View view) {
        return new a1(window, view);
    }

    public static void setDecorFitsSystemWindows(Window window, boolean z10) {
        if (Build.VERSION.SDK_INT >= 30) {
            a.a(window, z10);
            return;
        }
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z10 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
    }
}
