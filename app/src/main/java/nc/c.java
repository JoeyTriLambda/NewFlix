package nc;

import android.media.MediaPlayer;
import android.os.Handler;
import flix.com.vision.exomedia.core.exception.NativeMediaPlaybackException;
import java.lang.ref.WeakReference;
import xc.d;
import xc.e;

/* compiled from: ListenerMux.java */
/* loaded from: classes2.dex */
public final class c implements qc.a, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, xc.a, qc.b {

    /* renamed from: m, reason: collision with root package name */
    public final a f16787m;

    /* renamed from: n, reason: collision with root package name */
    public d f16788n;

    /* renamed from: o, reason: collision with root package name */
    public xc.b f16789o;

    /* renamed from: p, reason: collision with root package name */
    public xc.a f16790p;

    /* renamed from: q, reason: collision with root package name */
    public qc.a f16791q;

    /* renamed from: r, reason: collision with root package name */
    public e f16792r;

    /* renamed from: s, reason: collision with root package name */
    public xc.c f16793s;

    /* renamed from: t, reason: collision with root package name */
    public xc.c f16794t;

    /* renamed from: u, reason: collision with root package name */
    public qc.b f16795u;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f16786b = new Handler();

    /* renamed from: v, reason: collision with root package name */
    public WeakReference<uc.a> f16796v = new WeakReference<>(null);

    /* renamed from: w, reason: collision with root package name */
    public boolean f16797w = false;

    /* renamed from: x, reason: collision with root package name */
    public boolean f16798x = false;

    /* renamed from: y, reason: collision with root package name */
    public boolean f16799y = false;

    public c(a aVar) {
        this.f16787m = aVar;
    }

    public void clearSurfaceWhenReady(uc.a aVar) {
        this.f16799y = true;
        this.f16796v = new WeakReference<>(aVar);
    }

    public boolean isPrepared() {
        return this.f16797w;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
        onBufferingUpdate(i10);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        xc.b bVar = this.f16789o;
        if (bVar != null) {
            bVar.onCompletion();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        NativeMediaPlaybackException nativeMediaPlaybackException = new NativeMediaPlaybackException(i10, i11);
        xc.c cVar = this.f16793s;
        return cVar != null && cVar.onError(nativeMediaPlaybackException);
    }

    @Override // qc.b
    public void onMetadata(q5.a aVar) {
        qc.b bVar = this.f16795u;
        if (bVar != null) {
            bVar.onMetadata(aVar);
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f16797w = true;
        this.f16786b.post(new nc.a(this));
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        e eVar = this.f16792r;
        if (eVar != null) {
            eVar.onSeekComplete();
        }
    }

    @Override // qc.a
    public void onStateChanged(boolean z10, int i10) {
        Handler handler = this.f16786b;
        a aVar = this.f16787m;
        if (i10 == 4) {
            aVar.onMediaPlaybackEnded();
            if (!this.f16798x && aVar.shouldNotifyCompletion(1000L)) {
                this.f16798x = true;
                handler.post(new b(this));
            }
        } else if (i10 == 3 && !this.f16797w) {
            this.f16797w = true;
            handler.post(new nc.a(this));
        }
        if (i10 == 3 && z10) {
            aVar.onPreviewImageStateChanged(false);
        }
        if (i10 == 1 && this.f16799y) {
            this.f16799y = false;
            uc.a aVar2 = this.f16796v.get();
            if (aVar2 != null) {
                aVar2.clearSurface();
                this.f16796v = new WeakReference<>(null);
            }
        }
        qc.a aVar3 = this.f16791q;
        if (aVar3 != null) {
            aVar3.onStateChanged(z10, i10);
        }
    }

    @Override // qc.a
    public void onVideoSizeChanged(int i10, int i11, int i12, float f10) {
        this.f16787m.onVideoSizeChanged(i10, i11, i12);
    }

    public void setMetadataListener(qc.b bVar) {
        this.f16795u = bVar;
    }

    public void setNotifiedCompleted(boolean z10) {
        this.f16798x = z10;
    }

    public void setNotifiedPrepared(boolean z10) {
        this.f16797w = z10;
        this.f16787m.onPreviewImageStateChanged(true);
    }

    public void setOnBufferUpdateListener(xc.a aVar) {
        this.f16790p = aVar;
    }

    public void setOnCompletionListener(xc.b bVar) {
        this.f16789o = bVar;
    }

    public void setOnErrorListener(xc.c cVar) {
        this.f16793s = cVar;
    }

    public void setOnExoBufferUpdateListener(qc.a aVar) {
        this.f16791q = aVar;
    }

    public void setOnExoErrorListener(xc.c cVar) {
        this.f16794t = cVar;
    }

    public void setOnPreparedListener(d dVar) {
        this.f16788n = dVar;
    }

    public void setOnSeekCompletionListener(e eVar) {
        this.f16792r = eVar;
    }

    @Override // xc.a
    public void onBufferingUpdate(int i10) {
        this.f16787m.onBufferUpdated();
        xc.a aVar = this.f16790p;
        if (aVar != null) {
            aVar.onBufferingUpdate(i10);
        }
    }

    @Override // qc.a
    public void onError(pc.a aVar, Exception exc) {
        a aVar2 = this.f16787m;
        aVar2.onMediaPlaybackEnded();
        aVar2.onExoPlayerError(aVar);
        xc.c cVar = this.f16794t;
        if (cVar != null) {
            cVar.onError(exc);
        }
        xc.c cVar2 = this.f16793s;
        if (cVar2 != null) {
            cVar2.onError(exc);
        }
    }

    @Override // xc.e
    public void onSeekComplete() {
        this.f16787m.onSeekComplete();
        e eVar = this.f16792r;
        if (eVar != null) {
            eVar.onSeekComplete();
        }
    }

    /* compiled from: ListenerMux.java */
    public static abstract class a {
        public abstract void onExoPlayerError(pc.a aVar);

        public abstract void onMediaPlaybackEnded();

        public abstract void onPrepared();

        public abstract void onPreviewImageStateChanged(boolean z10);

        public abstract void onSeekComplete();

        public abstract void onVideoSizeChanged(int i10, int i11, int i12);

        public abstract boolean shouldNotifyCompletion(long j10);

        public void onBufferUpdated() {
        }
    }
}
