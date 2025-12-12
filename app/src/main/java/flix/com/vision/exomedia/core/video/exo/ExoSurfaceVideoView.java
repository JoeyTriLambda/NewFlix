package flix.com.vision.exomedia.core.video.exo;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.drm.f;
import flix.com.vision.exomedia.ExoMedia$RendererType;
import java.util.Map;
import nc.c;
import u5.o;
import uc.b;

@TargetApi(16)
/* loaded from: classes2.dex */
public class ExoSurfaceVideoView extends b implements oc.a {

    /* renamed from: w, reason: collision with root package name */
    public vc.a f12197w;

    public ExoSurfaceVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup();
    }

    @Override // oc.a
    public Map<ExoMedia$RendererType, o> getAvailableTracks() {
        return this.f12197w.getAvailableTracks();
    }

    @Override // oc.a
    public int getBufferedPercent() {
        return this.f12197w.getBufferedPercent();
    }

    @Override // oc.a
    public long getCurrentPosition() {
        return this.f12197w.getCurrentPosition();
    }

    @Override // oc.a
    public long getDuration() {
        return this.f12197w.getDuration();
    }

    @Override // oc.a
    public boolean isPlaying() {
        return this.f12197w.isPlaying();
    }

    @Override // oc.a
    public void onVideoSizeChanged(int i10, int i11) {
        if (updateVideoSize(i10, i11)) {
            requestLayout();
        }
    }

    @Override // oc.a
    public void pause() {
        this.f12197w.pause();
    }

    @Override // oc.a
    public void release() {
        this.f12197w.release();
    }

    @Override // oc.a
    public void seekTo(long j10) {
        this.f12197w.seekTo(j10);
    }

    @Override // oc.a
    public void setDrmCallback(f fVar) {
        this.f12197w.setDrmCallback(fVar);
    }

    @Override // oc.a
    public void setListenerMux(c cVar) {
        this.f12197w.setListenerMux(cVar);
    }

    @Override // oc.a
    public void setVideoUri(Uri uri) {
        this.f12197w.setVideoUri(uri);
    }

    @Override // oc.a
    public boolean setVolume(float f10) {
        return this.f12197w.setVolume(f10);
    }

    public void setup() {
        this.f12197w = new vc.a(getContext(), this);
        getHolder().addCallback(new a());
        updateVideoSize(0, 0);
    }

    @Override // oc.a
    public void start() {
        this.f12197w.start();
    }

    @Override // oc.a
    public void stopPlayback(boolean z10) {
        this.f12197w.stopPlayback(z10);
    }

    public class a implements SurfaceHolder.Callback {
        public a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            ExoSurfaceVideoView.this.f12197w.onSurfaceReady(surfaceHolder.getSurface());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ExoSurfaceVideoView.this.f12197w.onSurfaceDestroyed();
            surfaceHolder.getSurface().release();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        }
    }
}
