package flix.com.vision.bvp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.loopj.android.http.AsyncHttpClient;
import com.unity3d.services.core.device.MimeTypes;
import cz.msebera.android.httpclient.HttpHost;
import flix.com.vision.R;
import flix.com.vision.bvp.OnSwipeTouchListener;
import flix.com.vision.bvp.subtitle.CaptionsView;
import flix.com.vision.events.SystemEvent;
import flix.com.vision.exomedia.ExoMedia$RendererType;
import flix.com.vision.exomedia.core.video.scale.ScaleType;
import flix.com.vision.exomedia.ui.widget.VideoView;
import java.util.Map;
import m4.l;
import m4.m;
import org.greenrobot.eventbus.EventBus;
import u5.n;
import u5.o;

/* loaded from: classes2.dex */
public class BetterVideoPlayer extends RelativeLayout implements TextureView.SurfaceTextureListener, xc.d, xc.a, xc.b, xc.f, xc.c, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public VideoView A;
    public TextureView B;
    public SeekBar C;
    public ProgressBar D;
    public TextView E;
    public TextView F;
    public ImageButton G;
    public boolean H;
    public boolean I;
    public boolean J;
    public int K;
    public int L;
    public Handler M;
    public int N;
    public Uri O;
    public Map<String, String> P;
    public fc.b Q;
    public Drawable R;
    public Drawable S;
    public Drawable T;
    public boolean U;
    public boolean V;
    public boolean W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f12057a0;

    /* renamed from: b, reason: collision with root package name */
    public TextView f12058b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f12059b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f12060c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f12061d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f12062e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f12063f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f12064g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f12065h0;

    /* renamed from: i0, reason: collision with root package name */
    public final int f12066i0;

    /* renamed from: j0, reason: collision with root package name */
    public Handler f12067j0;

    /* renamed from: k0, reason: collision with root package name */
    public j f12068k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f12069l0;

    /* renamed from: m, reason: collision with root package name */
    public TextView f12070m;

    /* renamed from: m0, reason: collision with root package name */
    public final GestureDetector f12071m0;

    /* renamed from: n, reason: collision with root package name */
    public TextView f12072n;

    /* renamed from: n0, reason: collision with root package name */
    public int f12073n0;

    /* renamed from: o, reason: collision with root package name */
    public CaptionsView f12074o;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f12075o0;

    /* renamed from: p, reason: collision with root package name */
    public AudioManager f12076p;

    /* renamed from: p0, reason: collision with root package name */
    public final k f12077p0;

    /* renamed from: q, reason: collision with root package name */
    public Toolbar f12078q;

    /* renamed from: q0, reason: collision with root package name */
    public final a f12079q0;

    /* renamed from: r, reason: collision with root package name */
    public String f12080r;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f12081r0;

    /* renamed from: s, reason: collision with root package name */
    public int f12082s;

    /* renamed from: s0, reason: collision with root package name */
    public final b f12083s0;

    /* renamed from: t, reason: collision with root package name */
    public int f12084t;

    /* renamed from: t0, reason: collision with root package name */
    public int f12085t0;

    /* renamed from: u, reason: collision with root package name */
    public Context f12086u;

    /* renamed from: u0, reason: collision with root package name */
    public final ScaleType[] f12087u0;

    /* renamed from: v, reason: collision with root package name */
    public Window f12088v;

    /* renamed from: w, reason: collision with root package name */
    public View f12089w;

    /* renamed from: x, reason: collision with root package name */
    public View f12090x;

    /* renamed from: y, reason: collision with root package name */
    public FrameLayout f12091y;

    /* renamed from: z, reason: collision with root package name */
    public View f12092z;

    public class a extends OnSwipeTouchListener {

        /* renamed from: q, reason: collision with root package name */
        public float f12093q = -1.0f;

        /* renamed from: r, reason: collision with root package name */
        public float f12094r = -1.0f;

        /* renamed from: s, reason: collision with root package name */
        public int f12095s;

        /* renamed from: t, reason: collision with root package name */
        public int f12096t;

        /* renamed from: u, reason: collision with root package name */
        public int f12097u;

        /* renamed from: v, reason: collision with root package name */
        public int f12098v;

        public a() {
        }

        @Override // flix.com.vision.bvp.OnSwipeTouchListener
        public void onAfterMove() {
            float f10 = this.f12094r;
            BetterVideoPlayer betterVideoPlayer = BetterVideoPlayer.this;
            if (f10 >= 0.0f && betterVideoPlayer.f12060c0) {
                betterVideoPlayer.seekTo((int) f10);
                if (betterVideoPlayer.J) {
                    betterVideoPlayer.A.start();
                }
            }
            betterVideoPlayer.f12058b.setVisibility(8);
        }

        @Override // flix.com.vision.bvp.OnSwipeTouchListener
        public void onBeforeMove(OnSwipeTouchListener.Direction direction) {
            BetterVideoPlayer betterVideoPlayer = BetterVideoPlayer.this;
            if (betterVideoPlayer.f12060c0) {
                if (direction == OnSwipeTouchListener.Direction.LEFT || direction == OnSwipeTouchListener.Direction.RIGHT) {
                    betterVideoPlayer.J = betterVideoPlayer.isPlaying();
                    betterVideoPlayer.A.pause();
                    betterVideoPlayer.f12058b.setVisibility(0);
                    return;
                }
                this.f12098v = 100;
                Window window = betterVideoPlayer.f12088v;
                if (window != null) {
                    this.f12097u = (int) (window.getAttributes().screenBrightness * 100.0f);
                }
                this.f12096t = betterVideoPlayer.f12076p.getStreamMaxVolume(3);
                this.f12095s = betterVideoPlayer.f12076p.getStreamVolume(3);
                betterVideoPlayer.f12058b.setVisibility(0);
            }
        }

        @Override // flix.com.vision.bvp.OnSwipeTouchListener
        public void onClick() {
            BetterVideoPlayer betterVideoPlayer = BetterVideoPlayer.this;
            betterVideoPlayer.toggleControls();
            if (betterVideoPlayer.f12081r0) {
                SystemEvent systemEvent = new SystemEvent();
                systemEvent.f12187a = SystemEvent.ACTION.HIDE_CHANNEL_LIST;
                EventBus.getDefault().post(systemEvent);
            }
        }

        @Override // flix.com.vision.bvp.OnSwipeTouchListener
        public void onMove(OnSwipeTouchListener.Direction direction, float f10) {
            BetterVideoPlayer betterVideoPlayer = BetterVideoPlayer.this;
            if (betterVideoPlayer.f12060c0) {
                OnSwipeTouchListener.Direction direction2 = OnSwipeTouchListener.Direction.LEFT;
                if (direction == direction2 || direction == OnSwipeTouchListener.Direction.RIGHT) {
                    if (betterVideoPlayer.A.getDuration() <= 60) {
                        this.f12093q = (betterVideoPlayer.A.getDuration() * f10) / betterVideoPlayer.K;
                    } else {
                        this.f12093q = (f10 * 60000.0f) / betterVideoPlayer.K;
                    }
                    if (direction == direction2) {
                        this.f12093q *= -1.0f;
                    }
                    float currentPosition = betterVideoPlayer.A.getCurrentPosition() + this.f12093q;
                    this.f12094r = currentPosition;
                    if (currentPosition < 0.0f) {
                        this.f12094r = 0.0f;
                    } else if (currentPosition > betterVideoPlayer.A.getDuration()) {
                        this.f12094r = betterVideoPlayer.A.getDuration();
                    }
                    this.f12093q = this.f12094r - betterVideoPlayer.A.getCurrentPosition();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(hc.c.getDurationString((long) this.f12094r, false));
                    sb2.append(" [");
                    sb2.append(direction == direction2 ? "-" : "+");
                    sb2.append(hc.c.getDurationString((long) Math.abs(this.f12093q), false));
                    sb2.append("]");
                    betterVideoPlayer.f12058b.setText(sb2.toString());
                    return;
                }
                this.f12094r = -1.0f;
                int screenWidth = hc.c.getScreenWidth(betterVideoPlayer.f12086u) / 2;
                float f11 = this.f12159m;
                float f12 = screenWidth;
                OnSwipeTouchListener.Direction direction3 = OnSwipeTouchListener.Direction.DOWN;
                if (f11 > f12) {
                    if (f11 >= betterVideoPlayer.K / 2) {
                        int i10 = this.f12096t;
                        float f13 = (i10 * f10) / (betterVideoPlayer.L / 2.0f);
                        if (direction == direction3) {
                            f13 = -f13;
                        }
                        int i11 = this.f12095s + ((int) f13);
                        if (i11 < 0) {
                            i10 = 0;
                        } else if (i11 <= i10) {
                            i10 = i11;
                        }
                        betterVideoPlayer.f12058b.setText(String.format(betterVideoPlayer.getResources().getString(R.string.volume), Integer.valueOf(i10)));
                        betterVideoPlayer.f12076p.setStreamVolume(3, i10, 0);
                        return;
                    }
                    return;
                }
                if (f11 >= betterVideoPlayer.K / 2 || betterVideoPlayer.f12088v == null) {
                    return;
                }
                int i12 = this.f12098v;
                float f14 = (i12 * f10) / (betterVideoPlayer.L / 2.0f);
                if (direction == direction3) {
                    f14 = -f14;
                }
                int i13 = this.f12097u + ((int) f14);
                if (i13 < 0) {
                    i12 = 0;
                } else if (i13 <= i12) {
                    i12 = i13;
                }
                betterVideoPlayer.f12058b.setText(String.format(betterVideoPlayer.getResources().getString(R.string.brightness), Integer.valueOf(i12)));
                WindowManager.LayoutParams attributes = betterVideoPlayer.f12088v.getAttributes();
                attributes.screenBrightness = i12 / 100.0f;
                betterVideoPlayer.f12088v.setAttributes(attributes);
                PreferenceManager.getDefaultSharedPreferences(betterVideoPlayer.getContext()).edit().putInt("BETTER_VIDEO_PLAYER_BRIGHTNESS", i12).apply();
            }
        }

        @Override // flix.com.vision.bvp.OnSwipeTouchListener, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            BetterVideoPlayer.this.f12071m0.onTouchEvent(motionEvent);
            return super.onTouch(view, motionEvent);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoView videoView;
            BetterVideoPlayer betterVideoPlayer = BetterVideoPlayer.this;
            if (betterVideoPlayer.M == null || !betterVideoPlayer.I || betterVideoPlayer.C == null || (videoView = betterVideoPlayer.A) == null) {
                return;
            }
            long currentPosition = videoView.getCurrentPosition();
            long duration = betterVideoPlayer.A.getDuration();
            if (currentPosition > duration) {
                currentPosition = duration;
            }
            betterVideoPlayer.E.setText(hc.c.getDurationString(currentPosition, false));
            if (betterVideoPlayer.W) {
                betterVideoPlayer.F.setText(hc.c.getDurationString(duration, false));
            } else {
                betterVideoPlayer.F.setText(hc.c.getDurationString(duration - currentPosition, true));
            }
            int i10 = (int) currentPosition;
            int i11 = (int) duration;
            betterVideoPlayer.C.setProgress(i10);
            betterVideoPlayer.C.setMax(i11);
            betterVideoPlayer.D.setProgress(i10);
            betterVideoPlayer.D.setMax(i11);
            betterVideoPlayer.getClass();
            Handler handler = betterVideoPlayer.M;
            if (handler != null) {
                handler.postDelayed(this, 100L);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BetterVideoPlayer.this.f12058b.setVisibility(8);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BetterVideoPlayer.this.O = null;
        }
    }

    public class e extends GestureDetector.SimpleOnGestureListener {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BetterVideoPlayer betterVideoPlayer = BetterVideoPlayer.this;
                betterVideoPlayer.c(betterVideoPlayer.f12070m, 0);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BetterVideoPlayer betterVideoPlayer = BetterVideoPlayer.this;
                betterVideoPlayer.c(betterVideoPlayer.f12072n, 0);
            }
        }

        public e() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            BetterVideoPlayer betterVideoPlayer = BetterVideoPlayer.this;
            betterVideoPlayer.f12073n0 = hc.c.getScreenWidth(betterVideoPlayer.f12086u) / 2;
            int i10 = betterVideoPlayer.f12066i0;
            int i11 = i10 / 1000;
            betterVideoPlayer.f12070m.setText(i11 + " seconds");
            betterVideoPlayer.f12072n.setText(i11 + " seconds");
            if (motionEvent.getX() > betterVideoPlayer.f12073n0) {
                betterVideoPlayer.c(betterVideoPlayer.f12070m, 1);
                betterVideoPlayer.seekTo(betterVideoPlayer.getCurrentPosition() + i10);
                new Handler().postDelayed(new a(), 500L);
            } else {
                betterVideoPlayer.c(betterVideoPlayer.f12072n, 1);
                betterVideoPlayer.seekTo(betterVideoPlayer.getCurrentPosition() - i10);
                new Handler().postDelayed(new b(), 500L);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return true;
        }
    }

    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            BetterVideoPlayer.this.f12071m0.onTouchEvent(motionEvent);
            return true;
        }
    }

    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = BetterVideoPlayer.this.f12089w;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f12108b;

        public h(View view) {
            this.f12108b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f12108b.setTranslationY(0.0f);
        }
    }

    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = BetterVideoPlayer.this.f12092z;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BetterVideoPlayer betterVideoPlayer = BetterVideoPlayer.this;
            betterVideoPlayer.f12069l0 = 0;
            try {
                betterVideoPlayer.f12070m.animate().cancel();
                betterVideoPlayer.f12072n.animate().cancel();
                betterVideoPlayer.c(betterVideoPlayer.f12070m, 0);
                betterVideoPlayer.c(betterVideoPlayer.f12072n, 0);
            } catch (Exception unused) {
            }
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BetterVideoPlayer.this.hideControls();
        }
    }

    public BetterVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.U = false;
        this.V = false;
        this.W = true;
        this.f12057a0 = false;
        this.f12059b0 = true;
        this.f12060c0 = false;
        this.f12061d0 = false;
        this.f12062e0 = false;
        this.f12063f0 = 7;
        this.f12064g0 = -1;
        this.f12065h0 = 2000;
        this.f12066i0 = AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT;
        this.f12069l0 = 0;
        this.f12071m0 = new GestureDetector(this.f12086u, new e());
        this.f12073n0 = 0;
        this.f12075o0 = false;
        this.f12077p0 = new k();
        this.f12079q0 = new a();
        this.f12081r0 = false;
        this.f12083s0 = new b();
        this.f12085t0 = 0;
        this.f12087u0 = new ScaleType[]{ScaleType.NONE, ScaleType.CENTER_CROP, ScaleType.CENTER_INSIDE, ScaleType.FIT_CENTER, ScaleType.CENTER};
        try {
            e(context, attributeSet);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void a(String str, Object... objArr) {
        if (objArr.length > 0) {
            String.format(str, objArr);
        }
    }

    private void setControlsEnabled(boolean z10) {
        SeekBar seekBar = this.C;
        if (seekBar == null) {
            return;
        }
        seekBar.setEnabled(z10);
        this.G.setEnabled(z10);
        this.G.setAlpha(z10 ? 1.0f : 0.4f);
        this.f12091y.setEnabled(z10);
    }

    public final void b(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        double d10 = i13 / i12;
        int i16 = (int) (i10 * d10);
        if (i11 > i16) {
            i15 = i16;
            i14 = i10;
        } else {
            i14 = (int) (i11 / d10);
            i15 = i11;
        }
        Matrix matrix = new Matrix();
        this.B.getTransform(matrix);
        matrix.setScale(i14 / i10, i15 / i11);
        matrix.postTranslate((i10 - i14) / 2, (i11 - i15) / 2);
        this.B.setTransform(matrix);
    }

    public final void c(TextView textView, int i10) {
        this.N = i10 > 0 ? 0 : 4;
        textView.animate().alpha(i10).setListener(new fc.c(this, textView));
    }

    public void changeEncoding(String str) {
        this.f12074o.changeEncoding(str);
    }

    public final void d() {
        if (this.f12092z.getVisibility() == 0) {
            this.f12092z.animate().cancel();
            this.f12092z.setAlpha(1.0f);
            this.f12092z.setVisibility(0);
            this.f12092z.animate().alpha(0.0f).setInterpolator(new DecelerateInterpolator()).setListener(new i()).start();
        }
    }

    public void disableControls() {
        this.f12062e0 = true;
        this.f12089w.setVisibility(8);
        this.f12092z.setVisibility(8);
        this.f12091y.setOnTouchListener(null);
        this.f12091y.setClickable(false);
    }

    public final void e(Context context, AttributeSet attributeSet) {
        setBackgroundColor(-16777216);
        this.f12086u = context;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BetterVideoPlayer, 0, 0);
            try {
                try {
                    String string = typedArrayObtainStyledAttributes.getString(16);
                    if (string != null && !string.trim().isEmpty()) {
                        this.O = Uri.parse(string);
                    }
                    String string2 = typedArrayObtainStyledAttributes.getString(18);
                    if (string2 != null && !string2.trim().isEmpty()) {
                        this.f12080r = string2;
                    }
                    this.R = typedArrayObtainStyledAttributes.getDrawable(11);
                    this.S = typedArrayObtainStyledAttributes.getDrawable(10);
                    this.T = typedArrayObtainStyledAttributes.getDrawable(12);
                    this.f12063f0 = 7;
                    this.f12065h0 = typedArrayObtainStyledAttributes.getInteger(5, this.f12065h0);
                    this.V = typedArrayObtainStyledAttributes.getBoolean(6, false);
                    this.f12061d0 = typedArrayObtainStyledAttributes.getBoolean(1, false);
                    this.U = typedArrayObtainStyledAttributes.getBoolean(8, false);
                    this.W = typedArrayObtainStyledAttributes.getBoolean(15, false);
                    this.f12057a0 = typedArrayObtainStyledAttributes.getBoolean(13, false);
                    this.f12060c0 = typedArrayObtainStyledAttributes.getBoolean(17, false);
                    this.f12059b0 = typedArrayObtainStyledAttributes.getBoolean(14, true);
                    this.f12062e0 = typedArrayObtainStyledAttributes.getBoolean(4, false);
                    this.f12082s = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.bvp_subtitle_size));
                    this.f12084t = typedArrayObtainStyledAttributes.getColor(2, m0.a.getColor(context, R.color.bvp_subtitle_color));
                } catch (Exception e10) {
                    a("Exception " + e10.getMessage(), new Object[0]);
                    e10.printStackTrace();
                }
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        } else {
            this.f12082s = getResources().getDimensionPixelSize(R.dimen.bvp_subtitle_size);
            this.f12084t = m0.a.getColor(context, R.color.bvp_subtitle_color);
        }
        if (this.R == null) {
            this.R = m0.a.getDrawable(context, R.drawable.bvp_action_play);
        }
        if (this.S == null) {
            this.S = m0.a.getDrawable(context, R.drawable.bvp_action_pause);
        }
        if (this.T == null) {
            this.T = m0.a.getDrawable(context, R.drawable.bvp_action_restart);
        }
        this.Q = new hc.b();
    }

    public void enableControls() {
        this.f12062e0 = false;
        this.f12091y.setClickable(true);
        this.f12091y.setOnTouchListener(this.f12079q0);
    }

    public void enableSwipeGestures(Window window) {
        this.f12060c0 = true;
        this.f12088v = window;
    }

    public final void f() {
        if (!this.H || this.O == null || this.A == null || this.I) {
            return;
        }
        try {
            hideControls();
            this.Q.onPreparing();
            if (this.O.getScheme().equals(HttpHost.DEFAULT_SCHEME_NAME) || this.O.getScheme().equals("https")) {
                a("Loading web URI: " + this.O.toString(), new Object[0]);
                this.A.setVideoURI(this.O);
            } else {
                a("Loading local URI: " + this.O.toString(), new Object[0]);
                this.A.setVideoURI(this.O);
            }
        } catch (Exception e10) {
            fc.b bVar = this.Q;
            if (bVar == null) {
                throw new RuntimeException(e10);
            }
            bVar.onError(this);
        }
    }

    public int getCurrentPosition() {
        VideoView videoView = this.A;
        if (videoView == null) {
            return -1;
        }
        return (int) videoView.getCurrentPosition();
    }

    public int getDuration() {
        VideoView videoView = this.A;
        if (videoView == null) {
            return -1;
        }
        return (int) videoView.getDuration();
    }

    public int getHideControlsDuration() {
        return this.f12065h0;
    }

    public long getOffset() {
        return this.f12074o.f12169s;
    }

    public Uri getSource() {
        return this.O;
    }

    public Toolbar getToolbar() {
        return this.f12078q;
    }

    public void getTracks() {
        try {
            o oVar = this.A.getAvailableTracks().get(ExoMedia$RendererType.CLOSED_CAPTION);
            for (int i10 = 0; i10 < oVar.f20111a; i10++) {
                n nVar = oVar.get(i10);
                for (int i11 = 0; i11 < nVar.f20107a; i11++) {
                    nVar.getFormat(i11);
                }
            }
        } catch (Exception unused) {
        }
    }

    public VideoView getVideoView() {
        return this.A;
    }

    public void hideControls() {
        this.Q.onToggleControls(false);
        if (this.f12062e0 || !isControlsShown() || this.C == null) {
            return;
        }
        this.f12089w.animate().cancel();
        this.f12089w.setAlpha(1.0f);
        this.f12089w.setTranslationY(0.0f);
        this.f12089w.setVisibility(0);
        this.f12089w.animate().alpha(0.0f).translationY(this.f12089w.getHeight()).setInterpolator(new DecelerateInterpolator()).setListener(new g()).start();
        View view = (View) this.f12074o.getParent();
        view.animate().cancel();
        view.animate().translationY(this.f12089w.getHeight()).setInterpolator(new DecelerateInterpolator()).setListener(new h(view)).start();
        if (this.f12057a0) {
            this.D.animate().cancel();
            this.D.setAlpha(0.0f);
            this.D.animate().alpha(1.0f).start();
        }
        d();
    }

    public void hideToolbar() {
        this.f12059b0 = false;
        d();
    }

    public boolean isCaptionActive() {
        return this.f12075o0;
    }

    public boolean isControlsShown() {
        View view;
        return (this.f12062e0 || (view = this.f12089w) == null || view.getAlpha() <= 0.5f) ? false : true;
    }

    public boolean isPlaying() {
        VideoView videoView = this.A;
        return videoView != null && videoView.isPlaying();
    }

    public boolean isPrepared() {
        return this.A != null && this.I;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a("Attached to window", new Object[0]);
        if (this.A != null) {
            a("player not null on attach", new Object[0]);
        }
    }

    @Override // xc.a
    public void onBufferingUpdate(int i10) {
        fc.b bVar = this.Q;
        if (bVar != null) {
            bVar.onBuffering(i10);
        }
        SeekBar seekBar = this.C;
        if (seekBar != null) {
            if (i10 == 100) {
                seekBar.setSecondaryProgress(0);
                this.D.setSecondaryProgress(0);
            } else {
                int max = (int) (seekBar.getMax() * (i10 / 100.0f));
                this.C.setSecondaryProgress(max);
                this.D.setSecondaryProgress(max);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.btnPlayPause) {
            if (view.getId() == R.id.duration) {
                this.W = !this.W;
            }
        } else {
            if (this.A.isPlaying()) {
                pause();
                return;
            }
            if (this.V && !this.f12062e0) {
                this.M.postDelayed(this.f12077p0, 500L);
            }
            start();
        }
    }

    @Override // xc.b
    public void onCompletion() {
        a("onCompletion()", new Object[0]);
        this.G.setImageDrawable(this.T);
        Handler handler = this.M;
        if (handler != null) {
            handler.removeCallbacks(this.f12083s0);
        }
        int max = this.C.getMax();
        this.C.setProgress(max);
        this.D.setProgress(max);
        if (this.U) {
            reset();
            if (getSource() != null) {
                this.A.setVideoURI(getSource());
            }
        } else {
            showControls();
        }
        fc.b bVar = this.Q;
        if (bVar != null) {
            bVar.onCompletion(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a("Detached from window", new Object[0]);
        release();
        this.C = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.f12089w = null;
        this.f12091y = null;
        this.f12090x = null;
        Handler handler = this.M;
        if (handler != null) {
            handler.removeCallbacks(this.f12083s0);
            this.M = null;
        }
    }

    @Override // xc.c
    public boolean onError(Exception exc) {
        new Handler().postDelayed(new d(), 300L);
        Exception exc2 = new Exception(exc.getMessage());
        fc.b bVar = this.Q;
        if (bVar == null) {
            throw new RuntimeException(exc2);
        }
        bVar.onError(this);
        return false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        View viewInflate = layoutInflaterFrom.inflate(R.layout.bvp_include_surface, (ViewGroup) this, false);
        addView(viewInflate);
        this.A = (VideoView) viewInflate.findViewById(R.id.video_view);
        setKeepScreenOn(true);
        this.M = new Handler();
        this.A.setOnPreparedListener(this);
        this.A.setOnCompletionListener(this);
        this.A.setOnVideoSizedChangedListener(this);
        this.A.setOnErrorListener(this);
        this.A.setHandleAudioFocus(true);
        this.f12076p = (AudioManager) getContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f12067j0 = new Handler();
        this.f12068k0 = new j();
        TextureView textureView = (TextureView) viewInflate.findViewById(R.id.textureview);
        this.B = textureView;
        textureView.setSurfaceTextureListener(this);
        this.f12070m = (TextView) viewInflate.findViewById(R.id.view_forward);
        this.f12072n = (TextView) viewInflate.findViewById(R.id.view_backward);
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.bvp_include_progress, (ViewGroup) this, false);
        this.f12090x = viewInflate2;
        this.D = (ProgressBar) viewInflate2.findViewById(R.id.progressBarBottom);
        setLoadingStyle(this.f12063f0);
        TextView textView = (TextView) this.f12090x.findViewById(R.id.position_textview);
        this.f12058b = textView;
        textView.setShadowLayer(3.0f, 3.0f, 3.0f, -16777216);
        addView(this.f12090x);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f12091y = frameLayout;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 != 21 && i10 != 22) {
            frameLayout.setForeground(hc.c.resolveDrawable(getContext(), R.attr.selectableItemBackground));
        }
        addView(this.f12091y, new ViewGroup.LayoutParams(-1, -1));
        View viewInflate3 = layoutInflaterFrom.inflate(R.layout.bvp_include_controls, (ViewGroup) this, false);
        this.f12089w = viewInflate3;
        viewInflate3.setFocusable(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.f12089w, layoutParams);
        View viewInflate4 = layoutInflaterFrom.inflate(R.layout.bvp_include_topbar, (ViewGroup) this, false);
        this.f12092z = viewInflate4;
        Toolbar toolbar = (Toolbar) viewInflate4.findViewById(R.id.toolbar);
        this.f12078q = toolbar;
        toolbar.setTitle(this.f12080r);
        this.f12092z.setVisibility(this.f12059b0 ? 0 : 8);
        addView(this.f12092z);
        View viewInflate5 = layoutInflaterFrom.inflate(R.layout.bvp_include_subtitle, (ViewGroup) this, false);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(2, R.id.bvp_include_relativelayout);
        layoutParams2.alignWithParent = true;
        CaptionsView captionsView = (CaptionsView) viewInflate5.findViewById(R.id.subs_box);
        this.f12074o = captionsView;
        captionsView.setPlayer(this.A);
        this.f12074o.setTextSize(0, this.f12082s);
        this.f12074o.setTextColor(this.f12084t);
        addView(viewInflate5, layoutParams2);
        SeekBar seekBar = (SeekBar) this.f12089w.findViewById(R.id.seeker);
        this.C = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        TextView textView2 = (TextView) this.f12089w.findViewById(R.id.position);
        this.E = textView2;
        textView2.setText(hc.c.getDurationString(0L, false));
        TextView textView3 = (TextView) this.f12089w.findViewById(R.id.duration);
        this.F = textView3;
        textView3.setText(hc.c.getDurationString(0L, true));
        this.F.setOnClickListener(this);
        ImageButton imageButton = (ImageButton) this.f12089w.findViewById(R.id.btnPlayPause);
        this.G = imageButton;
        imageButton.setOnClickListener(this);
        this.G.setImageDrawable(this.R);
        if (this.f12062e0) {
            disableControls();
        } else {
            enableControls();
        }
        setBottomProgressBarVisibility(this.f12057a0);
        setControlsEnabled(false);
        f();
    }

    @Override // xc.d
    @TargetApi(16)
    public void onPrepared() {
        a("onPrepared()", new Object[0]);
        if (this.A == null) {
            return;
        }
        if (!this.f12081r0) {
            showControls();
        }
        this.I = true;
        fc.b bVar = this.Q;
        if (bVar != null) {
            bVar.onPrepared(this);
        }
        this.E.setText(hc.c.getDurationString(0L, false));
        this.F.setText(hc.c.getDurationString(this.A.getDuration(), false));
        this.C.setProgress(0);
        try {
            this.C.setMax((int) this.A.getDuration());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        setControlsEnabled(true);
        if (!this.f12061d0) {
            try {
                this.A.start();
                this.A.pause();
                return;
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
        if (!this.f12062e0 && this.V) {
            this.M.postDelayed(this.f12077p0, 500L);
        }
        start();
        int i10 = this.f12064g0;
        if (i10 > 0) {
            seekTo(i10);
            this.f12064g0 = -1;
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        if (z10) {
            seekTo(i10);
            this.f12058b.setText(hc.c.getDurationString(i10, false));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        boolean zIsPlaying = isPlaying();
        this.J = zIsPlaying;
        if (zIsPlaying) {
            this.A.pause();
        }
        this.f12058b.setVisibility(0);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (this.J) {
            this.A.start();
        }
        this.f12058b.setVisibility(8);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        a("Surface texture available: %dx%d", Integer.valueOf(i10), Integer.valueOf(i11));
        this.K = i10;
        this.L = i11;
        this.H = true;
        new Surface(surfaceTexture);
        if (this.I) {
            a("Surface texture available and media player is prepared", new Object[0]);
        } else {
            f();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        a("Surface texture destroyed", new Object[0]);
        this.H = false;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        a("Surface texture changed: %dx%d", Integer.valueOf(i10), Integer.valueOf(i11));
        try {
            b(i10, i11, this.A.getWidth(), this.A.getHeight());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // xc.f
    public void onVideoSizeChanged(int i10, int i11) {
        a("Video size changed: %dx%d", Integer.valueOf(i10), Integer.valueOf(i11));
        b(this.K, this.L, i10, i11);
    }

    public void pause() {
        if (this.A == null || !isPlaying()) {
            return;
        }
        this.A.pause();
        this.Q.onPaused(this);
        Handler handler = this.M;
        if (handler == null) {
            return;
        }
        handler.removeCallbacks(this.f12077p0);
        this.M.removeCallbacks(this.f12083s0);
        this.G.setImageDrawable(this.R);
    }

    public void release() {
        this.I = false;
        VideoView videoView = this.A;
        if (videoView != null) {
            try {
                videoView.release();
            } catch (Throwable unused) {
            }
            this.A = null;
        }
        Handler handler = this.M;
        if (handler != null) {
            handler.removeCallbacks(this.f12083s0);
            this.M = null;
        }
        a("Released player and Handler", new Object[0]);
    }

    public void removeCaptions() {
        setCaptions(null, null, null);
        this.f12075o0 = false;
    }

    public void reset() {
        VideoView videoView = this.A;
        if (videoView == null) {
            return;
        }
        this.I = false;
        videoView.reset();
        this.I = false;
        this.O = null;
    }

    public void seekTo(int i10) {
        VideoView videoView = this.A;
        if (videoView == null) {
            return;
        }
        videoView.seekTo(i10);
    }

    public void setAutoPlay(boolean z10) {
        this.f12061d0 = z10;
    }

    public void setBottomProgressBarVisibility(boolean z10) {
        this.f12057a0 = z10;
        if (z10) {
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
    }

    public void setCallback(fc.b bVar) {
        this.Q = bVar;
    }

    public void setCaptionLoadListener(CaptionsView.b bVar) {
        this.f12074o.setCaptionsViewLoadListener(bVar);
    }

    public void setCaptions(Uri uri, CaptionsView.CMime cMime, String str) {
        this.f12074o.setCaptionsSource(uri, cMime, str);
        this.f12074o.f12169s = 0L;
        this.f12075o0 = true;
    }

    public void setCaptionsPath(String str, CaptionsView.CMime cMime, String str2) {
        this.f12074o.setCaptionsSource(str, cMime, str2);
        this.f12074o.f12169s = 0L;
        this.f12075o0 = true;
    }

    public void setDoubleTap(int i10) {
        this.f12091y.setOnTouchListener(new f());
    }

    public void setEnableClick(boolean z10) {
        if (z10) {
            return;
        }
        this.f12091y.setVisibility(8);
    }

    public void setEncoding(String str) {
        if (str == null) {
            return;
        }
        try {
            CaptionsView.f12168y = str;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void setHideControlsDuration(int i10) {
        this.f12065h0 = i10;
    }

    public void setHideControlsOnPlay(boolean z10) {
        this.V = z10;
    }

    public void setInitialPosition(int i10) {
        this.f12064g0 = i10;
    }

    public void setLoadingStyle(int i10) {
        switch (i10) {
            case 0:
                new m4.d();
                break;
            case 1:
                new l();
                break;
            case 2:
                new m4.o();
                break;
            case 3:
                new m4.n();
                break;
            case 4:
                new m4.i();
                break;
            case 5:
                new m4.a();
                break;
            case 6:
                new m();
                break;
            case 7:
                new m4.b();
                break;
            case 8:
                new m4.c();
                break;
            case 9:
                new m4.e();
                break;
            case 10:
                new m4.k();
                break;
            default:
                new m();
                break;
        }
    }

    public void setLoop(boolean z10) {
        this.U = z10;
    }

    public void setOffSet(long j10) {
        this.f12074o.f12169s = j10;
    }

    public void setOnExoBufferingUpdate(qc.a aVar) {
        VideoView videoView = this.A;
        if (videoView != null) {
            videoView.setOnVideoBufferingListener1(aVar);
        }
    }

    public void setOnExoErrorListener(xc.c cVar) {
        VideoView videoView = this.A;
        if (videoView != null) {
            videoView.setOnExoErrorListener(cVar);
        }
    }

    public void setPreviewImage(Bitmap bitmap) {
        this.A.setPreviewImage(bitmap);
    }

    public void setScaleType() {
        this.A.setMeasureBasedOnAspectRatioEnabled(true);
        int i10 = this.f12085t0 + 1;
        this.f12085t0 = i10;
        ScaleType[] scaleTypeArr = this.f12087u0;
        if (i10 >= scaleTypeArr.length) {
            this.f12085t0 = 0;
        }
        this.A.setScaleType(scaleTypeArr[this.f12085t0]);
        this.f12058b.setText(scaleTypeArr[this.f12085t0].toString());
        this.f12058b.setVisibility(0);
        new Handler().postDelayed(new c(), 1000L);
    }

    public void setSource(Uri uri) {
        this.O = uri;
        if (this.A != null) {
            f();
        }
    }

    public void setSubColor(int i10) {
        this.f12074o.setTextColor(m0.a.getColor(this.f12086u, i10));
    }

    public void setSubSize(int i10) {
        this.f12074o.setTextSize(0, i10);
    }

    public void setTVMode(boolean z10) {
        this.f12089w.setVisibility(8);
        this.C.setVisibility(8);
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        this.D.setVisibility(8);
        this.f12081r0 = true;
        setLoop(true);
    }

    public void setVideoView(VideoView videoView) {
        this.A = videoView;
    }

    public void setVolume(float f10) {
        VideoView videoView = this.A;
        if (videoView == null || !this.I) {
            return;
        }
        videoView.setVolume(f10);
    }

    public void showControls() {
        this.Q.onToggleControls(true);
        if (this.f12062e0 || isControlsShown() || this.C == null) {
            return;
        }
        this.f12089w.animate().cancel();
        this.f12089w.setAlpha(0.0f);
        this.f12089w.setVisibility(0);
        this.f12089w.animate().alpha(1.0f).translationY(0.0f).setListener(null).setInterpolator(new DecelerateInterpolator()).start();
        View view = (View) this.f12074o.getParent();
        view.animate().cancel();
        view.setTranslationY(this.f12089w.getHeight());
        view.animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator()).start();
        if (this.f12057a0) {
            this.D.animate().cancel();
            this.D.setAlpha(1.0f);
            this.D.animate().alpha(0.0f).start();
        }
        if (this.f12059b0) {
            this.f12092z.animate().cancel();
            this.f12092z.setAlpha(0.0f);
            this.f12092z.setVisibility(0);
            this.f12092z.animate().alpha(1.0f).setListener(null).setInterpolator(new DecelerateInterpolator()).start();
        }
        this.f12089w.requestFocus();
    }

    public void showOverlayText(int i10, boolean z10) {
        int i11 = this.f12069l0 + i10;
        this.f12069l0 = i11;
        this.f12067j0.removeCallbacks(this.f12068k0);
        this.f12067j0.postDelayed(this.f12068k0, 1000L);
        if (i11 < 5) {
            return;
        }
        try {
            this.f12073n0 = hc.c.getScreenWidth(this.f12086u) / 2;
            this.f12070m.setText(i11 + " seconds");
            this.f12072n.setText(i11 + " seconds");
            if (z10) {
                c(this.f12070m, 1);
            } else {
                c(this.f12072n, 1);
            }
        } catch (Exception unused) {
        }
    }

    public void showToolbar() {
        this.f12059b0 = true;
    }

    public void start() {
        VideoView videoView = this.A;
        if (videoView == null) {
            return;
        }
        videoView.start();
        this.Q.onStarted(this);
        if (this.M == null) {
            this.M = new Handler();
        }
        this.M.post(this.f12083s0);
        this.G.setImageDrawable(this.S);
    }

    public void stop() {
        VideoView videoView = this.A;
        if (videoView == null) {
            return;
        }
        try {
            videoView.stopPlayback();
        } catch (Throwable unused) {
        }
        Handler handler = this.M;
        if (handler == null) {
            return;
        }
        handler.removeCallbacks(this.f12077p0);
        this.M.removeCallbacks(this.f12083s0);
        this.G.setImageDrawable(this.S);
    }

    public void toggleControls() {
        if (this.f12062e0) {
            return;
        }
        if (isControlsShown()) {
            hideControls();
            return;
        }
        if (this.f12065h0 >= 0) {
            try {
                Handler handler = this.M;
                k kVar = this.f12077p0;
                handler.removeCallbacks(kVar);
                this.M.postDelayed(kVar, this.f12065h0);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        showControls();
    }

    public void setSource(Uri uri, Map<String, String> map) {
        this.P = map;
        setSource(uri);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setProgressCallback(fc.f fVar) {
    }
}
