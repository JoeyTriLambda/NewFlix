package flix.com.vision.activities;

import ac.b0;
import ac.c;
import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import d4.m;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.UserTorrentsActivity;
import flix.com.vision.activities.player.SimpleVideoPlayer;
import flix.com.vision.api.alldebrid.AllDebridCommon;
import flix.com.vision.api.premiumize.PremiumizeCommon;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.helpers.Constants;
import flix.com.vision.models.Movie;
import flix.com.vision.models.torrent.UserTorrent;
import flix.com.vision.processors.english.BaseProcessor;
import gd.j;
import hd.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kc.d;
import ub.n0;
import ub.o0;
import ub.p0;
import ub.w2;
import ub.x2;

/* loaded from: classes2.dex */
public class UserTorrentsActivity extends wb.a implements j {
    public static final /* synthetic */ int X = 0;
    public RecyclerView L;
    public RelativeLayout M;
    public RelativeLayout N;
    public RelativeLayout O;
    public qe.b P;
    public b0 Q;
    public BaseProcessor.TorrentServiceType R;
    public HashMap T;
    public UserTorrent U;
    public final ArrayList<UserTorrent> K = new ArrayList<>();
    public String S = null;
    public d V = null;
    public final ArrayList<o> W = new ArrayList<>();

    public class a extends m {

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f11877n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, x2 x2Var, n0 n0Var, String str2) {
            super(1, str, x2Var, n0Var);
            this.f11877n = str2;
        }

        @Override // com.android.volley.Request
        public String getBodyContentType() {
            return "application/x-www-form-urlencoded; charset=UTF-8";
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            return c.w("Content-Type", URLEncodedUtils.CONTENT_TYPE);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getParams() {
            HashMap map = new HashMap();
            map.put("src", this.f11877n);
            return map;
        }
    }

    public final void d(ArrayList<o> arrayList) {
        try {
            ArrayList arrayList2 = new ArrayList();
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                arrayList2.add(arrayList.get(i10).C.toUpperCase(Locale.ROOT));
            }
            CharSequence[] charSequenceArr = (CharSequence[]) arrayList2.toArray(new CharSequence[arrayList2.size()]);
            d.a aVar = new d.a(new ContextThemeWrapper(this, R.style.AlertDialogNoHeader));
            aVar.setSingleChoiceItems(charSequenceArr, -1, new o0(this, arrayList, 1));
            aVar.setOnDismissListener(new p0(3));
            aVar.show();
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"CheckResult"})
    public final void e() {
        HashMap map = this.T;
        if (map != null) {
            map.clear();
        }
        qe.b bVar = this.P;
        if (bVar != null) {
            bVar.dispose();
        }
        if (this.R == BaseProcessor.TorrentServiceType.REAL_DEBRID) {
            this.P = bc.a.getMagnetsRealDebridLatest(RealDebridCommon.f12049n, RealDebridCommon.f12047b, 100).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new w2(this, 0), new n0(19));
        }
        if (this.R == BaseProcessor.TorrentServiceType.PREMIUMIZE) {
            this.P = bc.a.getUserTorrentPrem(this.S).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new w2(this, 1), new n0(20));
        }
        if (this.R == BaseProcessor.TorrentServiceType.ALL_DEBRID) {
            bc.a.getAllMagnetAllDebrid().observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new w2(this, 2), new n0(21));
        }
    }

    public final void f(o oVar) {
        int i10 = App.getInstance().f11574v.getInt("player_index", 0);
        if (i10 <= 0 || i10 >= 4) {
            g(oVar);
            return;
        }
        try {
            LinksActivity.PlayExternal(i10, oVar, oVar.C, null, this, -1);
        } catch (Exception unused) {
            Toast.makeText(getBaseContext(), "Failed to load external Player, Make sure it is installed", 1).show();
            g(oVar);
        }
    }

    public final void g(o oVar) {
        String str = oVar.C;
        UserTorrent userTorrent = this.U;
        if (userTorrent != null) {
            str = userTorrent.filename;
        }
        Intent intent = new Intent(this, (Class<?>) SimpleVideoPlayer.class);
        intent.putExtra("movie_id", str);
        intent.putExtra("title", str);
        intent.putExtra("language", oVar.f13045u);
        intent.putExtra("streamUrl", oVar.D);
        intent.putExtra("is_torrent", true);
        startActivity(intent);
    }

    public void getMagnetPrem(String str) {
        App.getInstance().getRequestQueue().add(new a(c.j("https://www.premiumize.me/api/transfer/directdl?apikey=", PremiumizeCommon.f12046m), new x2(this, str, 1), new n0(22), str));
    }

    public final void h() {
        kc.d dVar = this.V;
        if (dVar != null) {
            try {
                dVar.dismiss();
            } catch (Exception unused) {
            }
        }
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, false);
        this.V = dVarNewInstance;
        dVarNewInstance.setloading();
        try {
            this.V.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_torrents);
        this.T = new HashMap();
        SharedPreferences sharedPreferences = App.getInstance().f11574v;
        String str = Constants.f12319a;
        this.S = sharedPreferences.getString("prem_apikey", null);
        BaseProcessor.TorrentServiceType torrentServiceType = BaseProcessor.TorrentServiceType.REAL_DEBRID;
        this.R = torrentServiceType;
        this.O = (RelativeLayout) findViewById(R.id.alldebrid_button);
        this.N = (RelativeLayout) findViewById(R.id.prem_button);
        this.M = (RelativeLayout) findViewById(R.id.rd_button);
        if (AllDebridCommon.f12043n) {
            this.R = BaseProcessor.TorrentServiceType.ALL_DEBRID;
        } else {
            this.O.setVisibility(8);
        }
        if (RealDebridCommon.f12051p) {
            this.R = torrentServiceType;
        } else {
            this.M.setVisibility(8);
        }
        if (PremiumizeCommon.f12045b) {
            this.R = BaseProcessor.TorrentServiceType.PREMIUMIZE;
        } else {
            this.N.setVisibility(8);
        }
        final int i10 = 0;
        this.M.setOnClickListener(new View.OnClickListener(this) { // from class: ub.v2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ UserTorrentsActivity f20303m;

            {
                this.f20303m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                UserTorrentsActivity userTorrentsActivity = this.f20303m;
                switch (i11) {
                    case 0:
                        userTorrentsActivity.R = BaseProcessor.TorrentServiceType.REAL_DEBRID;
                        userTorrentsActivity.K.clear();
                        userTorrentsActivity.Q.notifyDataSetChanged();
                        userTorrentsActivity.e();
                        break;
                    case 1:
                        userTorrentsActivity.R = BaseProcessor.TorrentServiceType.PREMIUMIZE;
                        userTorrentsActivity.K.clear();
                        userTorrentsActivity.Q.notifyDataSetChanged();
                        userTorrentsActivity.e();
                        break;
                    default:
                        userTorrentsActivity.R = BaseProcessor.TorrentServiceType.ALL_DEBRID;
                        userTorrentsActivity.K.clear();
                        userTorrentsActivity.Q.notifyDataSetChanged();
                        userTorrentsActivity.e();
                        break;
                }
            }
        });
        final int i11 = 1;
        this.N.setOnClickListener(new View.OnClickListener(this) { // from class: ub.v2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ UserTorrentsActivity f20303m;

            {
                this.f20303m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                UserTorrentsActivity userTorrentsActivity = this.f20303m;
                switch (i112) {
                    case 0:
                        userTorrentsActivity.R = BaseProcessor.TorrentServiceType.REAL_DEBRID;
                        userTorrentsActivity.K.clear();
                        userTorrentsActivity.Q.notifyDataSetChanged();
                        userTorrentsActivity.e();
                        break;
                    case 1:
                        userTorrentsActivity.R = BaseProcessor.TorrentServiceType.PREMIUMIZE;
                        userTorrentsActivity.K.clear();
                        userTorrentsActivity.Q.notifyDataSetChanged();
                        userTorrentsActivity.e();
                        break;
                    default:
                        userTorrentsActivity.R = BaseProcessor.TorrentServiceType.ALL_DEBRID;
                        userTorrentsActivity.K.clear();
                        userTorrentsActivity.Q.notifyDataSetChanged();
                        userTorrentsActivity.e();
                        break;
                }
            }
        });
        final int i12 = 2;
        this.O.setOnClickListener(new View.OnClickListener(this) { // from class: ub.v2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ UserTorrentsActivity f20303m;

            {
                this.f20303m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i12;
                UserTorrentsActivity userTorrentsActivity = this.f20303m;
                switch (i112) {
                    case 0:
                        userTorrentsActivity.R = BaseProcessor.TorrentServiceType.REAL_DEBRID;
                        userTorrentsActivity.K.clear();
                        userTorrentsActivity.Q.notifyDataSetChanged();
                        userTorrentsActivity.e();
                        break;
                    case 1:
                        userTorrentsActivity.R = BaseProcessor.TorrentServiceType.PREMIUMIZE;
                        userTorrentsActivity.K.clear();
                        userTorrentsActivity.Q.notifyDataSetChanged();
                        userTorrentsActivity.e();
                        break;
                    default:
                        userTorrentsActivity.R = BaseProcessor.TorrentServiceType.ALL_DEBRID;
                        userTorrentsActivity.K.clear();
                        userTorrentsActivity.Q.notifyDataSetChanged();
                        userTorrentsActivity.e();
                        break;
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_cast);
        this.L = recyclerView;
        recyclerView.addItemDecoration(new fd.c(App.K ? 12 : 8));
        this.Q = new b0(this, this.K);
        this.L.setLayoutManager(new LinearLayoutManager(this));
        o1.a.h(8, this.L);
        this.L.setAdapter(this.Q);
        this.M.requestFocus();
        e();
    }

    @Override // gd.j
    public void onMediaSelected(Movie movie) {
        Intent intent = new Intent(this, (Class<?>) MovieDetailActivity.class);
        intent.putExtra("movie", movie);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        finish();
        return true;
    }

    public void torrentClicked(UserTorrent userTorrent) {
        String str;
        String str2;
        this.U = userTorrent;
        BaseProcessor.TorrentServiceType torrentServiceType = userTorrent.source_type;
        BaseProcessor.TorrentServiceType torrentServiceType2 = BaseProcessor.TorrentServiceType.REAL_DEBRID;
        int i10 = 0;
        if (torrentServiceType == torrentServiceType2 && (str2 = userTorrent.status) != null && str2.equals("error")) {
            Toast.makeText(this, "Cannot be played!", 0).show();
            return;
        }
        BaseProcessor.TorrentServiceType torrentServiceType3 = userTorrent.source_type;
        BaseProcessor.TorrentServiceType torrentServiceType4 = BaseProcessor.TorrentServiceType.ALL_DEBRID;
        if (torrentServiceType3 == torrentServiceType4 && (str = userTorrent.status) != null && !str.equals("Ready") && !userTorrent.status.equals("Downloading")) {
            Toast.makeText(this, "Cannot be played now!", 0).show();
            return;
        }
        if (userTorrent.streamable) {
            o videoSource = userTorrent.toVideoSource();
            if (videoSource == null) {
                return;
            }
            f(videoSource);
            return;
        }
        BaseProcessor.TorrentServiceType torrentServiceType5 = userTorrent.source_type;
        if (torrentServiceType5 == BaseProcessor.TorrentServiceType.PREMIUMIZE) {
            ArrayList<o> arrayList = (ArrayList) this.T.get(userTorrent.src);
            if (arrayList == null || arrayList.size() == 0) {
                getMagnetPrem(userTorrent.src);
                return;
            } else {
                d(arrayList);
                return;
            }
        }
        ArrayList<o> arrayList2 = this.W;
        if (torrentServiceType5 == torrentServiceType4) {
            ArrayList<o> arrayList3 = (ArrayList) this.T.get(userTorrent.src);
            if (arrayList3 != null && arrayList3.size() != 0) {
                d(arrayList3);
                return;
            }
            String str3 = userTorrent.file_id;
            arrayList2.clear();
            h();
            new Handler().postDelayed(new androidx.activity.d(this, 28), 5000L);
            bc.a.getMagnetStatusAllDebrid(str3).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new x2(this, str3, i10), new c1.c(str3, 19));
            return;
        }
        if (torrentServiceType5 == torrentServiceType2) {
            ArrayList<o> arrayList4 = (ArrayList) this.T.get(userTorrent.src);
            if (arrayList4 != null && arrayList4.size() != 0) {
                d(arrayList4);
                return;
            }
            String str4 = userTorrent.src;
            h();
            arrayList2.clear();
            bc.a.getLinkRealDebrid(str4, RealDebridCommon.f12049n, RealDebridCommon.f12047b).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new w2(this, 3), new x2(this, str4, 2));
        }
    }

    public void unlockLinkAllRebrid(String str) {
        bc.a.unlockLinkAllDebrid(str).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new w2(this, 4), new n0(23));
    }

    @Override // gd.j
    public void favoriteDeleted(int i10) {
    }
}
