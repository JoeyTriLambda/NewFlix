package w3;

/* compiled from: GradientColor.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f20897a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f20898b;

    public c(float[] fArr, int[] iArr) {
        this.f20897a = fArr;
        this.f20898b = iArr;
    }

    public int[] getColors() {
        return this.f20898b;
    }

    public float[] getPositions() {
        return this.f20897a;
    }

    public int getSize() {
        return this.f20898b.length;
    }

    public void lerp(c cVar, c cVar2, float f10) {
        int length = cVar.f20898b.length;
        int length2 = cVar2.f20898b.length;
        int[] iArr = cVar.f20898b;
        int[] iArr2 = cVar2.f20898b;
        if (length != length2) {
            StringBuilder sb2 = new StringBuilder("Cannot interpolate between gradients. Lengths vary (");
            sb2.append(iArr.length);
            sb2.append(" vs ");
            throw new IllegalArgumentException(ac.c.m(sb2, iArr2.length, ")"));
        }
        for (int i10 = 0; i10 < iArr.length; i10++) {
            this.f20897a[i10] = a4.g.lerp(cVar.f20897a[i10], cVar2.f20897a[i10], f10);
            this.f20898b[i10] = a4.b.evaluate(f10, iArr[i10], iArr2[i10]);
        }
    }
}
