package d6;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.Log;
import android.util.SparseArray;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l6.k;
import l6.u;

/* compiled from: DvbParser.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f10898h = {0, 7, 8, 15};

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f10899i = {0, 119, -120, -1};

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f10900j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, ByteSourceJsonBootstrapper.UTF8_BOM_2, -52, -35, -18, -1};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f10901a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f10902b;

    /* renamed from: c, reason: collision with root package name */
    public final Canvas f10903c;

    /* renamed from: d, reason: collision with root package name */
    public final C0126b f10904d;

    /* renamed from: e, reason: collision with root package name */
    public final a f10905e;

    /* renamed from: f, reason: collision with root package name */
    public final h f10906f;

    /* renamed from: g, reason: collision with root package name */
    public Bitmap f10907g;

    /* compiled from: DvbParser.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f10908a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f10909b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f10910c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f10911d;

        public a(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f10908a = i10;
            this.f10909b = iArr;
            this.f10910c = iArr2;
            this.f10911d = iArr3;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: d6.b$b, reason: collision with other inner class name */
    public static final class C0126b {

        /* renamed from: a, reason: collision with root package name */
        public final int f10912a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10913b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10914c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10915d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10916e;

        /* renamed from: f, reason: collision with root package name */
        public final int f10917f;

        public C0126b(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f10912a = i10;
            this.f10913b = i11;
            this.f10914c = i12;
            this.f10915d = i13;
            this.f10916e = i14;
            this.f10917f = i15;
        }
    }

    /* compiled from: DvbParser.java */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f10918a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10919b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f10920c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f10921d;

        public c(int i10, boolean z10, byte[] bArr, byte[] bArr2) {
            this.f10918a = i10;
            this.f10919b = z10;
            this.f10920c = bArr;
            this.f10921d = bArr2;
        }
    }

    /* compiled from: DvbParser.java */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f10922a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10923b;

        /* renamed from: c, reason: collision with root package name */
        public final SparseArray<e> f10924c;

        public d(int i10, int i11, int i12, SparseArray<e> sparseArray) {
            this.f10922a = i11;
            this.f10923b = i12;
            this.f10924c = sparseArray;
        }
    }

    /* compiled from: DvbParser.java */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f10925a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10926b;

        public e(int i10, int i11) {
            this.f10925a = i10;
            this.f10926b = i11;
        }
    }

    /* compiled from: DvbParser.java */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f10927a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10928b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10929c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10930d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10931e;

        /* renamed from: f, reason: collision with root package name */
        public final int f10932f;

        /* renamed from: g, reason: collision with root package name */
        public final int f10933g;

        /* renamed from: h, reason: collision with root package name */
        public final int f10934h;

        /* renamed from: i, reason: collision with root package name */
        public final int f10935i;

        /* renamed from: j, reason: collision with root package name */
        public final SparseArray<g> f10936j;

        public f(int i10, boolean z10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, SparseArray<g> sparseArray) {
            this.f10927a = i10;
            this.f10928b = z10;
            this.f10929c = i11;
            this.f10930d = i12;
            this.f10931e = i14;
            this.f10932f = i15;
            this.f10933g = i16;
            this.f10934h = i17;
            this.f10935i = i18;
            this.f10936j = sparseArray;
        }

        public void mergeFrom(f fVar) {
            if (fVar == null) {
                return;
            }
            int i10 = 0;
            while (true) {
                SparseArray<g> sparseArray = fVar.f10936j;
                if (i10 >= sparseArray.size()) {
                    return;
                }
                this.f10936j.put(sparseArray.keyAt(i10), sparseArray.valueAt(i10));
                i10++;
            }
        }
    }

    /* compiled from: DvbParser.java */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final int f10937a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10938b;

        public g(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f10937a = i12;
            this.f10938b = i13;
        }
    }

    /* compiled from: DvbParser.java */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final int f10939a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10940b;

        /* renamed from: c, reason: collision with root package name */
        public final SparseArray<f> f10941c = new SparseArray<>();

        /* renamed from: d, reason: collision with root package name */
        public final SparseArray<a> f10942d = new SparseArray<>();

        /* renamed from: e, reason: collision with root package name */
        public final SparseArray<c> f10943e = new SparseArray<>();

        /* renamed from: f, reason: collision with root package name */
        public final SparseArray<a> f10944f = new SparseArray<>();

        /* renamed from: g, reason: collision with root package name */
        public final SparseArray<c> f10945g = new SparseArray<>();

        /* renamed from: h, reason: collision with root package name */
        public C0126b f10946h;

        /* renamed from: i, reason: collision with root package name */
        public d f10947i;

        public h(int i10, int i11) {
            this.f10939a = i10;
            this.f10940b = i11;
        }

        public void reset() {
            this.f10941c.clear();
            this.f10942d.clear();
            this.f10943e.clear();
            this.f10944f.clear();
            this.f10945g.clear();
            this.f10946h = null;
            this.f10947i = null;
        }
    }

    public b(int i10, int i11) {
        Paint paint = new Paint();
        this.f10901a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f10902b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f10903c = new Canvas();
        this.f10904d = new C0126b(719, 575, 0, 719, 0, 575);
        this.f10905e = new a(0, new int[]{0, -1, -16777216, -8421505}, a(), b());
        this.f10906f = new h(i10, i11);
    }

    public static int[] a() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i10 = 1; i10 < 16; i10++) {
            if (i10 < 8) {
                iArr[i10] = c(255, (i10 & 1) != 0 ? 255 : 0, (i10 & 2) != 0 ? 255 : 0, (i10 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i10] = c(255, (i10 & 1) != 0 ? 127 : 0, (i10 & 2) != 0 ? 127 : 0, (i10 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    public static int[] b() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i10 = 0; i10 < 256; i10++) {
            if (i10 < 8) {
                iArr[i10] = c(63, (i10 & 1) != 0 ? 255 : 0, (i10 & 2) != 0 ? 255 : 0, (i10 & 4) == 0 ? 0 : 255);
            } else {
                int i11 = i10 & 136;
                if (i11 == 0) {
                    iArr[i10] = c(255, ((i10 & 1) != 0 ? 85 : 0) + ((i10 & 16) != 0 ? 170 : 0), ((i10 & 2) != 0 ? 85 : 0) + ((i10 & 32) != 0 ? 170 : 0), ((i10 & 4) == 0 ? 0 : 85) + ((i10 & 64) == 0 ? 0 : 170));
                } else if (i11 == 8) {
                    iArr[i10] = c(127, ((i10 & 1) != 0 ? 85 : 0) + ((i10 & 16) != 0 ? 170 : 0), ((i10 & 2) != 0 ? 85 : 0) + ((i10 & 32) != 0 ? 170 : 0), ((i10 & 4) == 0 ? 0 : 85) + ((i10 & 64) == 0 ? 0 : 170));
                } else if (i11 == 128) {
                    iArr[i10] = c(255, ((i10 & 1) != 0 ? 43 : 0) + 127 + ((i10 & 16) != 0 ? 85 : 0), ((i10 & 2) != 0 ? 43 : 0) + 127 + ((i10 & 32) != 0 ? 85 : 0), ((i10 & 4) == 0 ? 0 : 43) + 127 + ((i10 & 64) == 0 ? 0 : 85));
                } else if (i11 == 136) {
                    iArr[i10] = c(255, ((i10 & 1) != 0 ? 43 : 0) + ((i10 & 16) != 0 ? 85 : 0), ((i10 & 2) != 0 ? 43 : 0) + ((i10 & 32) != 0 ? 85 : 0), ((i10 & 4) == 0 ? 0 : 43) + ((i10 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int c(int i10, int i11, int i12, int i13) {
        return (i10 << 24) | (i11 << 16) | (i12 << 8) | i13;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01c9 A[LOOP:3: B:82:0x0143->B:114:0x01c9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x011d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0123 A[LOOP:2: B:35:0x008d->B:69:0x0123, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0161 A[PHI: r2
  0x0161: PHI (r2v8 int) = (r2v7 int), (r2v22 int) binds: [B:83:0x0147, B:90:0x0160] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(byte[] r22, int[] r23, int r24, int r25, int r26, android.graphics.Paint r27, android.graphics.Canvas r28) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.b.d(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    public static a e(k kVar, int i10) {
        int bits;
        int bits2;
        int bits3;
        int bits4;
        int i11 = 8;
        int bits5 = kVar.readBits(8);
        kVar.skipBits(8);
        int i12 = i10 - 2;
        int i13 = 4;
        int[] iArr = {0, -1, -16777216, -8421505};
        int[] iArrA = a();
        int[] iArrB = b();
        while (i12 > 0) {
            int bits6 = kVar.readBits(i11);
            int bits7 = kVar.readBits(i11);
            int i14 = i12 - 2;
            int[] iArr2 = (bits7 & 128) != 0 ? iArr : (bits7 & 64) != 0 ? iArrA : iArrB;
            if ((bits7 & 1) != 0) {
                bits3 = kVar.readBits(i11);
                bits4 = kVar.readBits(i11);
                bits = kVar.readBits(i11);
                bits2 = kVar.readBits(i11);
                i12 = i14 - 4;
            } else {
                int bits8 = kVar.readBits(6) << 2;
                int bits9 = kVar.readBits(i13) << i13;
                i12 = i14 - 2;
                bits = kVar.readBits(i13) << i13;
                bits2 = kVar.readBits(2) << 6;
                bits3 = bits8;
                bits4 = bits9;
            }
            if (bits3 == 0) {
                bits4 = 0;
                bits = 0;
                bits2 = 255;
            }
            double d10 = bits3;
            double d11 = bits4 - 128;
            double d12 = bits - 128;
            iArr2[bits6] = c((byte) (255 - (bits2 & 255)), u.constrainValue((int) ((1.402d * d11) + d10), 0, 255), u.constrainValue((int) ((d10 - (0.34414d * d12)) - (d11 * 0.71414d)), 0, 255), u.constrainValue((int) ((d12 * 1.772d) + d10), 0, 255));
            iArr = iArr;
            bits5 = bits5;
            i11 = 8;
            i13 = 4;
        }
        return new a(bits5, iArr, iArrA, iArrB);
    }

    public static c f(k kVar) {
        byte[] bArr;
        int bits = kVar.readBits(16);
        kVar.skipBits(4);
        int bits2 = kVar.readBits(2);
        boolean bit = kVar.readBit();
        kVar.skipBits(1);
        byte[] bArr2 = null;
        if (bits2 != 1) {
            if (bits2 == 0) {
                int bits3 = kVar.readBits(16);
                int bits4 = kVar.readBits(16);
                if (bits3 > 0) {
                    bArr2 = new byte[bits3];
                    kVar.readBytes(bArr2, 0, bits3);
                }
                if (bits4 > 0) {
                    bArr = new byte[bits4];
                    kVar.readBytes(bArr, 0, bits4);
                }
            }
            return new c(bits, bit, bArr2, bArr);
        }
        kVar.skipBits(kVar.readBits(8) * 16);
        bArr = bArr2;
        return new c(bits, bit, bArr2, bArr);
    }

    public List<b6.a> decode(byte[] bArr, int i10) {
        h hVar;
        int i11;
        int i12;
        h hVar2;
        int i13;
        a aVar;
        SparseArray<e> sparseArray;
        int bits;
        int bits2;
        int bits3;
        int bits4;
        int i14;
        int bits5;
        k kVar = new k(bArr, i10);
        while (true) {
            int iBitsLeft = kVar.bitsLeft();
            hVar = this.f10906f;
            if (iBitsLeft >= 48 && kVar.readBits(8) == 15) {
                int bits6 = kVar.readBits(8);
                int bits7 = kVar.readBits(16);
                int bits8 = kVar.readBits(16);
                int bytePosition = kVar.getBytePosition() + bits8;
                if (bits8 * 8 > kVar.bitsLeft()) {
                    Log.w("DvbParser", "Data field length exceeds limit");
                    kVar.skipBits(kVar.bitsLeft());
                } else {
                    switch (bits6) {
                        case 16:
                            if (bits7 == hVar.f10939a) {
                                d dVar = hVar.f10947i;
                                int bits9 = kVar.readBits(8);
                                int bits10 = kVar.readBits(4);
                                int bits11 = kVar.readBits(2);
                                kVar.skipBits(2);
                                int i15 = bits8 - 2;
                                SparseArray sparseArray2 = new SparseArray();
                                while (i15 > 0) {
                                    int bits12 = kVar.readBits(8);
                                    kVar.skipBits(8);
                                    i15 -= 6;
                                    sparseArray2.put(bits12, new e(kVar.readBits(16), kVar.readBits(16)));
                                }
                                d dVar2 = new d(bits9, bits10, bits11, sparseArray2);
                                if (dVar2.f10923b == 0) {
                                    if (dVar != null && dVar.f10922a != dVar2.f10922a) {
                                        hVar.f10947i = dVar2;
                                        break;
                                    }
                                } else {
                                    hVar.f10947i = dVar2;
                                    hVar.f10941c.clear();
                                    hVar.f10942d.clear();
                                    hVar.f10943e.clear();
                                    break;
                                }
                            }
                            break;
                        case 17:
                            d dVar3 = hVar.f10947i;
                            if (bits7 == hVar.f10939a && dVar3 != null) {
                                int bits13 = kVar.readBits(8);
                                kVar.skipBits(4);
                                boolean bit = kVar.readBit();
                                kVar.skipBits(3);
                                int bits14 = kVar.readBits(16);
                                int bits15 = kVar.readBits(16);
                                int bits16 = kVar.readBits(3);
                                int bits17 = kVar.readBits(3);
                                kVar.skipBits(2);
                                int bits18 = kVar.readBits(8);
                                int bits19 = kVar.readBits(8);
                                int bits20 = kVar.readBits(4);
                                int bits21 = kVar.readBits(2);
                                kVar.skipBits(2);
                                int i16 = bits8 - 10;
                                SparseArray sparseArray3 = new SparseArray();
                                while (i16 > 0) {
                                    int bits22 = kVar.readBits(16);
                                    int bits23 = kVar.readBits(2);
                                    int bits24 = kVar.readBits(2);
                                    int bits25 = kVar.readBits(12);
                                    kVar.skipBits(4);
                                    int bits26 = kVar.readBits(12);
                                    i16 -= 6;
                                    if (bits23 == 1 || bits23 == 2) {
                                        i16 -= 2;
                                        bits = kVar.readBits(8);
                                        bits2 = kVar.readBits(8);
                                    } else {
                                        bits = 0;
                                        bits2 = 0;
                                    }
                                    sparseArray3.put(bits22, new g(bits23, bits24, bits25, bits26, bits, bits2));
                                }
                                f fVar = new f(bits13, bit, bits14, bits15, bits16, bits17, bits18, bits19, bits20, bits21, sparseArray3);
                                SparseArray<f> sparseArray4 = hVar.f10941c;
                                int i17 = dVar3.f10923b;
                                int i18 = fVar.f10927a;
                                if (i17 == 0) {
                                    fVar.mergeFrom(sparseArray4.get(i18));
                                }
                                sparseArray4.put(i18, fVar);
                                break;
                            }
                            break;
                        case 18:
                            if (bits7 != hVar.f10939a) {
                                if (bits7 == hVar.f10940b) {
                                    a aVarE = e(kVar, bits8);
                                    hVar.f10944f.put(aVarE.f10908a, aVarE);
                                    break;
                                }
                            } else {
                                a aVarE2 = e(kVar, bits8);
                                hVar.f10942d.put(aVarE2.f10908a, aVarE2);
                                break;
                            }
                            break;
                        case 19:
                            if (bits7 != hVar.f10939a) {
                                if (bits7 == hVar.f10940b) {
                                    c cVarF = f(kVar);
                                    hVar.f10945g.put(cVarF.f10918a, cVarF);
                                    break;
                                }
                            } else {
                                c cVarF2 = f(kVar);
                                hVar.f10943e.put(cVarF2.f10918a, cVarF2);
                                break;
                            }
                            break;
                        case 20:
                            if (bits7 == hVar.f10939a) {
                                kVar.skipBits(4);
                                boolean bit2 = kVar.readBit();
                                kVar.skipBits(3);
                                int bits27 = kVar.readBits(16);
                                int bits28 = kVar.readBits(16);
                                if (bit2) {
                                    int bits29 = kVar.readBits(16);
                                    bits3 = kVar.readBits(16);
                                    bits5 = kVar.readBits(16);
                                    bits4 = kVar.readBits(16);
                                    i14 = bits29;
                                } else {
                                    bits3 = bits27;
                                    bits4 = bits28;
                                    i14 = 0;
                                    bits5 = 0;
                                }
                                hVar.f10946h = new C0126b(bits27, bits28, i14, bits3, bits5, bits4);
                                break;
                            }
                            break;
                    }
                    kVar.skipBytes(bytePosition - kVar.getBytePosition());
                }
            }
        }
        if (hVar.f10947i == null) {
            return Collections.emptyList();
        }
        C0126b c0126b = hVar.f10946h;
        if (c0126b == null) {
            c0126b = this.f10904d;
        }
        Bitmap bitmap = this.f10907g;
        Canvas canvas = this.f10903c;
        if (bitmap == null || c0126b.f10912a + 1 != bitmap.getWidth() || c0126b.f10913b + 1 != this.f10907g.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(c0126b.f10912a + 1, c0126b.f10913b + 1, Bitmap.Config.ARGB_8888);
            this.f10907g = bitmapCreateBitmap;
            canvas.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray5 = hVar.f10947i.f10924c;
        int i19 = 0;
        while (i19 < sparseArray5.size()) {
            e eVarValueAt = sparseArray5.valueAt(i19);
            f fVar2 = hVar.f10941c.get(sparseArray5.keyAt(i19));
            int i20 = eVarValueAt.f10925a + c0126b.f10914c;
            int i21 = eVarValueAt.f10926b + c0126b.f10916e;
            int iMin = Math.min(fVar2.f10929c + i20, c0126b.f10915d);
            int i22 = fVar2.f10930d;
            float f10 = i20;
            float f11 = i21;
            ArrayList arrayList2 = arrayList;
            C0126b c0126b2 = c0126b;
            int i23 = i19;
            canvas.clipRect(f10, f11, iMin, Math.min(i21 + i22, c0126b.f10917f), Region.Op.REPLACE);
            SparseArray<a> sparseArray6 = hVar.f10942d;
            int i24 = fVar2.f10932f;
            a aVar2 = sparseArray6.get(i24);
            if (aVar2 == null && (aVar2 = hVar.f10944f.get(i24)) == null) {
                aVar2 = this.f10905e;
            }
            a aVar3 = aVar2;
            int i25 = 0;
            while (true) {
                SparseArray<g> sparseArray7 = fVar2.f10936j;
                if (i25 < sparseArray7.size()) {
                    int iKeyAt = sparseArray7.keyAt(i25);
                    g gVarValueAt = sparseArray7.valueAt(i25);
                    c cVar = hVar.f10943e.get(iKeyAt);
                    if (cVar == null) {
                        cVar = hVar.f10945g.get(iKeyAt);
                    }
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        Paint paint = cVar2.f10919b ? null : this.f10901a;
                        int i26 = fVar2.f10931e;
                        int i27 = i20 + gVarValueAt.f10937a;
                        int i28 = i21 + gVarValueAt.f10938b;
                        int[] iArr = i26 == 3 ? aVar3.f10911d : i26 == 2 ? aVar3.f10910c : aVar3.f10909b;
                        hVar2 = hVar;
                        i13 = i25;
                        i12 = i23;
                        aVar = aVar3;
                        sparseArray = sparseArray5;
                        d(cVar2.f10920c, iArr, i26, i27, i28, paint, canvas);
                        d(cVar2.f10921d, iArr, i26, i27, i28 + 1, paint, canvas);
                    } else {
                        i12 = i23;
                        hVar2 = hVar;
                        i13 = i25;
                        aVar = aVar3;
                        sparseArray = sparseArray5;
                    }
                    i25 = i13 + 1;
                    aVar3 = aVar;
                    hVar = hVar2;
                    i23 = i12;
                    sparseArray5 = sparseArray;
                } else {
                    int i29 = i23;
                    h hVar3 = hVar;
                    a aVar4 = aVar3;
                    SparseArray<e> sparseArray8 = sparseArray5;
                    boolean z10 = fVar2.f10928b;
                    int i30 = fVar2.f10929c;
                    if (z10) {
                        int i31 = fVar2.f10931e;
                        int i32 = i31 == 3 ? aVar4.f10911d[fVar2.f10933g] : i31 == 2 ? aVar4.f10910c[fVar2.f10934h] : aVar4.f10909b[fVar2.f10935i];
                        Paint paint2 = this.f10902b;
                        paint2.setColor(i32);
                        i11 = i22;
                        canvas.drawRect(f10, f11, i20 + i30, i21 + i11, paint2);
                    } else {
                        i11 = i22;
                    }
                    Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.f10907g, i20, i21, i30, i11);
                    int i33 = c0126b2.f10912a;
                    float f12 = f10 / i33;
                    int i34 = c0126b2.f10913b;
                    arrayList2.add(new b6.a(bitmapCreateBitmap2, f12, 0, f11 / i34, 0, i30 / i33, i11 / i34));
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    i19 = i29 + 1;
                    arrayList = arrayList2;
                    c0126b = c0126b2;
                    hVar = hVar3;
                    sparseArray5 = sparseArray8;
                }
            }
        }
        return arrayList;
    }

    public void reset() {
        this.f10906f.reset();
    }
}
