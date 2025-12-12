package q7;

import android.view.View;

/* compiled from: ShapeableDelegateV14.java */
/* loaded from: classes.dex */
public final class r extends q {
    @Override // q7.q
    public final void a(View view) {
        if (this.f18033c == null || this.f18034d.isEmpty()) {
            return;
        }
        view.invalidate();
    }

    @Override // q7.q
    public final boolean b() {
        return true;
    }
}
