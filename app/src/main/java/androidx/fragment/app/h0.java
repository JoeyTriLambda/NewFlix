package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public static final i0 f2837a = new i0();

    /* renamed from: b, reason: collision with root package name */
    public static final k0 f2838b;

    static {
        k0 k0Var;
        try {
            k0Var = (k0) androidx.transition.c.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            k0Var = null;
        }
        f2838b = k0Var;
    }

    public static void a(int i10, ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i10);
        }
    }
}
