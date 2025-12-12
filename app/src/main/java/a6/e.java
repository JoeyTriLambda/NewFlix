package a6;

import a6.b;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import c5.g;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a;
import java.io.IOException;
import java.util.ArrayList;
import k6.d;
import k6.m;
import l6.u;
import u5.a;
import u5.h;

/* compiled from: SsMediaSource.java */
/* loaded from: classes.dex */
public final class e implements h, Loader.a<com.google.android.exoplayer2.upstream.a<com.google.android.exoplayer2.source.smoothstreaming.manifest.a>> {

    /* renamed from: b, reason: collision with root package name */
    public final Uri f353b;

    /* renamed from: m, reason: collision with root package name */
    public final d.a f354m;

    /* renamed from: n, reason: collision with root package name */
    public final b.a f355n;

    /* renamed from: o, reason: collision with root package name */
    public final int f356o;

    /* renamed from: p, reason: collision with root package name */
    public final long f357p;

    /* renamed from: q, reason: collision with root package name */
    public final a.C0284a f358q;

    /* renamed from: r, reason: collision with root package name */
    public final a.InterfaceC0074a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> f359r;

    /* renamed from: s, reason: collision with root package name */
    public final ArrayList<c> f360s;

    /* renamed from: t, reason: collision with root package name */
    public h.a f361t;

    /* renamed from: u, reason: collision with root package name */
    public k6.d f362u;

    /* renamed from: v, reason: collision with root package name */
    public Loader f363v;

    /* renamed from: w, reason: collision with root package name */
    public m f364w;

    /* renamed from: x, reason: collision with root package name */
    public long f365x;

    /* renamed from: y, reason: collision with root package name */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a f366y;

    /* renamed from: z, reason: collision with root package name */
    public Handler f367z;

    static {
        c5.h.registerModule("goog.exo.smoothstreaming");
    }

    public e(Uri uri, d.a aVar, b.a aVar2, Handler handler, u5.a aVar3) {
        this(uri, aVar, aVar2, 3, 30000L, handler, aVar3);
    }

    public final void a() {
        u5.m mVar;
        int i10 = 0;
        while (true) {
            ArrayList<c> arrayList = this.f360s;
            if (i10 >= arrayList.size()) {
                break;
            }
            arrayList.get(i10).updateManifest(this.f366y);
            i10++;
        }
        long jMax = Long.MIN_VALUE;
        long jMax2 = Long.MAX_VALUE;
        for (a.b bVar : this.f366y.f5995c) {
            if (bVar.f6003d > 0) {
                jMax2 = Math.min(jMax2, bVar.getStartTimeUs(0));
                int i11 = bVar.f6003d;
                jMax = Math.max(jMax, bVar.getChunkDurationUs(i11 - 1) + bVar.getStartTimeUs(i11 - 1));
            }
        }
        if (jMax2 == Long.MAX_VALUE) {
            mVar = new u5.m(this.f366y.f5993a ? -9223372036854775807L : 0L, 0L, 0L, 0L, true, this.f366y.f5993a);
        } else {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.f366y;
            if (aVar.f5993a) {
                long j10 = aVar.f5997e;
                if (j10 != -9223372036854775807L && j10 > 0) {
                    jMax2 = Math.max(jMax2, jMax - j10);
                }
                long j11 = jMax2;
                long j12 = jMax - j11;
                long jMsToUs = j12 - c5.b.msToUs(this.f357p);
                if (jMsToUs < 5000000) {
                    jMsToUs = Math.min(5000000L, j12 / 2);
                }
                mVar = new u5.m(-9223372036854775807L, j12, j11, jMsToUs, true, true);
            } else {
                long j13 = aVar.f5996d;
                long j14 = j13 != -9223372036854775807L ? j13 : jMax - jMax2;
                mVar = new u5.m(jMax2 + j14, j14, jMax2, 0L, true, false);
            }
        }
        ((g) this.f361t).onSourceInfoRefreshed(mVar, this.f366y);
    }

    public final void b() {
        com.google.android.exoplayer2.upstream.a aVar = new com.google.android.exoplayer2.upstream.a(this.f362u, this.f353b, 4, this.f359r);
        long jStartLoading = this.f363v.startLoading(aVar, this, this.f356o);
        this.f358q.loadStarted(aVar.f6042a, aVar.f6043b, jStartLoading);
    }

    @Override // u5.h
    public u5.g createPeriod(h.b bVar, k6.b bVar2) {
        l6.a.checkArgument(bVar.f20054a == 0);
        c cVar = new c(this.f366y, this.f355n, this.f356o, this.f358q, this.f364w, bVar2);
        this.f360s.add(cVar);
        return cVar;
    }

    @Override // u5.h
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.f364w.maybeThrowError();
    }

    @Override // u5.h
    public void prepareSource(c5.d dVar, boolean z10, h.a aVar) {
        this.f361t = aVar;
        if (this.f366y != null) {
            this.f364w = new m.a();
            a();
            return;
        }
        this.f362u = this.f354m.createDataSource();
        Loader loader = new Loader("Loader:Manifest");
        this.f363v = loader;
        this.f364w = loader;
        this.f367z = new Handler();
        b();
    }

    @Override // u5.h
    public void releasePeriod(u5.g gVar) {
        ((c) gVar).release();
        this.f360s.remove(gVar);
    }

    @Override // u5.h
    public void releaseSource() {
        this.f361t = null;
        this.f366y = null;
        this.f362u = null;
        this.f365x = 0L;
        Loader loader = this.f363v;
        if (loader != null) {
            loader.release();
            this.f363v = null;
        }
        Handler handler = this.f367z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f367z = null;
        }
    }

    public e(Uri uri, d.a aVar, b.a aVar2, int i10, long j10, Handler handler, u5.a aVar3) {
        this(uri, aVar, new SsManifestParser(), aVar2, i10, j10, handler, aVar3);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void onLoadCanceled(com.google.android.exoplayer2.upstream.a<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> aVar, long j10, long j11, boolean z10) {
        this.f358q.loadCompleted(aVar.f6042a, aVar.f6043b, j10, j11, aVar.bytesLoaded());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void onLoadCompleted(com.google.android.exoplayer2.upstream.a<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> aVar, long j10, long j11) {
        this.f358q.loadCompleted(aVar.f6042a, aVar.f6043b, j10, j11, aVar.bytesLoaded());
        this.f366y = aVar.getResult();
        this.f365x = j10 - j11;
        a();
        if (this.f366y.f5993a) {
            this.f367z.postDelayed(new d(this), Math.max(0L, (this.f365x + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int onLoadError(com.google.android.exoplayer2.upstream.a<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> aVar, long j10, long j11, IOException iOException) {
        boolean z10 = iOException instanceof ParserException;
        this.f358q.loadError(aVar.f6042a, aVar.f6043b, j10, j11, aVar.bytesLoaded(), iOException, z10);
        return z10 ? 3 : 0;
    }

    public e(Uri uri, d.a aVar, a.InterfaceC0074a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> interfaceC0074a, b.a aVar2, int i10, long j10, Handler handler, u5.a aVar3) {
        l6.a.checkState(true);
        this.f366y = null;
        if (uri == null) {
            uri = null;
        } else if (!u.toLowerInvariant(uri.getLastPathSegment()).equals("manifest")) {
            uri = Uri.withAppendedPath(uri, "Manifest");
        }
        this.f353b = uri;
        this.f354m = aVar;
        this.f359r = interfaceC0074a;
        this.f355n = aVar2;
        this.f356o = i10;
        this.f357p = j10;
        this.f358q = new a.C0284a(handler, aVar3);
        this.f360s = new ArrayList<>();
    }
}
