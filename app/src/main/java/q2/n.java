package q2;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: ViewUtilsApi22.java */
/* loaded from: classes.dex */
public class n extends m {

    /* renamed from: h, reason: collision with root package name */
    public static boolean f17798h = true;

    /* compiled from: ViewUtilsApi22.java */
    public static class a {
        public static void a(View view, int i10, int i11, int i12, int i13) {
            view.setLeftTopRightBottom(i10, i11, i12, i13);
        }
    }

    @Override // q2.l
    @SuppressLint({"NewApi"})
    public void setLeftTopRightBottom(View view, int i10, int i11, int i12, int i13) {
        if (f17798h) {
            try {
                a.a(view, i10, i11, i12, i13);
            } catch (NoSuchMethodError unused) {
                f17798h = false;
            }
        }
    }
}
