package me.zhanghai.android.materialprogressbar;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;

/* loaded from: classes2.dex */
abstract class IndeterminateProgressDrawableBase extends ProgressDrawableBase implements Animatable {
    protected Animator[] mAnimators;

    public IndeterminateProgressDrawableBase(Context context) {
        super(context);
    }

    private boolean isStarted() {
        for (Animator animator : this.mAnimators) {
            if (animator.isStarted()) {
                return true;
            }
        }
        return false;
    }

    @Override // me.zhanghai.android.materialprogressbar.ProgressDrawableBase, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (isStarted()) {
            invalidateSelf();
        }
    }

    public boolean isRunning() {
        for (Animator animator : this.mAnimators) {
            if (animator.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        if (isStarted()) {
            return;
        }
        for (Animator animator : this.mAnimators) {
            animator.start();
        }
        invalidateSelf();
    }

    public void stop() {
        for (Animator animator : this.mAnimators) {
            animator.end();
        }
    }
}
