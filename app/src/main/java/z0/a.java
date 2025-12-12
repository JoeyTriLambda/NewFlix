package z0;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* compiled from: PathInterpolatorCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: PathInterpolatorCompat.java */
    /* renamed from: z0.a$a, reason: collision with other inner class name */
    public static class C0329a {
        public static Interpolator a(float f10, float f11) {
            return new PathInterpolator(f10, f11);
        }

        public static Interpolator b(float f10, float f11, float f12, float f13) {
            return new PathInterpolator(f10, f11, f12, f13);
        }

        public static Interpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    public static Interpolator create(Path path) {
        return C0329a.c(path);
    }

    public static Interpolator create(float f10, float f11, float f12, float f13) {
        return C0329a.b(f10, f11, f12, f13);
    }
}
