package k6;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import k6.c;
import l6.o;
import l6.q;

/* compiled from: DefaultBandwidthMeter.java */
/* loaded from: classes.dex */
public final class h implements c, n<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final o f14974a;

    /* renamed from: b, reason: collision with root package name */
    public final l6.b f14975b;

    /* renamed from: c, reason: collision with root package name */
    public int f14976c;

    /* renamed from: d, reason: collision with root package name */
    public long f14977d;

    /* renamed from: e, reason: collision with root package name */
    public long f14978e;

    /* renamed from: f, reason: collision with root package name */
    public long f14979f;

    /* renamed from: g, reason: collision with root package name */
    public long f14980g;

    /* renamed from: h, reason: collision with root package name */
    public long f14981h;

    public h() {
        this(null, null);
    }

    public synchronized long getBitrateEstimate() {
        return this.f14981h;
    }

    public synchronized void onBytesTransferred(Object obj, int i10) {
        this.f14978e += i10;
    }

    public synchronized void onTransferEnd(Object obj) {
        l6.a.checkState(this.f14976c > 0);
        long jElapsedRealtime = ((q) this.f14975b).elapsedRealtime();
        int i10 = (int) (jElapsedRealtime - this.f14977d);
        this.f14979f += i10;
        long j10 = this.f14980g;
        long j11 = this.f14978e;
        this.f14980g = j10 + j11;
        if (i10 > 0) {
            this.f14974a.addSample((int) Math.sqrt(j11), (8000 * j11) / r5);
            if (this.f14979f >= 2000 || this.f14980g >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                float percentile = this.f14974a.getPercentile(0.5f);
                this.f14981h = Float.isNaN(percentile) ? -1L : (long) percentile;
            }
        }
        int i11 = this.f14976c - 1;
        this.f14976c = i11;
        if (i11 > 0) {
            this.f14977d = jElapsedRealtime;
        }
        this.f14978e = 0L;
    }

    public synchronized void onTransferStart(Object obj, f fVar) {
        if (this.f14976c == 0) {
            this.f14977d = ((q) this.f14975b).elapsedRealtime();
        }
        this.f14976c++;
    }

    public h(Handler handler, c.a aVar) {
        this(handler, aVar, 2000);
    }

    public h(Handler handler, c.a aVar, int i10) {
        this(handler, aVar, i10, l6.b.f15845a);
    }

    public h(Handler handler, c.a aVar, int i10, l6.b bVar) {
        this.f14974a = new o(i10);
        this.f14975b = bVar;
        this.f14981h = -1L;
    }
}
