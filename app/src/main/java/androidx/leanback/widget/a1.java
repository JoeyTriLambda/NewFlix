package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class a1 {
    public static boolean isDescendant(ViewGroup viewGroup, View view) {
        while (view != null) {
            if (view == viewGroup) {
                return true;
            }
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return false;
            }
            view = (View) parent;
        }
        return false;
    }
}
