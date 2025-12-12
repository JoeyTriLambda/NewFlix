package vc;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.exoplayer2.drm.f;
import flix.com.vision.exomedia.ExoMedia$RendererType;
import java.util.Map;
import nc.c;
import qc.b;
import u5.h;
import u5.o;

/* compiled from: ExoVideoDelegate.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public pc.a f20673a;

    /* renamed from: b, reason: collision with root package name */
    public c f20674b;

    /* renamed from: d, reason: collision with root package name */
    public final Context f20676d;

    /* renamed from: e, reason: collision with root package name */
    public final uc.a f20677e;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20675c = false;

    /* renamed from: f, reason: collision with root package name */
    public final C0298a f20678f = new C0298a();

    /* compiled from: ExoVideoDelegate.java */
    /* renamed from: vc.a$a, reason: collision with other inner class name */
    public class C0298a implements b, xc.a {
        public C0298a() {
        }

        @Override // xc.a
        public void onBufferingUpdate(int i10) {
            a.this.f20674b.onBufferingUpdate(i10);
        }

        @Override // qc.b
        public void onMetadata(q5.a aVar) {
            a.this.f20674b.onMetadata(aVar);
        }
    }

    public a(Context context, uc.a aVar) {
        this.f20676d = context.getApplicationContext();
        this.f20677e = aVar;
        setup();
    }

    public Map<ExoMedia$RendererType, o> getAvailableTracks() {
        return this.f20673a.getAvailableTracks();
    }

    public int getBufferedPercent() {
        return this.f20673a.getBufferedPercentage();
    }

    public long getCurrentPosition() {
        if (this.f20674b.isPrepared()) {
            return this.f20673a.getCurrentPosition();
        }
        return 0L;
    }

    public long getDuration() {
        if (this.f20674b.isPrepared()) {
            return this.f20673a.getDuration();
        }
        return 0L;
    }

    public void initExoPlayer() {
        pc.a aVar = new pc.a(this.f20676d);
        this.f20673a = aVar;
        C0298a c0298a = this.f20678f;
        aVar.setMetadataListener(c0298a);
        this.f20673a.setBufferUpdateListener(c0298a);
    }

    public boolean isPlaying() {
        return this.f20673a.getPlayWhenReady();
    }

    public void onSurfaceDestroyed() {
        this.f20673a.blockingClearSurface();
    }

    public void onSurfaceReady(Surface surface) {
        this.f20673a.setSurface(surface);
        if (this.f20675c) {
            this.f20673a.setPlayWhenReady(true);
        }
    }

    public void pause() {
        this.f20673a.setPlayWhenReady(false);
        this.f20675c = false;
    }

    public void release() {
        this.f20673a.release();
    }

    public void seekTo(long j10) {
        this.f20673a.seekTo(j10);
    }

    public void setDrmCallback(f fVar) {
        this.f20673a.setDrmCallback(fVar);
    }

    public void setListenerMux(c cVar) {
        c cVar2 = this.f20674b;
        if (cVar2 != null) {
            this.f20673a.removeListener(cVar2);
        }
        this.f20674b = cVar;
        this.f20673a.addListener(cVar);
    }

    public void setVideoUri(Uri uri) {
        setVideoUri(uri, null);
    }

    public boolean setVolume(float f10) {
        this.f20673a.setVolume(f10);
        return true;
    }

    public void setup() {
        initExoPlayer();
    }

    public void start() {
        this.f20673a.setPlayWhenReady(true);
        this.f20674b.setNotifiedCompleted(false);
        this.f20675c = true;
    }

    public void stopPlayback(boolean z10) {
        this.f20673a.stop();
        this.f20675c = false;
        if (z10) {
            this.f20674b.clearSurfaceWhenReady(this.f20677e);
        }
    }

    public void setVideoUri(Uri uri, h hVar) {
        this.f20674b.setNotifiedPrepared(false);
        this.f20673a.seekTo(0L);
        if (hVar != null) {
            this.f20673a.setMediaSource(hVar);
            this.f20674b.setNotifiedCompleted(false);
        } else if (uri == null) {
            this.f20673a.setMediaSource(null);
        } else {
            this.f20673a.setUri(uri);
            this.f20674b.setNotifiedCompleted(false);
        }
    }
}
