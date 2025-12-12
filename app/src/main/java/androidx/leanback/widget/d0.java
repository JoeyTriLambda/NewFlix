package androidx.leanback.widget;

import android.util.Property;
import java.util.ArrayList;

/* compiled from: ParallaxEffect.java */
/* loaded from: classes.dex */
public abstract class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3214a = new ArrayList(2);

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3215b;

    public d0() {
        new ArrayList(2);
        new ArrayList(2);
        this.f3215b = new ArrayList(4);
    }

    public abstract Number a();

    public abstract float b();

    public final void performMapping(c0 c0Var) {
        if (this.f3214a.size() < 2) {
            return;
        }
        ArrayList arrayList = c0Var.f3194a;
        int i10 = 0;
        if (arrayList.size() >= 2) {
            float[] fArr = c0Var.f3196c;
            float f10 = fArr[0];
            int i11 = 1;
            while (i11 < arrayList.size()) {
                float f11 = fArr[i11];
                if (f11 < f10) {
                    int i12 = i11 - 1;
                    throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is smaller than Property[%d]\"%s\"", Integer.valueOf(i11), ((Property) arrayList.get(i11)).getName(), Integer.valueOf(i12), ((Property) arrayList.get(i12)).getName()));
                }
                if (f10 == -3.4028235E38f && f11 == Float.MAX_VALUE) {
                    int i13 = i11 - 1;
                    throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is UNKNOWN_BEFORE and Property[%d]\"%s\" is UNKNOWN_AFTER", Integer.valueOf(i13), ((Property) arrayList.get(i13)).getName(), Integer.valueOf(i11), ((Property) arrayList.get(i11)).getName()));
                }
                i11++;
                f10 = f11;
            }
        }
        float fB = 0.0f;
        Number numberA = null;
        boolean z10 = false;
        while (true) {
            ArrayList arrayList2 = this.f3215b;
            if (i10 >= arrayList2.size()) {
                return;
            }
            e0 e0Var = (e0) arrayList2.get(i10);
            if (e0Var.isDirectMapping()) {
                if (numberA == null) {
                    numberA = a();
                }
                e0Var.directUpdate(numberA);
            } else {
                if (!z10) {
                    fB = b();
                    z10 = true;
                }
                e0Var.update(fB);
            }
            i10++;
        }
    }
}
