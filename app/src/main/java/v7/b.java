package v7;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import flix.com.vision.R;
import flix.com.vision.activities.AnimeDetailActivity;
import flix.com.vision.activities.DramaDetailActivity;
import flix.com.vision.activities.TraktTvConfigActivity;
import flix.com.vision.activities.leanback.MainActivityLeanback;
import flix.com.vision.activities.player.SimpleVideoPlayer;
import flix.com.vision.tv.MyImportActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20527b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f20528m;

    public /* synthetic */ b(Object obj, int i10) {
        this.f20527b = i10;
        this.f20528m = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        int i10 = this.f20527b;
        Object obj = this.f20528m;
        switch (i10) {
            case 0:
                e eVar = (e) obj;
                eVar.o(eVar.p());
                break;
            case 1:
                k kVar = (k) obj;
                kVar.f20551l = z10;
                kVar.l();
                if (!z10) {
                    kVar.o(false);
                    kVar.f20552m = false;
                    break;
                }
                break;
            case 2:
                AnimeDetailActivity animeDetailActivity = (AnimeDetailActivity) obj;
                if (!z10) {
                    animeDetailActivity.K.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animeDetailActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                    o1.a.k(animeDetailActivity.N, 100L, 1.0f);
                    o1.a.r(animeDetailActivity.N, 100L, 1.0f);
                    break;
                } else {
                    animeDetailActivity.K.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animeDetailActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                    o1.a.k(animeDetailActivity.N, 100L, 1.02f);
                    o1.a.r(animeDetailActivity.N, 100L, 1.02f);
                    break;
                }
            case 3:
                DramaDetailActivity dramaDetailActivity = (DramaDetailActivity) obj;
                if (!z10) {
                    dramaDetailActivity.K.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaDetailActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                    o1.a.k(dramaDetailActivity.N, 100L, 1.0f);
                    o1.a.r(dramaDetailActivity.N, 100L, 1.0f);
                    break;
                } else {
                    dramaDetailActivity.K.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaDetailActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                    o1.a.k(dramaDetailActivity.N, 100L, 1.02f);
                    o1.a.r(dramaDetailActivity.N, 100L, 1.02f);
                    break;
                }
            case 4:
                TraktTvConfigActivity traktTvConfigActivity = (TraktTvConfigActivity) obj;
                if (!z10) {
                    traktTvConfigActivity.Y.setTextColor(traktTvConfigActivity.getResources().getColor(R.color.black));
                    break;
                } else {
                    traktTvConfigActivity.Y.setTextColor(traktTvConfigActivity.getResources().getColor(R.color.white));
                    break;
                }
            case 5:
                MainActivityLeanback mainActivityLeanback = (MainActivityLeanback) obj;
                int i11 = MainActivityLeanback.f11919g0;
                if (z10 && !mainActivityLeanback.f()) {
                    mainActivityLeanback.g();
                    break;
                } else if (!z10) {
                    if (mainActivityLeanback.f()) {
                        mainActivityLeanback.d();
                        break;
                    }
                } else {
                    mainActivityLeanback.getClass();
                    break;
                }
                break;
            case 6:
                SimpleVideoPlayer simpleVideoPlayer = (SimpleVideoPlayer) obj;
                if (!z10) {
                    simpleVideoPlayer.f11985e0.C.getProgressDrawable().setColorFilter(simpleVideoPlayer.getResources().getColor(R.color.accent), PorterDuff.Mode.MULTIPLY);
                    break;
                } else {
                    simpleVideoPlayer.f11985e0.C.getProgressDrawable().setColorFilter(simpleVideoPlayer.getResources().getColor(R.color.md_yellow_500), PorterDuff.Mode.MULTIPLY);
                    break;
                }
            default:
                MyImportActivity myImportActivity = (MyImportActivity) obj;
                if (!z10) {
                    myImportActivity.O.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(myImportActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                    break;
                } else {
                    myImportActivity.O.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(myImportActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                    break;
                }
        }
    }
}
