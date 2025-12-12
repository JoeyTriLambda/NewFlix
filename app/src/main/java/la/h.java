package la;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;
import la.g;
import org.apache.commons.lang3.StringUtils;

/* compiled from: KeyframeSet.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final int f16015a;

    /* renamed from: b, reason: collision with root package name */
    public final Interpolator f16016b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<g> f16017c;

    /* renamed from: d, reason: collision with root package name */
    public j f16018d;

    public h(g... gVarArr) {
        int length = gVarArr.length;
        this.f16015a = length;
        ArrayList<g> arrayList = new ArrayList<>();
        this.f16017c = arrayList;
        arrayList.addAll(Arrays.asList(gVarArr));
        arrayList.get(0);
        this.f16016b = arrayList.get(length - 1).getInterpolator();
    }

    public static h ofFloat(float... fArr) {
        int length = fArr.length;
        g.a[] aVarArr = new g.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (g.a) g.ofFloat(0.0f);
            aVarArr[1] = (g.a) g.ofFloat(1.0f, fArr[0]);
        } else {
            aVarArr[0] = (g.a) g.ofFloat(0.0f, fArr[0]);
            for (int i10 = 1; i10 < length; i10++) {
                aVarArr[i10] = (g.a) g.ofFloat(i10 / (length - 1), fArr[i10]);
            }
        }
        return new d(aVarArr);
    }

    public static h ofInt(int... iArr) {
        int length = iArr.length;
        g.b[] bVarArr = new g.b[Math.max(length, 2)];
        if (length == 1) {
            bVarArr[0] = (g.b) g.ofInt(0.0f);
            bVarArr[1] = (g.b) g.ofInt(1.0f, iArr[0]);
        } else {
            bVarArr[0] = (g.b) g.ofInt(0.0f, iArr[0]);
            for (int i10 = 1; i10 < length; i10++) {
                bVarArr[i10] = (g.b) g.ofInt(i10 / (length - 1), iArr[i10]);
            }
        }
        return new f(bVarArr);
    }

    public h clone() {
        throw null;
    }

    public Object getValue(float f10) {
        throw null;
    }

    public void setEvaluator(j jVar) {
        this.f16018d = jVar;
    }

    public String toString() {
        String string = StringUtils.SPACE;
        for (int i10 = 0; i10 < this.f16015a; i10++) {
            StringBuilder sbR = ac.c.r(string);
            sbR.append(this.f16017c.get(i10).getValue());
            sbR.append("  ");
            string = sbR.toString();
        }
        return string;
    }
}
