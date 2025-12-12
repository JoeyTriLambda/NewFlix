package g1;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import x0.j0;

/* compiled from: ViewDragHelper.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: x, reason: collision with root package name */
    public static final a f12522x = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f12523a;

    /* renamed from: b, reason: collision with root package name */
    public int f12524b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f12526d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f12527e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f12528f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f12529g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f12530h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f12531i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f12532j;

    /* renamed from: k, reason: collision with root package name */
    public int f12533k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f12534l;

    /* renamed from: m, reason: collision with root package name */
    public final float f12535m;

    /* renamed from: n, reason: collision with root package name */
    public float f12536n;

    /* renamed from: o, reason: collision with root package name */
    public int f12537o;

    /* renamed from: p, reason: collision with root package name */
    public final int f12538p;

    /* renamed from: q, reason: collision with root package name */
    public int f12539q;

    /* renamed from: r, reason: collision with root package name */
    public final OverScroller f12540r;

    /* renamed from: s, reason: collision with root package name */
    public final AbstractC0148c f12541s;

    /* renamed from: t, reason: collision with root package name */
    public View f12542t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f12543u;

    /* renamed from: v, reason: collision with root package name */
    public final ViewGroup f12544v;

    /* renamed from: c, reason: collision with root package name */
    public int f12525c = -1;

    /* renamed from: w, reason: collision with root package name */
    public final b f12545w = new b();

    /* compiled from: ViewDragHelper.java */
    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* compiled from: ViewDragHelper.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.k(0);
        }
    }

    public c(Context context, ViewGroup viewGroup, AbstractC0148c abstractC0148c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0148c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f12544v = viewGroup;
        this.f12541s = abstractC0148c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i10 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f12538p = i10;
        this.f12537o = i10;
        this.f12524b = viewConfiguration.getScaledTouchSlop();
        this.f12535m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f12536n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f12540r = new OverScroller(context, f12522x);
    }

    public static c create(ViewGroup viewGroup, AbstractC0148c abstractC0148c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0148c);
    }

    public final boolean a(float f10, float f11, int i10, int i11) {
        float fAbs = Math.abs(f10);
        float fAbs2 = Math.abs(f11);
        if ((this.f12530h[i10] & i11) != i11 || (this.f12539q & i11) == 0 || (this.f12532j[i10] & i11) == i11 || (this.f12531i[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.f12524b;
        if (fAbs <= i12 && fAbs2 <= i12) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f12541s.onEdgeLock(i11)) {
            return (this.f12531i[i10] & i11) == 0 && fAbs > ((float) this.f12524b);
        }
        int[] iArr = this.f12532j;
        iArr[i10] = iArr[i10] | i11;
        return false;
    }

    public final boolean b(View view, float f10, float f11) {
        if (view == null) {
            return false;
        }
        AbstractC0148c abstractC0148c = this.f12541s;
        boolean z10 = abstractC0148c.getViewHorizontalDragRange(view) > 0;
        boolean z11 = abstractC0148c.getViewVerticalDragRange(view) > 0;
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f12524b) : z11 && Math.abs(f11) > ((float) this.f12524b);
        }
        float f12 = (f11 * f11) + (f10 * f10);
        int i10 = this.f12524b;
        return f12 > ((float) (i10 * i10));
    }

    public final void c(int i10) {
        if (this.f12526d == null || !isPointerDown(i10)) {
            return;
        }
        this.f12526d[i10] = 0.0f;
        this.f12527e[i10] = 0.0f;
        this.f12528f[i10] = 0.0f;
        this.f12529g[i10] = 0.0f;
        this.f12530h[i10] = 0;
        this.f12531i[i10] = 0;
        this.f12532j[i10] = 0;
        this.f12533k = (~(1 << i10)) & this.f12533k;
    }

    public void cancel() {
        this.f12525c = -1;
        float[] fArr = this.f12526d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f12527e, 0.0f);
            Arrays.fill(this.f12528f, 0.0f);
            Arrays.fill(this.f12529g, 0.0f);
            Arrays.fill(this.f12530h, 0);
            Arrays.fill(this.f12531i, 0);
            Arrays.fill(this.f12532j, 0);
            this.f12533k = 0;
        }
        VelocityTracker velocityTracker = this.f12534l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f12534l = null;
        }
    }

    public void captureChildView(View view, int i10) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f12544v;
        if (parent != viewGroup) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
        }
        this.f12542t = view;
        this.f12525c = i10;
        this.f12541s.onViewCaptured(view, i10);
        k(1);
    }

    public boolean checkTouchSlop(int i10) {
        int length = this.f12526d.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (checkTouchSlop(i10, i11)) {
                return true;
            }
        }
        return false;
    }

    public boolean continueSettling(boolean z10) {
        if (this.f12523a == 2) {
            OverScroller overScroller = this.f12540r;
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f12542t.getLeft();
            int top = currY - this.f12542t.getTop();
            if (left != 0) {
                j0.offsetLeftAndRight(this.f12542t, left);
            }
            if (top != 0) {
                j0.offsetTopAndBottom(this.f12542t, top);
            }
            if (left != 0 || top != 0) {
                this.f12541s.onViewPositionChanged(this.f12542t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z10) {
                    this.f12544v.post(this.f12545w);
                } else {
                    k(0);
                }
            }
        }
        return this.f12523a == 2;
    }

    public final int d(int i10, int i11, int i12) {
        if (i10 == 0) {
            return 0;
        }
        float width = this.f12544v.getWidth() / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i10) / r0) - 0.5f) * 0.47123894f)) * width) + width;
        int iAbs = Math.abs(i11);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i10) / i12) + 1.0f) * 256.0f), 600);
    }

    public final boolean e(int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int left = this.f12542t.getLeft();
        int top = this.f12542t.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        OverScroller overScroller = this.f12540r;
        if (i14 == 0 && i15 == 0) {
            overScroller.abortAnimation();
            k(0);
            return false;
        }
        View view = this.f12542t;
        int i16 = (int) this.f12536n;
        int i17 = (int) this.f12535m;
        int iAbs = Math.abs(i12);
        if (iAbs < i16) {
            i12 = 0;
        } else if (iAbs > i17) {
            i12 = i12 > 0 ? i17 : -i17;
        }
        int i18 = (int) this.f12536n;
        int iAbs2 = Math.abs(i13);
        if (iAbs2 < i18) {
            i13 = 0;
        } else if (iAbs2 > i17) {
            i13 = i13 > 0 ? i17 : -i17;
        }
        int iAbs3 = Math.abs(i14);
        int iAbs4 = Math.abs(i15);
        int iAbs5 = Math.abs(i12);
        int iAbs6 = Math.abs(i13);
        int i19 = iAbs5 + iAbs6;
        int i20 = iAbs3 + iAbs4;
        if (i12 != 0) {
            f10 = iAbs5;
            f11 = i19;
        } else {
            f10 = iAbs3;
            f11 = i20;
        }
        float f14 = f10 / f11;
        if (i13 != 0) {
            f12 = iAbs6;
            f13 = i19;
        } else {
            f12 = iAbs4;
            f13 = i20;
        }
        float f15 = f12 / f13;
        AbstractC0148c abstractC0148c = this.f12541s;
        overScroller.startScroll(left, top, i14, i15, (int) ((d(i15, i13, abstractC0148c.getViewVerticalDragRange(view)) * f15) + (d(i14, i12, abstractC0148c.getViewHorizontalDragRange(view)) * f14)));
        k(2);
        return true;
    }

    public final boolean f(int i10) {
        if (isPointerDown(i10)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public View findTopChildUnder(int i10, int i11) {
        ViewGroup viewGroup = this.f12544v;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(this.f12541s.getOrderedChildIndex(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final void g() {
        VelocityTracker velocityTracker = this.f12534l;
        float f10 = this.f12535m;
        velocityTracker.computeCurrentVelocity(1000, f10);
        float xVelocity = this.f12534l.getXVelocity(this.f12525c);
        float f11 = this.f12536n;
        float fAbs = Math.abs(xVelocity);
        float f12 = 0.0f;
        if (fAbs < f11) {
            xVelocity = 0.0f;
        } else if (fAbs > f10) {
            xVelocity = xVelocity > 0.0f ? f10 : -f10;
        }
        float yVelocity = this.f12534l.getYVelocity(this.f12525c);
        float f13 = this.f12536n;
        float fAbs2 = Math.abs(yVelocity);
        if (fAbs2 >= f13) {
            if (fAbs2 > f10) {
                if (yVelocity <= 0.0f) {
                    f10 = -f10;
                }
                f12 = f10;
            } else {
                f12 = yVelocity;
            }
        }
        this.f12543u = true;
        this.f12541s.onViewReleased(this.f12542t, xVelocity, f12);
        this.f12543u = false;
        if (this.f12523a == 1) {
            k(0);
        }
    }

    public View getCapturedView() {
        return this.f12542t;
    }

    public int getDefaultEdgeSize() {
        return this.f12538p;
    }

    public int getEdgeSize() {
        return this.f12537o;
    }

    public int getTouchSlop() {
        return this.f12524b;
    }

    public int getViewDragState() {
        return this.f12523a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [g1.c$c] */
    public final void h(float f10, float f11, int i10) {
        boolean zA = a(f10, f11, i10, 1);
        boolean z10 = zA;
        if (a(f11, f10, i10, 4)) {
            z10 = (zA ? 1 : 0) | 4;
        }
        boolean z11 = z10;
        if (a(f10, f11, i10, 2)) {
            z11 = (z10 ? 1 : 0) | 2;
        }
        ?? r02 = z11;
        if (a(f11, f10, i10, 8)) {
            r02 = (z11 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f12531i;
            iArr[i10] = iArr[i10] | r02;
            this.f12541s.onEdgeDragStarted(r02, i10);
        }
    }

    public final void i(float f10, float f11, int i10) {
        float[] fArr = this.f12526d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f12527e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f12528f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f12529g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f12530h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f12531i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f12532j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f12526d = fArr2;
            this.f12527e = fArr3;
            this.f12528f = fArr4;
            this.f12529g = fArr5;
            this.f12530h = iArr;
            this.f12531i = iArr2;
            this.f12532j = iArr3;
        }
        float[] fArr9 = this.f12526d;
        this.f12528f[i10] = f10;
        fArr9[i10] = f10;
        float[] fArr10 = this.f12527e;
        this.f12529g[i10] = f11;
        fArr10[i10] = f11;
        int[] iArr7 = this.f12530h;
        int i12 = (int) f10;
        int i13 = (int) f11;
        ViewGroup viewGroup = this.f12544v;
        int i14 = i12 < viewGroup.getLeft() + this.f12537o ? 1 : 0;
        if (i13 < viewGroup.getTop() + this.f12537o) {
            i14 |= 4;
        }
        if (i12 > viewGroup.getRight() - this.f12537o) {
            i14 |= 2;
        }
        if (i13 > viewGroup.getBottom() - this.f12537o) {
            i14 |= 8;
        }
        iArr7[i10] = i14;
        this.f12533k |= 1 << i10;
    }

    public boolean isCapturedViewUnder(int i10, int i11) {
        return isViewUnder(this.f12542t, i10, i11);
    }

    public boolean isPointerDown(int i10) {
        return ((1 << i10) & this.f12533k) != 0;
    }

    public boolean isViewUnder(View view, int i10, int i11) {
        return view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom();
    }

    public final void j(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (f(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f12528f[pointerId] = x10;
                this.f12529g[pointerId] = y10;
            }
        }
    }

    public final void k(int i10) {
        this.f12544v.removeCallbacks(this.f12545w);
        if (this.f12523a != i10) {
            this.f12523a = i10;
            this.f12541s.onViewDragStateChanged(i10);
            if (this.f12523a == 0) {
                this.f12542t = null;
            }
        }
    }

    public final boolean l(View view, int i10) {
        if (view == this.f12542t && this.f12525c == i10) {
            return true;
        }
        if (view == null || !this.f12541s.tryCaptureView(view, i10)) {
            return false;
        }
        this.f12525c = i10;
        captureChildView(view, i10);
        return true;
    }

    public void processTouchEvent(MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.f12534l == null) {
            this.f12534l = VelocityTracker.obtain();
        }
        this.f12534l.addMovement(motionEvent);
        int i11 = 0;
        AbstractC0148c abstractC0148c = this.f12541s;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewFindTopChildUnder = findTopChildUnder((int) x10, (int) y10);
            i(x10, y10, pointerId);
            l(viewFindTopChildUnder, pointerId);
            int i12 = this.f12530h[pointerId] & this.f12539q;
            if (i12 != 0) {
                abstractC0148c.onEdgeTouched(i12, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f12523a == 1) {
                g();
            }
            cancel();
            return;
        }
        if (actionMasked == 2) {
            if (this.f12523a != 1) {
                int pointerCount = motionEvent.getPointerCount();
                while (i11 < pointerCount) {
                    int pointerId2 = motionEvent.getPointerId(i11);
                    if (f(pointerId2)) {
                        float x11 = motionEvent.getX(i11);
                        float y11 = motionEvent.getY(i11);
                        float f10 = x11 - this.f12526d[pointerId2];
                        float f11 = y11 - this.f12527e[pointerId2];
                        h(f10, f11, pointerId2);
                        if (this.f12523a != 1) {
                            View viewFindTopChildUnder2 = findTopChildUnder((int) x11, (int) y11);
                            if (b(viewFindTopChildUnder2, f10, f11) && l(viewFindTopChildUnder2, pointerId2)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i11++;
                }
                j(motionEvent);
                return;
            }
            if (f(this.f12525c)) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f12525c);
                float x12 = motionEvent.getX(iFindPointerIndex);
                float y12 = motionEvent.getY(iFindPointerIndex);
                float[] fArr = this.f12528f;
                int i13 = this.f12525c;
                int i14 = (int) (x12 - fArr[i13]);
                int i15 = (int) (y12 - this.f12529g[i13]);
                int left = this.f12542t.getLeft() + i14;
                int top = this.f12542t.getTop() + i15;
                int left2 = this.f12542t.getLeft();
                int top2 = this.f12542t.getTop();
                if (i14 != 0) {
                    left = abstractC0148c.clampViewPositionHorizontal(this.f12542t, left, i14);
                    j0.offsetLeftAndRight(this.f12542t, left - left2);
                }
                int i16 = left;
                if (i15 != 0) {
                    top = abstractC0148c.clampViewPositionVertical(this.f12542t, top, i15);
                    j0.offsetTopAndBottom(this.f12542t, top - top2);
                }
                int i17 = top;
                if (i14 != 0 || i15 != 0) {
                    this.f12541s.onViewPositionChanged(this.f12542t, i16, i17, i16 - left2, i17 - top2);
                }
                j(motionEvent);
                return;
            }
            return;
        }
        if (actionMasked == 3) {
            if (this.f12523a == 1) {
                this.f12543u = true;
                abstractC0148c.onViewReleased(this.f12542t, 0.0f, 0.0f);
                this.f12543u = false;
                if (this.f12523a == 1) {
                    k(0);
                }
            }
            cancel();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x13 = motionEvent.getX(actionIndex);
            float y13 = motionEvent.getY(actionIndex);
            i(x13, y13, pointerId3);
            if (this.f12523a != 0) {
                if (isCapturedViewUnder((int) x13, (int) y13)) {
                    l(this.f12542t, pointerId3);
                    return;
                }
                return;
            } else {
                l(findTopChildUnder((int) x13, (int) y13), pointerId3);
                int i18 = this.f12530h[pointerId3] & this.f12539q;
                if (i18 != 0) {
                    abstractC0148c.onEdgeTouched(i18, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f12523a == 1 && pointerId4 == this.f12525c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i11 >= pointerCount2) {
                    i10 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i11);
                if (pointerId5 != this.f12525c) {
                    View viewFindTopChildUnder3 = findTopChildUnder((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                    View view = this.f12542t;
                    if (viewFindTopChildUnder3 == view && l(view, pointerId5)) {
                        i10 = this.f12525c;
                        break;
                    }
                }
                i11++;
            }
            if (i10 == -1) {
                g();
            }
        }
        c(pointerId4);
    }

    public void setEdgeSize(int i10) {
        this.f12537o = i10;
    }

    public void setEdgeTrackingEnabled(int i10) {
        this.f12539q = i10;
    }

    public void setMinVelocity(float f10) {
        this.f12536n = f10;
    }

    public boolean settleCapturedViewAt(int i10, int i11) {
        if (this.f12543u) {
            return e(i10, i11, (int) this.f12534l.getXVelocity(this.f12525c), (int) this.f12534l.getYVelocity(this.f12525c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean shouldInterceptTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.c.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(View view, int i10, int i11) {
        this.f12542t = view;
        this.f12525c = -1;
        boolean zE = e(i10, i11, 0, 0);
        if (!zE && this.f12523a == 0 && this.f12542t != null) {
            this.f12542t = null;
        }
        return zE;
    }

    public static c create(ViewGroup viewGroup, float f10, AbstractC0148c abstractC0148c) {
        c cVarCreate = create(viewGroup, abstractC0148c);
        cVarCreate.f12524b = (int) ((1.0f / f10) * cVarCreate.f12524b);
        return cVarCreate;
    }

    public boolean checkTouchSlop(int i10, int i11) {
        if (!isPointerDown(i11)) {
            return false;
        }
        boolean z10 = (i10 & 1) == 1;
        boolean z11 = (i10 & 2) == 2;
        float f10 = this.f12528f[i11] - this.f12526d[i11];
        float f11 = this.f12529g[i11] - this.f12527e[i11];
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f12524b) : z11 && Math.abs(f11) > ((float) this.f12524b);
        }
        float f12 = (f11 * f11) + (f10 * f10);
        int i12 = this.f12524b;
        return f12 > ((float) (i12 * i12));
    }

    /* compiled from: ViewDragHelper.java */
    /* renamed from: g1.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0148c {
        public abstract int clampViewPositionHorizontal(View view, int i10, int i11);

        public abstract int clampViewPositionVertical(View view, int i10, int i11);

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public boolean onEdgeLock(int i10) {
            return false;
        }

        public abstract void onViewDragStateChanged(int i10);

        public abstract void onViewPositionChanged(View view, int i10, int i11, int i12, int i13);

        public abstract void onViewReleased(View view, float f10, float f11);

        public abstract boolean tryCaptureView(View view, int i10);

        public int getOrderedChildIndex(int i10) {
            return i10;
        }

        public void onEdgeDragStarted(int i10, int i11) {
        }

        public void onEdgeTouched(int i10, int i11) {
        }

        public void onViewCaptured(View view, int i10) {
        }
    }
}
