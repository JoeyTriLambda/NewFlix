package x6;

/* compiled from: Arrangement.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f21620a;

    /* renamed from: b, reason: collision with root package name */
    public float f21621b;

    /* renamed from: c, reason: collision with root package name */
    public int f21622c;

    /* renamed from: d, reason: collision with root package name */
    public int f21623d;

    /* renamed from: e, reason: collision with root package name */
    public float f21624e;

    /* renamed from: f, reason: collision with root package name */
    public float f21625f;

    /* renamed from: g, reason: collision with root package name */
    public final int f21626g;

    /* renamed from: h, reason: collision with root package name */
    public final float f21627h;

    /* JADX WARN: Removed duplicated region for block: B:43:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(int r4, float r5, float r6, float r7, int r8, float r9, int r10, float r11, int r12, float r13) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.a.<init>(int, float, float, float, int, float, int, float, int, float):void");
    }

    public static a a(float f10, float f11, float f12, float f13, int[] iArr, float f14, int[] iArr2, float f15, int[] iArr3) {
        a aVar = null;
        int i10 = 1;
        for (int i11 : iArr3) {
            int length = iArr2.length;
            int i12 = 0;
            while (i12 < length) {
                int i13 = iArr2[i12];
                int length2 = iArr.length;
                int i14 = 0;
                while (i14 < length2) {
                    int i15 = i14;
                    int i16 = length2;
                    int i17 = i12;
                    int i18 = length;
                    a aVar2 = new a(i10, f11, f12, f13, iArr[i14], f14, i13, f15, i11, f10);
                    float f16 = aVar2.f21627h;
                    if (aVar == null || f16 < aVar.f21627h) {
                        if (f16 == 0.0f) {
                            return aVar2;
                        }
                        aVar = aVar2;
                    }
                    i10++;
                    i14 = i15 + 1;
                    length2 = i16;
                    i12 = i17;
                    length = i18;
                }
                i12++;
            }
        }
        return aVar;
    }

    public String toString() {
        return "Arrangement [priority=" + this.f21620a + ", smallCount=" + this.f21622c + ", smallSize=" + this.f21621b + ", mediumCount=" + this.f21623d + ", mediumSize=" + this.f21624e + ", largeCount=" + this.f21626g + ", largeSize=" + this.f21625f + ", cost=" + this.f21627h + "]";
    }
}
