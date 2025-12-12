package m4;

import android.animation.ValueAnimator;
import android.os.Build;

/* compiled from: Circle.java */
/* loaded from: classes.dex */
public final class b extends l4.a {

    /* compiled from: Circle.java */
    public class a extends l4.b {
        public a() {
            setScale(0.0f);
        }

        @Override // l4.f
        public ValueAnimator onCreateAnimation() {
            float[] fArr = {0.0f, 0.5f, 1.0f};
            j4.d dVar = new j4.d(this);
            Float fValueOf = Float.valueOf(0.0f);
            return dVar.scale(fArr, fValueOf, Float.valueOf(1.0f), fValueOf).duration(1200L).easeInOut(fArr).build();
        }
    }

    @Override // l4.g
    public l4.f[] onCreateChild() {
        a[] aVarArr = new a[12];
        for (int i10 = 0; i10 < 12; i10++) {
            a aVar = new a();
            aVarArr[i10] = aVar;
            if (Build.VERSION.SDK_INT >= 24) {
                aVar.setAnimationDelay(i10 * 100);
            } else {
                aVar.setAnimationDelay((i10 * 100) - 1200);
            }
        }
        return aVarArr;
    }
}
