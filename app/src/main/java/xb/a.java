package xb;

import flix.com.vision.activities.leanback.FilterActivityLeanBack;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21722b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ FilterActivityLeanBack f21723m;

    public /* synthetic */ a(FilterActivityLeanBack filterActivityLeanBack, int i10) {
        this.f21722b = i10;
        this.f21723m = filterActivityLeanBack;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f21722b;
        FilterActivityLeanBack filterActivityLeanBack = this.f21723m;
        switch (i10) {
            case 0:
                filterActivityLeanBack.d(filterActivityLeanBack.f11915k0);
                break;
            default:
                filterActivityLeanBack.f11917m0 = false;
                break;
        }
    }
}
