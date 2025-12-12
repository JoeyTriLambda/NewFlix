package vb;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import flix.com.vision.activities.adult.AdultHistoryActivity;
import flix.com.vision.activities.adult.AdultVideosFavoritesActivity;
import flix.com.vision.activities.player.YouTubeWebviewActivity;
import flix.com.vision.processors.english.BaseProcessor;
import flix.com.vision.tv.ChannelsListActivityImport;
import flix.com.vision.tv.TVCategoriesActivity2;
import flix.com.vision.tv.TVCategorySearchActivity;
import flix.com.vision.tv.TVChannelFavoritesActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20656b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f20657m;

    public /* synthetic */ d(Object obj, int i10) {
        this.f20656b = i10;
        this.f20657m = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f20656b;
        Object obj = this.f20657m;
        switch (i10) {
            case 0:
                ((AdultHistoryActivity) obj).S.requestFocus();
                break;
            case 1:
                ((AdultVideosFavoritesActivity) obj).S.requestFocus();
                break;
            case 2:
                YouTubeWebviewActivity youTubeWebviewActivity = YouTubeWebviewActivity.this;
                youTubeWebviewActivity.getClass();
                long jUptimeMillis = SystemClock.uptimeMillis();
                long jUptimeMillis2 = SystemClock.uptimeMillis() + 300;
                float f10 = youTubeWebviewActivity.getResources().getDisplayMetrics().widthPixels / 3;
                float f11 = youTubeWebviewActivity.getResources().getDisplayMetrics().heightPixels / 3;
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis2, 0, f10, f11, 0);
                MotionEvent motionEventObtain2 = MotionEvent.obtain(jUptimeMillis, jUptimeMillis2 + 200, 1, f10, f11, 0);
                youTubeWebviewActivity.P.dispatchTouchEvent(motionEventObtain);
                youTubeWebviewActivity.P.dispatchTouchEvent(motionEventObtain2);
                break;
            case 3:
                ec.d dVar = (ec.d) obj;
                dVar.getClass();
                try {
                    ic.a.Success(dVar.f11202a.getApplicationContext(), "Successfully logged In", null, 80, 0);
                    break;
                } catch (Exception unused) {
                    return;
                }
            case 4:
                kc.i iVar = (kc.i) obj;
                iVar.f15084p.setFocusable(true);
                iVar.f15080b.requestFocus();
                break;
            case 5:
                BaseProcessor baseProcessor = (BaseProcessor) obj;
                baseProcessor.a(baseProcessor.f12434e.pop().intValue());
                break;
            case 6:
                ((vd.b) obj).f20690n = false;
                break;
            case 7:
                ((vd.d) obj).f20708q = false;
                break;
            case 8:
                ((vd.f) obj).f20723n = false;
                break;
            case 9:
                ((vd.h) obj).f20740q = false;
                break;
            case 10:
                ((vd.j) obj).f20754n = false;
                break;
            case 11:
                ((vd.l) obj).f20771p = false;
                break;
            case 12:
            default:
                TVChannelFavoritesActivity tVChannelFavoritesActivity = (TVChannelFavoritesActivity) obj;
                tVChannelFavoritesActivity.N.setInterpolator(new AccelerateInterpolator());
                tVChannelFavoritesActivity.N.setDuration(500L);
                tVChannelFavoritesActivity.R.startAnimation(tVChannelFavoritesActivity.N);
                tVChannelFavoritesActivity.R.setVisibility(8);
                break;
            case 13:
                ChannelsListActivityImport channelsListActivityImport = (ChannelsListActivityImport) obj;
                channelsListActivityImport.f12443a0.setInterpolator(new AccelerateInterpolator());
                channelsListActivityImport.f12443a0.setDuration(500L);
                channelsListActivityImport.f12449g0.startAnimation(channelsListActivityImport.f12443a0);
                channelsListActivityImport.f12449g0.setVisibility(8);
                break;
            case 14:
                TVCategoriesActivity2 tVCategoriesActivity2 = (TVCategoriesActivity2) obj;
                tVCategoriesActivity2.f12485h0.setInterpolator(new AccelerateInterpolator());
                tVCategoriesActivity2.f12485h0.setDuration(500L);
                tVCategoriesActivity2.f12484g0.startAnimation(tVCategoriesActivity2.f12485h0);
                tVCategoriesActivity2.f12484g0.setVisibility(8);
                break;
            case 15:
                ((TVCategorySearchActivity) obj).K.openSearch();
                break;
        }
    }
}
