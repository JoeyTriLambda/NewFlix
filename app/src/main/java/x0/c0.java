package x0;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: VelocityTrackerCompat.java */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<VelocityTracker, d0> f21247a = Collections.synchronizedMap(new WeakHashMap());

    /* compiled from: VelocityTrackerCompat.java */
    public static class a {
        public static float a(VelocityTracker velocityTracker, int i10) {
            return velocityTracker.getAxisVelocity(i10);
        }

        public static float b(VelocityTracker velocityTracker, int i10, int i11) {
            return velocityTracker.getAxisVelocity(i10, i11);
        }

        public static boolean c(VelocityTracker velocityTracker, int i10) {
            return velocityTracker.isAxisSupported(i10);
        }
    }

    public static void addMovement(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            Map<VelocityTracker, d0> map = f21247a;
            if (!map.containsKey(velocityTracker)) {
                map.put(velocityTracker, new d0());
            }
            d0 d0Var = map.get(velocityTracker);
            d0Var.getClass();
            long eventTime = motionEvent.getEventTime();
            int i10 = d0Var.f21261d;
            long[] jArr = d0Var.f21259b;
            if (i10 != 0 && eventTime - jArr[d0Var.f21262e] > 40) {
                d0Var.f21261d = 0;
                d0Var.f21260c = 0.0f;
            }
            int i11 = (d0Var.f21262e + 1) % 20;
            d0Var.f21262e = i11;
            int i12 = d0Var.f21261d;
            if (i12 != 20) {
                d0Var.f21261d = i12 + 1;
            }
            d0Var.f21258a[i11] = motionEvent.getAxisValue(26);
            jArr[d0Var.f21262e] = eventTime;
        }
    }

    public static void computeCurrentVelocity(VelocityTracker velocityTracker, int i10, float f10) {
        long j10;
        int i11;
        velocityTracker.computeCurrentVelocity(i10, f10);
        d0 d0Var = f21247a.get(velocityTracker);
        if (d0Var != null) {
            int i12 = d0Var.f21261d;
            float fSqrt = 0.0f;
            if (i12 >= 2) {
                int i13 = d0Var.f21262e;
                int i14 = ((i13 + 20) - (i12 - 1)) % 20;
                long[] jArr = d0Var.f21259b;
                long j11 = jArr[i13];
                while (true) {
                    j10 = jArr[i14];
                    if (j11 - j10 <= 100) {
                        break;
                    }
                    d0Var.f21261d--;
                    i14 = (i14 + 1) % 20;
                }
                int i15 = d0Var.f21261d;
                if (i15 >= 2) {
                    float[] fArr = d0Var.f21258a;
                    if (i15 == 2) {
                        int i16 = (i14 + 1) % 20;
                        if (j10 != jArr[i16]) {
                            fSqrt = fArr[i16] / (r3 - j10);
                        }
                    } else {
                        int i17 = 0;
                        int i18 = 0;
                        float f11 = 0.0f;
                        while (true) {
                            if (i17 >= d0Var.f21261d - 1) {
                                break;
                            }
                            int i19 = i17 + i14;
                            long j12 = jArr[i19 % 20];
                            int i20 = (i19 + 1) % 20;
                            if (jArr[i20] == j12) {
                                i11 = i17;
                            } else {
                                i18++;
                                i11 = i17;
                                float fSqrt2 = (f11 >= fSqrt ? 1.0f : -1.0f) * ((float) Math.sqrt(Math.abs(f11) * 2.0f));
                                float f12 = fArr[i20] / (jArr[i20] - j12);
                                float fAbs = (Math.abs(f12) * (f12 - fSqrt2)) + f11;
                                if (i18 == 1) {
                                    fAbs *= 0.5f;
                                }
                                f11 = fAbs;
                            }
                            i17 = i11 + 1;
                            fSqrt = 0.0f;
                        }
                        fSqrt = (f11 >= 0.0f ? 1.0f : -1.0f) * ((float) Math.sqrt(Math.abs(f11) * 2.0f));
                    }
                }
            }
            float f13 = fSqrt * i10;
            d0Var.f21260c = f13;
            if (f13 < (-Math.abs(f10))) {
                d0Var.f21260c = -Math.abs(f10);
            } else if (d0Var.f21260c > Math.abs(f10)) {
                d0Var.f21260c = Math.abs(f10);
            }
        }
    }

    public static float getAxisVelocity(VelocityTracker velocityTracker, int i10) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.a(velocityTracker, i10);
        }
        if (i10 == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i10 == 1) {
            return velocityTracker.getYVelocity();
        }
        d0 d0Var = f21247a.get(velocityTracker);
        if (d0Var == null || i10 != 26) {
            return 0.0f;
        }
        return d0Var.f21260c;
    }

    public static void computeCurrentVelocity(VelocityTracker velocityTracker, int i10) {
        computeCurrentVelocity(velocityTracker, i10, Float.MAX_VALUE);
    }
}
