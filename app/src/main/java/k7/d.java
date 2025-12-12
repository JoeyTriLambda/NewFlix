package k7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R;

/* compiled from: MaterialBottomContainerBackHelper.java */
/* loaded from: classes.dex */
public final class d extends k7.a<View> {

    /* renamed from: g, reason: collision with root package name */
    public final float f15024g;

    /* renamed from: h, reason: collision with root package name */
    public final float f15025h;

    /* compiled from: MaterialBottomContainerBackHelper.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f15013b.setTranslationY(0.0f);
            dVar.updateBackProgress(0.0f);
        }
    }

    public d(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f15024g = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.f15025h = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    public final AnimatorSet a() {
        AnimatorSet animatorSet = new AnimatorSet();
        V v10 = this.f15013b;
        animatorSet.playTogether(ObjectAnimator.ofFloat(v10, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(v10, (Property<V, Float>) View.SCALE_Y, 1.0f));
        if (v10 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v10;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i10), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new p1.b());
        return animatorSet;
    }

    public void cancelBackProgress() {
        if (super.onCancelBackProgress() == null) {
            return;
        }
        AnimatorSet animatorSetA = a();
        animatorSetA.setDuration(this.f15016e);
        animatorSetA.start();
    }

    public void finishBackProgressNotPersistent(androidx.activity.b bVar, Animator.AnimatorListener animatorListener) {
        V v10 = this.f15013b;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(v10, (Property<V, Float>) View.TRANSLATION_Y, v10.getScaleY() * v10.getHeight());
        objectAnimatorOfFloat.setInterpolator(new p1.b());
        objectAnimatorOfFloat.setDuration(p6.a.lerp(this.f15014c, this.f15015d, bVar.getProgress()));
        objectAnimatorOfFloat.addListener(new a());
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public void finishBackProgressPersistent(androidx.activity.b bVar, Animator.AnimatorListener animatorListener) {
        AnimatorSet animatorSetA = a();
        animatorSetA.setDuration(p6.a.lerp(this.f15014c, this.f15015d, bVar.getProgress()));
        if (animatorListener != null) {
            animatorSetA.addListener(animatorListener);
        }
        animatorSetA.start();
    }

    public void startBackProgress(androidx.activity.b bVar) {
        super.onStartBackProgress(bVar);
    }

    public void updateBackProgress(androidx.activity.b bVar) {
        if (super.onUpdateBackProgress(bVar) == null) {
            return;
        }
        updateBackProgress(bVar.getProgress());
    }

    public void updateBackProgress(float f10) {
        float fInterpolateProgress = interpolateProgress(f10);
        V v10 = this.f15013b;
        float width = v10.getWidth();
        float height = v10.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f11 = this.f15024g / width;
        float f12 = this.f15025h / height;
        float fLerp = 1.0f - p6.a.lerp(0.0f, f11, fInterpolateProgress);
        float fLerp2 = 1.0f - p6.a.lerp(0.0f, f12, fInterpolateProgress);
        v10.setScaleX(fLerp);
        v10.setPivotY(height);
        v10.setScaleY(fLerp2);
        if (v10 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v10;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                View childAt = viewGroup.getChildAt(i10);
                childAt.setPivotY(-childAt.getTop());
                childAt.setScaleY(fLerp2 != 0.0f ? fLerp / fLerp2 : 1.0f);
            }
        }
    }
}
