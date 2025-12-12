package flix.com.vision.activities.player;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.player.WebPlayerActivity;
import flix.com.vision.helpers.CursorLayout;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import gd.m;
import hd.o;
import java.util.Random;
import org.adblockplus.libadblockplus.android.webview.AdblockWebView;
import r.j;
import zb.n;

/* loaded from: classes2.dex */
public class WebPlayerActivity extends j implements m {

    /* renamed from: u0, reason: collision with root package name */
    public static final /* synthetic */ int f12013u0 = 0;
    public Animation K;
    public FrameLayout M;
    public View N;
    public CursorLayout O;
    public AdblockWebView P;
    public LinearLayout Q;
    public String R;
    public Movie S;
    public Handler T;
    public n U;
    public View V;
    public ImageView W;
    public ImageView X;
    public ImageView Y;
    public LinearLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    public TextView f12014a0;

    /* renamed from: b0, reason: collision with root package name */
    public TextView f12015b0;

    /* renamed from: c0, reason: collision with root package name */
    public TextView f12016c0;

    /* renamed from: d0, reason: collision with root package name */
    public TextView f12017d0;

    /* renamed from: e0, reason: collision with root package name */
    public Typeface f12018e0;

    /* renamed from: f0, reason: collision with root package name */
    public Typeface f12019f0;

    /* renamed from: g0, reason: collision with root package name */
    public c4.a f12020g0;

    /* renamed from: h0, reason: collision with root package name */
    public String f12021h0;

    /* renamed from: i0, reason: collision with root package name */
    public TextClock f12022i0;

    /* renamed from: j0, reason: collision with root package name */
    public TextClock f12023j0;

    /* renamed from: k0, reason: collision with root package name */
    public RelativeLayout f12024k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f12025l0;

    /* renamed from: n0, reason: collision with root package name */
    public int f12027n0;

    /* renamed from: p0, reason: collision with root package name */
    public String f12029p0;

    /* renamed from: s0, reason: collision with root package name */
    public RelativeLayout f12032s0;

    /* renamed from: t0, reason: collision with root package name */
    public WebChromeClient.CustomViewCallback f12033t0;
    public boolean L = false;

    /* renamed from: m0, reason: collision with root package name */
    public int f12026m0 = 0;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f12028o0 = false;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f12030q0 = false;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f12031r0 = false;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WebPlayerActivity webPlayerActivity = WebPlayerActivity.this;
            webPlayerActivity.Z.setVisibility(8);
            webPlayerActivity.Z.setAlpha(1.0f);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WebPlayerActivity webPlayerActivity = WebPlayerActivity.this;
            webPlayerActivity.f12023j0.setVisibility(8);
            webPlayerActivity.f12023j0.setAlpha(1.0f);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WebPlayerActivity webPlayerActivity = WebPlayerActivity.this;
            webPlayerActivity.f12022i0.setVisibility(8);
            webPlayerActivity.f12022i0.setAlpha(1.0f);
        }
    }

    public class d extends WebViewClient {
        public d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WebPlayerActivity webPlayerActivity = WebPlayerActivity.this;
            webPlayerActivity.Q.setVisibility(8);
            webPlayerActivity.f12024k0.setVisibility(8);
            if (webPlayerActivity.L) {
                webPlayerActivity.getClass();
                try {
                    webPlayerActivity.Y.clearAnimation();
                    webPlayerActivity.Y.setAlpha(1.0f);
                } catch (Exception unused) {
                }
            }
            final int i10 = 0;
            webPlayerActivity.P.setVisibility(0);
            final int i11 = 1;
            int i12 = 2;
            if (App.getInstance().f11574v.getBoolean("pref_hide_watermark_tip", true)) {
                webPlayerActivity.getClass();
                o oVar = new o();
                oVar.D = webPlayerActivity.R;
                if (new Random(5L).nextInt(2) == 1 && oVar.hasMultiSubtitles() && !App.getInstance().f11574v.getBoolean("pref_hide_watermark", false)) {
                    new Handler().postDelayed(new n(webPlayerActivity, i12), 20000L);
                }
            }
            o oVar2 = new o();
            oVar2.D = str;
            if (oVar2.hasMultiSubtitles()) {
                webPlayerActivity.getClass();
                if (!App.getInstance().f11574v.getBoolean("pref_multi_subtitle_tuto_shown", false)) {
                    App.getInstance().f11574v.edit().putBoolean("pref_multi_subtitle_tuto_shown", true).apply();
                    FragmentManager fragmentManager = webPlayerActivity.getFragmentManager();
                    kc.d dVarNewInstance = kc.d.newInstance(webPlayerActivity, false);
                    dVarNewInstance.setTitle("Multi-language Subtitles Available");
                    dVarNewInstance.setCancelable(false);
                    dVarNewInstance.setMessage("Multi-language Subtitles are Available on this player. Press the CC button to choose your language subtitle");
                    dVarNewInstance.setButton1("GOT IT", new zb.m(webPlayerActivity, i12));
                    try {
                        dVarNewInstance.show(fragmentManager, "");
                    } catch (Exception e10) {
                        webPlayerActivity.f12030q0 = false;
                        e10.printStackTrace();
                    }
                }
            } else if (oVar2.hasSubtitles()) {
                webPlayerActivity.getClass();
                if (!App.getInstance().f11574v.getBoolean("pref_subtiel_tuto_shown", false)) {
                    App.getInstance().f11574v.edit().putBoolean("pref_subtiel_tuto_shown", true).apply();
                    FragmentManager fragmentManager2 = webPlayerActivity.getFragmentManager();
                    kc.d dVarNewInstance2 = kc.d.newInstance(webPlayerActivity, false);
                    dVarNewInstance2.setTitle("Subtitles Available");
                    dVarNewInstance2.setCancelable(false);
                    dVarNewInstance2.setMessage("Subtitles are Available on this player. Press the CC button to choose your language subtitle");
                    dVarNewInstance2.setButton1("GOT IT", new zb.m(webPlayerActivity, 3));
                    try {
                        dVarNewInstance2.show(fragmentManager2, "");
                    } catch (Exception e11) {
                        webPlayerActivity.f12030q0 = false;
                        e11.printStackTrace();
                    }
                }
            }
            if (App.getInstance().f11574v.getBoolean("pref_hide_watermark", false) && oVar2.hasMultiSubtitles()) {
                new Handler().postDelayed(new Runnable(this) { // from class: zb.p

                    /* renamed from: m, reason: collision with root package name */
                    public final /* synthetic */ WebPlayerActivity.d f22679m;

                    {
                        this.f22679m = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        int i13 = i10;
                        WebPlayerActivity.d dVar = this.f22679m;
                        switch (i13) {
                            case 0:
                                WebPlayerActivity.this.N.setVisibility(0);
                                break;
                            default:
                                WebPlayerActivity webPlayerActivity2 = WebPlayerActivity.this;
                                webPlayerActivity2.getClass();
                                long jUptimeMillis = SystemClock.uptimeMillis();
                                long jUptimeMillis2 = SystemClock.uptimeMillis() + 300;
                                float f10 = webPlayerActivity2.getResources().getDisplayMetrics().widthPixels / 3;
                                float f11 = webPlayerActivity2.getResources().getDisplayMetrics().heightPixels / 3;
                                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis2, 0, f10, f11, 0);
                                MotionEvent motionEventObtain2 = MotionEvent.obtain(jUptimeMillis, jUptimeMillis2 + 200, 1, f10, f11, 0);
                                webPlayerActivity2.P.dispatchTouchEvent(motionEventObtain);
                                webPlayerActivity2.P.dispatchTouchEvent(motionEventObtain2);
                                if (webPlayerActivity2.f12025l0) {
                                    if (!webPlayerActivity2.iscClockRight()) {
                                        webPlayerActivity2.f12022i0.setVisibility(4);
                                        break;
                                    } else {
                                        webPlayerActivity2.f12023j0.setVisibility(4);
                                        break;
                                    }
                                }
                                break;
                        }
                    }
                }, 2000L);
            }
            new Handler().postDelayed(new Runnable(this) { // from class: zb.p

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ WebPlayerActivity.d f22679m;

                {
                    this.f22679m = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i13 = i11;
                    WebPlayerActivity.d dVar = this.f22679m;
                    switch (i13) {
                        case 0:
                            WebPlayerActivity.this.N.setVisibility(0);
                            break;
                        default:
                            WebPlayerActivity webPlayerActivity2 = WebPlayerActivity.this;
                            webPlayerActivity2.getClass();
                            long jUptimeMillis = SystemClock.uptimeMillis();
                            long jUptimeMillis2 = SystemClock.uptimeMillis() + 300;
                            float f10 = webPlayerActivity2.getResources().getDisplayMetrics().widthPixels / 3;
                            float f11 = webPlayerActivity2.getResources().getDisplayMetrics().heightPixels / 3;
                            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis2, 0, f10, f11, 0);
                            MotionEvent motionEventObtain2 = MotionEvent.obtain(jUptimeMillis, jUptimeMillis2 + 200, 1, f10, f11, 0);
                            webPlayerActivity2.P.dispatchTouchEvent(motionEventObtain);
                            webPlayerActivity2.P.dispatchTouchEvent(motionEventObtain2);
                            if (webPlayerActivity2.f12025l0) {
                                if (!webPlayerActivity2.iscClockRight()) {
                                    webPlayerActivity2.f12022i0.setVisibility(4);
                                    break;
                                } else {
                                    webPlayerActivity2.f12023j0.setVisibility(4);
                                    break;
                                }
                            }
                            break;
                    }
                }
            }, 2000L);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            WebPlayerActivity webPlayerActivity = WebPlayerActivity.this;
            if (Build.VERSION.SDK_INT < 26 || renderProcessGoneDetail.didCrash()) {
                Log.e("MY_APP_TAG", "The WebView rendering process crashed!");
                return false;
            }
            try {
                webPlayerActivity.f12032s0.removeView(webPlayerActivity.P);
            } catch (Exception unused) {
            }
            try {
                webPlayerActivity.P.removeAllViews();
                webPlayerActivity.P.destroy();
                webPlayerActivity.P = null;
                webPlayerActivity.P = (AdblockWebView) webPlayerActivity.findViewById(R.id.webview);
                webPlayerActivity.d();
                webPlayerActivity.P.loadUrl(webPlayerActivity.R);
                return true;
            } catch (Exception unused2) {
                return true;
            }
        }
    }

    public class e extends WebChromeClient {

        /* renamed from: a, reason: collision with root package name */
        public final FrameLayout.LayoutParams f12038a = new FrameLayout.LayoutParams(-1, -1);

        public e() {
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            WebPlayerActivity webPlayerActivity = WebPlayerActivity.this;
            webPlayerActivity.getClass();
            try {
                webPlayerActivity.M.removeAllViews();
                webPlayerActivity.M.setVisibility(8);
                webPlayerActivity.f12033t0.onCustomViewHidden();
                webPlayerActivity.P.setVisibility(0);
            } catch (Exception unused) {
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            int i10 = WebPlayerActivity.f12013u0;
            WebPlayerActivity webPlayerActivity = WebPlayerActivity.this;
            webPlayerActivity.getClass();
            webPlayerActivity.f12032s0 = (RelativeLayout) webPlayerActivity.findViewById(R.id.relative_view_web_player);
            view.setLayoutParams(this.f12038a);
            FrameLayout frameLayout = webPlayerActivity.M;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
                webPlayerActivity.M.addView(view);
                webPlayerActivity.M.setVisibility(0);
            }
            webPlayerActivity.f12033t0 = customViewCallback;
            webPlayerActivity.P.setVisibility(8);
        }
    }

    public final void d() {
        this.P.setBackgroundColor(-16777216);
        this.P.getSettings().setAllowFileAccessFromFileURLs(true);
        this.P.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.P.getSettings().setJavaScriptEnabled(true);
        this.P.getSettings().setDomStorageEnabled(true);
        this.P.getSettings().setDatabaseEnabled(true);
        this.P.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        this.P.getSettings().setSupportMultipleWindows(true);
        this.P.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.P.setWebChromeClient(new e());
        this.P.setWebViewClient(new d());
    }

    @Override // gd.m
    public void infoToggle(boolean z10) {
        if (z10) {
            this.Z.setVisibility(z10 ? 0 : 8);
            if (this.f12025l0) {
                if (iscClockRight()) {
                    this.f12023j0.setVisibility(z10 ? 0 : 8);
                    return;
                } else {
                    this.f12022i0.setVisibility(z10 ? 0 : 8);
                    return;
                }
            }
            return;
        }
        this.Z.animate().alpha(0.0f).setDuration(400L).setListener(new a());
        if (this.f12025l0) {
            if (iscClockRight()) {
                this.f12023j0.animate().alpha(0.0f).setDuration(400L).setListener(new b());
            } else {
                this.f12022i0.animate().alpha(0.0f).setDuration(400L).setListener(new c());
            }
        }
    }

    public boolean iscClockRight() {
        String str = this.R;
        return (str != null && str.contains("185.112.144.240")) || this.f12028o0;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onBackPressed() {
        showDialog();
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        String str;
        super.onCreate(bundle);
        AssetManager assets = getAssets();
        String str2 = Constant.f12450b;
        this.f12018e0 = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f12019f0 = Typeface.createFromAsset(getAssets(), "fonts/product_sans_bold.ttf");
        this.f12020g0 = new c4.a();
        this.S = (Movie) getIntent().getSerializableExtra("movie");
        int i10 = 0;
        this.f12027n0 = getIntent().getIntExtra("runtime", 0);
        this.f12028o0 = getIntent().getBooleanExtra("move_clock", false);
        setContentView(App.K ? R.layout.activity_web_player : R.layout.activity_web_player_light);
        this.f12017d0 = (TextView) findViewById(R.id.text_view_rating);
        this.M = (FrameLayout) findViewById(R.id.fullscreen_frame);
        String stringExtra = getIntent().getStringExtra("movie_rating");
        if (stringExtra != null) {
            this.f12017d0.setText(stringExtra);
            this.f12017d0.setVisibility(0);
        }
        this.Y = (ImageView) findViewById(R.id.title_poster_img);
        this.O = (CursorLayout) findViewById(R.id.cursorLayout);
        this.X = (ImageView) findViewById(R.id.poster_image);
        this.N = findViewById(R.id.water_mark_view);
        this.f12015b0 = (TextView) findViewById(R.id.undertitle);
        this.f12016c0 = (TextView) findViewById(R.id.undertitle_episode);
        this.f12024k0 = (RelativeLayout) findViewById(R.id.background_relative_layout);
        this.T = new Handler();
        this.U = new n(this, i10);
        CursorLayout cursorLayout = this.O;
        if (cursorLayout != null) {
            cursorLayout.setActivity(this);
            try {
                try {
                    int color = getResources().getColor(App.getInstance().f11574v.getInt("mouse_toggle_color", R.color.accent));
                    this.O.setCursorColor(Color.red(color), Color.green(color), Color.blue(color));
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                int color2 = getResources().getColor(R.color.md_deep_orange_500);
                this.O.setCursorColor(Color.red(color2), Color.green(color2), Color.blue(color2));
            }
        }
        this.T.postDelayed(this.U, 20000L);
        this.f12025l0 = App.getInstance().f11574v.getBoolean("pref_show_time", true);
        this.Z = (LinearLayout) findViewById(R.id.movie_title_container);
        this.f12022i0 = (TextClock) findViewById(R.id.clock);
        this.f12023j0 = (TextClock) findViewById(R.id.clock_2);
        this.f12014a0 = (TextView) findViewById(R.id.movie_title_web_text);
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.f12020g0.applyFontToView(this.f12014a0, this.f12019f0);
        this.f12020g0.applyFontToView(this.f12016c0, this.f12018e0);
        this.f12020g0.applyFontToView(this.f12015b0, this.f12018e0);
        this.f12020g0.applyFontToView(this.f12022i0, this.f12018e0);
        this.f12020g0.applyFontToView(this.f12023j0, this.f12018e0);
        new Handler();
        this.P = (AdblockWebView) findViewById(R.id.webview);
        try {
            int i11 = this.f12027n0;
            if (i11 > 0) {
                if (i11 > 60) {
                    str = (this.f12027n0 / 60) + "h " + (this.f12027n0 % 60) + "m";
                } else {
                    str = this.f12027n0 + "m";
                }
                this.f12015b0.setText(this.S.getYear() + "  ·  " + str);
            } else {
                this.f12015b0.setText(this.S.getYear());
            }
        } catch (Exception unused3) {
        }
        this.W = (ImageView) findViewById(R.id.background_image_web);
        this.Q = (LinearLayout) findViewById(R.id.progress_web);
        View decorView = getWindow().getDecorView();
        this.V = decorView;
        decorView.setSystemUiVisibility(1028);
        try {
            Picasso.get().load(this.S.getImage_url()).into(this.X, new zb.o(this));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        String stringExtra2 = getIntent().getStringExtra("poster");
        String stringExtra3 = getIntent().getStringExtra("title");
        this.f12021h0 = getIntent().getStringExtra("title_episode");
        this.f12026m0 = getIntent().getIntExtra("episode_number", 0);
        if (this.S.isSeries() || this.S.f12396n) {
            String str3 = this.f12021h0;
            if (str3 == null || str3.isEmpty()) {
                this.f12016c0.setText("Episode " + this.f12026m0);
            } else {
                this.f12016c0.setText(this.f12021h0);
            }
            this.f12016c0.setVisibility(0);
        }
        if (stringExtra3 != null) {
            this.f12014a0.setText(stringExtra3);
        }
        if (stringExtra2 != null && !stringExtra2.isEmpty()) {
            try {
                Picasso.get().load(stringExtra2).fit().centerCrop().into(this.W);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        this.R = getIntent().getStringExtra("url");
        String stringExtra4 = getIntent().getStringExtra("title_logo");
        this.f12029p0 = stringExtra4;
        if (stringExtra4 == null || stringExtra4.isEmpty()) {
            this.Q.setVisibility(0);
        } else {
            this.Q.setVisibility(8);
            this.L = true;
            try {
                Picasso.get().load(this.f12029p0).into(this.Y);
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            this.K = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_infinite);
            try {
                this.Y.setAlpha(1.0f);
                this.Y.startAnimation(this.K);
            } catch (Exception unused4) {
            }
        }
        if (this.f12025l0) {
            if (iscClockRight()) {
                this.f12023j0.setVisibility(0);
            } else {
                this.f12022i0.setVisibility(0);
            }
        }
        d();
        this.P.loadUrl(this.R);
    }

    @Override // r.j, androidx.fragment.app.p, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f12031r0 && App.getInstance().f11574v.getBoolean("pref_hide_watermark", false)) {
            o oVar = new o();
            oVar.D = this.R;
            if (oVar.hasMultiSubtitles()) {
                this.N.setVisibility(0);
            }
        }
    }

    @Override // r.j, androidx.fragment.app.p, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            this.V.setSystemUiVisibility(5894);
        }
    }

    @Override // gd.m
    public void showDialog() {
        if (this.f12030q0) {
            return;
        }
        FrameLayout frameLayout = this.M;
        int i10 = 0;
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            try {
                this.M.removeAllViews();
                this.M.setVisibility(8);
                this.f12033t0.onCustomViewHidden();
                this.P.setVisibility(0);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        this.f12030q0 = true;
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, false);
        dVarNewInstance.setTitle("Exit");
        dVarNewInstance.setCancelable(false);
        dVarNewInstance.setMessage("Do you really want to stop playback and exit ?");
        dVarNewInstance.setButton1("CANCEL", new zb.m(this, i10));
        dVarNewInstance.setButton2("YES", new zb.m(this, 1));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            this.f12030q0 = false;
            e10.printStackTrace();
        }
    }
}
