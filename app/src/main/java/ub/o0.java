package ub;

import android.content.DialogInterface;
import android.net.Uri;
import flix.com.vision.R;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.activities.UserTorrentsActivity;
import flix.com.vision.activities.adult.AdultHistoryActivity;
import flix.com.vision.activities.adult.AdultVideosActivity;
import flix.com.vision.activities.adult.AdultVideosFavoritesActivity;
import flix.com.vision.activities.adult.AdultVideosSearchActivity;
import flix.com.vision.activities.player.AdultVideoPlayerActivity;
import flix.com.vision.activities.player.SimpleVideoPlayer;
import flix.com.vision.tv.ChannelsListActivity2;
import java.util.ArrayList;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class o0 implements DialogInterface.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20242b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f20243m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ r.j f20244n;

    public /* synthetic */ o0(r.j jVar, Object obj, int i10) {
        this.f20242b = i10;
        this.f20244n = jVar;
        this.f20243m = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        int i11 = this.f20242b;
        Object obj = this.f20243m;
        r.j jVar = this.f20244n;
        switch (i11) {
            case 0:
                LinksActivity linksActivity = (LinksActivity) jVar;
                int i12 = LinksActivity.C0;
                linksActivity.getClass();
                linksActivity.d((hd.o) ((ArrayList) obj).get(i10));
                break;
            case 1:
                UserTorrentsActivity userTorrentsActivity = (UserTorrentsActivity) jVar;
                int i13 = UserTorrentsActivity.X;
                userTorrentsActivity.getClass();
                userTorrentsActivity.f((hd.o) ((ArrayList) obj).get(i10));
                break;
            case 2:
                AdultHistoryActivity adultHistoryActivity = (AdultHistoryActivity) jVar;
                int i14 = AdultHistoryActivity.X;
                adultHistoryActivity.getClass();
                adultHistoryActivity.playAdultLink(((id.b) ((ArrayList) obj).get(i10)).f13364m);
                dialogInterface.dismiss();
                break;
            case 3:
                AdultVideosActivity adultVideosActivity = (AdultVideosActivity) jVar;
                int i15 = AdultVideosActivity.f11889g0;
                adultVideosActivity.getClass();
                adultVideosActivity.playAdultLink(((id.b) ((ArrayList) obj).get(i10)).f13364m);
                dialogInterface.dismiss();
                break;
            case 4:
                AdultVideosFavoritesActivity adultVideosFavoritesActivity = (AdultVideosFavoritesActivity) jVar;
                int i16 = AdultVideosFavoritesActivity.X;
                adultVideosFavoritesActivity.getClass();
                adultVideosFavoritesActivity.playAdultLink(((id.b) ((ArrayList) obj).get(i10)).f13364m);
                dialogInterface.dismiss();
                break;
            case 5:
                AdultVideosSearchActivity adultVideosSearchActivity = (AdultVideosSearchActivity) jVar;
                int i17 = AdultVideosSearchActivity.Z;
                adultVideosSearchActivity.getClass();
                adultVideosSearchActivity.playAdultLink(((id.b) ((ArrayList) obj).get(i10)).f13364m);
                dialogInterface.dismiss();
                break;
            case 6:
                AdultVideoPlayerActivity adultVideoPlayerActivity = (AdultVideoPlayerActivity) jVar;
                int i18 = AdultVideoPlayerActivity.f11962b0;
                adultVideoPlayerActivity.getClass();
                adultVideoPlayerActivity.playAdultLink(((id.b) ((ArrayList) obj).get(i10)).f13364m);
                dialogInterface.dismiss();
                break;
            case 7:
                SimpleVideoPlayer simpleVideoPlayer = (SimpleVideoPlayer) jVar;
                ArrayList arrayList = (ArrayList) obj;
                simpleVideoPlayer.A0 = null;
                if (!simpleVideoPlayer.f11985e0.isPlaying()) {
                    simpleVideoPlayer.M0 = true;
                }
                hd.o oVar = (hd.o) arrayList.get(i10);
                simpleVideoPlayer.H0 = false;
                simpleVideoPlayer.L0 = simpleVideoPlayer.f11985e0.getCurrentPosition();
                simpleVideoPlayer.f11985e0.reset();
                simpleVideoPlayer.f11985e0.setSource(Uri.parse(oVar.D));
                simpleVideoPlayer.K0 = i10;
                dialogInterface.dismiss();
                try {
                    int i19 = simpleVideoPlayer.K0;
                    if (i19 != -1 && i19 < simpleVideoPlayer.T.size()) {
                        int i20 = (simpleVideoPlayer.f11995m0.isSeries() || simpleVideoPlayer.f11995m0.isAnime() || simpleVideoPlayer.f11995m0.f12397o) ? 3 : 2;
                        if (simpleVideoPlayer.T.get(simpleVideoPlayer.K0).C.contains("1080")) {
                            simpleVideoPlayer.f11985e0.getToolbar().getMenu().getItem(i20).setIcon(R.drawable.ic_fhd);
                        }
                        if (simpleVideoPlayer.T.get(simpleVideoPlayer.K0).C.contains("720")) {
                            simpleVideoPlayer.f11985e0.getToolbar().getMenu().getItem(i20).setIcon(R.drawable.ic_hd);
                        }
                        if (simpleVideoPlayer.T.get(simpleVideoPlayer.K0).C.contains("480") || simpleVideoPlayer.T.get(simpleVideoPlayer.K0).C.contains("250") || simpleVideoPlayer.T.get(simpleVideoPlayer.K0).C.contains("360")) {
                            simpleVideoPlayer.f11985e0.getToolbar().getMenu().getItem(i20).setIcon(R.drawable.ic_sd);
                            break;
                        }
                    }
                } catch (Exception unused) {
                    return;
                }
                break;
            default:
                ChannelsListActivity2 channelsListActivity2 = (ChannelsListActivity2) jVar;
                hd.d dVar = (hd.d) obj;
                int i21 = ChannelsListActivity2.U;
                channelsListActivity2.getClass();
                hd.d dVar2 = new hd.d(dVar);
                dVar2.f12989v.add(0, dVar.f12989v.get(i10));
                channelsListActivity2.OpenChannell(dVar2);
                break;
        }
    }
}
