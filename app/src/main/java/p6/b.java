package p6;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.List;

/* compiled from: AnimatorSetCompat.java */
/* loaded from: classes.dex */
public final class b {
    public static void playTogether(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long jMax = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Animator animator = list.get(i10);
            jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt.setDuration(jMax);
        list.add(0, valueAnimatorOfInt);
        animatorSet.playTogether(list);
    }
}
