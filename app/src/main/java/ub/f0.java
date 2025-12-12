package ub;

import flix.com.vision.activities.FilterActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20177b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ FilterActivity f20178m;

    public /* synthetic */ f0(FilterActivity filterActivity, int i10) {
        this.f20177b = i10;
        this.f20178m = filterActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f20177b;
        FilterActivity filterActivity = this.f20178m;
        switch (i10) {
            case 0:
                filterActivity.f11669m0 = false;
                break;
            default:
                filterActivity.d(filterActivity.f11667k0);
                break;
        }
    }
}
