package flix.com.vision.exomedia.core.video.mp;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import com.google.android.exoplayer2.drm.f;
import flix.com.vision.exomedia.ExoMedia$RendererType;
import flix.com.vision.exomedia.core.video.mp.NativeVideoDelegate;
import java.io.IOException;
import java.util.Map;
import nc.c;
import u5.h;
import u5.o;
import uc.b;

/* loaded from: classes2.dex */
public class NativeSurfaceVideoView extends b implements NativeVideoDelegate.a, oc.a {

    /* renamed from: w, reason: collision with root package name */
    public View.OnTouchListener f12201w;

    /* renamed from: x, reason: collision with root package name */
    public NativeVideoDelegate f12202x;

    public class a implements SurfaceHolder.Callback {
        public a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) throws IllegalStateException {
            NativeSurfaceVideoView.this.f12202x.onSurfaceSizeChanged(i11, i12);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) throws IllegalStateException {
            NativeSurfaceVideoView.this.f12202x.onSurfaceReady(surfaceHolder.getSurface());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            surfaceHolder.getSurface().release();
            NativeSurfaceVideoView.this.suspend();
        }
    }

    public NativeSurfaceVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup(context, attributeSet);
    }

    @Override // oc.a
    public Map<ExoMedia$RendererType, o> getAvailableTracks() {
        return null;
    }

    @Override // oc.a
    public int getBufferedPercent() {
        return this.f12202x.getBufferPercentage();
    }

    @Override // oc.a
    public long getCurrentPosition() {
        return this.f12202x.getCurrentPosition();
    }

    @Override // oc.a
    public long getDuration() {
        return this.f12202x.getDuration();
    }

    @Override // oc.a
    public boolean isPlaying() {
        return this.f12202x.isPlaying();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.f12201w;
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
        this.f12202x.pause();
    }

    @Override // oc.a
    public void seekTo(long j10) throws IllegalStateException {
        this.f12202x.seekTo(j10);
    }

    @Override // oc.a
    public void setListenerMux(c cVar) {
        this.f12202x.setListenerMux(cVar);
    }

    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f12202x.setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f12202x.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.f12202x.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.f12202x.setOnInfoListener(onInfoListener);
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f12202x.setOnPreparedListener(onPreparedListener);
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.f12202x.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // android.view.View, oc.a
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f12201w = onTouchListener;
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
        this.f12202x = new NativeVideoDelegate(context, this, this);
        getHolder().addCallback(new a());
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        updateVideoSize(0, 0);
    }

    @Override // oc.a
    public void start() throws IllegalStateException {
        this.f12202x.start();
        requestFocus();
    }

    @Override // oc.a
    public void stopPlayback(boolean z10) throws IllegalStateException {
        this.f12202x.stopPlayback(z10);
    }

    public void suspend() {
        this.f12202x.suspend();
    }

    @Override // flix.com.vision.exomedia.core.video.mp.NativeVideoDelegate.a
    public void videoSizeChanged(int i10, int i11) {
        if (updateVideoSize(i10, i11)) {
            requestLayout();
        }
    }

    public void setVideoURI(Uri uri, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.f12202x.setVideoURI(uri, map);
        requestLayout();
        invalidate();
    }

    public void setVideoUri(Uri uri, h hVar) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        setVideoURI(uri);
    }

    @Override // oc.a
    public void release() {
    }

    @Override // oc.a
    public void setDrmCallback(f fVar) {
    }
}
