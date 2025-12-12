package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.leanback.R;
import androidx.leanback.widget.c0;

/* loaded from: classes.dex */
public class ParallaxTransition extends Visibility {

    /* renamed from: b, reason: collision with root package name */
    public static final LinearInterpolator f3019b = new LinearInterpolator();

    public ParallaxTransition() {
    }

    public static ValueAnimator a(View view) {
        c0 c0Var = (c0) view.getTag(R.id.lb_parallax_source);
        if (c0Var == null) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(f3019b);
        valueAnimatorOfFloat.addUpdateListener(new a(c0Var));
        return valueAnimatorOfFloat;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        return a(view);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        return a(view);
    }

    public ParallaxTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
