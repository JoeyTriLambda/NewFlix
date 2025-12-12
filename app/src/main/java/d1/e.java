package d1;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* compiled from: ImageViewCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* compiled from: ImageViewCompat.java */
    public static class a {
        public static ColorStateList a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        public static PorterDuff.Mode b(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        public static void c(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
        }

        public static void d(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
        }
    }

    public static ColorStateList getImageTintList(ImageView imageView) {
        return a.a(imageView);
    }

    public static PorterDuff.Mode getImageTintMode(ImageView imageView) {
        return a.b(imageView);
    }

    public static void setImageTintList(ImageView imageView, ColorStateList colorStateList) {
        Drawable drawable;
        int i10 = Build.VERSION.SDK_INT;
        a.c(imageView, colorStateList);
        if (i10 != 21 || (drawable = imageView.getDrawable()) == null || a.a(imageView) == null) {
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(imageView.getDrawableState());
        }
        imageView.setImageDrawable(drawable);
    }

    public static void setImageTintMode(ImageView imageView, PorterDuff.Mode mode) {
        Drawable drawable;
        int i10 = Build.VERSION.SDK_INT;
        a.d(imageView, mode);
        if (i10 != 21 || (drawable = imageView.getDrawable()) == null || a.a(imageView) == null) {
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(imageView.getDrawableState());
        }
        imageView.setImageDrawable(drawable);
    }
}
