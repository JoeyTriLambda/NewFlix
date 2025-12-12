package u5;

import g5.m;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import u5.i;

/* compiled from: SampleQueue.java */
/* loaded from: classes.dex */
public final class j implements g5.m {

    /* renamed from: a, reason: collision with root package name */
    public final k6.b f20078a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20079b;

    /* renamed from: c, reason: collision with root package name */
    public final i f20080c;

    /* renamed from: d, reason: collision with root package name */
    public final i.a f20081d;

    /* renamed from: e, reason: collision with root package name */
    public final l6.l f20082e;

    /* renamed from: f, reason: collision with root package name */
    public a f20083f;

    /* renamed from: g, reason: collision with root package name */
    public a f20084g;

    /* renamed from: h, reason: collision with root package name */
    public a f20085h;

    /* renamed from: i, reason: collision with root package name */
    public c5.i f20086i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20087j;

    /* renamed from: k, reason: collision with root package name */
    public c5.i f20088k;

    /* renamed from: l, reason: collision with root package name */
    public long f20089l;

    /* renamed from: m, reason: collision with root package name */
    public long f20090m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f20091n;

    /* renamed from: o, reason: collision with root package name */
    public b f20092o;

    /* compiled from: SampleQueue.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f20093a;

        /* renamed from: b, reason: collision with root package name */
        public final long f20094b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f20095c;

        /* renamed from: d, reason: collision with root package name */
        public k6.a f20096d;

        /* renamed from: e, reason: collision with root package name */
        public a f20097e;

        public a(long j10, int i10) {
            this.f20093a = j10;
            this.f20094b = j10 + i10;
        }

        public a clear() {
            this.f20096d = null;
            a aVar = this.f20097e;
            this.f20097e = null;
            return aVar;
        }

        public void initialize(k6.a aVar, a aVar2) {
            this.f20096d = aVar;
            this.f20097e = aVar2;
            this.f20095c = true;
        }

        public int translateOffset(long j10) {
            return ((int) (j10 - this.f20093a)) + this.f20096d.f14952b;
        }
    }

    /* compiled from: SampleQueue.java */
    public interface b {
        void onUpstreamFormatChanged(c5.i iVar);
    }

    public j(k6.b bVar) {
        this.f20078a = bVar;
        int individualAllocationLength = ((k6.g) bVar).getIndividualAllocationLength();
        this.f20079b = individualAllocationLength;
        this.f20080c = new i();
        this.f20081d = new i.a();
        this.f20082e = new l6.l(32);
        a aVar = new a(0L, individualAllocationLength);
        this.f20083f = aVar;
        this.f20084g = aVar;
        this.f20085h = aVar;
    }

    public final void a(a aVar) {
        if (aVar.f20095c) {
            a aVar2 = this.f20085h;
            int i10 = (((int) (aVar2.f20093a - aVar.f20093a)) / this.f20079b) + (aVar2.f20095c ? 1 : 0);
            k6.a[] aVarArr = new k6.a[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                aVarArr[i11] = aVar.f20096d;
                aVar = aVar.clear();
            }
            ((k6.g) this.f20078a).release(aVarArr);
        }
    }

    public boolean advanceTo(long j10, boolean z10, boolean z11) {
        return this.f20080c.advanceTo(j10, z10, z11);
    }

    public void advanceToEnd() {
        this.f20080c.advanceToEnd();
    }

    public final void b(long j10) {
        a aVar;
        if (j10 == -1) {
            return;
        }
        while (true) {
            aVar = this.f20083f;
            if (j10 < aVar.f20094b) {
                break;
            }
            ((k6.g) this.f20078a).release(aVar.f20096d);
            this.f20083f = this.f20083f.clear();
        }
        if (this.f20084g.f20093a < aVar.f20093a) {
            this.f20084g = aVar;
        }
    }

    public final int c(int i10) {
        a aVar = this.f20085h;
        if (!aVar.f20095c) {
            aVar.initialize(((k6.g) this.f20078a).allocate(), new a(this.f20085h.f20094b, this.f20079b));
        }
        return Math.min(i10, (int) (this.f20085h.f20094b - this.f20090m));
    }

    public final void d(long j10, byte[] bArr, int i10) {
        while (true) {
            a aVar = this.f20084g;
            if (j10 < aVar.f20094b) {
                break;
            } else {
                this.f20084g = aVar.f20097e;
            }
        }
        int i11 = i10;
        while (i11 > 0) {
            int iMin = Math.min(i11, (int) (this.f20084g.f20094b - j10));
            a aVar2 = this.f20084g;
            System.arraycopy(aVar2.f20096d.f14951a, aVar2.translateOffset(j10), bArr, i10 - i11, iMin);
            i11 -= iMin;
            j10 += iMin;
            a aVar3 = this.f20084g;
            if (j10 == aVar3.f20094b) {
                this.f20084g = aVar3.f20097e;
            }
        }
    }

    public void discardTo(long j10, boolean z10, boolean z11) {
        b(this.f20080c.discardTo(j10, z10, z11));
    }

    public void discardToEnd() {
        b(this.f20080c.discardToEnd());
    }

    public void discardToRead() {
        b(this.f20080c.discardToRead());
    }

    public void discardUpstreamSamples(int i10) {
        long jDiscardUpstreamSamples = this.f20080c.discardUpstreamSamples(i10);
        this.f20090m = jDiscardUpstreamSamples;
        int i11 = this.f20079b;
        if (jDiscardUpstreamSamples != 0) {
            a aVar = this.f20083f;
            if (jDiscardUpstreamSamples != aVar.f20093a) {
                while (this.f20090m > aVar.f20094b) {
                    aVar = aVar.f20097e;
                }
                a aVar2 = aVar.f20097e;
                a(aVar2);
                long j10 = aVar.f20094b;
                a aVar3 = new a(j10, i11);
                aVar.f20097e = aVar3;
                if (this.f20090m == j10) {
                    aVar = aVar3;
                }
                this.f20085h = aVar;
                if (this.f20084g == aVar2) {
                    this.f20084g = aVar3;
                    return;
                }
                return;
            }
        }
        a(this.f20083f);
        a aVar4 = new a(this.f20090m, i11);
        this.f20083f = aVar4;
        this.f20084g = aVar4;
        this.f20085h = aVar4;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    @Override // g5.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void format(c5.i r8) {
        /*
            r7 = this;
            long r0 = r7.f20089l
            if (r8 != 0) goto L6
            r0 = 0
            goto L1e
        L6:
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L1d
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r4 = r8.H
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L1d
            long r4 = r4 + r0
            c5.i r0 = r8.copyWithSubsampleOffsetUs(r4)
            goto L1e
        L1d:
            r0 = r8
        L1e:
            u5.i r1 = r7.f20080c
            boolean r1 = r1.format(r0)
            r7.f20088k = r8
            r8 = 0
            r7.f20087j = r8
            u5.j$b r8 = r7.f20092o
            if (r8 == 0) goto L32
            if (r1 == 0) goto L32
            r8.onUpstreamFormatChanged(r0)
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u5.j.format(c5.i):void");
    }

    public long getLargestQueuedTimestampUs() {
        return this.f20080c.getLargestQueuedTimestampUs();
    }

    public int getReadIndex() {
        return this.f20080c.getReadIndex();
    }

    public c5.i getUpstreamFormat() {
        return this.f20080c.getUpstreamFormat();
    }

    public int getWriteIndex() {
        return this.f20080c.getWriteIndex();
    }

    public boolean hasNextSample() {
        return this.f20080c.hasNextSample();
    }

    public int peekSourceId() {
        return this.f20080c.peekSourceId();
    }

    public int read(c5.j jVar, e5.e eVar, boolean z10, boolean z11, long j10) throws IllegalStateException {
        int unsignedShort;
        int i10 = this.f20080c.read(jVar, eVar, z10, z11, this.f20086i, this.f20081d);
        if (i10 == -5) {
            this.f20086i = jVar.f5130a;
            return -5;
        }
        if (i10 != -4) {
            if (i10 == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!eVar.isEndOfStream()) {
            if (eVar.f11143o < j10) {
                eVar.addFlag(Integer.MIN_VALUE);
            }
            boolean zIsEncrypted = eVar.isEncrypted();
            i.a aVar = this.f20081d;
            if (zIsEncrypted) {
                long j11 = aVar.f20076b;
                l6.l lVar = this.f20082e;
                lVar.reset(1);
                d(j11, lVar.f15881a, 1);
                long j12 = j11 + 1;
                byte b10 = lVar.f15881a[0];
                boolean z12 = (b10 & 128) != 0;
                int i11 = b10 & 127;
                e5.b bVar = eVar.f11141m;
                if (bVar.f11133a == null) {
                    bVar.f11133a = new byte[16];
                }
                d(j12, bVar.f11133a, i11);
                long j13 = j12 + i11;
                if (z12) {
                    lVar.reset(2);
                    d(j13, lVar.f15881a, 2);
                    j13 += 2;
                    unsignedShort = lVar.readUnsignedShort();
                } else {
                    unsignedShort = 1;
                }
                int[] iArr = bVar.f11134b;
                if (iArr == null || iArr.length < unsignedShort) {
                    iArr = new int[unsignedShort];
                }
                int[] iArr2 = iArr;
                int[] iArr3 = bVar.f11135c;
                if (iArr3 == null || iArr3.length < unsignedShort) {
                    iArr3 = new int[unsignedShort];
                }
                int[] iArr4 = iArr3;
                if (z12) {
                    int i12 = unsignedShort * 6;
                    lVar.reset(i12);
                    d(j13, lVar.f15881a, i12);
                    j13 += i12;
                    lVar.setPosition(0);
                    for (int i13 = 0; i13 < unsignedShort; i13++) {
                        iArr2[i13] = lVar.readUnsignedShort();
                        iArr4[i13] = lVar.readUnsignedIntToInt();
                    }
                } else {
                    iArr2[0] = 0;
                    iArr4[0] = aVar.f20075a - ((int) (j13 - aVar.f20076b));
                }
                m.a aVar2 = aVar.f20077c;
                bVar.set(unsignedShort, iArr2, iArr4, aVar2.f12729b, bVar.f11133a, aVar2.f12728a, aVar2.f12730c, aVar2.f12731d);
                long j14 = aVar.f20076b;
                int i14 = (int) (j13 - j14);
                aVar.f20076b = j14 + i14;
                aVar.f20075a -= i14;
            }
            eVar.ensureSpaceForWrite(aVar.f20075a);
            long j15 = aVar.f20076b;
            ByteBuffer byteBuffer = eVar.f11142n;
            int i15 = aVar.f20075a;
            while (true) {
                a aVar3 = this.f20084g;
                if (j15 < aVar3.f20094b) {
                    break;
                }
                this.f20084g = aVar3.f20097e;
            }
            while (i15 > 0) {
                int iMin = Math.min(i15, (int) (this.f20084g.f20094b - j15));
                a aVar4 = this.f20084g;
                byteBuffer.put(aVar4.f20096d.f14951a, aVar4.translateOffset(j15), iMin);
                i15 -= iMin;
                j15 += iMin;
                a aVar5 = this.f20084g;
                if (j15 == aVar5.f20094b) {
                    this.f20084g = aVar5.f20097e;
                }
            }
        }
        return -4;
    }

    public void reset() {
        reset(false);
    }

    public void rewind() {
        this.f20080c.rewind();
        this.f20084g = this.f20083f;
    }

    @Override // g5.m
    public int sampleData(g5.f fVar, int i10, boolean z10) throws InterruptedException, IOException {
        int iC = c(i10);
        a aVar = this.f20085h;
        int i11 = ((g5.b) fVar).read(aVar.f20096d.f14951a, aVar.translateOffset(this.f20090m), iC);
        if (i11 == -1) {
            if (z10) {
                return -1;
            }
            throw new EOFException();
        }
        long j10 = this.f20090m + i11;
        this.f20090m = j10;
        a aVar2 = this.f20085h;
        if (j10 == aVar2.f20094b) {
            this.f20085h = aVar2.f20097e;
        }
        return i11;
    }

    @Override // g5.m
    public void sampleMetadata(long j10, int i10, int i11, int i12, m.a aVar) {
        if (this.f20087j) {
            format(this.f20088k);
        }
        if (this.f20091n) {
            if ((i10 & 1) == 0 || !this.f20080c.attemptSplice(j10)) {
                return;
            } else {
                this.f20091n = false;
            }
        }
        this.f20080c.commitSample(j10 + this.f20089l, i10, (this.f20090m - i11) - i12, i11, aVar);
    }

    public void setSampleOffsetUs(long j10) {
        if (this.f20089l != j10) {
            this.f20089l = j10;
            this.f20087j = true;
        }
    }

    public void setUpstreamFormatChangeListener(b bVar) {
        this.f20092o = bVar;
    }

    public void sourceId(int i10) {
        this.f20080c.sourceId(i10);
    }

    public void splice() {
        this.f20091n = true;
    }

    public void reset(boolean z10) {
        this.f20080c.reset(z10);
        a(this.f20083f);
        a aVar = new a(0L, this.f20079b);
        this.f20083f = aVar;
        this.f20084g = aVar;
        this.f20085h = aVar;
        this.f20090m = 0L;
        ((k6.g) this.f20078a).trim();
    }

    @Override // g5.m
    public void sampleData(l6.l lVar, int i10) {
        while (i10 > 0) {
            int iC = c(i10);
            a aVar = this.f20085h;
            lVar.readBytes(aVar.f20096d.f14951a, aVar.translateOffset(this.f20090m), iC);
            i10 -= iC;
            long j10 = this.f20090m + iC;
            this.f20090m = j10;
            a aVar2 = this.f20085h;
            if (j10 == aVar2.f20094b) {
                this.f20085h = aVar2.f20097e;
            }
        }
    }
}
