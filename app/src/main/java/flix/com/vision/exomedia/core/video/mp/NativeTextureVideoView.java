package flix.com.vision.exomedia.core.video.mp;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.google.android.exoplayer2.drm.f;
import flix.com.vision.exomedia.ExoMedia$RendererType;
import flix.com.vision.exomedia.core.video.mp.NativeVideoDelegate;
import java.io.IOException;
import java.util.Map;
import u5.h;
import u5.o;
import uc.c;

/* loaded from: classes2.dex */
public class NativeTextureVideoView extends c implements NativeVideoDelegate.a, oc.a {

    /* renamed from: w, reason: collision with root package name */
    public View.OnTouchListener f12204w;

    /* renamed from: x, reason: collision with root package name */
    public NativeVideoDelegate f12205x;

    public NativeTextureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup(context, attributeSet);
    }

    @Override // oc.a
    public Map<ExoMedia$RendererType, o> getAvailableTracks() {
        return null;
    }

    @Override // oc.a
    public int getBufferedPercent() {
        return this.f12205x.getBufferPercentage();
    }

    @Override // oc.a
    public long getCurrentPosition() {
        return this.f12205x.getCurrentPosition();
    }

    @Override // oc.a
    public long getDuration() {
        return this.f12205x.getDuration();
    }

    @Override // oc.a
    public boolean isPlaying() {
        return this.f12205x.isPlaying();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.f12204w;
        return (onTouchListener != null ? onTouchListener.onTouch(this, motionEvent) : false) || super.onTouchEvent(motionEvent);
    }

    @Override // oc.a
    public void onVideoSizeChanged(int i10, int i11) {
        if (updateVideoSize(i10, i11)) {
            requestLayout();
        }
    }

    @Override // oc.a
    public void pause() throws IllegalStateException {
        this.f12205x.pause();
    }

    @Override // oc.a
    public void seekTo(long j10) throws IllegalStateException {
        this.f12205x.seekTo(j10);
    }

    @Override // oc.a
    public void setListenerMux(nc.c cVar) {
        this.f12205x.setListenerMux(cVar);
    }

    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f12205x.setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f12205x.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.f12205x.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.f12205x.setOnInfoListener(onInfoListener);
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f12205x.setOnPreparedListener(onPreparedListener);
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.f12205x.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // android.view.View, oc.a
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f12204w = onTouchListener;
        super.setOnTouchListener(onTouchListener);
    }

    public void setVideoURI(Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        setVideoURI(uri, null);
    }

    @Override // oc.a
    public void setVideoUri(Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        setVideoUri(uri, null);
    }

    @Override // oc.a
    public boolean setVolume(float f10) {
        return false;
    }

    public void setup(Context context, AttributeSet attributeSet) {
        this.f12205x = new NativeVideoDelegate(context, this, this);
        setSurfaceTextureListener(new a());
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        updateVideoSize(0, 0);
    }

    @Override // oc.a
    public void start() throws IllegalStateException {
        this.f12205x.start();
        requestFocus();
    }

    @Override // oc.a
    public void stopPlayback(boolean z10) throws IllegalStateException {
        this.f12205x.stopPlayback(z10);
    }

    public void suspend() {
        this.f12205x.suspend();
    }

    @Override // flix.com.vision.exomedia.core.video.mp.NativeVideoDelegate.a
    public void videoSizeChanged(int i10, int i11) {
        if (updateVideoSize(i10, i11)) {
            requestLayout();
        }
    }

    public void setVideoURI(Uri uri, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.f12205x.setVideoURI(uri, map);
        requestLayout();
        invalidate();
    }

    public void setVideoUri(Uri uri, h hVar) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        setVideoURI(uri);
    }

    @Override // oc.a
    public void release() {
    }

    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) throws IllegalStateException {
            NativeTextureVideoView.this.f12205x.onSurfaceReady(new Surface(surfaceTexture));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            surfaceTexture.release();
            NativeTextureVideoView.this.suspend();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) throws IllegalStateException {
            NativeTextureVideoView.this.f12205x.onSurfaceSizeChanged(i10, i11);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    @Override // oc.a
    public void setDrmCallback(f fVar) {
    }
}
