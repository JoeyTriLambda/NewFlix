package t6;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import q7.g;

/* compiled from: BottomSheetBehavior.java */
/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f19459b;

    public a(BottomSheetBehavior bottomSheetBehavior) {
        this.f19459b = bottomSheetBehavior;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        g gVar = this.f19459b.f8860t;
        if (gVar != null) {
            gVar.setInterpolation(fFloatValue);
        }
    }
}
