package p6;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* compiled from: ImageMatrixProperty.java */
/* loaded from: classes.dex */
public final class f extends Property<ImageView, Matrix> {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f17612a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.f17612a = new Matrix();
    }

    @Override // android.util.Property
    public Matrix get(ImageView imageView) {
        Matrix matrix = this.f17612a;
        matrix.set(imageView.getImageMatrix());
        return matrix;
    }

    @Override // android.util.Property
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
