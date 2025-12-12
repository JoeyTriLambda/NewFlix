package la;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import la.g;

/* compiled from: FloatKeyframeSet.java */
/* loaded from: classes.dex */
public final class d extends h {

    /* renamed from: e, reason: collision with root package name */
    public float f16003e;

    /* renamed from: f, reason: collision with root package name */
    public float f16004f;

    /* renamed from: g, reason: collision with root package name */
    public float f16005g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16006h;

    public d(g.a... aVarArr) {
        super(aVarArr);
        this.f16006h = true;
    }

    public float getFloatValue(float f10) {
        ArrayList<g> arrayList = this.f16017c;
        int i10 = this.f16015a;
        if (i10 == 2) {
            if (this.f16006h) {
                this.f16006h = false;
                this.f16003e = ((g.a) arrayList.get(0)).getFloatValue();
                float floatValue = ((g.a) arrayList.get(1)).getFloatValue();
                this.f16004f = floatValue;
                this.f16005g = floatValue - this.f16003e;
            }
            Interpolator interpolator = this.f16016b;
            if (interpolator != null) {
                f10 = interpolator.getInterpolation(f10);
            }
            j jVar = this.f16018d;
            if (jVar == null) {
                return (f10 * this.f16005g) + this.f16003e;
            }
            return ((Number) jVar.evaluate(f10, Float.valueOf(this.f16003e), Float.valueOf(this.f16004f))).floatValue();
        }
        if (f10 <= 0.0f) {
            g.a aVar = (g.a) arrayList.get(0);
            g.a aVar2 = (g.a) arrayList.get(1);
            float floatValue2 = aVar.getFloatValue();
            float floatValue3 = aVar2.getFloatValue();
            float fraction = aVar.getFraction();
            float fraction2 = aVar2.getFraction();
            Interpolator interpolator2 = aVar2.getInterpolator();
            if (interpolator2 != null) {
                f10 = interpolator2.getInterpolation(f10);
            }
            float f11 = (f10 - fraction) / (fraction2 - fraction);
            j jVar2 = this.f16018d;
            return jVar2 == null ? o1.a.a(floatValue3, floatValue2, f11, floatValue2) : ((Number) jVar2.evaluate(f11, Float.valueOf(floatValue2), Float.valueOf(floatValue3))).floatValue();
        }
        if (f10 >= 1.0f) {
            g.a aVar3 = (g.a) arrayList.get(i10 - 2);
            g.a aVar4 = (g.a) arrayList.get(i10 - 1);
            float floatValue4 = aVar3.getFloatValue();
            float floatValue5 = aVar4.getFloatValue();
            float fraction3 = aVar3.getFraction();
            float fraction4 = aVar4.getFraction();
            Interpolator interpolator3 = aVar4.getInterpolator();
            if (interpolator3 != null) {
                f10 = interpolator3.getInterpolation(f10);
            }
            float f12 = (f10 - fraction3) / (fraction4 - fraction3);
            j jVar3 = this.f16018d;
            return jVar3 == null ? o1.a.a(floatValue5, floatValue4, f12, floatValue4) : ((Number) jVar3.evaluate(f12, Float.valueOf(floatValue4), Float.valueOf(floatValue5))).floatValue();
        }
        g.a aVar5 = (g.a) arrayList.get(0);
        int i11 = 1;
        while (i11 < i10) {
            g.a aVar6 = (g.a) arrayList.get(i11);
            if (f10 < aVar6.getFraction()) {
                Interpolator interpolator4 = aVar6.getInterpolator();
                if (interpolator4 != null) {
                    f10 = interpolator4.getInterpolation(f10);
                }
                float fraction5 = (f10 - aVar5.getFraction()) / (aVar6.getFraction() - aVar5.getFraction());
                float floatValue6 = aVar5.getFloatValue();
                float floatValue7 = aVar6.getFloatValue();
                j jVar4 = this.f16018d;
                return jVar4 == null ? o1.a.a(floatValue7, floatValue6, fraction5, floatValue6) : ((Number) jVar4.evaluate(fraction5, Float.valueOf(floatValue6), Float.valueOf(floatValue7))).floatValue();
            }
            i11++;
            aVar5 = aVar6;
        }
        return ((Number) arrayList.get(i10 - 1).getValue()).floatValue();
    }

    @Override // la.h
    public Object getValue(float f10) {
        return Float.valueOf(getFloatValue(f10));
    }

    @Override // la.h
    public d clone() {
        ArrayList<g> arrayList = this.f16017c;
        int size = arrayList.size();
        g.a[] aVarArr = new g.a[size];
        for (int i10 = 0; i10 < size; i10++) {
            aVarArr[i10] = (g.a) arrayList.get(i10).mo86clone();
        }
        return new d(aVarArr);
    }
}
