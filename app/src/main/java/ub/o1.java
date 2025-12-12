package ub;

import flix.com.vision.activities.SearchActivityClassic;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class o1 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20245b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SearchActivityClassic f20246m;

    public /* synthetic */ o1(SearchActivityClassic searchActivityClassic, int i10) {
        this.f20245b = i10;
        this.f20246m = searchActivityClassic;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f20245b;
        SearchActivityClassic searchActivityClassic = this.f20246m;
        switch (i10) {
            case 0:
                searchActivityClassic.L.openSearch();
                break;
            default:
                if (!searchActivityClassic.L.isOpen() && !SearchActivityClassic.isTV()) {
                    searchActivityClassic.L.openSearch();
                    break;
                }
                break;
        }
    }
}
