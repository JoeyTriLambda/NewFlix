package vb;

import flix.com.vision.activities.adult.AdultVideosSearchActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20666b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AdultVideosSearchActivity f20667m;

    public /* synthetic */ i(AdultVideosSearchActivity adultVideosSearchActivity, int i10) {
        this.f20666b = i10;
        this.f20667m = adultVideosSearchActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f20666b;
        AdultVideosSearchActivity adultVideosSearchActivity = this.f20667m;
        switch (i10) {
            case 0:
                if (adultVideosSearchActivity.U != null) {
                    int i11 = adultVideosSearchActivity.T + 1;
                    adultVideosSearchActivity.T = i11;
                    adultVideosSearchActivity.getVideos(i11);
                    break;
                }
                break;
            case 1:
                adultVideosSearchActivity.M.openSearch();
                break;
            default:
                adultVideosSearchActivity.W = false;
                break;
        }
    }
}
