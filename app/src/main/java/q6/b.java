package q6;

import android.animation.ValueAnimator;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* compiled from: CollapsingToolbarLayout.java */
/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CollapsingToolbarLayout f17901b;

    public b(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.f17901b = collapsingToolbarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f17901b.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
