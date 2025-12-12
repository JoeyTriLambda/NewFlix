package u5;

import g5.m;
import l6.u;

/* compiled from: SampleMetadataQueue.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: i, reason: collision with root package name */
    public int f20065i;

    /* renamed from: j, reason: collision with root package name */
    public int f20066j;

    /* renamed from: k, reason: collision with root package name */
    public int f20067k;

    /* renamed from: l, reason: collision with root package name */
    public int f20068l;

    /* renamed from: q, reason: collision with root package name */
    public c5.i f20073q;

    /* renamed from: r, reason: collision with root package name */
    public int f20074r;

    /* renamed from: a, reason: collision with root package name */
    public int f20057a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public int[] f20058b = new int[1000];

    /* renamed from: c, reason: collision with root package name */
    public long[] f20059c = new long[1000];

    /* renamed from: f, reason: collision with root package name */
    public long[] f20062f = new long[1000];

    /* renamed from: e, reason: collision with root package name */
    public int[] f20061e = new int[1000];

    /* renamed from: d, reason: collision with root package name */
    public int[] f20060d = new int[1000];

    /* renamed from: g, reason: collision with root package name */
    public m.a[] f20063g = new m.a[1000];

    /* renamed from: h, reason: collision with root package name */
    public c5.i[] f20064h = new c5.i[1000];

    /* renamed from: m, reason: collision with root package name */
    public long f20069m = Long.MIN_VALUE;

    /* renamed from: n, reason: collision with root package name */
    public long f20070n = Long.MIN_VALUE;

    /* renamed from: p, reason: collision with root package name */
    public boolean f20072p = true;

    /* renamed from: o, reason: collision with root package name */
    public boolean f20071o = true;

    /* compiled from: SampleMetadataQueue.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f20075a;

        /* renamed from: b, reason: collision with root package name */
        public long f20076b;

        /* renamed from: c, reason: collision with root package name */
        public m.a f20077c;
    }

    public final long a(int i10) {
        this.f20069m = Math.max(this.f20069m, c(i10));
        int i11 = this.f20065i - i10;
        this.f20065i = i11;
        this.f20066j += i10;
        int i12 = this.f20067k + i10;
        this.f20067k = i12;
        int i13 = this.f20057a;
        if (i12 >= i13) {
            this.f20067k = i12 - i13;
        }
        int i14 = this.f20068l - i10;
        this.f20068l = i14;
        if (i14 < 0) {
            this.f20068l = 0;
        }
        if (i11 != 0) {
            return this.f20059c[this.f20067k];
        }
        int i15 = this.f20067k;
        if (i15 != 0) {
            i13 = i15;
        }
        return this.f20059c[i13 - 1] + this.f20060d[r2];
    }

    public synchronized boolean advanceTo(long j10, boolean z10, boolean z11) {
        int iD = d(this.f20068l);
        if (hasNextSample() && j10 >= this.f20062f[iD] && (j10 <= this.f20070n || z11)) {
            int iB = b(iD, this.f20065i - this.f20068l, j10, z10);
            if (iB == -1) {
                return false;
            }
            this.f20068l += iB;
            return true;
        }
        return false;
    }

    public synchronized void advanceToEnd() {
        if (hasNextSample()) {
            this.f20068l = this.f20065i;
        }
    }

    public synchronized boolean attemptSplice(long j10) {
        if (this.f20065i == 0) {
            return j10 > this.f20069m;
        }
        if (Math.max(this.f20069m, c(this.f20068l)) >= j10) {
            return false;
        }
        int i10 = this.f20065i;
        int iD = d(i10 - 1);
        while (i10 > this.f20068l && this.f20062f[iD] >= j10) {
            i10--;
            iD--;
            if (iD == -1) {
                iD = this.f20057a - 1;
            }
        }
        discardUpstreamSamples(this.f20066j + i10);
        return true;
    }

    public final int b(int i10, int i11, long j10, boolean z10) {
        int i12 = -1;
        for (int i13 = 0; i13 < i11 && this.f20062f[i10] <= j10; i13++) {
            if (!z10 || (this.f20061e[i10] & 1) != 0) {
                i12 = i13;
            }
            i10++;
            if (i10 == this.f20057a) {
                i10 = 0;
            }
        }
        return i12;
    }

    public final long c(int i10) {
        long jMax = Long.MIN_VALUE;
        if (i10 == 0) {
            return Long.MIN_VALUE;
        }
        int iD = d(i10 - 1);
        for (int i11 = 0; i11 < i10; i11++) {
            jMax = Math.max(jMax, this.f20062f[iD]);
            if ((this.f20061e[iD] & 1) != 0) {
                break;
            }
            iD--;
            if (iD == -1) {
                iD = this.f20057a - 1;
            }
        }
        return jMax;
    }

    public synchronized void commitSample(long j10, int i10, long j11, int i11, m.a aVar) {
        if (this.f20071o) {
            if ((i10 & 1) == 0) {
                return;
            } else {
                this.f20071o = false;
            }
        }
        l6.a.checkState(!this.f20072p);
        commitSampleTimestamp(j10);
        int iD = d(this.f20065i);
        this.f20062f[iD] = j10;
        long[] jArr = this.f20059c;
        jArr[iD] = j11;
        this.f20060d[iD] = i11;
        this.f20061e[iD] = i10;
        this.f20063g[iD] = aVar;
        this.f20064h[iD] = this.f20073q;
        this.f20058b[iD] = this.f20074r;
        int i12 = this.f20065i + 1;
        this.f20065i = i12;
        int i13 = this.f20057a;
        if (i12 == i13) {
            int i14 = i13 + 1000;
            int[] iArr = new int[i14];
            long[] jArr2 = new long[i14];
            long[] jArr3 = new long[i14];
            int[] iArr2 = new int[i14];
            int[] iArr3 = new int[i14];
            m.a[] aVarArr = new m.a[i14];
            c5.i[] iVarArr = new c5.i[i14];
            int i15 = this.f20067k;
            int i16 = i13 - i15;
            System.arraycopy(jArr, i15, jArr2, 0, i16);
            System.arraycopy(this.f20062f, this.f20067k, jArr3, 0, i16);
            System.arraycopy(this.f20061e, this.f20067k, iArr2, 0, i16);
            System.arraycopy(this.f20060d, this.f20067k, iArr3, 0, i16);
            System.arraycopy(this.f20063g, this.f20067k, aVarArr, 0, i16);
            System.arraycopy(this.f20064h, this.f20067k, iVarArr, 0, i16);
            System.arraycopy(this.f20058b, this.f20067k, iArr, 0, i16);
            int i17 = this.f20067k;
            System.arraycopy(this.f20059c, 0, jArr2, i16, i17);
            System.arraycopy(this.f20062f, 0, jArr3, i16, i17);
            System.arraycopy(this.f20061e, 0, iArr2, i16, i17);
            System.arraycopy(this.f20060d, 0, iArr3, i16, i17);
            System.arraycopy(this.f20063g, 0, aVarArr, i16, i17);
            System.arraycopy(this.f20064h, 0, iVarArr, i16, i17);
            System.arraycopy(this.f20058b, 0, iArr, i16, i17);
            this.f20059c = jArr2;
            this.f20062f = jArr3;
            this.f20061e = iArr2;
            this.f20060d = iArr3;
            this.f20063g = aVarArr;
            this.f20064h = iVarArr;
            this.f20058b = iArr;
            this.f20067k = 0;
            this.f20065i = this.f20057a;
            this.f20057a = i14;
        }
    }

    public synchronized void commitSampleTimestamp(long j10) {
        this.f20070n = Math.max(this.f20070n, j10);
    }

    public final int d(int i10) {
        int i11 = this.f20067k + i10;
        int i12 = this.f20057a;
        return i11 < i12 ? i11 : i11 - i12;
    }

    public synchronized long discardTo(long j10, boolean z10, boolean z11) {
        int i10;
        int i11 = this.f20065i;
        if (i11 != 0) {
            long[] jArr = this.f20062f;
            int i12 = this.f20067k;
            if (j10 >= jArr[i12]) {
                if (z11 && (i10 = this.f20068l) != i11) {
                    i11 = i10 + 1;
                }
                int iB = b(i12, i11, j10, z10);
                if (iB == -1) {
                    return -1L;
                }
                return a(iB);
            }
        }
        return -1L;
    }

    public synchronized long discardToEnd() {
        int i10 = this.f20065i;
        if (i10 == 0) {
            return -1L;
        }
        return a(i10);
    }

    public synchronized long discardToRead() {
        int i10 = this.f20068l;
        if (i10 == 0) {
            return -1L;
        }
        return a(i10);
    }

    public long discardUpstreamSamples(int i10) {
        int writeIndex = getWriteIndex() - i10;
        l6.a.checkArgument(writeIndex >= 0 && writeIndex <= this.f20065i - this.f20068l);
        int i11 = this.f20065i - writeIndex;
        this.f20065i = i11;
        this.f20070n = Math.max(this.f20069m, c(i11));
        int i12 = this.f20065i;
        if (i12 == 0) {
            return 0L;
        }
        return this.f20059c[d(i12 - 1)] + this.f20060d[r6];
    }

    public synchronized boolean format(c5.i iVar) {
        if (iVar == null) {
            this.f20072p = true;
            return false;
        }
        this.f20072p = false;
        if (u.areEqual(iVar, this.f20073q)) {
            return false;
        }
        this.f20073q = iVar;
        return true;
    }

    public synchronized long getLargestQueuedTimestampUs() {
        return this.f20070n;
    }

    public int getReadIndex() {
        return this.f20066j + this.f20068l;
    }

    public synchronized c5.i getUpstreamFormat() {
        return this.f20072p ? null : this.f20073q;
    }

    public int getWriteIndex() {
        return this.f20066j + this.f20065i;
    }

    public synchronized boolean hasNextSample() {
        return this.f20068l != this.f20065i;
    }

    public int peekSourceId() {
        return hasNextSample() ? this.f20058b[d(this.f20068l)] : this.f20074r;
    }

    public synchronized int read(c5.j jVar, e5.e eVar, boolean z10, boolean z11, c5.i iVar, a aVar) {
        if (!hasNextSample()) {
            if (z11) {
                eVar.setFlags(4);
                return -4;
            }
            c5.i iVar2 = this.f20073q;
            if (iVar2 == null || (!z10 && iVar2 == iVar)) {
                return -3;
            }
            jVar.f5130a = iVar2;
            return -5;
        }
        int iD = d(this.f20068l);
        if (!z10 && this.f20064h[iD] == iVar) {
            if (eVar.isFlagsOnly()) {
                return -3;
            }
            eVar.f11143o = this.f20062f[iD];
            eVar.setFlags(this.f20061e[iD]);
            aVar.f20075a = this.f20060d[iD];
            aVar.f20076b = this.f20059c[iD];
            aVar.f20077c = this.f20063g[iD];
            this.f20068l++;
            return -4;
        }
        jVar.f5130a = this.f20064h[iD];
        return -5;
    }

    public void reset(boolean z10) {
        this.f20065i = 0;
        this.f20066j = 0;
        this.f20067k = 0;
        this.f20068l = 0;
        this.f20071o = true;
        this.f20069m = Long.MIN_VALUE;
        this.f20070n = Long.MIN_VALUE;
        if (z10) {
            this.f20073q = null;
            this.f20072p = true;
        }
    }

    public synchronized void rewind() {
        this.f20068l = 0;
    }

    public void sourceId(int i10) {
        this.f20074r = i10;
    }
}
