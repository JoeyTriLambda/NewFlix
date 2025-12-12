package x0;

import android.view.ViewGroup;

/* compiled from: ViewGroupCompat.java */
/* loaded from: classes.dex */
public final class n0 {

    /* compiled from: ViewGroupCompat.java */
    public static class a {
        public static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        public static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        public static void c(ViewGroup viewGroup, boolean z10) {
            viewGroup.setTransitionGroup(z10);
        }
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        return a.b(viewGroup);
    }
}
