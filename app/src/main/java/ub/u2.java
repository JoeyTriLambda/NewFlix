package ub;

import android.content.DialogInterface;
import android.os.Handler;
import android.widget.Toast;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.TraktTvConfigActivity;
import flix.com.vision.activities.leanback.MainActivityLeanback;
import flix.com.vision.activities.player.SimpleVideoPlayer;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class u2 implements DialogInterface.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20291b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f20292m;

    public /* synthetic */ u2(Object obj, int i10) {
        this.f20291b = i10;
        this.f20292m = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        int i11 = this.f20291b;
        Object obj = this.f20292m;
        switch (i11) {
            case 0:
                TraktTvConfigActivity traktTvConfigActivity = (TraktTvConfigActivity) obj;
                int i12 = TraktTvConfigActivity.f11876a0;
                traktTvConfigActivity.getClass();
                App.getInstance().f11574v.edit().putBoolean("trakt_user_logged_in", false).apply();
                dialogInterface.dismiss();
                new Handler().postDelayed(new x4.a(1), 500L);
                Toast.makeText(traktTvConfigActivity.getBaseContext(), R.string.you_successfully_signed_out_mess, 1).show();
                traktTvConfigActivity.finish();
                break;
            case 1:
                MainActivityLeanback.a aVar = (MainActivityLeanback.a) obj;
                int i13 = MainActivityLeanback.a.f11926f;
                aVar.getClass();
                dialogInterface.dismiss();
                aVar.cancel(true);
                break;
            default:
                SimpleVideoPlayer simpleVideoPlayer = (SimpleVideoPlayer) obj;
                simpleVideoPlayer.f11978a1 = i10;
                dialogInterface.dismiss();
                simpleVideoPlayer.f11980b1 = false;
                zd.a.downloadSubtitle(simpleVideoPlayer, simpleVideoPlayer.Z0.get(simpleVideoPlayer.f11978a1).f13033b);
                break;
        }
    }
}
