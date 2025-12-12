package ub;

import flix.com.vision.activities.DramaFilterActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20240b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ DramaFilterActivity f20241m;

    public /* synthetic */ o(DramaFilterActivity dramaFilterActivity, int i10) {
        this.f20240b = i10;
        this.f20241m = dramaFilterActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f20240b;
        DramaFilterActivity dramaFilterActivity = this.f20241m;
        switch (i10) {
            case 0:
                int i11 = DramaFilterActivity.f11616a0;
                dramaFilterActivity.ExtractDominentColor();
                break;
            default:
                dramaFilterActivity.T = false;
                break;
        }
    }
}
