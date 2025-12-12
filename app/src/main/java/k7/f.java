package k7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R;
import x0.h;
import x0.j0;

/* compiled from: MaterialSideContainerBackHelper.java */
/* loaded from: classes.dex */
public final class f extends k7.a<View> {

    /* renamed from: g, reason: collision with root package name */
    public final float f15027g;

    /* renamed from: h, reason: collision with root package name */
    public final float f15028h;

    /* renamed from: i, reason: collision with root package name */
    public final float f15029i;

    /* compiled from: MaterialSideContainerBackHelper.java */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f15030b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f15031m;

        public a(boolean z10, int i10) {
            this.f15030b = z10;
            this.f15031m = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f fVar = f.this;
            fVar.f15013b.setTranslationX(0.0f);
            fVar.updateBackProgress(0.0f, this.f15030b, this.f15031m);
        }
    }

    public f(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f15027g = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.f15028h = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.f15029i = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    public void cancelBackProgress() {
        if (super.onCancelBackProgress() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        V v10 = this.f15013b;
        animatorSet.playTogether(ObjectAnimator.ofFloat(v10, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(v10, (Property<V, Float>) View.SCALE_Y, 1.0f));
        if (v10 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v10;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i10), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.f15016e);
        animatorSet.start();
    }

    public void finishBackProgress(androidx.activity.b bVar, int i10, Animator.AnimatorListener animatorListener, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        int i11;
        boolean z10 = bVar.getSwipeEdge() == 0;
        V v10 = this.f15013b;
        boolean z11 = (h.getAbsoluteGravity(i10, j0.getLayoutDirection(v10)) & 3) == 3;
        float scaleX = v10.getScaleX() * v10.getWidth();
        ViewGroup.LayoutParams layoutParams = v10.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i11 = z11 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
        } else {
            i11 = 0;
        }
        float f10 = scaleX + i11;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (z11) {
            f10 = -f10;
        }
        fArr[0] = f10;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(v10, (Property<V, Float>) property, fArr);
        if (animatorUpdateListener != null) {
            objectAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
        }
        objectAnimatorOfFloat.setInterpolator(new p1.b());
        objectAnimatorOfFloat.setDuration(p6.a.lerp(this.f15014c, this.f15015d, bVar.getProgress()));
        objectAnimatorOfFloat.addListener(new a(z10, i10));
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public void startBackProgress(androidx.activity.b bVar) {
        super.onStartBackProgress(bVar);
    }

    public void updateBackProgress(androidx.activity.b bVar, int i10) {
        if (super.onUpdateBackProgress(bVar) == null) {
            return;
        }
        updateBackProgress(bVar.getProgress(), bVar.getSwipeEdge() == 0, i10);
    }

    public void updateBackProgress(float f10, boolean z10, int i10) {
        float fInterpolateProgress = interpolateProgress(f10);
        V v10 = this.f15013b;
        boolean z11 = (h.getAbsoluteGravity(i10, j0.getLayoutDirection(v10)) & 3) == 3;
        boolean z12 = z10 == z11;
        int width = v10.getWidth();
        int height = v10.getHeight();
        float f11 = width;
        if (f11 > 0.0f) {
            float f12 = height;
            if (f12 <= 0.0f) {
                return;
            }
            float f13 = this.f15027g / f11;
            float f14 = this.f15028h / f11;
            float f15 = this.f15029i / f12;
            if (z11) {
                f11 = 0.0f;
            }
            v10.setPivotX(f11);
            if (!z12) {
                f14 = -f13;
            }
            float fLerp = p6.a.lerp(0.0f, f14, fInterpolateProgress);
            float f16 = fLerp + 1.0f;
            v10.setScaleX(f16);
            float fLerp2 = 1.0f - p6.a.lerp(0.0f, f15, fInterpolateProgress);
            v10.setScaleY(fLerp2);
            if (v10 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v10;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    childAt.setPivotX(z11 ? childAt.getWidth() + (width - childAt.getRight()) : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f17 = z12 ? 1.0f - fLerp : 1.0f;
                    float f18 = fLerp2 != 0.0f ? (f16 / fLerp2) * f17 : 1.0f;
                    childAt.setScaleX(f17);
                    childAt.setScaleY(f18);
                }
            }
        }
    }
}
