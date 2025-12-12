package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.s;
import androidx.recyclerview.widget.w;
import androidx.recyclerview.widget.x;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import x0.j0;
import x0.m0;
import y0.d;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements x0.q {
    public static final int[] K0 = {R.attr.nestedScrollingEnabled};
    public static final boolean L0;
    public static final boolean M0;
    public static final boolean N0;
    public static final Class<?>[] O0;
    public static final c P0;
    public final ArrayList<k> A;
    public x0.r A0;
    public final ArrayList<o> B;
    public final int[] B0;
    public o C;
    public final int[] C0;
    public boolean D;
    public final int[] D0;
    public boolean E;
    public final ArrayList E0;
    public boolean F;
    public final b F0;
    public int G;
    public boolean G0;
    public boolean H;
    public int H0;
    public boolean I;
    public int I0;
    public boolean J;
    public final d J0;
    public int K;
    public boolean L;
    public final AccessibilityManager M;
    public boolean N;
    public boolean O;
    public int P;
    public int Q;
    public h R;
    public EdgeEffect S;
    public EdgeEffect T;
    public EdgeEffect U;
    public EdgeEffect V;
    public i W;

    /* renamed from: a0, reason: collision with root package name */
    public int f3903a0;

    /* renamed from: b, reason: collision with root package name */
    public final t f3904b;

    /* renamed from: b0, reason: collision with root package name */
    public int f3905b0;

    /* renamed from: c0, reason: collision with root package name */
    public VelocityTracker f3906c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f3907d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f3908e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f3909f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f3910g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f3911h0;

    /* renamed from: i0, reason: collision with root package name */
    public n f3912i0;

    /* renamed from: j0, reason: collision with root package name */
    public final int f3913j0;

    /* renamed from: k0, reason: collision with root package name */
    public final int f3914k0;

    /* renamed from: l0, reason: collision with root package name */
    public final float f3915l0;

    /* renamed from: m, reason: collision with root package name */
    public final r f3916m;

    /* renamed from: m0, reason: collision with root package name */
    public final float f3917m0;

    /* renamed from: n, reason: collision with root package name */
    public u f3918n;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f3919n0;

    /* renamed from: o, reason: collision with root package name */
    public androidx.recyclerview.widget.a f3920o;

    /* renamed from: o0, reason: collision with root package name */
    public final y f3921o0;

    /* renamed from: p, reason: collision with root package name */
    public androidx.recyclerview.widget.b f3922p;

    /* renamed from: p0, reason: collision with root package name */
    public androidx.recyclerview.widget.k f3923p0;

    /* renamed from: q, reason: collision with root package name */
    public final androidx.recyclerview.widget.x f3924q;

    /* renamed from: q0, reason: collision with root package name */
    public final k.b f3925q0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3926r;

    /* renamed from: r0, reason: collision with root package name */
    public final w f3927r0;

    /* renamed from: s, reason: collision with root package name */
    public final a f3928s;

    /* renamed from: s0, reason: collision with root package name */
    public p f3929s0;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f3930t;

    /* renamed from: t0, reason: collision with root package name */
    public ArrayList f3931t0;

    /* renamed from: u, reason: collision with root package name */
    public final Rect f3932u;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f3933u0;

    /* renamed from: v, reason: collision with root package name */
    public final RectF f3934v;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f3935v0;

    /* renamed from: w, reason: collision with root package name */
    public Adapter f3936w;

    /* renamed from: w0, reason: collision with root package name */
    public final j f3937w0;

    /* renamed from: x, reason: collision with root package name */
    public l f3938x;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f3939x0;

    /* renamed from: y, reason: collision with root package name */
    public s f3940y;

    /* renamed from: y0, reason: collision with root package name */
    public androidx.recyclerview.widget.s f3941y0;

    /* renamed from: z, reason: collision with root package name */
    public final ArrayList f3942z;

    /* renamed from: z0, reason: collision with root package name */
    public final int[] f3943z0;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.F || recyclerView.isLayoutRequested()) {
                return;
            }
            if (!recyclerView.D) {
                recyclerView.requestLayout();
            } else if (recyclerView.I) {
                recyclerView.H = true;
            } else {
                recyclerView.j();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            i iVar = recyclerView.W;
            if (iVar != null) {
                iVar.runPendingAnimations();
            }
            recyclerView.f3939x0 = false;
        }
    }

    public class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    public class d {
        public d() {
        }

        public void processAppeared(z zVar, i.c cVar, i.c cVar2) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.getClass();
            zVar.setIsRecyclable(false);
            if (recyclerView.W.animateAppearance(zVar, cVar, cVar2)) {
                recyclerView.L();
            }
        }

        public void processDisappeared(z zVar, i.c cVar, i.c cVar2) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3916m.h(zVar);
            recyclerView.e(zVar);
            zVar.setIsRecyclable(false);
            if (recyclerView.W.animateDisappearance(zVar, cVar, cVar2)) {
                recyclerView.L();
            }
        }

        public void processPersistent(z zVar, i.c cVar, i.c cVar2) {
            zVar.setIsRecyclable(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.N) {
                if (recyclerView.W.animateChange(zVar, zVar, cVar, cVar2)) {
                    recyclerView.L();
                }
            } else if (recyclerView.W.animatePersistence(zVar, cVar, cVar2)) {
                recyclerView.L();
            }
        }

        public void unused(z zVar) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3938x.removeAndRecycleView(zVar.f4041a, recyclerView.f3916m);
        }
    }

    public static class e extends Observable<f> {
        public boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void notifyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((f) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemRangeChanged(int i10, int i11) {
            notifyItemRangeChanged(i10, i11, null);
        }

        public void notifyItemRangeInserted(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((f) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i10, i11);
            }
        }

        public void notifyItemRangeRemoved(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((f) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i10, i11);
            }
        }

        public void notifyItemRangeChanged(int i10, int i11, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((f) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i10, i11, obj);
            }
        }
    }

    public static abstract class f {
        public void onItemRangeChanged(int i10, int i11) {
        }

        public void onItemRangeChanged(int i10, int i11, Object obj) {
            onItemRangeChanged(i10, i11);
        }

        public void onChanged() {
        }

        public void onItemRangeInserted(int i10, int i11) {
        }

        public void onItemRangeRemoved(int i10, int i11) {
        }
    }

    public interface g {
    }

    public static class h {
        public EdgeEffect createEdgeEffect(RecyclerView recyclerView, int i10) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public class j implements i.b {
        public j() {
        }

        public void onAnimationFinished(z zVar) {
            boolean z10 = true;
            zVar.setIsRecyclable(true);
            if (zVar.f4048h != null && zVar.f4049i == null) {
                zVar.f4048h = null;
            }
            zVar.f4049i = null;
            if ((zVar.f4050j & 16) != 0) {
                return;
            }
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.V();
            androidx.recyclerview.widget.b bVar = recyclerView.f3922p;
            androidx.recyclerview.widget.q qVar = (androidx.recyclerview.widget.q) bVar.f4112a;
            View view = zVar.f4041a;
            int iIndexOfChild = qVar.indexOfChild(view);
            if (iIndexOfChild == -1) {
                bVar.j(view);
            } else {
                b.a aVar = bVar.f4113b;
                if (aVar.d(iIndexOfChild)) {
                    aVar.f(iIndexOfChild);
                    bVar.j(view);
                    qVar.removeViewAt(iIndexOfChild);
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                z zVarC = RecyclerView.C(view);
                r rVar = recyclerView.f3916m;
                rVar.h(zVarC);
                rVar.e(zVarC);
            }
            recyclerView.W(!z10);
            if (z10 || !zVar.i()) {
                return;
            }
            recyclerView.removeDetachedView(view, false);
        }
    }

    public static abstract class k {
        @Deprecated
        public void getItemOffsets(Rect rect, int i10, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, w wVar) {
            getItemOffsets(rect, ((m) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, w wVar) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, w wVar) {
            onDrawOver(canvas, recyclerView);
        }
    }

    public static abstract class l {

        /* renamed from: a, reason: collision with root package name */
        public androidx.recyclerview.widget.b f3961a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView f3962b;

        /* renamed from: c, reason: collision with root package name */
        public final androidx.recyclerview.widget.w f3963c;

        /* renamed from: d, reason: collision with root package name */
        public final androidx.recyclerview.widget.w f3964d;

        /* renamed from: e, reason: collision with root package name */
        public v f3965e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f3966f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f3967g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f3968h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f3969i;

        /* renamed from: j, reason: collision with root package name */
        public int f3970j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f3971k;

        /* renamed from: l, reason: collision with root package name */
        public int f3972l;

        /* renamed from: m, reason: collision with root package name */
        public int f3973m;

        /* renamed from: n, reason: collision with root package name */
        public int f3974n;

        /* renamed from: o, reason: collision with root package name */
        public int f3975o;

        public class a implements w.b {
            public a() {
            }

            @Override // androidx.recyclerview.widget.w.b
            public View getChildAt(int i10) {
                return l.this.getChildAt(i10);
            }

            @Override // androidx.recyclerview.widget.w.b
            public int getChildEnd(View view) {
                return l.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.w.b
            public int getChildStart(View view) {
                return l.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.w.b
            public int getParentEnd() {
                l lVar = l.this;
                return lVar.getWidth() - lVar.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.w.b
            public int getParentStart() {
                return l.this.getPaddingLeft();
            }
        }

        public class b implements w.b {
            public b() {
            }

            @Override // androidx.recyclerview.widget.w.b
            public View getChildAt(int i10) {
                return l.this.getChildAt(i10);
            }

            @Override // androidx.recyclerview.widget.w.b
            public int getChildEnd(View view) {
                return l.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.w.b
            public int getChildStart(View view) {
                return l.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.w.b
            public int getParentEnd() {
                l lVar = l.this;
                return lVar.getHeight() - lVar.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.w.b
            public int getParentStart() {
                return l.this.getPaddingTop();
            }
        }

        public interface c {
        }

        public static class d {

            /* renamed from: a, reason: collision with root package name */
            public int f3978a;

            /* renamed from: b, reason: collision with root package name */
            public int f3979b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f3980c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f3981d;
        }

        public l() {
            a aVar = new a();
            b bVar = new b();
            this.f3963c = new androidx.recyclerview.widget.w(aVar);
            this.f3964d = new androidx.recyclerview.widget.w(bVar);
            this.f3966f = false;
            this.f3967g = false;
            this.f3968h = true;
            this.f3969i = true;
        }

        public static boolean b(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (i12 > 0 && i10 != i12) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i10;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i10;
            }
            return true;
        }

        public static int chooseSize(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i11, i12) : size : Math.min(size, Math.max(i11, i12));
        }

        public static int getChildMeasureSpec(int i10, int i11, int i12, int i13, boolean z10) {
            int iMax = Math.max(0, i10 - i12);
            if (z10) {
                if (i13 < 0) {
                    if (i13 != -1 || (i11 != Integer.MIN_VALUE && (i11 == 0 || i11 != 1073741824))) {
                        i11 = 0;
                        i13 = 0;
                    } else {
                        i13 = iMax;
                    }
                }
                i11 = 1073741824;
            } else {
                if (i13 < 0) {
                    if (i13 != -1) {
                        if (i13 == -2) {
                            i11 = (i11 == Integer.MIN_VALUE || i11 == 1073741824) ? Integer.MIN_VALUE : 0;
                        }
                        i11 = 0;
                        i13 = 0;
                    }
                    i13 = iMax;
                }
                i11 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i13, i11);
        }

        public static d getProperties(Context context, AttributeSet attributeSet, int i10, int i11) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i10, i11);
            dVar.f3978a = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            dVar.f3979b = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            dVar.f3980c = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            dVar.f3981d = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        public final void a(View view, boolean z10, int i10) {
            z zVarC = RecyclerView.C(view);
            if (z10 || zVarC.g()) {
                b0.k<z, x.a> kVar = this.f3962b.f3924q.f4260a;
                x.a aVarA = kVar.get(zVarC);
                if (aVarA == null) {
                    aVarA = x.a.a();
                    kVar.put(zVarC, aVarA);
                }
                aVarA.f4263a |= 1;
            } else {
                this.f3962b.f3924q.c(zVarC);
            }
            m mVar = (m) view.getLayoutParams();
            if (zVarC.m() || zVarC.h()) {
                if (zVarC.h()) {
                    zVarC.f4054n.h(zVarC);
                } else {
                    zVarC.f4050j &= -33;
                }
                this.f3961a.b(view, i10, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f3962b) {
                int iH = this.f3961a.h(view);
                if (i10 == -1) {
                    i10 = this.f3961a.d();
                }
                if (iH == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f3962b.indexOfChild(view) + this.f3962b.u());
                }
                if (iH != i10) {
                    this.f3962b.f3938x.moveView(iH, i10);
                }
            } else {
                this.f3961a.a(view, false, i10);
                mVar.f3984c = true;
                v vVar = this.f3965e;
                if (vVar != null && vVar.isRunning()) {
                    this.f3965e.onChildAttachedToWindow(view);
                }
            }
            if (mVar.f3985d) {
                zVarC.f4041a.invalidate();
                mVar.f3985d = false;
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.f3962b;
            if (recyclerView != null) {
                recyclerView.f(str);
            }
        }

        public void attachView(View view, int i10, m mVar) {
            z zVarC = RecyclerView.C(view);
            if (zVarC.g()) {
                b0.k<z, x.a> kVar = this.f3962b.f3924q.f4260a;
                x.a aVarA = kVar.get(zVarC);
                if (aVarA == null) {
                    aVarA = x.a.a();
                    kVar.put(zVarC, aVarA);
                }
                aVarA.f4263a |= 1;
            } else {
                this.f3962b.f3924q.c(zVarC);
            }
            this.f3961a.b(view, i10, mVar, zVarC.g());
        }

        public final void c(View view, y0.d dVar) {
            z zVarC = RecyclerView.C(view);
            if (zVarC == null || zVarC.g() || this.f3961a.i(zVarC.f4041a)) {
                return;
            }
            RecyclerView recyclerView = this.f3962b;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.f3916m, recyclerView.f3927r0, view, dVar);
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.f3962b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.E(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(m mVar) {
            return mVar != null;
        }

        public int computeHorizontalScrollExtent(w wVar) {
            return 0;
        }

        public int computeHorizontalScrollOffset(w wVar) {
            return 0;
        }

        public int computeHorizontalScrollRange(w wVar) {
            return 0;
        }

        public int computeVerticalScrollExtent(w wVar) {
            return 0;
        }

        public int computeVerticalScrollOffset(w wVar) {
            return 0;
        }

        public int computeVerticalScrollRange(w wVar) {
            return 0;
        }

        public final void d(r rVar) {
            ArrayList<z> arrayList;
            int size = rVar.f3992a.size();
            int i10 = size - 1;
            while (true) {
                arrayList = rVar.f3992a;
                if (i10 < 0) {
                    break;
                }
                View view = arrayList.get(i10).f4041a;
                z zVarC = RecyclerView.C(view);
                if (!zVarC.l()) {
                    zVarC.setIsRecyclable(false);
                    if (zVarC.i()) {
                        this.f3962b.removeDetachedView(view, false);
                    }
                    i iVar = this.f3962b.W;
                    if (iVar != null) {
                        iVar.endAnimation(zVarC);
                    }
                    zVarC.setIsRecyclable(true);
                    z zVarC2 = RecyclerView.C(view);
                    zVarC2.f4054n = null;
                    zVarC2.f4055o = false;
                    zVarC2.f4050j &= -33;
                    rVar.e(zVarC2);
                }
                i10--;
            }
            arrayList.clear();
            ArrayList<z> arrayList2 = rVar.f3993b;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            if (size > 0) {
                this.f3962b.invalidate();
            }
        }

        public void detachAndScrapAttachedViews(r rVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                e(rVar, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, r rVar) {
            e(rVar, this.f3961a.h(view), view);
        }

        public void detachViewAt(int i10) {
            getChildAt(i10);
            androidx.recyclerview.widget.b bVar = this.f3961a;
            int iE = bVar.e(i10);
            bVar.f4113b.f(iE);
            ((androidx.recyclerview.widget.q) bVar.f4112a).detachViewFromParent(iE);
        }

        public final void e(r rVar, int i10, View view) {
            z zVarC = RecyclerView.C(view);
            if (zVarC.l()) {
                return;
            }
            if (zVarC.f() && !zVarC.g() && !this.f3962b.f3936w.hasStableIds()) {
                removeViewAt(i10);
                rVar.e(zVarC);
            } else {
                detachViewAt(i10);
                rVar.f(view);
                this.f3962b.f3924q.onViewDetached(zVarC);
            }
        }

        public final void f(RecyclerView recyclerView) {
            g(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public View findContainingItemView(View view) {
            View viewFindContainingItemView;
            RecyclerView recyclerView = this.f3962b;
            if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || this.f3961a.i(viewFindContainingItemView)) {
                return null;
            }
            return viewFindContainingItemView;
        }

        public View findViewByPosition(int i10) {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                z zVarC = RecyclerView.C(childAt);
                if (zVarC != null && zVarC.getLayoutPosition() == i10 && !zVarC.l() && (this.f3962b.f3927r0.isPreLayout() || !zVarC.g())) {
                    return childAt;
                }
            }
            return null;
        }

        public final void g(int i10, int i11) {
            this.f3974n = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            this.f3972l = mode;
            if (mode == 0 && !RecyclerView.L0) {
                this.f3974n = 0;
            }
            this.f3975o = View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f3973m = mode2;
            if (mode2 != 0 || RecyclerView.L0) {
                return;
            }
            this.f3975o = 0;
        }

        public abstract m generateDefaultLayoutParams();

        public m generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof m ? new m((m) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new m((ViewGroup.MarginLayoutParams) layoutParams) : new m(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((m) view.getLayoutParams()).f3983b.bottom;
        }

        public View getChildAt(int i10) {
            androidx.recyclerview.widget.b bVar = this.f3961a;
            if (bVar != null) {
                return bVar.c(i10);
            }
            return null;
        }

        public int getChildCount() {
            androidx.recyclerview.widget.b bVar = this.f3961a;
            if (bVar != null) {
                return bVar.d();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.f3962b;
            return recyclerView != null && recyclerView.f3926r;
        }

        public int getColumnCountForAccessibility(r rVar, w wVar) {
            return -1;
        }

        public int getDecoratedBottom(View view) {
            return getBottomDecorationHeight(view) + view.getBottom();
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.D(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((m) view.getLayoutParams()).f3983b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((m) view.getLayoutParams()).f3983b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return getRightDecorationWidth(view) + view.getRight();
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.f3962b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f3961a.i(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.f3975o;
        }

        public int getHeightMode() {
            return this.f3973m;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.f3962b;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getLayoutDirection() {
            return j0.getLayoutDirection(this.f3962b);
        }

        public int getLeftDecorationWidth(View view) {
            return ((m) view.getLayoutParams()).f3983b.left;
        }

        public int getMinimumHeight() {
            return j0.getMinimumHeight(this.f3962b);
        }

        public int getMinimumWidth() {
            return j0.getMinimumWidth(this.f3962b);
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.f3962b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.f3962b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.f3962b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.f3962b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((m) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(View view) {
            return ((m) view.getLayoutParams()).f3983b.right;
        }

        public int getRowCountForAccessibility(r rVar, w wVar) {
            return -1;
        }

        public int getSelectionModeForAccessibility(r rVar, w wVar) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((m) view.getLayoutParams()).f3983b.top;
        }

        public void getTransformedBoundingBox(View view, boolean z10, Rect rect) {
            Matrix matrix;
            if (z10) {
                Rect rect2 = ((m) view.getLayoutParams()).f3983b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f3962b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f3962b.f3934v;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.f3974n;
        }

        public int getWidthMode() {
            return this.f3972l;
        }

        public final void h(int i10, int i11) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.f3962b.k(i10, i11);
                return;
            }
            int i12 = Integer.MAX_VALUE;
            int i13 = Integer.MAX_VALUE;
            int i14 = Integer.MIN_VALUE;
            int i15 = Integer.MIN_VALUE;
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = getChildAt(i16);
                Rect rect = this.f3962b.f3930t;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i17 = rect.left;
                if (i17 < i12) {
                    i12 = i17;
                }
                int i18 = rect.right;
                if (i18 > i14) {
                    i14 = i18;
                }
                int i19 = rect.top;
                if (i19 < i13) {
                    i13 = i19;
                }
                int i20 = rect.bottom;
                if (i20 > i15) {
                    i15 = i20;
                }
            }
            this.f3962b.f3930t.set(i12, i13, i14, i15);
            setMeasuredDimension(this.f3962b.f3930t, i10, i11);
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.f3962b;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public final void i(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f3962b = null;
                this.f3961a = null;
                this.f3974n = 0;
                this.f3975o = 0;
            } else {
                this.f3962b = recyclerView;
                this.f3961a = recyclerView.f3922p;
                this.f3974n = recyclerView.getWidth();
                this.f3975o = recyclerView.getHeight();
            }
            this.f3972l = 1073741824;
            this.f3973m = 1073741824;
        }

        public boolean isAttachedToWindow() {
            return this.f3967g;
        }

        public boolean isAutoMeasureEnabled() {
            return false;
        }

        public final boolean isItemPrefetchEnabled() {
            return this.f3969i;
        }

        public boolean isLayoutHierarchical(r rVar, w wVar) {
            return false;
        }

        public boolean isSmoothScrolling() {
            v vVar = this.f3965e;
            return vVar != null && vVar.isRunning();
        }

        public boolean isViewPartiallyVisible(View view, boolean z10, boolean z11) {
            boolean z12 = this.f3963c.b(view) && this.f3964d.b(view);
            return z10 ? z12 : !z12;
        }

        public final boolean j(View view, int i10, int i11, m mVar) {
            return (!view.isLayoutRequested() && this.f3968h && b(view.getWidth(), i10, ((ViewGroup.MarginLayoutParams) mVar).width) && b(view.getHeight(), i11, ((ViewGroup.MarginLayoutParams) mVar).height)) ? false : true;
        }

        public boolean k() {
            return false;
        }

        public final boolean l(View view, int i10, int i11, m mVar) {
            return (this.f3968h && b(view.getMeasuredWidth(), i10, ((ViewGroup.MarginLayoutParams) mVar).width) && b(view.getMeasuredHeight(), i11, ((ViewGroup.MarginLayoutParams) mVar).height)) ? false : true;
        }

        public void layoutDecoratedWithMargins(View view, int i10, int i11, int i12, int i13) {
            m mVar = (m) view.getLayoutParams();
            Rect rect = mVar.f3983b;
            view.layout(i10 + rect.left + ((ViewGroup.MarginLayoutParams) mVar).leftMargin, i11 + rect.top + ((ViewGroup.MarginLayoutParams) mVar).topMargin, (i12 - rect.right) - ((ViewGroup.MarginLayoutParams) mVar).rightMargin, (i13 - rect.bottom) - ((ViewGroup.MarginLayoutParams) mVar).bottomMargin);
        }

        public void measureChildWithMargins(View view, int i10, int i11) {
            m mVar = (m) view.getLayoutParams();
            Rect rectE = this.f3962b.E(view);
            int i12 = rectE.left + rectE.right + i10;
            int i13 = rectE.top + rectE.bottom + i11;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin + i12, ((ViewGroup.MarginLayoutParams) mVar).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin + i13, ((ViewGroup.MarginLayoutParams) mVar).height, canScrollVertically());
            if (j(view, childMeasureSpec, childMeasureSpec2, mVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i10, int i11) {
            View childAt = getChildAt(i10);
            if (childAt != null) {
                detachViewAt(i10);
                attachView(childAt, i11);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i10 + this.f3962b.toString());
            }
        }

        public void offsetChildrenHorizontal(int i10) {
            RecyclerView recyclerView = this.f3962b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i10);
            }
        }

        public void offsetChildrenVertical(int i10) {
            RecyclerView recyclerView = this.f3962b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i10);
            }
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i10, int i11) {
            return false;
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public View onFocusSearchFailed(View view, int i10, r rVar, w wVar) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f3962b;
            onInitializeAccessibilityEvent(recyclerView.f3916m, recyclerView.f3927r0, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(r rVar, w wVar, y0.d dVar) {
            if (this.f3962b.canScrollVertically(-1) || this.f3962b.canScrollHorizontally(-1)) {
                dVar.addAction(8192);
                dVar.setScrollable(true);
            }
            if (this.f3962b.canScrollVertically(1) || this.f3962b.canScrollHorizontally(1)) {
                dVar.addAction(4096);
                dVar.setScrollable(true);
            }
            dVar.setCollectionInfo(d.e.obtain(getRowCountForAccessibility(rVar, wVar), getColumnCountForAccessibility(rVar, wVar), isLayoutHierarchical(rVar, wVar), getSelectionModeForAccessibility(rVar, wVar)));
        }

        public View onInterceptFocusSearch(View view, int i10) {
            return null;
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11) {
        }

        public void onLayoutChildren(r rVar, w wVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onMeasure(r rVar, w wVar, int i10, int i11) {
            this.f3962b.k(i10, i11);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean performAccessibilityAction(r rVar, w wVar, int i10, Bundle bundle) {
            int height;
            int width;
            int i11;
            int i12;
            RecyclerView recyclerView = this.f3962b;
            if (recyclerView == null) {
                return false;
            }
            if (i10 == 4096) {
                height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.f3962b.canScrollHorizontally(1)) {
                    width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    i11 = height;
                    i12 = width;
                }
                i11 = height;
                i12 = 0;
            } else if (i10 != 8192) {
                i12 = 0;
                i11 = 0;
            } else {
                height = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.f3962b.canScrollHorizontally(-1)) {
                    width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    i11 = height;
                    i12 = width;
                }
                i11 = height;
                i12 = 0;
            }
            if (i11 == 0 && i12 == 0) {
                return false;
            }
            this.f3962b.U(i12, i11, null, Integer.MIN_VALUE, true);
            return true;
        }

        public boolean performAccessibilityActionForItem(r rVar, w wVar, View view, int i10, Bundle bundle) {
            return false;
        }

        public void removeAndRecycleAllViews(r rVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.C(getChildAt(childCount)).l()) {
                    removeAndRecycleViewAt(childCount, rVar);
                }
            }
        }

        public void removeAndRecycleView(View view, r rVar) {
            removeView(view);
            rVar.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i10, r rVar) {
            View childAt = getChildAt(i10);
            removeViewAt(i10);
            rVar.recycleView(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.f3962b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeView(View view) {
            androidx.recyclerview.widget.b bVar = this.f3961a;
            androidx.recyclerview.widget.q qVar = (androidx.recyclerview.widget.q) bVar.f4112a;
            int iIndexOfChild = qVar.indexOfChild(view);
            if (iIndexOfChild < 0) {
                return;
            }
            if (bVar.f4113b.f(iIndexOfChild)) {
                bVar.j(view);
            }
            qVar.removeViewAt(iIndexOfChild);
        }

        public void removeViewAt(int i10) {
            androidx.recyclerview.widget.b bVar;
            int iE;
            androidx.recyclerview.widget.q qVar;
            View childAt;
            if (getChildAt(i10) == null || (childAt = (qVar = (androidx.recyclerview.widget.q) bVar.f4112a).getChildAt((iE = (bVar = this.f3961a).e(i10)))) == null) {
                return;
            }
            if (bVar.f4113b.f(iE)) {
                bVar.j(childAt);
            }
            qVar.removeViewAt(iE);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean requestChildRectangleOnScreen(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
            /*
                r8 = this;
                int r0 = r8.getPaddingLeft()
                int r1 = r8.getPaddingTop()
                int r2 = r8.getWidth()
                int r3 = r8.getPaddingRight()
                int r2 = r2 - r3
                int r3 = r8.getHeight()
                int r4 = r8.getPaddingBottom()
                int r3 = r3 - r4
                int r4 = r10.getLeft()
                int r5 = r11.left
                int r4 = r4 + r5
                int r5 = r10.getScrollX()
                int r4 = r4 - r5
                int r5 = r10.getTop()
                int r6 = r11.top
                int r5 = r5 + r6
                int r10 = r10.getScrollY()
                int r5 = r5 - r10
                int r10 = r11.width()
                int r10 = r10 + r4
                int r11 = r11.height()
                int r11 = r11 + r5
                int r4 = r4 - r0
                r0 = 0
                int r6 = java.lang.Math.min(r0, r4)
                int r5 = r5 - r1
                int r1 = java.lang.Math.min(r0, r5)
                int r10 = r10 - r2
                int r2 = java.lang.Math.max(r0, r10)
                int r11 = r11 - r3
                int r11 = java.lang.Math.max(r0, r11)
                int r3 = r8.getLayoutDirection()
                r7 = 1
                if (r3 != r7) goto L60
                if (r2 == 0) goto L5b
                goto L68
            L5b:
                int r2 = java.lang.Math.max(r6, r10)
                goto L68
            L60:
                if (r6 == 0) goto L63
                goto L67
            L63:
                int r6 = java.lang.Math.min(r4, r2)
            L67:
                r2 = r6
            L68:
                if (r1 == 0) goto L6b
                goto L6f
            L6b:
                int r1 = java.lang.Math.min(r5, r11)
            L6f:
                if (r13 == 0) goto Lb2
                android.view.View r10 = r9.getFocusedChild()
                if (r10 != 0) goto L79
            L77:
                r10 = 0
                goto Lb0
            L79:
                int r11 = r8.getPaddingLeft()
                int r13 = r8.getPaddingTop()
                int r3 = r8.getWidth()
                int r4 = r8.getPaddingRight()
                int r3 = r3 - r4
                int r4 = r8.getHeight()
                int r5 = r8.getPaddingBottom()
                int r4 = r4 - r5
                androidx.recyclerview.widget.RecyclerView r5 = r8.f3962b
                android.graphics.Rect r5 = r5.f3930t
                r8.getDecoratedBoundsWithMargins(r10, r5)
                int r10 = r5.left
                int r10 = r10 - r2
                if (r10 >= r3) goto L77
                int r10 = r5.right
                int r10 = r10 - r2
                if (r10 <= r11) goto L77
                int r10 = r5.top
                int r10 = r10 - r1
                if (r10 >= r4) goto L77
                int r10 = r5.bottom
                int r10 = r10 - r1
                if (r10 > r13) goto Laf
                goto L77
            Laf:
                r10 = 1
            Lb0:
                if (r10 == 0) goto Lb7
            Lb2:
                if (r2 != 0) goto Lb8
                if (r1 == 0) goto Lb7
                goto Lb8
            Lb7:
                return r0
            Lb8:
                if (r12 == 0) goto Lbe
                r9.scrollBy(r2, r1)
                goto Lc1
            Lbe:
                r9.smoothScrollBy(r2, r1)
            Lc1:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.l.requestChildRectangleOnScreen(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.f3962b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.f3966f = true;
        }

        public int scrollHorizontallyBy(int i10, r rVar, w wVar) {
            return 0;
        }

        public int scrollVerticallyBy(int i10, r rVar, w wVar) {
            return 0;
        }

        public final void setItemPrefetchEnabled(boolean z10) {
            if (z10 != this.f3969i) {
                this.f3969i = z10;
                this.f3970j = 0;
                RecyclerView recyclerView = this.f3962b;
                if (recyclerView != null) {
                    recyclerView.f3916m.i();
                }
            }
        }

        public void setMeasuredDimension(Rect rect, int i10, int i11) {
            setMeasuredDimension(chooseSize(i10, getPaddingRight() + getPaddingLeft() + rect.width(), getMinimumWidth()), chooseSize(i11, getPaddingBottom() + getPaddingTop() + rect.height(), getMinimumHeight()));
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, w wVar, int i10) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(v vVar) {
            v vVar2 = this.f3965e;
            if (vVar2 != null && vVar != vVar2 && vVar2.isRunning()) {
                this.f3965e.stop();
            }
            this.f3965e = vVar;
            RecyclerView recyclerView = this.f3962b;
            vVar.getClass();
            recyclerView.f3921o0.stop();
            if (vVar.f4009h) {
                Log.w("RecyclerView", "An instance of " + vVar.getClass().getSimpleName() + " was started more than once. Each instance of" + vVar.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            vVar.f4003b = recyclerView;
            vVar.f4004c = this;
            int i10 = vVar.f4002a;
            if (i10 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.f3927r0.f4017a = i10;
            vVar.f4006e = true;
            vVar.f4005d = true;
            vVar.f4007f = vVar.findViewByPosition(vVar.getTargetPosition());
            vVar.onStart();
            vVar.f4003b.f3921o0.a();
            vVar.f4009h = true;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public void addDisappearingView(View view, int i10) {
            a(view, true, i10);
        }

        public void addView(View view, int i10) {
            a(view, false, i10);
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, r rVar) {
            onDetachedFromWindow(recyclerView);
        }

        public void onInitializeAccessibilityEvent(r rVar, w wVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f3962b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z10 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f3962b.canScrollVertically(-1) && !this.f3962b.canScrollHorizontally(-1) && !this.f3962b.canScrollHorizontally(1)) {
                z10 = false;
            }
            accessibilityEvent.setScrollable(z10);
            Adapter adapter = this.f3962b.f3936w;
            if (adapter != null) {
                accessibilityEvent.setItemCount(adapter.getItemCount());
            }
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
            onItemsUpdated(recyclerView, i10, i11);
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, w wVar, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public m generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new m(context, attributeSet);
        }

        public void setMeasuredDimension(int i10, int i11) {
            this.f3962b.setMeasuredDimension(i10, i11);
        }

        public void attachView(View view, int i10) {
            attachView(view, i10, (m) view.getLayoutParams());
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onLayoutCompleted(w wVar) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public void onScrollStateChanged(int i10) {
        }

        public void scrollToPosition(int i10) {
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z10, false);
        }

        public void collectInitialPrefetchPositions(int i10, c cVar) {
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        }

        public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        }

        public void collectAdjacentPrefetchPositions(int i10, int i11, w wVar, c cVar) {
        }

        public void onInitializeAccessibilityNodeInfoForItem(r rVar, w wVar, View view, y0.d dVar) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        }
    }

    public static abstract class n {
        public abstract boolean onFling(int i10, int i11);
    }

    public interface o {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z10);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static class q {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray<a> f3986a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        public int f3987b = 0;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final ArrayList<z> f3988a = new ArrayList<>();

            /* renamed from: b, reason: collision with root package name */
            public int f3989b = 5;

            /* renamed from: c, reason: collision with root package name */
            public long f3990c = 0;

            /* renamed from: d, reason: collision with root package name */
            public long f3991d = 0;
        }

        public final a a(int i10) {
            SparseArray<a> sparseArray = this.f3986a;
            a aVar = sparseArray.get(i10);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            sparseArray.put(i10, aVar2);
            return aVar2;
        }

        public void clear() {
            int i10 = 0;
            while (true) {
                SparseArray<a> sparseArray = this.f3986a;
                if (i10 >= sparseArray.size()) {
                    return;
                }
                sparseArray.valueAt(i10).f3988a.clear();
                i10++;
            }
        }

        public z getRecycledView(int i10) {
            a aVar = this.f3986a.get(i10);
            if (aVar == null) {
                return null;
            }
            ArrayList<z> arrayList = aVar.f3988a;
            if (arrayList.isEmpty()) {
                return null;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).d()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public void putRecycledView(z zVar) {
            int itemViewType = zVar.getItemViewType();
            ArrayList<z> arrayList = a(itemViewType).f3988a;
            if (this.f3986a.get(itemViewType).f3989b <= arrayList.size()) {
                return;
            }
            zVar.k();
            arrayList.add(zVar);
        }

        public void setMaxRecycledViews(int i10, int i11) {
            a aVarA = a(i10);
            aVarA.f3989b = i11;
            ArrayList<z> arrayList = aVarA.f3988a;
            while (arrayList.size() > i11) {
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    public final class r {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList<z> f3992a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<z> f3993b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList<z> f3994c;

        /* renamed from: d, reason: collision with root package name */
        public final List<z> f3995d;

        /* renamed from: e, reason: collision with root package name */
        public int f3996e;

        /* renamed from: f, reason: collision with root package name */
        public int f3997f;

        /* renamed from: g, reason: collision with root package name */
        public q f3998g;

        public r() {
            ArrayList<z> arrayList = new ArrayList<>();
            this.f3992a = arrayList;
            this.f3993b = null;
            this.f3994c = new ArrayList<>();
            this.f3995d = Collections.unmodifiableList(arrayList);
            this.f3996e = 2;
            this.f3997f = 2;
        }

        public final void a(z zVar, boolean z10) {
            RecyclerView.g(zVar);
            RecyclerView recyclerView = RecyclerView.this;
            androidx.recyclerview.widget.s sVar = recyclerView.f3941y0;
            if (sVar != null) {
                x0.a itemDelegate = sVar.getItemDelegate();
                boolean z11 = itemDelegate instanceof s.a;
                View view = zVar.f4041a;
                j0.setAccessibilityDelegate(view, z11 ? (x0.a) ((s.a) itemDelegate).f4247e.remove(view) : null);
            }
            if (z10) {
                s sVar2 = recyclerView.f3940y;
                if (sVar2 != null) {
                    sVar2.onViewRecycled(zVar);
                }
                ArrayList arrayList = recyclerView.f3942z;
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((s) arrayList.get(i10)).onViewRecycled(zVar);
                }
                Adapter adapter = recyclerView.f3936w;
                if (adapter != null) {
                    adapter.onViewRecycled(zVar);
                }
                if (recyclerView.f3927r0 != null) {
                    recyclerView.f3924q.d(zVar);
                }
            }
            zVar.f4059s = null;
            zVar.f4058r = null;
            b().putRecycledView(zVar);
        }

        public final q b() {
            if (this.f3998g == null) {
                this.f3998g = new q();
            }
            return this.f3998g;
        }

        public final void c() {
            ArrayList<z> arrayList = this.f3994c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                d(size);
            }
            arrayList.clear();
            if (RecyclerView.N0) {
                k.b bVar = RecyclerView.this.f3925q0;
                int[] iArr = bVar.f4211c;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                bVar.f4212d = 0;
            }
        }

        public void clear() {
            this.f3992a.clear();
            c();
        }

        public int convertPreLayoutPositionToPostLayout(int i10) {
            RecyclerView recyclerView = RecyclerView.this;
            if (i10 >= 0 && i10 < recyclerView.f3927r0.getItemCount()) {
                return !recyclerView.f3927r0.isPreLayout() ? i10 : recyclerView.f3920o.f(i10, 0);
            }
            StringBuilder sbS = ac.c.s("invalid position ", i10, ". State item count is ");
            sbS.append(recyclerView.f3927r0.getItemCount());
            sbS.append(recyclerView.u());
            throw new IndexOutOfBoundsException(sbS.toString());
        }

        public final void d(int i10) {
            ArrayList<z> arrayList = this.f3994c;
            a(arrayList.get(i10), true);
            arrayList.remove(i10);
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x008d A[LOOP:1: B:53:0x008d->B:92:?, LOOP_START, PHI: r5
  0x008d: PHI (r5v4 int) = (r5v2 int), (r5v5 int) binds: [B:52:0x008b, B:92:?] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void e(androidx.recyclerview.widget.RecyclerView.z r12) {
            /*
                Method dump skipped, instructions count: 306
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.r.e(androidx.recyclerview.widget.RecyclerView$z):void");
        }

        public final void f(View view) {
            z zVarC = RecyclerView.C(view);
            int i10 = zVarC.f4050j;
            boolean z10 = (i10 & 12) != 0;
            RecyclerView recyclerView = RecyclerView.this;
            if (!z10) {
                if ((i10 & 2) != 0) {
                    i iVar = recyclerView.W;
                    if (!(iVar == null || iVar.canReuseUpdatedViewHolder(zVarC, zVarC.c()))) {
                        if (this.f3993b == null) {
                            this.f3993b = new ArrayList<>();
                        }
                        zVarC.f4054n = this;
                        zVarC.f4055o = true;
                        this.f3993b.add(zVarC);
                        return;
                    }
                }
            }
            if (zVarC.f() && !zVarC.g() && !recyclerView.f3936w.hasStableIds()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + recyclerView.u());
            }
            zVarC.f4054n = this;
            zVarC.f4055o = false;
            this.f3992a.add(zVarC);
        }

        /* JADX WARN: Removed duplicated region for block: B:216:0x03d4  */
        /* JADX WARN: Removed duplicated region for block: B:260:0x048c  */
        /* JADX WARN: Removed duplicated region for block: B:261:0x0496  */
        /* JADX WARN: Removed duplicated region for block: B:269:0x04b0  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0088  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final androidx.recyclerview.widget.RecyclerView.z g(long r20, int r22) {
            /*
                Method dump skipped, instructions count: 1240
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.r.g(long, int):androidx.recyclerview.widget.RecyclerView$z");
        }

        public List<z> getScrapList() {
            return this.f3995d;
        }

        public View getViewForPosition(int i10) {
            return g(Long.MAX_VALUE, i10).f4041a;
        }

        public final void h(z zVar) {
            if (zVar.f4055o) {
                this.f3993b.remove(zVar);
            } else {
                this.f3992a.remove(zVar);
            }
            zVar.f4054n = null;
            zVar.f4055o = false;
            zVar.f4050j &= -33;
        }

        public final void i() {
            l lVar = RecyclerView.this.f3938x;
            this.f3997f = this.f3996e + (lVar != null ? lVar.f3970j : 0);
            ArrayList<z> arrayList = this.f3994c;
            for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f3997f; size--) {
                d(size);
            }
        }

        public void recycleView(View view) {
            z zVarC = RecyclerView.C(view);
            boolean zI = zVarC.i();
            RecyclerView recyclerView = RecyclerView.this;
            if (zI) {
                recyclerView.removeDetachedView(view, false);
            }
            if (zVarC.h()) {
                zVarC.f4054n.h(zVarC);
            } else if (zVarC.m()) {
                zVarC.f4050j &= -33;
            }
            e(zVarC);
            if (recyclerView.W == null || zVarC.isRecyclable()) {
                return;
            }
            recyclerView.W.endAnimation(zVarC);
        }

        public void setViewCacheSize(int i10) {
            this.f3996e = i10;
            i();
        }
    }

    public interface s {
        void onViewRecycled(z zVar);
    }

    public class t extends f {
        public t() {
        }

        public final void a() {
            boolean z10 = RecyclerView.M0;
            RecyclerView recyclerView = RecyclerView.this;
            if (z10 && recyclerView.E && recyclerView.D) {
                j0.postOnAnimation(recyclerView, recyclerView.f3928s);
            } else {
                recyclerView.L = true;
                recyclerView.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f
        public void onChanged() {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f(null);
            recyclerView.f3927r0.f4022f = true;
            recyclerView.N(true);
            if (recyclerView.f3920o.g()) {
                return;
            }
            recyclerView.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f
        public void onItemRangeChanged(int i10, int i11, Object obj) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f(null);
            androidx.recyclerview.widget.a aVar = recyclerView.f3920o;
            boolean z10 = false;
            if (i11 < 1) {
                aVar.getClass();
            } else {
                ArrayList<a.b> arrayList = aVar.f4103b;
                arrayList.add(aVar.obtainUpdateOp(4, i10, i11, obj));
                aVar.f4107f |= 4;
                z10 = arrayList.size() == 1;
            }
            if (z10) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f
        public void onItemRangeInserted(int i10, int i11) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f(null);
            androidx.recyclerview.widget.a aVar = recyclerView.f3920o;
            boolean z10 = false;
            if (i11 < 1) {
                aVar.getClass();
            } else {
                ArrayList<a.b> arrayList = aVar.f4103b;
                arrayList.add(aVar.obtainUpdateOp(1, i10, i11, null));
                aVar.f4107f |= 1;
                z10 = arrayList.size() == 1;
            }
            if (z10) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f
        public void onItemRangeRemoved(int i10, int i11) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f(null);
            androidx.recyclerview.widget.a aVar = recyclerView.f3920o;
            boolean z10 = false;
            if (i11 < 1) {
                aVar.getClass();
            } else {
                ArrayList<a.b> arrayList = aVar.f4103b;
                arrayList.add(aVar.obtainUpdateOp(2, i10, i11, null));
                aVar.f4107f |= 2;
                z10 = arrayList.size() == 1;
            }
            if (z10) {
                a();
            }
        }
    }

    public static abstract class v {

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView f4003b;

        /* renamed from: c, reason: collision with root package name */
        public l f4004c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f4005d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f4006e;

        /* renamed from: f, reason: collision with root package name */
        public View f4007f;

        /* renamed from: h, reason: collision with root package name */
        public boolean f4009h;

        /* renamed from: a, reason: collision with root package name */
        public int f4002a = -1;

        /* renamed from: g, reason: collision with root package name */
        public final a f4008g = new a(0, 0);

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public int f4010a;

            /* renamed from: b, reason: collision with root package name */
            public int f4011b;

            /* renamed from: c, reason: collision with root package name */
            public int f4012c;

            /* renamed from: d, reason: collision with root package name */
            public int f4013d;

            /* renamed from: e, reason: collision with root package name */
            public Interpolator f4014e;

            /* renamed from: f, reason: collision with root package name */
            public boolean f4015f;

            /* renamed from: g, reason: collision with root package name */
            public int f4016g;

            public a(int i10, int i11) {
                this(i10, i11, Integer.MIN_VALUE, null);
            }

            public final void a(RecyclerView recyclerView) {
                int i10 = this.f4013d;
                if (i10 >= 0) {
                    this.f4013d = -1;
                    recyclerView.F(i10);
                    this.f4015f = false;
                    return;
                }
                if (!this.f4015f) {
                    this.f4016g = 0;
                    return;
                }
                Interpolator interpolator = this.f4014e;
                if (interpolator != null && this.f4012c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                int i11 = this.f4012c;
                if (i11 < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
                recyclerView.f3921o0.smoothScrollBy(this.f4010a, this.f4011b, i11, interpolator);
                int i12 = this.f4016g + 1;
                this.f4016g = i12;
                if (i12 > 10) {
                    Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                this.f4015f = false;
            }

            public void jumpTo(int i10) {
                this.f4013d = i10;
            }

            public void update(int i10, int i11, int i12, Interpolator interpolator) {
                this.f4010a = i10;
                this.f4011b = i11;
                this.f4012c = i12;
                this.f4014e = interpolator;
                this.f4015f = true;
            }

            public a(int i10, int i11, int i12, Interpolator interpolator) {
                this.f4013d = -1;
                this.f4015f = false;
                this.f4016g = 0;
                this.f4010a = i10;
                this.f4011b = i11;
                this.f4012c = i12;
                this.f4014e = interpolator;
            }
        }

        public interface b {
            PointF computeScrollVectorForPosition(int i10);
        }

        public final void a(int i10, int i11) {
            PointF pointFComputeScrollVectorForPosition;
            RecyclerView recyclerView = this.f4003b;
            if (this.f4002a == -1 || recyclerView == null) {
                stop();
            }
            if (this.f4005d && this.f4007f == null && this.f4004c != null && (pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(this.f4002a)) != null) {
                float f10 = pointFComputeScrollVectorForPosition.x;
                if (f10 != 0.0f || pointFComputeScrollVectorForPosition.y != 0.0f) {
                    recyclerView.S((int) Math.signum(f10), (int) Math.signum(pointFComputeScrollVectorForPosition.y), null);
                }
            }
            this.f4005d = false;
            View view = this.f4007f;
            a aVar = this.f4008g;
            if (view != null) {
                if (getChildPosition(view) == this.f4002a) {
                    onTargetFound(this.f4007f, recyclerView.f3927r0, aVar);
                    aVar.a(recyclerView);
                    stop();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f4007f = null;
                }
            }
            if (this.f4006e) {
                onSeekTargetStep(i10, i11, recyclerView.f3927r0, aVar);
                boolean z10 = aVar.f4013d >= 0;
                aVar.a(recyclerView);
                if (z10 && this.f4006e) {
                    this.f4005d = true;
                    recyclerView.f3921o0.a();
                }
            }
        }

        public PointF computeScrollVectorForPosition(int i10) {
            Object layoutManager = getLayoutManager();
            if (layoutManager instanceof b) {
                return ((b) layoutManager).computeScrollVectorForPosition(i10);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int i10) {
            return this.f4003b.f3938x.findViewByPosition(i10);
        }

        public int getChildCount() {
            return this.f4003b.f3938x.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.f4003b.getChildLayoutPosition(view);
        }

        public l getLayoutManager() {
            return this.f4004c;
        }

        public int getTargetPosition() {
            return this.f4002a;
        }

        public boolean isPendingInitialRun() {
            return this.f4005d;
        }

        public boolean isRunning() {
            return this.f4006e;
        }

        public void normalize(PointF pointF) {
            float f10 = pointF.x;
            float f11 = pointF.y;
            float fSqrt = (float) Math.sqrt((f11 * f11) + (f10 * f10));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.f4007f = view;
            }
        }

        public abstract void onSeekTargetStep(int i10, int i11, w wVar, a aVar);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(View view, w wVar, a aVar);

        public void setTargetPosition(int i10) {
            this.f4002a = i10;
        }

        public final void stop() {
            if (this.f4006e) {
                this.f4006e = false;
                onStop();
                this.f4003b.f3927r0.f4017a = -1;
                this.f4007f = null;
                this.f4002a = -1;
                this.f4005d = false;
                l lVar = this.f4004c;
                if (lVar.f3965e == this) {
                    lVar.f3965e = null;
                }
                this.f4004c = null;
                this.f4003b = null;
            }
        }
    }

    public static class w {

        /* renamed from: a, reason: collision with root package name */
        public int f4017a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f4018b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f4019c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f4020d = 1;

        /* renamed from: e, reason: collision with root package name */
        public int f4021e = 0;

        /* renamed from: f, reason: collision with root package name */
        public boolean f4022f = false;

        /* renamed from: g, reason: collision with root package name */
        public boolean f4023g = false;

        /* renamed from: h, reason: collision with root package name */
        public boolean f4024h = false;

        /* renamed from: i, reason: collision with root package name */
        public boolean f4025i = false;

        /* renamed from: j, reason: collision with root package name */
        public boolean f4026j = false;

        /* renamed from: k, reason: collision with root package name */
        public boolean f4027k = false;

        /* renamed from: l, reason: collision with root package name */
        public int f4028l;

        /* renamed from: m, reason: collision with root package name */
        public long f4029m;

        /* renamed from: n, reason: collision with root package name */
        public int f4030n;

        /* renamed from: o, reason: collision with root package name */
        public int f4031o;

        /* renamed from: p, reason: collision with root package name */
        public int f4032p;

        public final void a(int i10) {
            if ((this.f4020d & i10) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i10) + " but it is " + Integer.toBinaryString(this.f4020d));
        }

        public boolean didStructureChange() {
            return this.f4022f;
        }

        public int getItemCount() {
            return this.f4023g ? this.f4018b - this.f4019c : this.f4021e;
        }

        public int getRemainingScrollHorizontal() {
            return this.f4031o;
        }

        public int getRemainingScrollVertical() {
            return this.f4032p;
        }

        public int getTargetScrollPosition() {
            return this.f4017a;
        }

        public boolean hasTargetScrollPosition() {
            return this.f4017a != -1;
        }

        public boolean isPreLayout() {
            return this.f4023g;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f4017a + ", mData=null, mItemCount=" + this.f4021e + ", mIsMeasuring=" + this.f4025i + ", mPreviousLayoutItemCount=" + this.f4018b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f4019c + ", mStructureChanged=" + this.f4022f + ", mInPreLayout=" + this.f4023g + ", mRunSimpleAnimations=" + this.f4026j + ", mRunPredictiveAnimations=" + this.f4027k + '}';
        }

        public boolean willRunPredictiveAnimations() {
            return this.f4027k;
        }
    }

    public static abstract class x {
    }

    public class y implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public int f4033b;

        /* renamed from: m, reason: collision with root package name */
        public int f4034m;

        /* renamed from: n, reason: collision with root package name */
        public OverScroller f4035n;

        /* renamed from: o, reason: collision with root package name */
        public Interpolator f4036o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f4037p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f4038q;

        public y() {
            c cVar = RecyclerView.P0;
            this.f4036o = cVar;
            this.f4037p = false;
            this.f4038q = false;
            this.f4035n = new OverScroller(RecyclerView.this.getContext(), cVar);
        }

        public final void a() {
            if (this.f4037p) {
                this.f4038q = true;
                return;
            }
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.removeCallbacks(this);
            j0.postOnAnimation(recyclerView, this);
        }

        public void fling(int i10, int i11) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.setScrollState(2);
            this.f4034m = 0;
            this.f4033b = 0;
            Interpolator interpolator = this.f4036o;
            c cVar = RecyclerView.P0;
            if (interpolator != cVar) {
                this.f4036o = cVar;
                this.f4035n = new OverScroller(recyclerView.getContext(), cVar);
            }
            this.f4035n.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            int i11;
            int i12;
            int i13;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f3938x == null) {
                stop();
                return;
            }
            this.f4038q = false;
            this.f4037p = true;
            recyclerView.j();
            OverScroller overScroller = this.f4035n;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i14 = currX - this.f4033b;
                int i15 = currY - this.f4034m;
                this.f4033b = currX;
                this.f4034m = currY;
                int[] iArr = recyclerView.D0;
                iArr[0] = 0;
                iArr[1] = 0;
                boolean zDispatchNestedPreScroll = recyclerView.dispatchNestedPreScroll(i14, i15, iArr, null, 1);
                int[] iArr2 = recyclerView.D0;
                if (zDispatchNestedPreScroll) {
                    i14 -= iArr2[0];
                    i15 -= iArr2[1];
                }
                if (recyclerView.getOverScrollMode() != 2) {
                    recyclerView.i(i14, i15);
                }
                if (recyclerView.f3936w != null) {
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    recyclerView.S(i14, i15, iArr2);
                    int i16 = iArr2[0];
                    int i17 = iArr2[1];
                    int i18 = i14 - i16;
                    int i19 = i15 - i17;
                    v vVar = recyclerView.f3938x.f3965e;
                    if (vVar != null && !vVar.isPendingInitialRun() && vVar.isRunning()) {
                        int itemCount = recyclerView.f3927r0.getItemCount();
                        if (itemCount == 0) {
                            vVar.stop();
                        } else if (vVar.getTargetPosition() >= itemCount) {
                            vVar.setTargetPosition(itemCount - 1);
                            vVar.a(i16, i17);
                        } else {
                            vVar.a(i16, i17);
                        }
                    }
                    i13 = i16;
                    i10 = i18;
                    i11 = i19;
                    i12 = i17;
                } else {
                    i10 = i14;
                    i11 = i15;
                    i12 = 0;
                    i13 = 0;
                }
                if (!recyclerView.A.isEmpty()) {
                    recyclerView.invalidate();
                }
                int[] iArr3 = recyclerView.D0;
                iArr3[0] = 0;
                iArr3[1] = 0;
                int i20 = i12;
                recyclerView.dispatchNestedScroll(i13, i12, i10, i11, null, 1, iArr3);
                int i21 = i10 - iArr2[0];
                int i22 = i11 - iArr2[1];
                if (i13 != 0 || i20 != 0) {
                    recyclerView.p(i13, i20);
                }
                if (!recyclerView.awakenScrollBars()) {
                    recyclerView.invalidate();
                }
                boolean z10 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i21 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i22 != 0));
                v vVar2 = recyclerView.f3938x.f3965e;
                if ((vVar2 != null && vVar2.isPendingInitialRun()) || !z10) {
                    a();
                    androidx.recyclerview.widget.k kVar = recyclerView.f3923p0;
                    if (kVar != null) {
                        kVar.a(recyclerView, i13, i20);
                    }
                } else {
                    if (recyclerView.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i23 = i21 < 0 ? -currVelocity : i21 > 0 ? currVelocity : 0;
                        if (i22 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i22 <= 0) {
                            currVelocity = 0;
                        }
                        if (i23 < 0) {
                            recyclerView.r();
                            if (recyclerView.S.isFinished()) {
                                recyclerView.S.onAbsorb(-i23);
                            }
                        } else if (i23 > 0) {
                            recyclerView.s();
                            if (recyclerView.U.isFinished()) {
                                recyclerView.U.onAbsorb(i23);
                            }
                        }
                        if (currVelocity < 0) {
                            recyclerView.t();
                            if (recyclerView.T.isFinished()) {
                                recyclerView.T.onAbsorb(-currVelocity);
                            }
                        } else if (currVelocity > 0) {
                            recyclerView.q();
                            if (recyclerView.V.isFinished()) {
                                recyclerView.V.onAbsorb(currVelocity);
                            }
                        }
                        if (i23 != 0 || currVelocity != 0) {
                            j0.postInvalidateOnAnimation(recyclerView);
                        }
                    }
                    if (RecyclerView.N0) {
                        k.b bVar = recyclerView.f3925q0;
                        int[] iArr4 = bVar.f4211c;
                        if (iArr4 != null) {
                            Arrays.fill(iArr4, -1);
                        }
                        bVar.f4212d = 0;
                    }
                }
            }
            v vVar3 = recyclerView.f3938x.f3965e;
            if (vVar3 != null && vVar3.isPendingInitialRun()) {
                vVar3.a(0, 0);
            }
            this.f4037p = false;
            if (this.f4038q) {
                recyclerView.removeCallbacks(this);
                j0.postOnAnimation(recyclerView, this);
            } else {
                recyclerView.setScrollState(0);
                recyclerView.stopNestedScroll(1);
            }
        }

        public void smoothScrollBy(int i10, int i11, int i12, Interpolator interpolator) {
            RecyclerView recyclerView = RecyclerView.this;
            if (i12 == Integer.MIN_VALUE) {
                int iAbs = Math.abs(i10);
                int iAbs2 = Math.abs(i11);
                boolean z10 = iAbs > iAbs2;
                int width = z10 ? recyclerView.getWidth() : recyclerView.getHeight();
                if (!z10) {
                    iAbs = iAbs2;
                }
                i12 = Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
            }
            int i13 = i12;
            if (interpolator == null) {
                interpolator = RecyclerView.P0;
            }
            if (this.f4036o != interpolator) {
                this.f4036o = interpolator;
                this.f4035n = new OverScroller(recyclerView.getContext(), interpolator);
            }
            this.f4034m = 0;
            this.f4033b = 0;
            recyclerView.setScrollState(2);
            this.f4035n.startScroll(0, 0, i10, i11, i13);
            if (Build.VERSION.SDK_INT < 23) {
                this.f4035n.computeScrollOffset();
            }
            a();
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.f4035n.abortAnimation();
        }
    }

    public static abstract class z {

        /* renamed from: t, reason: collision with root package name */
        public static final List<Object> f4040t = Collections.emptyList();

        /* renamed from: a, reason: collision with root package name */
        public final View f4041a;

        /* renamed from: b, reason: collision with root package name */
        public WeakReference<RecyclerView> f4042b;

        /* renamed from: j, reason: collision with root package name */
        public int f4050j;

        /* renamed from: r, reason: collision with root package name */
        public RecyclerView f4058r;

        /* renamed from: s, reason: collision with root package name */
        public Adapter<? extends z> f4059s;

        /* renamed from: c, reason: collision with root package name */
        public int f4043c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f4044d = -1;

        /* renamed from: e, reason: collision with root package name */
        public long f4045e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f4046f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f4047g = -1;

        /* renamed from: h, reason: collision with root package name */
        public z f4048h = null;

        /* renamed from: i, reason: collision with root package name */
        public z f4049i = null;

        /* renamed from: k, reason: collision with root package name */
        public ArrayList f4051k = null;

        /* renamed from: l, reason: collision with root package name */
        public List<Object> f4052l = null;

        /* renamed from: m, reason: collision with root package name */
        public int f4053m = 0;

        /* renamed from: n, reason: collision with root package name */
        public r f4054n = null;

        /* renamed from: o, reason: collision with root package name */
        public boolean f4055o = false;

        /* renamed from: p, reason: collision with root package name */
        public int f4056p = 0;

        /* renamed from: q, reason: collision with root package name */
        public int f4057q = -1;

        public z(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f4041a = view;
        }

        public final void a(Object obj) {
            if (obj == null) {
                b(1024);
                return;
            }
            if ((1024 & this.f4050j) == 0) {
                if (this.f4051k == null) {
                    ArrayList arrayList = new ArrayList();
                    this.f4051k = arrayList;
                    this.f4052l = Collections.unmodifiableList(arrayList);
                }
                this.f4051k.add(obj);
            }
        }

        public final void b(int i10) {
            this.f4050j = i10 | this.f4050j;
        }

        public final List<Object> c() {
            ArrayList arrayList;
            return ((this.f4050j & 1024) != 0 || (arrayList = this.f4051k) == null || arrayList.size() == 0) ? f4040t : this.f4052l;
        }

        public final boolean d() {
            View view = this.f4041a;
            return (view.getParent() == null || view.getParent() == this.f4058r) ? false : true;
        }

        public final boolean e() {
            return (this.f4050j & 1) != 0;
        }

        public final boolean f() {
            return (this.f4050j & 4) != 0;
        }

        public final boolean g() {
            return (this.f4050j & 8) != 0;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.f4058r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.A(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int iA;
            if (this.f4059s == null || (recyclerView = this.f4058r) == null || (adapter = recyclerView.getAdapter()) == null || (iA = this.f4058r.A(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.f4059s, this, iA);
        }

        public final long getItemId() {
            return this.f4045e;
        }

        public final int getItemViewType() {
            return this.f4046f;
        }

        public final int getLayoutPosition() {
            int i10 = this.f4047g;
            return i10 == -1 ? this.f4043c : i10;
        }

        public final int getOldPosition() {
            return this.f4044d;
        }

        public final boolean h() {
            return this.f4054n != null;
        }

        public final boolean i() {
            return (this.f4050j & 256) != 0;
        }

        public final boolean isRecyclable() {
            return (this.f4050j & 16) == 0 && !j0.hasTransientState(this.f4041a);
        }

        public final void j(int i10, boolean z10) {
            if (this.f4044d == -1) {
                this.f4044d = this.f4043c;
            }
            if (this.f4047g == -1) {
                this.f4047g = this.f4043c;
            }
            if (z10) {
                this.f4047g += i10;
            }
            this.f4043c += i10;
            View view = this.f4041a;
            if (view.getLayoutParams() != null) {
                ((m) view.getLayoutParams()).f3984c = true;
            }
        }

        public final void k() {
            this.f4050j = 0;
            this.f4043c = -1;
            this.f4044d = -1;
            this.f4045e = -1L;
            this.f4047g = -1;
            this.f4053m = 0;
            this.f4048h = null;
            this.f4049i = null;
            ArrayList arrayList = this.f4051k;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.f4050j &= -1025;
            this.f4056p = 0;
            this.f4057q = -1;
            RecyclerView.g(this);
        }

        public final boolean l() {
            return (this.f4050j & 128) != 0;
        }

        public final boolean m() {
            return (this.f4050j & 32) != 0;
        }

        public final void setIsRecyclable(boolean z10) {
            int i10 = this.f4053m;
            int i11 = z10 ? i10 - 1 : i10 + 1;
            this.f4053m = i11;
            if (i11 < 0) {
                this.f4053m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z10 && i11 == 1) {
                this.f4050j |= 16;
            } else if (z10 && i11 == 0) {
                this.f4050j &= -17;
            }
        }

        public String toString() {
            StringBuilder sbU = ac.c.u(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
            sbU.append(Integer.toHexString(hashCode()));
            sbU.append(" position=");
            sbU.append(this.f4043c);
            sbU.append(" id=");
            sbU.append(this.f4045e);
            sbU.append(", oldPos=");
            sbU.append(this.f4044d);
            sbU.append(", pLpos:");
            sbU.append(this.f4047g);
            StringBuilder sb2 = new StringBuilder(sbU.toString());
            if (h()) {
                sb2.append(" scrap ");
                sb2.append(this.f4055o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (f()) {
                sb2.append(" invalid");
            }
            if (!e()) {
                sb2.append(" unbound");
            }
            boolean z10 = true;
            if ((this.f4050j & 2) != 0) {
                sb2.append(" update");
            }
            if (g()) {
                sb2.append(" removed");
            }
            if (l()) {
                sb2.append(" ignored");
            }
            if (i()) {
                sb2.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb2.append(" not recyclable(" + this.f4053m + ")");
            }
            if ((this.f4050j & 512) == 0 && !f()) {
                z10 = false;
            }
            if (z10) {
                sb2.append(" undefined adapter position");
            }
            if (this.f4041a.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }
    }

    static {
        L0 = Build.VERSION.SDK_INT >= 23;
        M0 = true;
        N0 = true;
        Class<?> cls = Integer.TYPE;
        O0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        P0 = new c();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.recyclerview.R.attr.recyclerViewStyle);
    }

    public static z C(View view) {
        if (view == null) {
            return null;
        }
        return ((m) view.getLayoutParams()).f3982a;
    }

    public static void D(View view, Rect rect) {
        m mVar = (m) view.getLayoutParams();
        Rect rect2 = mVar.f3983b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) mVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) mVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) mVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin);
    }

    private void T(Adapter adapter, boolean z10, boolean z11) {
        Adapter adapter2 = this.f3936w;
        t tVar = this.f3904b;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(tVar);
            this.f3936w.onDetachedFromRecyclerView(this);
        }
        r rVar = this.f3916m;
        if (!z10 || z11) {
            i iVar = this.W;
            if (iVar != null) {
                iVar.endAnimations();
            }
            l lVar = this.f3938x;
            if (lVar != null) {
                lVar.removeAndRecycleAllViews(rVar);
                this.f3938x.d(rVar);
            }
            rVar.clear();
        }
        androidx.recyclerview.widget.a aVar = this.f3920o;
        aVar.j(aVar.f4103b);
        aVar.j(aVar.f4104c);
        aVar.f4107f = 0;
        Adapter adapter3 = this.f3936w;
        this.f3936w = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(tVar);
            adapter.onAttachedToRecyclerView(this);
        }
        l lVar2 = this.f3938x;
        if (lVar2 != null) {
            lVar2.onAdapterChanged(adapter3, this.f3936w);
        }
        Adapter adapter4 = this.f3936w;
        rVar.clear();
        q qVarB = rVar.b();
        if (adapter3 != null) {
            qVarB.f3987b--;
        }
        if (!z10 && qVarB.f3987b == 0) {
            qVarB.clear();
        }
        if (adapter4 != null) {
            qVarB.f3987b++;
        } else {
            qVarB.getClass();
        }
        this.f3927r0.f4022f = true;
    }

    public static void g(z zVar) {
        WeakReference<RecyclerView> weakReference = zVar.f4042b;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == zVar.f4041a) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            zVar.f4042b = null;
        }
    }

    private x0.r getScrollingChildHelper() {
        if (this.A0 == null) {
            this.A0 = new x0.r(this);
        }
        return this.A0;
    }

    public static RecyclerView y(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView recyclerViewY = y(viewGroup.getChildAt(i10));
            if (recyclerViewY != null) {
                return recyclerViewY;
            }
        }
        return null;
    }

    public final int A(z zVar) {
        if (((zVar.f4050j & 524) != 0) || !zVar.e()) {
            return -1;
        }
        return this.f3920o.applyPendingUpdatesToPosition(zVar.f4043c);
    }

    public final long B(z zVar) {
        return this.f3936w.hasStableIds() ? zVar.getItemId() : zVar.f4043c;
    }

    public final Rect E(View view) {
        m mVar = (m) view.getLayoutParams();
        boolean z10 = mVar.f3984c;
        Rect rect = mVar.f3983b;
        if (!z10) {
            return rect;
        }
        w wVar = this.f3927r0;
        if (wVar.isPreLayout() && (mVar.isItemChanged() || mVar.isViewInvalid())) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList<k> arrayList = this.A;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Rect rect2 = this.f3930t;
            rect2.set(0, 0, 0, 0);
            arrayList.get(i10).getItemOffsets(rect2, view, this, wVar);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        mVar.f3984c = false;
        return rect;
    }

    public final void F(int i10) {
        if (this.f3938x == null) {
            return;
        }
        setScrollState(2);
        this.f3938x.scrollToPosition(i10);
        awakenScrollBars();
    }

    public final void G() {
        int iG = this.f3922p.g();
        for (int i10 = 0; i10 < iG; i10++) {
            ((m) this.f3922p.f(i10).getLayoutParams()).f3984c = true;
        }
        ArrayList<z> arrayList = this.f3916m.f3994c;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            m mVar = (m) arrayList.get(i11).f4041a.getLayoutParams();
            if (mVar != null) {
                mVar.f3984c = true;
            }
        }
    }

    public final void H(int i10, int i11, boolean z10) {
        int i12 = i10 + i11;
        int iG = this.f3922p.g();
        for (int i13 = 0; i13 < iG; i13++) {
            z zVarC = C(this.f3922p.f(i13));
            if (zVarC != null && !zVarC.l()) {
                int i14 = zVarC.f4043c;
                w wVar = this.f3927r0;
                if (i14 >= i12) {
                    zVarC.j(-i11, z10);
                    wVar.f4022f = true;
                } else if (i14 >= i10) {
                    zVarC.b(8);
                    zVarC.j(-i11, z10);
                    zVarC.f4043c = i10 - 1;
                    wVar.f4022f = true;
                }
            }
        }
        r rVar = this.f3916m;
        ArrayList<z> arrayList = rVar.f3994c;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                requestLayout();
                return;
            }
            z zVar = arrayList.get(size);
            if (zVar != null) {
                int i15 = zVar.f4043c;
                if (i15 >= i12) {
                    zVar.j(-i11, z10);
                } else if (i15 >= i10) {
                    zVar.b(8);
                    rVar.d(size);
                }
            }
        }
    }

    public final void I() {
        this.P++;
    }

    public final void J(boolean z10) {
        int i10;
        int i11 = this.P - 1;
        this.P = i11;
        if (i11 < 1) {
            this.P = 0;
            if (z10) {
                int i12 = this.K;
                this.K = 0;
                if (i12 != 0) {
                    AccessibilityManager accessibilityManager = this.M;
                    if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                        accessibilityEventObtain.setEventType(2048);
                        y0.b.setContentChangeTypes(accessibilityEventObtain, i12);
                        sendAccessibilityEventUnchecked(accessibilityEventObtain);
                    }
                }
                ArrayList arrayList = this.E0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    z zVar = (z) arrayList.get(size);
                    if (zVar.f4041a.getParent() == this && !zVar.l() && (i10 = zVar.f4057q) != -1) {
                        j0.setImportantForAccessibility(zVar.f4041a, i10);
                        zVar.f4057q = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void K(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3905b0) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.f3905b0 = motionEvent.getPointerId(i10);
            int x10 = (int) (motionEvent.getX(i10) + 0.5f);
            this.f3909f0 = x10;
            this.f3907d0 = x10;
            int y10 = (int) (motionEvent.getY(i10) + 0.5f);
            this.f3910g0 = y10;
            this.f3908e0 = y10;
        }
    }

    public final void L() {
        if (this.f3939x0 || !this.D) {
            return;
        }
        j0.postOnAnimation(this, this.F0);
        this.f3939x0 = true;
    }

    public final void M() {
        boolean z10;
        boolean z11 = false;
        if (this.N) {
            androidx.recyclerview.widget.a aVar = this.f3920o;
            aVar.j(aVar.f4103b);
            aVar.j(aVar.f4104c);
            aVar.f4107f = 0;
            if (this.O) {
                this.f3938x.onItemsChanged(this);
            }
        }
        if (this.W != null && this.f3938x.supportsPredictiveItemAnimations()) {
            this.f3920o.i();
        } else {
            this.f3920o.c();
        }
        boolean z12 = this.f3933u0 || this.f3935v0;
        boolean z13 = this.F && this.W != null && ((z10 = this.N) || z12 || this.f3938x.f3966f) && (!z10 || this.f3936w.hasStableIds());
        w wVar = this.f3927r0;
        wVar.f4026j = z13;
        if (z13 && z12 && !this.N) {
            if (this.W != null && this.f3938x.supportsPredictiveItemAnimations()) {
                z11 = true;
            }
        }
        wVar.f4027k = z11;
    }

    public final void N(boolean z10) {
        this.O = z10 | this.O;
        this.N = true;
        int iG = this.f3922p.g();
        for (int i10 = 0; i10 < iG; i10++) {
            z zVarC = C(this.f3922p.f(i10));
            if (zVarC != null && !zVarC.l()) {
                zVarC.b(6);
            }
        }
        G();
        r rVar = this.f3916m;
        ArrayList<z> arrayList = rVar.f3994c;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            z zVar = arrayList.get(i11);
            if (zVar != null) {
                zVar.b(6);
                zVar.a(null);
            }
        }
        Adapter adapter = RecyclerView.this.f3936w;
        if (adapter == null || !adapter.hasStableIds()) {
            rVar.c();
        }
    }

    public final void O(z zVar, i.c cVar) {
        int i10 = (zVar.f4050j & (-8193)) | 0;
        zVar.f4050j = i10;
        boolean z10 = this.f3927r0.f4024h;
        androidx.recyclerview.widget.x xVar = this.f3924q;
        if (z10) {
            if (((i10 & 2) != 0) && !zVar.g() && !zVar.l()) {
                xVar.f4261b.put(B(zVar), zVar);
            }
        }
        b0.k<z, x.a> kVar = xVar.f4260a;
        x.a aVarA = kVar.get(zVar);
        if (aVarA == null) {
            aVarA = x.a.a();
            kVar.put(zVar, aVarA);
        }
        aVarA.f4264b = cVar;
        aVarA.f4263a |= 4;
    }

    public final void P(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f3930t;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof m) {
            m mVar = (m) layoutParams;
            if (!mVar.f3984c) {
                int i10 = rect.left;
                Rect rect2 = mVar.f3983b;
                rect.left = i10 - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.f3938x.requestChildRectangleOnScreen(this, view, this.f3930t, !this.F, view2 == null);
    }

    public final void Q() {
        VelocityTracker velocityTracker = this.f3906c0;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean zIsFinished = false;
        stopNestedScroll(0);
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.S.isFinished();
        }
        EdgeEffect edgeEffect2 = this.T;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.T.isFinished();
        }
        EdgeEffect edgeEffect3 = this.U;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.U.isFinished();
        }
        EdgeEffect edgeEffect4 = this.V;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.V.isFinished();
        }
        if (zIsFinished) {
            j0.postInvalidateOnAnimation(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean R(int r21, int r22, android.view.MotionEvent r23, int r24) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.R(int, int, android.view.MotionEvent, int):boolean");
    }

    public final void S(int i10, int i11, int[] iArr) {
        z zVar;
        V();
        I();
        t0.m.beginSection("RV Scroll");
        w wVar = this.f3927r0;
        v(wVar);
        r rVar = this.f3916m;
        int iScrollHorizontallyBy = i10 != 0 ? this.f3938x.scrollHorizontallyBy(i10, rVar, wVar) : 0;
        int iScrollVerticallyBy = i11 != 0 ? this.f3938x.scrollVerticallyBy(i11, rVar, wVar) : 0;
        t0.m.endSection();
        int iD = this.f3922p.d();
        for (int i12 = 0; i12 < iD; i12++) {
            View viewC = this.f3922p.c(i12);
            z childViewHolder = getChildViewHolder(viewC);
            if (childViewHolder != null && (zVar = childViewHolder.f4049i) != null) {
                int left = viewC.getLeft();
                int top = viewC.getTop();
                View view = zVar.f4041a;
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        J(true);
        W(false);
        if (iArr != null) {
            iArr[0] = iScrollHorizontallyBy;
            iArr[1] = iScrollVerticallyBy;
        }
    }

    public final void U(int i10, int i11, Interpolator interpolator, int i12, boolean z10) {
        l lVar = this.f3938x;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.I) {
            return;
        }
        if (!lVar.canScrollHorizontally()) {
            i10 = 0;
        }
        if (!this.f3938x.canScrollVertically()) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return;
        }
        if (!(i12 == Integer.MIN_VALUE || i12 > 0)) {
            scrollBy(i10, i11);
            return;
        }
        if (z10) {
            int i13 = i10 != 0 ? 1 : 0;
            if (i11 != 0) {
                i13 |= 2;
            }
            startNestedScroll(i13, 1);
        }
        this.f3921o0.smoothScrollBy(i10, i11, i12, interpolator);
    }

    public final void V() {
        int i10 = this.G + 1;
        this.G = i10;
        if (i10 != 1 || this.I) {
            return;
        }
        this.H = false;
    }

    public final void W(boolean z10) {
        if (this.G < 1) {
            this.G = 1;
        }
        if (!z10 && !this.I) {
            this.H = false;
        }
        if (this.G == 1) {
            if (z10 && this.H && !this.I && this.f3938x != null && this.f3936w != null) {
                m();
            }
            if (!this.I) {
                this.H = false;
            }
        }
        this.G--;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        l lVar = this.f3938x;
        if (lVar == null || !lVar.onAddFocusables(this, arrayList, i10, i11)) {
            super.addFocusables(arrayList, i10, i11);
        }
    }

    public void addItemDecoration(k kVar, int i10) {
        l lVar = this.f3938x;
        if (lVar != null) {
            lVar.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList<k> arrayList = this.A;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i10 < 0) {
            arrayList.add(kVar);
        } else {
            arrayList.add(i10, kVar);
        }
        G();
        requestLayout();
    }

    public void addOnItemTouchListener(o oVar) {
        this.B.add(oVar);
    }

    public void addOnScrollListener(p pVar) {
        if (this.f3931t0 == null) {
            this.f3931t0 = new ArrayList();
        }
        this.f3931t0.add(pVar);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof m) && this.f3938x.checkLayoutParams((m) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        l lVar = this.f3938x;
        if (lVar != null && lVar.canScrollHorizontally()) {
            return this.f3938x.computeHorizontalScrollExtent(this.f3927r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        l lVar = this.f3938x;
        if (lVar != null && lVar.canScrollHorizontally()) {
            return this.f3938x.computeHorizontalScrollOffset(this.f3927r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        l lVar = this.f3938x;
        if (lVar != null && lVar.canScrollHorizontally()) {
            return this.f3938x.computeHorizontalScrollRange(this.f3927r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        l lVar = this.f3938x;
        if (lVar != null && lVar.canScrollVertically()) {
            return this.f3938x.computeVerticalScrollExtent(this.f3927r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        l lVar = this.f3938x;
        if (lVar != null && lVar.canScrollVertically()) {
            return this.f3938x.computeVerticalScrollOffset(this.f3927r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        l lVar = this.f3938x;
        if (lVar != null && lVar.canScrollVertically()) {
            return this.f3938x.computeVerticalScrollRange(this.f3927r0);
        }
        return 0;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return getScrollingChildHelper().dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return getScrollingChildHelper().dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i10, i11, i12, i13, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z10;
        super.draw(canvas);
        ArrayList<k> arrayList = this.A;
        int size = arrayList.size();
        boolean z11 = false;
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).onDrawOver(canvas, this, this.f3927r0);
        }
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z10 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f3926r ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.S;
            z10 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f3926r) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.T;
            z10 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.U;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f3926r ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.U;
            z10 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.V;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f3926r) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.V;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z11 = true;
            }
            z10 |= z11;
            canvas.restoreToCount(iSave4);
        }
        if ((z10 || this.W == null || arrayList.size() <= 0 || !this.W.isRunning()) ? z10 : true) {
            j0.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        return super.drawChild(canvas, view, j10);
    }

    public final void e(z zVar) {
        View view = zVar.f4041a;
        boolean z10 = view.getParent() == this;
        this.f3916m.h(getChildViewHolder(view));
        if (zVar.i()) {
            this.f3922p.b(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z10) {
            this.f3922p.a(view, true, -1);
            return;
        }
        androidx.recyclerview.widget.b bVar = this.f3922p;
        int iIndexOfChild = ((androidx.recyclerview.widget.q) bVar.f4112a).indexOfChild(view);
        if (iIndexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        bVar.f4113b.h(iIndexOfChild);
        bVar.f4114c.add(view);
        ((androidx.recyclerview.widget.q) bVar.f4112a).onEnteredHiddenState(view);
    }

    public final void f(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + u());
        }
        if (this.Q > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + u()));
        }
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public z findContainingViewHolder(View view) {
        View viewFindContainingItemView = findContainingItemView(view);
        if (viewFindContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(viewFindContainingItemView);
    }

    public z findViewHolderForAdapterPosition(int i10) {
        z zVar = null;
        if (this.N) {
            return null;
        }
        int iG = this.f3922p.g();
        for (int i11 = 0; i11 < iG; i11++) {
            z zVarC = C(this.f3922p.f(i11));
            if (zVarC != null && !zVarC.g() && A(zVarC) == i10) {
                if (!this.f3922p.i(zVarC.f4041a)) {
                    return zVarC;
                }
                zVar = zVarC;
            }
        }
        return zVar;
    }

    public z findViewHolderForItemId(long j10) {
        Adapter adapter = this.f3936w;
        z zVar = null;
        if (adapter != null && adapter.hasStableIds()) {
            int iG = this.f3922p.g();
            for (int i10 = 0; i10 < iG; i10++) {
                z zVarC = C(this.f3922p.f(i10));
                if (zVarC != null && !zVarC.g() && zVarC.getItemId() == j10) {
                    if (!this.f3922p.i(zVarC.f4041a)) {
                        return zVarC;
                    }
                    zVar = zVarC;
                }
            }
        }
        return zVar;
    }

    @Deprecated
    public z findViewHolderForPosition(int i10) {
        return z(i10, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean fling(int i10, int i11) {
        l lVar = this.f3938x;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.I) {
            return false;
        }
        int iCanScrollHorizontally = lVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.f3938x.canScrollVertically();
        int i12 = this.f3913j0;
        if (iCanScrollHorizontally == 0 || Math.abs(i10) < i12) {
            i10 = 0;
        }
        if (!zCanScrollVertically || Math.abs(i11) < i12) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return false;
        }
        float f10 = i10;
        float f11 = i11;
        if (!dispatchNestedPreFling(f10, f11)) {
            boolean z10 = iCanScrollHorizontally != 0 || zCanScrollVertically;
            dispatchNestedFling(f10, f11, z10);
            n nVar = this.f3912i0;
            if (nVar != null && nVar.onFling(i10, i11)) {
                return true;
            }
            if (z10) {
                if (zCanScrollVertically) {
                    iCanScrollHorizontally = (iCanScrollHorizontally == true ? 1 : 0) | 2;
                }
                startNestedScroll(iCanScrollHorizontally, 1);
                int i13 = this.f3914k0;
                this.f3921o0.fling(Math.max(-i13, Math.min(i10, i13)), Math.max(-i13, Math.min(i11, i13)));
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View focusSearch(android.view.View r14, int r15) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        l lVar = this.f3938x;
        if (lVar != null) {
            return lVar.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + u());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        l lVar = this.f3938x;
        if (lVar != null) {
            return lVar.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + u());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.f3936w;
    }

    @Override // android.view.View
    public int getBaseline() {
        l lVar = this.f3938x;
        return lVar != null ? lVar.getBaseline() : super.getBaseline();
    }

    public int getChildAdapterPosition(View view) {
        z zVarC = C(view);
        if (zVarC != null) {
            return zVarC.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        return super.getChildDrawingOrder(i10, i11);
    }

    public int getChildLayoutPosition(View view) {
        z zVarC = C(view);
        if (zVarC != null) {
            return zVarC.getLayoutPosition();
        }
        return -1;
    }

    public z getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return C(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f3926r;
    }

    public androidx.recyclerview.widget.s getCompatAccessibilityDelegate() {
        return this.f3941y0;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        D(view, rect);
    }

    public h getEdgeEffectFactory() {
        return this.R;
    }

    public i getItemAnimator() {
        return this.W;
    }

    public int getItemDecorationCount() {
        return this.A.size();
    }

    public l getLayoutManager() {
        return this.f3938x;
    }

    public int getMaxFlingVelocity() {
        return this.f3914k0;
    }

    public int getMinFlingVelocity() {
        return this.f3913j0;
    }

    long getNanoTime() {
        if (N0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public n getOnFlingListener() {
        return this.f3912i0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f3919n0;
    }

    public q getRecycledViewPool() {
        return this.f3916m.b();
    }

    public int getScrollState() {
        return this.f3903a0;
    }

    public final void h() {
        int iG = this.f3922p.g();
        for (int i10 = 0; i10 < iG; i10++) {
            z zVarC = C(this.f3922p.f(i10));
            if (!zVarC.l()) {
                zVarC.f4044d = -1;
                zVarC.f4047g = -1;
            }
        }
        r rVar = this.f3916m;
        ArrayList<z> arrayList = rVar.f3994c;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            z zVar = arrayList.get(i11);
            zVar.f4044d = -1;
            zVar.f4047g = -1;
        }
        ArrayList<z> arrayList2 = rVar.f3992a;
        int size2 = arrayList2.size();
        for (int i12 = 0; i12 < size2; i12++) {
            z zVar2 = arrayList2.get(i12);
            zVar2.f4044d = -1;
            zVar2.f4047g = -1;
        }
        ArrayList<z> arrayList3 = rVar.f3993b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i13 = 0; i13 < size3; i13++) {
                z zVar3 = rVar.f3993b.get(i13);
                zVar3.f4044d = -1;
                zVar3.f4047g = -1;
            }
        }
    }

    public boolean hasFixedSize() {
        return this.E;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.F || this.N || this.f3920o.g();
    }

    public final void i(int i10, int i11) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect == null || edgeEffect.isFinished() || i10 <= 0) {
            zIsFinished = false;
        } else {
            this.S.onRelease();
            zIsFinished = this.S.isFinished();
        }
        EdgeEffect edgeEffect2 = this.U;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i10 < 0) {
            this.U.onRelease();
            zIsFinished |= this.U.isFinished();
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i11 > 0) {
            this.T.onRelease();
            zIsFinished |= this.T.isFinished();
        }
        EdgeEffect edgeEffect4 = this.V;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i11 < 0) {
            this.V.onRelease();
            zIsFinished |= this.V.isFinished();
        }
        if (zIsFinished) {
            j0.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.D;
    }

    public boolean isComputingLayout() {
        return this.P > 0;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.I;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    public final void j() {
        if (!this.F || this.N) {
            t0.m.beginSection("RV FullInvalidate");
            m();
            t0.m.endSection();
            return;
        }
        if (this.f3920o.g()) {
            androidx.recyclerview.widget.a aVar = this.f3920o;
            int i10 = aVar.f4107f;
            boolean z10 = false;
            if ((4 & i10) != 0) {
                if (!((i10 & 11) != 0)) {
                    t0.m.beginSection("RV PartialInvalidate");
                    V();
                    I();
                    this.f3920o.i();
                    if (!this.H) {
                        int iD = this.f3922p.d();
                        int i11 = 0;
                        while (true) {
                            if (i11 >= iD) {
                                break;
                            }
                            z zVarC = C(this.f3922p.c(i11));
                            if (zVarC != null && !zVarC.l()) {
                                if ((zVarC.f4050j & 2) != 0) {
                                    z10 = true;
                                    break;
                                }
                            }
                            i11++;
                        }
                        if (z10) {
                            m();
                        } else {
                            this.f3920o.b();
                        }
                    }
                    W(true);
                    J(true);
                    t0.m.endSection();
                    return;
                }
            }
            if (aVar.g()) {
                t0.m.beginSection("RV FullInvalidate");
                m();
                t0.m.endSection();
            }
        }
    }

    public final void k(int i10, int i11) {
        setMeasuredDimension(l.chooseSize(i10, getPaddingRight() + getPaddingLeft(), j0.getMinimumWidth(this)), l.chooseSize(i11, getPaddingBottom() + getPaddingTop(), j0.getMinimumHeight(this)));
    }

    public final void l(View view) {
        z zVarC = C(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.f3936w;
        if (adapter == null || zVarC == null) {
            return;
        }
        adapter.onViewDetachedFromWindow(zVarC);
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0346  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m() {
        /*
            Method dump skipped, instructions count: 869
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.m():void");
    }

    public final void n() {
        w wVar = this.f3927r0;
        wVar.a(1);
        v(wVar);
        wVar.f4025i = false;
        V();
        androidx.recyclerview.widget.x xVar = this.f3924q;
        xVar.f4260a.clear();
        xVar.f4261b.clear();
        I();
        M();
        View focusedChild = (this.f3919n0 && hasFocus() && this.f3936w != null) ? getFocusedChild() : null;
        z zVarFindContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (zVarFindContainingViewHolder == null) {
            wVar.f4029m = -1L;
            wVar.f4028l = -1;
            wVar.f4030n = -1;
        } else {
            wVar.f4029m = this.f3936w.hasStableIds() ? zVarFindContainingViewHolder.getItemId() : -1L;
            wVar.f4028l = this.N ? -1 : zVarFindContainingViewHolder.g() ? zVarFindContainingViewHolder.f4044d : zVarFindContainingViewHolder.getAbsoluteAdapterPosition();
            View focusedChild2 = zVarFindContainingViewHolder.f4041a;
            int id2 = focusedChild2.getId();
            while (!focusedChild2.isFocused() && (focusedChild2 instanceof ViewGroup) && focusedChild2.hasFocus()) {
                focusedChild2 = ((ViewGroup) focusedChild2).getFocusedChild();
                if (focusedChild2.getId() != -1) {
                    id2 = focusedChild2.getId();
                }
            }
            wVar.f4030n = id2;
        }
        wVar.f4024h = wVar.f4026j && this.f3935v0;
        this.f3935v0 = false;
        this.f3933u0 = false;
        wVar.f4023g = wVar.f4027k;
        wVar.f4021e = this.f3936w.getItemCount();
        x(this.f3943z0);
        boolean z10 = wVar.f4026j;
        b0.k<z, x.a> kVar = xVar.f4260a;
        if (z10) {
            int iD = this.f3922p.d();
            for (int i10 = 0; i10 < iD; i10++) {
                z zVarC = C(this.f3922p.c(i10));
                if (!zVarC.l() && (!zVarC.f() || this.f3936w.hasStableIds())) {
                    i.c cVarRecordPreLayoutInformation = this.W.recordPreLayoutInformation(wVar, zVarC, i.a(zVarC), zVarC.c());
                    x.a aVarA = kVar.get(zVarC);
                    if (aVarA == null) {
                        aVarA = x.a.a();
                        kVar.put(zVarC, aVarA);
                    }
                    aVarA.f4264b = cVarRecordPreLayoutInformation;
                    aVarA.f4263a |= 4;
                    if (wVar.f4024h) {
                        if (((zVarC.f4050j & 2) != 0) && !zVarC.g() && !zVarC.l() && !zVarC.f()) {
                            xVar.f4261b.put(B(zVarC), zVarC);
                        }
                    }
                }
            }
        }
        if (wVar.f4027k) {
            int iG = this.f3922p.g();
            for (int i11 = 0; i11 < iG; i11++) {
                z zVarC2 = C(this.f3922p.f(i11));
                if (!zVarC2.l() && zVarC2.f4044d == -1) {
                    zVarC2.f4044d = zVarC2.f4043c;
                }
            }
            boolean z11 = wVar.f4022f;
            wVar.f4022f = false;
            this.f3938x.onLayoutChildren(this.f3916m, wVar);
            wVar.f4022f = z11;
            for (int i12 = 0; i12 < this.f3922p.d(); i12++) {
                z zVarC3 = C(this.f3922p.c(i12));
                if (!zVarC3.l()) {
                    x.a aVar = kVar.get(zVarC3);
                    if (!((aVar == null || (aVar.f4263a & 4) == 0) ? false : true)) {
                        int iA = i.a(zVarC3);
                        boolean z12 = (zVarC3.f4050j & 8192) != 0;
                        if (!z12) {
                            iA |= 4096;
                        }
                        i.c cVarRecordPreLayoutInformation2 = this.W.recordPreLayoutInformation(wVar, zVarC3, iA, zVarC3.c());
                        if (z12) {
                            O(zVarC3, cVarRecordPreLayoutInformation2);
                        } else {
                            x.a aVarA2 = kVar.get(zVarC3);
                            if (aVarA2 == null) {
                                aVarA2 = x.a.a();
                                kVar.put(zVarC3, aVarA2);
                            }
                            aVarA2.f4263a |= 2;
                            aVarA2.f4264b = cVarRecordPreLayoutInformation2;
                        }
                    }
                }
            }
            h();
        } else {
            h();
        }
        J(true);
        W(false);
        wVar.f4020d = 2;
    }

    public final void o() {
        V();
        I();
        w wVar = this.f3927r0;
        wVar.a(6);
        this.f3920o.c();
        wVar.f4021e = this.f3936w.getItemCount();
        wVar.f4019c = 0;
        if (this.f3918n != null) {
            Adapter adapter = this.f3936w;
            int iOrdinal = adapter.f3946c.ordinal();
            if (iOrdinal == 1 ? adapter.getItemCount() > 0 : iOrdinal != 2) {
                Parcelable parcelable = this.f3918n.f4001n;
                if (parcelable != null) {
                    this.f3938x.onRestoreInstanceState(parcelable);
                }
                this.f3918n = null;
            }
        }
        wVar.f4023g = false;
        this.f3938x.onLayoutChildren(this.f3916m, wVar);
        wVar.f4022f = false;
        wVar.f4026j = wVar.f4026j && this.W != null;
        wVar.f4020d = 4;
        J(true);
        W(false);
    }

    public void offsetChildrenHorizontal(int i10) {
        int iD = this.f3922p.d();
        for (int i11 = 0; i11 < iD; i11++) {
            this.f3922p.c(i11).offsetLeftAndRight(i10);
        }
    }

    public void offsetChildrenVertical(int i10) {
        int iD = this.f3922p.d();
        for (int i11 = 0; i11 < iD; i11++) {
            this.f3922p.c(i11).offsetTopAndBottom(i10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.P = r0
            r1 = 1
            r5.D = r1
            boolean r2 = r5.F
            if (r2 == 0) goto L15
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L15
            r2 = 1
            goto L16
        L15:
            r2 = 0
        L16:
            r5.F = r2
            androidx.recyclerview.widget.RecyclerView$l r2 = r5.f3938x
            if (r2 == 0) goto L21
            r2.f3967g = r1
            r2.onAttachedToWindow(r5)
        L21:
            r5.f3939x0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.N0
            if (r0 == 0) goto L64
            java.lang.ThreadLocal<androidx.recyclerview.widget.k> r0 = androidx.recyclerview.widget.k.f4203p
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.k r1 = (androidx.recyclerview.widget.k) r1
            r5.f3923p0 = r1
            if (r1 != 0) goto L5f
            androidx.recyclerview.widget.k r1 = new androidx.recyclerview.widget.k
            r1.<init>()
            r5.f3923p0 = r1
            android.view.Display r1 = x0.j0.getDisplay(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L51
            if (r1 == 0) goto L51
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L51
            goto L53
        L51:
            r1 = 1114636288(0x42700000, float:60.0)
        L53:
            androidx.recyclerview.widget.k r2 = r5.f3923p0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f4207n = r3
            r0.set(r2)
        L5f:
            androidx.recyclerview.widget.k r0 = r5.f3923p0
            r0.add(r5)
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        androidx.recyclerview.widget.k kVar;
        super.onDetachedFromWindow();
        i iVar = this.W;
        if (iVar != null) {
            iVar.endAnimations();
        }
        stopScroll();
        this.D = false;
        l lVar = this.f3938x;
        if (lVar != null) {
            lVar.f3967g = false;
            lVar.onDetachedFromWindow(this, this.f3916m);
        }
        this.E0.clear();
        removeCallbacks(this.F0);
        this.f3924q.getClass();
        while (x.a.f4262d.acquire() != 0) {
        }
        if (!N0 || (kVar = this.f3923p0) == null) {
            return;
        }
        kVar.remove(this);
        this.f3923p0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList<k> arrayList = this.A;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).onDraw(canvas, this, this.f3927r0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0080  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (this.I) {
            return false;
        }
        this.C = null;
        if (w(motionEvent)) {
            Q();
            setScrollState(0);
            return true;
        }
        l lVar = this.f3938x;
        if (lVar == null) {
            return false;
        }
        boolean zCanScrollHorizontally = lVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.f3938x.canScrollVertically();
        if (this.f3906c0 == null) {
            this.f3906c0 = VelocityTracker.obtain();
        }
        this.f3906c0.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.J) {
                this.J = false;
            }
            this.f3905b0 = motionEvent.getPointerId(0);
            int x10 = (int) (motionEvent.getX() + 0.5f);
            this.f3909f0 = x10;
            this.f3907d0 = x10;
            int y10 = (int) (motionEvent.getY() + 0.5f);
            this.f3910g0 = y10;
            this.f3908e0 = y10;
            if (this.f3903a0 == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.C0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i10 = zCanScrollHorizontally;
            if (zCanScrollVertically) {
                i10 = (zCanScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i10, 0);
        } else if (actionMasked == 1) {
            this.f3906c0.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f3905b0);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f3905b0 + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x11 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y11 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f3903a0 != 1) {
                int i11 = x11 - this.f3907d0;
                int i12 = y11 - this.f3908e0;
                if (zCanScrollHorizontally == 0 || Math.abs(i11) <= this.f3911h0) {
                    z10 = false;
                } else {
                    this.f3909f0 = x11;
                    z10 = true;
                }
                if (zCanScrollVertically && Math.abs(i12) > this.f3911h0) {
                    this.f3910g0 = y11;
                    z10 = true;
                }
                if (z10) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            Q();
            setScrollState(0);
        } else if (actionMasked == 5) {
            this.f3905b0 = motionEvent.getPointerId(actionIndex);
            int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f3909f0 = x12;
            this.f3907d0 = x12;
            int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f3910g0 = y12;
            this.f3908e0 = y12;
        } else if (actionMasked == 6) {
            K(motionEvent);
        }
        return this.f3903a0 == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        t0.m.beginSection("RV OnLayout");
        m();
        t0.m.endSection();
        this.F = true;
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        l lVar = this.f3938x;
        if (lVar == null) {
            k(i10, i11);
            return;
        }
        boolean zIsAutoMeasureEnabled = lVar.isAutoMeasureEnabled();
        r rVar = this.f3916m;
        boolean z10 = false;
        w wVar = this.f3927r0;
        if (zIsAutoMeasureEnabled) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f3938x.onMeasure(rVar, wVar, i10, i11);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z10 = true;
            }
            this.G0 = z10;
            if (z10 || this.f3936w == null) {
                return;
            }
            if (wVar.f4020d == 1) {
                n();
            }
            this.f3938x.g(i10, i11);
            wVar.f4025i = true;
            o();
            this.f3938x.h(i10, i11);
            if (this.f3938x.k()) {
                this.f3938x.g(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                wVar.f4025i = true;
                o();
                this.f3938x.h(i10, i11);
            }
            this.H0 = getMeasuredWidth();
            this.I0 = getMeasuredHeight();
            return;
        }
        if (this.E) {
            this.f3938x.onMeasure(rVar, wVar, i10, i11);
            return;
        }
        if (this.L) {
            V();
            I();
            M();
            J(true);
            if (wVar.f4027k) {
                wVar.f4023g = true;
            } else {
                this.f3920o.c();
                wVar.f4023g = false;
            }
            this.L = false;
            W(false);
        } else if (wVar.f4027k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        Adapter adapter = this.f3936w;
        if (adapter != null) {
            wVar.f4021e = adapter.getItemCount();
        } else {
            wVar.f4021e = 0;
        }
        V();
        this.f3938x.onMeasure(rVar, wVar, i10, i11);
        W(false);
        wVar.f4023g = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof u)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        u uVar = (u) parcelable;
        this.f3918n = uVar;
        super.onRestoreInstanceState(uVar.getSuperState());
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        u uVar = new u(super.onSaveInstanceState());
        u uVar2 = this.f3918n;
        if (uVar2 != null) {
            uVar.f4001n = uVar2.f4001n;
        } else {
            l lVar = this.f3938x;
            if (lVar != null) {
                uVar.f4001n = lVar.onSaveInstanceState();
            } else {
                uVar.f4001n = null;
            }
        }
        return uVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 == i12 && i11 == i13) {
            return;
        }
        this.V = null;
        this.T = null;
        this.U = null;
        this.S = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00fc A[PHI: r0
  0x00fc: PHI (r0v43 int) = (r0v30 int), (r0v47 int) binds: [B:50:0x00e5, B:54:0x00f8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0115  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r21) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i10, int i11) {
        this.Q++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i10, scrollY - i11);
        onScrolled(i10, i11);
        p pVar = this.f3929s0;
        if (pVar != null) {
            pVar.onScrolled(this, i10, i11);
        }
        ArrayList arrayList = this.f3931t0;
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else {
                    ((p) this.f3931t0.get(size)).onScrolled(this, i10, i11);
                }
            }
        }
        this.Q--;
    }

    public final void q() {
        if (this.V != null) {
            return;
        }
        EdgeEffect edgeEffectCreateEdgeEffect = this.R.createEdgeEffect(this, 3);
        this.V = edgeEffectCreateEdgeEffect;
        if (this.f3926r) {
            edgeEffectCreateEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectCreateEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void r() {
        if (this.S != null) {
            return;
        }
        EdgeEffect edgeEffectCreateEdgeEffect = this.R.createEdgeEffect(this, 0);
        this.S = edgeEffectCreateEdgeEffect;
        if (this.f3926r) {
            edgeEffectCreateEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectCreateEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z10) {
        z zVarC = C(view);
        if (zVarC != null) {
            if (zVarC.i()) {
                zVarC.f4050j &= -257;
            } else if (!zVarC.l()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + zVarC + u());
            }
        }
        view.clearAnimation();
        l(view);
        super.removeDetachedView(view, z10);
    }

    public void removeItemDecoration(k kVar) {
        l lVar = this.f3938x;
        if (lVar != null) {
            lVar.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        ArrayList<k> arrayList = this.A;
        arrayList.remove(kVar);
        if (arrayList.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        G();
        requestLayout();
    }

    public void removeOnItemTouchListener(o oVar) {
        this.B.remove(oVar);
        if (this.C == oVar) {
            this.C = null;
        }
    }

    public void removeOnScrollListener(p pVar) {
        ArrayList arrayList = this.f3931t0;
        if (arrayList != null) {
            arrayList.remove(pVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f3938x.onRequestChildFocus(this, this.f3927r0, view, view2) && view2 != null) {
            P(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        return this.f3938x.requestChildRectangleOnScreen(this, view, rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        ArrayList<o> arrayList = this.B;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).onRequestDisallowInterceptTouchEvent(z10);
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.G != 0 || this.I) {
            this.H = true;
        } else {
            super.requestLayout();
        }
    }

    public final void s() {
        if (this.U != null) {
            return;
        }
        EdgeEffect edgeEffectCreateEdgeEffect = this.R.createEdgeEffect(this, 2);
        this.U = edgeEffectCreateEdgeEffect;
        if (this.f3926r) {
            edgeEffectCreateEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectCreateEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    @Override // android.view.View
    public void scrollBy(int i10, int i11) {
        l lVar = this.f3938x;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.I) {
            return;
        }
        boolean zCanScrollHorizontally = lVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.f3938x.canScrollVertically();
        if (zCanScrollHorizontally || zCanScrollVertically) {
            if (!zCanScrollHorizontally) {
                i10 = 0;
            }
            if (!zCanScrollVertically) {
                i11 = 0;
            }
            R(i10, i11, null, 0);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i10) {
        if (this.I) {
            return;
        }
        stopScroll();
        l lVar = this.f3938x;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            lVar.scrollToPosition(i10);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (isComputingLayout()) {
            int contentChangeTypes = accessibilityEvent != null ? y0.b.getContentChangeTypes(accessibilityEvent) : 0;
            this.K |= contentChangeTypes != 0 ? contentChangeTypes : 0;
            i = 1;
        }
        if (i != 0) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.s sVar) {
        this.f3941y0 = sVar;
        j0.setAccessibilityDelegate(this, sVar);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        T(adapter, false, true);
        N(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(g gVar) {
        if (gVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z10) {
        if (z10 != this.f3926r) {
            this.V = null;
            this.T = null;
            this.U = null;
            this.S = null;
        }
        this.f3926r = z10;
        super.setClipToPadding(z10);
        if (this.F) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(h hVar) {
        w0.h.checkNotNull(hVar);
        this.R = hVar;
        this.V = null;
        this.T = null;
        this.U = null;
        this.S = null;
    }

    public void setHasFixedSize(boolean z10) {
        this.E = z10;
    }

    public void setItemAnimator(i iVar) {
        i iVar2 = this.W;
        if (iVar2 != null) {
            iVar2.endAnimations();
            this.W.f3952a = null;
        }
        this.W = iVar;
        if (iVar != null) {
            iVar.f3952a = this.f3937w0;
        }
    }

    public void setItemViewCacheSize(int i10) {
        this.f3916m.setViewCacheSize(i10);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z10) {
        suppressLayout(z10);
    }

    public void setLayoutManager(l lVar) {
        b.InterfaceC0040b interfaceC0040b;
        if (lVar == this.f3938x) {
            return;
        }
        stopScroll();
        l lVar2 = this.f3938x;
        r rVar = this.f3916m;
        if (lVar2 != null) {
            i iVar = this.W;
            if (iVar != null) {
                iVar.endAnimations();
            }
            this.f3938x.removeAndRecycleAllViews(rVar);
            this.f3938x.d(rVar);
            rVar.clear();
            if (this.D) {
                l lVar3 = this.f3938x;
                lVar3.f3967g = false;
                lVar3.onDetachedFromWindow(this, rVar);
            }
            this.f3938x.i(null);
            this.f3938x = null;
        } else {
            rVar.clear();
        }
        androidx.recyclerview.widget.b bVar = this.f3922p;
        bVar.f4113b.g();
        ArrayList arrayList = bVar.f4114c;
        int size = arrayList.size();
        while (true) {
            size--;
            interfaceC0040b = bVar.f4112a;
            if (size < 0) {
                break;
            }
            ((androidx.recyclerview.widget.q) interfaceC0040b).onLeftHiddenState((View) arrayList.get(size));
            arrayList.remove(size);
        }
        ((androidx.recyclerview.widget.q) interfaceC0040b).removeAllViews();
        this.f3938x = lVar;
        if (lVar != null) {
            if (lVar.f3962b != null) {
                throw new IllegalArgumentException("LayoutManager " + lVar + " is already attached to a RecyclerView:" + lVar.f3962b.u());
            }
            lVar.i(this);
            if (this.D) {
                l lVar4 = this.f3938x;
                lVar4.f3967g = true;
                lVar4.onAttachedToWindow(this);
            }
        }
        rVar.i();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        getScrollingChildHelper().setNestedScrollingEnabled(z10);
    }

    public void setOnFlingListener(n nVar) {
        this.f3912i0 = nVar;
    }

    @Deprecated
    public void setOnScrollListener(p pVar) {
        this.f3929s0 = pVar;
    }

    public void setPreserveFocusAfterLayout(boolean z10) {
        this.f3919n0 = z10;
    }

    public void setRecycledViewPool(q qVar) {
        r rVar = this.f3916m;
        if (rVar.f3998g != null) {
            r1.f3987b--;
        }
        rVar.f3998g = qVar;
        if (qVar == null || RecyclerView.this.getAdapter() == null) {
            return;
        }
        rVar.f3998g.f3987b++;
    }

    @Deprecated
    public void setRecyclerListener(s sVar) {
        this.f3940y = sVar;
    }

    void setScrollState(int i10) {
        v vVar;
        if (i10 == this.f3903a0) {
            return;
        }
        this.f3903a0 = i10;
        if (i10 != 2) {
            this.f3921o0.stop();
            l lVar = this.f3938x;
            if (lVar != null && (vVar = lVar.f3965e) != null) {
                vVar.stop();
            }
        }
        l lVar2 = this.f3938x;
        if (lVar2 != null) {
            lVar2.onScrollStateChanged(i10);
        }
        onScrollStateChanged(i10);
        p pVar = this.f3929s0;
        if (pVar != null) {
            pVar.onScrollStateChanged(this, i10);
        }
        ArrayList arrayList = this.f3931t0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((p) this.f3931t0.get(size)).onScrollStateChanged(this, i10);
            }
        }
    }

    public void setScrollingTouchSlop(int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i10 != 0) {
            if (i10 == 1) {
                this.f3911h0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i10 + "; using default value");
        }
        this.f3911h0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(x xVar) {
        this.f3916m.getClass();
    }

    public void smoothScrollBy(int i10, int i11) {
        smoothScrollBy(i10, i11, null);
    }

    public void smoothScrollToPosition(int i10) {
        if (this.I) {
            return;
        }
        l lVar = this.f3938x;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            lVar.smoothScrollToPosition(this, this.f3927r0, i10);
        }
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return getScrollingChildHelper().startNestedScroll(i10);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public void stopScroll() {
        v vVar;
        setScrollState(0);
        this.f3921o0.stop();
        l lVar = this.f3938x;
        if (lVar == null || (vVar = lVar.f3965e) == null) {
            return;
        }
        vVar.stop();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z10) {
        if (z10 != this.I) {
            f("Do not suppressLayout in layout or scroll");
            if (z10) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.I = true;
                this.J = true;
                stopScroll();
                return;
            }
            this.I = false;
            if (this.H && this.f3938x != null && this.f3936w != null) {
                requestLayout();
            }
            this.H = false;
        }
    }

    public final void t() {
        if (this.T != null) {
            return;
        }
        EdgeEffect edgeEffectCreateEdgeEffect = this.R.createEdgeEffect(this, 1);
        this.T = edgeEffectCreateEdgeEffect;
        if (this.f3926r) {
            edgeEffectCreateEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectCreateEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String u() {
        return StringUtils.SPACE + super.toString() + ", adapter:" + this.f3936w + ", layout:" + this.f3938x + ", context:" + getContext();
    }

    public final void v(w wVar) {
        if (getScrollState() != 2) {
            wVar.f4031o = 0;
            wVar.f4032p = 0;
        } else {
            OverScroller overScroller = this.f3921o0.f4035n;
            wVar.f4031o = overScroller.getFinalX() - overScroller.getCurrX();
            wVar.f4032p = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public final boolean w(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        ArrayList<o> arrayList = this.B;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            o oVar = arrayList.get(i10);
            if (oVar.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.C = oVar;
                return true;
            }
        }
        return false;
    }

    public final void x(int[] iArr) {
        int iD = this.f3922p.d();
        if (iD == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < iD; i12++) {
            z zVarC = C(this.f3922p.c(i12));
            if (!zVarC.l()) {
                int layoutPosition = zVarC.getLayoutPosition();
                if (layoutPosition < i10) {
                    i10 = layoutPosition;
                }
                if (layoutPosition > i11) {
                    i11 = layoutPosition;
                }
            }
        }
        iArr[0] = i10;
        iArr[1] = i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.recyclerview.widget.RecyclerView.z z(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.b r0 = r5.f3922p
            int r0 = r0.g()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.b r3 = r5.f3922p
            android.view.View r3 = r3.f(r2)
            androidx.recyclerview.widget.RecyclerView$z r3 = C(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.g()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f4043c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.b r1 = r5.f3922p
            android.view.View r4 = r3.f4041a
            boolean r1 = r1.i(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.z(int, boolean):androidx.recyclerview.widget.RecyclerView$z");
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i10) throws NoSuchMethodException, SecurityException {
        TypedArray typedArray;
        char c10;
        Constructor constructor;
        Object[] objArr;
        super(context, attributeSet, i10);
        this.f3904b = new t();
        this.f3916m = new r();
        this.f3924q = new androidx.recyclerview.widget.x();
        this.f3928s = new a();
        this.f3930t = new Rect();
        this.f3932u = new Rect();
        this.f3934v = new RectF();
        this.f3942z = new ArrayList();
        this.A = new ArrayList<>();
        this.B = new ArrayList<>();
        this.G = 0;
        this.N = false;
        this.O = false;
        this.P = 0;
        this.Q = 0;
        this.R = new h();
        this.W = new androidx.recyclerview.widget.c();
        this.f3903a0 = 0;
        this.f3905b0 = -1;
        this.f3915l0 = Float.MIN_VALUE;
        this.f3917m0 = Float.MIN_VALUE;
        this.f3919n0 = true;
        this.f3921o0 = new y();
        this.f3925q0 = N0 ? new k.b() : null;
        this.f3927r0 = new w();
        this.f3933u0 = false;
        this.f3935v0 = false;
        j jVar = new j();
        this.f3937w0 = jVar;
        this.f3939x0 = false;
        this.f3943z0 = new int[2];
        this.B0 = new int[2];
        this.C0 = new int[2];
        this.D0 = new int[2];
        this.E0 = new ArrayList();
        this.F0 = new b();
        this.H0 = 0;
        this.I0 = 0;
        this.J0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3911h0 = viewConfiguration.getScaledTouchSlop();
        this.f3915l0 = m0.getScaledHorizontalScrollFactor(viewConfiguration, context);
        this.f3917m0 = m0.getScaledVerticalScrollFactor(viewConfiguration, context);
        this.f3913j0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3914k0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.W.f3952a = jVar;
        this.f3920o = new androidx.recyclerview.widget.a(new androidx.recyclerview.widget.r(this));
        this.f3922p = new androidx.recyclerview.widget.b(new androidx.recyclerview.widget.q(this));
        if (j0.getImportantForAutofill(this) == 0) {
            j0.setImportantForAutofill(this, 8);
        }
        if (j0.getImportantForAccessibility(this) == 0) {
            j0.setImportantForAccessibility(this, 1);
        }
        this.M = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.s(this));
        int[] iArr = androidx.recyclerview.R.styleable.RecyclerView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        j0.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        String string = typedArrayObtainStyledAttributes.getString(androidx.recyclerview.R.styleable.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f3926r = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_android_clipToPadding, true);
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_fastScrollEnabled, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + u());
            }
            Resources resources = getContext().getResources();
            c10 = 2;
            typedArray = typedArrayObtainStyledAttributes;
            new androidx.recyclerview.widget.j(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(androidx.recyclerview.R.dimen.fastscroll_margin));
        } else {
            typedArray = typedArrayObtainStyledAttributes;
            c10 = 2;
        }
        typedArray.recycle();
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(".")) {
                    strTrim = RecyclerView.class.getPackage().getName() + ClassUtils.PACKAGE_SEPARATOR_CHAR + strTrim;
                }
                String str = strTrim;
                try {
                    Class<? extends U> clsAsSubclass = Class.forName(str, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(l.class);
                    try {
                        constructor = clsAsSubclass.getConstructor(O0);
                        objArr = new Object[4];
                        objArr[0] = context;
                        objArr[1] = attributeSet;
                        objArr[c10] = Integer.valueOf(i10);
                        objArr[3] = 0;
                    } catch (NoSuchMethodException e10) {
                        try {
                            constructor = clsAsSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        } catch (NoSuchMethodException e11) {
                            e11.initCause(e10);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e11);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((l) constructor.newInstance(objArr));
                } catch (ClassCastException e12) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e12);
                } catch (ClassNotFoundException e13) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e13);
                } catch (IllegalAccessException e14) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e14);
                } catch (InstantiationException e15) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e15);
                } catch (InvocationTargetException e16) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e16);
                }
            }
        }
        int[] iArr2 = K0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i10, 0);
        j0.saveAttributeDataForStyleable(this, context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i10, 0);
        boolean z10 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z10);
    }

    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i10, i11, iArr, iArr2, i12);
    }

    public final void dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScroll(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public void smoothScrollBy(int i10, int i11, Interpolator interpolator) {
        smoothScrollBy(i10, i11, interpolator, Integer.MIN_VALUE);
    }

    public boolean startNestedScroll(int i10, int i11) {
        return getScrollingChildHelper().startNestedScroll(i10, i11);
    }

    public void stopNestedScroll(int i10) {
        getScrollingChildHelper().stopNestedScroll(i10);
    }

    public static class u extends f1.a {
        public static final Parcelable.Creator<u> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public Parcelable f4001n;

        public class a implements Parcelable.ClassLoaderCreator<u> {
            @Override // android.os.Parcelable.Creator
            public u[] newArray(int i10) {
                return new u[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public u createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new u(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public u createFromParcel(Parcel parcel) {
                return new u(parcel, null);
            }
        }

        public u(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4001n = parcel.readParcelable(classLoader == null ? l.class.getClassLoader() : classLoader);
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f4001n, 0);
        }

        public u(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void smoothScrollBy(int i10, int i11, Interpolator interpolator, int i12) {
        U(i10, i11, interpolator, i12, false);
    }

    public static class m extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public z f3982a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f3983b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f3984c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f3985d;

        public m(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3983b = new Rect();
            this.f3984c = true;
            this.f3985d = false;
        }

        @Deprecated
        public int getViewAdapterPosition() {
            return this.f3982a.getBindingAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.f3982a.getLayoutPosition();
        }

        public boolean isItemChanged() {
            return (this.f3982a.f4050j & 2) != 0;
        }

        public boolean isItemRemoved() {
            return this.f3982a.g();
        }

        public boolean isViewInvalid() {
            return this.f3982a.f();
        }

        public boolean viewNeedsUpdate() {
            return (this.f3982a.f4050j & 2) != 0;
        }

        public m(int i10, int i11) {
            super(i10, i11);
            this.f3983b = new Rect();
            this.f3984c = true;
            this.f3985d = false;
        }

        public m(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3983b = new Rect();
            this.f3984c = true;
            this.f3985d = false;
        }

        public m(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3983b = new Rect();
            this.f3984c = true;
            this.f3985d = false;
        }

        public m(m mVar) {
            super((ViewGroup.LayoutParams) mVar);
            this.f3983b = new Rect();
            this.f3984c = true;
            this.f3985d = false;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        l lVar = this.f3938x;
        if (lVar != null) {
            return lVar.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + u());
    }

    public void addItemDecoration(k kVar) {
        addItemDecoration(kVar, -1);
    }

    public static abstract class Adapter<VH extends z> {

        /* renamed from: a, reason: collision with root package name */
        public final e f3944a = new e();

        /* renamed from: b, reason: collision with root package name */
        public boolean f3945b = false;

        /* renamed from: c, reason: collision with root package name */
        public final StateRestorationPolicy f3946c = StateRestorationPolicy.ALLOW;

        public enum StateRestorationPolicy {
            ALLOW,
            /* JADX INFO: Fake field, exist only in values array */
            PREVENT_WHEN_EMPTY,
            /* JADX INFO: Fake field, exist only in values array */
            PREVENT
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void bindViewHolder(VH vh2, int i10) {
            boolean z10 = vh2.f4059s == null;
            if (z10) {
                vh2.f4043c = i10;
                if (hasStableIds()) {
                    vh2.f4045e = getItemId(i10);
                }
                vh2.f4050j = (vh2.f4050j & (-520)) | 1;
                t0.m.beginSection("RV OnBindView");
            }
            vh2.f4059s = this;
            onBindViewHolder(vh2, i10, vh2.c());
            if (z10) {
                ArrayList arrayList = vh2.f4051k;
                if (arrayList != null) {
                    arrayList.clear();
                }
                vh2.f4050j &= -1025;
                ViewGroup.LayoutParams layoutParams = vh2.f4041a.getLayoutParams();
                if (layoutParams instanceof m) {
                    ((m) layoutParams).f3984c = true;
                }
                t0.m.endSection();
            }
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i10) {
            try {
                t0.m.beginSection("RV CreateView");
                VH vh2 = (VH) onCreateViewHolder(viewGroup, i10);
                if (vh2.f4041a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh2.f4046f = i10;
                return vh2;
            } finally {
                t0.m.endSection();
            }
        }

        public int findRelativeAdapterPositionIn(Adapter<? extends z> adapter, z zVar, int i10) {
            if (adapter == this) {
                return i10;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i10) {
            return -1L;
        }

        public int getItemViewType(int i10) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.f3944a.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.f3945b;
        }

        public final void notifyDataSetChanged() {
            this.f3944a.notifyChanged();
        }

        public final void notifyItemRangeChanged(int i10, int i11) {
            this.f3944a.notifyItemRangeChanged(i10, i11);
        }

        public final void notifyItemRangeInserted(int i10, int i11) {
            this.f3944a.notifyItemRangeInserted(i10, i11);
        }

        public final void notifyItemRangeRemoved(int i10, int i11) {
            this.f3944a.notifyItemRangeRemoved(i10, i11);
        }

        public final void notifyItemRemoved(int i10) {
            this.f3944a.notifyItemRangeRemoved(i10, 1);
        }

        public abstract void onBindViewHolder(VH vh2, int i10);

        public void onBindViewHolder(VH vh2, int i10, List<Object> list) {
            onBindViewHolder(vh2, i10);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i10);

        public boolean onFailedToRecycleView(VH vh2) {
            return false;
        }

        public void registerAdapterDataObserver(f fVar) {
            this.f3944a.registerObserver(fVar);
        }

        public void setHasStableIds(boolean z10) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f3945b = z10;
        }

        public void unregisterAdapterDataObserver(f fVar) {
            this.f3944a.unregisterObserver(fVar);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public void onViewAttachedToWindow(VH vh2) {
        }

        public void onViewDetachedFromWindow(VH vh2) {
        }

        public void onViewRecycled(VH vh2) {
        }
    }

    public static abstract class i {

        /* renamed from: a, reason: collision with root package name */
        public b f3952a = null;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<a> f3953b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public final long f3954c = 120;

        /* renamed from: d, reason: collision with root package name */
        public final long f3955d = 120;

        /* renamed from: e, reason: collision with root package name */
        public final long f3956e = 250;

        /* renamed from: f, reason: collision with root package name */
        public final long f3957f = 250;

        public interface a {
            void onAnimationsFinished();
        }

        public interface b {
        }

        public static class c {

            /* renamed from: a, reason: collision with root package name */
            public int f3958a;

            /* renamed from: b, reason: collision with root package name */
            public int f3959b;

            public c setFrom(z zVar) {
                return setFrom(zVar, 0);
            }

            public c setFrom(z zVar, int i10) {
                View view = zVar.f4041a;
                this.f3958a = view.getLeft();
                this.f3959b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        public static int a(z zVar) {
            int i10 = zVar.f4050j & 14;
            if (zVar.f()) {
                return 4;
            }
            if ((i10 & 4) != 0) {
                return i10;
            }
            int oldPosition = zVar.getOldPosition();
            int absoluteAdapterPosition = zVar.getAbsoluteAdapterPosition();
            return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i10 : i10 | 2048;
        }

        public abstract boolean animateAppearance(z zVar, c cVar, c cVar2);

        public abstract boolean animateChange(z zVar, z zVar2, c cVar, c cVar2);

        public abstract boolean animateDisappearance(z zVar, c cVar, c cVar2);

        public abstract boolean animatePersistence(z zVar, c cVar, c cVar2);

        public abstract boolean canReuseUpdatedViewHolder(z zVar);

        public boolean canReuseUpdatedViewHolder(z zVar, List<Object> list) {
            return canReuseUpdatedViewHolder(zVar);
        }

        public final void dispatchAnimationFinished(z zVar) {
            onAnimationFinished(zVar);
            b bVar = this.f3952a;
            if (bVar != null) {
                ((j) bVar).onAnimationFinished(zVar);
            }
        }

        public final void dispatchAnimationsFinished() {
            ArrayList<a> arrayList = this.f3953b;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.get(i10).onAnimationsFinished();
            }
            arrayList.clear();
        }

        public abstract void endAnimation(z zVar);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.f3954c;
        }

        public long getChangeDuration() {
            return this.f3957f;
        }

        public long getMoveDuration() {
            return this.f3956e;
        }

        public long getRemoveDuration() {
            return this.f3955d;
        }

        public abstract boolean isRunning();

        public c obtainHolderInfo() {
            return new c();
        }

        public c recordPostLayoutInformation(w wVar, z zVar) {
            return obtainHolderInfo().setFrom(zVar);
        }

        public c recordPreLayoutInformation(w wVar, z zVar, int i10, List<Object> list) {
            return obtainHolderInfo().setFrom(zVar);
        }

        public abstract void runPendingAnimations();

        public void onAnimationFinished(z zVar) {
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int i10) {
    }

    public static abstract class p {
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        }

        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        }
    }

    public void onScrolled(int i10, int i11) {
    }
}
