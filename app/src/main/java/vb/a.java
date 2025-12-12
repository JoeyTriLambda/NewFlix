package vb;

import flix.com.vision.activities.adult.AdultCategoriesActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20650b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AdultCategoriesActivity f20651m;

    public /* synthetic */ a(AdultCategoriesActivity adultCategoriesActivity, int i10) {
        this.f20650b = i10;
        this.f20651m = adultCategoriesActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f20650b;
        AdultCategoriesActivity adultCategoriesActivity = this.f20651m;
        switch (i10) {
            case 0:
                adultCategoriesActivity.W.requestFocus();
                break;
            default:
                adultCategoriesActivity.Y = false;
                break;
        }
    }
}
