package ba;

import android.view.View;
import android.view.ViewGroup;
import la.k;

/* compiled from: SwipeDismissRecyclerViewTouchListener.java */
/* loaded from: classes.dex */
public final class d implements k.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f4825a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f4826b;

    public d(ViewGroup.LayoutParams layoutParams, View view) {
        this.f4825a = layoutParams;
        this.f4826b = view;
    }

    @Override // la.k.g
    public void onAnimationUpdate(k kVar) {
        int iIntValue = ((Integer) kVar.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.f4825a;
        layoutParams.height = iIntValue;
        this.f4826b.setLayoutParams(layoutParams);
    }
}
