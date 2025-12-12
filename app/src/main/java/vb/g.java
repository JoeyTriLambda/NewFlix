package vb;

import android.widget.Toast;
import flix.com.vision.activities.adult.AdultVideosActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20662b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AdultVideosActivity f20663m;

    public /* synthetic */ g(AdultVideosActivity adultVideosActivity, int i10) {
        this.f20662b = i10;
        this.f20663m = adultVideosActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f20662b;
        AdultVideosActivity adultVideosActivity = this.f20663m;
        switch (i10) {
            case 0:
                int i11 = adultVideosActivity.f11891b0 + 1;
                adultVideosActivity.f11891b0 = i11;
                adultVideosActivity.getVideos(i11);
                break;
            case 1:
                adultVideosActivity.f11893d0 = false;
                break;
            case 2:
                adultVideosActivity.X.requestFocus();
                break;
            default:
                if (adultVideosActivity.W.size() == 0) {
                    Toast.makeText(adultVideosActivity.getBaseContext(), "We're not able to load any data. AdultZone may be blocked in your region. Please try with a VPN", 1).show();
                    break;
                }
                break;
        }
    }
}
