package p1;

import android.view.animation.Interpolator;

/* compiled from: LookupTableInterpolator.java */
/* loaded from: classes.dex */
public abstract class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f17423a;

    /* renamed from: b, reason: collision with root package name */
    public final float f17424b;

    public d(float[] fArr) {
        this.f17423a = fArr;
        this.f17424b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f17423a;
        int iMin = Math.min((int) ((fArr.length - 1) * f10), fArr.length - 2);
        float f11 = this.f17424b;
        float f12 = (f10 - (iMin * f11)) / f11;
        float f13 = fArr[iMin];
        return o1.a.a(fArr[iMin + 1], f13, f12, f13);
    }
}
