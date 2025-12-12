package flix.com.vision.exomedia.core.video.exo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.exoplayer2.drm.f;
import flix.com.vision.exomedia.ExoMedia$RendererType;
import java.util.Map;
import u5.o;
import uc.c;

@TargetApi(16)
/* loaded from: classes2.dex */
public class ExoTextureVideoView extends c implements oc.a {

    /* renamed from: w, reason: collision with root package name */
    public vc.a f12199w;

    public ExoTextureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup();
    }

    @Override // oc.a
    public Map<ExoMedia$RendererType, o> getAvailableTracks() {
        return this.f12199w.getAvailableTracks();
    }

    @Override // oc.a
    public int getBufferedPercent() {
        return this.f12199w.getBufferedPercent();
    }

    @Override // oc.a
    public long getCurrentPosition() {
        return this.f12199w.getCurrentPosition();
    }

    @Override // oc.a
    public long getDuration() {
        return this.f12199w.getDuration();
    }

    @Override // oc.a
    public boolean isPlaying() {
        return this.f12199w.isPlaying();
    }

    @Override // oc.a
    public void onVideoSizeChanged(int i10, int i11) {
        if (updateVideoSize(i10, i11)) {
            requestLayout();
        }
    }

    @Override // oc.a
    public void pause() {
        this.f12199w.pause();
    }

    @Override // oc.a
    public void release() {
        this.f12199w.release();
    }

    @Override // oc.a
    public void seekTo(long j10) {
        this.f12199w.seekTo(j10);
    }

    @Override // oc.a
    public void setDrmCallback(f fVar) {
        this.f12199w.setDrmCallback(fVar);
    }

    @Override // oc.a
    public void setListenerMux(nc.c cVar) {
        this.f12199w.setListenerMux(cVar);
    }

    @Override // oc.a
    public void setVideoUri(Uri uri) {
        this.f12199w.setVideoUri(uri);
    }

    @Override // oc.a
    public boolean setVolume(float f10) {
        return this.f12199w.setVolume(f10);
    }

    public void setup() {
        this.f12199w = new vc.a(getContext(), this);
        setSurfaceTextureListener(new a());
        updateVideoSize(0, 0);
    }

    @Override // oc.a
    public void start() {
        this.f12199w.start();
    }

    @Override // oc.a
    public void stopPlayback(boolean z10) {
        this.f12199w.stopPlayback(z10);
    }

    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            ExoTextureVideoView.this.f12199w.onSurfaceReady(new Surface(surfaceTexture));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ExoTextureVideoView.this.f12199w.onSurfaceDestroyed();
            surfaceTexture.release();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        }
    }
}
