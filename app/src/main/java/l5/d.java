package l5;

import java.io.IOException;
import java.util.Arrays;
import l6.l;

/* compiled from: OggPacket.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final e f15794a = new e();

    /* renamed from: b, reason: collision with root package name */
    public final l f15795b = new l(new byte[65025], 0);

    /* renamed from: c, reason: collision with root package name */
    public int f15796c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f15797d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15798e;

    public e getPageHeader() {
        return this.f15794a;
    }

    public l getPayload() {
        return this.f15795b;
    }

    public boolean populate(g5.f fVar) throws InterruptedException, IOException {
        int i10;
        int i11;
        int i12;
        l6.a.checkState(fVar != null);
        boolean z10 = this.f15798e;
        l lVar = this.f15795b;
        if (z10) {
            this.f15798e = false;
            lVar.reset();
        }
        while (!this.f15798e) {
            int i13 = this.f15796c;
            e eVar = this.f15794a;
            if (i13 < 0) {
                if (!eVar.populate(fVar, true)) {
                    return false;
                }
                int i14 = eVar.f15803d;
                if ((eVar.f15800a & 1) == 1 && lVar.limit() == 0) {
                    this.f15797d = 0;
                    int i15 = 0;
                    do {
                        int i16 = this.f15797d;
                        int i17 = 0 + i16;
                        if (i17 >= eVar.f15802c) {
                            break;
                        }
                        this.f15797d = i16 + 1;
                        i12 = eVar.f15805f[i17];
                        i15 += i12;
                    } while (i12 == 255);
                    i14 += i15;
                    i11 = this.f15797d + 0;
                } else {
                    i11 = 0;
                }
                ((g5.b) fVar).skipFully(i14);
                this.f15796c = i11;
            }
            int i18 = this.f15796c;
            this.f15797d = 0;
            int i19 = 0;
            do {
                int i20 = this.f15797d;
                int i21 = i18 + i20;
                if (i21 >= eVar.f15802c) {
                    break;
                }
                this.f15797d = i20 + 1;
                i10 = eVar.f15805f[i21];
                i19 += i10;
            } while (i10 == 255);
            int i22 = this.f15796c + this.f15797d;
            if (i19 > 0) {
                if (lVar.capacity() < lVar.limit() + i19) {
                    lVar.f15881a = Arrays.copyOf(lVar.f15881a, lVar.limit() + i19);
                }
                ((g5.b) fVar).readFully(lVar.f15881a, lVar.limit(), i19);
                lVar.setLimit(lVar.limit() + i19);
                this.f15798e = eVar.f15805f[i22 + (-1)] != 255;
            }
            if (i22 == eVar.f15802c) {
                i22 = -1;
            }
            this.f15796c = i22;
        }
        return true;
    }

    public void reset() {
        this.f15794a.reset();
        this.f15795b.reset();
        this.f15796c = -1;
        this.f15798e = false;
    }

    public void trimPayload() {
        l lVar = this.f15795b;
        byte[] bArr = lVar.f15881a;
        if (bArr.length == 65025) {
            return;
        }
        lVar.f15881a = Arrays.copyOf(bArr, Math.max(65025, lVar.limit()));
    }
}
