package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.l implements RecyclerView.v.b {
    public final a A;
    public final b B;
    public final int C;
    public final int[] D;

    /* renamed from: p, reason: collision with root package name */
    public int f3868p;

    /* renamed from: q, reason: collision with root package name */
    public c f3869q;

    /* renamed from: r, reason: collision with root package name */
    public o f3870r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3871s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3872t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3873u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f3874v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f3875w;

    /* renamed from: x, reason: collision with root package name */
    public int f3876x;

    /* renamed from: y, reason: collision with root package name */
    public int f3877y;

    /* renamed from: z, reason: collision with root package name */
    public d f3878z;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public o f3879a;

        /* renamed from: b, reason: collision with root package name */
        public int f3880b;

        /* renamed from: c, reason: collision with root package name */
        public int f3881c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f3882d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f3883e;

        public a() {
            b();
        }

        public final void a() {
            this.f3881c = this.f3882d ? this.f3879a.getEndAfterPadding() : this.f3879a.getStartAfterPadding();
        }

        public void assignFromView(View view, int i10) {
            if (this.f3882d) {
                this.f3881c = this.f3879a.getTotalSpaceChange() + this.f3879a.getDecoratedEnd(view);
            } else {
                this.f3881c = this.f3879a.getDecoratedStart(view);
            }
            this.f3880b = i10;
        }

        public void assignFromViewAndKeepVisibleRect(View view, int i10) {
            int totalSpaceChange = this.f3879a.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                assignFromView(view, i10);
                return;
            }
            this.f3880b = i10;
            if (!this.f3882d) {
                int decoratedStart = this.f3879a.getDecoratedStart(view);
                int startAfterPadding = decoratedStart - this.f3879a.getStartAfterPadding();
                this.f3881c = decoratedStart;
                if (startAfterPadding > 0) {
                    int endAfterPadding = (this.f3879a.getEndAfterPadding() - Math.min(0, (this.f3879a.getEndAfterPadding() - totalSpaceChange) - this.f3879a.getDecoratedEnd(view))) - (this.f3879a.getDecoratedMeasurement(view) + decoratedStart);
                    if (endAfterPadding < 0) {
                        this.f3881c -= Math.min(startAfterPadding, -endAfterPadding);
                        return;
                    }
                    return;
                }
                return;
            }
            int endAfterPadding2 = (this.f3879a.getEndAfterPadding() - totalSpaceChange) - this.f3879a.getDecoratedEnd(view);
            this.f3881c = this.f3879a.getEndAfterPadding() - endAfterPadding2;
            if (endAfterPadding2 > 0) {
                int decoratedMeasurement = this.f3881c - this.f3879a.getDecoratedMeasurement(view);
                int startAfterPadding2 = this.f3879a.getStartAfterPadding();
                int iMin = decoratedMeasurement - (Math.min(this.f3879a.getDecoratedStart(view) - startAfterPadding2, 0) + startAfterPadding2);
                if (iMin < 0) {
                    this.f3881c = Math.min(endAfterPadding2, -iMin) + this.f3881c;
                }
            }
        }

        public final void b() {
            this.f3880b = -1;
            this.f3881c = Integer.MIN_VALUE;
            this.f3882d = false;
            this.f3883e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f3880b + ", mCoordinate=" + this.f3881c + ", mLayoutFromEnd=" + this.f3882d + ", mValid=" + this.f3883e + '}';
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f3884a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f3885b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f3886c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f3887d;
    }

    public static class c {

        /* renamed from: b, reason: collision with root package name */
        public int f3889b;

        /* renamed from: c, reason: collision with root package name */
        public int f3890c;

        /* renamed from: d, reason: collision with root package name */
        public int f3891d;

        /* renamed from: e, reason: collision with root package name */
        public int f3892e;

        /* renamed from: f, reason: collision with root package name */
        public int f3893f;

        /* renamed from: g, reason: collision with root package name */
        public int f3894g;

        /* renamed from: j, reason: collision with root package name */
        public int f3897j;

        /* renamed from: l, reason: collision with root package name */
        public boolean f3899l;

        /* renamed from: a, reason: collision with root package name */
        public boolean f3888a = true;

        /* renamed from: h, reason: collision with root package name */
        public int f3895h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f3896i = 0;

        /* renamed from: k, reason: collision with root package name */
        public List<RecyclerView.z> f3898k = null;

        public final View a(RecyclerView.r rVar) {
            List<RecyclerView.z> list = this.f3898k;
            if (list == null) {
                View viewForPosition = rVar.getViewForPosition(this.f3891d);
                this.f3891d += this.f3892e;
                return viewForPosition;
            }
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = this.f3898k.get(i10).f4041a;
                RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
                if (!mVar.isItemRemoved() && this.f3891d == mVar.getViewLayoutPosition()) {
                    assignPositionFromScrapList(view);
                    return view;
                }
            }
            return null;
        }

        public void assignPositionFromScrapList() {
            assignPositionFromScrapList(null);
        }

        public View nextViewInLimitedList(View view) {
            int viewLayoutPosition;
            int size = this.f3898k.size();
            View view2 = null;
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < size; i11++) {
                View view3 = this.f3898k.get(i11).f4041a;
                RecyclerView.m mVar = (RecyclerView.m) view3.getLayoutParams();
                if (view3 != view && !mVar.isItemRemoved() && (viewLayoutPosition = (mVar.getViewLayoutPosition() - this.f3891d) * this.f3892e) >= 0 && viewLayoutPosition < i10) {
                    view2 = view3;
                    if (viewLayoutPosition == 0) {
                        break;
                    }
                    i10 = viewLayoutPosition;
                }
            }
            return view2;
        }

        public void assignPositionFromScrapList(View view) {
            View viewNextViewInLimitedList = nextViewInLimitedList(view);
            if (viewNextViewInLimitedList == null) {
                this.f3891d = -1;
            } else {
                this.f3891d = ((RecyclerView.m) viewNextViewInLimitedList.getLayoutParams()).getViewLayoutPosition();
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public int f3900b;

        /* renamed from: m, reason: collision with root package name */
        public int f3901m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f3902n;

        public class a implements Parcelable.Creator<d> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i10) {
                return new d[i10];
            }
        }

        public d() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f3900b);
            parcel.writeInt(this.f3901m);
            parcel.writeInt(this.f3902n ? 1 : 0);
        }

        public d(Parcel parcel) {
            this.f3900b = parcel.readInt();
            this.f3901m = parcel.readInt();
            this.f3902n = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f3900b = dVar.f3900b;
            this.f3901m = dVar.f3901m;
            this.f3902n = dVar.f3902n;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public final View A() {
        return getChildAt(this.f3873u ? 0 : getChildCount() - 1);
    }

    public final View B() {
        return getChildAt(this.f3873u ? getChildCount() - 1 : 0);
    }

    public void C(RecyclerView.r rVar, RecyclerView.w wVar, c cVar, b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int paddingLeft;
        int decoratedMeasurementInOther;
        View viewA = cVar.a(rVar);
        if (viewA == null) {
            bVar.f3885b = true;
            return;
        }
        RecyclerView.m mVar = (RecyclerView.m) viewA.getLayoutParams();
        if (cVar.f3898k == null) {
            if (this.f3873u == (cVar.f3893f == -1)) {
                addView(viewA);
            } else {
                addView(viewA, 0);
            }
        } else {
            if (this.f3873u == (cVar.f3893f == -1)) {
                addDisappearingView(viewA);
            } else {
                addDisappearingView(viewA, 0);
            }
        }
        measureChildWithMargins(viewA, 0, 0);
        bVar.f3884a = this.f3870r.getDecoratedMeasurement(viewA);
        if (this.f3868p == 1) {
            if (isLayoutRTL()) {
                decoratedMeasurementInOther = getWidth() - getPaddingRight();
                paddingLeft = decoratedMeasurementInOther - this.f3870r.getDecoratedMeasurementInOther(viewA);
            } else {
                paddingLeft = getPaddingLeft();
                decoratedMeasurementInOther = this.f3870r.getDecoratedMeasurementInOther(viewA) + paddingLeft;
            }
            if (cVar.f3893f == -1) {
                int i14 = cVar.f3889b;
                i11 = i14;
                i12 = decoratedMeasurementInOther;
                i10 = i14 - bVar.f3884a;
            } else {
                int i15 = cVar.f3889b;
                i10 = i15;
                i12 = decoratedMeasurementInOther;
                i11 = bVar.f3884a + i15;
            }
            i13 = paddingLeft;
        } else {
            int paddingTop = getPaddingTop();
            int decoratedMeasurementInOther2 = this.f3870r.getDecoratedMeasurementInOther(viewA) + paddingTop;
            if (cVar.f3893f == -1) {
                int i16 = cVar.f3889b;
                i13 = i16 - bVar.f3884a;
                i12 = i16;
                i10 = paddingTop;
                i11 = decoratedMeasurementInOther2;
            } else {
                int i17 = cVar.f3889b;
                i10 = paddingTop;
                i11 = decoratedMeasurementInOther2;
                i12 = bVar.f3884a + i17;
                i13 = i17;
            }
        }
        layoutDecoratedWithMargins(viewA, i13, i10, i12, i11);
        if (mVar.isItemRemoved() || mVar.isItemChanged()) {
            bVar.f3886c = true;
        }
        bVar.f3887d = viewA.hasFocusable();
    }

    public final void E(RecyclerView.r rVar, c cVar) {
        if (!cVar.f3888a || cVar.f3899l) {
            return;
        }
        int i10 = cVar.f3894g;
        int i11 = cVar.f3896i;
        if (cVar.f3893f == -1) {
            int childCount = getChildCount();
            if (i10 < 0) {
                return;
            }
            int end = (this.f3870r.getEnd() - i10) + i11;
            if (this.f3873u) {
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt = getChildAt(i12);
                    if (this.f3870r.getDecoratedStart(childAt) < end || this.f3870r.getTransformedStartWithDecoration(childAt) < end) {
                        F(rVar, 0, i12);
                        return;
                    }
                }
                return;
            }
            int i13 = childCount - 1;
            for (int i14 = i13; i14 >= 0; i14--) {
                View childAt2 = getChildAt(i14);
                if (this.f3870r.getDecoratedStart(childAt2) < end || this.f3870r.getTransformedStartWithDecoration(childAt2) < end) {
                    F(rVar, i13, i14);
                    return;
                }
            }
            return;
        }
        if (i10 < 0) {
            return;
        }
        int i15 = i10 - i11;
        int childCount2 = getChildCount();
        if (!this.f3873u) {
            for (int i16 = 0; i16 < childCount2; i16++) {
                View childAt3 = getChildAt(i16);
                if (this.f3870r.getDecoratedEnd(childAt3) > i15 || this.f3870r.getTransformedEndWithDecoration(childAt3) > i15) {
                    F(rVar, 0, i16);
                    return;
                }
            }
            return;
        }
        int i17 = childCount2 - 1;
        for (int i18 = i17; i18 >= 0; i18--) {
            View childAt4 = getChildAt(i18);
            if (this.f3870r.getDecoratedEnd(childAt4) > i15 || this.f3870r.getTransformedEndWithDecoration(childAt4) > i15) {
                F(rVar, i17, i18);
                return;
            }
        }
    }

    public final void F(RecyclerView.r rVar, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        if (i11 <= i10) {
            while (i10 > i11) {
                removeAndRecycleViewAt(i10, rVar);
                i10--;
            }
        } else {
            for (int i12 = i11 - 1; i12 >= i10; i12--) {
                removeAndRecycleViewAt(i12, rVar);
            }
        }
    }

    public final void G() {
        if (this.f3868p == 1 || !isLayoutRTL()) {
            this.f3873u = this.f3872t;
        } else {
            this.f3873u = !this.f3872t;
        }
    }

    public final int H(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        r();
        this.f3869q.f3888a = true;
        int i11 = i10 > 0 ? 1 : -1;
        int iAbs = Math.abs(i10);
        I(i11, iAbs, true, wVar);
        c cVar = this.f3869q;
        int iS = s(rVar, cVar, wVar, false) + cVar.f3894g;
        if (iS < 0) {
            return 0;
        }
        if (iAbs > iS) {
            i10 = i11 * iS;
        }
        this.f3870r.offsetChildren(-i10);
        this.f3869q.f3897j = i10;
        return i10;
    }

    public final void I(int i10, int i11, boolean z10, RecyclerView.w wVar) {
        int startAfterPadding;
        this.f3869q.f3899l = this.f3870r.getMode() == 0 && this.f3870r.getEnd() == 0;
        this.f3869q.f3893f = i10;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(wVar, iArr);
        int iMax = Math.max(0, iArr[0]);
        int iMax2 = Math.max(0, iArr[1]);
        boolean z11 = i10 == 1;
        c cVar = this.f3869q;
        int i12 = z11 ? iMax2 : iMax;
        cVar.f3895h = i12;
        if (!z11) {
            iMax = iMax2;
        }
        cVar.f3896i = iMax;
        if (z11) {
            cVar.f3895h = this.f3870r.getEndPadding() + i12;
            View viewA = A();
            c cVar2 = this.f3869q;
            cVar2.f3892e = this.f3873u ? -1 : 1;
            int position = getPosition(viewA);
            c cVar3 = this.f3869q;
            cVar2.f3891d = position + cVar3.f3892e;
            cVar3.f3889b = this.f3870r.getDecoratedEnd(viewA);
            startAfterPadding = this.f3870r.getDecoratedEnd(viewA) - this.f3870r.getEndAfterPadding();
        } else {
            View viewB = B();
            c cVar4 = this.f3869q;
            cVar4.f3895h = this.f3870r.getStartAfterPadding() + cVar4.f3895h;
            c cVar5 = this.f3869q;
            cVar5.f3892e = this.f3873u ? 1 : -1;
            int position2 = getPosition(viewB);
            c cVar6 = this.f3869q;
            cVar5.f3891d = position2 + cVar6.f3892e;
            cVar6.f3889b = this.f3870r.getDecoratedStart(viewB);
            startAfterPadding = (-this.f3870r.getDecoratedStart(viewB)) + this.f3870r.getStartAfterPadding();
        }
        c cVar7 = this.f3869q;
        cVar7.f3890c = i11;
        if (z10) {
            cVar7.f3890c = i11 - startAfterPadding;
        }
        cVar7.f3894g = startAfterPadding;
    }

    public final void J(int i10, int i11) {
        this.f3869q.f3890c = this.f3870r.getEndAfterPadding() - i11;
        c cVar = this.f3869q;
        cVar.f3892e = this.f3873u ? -1 : 1;
        cVar.f3891d = i10;
        cVar.f3893f = 1;
        cVar.f3889b = i11;
        cVar.f3894g = Integer.MIN_VALUE;
    }

    public final void K(int i10, int i11) {
        this.f3869q.f3890c = i11 - this.f3870r.getStartAfterPadding();
        c cVar = this.f3869q;
        cVar.f3891d = i10;
        cVar.f3892e = this.f3873u ? 1 : -1;
        cVar.f3893f = -1;
        cVar.f3889b = i11;
        cVar.f3894g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void assertNotInLayoutOrScroll(String str) {
        if (this.f3878z == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView.w wVar, int[] iArr) {
        int i10;
        int extraLayoutSpace = getExtraLayoutSpace(wVar);
        if (this.f3869q.f3893f == -1) {
            i10 = 0;
        } else {
            i10 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean canScrollHorizontally() {
        return this.f3868p == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean canScrollVertically() {
        return this.f3868p == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.w wVar, RecyclerView.l.c cVar) {
        if (this.f3868p != 0) {
            i10 = i11;
        }
        if (getChildCount() == 0 || i10 == 0) {
            return;
        }
        r();
        I(i10 > 0 ? 1 : -1, Math.abs(i10), true, wVar);
        m(wVar, this.f3869q, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void collectInitialPrefetchPositions(int r7, androidx.recyclerview.widget.RecyclerView.l.c r8) {
        /*
            r6 = this;
            androidx.recyclerview.widget.LinearLayoutManager$d r0 = r6.f3878z
            r1 = 1
            r2 = -1
            r3 = 0
            if (r0 == 0) goto L13
            int r4 = r0.f3900b
            if (r4 < 0) goto Ld
            r5 = 1
            goto Le
        Ld:
            r5 = 0
        Le:
            if (r5 == 0) goto L13
            boolean r0 = r0.f3902n
            goto L22
        L13:
            r6.G()
            boolean r0 = r6.f3873u
            int r4 = r6.f3876x
            if (r4 != r2) goto L22
            if (r0 == 0) goto L21
            int r4 = r7 + (-1)
            goto L22
        L21:
            r4 = 0
        L22:
            if (r0 == 0) goto L25
            r1 = -1
        L25:
            r0 = 0
        L26:
            int r2 = r6.C
            if (r0 >= r2) goto L38
            if (r4 < 0) goto L38
            if (r4 >= r7) goto L38
            r2 = r8
            androidx.recyclerview.widget.k$b r2 = (androidx.recyclerview.widget.k.b) r2
            r2.addPosition(r4, r3)
            int r4 = r4 + r1
            int r0 = r0 + 1
            goto L26
        L38:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.collectInitialPrefetchPositions(int, androidx.recyclerview.widget.RecyclerView$l$c):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeHorizontalScrollExtent(RecyclerView.w wVar) {
        return n(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeHorizontalScrollOffset(RecyclerView.w wVar) {
        return o(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeHorizontalScrollRange(RecyclerView.w wVar) {
        return p(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v.b
    public PointF computeScrollVectorForPosition(int i10) {
        if (getChildCount() == 0) {
            return null;
        }
        int i11 = (i10 < getPosition(getChildAt(0))) != this.f3873u ? -1 : 1;
        return this.f3868p == 0 ? new PointF(i11, 0.0f) : new PointF(0.0f, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeVerticalScrollExtent(RecyclerView.w wVar) {
        return n(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeVerticalScrollOffset(RecyclerView.w wVar) {
        return o(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeVerticalScrollRange(RecyclerView.w wVar) {
        return p(wVar);
    }

    public int findFirstVisibleItemPosition() {
        View viewW = w(0, getChildCount(), false);
        if (viewW == null) {
            return -1;
        }
        return getPosition(viewW);
    }

    public int findLastVisibleItemPosition() {
        View viewW = w(getChildCount() - 1, -1, false);
        if (viewW == null) {
            return -1;
        }
        return getPosition(viewW);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public View findViewByPosition(int i10) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i10 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i10) {
                return childAt;
            }
        }
        return super.findViewByPosition(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m generateDefaultLayoutParams() {
        return new RecyclerView.m(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.w wVar) {
        if (wVar.hasTargetScrollPosition()) {
            return this.f3870r.getTotalSpace();
        }
        return 0;
    }

    public int getOrientation() {
        return this.f3868p;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean k() {
        boolean z10;
        if (getHeightMode() == 1073741824 || getWidthMode() == 1073741824) {
            return false;
        }
        int childCount = getChildCount();
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                z10 = false;
                break;
            }
            ViewGroup.LayoutParams layoutParams = getChildAt(i10).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                z10 = true;
                break;
            }
            i10++;
        }
        return z10;
    }

    public void m(RecyclerView.w wVar, c cVar, RecyclerView.l.c cVar2) {
        int i10 = cVar.f3891d;
        if (i10 < 0 || i10 >= wVar.getItemCount()) {
            return;
        }
        ((k.b) cVar2).addPosition(i10, Math.max(0, cVar.f3894g));
    }

    public final int n(RecyclerView.w wVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        r();
        o oVar = this.f3870r;
        boolean z10 = !this.f3875w;
        return t.a(wVar, oVar, u(z10), t(z10), this, this.f3875w);
    }

    public final int o(RecyclerView.w wVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        r();
        o oVar = this.f3870r;
        boolean z10 = !this.f3875w;
        return t.b(wVar, oVar, u(z10), t(z10), this, this.f3875w, this.f3873u);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.r rVar) {
        super.onDetachedFromWindow(recyclerView, rVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public View onFocusSearchFailed(View view, int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        int iQ;
        G();
        if (getChildCount() == 0 || (iQ = q(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        r();
        I(iQ, (int) (this.f3870r.getTotalSpace() * 0.33333334f), false, wVar);
        c cVar = this.f3869q;
        cVar.f3894g = Integer.MIN_VALUE;
        cVar.f3888a = false;
        s(rVar, cVar, wVar, true);
        View viewV = iQ == -1 ? this.f3873u ? v(getChildCount() - 1, -1) : v(0, getChildCount()) : this.f3873u ? v(0, getChildCount()) : v(getChildCount() - 1, -1);
        View viewB = iQ == -1 ? B() : A();
        if (!viewB.hasFocusable()) {
            return viewV;
        }
        if (viewV == null) {
            return null;
        }
        return viewB;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017c  */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.r r18, androidx.recyclerview.widget.RecyclerView.w r19) {
        /*
            Method dump skipped, instructions count: 1071
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onLayoutCompleted(RecyclerView.w wVar) {
        super.onLayoutCompleted(wVar);
        this.f3878z = null;
        this.f3876x = -1;
        this.f3877y = Integer.MIN_VALUE;
        this.A.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            d dVar = (d) parcelable;
            this.f3878z = dVar;
            if (this.f3876x != -1) {
                dVar.f3900b = -1;
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public Parcelable onSaveInstanceState() {
        d dVar = this.f3878z;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (getChildCount() > 0) {
            r();
            boolean z10 = this.f3871s ^ this.f3873u;
            dVar2.f3902n = z10;
            if (z10) {
                View viewA = A();
                dVar2.f3901m = this.f3870r.getEndAfterPadding() - this.f3870r.getDecoratedEnd(viewA);
                dVar2.f3900b = getPosition(viewA);
            } else {
                View viewB = B();
                dVar2.f3900b = getPosition(viewB);
                dVar2.f3901m = this.f3870r.getDecoratedStart(viewB) - this.f3870r.getStartAfterPadding();
            }
        } else {
            dVar2.f3900b = -1;
        }
        return dVar2;
    }

    public final int p(RecyclerView.w wVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        r();
        o oVar = this.f3870r;
        boolean z10 = !this.f3875w;
        return t.c(wVar, oVar, u(z10), t(z10), this, this.f3875w);
    }

    public final int q(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.f3868p == 1) ? 1 : Integer.MIN_VALUE : this.f3868p == 0 ? 1 : Integer.MIN_VALUE : this.f3868p == 1 ? -1 : Integer.MIN_VALUE : this.f3868p == 0 ? -1 : Integer.MIN_VALUE : (this.f3868p != 1 && isLayoutRTL()) ? -1 : 1 : (this.f3868p != 1 && isLayoutRTL()) ? 1 : -1;
    }

    public final void r() {
        if (this.f3869q == null) {
            this.f3869q = new c();
        }
    }

    public final int s(RecyclerView.r rVar, c cVar, RecyclerView.w wVar, boolean z10) {
        int i10 = cVar.f3890c;
        int i11 = cVar.f3894g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                cVar.f3894g = i11 + i10;
            }
            E(rVar, cVar);
        }
        int i12 = cVar.f3890c + cVar.f3895h;
        while (true) {
            if (!cVar.f3899l && i12 <= 0) {
                break;
            }
            int i13 = cVar.f3891d;
            if (!(i13 >= 0 && i13 < wVar.getItemCount())) {
                break;
            }
            b bVar = this.B;
            bVar.f3884a = 0;
            bVar.f3885b = false;
            bVar.f3886c = false;
            bVar.f3887d = false;
            C(rVar, wVar, cVar, bVar);
            if (!bVar.f3885b) {
                cVar.f3889b = (bVar.f3884a * cVar.f3893f) + cVar.f3889b;
                if (!bVar.f3886c || cVar.f3898k != null || !wVar.isPreLayout()) {
                    int i14 = cVar.f3890c;
                    int i15 = bVar.f3884a;
                    cVar.f3890c = i14 - i15;
                    i12 -= i15;
                }
                int i16 = cVar.f3894g;
                if (i16 != Integer.MIN_VALUE) {
                    int i17 = i16 + bVar.f3884a;
                    cVar.f3894g = i17;
                    int i18 = cVar.f3890c;
                    if (i18 < 0) {
                        cVar.f3894g = i17 + i18;
                    }
                    E(rVar, cVar);
                }
                if (z10 && bVar.f3887d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - cVar.f3890c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int scrollHorizontallyBy(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (this.f3868p == 1) {
            return 0;
        }
        return H(i10, rVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void scrollToPosition(int i10) {
        this.f3876x = i10;
        this.f3877y = Integer.MIN_VALUE;
        d dVar = this.f3878z;
        if (dVar != null) {
            dVar.f3900b = -1;
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int scrollVerticallyBy(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (this.f3868p == 0) {
            return 0;
        }
        return H(i10, rVar, wVar);
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException(ac.c.f("invalid orientation:", i10));
        }
        assertNotInLayoutOrScroll(null);
        if (i10 != this.f3868p || this.f3870r == null) {
            o oVarCreateOrientationHelper = o.createOrientationHelper(this, i10);
            this.f3870r = oVarCreateOrientationHelper;
            this.A.f3879a = oVarCreateOrientationHelper;
            this.f3868p = i10;
            requestLayout();
        }
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (z10 == this.f3872t) {
            return;
        }
        this.f3872t = z10;
        requestLayout();
    }

    public void setStackFromEnd(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (this.f3874v == z10) {
            return;
        }
        this.f3874v = z10;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.w wVar, int i10) {
        m mVar = new m(recyclerView.getContext());
        mVar.setTargetPosition(i10);
        startSmoothScroll(mVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean supportsPredictiveItemAnimations() {
        return this.f3878z == null && this.f3871s == this.f3874v;
    }

    public final View t(boolean z10) {
        return this.f3873u ? w(0, getChildCount(), z10) : w(getChildCount() - 1, -1, z10);
    }

    public final View u(boolean z10) {
        return this.f3873u ? w(getChildCount() - 1, -1, z10) : w(0, getChildCount(), z10);
    }

    public final View v(int i10, int i11) {
        int i12;
        int i13;
        r();
        if ((i11 > i10 ? (char) 1 : i11 < i10 ? (char) 65535 : (char) 0) == 0) {
            return getChildAt(i10);
        }
        if (this.f3870r.getDecoratedStart(getChildAt(i10)) < this.f3870r.getStartAfterPadding()) {
            i12 = 16644;
            i13 = 16388;
        } else {
            i12 = 4161;
            i13 = 4097;
        }
        return this.f3868p == 0 ? this.f3963c.a(i10, i11, i12, i13) : this.f3964d.a(i10, i11, i12, i13);
    }

    public final View w(int i10, int i11, boolean z10) {
        r();
        int i12 = z10 ? 24579 : 320;
        return this.f3868p == 0 ? this.f3963c.a(i10, i11, i12, 320) : this.f3964d.a(i10, i11, i12, 320);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View x(androidx.recyclerview.widget.RecyclerView.r r17, androidx.recyclerview.widget.RecyclerView.w r18, boolean r19, boolean r20) {
        /*
            r16 = this;
            r0 = r16
            r16.r()
            int r1 = r16.getChildCount()
            r2 = 0
            r3 = 1
            if (r20 == 0) goto L15
            int r1 = r16.getChildCount()
            int r1 = r1 - r3
            r4 = -1
            r5 = -1
            goto L18
        L15:
            r4 = r1
            r1 = 0
            r5 = 1
        L18:
            int r6 = r18.getItemCount()
            androidx.recyclerview.widget.o r7 = r0.f3870r
            int r7 = r7.getStartAfterPadding()
            androidx.recyclerview.widget.o r8 = r0.f3870r
            int r8 = r8.getEndAfterPadding()
            r9 = 0
            r10 = r9
            r11 = r10
        L2b:
            if (r1 == r4) goto L7a
            android.view.View r12 = r0.getChildAt(r1)
            int r13 = r0.getPosition(r12)
            androidx.recyclerview.widget.o r14 = r0.f3870r
            int r14 = r14.getDecoratedStart(r12)
            androidx.recyclerview.widget.o r15 = r0.f3870r
            int r15 = r15.getDecoratedEnd(r12)
            if (r13 < 0) goto L78
            if (r13 >= r6) goto L78
            android.view.ViewGroup$LayoutParams r13 = r12.getLayoutParams()
            androidx.recyclerview.widget.RecyclerView$m r13 = (androidx.recyclerview.widget.RecyclerView.m) r13
            boolean r13 = r13.isItemRemoved()
            if (r13 == 0) goto L55
            if (r11 != 0) goto L78
            r11 = r12
            goto L78
        L55:
            if (r15 > r7) goto L5b
            if (r14 >= r7) goto L5b
            r13 = 1
            goto L5c
        L5b:
            r13 = 0
        L5c:
            if (r14 < r8) goto L62
            if (r15 <= r8) goto L62
            r14 = 1
            goto L63
        L62:
            r14 = 0
        L63:
            if (r13 != 0) goto L69
            if (r14 == 0) goto L68
            goto L69
        L68:
            return r12
        L69:
            if (r19 == 0) goto L71
            if (r14 == 0) goto L6e
            goto L73
        L6e:
            if (r9 != 0) goto L78
            goto L77
        L71:
            if (r13 == 0) goto L75
        L73:
            r10 = r12
            goto L78
        L75:
            if (r9 != 0) goto L78
        L77:
            r9 = r12
        L78:
            int r1 = r1 + r5
            goto L2b
        L7a:
            if (r9 == 0) goto L7d
            goto L82
        L7d:
            if (r10 == 0) goto L81
            r9 = r10
            goto L82
        L81:
            r9 = r11
        L82:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.x(androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w, boolean, boolean):android.view.View");
    }

    public final int y(int i10, RecyclerView.r rVar, RecyclerView.w wVar, boolean z10) {
        int endAfterPadding;
        int endAfterPadding2 = this.f3870r.getEndAfterPadding() - i10;
        if (endAfterPadding2 <= 0) {
            return 0;
        }
        int i11 = -H(-endAfterPadding2, rVar, wVar);
        int i12 = i10 + i11;
        if (!z10 || (endAfterPadding = this.f3870r.getEndAfterPadding() - i12) <= 0) {
            return i11;
        }
        this.f3870r.offsetChildren(endAfterPadding);
        return endAfterPadding + i11;
    }

    public final int z(int i10, RecyclerView.r rVar, RecyclerView.w wVar, boolean z10) {
        int startAfterPadding;
        int startAfterPadding2 = i10 - this.f3870r.getStartAfterPadding();
        if (startAfterPadding2 <= 0) {
            return 0;
        }
        int i11 = -H(startAfterPadding2, rVar, wVar);
        int i12 = i10 + i11;
        if (!z10 || (startAfterPadding = i12 - this.f3870r.getStartAfterPadding()) <= 0) {
            return i11;
        }
        this.f3870r.offsetChildren(-startAfterPadding);
        return i11 - startAfterPadding;
    }

    public LinearLayoutManager(Context context, int i10, boolean z10) {
        this.f3868p = 1;
        this.f3872t = false;
        this.f3873u = false;
        this.f3874v = false;
        this.f3875w = true;
        this.f3876x = -1;
        this.f3877y = Integer.MIN_VALUE;
        this.f3878z = null;
        this.A = new a();
        this.B = new b();
        this.C = 2;
        this.D = new int[2];
        setOrientation(i10);
        setReverseLayout(z10);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f3868p = 1;
        this.f3872t = false;
        this.f3873u = false;
        this.f3874v = false;
        this.f3875w = true;
        this.f3876x = -1;
        this.f3877y = Integer.MIN_VALUE;
        this.f3878z = null;
        this.A = new a();
        this.B = new b();
        this.C = 2;
        this.D = new int[2];
        RecyclerView.l.d properties = RecyclerView.l.getProperties(context, attributeSet, i10, i11);
        setOrientation(properties.f3978a);
        setReverseLayout(properties.f3980c);
        setStackFromEnd(properties.f3981d);
    }

    public void D(RecyclerView.r rVar, RecyclerView.w wVar, a aVar, int i10) {
    }
}
