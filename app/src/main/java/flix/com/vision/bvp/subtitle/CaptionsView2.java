package flix.com.vision.bvp.subtitle;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes2.dex */
public class CaptionsView2 extends AppCompatTextView implements Runnable {

    /* renamed from: s, reason: collision with root package name */
    public MediaPlayer f12186s;

    public interface a {
    }

    public CaptionsView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this, 300L);
        setShadowLayer(6.0f, 6.0f, 6.0f, -16777216);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer = this.f12186s;
        postDelayed(this, 50L);
    }

    public void setPlayer(MediaPlayer mediaPlayer) {
        this.f12186s = mediaPlayer;
    }

    public void setCaptionsViewLoadListener(a aVar) {
    }
}
