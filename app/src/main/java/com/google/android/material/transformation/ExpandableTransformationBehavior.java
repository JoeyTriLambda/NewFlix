package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: m, reason: collision with root package name */
    public AnimatorSet f9515m;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.f9515m = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    public abstract AnimatorSet onCreateExpandedStateChangeAnimation(View view, View view2, boolean z10, boolean z11);

    @Override // com.google.android.material.transformation.ExpandableBehavior
    public boolean onExpandedStateChange(View view, View view2, boolean z10, boolean z11) {
        AnimatorSet animatorSet = this.f9515m;
        boolean z12 = animatorSet != null;
        if (z12) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSetOnCreateExpandedStateChangeAnimation = onCreateExpandedStateChangeAnimation(view, view2, z10, z12);
        this.f9515m = animatorSetOnCreateExpandedStateChangeAnimation;
        animatorSetOnCreateExpandedStateChangeAnimation.addListener(new a());
        this.f9515m.start();
        if (!z11) {
            this.f9515m.end();
        }
        return true;
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
