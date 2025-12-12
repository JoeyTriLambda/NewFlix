package q6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import x0.j0;

/* compiled from: HeaderBehavior.java */
/* loaded from: classes.dex */
public abstract class c<V extends View> extends e<V> {

    /* renamed from: n, reason: collision with root package name */
    public a f17902n;

    /* renamed from: o, reason: collision with root package name */
    public OverScroller f17903o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f17904p;

    /* renamed from: q, reason: collision with root package name */
    public int f17905q;

    /* renamed from: r, reason: collision with root package name */
    public int f17906r;

    /* renamed from: s, reason: collision with root package name */
    public int f17907s;

    /* renamed from: t, reason: collision with root package name */
    public VelocityTracker f17908t;

    /* compiled from: HeaderBehavior.java */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final CoordinatorLayout f17909b;

        /* renamed from: m, reason: collision with root package name */
        public final V f17910m;

        public a(CoordinatorLayout coordinatorLayout, V v10) {
            this.f17909b = coordinatorLayout;
            this.f17910m = v10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            OverScroller overScroller;
            V v10 = this.f17910m;
            if (v10 == null || (overScroller = (cVar = c.this).f17903o) == null) {
                return;
            }
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            CoordinatorLayout coordinatorLayout = this.f17909b;
            if (!zComputeScrollOffset) {
                cVar.e(coordinatorLayout, v10);
            } else {
                cVar.g(coordinatorLayout, v10, cVar.f17903o.getCurrY());
                j0.postOnAnimation(v10, this);
            }
        }
    }

    public c() {
        this.f17905q = -1;
        this.f17907s = -1;
    }

    public boolean a(V v10) {
        return false;
    }

    public int b(V v10) {
        return -v10.getHeight();
    }

    public int c(V v10) {
        return v10.getHeight();
    }

    public int d() {
        return getTopAndBottomOffset();
    }

    public int f(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        int iClamp;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i11 == 0 || topAndBottomOffset < i11 || topAndBottomOffset > i12 || topAndBottomOffset == (iClamp = r0.a.clamp(i10, i11, i12))) {
            return 0;
        }
        setTopAndBottomOffset(iClamp);
        return topAndBottomOffset - iClamp;
    }

    public final void g(CoordinatorLayout coordinatorLayout, View view, int i10) {
        f(coordinatorLayout, view, i10, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f17907s < 0) {
            this.f17907s = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f17904p) {
            int i10 = this.f17905q;
            if (i10 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i10)) == -1) {
                return false;
            }
            int y10 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y10 - this.f17906r) > this.f17907s) {
                this.f17906r = y10;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f17905q = -1;
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            boolean z10 = a(v10) && coordinatorLayout.isPointInChildBounds(v10, x10, y11);
            this.f17904p = z10;
            if (z10) {
                this.f17906r = y11;
                this.f17905q = motionEvent.getPointerId(0);
                if (this.f17908t == null) {
                    this.f17908t = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f17903o;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f17903o.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f17908t;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r20, V r21, android.view.MotionEvent r22) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.c.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17905q = -1;
        this.f17907s = -1;
    }

    public void e(CoordinatorLayout coordinatorLayout, V v10) {
    }
}
