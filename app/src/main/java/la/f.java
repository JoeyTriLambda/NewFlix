package la;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import la.g;

/* compiled from: IntKeyframeSet.java */
/* loaded from: classes.dex */
public final class f extends h {

    /* renamed from: e, reason: collision with root package name */
    public int f16007e;

    /* renamed from: f, reason: collision with root package name */
    public int f16008f;

    /* renamed from: g, reason: collision with root package name */
    public int f16009g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16010h;

    public f(g.b... bVarArr) {
        super(bVarArr);
        this.f16010h = true;
    }

    public int getIntValue(float f10) {
        ArrayList<g> arrayList = this.f16017c;
        int i10 = this.f16015a;
        if (i10 == 2) {
            if (this.f16010h) {
                this.f16010h = false;
                this.f16007e = ((g.b) arrayList.get(0)).getIntValue();
                int intValue = ((g.b) arrayList.get(1)).getIntValue();
                this.f16008f = intValue;
                this.f16009g = intValue - this.f16007e;
            }
            Interpolator interpolator = this.f16016b;
            if (interpolator != null) {
                f10 = interpolator.getInterpolation(f10);
            }
            j jVar = this.f16018d;
            return jVar == null ? this.f16007e + ((int) (f10 * this.f16009g)) : ((Number) jVar.evaluate(f10, Integer.valueOf(this.f16007e), Integer.valueOf(this.f16008f))).intValue();
        }
        if (f10 <= 0.0f) {
            g.b bVar = (g.b) arrayList.get(0);
            g.b bVar2 = (g.b) arrayList.get(1);
            int intValue2 = bVar.getIntValue();
            int intValue3 = bVar2.getIntValue();
            float fraction = bVar.getFraction();
            float fraction2 = bVar2.getFraction();
            Interpolator interpolator2 = bVar2.getInterpolator();
            if (interpolator2 != null) {
                f10 = interpolator2.getInterpolation(f10);
            }
            float f11 = (f10 - fraction) / (fraction2 - fraction);
            j jVar2 = this.f16018d;
            return jVar2 == null ? intValue2 + ((int) (f11 * (intValue3 - intValue2))) : ((Number) jVar2.evaluate(f11, Integer.valueOf(intValue2), Integer.valueOf(intValue3))).intValue();
        }
        if (f10 >= 1.0f) {
            g.b bVar3 = (g.b) arrayList.get(i10 - 2);
            g.b bVar4 = (g.b) arrayList.get(i10 - 1);
            int intValue4 = bVar3.getIntValue();
            int intValue5 = bVar4.getIntValue();
            float fraction3 = bVar3.getFraction();
            float fraction4 = bVar4.getFraction();
            Interpolator interpolator3 = bVar4.getInterpolator();
            if (interpolator3 != null) {
                f10 = interpolator3.getInterpolation(f10);
            }
            float f12 = (f10 - fraction3) / (fraction4 - fraction3);
            j jVar3 = this.f16018d;
            return jVar3 == null ? intValue4 + ((int) (f12 * (intValue5 - intValue4))) : ((Number) jVar3.evaluate(f12, Integer.valueOf(intValue4), Integer.valueOf(intValue5))).intValue();
        }
        g.b bVar5 = (g.b) arrayList.get(0);
        int i11 = 1;
        while (i11 < i10) {
            g.b bVar6 = (g.b) arrayList.get(i11);
            if (f10 < bVar6.getFraction()) {
                Interpolator interpolator4 = bVar6.getInterpolator();
                if (interpolator4 != null) {
                    f10 = interpolator4.getInterpolation(f10);
                }
                float fraction5 = (f10 - bVar5.getFraction()) / (bVar6.getFraction() - bVar5.getFraction());
                int intValue6 = bVar5.getIntValue();
                int intValue7 = bVar6.getIntValue();
                j jVar4 = this.f16018d;
                return jVar4 == null ? intValue6 + ((int) (fraction5 * (intValue7 - intValue6))) : ((Number) jVar4.evaluate(fraction5, Integer.valueOf(intValue6), Integer.valueOf(intValue7))).intValue();
            }
            i11++;
            bVar5 = bVar6;
        }
        return ((Number) arrayList.get(i10 - 1).getValue()).intValue();
    }

    @Override // la.h
    public Object getValue(float f10) {
        return Integer.valueOf(getIntValue(f10));
    }

    @Override // la.h
    public f clone() {
        ArrayList<g> arrayList = this.f16017c;
        int size = arrayList.size();
        g.b[] bVarArr = new g.b[size];
        for (int i10 = 0; i10 < size; i10++) {
            bVarArr[i10] = (g.b) arrayList.get(i10).mo86clone();
        }
        return new f(bVarArr);
    }
}
