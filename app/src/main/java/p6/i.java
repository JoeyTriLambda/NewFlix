package p6;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import org.apache.commons.lang3.StringUtils;

/* compiled from: MotionTiming.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final long f17618a;

    /* renamed from: b, reason: collision with root package name */
    public final long f17619b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeInterpolator f17620c;

    /* renamed from: d, reason: collision with root package name */
    public int f17621d;

    /* renamed from: e, reason: collision with root package name */
    public int f17622e;

    public i(long j10, long j11) {
        this.f17618a = 0L;
        this.f17619b = 300L;
        this.f17620c = null;
        this.f17621d = 0;
        this.f17622e = 1;
        this.f17618a = j10;
        this.f17619b = j11;
    }

    public void apply(Animator animator) {
        animator.setStartDelay(getDelay());
        animator.setDuration(getDuration());
        animator.setInterpolator(getInterpolator());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(getRepeatCount());
            valueAnimator.setRepeatMode(getRepeatMode());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (getDelay() == iVar.getDelay() && getDuration() == iVar.getDuration() && getRepeatCount() == iVar.getRepeatCount() && getRepeatMode() == iVar.getRepeatMode()) {
            return getInterpolator().getClass().equals(iVar.getInterpolator().getClass());
        }
        return false;
    }

    public long getDelay() {
        return this.f17618a;
    }

    public long getDuration() {
        return this.f17619b;
    }

    public TimeInterpolator getInterpolator() {
        TimeInterpolator timeInterpolator = this.f17620c;
        return timeInterpolator != null ? timeInterpolator : a.f17605b;
    }

    public int getRepeatCount() {
        return this.f17621d;
    }

    public int getRepeatMode() {
        return this.f17622e;
    }

    public int hashCode() {
        return getRepeatMode() + ((getRepeatCount() + ((getInterpolator().getClass().hashCode() + (((((int) (getDelay() ^ (getDelay() >>> 32))) * 31) + ((int) (getDuration() ^ (getDuration() >>> 32)))) * 31)) * 31)) * 31);
    }

    public String toString() {
        return StringUtils.LF + i.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + getDelay() + " duration: " + getDuration() + " interpolator: " + getInterpolator().getClass() + " repeatCount: " + getRepeatCount() + " repeatMode: " + getRepeatMode() + "}\n";
    }

    public i(long j10, long j11, TimeInterpolator timeInterpolator) {
        this.f17618a = 0L;
        this.f17619b = 300L;
        this.f17620c = null;
        this.f17621d = 0;
        this.f17622e = 1;
        this.f17618a = j10;
        this.f17619b = j11;
        this.f17620c = timeInterpolator;
    }
}
