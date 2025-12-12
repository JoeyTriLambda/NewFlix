package ub;

import android.content.DialogInterface;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.activities.UserTorrentsActivity;
import flix.com.vision.activities.adult.AdultHistoryActivity;
import flix.com.vision.activities.adult.AdultVideosActivity;
import flix.com.vision.activities.adult.AdultVideosFavoritesActivity;
import flix.com.vision.activities.adult.AdultVideosSearchActivity;
import flix.com.vision.activities.player.AdultVideoPlayerActivity;
import flix.com.vision.activities.player.SimpleVideoPlayer;
import flix.com.vision.tv.ChannelsListActivity2;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class p0 implements DialogInterface.OnDismissListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20249b;

    public /* synthetic */ p0(int i10) {
        this.f20249b = i10;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.f20249b) {
            case 0:
                int i10 = LinksActivity.C0;
                break;
            case 1:
                int i11 = SettingsActivity.f11809o2;
                break;
            case 2:
                int i12 = SettingsActivity.f11809o2;
                break;
            case 3:
                int i13 = UserTorrentsActivity.X;
                break;
            case 4:
                int i14 = AdultHistoryActivity.X;
                break;
            case 5:
                int i15 = AdultVideosActivity.f11889g0;
                break;
            case 6:
                int i16 = AdultVideosFavoritesActivity.X;
                break;
            case 7:
                int i17 = AdultVideosSearchActivity.Z;
                break;
            case 8:
                int i18 = AdultVideoPlayerActivity.f11962b0;
                break;
            case 9:
                int i19 = SimpleVideoPlayer.f11976g1;
                break;
            case 10:
                int i20 = SimpleVideoPlayer.f11976g1;
                break;
            default:
                int i21 = ChannelsListActivity2.U;
                break;
        }
    }
}
