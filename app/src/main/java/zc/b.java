package zc;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import flix.com.vision.R;
import flix.com.vision.exomedia.ui.widget.VideoView;
import xc.g;
import xc.h;
import zc.a;

/* compiled from: VideoControlsLeanback.java */
@TargetApi(21)
/* loaded from: classes2.dex */
public final class b extends zc.a {
    public ProgressBar K;
    public ImageView L;
    public ViewGroup M;
    public ImageButton N;
    public ImageButton O;
    public View P;
    public final c Q;

    /* compiled from: VideoControlsLeanback.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.onRewindClick();
        }
    }

    /* compiled from: VideoControlsLeanback.java */
    /* renamed from: zc.b$b, reason: collision with other inner class name */
    public class ViewOnClickListenerC0335b implements View.OnClickListener {
        public ViewOnClickListenerC0335b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.onFastForwardClick();
        }
    }

    /* compiled from: VideoControlsLeanback.java */
    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        public int getHorizontalDelta(View view) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i10 = iArr[0];
            b bVar = b.this;
            bVar.L.getLocationOnScreen(iArr);
            return (i10 - ((bVar.L.getWidth() - view.getWidth()) / 2)) - iArr[0];
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (z10) {
                int horizontalDelta = getHorizontalDelta(view);
                b bVar = b.this;
                bVar.L.startAnimation(bVar.new f(horizontalDelta));
            }
        }
    }

    /* compiled from: VideoControlsLeanback.java */
    public class d extends a.f {
        public d() {
            super();
        }

        @Override // zc.a.f, xc.g
        public boolean onFastForwardClicked() {
            b bVar = b.this;
            VideoView videoView = bVar.A;
            if (videoView == null) {
                return false;
            }
            long currentPosition = videoView.getCurrentPosition() + 10000;
            if (currentPosition > bVar.K.getMax()) {
                currentPosition = bVar.K.getMax();
            }
            bVar.performSeek(currentPosition);
            return true;
        }

        @Override // zc.a.f, xc.g
        public boolean onRewindClicked() {
            b bVar = b.this;
            VideoView videoView = bVar.A;
            if (videoView == null) {
                return false;
            }
            long currentPosition = videoView.getCurrentPosition() - 10000;
            if (currentPosition < 0) {
                currentPosition = 0;
            }
            bVar.performSeek(currentPosition);
            return true;
        }
    }

    /* compiled from: VideoControlsLeanback.java */
    public class e implements View.OnKeyListener {
        public e() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            b bVar = b.this;
            if (i10 != 4) {
                if (i10 == 85) {
                    bVar.onPlayPauseClick();
                    return true;
                }
                if (i10 == 126) {
                    VideoView videoView = bVar.A;
                    if (videoView != null && !videoView.isPlaying()) {
                        bVar.A.start();
                        return true;
                    }
                } else {
                    if (i10 != 127) {
                        switch (i10) {
                            case 19:
                                bVar.showTemporary();
                                return true;
                            case 20:
                                bVar.hide();
                                return true;
                            case 21:
                                bVar.showTemporary();
                                bVar.focusPrevious(bVar.P);
                                return true;
                            case 22:
                                bVar.showTemporary();
                                bVar.focusNext(bVar.P);
                                return true;
                            case 23:
                                bVar.showTemporary();
                                bVar.P.callOnClick();
                                return true;
                            default:
                                switch (i10) {
                                    case 87:
                                        bVar.onNextClick();
                                        return true;
                                    case 88:
                                        bVar.onPreviousClick();
                                        return true;
                                    case 89:
                                        bVar.onRewindClick();
                                        return true;
                                    case 90:
                                        bVar.onFastForwardClick();
                                        return true;
                                }
                        }
                    }
                    VideoView videoView2 = bVar.A;
                    if (videoView2 != null && videoView2.isPlaying()) {
                        bVar.A.pause();
                        return true;
                    }
                }
            } else {
                if (bVar.H && bVar.I && !bVar.G) {
                    bVar.hide();
                    return true;
                }
                if (bVar.M.getAnimation() != null) {
                    return true;
                }
            }
            return false;
        }
    }

    public b(Context context) {
        super(context);
        this.Q = new c();
    }

    @Override // zc.a
    public void animateVisibility(boolean z10) {
        if (this.H == z10) {
            return;
        }
        if (!this.G) {
            this.M.startAnimation(new yc.a(this.M, z10, 300L));
        }
        this.H = z10;
        onVisibilityChanged();
    }

    @Override // zc.a
    public void finishLoading() {
        if (this.G) {
            boolean z10 = false;
            this.G = false;
            this.f22689u.setVisibility(0);
            this.L.setVisibility(0);
            this.f22688t.setVisibility(8);
            VideoView videoView = this.A;
            if (videoView != null && videoView.isPlaying()) {
                z10 = true;
            }
            updatePlaybackState(z10);
        }
    }

    public void focusNext(View view) {
        int nextFocusRightId = view.getNextFocusRightId();
        if (nextFocusRightId == -1) {
            return;
        }
        View viewFindViewById = findViewById(nextFocusRightId);
        if (viewFindViewById.getVisibility() != 0) {
            focusNext(viewFindViewById);
            return;
        }
        viewFindViewById.requestFocus();
        this.P = viewFindViewById;
        this.Q.onFocusChange(viewFindViewById, true);
    }

    public void focusPrevious(View view) {
        int nextFocusLeftId = view.getNextFocusLeftId();
        if (nextFocusLeftId == -1) {
            return;
        }
        View viewFindViewById = findViewById(nextFocusLeftId);
        if (viewFindViewById.getVisibility() != 0) {
            focusPrevious(viewFindViewById);
            return;
        }
        viewFindViewById.requestFocus();
        this.P = viewFindViewById;
        this.Q.onFocusChange(viewFindViewById, true);
    }

    @Override // zc.a
    public int getLayoutResource() {
        return R.layout.exomedia_default_controls_leanback;
    }

    @Override // zc.a, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f22685q.requestFocus();
        this.P = this.f22685q;
    }

    public void onFastForwardClick() {
        g gVar = this.C;
        if (gVar == null || !gVar.onFastForwardClicked()) {
            this.D.onFastForwardClicked();
        }
    }

    public void onRewindClick() {
        g gVar = this.C;
        if (gVar == null || !gVar.onRewindClicked()) {
            this.D.onRewindClicked();
        }
    }

    public void performSeek(long j10) {
        h hVar = this.B;
        if (hVar == null || !((a.f) hVar).onSeekEnded(j10)) {
            this.D.onSeekEnded(j10);
        }
    }

    public void registerForInput() {
        e eVar = new e();
        setOnKeyListener(eVar);
        this.f22685q.setOnKeyListener(eVar);
        this.f22686r.setOnKeyListener(eVar);
        this.f22687s.setOnKeyListener(eVar);
        this.O.setOnKeyListener(eVar);
        this.N.setOnKeyListener(eVar);
    }

    @Override // zc.a
    public void registerListeners() {
        super.registerListeners();
        this.O.setOnClickListener(new a());
        this.N.setOnClickListener(new ViewOnClickListenerC0335b());
        ImageButton imageButton = this.f22686r;
        c cVar = this.Q;
        imageButton.setOnFocusChangeListener(cVar);
        this.O.setOnFocusChangeListener(cVar);
        this.f22685q.setOnFocusChangeListener(cVar);
        this.N.setOnFocusChangeListener(cVar);
        this.f22687s.setOnFocusChangeListener(cVar);
    }

    @Override // zc.a
    public void retrieveViews() {
        super.retrieveViews();
        this.K = (ProgressBar) findViewById(R.id.exomedia_controls_video_progress);
        this.O = (ImageButton) findViewById(R.id.exomedia_controls_rewind_btn);
        this.N = (ImageButton) findViewById(R.id.exomedia_controls_fast_forward_btn);
        this.L = (ImageView) findViewById(R.id.exomedia_controls_leanback_ripple);
        this.M = (ViewGroup) findViewById(R.id.exomedia_controls_parent);
    }

    @Override // zc.a
    public void setDuration(long j10) {
        if (j10 != this.K.getMax()) {
            this.f22681m.setText(ad.f.formatMs(j10));
            this.K.setMax((int) j10);
        }
    }

    @Override // zc.a
    public void setFastForwardButtonEnabled(boolean z10) {
        ImageButton imageButton = this.N;
        if (imageButton != null) {
            imageButton.setEnabled(z10);
            this.E.put(R.id.exomedia_controls_fast_forward_btn, z10);
        }
    }

    @Override // zc.a
    public void setFastForwardButtonRemoved(boolean z10) {
        ImageButton imageButton = this.N;
        if (imageButton != null) {
            imageButton.setVisibility(z10 ? 8 : 0);
        }
    }

    @Override // zc.a
    public void setFastForwardDrawable(Drawable drawable) {
        ImageButton imageButton = this.N;
        if (imageButton != null) {
            imageButton.setImageDrawable(drawable);
        }
    }

    @Override // zc.a
    public void setPosition(long j10) {
        this.f22680b.setText(ad.f.formatMs(j10));
        this.K.setProgress((int) j10);
    }

    @Override // zc.a
    public void setRewindButtonEnabled(boolean z10) {
        ImageButton imageButton = this.O;
        if (imageButton != null) {
            imageButton.setEnabled(z10);
            this.E.put(R.id.exomedia_controls_rewind_btn, z10);
        }
    }

    @Override // zc.a
    public void setRewindButtonRemoved(boolean z10) {
        ImageButton imageButton = this.O;
        if (imageButton != null) {
            imageButton.setVisibility(z10 ? 8 : 0);
        }
    }

    @Override // zc.a
    public void setRewindDrawable(Drawable drawable) {
        ImageButton imageButton = this.O;
        if (imageButton != null) {
            imageButton.setImageDrawable(drawable);
        }
    }

    @Override // zc.a
    public void setup(Context context) {
        super.setup(context);
        this.D = new d();
        registerForInput();
        setFocusable(true);
    }

    @Override // zc.a
    public void showLoading(boolean z10) {
        if (this.G) {
            return;
        }
        this.G = true;
        this.f22689u.setVisibility(8);
        this.L.setVisibility(8);
        this.f22688t.setVisibility(0);
        show();
    }

    public void showTemporary() {
        show();
        VideoView videoView = this.A;
        if (videoView == null || !videoView.isPlaying()) {
            return;
        }
        hideDelayed();
    }

    @Override // zc.a
    public void updateButtonDrawables() {
        super.updateButtonDrawables();
        this.O.setImageDrawable(ad.d.tintList(getContext(), R.drawable.exomedia_ic_rewind_white, R.color.exomedia_default_controls_button_selector));
        this.N.setImageDrawable(ad.d.tintList(getContext(), R.drawable.exomedia_ic_fast_forward_white, R.color.exomedia_default_controls_button_selector));
    }

    @Override // zc.a
    public void updateProgress(long j10, long j11, int i10) {
        this.K.setSecondaryProgress((int) ((i10 / 100.0f) * r4.getMax()));
        this.K.setProgress((int) j10);
        this.f22680b.setText(ad.f.formatMs(j10));
    }

    @Override // zc.a
    public void updateTextContainerVisibility() {
        if (this.H) {
            boolean zIsTextContainerEmpty = isTextContainerEmpty();
            if (this.J && zIsTextContainerEmpty && this.f22690v.getVisibility() == 0) {
                this.f22690v.clearAnimation();
                this.f22690v.startAnimation(new yc.a(this.f22690v, false, 300L));
            } else {
                if ((this.J && zIsTextContainerEmpty) || this.f22690v.getVisibility() == 0) {
                    return;
                }
                this.f22690v.clearAnimation();
                this.f22690v.startAnimation(new yc.a(this.f22690v, true, 300L));
            }
        }
    }

    /* compiled from: VideoControlsLeanback.java */
    public class f extends TranslateAnimation implements Animation.AnimationListener {

        /* renamed from: b, reason: collision with root package name */
        public final int f22707b;

        public f(int i10) {
            super(0.0f, i10, 0.0f, 0.0f);
            this.f22707b = i10;
            setDuration(250L);
            setAnimationListener(this);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b bVar = b.this;
            ImageView imageView = bVar.L;
            imageView.setX(imageView.getX() + this.f22707b);
            bVar.L.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
