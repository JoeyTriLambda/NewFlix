package ub;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import flix.com.vision.activities.DramaFilterActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class n implements SwipeRefreshLayout.f, aa.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DramaFilterActivity f20236b;

    @Override // aa.a
    public final void onMoreAsked(int i10, int i11, int i12) {
        DramaFilterActivity dramaFilterActivity = this.f20236b;
        int i13 = dramaFilterActivity.O + 1;
        dramaFilterActivity.O = i13;
        dramaFilterActivity.d(i13);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.f
    public final void onRefresh() {
        DramaFilterActivity dramaFilterActivity = this.f20236b;
        dramaFilterActivity.O = 0;
        dramaFilterActivity.Q.clear();
        dramaFilterActivity.e(dramaFilterActivity.O);
    }
}
