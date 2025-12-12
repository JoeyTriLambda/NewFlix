package flix.com.vision.tv;

import ac.k;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import flix.com.vision.bvp.BetterVideoPlayer2;
import flix.com.vision.events.SystemEvent;
import hd.i;
import java.io.IOException;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes2.dex */
public class PlayerActivityLiveExtended extends wb.a implements fc.a {
    public k K;
    public ImageView L;
    public MKLoader M;
    public Toast N;
    public Menu P;
    public RelativeLayout Q;
    public RecyclerView R;
    public Animation S;
    public Animation T;
    public ArrayList<hd.d> U;
    public View W;
    public BetterVideoPlayer2 X;

    /* renamed from: e0, reason: collision with root package name */
    public f f12455e0;

    /* renamed from: f0, reason: collision with root package name */
    public hd.d f12456f0;
    public final int O = 1919;
    public int V = 0;
    public final fd.b Y = new fd.b();
    public final Handler Z = new Handler();

    /* renamed from: a0, reason: collision with root package name */
    public boolean f12451a0 = false;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f12452b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    public final boolean f12453c0 = true;

    /* renamed from: d0, reason: collision with root package name */
    public int f12454d0 = 0;

    public enum RESULT_EVENT_PLAYER_CTIVITY_LIVE {
        /* JADX INFO: Fake field, exist only in values array */
        SHOW,
        HIDE
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerActivityLiveExtended.this.finish();
        }
    }

    public class b implements Toolbar.h {
        public b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.h
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            PlayerActivityLiveExtended playerActivityLiveExtended = PlayerActivityLiveExtended.this;
            if (itemId == R.id.action_episodes) {
                try {
                    playerActivityLiveExtended.R.scrollToPosition(playerActivityLiveExtended.V);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                playerActivityLiveExtended.Q.setVisibility(0);
                playerActivityLiveExtended.Q.startAnimation(playerActivityLiveExtended.S);
            } else if (menuItem.getItemId() == R.id.action_close) {
                if (playerActivityLiveExtended.Q.getVisibility() == 0) {
                    playerActivityLiveExtended.Q.startAnimation(playerActivityLiveExtended.T);
                    playerActivityLiveExtended.Q.setVisibility(8);
                    return true;
                }
                playerActivityLiveExtended.showDialog();
            }
            return false;
        }
    }

    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BetterVideoPlayer2 f12461b;

        public c(BetterVideoPlayer2 betterVideoPlayer2) {
            this.f12461b = betterVideoPlayer2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f12461b.isPlaying()) {
                return;
            }
            PlayerActivityLiveExtended.this.Show();
        }
    }

    public class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BetterVideoPlayer2 f12463b;

        public d(BetterVideoPlayer2 betterVideoPlayer2) {
            this.f12463b = betterVideoPlayer2;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            this.f12463b.start();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerActivityLiveExtended playerActivityLiveExtended = PlayerActivityLiveExtended.this;
            playerActivityLiveExtended.playChannel(playerActivityLiveExtended.V);
        }
    }

    public class f implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            EventBus.getDefault().post(RESULT_EVENT_PLAYER_CTIVITY_LIVE.HIDE);
        }
    }

    public static String getMXPlayerPackage(Context context) {
        return isPackageInstalled(context, "com.mxtech.videoplayer.pro") ? "com.mxtech.videoplayer.pro" : "com.mxtech.videoplayer.ad";
    }

    public static boolean isPackageInstalled(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public void MXPlayerPlayUri(Context context, String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putBoolean("secure_uri", true);
        bundle.putInt("position", 0);
        bundle.putInt("video_zoom", 0);
        bundle.putBoolean("sticky", false);
        if (!str3.isEmpty()) {
            bundle.putStringArray("headers", new String[]{"User-Agent", str3});
        }
        if (!str4.isEmpty()) {
            bundle.putStringArray("referer", new String[]{"Referer", str4});
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtras(bundle);
        intent.setDataAndType(Uri.parse(str2), "video/*");
        intent.setPackage(getMXPlayerPackage(context));
        startActivityForResult(intent, 3344);
    }

    public void VLCPlayerPlayUri(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putInt("position", 0);
        bundle.putBoolean("from_start", true);
        if (!str3.isEmpty()) {
            bundle.putStringArray("headers", new String[]{"User-Agent", str3});
        }
        if (!str4.isEmpty()) {
            bundle.putStringArray("referer", new String[]{"Referer", str4});
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtras(bundle);
        intent.setDataAndType(Uri.parse(str2), "video/*");
        intent.setPackage("org.videolan.vlc");
        startActivityForResult(intent, 2211);
    }

    public void XPlayerlayerPlayUri(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtras(bundle);
        intent.setDataAndType(Uri.parse(str2), "video/*");
        intent.setPackage("video.player.videoplayer");
        startActivityForResult(intent, 2211);
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
        if (this.Q.getVisibility() == 0) {
            this.Q.startAnimation(this.T);
            this.Q.setVisibility(8);
        } else if (this.X.isControlsShown()) {
            this.X.hideControls();
        } else {
            this.X.showControls();
            showDialog();
        }
    }

    @Override // fc.a
    public void onCompletion(BetterVideoPlayer2 betterVideoPlayer2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (this.U.get(this.V).f12979b && this.U.get(this.V).f12989v.size() > 0) {
            String str = this.U.get(this.V).f12989v.get(0).f13027u;
            betterVideoPlayer2.reset();
            betterVideoPlayer2.setSource(Uri.parse(str), this.U.get(this.V).f12989v.get(0).getHeaders());
        } else if (this.U.get(this.V).f12979b) {
            betterVideoPlayer2.reset();
            betterVideoPlayer2.setSource(Uri.parse(this.U.get(this.V).f12983p));
        }
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        ArrayList<hd.d> arrayList;
        super.onCreate(bundle);
        setContentView(R.layout.activity_exo_media2);
        this.L = (ImageView) findViewById(R.id.channel_image_loader);
        this.M = (MKLoader) findViewById(R.id.loading_progress_tv);
        this.U = getIntent().getParcelableArrayListExtra("channels3g");
        this.V = getIntent().getIntExtra("index", 0);
        this.f12451a0 = App.getInstance().f11574v.getInt("player_index", 0) != 0;
        this.N = Toast.makeText(getApplicationContext(), "", 0);
        EventBus.getDefault().register(this);
        this.R = (RecyclerView) findViewById(R.id.listview);
        BetterVideoPlayer2 betterVideoPlayer2 = (BetterVideoPlayer2) findViewById(R.id.video_view);
        this.X = betterVideoPlayer2;
        betterVideoPlayer2.setAutoPlay(true);
        this.X.setHideControlsOnPlay(true);
        this.X.setHideControlsDuration(5000);
        this.X.setCallback(this);
        this.X.enableSwipeGestures(getWindow());
        this.X.getToolbar().inflateMenu(R.menu.menu_live_tv);
        this.P = this.X.getToolbar().getMenu();
        this.X.getToolbar().setOnMenuItemClickListener(new b());
        this.R.setLayoutManager(new LinearLayoutManager(this));
        k kVar = new k(getBaseContext(), this.U, this, this.O, 200);
        this.K = kVar;
        this.R.setAdapter(kVar);
        this.K.notifyDataSetChanged();
        this.Q = (RelativeLayout) findViewById(R.id.channels_rel);
        View decorView = getWindow().getDecorView();
        this.W = decorView;
        decorView.setSystemUiVisibility(1028);
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down2);
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up2);
        this.S = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);
        this.T = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right);
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        int intExtra = getIntent().getIntExtra("index", 0);
        this.V = intExtra;
        if (intExtra < 0 || ((arrayList = this.U) != null && intExtra >= arrayList.size())) {
            this.V = 0;
        }
        this.X.setTVMode(true);
        playChannel(this.V);
    }

    @Override // wb.a, r.j, androidx.fragment.app.p, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // fc.a
    public void onError() {
        if (this.U.size() == 0) {
            return;
        }
        int i10 = this.f12454d0 + 1;
        this.f12454d0 = i10;
        if (i10 <= 2) {
            new Handler().postDelayed(new e(), 2000L);
            return;
        }
        this.N.setText("Failed to load " + this.U.get(this.V).f12984q);
        try {
            this.N.show();
        } catch (Exception unused) {
        }
        this.f12454d0 = 0;
        int i11 = this.V + 1;
        this.V = i11;
        if (i11 >= this.U.size()) {
            this.V = 0;
        }
        playChannel(this.V);
    }

    @Override // r.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        int directionPressed = this.Y.getDirectionPressed(keyEvent);
        this.X.showControls();
        if (directionPressed == 4) {
            if (this.Q.getVisibility() == 0) {
                return false;
            }
            this.X.toggleControls();
            return true;
        }
        if (directionPressed == 5) {
            try {
                if (this.X.isPlaying()) {
                    this.X.pause();
                } else if (this.X.isPrepared()) {
                    this.X.start();
                }
                this.X.showControls();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return true;
        }
        if (directionPressed != 10) {
            if (directionPressed != 11) {
                return false;
            }
            if (this.Q.getVisibility() == 0) {
                this.Q.startAnimation(this.T);
                this.Q.setVisibility(8);
            } else {
                this.Q.setVisibility(0);
                this.Q.startAnimation(this.S);
            }
            return true;
        }
        if (this.Q.getVisibility() == 0) {
            this.Q.startAnimation(this.T);
            this.Q.setVisibility(8);
            return false;
        }
        if (this.X.isControlsShown()) {
            this.X.hideControls();
            return false;
        }
        this.X.showControls();
        showDialog();
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent() {
        if (this.X.isControlsShown()) {
            this.X.hideControls();
        }
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // fc.a
    public void onPaused(BetterVideoPlayer2 betterVideoPlayer2) {
        try {
            f fVar = this.f12455e0;
            if (fVar != null) {
                this.Z.removeCallbacks(fVar);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        new Handler().postDelayed(new c(betterVideoPlayer2), 2000L);
    }

    @Override // fc.a
    public void onPrepared(BetterVideoPlayer2 betterVideoPlayer2) {
        this.M.setVisibility(8);
        if (!this.f12453c0) {
            this.L.setVisibility(8);
        }
        this.f12454d0 = 0;
        try {
            betterVideoPlayer2.getToolbar().setTitle(this.U.get(this.V).f12984q);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (!this.f12452b0) {
            this.f12452b0 = true;
            try {
                betterVideoPlayer2.setVolume(1.0f, 1.0f);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        try {
            this.U.get(this.V).getClass();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        new Handler().postDelayed(new d(betterVideoPlayer2), 200L);
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // fc.a
    public void onToggleControls(boolean z10) {
        if (z10) {
            f fVar = this.f12455e0;
            Handler handler = this.Z;
            if (fVar != null) {
                handler.removeCallbacks(fVar);
            }
            f fVar2 = new f();
            this.f12455e0 = fVar2;
            handler.postDelayed(fVar2, 5000L);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            this.W.setSystemUiVisibility(5894);
        }
    }

    public void playChannel(int i10) {
        hd.d dVar = this.U.get(i10);
        this.M.setVisibility(0);
        this.L.setVisibility(0);
        String str = dVar.f12985r;
        if (str != null) {
            try {
                if (str.length() > 10) {
                    try {
                        Picasso.get().load(dVar.f12985r).fit().transform(new fd.a()).centerCrop().into(this.L);
                    } catch (OutOfMemoryError e10) {
                        e10.printStackTrace();
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        this.V = i10;
        this.f12456f0 = dVar;
        if (!dVar.f12979b) {
            ArrayList<hd.k> arrayList = dVar.f12989v;
            if (arrayList.size() > 0) {
                ae.c.GetStreamLink(arrayList.get(0), Constant.f12450b);
                return;
            } else {
                Toast.makeText(getApplicationContext(), "Failed to load Channel", 1).show();
                return;
            }
        }
        try {
            this.V = this.U.indexOf(dVar);
            this.X.reset();
            this.X.setSource(Uri.parse(dVar.f12983p));
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public final void showDialog() {
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, true);
        dVarNewInstance.setTitle("Exit");
        dVarNewInstance.setMessage("Do you really want to stop playback and exit ?");
        dVarNewInstance.setButton1("CANCEL", new g());
        dVarNewInstance.setButton2("YES", new a());
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SystemEvent systemEvent) {
        if (systemEvent.f12187a.ordinal() == 0 && this.Q.getVisibility() == 0) {
            this.Q.startAnimation(this.T);
            this.Q.setVisibility(8);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(i iVar) {
        iVar.getClass();
        throw null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(hd.k kVar) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (kVar != null) {
            this.U.get(this.V).f12979b = true;
            if (this.f12451a0) {
                if (App.getInstance().f11574v.getInt("player_index", 0) == 1) {
                    MXPlayerPlayUri(getBaseContext(), this.f12456f0.f12984q, kVar.f13027u, kVar.f13021o, kVar.f13020n);
                } else if (App.getInstance().f11574v.getInt("player_index", 0) == 2) {
                    VLCPlayerPlayUri(this.f12456f0.f12984q, kVar.f13027u, kVar.f13021o, kVar.f13020n);
                } else if (App.getInstance().f11574v.getInt("player_index", 0) == 3) {
                    XPlayerlayerPlayUri(this.f12456f0.f12984q, kVar.f13027u);
                } else {
                    this.X.reset();
                    this.X.setSource(Uri.parse(kVar.f13027u), kVar.getHeaders());
                    return;
                }
            }
            this.X.reset();
            this.X.setSource(Uri.parse(kVar.f13027u), kVar.getHeaders());
        }
    }

    @Override // fc.a
    public void onBuffering() {
    }

    @Override // fc.a
    public void onPreparing() {
    }

    @Override // fc.a
    public void onStarted() {
    }

    public class g implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
