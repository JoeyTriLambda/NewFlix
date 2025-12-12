package ub;

import android.view.View;
import flix.com.vision.App;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.SeriesDetailActivity;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.activities.WatchedAcvivity;
import flix.com.vision.activities.YouTubePlayerActivity;
import flix.com.vision.activities.adult.AdultVideosFavoritesActivity;
import flix.com.vision.activities.leanback.MainActivityLeanback;
import flix.com.vision.activities.player.AdultVideoPlayerActivity;
import flix.com.vision.activities.player.SimpleVideoPlayer;
import flix.com.vision.activities.player.YouTubeWebviewActivity;
import flix.com.vision.subtitles.SubtitlesWebViewActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class q0 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20253b;

    public /* synthetic */ q0(int i10) {
        this.f20253b = i10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f20253b) {
            case 0:
                int i10 = LinksActivity.C0;
                break;
            case 1:
                int i11 = LinksActivity.C0;
                break;
            case 2:
                int i12 = MainActivity.f11697v0;
                break;
            case 3:
                int i13 = MainActivity.f11697v0;
                break;
            case 4:
                int i14 = SeriesDetailActivity.f11800h0;
                break;
            case 5:
                int i15 = SeriesDetailActivity.f11800h0;
                o1.a.j(App.getInstance().f11574v, "trakt_episode_always_send", true);
                break;
            case 6:
                int i16 = SettingsActivity.f11809o2;
                break;
            case 7:
                int i17 = SettingsActivity.f11809o2;
                break;
            case 8:
                int i18 = SettingsActivity.f11809o2;
                break;
            case 9:
                int i19 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "hindi_include_english", true);
                break;
            case 10:
                int i20 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "hindi_include_english", false);
                break;
            case 11:
                int i21 = SettingsActivity.f11809o2;
                break;
            case 12:
                int i22 = SettingsActivity.f11809o2;
                break;
            case 13:
                int i23 = SettingsActivity.f11809o2;
                break;
            case 14:
                int i24 = WatchedAcvivity.P;
                break;
            case 15:
                int i25 = YouTubePlayerActivity.f11878t;
                break;
            case 16:
                int i26 = AdultVideosFavoritesActivity.X;
                break;
            case 17:
                int i27 = MainActivityLeanback.f11919g0;
                break;
            case 18:
                int i28 = MainActivityLeanback.f11919g0;
                break;
            case 19:
                int i29 = MainActivityLeanback.f11919g0;
                break;
            case 20:
                int i30 = AdultVideoPlayerActivity.f11962b0;
                break;
            case 21:
                int i31 = AdultVideoPlayerActivity.f11962b0;
                break;
            case 22:
                int i32 = SimpleVideoPlayer.f11976g1;
                break;
            case 23:
                int i33 = SimpleVideoPlayer.f11976g1;
                break;
            case 24:
                int i34 = SimpleVideoPlayer.f11976g1;
                break;
            case 25:
                int i35 = YouTubeWebviewActivity.U;
                break;
            case 26:
                int i36 = SubtitlesWebViewActivity.R;
                o1.a.j(App.getInstance().f11574v, "open_sub_help_shown", true);
                break;
            case 27:
                int i37 = SubtitlesWebViewActivity.R;
                break;
            default:
                int i38 = SubtitlesWebViewActivity.R;
                break;
        }
    }
}
