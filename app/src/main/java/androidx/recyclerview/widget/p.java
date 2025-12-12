package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PagerSnapHelper.java */
/* loaded from: classes.dex */
public final class p extends v {

    /* renamed from: c, reason: collision with root package name */
    public o f4239c;

    /* renamed from: d, reason: collision with root package name */
    public o f4240d;

    /* compiled from: PagerSnapHelper.java */
    public class a extends m {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.m
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.m
        public int calculateTimeForScrolling(int i10) {
            return Math.min(100, super.calculateTimeForScrolling(i10));
        }

        @Override // androidx.recyclerview.widget.m, androidx.recyclerview.widget.RecyclerView.v
        public void onTargetFound(View view, RecyclerView.w wVar, RecyclerView.v.a aVar) {
            p pVar = p.this;
            int[] iArrCalculateDistanceToFinalSnap = pVar.calculateDistanceToFinalSnap(pVar.f4249a.getLayoutManager(), view);
            int i10 = iArrCalculateDistanceToFinalSnap[0];
            int i11 = iArrCalculateDistanceToFinalSnap[1];
            int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i10), Math.abs(i11)));
            if (iCalculateTimeForDeceleration > 0) {
                aVar.update(i10, i11, iCalculateTimeForDeceleration, this.f4228j);
            }
        }
    }

    public static int b(View view, o oVar) {
        return ((oVar.getDecoratedMeasurement(view) / 2) + oVar.getDecoratedStart(view)) - ((oVar.getTotalSpace() / 2) + oVar.getStartAfterPadding());
    }

    public static View c(RecyclerView.l lVar, o oVar) {
        int childCount = lVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int totalSpace = (oVar.getTotalSpace() / 2) + oVar.getStartAfterPadding();
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = lVar.getChildAt(i11);
            int iAbs = Math.abs(((oVar.getDecoratedMeasurement(childAt) / 2) + oVar.getDecoratedStart(childAt)) - totalSpace);
            if (iAbs < i10) {
                view = childAt;
                i10 = iAbs;
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.v
    public int[] calculateDistanceToFinalSnap(RecyclerView.l lVar, View view) {
        int[] iArr = new int[2];
        if (lVar.canScrollHorizontally()) {
            iArr[0] = b(view, d(lVar));
        } else {
            iArr[0] = 0;
        }
        if (lVar.canScrollVertically()) {
            iArr[1] = b(view, e(lVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.v
    public RecyclerView.v createScroller(RecyclerView.l lVar) {
        if (lVar instanceof RecyclerView.v.b) {
            return new a(this.f4249a.getContext());
        }
        return null;
    }

    public final o d(RecyclerView.l lVar) {
        o oVar = this.f4240d;
        if (oVar == null || oVar.f4236a != lVar) {
            this.f4240d = o.createHorizontalHelper(lVar);
        }
        return this.f4240d;
    }

    public final o e(RecyclerView.l lVar) {
        o oVar = this.f4239c;
        if (oVar == null || oVar.f4236a != lVar) {
            this.f4239c = o.createVerticalHelper(lVar);
        }
        return this.f4239c;
    }

    @Override // androidx.recyclerview.widget.v
    public View findSnapView(RecyclerView.l lVar) {
        if (lVar.canScrollVertically()) {
            return c(lVar, e(lVar));
        }
        if (lVar.canScrollHorizontally()) {
            return c(lVar, d(lVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.v
    public int findTargetSnapPosition(RecyclerView.l lVar, int i10, int i11) {
        PointF pointFComputeScrollVectorForPosition;
        int itemCount = lVar.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        o oVarE = lVar.canScrollVertically() ? e(lVar) : lVar.canScrollHorizontally() ? d(lVar) : null;
        if (oVarE == null) {
            return -1;
        }
        int childCount = lVar.getChildCount();
        boolean z10 = false;
        View view2 = null;
        int i12 = Integer.MIN_VALUE;
        int i13 = Integer.MAX_VALUE;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = lVar.getChildAt(i14);
            if (childAt != null) {
                int iB = b(childAt, oVarE);
                if (iB <= 0 && iB > i12) {
                    view2 = childAt;
                    i12 = iB;
                }
                if (iB >= 0 && iB < i13) {
                    view = childAt;
                    i13 = iB;
                }
            }
        }
        boolean z11 = !lVar.canScrollHorizontally() ? i11 <= 0 : i10 <= 0;
        if (z11 && view != null) {
            return lVar.getPosition(view);
        }
        if (!z11 && view2 != null) {
            return lVar.getPosition(view2);
        }
        if (z11) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = lVar.getPosition(view);
        int itemCount2 = lVar.getItemCount();
        if ((lVar instanceof RecyclerView.v.b) && (pointFComputeScrollVectorForPosition = ((RecyclerView.v.b) lVar).computeScrollVectorForPosition(itemCount2 - 1)) != null && (pointFComputeScrollVectorForPosition.x < 0.0f || pointFComputeScrollVectorForPosition.y < 0.0f)) {
            z10 = true;
        }
        int i15 = position + (z10 == z11 ? -1 : 1);
        if (i15 < 0 || i15 >= itemCount) {
            return -1;
        }
        return i15;
    }
}
