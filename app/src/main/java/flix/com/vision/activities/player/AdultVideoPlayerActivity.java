package flix.com.vision.activities.player;

import ac.f;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import androidx.appcompat.app.d;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.loopj.android.http.AsyncHttpClient;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.player.AdultVideoPlayerActivity;
import flix.com.vision.bvp.BetterVideoPlayer;
import flix.com.vision.exomedia.core.video.scale.ScaleType;
import flix.com.vision.helpers.CenterLayoutManager;
import gd.c;
import java.util.ArrayList;
import java.util.Locale;
import kc.d;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import r.x;
import ub.o0;
import ub.p0;
import ub.q0;

/* loaded from: classes2.dex */
public class AdultVideoPlayerActivity extends wb.a implements fc.b, gd.b, c, gd.a {

    /* renamed from: b0, reason: collision with root package name */
    public static final /* synthetic */ int f11962b0 = 0;
    public SpinKitView K;
    public String L;
    public RelativeLayout M;
    public RecyclerView N;
    public Menu O;
    public Animation P;
    public Animation Q;
    public View R;
    public BetterVideoPlayer S;
    public final fd.b T = new fd.b();
    public boolean U;
    public String V;
    public final ArrayList<id.c> W;
    public final ArrayList<id.b> X;
    public f Y;
    public final ArrayList<id.c> Z;

    /* renamed from: a0, reason: collision with root package name */
    public d f11963a0;

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11965a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<id.c> f11966b;

        public b(AdultVideoPlayerActivity adultVideoPlayerActivity) {
        }
    }

    public AdultVideoPlayerActivity() {
        new Handler();
        this.U = true;
        this.W = new ArrayList<>();
        this.X = new ArrayList<>();
        this.Z = new ArrayList<>();
    }

    public static /* synthetic */ void d(AdultVideoPlayerActivity adultVideoPlayerActivity) {
        adultVideoPlayerActivity.getClass();
        try {
            adultVideoPlayerActivity.S.stop();
            adultVideoPlayerActivity.S.release();
            super.onBackPressed();
            adultVideoPlayerActivity.finish();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void e(AdultVideoPlayerActivity adultVideoPlayerActivity) {
        adultVideoPlayerActivity.getClass();
        try {
            adultVideoPlayerActivity.S.stop();
            adultVideoPlayerActivity.S.release();
            super.onBackPressed();
            adultVideoPlayerActivity.finish();
        } catch (Exception unused) {
        }
    }

    @Override // gd.a
    public void OnStreamResolvedSuccess(ArrayList<id.b> arrayList) {
        d dVar = this.f11963a0;
        if (dVar != null) {
            try {
                dVar.dismiss();
            } catch (Exception unused) {
            }
        }
        ArrayList<id.b> arrayList2 = this.X;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        b bVar = new b(this);
        bVar.f11965a = true;
        EventBus.getDefault().post(bVar);
    }

    @Override // gd.c
    public void OnVideoListSuccess(ArrayList<id.c> arrayList) {
        b bVar = new b(this);
        bVar.f11966b = arrayList;
        bVar.f11965a = false;
        EventBus.getDefault().post(bVar);
    }

    public final void f(id.c cVar) {
        try {
            if (cVar == null) {
                String stringExtra = getIntent().getStringExtra("videoUrl");
                String stringExtra2 = getIntent().getStringExtra("title");
                String stringExtra3 = getIntent().getStringExtra("image_url");
                id.c cVar2 = new id.c();
                cVar2.f13365a = stringExtra2;
                cVar2.f13367c = stringExtra3;
                cVar2.f13366b = stringExtra;
                if (stringExtra2 != null && stringExtra != null) {
                    App.getInstance().f11573u.addAdultHistory(cVar2);
                }
            } else {
                App.getInstance().f11573u.addAdultHistory(cVar);
            }
        } catch (Exception unused) {
        }
    }

    public final void g() {
        if (this.U) {
            this.M.startAnimation(this.Q);
            this.M.setVisibility(8);
            this.N.clearFocus();
        }
    }

    public void getVideos() {
        if (this.U) {
            new od.f(this, this).process(this.V);
        }
    }

    public final void h() {
        if (this.U) {
            this.M.setVisibility(0);
            this.M.startAnimation(this.P);
            this.N.requestFocus();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.S.isControlsShown()) {
            this.S.hideControls();
        } else {
            showDialog();
        }
    }

    @Override // fc.b
    public void onCompletion(BetterVideoPlayer betterVideoPlayer) {
        try {
            betterVideoPlayer.start();
        } catch (Exception unused) {
        }
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_player_adult);
        this.K = (SpinKitView) findViewById(R.id.buffering_view);
        this.M = (RelativeLayout) findViewById(R.id.relativeview_videos);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_videos);
        this.N = recyclerView;
        o1.a.h(5, recyclerView);
        this.N.setLayoutManager(new CenterLayoutManager(this, 1, false));
        f fVar = new f(this, this, this.Z);
        this.Y = fVar;
        this.N.setAdapter(fVar);
        this.U = App.getInstance().f11574v.getBoolean("pref_show_adult_zone_hide_related", true);
        this.S = (BetterVideoPlayer) findViewById(R.id.video_view);
        f(null);
        this.S.setOnExoBufferingUpdate(new a());
        this.S.setAutoPlay(true);
        this.S.setBottomProgressBarVisibility(true);
        this.S.setHideControlsOnPlay(true);
        this.S.setHideControlsDuration(AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
        this.S.setCallback(this);
        this.S.enableSwipeGestures(getWindow());
        this.S.getToolbar().inflateMenu(R.menu.menu_simple_video_player_adult);
        this.S.getToolbar().setOnMenuItemClickListener(new c1.c(this, 22));
        this.O = this.S.getToolbar().getMenu();
        this.S.getVideoView().setScaleType(ScaleType.NONE);
        View decorView = getWindow().getDecorView();
        this.R = decorView;
        decorView.setSystemUiVisibility(1028);
        this.P = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);
        this.Q = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right);
        this.L = getIntent().getStringExtra("url");
        this.V = getIntent().getStringExtra("videoUrl");
        this.S.getToolbar().setTitle(getIntent().getStringExtra("title"));
        id.c cVar = new id.c();
        cVar.f13366b = this.V;
        this.W.add(cVar);
        String str = this.L;
        if (str != null) {
            playAdultLink(str);
        }
        getVideos();
    }

    @Override // wb.a, r.j, androidx.fragment.app.p, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // r.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        int directionPressed = this.T.getDirectionPressed(keyEvent);
        this.S.showControls();
        if (directionPressed == 1) {
            if (!this.S.isPlaying() || !this.S.isPrepared()) {
                return false;
            }
            try {
                this.S.seekTo(this.S.getCurrentPosition() - 10000);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return true;
        }
        if (directionPressed == 2) {
            if (!this.S.isPlaying() || !this.S.isPrepared()) {
                return false;
            }
            try {
                this.S.seekTo(this.S.getCurrentPosition() + AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            return true;
        }
        if (directionPressed == 4) {
            this.S.toggleControls();
            return true;
        }
        if (directionPressed == 5) {
            try {
                if (this.S.isPlaying()) {
                    this.S.pause();
                } else if (this.S.isPrepared()) {
                    this.S.start();
                }
                this.S.showControls();
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            return true;
        }
        if (directionPressed == 10) {
            if (this.S.isControlsShown()) {
                this.S.hideControls();
                return true;
            }
            showDialog();
            return true;
        }
        if (directionPressed != 11) {
            return false;
        }
        if (this.M.getVisibility() == 0) {
            g();
        } else {
            h();
        }
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent() {
        if (this.S.isControlsShown()) {
            this.S.hideControls();
        }
    }

    @Override // fc.b
    public void onPaused(BetterVideoPlayer betterVideoPlayer) {
        new Handler().postDelayed(new x(24, this, betterVideoPlayer), 2000L);
    }

    @Override // fc.b
    public void onPrepared(BetterVideoPlayer betterVideoPlayer) {
        new Handler().postDelayed(new zb.b(betterVideoPlayer, 0), 200L);
    }

    @Override // fc.b
    public void onToggleControls(boolean z10) {
        if (this.Z.size() > 0) {
            if (z10) {
                if (this.M.getVisibility() != 0) {
                    h();
                }
            } else if (this.M.getVisibility() == 0) {
                g();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            this.R.setSystemUiVisibility(5894);
        }
    }

    @Override // gd.b
    public void openAdultVideo(int i10) {
        ArrayList<id.c> arrayList = this.W;
        int size = arrayList.size();
        ArrayList<id.c> arrayList2 = this.Z;
        if (size == 0 || arrayList.get(arrayList.size() - 1) != arrayList2.get(i10)) {
            arrayList.add(arrayList2.get(i10));
        }
        this.S.getToolbar().setTitle(arrayList2.get(i10).f13365a);
        g();
        FragmentManager fragmentManager = getFragmentManager();
        d dVarNewInstance = d.newInstance(this, false);
        this.f11963a0 = dVarNewInstance;
        dVarNewInstance.setloading();
        try {
            this.f11963a0.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.V = arrayList2.get(i10).f13366b;
        f(arrayList2.get(i10));
        new od.b(this, this).process(this.V);
        getVideos();
    }

    public void openAdultVideoAuto(id.c cVar) {
        g();
        FragmentManager fragmentManager = getFragmentManager();
        d dVarNewInstance = d.newInstance(this, false);
        this.f11963a0 = dVarNewInstance;
        dVarNewInstance.setloading();
        try {
            this.f11963a0.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.V = cVar.f13366b;
        f(cVar);
        new od.b(this, this).process(this.V);
        getVideos();
    }

    public void playAdultLink(String str) {
        try {
            this.S.reset();
            this.S.setSource(Uri.parse(str));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void showDialog() {
        ArrayList<id.c> arrayList = this.W;
        final int i10 = 1;
        if (arrayList.size() <= 1) {
            FragmentManager fragmentManager = getFragmentManager();
            d dVarNewInstance = d.newInstance(this, true);
            dVarNewInstance.setTitle("Exit");
            dVarNewInstance.setMessage("Do you really want to stop playback and exit ?");
            dVarNewInstance.setButton1("CANCEL", new q0(20));
            final int i11 = 0;
            dVarNewInstance.setButton2("YES", new View.OnClickListener(this) { // from class: zb.a

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ AdultVideoPlayerActivity f22656m;

                {
                    this.f22656m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i12 = i11;
                    AdultVideoPlayerActivity adultVideoPlayerActivity = this.f22656m;
                    switch (i12) {
                        case 0:
                            AdultVideoPlayerActivity.d(adultVideoPlayerActivity);
                            break;
                        case 1:
                            ArrayList<id.c> arrayList2 = adultVideoPlayerActivity.W;
                            try {
                                id.c cVar = arrayList2.get(arrayList2.size() - 2);
                                adultVideoPlayerActivity.openAdultVideoAuto(cVar);
                                arrayList2.remove(cVar);
                                break;
                            } catch (Exception unused) {
                                return;
                            }
                        default:
                            AdultVideoPlayerActivity.e(adultVideoPlayerActivity);
                            break;
                    }
                }
            });
            try {
                dVarNewInstance.show(fragmentManager, "");
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        FragmentManager fragmentManager2 = getFragmentManager();
        d dVarNewInstance2 = d.newInstance(this, true);
        dVarNewInstance2.setTitle("Exit or Back");
        dVarNewInstance2.setMessage("Do you want to Play previous video or Exit?");
        dVarNewInstance2.setButton2("CANCEL", new q0(21));
        if (arrayList.size() > 1) {
            dVarNewInstance2.setButton1("PREVIOUS VIDEO", new View.OnClickListener(this) { // from class: zb.a

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ AdultVideoPlayerActivity f22656m;

                {
                    this.f22656m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i12 = i10;
                    AdultVideoPlayerActivity adultVideoPlayerActivity = this.f22656m;
                    switch (i12) {
                        case 0:
                            AdultVideoPlayerActivity.d(adultVideoPlayerActivity);
                            break;
                        case 1:
                            ArrayList<id.c> arrayList2 = adultVideoPlayerActivity.W;
                            try {
                                id.c cVar = arrayList2.get(arrayList2.size() - 2);
                                adultVideoPlayerActivity.openAdultVideoAuto(cVar);
                                arrayList2.remove(cVar);
                                break;
                            } catch (Exception unused) {
                                return;
                            }
                        default:
                            AdultVideoPlayerActivity.e(adultVideoPlayerActivity);
                            break;
                    }
                }
            });
        }
        final int i12 = 2;
        dVarNewInstance2.setButton3("EXIT", new View.OnClickListener(this) { // from class: zb.a

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultVideoPlayerActivity f22656m;

            {
                this.f22656m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i122 = i12;
                AdultVideoPlayerActivity adultVideoPlayerActivity = this.f22656m;
                switch (i122) {
                    case 0:
                        AdultVideoPlayerActivity.d(adultVideoPlayerActivity);
                        break;
                    case 1:
                        ArrayList<id.c> arrayList2 = adultVideoPlayerActivity.W;
                        try {
                            id.c cVar = arrayList2.get(arrayList2.size() - 2);
                            adultVideoPlayerActivity.openAdultVideoAuto(cVar);
                            arrayList2.remove(cVar);
                            break;
                        } catch (Exception unused) {
                            return;
                        }
                    default:
                        AdultVideoPlayerActivity.e(adultVideoPlayerActivity);
                        break;
                }
            }
        });
        try {
            dVarNewInstance2.show(fragmentManager2, "");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(b bVar) {
        ArrayList<id.c> arrayList = bVar.f11966b;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<id.c> arrayList2 = this.Z;
            arrayList2.clear();
            arrayList2.addAll(bVar.f11966b);
            this.Y.notifyDataSetChanged();
            this.N.scrollToPosition(0);
            return;
        }
        if (bVar.f11965a) {
            ArrayList<id.b> arrayList3 = this.X;
            if (App.getInstance().f11574v.getBoolean("pref_adult_zone_always_play_best", true) && arrayList3.size() > 0) {
                playAdultLink(arrayList3.get(0).f13364m);
                return;
            }
            ArrayList arrayList4 = new ArrayList();
            for (int i10 = 0; i10 < arrayList3.size(); i10++) {
                arrayList4.add(arrayList3.get(i10).f13363b.toUpperCase(Locale.ROOT));
            }
            CharSequence[] charSequenceArr = (CharSequence[]) arrayList4.toArray(new CharSequence[arrayList4.size()]);
            d.a aVar = new d.a(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
            aVar.setSingleChoiceItems(charSequenceArr, -1, new o0(this, arrayList3, 6));
            aVar.setOnDismissListener(new p0(8));
            aVar.show();
        }
    }

    public class a implements qc.a {
        public a() {
        }

        @Override // qc.a
        public void onStateChanged(boolean z10, int i10) {
            AdultVideoPlayerActivity adultVideoPlayerActivity = AdultVideoPlayerActivity.this;
            if (i10 == 2) {
                adultVideoPlayerActivity.K.setVisibility(0);
                adultVideoPlayerActivity.S.showControls();
            } else {
                adultVideoPlayerActivity.K.setVisibility(8);
                adultVideoPlayerActivity.S.hideToolbar();
            }
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

    @Override // fc.b
    public void onPreparing() {
    }

    @Override // fc.b
    public void onBuffering(int i10) {
    }

    @Override // fc.b
    public void onError(BetterVideoPlayer betterVideoPlayer) {
    }

    @Override // fc.b
    public void onStarted(BetterVideoPlayer betterVideoPlayer) {
    }
}
