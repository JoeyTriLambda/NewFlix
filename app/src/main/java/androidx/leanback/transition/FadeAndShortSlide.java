package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.leanback.R;

/* loaded from: classes.dex */
public class FadeAndShortSlide extends Visibility {

    /* renamed from: p, reason: collision with root package name */
    public static final DecelerateInterpolator f3008p = new DecelerateInterpolator();

    /* renamed from: q, reason: collision with root package name */
    public static final a f3009q = new a();

    /* renamed from: r, reason: collision with root package name */
    public static final b f3010r = new b();

    /* renamed from: s, reason: collision with root package name */
    public static final c f3011s = new c();

    /* renamed from: t, reason: collision with root package name */
    public static final d f3012t = new d();

    /* renamed from: u, reason: collision with root package name */
    public static final e f3013u = new e();

    /* renamed from: b, reason: collision with root package name */
    public g f3014b;

    /* renamed from: m, reason: collision with root package name */
    public Visibility f3015m;

    /* renamed from: n, reason: collision with root package name */
    public final float f3016n;

    /* renamed from: o, reason: collision with root package name */
    public final f f3017o;

    public static class a extends g {
        @Override // androidx.leanback.transition.FadeAndShortSlide.g
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            if (viewGroup.getLayoutDirection() == 1) {
                return fadeAndShortSlide.a(viewGroup) + view.getTranslationX();
            }
            return view.getTranslationX() - fadeAndShortSlide.a(viewGroup);
        }
    }

    public static class b extends g {
        @Override // androidx.leanback.transition.FadeAndShortSlide.g
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return viewGroup.getLayoutDirection() == 1 ? view.getTranslationX() - fadeAndShortSlide.a(viewGroup) : view.getTranslationX() + fadeAndShortSlide.a(viewGroup);
        }
    }

    public static class c extends g {
        @Override // androidx.leanback.transition.FadeAndShortSlide.g
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            int iCenterX;
            int width = (view.getWidth() / 2) + iArr[0];
            viewGroup.getLocationOnScreen(iArr);
            Rect epicenter = fadeAndShortSlide.getEpicenter();
            if (epicenter == null) {
                iCenterX = (viewGroup.getWidth() / 2) + iArr[0];
            } else {
                iCenterX = epicenter.centerX();
            }
            if (width < iCenterX) {
                return view.getTranslationX() - fadeAndShortSlide.a(viewGroup);
            }
            return fadeAndShortSlide.a(viewGroup) + view.getTranslationX();
        }
    }

    public static class d extends g {
        @Override // androidx.leanback.transition.FadeAndShortSlide.g
        public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return fadeAndShortSlide.b(viewGroup) + view.getTranslationY();
        }
    }

    public static class e extends g {
        @Override // androidx.leanback.transition.FadeAndShortSlide.g
        public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationY() - fadeAndShortSlide.b(viewGroup);
        }
    }

    public class f extends g {
        public f() {
        }

        @Override // androidx.leanback.transition.FadeAndShortSlide.g
        public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            int iCenterY;
            int height = (view.getHeight() / 2) + iArr[1];
            viewGroup.getLocationOnScreen(iArr);
            Rect epicenter = FadeAndShortSlide.this.getEpicenter();
            if (epicenter == null) {
                iCenterY = (viewGroup.getHeight() / 2) + iArr[1];
            } else {
                iCenterY = epicenter.centerY();
            }
            if (height < iCenterY) {
                return view.getTranslationY() - fadeAndShortSlide.b(viewGroup);
            }
            return fadeAndShortSlide.b(viewGroup) + view.getTranslationY();
        }
    }

    public static abstract class g {
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationX();
        }

        public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationY();
        }
    }

    public FadeAndShortSlide() {
        this(8388611);
    }

    public final float a(ViewGroup viewGroup) {
        float f10 = this.f3016n;
        return f10 >= 0.0f ? f10 : viewGroup.getWidth() / 4;
    }

    @Override // android.transition.Transition
    public Transition addListener(Transition.TransitionListener transitionListener) {
        this.f3015m.addListener(transitionListener);
        return super.addListener(transitionListener);
    }

    public final float b(ViewGroup viewGroup) {
        float f10 = this.f3016n;
        return f10 >= 0.0f ? f10 : viewGroup.getHeight() / 4;
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        this.f3015m.captureEndValues(transitionValues);
        super.captureEndValues(transitionValues);
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put("android:fadeAndShortSlideTransition:screenPosition", iArr);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        this.f3015m.captureStartValues(transitionValues);
        super.captureStartValues(transitionValues);
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put("android:fadeAndShortSlideTransition:screenPosition", iArr);
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.values.get("android:fadeAndShortSlideTransition:screenPosition");
        int i10 = iArr[0];
        int i11 = iArr[1];
        float translationX = view.getTranslationX();
        ObjectAnimator objectAnimatorA = androidx.leanback.transition.c.a(view, transitionValues2, i10, i11, this.f3014b.getGoneX(this, viewGroup, view, iArr), this.f3014b.getGoneY(this, viewGroup, view, iArr), translationX, view.getTranslationY(), f3008p, this);
        Animator animatorOnAppear = this.f3015m.onAppear(viewGroup, view, transitionValues, transitionValues2);
        if (objectAnimatorA == null) {
            return animatorOnAppear;
        }
        if (animatorOnAppear == null) {
            return objectAnimatorA;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorA).with(animatorOnAppear);
        return animatorSet;
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.values.get("android:fadeAndShortSlideTransition:screenPosition");
        ObjectAnimator objectAnimatorA = androidx.leanback.transition.c.a(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f3014b.getGoneX(this, viewGroup, view, iArr), this.f3014b.getGoneY(this, viewGroup, view, iArr), f3008p, this);
        Animator animatorOnDisappear = this.f3015m.onDisappear(viewGroup, view, transitionValues, transitionValues2);
        if (objectAnimatorA == null) {
            return animatorOnDisappear;
        }
        if (animatorOnDisappear == null) {
            return objectAnimatorA;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorA).with(animatorOnDisappear);
        return animatorSet;
    }

    @Override // android.transition.Transition
    public Transition removeListener(Transition.TransitionListener transitionListener) {
        this.f3015m.removeListener(transitionListener);
        return super.removeListener(transitionListener);
    }

    @Override // android.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        this.f3015m.setEpicenterCallback(epicenterCallback);
        super.setEpicenterCallback(epicenterCallback);
    }

    public void setSlideEdge(int i10) {
        if (i10 == 48) {
            this.f3014b = f3013u;
            return;
        }
        if (i10 == 80) {
            this.f3014b = f3012t;
            return;
        }
        if (i10 == 112) {
            this.f3014b = this.f3017o;
            return;
        }
        if (i10 == 8388611) {
            this.f3014b = f3009q;
        } else if (i10 == 8388613) {
            this.f3014b = f3010r;
        } else {
            if (i10 != 8388615) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.f3014b = f3011s;
        }
    }

    public FadeAndShortSlide(int i10) {
        this.f3015m = new Fade();
        this.f3016n = -1.0f;
        this.f3017o = new f();
        setSlideEdge(i10);
    }

    @Override // android.transition.Transition
    public Transition clone() {
        FadeAndShortSlide fadeAndShortSlide = (FadeAndShortSlide) super.clone();
        fadeAndShortSlide.f3015m = (Visibility) this.f3015m.clone();
        return fadeAndShortSlide;
    }

    public FadeAndShortSlide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3015m = new Fade();
        this.f3016n = -1.0f;
        this.f3017o = new f();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbSlide);
        setSlideEdge(typedArrayObtainStyledAttributes.getInt(R.styleable.lbSlide_lb_slideEdge, 8388611));
        typedArrayObtainStyledAttributes.recycle();
    }
}
