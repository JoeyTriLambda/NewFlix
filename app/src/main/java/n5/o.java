package n5;

import android.util.Log;
import n5.v;

/* compiled from: PesReader.java */
/* loaded from: classes.dex */
public final class o implements v {

    /* renamed from: a, reason: collision with root package name */
    public final h f16663a;

    /* renamed from: b, reason: collision with root package name */
    public final l6.k f16664b = new l6.k(new byte[10]);

    /* renamed from: c, reason: collision with root package name */
    public int f16665c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f16666d;

    /* renamed from: e, reason: collision with root package name */
    public l6.r f16667e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16668f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16669g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16670h;

    /* renamed from: i, reason: collision with root package name */
    public int f16671i;

    /* renamed from: j, reason: collision with root package name */
    public int f16672j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f16673k;

    /* renamed from: l, reason: collision with root package name */
    public long f16674l;

    public o(h hVar) {
        this.f16663a = hVar;
    }

    public final boolean a(l6.l lVar, byte[] bArr, int i10) {
        int iMin = Math.min(lVar.bytesLeft(), i10 - this.f16666d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            lVar.skipBytes(iMin);
        } else {
            lVar.readBytes(bArr, this.f16666d, iMin);
        }
        int i11 = this.f16666d + iMin;
        this.f16666d = i11;
        return i11 == i10;
    }

    @Override // n5.v
    public final void consume(l6.l lVar, boolean z10) {
        boolean z11;
        int i10 = 0;
        h hVar = this.f16663a;
        int i11 = -1;
        int i12 = 3;
        if (z10) {
            int i13 = this.f16665c;
            if (i13 == 2) {
                Log.w("PesReader", "Unexpected start indicator reading extended header");
            } else if (i13 == 3) {
                if (this.f16672j != -1) {
                    Log.w("PesReader", "Unexpected start indicator: expected " + this.f16672j + " more bytes");
                }
                hVar.packetFinished();
            }
            this.f16665c = 1;
            this.f16666d = 0;
        }
        while (lVar.bytesLeft() > 0) {
            int i14 = this.f16665c;
            if (i14 != 0) {
                l6.k kVar = this.f16664b;
                if (i14 != 1) {
                    if (i14 == 2) {
                        if (a(lVar, kVar.f15877a, Math.min(10, this.f16671i)) && a(lVar, null, this.f16671i)) {
                            kVar.setPosition(i10);
                            this.f16674l = -9223372036854775807L;
                            if (this.f16668f) {
                                kVar.skipBits(4);
                                kVar.skipBits(1);
                                kVar.skipBits(1);
                                long bits = (kVar.readBits(i12) << 30) | (kVar.readBits(15) << 15) | kVar.readBits(15);
                                kVar.skipBits(1);
                                if (!this.f16670h && this.f16669g) {
                                    kVar.skipBits(4);
                                    kVar.skipBits(1);
                                    kVar.skipBits(1);
                                    kVar.skipBits(1);
                                    this.f16667e.adjustTsTimestamp((kVar.readBits(i12) << 30) | (kVar.readBits(15) << 15) | kVar.readBits(15));
                                    this.f16670h = true;
                                }
                                this.f16674l = this.f16667e.adjustTsTimestamp(bits);
                            }
                            hVar.packetStarted(this.f16674l, this.f16673k);
                            this.f16665c = 3;
                            this.f16666d = 0;
                        } else {
                            i10 = 0;
                        }
                    } else if (i14 == i12) {
                        int iBytesLeft = lVar.bytesLeft();
                        int i15 = this.f16672j;
                        int i16 = i15 == i11 ? 0 : iBytesLeft - i15;
                        if (i16 > 0) {
                            iBytesLeft -= i16;
                            lVar.setLimit(lVar.getPosition() + iBytesLeft);
                        }
                        hVar.consume(lVar);
                        int i17 = this.f16672j;
                        if (i17 != i11) {
                            int i18 = i17 - iBytesLeft;
                            this.f16672j = i18;
                            if (i18 == 0) {
                                hVar.packetFinished();
                                this.f16665c = 1;
                                this.f16666d = i10;
                            }
                        }
                    }
                } else if (a(lVar, kVar.f15877a, 9)) {
                    kVar.setPosition(0);
                    int bits2 = kVar.readBits(24);
                    if (bits2 != 1) {
                        o1.a.o("Unexpected start code prefix: ", bits2, "PesReader");
                        this.f16672j = -1;
                        z11 = false;
                    } else {
                        kVar.skipBits(8);
                        int bits3 = kVar.readBits(16);
                        kVar.skipBits(5);
                        this.f16673k = kVar.readBit();
                        kVar.skipBits(2);
                        this.f16668f = kVar.readBit();
                        this.f16669g = kVar.readBit();
                        kVar.skipBits(6);
                        int bits4 = kVar.readBits(8);
                        this.f16671i = bits4;
                        if (bits3 == 0) {
                            this.f16672j = -1;
                        } else {
                            this.f16672j = ((bits3 + 6) - 9) - bits4;
                        }
                        z11 = true;
                    }
                    this.f16665c = z11 ? 2 : 0;
                    this.f16666d = 0;
                }
            } else {
                lVar.skipBytes(lVar.bytesLeft());
            }
            i10 = 0;
            i11 = -1;
            i12 = 3;
        }
    }

    @Override // n5.v
    public void init(l6.r rVar, g5.g gVar, v.d dVar) {
        this.f16667e = rVar;
        this.f16663a.createTracks(gVar, dVar);
    }

    @Override // n5.v
    public final void seek() {
        this.f16665c = 0;
        this.f16666d = 0;
        this.f16670h = false;
        this.f16663a.seek();
    }
}
