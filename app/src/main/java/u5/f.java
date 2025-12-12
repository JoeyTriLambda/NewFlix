package u5;

import android.net.Uri;
import android.os.Handler;
import c5.r;
import java.io.IOException;
import k6.d;
import u5.e;
import u5.h;

/* compiled from: ExtractorMediaSource.java */
/* loaded from: classes.dex */
public final class f implements h, e.InterfaceC0285e {

    /* renamed from: b, reason: collision with root package name */
    public final Uri f20044b;

    /* renamed from: m, reason: collision with root package name */
    public final d.a f20045m;

    /* renamed from: n, reason: collision with root package name */
    public final g5.h f20046n;

    /* renamed from: o, reason: collision with root package name */
    public final int f20047o;

    /* renamed from: p, reason: collision with root package name */
    public final Handler f20048p;

    /* renamed from: q, reason: collision with root package name */
    public final String f20049q;

    /* renamed from: r, reason: collision with root package name */
    public final int f20050r;

    /* renamed from: s, reason: collision with root package name */
    public h.a f20051s;

    /* renamed from: t, reason: collision with root package name */
    public long f20052t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f20053u;

    /* compiled from: ExtractorMediaSource.java */
    public interface a {
    }

    public f(Uri uri, d.a aVar, g5.h hVar, Handler handler, a aVar2) {
        this(uri, aVar, hVar, handler, aVar2, null);
    }

    @Override // u5.h
    public g createPeriod(h.b bVar, k6.b bVar2) {
        l6.a.checkArgument(bVar.f20054a == 0);
        return new e(this.f20044b, this.f20045m.createDataSource(), this.f20046n.createExtractors(), this.f20047o, this.f20048p, null, this, bVar2, this.f20049q, this.f20050r);
    }

    public void onSourceInfoRefreshed(long j10, boolean z10) {
        if (j10 == -9223372036854775807L) {
            j10 = this.f20052t;
        }
        long j11 = this.f20052t;
        if (j11 == j10 && this.f20053u == z10) {
            return;
        }
        if (j11 == -9223372036854775807L || j10 != -9223372036854775807L) {
            this.f20052t = j10;
            this.f20053u = z10;
            ((c5.g) this.f20051s).onSourceInfoRefreshed(new m(this.f20052t, this.f20053u), null);
        }
    }

    @Override // u5.h
    public void prepareSource(c5.d dVar, boolean z10, h.a aVar) {
        this.f20051s = aVar;
        this.f20052t = -9223372036854775807L;
        this.f20053u = false;
        ((c5.g) aVar).onSourceInfoRefreshed(new m(this.f20052t, this.f20053u), null);
    }

    @Override // u5.h
    public void releasePeriod(g gVar) {
        ((e) gVar).release();
    }

    @Override // u5.h
    public void releaseSource() {
        this.f20051s = null;
    }

    public f(Uri uri, d.a aVar, g5.h hVar, Handler handler, a aVar2, String str) {
        this(uri, aVar, hVar, -1, handler, aVar2, str, 1048576);
    }

    public f(Uri uri, d.a aVar, g5.h hVar, int i10, Handler handler, a aVar2, String str, int i11) {
        this.f20044b = uri;
        this.f20045m = aVar;
        this.f20046n = hVar;
        this.f20047o = i10;
        this.f20048p = handler;
        this.f20049q = str;
        this.f20050r = i11;
        new r.b();
    }

    @Override // u5.h
    public void maybeThrowSourceInfoRefreshError() throws IOException {
    }
}
