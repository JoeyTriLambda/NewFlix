package flix.com.vision.tv;

import ac.k;
import ae.c;
import ae.f;
import ae.h;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.tuyenmonkey.mkloader.MKLoader;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.bvp.BetterVideoPlayer;
import flix.com.vision.events.SystemEvent;
import flix.com.vision.exomedia.core.video.scale.ScaleType;
import hd.d;
import hd.i;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes2.dex */
public class PlayerActivityLiveExternal extends wb.a implements fc.b {

    /* renamed from: h0, reason: collision with root package name */
    public static final /* synthetic */ int f12465h0 = 0;
    public k K;
    public ImageView L;
    public Toast M;
    public Menu O;
    public RelativeLayout P;
    public RecyclerView Q;
    public Animation R;
    public Animation S;
    public ArrayList<d> T;
    public View V;
    public BetterVideoPlayer W;

    /* renamed from: a0, reason: collision with root package name */
    public MKLoader f12466a0;

    /* renamed from: e0, reason: collision with root package name */
    public b f12470e0;

    /* renamed from: f0, reason: collision with root package name */
    public d f12471f0;
    public final int N = 1919;
    public int U = 0;
    public final fd.b X = new fd.b();
    public final Handler Y = new Handler();
    public boolean Z = false;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f12467b0 = true;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f12468c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    public int f12469d0 = 0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f12472g0 = false;

    public enum RESULT_EVENT_PLAYER_CTIVITY_LIVE {
        /* JADX INFO: Fake field, exist only in values array */
        SHOW,
        HIDE
    }

    public class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            EventBus.getDefault().post(RESULT_EVENT_PLAYER_CTIVITY_LIVE.HIDE);
        }
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 3344 || i10 == 2211) {
            if (i11 == -1) {
                setResult(-1, intent);
            } else {
                setResult(8888, intent);
            }
            setResult(1);
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.P.getVisibility() == 0) {
            this.P.startAnimation(this.S);
            this.P.setVisibility(8);
        } else if (this.W.isControlsShown()) {
            this.W.hideControls();
        } else {
            this.W.showControls();
            showDialog();
        }
    }

    @Override // fc.b
    public void onCompletion(BetterVideoPlayer betterVideoPlayer) {
        Uri source = betterVideoPlayer.getSource();
        if (source == null) {
            return;
        }
        betterVideoPlayer.reset();
        betterVideoPlayer.setSource(source);
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_player_live2);
        this.Z = App.getInstance().f11574v.getInt("player_index", 0) != 0;
        this.L = (ImageView) findViewById(R.id.channel_image_loader);
        this.f12466a0 = (MKLoader) findViewById(R.id.loading_progress_tv);
        this.T = getIntent().getParcelableArrayListExtra("channels3g");
        this.U = getIntent().getIntExtra("index", 0);
        this.f12467b0 = App.getInstance().f11574v.getBoolean("prefs_show_channel_logo_tv", true);
        this.M = Toast.makeText(getApplicationContext(), "", 0);
        this.Q = (RecyclerView) findViewById(R.id.listview);
        BetterVideoPlayer betterVideoPlayer = (BetterVideoPlayer) findViewById(R.id.video_view);
        this.W = betterVideoPlayer;
        betterVideoPlayer.setAutoPlay(true);
        this.W.setHideControlsOnPlay(true);
        this.W.setHideControlsDuration(5000);
        this.W.setCallback(this);
        this.W.enableSwipeGestures(getWindow());
        this.W.setTVMode(true);
        this.W.getToolbar().inflateMenu(R.menu.menu_live_tv);
        this.O = this.W.getToolbar().getMenu();
        this.W.getToolbar().setOnMenuItemClickListener(new a());
        this.Q.setLayoutManager(new LinearLayoutManager(this));
        this.W.getVideoView().setScaleType(ScaleType.NONE);
        k kVar = new k(getBaseContext(), this.T, this, this.N, 200);
        this.K = kVar;
        this.Q.setAdapter(kVar);
        this.K.notifyDataSetChanged();
        this.P = (RelativeLayout) findViewById(R.id.channels_rel);
        this.V = getWindow().getDecorView();
        if (this.Z) {
            this.W.setVisibility(8);
        }
        this.V.setSystemUiVisibility(1028);
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down2);
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up2);
        this.R = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);
        this.S = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right);
        int intExtra = getIntent().getIntExtra("index", 0);
        this.U = intExtra;
        if (intExtra < 0 || intExtra >= this.T.size()) {
            this.U = 0;
        }
        this.W.setTVMode(true);
        playChannel(this.U);
    }

    @Override // wb.a, r.j, androidx.fragment.app.p, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // fc.b
    public void onError(BetterVideoPlayer betterVideoPlayer) {
        if (this.T.size() == 0) {
            return;
        }
        int i10 = this.f12469d0 + 1;
        this.f12469d0 = i10;
        if (i10 <= 2) {
            new Handler().postDelayed(new f(this, 1), 2000L);
            return;
        }
        this.M.setText("Failed to load " + this.T.get(this.U).f12984q);
        try {
            this.M.show();
        } catch (Exception unused) {
        }
        this.f12469d0 = 0;
        int i11 = this.U + 1;
        this.U = i11;
        if (i11 >= this.T.size()) {
            this.U = 0;
        }
        playChannel(this.U);
    }

    @Override // r.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        int directionPressed = this.X.getDirectionPressed(keyEvent);
        if (directionPressed == 4) {
            if (this.P.getVisibility() == 0) {
                return false;
            }
            this.W.toggleControls();
            return true;
        }
        if (directionPressed == 5) {
            try {
                if (this.W.isPlaying()) {
                    this.W.pause();
                } else if (this.W.isPrepared()) {
                    this.W.start();
                }
                this.W.showControls();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return true;
        }
        if (directionPressed == 10) {
            if (this.P.getVisibility() == 0) {
                this.P.startAnimation(this.S);
                this.P.setVisibility(8);
                return false;
            }
            if (this.W.isControlsShown()) {
                this.W.hideControls();
                return false;
            }
            this.W.showControls();
            showDialog();
            return true;
        }
        if (directionPressed != 11) {
            return false;
        }
        if (this.P.getVisibility() == 0) {
            this.P.startAnimation(this.S);
            this.P.setVisibility(8);
        } else {
            try {
                this.Q.scrollToPosition(this.U);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            this.P.setVisibility(0);
            this.P.startAnimation(this.R);
        }
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent() {
        if (this.W.isControlsShown()) {
            this.W.hideControls();
        }
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // fc.b
    public void onPaused(BetterVideoPlayer betterVideoPlayer) {
        try {
            b bVar = this.f12470e0;
            if (bVar != null) {
                this.Y.removeCallbacks(bVar);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        Show();
    }

    @Override // fc.b
    public void onPrepared(BetterVideoPlayer betterVideoPlayer) {
        this.f12466a0.setVisibility(8);
        if (!this.f12467b0) {
            this.L.setVisibility(8);
        }
        this.f12469d0 = 0;
        try {
            betterVideoPlayer.getToolbar().setTitle(this.T.get(this.U).f12984q);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (!this.f12468c0) {
            this.f12468c0 = true;
            try {
                betterVideoPlayer.setVolume(1.0f);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        try {
            this.T.get(this.U).getClass();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        new Handler().postDelayed(new zb.b(betterVideoPlayer, 3), 200L);
        Show();
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // r.j, androidx.fragment.app.p, android.app.Activity
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override // r.j, androidx.fragment.app.p, android.app.Activity
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override // fc.b
    public void onToggleControls(boolean z10) {
        if (z10) {
            b bVar = this.f12470e0;
            Handler handler = this.Y;
            if (bVar != null) {
                handler.removeCallbacks(bVar);
            }
            b bVar2 = new b();
            this.f12470e0 = bVar2;
            handler.postDelayed(bVar2, 5000L);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            this.V.setSystemUiVisibility(5894);
        }
    }

    public void playChannel(int i10) {
        d dVar = this.T.get(i10);
        String str = dVar.f12985r;
        if (str != null && str.length() > 10) {
            try {
                try {
                    Picasso.get().load(dVar.f12985r).fit().transform(new fd.a()).centerCrop().into(this.L);
                } catch (OutOfMemoryError e10) {
                    e10.printStackTrace();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        this.f12466a0.setVisibility(0);
        this.L.setVisibility(0);
        this.U = i10;
        HashMap map = App.G;
        map.clear();
        d dVar2 = this.f12471f0;
        if (dVar2 != null && dVar2.f12989v.size() > 0) {
            map.put("User-Agent", this.f12471f0.f12989v.get(0).f13021o);
            map.put("Referer", this.f12471f0.f12989v.get(0).f13020n);
        }
        this.f12471f0 = dVar;
        if (!dVar.f12979b) {
            ArrayList<hd.k> arrayList = dVar.f12989v;
            if (arrayList.size() > 0) {
                c.GetStreamLink(arrayList.get(0), Constant.f12450b);
                return;
            } else {
                Toast.makeText(getApplicationContext(), "Failed to load Channel", 1).show();
                return;
            }
        }
        try {
            this.U = this.T.indexOf(dVar);
            this.W.reset();
            this.W.setSource(Uri.parse(dVar.f12983p));
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public final void showDialog() {
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, true);
        dVarNewInstance.setTitle("Exit");
        dVarNewInstance.setMessage("Do you really want to stop playback and exit ?");
        dVarNewInstance.setButton1("CANCEL", new h(1));
        dVarNewInstance.setButton2("YES", new androidx.mediarouter.app.b(this, 14));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SystemEvent systemEvent) {
        if (systemEvent.f12187a.ordinal() == 0 && this.P.getVisibility() == 0) {
            this.P.startAnimation(this.S);
            this.P.setVisibility(8);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(i iVar) {
        iVar.getClass();
        throw null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(hd.k kVar) {
        BetterVideoPlayer betterVideoPlayer = this.W;
        if ((betterVideoPlayer != null && betterVideoPlayer.getSource() != null && this.W.getSource().toString().equals(kVar.f13027u)) || kVar == null || this.f12472g0) {
            return;
        }
        this.f12472g0 = true;
        this.T.get(this.U).f12979b = true;
        if (this.Z) {
            if (App.getInstance().f11574v.getInt("player_index", 0) == 1) {
                fd.h.PlayMXPlayer(this, this.f12471f0.f12984q, kVar.f13027u, kVar.f13021o, kVar.f13020n, -1);
            } else if (App.getInstance().f11574v.getInt("player_index", 0) == 2) {
                fd.h.PlayVLC(this, this.f12471f0.f12984q, kVar.f13027u, kVar.f13021o, kVar.f13020n, -1);
            } else if (App.getInstance().f11574v.getInt("player_index", 0) == 3) {
                fd.h.PlayXPlayer(this, this.f12471f0.f12984q, kVar.f13027u);
            } else {
                this.W.reset();
                this.W.setSource(Uri.parse(kVar.f13027u), kVar.getHeaders());
            }
            this.W.reset();
            this.W.setSource(Uri.parse(kVar.f13027u), kVar.getHeaders());
        } else {
            this.W.reset();
            this.W.setSource(Uri.parse(kVar.f13027u), kVar.getHeaders());
        }
        new Handler().postDelayed(new f(this, 0), 1000L);
    }

    @Override // fc.b
    public void onPreparing() {
    }

    public class a implements Toolbar.h {

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                a aVar = a.this;
                try {
                    dialogInterface.dismiss();
                } catch (Exception unused) {
                }
                try {
                    PlayerActivityLiveExternal.this.W.stop();
                    PlayerActivityLiveExternal.this.W.release();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                PlayerActivityLiveExternal.super.onBackPressed();
            }
        }

        public class c implements DialogInterface.OnClickListener {
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                try {
                    dialogInterface.dismiss();
                } catch (Exception unused) {
                }
            }
        }

        public a() {
        }

        @Override // androidx.appcompat.widget.Toolbar.h
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            PlayerActivityLiveExternal playerActivityLiveExternal = PlayerActivityLiveExternal.this;
            if (itemId == R.id.action_episodes) {
                try {
                    playerActivityLiveExternal.Q.scrollToPosition(playerActivityLiveExternal.U);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                playerActivityLiveExternal.P.setVisibility(0);
                playerActivityLiveExternal.P.startAnimation(playerActivityLiveExternal.R);
            } else if (menuItem.getItemId() == R.id.action_close) {
                if (playerActivityLiveExternal.P.getVisibility() == 0) {
                    playerActivityLiveExternal.P.startAnimation(playerActivityLiveExternal.S);
                    playerActivityLiveExternal.P.setVisibility(8);
                    return true;
                }
                AlertDialog alertDialogCreate = new AlertDialog.Builder(playerActivityLiveExternal).create();
                alertDialogCreate.setTitle(playerActivityLiveExternal.getString(R.string.exit_label));
                alertDialogCreate.setOnDismissListener(new DialogInterfaceOnDismissListenerC0145a());
                alertDialogCreate.setMessage(playerActivityLiveExternal.getString(R.string.stop_playback_exit_mess));
                alertDialogCreate.setButton(-1, playerActivityLiveExternal.getString(R.string.yes_label), new b());
                alertDialogCreate.setButton(-3, playerActivityLiveExternal.getString(R.string.no_label), new c());
                try {
                    alertDialogCreate.show();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            } else if (menuItem.getItemId() == R.id.action_scale) {
                playerActivityLiveExternal.W.setScaleType();
            }
            return false;
        }

        /* renamed from: flix.com.vision.tv.PlayerActivityLiveExternal$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnDismissListenerC0145a implements DialogInterface.OnDismissListener {
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
            }
        }
    }

    @Override // fc.b
    public void onBuffering(int i10) {
    }

    @Override // fc.b
    public void onStarted(BetterVideoPlayer betterVideoPlayer) {
    }
}
