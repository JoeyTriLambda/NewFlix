package flix.com.vision.activities.player;

import ac.v;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.d;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.images.WebImage;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.player.SimpleVideoPlayer;
import flix.com.vision.api.alldebrid.AllDebridCommon;
import flix.com.vision.api.premiumize.PremiumizeCommon;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.bvp.BetterVideoPlayer;
import flix.com.vision.bvp.subtitle.CaptionsView;
import flix.com.vision.cast.ExpandedControlsActivity;
import flix.com.vision.models.Movie;
import flix.com.vision.subtitles.SubtitlesWebViewActivity;
import flix.com.vision.tv.Constant;
import gd.f;
import gd.g;
import hd.m;
import hd.n;
import hd.o;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import qd.d0;
import qd.i;
import qd.q;
import qd.u;
import qd.z;
import r.j;
import sd.l;
import ub.m0;
import ub.o0;
import ub.p0;
import ub.q0;
import ub.u2;
import vd.h;
import wd.s;

/* loaded from: classes2.dex */
public class SimpleVideoPlayer extends j implements fc.b, f, g, IUnityAdsInitializationListener {

    /* renamed from: g1, reason: collision with root package name */
    public static final /* synthetic */ int f11976g1 = 0;
    public String A0;
    public String C0;
    public int D0;
    public int E0;
    public int F0;
    public zb.e G0;
    public ImageView L;
    public Animation N0;
    public TextClock O;
    public Animation O0;
    public MediaRouteButton P;
    public Animation P0;
    public ImageView Q;
    public Animation Q0;
    public Handler R;
    public Animation R0;
    public zb.e S;
    public SpinKitView U;
    public RelativeLayout V;
    public RelativeLayout W;
    public CastSession W0;
    public RecyclerView X;
    public SessionManager X0;
    public String Y;
    public Typeface Z;

    /* renamed from: a0, reason: collision with root package name */
    public c4.a f11977a0;

    /* renamed from: a1, reason: collision with root package name */
    public int f11978a1;

    /* renamed from: b0, reason: collision with root package name */
    public String f11979b0;

    /* renamed from: b1, reason: collision with root package name */
    public boolean f11980b1;

    /* renamed from: c0, reason: collision with root package name */
    public Menu f11981c0;

    /* renamed from: c1, reason: collision with root package name */
    public Animation f11982c1;

    /* renamed from: d0, reason: collision with root package name */
    public View f11983d0;

    /* renamed from: d1, reason: collision with root package name */
    public Animation f11984d1;

    /* renamed from: e0, reason: collision with root package name */
    public BetterVideoPlayer f11985e0;

    /* renamed from: e1, reason: collision with root package name */
    public boolean f11986e1;

    /* renamed from: f1, reason: collision with root package name */
    public boolean f11988f1;

    /* renamed from: h0, reason: collision with root package name */
    public TextView f11990h0;

    /* renamed from: i0, reason: collision with root package name */
    public TextView f11991i0;

    /* renamed from: j0, reason: collision with root package name */
    public TextView f11992j0;

    /* renamed from: k0, reason: collision with root package name */
    public TextView f11993k0;

    /* renamed from: l0, reason: collision with root package name */
    public TextView f11994l0;

    /* renamed from: m0, reason: collision with root package name */
    public Movie f11995m0;

    /* renamed from: n0, reason: collision with root package name */
    public ImageView f11996n0;

    /* renamed from: o0, reason: collision with root package name */
    public ImageView f11997o0;

    /* renamed from: p0, reason: collision with root package name */
    public LinearLayout f11998p0;

    /* renamed from: q0, reason: collision with root package name */
    public LinearLayout f11999q0;

    /* renamed from: r0, reason: collision with root package name */
    public LinearLayout f12000r0;

    /* renamed from: s0, reason: collision with root package name */
    public v f12001s0;

    /* renamed from: u0, reason: collision with root package name */
    public CastContext f12003u0;

    /* renamed from: v0, reason: collision with root package name */
    public String f12004v0;
    public boolean K = false;
    public boolean M = false;
    public boolean N = true;
    public ArrayList<o> T = new ArrayList<>();

    /* renamed from: f0, reason: collision with root package name */
    public final fd.b f11987f0 = new fd.b();

    /* renamed from: g0, reason: collision with root package name */
    public Handler f11989g0 = new Handler();

    /* renamed from: t0, reason: collision with root package name */
    public final ArrayList<hd.f> f12002t0 = new ArrayList<>();

    /* renamed from: w0, reason: collision with root package name */
    public int f12005w0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    public String f12006x0 = null;

    /* renamed from: y0, reason: collision with root package name */
    public String f12007y0 = null;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f12008z0 = true;
    public boolean B0 = false;
    public boolean H0 = false;
    public int I0 = 0;
    public boolean J0 = false;
    public int K0 = -1;
    public int L0 = -1;
    public boolean M0 = false;
    public boolean S0 = false;
    public boolean T0 = false;
    public boolean U0 = false;
    public kc.d V0 = null;
    public final e Y0 = new e();
    public ArrayList<m> Z0 = new ArrayList<>();

    public class b extends RemoteMediaClient.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RemoteMediaClient f12010a;

        public b(RemoteMediaClient remoteMediaClient) {
            this.f12010a = remoteMediaClient;
        }

        @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
        public void onStatusUpdated() {
            SimpleVideoPlayer simpleVideoPlayer = SimpleVideoPlayer.this;
            simpleVideoPlayer.startActivity(new Intent(simpleVideoPlayer, (Class<?>) ExpandedControlsActivity.class));
            this.f12010a.unregisterCallback(this);
        }
    }

    public class c implements Comparator<m> {
        @Override // java.util.Comparator
        public int compare(m mVar, m mVar2) {
            return mVar.f13034m.compareTo(mVar2.f13034m);
        }
    }

    public class d implements IUnityAdsShowListener {
        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowClick(String str) {
            Log.v("UnityAdsExample", "onUnityAdsShowClick: " + str);
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
            Log.v("UnityAdsExample", "onUnityAdsShowComplete: " + str);
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
            Log.e("UnityAdsExample", "Unity Ads failed to show ad for " + str + " with error: [" + unityAdsShowError + "] " + str2);
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowStart(String str) {
            Log.v("UnityAdsExample", "onUnityAdsShowStart: " + str);
        }
    }

    public class e implements SessionManagerListener<CastSession> {
        public e() {
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionEnded(CastSession castSession, int i10) {
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionEnding(CastSession castSession) {
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionResumeFailed(CastSession castSession, int i10) {
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionResumed(CastSession castSession, boolean z10) {
            SimpleVideoPlayer simpleVideoPlayer = SimpleVideoPlayer.this;
            BetterVideoPlayer betterVideoPlayer = simpleVideoPlayer.f11985e0;
            if (betterVideoPlayer != null) {
                betterVideoPlayer.getToolbar().invalidateMenu();
            }
            simpleVideoPlayer.W0 = castSession;
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionResuming(CastSession castSession, String str) {
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionStarted(CastSession castSession, String str) throws IllegalArgumentException {
            SimpleVideoPlayer simpleVideoPlayer = SimpleVideoPlayer.this;
            simpleVideoPlayer.f11985e0.getToolbar().invalidateMenu();
            simpleVideoPlayer.W0 = castSession;
            simpleVideoPlayer.e(simpleVideoPlayer.f11985e0.getSource().toString());
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionStarting(CastSession castSession) {
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionSuspended(CastSession castSession, int i10) {
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionStartFailed(CastSession castSession, int i10) {
            CastContext castContext = SimpleVideoPlayer.this.f12003u0;
            if (castContext != null) {
                castContext.getCastReasonCodeForCastStatusCode(i10);
            }
        }
    }

    public SimpleVideoPlayer() {
        new d();
        this.f11978a1 = -1;
        this.f11986e1 = false;
        this.f11988f1 = false;
    }

    public static /* synthetic */ void d(SimpleVideoPlayer simpleVideoPlayer) {
        simpleVideoPlayer.getClass();
        try {
            if (simpleVideoPlayer.f12006x0 != null) {
                App.getInstance().f11574v.edit().putInt(simpleVideoPlayer.f12006x0, simpleVideoPlayer.f11985e0.getCurrentPosition()).apply();
            }
            simpleVideoPlayer.f11985e0.stop();
            simpleVideoPlayer.f11985e0.release();
            super.onBackPressed();
            simpleVideoPlayer.finish();
        } catch (Exception unused) {
        }
    }

    @Override // gd.g
    public void OnM3USuccess(ArrayList<o> arrayList) {
        this.T.addAll(arrayList);
    }

    @Override // gd.f
    public void OnSuccess(ArrayList<o> arrayList) {
        if (arrayList != null) {
            this.T.addAll(arrayList);
        }
    }

    public final void e(String str) throws IllegalArgumentException {
        RemoteMediaClient remoteMediaClient;
        CastSession castSession = this.W0;
        if (castSession == null || (remoteMediaClient = castSession.getRemoteMediaClient()) == null) {
            return;
        }
        remoteMediaClient.registerCallback(new b(remoteMediaClient));
        Movie movie = this.f11995m0;
        String image_url = movie != null ? movie.getImage_url() : null;
        MediaMetadata mediaMetadata = new MediaMetadata(1);
        mediaMetadata.putString("com.google.android.gms.cast.metadata.TITLE", this.f11990h0.getText().toString());
        mediaMetadata.putString("com.google.android.gms.cast.metadata.SUBTITLE", this.f11992j0.getText().toString());
        String str2 = !str.contains("hls") ? "video/*" : "application/vnd.apple.mpegurl";
        String str3 = this.A0;
        if (str3 != null && str3.length() > 5) {
            str2 = this.A0;
        }
        if (image_url != null && image_url.length() > 1) {
            mediaMetadata.addImage(new WebImage(Uri.parse(image_url)));
        }
        MediaLoadRequestData.Builder mediaInfo = new MediaLoadRequestData.Builder().setMediaInfo(new MediaInfo.Builder(str).setStreamType(1).setContentType(str2).setMetadata(mediaMetadata).setStreamDuration(this.f11985e0.getDuration() * 1000).build());
        BetterVideoPlayer betterVideoPlayer = this.f11985e0;
        remoteMediaClient.load(mediaInfo.setCurrentTime((betterVideoPlayer == null || !betterVideoPlayer.isPrepared()) ? 0L : this.f11985e0.getCurrentPosition()).build());
        finish();
    }

    public final void f() {
        Movie movie = this.f11995m0;
        if (movie == null || !(movie.isAnime() || this.f11995m0.f12397o)) {
            new Handler().postDelayed(new zb.e(this, 8), 300L);
        }
    }

    public final void g(ArrayList<o> arrayList) {
        try {
            ArrayList arrayList2 = new ArrayList();
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                arrayList2.add(arrayList.get(i10).C.toUpperCase(Locale.ROOT));
            }
            CharSequence[] charSequenceArr = (CharSequence[]) arrayList2.toArray(new CharSequence[arrayList2.size()]);
            d.a aVar = new d.a(new ContextThemeWrapper(this, R.style.AlertDialogNoHeader));
            aVar.setSingleChoiceItems(charSequenceArr, this.K0, new o0(this, arrayList, 7));
            aVar.setOnDismissListener(new p0(10));
            aVar.show();
        } catch (Exception unused) {
        }
    }

    public final void h() {
        if (this.f11985e0.isPrepared() && this.f11985e0.isPlaying()) {
            this.f11985e0.pause();
            this.f11997o0.setVisibility(0);
            this.f11985e0.pause();
            this.f11985e0.getToolbar().getMenu().getItem(1).setIcon(R.drawable.ic_play_circle2);
        }
        try {
            if (m0.a.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                l0.a.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 10001);
                Toast.makeText(getBaseContext(), "Grant Storage permission First", 0).show();
                return;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        Intent intent = new Intent(this, (Class<?>) SubtitlesWebViewActivity.class);
        StringBuilder sbV = ac.c.v("https://www.opensubtitles.org/en/search/sublanguageid-", App.getInstance().f11574v.getString("sub_lang_code_1", "eng"), "/imdbid-");
        sbV.append(this.f11995m0.getImdbID().replace("tt", ""));
        String string = sbV.toString();
        if (this.f11995m0.isSeries() && App.getInstance().f11564b != null) {
            string = App.getInstance().f11564b;
        }
        intent.putExtra("url", string);
        String title = this.f11995m0.getTitle();
        if (this.f11995m0.isSeries()) {
            StringBuilder sbU = ac.c.u(title, " - S");
            sbU.append(be.f.formatSeasonnumber(this.D0));
            sbU.append("E");
            sbU.append(be.f.formatSeasonnumber(this.E0));
            title = sbU.toString();
        }
        intent.putExtra("title", title);
        startActivity(intent);
    }

    public final void i() {
        kc.d dVar = this.V0;
        if (dVar != null) {
            try {
                dVar.dismiss();
            } catch (Exception unused) {
            }
        }
        if (this.f11986e1) {
            try {
                this.W.setVisibility(8);
                this.L.clearAnimation();
                this.L.setAlpha(1.0f);
            } catch (Exception unused2) {
            }
        }
    }

    public final void j() {
        if (this.f11999q0.getVisibility() == 8) {
            return;
        }
        this.f11999q0.animate().cancel();
        this.f11999q0.startAnimation(this.O0);
        this.f11999q0.setVisibility(8);
    }

    public final void k() {
        this.V.startAnimation(this.f11984d1);
        this.V.setVisibility(8);
        this.X.clearFocus();
    }

    public final void l(int i10) throws UnsupportedEncodingException {
        this.f11988f1 = false;
        this.f11985e0.hideControls();
        this.f11985e0.hideToolbar();
        this.S0 = false;
        if (this.E0 >= App.getInstance().A.size() || App.getInstance().A.isEmpty()) {
            be.d.makeToast(this, "Error indexing episodes list", true);
            return;
        }
        ArrayList<o> arrayList = this.T;
        if (arrayList == null) {
            this.T = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        new Handler().postDelayed(new zb.e(this, 10), 5000L);
        this.T0 = false;
        this.U0 = false;
        this.f11999q0.setVisibility(8);
        this.J0 = false;
        this.B0 = false;
        this.f12006x0 = this.f11995m0.getMovieId() + "" + this.D0 + "" + this.E0;
        String string = this.f11990h0.getText().toString();
        StringBuilder sb2 = new StringBuilder("S");
        sb2.append(this.D0);
        sb2.append("E");
        sb2.append(i10);
        this.f11990h0.setText(string.replace(sb2.toString(), "S" + this.D0 + "E" + this.E0));
        TextView textView = this.f11991i0;
        StringBuilder sb3 = new StringBuilder("Episode ");
        sb3.append(this.E0);
        textView.setText(sb3.toString());
        q(false);
        if (this.f11995m0.getImdbID() != null && !this.f11995m0.getImdbID().isEmpty()) {
            try {
                App.getInstance().f11574v.edit().putInt(this.f11995m0.getMovieId() + "season" + this.D0 + "episode" + this.D0, this.E0 - 1).apply();
                String str = this.f11995m0.getMovieId() + "s" + this.D0 + "e" + this.D0 + "title";
                App.getInstance().f11574v.edit().putString(str, "Episode " + this.E0).apply();
            } catch (Exception unused) {
            }
        }
        final Movie movie = this.f11995m0;
        hd.f fVar = App.getInstance().A.get(this.E0 - 1);
        final int i11 = this.D0;
        final int i12 = this.E0;
        this.T.clear();
        if (movie.isDrama()) {
            new rd.b(this, movie, this).process(fVar.f12994n);
            return;
        }
        if (movie.isAnime()) {
            String strReplace = fVar.f12994n;
            if (strReplace != null) {
                strReplace = strReplace.replace("www9.gogoanime.io", "gogoanime.pe").replace("gogoanime.io", "gogoanime.pe");
            }
            if (strReplace != null) {
                new qd.d(this, this, movie).Process(strReplace);
                return;
            }
            return;
        }
        if (movie.getImdbID() != null && !movie.getImdbID().isEmpty()) {
            new Handler().postDelayed(new Runnable() { // from class: zb.h
                @Override // java.lang.Runnable
                public final void run() {
                    int i13 = SimpleVideoPlayer.f11976g1;
                    SimpleVideoPlayer simpleVideoPlayer = this.f22665b;
                    simpleVideoPlayer.getClass();
                    SharedPreferences sharedPreferences = App.getInstance().f11574v;
                    String str2 = Constant.f12450b;
                    new td.f(simpleVideoPlayer, simpleVideoPlayer, sharedPreferences.getString("pref_ml_host", simpleVideoPlayer.getString(R.string.ml_host))).process(movie.getImdbID(), i11, i12);
                }
            }, 2000L);
        }
        if (RealDebridCommon.f12051p || PremiumizeCommon.f12045b || AllDebridCommon.f12043n) {
            new s(this, movie, this).process(i11, i12, 1);
            new wd.m(this, movie, this).process(i11, i12, 1);
            new wd.f(this, movie, this).process(i11, i12, 1);
            new h(this, movie, this).process(i11, i12);
            new vd.d(this, movie, this).process(i11, i12);
        }
        new qd.v(this, movie, this).process(i11, i12);
        new sd.d(this, movie, this).process(i11, i12);
        new sd.f(this, movie, this).process(i11, i12);
        new sd.j(this, movie, this).process(i11, i12);
        new l(this, movie, this).process(i11, i12);
        new sd.b(this, movie, this).process(i11, i12, this.Y);
        new z(this, movie, this).process(i11, i12);
        new qd.m(this, movie, this).process(i11, i12);
        new d0(this, movie, this).process(i11, i12);
        new u(this, movie, this).Process(i11, i12);
        new i(this, movie, this).process(i11, i12);
        new q(this, movie, this).Process(i12, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m() {
        /*
            r7 = this;
            flix.com.vision.App r0 = flix.com.vision.App.getInstance()
            android.content.SharedPreferences r0 = r0.f11574v
            java.lang.String r1 = "pref_auto_play_minutes"
            r2 = 2
            int r0 = r0.getInt(r1, r2)
            r3 = 60000(0xea60, double:2.9644E-319)
            if (r0 == 0) goto L35
            r1 = 1
            if (r0 == r1) goto L31
            if (r0 == r2) goto L2d
            r1 = 3
            if (r0 == r1) goto L29
            r1 = 4
            if (r0 == r1) goto L25
            r1 = 5
            if (r0 == r1) goto L21
            goto L31
        L21:
            r0 = 360000(0x57e40, double:1.778636E-318)
            goto L36
        L25:
            r0 = 300000(0x493e0, double:1.482197E-318)
            goto L36
        L29:
            r0 = 240000(0x3a980, double:1.18576E-318)
            goto L36
        L2d:
            r0 = 180000(0x2bf20, double:8.8932E-319)
            goto L36
        L31:
            r0 = 120000(0x1d4c0, double:5.9288E-319)
            goto L36
        L35:
            r0 = r3
        L36:
            flix.com.vision.bvp.BetterVideoPlayer r2 = r7.f11985e0
            boolean r2 = r2.isPrepared()
            if (r2 == 0) goto L5f
            flix.com.vision.bvp.BetterVideoPlayer r2 = r7.f11985e0
            int r2 = r2.getDuration()
            flix.com.vision.bvp.BetterVideoPlayer r5 = r7.f11985e0
            int r5 = r5.getCurrentPosition()
            int r2 = r2 - r5
            r5 = 120000(0x1d4c0, float:1.68156E-40)
            if (r2 <= r5) goto L5f
            flix.com.vision.bvp.BetterVideoPlayer r2 = r7.f11985e0
            int r2 = r2.getDuration()
            flix.com.vision.bvp.BetterVideoPlayer r5 = r7.f11985e0
            int r5 = r5.getCurrentPosition()
            int r2 = r2 - r5
            long r5 = (long) r2
            goto L61
        L5f:
            r5 = -1
        L61:
            long r5 = r5 - r0
            r0 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 >= 0) goto L70
            android.os.Handler r0 = r7.R
            zb.e r1 = r7.S
            r0.removeCallbacks(r1)
            return
        L70:
            long r0 = r5 / r3
            android.os.Handler r0 = r7.R
            zb.e r1 = r7.S
            r0.removeCallbacks(r1)
            android.os.Handler r0 = r7.R
            zb.e r1 = r7.S
            r0.postDelayed(r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flix.com.vision.activities.player.SimpleVideoPlayer.m():void");
    }

    public final void n(boolean z10) {
        try {
            if (z10) {
                if (!this.f11986e1) {
                    this.U.setVisibility(0);
                } else {
                    this.L.setAlpha(1.0f);
                    this.W.setVisibility(0);
                    this.L.startAnimation(this.P0);
                }
            } else if (!this.f11986e1) {
                this.U.setVisibility(8);
            } else {
                this.W.setVisibility(8);
                this.L.clearAnimation();
                this.L.setAlpha(1.0f);
            }
        } catch (Exception unused) {
        }
    }

    public final void o() {
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, true);
        dVarNewInstance.setTitle("Error Downloading Subtitles");
        dVarNewInstance.setMessage("Would you like to Download directly from OpenSubtitles Website ?");
        dVarNewInstance.setButton2("CANCEL", new q0(23));
        dVarNewInstance.setButton1("YES, DOWNLOAD", new zb.f(this, 2));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 12345 && i11 == -1) {
            String stringExtra = intent.getStringExtra("fileExtraPath");
            if (!stringExtra.endsWith(".srt") && !stringExtra.endsWith(".vtt")) {
                Toast.makeText(getBaseContext(), getString(R.string.srt_vtt_only_sub), 0).show();
                return;
            } else {
                try {
                    ic.a.Success(getApplicationContext(), "Subtitles Loaded", null, 48, 0);
                } catch (Exception unused) {
                }
                this.f11985e0.setCaptionsPath(stringExtra, CaptionsView.CMime.SUBRIP, "");
                s();
            }
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        RelativeLayout relativeLayout;
        super.onBackPressed();
        if (this.f11986e1 && (relativeLayout = this.W) != null && relativeLayout.getVisibility() == 0) {
            i();
            return;
        }
        if (this.V.getVisibility() == 0) {
            k();
        } else if (this.f11985e0.isControlsShown()) {
            this.f11985e0.hideControls();
        } else {
            showDialog();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x035d  */
    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r9) throws java.lang.IllegalStateException {
        /*
            Method dump skipped, instructions count: 1641
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: flix.com.vision.activities.player.SimpleVideoPlayer.onCreate(android.os.Bundle):void");
    }

    @Override // r.j, androidx.fragment.app.p, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // r.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        int directionPressed = this.f11987f0.getDirectionPressed(keyEvent);
        int i11 = 4;
        if (!this.f11985e0.isControlsShown()) {
            if (directionPressed == 1 || directionPressed == 7) {
                if (!this.f11985e0.isPlaying() || !this.f11985e0.isPrepared()) {
                    return false;
                }
                try {
                    this.f11985e0.seekTo(this.f11985e0.getCurrentPosition() - 15000);
                    this.f11985e0.showOverlayText(15, false);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                return true;
            }
            if (directionPressed == 2 || directionPressed == 6) {
                if (!this.f11985e0.isPlaying() || !this.f11985e0.isPrepared()) {
                    return false;
                }
                try {
                    this.f11985e0.seekTo(this.f11985e0.getCurrentPosition() + 15000);
                    this.f11985e0.showOverlayText(15, true);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                return true;
            }
            if (directionPressed == 4) {
                try {
                    if (this.f11985e0.isPlaying()) {
                        this.f11985e0.pause();
                        if (this.L != null && this.f11986e1) {
                            this.W.setVisibility(0);
                        }
                        this.f11997o0.setVisibility(0);
                        this.f11985e0.getToolbar().getMenu().getItem(1).setIcon(R.drawable.ic_play_circle2);
                    } else if (this.f11985e0.isPrepared()) {
                        this.f11997o0.setImageResource(R.drawable.ic_play);
                        new Handler().postDelayed(new zb.e(this, i11), 200L);
                        if (this.L != null && this.f11986e1) {
                            this.W.setVisibility(8);
                        }
                        this.f11985e0.start();
                        this.f11985e0.getToolbar().getMenu().getItem(1).setIcon(R.drawable.ic_pause_cirlce);
                    }
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
                return true;
            }
        }
        this.f11985e0.showControls();
        if (directionPressed == 4) {
            this.f11985e0.toggleControls();
            return true;
        }
        int i12 = 5;
        if (directionPressed != 5) {
            switch (directionPressed) {
                case 10:
                    if (this.V.getVisibility() != 0) {
                        if (!this.f11985e0.isControlsShown()) {
                            showDialog();
                            break;
                        } else {
                            this.f11985e0.hideControls();
                            break;
                        }
                    } else {
                        k();
                        break;
                    }
            }
            return true;
        }
        try {
            if (this.f11985e0.isPlaying()) {
                this.f11997o0.setVisibility(0);
                this.f11985e0.pause();
                this.f11985e0.getToolbar().getMenu().getItem(1).setIcon(R.drawable.ic_play_circle2);
                if (this.f12006x0 != null) {
                    App.getInstance().f11574v.edit().putInt(this.f12006x0, this.f11985e0.getCurrentPosition()).apply();
                }
                requestAndDisplayAd();
            } else if (this.f11985e0.isPrepared()) {
                if (this.L != null && this.f11986e1) {
                    this.W.setVisibility(8);
                }
                this.f11997o0.setImageResource(R.drawable.ic_play);
                new Handler().postDelayed(new zb.e(this, i12), 200L);
                this.J0 = false;
                this.f11985e0.getToolbar().getMenu().getItem(1).setIcon(R.drawable.ic_pause_cirlce);
                this.f11985e0.start();
            }
            this.f11985e0.showControls();
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(hd.i iVar) {
        o oVar = iVar.f13011a;
        if (oVar != null) {
            playLink(oVar.D, false);
        }
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onPause() {
        super.onPause();
        SessionManager sessionManager = this.X0;
        if (sessionManager != null) {
            sessionManager.removeSessionManagerListener(this.Y0, CastSession.class);
            this.W0 = null;
        }
    }

    @Override // fc.b
    public void onPaused(BetterVideoPlayer betterVideoPlayer) {
        try {
            if (this.f12006x0 != null) {
                App.getInstance().f11574v.edit().putInt(this.f12006x0, betterVideoPlayer.getCurrentPosition()).apply();
            }
            if (this.f12008z0) {
                this.R.removeCallbacks(this.S);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // fc.b
    public void onPrepared(BetterVideoPlayer betterVideoPlayer) {
        Handler handler = new Handler();
        Objects.requireNonNull(betterVideoPlayer);
        handler.postDelayed(new zb.b(betterVideoPlayer, 2), 200L);
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onResume() throws NullPointerException {
        super.onResume();
        if (App.getInstance().f11565m) {
            this.f11978a1 = -1;
            this.Z0 = new ArrayList<>();
            App.getInstance().f11565m = false;
        }
        this.N = App.getInstance().f11574v.getBoolean("pref_show_time", true);
        SessionManager sessionManager = this.X0;
        if (sessionManager != null) {
            this.W0 = sessionManager.getCurrentCastSession();
            this.X0.addSessionManagerListener(this.Y0, CastSession.class);
        }
    }

    @Override // fc.b
    public void onStarted(BetterVideoPlayer betterVideoPlayer) {
        if (this.K && !this.f11988f1) {
            this.f11988f1 = true;
            new Handler().postDelayed(new zb.e(this, 6), 6000L);
        }
        if (this.H0) {
            return;
        }
        Movie movie = this.f11995m0;
        if (movie != null && movie.isSeries() && this.f12008z0) {
            m();
        }
        this.H0 = true;
        int i10 = this.L0;
        int i11 = 0;
        if (i10 > 0) {
            try {
                betterVideoPlayer.seekTo(i10);
            } catch (Exception unused) {
            }
            new Handler().postDelayed(new zb.e(this, i11), 1000L);
            this.L0 = -1;
        }
        if (this.J0) {
            try {
                betterVideoPlayer.seekTo(this.I0 - 5000);
            } catch (Exception unused2) {
            }
        }
        if (this.M0) {
            new Handler().postDelayed(new zb.b(betterVideoPlayer, 1), 500L);
            this.M0 = false;
        }
    }

    @Override // fc.b
    public void onToggleControls(boolean z10) {
        this.f11998p0.setAlpha(1.0f);
        TextClock textClock = this.O;
        if (textClock != null && this.N) {
            textClock.setAlpha(1.0f);
            this.O.setVisibility(z10 ? 0 : 8);
        }
        this.f11998p0.setVisibility(z10 ? 0 : 8);
        if (!z10) {
            if (this.B0) {
                j();
                return;
            }
            return;
        }
        this.f11985e0.showToolbar();
        this.f11989g0.removeCallbacks(this.G0);
        this.f11989g0.postDelayed(this.G0, 4000L);
        if (!this.B0 || this.f11999q0.getVisibility() == 0) {
            return;
        }
        this.f11999q0.setVisibility(0);
        this.f11999q0.startAnimation(this.N0);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            this.f11983d0.setSystemUiVisibility(5894);
        }
    }

    public void openEpisode(int i10) {
        try {
            this.f11985e0.hideControls();
            this.f11985e0.hideToolbar();
        } catch (Exception unused) {
        }
        int i11 = this.E0;
        this.E0 = i10 + 1;
        k();
        if (this.f11995m0.isSeries()) {
            this.C0 = this.f12002t0.get(i10).f13000t;
        }
        l(i11);
        this.f12001s0.notifyDataSetChanged();
    }

    public final void p() {
        ArrayList<m> arrayList;
        if (!this.f11985e0.isCaptionActive() && (arrayList = this.Z0) != null && !arrayList.isEmpty()) {
            r();
            return;
        }
        if (this.f11995m0.isAnime() || this.f11995m0.f12397o) {
            return;
        }
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, true);
        dVarNewInstance.setTitle(App.getInstance().f11574v.getString("sub_lang_name_1", "English") + " Subtitles");
        dVarNewInstance.setMessage("You can Download Subtitles from OpenSubtitles");
        if (this.f11985e0.isCaptionActive()) {
            dVarNewInstance.setMessage("Disable, Change Subtitles or Adjust Offset");
            dVarNewInstance.setButton1("DISABLE", new zb.f(this, 9));
            dVarNewInstance.setButton3("OFFSET", new zb.f(this, 10));
        } else {
            dVarNewInstance.setButton3("IMPORT", new zb.f(this, 11));
            Movie movie = this.f11995m0;
            String string = null;
            if (movie != null && !movie.isSeries()) {
                string = App.getInstance().f11574v.getString(this.f11995m0.getMovieId() + "subtitle", null);
            } else if (this.f11995m0 != null) {
                String str = this.f11995m0.getMovieId() + "" + this.D0 + "" + this.E0;
                string = App.getInstance().f11574v.getString(str + "subtitle", null);
            }
            if (string == null || !new File(string).exists()) {
                dVarNewInstance.setButton1("CANCEL", new q0(24));
            } else {
                dVarNewInstance.setButton1("ENABLE", new ub.v(7, this, string));
            }
        }
        ArrayList<m> arrayList2 = this.Z0;
        dVarNewInstance.setButton2((arrayList2 == null || arrayList2.isEmpty()) ? "DOWNLOAD" : "SHOW LIST", new zb.f(this, 12));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void playLink(String str, boolean z10) {
        Movie movie;
        try {
            this.f11985e0.stop();
            this.f11985e0.reset();
            this.f11985e0.setSource(Uri.parse(str));
            this.f11985e0.removeCaptions();
            if (z10 && (movie = this.f11995m0) != null && !movie.f12397o && !movie.isAnime()) {
                Movie movie2 = this.f11995m0;
                String string = null;
                if (movie2 != null && !movie2.isSeries()) {
                    string = App.getInstance().f11574v.getString(this.f11995m0.getMovieId() + "subtitle", null);
                } else if (this.f11995m0 != null) {
                    String str2 = this.f11995m0.getMovieId() + "" + this.D0 + "" + this.E0;
                    string = App.getInstance().f11574v.getString(str2 + "subtitle", null);
                }
                if (string != null && new File(string).exists()) {
                    this.f11985e0.setCaptionsPath(string, CaptionsView.CMime.SUBRIP, "");
                    s();
                }
            }
            this.B0 = false;
            this.R.removeCallbacks(this.S);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void q(boolean z10) {
        if (this.f11986e1 && !z10) {
            try {
                this.L.setAlpha(1.0f);
                this.W.setVisibility(0);
                this.L.startAnimation(this.P0);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, false);
        this.V0 = dVarNewInstance;
        dVarNewInstance.setloading();
        try {
            this.V0.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void r() {
        if (this.Z0.isEmpty()) {
            be.d.makeToast(this, "No Subtitle Found", false);
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < this.Z0.size(); i10++) {
                arrayList.add(this.Z0.get(i10).f13034m.toUpperCase(Locale.ROOT));
            }
            CharSequence[] charSequenceArr = (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]);
            d.a aVar = new d.a(new ContextThemeWrapper(this, R.style.AlertDialogNoHeader));
            aVar.setSingleChoiceItems(charSequenceArr, this.f11978a1, new u2(this, 2));
            aVar.setOnDismissListener(new p0(9));
            aVar.show();
        } catch (Exception unused) {
        }
    }

    public final void s() {
        try {
            if (this.f11985e0.isCaptionActive()) {
                this.f11985e0.getToolbar().getMenu().getItem(0).setIcon(R.drawable.ic_caption_active);
            } else {
                this.f11985e0.getToolbar().getMenu().getItem(0).setIcon(R.drawable.ic_action_caption);
            }
        } catch (Exception unused) {
        }
    }

    public final void showDialog() {
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, true);
        dVarNewInstance.setTitle("Exit");
        dVarNewInstance.setMessage("Do you really want to stop playback and exit ?");
        dVarNewInstance.setButton1("CANCEL", new q0(22));
        dVarNewInstance.setButton2("YES", new zb.f(this, 0));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void t(int i10) {
        try {
            this.f11985e0.setSubSize(i10 == 2 ? getResources().getDimensionPixelSize(R.dimen.sub_size_normal) : i10 == 1 ? getResources().getDimensionPixelSize(R.dimen.sub_size_small) : i10 == 3 ? getResources().getDimensionPixelSize(R.dimen.sub_size_big) : i10 == 4 ? getResources().getDimensionPixelSize(R.dimen.sub_size_big_big) : i10 == 5 ? getResources().getDimensionPixelSize(R.dimen.sub_size_big_big_big) : i10 == 6 ? getResources().getDimensionPixelSize(R.dimen.sub_size_big_big_big_big) : i10 == 7 ? getResources().getDimensionPixelSize(R.dimen.sub_size_big_big_big_big_big) : getResources().getDimensionPixelSize(R.dimen.sub_size_normal));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // gd.f
    public void OnSuccess(o oVar) {
        if (oVar.f13047w) {
            if (oVar.f13044t) {
                if (oVar.f13048x || App.isRdSupported(oVar.D)) {
                    bc.a.getLinkRealDebrid(oVar.D, RealDebridCommon.f12049n, RealDebridCommon.f12047b).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new zb.g(this), new m0(1, oVar));
                    return;
                }
                return;
            }
            this.T.add(oVar);
            if (this.U0 || !this.S0) {
                return;
            }
            if (!oVar.f13050z) {
                i();
                this.H0 = true;
                this.L0 = 0;
                hd.i iVar = new hd.i();
                iVar.f13011a = oVar;
                EventBus.getDefault().post(iVar);
                this.U0 = true;
                try {
                    ic.a.Success(getApplicationContext(), "Episode " + this.E0 + " Loaded", null, 48, 0);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            i();
            if (this.T0) {
                return;
            }
            this.T0 = true;
            this.H0 = true;
            this.L0 = 0;
            hd.i iVar2 = new hd.i();
            iVar2.f13011a = oVar;
            EventBus.getDefault().post(iVar2);
            try {
                ic.a.Success(getApplicationContext(), "Episode " + this.E0 + " Loaded", null, 48, 0);
            } catch (Exception unused2) {
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent() {
        if (this.f11985e0.isControlsShown()) {
            this.f11985e0.hideControls();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(hd.l lVar) {
        int i10 = lVar.f13030a;
        if (i10 > 0) {
            this.f11985e0.setSubColor(i10);
        }
        int i11 = lVar.f13031b;
        if (i11 > 0) {
            t(i11);
        }
        BetterVideoPlayer betterVideoPlayer = this.f11985e0;
        if (betterVideoPlayer == null || !betterVideoPlayer.isCaptionActive()) {
            return;
        }
        this.f11985e0.changeEncoding(lVar.f13032c);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(n nVar) {
        i();
        ArrayList<m> arrayList = nVar.f13035a;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<m> arrayList2 = nVar.f13035a;
            this.Z0 = arrayList2;
            Collections.sort(arrayList2, new c());
            r();
            return;
        }
        o();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(hd.c cVar) {
        String str;
        if (this.f11980b1) {
            return;
        }
        this.f11980b1 = true;
        if (cVar != null && (str = cVar.f12978a) != null) {
            try {
                if (!str.endsWith(".srt") && !cVar.f12978a.endsWith(".vtt")) {
                    ic.a.Success(getApplicationContext(), "Only SRT and VTT format are supported. Please choose another file", null, 48, 1);
                } else {
                    BetterVideoPlayer betterVideoPlayer = this.f11985e0;
                    String str2 = cVar.f12978a;
                    betterVideoPlayer.setCaptionsPath(str2, str2.contains(".srt") ? CaptionsView.CMime.SUBRIP : CaptionsView.CMime.WEBVTT, "");
                    s();
                    this.f11985e0.start();
                    if (this.L != null && this.f11986e1) {
                        this.W.setVisibility(8);
                    }
                    this.f11997o0.setVisibility(8);
                    this.f11985e0.getToolbar().getMenu().getItem(1).setIcon(R.drawable.ic_pause_cirlce);
                    this.f11985e0.hideControls();
                    this.f11998p0.setVisibility(8);
                    if (!this.f11995m0.isSeries()) {
                        App.getInstance().f11574v.edit().putString(this.f11995m0.getMovieId() + "subtitle", cVar.f12978a).apply();
                    } else {
                        App.getInstance().f11574v.edit().putString(ac.c.B(this.f11995m0.getMovieId() + "" + this.D0 + "" + this.E0, "subtitle"), cVar.f12978a).apply();
                    }
                    ic.a.Success(getApplicationContext(), "Subtitles Loaded", null, 48, 0);
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (cVar == null || cVar.f12978a != null) {
            return;
        }
        o();
    }

    public class a implements qc.a {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
        @Override // qc.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onStateChanged(boolean r5, int r6) {
            /*
                r4 = this;
                r0 = 2
                flix.com.vision.activities.player.SimpleVideoPlayer r1 = flix.com.vision.activities.player.SimpleVideoPlayer.this
                if (r6 != r0) goto L17
                r0 = 1
                r1.n(r0)
                boolean r0 = r1.f12008z0
                if (r0 == 0) goto L20
                android.os.Handler r0 = r1.R     // Catch: java.lang.Exception -> L15
                zb.e r2 = r1.S     // Catch: java.lang.Exception -> L15
                r0.removeCallbacks(r2)     // Catch: java.lang.Exception -> L15
                goto L20
            L15:
                goto L20
            L17:
                r0 = 0
                r1.n(r0)
                flix.com.vision.bvp.BetterVideoPlayer r0 = r1.f11985e0
                r0.hideToolbar()
            L20:
                flix.com.vision.models.Movie r0 = r1.f11995m0
                r2 = 4
                if (r0 == 0) goto L42
                boolean r3 = r1.f12008z0
                if (r3 == 0) goto L42
                if (r5 == 0) goto L42
                if (r6 == r2) goto L42
                boolean r5 = r0.isSeries()
                if (r5 != 0) goto L3f
                flix.com.vision.models.Movie r5 = r1.f11995m0
                boolean r0 = r5.f12397o
                if (r0 != 0) goto L3f
                boolean r5 = r5.isAnime()
                if (r5 == 0) goto L42
            L3f:
                r1.m()
            L42:
                if (r6 != r2) goto L57
                flix.com.vision.App r5 = flix.com.vision.App.getInstance()
                android.content.SharedPreferences r5 = r5.f11574v
                android.content.SharedPreferences$Editor r5 = r5.edit()
                java.lang.String r6 = r1.f12006x0
                android.content.SharedPreferences$Editor r5 = r5.remove(r6)
                r5.apply()
            L57:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: flix.com.vision.activities.player.SimpleVideoPlayer.a.onStateChanged(boolean, int):void");
        }

        @Override // xc.e
        public void onSeekComplete() {
        }

        @Override // qc.a
        public void onError(pc.a aVar, Exception exc) {
        }

        @Override // qc.a
        public void onVideoSizeChanged(int i10, int i11, int i12, float f10) {
        }
    }

    @Override // com.unity3d.ads.IUnityAdsInitializationListener
    public void onInitializationComplete() {
    }

    @Override // fc.b
    public void onPreparing() {
    }

    public void requestAndDisplayAd() {
    }

    @Override // fc.b
    public void onBuffering(int i10) {
    }

    @Override // fc.b
    public void onCompletion(BetterVideoPlayer betterVideoPlayer) {
    }

    @Override // fc.b
    public void onError(BetterVideoPlayer betterVideoPlayer) {
    }

    @Override // com.unity3d.ads.IUnityAdsInitializationListener
    public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
    }
}
