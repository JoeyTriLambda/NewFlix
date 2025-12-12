package n5;

import g5.l;
import java.io.IOException;
import n5.v;

/* compiled from: Ac3Extractor.java */
/* loaded from: classes.dex */
public final class a implements g5.e {

    /* renamed from: e, reason: collision with root package name */
    public static final int f16487e = l6.u.getIntegerCodeForString("ID3");

    /* renamed from: a, reason: collision with root package name */
    public final long f16488a;

    /* renamed from: b, reason: collision with root package name */
    public final b f16489b;

    /* renamed from: c, reason: collision with root package name */
    public final l6.l f16490c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16491d;

    public a() {
        this(0L);
    }

    @Override // g5.e
    public void init(g5.g gVar) {
        this.f16489b.createTracks(gVar, new v.d(0, 1));
        gVar.endTracks();
        gVar.seekMap(new l.a(-9223372036854775807L));
    }

    @Override // g5.e
    public int read(g5.f fVar, g5.k kVar) throws InterruptedException, IOException {
        l6.l lVar = this.f16490c;
        int i10 = ((g5.b) fVar).read(lVar.f15881a, 0, 2786);
        if (i10 == -1) {
            return -1;
        }
        lVar.setPosition(0);
        lVar.setLimit(i10);
        boolean z10 = this.f16491d;
        b bVar = this.f16489b;
        if (!z10) {
            bVar.packetStarted(this.f16488a, true);
            this.f16491d = true;
        }
        bVar.consume(lVar);
        return 0;
    }

    @Override // g5.e
    public void seek(long j10, long j11) {
        this.f16491d = false;
        this.f16489b.seek();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003e, code lost:
    
        if ((r1 - r3) < 8192) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
    
        r5.resetPeekPosition();
        r1 = r1 + 1;
     */
    @Override // g5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean sniff(g5.f r8) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r7 = this;
            l6.l r0 = new l6.l
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.f15881a
            r5 = r8
            g5.b r5 = (g5.b) r5
            r5.peekFully(r4, r2, r1)
            r0.setPosition(r2)
            int r4 = r0.readUnsignedInt24()
            int r6 = n5.a.f16487e
            if (r4 == r6) goto L5b
            r5.resetPeekPosition()
            r5.advancePeekPosition(r3)
            r1 = r3
        L23:
            r8 = 0
        L24:
            byte[] r4 = r0.f15881a
            r6 = 5
            r5.peekFully(r4, r2, r6)
            r0.setPosition(r2)
            int r4 = r0.readUnsignedShort()
            r6 = 2935(0xb77, float:4.113E-42)
            if (r4 == r6) goto L45
            r5.resetPeekPosition()
            int r1 = r1 + 1
            int r8 = r1 - r3
            r4 = 8192(0x2000, float:1.148E-41)
            if (r8 < r4) goto L41
            return r2
        L41:
            r5.advancePeekPosition(r1)
            goto L23
        L45:
            r4 = 1
            int r8 = r8 + r4
            r6 = 4
            if (r8 < r6) goto L4b
            return r4
        L4b:
            byte[] r4 = r0.f15881a
            int r4 = d5.a.parseAc3SyncframeSize(r4)
            r6 = -1
            if (r4 != r6) goto L55
            return r2
        L55:
            int r4 = r4 + (-5)
            r5.advancePeekPosition(r4)
            goto L24
        L5b:
            r4 = 3
            r0.skipBytes(r4)
            int r4 = r0.readSynchSafeInt()
            int r6 = r4 + 10
            int r3 = r3 + r6
            r5.advancePeekPosition(r4)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: n5.a.sniff(g5.f):boolean");
    }

    public a(long j10) {
        this.f16488a = j10;
        this.f16489b = new b();
        this.f16490c = new l6.l(2786);
    }

    @Override // g5.e
    public void release() {
    }
}
