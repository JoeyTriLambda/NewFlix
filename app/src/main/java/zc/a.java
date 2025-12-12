package zc;

import ad.c;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import flix.com.vision.R;
import flix.com.vision.exomedia.ui.widget.VideoView;
import java.util.LinkedList;
import java.util.List;
import xc.g;
import xc.h;
import xc.i;

/* compiled from: VideoControls.java */
/* loaded from: classes2.dex */
public abstract class a extends RelativeLayout {
    public VideoView A;
    public h B;
    public g C;
    public f D;
    public final SparseBooleanArray E;
    public long F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;

    /* renamed from: b, reason: collision with root package name */
    public TextView f22680b;

    /* renamed from: m, reason: collision with root package name */
    public TextView f22681m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f22682n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f22683o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f22684p;

    /* renamed from: q, reason: collision with root package name */
    public ImageButton f22685q;

    /* renamed from: r, reason: collision with root package name */
    public ImageButton f22686r;

    /* renamed from: s, reason: collision with root package name */
    public ImageButton f22687s;

    /* renamed from: t, reason: collision with root package name */
    public ProgressBar f22688t;

    /* renamed from: u, reason: collision with root package name */
    public ViewGroup f22689u;

    /* renamed from: v, reason: collision with root package name */
    public ViewGroup f22690v;

    /* renamed from: w, reason: collision with root package name */
    public Drawable f22691w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f22692x;

    /* renamed from: y, reason: collision with root package name */
    public final Handler f22693y;

    /* renamed from: z, reason: collision with root package name */
    public final ad.c f22694z;

    /* compiled from: VideoControls.java */
    /* renamed from: zc.a$a, reason: collision with other inner class name */
    public class C0334a implements c.b {
        public C0334a() {
        }

        @Override // ad.c.b
        public void onRepeat() {
            a.this.updateProgress();
        }
    }

    /* compiled from: VideoControls.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.hide();
        }
    }

    /* compiled from: VideoControls.java */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.onPlayPauseClick();
        }
    }

    /* compiled from: VideoControls.java */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.onPreviousClick();
        }
    }

    /* compiled from: VideoControls.java */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.onNextClick();
        }
    }

    /* compiled from: VideoControls.java */
    public class f implements h, g {

        /* renamed from: a, reason: collision with root package name */
        public boolean f22700a = false;

        public f() {
        }

        @Override // xc.g
        public boolean onFastForwardClicked() {
            return false;
        }

        public boolean onNextClicked() {
            return false;
        }

        public boolean onPlayPauseClicked() {
            a aVar = a.this;
            VideoView videoView = aVar.A;
            if (videoView == null) {
                return false;
            }
            if (videoView.isPlaying()) {
                aVar.A.pause();
                return true;
            }
            aVar.A.start();
            return true;
        }

        public boolean onPreviousClicked() {
            return false;
        }

        @Override // xc.g
        public boolean onRewindClicked() {
            return false;
        }

        public boolean onSeekEnded(long j10) {
            a aVar = a.this;
            VideoView videoView = aVar.A;
            if (videoView == null) {
                return false;
            }
            videoView.seekTo(j10);
            if (!this.f22700a) {
                return true;
            }
            this.f22700a = false;
            aVar.A.start();
            aVar.hideDelayed();
            return true;
        }

        public boolean onSeekStarted() {
            a aVar = a.this;
            VideoView videoView = aVar.A;
            if (videoView == null) {
                return false;
            }
            if (videoView.isPlaying()) {
                this.f22700a = true;
                aVar.A.pause(true);
            }
            aVar.show();
            return true;
        }
    }

    public a(Context context) {
        super(context);
        this.f22693y = new Handler();
        this.f22694z = new ad.c();
        this.D = new f();
        this.E = new SparseBooleanArray();
        this.F = 2000L;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = true;
        setup(context);
    }

    public abstract void animateVisibility(boolean z10);

    public abstract void finishLoading();

    public List<View> getExtraViews() {
        return new LinkedList();
    }

    public abstract int getLayoutResource();

    public void hide() {
        if (!this.I || this.G) {
            return;
        }
        this.f22693y.removeCallbacksAndMessages(null);
        clearAnimation();
        animateVisibility(false);
    }

    public void hideDelayed() {
        hideDelayed(this.F);
    }

    public boolean isTextContainerEmpty() {
        if (this.f22682n.getText() != null && this.f22682n.getText().length() > 0) {
            return false;
        }
        if (this.f22683o.getText() == null || this.f22683o.getText().length() <= 0) {
            return this.f22684p.getText() == null || this.f22684p.getText().length() <= 0;
        }
        return false;
    }

    public boolean isVisible() {
        return this.H;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f22694z.setRepeatListener(new C0334a());
        VideoView videoView = this.A;
        if (videoView == null || !videoView.isPlaying()) {
            return;
        }
        updatePlaybackState(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ad.c cVar = this.f22694z;
        cVar.stop();
        cVar.setRepeatListener(null);
    }

    public void onNextClick() {
        g gVar = this.C;
        if (gVar == null || !((f) gVar).onNextClicked()) {
            this.D.onNextClicked();
        }
    }

    public void onPlayPauseClick() {
        g gVar = this.C;
        if (gVar == null || !((f) gVar).onPlayPauseClicked()) {
            this.D.onPlayPauseClicked();
        }
    }

    public void onPreviousClick() {
        g gVar = this.C;
        if (gVar == null || !((f) gVar).onPreviousClicked()) {
            this.D.onPreviousClicked();
        }
    }

    public void registerListeners() {
        this.f22685q.setOnClickListener(new c());
        this.f22686r.setOnClickListener(new d());
        this.f22687s.setOnClickListener(new e());
    }

    public void retrieveViews() {
        this.f22680b = (TextView) findViewById(R.id.exomedia_controls_current_time);
        this.f22681m = (TextView) findViewById(R.id.exomedia_controls_end_time);
        this.f22682n = (TextView) findViewById(R.id.exomedia_controls_title);
        this.f22683o = (TextView) findViewById(R.id.exomedia_controls_sub_title);
        this.f22684p = (TextView) findViewById(R.id.exomedia_controls_description);
        this.f22685q = (ImageButton) findViewById(R.id.exomedia_controls_play_pause_btn);
        this.f22686r = (ImageButton) findViewById(R.id.exomedia_controls_previous_btn);
        this.f22687s = (ImageButton) findViewById(R.id.exomedia_controls_next_btn);
        this.f22688t = (ProgressBar) findViewById(R.id.exomedia_controls_video_loading);
        this.f22689u = (ViewGroup) findViewById(R.id.exomedia_controls_interactive_container);
        this.f22690v = (ViewGroup) findViewById(R.id.exomedia_controls_text_container);
    }

    public void setButtonListener(g gVar) {
        this.C = gVar;
    }

    public void setCanHide(boolean z10) {
        this.I = z10;
    }

    public void setDescription(CharSequence charSequence) {
        this.f22684p.setText(charSequence);
        updateTextContainerVisibility();
    }

    public abstract void setDuration(long j10);

    public void setHideDelay(long j10) {
        this.F = j10;
    }

    public void setHideEmptyTextContainer(boolean z10) {
        this.J = z10;
        updateTextContainerVisibility();
    }

    public void setNextButtonEnabled(boolean z10) {
        this.f22687s.setEnabled(z10);
        this.E.put(R.id.exomedia_controls_next_btn, z10);
    }

    public void setNextButtonRemoved(boolean z10) {
        this.f22687s.setVisibility(z10 ? 8 : 0);
    }

    public void setNextDrawable(Drawable drawable) {
        this.f22687s.setImageDrawable(drawable);
    }

    public abstract void setPosition(long j10);

    public void setPreviousButtonEnabled(boolean z10) {
        this.f22686r.setEnabled(z10);
        this.E.put(R.id.exomedia_controls_previous_btn, z10);
    }

    public void setPreviousButtonRemoved(boolean z10) {
        this.f22686r.setVisibility(z10 ? 8 : 0);
    }

    public void setPreviousDrawable(Drawable drawable) {
        this.f22686r.setImageDrawable(drawable);
    }

    public void setSeekListener(h hVar) {
        this.B = hVar;
    }

    public void setSubTitle(CharSequence charSequence) {
        this.f22683o.setText(charSequence);
        updateTextContainerVisibility();
    }

    public void setTitle(CharSequence charSequence) {
        this.f22682n.setText(charSequence);
        updateTextContainerVisibility();
    }

    public void setVideoView(VideoView videoView) {
        this.A = videoView;
    }

    public void setup(Context context) {
        View.inflate(context, getLayoutResource(), this);
        retrieveViews();
        registerListeners();
        updateButtonDrawables();
    }

    public void show() {
        this.f22693y.removeCallbacksAndMessages(null);
        clearAnimation();
        animateVisibility(true);
    }

    public abstract void showLoading(boolean z10);

    public void updateButtonDrawables() {
        this.f22691w = ad.d.tintList(getContext(), R.drawable.exomedia_ic_play_arrow_white, R.color.exomedia_default_controls_button_selector);
        this.f22692x = ad.d.tintList(getContext(), R.drawable.exomedia_ic_pause_white, R.color.exomedia_default_controls_button_selector);
        this.f22685q.setImageDrawable(this.f22691w);
        this.f22686r.setImageDrawable(ad.d.tintList(getContext(), R.drawable.exomedia_ic_skip_previous_white, R.color.exomedia_default_controls_button_selector));
        this.f22687s.setImageDrawable(ad.d.tintList(getContext(), R.drawable.exomedia_ic_skip_next_white, R.color.exomedia_default_controls_button_selector));
    }

    public void updatePlayPauseImage(boolean z10) {
        this.f22685q.setImageDrawable(z10 ? this.f22692x : this.f22691w);
    }

    public void updatePlaybackState(boolean z10) {
        updatePlayPauseImage(z10);
        this.f22694z.start();
        if (z10) {
            hideDelayed();
        } else {
            show();
        }
    }

    public void updateProgress() {
        VideoView videoView = this.A;
        if (videoView != null) {
            updateProgress(videoView.getCurrentPosition(), this.A.getDuration(), this.A.getBufferPercentage());
        }
    }

    public abstract void updateProgress(long j10, long j11, int i10);

    public abstract void updateTextContainerVisibility();

    public void hideDelayed(long j10) {
        this.F = j10;
        if (j10 < 0 || !this.I || this.G) {
            return;
        }
        this.f22693y.postDelayed(new b(), j10);
    }

    public void onVisibilityChanged() {
    }

    public void setFastForwardButtonEnabled(boolean z10) {
    }

    public void setFastForwardButtonRemoved(boolean z10) {
    }

    public void setFastForwardDrawable(Drawable drawable) {
    }

    public void setRewindButtonEnabled(boolean z10) {
    }

    public void setRewindButtonRemoved(boolean z10) {
    }

    public void setRewindDrawable(Drawable drawable) {
    }

    public void setVisibilityListener(i iVar) {
    }
}
