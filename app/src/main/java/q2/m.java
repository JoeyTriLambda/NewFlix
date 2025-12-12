package q2;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi21.java */
/* loaded from: classes.dex */
public class m extends l {

    /* renamed from: f, reason: collision with root package name */
    public static boolean f17796f = true;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f17797g = true;

    /* compiled from: ViewUtilsApi21.java */
    public static class a {
        public static void a(View view, Matrix matrix) {
            view.setAnimationMatrix(matrix);
        }

        public static void b(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }

        public static void c(View view, Matrix matrix) {
            view.transformMatrixToLocal(matrix);
        }
    }

    @SuppressLint({"NewApi"})
    public void transformMatrixToGlobal(View view, Matrix matrix) {
        if (f17796f) {
            try {
                a.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                f17796f = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void transformMatrixToLocal(View view, Matrix matrix) {
        if (f17797g) {
            try {
                a.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                f17797g = false;
            }
        }
    }
}
