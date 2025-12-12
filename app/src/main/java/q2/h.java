package q2;

import android.graphics.Bitmap;
import android.graphics.Picture;
import android.os.Build;

/* compiled from: TransitionUtils.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f17784a;

    /* compiled from: TransitionUtils.java */
    public static class a {
        public static Bitmap a(Picture picture) {
            return Bitmap.createBitmap(picture);
        }
    }

    static {
        f17784a = Build.VERSION.SDK_INT >= 28;
    }
}
