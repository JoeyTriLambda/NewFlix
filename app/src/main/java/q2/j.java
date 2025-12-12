package q2;

import android.os.Build;
import android.view.ViewGroup;

/* compiled from: ViewGroupUtils.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f17788a = true;

    /* compiled from: ViewGroupUtils.java */
    public static class a {
        public static int a(ViewGroup viewGroup, int i10) {
            return viewGroup.getChildDrawingOrder(i10);
        }

        public static void b(ViewGroup viewGroup, boolean z10) {
            viewGroup.suppressLayout(z10);
        }
    }

    public static void a(ViewGroup viewGroup, boolean z10) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.b(viewGroup, z10);
        } else if (f17788a) {
            try {
                a.b(viewGroup, z10);
            } catch (NoSuchMethodError unused) {
                f17788a = false;
            }
        }
    }
}
