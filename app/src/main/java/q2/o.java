package q2;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* compiled from: ViewUtilsApi23.java */
/* loaded from: classes.dex */
public class o extends n {

    /* renamed from: i, reason: collision with root package name */
    public static boolean f17799i = true;

    /* compiled from: ViewUtilsApi23.java */
    public static class a {
        public static void a(View view, int i10) {
            view.setTransitionVisibility(i10);
        }
    }

    @Override // q2.l
    @SuppressLint({"NewApi"})
    public void setTransitionVisibility(View view, int i10) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT == 28) {
            super.setTransitionVisibility(view, i10);
        } else if (f17799i) {
            try {
                a.a(view, i10);
            } catch (NoSuchMethodError unused) {
                f17799i = false;
            }
        }
    }
}
