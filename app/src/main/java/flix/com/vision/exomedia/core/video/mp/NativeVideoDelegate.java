package flix.com.vision.exomedia.core.video.mp;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.util.Map;
import nc.c;

/* loaded from: classes2.dex */
public final class NativeVideoDelegate {

    /* renamed from: a, reason: collision with root package name */
    public Map<String, String> f12207a;

    /* renamed from: b, reason: collision with root package name */
    public State f12208b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f12209c;

    /* renamed from: d, reason: collision with root package name */
    public final a f12210d;

    /* renamed from: e, reason: collision with root package name */
    public final uc.a f12211e;

    /* renamed from: f, reason: collision with root package name */
    public MediaPlayer f12212f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12213g;

    /* renamed from: h, reason: collision with root package name */
    public long f12214h;

    /* renamed from: i, reason: collision with root package name */
    public int f12215i;

    /* renamed from: j, reason: collision with root package name */
    public c f12216j;

    /* renamed from: k, reason: collision with root package name */
    public final b f12217k;

    /* renamed from: l, reason: collision with root package name */
    public MediaPlayer.OnCompletionListener f12218l;

    /* renamed from: m, reason: collision with root package name */
    public MediaPlayer.OnPreparedListener f12219m;

    /* renamed from: n, reason: collision with root package name */
    public MediaPlayer.OnBufferingUpdateListener f12220n;

    /* renamed from: o, reason: collision with root package name */
    public MediaPlayer.OnSeekCompleteListener f12221o;

    /* renamed from: p, reason: collision with root package name */
    public MediaPlayer.OnErrorListener f12222p;

    /* renamed from: q, reason: collision with root package name */
    public MediaPlayer.OnInfoListener f12223q;

    public enum State {
        ERROR,
        IDLE,
        PREPARING,
        PREPARED,
        PLAYING,
        PAUSED,
        COMPLETED
    }

    public interface a {
        void videoSizeChanged(int i10, int i11);
    }

    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
            NativeVideoDelegate nativeVideoDelegate = NativeVideoDelegate.this;
            nativeVideoDelegate.f12215i = i10;
            MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = nativeVideoDelegate.f12220n;
            if (onBufferingUpdateListener != null) {
                onBufferingUpdateListener.onBufferingUpdate(mediaPlayer, i10);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            State state = State.COMPLETED;
            NativeVideoDelegate nativeVideoDelegate = NativeVideoDelegate.this;
            nativeVideoDelegate.f12208b = state;
            MediaPlayer.OnCompletionListener onCompletionListener = nativeVideoDelegate.f12218l;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(nativeVideoDelegate.f12212f);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            State state = State.ERROR;
            NativeVideoDelegate nativeVideoDelegate = NativeVideoDelegate.this;
            nativeVideoDelegate.f12208b = state;
            MediaPlayer.OnErrorListener onErrorListener = nativeVideoDelegate.f12222p;
            return onErrorListener == null || onErrorListener.onError(nativeVideoDelegate.f12212f, i10, i11);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
            MediaPlayer.OnInfoListener onInfoListener = NativeVideoDelegate.this.f12223q;
            return onInfoListener == null || onInfoListener.onInfo(mediaPlayer, i10, i11);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
            State state = State.PREPARED;
            NativeVideoDelegate nativeVideoDelegate = NativeVideoDelegate.this;
            nativeVideoDelegate.f12208b = state;
            MediaPlayer.OnPreparedListener onPreparedListener = nativeVideoDelegate.f12219m;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(nativeVideoDelegate.f12212f);
            }
            nativeVideoDelegate.f12210d.videoSizeChanged(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            long j10 = nativeVideoDelegate.f12214h;
            if (j10 != 0) {
                nativeVideoDelegate.seekTo(j10);
            }
            if (nativeVideoDelegate.f12213g) {
                nativeVideoDelegate.start();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            MediaPlayer.OnSeekCompleteListener onSeekCompleteListener = NativeVideoDelegate.this.f12221o;
            if (onSeekCompleteListener != null) {
                onSeekCompleteListener.onSeekComplete(mediaPlayer);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            NativeVideoDelegate.this.f12210d.videoSizeChanged(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }

    public NativeVideoDelegate(Context context, a aVar, uc.a aVar2) {
        State state = State.IDLE;
        this.f12208b = state;
        this.f12213g = false;
        this.f12217k = new b();
        this.f12209c = context;
        this.f12210d = aVar;
        this.f12211e = aVar2;
        initMediaPlayer();
        this.f12208b = state;
    }

    public int getBufferPercentage() {
        if (this.f12212f != null) {
            return this.f12215i;
        }
        return 0;
    }

    public long getCurrentPosition() {
        if (this.f12216j.isPrepared() && isReady()) {
            return this.f12212f.getCurrentPosition();
        }
        return 0L;
    }

    public long getDuration() {
        if (this.f12216j.isPrepared() && isReady()) {
            return this.f12212f.getDuration();
        }
        return 0L;
    }

    public void initMediaPlayer() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f12212f = mediaPlayer;
        b bVar = this.f12217k;
        mediaPlayer.setOnInfoListener(bVar);
        this.f12212f.setOnErrorListener(bVar);
        this.f12212f.setOnPreparedListener(bVar);
        this.f12212f.setOnCompletionListener(bVar);
        this.f12212f.setOnSeekCompleteListener(bVar);
        this.f12212f.setOnBufferingUpdateListener(bVar);
        this.f12212f.setOnVideoSizeChangedListener(bVar);
        this.f12212f.setAudioStreamType(3);
        this.f12212f.setScreenOnWhilePlaying(true);
    }

    public boolean isPlaying() {
        return isReady() && this.f12212f.isPlaying();
    }

    public boolean isReady() {
        State state = this.f12208b;
        return (state == State.ERROR || state == State.IDLE || state == State.PREPARING) ? false : true;
    }

    public void onSurfaceReady(Surface surface) throws IllegalStateException {
        this.f12212f.setSurface(surface);
        if (this.f12213g) {
            start();
        }
    }

    public void onSurfaceSizeChanged(int i10, int i11) throws IllegalStateException {
        if (this.f12212f == null || i10 <= 0 || i11 <= 0) {
            return;
        }
        long j10 = this.f12214h;
        if (j10 != 0) {
            seekTo(j10);
        }
        if (this.f12213g) {
            start();
        }
    }

    public void openVideo(Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (uri == null) {
            return;
        }
        this.f12215i = 0;
        try {
            this.f12212f.reset();
            this.f12212f.setDataSource(this.f12209c.getApplicationContext(), uri, this.f12207a);
            this.f12212f.prepareAsync();
            this.f12208b = State.PREPARING;
        } catch (IOException | IllegalArgumentException e10) {
            Log.w("ContentValues", "Unable to open content: " + uri, e10);
            this.f12208b = State.ERROR;
            this.f12217k.onError(this.f12212f, 1, 0);
        }
    }

    public void pause() throws IllegalStateException {
        if (isReady() && this.f12212f.isPlaying()) {
            this.f12212f.pause();
            this.f12208b = State.PAUSED;
        }
        this.f12213g = false;
    }

    public void seekTo(long j10) throws IllegalStateException {
        if (!isReady()) {
            this.f12214h = j10;
        } else {
            this.f12212f.seekTo((int) j10);
            this.f12214h = 0L;
        }
    }

    public void setListenerMux(c cVar) {
        this.f12216j = cVar;
        setOnCompletionListener(cVar);
        setOnPreparedListener(cVar);
        setOnBufferingUpdateListener(cVar);
        setOnSeekCompleteListener(cVar);
        setOnErrorListener(cVar);
    }

    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f12220n = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f12218l = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.f12222p = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.f12223q = onInfoListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f12219m = onPreparedListener;
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.f12221o = onSeekCompleteListener;
    }

    public void setVideoURI(Uri uri, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.f12207a = map;
        this.f12214h = 0L;
        this.f12213g = false;
        openVideo(uri);
    }

    public void start() throws IllegalStateException {
        if (isReady()) {
            this.f12212f.start();
            this.f12208b = State.PLAYING;
        }
        this.f12213g = true;
        this.f12216j.setNotifiedCompleted(false);
    }

    public void stopPlayback(boolean z10) throws IllegalStateException {
        this.f12208b = State.IDLE;
        if (isReady()) {
            try {
                this.f12212f.stop();
            } catch (Exception unused) {
            }
        }
        this.f12213g = false;
        if (z10) {
            this.f12216j.clearSurfaceWhenReady(this.f12211e);
        }
    }

    public void suspend() {
        this.f12208b = State.IDLE;
        try {
            this.f12212f.reset();
            this.f12212f.release();
        } catch (Exception unused) {
        }
        this.f12213g = false;
    }
}
