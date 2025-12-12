package m5;

import c5.i;
import com.google.android.exoplayer2.ParserException;
import g5.b;
import g5.e;
import g5.f;
import g5.g;
import g5.k;
import g5.l;
import g5.m;
import java.io.IOException;
import l6.l;
import l6.u;

/* compiled from: RawCcExtractor.java */
/* loaded from: classes.dex */
public final class a implements e {

    /* renamed from: i, reason: collision with root package name */
    public static final int f16101i = u.getIntegerCodeForString("RCC\u0001");

    /* renamed from: a, reason: collision with root package name */
    public final i f16102a;

    /* renamed from: c, reason: collision with root package name */
    public m f16104c;

    /* renamed from: e, reason: collision with root package name */
    public int f16106e;

    /* renamed from: f, reason: collision with root package name */
    public long f16107f;

    /* renamed from: g, reason: collision with root package name */
    public int f16108g;

    /* renamed from: h, reason: collision with root package name */
    public int f16109h;

    /* renamed from: b, reason: collision with root package name */
    public final l f16103b = new l(9);

    /* renamed from: d, reason: collision with root package name */
    public int f16105d = 0;

    public a(i iVar) {
        this.f16102a = iVar;
    }

    @Override // g5.e
    public void init(g gVar) {
        gVar.seekMap(new l.a(-9223372036854775807L));
        this.f16104c = gVar.track(0, 3);
        gVar.endTracks();
        this.f16104c.format(this.f16102a);
    }

    @Override // g5.e
    public int read(f fVar, k kVar) throws InterruptedException, IOException {
        while (true) {
            int i10 = this.f16105d;
            l6.l lVar = this.f16103b;
            boolean z10 = false;
            boolean z11 = true;
            if (i10 == 0) {
                lVar.reset();
                if (((b) fVar).readFully(lVar.f15881a, 0, 8, true)) {
                    if (lVar.readInt() != f16101i) {
                        throw new IOException("Input not RawCC");
                    }
                    this.f16106e = lVar.readUnsignedByte();
                    z10 = true;
                }
                if (!z10) {
                    return -1;
                }
                this.f16105d = 1;
            } else {
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException();
                    }
                    while (this.f16108g > 0) {
                        lVar.reset();
                        ((b) fVar).readFully(lVar.f15881a, 0, 3);
                        this.f16104c.sampleData(lVar, 3);
                        this.f16109h += 3;
                        this.f16108g--;
                    }
                    int i11 = this.f16109h;
                    if (i11 > 0) {
                        this.f16104c.sampleMetadata(this.f16107f, 1, i11, 0, null);
                    }
                    this.f16105d = 1;
                    return 0;
                }
                lVar.reset();
                int i12 = this.f16106e;
                if (i12 == 0) {
                    if (((b) fVar).readFully(lVar.f15881a, 0, 5, true)) {
                        this.f16107f = (lVar.readUnsignedInt() * 1000) / 45;
                        this.f16108g = lVar.readUnsignedByte();
                        this.f16109h = 0;
                    }
                    z11 = false;
                } else {
                    if (i12 != 1) {
                        throw new ParserException("Unsupported version number: " + this.f16106e);
                    }
                    if (((b) fVar).readFully(lVar.f15881a, 0, 9, true)) {
                        this.f16107f = lVar.readLong();
                        this.f16108g = lVar.readUnsignedByte();
                        this.f16109h = 0;
                    }
                    z11 = false;
                }
                if (!z11) {
                    this.f16105d = 0;
                    return -1;
                }
                this.f16105d = 2;
            }
        }
    }

    @Override // g5.e
    public void seek(long j10, long j11) {
        this.f16105d = 0;
    }

    @Override // g5.e
    public boolean sniff(f fVar) throws InterruptedException, IOException {
        l6.l lVar = this.f16103b;
        lVar.reset();
        ((b) fVar).peekFully(lVar.f15881a, 0, 8);
        return lVar.readInt() == f16101i;
    }

    @Override // g5.e
    public void release() {
    }
}
