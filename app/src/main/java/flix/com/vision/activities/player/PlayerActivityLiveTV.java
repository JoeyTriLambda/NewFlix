package flix.com.vision.activities.player;

import ac.k;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ybq.android.spinkit.SpinKitView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.bvp.BetterVideoPlayer;
import flix.com.vision.events.SystemEvent;
import flix.com.vision.exomedia.core.video.scale.ScaleType;
import flix.com.vision.exomedia.ui.widget.VideoView;
import hd.i;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes2.dex */
public class PlayerActivityLiveTV extends wb.a implements fc.b {

    /* renamed from: a0, reason: collision with root package name */
    public static final /* synthetic */ int f11967a0 = 0;
    public SpinKitView K;
    public k L;
    public Menu N;
    public RelativeLayout O;
    public RecyclerView P;
    public Animation Q;
    public Animation R;
    public View T;
    public BetterVideoPlayer U;
    public x4.a Y;
    public final int M = 1919;
    public int S = 0;
    public final fd.b V = new fd.b();
    public final Handler W = new Handler();
    public String X = "-1";
    public boolean Z = false;

    public enum RESULT_EVENT_PLAYER_CTIVITY_LIVE {
        /* JADX INFO: Fake field, exist only in values array */
        SHOW,
        HIDE
    }

    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BetterVideoPlayer f11971b;

        public b(BetterVideoPlayer betterVideoPlayer) {
            this.f11971b = betterVideoPlayer;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11971b.isPlaying()) {
                return;
            }
            PlayerActivityLiveTV.this.Show();
        }
    }

    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BetterVideoPlayer f11973b;

        public c(BetterVideoPlayer betterVideoPlayer) {
            this.f11973b = betterVideoPlayer;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11973b.start();
        }
    }

    public class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ hd.d f11974b;

        public d(hd.d dVar) {
            this.f11974b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerActivityLiveTV playerActivityLiveTV = PlayerActivityLiveTV.this;
            if (playerActivityLiveTV.U.isPrepared()) {
                return;
            }
            playerActivityLiveTV.playChannel(this.f11974b, true);
        }
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.O.getVisibility() == 0) {
            this.O.startAnimation(this.R);
            this.O.setVisibility(8);
        } else {
            if (this.U.isControlsShown()) {
                this.U.hideControls();
                return;
            }
            this.U.showControls();
            try {
                this.U.stop();
                this.U.release();
            } catch (Exception unused) {
            }
            super.onBackPressed();
            finish();
        }
    }

    @Override // fc.b
    public void onCompletion(BetterVideoPlayer betterVideoPlayer) {
        String str = App.getInstance().f11570r.get(this.S).f12983p;
        betterVideoPlayer.reset();
        betterVideoPlayer.setSource(Uri.parse(str));
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_exo_media);
        String stringExtra = getIntent().getStringExtra("type");
        this.X = stringExtra;
        if (stringExtra == null) {
            this.X = "1";
        }
        this.Z = (App.getInstance().f11574v.getInt("player_index", 0) == 0 || this.X.equalsIgnoreCase("3")) ? false : true;
        Toast.makeText(getApplicationContext(), "", 0);
        EventBus.getDefault().register(this);
        this.K = (SpinKitView) findViewById(R.id.buffering_view);
        this.P = (RecyclerView) findViewById(R.id.listview);
        BetterVideoPlayer betterVideoPlayer = (BetterVideoPlayer) findViewById(R.id.video_view);
        this.U = betterVideoPlayer;
        betterVideoPlayer.setAutoPlay(true);
        this.U.setHideControlsOnPlay(true);
        this.U.setHideControlsDuration(5000);
        this.U.setCallback(this);
        this.U.enableSwipeGestures(getWindow());
        this.U.setTVMode(true);
        this.U.getToolbar().inflateMenu(R.menu.menu_live_tv);
        this.N = this.U.getToolbar().getMenu();
        this.U.getToolbar().setOnMenuItemClickListener(new c1.c(this, 23));
        this.U.setOnExoBufferingUpdate(new a());
        this.P.setLayoutManager(new LinearLayoutManager(this));
        VideoView videoView = this.U.getVideoView();
        ScaleType scaleType = ScaleType.NONE;
        videoView.setScaleType(scaleType);
        k kVar = new k(getBaseContext(), App.getInstance().f11570r, this, this.M, 200);
        this.L = kVar;
        this.P.setAdapter(kVar);
        this.L.notifyDataSetChanged();
        this.O = (RelativeLayout) findViewById(R.id.channels_rel);
        View decorView = getWindow().getDecorView();
        this.T = decorView;
        decorView.setSystemUiVisibility(1028);
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down2);
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up2);
        this.Q = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);
        this.R = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right);
        int intExtra = getIntent().getIntExtra("actual_index", 0);
        this.S = intExtra;
        if (intExtra < 0 || intExtra >= App.getInstance().f11570r.size()) {
            this.S = 0;
        }
        this.U.getVideoView().setScaleType(scaleType);
        hd.d dVar = (hd.d) getIntent().getParcelableExtra("channel");
        if (dVar != null) {
            playChannel(dVar, false);
        } else {
            playChannel(App.getInstance().f11570r.get(this.S), false);
        }
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
    }

    @Override // wb.a, r.j, androidx.fragment.app.p, android.app.Activity
    public void onDestroy() {
        if (this.Z) {
            super.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    @Override // fc.b
    public void onError(BetterVideoPlayer betterVideoPlayer) {
        if (App.getInstance().f11570r.size() == 0) {
            return;
        }
        if (this.S >= App.getInstance().f11570r.size() || this.S < 0) {
            this.S = 0;
        }
        playChannel(App.getInstance().f11570r.get(this.S), false);
    }

    @Override // r.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.O.getVisibility() != 0) {
            this.U.showControls();
            this.U.getToolbar().requestFocus();
        }
        int directionPressed = this.V.getDirectionPressed(keyEvent);
        if (directionPressed == 4) {
            if (this.O.getVisibility() == 0) {
                return false;
            }
            this.U.toggleControls();
            return true;
        }
        if (directionPressed == 5) {
            try {
                if (this.U.isPlaying()) {
                    this.U.pause();
                } else if (this.U.isPrepared()) {
                    this.U.start();
                }
                this.U.showControls();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return true;
        }
        if (directionPressed != 10) {
            if (directionPressed != 11) {
                return false;
            }
            if (this.O.getVisibility() == 0) {
                this.O.startAnimation(this.R);
                this.O.setVisibility(8);
            } else {
                try {
                    this.P.scrollToPosition(this.S);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                this.O.setVisibility(0);
                this.O.startAnimation(this.Q);
                this.P.requestFocus();
            }
            return true;
        }
        if (this.O.getVisibility() == 0) {
            this.O.startAnimation(this.R);
            this.O.setVisibility(8);
            return true;
        }
        if (this.U.isControlsShown()) {
            this.U.hideControls();
            return true;
        }
        this.U.showControls();
        try {
            this.U.stop();
            this.U.release();
        } catch (Exception unused) {
        }
        super.onBackPressed();
        finish();
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent() {
        if (this.U.isControlsShown()) {
            this.U.hideControls();
        }
    }

    @Override // fc.b
    public void onPaused(BetterVideoPlayer betterVideoPlayer) {
        try {
            x4.a aVar = this.Y;
            if (aVar != null) {
                this.W.removeCallbacks(aVar);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        new Handler().postDelayed(new b(betterVideoPlayer), 2000L);
    }

    @Override // fc.b
    public void onPrepared(BetterVideoPlayer betterVideoPlayer) {
        try {
            betterVideoPlayer.getToolbar().setTitle(App.getInstance().f11570r.get(this.S).f12984q);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            App.getInstance().f11570r.get(this.S).getClass();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        new Handler().postDelayed(new c(betterVideoPlayer), 200L);
    }

    @Override // fc.b
    public void onToggleControls(boolean z10) {
        if (z10) {
            x4.a aVar = this.Y;
            Handler handler = this.W;
            if (aVar != null) {
                handler.removeCallbacks(aVar);
            }
            x4.a aVar2 = new x4.a(2);
            this.Y = aVar2;
            handler.postDelayed(aVar2, 5000L);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            this.T.setSystemUiVisibility(5894);
        }
    }

    public void playChannel(hd.d dVar, boolean z10) {
        if (dVar != null) {
            this.U.getToolbar().setTitle(dVar.f12984q);
        }
        if (!z10) {
            this.S = App.getInstance().f11570r.indexOf(dVar);
        }
        try {
            this.U.reset();
            this.U.setSource(Uri.parse(dVar.f12983p));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (z10) {
            return;
        }
        new Handler().postDelayed(new d(dVar), 4000L);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SystemEvent systemEvent) {
        if (systemEvent.f12187a.ordinal() == 0 && this.O.getVisibility() == 0) {
            this.O.startAnimation(this.R);
            this.O.setVisibility(8);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(i iVar) {
        iVar.getClass();
        throw null;
    }

    public class a implements qc.a {
        public a() {
        }

        @Override // qc.a
        public void onStateChanged(boolean z10, int i10) {
            PlayerActivityLiveTV playerActivityLiveTV = PlayerActivityLiveTV.this;
            if (i10 == 2) {
                playerActivityLiveTV.K.setVisibility(0);
                playerActivityLiveTV.U.showControls();
            } else {
                playerActivityLiveTV.K.setVisibility(8);
                playerActivityLiveTV.U.hideToolbar();
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
    public void onStarted(BetterVideoPlayer betterVideoPlayer) {
    }
}
