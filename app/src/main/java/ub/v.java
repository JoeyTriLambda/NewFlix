package ub;

import ac.b0;
import ac.c0;
import ac.d0;
import ac.e0;
import ac.h;
import ac.j;
import ac.l;
import ac.m;
import ac.n;
import ac.r;
import ac.t;
import ac.u;
import ac.y;
import ac.z;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import com.unity3d.ads.metadata.MediationMetaData;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.CastMoviesActivity;
import flix.com.vision.activities.DramaHomeActivity;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.MainActivity.b;
import flix.com.vision.activities.SearchActivityTV;
import flix.com.vision.activities.UserTorrentsActivity;
import flix.com.vision.activities.WatchedAcvivity;
import flix.com.vision.activities.adult.AdultHistoryActivity;
import flix.com.vision.activities.leanback.MainActivityLeanback;
import flix.com.vision.activities.leanback.MainActivityLeanback.a;
import flix.com.vision.activities.player.SimpleVideoPlayer;
import flix.com.vision.bvp.subtitle.CaptionsView;
import flix.com.vision.models.Drama;
import flix.com.vision.models.Movie;
import flix.com.vision.subtitles.SubtitlesWebViewActivity;
import flix.com.vision.tv.Constant;
import flix.com.vision.tv.MyImportActivity;
import java.util.Iterator;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class v implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20293b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f20294m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f20295n;

    public /* synthetic */ v(int i10, Object obj, Object obj2) {
        this.f20293b = i10;
        this.f20294m = obj;
        this.f20295n = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f20293b;
        Object obj = this.f20295n;
        Object obj2 = this.f20294m;
        switch (i10) {
            case 0:
                DramaHomeActivity dramaHomeActivity = (DramaHomeActivity) obj2;
                int i11 = DramaHomeActivity.f11619x0;
                dramaHomeActivity.getClass();
                App.getInstance().f11573u.addDramaToFavorites((Drama) obj);
                be.d.makeToast(dramaHomeActivity, "Added to Favorites", true);
                break;
            case 1:
                MainActivity mainActivity = (MainActivity) obj2;
                int i12 = MainActivity.f11697v0;
                mainActivity.getClass();
                mainActivity.new b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (String) obj);
                break;
            case 2:
                MainActivity mainActivity2 = (MainActivity) obj2;
                int i13 = MainActivity.f11697v0;
                mainActivity2.getClass();
                App.getInstance().f11573u.addMovieFavorites((Movie) obj);
                be.d.makeToast(mainActivity2, "Added to Favorites", true);
                break;
            case 3:
                SearchActivityTV searchActivityTV = (SearchActivityTV) obj2;
                kc.d dVar = (kc.d) obj;
                int i14 = SearchActivityTV.f11775j0;
                searchActivityTV.getClass();
                dVar.dismiss();
                if (m0.a.checkSelfPermission(searchActivityTV, "android.permission.WRITE_EXTERNAL_STORAGE") != -1) {
                    if (Build.VERSION.SDK_INT >= 26 && !searchActivityTV.getPackageManager().canRequestPackageInstalls()) {
                        dVar.dismiss();
                        kc.d dVarNewInstance = kc.d.newInstance(searchActivityTV, true);
                        dVarNewInstance.setTitle("Grant install Permission");
                        dVarNewInstance.setMessage("Please grant the Permission to install the Update");
                        dVarNewInstance.setButton1("Cancel", new z0(dVarNewInstance, 6));
                        dVarNewInstance.setButton2("OK", new r1(searchActivityTV, 4));
                        dVarNewInstance.show(searchActivityTV.getFragmentManager(), "");
                        break;
                    } else {
                        SharedPreferences sharedPreferences = App.getInstance().f11574v;
                        String str = Constant.f12450b;
                        String string = sharedPreferences.getString("update_url", null);
                        if (string != null) {
                            new SearchActivityTV.b(searchActivityTV).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, string);
                            break;
                        }
                    }
                } else {
                    Toast.makeText(searchActivityTV.getBaseContext(), searchActivityTV.getString(R.string.please_grant_permissions_label), 1).show();
                    l0.a.requestPermissions(searchActivityTV, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
                    break;
                }
                break;
            case 4:
                WatchedAcvivity watchedAcvivity = (WatchedAcvivity) obj2;
                int i15 = WatchedAcvivity.P;
                watchedAcvivity.getClass();
                App.getInstance().f11573u.addMovieFavorites((Movie) obj);
                be.d.makeToast(watchedAcvivity, "Added to Favorites", true);
                break;
            case 5:
                AdultHistoryActivity adultHistoryActivity = (AdultHistoryActivity) obj2;
                int i16 = AdultHistoryActivity.X;
                adultHistoryActivity.getClass();
                App.getInstance().f11573u.addFavoritesAdult((id.c) obj);
                be.d.makeToast(adultHistoryActivity, "Added to Favorites", true);
                break;
            case 6:
                MainActivityLeanback mainActivityLeanback = (MainActivityLeanback) obj2;
                int i17 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                mainActivityLeanback.new a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (String) obj);
                break;
            case 7:
                SimpleVideoPlayer simpleVideoPlayer = (SimpleVideoPlayer) obj2;
                simpleVideoPlayer.f11985e0.setCaptionsPath((String) obj, CaptionsView.CMime.SUBRIP, "");
                simpleVideoPlayer.s();
                try {
                    ic.a.Success(simpleVideoPlayer.getApplicationContext(), "Subtitles Enabled", null, 48, 0);
                    break;
                } catch (Exception unused) {
                    return;
                }
            case 8:
                h.a aVar = (h.a) obj;
                gd.d dVar2 = ((ac.h) obj2).f457e;
                if (dVar2 != null) {
                    dVar2.openAnime(aVar.f462u);
                    break;
                }
                break;
            case 9:
                ac.j jVar = (ac.j) obj2;
                j.b bVar = (j.b) obj;
                jVar.getClass();
                Activity activity = jVar.f475d;
                Intent intent = new Intent(activity, (Class<?>) CastMoviesActivity.class);
                intent.putExtra("gender", bVar.f482u.f12975c);
                intent.putExtra(MediationMetaData.KEY_NAME, bVar.f482u.getName());
                intent.putExtra("id", bVar.f482u.getId());
                intent.putExtra("image", bVar.f482u.getImg_url());
                intent.putExtra("type", jVar.f476e);
                activity.startActivity(intent);
                break;
            case 10:
                ac.l lVar = (ac.l) obj2;
                l.a aVar2 = (l.a) obj;
                lVar.getClass();
                App.getInstance().f11574v.edit().putInt(lVar.f497d, aVar2.f501u.f12990a).apply();
                Iterator<hd.e> it = lVar.f498e.iterator();
                while (it.hasNext()) {
                    it.next().f12991b = false;
                }
                aVar2.f501u.f12991b = true;
                androidx.appcompat.app.d dVar3 = lVar.f500g;
                if (dVar3 != null) {
                    try {
                        dVar3.dismiss();
                    } catch (Exception unused2) {
                    }
                }
                lVar.notifyDataSetChanged();
                break;
            case 11:
                m.a aVar3 = (m.a) obj;
                gd.e eVar = ((ac.m) obj2).f506d;
                if (eVar != null) {
                    eVar.openDrama(aVar3.f509u);
                    break;
                }
                break;
            case 12:
                n.a aVar4 = (n.a) obj;
                gd.e eVar2 = ((ac.n) obj2).f515d;
                if (eVar2 != null) {
                    eVar2.openDrama(aVar4.f518u);
                    break;
                }
                break;
            case 13:
                ((ac.r) obj2).f549g.onLetterClicked(((r.a) obj).f551u);
                break;
            case 14:
                ((ac.t) obj2).f558d.onMediaSelected(((t.b) obj).f570u);
                break;
            case 15:
                u.a aVar5 = (u.a) obj;
                Activity activity2 = ((ac.u) obj2).f576d;
                if (activity2 instanceof MainActivity) {
                    ((MainActivity) activity2).onNetworkClicked(aVar5.f578u);
                    break;
                }
                break;
            case 16:
                ((ac.y) obj2).f602e.openCategory(((y.a) obj).f604u);
                break;
            case 17:
                ac.z zVar = (ac.z) obj2;
                z.a aVar6 = (z.a) obj;
                zVar.getClass();
                boolean zEquals = aVar6.f612u.f13010n.equals("1");
                Activity activity3 = zVar.f608d;
                if (!zEquals) {
                    androidx.appcompat.widget.r0 r0Var = new androidx.appcompat.widget.r0(activity3, aVar6.f613v);
                    if (aVar6.f612u.f13010n.equals("3")) {
                        r0Var.getMenuInflater().inflate(R.menu.history_menu_file, r0Var.getMenu());
                    } else {
                        r0Var.getMenuInflater().inflate(R.menu.history_menu, r0Var.getMenu());
                    }
                    r0Var.setOnMenuItemClickListener(new q2.b(9, zVar, aVar6, r0Var));
                    r0Var.show();
                    break;
                } else {
                    ((MyImportActivity) activity3).openItem(aVar6.f612u);
                    break;
                }
            case 18:
                b0.a aVar7 = (b0.a) obj;
                ((UserTorrentsActivity) ((ac.b0) obj2).f391e).torrentClicked(aVar7.f392u);
                aVar7.f392u.clicked = true;
                aVar7.f394w.setAlpha(0.4f);
                aVar7.f395x.setAlpha(0.4f);
                break;
            case 19:
                c0.a aVar8 = (c0.a) obj;
                ((LinksActivity) ((ac.c0) obj2).f401h).linkClicked(aVar8.f402u, false);
                aVar8.f402u.f13041q = true;
                aVar8.f404w.setAlpha(0.4f);
                aVar8.f405x.setAlpha(0.4f);
                break;
            case 20:
                ((ac.d0) obj2).f415d.onMediaSelected(((d0.b) obj).f426u);
                break;
            case 21:
                ((ac.e0) obj2).f436d.onMediaSelected(((e0.a) obj).f439u);
                break;
            default:
                SubtitlesWebViewActivity subtitlesWebViewActivity = (SubtitlesWebViewActivity) obj2;
                String str2 = (String) obj;
                int i18 = SubtitlesWebViewActivity.R;
                subtitlesWebViewActivity.getClass();
                try {
                    if (str2.endsWith(".srt") || str2.endsWith(".vtt")) {
                        zd.a.downloadSubtitleDirect(subtitlesWebViewActivity, str2);
                    } else {
                        zd.a.downloadSubtitle(subtitlesWebViewActivity, str2);
                    }
                } catch (Exception unused3) {
                }
                subtitlesWebViewActivity.finish();
                break;
        }
    }
}
