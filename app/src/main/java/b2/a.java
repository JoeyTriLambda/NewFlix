package b2;

import b2.b;
import java.util.ArrayList;
import java.util.Comparator;

/* compiled from: ColorCutQuantizer.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final C0052a f4700f = new C0052a();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f4701a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f4702b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f4703c;

    /* renamed from: d, reason: collision with root package name */
    public final b.c[] f4704d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f4705e = new float[3];

    /* compiled from: ColorCutQuantizer.java */
    /* renamed from: b2.a$a, reason: collision with other inner class name */
    public static class C0052a implements Comparator<b> {
        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return (((bVar2.f4714i - bVar2.f4713h) + 1) * (((bVar2.f4712g - bVar2.f4711f) + 1) * ((bVar2.f4710e - bVar2.f4709d) + 1))) - (((bVar.f4714i - bVar.f4713h) + 1) * (((bVar.f4712g - bVar.f4711f) + 1) * ((bVar.f4710e - bVar.f4709d) + 1)));
        }
    }

    /* compiled from: ColorCutQuantizer.java */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f4706a;

        /* renamed from: b, reason: collision with root package name */
        public int f4707b;

        /* renamed from: c, reason: collision with root package name */
        public int f4708c;

        /* renamed from: d, reason: collision with root package name */
        public int f4709d;

        /* renamed from: e, reason: collision with root package name */
        public int f4710e;

        /* renamed from: f, reason: collision with root package name */
        public int f4711f;

        /* renamed from: g, reason: collision with root package name */
        public int f4712g;

        /* renamed from: h, reason: collision with root package name */
        public int f4713h;

        /* renamed from: i, reason: collision with root package name */
        public int f4714i;

        public b(int i10, int i11) {
            this.f4706a = i10;
            this.f4707b = i11;
            a();
        }

        public final void a() {
            a aVar = a.this;
            int[] iArr = aVar.f4701a;
            int[] iArr2 = aVar.f4702b;
            int i10 = Integer.MAX_VALUE;
            int i11 = Integer.MAX_VALUE;
            int i12 = Integer.MAX_VALUE;
            int i13 = Integer.MIN_VALUE;
            int i14 = Integer.MIN_VALUE;
            int i15 = Integer.MIN_VALUE;
            int i16 = 0;
            for (int i17 = this.f4706a; i17 <= this.f4707b; i17++) {
                int i18 = iArr[i17];
                i16 += iArr2[i18];
                int i19 = (i18 >> 10) & 31;
                int i20 = (i18 >> 5) & 31;
                int i21 = i18 & 31;
                if (i19 > i13) {
                    i13 = i19;
                }
                if (i19 < i10) {
                    i10 = i19;
                }
                if (i20 > i14) {
                    i14 = i20;
                }
                if (i20 < i11) {
                    i11 = i20;
                }
                if (i21 > i15) {
                    i15 = i21;
                }
                if (i21 < i12) {
                    i12 = i21;
                }
            }
            this.f4709d = i10;
            this.f4710e = i13;
            this.f4711f = i11;
            this.f4712g = i14;
            this.f4713h = i12;
            this.f4714i = i15;
            this.f4708c = i16;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(int[] r18, int r19, b2.b.c[] r20) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.a.<init>(int[], int, b2.b$c[]):void");
    }

    public static void a(int i10, int i11, int[] iArr, int i12) {
        if (i10 == -2) {
            while (i11 <= i12) {
                int i13 = iArr[i11];
                iArr[i11] = (i13 & 31) | (((i13 >> 5) & 31) << 10) | (((i13 >> 10) & 31) << 5);
                i11++;
            }
            return;
        }
        if (i10 != -1) {
            return;
        }
        while (i11 <= i12) {
            int i14 = iArr[i11];
            iArr[i11] = ((i14 >> 10) & 31) | ((i14 & 31) << 10) | (((i14 >> 5) & 31) << 5);
            i11++;
        }
    }

    public static int b(int i10, int i11, int i12) {
        return (i12 > i11 ? i10 << (i12 - i11) : i10 >> (i11 - i12)) & ((1 << i12) - 1);
    }
}
