package n5;

import n5.v;

/* compiled from: SectionReader.java */
/* loaded from: classes.dex */
public final class r implements v {

    /* renamed from: a, reason: collision with root package name */
    public final q f16689a;

    /* renamed from: b, reason: collision with root package name */
    public final l6.l f16690b = new l6.l(32);

    /* renamed from: c, reason: collision with root package name */
    public int f16691c;

    /* renamed from: d, reason: collision with root package name */
    public int f16692d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16693e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16694f;

    public r(q qVar) {
        this.f16689a = qVar;
    }

    @Override // n5.v
    public void consume(l6.l lVar, boolean z10) {
        int position = z10 ? lVar.getPosition() + lVar.readUnsignedByte() : -1;
        if (this.f16694f) {
            if (!z10) {
                return;
            }
            this.f16694f = false;
            lVar.setPosition(position);
            this.f16692d = 0;
        }
        while (lVar.bytesLeft() > 0) {
            int i10 = this.f16692d;
            l6.l lVar2 = this.f16690b;
            if (i10 < 3) {
                if (i10 == 0) {
                    int unsignedByte = lVar.readUnsignedByte();
                    lVar.setPosition(lVar.getPosition() - 1);
                    if (unsignedByte == 255) {
                        this.f16694f = true;
                        return;
                    }
                }
                int iMin = Math.min(lVar.bytesLeft(), 3 - this.f16692d);
                lVar.readBytes(lVar2.f15881a, this.f16692d, iMin);
                int i11 = this.f16692d + iMin;
                this.f16692d = i11;
                if (i11 == 3) {
                    lVar2.reset(3);
                    lVar2.skipBytes(1);
                    int unsignedByte2 = lVar2.readUnsignedByte();
                    int unsignedByte3 = lVar2.readUnsignedByte();
                    this.f16693e = (unsignedByte2 & 128) != 0;
                    this.f16691c = (((unsignedByte2 & 15) << 8) | unsignedByte3) + 3;
                    int iCapacity = lVar2.capacity();
                    int i12 = this.f16691c;
                    if (iCapacity < i12) {
                        byte[] bArr = lVar2.f15881a;
                        lVar2.reset(Math.min(4098, Math.max(i12, bArr.length * 2)));
                        System.arraycopy(bArr, 0, lVar2.f15881a, 0, 3);
                    }
                }
            } else {
                int iMin2 = Math.min(lVar.bytesLeft(), this.f16691c - this.f16692d);
                lVar.readBytes(lVar2.f15881a, this.f16692d, iMin2);
                int i13 = this.f16692d + iMin2;
                this.f16692d = i13;
                int i14 = this.f16691c;
                if (i13 != i14) {
                    continue;
                } else {
                    if (!this.f16693e) {
                        lVar2.reset(i14);
                    } else {
                        if (l6.u.crc(lVar2.f15881a, 0, i14, -1) != 0) {
                            this.f16694f = true;
                            return;
                        }
                        lVar2.reset(this.f16691c - 4);
                    }
                    this.f16689a.consume(lVar2);
                    this.f16692d = 0;
                }
            }
        }
    }

    @Override // n5.v
    public void init(l6.r rVar, g5.g gVar, v.d dVar) {
        this.f16689a.init(rVar, gVar, dVar);
        this.f16694f = true;
    }

    @Override // n5.v
    public void seek() {
        this.f16694f = true;
    }
}
