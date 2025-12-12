package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import androidx.leanback.R;

/* loaded from: classes.dex */
class SlideKitkat extends Visibility {

    /* renamed from: m, reason: collision with root package name */
    public static final DecelerateInterpolator f3020m = new DecelerateInterpolator();

    /* renamed from: n, reason: collision with root package name */
    public static final AccelerateInterpolator f3021n = new AccelerateInterpolator();

    /* renamed from: o, reason: collision with root package name */
    public static final a f3022o = new a();

    /* renamed from: p, reason: collision with root package name */
    public static final b f3023p = new b();

    /* renamed from: q, reason: collision with root package name */
    public static final c f3024q = new c();

    /* renamed from: r, reason: collision with root package name */
    public static final d f3025r = new d();

    /* renamed from: s, reason: collision with root package name */
    public static final e f3026s = new e();

    /* renamed from: t, reason: collision with root package name */
    public static final f f3027t = new f();

    /* renamed from: b, reason: collision with root package name */
    public g f3028b;

    public static class a extends h {
        @Override // androidx.leanback.transition.SlideKitkat.g
        public float getGone(View view) {
            return view.getTranslationX() - view.getWidth();
        }
    }

    public static class b extends i {
        @Override // androidx.leanback.transition.SlideKitkat.g
        public float getGone(View view) {
            return view.getTranslationY() - view.getHeight();
        }
    }

    public static class c extends h {
        @Override // androidx.leanback.transition.SlideKitkat.g
        public float getGone(View view) {
            return view.getTranslationX() + view.getWidth();
        }
    }

    public static class d extends i {
        @Override // androidx.leanback.transition.SlideKitkat.g
        public float getGone(View view) {
            return view.getTranslationY() + view.getHeight();
        }
    }

    public static class e extends h {
        @Override // androidx.leanback.transition.SlideKitkat.g
        public float getGone(View view) {
            return view.getLayoutDirection() == 1 ? view.getTranslationX() + view.getWidth() : view.getTranslationX() - view.getWidth();
        }
    }

    public static class f extends h {
        @Override // androidx.leanback.transition.SlideKitkat.g
        public float getGone(View view) {
            return view.getLayoutDirection() == 1 ? view.getTranslationX() - view.getWidth() : view.getTranslationX() + view.getWidth();
        }
    }

    public interface g {
        float getGone(View view);

        float getHere(View view);

        Property<View, Float> getProperty();
    }

    public static abstract class h implements g {
        @Override // androidx.leanback.transition.SlideKitkat.g
        public float getHere(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.leanback.transition.SlideKitkat.g
        public Property<View, Float> getProperty() {
            return View.TRANSLATION_X;
        }
    }

    public static abstract class i implements g {
        @Override // androidx.leanback.transition.SlideKitkat.g
        public float getHere(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.leanback.transition.SlideKitkat.g
        public Property<View, Float> getProperty() {
            return View.TRANSLATION_Y;
        }
    }

    public static class j extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public boolean f3029b = false;

        /* renamed from: m, reason: collision with root package name */
        public float f3030m;

        /* renamed from: n, reason: collision with root package name */
        public final View f3031n;

        /* renamed from: o, reason: collision with root package name */
        public final float f3032o;

        /* renamed from: p, reason: collision with root package name */
        public final float f3033p;

        /* renamed from: q, reason: collision with root package name */
        public final int f3034q;

        /* renamed from: r, reason: collision with root package name */
        public final Property<View, Float> f3035r;

        public j(View view, Property<View, Float> property, float f10, float f11, int i10) {
            this.f3035r = property;
            this.f3031n = view;
            this.f3033p = f10;
            this.f3032o = f11;
            this.f3034q = i10;
            view.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            View view = this.f3031n;
            view.setTag(R.id.lb_slide_transition_value, new float[]{view.getTranslationX(), view.getTranslationY()});
            this.f3035r.set(view, Float.valueOf(this.f3033p));
            this.f3029b = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            boolean z10 = this.f3029b;
            View view = this.f3031n;
            if (!z10) {
                this.f3035r.set(view, Float.valueOf(this.f3033p));
            }
            view.setVisibility(this.f3034q);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            Property<View, Float> property = this.f3035r;
            View view = this.f3031n;
            this.f3030m = property.get(view).floatValue();
            property.set(view, Float.valueOf(this.f3032o));
            view.setVisibility(this.f3034q);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            Float fValueOf = Float.valueOf(this.f3030m);
            Property<View, Float> property = this.f3035r;
            View view = this.f3031n;
            property.set(view, fValueOf);
            view.setVisibility(0);
        }
    }

    public SlideKitkat() {
        setSlideEdge(80);
    }

    public static ObjectAnimator a(View view, Property property, float f10, float f11, float f12, TimeInterpolator timeInterpolator, int i10) {
        int i11 = R.id.lb_slide_transition_value;
        float[] fArr = (float[]) view.getTag(i11);
        if (fArr != null) {
            f10 = View.TRANSLATION_Y == property ? fArr[1] : fArr[0];
            view.setTag(i11, null);
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, f10, f11);
        j jVar = new j(view, property, f12, f11, i10);
        objectAnimatorOfFloat.addListener(jVar);
        objectAnimatorOfFloat.addPauseListener(jVar);
        objectAnimatorOfFloat.setInterpolator(timeInterpolator);
        return objectAnimatorOfFloat;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i10, TransitionValues transitionValues2, int i11) {
        View view = transitionValues2 != null ? transitionValues2.view : null;
        if (view == null) {
            return null;
        }
        float here = this.f3028b.getHere(view);
        return a(view, this.f3028b.getProperty(), this.f3028b.getGone(view), here, here, f3020m, 0);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i10, TransitionValues transitionValues2, int i11) {
        View view = transitionValues != null ? transitionValues.view : null;
        if (view == null) {
            return null;
        }
        float here = this.f3028b.getHere(view);
        return a(view, this.f3028b.getProperty(), here, this.f3028b.getGone(view), here, f3021n, 4);
    }

    public void setSlideEdge(int i10) {
        if (i10 == 3) {
            this.f3028b = f3022o;
            return;
        }
        if (i10 == 5) {
            this.f3028b = f3024q;
            return;
        }
        if (i10 == 48) {
            this.f3028b = f3023p;
            return;
        }
        if (i10 == 80) {
            this.f3028b = f3025r;
        } else if (i10 == 8388611) {
            this.f3028b = f3026s;
        } else {
            if (i10 != 8388613) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.f3028b = f3027t;
        }
    }

    public SlideKitkat(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbSlide);
        setSlideEdge(typedArrayObtainStyledAttributes.getInt(R.styleable.lbSlide_lb_slideEdge, 80));
        long j10 = typedArrayObtainStyledAttributes.getInt(R.styleable.lbSlide_android_duration, -1);
        if (j10 >= 0) {
            setDuration(j10);
        }
        long j11 = typedArrayObtainStyledAttributes.getInt(R.styleable.lbSlide_android_startDelay, -1);
        if (j11 > 0) {
            setStartDelay(j11);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.lbSlide_android_interpolator, 0);
        if (resourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
