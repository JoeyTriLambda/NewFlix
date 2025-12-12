package k4;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;

/* compiled from: KeyFrameInterpolator.java */
/* loaded from: classes.dex */
public final class b implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final TimeInterpolator f14735a;

    /* renamed from: b, reason: collision with root package name */
    public float[] f14736b;

    public b(TimeInterpolator timeInterpolator, float... fArr) {
        this.f14735a = timeInterpolator;
        this.f14736b = fArr;
    }

    public static b easeInOut(float... fArr) {
        b bVar = new b(a.inOut(), new float[0]);
        bVar.setFractions(fArr);
        return bVar;
    }

    public static b pathInterpolator(float f10, float f11, float f12, float f13, float... fArr) {
        b bVar = new b(c.create(f10, f11, f12, f13), new float[0]);
        bVar.setFractions(fArr);
        return bVar;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        int length = this.f14736b.length;
        TimeInterpolator timeInterpolator = this.f14735a;
        if (length > 1) {
            int i10 = 0;
            while (true) {
                float[] fArr = this.f14736b;
                if (i10 >= fArr.length - 1) {
                    break;
                }
                float f11 = fArr[i10];
                i10++;
                float f12 = fArr[i10];
                float f13 = f12 - f11;
                if (f10 >= f11 && f10 <= f12) {
                    return (timeInterpolator.getInterpolation((f10 - f11) / f13) * f13) + f11;
                }
            }
        }
        return timeInterpolator.getInterpolation(f10);
    }

    public void setFractions(float... fArr) {
        this.f14736b = fArr;
    }
}
