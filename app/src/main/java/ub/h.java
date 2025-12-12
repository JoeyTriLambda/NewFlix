package ub;

import flix.com.vision.activities.AnimesListActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20190b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AnimesListActivity f20191m;

    public /* synthetic */ h(AnimesListActivity animesListActivity, int i10) {
        this.f20190b = i10;
        this.f20191m = animesListActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f20190b;
        AnimesListActivity animesListActivity = this.f20191m;
        switch (i10) {
            case 0:
                int i11 = AnimesListActivity.f11597f0;
                animesListActivity.ExtractDominentColor();
                break;
            default:
                animesListActivity.f11602e0 = false;
                break;
        }
    }
}
