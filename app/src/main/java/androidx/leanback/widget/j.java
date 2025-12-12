package androidx.leanback.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.FocusFinder;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.c1;
import androidx.leanback.widget.i;
import androidx.leanback.widget.q;
import androidx.leanback.widget.v;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import java.util.ArrayList;
import okhttp3.internal.http2.Http2;
import y0.d;

/* compiled from: GridLayoutManager.java */
/* loaded from: classes.dex */
public final class j extends RecyclerView.l {

    /* renamed from: g0, reason: collision with root package name */
    public static final Rect f3241g0 = new Rect();

    /* renamed from: h0, reason: collision with root package name */
    public static final int[] f3242h0 = new int[2];
    public c E;
    public e F;
    public int H;
    public int J;
    public int K;
    public int L;
    public int[] M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int T;
    public i V;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f3243a0;

    /* renamed from: d0, reason: collision with root package name */
    public androidx.leanback.widget.f f3246d0;

    /* renamed from: q, reason: collision with root package name */
    public final androidx.leanback.widget.b f3250q;

    /* renamed from: t, reason: collision with root package name */
    public RecyclerView.w f3253t;

    /* renamed from: u, reason: collision with root package name */
    public int f3254u;

    /* renamed from: v, reason: collision with root package name */
    public int f3255v;

    /* renamed from: x, reason: collision with root package name */
    public int[] f3257x;

    /* renamed from: y, reason: collision with root package name */
    public RecyclerView.r f3258y;

    /* renamed from: p, reason: collision with root package name */
    public final int f3249p = 10;

    /* renamed from: r, reason: collision with root package name */
    public int f3251r = 0;

    /* renamed from: s, reason: collision with root package name */
    public androidx.recyclerview.widget.o f3252s = androidx.recyclerview.widget.o.createHorizontalHelper(this);

    /* renamed from: w, reason: collision with root package name */
    public final SparseIntArray f3256w = new SparseIntArray();

    /* renamed from: z, reason: collision with root package name */
    public int f3259z = 221696;
    public a0 A = null;
    public ArrayList<b0> B = null;
    public int C = -1;
    public int D = 0;
    public int G = 0;
    public int S = 8388659;
    public int U = 1;
    public int W = 0;
    public final c1 X = new c1();
    public final p Y = new p();

    /* renamed from: b0, reason: collision with root package name */
    public final int[] f3244b0 = new int[2];

    /* renamed from: c0, reason: collision with root package name */
    public final b1 f3245c0 = new b1();

    /* renamed from: e0, reason: collision with root package name */
    public final a f3247e0 = new a();

    /* renamed from: f0, reason: collision with root package name */
    public final b f3248f0 = new b();
    public int I = -1;

    /* compiled from: GridLayoutManager.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.requestLayout();
        }
    }

    /* compiled from: GridLayoutManager.java */
    public class b implements i.b {
        public b() {
        }

        public void addItem(Object obj, int i10, int i11, int i12, int i13) {
            int i14;
            int i15;
            e eVar;
            int i16;
            View view = (View) obj;
            j jVar = j.this;
            if (i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE) {
                i13 = !jVar.V.isReversedFlow() ? jVar.X.mainAxis().getPaddingMin() : jVar.X.mainAxis().getSize() - jVar.X.mainAxis().getPaddingMax();
            }
            if (!jVar.V.isReversedFlow()) {
                i15 = i11 + i13;
                i14 = i13;
            } else {
                i14 = i13 - i11;
                i15 = i13;
            }
            int paddingMin = (jVar.X.secondAxis().getPaddingMin() + jVar.u(i12)) - jVar.J;
            jVar.f3245c0.loadView(view, i10);
            j.this.E(view, i12, i14, i15, paddingMin);
            if (!jVar.f3253t.isPreLayout()) {
                jVar.V();
            }
            if ((jVar.f3259z & 3) != 1 && (eVar = jVar.F) != null) {
                boolean z10 = eVar.f3272s;
                j jVar2 = j.this;
                if (z10 && (i16 = eVar.f3273t) != 0) {
                    eVar.f3273t = jVar2.K(i16, true);
                }
                int i17 = eVar.f3273t;
                if (i17 == 0 || ((i17 > 0 && jVar2.C()) || (eVar.f3273t < 0 && jVar2.B()))) {
                    eVar.setTargetPosition(jVar2.C);
                    eVar.stop();
                }
            }
            jVar.getClass();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:37:0x0081
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
            */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x00b8 -> B:59:0x00ba). Please report as a decompilation issue!!! */
        public int createItem(int r9, boolean r10, java.lang.Object[] r11, boolean r12) {
            /*
                Method dump skipped, instructions count: 311
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.j.b.createItem(int, boolean, java.lang.Object[], boolean):int");
        }

        public int getCount() {
            j jVar = j.this;
            return jVar.f3253t.getItemCount() + jVar.f3254u;
        }

        public int getEdge(int i10) {
            j jVar = j.this;
            View viewFindViewByPosition = jVar.findViewByPosition(i10 - jVar.f3254u);
            return (jVar.f3259z & 262144) != 0 ? jVar.z(viewFindViewByPosition) : jVar.A(viewFindViewByPosition);
        }

        public int getMinIndex() {
            return j.this.f3254u;
        }

        public int getSize(int i10) {
            j jVar = j.this;
            View viewFindViewByPosition = jVar.findViewByPosition(i10 - jVar.f3254u);
            Rect rect = j.f3241g0;
            jVar.getDecoratedBoundsWithMargins(viewFindViewByPosition, rect);
            return jVar.f3251r == 0 ? rect.width() : rect.height();
        }

        public void removeItem(int i10) {
            j jVar = j.this;
            View viewFindViewByPosition = jVar.findViewByPosition(i10 - jVar.f3254u);
            if ((jVar.f3259z & 3) == 1) {
                jVar.detachAndScrapView(viewFindViewByPosition, jVar.f3258y);
            } else {
                jVar.removeAndRecycleView(viewFindViewByPosition, jVar.f3258y);
            }
        }
    }

    /* compiled from: GridLayoutManager.java */
    public abstract class c extends androidx.recyclerview.widget.m {

        /* renamed from: q, reason: collision with root package name */
        public boolean f3262q;

        public c() {
            super(j.this.f3250q.getContext());
        }

        @Override // androidx.recyclerview.widget.m
        public int calculateTimeForScrolling(int i10) {
            int iCalculateTimeForScrolling = super.calculateTimeForScrolling(i10);
            if (j.this.X.mainAxis().getSize() <= 0) {
                return iCalculateTimeForScrolling;
            }
            float size = (30.0f / r1.X.mainAxis().getSize()) * i10;
            return ((float) iCalculateTimeForScrolling) < size ? (int) size : iCalculateTimeForScrolling;
        }

        @Override // androidx.recyclerview.widget.m, androidx.recyclerview.widget.RecyclerView.v
        public void onStop() {
            super.onStop();
            if (!this.f3262q) {
                onStopInternal();
            }
            j jVar = j.this;
            if (jVar.E == this) {
                jVar.E = null;
            }
            if (jVar.F == this) {
                jVar.F = null;
            }
        }

        public void onStopInternal() {
            View viewFindViewByPosition = findViewByPosition(getTargetPosition());
            j jVar = j.this;
            if (viewFindViewByPosition == null) {
                if (getTargetPosition() >= 0) {
                    jVar.Q(getTargetPosition(), 0, 0, false);
                    return;
                }
                return;
            }
            if (jVar.C != getTargetPosition()) {
                jVar.C = getTargetPosition();
            }
            if (jVar.hasFocus()) {
                jVar.f3259z |= 32;
                viewFindViewByPosition.requestFocus();
                jVar.f3259z &= -33;
            }
            jVar.n();
            jVar.o();
        }

        @Override // androidx.recyclerview.widget.m, androidx.recyclerview.widget.RecyclerView.v
        public void onTargetFound(View view, RecyclerView.w wVar, RecyclerView.v.a aVar) {
            int i10;
            int i11;
            int[] iArr = j.f3242h0;
            j jVar = j.this;
            if (jVar.v(view, null, iArr)) {
                if (jVar.f3251r == 0) {
                    i10 = iArr[0];
                    i11 = iArr[1];
                } else {
                    i10 = iArr[1];
                    i11 = iArr[0];
                }
                aVar.update(i10, i11, calculateTimeForDeceleration((int) Math.sqrt((i11 * i11) + (i10 * i10))), this.f4228j);
            }
        }
    }

    /* compiled from: GridLayoutManager.java */
    public static final class d extends RecyclerView.m {

        /* renamed from: e, reason: collision with root package name */
        public int f3264e;

        /* renamed from: f, reason: collision with root package name */
        public int f3265f;

        /* renamed from: g, reason: collision with root package name */
        public int f3266g;

        /* renamed from: h, reason: collision with root package name */
        public int f3267h;

        /* renamed from: i, reason: collision with root package name */
        public int f3268i;

        /* renamed from: j, reason: collision with root package name */
        public int f3269j;

        /* renamed from: k, reason: collision with root package name */
        public int[] f3270k;

        /* renamed from: l, reason: collision with root package name */
        public q f3271l;

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public d(int i10, int i11) {
            super(i10, i11);
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public d(RecyclerView.m mVar) {
            super(mVar);
        }

        public d(d dVar) {
            super((RecyclerView.m) dVar);
        }
    }

    /* compiled from: GridLayoutManager.java */
    public final class e extends c {

        /* renamed from: s, reason: collision with root package name */
        public final boolean f3272s;

        /* renamed from: t, reason: collision with root package name */
        public int f3273t;

        public e(int i10, boolean z10) {
            super();
            this.f3273t = i10;
            this.f3272s = z10;
            setTargetPosition(-2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.v
        public PointF computeScrollVectorForPosition(int i10) {
            int i11 = this.f3273t;
            if (i11 == 0) {
                return null;
            }
            j jVar = j.this;
            int i12 = ((jVar.f3259z & 262144) == 0 ? i11 >= 0 : i11 <= 0) ? 1 : -1;
            return jVar.f3251r == 0 ? new PointF(i12, 0.0f) : new PointF(0.0f, i12);
        }

        @Override // androidx.leanback.widget.j.c
        public void onStopInternal() {
            super.onStopInternal();
            this.f3273t = 0;
            View viewFindViewByPosition = findViewByPosition(getTargetPosition());
            if (viewFindViewByPosition != null) {
                j jVar = j.this;
                jVar.getClass();
                jVar.R(viewFindViewByPosition, viewFindViewByPosition.findFocus(), true, 0, 0);
            }
        }

        @Override // androidx.recyclerview.widget.m
        public void updateActionForInterimTarget(RecyclerView.v.a aVar) {
            if (this.f3273t == 0) {
                return;
            }
            super.updateActionForInterimTarget(aVar);
        }
    }

    public j(androidx.leanback.widget.b bVar) {
        this.f3250q = bVar;
        setItemPrefetchEnabled(false);
    }

    public static int p(View view) {
        d dVar;
        if (view == null || (dVar = (d) view.getLayoutParams()) == null || dVar.isItemRemoved()) {
            return -1;
        }
        return dVar.getViewAdapterPosition();
    }

    public static int y(View view, View view2) {
        q qVar;
        if (view == null || view2 == null || (qVar = ((d) view.getLayoutParams()).f3271l) == null) {
            return 0;
        }
        q.a[] alignmentDefs = qVar.getAlignmentDefs();
        if (alignmentDefs.length <= 1) {
            return 0;
        }
        while (view2 != view) {
            int id2 = view2.getId();
            if (id2 != -1) {
                for (int i10 = 1; i10 < alignmentDefs.length; i10++) {
                    if (alignmentDefs[i10].getItemAlignmentFocusViewId() == id2) {
                        return i10;
                    }
                }
            }
            view2 = (View) view2.getParent();
        }
        return 0;
    }

    public final int A(View view) {
        return this.f3252s.getDecoratedStart(view);
    }

    public final boolean B() {
        return getItemCount() == 0 || this.f3250q.findViewHolderForAdapterPosition(0) != null;
    }

    public final boolean C() {
        int itemCount = getItemCount();
        return itemCount == 0 || this.f3250q.findViewHolderForAdapterPosition(itemCount - 1) != null;
    }

    public final boolean D(int i10) {
        androidx.leanback.widget.b bVar = this.f3250q;
        RecyclerView.z zVarFindViewHolderForAdapterPosition = bVar.findViewHolderForAdapterPosition(i10);
        if (zVarFindViewHolderForAdapterPosition == null) {
            return false;
        }
        View view = zVarFindViewHolderForAdapterPosition.f4041a;
        return view.getLeft() >= 0 && view.getRight() <= bVar.getWidth() && view.getTop() >= 0 && view.getBottom() <= bVar.getHeight();
    }

    public final void E(View view, int i10, int i11, int i12, int i13) {
        int iT;
        int i14;
        int iQ = this.f3251r == 0 ? q(view) : r(view);
        int i15 = this.L;
        if (i15 > 0) {
            iQ = Math.min(iQ, i15);
        }
        int i16 = this.S;
        int i17 = i16 & 112;
        int absoluteGravity = (this.f3259z & 786432) != 0 ? Gravity.getAbsoluteGravity(i16 & 8388615, 1) : i16 & 7;
        int i18 = this.f3251r;
        if ((i18 != 0 || i17 != 48) && (i18 != 1 || absoluteGravity != 3)) {
            if ((i18 == 0 && i17 == 80) || (i18 == 1 && absoluteGravity == 5)) {
                iT = t(i10) - iQ;
            } else if ((i18 == 0 && i17 == 16) || (i18 == 1 && absoluteGravity == 1)) {
                iT = (t(i10) - iQ) / 2;
            }
            i13 += iT;
        }
        if (this.f3251r == 0) {
            i14 = iQ + i13;
        } else {
            int i19 = iQ + i13;
            int i20 = i13;
            i13 = i11;
            i11 = i20;
            i14 = i12;
            i12 = i19;
        }
        d dVar = (d) view.getLayoutParams();
        layoutDecoratedWithMargins(view, i11, i13, i12, i14);
        Rect rect = f3241g0;
        super.getDecoratedBoundsWithMargins(view, rect);
        int i21 = i11 - rect.left;
        int i22 = i13 - rect.top;
        int i23 = rect.right - i12;
        int i24 = rect.bottom - i14;
        dVar.f3264e = i21;
        dVar.f3265f = i22;
        dVar.f3266g = i23;
        dVar.f3267h = i24;
        T(view);
    }

    public final void F() {
        this.f3258y = null;
        this.f3253t = null;
        this.f3254u = 0;
        this.f3255v = 0;
    }

    public final void G(View view) {
        int childMeasureSpec;
        int childMeasureSpec2;
        d dVar = (d) view.getLayoutParams();
        Rect rect = f3241g0;
        calculateItemDecorationsForChild(view, rect);
        int i10 = ((ViewGroup.MarginLayoutParams) dVar).leftMargin + ((ViewGroup.MarginLayoutParams) dVar).rightMargin + rect.left + rect.right;
        int i11 = ((ViewGroup.MarginLayoutParams) dVar).topMargin + ((ViewGroup.MarginLayoutParams) dVar).bottomMargin + rect.top + rect.bottom;
        int iMakeMeasureSpec = this.K == -2 ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(this.L, 1073741824);
        if (this.f3251r == 0) {
            childMeasureSpec = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i10, ((ViewGroup.MarginLayoutParams) dVar).width);
            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, i11, ((ViewGroup.MarginLayoutParams) dVar).height);
        } else {
            int childMeasureSpec3 = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i11, ((ViewGroup.MarginLayoutParams) dVar).height);
            childMeasureSpec = ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, i10, ((ViewGroup.MarginLayoutParams) dVar).width);
            childMeasureSpec2 = childMeasureSpec3;
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final void H() {
        this.V.prependVisibleItems((this.f3259z & 262144) != 0 ? this.Z + this.f3243a0 + this.f3255v : (-this.f3243a0) - this.f3255v);
    }

    public final void I(boolean z10) {
        if (z10) {
            if (C()) {
                return;
            }
        } else if (B()) {
            return;
        }
        e eVar = this.F;
        if (eVar == null) {
            this.f3250q.stopScroll();
            e eVar2 = new e(z10 ? 1 : -1, this.T > 1);
            this.G = 0;
            startSmoothScroll(eVar2);
            return;
        }
        if (z10) {
            int i10 = eVar.f3273t;
            if (i10 < j.this.f3249p) {
                eVar.f3273t = i10 + 1;
                return;
            }
            return;
        }
        int i11 = eVar.f3273t;
        if (i11 > (-j.this.f3249p)) {
            eVar.f3273t = i11 - 1;
        }
    }

    public final boolean J(boolean z10) {
        if (this.L != 0 || this.M == null) {
            return false;
        }
        i iVar = this.V;
        b0.f[] itemPositionsInRows = iVar == null ? null : iVar.getItemPositionsInRows();
        boolean z11 = false;
        int i10 = -1;
        for (int i11 = 0; i11 < this.T; i11++) {
            b0.f fVar = itemPositionsInRows == null ? null : itemPositionsInRows[i11];
            int size = fVar == null ? 0 : fVar.size();
            int i12 = -1;
            for (int i13 = 0; i13 < size; i13 += 2) {
                int i14 = fVar.get(i13 + 1);
                for (int i15 = fVar.get(i13); i15 <= i14; i15++) {
                    View viewFindViewByPosition = findViewByPosition(i15 - this.f3254u);
                    if (viewFindViewByPosition != null) {
                        if (z10) {
                            G(viewFindViewByPosition);
                        }
                        int iQ = this.f3251r == 0 ? q(viewFindViewByPosition) : r(viewFindViewByPosition);
                        if (iQ > i12) {
                            i12 = iQ;
                        }
                    }
                }
            }
            int itemCount = this.f3253t.getItemCount();
            androidx.leanback.widget.b bVar = this.f3250q;
            if (!bVar.hasFixedSize() && z10 && i12 < 0 && itemCount > 0) {
                if (i10 < 0) {
                    int i16 = this.C;
                    if (i16 < 0) {
                        i16 = 0;
                    } else if (i16 >= itemCount) {
                        i16 = itemCount - 1;
                    }
                    if (getChildCount() > 0) {
                        int layoutPosition = bVar.getChildViewHolder(getChildAt(0)).getLayoutPosition();
                        int layoutPosition2 = bVar.getChildViewHolder(getChildAt(getChildCount() - 1)).getLayoutPosition();
                        if (i16 >= layoutPosition && i16 <= layoutPosition2) {
                            i16 = i16 - layoutPosition <= layoutPosition2 - i16 ? layoutPosition - 1 : layoutPosition2 + 1;
                            if (i16 < 0 && layoutPosition2 < itemCount - 1) {
                                i16 = layoutPosition2 + 1;
                            } else if (i16 >= itemCount && layoutPosition > 0) {
                                i16 = layoutPosition - 1;
                            }
                        }
                    }
                    if (i16 >= 0 && i16 < itemCount) {
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                        View viewForPosition = this.f3258y.getViewForPosition(i16);
                        int[] iArr = this.f3244b0;
                        if (viewForPosition != null) {
                            d dVar = (d) viewForPosition.getLayoutParams();
                            Rect rect = f3241g0;
                            calculateItemDecorationsForChild(viewForPosition, rect);
                            viewForPosition.measure(ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin + ((ViewGroup.MarginLayoutParams) dVar).rightMargin + rect.left + rect.right, ((ViewGroup.MarginLayoutParams) dVar).width), ViewGroup.getChildMeasureSpec(iMakeMeasureSpec2, getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar).topMargin + ((ViewGroup.MarginLayoutParams) dVar).bottomMargin + rect.top + rect.bottom, ((ViewGroup.MarginLayoutParams) dVar).height));
                            iArr[0] = r(viewForPosition);
                            iArr[1] = q(viewForPosition);
                            this.f3258y.recycleView(viewForPosition);
                        }
                        i10 = this.f3251r == 0 ? iArr[1] : iArr[0];
                    }
                }
                if (i10 >= 0) {
                    i12 = i10;
                }
            }
            if (i12 < 0) {
                i12 = 0;
            }
            int[] iArr2 = this.M;
            if (iArr2[i11] != i12) {
                iArr2[i11] = i12;
                z11 = true;
            }
        }
        return z11;
    }

    public final int K(int i10, boolean z10) {
        i iVar = this.V;
        if (iVar == null) {
            return i10;
        }
        int i11 = this.C;
        int rowIndex = i11 != -1 ? iVar.getRowIndex(i11) : -1;
        int childCount = getChildCount();
        View view = null;
        for (int i12 = 0; i12 < childCount && i10 != 0; i12++) {
            int i13 = i10 > 0 ? i12 : (childCount - 1) - i12;
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 0 && (!hasFocus() || childAt.hasFocusable())) {
                int iP = p(getChildAt(i13));
                int rowIndex2 = this.V.getRowIndex(iP);
                if (rowIndex == -1) {
                    i11 = iP;
                    view = childAt;
                    rowIndex = rowIndex2;
                } else if (rowIndex2 == rowIndex && ((i10 > 0 && iP > i11) || (i10 < 0 && iP < i11))) {
                    i10 = i10 > 0 ? i10 - 1 : i10 + 1;
                    i11 = iP;
                    view = childAt;
                }
            }
        }
        if (view != null) {
            if (z10) {
                if (hasFocus()) {
                    this.f3259z |= 32;
                    view.requestFocus();
                    this.f3259z &= -33;
                }
                this.C = i11;
                this.D = 0;
            } else {
                R(view, view.findFocus(), true, 0, 0);
            }
        }
        return i10;
    }

    public final void L() {
        int i10 = this.f3259z;
        if ((65600 & i10) == 65536) {
            this.V.removeInvisibleItemsAtEnd(this.C, (i10 & 262144) != 0 ? -this.f3243a0 : this.Z + this.f3243a0);
        }
    }

    public final void M() {
        int i10 = this.f3259z;
        if ((65600 & i10) == 65536) {
            this.V.removeInvisibleItemsAtFront(this.C, (i10 & 262144) != 0 ? this.Z + this.f3243a0 : -this.f3243a0);
        }
    }

    public final void N(RecyclerView.r rVar, RecyclerView.w wVar) {
        if (this.f3258y != null || this.f3253t != null) {
            Log.e("GridLayoutManager", "Recycler information was not released, bug!");
        }
        this.f3258y = rVar;
        this.f3253t = wVar;
        this.f3254u = 0;
        this.f3255v = 0;
    }

    public final int O(int i10) {
        int minScroll;
        int i11 = this.f3259z;
        if ((i11 & 64) == 0 && (i11 & 3) != 1) {
            c1 c1Var = this.X;
            if (i10 <= 0 ? !(i10 >= 0 || c1Var.mainAxis().isMinUnknown() || i10 >= (minScroll = c1Var.mainAxis().getMinScroll())) : !(c1Var.mainAxis().isMaxUnknown() || i10 <= (minScroll = c1Var.mainAxis().getMaxScroll()))) {
                i10 = minScroll;
            }
        }
        if (i10 == 0) {
            return 0;
        }
        int i12 = -i10;
        int childCount = getChildCount();
        if (this.f3251r == 1) {
            for (int i13 = 0; i13 < childCount; i13++) {
                getChildAt(i13).offsetTopAndBottom(i12);
            }
        } else {
            for (int i14 = 0; i14 < childCount; i14++) {
                getChildAt(i14).offsetLeftAndRight(i12);
            }
        }
        if ((this.f3259z & 3) == 1) {
            V();
            return i10;
        }
        int childCount2 = getChildCount();
        if ((this.f3259z & 262144) == 0 ? i10 >= 0 : i10 <= 0) {
            m();
        } else {
            H();
        }
        boolean z10 = getChildCount() > childCount2;
        int childCount3 = getChildCount();
        if ((262144 & this.f3259z) == 0 ? i10 >= 0 : i10 <= 0) {
            M();
        } else {
            L();
        }
        boolean z11 = z10 | (getChildCount() < childCount3);
        androidx.leanback.widget.b bVar = this.f3250q;
        if (z11) {
            int i15 = (J(false) ? 1024 : 0) | (this.f3259z & (-1025));
            this.f3259z = i15;
            if ((i15 & 1024) != 0) {
                x0.j0.postOnAnimation(bVar, this.f3247e0);
            }
        }
        bVar.invalidate();
        V();
        return i10;
    }

    public final int P(int i10) {
        int i11 = 0;
        if (i10 == 0) {
            return 0;
        }
        int i12 = -i10;
        int childCount = getChildCount();
        if (this.f3251r == 0) {
            while (i11 < childCount) {
                getChildAt(i11).offsetTopAndBottom(i12);
                i11++;
            }
        } else {
            while (i11 < childCount) {
                getChildAt(i11).offsetLeftAndRight(i12);
                i11++;
            }
        }
        this.J += i10;
        W();
        this.f3250q.invalidate();
        return i10;
    }

    public final void Q(int i10, int i11, int i12, boolean z10) {
        this.H = i12;
        View viewFindViewByPosition = findViewByPosition(i10);
        boolean z11 = !isSmoothScrolling();
        androidx.leanback.widget.b bVar = this.f3250q;
        if (z11 && !bVar.isLayoutRequested() && viewFindViewByPosition != null && p(viewFindViewByPosition) == i10) {
            this.f3259z |= 32;
            R(viewFindViewByPosition, viewFindViewByPosition.findFocus(), z10, 0, 0);
            this.f3259z &= -33;
            return;
        }
        int i13 = this.f3259z;
        if ((i13 & 512) == 0 || (i13 & 64) != 0) {
            this.C = i10;
            this.D = i11;
            this.G = Integer.MIN_VALUE;
            return;
        }
        if (z10 && !bVar.isLayoutRequested()) {
            this.C = i10;
            this.D = i11;
            this.G = Integer.MIN_VALUE;
            if (!hasDoneFirstLayout()) {
                Log.w("GridLayoutManager:" + bVar.getId(), "setSelectionSmooth should not be called before first layout pass");
                return;
            }
            k kVar = new k(this);
            kVar.setTargetPosition(i10);
            startSmoothScroll(kVar);
            int targetPosition = kVar.getTargetPosition();
            if (targetPosition != this.C) {
                this.C = targetPosition;
                this.D = 0;
                return;
            }
            return;
        }
        if (!z11) {
            c cVar = this.E;
            if (cVar != null) {
                cVar.f3262q = true;
            }
            bVar.stopScroll();
        }
        if (!bVar.isLayoutRequested() && viewFindViewByPosition != null && p(viewFindViewByPosition) == i10) {
            this.f3259z |= 32;
            R(viewFindViewByPosition, viewFindViewByPosition.findFocus(), z10, 0, 0);
            this.f3259z &= -33;
        } else {
            this.C = i10;
            this.D = i11;
            this.G = Integer.MIN_VALUE;
            this.f3259z |= 256;
            requestLayout();
        }
    }

    public final void R(View view, View view2, boolean z10, int i10, int i11) {
        if ((this.f3259z & 64) != 0) {
            return;
        }
        int iP = p(view);
        int iY = y(view, view2);
        int i12 = this.C;
        androidx.leanback.widget.b bVar = this.f3250q;
        if (iP != i12 || iY != this.D) {
            this.C = iP;
            this.D = iY;
            this.G = 0;
            if ((this.f3259z & 3) != 1) {
                n();
            }
            if (bVar.Y()) {
                bVar.invalidate();
            }
        }
        if (view == null) {
            return;
        }
        if (!view.hasFocus() && bVar.hasFocus()) {
            view.requestFocus();
        }
        if ((this.f3259z & 131072) == 0 && z10) {
            return;
        }
        int[] iArr = f3242h0;
        if (!v(view, view2, iArr) && i10 == 0 && i11 == 0) {
            return;
        }
        int i13 = iArr[0] + i10;
        int i14 = iArr[1] + i11;
        if ((this.f3259z & 3) == 1) {
            O(i13);
            P(i14);
            return;
        }
        if (this.f3251r != 0) {
            i14 = i13;
            i13 = i14;
        }
        if (z10) {
            bVar.smoothScrollBy(i13, i14);
        } else {
            bVar.scrollBy(i13, i14);
            o();
        }
    }

    public final void S() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            T(getChildAt(i10));
        }
    }

    public final void T(View view) {
        d dVar = (d) view.getLayoutParams();
        q qVar = dVar.f3271l;
        p pVar = this.Y;
        if (qVar == null) {
            dVar.f3268i = pVar.f3314b.getAlignmentPosition(view);
            dVar.f3269j = pVar.f3313a.getAlignmentPosition(view);
            return;
        }
        int i10 = this.f3251r;
        q.a[] alignmentDefs = qVar.getAlignmentDefs();
        int[] iArr = dVar.f3270k;
        if (iArr == null || iArr.length != alignmentDefs.length) {
            dVar.f3270k = new int[alignmentDefs.length];
        }
        for (int i11 = 0; i11 < alignmentDefs.length; i11++) {
            dVar.f3270k[i11] = r.a(view, alignmentDefs[i11], i10);
        }
        if (i10 == 0) {
            dVar.f3268i = dVar.f3270k[0];
        } else {
            dVar.f3269j = dVar.f3270k[0];
        }
        if (this.f3251r == 0) {
            dVar.f3269j = pVar.f3313a.getAlignmentPosition(view);
        } else {
            dVar.f3268i = pVar.f3314b.getAlignmentPosition(view);
        }
    }

    public final void U() {
        if (getChildCount() <= 0) {
            this.f3254u = 0;
        } else {
            this.f3254u = this.V.getFirstVisibleIndex() - ((d) getChildAt(0).getLayoutParams()).getViewLayoutPosition();
        }
    }

    public final void V() {
        int firstVisibleIndex;
        int lastVisibleIndex;
        int itemCount;
        int itemCount2;
        int iFindRowMax;
        int i10;
        int iFindRowMin;
        int i11;
        int top;
        int i12;
        int top2;
        int i13;
        if (this.f3253t.getItemCount() == 0) {
            return;
        }
        if ((this.f3259z & 262144) == 0) {
            firstVisibleIndex = this.V.getLastVisibleIndex();
            itemCount2 = this.f3253t.getItemCount() - 1;
            lastVisibleIndex = this.V.getFirstVisibleIndex();
            itemCount = 0;
        } else {
            firstVisibleIndex = this.V.getFirstVisibleIndex();
            lastVisibleIndex = this.V.getLastVisibleIndex();
            itemCount = this.f3253t.getItemCount() - 1;
            itemCount2 = 0;
        }
        if (firstVisibleIndex < 0 || lastVisibleIndex < 0) {
            return;
        }
        boolean z10 = firstVisibleIndex == itemCount2;
        boolean z11 = lastVisibleIndex == itemCount;
        c1 c1Var = this.X;
        if (z10 || !c1Var.mainAxis().isMaxUnknown() || z11 || !c1Var.mainAxis().isMinUnknown()) {
            int[] iArr = f3242h0;
            if (z10) {
                iFindRowMax = this.V.findRowMax(true, iArr);
                View viewFindViewByPosition = findViewByPosition(iArr[1]);
                if (this.f3251r == 0) {
                    d dVar = (d) viewFindViewByPosition.getLayoutParams();
                    dVar.getClass();
                    top2 = viewFindViewByPosition.getLeft() + dVar.f3264e;
                    i13 = dVar.f3268i;
                } else {
                    d dVar2 = (d) viewFindViewByPosition.getLayoutParams();
                    dVar2.getClass();
                    top2 = viewFindViewByPosition.getTop() + dVar2.f3265f;
                    i13 = dVar2.f3269j;
                }
                i10 = top2 + i13;
                int[] iArr2 = ((d) viewFindViewByPosition.getLayoutParams()).f3270k;
                if (iArr2 != null && iArr2.length > 0) {
                    i10 += iArr2[iArr2.length - 1] - iArr2[0];
                }
            } else {
                iFindRowMax = Integer.MAX_VALUE;
                i10 = Integer.MAX_VALUE;
            }
            if (z11) {
                iFindRowMin = this.V.findRowMin(false, iArr);
                View viewFindViewByPosition2 = findViewByPosition(iArr[1]);
                if (this.f3251r == 0) {
                    d dVar3 = (d) viewFindViewByPosition2.getLayoutParams();
                    dVar3.getClass();
                    top = viewFindViewByPosition2.getLeft() + dVar3.f3264e;
                    i12 = dVar3.f3268i;
                } else {
                    d dVar4 = (d) viewFindViewByPosition2.getLayoutParams();
                    dVar4.getClass();
                    top = viewFindViewByPosition2.getTop() + dVar4.f3265f;
                    i12 = dVar4.f3269j;
                }
                i11 = top + i12;
            } else {
                iFindRowMin = Integer.MIN_VALUE;
                i11 = Integer.MIN_VALUE;
            }
            c1Var.mainAxis().updateMinMax(iFindRowMin, iFindRowMax, i11, i10);
        }
    }

    public final void W() {
        c1.a aVarSecondAxis = this.X.secondAxis();
        int paddingMin = aVarSecondAxis.getPaddingMin() - this.J;
        int iX = x() + paddingMin;
        aVarSecondAxis.updateMinMax(paddingMin, iX, paddingMin, iX);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean canScrollHorizontally() {
        return this.f3251r == 0 || this.T > 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean canScrollVertically() {
        return this.f3251r == 1 || this.T > 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.w wVar, RecyclerView.l.c cVar) {
        try {
            N(null, wVar);
            if (this.f3251r != 0) {
                i10 = i11;
            }
            if (getChildCount() != 0 && i10 != 0) {
                this.V.collectAdjacentPrefetchPositions(i10 < 0 ? -this.f3243a0 : this.Z + this.f3243a0, i10, cVar);
            }
        } finally {
            F();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void collectInitialPrefetchPositions(int i10, RecyclerView.l.c cVar) {
        int i11 = this.f3250q.W0;
        if (i10 == 0 || i11 == 0) {
            return;
        }
        int iMax = Math.max(0, Math.min(this.C - ((i11 - 1) / 2), i10 - i11));
        for (int i12 = iMax; i12 < i10 && i12 < iMax + i11; i12++) {
            ((k.b) cVar).addPosition(i12, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m generateDefaultLayoutParams() {
        return new d(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new d(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int getColumnCountForAccessibility(RecyclerView.r rVar, RecyclerView.w wVar) {
        i iVar;
        return (this.f3251r != 1 || (iVar = this.V) == null) ? super.getColumnCountForAccessibility(rVar, wVar) : iVar.getNumRows();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int getDecoratedBottom(View view) {
        return super.getDecoratedBottom(view) - ((d) view.getLayoutParams()).f3267h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        d dVar = (d) view.getLayoutParams();
        rect.left += dVar.f3264e;
        rect.top += dVar.f3265f;
        rect.right -= dVar.f3266g;
        rect.bottom -= dVar.f3267h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int getDecoratedLeft(View view) {
        return super.getDecoratedLeft(view) + ((d) view.getLayoutParams()).f3264e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int getDecoratedRight(View view) {
        return super.getDecoratedRight(view) - ((d) view.getLayoutParams()).f3266g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int getDecoratedTop(View view) {
        return super.getDecoratedTop(view) + ((d) view.getLayoutParams()).f3265f;
    }

    public int getFocusScrollStrategy() {
        return this.W;
    }

    public int getHorizontalSpacing() {
        return this.O;
    }

    public int getItemAlignmentOffset() {
        return this.Y.mainAxis().getItemAlignmentOffset();
    }

    public float getItemAlignmentOffsetPercent() {
        return this.Y.mainAxis().getItemAlignmentOffsetPercent();
    }

    public int getItemAlignmentViewId() {
        return this.Y.mainAxis().getItemAlignmentViewId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int getRowCountForAccessibility(RecyclerView.r rVar, RecyclerView.w wVar) {
        i iVar;
        return (this.f3251r != 0 || (iVar = this.V) == null) ? super.getRowCountForAccessibility(rVar, wVar) : iVar.getNumRows();
    }

    public int getSelection() {
        return this.C;
    }

    public int getSubSelection() {
        return this.D;
    }

    public int getVerticalSpacing() {
        return this.P;
    }

    public View getViewForPosition(int i10) {
        return this.f3258y.getViewForPosition(i10);
    }

    public int getWindowAlignment() {
        return this.X.mainAxis().getWindowAlignment();
    }

    public int getWindowAlignmentOffset() {
        return this.X.mainAxis().getWindowAlignmentOffset();
    }

    public float getWindowAlignmentOffsetPercent() {
        return this.X.mainAxis().getWindowAlignmentOffsetPercent();
    }

    public boolean hasDoneFirstLayout() {
        return this.V != null;
    }

    public boolean isScrollEnabled() {
        return (this.f3259z & 131072) != 0;
    }

    public final void m() {
        this.V.appendVisibleItems((this.f3259z & 262144) != 0 ? (-this.f3243a0) - this.f3255v : this.Z + this.f3243a0 + this.f3255v);
    }

    public final void n() {
        if (this.A == null) {
            ArrayList<b0> arrayList = this.B;
            if (!(arrayList != null && arrayList.size() > 0)) {
                return;
            }
        }
        int i10 = this.C;
        View viewFindViewByPosition = i10 == -1 ? null : findViewByPosition(i10);
        androidx.leanback.widget.b bVar = this.f3250q;
        if (viewFindViewByPosition != null) {
            RecyclerView.z childViewHolder = bVar.getChildViewHolder(viewFindViewByPosition);
            a0 a0Var = this.A;
            if (a0Var != null) {
                ((v.a) a0Var).onChildSelected(this.f3250q, viewFindViewByPosition, this.C, childViewHolder == null ? -1L : childViewHolder.getItemId());
            }
            int i11 = this.C;
            int i12 = this.D;
            ArrayList<b0> arrayList2 = this.B;
            if (arrayList2 != null) {
                int size = arrayList2.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    } else {
                        this.B.get(size).onChildViewHolderSelected(bVar, childViewHolder, i11, i12);
                    }
                }
            }
        } else {
            a0 a0Var2 = this.A;
            if (a0Var2 != null) {
                ((v.a) a0Var2).onChildSelected(bVar, null, -1, -1L);
            }
            ArrayList<b0> arrayList3 = this.B;
            if (arrayList3 != null) {
                int size2 = arrayList3.size();
                while (true) {
                    size2--;
                    if (size2 < 0) {
                        break;
                    } else {
                        this.B.get(size2).onChildViewHolderSelected(bVar, null, -1, 0);
                    }
                }
            }
        }
        if ((this.f3259z & 3) == 1 || bVar.isLayoutRequested()) {
            return;
        }
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            if (getChildAt(i13).isLayoutRequested()) {
                x0.j0.postOnAnimation(this.f3250q, this.f3247e0);
                return;
            }
        }
    }

    public final void o() {
        ArrayList<b0> arrayList = this.B;
        if (!(arrayList != null && arrayList.size() > 0)) {
            return;
        }
        int i10 = this.C;
        View viewFindViewByPosition = i10 == -1 ? null : findViewByPosition(i10);
        androidx.leanback.widget.b bVar = this.f3250q;
        if (viewFindViewByPosition != null) {
            RecyclerView.z childViewHolder = bVar.getChildViewHolder(viewFindViewByPosition);
            int i11 = this.C;
            int i12 = this.D;
            ArrayList<b0> arrayList2 = this.B;
            if (arrayList2 == null) {
                return;
            }
            int size = arrayList2.size();
            while (true) {
                size--;
                if (size < 0) {
                    return;
                } else {
                    this.B.get(size).onChildViewHolderSelectedAndPositioned(bVar, childViewHolder, i11, i12);
                }
            }
        } else {
            a0 a0Var = this.A;
            if (a0Var != null) {
                ((v.a) a0Var).onChildSelected(bVar, null, -1, -1L);
            }
            ArrayList<b0> arrayList3 = this.B;
            if (arrayList3 == null) {
                return;
            }
            int size2 = arrayList3.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return;
                } else {
                    this.B.get(size2).onChildViewHolderSelectedAndPositioned(bVar, null, -1, 0);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        if (adapter != null) {
            this.V = null;
            this.M = null;
            this.f3259z &= -1025;
            this.C = -1;
            this.G = 0;
            this.f3245c0.clear();
        }
        if (adapter2 instanceof androidx.leanback.widget.f) {
            this.f3246d0 = (androidx.leanback.widget.f) adapter2;
        } else {
            this.f3246d0 = null;
        }
        super.onAdapterChanged(adapter, adapter2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00af  */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onAddFocusables(androidx.recyclerview.widget.RecyclerView r18, java.util.ArrayList<android.view.View> r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.j.onAddFocusables(androidx.recyclerview.widget.RecyclerView, java.util.ArrayList, int, int):boolean");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onInitializeAccessibilityNodeInfo(RecyclerView.r rVar, RecyclerView.w wVar, y0.d dVar) {
        N(rVar, wVar);
        int itemCount = wVar.getItemCount();
        boolean z10 = (this.f3259z & 262144) != 0;
        if (itemCount > 1 && !D(0)) {
            if (Build.VERSION.SDK_INT < 23) {
                dVar.addAction(8192);
            } else if (this.f3251r == 0) {
                dVar.addAction(z10 ? d.a.f21831p : d.a.f21829n);
            } else {
                dVar.addAction(d.a.f21828m);
            }
            dVar.setScrollable(true);
        }
        if (itemCount > 1 && !D(itemCount - 1)) {
            if (Build.VERSION.SDK_INT < 23) {
                dVar.addAction(4096);
            } else if (this.f3251r == 0) {
                dVar.addAction(z10 ? d.a.f21829n : d.a.f21831p);
            } else {
                dVar.addAction(d.a.f21830o);
            }
            dVar.setScrollable(true);
        }
        dVar.setCollectionInfo(d.e.obtain(getRowCountForAccessibility(rVar, wVar), getColumnCountForAccessibility(rVar, wVar), isLayoutHierarchical(rVar, wVar), getSelectionModeForAccessibility(rVar, wVar)));
        F();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.r rVar, RecyclerView.w wVar, View view, y0.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.V == null || !(layoutParams instanceof d)) {
            return;
        }
        int viewAdapterPosition = ((d) layoutParams).getViewAdapterPosition();
        int rowIndex = viewAdapterPosition >= 0 ? this.V.getRowIndex(viewAdapterPosition) : -1;
        if (rowIndex < 0) {
            return;
        }
        int numRows = viewAdapterPosition / this.V.getNumRows();
        if (this.f3251r == 0) {
            dVar.setCollectionItemInfo(d.f.obtain(rowIndex, 1, numRows, 1, false, false));
        } else {
            dVar.setCollectionItemInfo(d.f.obtain(numRows, 1, rowIndex, 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public View onInterceptFocusSearch(View view, int i10) {
        View viewFindNextFocus;
        View viewFindNextFocus2;
        if ((this.f3259z & 32768) != 0) {
            return view;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        androidx.leanback.widget.b bVar = this.f3250q;
        if (i10 == 2 || i10 == 1) {
            if (canScrollVertically()) {
                viewFindNextFocus = focusFinder.findNextFocus(bVar, view, i10 == 2 ? 130 : 33);
            } else {
                viewFindNextFocus = null;
            }
            if (canScrollHorizontally()) {
                viewFindNextFocus2 = focusFinder.findNextFocus(bVar, view, (getLayoutDirection() == 1) ^ (i10 == 2) ? 66 : 17);
            } else {
                viewFindNextFocus2 = viewFindNextFocus;
            }
        } else {
            viewFindNextFocus2 = focusFinder.findNextFocus(bVar, view, i10);
        }
        if (viewFindNextFocus2 != null) {
            return viewFindNextFocus2;
        }
        if (bVar.getDescendantFocusability() == 393216) {
            return bVar.getParent().focusSearch(view, i10);
        }
        int iS = s(i10);
        boolean z10 = bVar.getScrollState() != 0;
        if (iS == 1) {
            if (z10 || (this.f3259z & 4096) == 0) {
                viewFindNextFocus2 = view;
            }
            if ((this.f3259z & 131072) != 0 && !C()) {
                I(true);
                viewFindNextFocus2 = view;
            }
        } else if (iS == 0) {
            if (z10 || (this.f3259z & 2048) == 0) {
                viewFindNextFocus2 = view;
            }
            if ((this.f3259z & 131072) != 0 && !B()) {
                I(false);
                viewFindNextFocus2 = view;
            }
        } else if (iS == 3) {
        }
        if (viewFindNextFocus2 != null) {
            return viewFindNextFocus2;
        }
        View viewFocusSearch = bVar.getParent().focusSearch(view, i10);
        return viewFocusSearch != null ? viewFocusSearch : view != null ? view : bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        i iVar;
        int i12;
        if (this.C != -1 && (iVar = this.V) != null && iVar.getFirstVisibleIndex() >= 0 && (i12 = this.G) != Integer.MIN_VALUE && i10 <= this.C + i12) {
            this.G = i12 + i11;
        }
        this.f3245c0.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsChanged(RecyclerView recyclerView) {
        this.G = 0;
        this.f3245c0.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        int i13;
        int i14 = this.C;
        if (i14 != -1 && (i13 = this.G) != Integer.MIN_VALUE) {
            int i15 = i14 + i13;
            if (i10 <= i15 && i15 < i10 + i12) {
                this.G = (i11 - i10) + i13;
            } else if (i10 < i15 && i11 > i15 - i12) {
                this.G = i13 - i12;
            } else if (i10 > i15 && i11 < i15) {
                this.G = i13 + i12;
            }
        }
        this.f3245c0.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        i iVar;
        int i12;
        int i13;
        int i14;
        if (this.C != -1 && (iVar = this.V) != null && iVar.getFirstVisibleIndex() >= 0 && (i12 = this.G) != Integer.MIN_VALUE && i10 <= (i14 = (i13 = this.C) + i12)) {
            if (i10 + i11 > i14) {
                this.C = (i10 - i14) + i12 + i13;
                this.G = Integer.MIN_VALUE;
            } else {
                this.G = i12 - i11;
            }
        }
        this.f3245c0.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12) {
            this.f3245c0.remove(i10);
            i10++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x05ba A[PHI: r0 r1
  0x05ba: PHI (r0v52 int) = (r0v48 int), (r0v55 int) binds: [B:283:0x05b8, B:271:0x0585] A[DONT_GENERATE, DONT_INLINE]
  0x05ba: PHI (r1v23 int) = (r1v19 int), (r1v27 int) binds: [B:283:0x05b8, B:271:0x0585] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.r r24, androidx.recyclerview.widget.RecyclerView.w r25) {
        /*
            Method dump skipped, instructions count: 1508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.j.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onMeasure(RecyclerView.r rVar, RecyclerView.w wVar, int i10, int i11) {
        int size;
        int size2;
        int mode;
        int paddingLeft;
        int paddingRight;
        int iX;
        N(rVar, wVar);
        if (this.f3251r == 0) {
            size2 = View.MeasureSpec.getSize(i10);
            size = View.MeasureSpec.getSize(i11);
            mode = View.MeasureSpec.getMode(i11);
            paddingLeft = getPaddingTop();
            paddingRight = getPaddingBottom();
        } else {
            size = View.MeasureSpec.getSize(i10);
            size2 = View.MeasureSpec.getSize(i11);
            mode = View.MeasureSpec.getMode(i10);
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        int i12 = paddingRight + paddingLeft;
        this.N = size;
        int i13 = this.K;
        if (i13 == -2) {
            int i14 = this.U;
            if (i14 == 0) {
                i14 = 1;
            }
            this.T = i14;
            this.L = 0;
            int[] iArr = this.M;
            if (iArr == null || iArr.length != i14) {
                this.M = new int[i14];
            }
            if (this.f3253t.isPreLayout()) {
                U();
            }
            J(true);
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(x() + i12, this.N);
            } else if (mode == 0) {
                iX = x();
                size = iX + i12;
            } else {
                if (mode != 1073741824) {
                    throw new IllegalStateException("wrong spec");
                }
                size = this.N;
            }
        } else {
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    if (i13 == 0) {
                        i13 = size - i12;
                    }
                    this.L = i13;
                    int i15 = this.U;
                    if (i15 == 0) {
                        i15 = 1;
                    }
                    this.T = i15;
                    iX = ((i15 - 1) * this.R) + (i13 * i15);
                    size = iX + i12;
                } else if (mode != 1073741824) {
                    throw new IllegalStateException("wrong spec");
                }
            }
            int i16 = this.U;
            if (i16 == 0 && i13 == 0) {
                this.T = 1;
                this.L = size - i12;
            } else if (i16 == 0) {
                this.L = i13;
                int i17 = this.R;
                this.T = (size + i17) / (i13 + i17);
            } else if (i13 == 0) {
                this.T = i16;
                this.L = ((size - i12) - ((i16 - 1) * this.R)) / i16;
            } else {
                this.T = i16;
                this.L = i13;
            }
            if (mode == Integer.MIN_VALUE) {
                int i18 = this.L;
                int i19 = this.T;
                int i20 = ((i19 - 1) * this.R) + (i18 * i19) + i12;
                if (i20 < size) {
                    size = i20;
                }
            }
        }
        if (this.f3251r == 0) {
            setMeasuredDimension(size2, size);
        } else {
            setMeasuredDimension(size, size2);
        }
        F();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
        if ((this.f3259z & 32768) == 0 && p(view) != -1 && (this.f3259z & 35) == 0) {
            R(view, view2, true, 0, 0);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof f) {
            f fVar = (f) parcelable;
            this.C = fVar.f3275b;
            this.G = 0;
            this.f3245c0.loadFromBundle(fVar.f3276m);
            this.f3259z |= 256;
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onRtlPropertiesChanged(int r6) {
        /*
            r5 = this;
            int r0 = r5.f3251r
            r1 = 0
            r2 = 1
            if (r0 != 0) goto Ld
            if (r6 != r2) goto Lb
            r0 = 262144(0x40000, float:3.67342E-40)
            goto L11
        Lb:
            r0 = 0
            goto L11
        Ld:
            if (r6 != r2) goto Lb
            r0 = 524288(0x80000, float:7.34684E-40)
        L11:
            int r3 = r5.f3259z
            r4 = 786432(0xc0000, float:1.102026E-39)
            r4 = r4 & r3
            if (r4 != r0) goto L19
            return
        L19:
            r4 = -786433(0xfffffffffff3ffff, float:NaN)
            r3 = r3 & r4
            r0 = r0 | r3
            r0 = r0 | 256(0x100, float:3.59E-43)
            r5.f3259z = r0
            androidx.leanback.widget.c1 r0 = r5.X
            androidx.leanback.widget.c1$a r0 = r0.f3199b
            if (r6 != r2) goto L29
            r1 = 1
        L29:
            r0.setReversedFlow(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.j.onRtlPropertiesChanged(int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public Parcelable onSaveInstanceState() {
        f fVar = new f();
        fVar.f3275b = getSelection();
        b1 b1Var = this.f3245c0;
        Bundle bundleSaveAsBundle = b1Var.saveAsBundle();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int iP = p(childAt);
            if (iP != -1) {
                bundleSaveAsBundle = b1Var.saveOnScreenView(bundleSaveAsBundle, childAt, iP);
            }
        }
        fVar.f3276m = bundleSaveAsBundle;
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean performAccessibilityAction(androidx.recyclerview.widget.RecyclerView.r r5, androidx.recyclerview.widget.RecyclerView.w r6, int r7, android.os.Bundle r8) {
        /*
            r4 = this;
            boolean r8 = r4.isScrollEnabled()
            r0 = 1
            if (r8 != 0) goto L8
            return r0
        L8:
            r4.N(r5, r6)
            int r5 = r4.f3259z
            r6 = 262144(0x40000, float:3.67342E-40)
            r5 = r5 & r6
            r6 = 0
            if (r5 == 0) goto L15
            r5 = 1
            goto L16
        L15:
            r5 = 0
        L16:
            int r8 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            r2 = 8192(0x2000, float:1.148E-41)
            r3 = 4096(0x1000, float:5.74E-42)
            if (r8 < r1) goto L51
            int r8 = r4.f3251r
            if (r8 != 0) goto L3f
            y0.d$a r8 = y0.d.a.f21829n
            int r8 = r8.getId()
            if (r7 != r8) goto L34
            if (r5 == 0) goto L31
        L2e:
            r7 = 4096(0x1000, float:5.74E-42)
            goto L51
        L31:
            r7 = 8192(0x2000, float:1.148E-41)
            goto L51
        L34:
            y0.d$a r8 = y0.d.a.f21831p
            int r8 = r8.getId()
            if (r7 != r8) goto L51
            if (r5 == 0) goto L2e
            goto L31
        L3f:
            y0.d$a r5 = y0.d.a.f21828m
            int r5 = r5.getId()
            if (r7 != r5) goto L48
            goto L31
        L48:
            y0.d$a r5 = y0.d.a.f21830o
            int r5 = r5.getId()
            if (r7 != r5) goto L51
            goto L2e
        L51:
            if (r7 == r3) goto L5e
            if (r7 == r2) goto L56
            goto L64
        L56:
            r4.I(r6)
            r5 = -1
            r4.K(r5, r6)
            goto L64
        L5e:
            r4.I(r0)
            r4.K(r0, r6)
        L64:
            r4.F()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.j.performAccessibilityAction(androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w, int, android.os.Bundle):boolean");
    }

    public final int q(View view) {
        d dVar = (d) view.getLayoutParams();
        return getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) dVar).topMargin + ((ViewGroup.MarginLayoutParams) dVar).bottomMargin;
    }

    public final int r(View view) {
        d dVar = (d) view.getLayoutParams();
        return getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) dVar).leftMargin + ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void removeAndRecycleAllViews(RecyclerView.r rVar) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            removeAndRecycleViewAt(childCount, rVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0023 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int s(int r10) {
        /*
            r9 = this;
            int r0 = r9.f3251r
            r1 = 130(0x82, float:1.82E-43)
            r2 = 66
            r3 = 33
            r4 = 0
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 17
            if (r0 != 0) goto L2b
            r0 = 262144(0x40000, float:3.67342E-40)
            if (r10 == r8) goto L25
            if (r10 == r3) goto L23
            if (r10 == r2) goto L1d
            if (r10 == r1) goto L1b
            goto L46
        L1b:
            r4 = 3
            goto L48
        L1d:
            int r10 = r9.f3259z
            r10 = r10 & r0
            if (r10 != 0) goto L48
            goto L38
        L23:
            r4 = 2
            goto L48
        L25:
            int r10 = r9.f3259z
            r10 = r10 & r0
            if (r10 != 0) goto L38
            goto L48
        L2b:
            if (r0 != r7) goto L46
            r0 = 524288(0x80000, float:7.34684E-40)
            if (r10 == r8) goto L40
            if (r10 == r3) goto L48
            if (r10 == r2) goto L3a
            if (r10 == r1) goto L38
            goto L46
        L38:
            r4 = 1
            goto L48
        L3a:
            int r10 = r9.f3259z
            r10 = r10 & r0
            if (r10 != 0) goto L23
            goto L1b
        L40:
            int r10 = r9.f3259z
            r10 = r10 & r0
            if (r10 != 0) goto L1b
            goto L23
        L46:
            r4 = 17
        L48:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.j.s(int):int");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int scrollHorizontallyBy(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        if ((this.f3259z & 512) == 0 || !hasDoneFirstLayout()) {
            return 0;
        }
        N(rVar, wVar);
        this.f3259z = (this.f3259z & (-4)) | 2;
        int iO = this.f3251r == 0 ? O(i10) : P(i10);
        F();
        this.f3259z &= -4;
        return iO;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void scrollToPosition(int i10) {
        setSelection(i10, 0, false, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int scrollVerticallyBy(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        if ((this.f3259z & 512) == 0 || !hasDoneFirstLayout()) {
            return 0;
        }
        this.f3259z = (this.f3259z & (-4)) | 2;
        N(rVar, wVar);
        int iO = this.f3251r == 1 ? O(i10) : P(i10);
        F();
        this.f3259z &= -4;
        return iO;
    }

    public void setFocusOutAllowed(boolean z10, boolean z11) {
        this.f3259z = (z10 ? 2048 : 0) | (this.f3259z & (-6145)) | (z11 ? 4096 : 0);
    }

    public void setFocusOutSideAllowed(boolean z10, boolean z11) {
        this.f3259z = (z10 ? 8192 : 0) | (this.f3259z & (-24577)) | (z11 ? Http2.INITIAL_MAX_FRAME_SIZE : 0);
    }

    public void setFocusScrollStrategy(int i10) {
        this.W = i10;
    }

    public void setGravity(int i10) {
        this.S = i10;
    }

    public void setHorizontalSpacing(int i10) {
        if (this.f3251r == 0) {
            this.O = i10;
            this.Q = i10;
        } else {
            this.O = i10;
            this.R = i10;
        }
    }

    public void setItemAlignmentOffset(int i10) {
        this.Y.mainAxis().setItemAlignmentOffset(i10);
        S();
    }

    public void setItemAlignmentOffsetPercent(float f10) {
        this.Y.mainAxis().setItemAlignmentOffsetPercent(f10);
        S();
    }

    public void setItemAlignmentOffsetWithPadding(boolean z10) {
        this.Y.mainAxis().setItemAlignmentOffsetWithPadding(z10);
        S();
    }

    public void setItemAlignmentViewId(int i10) {
        this.Y.mainAxis().setItemAlignmentViewId(i10);
        S();
    }

    public void setItemSpacing(int i10) {
        this.O = i10;
        this.P = i10;
        this.R = i10;
        this.Q = i10;
    }

    public void setLayoutEnabled(boolean z10) {
        int i10 = this.f3259z;
        if (((i10 & 512) != 0) != z10) {
            this.f3259z = (i10 & (-513)) | (z10 ? 512 : 0);
            requestLayout();
        }
    }

    public void setNumRows(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        this.U = i10;
    }

    public void setOnChildSelectedListener(a0 a0Var) {
        this.A = a0Var;
    }

    public void setOnChildViewHolderSelectedListener(b0 b0Var) {
        if (b0Var == null) {
            this.B = null;
            return;
        }
        ArrayList<b0> arrayList = this.B;
        if (arrayList == null) {
            this.B = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        this.B.add(b0Var);
    }

    public void setOrientation(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.f3251r = i10;
            this.f3252s = androidx.recyclerview.widget.o.createOrientationHelper(this, i10);
            this.X.setOrientation(i10);
            this.Y.setOrientation(i10);
            this.f3259z |= 256;
        }
    }

    public void setPruneChild(boolean z10) {
        int i10 = this.f3259z;
        if (((i10 & 65536) != 0) != z10) {
            this.f3259z = (i10 & (-65537)) | (z10 ? 65536 : 0);
            if (z10) {
                requestLayout();
            }
        }
    }

    public void setRowHeight(int i10) {
        if (i10 < 0 && i10 != -2) {
            throw new IllegalArgumentException(ac.c.f("Invalid row height: ", i10));
        }
        this.K = i10;
    }

    public void setScrollEnabled(boolean z10) {
        int i10;
        int i11 = this.f3259z;
        if (((i11 & 131072) != 0) != z10) {
            int i12 = (i11 & (-131073)) | (z10 ? 131072 : 0);
            this.f3259z = i12;
            if ((i12 & 131072) == 0 || this.W != 0 || (i10 = this.C) == -1) {
                return;
            }
            Q(i10, this.D, this.H, true);
        }
    }

    public void setSelection(int i10, int i11) {
        setSelection(i10, 0, false, i11);
    }

    public void setSelectionSmooth(int i10) {
        setSelection(i10, 0, true, 0);
    }

    public void setSelectionWithSub(int i10, int i11, int i12) {
        setSelection(i10, i11, false, i12);
    }

    public void setVerticalSpacing(int i10) {
        if (this.f3251r == 1) {
            this.P = i10;
            this.Q = i10;
        } else {
            this.P = i10;
            this.R = i10;
        }
    }

    public void setWindowAlignment(int i10) {
        this.X.mainAxis().setWindowAlignment(i10);
    }

    public void setWindowAlignmentOffset(int i10) {
        this.X.mainAxis().setWindowAlignmentOffset(i10);
    }

    public void setWindowAlignmentOffsetPercent(float f10) {
        this.X.mainAxis().setWindowAlignmentOffsetPercent(f10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.w wVar, int i10) {
        setSelection(i10, 0, true, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void startSmoothScroll(RecyclerView.v vVar) {
        c cVar = this.E;
        if (cVar != null) {
            cVar.f3262q = true;
        }
        super.startSmoothScroll(vVar);
        if (!vVar.isRunning() || !(vVar instanceof c)) {
            this.E = null;
            this.F = null;
            return;
        }
        c cVar2 = (c) vVar;
        this.E = cVar2;
        if (cVar2 instanceof e) {
            this.F = (e) cVar2;
        } else {
            this.F = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean supportsPredictiveItemAnimations() {
        return true;
    }

    public final int t(int i10) {
        int i11 = this.L;
        if (i11 != 0) {
            return i11;
        }
        int[] iArr = this.M;
        if (iArr == null) {
            return 0;
        }
        return iArr[i10];
    }

    public final int u(int i10) {
        int iT = 0;
        if ((this.f3259z & 524288) != 0) {
            for (int i11 = this.T - 1; i11 > i10; i11--) {
                iT += t(i11) + this.R;
            }
            return iT;
        }
        int iT2 = 0;
        while (iT < i10) {
            iT2 += t(iT) + this.R;
            iT++;
        }
        return iT2;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean v(android.view.View r12, android.view.View r13, int[] r14) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.j.v(android.view.View, android.view.View, int[]):boolean");
    }

    public final int w(View view) {
        int left;
        int i10;
        if (this.f3251r == 0) {
            d dVar = (d) view.getLayoutParams();
            dVar.getClass();
            left = view.getTop() + dVar.f3265f;
            i10 = dVar.f3269j;
        } else {
            d dVar2 = (d) view.getLayoutParams();
            dVar2.getClass();
            left = view.getLeft() + dVar2.f3264e;
            i10 = dVar2.f3268i;
        }
        return this.X.secondAxis().getScroll(left + i10);
    }

    public final int x() {
        int i10 = (this.f3259z & 524288) != 0 ? 0 : this.T - 1;
        return t(i10) + u(i10);
    }

    public final int z(View view) {
        return this.f3252s.getDecoratedEnd(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d ? new d((d) layoutParams) : layoutParams instanceof RecyclerView.m ? new d((RecyclerView.m) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    public void setSelection(int i10, int i11, boolean z10, int i12) {
        if ((this.C == i10 || i10 == -1) && i11 == this.D && i12 == this.H) {
            return;
        }
        Q(i10, i11, i12, z10);
    }

    /* compiled from: GridLayoutManager.java */
    public static final class f implements Parcelable {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public int f3275b;

        /* renamed from: m, reason: collision with root package name */
        public Bundle f3276m;

        /* compiled from: GridLayoutManager.java */
        public static class a implements Parcelable.Creator<f> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public f createFromParcel(Parcel parcel) {
                return new f(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public f[] newArray(int i10) {
                return new f[i10];
            }
        }

        public f(Parcel parcel) {
            this.f3276m = Bundle.EMPTY;
            this.f3275b = parcel.readInt();
            this.f3276m = parcel.readBundle(j.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f3275b);
            parcel.writeBundle(this.f3276m);
        }

        public f() {
            this.f3276m = Bundle.EMPTY;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onLayoutCompleted(RecyclerView.w wVar) {
    }
}
