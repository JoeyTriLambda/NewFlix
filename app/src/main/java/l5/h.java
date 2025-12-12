package l5;

import g5.l;
import g5.m;
import java.io.IOException;
import l5.b;

/* compiled from: StreamReader.java */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public final d f15810a = new d();

    /* renamed from: b, reason: collision with root package name */
    public m f15811b;

    /* renamed from: c, reason: collision with root package name */
    public g5.g f15812c;

    /* renamed from: d, reason: collision with root package name */
    public f f15813d;

    /* renamed from: e, reason: collision with root package name */
    public long f15814e;

    /* renamed from: f, reason: collision with root package name */
    public long f15815f;

    /* renamed from: g, reason: collision with root package name */
    public long f15816g;

    /* renamed from: h, reason: collision with root package name */
    public int f15817h;

    /* renamed from: i, reason: collision with root package name */
    public int f15818i;

    /* renamed from: j, reason: collision with root package name */
    public a f15819j;

    /* renamed from: k, reason: collision with root package name */
    public long f15820k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f15821l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15822m;

    /* compiled from: StreamReader.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public c5.i f15823a;

        /* renamed from: b, reason: collision with root package name */
        public b.a f15824b;
    }

    /* compiled from: StreamReader.java */
    public static final class b implements f {
        @Override // l5.f
        public l createSeekMap() {
            return new l.a(-9223372036854775807L);
        }

        @Override // l5.f
        public long read(g5.f fVar) throws InterruptedException, IOException {
            return -1L;
        }

        @Override // l5.f
        public long startSeek(long j10) {
            return 0L;
        }
    }

    public long convertGranuleToTime(long j10) {
        return (j10 * 1000000) / this.f15818i;
    }

    public long convertTimeToGranule(long j10) {
        return (this.f15818i * j10) / 1000000;
    }

    public void onSeekEnd(long j10) {
        this.f15816g = j10;
    }

    public abstract long preparePayload(l6.l lVar);

    public abstract boolean readHeaders(l6.l lVar, long j10, a aVar) throws InterruptedException, IOException;

    public void reset(boolean z10) {
        if (z10) {
            this.f15819j = new a();
            this.f15815f = 0L;
            this.f15817h = 0;
        } else {
            this.f15817h = 1;
        }
        this.f15814e = -1L;
        this.f15816g = 0L;
    }
}
