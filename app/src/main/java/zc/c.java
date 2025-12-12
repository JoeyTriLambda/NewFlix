package zc;

import ad.f;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import flix.com.vision.R;
import flix.com.vision.exomedia.ui.widget.VideoView;
import java.util.LinkedList;
import java.util.List;
import xc.h;
import zc.a;

/* compiled from: VideoControlsMobile.java */
/* loaded from: classes2.dex */
public final class c extends zc.a {
    public SeekBar K;
    public LinearLayout L;
    public boolean M;

    /* compiled from: VideoControlsMobile.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.animateVisibility(false);
        }
    }

    /* compiled from: VideoControlsMobile.java */
    public class b implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: b, reason: collision with root package name */
        public long f22710b;

        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (z10) {
                long j10 = i10;
                this.f22710b = j10;
                TextView textView = c.this.f22680b;
                if (textView != null) {
                    textView.setText(f.formatMs(j10));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c cVar = c.this;
            cVar.M = true;
            h hVar = cVar.B;
            if (hVar == null || !((a.f) hVar).onSeekStarted()) {
                cVar.D.onSeekStarted();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            c cVar = c.this;
            cVar.M = false;
            h hVar = cVar.B;
            if (hVar != null) {
                if (((a.f) hVar).onSeekEnded(this.f22710b)) {
                    return;
                }
            }
            cVar.D.onSeekEnded(this.f22710b);
        }
    }

    public c(Context context) {
        super(context);
        this.M = false;
    }

    @Override // zc.a
    public void animateVisibility(boolean z10) {
        if (this.H == z10) {
            return;
        }
        if (!this.J || !isTextContainerEmpty()) {
            this.f22690v.startAnimation(new yc.b(this.f22690v, z10, 300L));
        }
        if (!this.G) {
            this.f22689u.startAnimation(new yc.a(this.f22689u, z10, 300L));
        }
        this.H = z10;
        onVisibilityChanged();
    }

    @Override // zc.a
    public void finishLoading() {
        if (this.G) {
            boolean z10 = false;
            this.G = false;
            this.f22688t.setVisibility(8);
            this.f22689u.setVisibility(0);
            this.f22685q.setEnabled(true);
            ImageButton imageButton = this.f22686r;
            SparseBooleanArray sparseBooleanArray = this.E;
            imageButton.setEnabled(sparseBooleanArray.get(R.id.exomedia_controls_previous_btn, true));
            this.f22687s.setEnabled(sparseBooleanArray.get(R.id.exomedia_controls_next_btn, true));
            VideoView videoView = this.A;
            if (videoView != null && videoView.isPlaying()) {
                z10 = true;
            }
            updatePlaybackState(z10);
        }
    }

    @Override // zc.a
    public List<View> getExtraViews() {
        int childCount = this.L.getChildCount();
        if (childCount <= 0) {
            return super.getExtraViews();
        }
        LinkedList linkedList = new LinkedList();
        for (int i10 = 0; i10 < childCount; i10++) {
            linkedList.add(this.L.getChildAt(i10));
        }
        return linkedList;
    }

    @Override // zc.a
    public int getLayoutResource() {
        return R.layout.exomedia_default_controls_mobile;
    }

    @Override // zc.a
    public void hideDelayed(long j10) {
        this.F = j10;
        if (j10 < 0 || !this.I || this.G || this.M) {
            return;
        }
        this.f22693y.postDelayed(new a(), j10);
    }

    @Override // zc.a
    public void registerListeners() {
        super.registerListeners();
        this.K.setOnSeekBarChangeListener(new b());
    }

    @Override // zc.a
    public void retrieveViews() {
        super.retrieveViews();
        this.K = (SeekBar) findViewById(R.id.exomedia_controls_video_seek);
        this.L = (LinearLayout) findViewById(R.id.exomedia_controls_extra_container);
    }

    @Override // zc.a
    public void setDuration(long j10) {
        if (j10 != this.K.getMax()) {
            this.f22681m.setText(f.formatMs(j10));
            this.K.setMax((int) j10);
        }
    }

    @Override // zc.a
    public void setPosition(long j10) {
        this.f22680b.setText(f.formatMs(j10));
        this.K.setProgress((int) j10);
    }

    @Override // zc.a
    public void showLoading(boolean z10) {
        if (this.G) {
            return;
        }
        this.G = true;
        this.f22688t.setVisibility(0);
        if (z10) {
            this.f22689u.setVisibility(8);
        } else {
            this.f22685q.setEnabled(false);
            this.f22686r.setEnabled(false);
            this.f22687s.setEnabled(false);
        }
        show();
    }

    @Override // zc.a
    public void updateProgress(long j10, long j11, int i10) {
        if (this.M) {
            return;
        }
        this.K.setSecondaryProgress((int) ((i10 / 100.0f) * r4.getMax()));
        this.K.setProgress((int) j10);
        this.f22680b.setText(f.formatMs(j10));
    }

    @Override // zc.a
    public void updateTextContainerVisibility() {
        if (this.H) {
            boolean zIsTextContainerEmpty = isTextContainerEmpty();
            if (this.J && zIsTextContainerEmpty && this.f22690v.getVisibility() == 0) {
                this.f22690v.clearAnimation();
                this.f22690v.startAnimation(new yc.b(this.f22690v, false, 300L));
            } else {
                if ((this.J && zIsTextContainerEmpty) || this.f22690v.getVisibility() == 0) {
                    return;
                }
                this.f22690v.clearAnimation();
                this.f22690v.startAnimation(new yc.b(this.f22690v, true, 300L));
            }
        }
    }
}
