package j4;

import android.animation.Animator;
import android.animation.ValueAnimator;
import l4.f;

/* compiled from: AnimationUtils.java */
/* loaded from: classes.dex */
public final class a {
    public static boolean isRunning(f... fVarArr) {
        for (f fVar : fVarArr) {
            if (fVar.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isStarted(ValueAnimator valueAnimator) {
        return valueAnimator != null && valueAnimator.isStarted();
    }

    public static void start(Animator animator) {
        if (animator == null || animator.isStarted()) {
            return;
        }
        animator.start();
    }

    public static void stop(f... fVarArr) {
        for (f fVar : fVarArr) {
            fVar.stop();
        }
    }

    public static boolean isRunning(ValueAnimator valueAnimator) {
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public static void start(f... fVarArr) {
        for (f fVar : fVarArr) {
            fVar.start();
        }
    }
}
