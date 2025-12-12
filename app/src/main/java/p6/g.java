package p6;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* compiled from: MatrixEvaluator.java */
/* loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f17613a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f17614b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f17615c = new Matrix();

    public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
        float[] fArr = this.f17613a;
        matrix.getValues(fArr);
        float[] fArr2 = this.f17614b;
        matrix2.getValues(fArr2);
        for (int i10 = 0; i10 < 9; i10++) {
            float f11 = fArr2[i10];
            float f12 = fArr[i10];
            fArr2[i10] = o1.a.a(f11, f12, f10, f12);
        }
        Matrix matrix3 = this.f17615c;
        matrix3.setValues(fArr2);
        return matrix3;
    }
}
