package y5;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.upstream.a;
import java.io.IOException;
import java.util.List;
import k6.d;
import u5.a;
import u5.h;
import u5.m;

/* compiled from: HlsMediaSource.java */
/* loaded from: classes.dex */
public final class h implements u5.h, HlsPlaylistTracker.c {

    /* renamed from: b, reason: collision with root package name */
    public final Uri f21971b;

    /* renamed from: m, reason: collision with root package name */
    public final d f21972m;

    /* renamed from: n, reason: collision with root package name */
    public final int f21973n;

    /* renamed from: o, reason: collision with root package name */
    public final a.C0284a f21974o;

    /* renamed from: p, reason: collision with root package name */
    public final a.InterfaceC0074a<z5.a> f21975p;

    /* renamed from: q, reason: collision with root package name */
    public HlsPlaylistTracker f21976q;

    /* renamed from: r, reason: collision with root package name */
    public h.a f21977r;

    static {
        c5.h.registerModule("goog.exo.hls");
    }

    public h(Uri uri, d.a aVar, Handler handler, u5.a aVar2) {
        this(uri, aVar, 3, handler, aVar2);
    }

    @Override // u5.h
    public u5.g createPeriod(h.b bVar, k6.b bVar2) {
        l6.a.checkArgument(bVar.f20054a == 0);
        return new g(this.f21976q, this.f21972m, this.f21973n, this.f21974o, bVar2);
    }

    @Override // u5.h
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.f21976q.maybeThrowPrimaryPlaylistRefreshError();
    }

    public void onPrimaryPlaylistRefreshed(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        m mVar;
        long j10;
        boolean z10 = bVar.f5923m;
        long j11 = z10 ? 0L : -9223372036854775807L;
        long j12 = bVar.f5915e;
        long jUsToMs = z10 ? c5.b.usToMs(j12) : -9223372036854775807L;
        boolean zIsLive = this.f21976q.isLive();
        long j13 = bVar.f5914d;
        if (zIsLive) {
            boolean z11 = bVar.f5922l;
            long j14 = z11 ? j12 + bVar.f5926p : -9223372036854775807L;
            if (j13 == -9223372036854775807L) {
                List<b.a> list = bVar.f5925o;
                j10 = list.isEmpty() ? 0L : list.get(Math.max(0, list.size() - 3)).f5930o;
            } else {
                j10 = j13;
            }
            mVar = new m(j11, jUsToMs, j14, bVar.f5926p, bVar.f5915e, j10, true, !z11);
        } else {
            long j15 = j13 == -9223372036854775807L ? 0L : j13;
            long j16 = bVar.f5915e;
            long j17 = bVar.f5926p;
            mVar = new m(j11, jUsToMs, j16 + j17, j17, j16, j15, true, false);
        }
        ((c5.g) this.f21977r).onSourceInfoRefreshed(mVar, new e(this.f21976q.getMasterPlaylist(), bVar));
    }

    @Override // u5.h
    public void prepareSource(c5.d dVar, boolean z10, h.a aVar) {
        l6.a.checkState(this.f21976q == null);
        HlsPlaylistTracker hlsPlaylistTracker = new HlsPlaylistTracker(this.f21971b, this.f21972m, this.f21974o, this.f21973n, this, this.f21975p);
        this.f21976q = hlsPlaylistTracker;
        this.f21977r = aVar;
        hlsPlaylistTracker.start();
    }

    @Override // u5.h
    public void releasePeriod(u5.g gVar) {
        ((g) gVar).release();
    }

    @Override // u5.h
    public void releaseSource() {
        HlsPlaylistTracker hlsPlaylistTracker = this.f21976q;
        if (hlsPlaylistTracker != null) {
            hlsPlaylistTracker.release();
            this.f21976q = null;
        }
        this.f21977r = null;
    }

    public h(Uri uri, d.a aVar, int i10, Handler handler, u5.a aVar2) {
        this(uri, new b(aVar), i10, handler, aVar2);
    }

    public h(Uri uri, d dVar, int i10, Handler handler, u5.a aVar) {
        this(uri, dVar, i10, handler, aVar, new com.google.android.exoplayer2.source.hls.playlist.c());
    }

    public h(Uri uri, d dVar, int i10, Handler handler, u5.a aVar, a.InterfaceC0074a<z5.a> interfaceC0074a) {
        this.f21971b = uri;
        this.f21972m = dVar;
        this.f21973n = i10;
        this.f21975p = interfaceC0074a;
        this.f21974o = new a.C0284a(handler, aVar);
    }
}
