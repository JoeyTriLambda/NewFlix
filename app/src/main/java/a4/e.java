package a4;

import android.animation.Animator;
import android.os.Build;
import android.view.Choreographer;
import java.util.Iterator;

/* compiled from: LottieValueAnimator.java */
/* loaded from: classes.dex */
public final class e extends a implements Choreographer.FrameCallback {

    /* renamed from: u, reason: collision with root package name */
    public p3.d f320u;

    /* renamed from: n, reason: collision with root package name */
    public float f313n = 1.0f;

    /* renamed from: o, reason: collision with root package name */
    public boolean f314o = false;

    /* renamed from: p, reason: collision with root package name */
    public long f315p = 0;

    /* renamed from: q, reason: collision with root package name */
    public float f316q = 0.0f;

    /* renamed from: r, reason: collision with root package name */
    public int f317r = 0;

    /* renamed from: s, reason: collision with root package name */
    public float f318s = -2.1474836E9f;

    /* renamed from: t, reason: collision with root package name */
    public float f319t = 2.1474836E9f;

    /* renamed from: v, reason: collision with root package name */
    public boolean f321v = false;

    public final boolean c() {
        return getSpeed() < 0.0f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        Iterator it = this.f310m.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
        }
        removeFrameCallback();
    }

    public void clearComposition() {
        this.f320u = null;
        this.f318s = -2.1474836E9f;
        this.f319t = 2.1474836E9f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j10) {
        postFrameCallback();
        if (this.f320u == null || !isRunning()) {
            return;
        }
        p3.c.beginSection("LottieValueAnimator#doFrame");
        long j11 = this.f315p;
        long j12 = j11 != 0 ? j10 - j11 : 0L;
        p3.d dVar = this.f320u;
        float frameRate = j12 / (dVar == null ? Float.MAX_VALUE : (1.0E9f / dVar.getFrameRate()) / Math.abs(this.f313n));
        float f10 = this.f316q;
        if (c()) {
            frameRate = -frameRate;
        }
        float f11 = f10 + frameRate;
        this.f316q = f11;
        boolean z10 = !g.contains(f11, getMinFrame(), getMaxFrame());
        this.f316q = g.clamp(this.f316q, getMinFrame(), getMaxFrame());
        this.f315p = j10;
        b();
        if (z10) {
            if (getRepeatCount() == -1 || this.f317r < getRepeatCount()) {
                Iterator it = this.f310m.iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationRepeat(this);
                }
                this.f317r++;
                if (getRepeatMode() == 2) {
                    this.f314o = !this.f314o;
                    reverseAnimationSpeed();
                } else {
                    this.f316q = c() ? getMaxFrame() : getMinFrame();
                }
                this.f315p = j10;
            } else {
                this.f316q = this.f313n < 0.0f ? getMinFrame() : getMaxFrame();
                removeFrameCallback();
                a(c());
            }
        }
        if (this.f320u != null) {
            float f12 = this.f316q;
            if (f12 < this.f318s || f12 > this.f319t) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f318s), Float.valueOf(this.f319t), Float.valueOf(this.f316q)));
            }
        }
        p3.c.endSection("LottieValueAnimator#doFrame");
    }

    public void endAnimation() {
        removeFrameCallback();
        a(c());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float minFrame;
        float maxFrame;
        float minFrame2;
        if (this.f320u == null) {
            return 0.0f;
        }
        if (c()) {
            minFrame = getMaxFrame() - this.f316q;
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        } else {
            minFrame = this.f316q - getMinFrame();
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        }
        return minFrame / (maxFrame - minFrame2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    public float getAnimatedValueAbsolute() {
        p3.d dVar = this.f320u;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.f316q - dVar.getStartFrame()) / (this.f320u.getEndFrame() - this.f320u.getStartFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        p3.d dVar = this.f320u;
        if (dVar == null) {
            return 0L;
        }
        return (long) dVar.getDuration();
    }

    public float getFrame() {
        return this.f316q;
    }

    public float getMaxFrame() {
        p3.d dVar = this.f320u;
        if (dVar == null) {
            return 0.0f;
        }
        float f10 = this.f319t;
        return f10 == 2.1474836E9f ? dVar.getEndFrame() : f10;
    }

    public float getMinFrame() {
        p3.d dVar = this.f320u;
        if (dVar == null) {
            return 0.0f;
        }
        float f10 = this.f318s;
        return f10 == -2.1474836E9f ? dVar.getStartFrame() : f10;
    }

    public float getSpeed() {
        return this.f313n;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f321v;
    }

    public void pauseAnimation() {
        removeFrameCallback();
    }

    public void playAnimation() {
        this.f321v = true;
        boolean zC = c();
        Iterator it = this.f310m.iterator();
        while (it.hasNext()) {
            Animator.AnimatorListener animatorListener = (Animator.AnimatorListener) it.next();
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, zC);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
        setFrame((int) (c() ? getMaxFrame() : getMinFrame()));
        this.f315p = 0L;
        this.f317r = 0;
        postFrameCallback();
    }

    public void postFrameCallback() {
        if (isRunning()) {
            removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void removeFrameCallback() {
        removeFrameCallback(true);
    }

    public void resumeAnimation() {
        this.f321v = true;
        postFrameCallback();
        this.f315p = 0L;
        if (c() && getFrame() == getMinFrame()) {
            this.f316q = getMaxFrame();
        } else {
            if (c() || getFrame() != getMaxFrame()) {
                return;
            }
            this.f316q = getMinFrame();
        }
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setComposition(p3.d dVar) {
        boolean z10 = this.f320u == null;
        this.f320u = dVar;
        if (z10) {
            setMinAndMaxFrames((int) Math.max(this.f318s, dVar.getStartFrame()), (int) Math.min(this.f319t, dVar.getEndFrame()));
        } else {
            setMinAndMaxFrames((int) dVar.getStartFrame(), (int) dVar.getEndFrame());
        }
        float f10 = this.f316q;
        this.f316q = 0.0f;
        setFrame((int) f10);
        b();
    }

    public void setFrame(float f10) {
        if (this.f316q == f10) {
            return;
        }
        this.f316q = g.clamp(f10, getMinFrame(), getMaxFrame());
        this.f315p = 0L;
        b();
    }

    public void setMaxFrame(float f10) {
        setMinAndMaxFrames(this.f318s, f10);
    }

    public void setMinAndMaxFrames(float f10, float f11) {
        if (f10 > f11) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f10), Float.valueOf(f11)));
        }
        p3.d dVar = this.f320u;
        float startFrame = dVar == null ? -3.4028235E38f : dVar.getStartFrame();
        p3.d dVar2 = this.f320u;
        float endFrame = dVar2 == null ? Float.MAX_VALUE : dVar2.getEndFrame();
        this.f318s = g.clamp(f10, startFrame, endFrame);
        this.f319t = g.clamp(f11, startFrame, endFrame);
        setFrame((int) g.clamp(this.f316q, f10, f11));
    }

    public void setMinFrame(int i10) {
        setMinAndMaxFrames(i10, (int) this.f319t);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i10) {
        super.setRepeatMode(i10);
        if (i10 == 2 || !this.f314o) {
            return;
        }
        this.f314o = false;
        reverseAnimationSpeed();
    }

    public void setSpeed(float f10) {
        this.f313n = f10;
    }

    public void removeFrameCallback(boolean z10) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z10) {
            this.f321v = false;
        }
    }
}
