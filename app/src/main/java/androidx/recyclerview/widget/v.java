package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SnapHelper.java */
/* loaded from: classes.dex */
public abstract class v extends RecyclerView.n {

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView f4249a;

    /* renamed from: b, reason: collision with root package name */
    public final a f4250b = new a();

    /* compiled from: SnapHelper.java */
    public class a extends RecyclerView.p {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4251a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 == 0 && this.f4251a) {
                this.f4251a = false;
                v.this.a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            if (i10 == 0 && i11 == 0) {
                return;
            }
            this.f4251a = true;
        }
    }

    public final void a() {
        RecyclerView.l layoutManager;
        View viewFindSnapView;
        RecyclerView recyclerView = this.f4249a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewFindSnapView = findSnapView(layoutManager)) == null) {
            return;
        }
        int[] iArrCalculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, viewFindSnapView);
        int i10 = iArrCalculateDistanceToFinalSnap[0];
        if (i10 == 0 && iArrCalculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.f4249a.smoothScrollBy(i10, iArrCalculateDistanceToFinalSnap[1]);
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f4249a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        a aVar = this.f4250b;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(aVar);
            this.f4249a.setOnFlingListener(null);
        }
        this.f4249a = recyclerView;
        if (recyclerView != null) {
            if (recyclerView.getOnFlingListener() != null) {
                throw new IllegalStateException("An instance of OnFlingListener already set.");
            }
            this.f4249a.addOnScrollListener(aVar);
            this.f4249a.setOnFlingListener(this);
            new Scroller(this.f4249a.getContext(), new DecelerateInterpolator());
            a();
        }
    }

    public abstract int[] calculateDistanceToFinalSnap(RecyclerView.l lVar, View view);

    public abstract RecyclerView.v createScroller(RecyclerView.l lVar);

    public abstract View findSnapView(RecyclerView.l lVar);

    public abstract int findTargetSnapPosition(RecyclerView.l lVar, int i10, int i11);

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean onFling(int i10, int i11) {
        RecyclerView.v vVarCreateScroller;
        int iFindTargetSnapPosition;
        boolean z10;
        RecyclerView.l layoutManager = this.f4249a.getLayoutManager();
        if (layoutManager == null || this.f4249a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f4249a.getMinFlingVelocity();
        if (Math.abs(i11) <= minFlingVelocity && Math.abs(i10) <= minFlingVelocity) {
            return false;
        }
        if (!(layoutManager instanceof RecyclerView.v.b) || (vVarCreateScroller = createScroller(layoutManager)) == null || (iFindTargetSnapPosition = findTargetSnapPosition(layoutManager, i10, i11)) == -1) {
            z10 = false;
        } else {
            vVarCreateScroller.setTargetPosition(iFindTargetSnapPosition);
            layoutManager.startSmoothScroll(vVarCreateScroller);
            z10 = true;
        }
        return z10;
    }
}
