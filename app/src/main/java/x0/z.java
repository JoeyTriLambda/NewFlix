package x0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;

/* compiled from: PointerIconCompat.java */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final PointerIcon f21373a;

    /* compiled from: PointerIconCompat.java */
    public static class a {
        public static PointerIcon a(Bitmap bitmap, float f10, float f11) {
            return PointerIcon.create(bitmap, f10, f11);
        }

        public static PointerIcon b(Context context, int i10) {
            return PointerIcon.getSystemIcon(context, i10);
        }

        public static PointerIcon c(Resources resources, int i10) {
            return PointerIcon.load(resources, i10);
        }
    }

    public z(PointerIcon pointerIcon) {
        this.f21373a = pointerIcon;
    }

    public static z getSystemIcon(Context context, int i10) {
        return Build.VERSION.SDK_INT >= 24 ? new z(a.b(context, i10)) : new z(null);
    }

    public Object getPointerIcon() {
        return this.f21373a;
    }
}
