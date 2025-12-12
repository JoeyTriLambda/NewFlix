package com.google.android.material.behavior;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.e;
import x0.j0;
import y0.g;

/* compiled from: SwipeDismissBehavior.java */
/* loaded from: classes.dex */
public final class a implements g {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f8807b;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.f8807b = swipeDismissBehavior;
    }

    @Override // y0.g
    public boolean perform(View view, g.a aVar) {
        SwipeDismissBehavior swipeDismissBehavior = this.f8807b;
        boolean z10 = false;
        if (!swipeDismissBehavior.canSwipeDismissView(view)) {
            return false;
        }
        boolean z11 = j0.getLayoutDirection(view) == 1;
        int i10 = swipeDismissBehavior.f8796p;
        if ((i10 == 0 && z11) || (i10 == 1 && !z11)) {
            z10 = true;
        }
        int width = view.getWidth();
        if (z10) {
            width = -width;
        }
        j0.offsetLeftAndRight(view, width);
        view.setAlpha(0.0f);
        SwipeDismissBehavior.b bVar = swipeDismissBehavior.f8793m;
        if (bVar != null) {
            ((e) bVar).onDismiss(view);
        }
        return true;
    }
}
