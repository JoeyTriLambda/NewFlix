package n5;

import g5.l;
import java.io.IOException;
import n5.v;

/* compiled from: AdtsExtractor.java */
/* loaded from: classes.dex */
public final class c implements g5.e {

    /* renamed from: e, reason: collision with root package name */
    public static final int f16504e = l6.u.getIntegerCodeForString("ID3");

    /* renamed from: a, reason: collision with root package name */
    public final long f16505a;

    /* renamed from: b, reason: collision with root package name */
    public final d f16506b;

    /* renamed from: c, reason: collision with root package name */
    public final l6.l f16507c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16508d;

    public c() {
        this(0L);
    }

    @Override // g5.e
    public void init(g5.g gVar) {
        this.f16506b.createTracks(gVar, new v.d(0, 1));
        gVar.endTracks();
        gVar.seekMap(new l.a(-9223372036854775807L));
    }

    @Override // g5.e
    public int read(g5.f fVar, g5.k kVar) throws InterruptedException, IOException {
        l6.l lVar = this.f16507c;
        int i10 = ((g5.b) fVar).read(lVar.f15881a, 0, 200);
        if (i10 == -1) {
            return -1;
        }
        lVar.setPosition(0);
        lVar.setLimit(i10);
        boolean z10 = this.f16508d;
        d dVar = this.f16506b;
        if (!z10) {
            dVar.packetStarted(this.f16505a, true);
            this.f16508d = true;
        }
        dVar.consume(lVar);
        return 0;
    }

    @Override // g5.e
    public void seek(long j10, long j11) {
        this.f16508d = false;
        this.f16506b.seek();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004b, code lost:
    
        if ((r1 - r4) < 8192) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004d, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        r6.resetPeekPosition();
        r1 = r1 + 1;
     */
    @Override // g5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean sniff(g5.f r11) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r10 = this;
            l6.l r0 = new l6.l
            r1 = 10
            r0.<init>(r1)
            l6.k r2 = new l6.k
            byte[] r3 = r0.f15881a
            r2.<init>(r3)
            r3 = 0
            r4 = 0
        L10:
            byte[] r5 = r0.f15881a
            r6 = r11
            g5.b r6 = (g5.b) r6
            r6.peekFully(r5, r3, r1)
            r0.setPosition(r3)
            int r5 = r0.readUnsignedInt24()
            int r7 = n5.c.f16504e
            if (r5 == r7) goto L77
            r6.resetPeekPosition()
            r6.advancePeekPosition(r4)
            r1 = r4
        L2a:
            r11 = 0
            r5 = 0
        L2c:
            byte[] r7 = r0.f15881a
            r8 = 2
            r6.peekFully(r7, r3, r8)
            r0.setPosition(r3)
            int r7 = r0.readUnsignedShort()
            r8 = 65526(0xfff6, float:9.1821E-41)
            r7 = r7 & r8
            r8 = 65520(0xfff0, float:9.1813E-41)
            if (r7 == r8) goto L52
            r6.resetPeekPosition()
            int r1 = r1 + 1
            int r11 = r1 - r4
            r5 = 8192(0x2000, float:1.148E-41)
            if (r11 < r5) goto L4e
            return r3
        L4e:
            r6.advancePeekPosition(r1)
            goto L2a
        L52:
            r7 = 1
            int r11 = r11 + r7
            r8 = 4
            if (r11 < r8) goto L5c
            r9 = 188(0xbc, float:2.63E-43)
            if (r5 <= r9) goto L5c
            return r7
        L5c:
            byte[] r7 = r0.f15881a
            r6.peekFully(r7, r3, r8)
            r7 = 14
            r2.setPosition(r7)
            r7 = 13
            int r7 = r2.readBits(r7)
            r8 = 6
            if (r7 > r8) goto L70
            return r3
        L70:
            int r8 = r7 + (-6)
            r6.advancePeekPosition(r8)
            int r5 = r5 + r7
            goto L2c
        L77:
            r5 = 3
            r0.skipBytes(r5)
            int r5 = r0.readSynchSafeInt()
            int r7 = r5 + 10
            int r4 = r4 + r7
            r6.advancePeekPosition(r5)
            goto L10
        */
        throw new UnsupportedOperationException("Method not decompiled: n5.c.sniff(g5.f):boolean");
    }

    public c(long j10) {
        this.f16505a = j10;
        this.f16506b = new d(true);
        this.f16507c = new l6.l(200);
    }

    @Override // g5.e
    public void release() {
    }
}
