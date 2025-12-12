package x0;

import android.view.View;
import x0.j0;

/* compiled from: ViewCompat.java */
/* loaded from: classes.dex */
public final class f0 extends j0.b<Boolean> {
    public f0(int i10) {
        super(i10, Boolean.class, 0, 28);
    }

    @Override // x0.j0.b
    public final Boolean b(View view) {
        return Boolean.valueOf(j0.h.d(view));
    }

    @Override // x0.j0.b
    public final void c(Object obj, View view) {
        j0.h.i(view, ((Boolean) obj).booleanValue());
    }

    @Override // x0.j0.b
    public final boolean f(Boolean bool, Boolean bool2) {
        return !j0.b.a(bool, bool2);
    }
}
