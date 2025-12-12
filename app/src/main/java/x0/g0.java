package x0;

import android.text.TextUtils;
import android.view.View;
import x0.j0;

/* compiled from: ViewCompat.java */
/* loaded from: classes.dex */
public final class g0 extends j0.b<CharSequence> {
    public g0(int i10) {
        super(i10, CharSequence.class, 8, 28);
    }

    @Override // x0.j0.b
    public final CharSequence b(View view) {
        return j0.h.b(view);
    }

    @Override // x0.j0.b
    public final void c(Object obj, View view) {
        j0.h.h(view, (CharSequence) obj);
    }

    @Override // x0.j0.b
    public final boolean f(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
