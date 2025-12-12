package d1;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import x0.j0;

/* compiled from: AutoScrollHelper.java */
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    public static final int B = ViewConfiguration.getTapTimeout();
    public boolean A;

    /* renamed from: n, reason: collision with root package name */
    public final View f10752n;

    /* renamed from: o, reason: collision with root package name */
    public b f10753o;

    /* renamed from: r, reason: collision with root package name */
    public int f10756r;

    /* renamed from: s, reason: collision with root package name */
    public int f10757s;

    /* renamed from: w, reason: collision with root package name */
    public boolean f10761w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f10762x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f10763y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f10764z;

    /* renamed from: b, reason: collision with root package name */
    public final C0123a f10750b = new C0123a();

    /* renamed from: m, reason: collision with root package name */
    public final AccelerateInterpolator f10751m = new AccelerateInterpolator();

    /* renamed from: p, reason: collision with root package name */
    public final float[] f10754p = {0.0f, 0.0f};

    /* renamed from: q, reason: collision with root package name */
    public final float[] f10755q = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: t, reason: collision with root package name */
    public final float[] f10758t = {0.0f, 0.0f};

    /* renamed from: u, reason: collision with root package name */
    public final float[] f10759u = {0.0f, 0.0f};

    /* renamed from: v, reason: collision with root package name */
    public final float[] f10760v = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: d1.a$a, reason: collision with other inner class name */
    public static class C0123a {

        /* renamed from: a, reason: collision with root package name */
        public int f10765a;

        /* renamed from: b, reason: collision with root package name */
        public int f10766b;

        /* renamed from: c, reason: collision with root package name */
        public float f10767c;

        /* renamed from: d, reason: collision with root package name */
        public float f10768d;

        /* renamed from: j, reason: collision with root package name */
        public float f10774j;

        /* renamed from: k, reason: collision with root package name */
        public int f10775k;

        /* renamed from: e, reason: collision with root package name */
        public long f10769e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        public long f10773i = -1;

        /* renamed from: f, reason: collision with root package name */
        public long f10770f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f10771g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f10772h = 0;

        public final float a(long j10) {
            if (j10 < this.f10769e) {
                return 0.0f;
            }
            long j11 = this.f10773i;
            if (j11 < 0 || j10 < j11) {
                return a.b((j10 - r0) / this.f10765a, 0.0f, 1.0f) * 0.5f;
            }
            float f10 = this.f10774j;
            return (a.b((j10 - j11) / this.f10775k, 0.0f, 1.0f) * f10) + (1.0f - f10);
        }

        public void computeScrollDelta() {
            if (this.f10770f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fA = a(jCurrentAnimationTimeMillis);
            long j10 = jCurrentAnimationTimeMillis - this.f10770f;
            this.f10770f = jCurrentAnimationTimeMillis;
            float f10 = j10 * ((fA * 4.0f) + ((-4.0f) * fA * fA));
            this.f10771g = (int) (this.f10767c * f10);
            this.f10772h = (int) (f10 * this.f10768d);
        }

        public int getDeltaX() {
            return this.f10771g;
        }

        public int getDeltaY() {
            return this.f10772h;
        }

        public int getHorizontalDirection() {
            float f10 = this.f10767c;
            return (int) (f10 / Math.abs(f10));
        }

        public int getVerticalDirection() {
            float f10 = this.f10768d;
            return (int) (f10 / Math.abs(f10));
        }

        public boolean isFinished() {
            return this.f10773i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f10773i + ((long) this.f10775k);
        }

        public void requestStop() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            int i10 = (int) (jCurrentAnimationTimeMillis - this.f10769e);
            int i11 = this.f10766b;
            if (i10 > i11) {
                i10 = i11;
            } else if (i10 < 0) {
                i10 = 0;
            }
            this.f10775k = i10;
            this.f10774j = a(jCurrentAnimationTimeMillis);
            this.f10773i = jCurrentAnimationTimeMillis;
        }

        public void setRampDownDuration(int i10) {
            this.f10766b = i10;
        }

        public void setRampUpDuration(int i10) {
            this.f10765a = i10;
        }

        public void setTargetVelocity(float f10, float f11) {
            this.f10767c = f10;
            this.f10768d = f11;
        }

        public void start() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f10769e = jCurrentAnimationTimeMillis;
            this.f10773i = -1L;
            this.f10770f = jCurrentAnimationTimeMillis;
            this.f10774j = 0.5f;
            this.f10771g = 0;
            this.f10772h = 0;
        }
    }

    /* compiled from: AutoScrollHelper.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f10764z) {
                if (aVar.f10762x) {
                    aVar.f10762x = false;
                    aVar.f10750b.start();
                }
                C0123a c0123a = aVar.f10750b;
                if (c0123a.isFinished() || !aVar.d()) {
                    aVar.f10764z = false;
                    return;
                }
                if (aVar.f10763y) {
                    aVar.f10763y = false;
                    aVar.getClass();
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    aVar.f10752n.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                c0123a.computeScrollDelta();
                aVar.scrollTargetBy(c0123a.getDeltaX(), c0123a.getDeltaY());
                j0.postOnAnimation(aVar.f10752n, this);
            }
        }
    }

    public a(View view) {
        this.f10752n = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = (int) ((1575.0f * f10) + 0.5f);
        setMaximumVelocity(f11, f11);
        float f12 = (int) ((f10 * 315.0f) + 0.5f);
        setMinimumVelocity(f12, f12);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(B);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    public static float b(float f10, float f11, float f12) {
        return f10 > f12 ? f12 : f10 < f11 ? f11 : f10;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.f10754p
            r0 = r0[r7]
            float[] r1 = r3.f10755q
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            android.view.animation.AccelerateInterpolator r5 = r3.f10751m
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 >= 0) goto L26
            float r4 = -r4
            float r4 = r5.getInterpolation(r4)
            float r4 = -r4
            goto L2e
        L26:
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L37
            float r4 = r5.getInterpolation(r4)
        L2e:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = b(r4, r5, r0)
            goto L38
        L37:
            r4 = 0
        L38:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L3d
            return r2
        L3d:
            float[] r0 = r3.f10758t
            r0 = r0[r7]
            float[] r1 = r3.f10759u
            r1 = r1[r7]
            float[] r2 = r3.f10760v
            r7 = r2[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L54
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            return r4
        L54:
            float r4 = -r4
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.a.a(float, float, float, int):float");
    }

    public final float c(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.f10756r;
        if (i10 == 0 || i10 == 1) {
            if (f10 < f11) {
                if (f10 >= 0.0f) {
                    return 1.0f - (f10 / f11);
                }
                if (this.f10764z && i10 == 1) {
                    return 1.0f;
                }
            }
        } else if (i10 == 2 && f10 < 0.0f) {
            return f10 / (-f11);
        }
        return 0.0f;
    }

    public abstract boolean canTargetScrollHorizontally(int i10);

    public abstract boolean canTargetScrollVertically(int i10);

    public final boolean d() {
        C0123a c0123a = this.f10750b;
        int verticalDirection = c0123a.getVerticalDirection();
        int horizontalDirection = c0123a.getHorizontalDirection();
        return (verticalDirection != 0 && canTargetScrollVertically(verticalDirection)) || (horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0018  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
        /*
            r8 = this;
            boolean r0 = r8.A
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r10.getActionMasked()
            d1.a$a r2 = r8.f10750b
            r3 = 1
            if (r0 == 0) goto L23
            if (r0 == r3) goto L18
            r4 = 2
            if (r0 == r4) goto L27
            r9 = 3
            if (r0 == r9) goto L18
            goto L7f
        L18:
            boolean r9 = r8.f10762x
            if (r9 == 0) goto L1f
            r8.f10764z = r1
            goto L7f
        L1f:
            r2.requestStop()
            goto L7f
        L23:
            r8.f10763y = r3
            r8.f10761w = r1
        L27:
            float r0 = r10.getX()
            int r4 = r9.getWidth()
            float r4 = (float) r4
            android.view.View r5 = r8.f10752n
            int r6 = r5.getWidth()
            float r6 = (float) r6
            float r0 = r8.a(r0, r4, r6, r1)
            float r10 = r10.getY()
            int r9 = r9.getHeight()
            float r9 = (float) r9
            int r4 = r5.getHeight()
            float r4 = (float) r4
            float r9 = r8.a(r10, r9, r4, r3)
            r2.setTargetVelocity(r0, r9)
            boolean r9 = r8.f10764z
            if (r9 != 0) goto L7f
            boolean r9 = r8.d()
            if (r9 == 0) goto L7f
            d1.a$b r9 = r8.f10753o
            if (r9 != 0) goto L65
            d1.a$b r9 = new d1.a$b
            r9.<init>()
            r8.f10753o = r9
        L65:
            r8.f10764z = r3
            r8.f10762x = r3
            boolean r9 = r8.f10761w
            if (r9 != 0) goto L78
            int r9 = r8.f10757s
            if (r9 <= 0) goto L78
            d1.a$b r10 = r8.f10753o
            long r6 = (long) r9
            x0.j0.postOnAnimationDelayed(r5, r10, r6)
            goto L7d
        L78:
            d1.a$b r9 = r8.f10753o
            r9.run()
        L7d:
            r8.f10761w = r3
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract void scrollTargetBy(int i10, int i11);

    public a setActivationDelay(int i10) {
        this.f10757s = i10;
        return this;
    }

    public a setEdgeType(int i10) {
        this.f10756r = i10;
        return this;
    }

    public a setEnabled(boolean z10) {
        if (this.A && !z10) {
            if (this.f10762x) {
                this.f10764z = false;
            } else {
                this.f10750b.requestStop();
            }
        }
        this.A = z10;
        return this;
    }

    public a setMaximumEdges(float f10, float f11) {
        float[] fArr = this.f10755q;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a setMaximumVelocity(float f10, float f11) {
        float[] fArr = this.f10760v;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public a setMinimumVelocity(float f10, float f11) {
        float[] fArr = this.f10759u;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public a setRampDownDuration(int i10) {
        this.f10750b.setRampDownDuration(i10);
        return this;
    }

    public a setRampUpDuration(int i10) {
        this.f10750b.setRampUpDuration(i10);
        return this;
    }

    public a setRelativeEdges(float f10, float f11) {
        float[] fArr = this.f10754p;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a setRelativeVelocity(float f10, float f11) {
        float[] fArr = this.f10758t;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }
}
