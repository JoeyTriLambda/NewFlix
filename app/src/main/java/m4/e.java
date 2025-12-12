package m4;

import android.animation.ValueAnimator;
import android.os.Build;

/* compiled from: FadingCircle.java */
/* loaded from: classes.dex */
public final class e extends l4.a {

    /* compiled from: FadingCircle.java */
    public class a extends l4.b {
        public a() {
            setAlpha(0);
        }

        @Override // l4.f
        public ValueAnimator onCreateAnimation() {
            float[] fArr = {0.0f, 0.39f, 0.4f, 1.0f};
            return new j4.d(this).alpha(fArr, 0, 0, 255, 0).duration(1200L).easeInOut(fArr).build();
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
