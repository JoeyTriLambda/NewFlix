package androidx.lifecycle;

import u1.a;

/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public final class c0 {
    public static final u1.a defaultCreationExtras(e0 e0Var) {
        zf.i.checkNotNullParameter(e0Var, "owner");
        return e0Var instanceof f ? ((f) e0Var).getDefaultViewModelCreationExtras() : a.C0283a.f19972b;
    }
}
