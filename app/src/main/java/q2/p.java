package q2;

import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi29.java */
/* loaded from: classes.dex */
public final class p extends o {
    @Override // q2.l
    public float getTransitionAlpha(View view) {
        return view.getTransitionAlpha();
    }

    @Override // q2.n, q2.l
    public void setLeftTopRightBottom(View view, int i10, int i11, int i12, int i13) {
        view.setLeftTopRightBottom(i10, i11, i12, i13);
    }

    @Override // q2.l
    public void setTransitionAlpha(View view, float f10) {
        view.setTransitionAlpha(f10);
    }

    @Override // q2.o, q2.l
    public void setTransitionVisibility(View view, int i10) {
        view.setTransitionVisibility(i10);
    }

    @Override // q2.m
    public void transformMatrixToGlobal(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // q2.m
    public void transformMatrixToLocal(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
