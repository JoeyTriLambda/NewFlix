package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.s;

/* compiled from: ItemBridgeAdapterShadowOverlayWrapper.java */
/* loaded from: classes.dex */
public final class t extends s.e {

    /* renamed from: a, reason: collision with root package name */
    public final r0 f3371a;

    public t(r0 r0Var) {
        this.f3371a = r0Var;
    }

    @Override // androidx.leanback.widget.s.e
    public View createWrapper(View view) {
        return this.f3371a.createShadowOverlayContainer(view.getContext());
    }

    @Override // androidx.leanback.widget.s.e
    public void wrap(View view, View view2) {
        ((q0) view).wrap(view2);
    }
}
