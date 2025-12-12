package h5;

import g5.e;
import g5.f;
import g5.g;
import g5.k;
import g5.l;
import java.io.IOException;
import l6.u;

/* compiled from: FlvExtractor.java */
/* loaded from: classes.dex */
public final class a implements e, l {

    /* renamed from: n, reason: collision with root package name */
    public static final int f12918n = u.getIntegerCodeForString("FLV");

    /* renamed from: e, reason: collision with root package name */
    public g f12923e;

    /* renamed from: g, reason: collision with root package name */
    public int f12925g;

    /* renamed from: h, reason: collision with root package name */
    public int f12926h;

    /* renamed from: i, reason: collision with root package name */
    public int f12927i;

    /* renamed from: j, reason: collision with root package name */
    public long f12928j;

    /* renamed from: k, reason: collision with root package name */
    public com.google.android.exoplayer2.extractor.flv.a f12929k;

    /* renamed from: l, reason: collision with root package name */
    public com.google.android.exoplayer2.extractor.flv.b f12930l;

    /* renamed from: m, reason: collision with root package name */
    public b f12931m;

    /* renamed from: a, reason: collision with root package name */
    public final l6.l f12919a = new l6.l(4);

    /* renamed from: b, reason: collision with root package name */
    public final l6.l f12920b = new l6.l(9);

    /* renamed from: c, reason: collision with root package name */
    public final l6.l f12921c = new l6.l(11);

    /* renamed from: d, reason: collision with root package name */
    public final l6.l f12922d = new l6.l();

    /* renamed from: f, reason: collision with root package name */
    public int f12924f = 1;

    public final l6.l a(f fVar) throws InterruptedException, IOException {
        int i10 = this.f12927i;
        l6.l lVar = this.f12922d;
        if (i10 > lVar.capacity()) {
            lVar.reset(new byte[Math.max(lVar.capacity() * 2, this.f12927i)], 0);
        } else {
            lVar.setPosition(0);
        }
        lVar.setLimit(this.f12927i);
        ((g5.b) fVar).readFully(lVar.f15881a, 0, this.f12927i);
        return lVar;
    }

    @Override // g5.l
    public long getDurationUs() {
        return this.f12931m.getDurationUs();
    }

    @Override // g5.l
    public long getPosition(long j10) {
        return 0L;
    }

    @Override // g5.e
    public void init(g gVar) {
        this.f12923e = gVar;
    }

    @Override // g5.l
    public boolean isSeekable() {
        return false;
    }

    @Override // g5.e
    public int read(f fVar, k kVar) throws InterruptedException, IOException {
        b bVar;
        com.google.android.exoplayer2.extractor.flv.b bVar2;
        com.google.android.exoplayer2.extractor.flv.a aVar;
        while (true) {
            int i10 = this.f12924f;
            boolean z10 = true;
            if (i10 == 1) {
                l6.l lVar = this.f12920b;
                if (((g5.b) fVar).readFully(lVar.f15881a, 0, 9, true)) {
                    lVar.setPosition(0);
                    lVar.skipBytes(4);
                    int unsignedByte = lVar.readUnsignedByte();
                    boolean z11 = (unsignedByte & 4) != 0;
                    z = (unsignedByte & 1) != 0;
                    if (z11 && this.f12929k == null) {
                        this.f12929k = new com.google.android.exoplayer2.extractor.flv.a(this.f12923e.track(8, 1));
                    }
                    if (z && this.f12930l == null) {
                        this.f12930l = new com.google.android.exoplayer2.extractor.flv.b(this.f12923e.track(9, 2));
                    }
                    if (this.f12931m == null) {
                        this.f12931m = new b(null);
                    }
                    this.f12923e.endTracks();
                    this.f12923e.seekMap(this);
                    this.f12925g = (lVar.readInt() - 9) + 4;
                    this.f12924f = 2;
                    z = true;
                }
                if (!z) {
                    return -1;
                }
            } else if (i10 == 2) {
                ((g5.b) fVar).skipFully(this.f12925g);
                this.f12925g = 0;
                this.f12924f = 3;
            } else if (i10 == 3) {
                l6.l lVar2 = this.f12921c;
                if (((g5.b) fVar).readFully(lVar2.f15881a, 0, 11, true)) {
                    lVar2.setPosition(0);
                    this.f12926h = lVar2.readUnsignedByte();
                    this.f12927i = lVar2.readUnsignedInt24();
                    this.f12928j = lVar2.readUnsignedInt24();
                    this.f12928j = ((lVar2.readUnsignedByte() << 24) | this.f12928j) * 1000;
                    lVar2.skipBytes(3);
                    this.f12924f = 4;
                    z = true;
                }
                if (!z) {
                    return -1;
                }
            } else if (i10 == 4) {
                int i11 = this.f12926h;
                if (i11 == 8 && (aVar = this.f12929k) != null) {
                    aVar.consume(a(fVar), this.f12928j);
                } else if (i11 == 9 && (bVar2 = this.f12930l) != null) {
                    bVar2.consume(a(fVar), this.f12928j);
                } else if (i11 != 18 || (bVar = this.f12931m) == null) {
                    ((g5.b) fVar).skipFully(this.f12927i);
                    z10 = false;
                } else {
                    bVar.consume(a(fVar), this.f12928j);
                }
                this.f12925g = 4;
                this.f12924f = 2;
                if (z10) {
                    return 0;
                }
            } else {
                continue;
            }
        }
    }

    @Override // g5.e
    public void seek(long j10, long j11) {
        this.f12924f = 1;
        this.f12925g = 0;
    }

    @Override // g5.e
    public boolean sniff(f fVar) throws InterruptedException, IOException {
        l6.l lVar = this.f12919a;
        g5.b bVar = (g5.b) fVar;
        bVar.peekFully(lVar.f15881a, 0, 3);
        lVar.setPosition(0);
        if (lVar.readUnsignedInt24() != f12918n) {
            return false;
        }
        bVar.peekFully(lVar.f15881a, 0, 2);
        lVar.setPosition(0);
        if ((lVar.readUnsignedShort() & 250) != 0) {
            return false;
        }
        bVar.peekFully(lVar.f15881a, 0, 4);
        lVar.setPosition(0);
        int i10 = lVar.readInt();
        bVar.resetPeekPosition();
        bVar.advancePeekPosition(i10);
        bVar.peekFully(lVar.f15881a, 0, 4);
        lVar.setPosition(0);
        return lVar.readInt() == 0;
    }

    @Override // g5.e
    public void release() {
    }
}
