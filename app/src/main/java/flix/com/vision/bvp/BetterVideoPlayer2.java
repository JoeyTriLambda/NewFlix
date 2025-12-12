package flix.com.vision.bvp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
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
import com.github.ybq.android.spinkit.SpinKitView;
import com.unity3d.services.core.device.MimeTypes;
import cz.msebera.android.httpclient.HttpHost;
import flix.com.vision.R;
import flix.com.vision.bvp.OnSwipeTouchListener;
import flix.com.vision.bvp.subtitle.CaptionsView2;
import flix.com.vision.events.SystemEvent;
import java.io.IOException;
import java.util.Map;
import m4.i;
import m4.k;
import m4.l;
import m4.m;
import m4.n;
import m4.o;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes2.dex */
public class BetterVideoPlayer2 extends RelativeLayout implements TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnErrorListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public View A;
    public MediaPlayer B;
    public TextureView C;
    public Surface D;
    public SeekBar E;
    public ProgressBar F;
    public TextView G;
    public TextView H;
    public ImageButton I;
    public boolean J;
    public boolean K;
    public boolean L;
    public int M;
    public int N;
    public Handler O;
    public int P;
    public Uri Q;
    public Map<String, String> R;
    public fc.a S;
    public Drawable T;
    public Drawable U;
    public Drawable V;
    public boolean W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f12112a0;

    /* renamed from: b, reason: collision with root package name */
    public SpinKitView f12113b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f12114b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f12115c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f12116d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f12117e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f12118f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f12119g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f12120h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f12121i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f12122j0;

    /* renamed from: k0, reason: collision with root package name */
    public final d f12123k0;

    /* renamed from: l0, reason: collision with root package name */
    public final e f12124l0;

    /* renamed from: m, reason: collision with root package name */
    public TextView f12125m;

    /* renamed from: m0, reason: collision with root package name */
    public final f f12126m0;

    /* renamed from: n, reason: collision with root package name */
    public TextView f12127n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f12128o;

    /* renamed from: p, reason: collision with root package name */
    public CaptionsView2 f12129p;

    /* renamed from: q, reason: collision with root package name */
    public AudioManager f12130q;

    /* renamed from: r, reason: collision with root package name */
    public Toolbar f12131r;

    /* renamed from: s, reason: collision with root package name */
    public String f12132s;

    /* renamed from: t, reason: collision with root package name */
    public int f12133t;

    /* renamed from: u, reason: collision with root package name */
    public int f12134u;

    /* renamed from: v, reason: collision with root package name */
    public Context f12135v;

    /* renamed from: w, reason: collision with root package name */
    public Window f12136w;

    /* renamed from: x, reason: collision with root package name */
    public View f12137x;

    /* renamed from: y, reason: collision with root package name */
    public View f12138y;

    /* renamed from: z, reason: collision with root package name */
    public FrameLayout f12139z;

    public class a implements View.OnTouchListener {

        /* renamed from: b, reason: collision with root package name */
        public final int f12140b;

        /* renamed from: m, reason: collision with root package name */
        public final GestureDetector f12141m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ int f12142n;

        /* renamed from: flix.com.vision.bvp.BetterVideoPlayer2$a$a, reason: collision with other inner class name */
        public class C0143a extends GestureDetector.SimpleOnGestureListener {

            /* renamed from: flix.com.vision.bvp.BetterVideoPlayer2$a$a$a, reason: collision with other inner class name */
            public class RunnableC0144a implements Runnable {
                public RunnableC0144a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    BetterVideoPlayer2 betterVideoPlayer2 = BetterVideoPlayer2.this;
                    BetterVideoPlayer2.b(betterVideoPlayer2, betterVideoPlayer2.f12127n, 0);
                }
            }

            /* renamed from: flix.com.vision.bvp.BetterVideoPlayer2$a$a$b */
            public class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    BetterVideoPlayer2 betterVideoPlayer2 = BetterVideoPlayer2.this;
                    BetterVideoPlayer2.b(betterVideoPlayer2, betterVideoPlayer2.f12128o, 0);
                }
            }

            public C0143a() {
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) throws IllegalStateException {
                a aVar = a.this;
                int i10 = aVar.f12142n / 1000;
                BetterVideoPlayer2 betterVideoPlayer2 = BetterVideoPlayer2.this;
                betterVideoPlayer2.f12127n.setText(i10 + " seconds");
                betterVideoPlayer2.f12128o.setText(i10 + " seconds");
                float x10 = motionEvent.getX();
                float f10 = (float) aVar.f12140b;
                int i11 = aVar.f12142n;
                if (x10 > f10) {
                    BetterVideoPlayer2.b(betterVideoPlayer2, betterVideoPlayer2.f12127n, 1);
                    betterVideoPlayer2.seekTo(betterVideoPlayer2.getCurrentPosition() + i11);
                    new Handler().postDelayed(new RunnableC0144a(), 500L);
                } else {
                    BetterVideoPlayer2.b(betterVideoPlayer2, betterVideoPlayer2.f12128o, 1);
                    betterVideoPlayer2.seekTo(betterVideoPlayer2.getCurrentPosition() - i11);
                    new Handler().postDelayed(new b(), 500L);
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                BetterVideoPlayer2.this.toggleControls();
                return true;
            }
        }

        public a(int i10) {
            this.f12142n = i10;
            this.f12140b = hc.c.getScreenWidth(BetterVideoPlayer2.this.f12135v) / 2;
            this.f12141m = new GestureDetector(BetterVideoPlayer2.this.f12135v, new C0143a());
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f12141m.onTouchEvent(motionEvent);
            return true;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = BetterVideoPlayer2.this.f12137x;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f12148b;

        public c(View view) {
            this.f12148b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f12148b.setTranslationY(0.0f);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BetterVideoPlayer2.this.hideControls();
        }
    }

    public class e extends OnSwipeTouchListener {

        /* renamed from: q, reason: collision with root package name */
        public float f12150q = -1.0f;

        /* renamed from: r, reason: collision with root package name */
        public float f12151r = -1.0f;

        /* renamed from: s, reason: collision with root package name */
        public int f12152s;

        /* renamed from: t, reason: collision with root package name */
        public int f12153t;

        /* renamed from: u, reason: collision with root package name */
        public int f12154u;

        /* renamed from: v, reason: collision with root package name */
        public int f12155v;

        public e() {
        }

        @Override // flix.com.vision.bvp.OnSwipeTouchListener
        public void onAfterMove() throws IllegalStateException {
            float f10 = this.f12151r;
            BetterVideoPlayer2 betterVideoPlayer2 = BetterVideoPlayer2.this;
            if (f10 >= 0.0f && betterVideoPlayer2.f12117e0) {
                betterVideoPlayer2.seekTo((int) f10);
                if (betterVideoPlayer2.L) {
                    betterVideoPlayer2.B.start();
                }
            }
            betterVideoPlayer2.f12125m.setVisibility(8);
        }

        @Override // flix.com.vision.bvp.OnSwipeTouchListener
        public void onBeforeMove(OnSwipeTouchListener.Direction direction) throws IllegalStateException {
            BetterVideoPlayer2 betterVideoPlayer2 = BetterVideoPlayer2.this;
            if (betterVideoPlayer2.f12117e0) {
                if (direction == OnSwipeTouchListener.Direction.LEFT || direction == OnSwipeTouchListener.Direction.RIGHT) {
                    betterVideoPlayer2.L = betterVideoPlayer2.isPlaying();
                    betterVideoPlayer2.B.pause();
                    betterVideoPlayer2.f12125m.setVisibility(0);
                    return;
                }
                this.f12155v = 100;
                Window window = betterVideoPlayer2.f12136w;
                if (window != null) {
                    this.f12154u = (int) (window.getAttributes().screenBrightness * 100.0f);
                }
                this.f12153t = betterVideoPlayer2.f12130q.getStreamMaxVolume(3);
                this.f12152s = betterVideoPlayer2.f12130q.getStreamVolume(3);
                betterVideoPlayer2.f12125m.setVisibility(0);
            }
        }

        @Override // flix.com.vision.bvp.OnSwipeTouchListener
        public void onClick() {
            BetterVideoPlayer2.this.toggleControls();
            SystemEvent systemEvent = new SystemEvent();
            systemEvent.f12187a = SystemEvent.ACTION.HIDE_CHANNEL_LIST;
            EventBus.getDefault().post(systemEvent);
        }

        @Override // flix.com.vision.bvp.OnSwipeTouchListener
        public void onMove(OnSwipeTouchListener.Direction direction, float f10) {
            BetterVideoPlayer2 betterVideoPlayer2 = BetterVideoPlayer2.this;
            if (betterVideoPlayer2.f12117e0) {
                OnSwipeTouchListener.Direction direction2 = OnSwipeTouchListener.Direction.LEFT;
                if (direction == direction2 || direction == OnSwipeTouchListener.Direction.RIGHT) {
                    if (betterVideoPlayer2.B.getDuration() <= 60) {
                        this.f12150q = (betterVideoPlayer2.B.getDuration() * f10) / betterVideoPlayer2.M;
                    } else {
                        this.f12150q = (f10 * 60000.0f) / betterVideoPlayer2.M;
                    }
                    if (direction == direction2) {
                        this.f12150q *= -1.0f;
                    }
                    float currentPosition = betterVideoPlayer2.B.getCurrentPosition() + this.f12150q;
                    this.f12151r = currentPosition;
                    if (currentPosition < 0.0f) {
                        this.f12151r = 0.0f;
                    } else if (currentPosition > betterVideoPlayer2.B.getDuration()) {
                        this.f12151r = betterVideoPlayer2.B.getDuration();
                    }
                    this.f12150q = this.f12151r - betterVideoPlayer2.B.getCurrentPosition();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(hc.c.getDurationString((long) this.f12151r, false));
                    sb2.append(" [");
                    sb2.append(direction == direction2 ? "-" : "+");
                    sb2.append(hc.c.getDurationString((long) Math.abs(this.f12150q), false));
                    sb2.append("]");
                    betterVideoPlayer2.f12125m.setText(sb2.toString());
                    return;
                }
                this.f12151r = -1.0f;
                float f11 = this.f12159m;
                float f12 = betterVideoPlayer2.M / 2;
                OnSwipeTouchListener.Direction direction3 = OnSwipeTouchListener.Direction.DOWN;
                if (f11 >= f12 || betterVideoPlayer2.f12136w == null) {
                    int i10 = this.f12153t;
                    float f13 = (i10 * f10) / (betterVideoPlayer2.N / 2.0f);
                    if (direction == direction3) {
                        f13 = -f13;
                    }
                    int i11 = this.f12152s + ((int) f13);
                    if (i11 < 0) {
                        i10 = 0;
                    } else if (i11 <= i10) {
                        i10 = i11;
                    }
                    betterVideoPlayer2.f12125m.setText(String.format(betterVideoPlayer2.getResources().getString(R.string.volume), Integer.valueOf(i10)));
                    betterVideoPlayer2.f12130q.setStreamVolume(3, i10, 0);
                    return;
                }
                if (f11 < r2 / 2) {
                    int i12 = this.f12155v;
                    float f14 = (i12 * f10) / (betterVideoPlayer2.N / 2.0f);
                    if (direction == direction3) {
                        f14 = -f14;
                    }
                    int i13 = this.f12154u + ((int) f14);
                    if (i13 < 0) {
                        i12 = 0;
                    } else if (i13 <= i12) {
                        i12 = i13;
                    }
                    betterVideoPlayer2.f12125m.setText(String.format(betterVideoPlayer2.getResources().getString(R.string.brightness), Integer.valueOf(i12)));
                    WindowManager.LayoutParams attributes = betterVideoPlayer2.f12136w.getAttributes();
                    attributes.screenBrightness = i12 / 100.0f;
                    betterVideoPlayer2.f12136w.setAttributes(attributes);
                    PreferenceManager.getDefaultSharedPreferences(betterVideoPlayer2.getContext()).edit().putInt("BETTER_VIDEO_PLAYER_BRIGHTNESS", i12).apply();
                }
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayer mediaPlayer;
            BetterVideoPlayer2 betterVideoPlayer2 = BetterVideoPlayer2.this;
            if (betterVideoPlayer2.O == null || !betterVideoPlayer2.K || betterVideoPlayer2.E == null || (mediaPlayer = betterVideoPlayer2.B) == null) {
                return;
            }
            long currentPosition = mediaPlayer.getCurrentPosition();
            long duration = betterVideoPlayer2.B.getDuration();
            if (currentPosition > duration) {
                currentPosition = duration;
            }
            betterVideoPlayer2.G.setText(hc.c.getDurationString(currentPosition, false));
            if (betterVideoPlayer2.f12114b0) {
                betterVideoPlayer2.H.setText(hc.c.getDurationString(duration, false));
            } else {
                betterVideoPlayer2.H.setText(hc.c.getDurationString(duration - currentPosition, true));
            }
            int i10 = (int) currentPosition;
            int i11 = (int) duration;
            betterVideoPlayer2.E.setProgress(i10);
            betterVideoPlayer2.E.setMax(i11);
            betterVideoPlayer2.F.setProgress(i10);
            betterVideoPlayer2.F.setMax(i11);
            betterVideoPlayer2.getClass();
            Handler handler = betterVideoPlayer2.O;
            if (handler != null) {
                handler.postDelayed(this, 100L);
            }
        }
    }

    public BetterVideoPlayer2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.W = false;
        this.f12112a0 = false;
        this.f12114b0 = true;
        this.f12115c0 = false;
        this.f12116d0 = true;
        this.f12117e0 = false;
        this.f12118f0 = false;
        this.f12119g0 = false;
        this.f12120h0 = 5;
        this.f12121i0 = -1;
        this.f12122j0 = 2000;
        this.f12123k0 = new d();
        this.f12124l0 = new e();
        this.f12126m0 = new f();
        setBackgroundColor(-16777216);
        this.f12135v = context;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BetterVideoPlayer, 0, 0);
            try {
                try {
                    String string = typedArrayObtainStyledAttributes.getString(16);
                    if (string != null && !string.trim().isEmpty()) {
                        this.Q = Uri.parse(string);
                    }
                    String string2 = typedArrayObtainStyledAttributes.getString(18);
                    if (string2 != null && !string2.trim().isEmpty()) {
                        this.f12132s = string2;
                    }
                    this.T = typedArrayObtainStyledAttributes.getDrawable(11);
                    this.U = typedArrayObtainStyledAttributes.getDrawable(10);
                    this.V = typedArrayObtainStyledAttributes.getDrawable(12);
                    this.f12120h0 = typedArrayObtainStyledAttributes.getInt(1, 0);
                    this.f12122j0 = typedArrayObtainStyledAttributes.getInteger(5, this.f12122j0);
                    this.f12112a0 = typedArrayObtainStyledAttributes.getBoolean(6, false);
                    this.f12118f0 = typedArrayObtainStyledAttributes.getBoolean(1, false);
                    this.W = typedArrayObtainStyledAttributes.getBoolean(8, false);
                    this.f12114b0 = typedArrayObtainStyledAttributes.getBoolean(15, false);
                    this.f12115c0 = typedArrayObtainStyledAttributes.getBoolean(13, false);
                    this.f12117e0 = typedArrayObtainStyledAttributes.getBoolean(17, false);
                    this.f12116d0 = typedArrayObtainStyledAttributes.getBoolean(14, true);
                    this.f12119g0 = typedArrayObtainStyledAttributes.getBoolean(4, false);
                    this.f12133t = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.bvp_subtitle_size));
                    this.f12134u = typedArrayObtainStyledAttributes.getColor(2, m0.a.getColor(context, R.color.bvp_subtitle_color));
                } catch (Exception e10) {
                    a("Exception " + e10.getMessage(), new Object[0]);
                    e10.printStackTrace();
                }
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        } else {
            this.f12133t = getResources().getDimensionPixelSize(R.dimen.bvp_subtitle_size);
            this.f12134u = m0.a.getColor(context, R.color.bvp_subtitle_color);
        }
        if (this.T == null) {
            this.T = m0.a.getDrawable(context, R.drawable.bvp_action_play);
        }
        if (this.U == null) {
            this.U = m0.a.getDrawable(context, R.drawable.bvp_action_pause);
        }
        if (this.V == null) {
            this.V = m0.a.getDrawable(context, R.drawable.bvp_action_restart);
        }
        this.S = new hc.a();
    }

    public static void a(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        Log.d("BetterVideoPlayer2", str);
    }

    public static void b(BetterVideoPlayer2 betterVideoPlayer2, TextView textView, int i10) {
        betterVideoPlayer2.getClass();
        betterVideoPlayer2.P = i10 > 0 ? 0 : 4;
        textView.animate().alpha(i10).setListener(new fc.d(betterVideoPlayer2, textView));
    }

    private void setControlsEnabled(boolean z10) {
        SeekBar seekBar = this.E;
        if (seekBar == null) {
            return;
        }
        seekBar.setEnabled(z10);
        this.I.setEnabled(z10);
        this.I.setAlpha(z10 ? 1.0f : 0.4f);
        this.f12139z.setEnabled(z10);
    }

    public final void c() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (!this.J || this.Q == null || this.B == null || this.K) {
            return;
        }
        try {
            hideControls();
            this.S.onPreparing();
            this.B.setSurface(this.D);
            if (this.Q.getScheme().equals(HttpHost.DEFAULT_SCHEME_NAME) || this.Q.getScheme().equals("https")) {
                a("Loading web URI: " + this.Q.toString(), new Object[0]);
                this.B.setDataSource(getContext(), this.Q, this.R);
            } else {
                a("Loading local URI: " + this.Q.toString(), new Object[0]);
                this.B.setDataSource(getContext(), this.Q, this.R);
            }
            this.B.prepareAsync();
        } catch (IOException e10) {
            fc.a aVar = this.S;
            if (aVar == null) {
                throw new RuntimeException(e10);
            }
            aVar.onError();
        }
    }

    public void disableControls() {
        this.f12119g0 = true;
        this.f12137x.setVisibility(8);
        this.A.setVisibility(8);
        this.f12139z.setOnTouchListener(null);
        this.f12139z.setClickable(false);
    }

    public void enableControls() {
        this.f12119g0 = false;
        this.f12139z.setClickable(true);
        this.f12139z.setOnTouchListener(this.f12124l0);
    }

    public void enableSwipeGestures(Window window) {
        this.f12117e0 = true;
        this.f12136w = window;
    }

    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.B;
        if (mediaPlayer == null) {
            return -1;
        }
        return mediaPlayer.getCurrentPosition();
    }

    public int getDuration() {
        MediaPlayer mediaPlayer = this.B;
        if (mediaPlayer == null) {
            return -1;
        }
        return mediaPlayer.getDuration();
    }

    public int getHideControlsDuration() {
        return this.f12122j0;
    }

    public Toolbar getToolbar() {
        return this.f12131r;
    }

    public void hideControls() {
        this.S.onToggleControls(false);
        if (this.f12119g0 || !isControlsShown() || this.E == null) {
            return;
        }
        this.f12137x.animate().cancel();
        this.f12137x.setAlpha(1.0f);
        this.f12137x.setTranslationY(0.0f);
        this.f12137x.setVisibility(0);
        this.f12137x.animate().alpha(0.0f).translationY(this.f12137x.getHeight()).setInterpolator(new DecelerateInterpolator()).setListener(new b()).start();
        View view = (View) this.f12129p.getParent();
        view.animate().cancel();
        view.animate().translationY(this.f12137x.getHeight()).setInterpolator(new DecelerateInterpolator()).setListener(new c(view)).start();
        if (this.f12115c0) {
            this.F.animate().cancel();
            this.F.setAlpha(0.0f);
            this.F.animate().alpha(1.0f).start();
        }
        if (this.A.getVisibility() == 0) {
            this.A.animate().cancel();
            this.A.setAlpha(1.0f);
            this.A.setVisibility(0);
            this.A.animate().alpha(0.0f).setInterpolator(new DecelerateInterpolator()).setListener(new fc.e(this)).start();
        }
    }

    public boolean isControlsShown() {
        View view;
        return (this.f12119g0 || (view = this.f12137x) == null || view.getAlpha() <= 0.5f) ? false : true;
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.B;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public boolean isPrepared() {
        return this.B != null && this.K;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a("Attached to window", new Object[0]);
        if (this.B != null) {
            a("mPlayer not null on attach", new Object[0]);
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
        a("Buffering: %d%%", Integer.valueOf(i10));
        fc.a aVar = this.S;
        if (aVar != null) {
            aVar.onBuffering();
        }
        SeekBar seekBar = this.E;
        if (seekBar != null) {
            if (i10 == 100) {
                seekBar.setSecondaryProgress(0);
                this.F.setSecondaryProgress(0);
            } else {
                int max = (int) (seekBar.getMax() * (i10 / 100.0f));
                this.E.setSecondaryProgress(max);
                this.F.setSecondaryProgress(max);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException {
        if (view.getId() != R.id.btnPlayPause) {
            if (view.getId() == R.id.duration) {
                this.f12114b0 = !this.f12114b0;
            }
        } else {
            if (this.B.isPlaying()) {
                pause();
                return;
            }
            if (this.f12112a0 && !this.f12119g0) {
                this.O.postDelayed(this.f12123k0, 500L);
            }
            start();
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) throws IllegalStateException {
        a("onCompletion()", new Object[0]);
        this.I.setImageDrawable(this.V);
        Handler handler = this.O;
        if (handler != null) {
            handler.removeCallbacks(this.f12126m0);
        }
        int max = this.E.getMax();
        this.E.setProgress(max);
        this.F.setProgress(max);
        if (this.W) {
            start();
        } else {
            showControls();
        }
        fc.a aVar = this.S;
        if (aVar != null) {
            aVar.onCompletion(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a("Detached from window", new Object[0]);
        release();
        this.E = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.f12137x = null;
        this.f12139z = null;
        this.f12138y = null;
        Handler handler = this.O;
        if (handler != null) {
            handler.removeCallbacks(this.f12126m0);
            this.O = null;
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        if (i10 == -38) {
            return false;
        }
        String strD = o1.a.d("Preparation/playback error (", i10, "): ");
        Exception exc = new Exception(i10 != -1010 ? i10 != -1007 ? i10 != -1004 ? i10 != -110 ? i10 != 100 ? i10 != 200 ? ac.c.B(strD, "Unknown error") : ac.c.B(strD, "Not valid for progressive playback") : ac.c.B(strD, "Server died") : ac.c.B(strD, "Timed out") : ac.c.B(strD, "I/O error") : ac.c.B(strD, "Malformed") : ac.c.B(strD, "Unsupported"));
        fc.a aVar = this.S;
        if (aVar == null) {
            throw new RuntimeException(exc);
        }
        aVar.onError();
        return false;
    }

    @Override // android.view.View
    public void onFinishInflate() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        super.onFinishInflate();
        setKeepScreenOn(true);
        this.O = new Handler();
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.B = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this);
        this.B.setOnBufferingUpdateListener(this);
        this.B.setOnCompletionListener(this);
        this.B.setOnVideoSizeChangedListener(this);
        this.B.setOnErrorListener(this);
        this.B.setAudioStreamType(3);
        this.f12130q = (AudioManager) getContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        View viewInflate = layoutInflaterFrom.inflate(R.layout.bvp_include_surface2, (ViewGroup) this, false);
        addView(viewInflate);
        TextureView textureView = (TextureView) viewInflate.findViewById(R.id.textureview);
        this.C = textureView;
        textureView.setSurfaceTextureListener(this);
        this.f12127n = (TextView) viewInflate.findViewById(R.id.view_forward);
        this.f12128o = (TextView) viewInflate.findViewById(R.id.view_backward);
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.bvp_include_progress, (ViewGroup) this, false);
        this.f12138y = viewInflate2;
        this.f12113b = (SpinKitView) viewInflate2.findViewById(R.id.spin_kit);
        this.F = (ProgressBar) this.f12138y.findViewById(R.id.progressBarBottom);
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true);
        this.f12113b.setColor(typedValue.data);
        setLoadingStyle(this.f12120h0);
        TextView textView = (TextView) this.f12138y.findViewById(R.id.position_textview);
        this.f12125m = textView;
        textView.setShadowLayer(3.0f, 3.0f, 3.0f, -16777216);
        addView(this.f12138y);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f12139z = frameLayout;
        addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.f12137x = layoutInflaterFrom.inflate(R.layout.bvp_include_controls, (ViewGroup) this, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.f12137x, layoutParams);
        View viewInflate3 = layoutInflaterFrom.inflate(R.layout.bvp_include_topbar, (ViewGroup) this, false);
        this.A = viewInflate3;
        Toolbar toolbar = (Toolbar) viewInflate3.findViewById(R.id.toolbar);
        this.f12131r = toolbar;
        toolbar.setTitle(this.f12132s);
        this.A.setVisibility(this.f12116d0 ? 0 : 8);
        addView(this.A);
        View viewInflate4 = layoutInflaterFrom.inflate(R.layout.bvp_include_subtitle2, (ViewGroup) this, false);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(2, R.id.bvp_include_relativelayout);
        layoutParams2.alignWithParent = true;
        CaptionsView2 captionsView2 = (CaptionsView2) viewInflate4.findViewById(R.id.subs_box);
        this.f12129p = captionsView2;
        captionsView2.setPlayer(this.B);
        this.f12129p.setTextSize(0, this.f12133t);
        this.f12129p.setTextColor(this.f12134u);
        addView(viewInflate4, layoutParams2);
        SeekBar seekBar = (SeekBar) this.f12137x.findViewById(R.id.seeker);
        this.E = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        TextView textView2 = (TextView) this.f12137x.findViewById(R.id.position);
        this.G = textView2;
        textView2.setText(hc.c.getDurationString(0L, false));
        TextView textView3 = (TextView) this.f12137x.findViewById(R.id.duration);
        this.H = textView3;
        textView3.setText(hc.c.getDurationString(0L, true));
        this.H.setOnClickListener(this);
        ImageButton imageButton = (ImageButton) this.f12137x.findViewById(R.id.btnPlayPause);
        this.I = imageButton;
        imageButton.setOnClickListener(this);
        this.I.setImageDrawable(this.T);
        if (this.f12119g0) {
            disableControls();
        } else {
            enableControls();
        }
        setBottomProgressBarVisibility(this.f12115c0);
        setControlsEnabled(false);
        c();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    @TargetApi(16)
    public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
        a("onPrepared()", new Object[0]);
        this.f12113b.setVisibility(4);
        showControls();
        this.K = true;
        fc.a aVar = this.S;
        if (aVar != null) {
            aVar.onPrepared(this);
        }
        this.G.setText(hc.c.getDurationString(0L, false));
        this.H.setText(hc.c.getDurationString(mediaPlayer.getDuration(), false));
        this.E.setProgress(0);
        this.E.setMax(mediaPlayer.getDuration());
        setControlsEnabled(true);
        if (!this.f12118f0) {
            this.B.start();
            this.B.pause();
            return;
        }
        if (!this.f12119g0 && this.f12112a0) {
            this.O.postDelayed(this.f12123k0, 500L);
        }
        start();
        int i10 = this.f12121i0;
        if (i10 > 0) {
            seekTo(i10);
            this.f12121i0 = -1;
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) throws IllegalStateException {
        if (z10) {
            seekTo(i10);
            this.f12125m.setText(hc.c.getDurationString(i10, false));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) throws IllegalStateException {
        boolean zIsPlaying = isPlaying();
        this.L = zIsPlaying;
        if (zIsPlaying) {
            this.B.pause();
        }
        this.f12125m.setVisibility(0);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) throws IllegalStateException {
        if (this.L) {
            this.B.start();
        }
        this.f12125m.setVisibility(8);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        a("Surface texture available: %dx%d", Integer.valueOf(i10), Integer.valueOf(i11));
        this.M = i10;
        this.N = i11;
        this.J = true;
        this.D = new Surface(surfaceTexture);
        if (!this.K) {
            c();
        } else {
            a("Surface texture available and media player is prepared", new Object[0]);
            this.B.setSurface(this.D);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        a("Surface texture destroyed", new Object[0]);
        this.J = false;
        this.D = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        int i12;
        int i13;
        a("Surface texture changed: %dx%d", Integer.valueOf(i10), Integer.valueOf(i11));
        try {
            double videoHeight = this.B.getVideoHeight() / this.B.getVideoWidth();
            int i14 = (int) (i10 * videoHeight);
            if (i11 > i14) {
                i13 = i14;
                i12 = i10;
            } else {
                i12 = (int) (i11 / videoHeight);
                i13 = i11;
            }
            Matrix matrix = new Matrix();
            this.C.getTransform(matrix);
            matrix.setScale(i12 / i10, i13 / i11);
            matrix.postTranslate((i10 - i12) / 2, (i11 - i13) / 2);
            this.C.setTransform(matrix);
        } catch (Exception unused) {
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
        a("Video size changed: %dx%d", Integer.valueOf(i10), Integer.valueOf(i11));
    }

    public void pause() throws IllegalStateException {
        if (this.B == null || !isPlaying()) {
            return;
        }
        this.B.pause();
        this.S.onPaused(this);
        Handler handler = this.O;
        if (handler == null) {
            return;
        }
        handler.removeCallbacks(this.f12123k0);
        this.O.removeCallbacks(this.f12126m0);
        this.I.setImageDrawable(this.T);
    }

    public void release() {
        this.K = false;
        MediaPlayer mediaPlayer = this.B;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Throwable unused) {
            }
            this.B = null;
        }
        Handler handler = this.O;
        if (handler != null) {
            handler.removeCallbacks(this.f12126m0);
            this.O = null;
        }
        a("Released player and Handler", new Object[0]);
    }

    public void reset() {
        MediaPlayer mediaPlayer = this.B;
        if (mediaPlayer == null) {
            return;
        }
        this.K = false;
        mediaPlayer.reset();
        this.K = false;
    }

    public void seekTo(int i10) throws IllegalStateException {
        MediaPlayer mediaPlayer = this.B;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.seekTo(i10);
    }

    public void setAutoPlay(boolean z10) {
        this.f12118f0 = z10;
    }

    public void setBottomProgressBarVisibility(boolean z10) {
        this.f12115c0 = z10;
        if (z10) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
    }

    public void setCallback(fc.a aVar) {
        this.S = aVar;
    }

    public void setCaptionLoadListener(CaptionsView2.a aVar) {
        this.f12129p.setCaptionsViewLoadListener(aVar);
    }

    public void setDoubleTap(int i10) {
        this.f12139z.setOnTouchListener(new a(i10));
    }

    public void setHeaders(Map<String, String> map) {
        this.R = map;
    }

    public void setHideControlsDuration(int i10) {
        this.f12122j0 = i10;
    }

    public void setHideControlsOnPlay(boolean z10) {
        this.f12112a0 = z10;
    }

    public void setInitialPosition(int i10) {
        this.f12121i0 = i10;
    }

    public void setLoadingStyle(int i10) {
        Drawable dVar;
        switch (i10) {
            case 0:
                dVar = new m4.d();
                break;
            case 1:
                dVar = new l();
                break;
            case 2:
                dVar = new o();
                break;
            case 3:
                dVar = new n();
                break;
            case 4:
                dVar = new i();
                break;
            case 5:
                dVar = new m4.a();
                break;
            case 6:
                dVar = new m();
                break;
            case 7:
                dVar = new m4.b();
                break;
            case 8:
                dVar = new m4.c();
                break;
            case 9:
                dVar = new m4.e();
                break;
            case 10:
                dVar = new k();
                break;
            default:
                dVar = new m();
                break;
        }
        this.f12113b.setIndeterminateDrawable(dVar);
    }

    public void setLoop(boolean z10) {
        this.W = z10;
    }

    public void setSource(Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.Q = uri;
        if (this.B != null) {
            c();
        }
    }

    public void setTVMode(boolean z10) {
        this.f12137x.setVisibility(8);
        this.E.setVisibility(8);
        this.G.setVisibility(8);
        this.H.setVisibility(8);
        this.F.setVisibility(8);
        setLoop(true);
    }

    public void setVolume(float f10, float f11) {
        MediaPlayer mediaPlayer = this.B;
        if (mediaPlayer == null || !this.K) {
            return;
        }
        mediaPlayer.setVolume(f10, f11);
    }

    public void showControls() {
        this.S.onToggleControls(true);
        if (this.f12119g0 || isControlsShown() || this.E == null) {
            return;
        }
        this.f12137x.animate().cancel();
        this.f12137x.setAlpha(0.0f);
        this.f12137x.setVisibility(0);
        this.f12137x.animate().alpha(1.0f).translationY(0.0f).setListener(null).setInterpolator(new DecelerateInterpolator()).start();
        View view = (View) this.f12129p.getParent();
        view.animate().cancel();
        view.setTranslationY(this.f12137x.getHeight());
        view.animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator()).start();
        if (this.f12115c0) {
            this.F.animate().cancel();
            this.F.setAlpha(1.0f);
            this.F.animate().alpha(0.0f).start();
        }
        if (this.f12116d0) {
            this.A.animate().cancel();
            this.A.setAlpha(0.0f);
            this.A.setVisibility(0);
            this.A.animate().alpha(1.0f).setListener(null).setInterpolator(new DecelerateInterpolator()).start();
        }
    }

    public void start() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.B;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.start();
        this.S.onStarted();
        if (this.O == null) {
            this.O = new Handler();
        }
        this.O.post(this.f12126m0);
        this.I.setImageDrawable(this.U);
    }

    public void toggleControls() {
        if (this.f12119g0) {
            return;
        }
        if (isControlsShown()) {
            hideControls();
            return;
        }
        if (this.f12122j0 >= 0) {
            Handler handler = this.O;
            d dVar = this.f12123k0;
            handler.removeCallbacks(dVar);
            this.O.postDelayed(dVar, this.f12122j0);
        }
        showControls();
    }

    public void setSource(Uri uri, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.R = map;
        setSource(uri);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setProgressCallback(fc.f fVar) {
    }
}
