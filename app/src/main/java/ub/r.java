package ub;

import flix.com.vision.activities.DramaHomeActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class r implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20256b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ DramaHomeActivity f20257m;

    public /* synthetic */ r(DramaHomeActivity dramaHomeActivity, int i10) {
        this.f20256b = i10;
        this.f20257m = dramaHomeActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f20256b;
        DramaHomeActivity dramaHomeActivity = this.f20257m;
        switch (i10) {
            case 0:
                kc.d dVar = dramaHomeActivity.f11640u0;
                if (dVar != null) {
                    try {
                        dVar.dismiss();
                    } catch (Exception unused) {
                    }
                }
                dramaHomeActivity.K.fullScroll(33);
                break;
            default:
                dramaHomeActivity.f11641v0 = false;
                break;
        }
    }
}
