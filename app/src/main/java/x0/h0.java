package x0;

import android.text.TextUtils;
import android.view.View;
import x0.j0;

/* compiled from: ViewCompat.java */
/* loaded from: classes.dex */
public final class h0 extends j0.b<CharSequence> {
    public h0(int i10) {
        super(i10, CharSequence.class, 64, 30);
    }

    @Override // x0.j0.b
    public final CharSequence b(View view) {
        return j0.j.b(view);
    }

    @Override // x0.j0.b
    public final void c(Object obj, View view) {
        j0.j.e(view, (CharSequence) obj);
    }

    @Override // x0.j0.b
    public final boolean f(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
