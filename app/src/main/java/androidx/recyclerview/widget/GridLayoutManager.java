package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import java.util.Arrays;
import y0.d;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean E;
    public int F;
    public int[] G;
    public View[] H;
    public final SparseIntArray I;
    public final SparseIntArray J;
    public final a K;
    public final Rect L;

    public static final class a extends c {
        public int getSpanIndex(int i10, int i11) {
            return i10 % i11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            return 1;
        }
    }

    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final SparseIntArray f3866a = new SparseIntArray();

        /* renamed from: b, reason: collision with root package name */
        public final SparseIntArray f3867b = new SparseIntArray();

        public int getSpanGroupIndex(int i10, int i11) {
            int spanSize = getSpanSize(i10);
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int spanSize2 = getSpanSize(i14);
                i12 += spanSize2;
                if (i12 == i11) {
                    i13++;
                    i12 = 0;
                } else if (i12 > i11) {
                    i13++;
                    i12 = spanSize2;
                }
            }
            return i12 + spanSize > i11 ? i13 + 1 : i13;
        }

        public abstract int getSpanSize(int i10);

        public void invalidateSpanGroupIndexCache() {
            this.f3867b.clear();
        }

        public void invalidateSpanIndexCache() {
            this.f3866a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new a();
        this.L = new Rect();
        setSpanCount(RecyclerView.l.getProperties(context, attributeSet, i10, i11).f3979b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void C(RecyclerView.r rVar, RecyclerView.w wVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int paddingLeft;
        int decoratedMeasurementInOther;
        int i14;
        int i15;
        int i16;
        int decoratedMeasurementInOther2;
        int childMeasureSpec;
        int childMeasureSpec2;
        boolean z10;
        View viewA;
        int modeInOther = this.f3870r.getModeInOther();
        boolean z11 = modeInOther != 1073741824;
        int i17 = getChildCount() > 0 ? this.G[this.F] : 0;
        if (z11) {
            R();
        }
        boolean z12 = cVar.f3892e == 1;
        int iO = this.F;
        if (!z12) {
            iO = O(cVar.f3891d, rVar, wVar) + P(cVar.f3891d, rVar, wVar);
        }
        int i18 = 0;
        while (i18 < this.F) {
            int i19 = cVar.f3891d;
            if (!(i19 >= 0 && i19 < wVar.getItemCount()) || iO <= 0) {
                break;
            }
            int i20 = cVar.f3891d;
            int iP = P(i20, rVar, wVar);
            if (iP > this.F) {
                throw new IllegalArgumentException(ac.c.m(ac.c.t("Item at position ", i20, " requires ", iP, " spans but GridLayoutManager has only "), this.F, " spans."));
            }
            iO -= iP;
            if (iO < 0 || (viewA = cVar.a(rVar)) == null) {
                break;
            }
            this.H[i18] = viewA;
            i18++;
        }
        if (i18 == 0) {
            bVar.f3885b = true;
            return;
        }
        if (z12) {
            i10 = 0;
            i11 = i18;
            i12 = 0;
            i13 = 1;
        } else {
            i10 = i18 - 1;
            i11 = -1;
            i12 = 0;
            i13 = -1;
        }
        while (i10 != i11) {
            View view = this.H[i10];
            b bVar2 = (b) view.getLayoutParams();
            int iP2 = P(getPosition(view), rVar, wVar);
            bVar2.f3865f = iP2;
            bVar2.f3864e = i12;
            i12 += iP2;
            i10 += i13;
        }
        float f10 = 0.0f;
        int i21 = 0;
        for (int i22 = 0; i22 < i18; i22++) {
            View view2 = this.H[i22];
            if (cVar.f3898k != null) {
                z10 = false;
                if (z12) {
                    addDisappearingView(view2);
                } else {
                    addDisappearingView(view2, 0);
                }
            } else if (z12) {
                addView(view2);
                z10 = false;
            } else {
                z10 = false;
                addView(view2, 0);
            }
            calculateItemDecorationsForChild(view2, this.L);
            Q(view2, z10, modeInOther);
            int decoratedMeasurement = this.f3870r.getDecoratedMeasurement(view2);
            if (decoratedMeasurement > i21) {
                i21 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther3 = (this.f3870r.getDecoratedMeasurementInOther(view2) * 1.0f) / ((b) view2.getLayoutParams()).f3865f;
            if (decoratedMeasurementInOther3 > f10) {
                f10 = decoratedMeasurementInOther3;
            }
        }
        if (z11) {
            L(Math.max(Math.round(f10 * this.F), i17));
            i21 = 0;
            for (int i23 = 0; i23 < i18; i23++) {
                View view3 = this.H[i23];
                Q(view3, true, 1073741824);
                int decoratedMeasurement2 = this.f3870r.getDecoratedMeasurement(view3);
                if (decoratedMeasurement2 > i21) {
                    i21 = decoratedMeasurement2;
                }
            }
        }
        for (int i24 = 0; i24 < i18; i24++) {
            View view4 = this.H[i24];
            if (this.f3870r.getDecoratedMeasurement(view4) != i21) {
                b bVar3 = (b) view4.getLayoutParams();
                Rect rect = bVar3.f3983b;
                int i25 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar3).topMargin + ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin;
                int i26 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar3).leftMargin + ((ViewGroup.MarginLayoutParams) bVar3).rightMargin;
                int iM = M(bVar3.f3864e, bVar3.f3865f);
                if (this.f3868p == 1) {
                    childMeasureSpec2 = RecyclerView.l.getChildMeasureSpec(iM, 1073741824, i26, ((ViewGroup.MarginLayoutParams) bVar3).width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i21 - i25, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i21 - i26, 1073741824);
                    childMeasureSpec = RecyclerView.l.getChildMeasureSpec(iM, 1073741824, i25, ((ViewGroup.MarginLayoutParams) bVar3).height, false);
                    childMeasureSpec2 = iMakeMeasureSpec;
                }
                if (l(view4, childMeasureSpec2, childMeasureSpec, (RecyclerView.m) view4.getLayoutParams())) {
                    view4.measure(childMeasureSpec2, childMeasureSpec);
                }
            }
        }
        bVar.f3884a = i21;
        if (this.f3868p == 1) {
            if (cVar.f3893f == -1) {
                i15 = cVar.f3889b;
                i14 = i15 - i21;
            } else {
                i14 = cVar.f3889b;
                i15 = i14 + i21;
            }
            decoratedMeasurementInOther = 0;
            paddingLeft = 0;
        } else {
            if (cVar.f3893f == -1) {
                int i27 = cVar.f3889b;
                decoratedMeasurementInOther = i27;
                paddingLeft = i27 - i21;
            } else {
                int i28 = cVar.f3889b;
                paddingLeft = i28;
                decoratedMeasurementInOther = i21 + i28;
            }
            i14 = 0;
            i15 = 0;
        }
        int i29 = 0;
        while (i29 < i18) {
            View view5 = this.H[i29];
            b bVar4 = (b) view5.getLayoutParams();
            if (this.f3868p == 1) {
                if (isLayoutRTL()) {
                    decoratedMeasurementInOther = getPaddingLeft() + this.G[this.F - bVar4.f3864e];
                    paddingLeft = decoratedMeasurementInOther - this.f3870r.getDecoratedMeasurementInOther(view5);
                } else {
                    paddingLeft = this.G[bVar4.f3864e] + getPaddingLeft();
                    decoratedMeasurementInOther = this.f3870r.getDecoratedMeasurementInOther(view5) + paddingLeft;
                }
                decoratedMeasurementInOther2 = i15;
                i16 = i14;
            } else {
                int paddingTop = getPaddingTop() + this.G[bVar4.f3864e];
                i16 = paddingTop;
                decoratedMeasurementInOther2 = this.f3870r.getDecoratedMeasurementInOther(view5) + paddingTop;
            }
            int i30 = decoratedMeasurementInOther;
            int i31 = paddingLeft;
            layoutDecoratedWithMargins(view5, i31, i16, i30, decoratedMeasurementInOther2);
            if (bVar4.isItemRemoved() || bVar4.isItemChanged()) {
                bVar.f3886c = true;
            }
            bVar.f3887d |= view5.hasFocusable();
            i29++;
            i15 = decoratedMeasurementInOther2;
            i14 = i16;
            decoratedMeasurementInOther = i30;
            paddingLeft = i31;
        }
        Arrays.fill(this.H, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void D(RecyclerView.r rVar, RecyclerView.w wVar, LinearLayoutManager.a aVar, int i10) {
        R();
        if (wVar.getItemCount() > 0 && !wVar.isPreLayout()) {
            boolean z10 = i10 == 1;
            int iO = O(aVar.f3880b, rVar, wVar);
            if (z10) {
                while (iO > 0) {
                    int i11 = aVar.f3880b;
                    if (i11 <= 0) {
                        break;
                    }
                    int i12 = i11 - 1;
                    aVar.f3880b = i12;
                    iO = O(i12, rVar, wVar);
                }
            } else {
                int itemCount = wVar.getItemCount() - 1;
                int i13 = aVar.f3880b;
                while (i13 < itemCount) {
                    int i14 = i13 + 1;
                    int iO2 = O(i14, rVar, wVar);
                    if (iO2 <= iO) {
                        break;
                    }
                    i13 = i14;
                    iO = iO2;
                }
                aVar.f3880b = i13;
            }
        }
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
    }

    public final void L(int i10) {
        int i11;
        int[] iArr = this.G;
        int i12 = this.F;
        if (iArr == null || iArr.length != i12 + 1 || iArr[iArr.length - 1] != i10) {
            iArr = new int[i12 + 1];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i10 / i12;
        int i15 = i10 % i12;
        int i16 = 0;
        for (int i17 = 1; i17 <= i12; i17++) {
            i13 += i15;
            if (i13 <= 0 || i12 - i13 >= i15) {
                i11 = i14;
            } else {
                i11 = i14 + 1;
                i13 -= i12;
            }
            i16 += i11;
            iArr[i17] = i16;
        }
        this.G = iArr;
    }

    public final int M(int i10, int i11) {
        if (this.f3868p != 1 || !isLayoutRTL()) {
            int[] iArr = this.G;
            return iArr[i11 + i10] - iArr[i10];
        }
        int[] iArr2 = this.G;
        int i12 = this.F;
        return iArr2[i12 - i10] - iArr2[(i12 - i10) - i11];
    }

    public final int N(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        boolean zIsPreLayout = wVar.isPreLayout();
        a aVar = this.K;
        if (!zIsPreLayout) {
            return aVar.getSpanGroupIndex(i10, this.F);
        }
        int iConvertPreLayoutPositionToPostLayout = rVar.convertPreLayoutPositionToPostLayout(i10);
        if (iConvertPreLayoutPositionToPostLayout != -1) {
            return aVar.getSpanGroupIndex(iConvertPreLayoutPositionToPostLayout, this.F);
        }
        o1.a.o("Cannot find span size for pre layout position. ", i10, "GridLayoutManager");
        return 0;
    }

    public final int O(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        boolean zIsPreLayout = wVar.isPreLayout();
        a aVar = this.K;
        if (!zIsPreLayout) {
            return aVar.getSpanIndex(i10, this.F);
        }
        int i11 = this.J.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int iConvertPreLayoutPositionToPostLayout = rVar.convertPreLayoutPositionToPostLayout(i10);
        if (iConvertPreLayoutPositionToPostLayout != -1) {
            return aVar.getSpanIndex(iConvertPreLayoutPositionToPostLayout, this.F);
        }
        o1.a.o("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:", i10, "GridLayoutManager");
        return 0;
    }

    public final int P(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        boolean zIsPreLayout = wVar.isPreLayout();
        a aVar = this.K;
        if (!zIsPreLayout) {
            return aVar.getSpanSize(i10);
        }
        int i11 = this.I.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int iConvertPreLayoutPositionToPostLayout = rVar.convertPreLayoutPositionToPostLayout(i10);
        if (iConvertPreLayoutPositionToPostLayout != -1) {
            return aVar.getSpanSize(iConvertPreLayoutPositionToPostLayout);
        }
        o1.a.o("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:", i10, "GridLayoutManager");
        return 1;
    }

    public final void Q(View view, boolean z10, int i10) {
        int childMeasureSpec;
        int childMeasureSpec2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f3983b;
        int i11 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i12 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int iM = M(bVar.f3864e, bVar.f3865f);
        if (this.f3868p == 1) {
            childMeasureSpec2 = RecyclerView.l.getChildMeasureSpec(iM, i10, i12, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            childMeasureSpec = RecyclerView.l.getChildMeasureSpec(this.f3870r.getTotalSpace(), getHeightMode(), i11, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int childMeasureSpec3 = RecyclerView.l.getChildMeasureSpec(iM, i10, i11, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int childMeasureSpec4 = RecyclerView.l.getChildMeasureSpec(this.f3870r.getTotalSpace(), getWidthMode(), i12, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        if (z10 ? l(view, childMeasureSpec2, childMeasureSpec, mVar) : j(view, childMeasureSpec2, childMeasureSpec, mVar)) {
            view.measure(childMeasureSpec2, childMeasureSpec);
        }
    }

    public final void R() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        L(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean checkLayoutParams(RecyclerView.m mVar) {
        return mVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public int computeHorizontalScrollOffset(RecyclerView.w wVar) {
        return super.computeHorizontalScrollOffset(wVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public int computeHorizontalScrollRange(RecyclerView.w wVar) {
        return super.computeHorizontalScrollRange(wVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public int computeVerticalScrollOffset(RecyclerView.w wVar) {
        return super.computeVerticalScrollOffset(wVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public int computeVerticalScrollRange(RecyclerView.w wVar) {
        return super.computeVerticalScrollRange(wVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m generateDefaultLayoutParams() {
        return this.f3868p == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int getColumnCountForAccessibility(RecyclerView.r rVar, RecyclerView.w wVar) {
        if (this.f3868p == 1) {
            return this.F;
        }
        if (wVar.getItemCount() < 1) {
            return 0;
        }
        return N(wVar.getItemCount() - 1, rVar, wVar) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int getRowCountForAccessibility(RecyclerView.r rVar, RecyclerView.w wVar) {
        if (this.f3868p == 0) {
            return this.F;
        }
        if (wVar.getItemCount() < 1) {
            return 0;
        }
        return N(wVar.getItemCount() - 1, rVar, wVar) + 1;
    }

    public int getSpanCount() {
        return this.F;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void m(RecyclerView.w wVar, LinearLayoutManager.c cVar, RecyclerView.l.c cVar2) {
        int spanSize = this.F;
        for (int i10 = 0; i10 < this.F; i10++) {
            int i11 = cVar.f3891d;
            if (!(i11 >= 0 && i11 < wVar.getItemCount()) || spanSize <= 0) {
                return;
            }
            int i12 = cVar.f3891d;
            ((k.b) cVar2).addPosition(i12, Math.max(0, cVar.f3894g));
            spanSize -= this.K.getSpanSize(i12);
            cVar.f3891d += cVar.f3892e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.r r26, androidx.recyclerview.widget.RecyclerView.w r27) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.r rVar, RecyclerView.w wVar, View view, y0.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            c(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        int iN = N(bVar.getViewLayoutPosition(), rVar, wVar);
        if (this.f3868p == 0) {
            dVar.setCollectionItemInfo(d.f.obtain(bVar.getSpanIndex(), bVar.getSpanSize(), iN, 1, false, false));
        } else {
            dVar.setCollectionItemInfo(d.f.obtain(iN, 1, bVar.getSpanIndex(), bVar.getSpanSize(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        a aVar = this.K;
        aVar.invalidateSpanIndexCache();
        aVar.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsChanged(RecyclerView recyclerView) {
        a aVar = this.K;
        aVar.invalidateSpanIndexCache();
        aVar.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        a aVar = this.K;
        aVar.invalidateSpanIndexCache();
        aVar.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        a aVar = this.K;
        aVar.invalidateSpanIndexCache();
        aVar.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        a aVar = this.K;
        aVar.invalidateSpanIndexCache();
        aVar.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public void onLayoutChildren(RecyclerView.r rVar, RecyclerView.w wVar) {
        boolean zIsPreLayout = wVar.isPreLayout();
        SparseIntArray sparseIntArray = this.J;
        SparseIntArray sparseIntArray2 = this.I;
        if (zIsPreLayout) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                b bVar = (b) getChildAt(i10).getLayoutParams();
                int viewLayoutPosition = bVar.getViewLayoutPosition();
                sparseIntArray2.put(viewLayoutPosition, bVar.getSpanSize());
                sparseIntArray.put(viewLayoutPosition, bVar.getSpanIndex());
            }
        }
        super.onLayoutChildren(rVar, wVar);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public void onLayoutCompleted(RecyclerView.w wVar) {
        super.onLayoutCompleted(wVar);
        this.E = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public int scrollHorizontallyBy(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        R();
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
        return super.scrollHorizontallyBy(i10, rVar, wVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public int scrollVerticallyBy(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        R();
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
        return super.scrollVerticallyBy(i10, rVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void setMeasuredDimension(Rect rect, int i10, int i11) {
        int iChooseSize;
        int iChooseSize2;
        if (this.G == null) {
            super.setMeasuredDimension(rect, i10, i11);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.f3868p == 1) {
            iChooseSize2 = RecyclerView.l.chooseSize(i11, rect.height() + paddingBottom, getMinimumHeight());
            int[] iArr = this.G;
            iChooseSize = RecyclerView.l.chooseSize(i10, iArr[iArr.length - 1] + paddingRight, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView.l.chooseSize(i10, rect.width() + paddingRight, getMinimumWidth());
            int[] iArr2 = this.G;
            iChooseSize2 = RecyclerView.l.chooseSize(i11, iArr2[iArr2.length - 1] + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setSpanCount(int i10) {
        if (i10 == this.F) {
            return;
        }
        this.E = true;
        if (i10 < 1) {
            throw new IllegalArgumentException(ac.c.f("Span count should be at least 1. Provided ", i10));
        }
        this.F = i10;
        this.K.invalidateSpanIndexCache();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z10) {
        if (z10) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public boolean supportsPredictiveItemAnimations() {
        return this.f3878z == null && !this.E;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View x(RecyclerView.r rVar, RecyclerView.w wVar, boolean z10, boolean z11) {
        int i10;
        int childCount;
        int childCount2 = getChildCount();
        int i11 = 1;
        if (z11) {
            childCount = getChildCount() - 1;
            i10 = -1;
            i11 = -1;
        } else {
            i10 = childCount2;
            childCount = 0;
        }
        int itemCount = wVar.getItemCount();
        r();
        int startAfterPadding = this.f3870r.getStartAfterPadding();
        int endAfterPadding = this.f3870r.getEndAfterPadding();
        View view = null;
        View view2 = null;
        while (childCount != i10) {
            View childAt = getChildAt(childCount);
            int position = getPosition(childAt);
            if (position >= 0 && position < itemCount && O(position, rVar, wVar) == 0) {
                if (((RecyclerView.m) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.f3870r.getDecoratedStart(childAt) < endAfterPadding && this.f3870r.getDecoratedEnd(childAt) >= startAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            childCount += i11;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public static class b extends RecyclerView.m {

        /* renamed from: e, reason: collision with root package name */
        public int f3864e;

        /* renamed from: f, reason: collision with root package name */
        public int f3865f;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3864e = -1;
            this.f3865f = 0;
        }

        public int getSpanIndex() {
            return this.f3864e;
        }

        public int getSpanSize() {
            return this.f3865f;
        }

        public b(int i10, int i11) {
            super(i10, i11);
            this.f3864e = -1;
            this.f3865f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3864e = -1;
            this.f3865f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3864e = -1;
            this.f3865f = 0;
        }
    }

    public GridLayoutManager(Context context, int i10) {
        super(context);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new a();
        this.L = new Rect();
        setSpanCount(i10);
    }

    public GridLayoutManager(Context context, int i10, int i11, boolean z10) {
        super(context, i11, z10);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new a();
        this.L = new Rect();
        setSpanCount(i10);
    }
}
