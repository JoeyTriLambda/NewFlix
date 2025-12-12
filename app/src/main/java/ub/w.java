package ub;

import flix.com.vision.activities.DramaSearchActivityMobile;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class w implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20304b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ DramaSearchActivityMobile f20305m;

    public /* synthetic */ w(DramaSearchActivityMobile dramaSearchActivityMobile, int i10) {
        this.f20304b = i10;
        this.f20305m = dramaSearchActivityMobile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f20304b;
        DramaSearchActivityMobile dramaSearchActivityMobile = this.f20305m;
        switch (i10) {
            case 0:
                dramaSearchActivityMobile.R = false;
                break;
            default:
                dramaSearchActivityMobile.M.openSearch();
                break;
        }
    }
}
