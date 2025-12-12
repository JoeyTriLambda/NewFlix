package u5;

import java.io.IOException;
import u5.g;

/* compiled from: ClippingMediaPeriod.java */
/* loaded from: classes.dex */
public final class b implements g, g.a {

    /* renamed from: b, reason: collision with root package name */
    public final g f19999b;

    /* renamed from: m, reason: collision with root package name */
    public g.a f20000m;

    /* renamed from: n, reason: collision with root package name */
    public long f20001n = -9223372036854775807L;

    /* renamed from: o, reason: collision with root package name */
    public long f20002o = -9223372036854775807L;

    /* renamed from: p, reason: collision with root package name */
    public a[] f20003p = new a[0];

    /* renamed from: q, reason: collision with root package name */
    public boolean f20004q;

    /* compiled from: ClippingMediaPeriod.java */
    public static final class a implements k {

        /* renamed from: b, reason: collision with root package name */
        public final g f20005b;

        /* renamed from: m, reason: collision with root package name */
        public final k f20006m;

        /* renamed from: n, reason: collision with root package name */
        public final long f20007n;

        /* renamed from: o, reason: collision with root package name */
        public final long f20008o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f20009p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f20010q;

        public a(g gVar, k kVar, long j10, long j11, boolean z10) {
            this.f20005b = gVar;
            this.f20006m = kVar;
            this.f20007n = j10;
            this.f20008o = j11;
            this.f20009p = z10;
        }

        public void clearPendingDiscontinuity() {
            this.f20009p = false;
        }

        public void clearSentEos() {
            this.f20010q = false;
        }

        @Override // u5.k
        public boolean isReady() {
            return this.f20006m.isReady();
        }

        @Override // u5.k
        public void maybeThrowError() throws IOException {
            this.f20006m.maybeThrowError();
        }

        @Override // u5.k
        public int readData(c5.j jVar, e5.e eVar, boolean z10) {
            if (this.f20009p) {
                return -3;
            }
            if (this.f20010q) {
                eVar.setFlags(4);
                return -4;
            }
            int data = this.f20006m.readData(jVar, eVar, z10);
            long j10 = this.f20008o;
            if (j10 == Long.MIN_VALUE || ((data != -4 || eVar.f11143o < j10) && !(data == -3 && this.f20005b.getBufferedPositionUs() == Long.MIN_VALUE))) {
                if (data == -4 && !eVar.isEndOfStream()) {
                    eVar.f11143o -= this.f20007n;
                }
                return data;
            }
            eVar.clear();
            eVar.setFlags(4);
            this.f20010q = true;
            return -4;
        }

        @Override // u5.k
        public void skipData(long j10) {
            this.f20006m.skipData(this.f20007n + j10);
        }
    }

    public b(g gVar, boolean z10) {
        this.f19999b = gVar;
        this.f20004q = z10;
    }

    @Override // u5.g, u5.l
    public boolean continueLoading(long j10) {
        return this.f19999b.continueLoading(j10 + this.f20001n);
    }

    @Override // u5.g
    public void discardBuffer(long j10) {
        this.f19999b.discardBuffer(j10 + this.f20001n);
    }

    @Override // u5.g, u5.l
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.f19999b.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j10 = this.f20002o;
            if (j10 == Long.MIN_VALUE || bufferedPositionUs < j10) {
                return Math.max(0L, bufferedPositionUs - this.f20001n);
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // u5.g, u5.l
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.f19999b.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j10 = this.f20002o;
            if (j10 == Long.MIN_VALUE || nextLoadPositionUs < j10) {
                return nextLoadPositionUs - this.f20001n;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // u5.g
    public o getTrackGroups() {
        return this.f19999b.getTrackGroups();
    }

    @Override // u5.g
    public void maybeThrowPrepareError() throws IOException {
        this.f19999b.maybeThrowPrepareError();
    }

    @Override // u5.g.a
    public void onPrepared(g gVar) {
        l6.a.checkState((this.f20001n == -9223372036854775807L || this.f20002o == -9223372036854775807L) ? false : true);
        this.f20000m.onPrepared(this);
    }

    @Override // u5.g
    public void prepare(g.a aVar, long j10) {
        this.f20000m = aVar;
        this.f19999b.prepare(this, this.f20001n + j10);
    }

    @Override // u5.g
    public long readDiscontinuity() {
        if (!this.f20004q) {
            long discontinuity = this.f19999b.readDiscontinuity();
            if (discontinuity == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            l6.a.checkState(discontinuity >= this.f20001n);
            long j10 = this.f20002o;
            l6.a.checkState(j10 == Long.MIN_VALUE || discontinuity <= j10);
            return discontinuity - this.f20001n;
        }
        for (a aVar : this.f20003p) {
            if (aVar != null) {
                aVar.clearPendingDiscontinuity();
            }
        }
        this.f20004q = false;
        long discontinuity2 = readDiscontinuity();
        if (discontinuity2 != -9223372036854775807L) {
            return discontinuity2;
        }
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    @Override // u5.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long seekToUs(long r7) {
        /*
            r6 = this;
            u5.b$a[] r0 = r6.f20003p
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L5:
            if (r3 >= r1) goto L11
            r4 = r0[r3]
            if (r4 == 0) goto Le
            r4.clearSentEos()
        Le:
            int r3 = r3 + 1
            goto L5
        L11:
            long r0 = r6.f20001n
            long r0 = r0 + r7
            u5.g r3 = r6.f19999b
            long r0 = r3.seekToUs(r0)
            long r3 = r6.f20001n
            long r7 = r7 + r3
            int r5 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r5 == 0) goto L31
            int r7 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r7 < 0) goto L32
            long r7 = r6.f20002o
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L31
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L32
        L31:
            r2 = 1
        L32:
            l6.a.checkState(r2)
            long r7 = r6.f20001n
            long r0 = r0 - r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u5.b.seekToUs(long):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007d  */
    @Override // u5.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long selectTracks(j6.f[] r18, boolean[] r19, u5.k[] r20, boolean[] r21, long r22) {
        /*
            Method dump skipped, instructions count: 185
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: u5.b.selectTracks(j6.f[], boolean[], u5.k[], boolean[], long):long");
    }

    public void setClipping(long j10, long j11) {
        this.f20001n = j10;
        this.f20002o = j11;
    }

    @Override // u5.l.a
    public void onContinueLoadingRequested(g gVar) {
        this.f20000m.onContinueLoadingRequested(this);
    }
}
