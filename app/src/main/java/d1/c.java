package d1;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* compiled from: CompoundButtonCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static Field f10777a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f10778b;

    /* compiled from: CompoundButtonCompat.java */
    public static class a {
        public static ColorStateList a(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        public static PorterDuff.Mode b(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        public static void c(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        public static void d(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    /* compiled from: CompoundButtonCompat.java */
    public static class b {
        public static Drawable a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    public static Drawable getButtonDrawable(CompoundButton compoundButton) throws NoSuchFieldException, SecurityException {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.a(compoundButton);
        }
        if (!f10778b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f10777a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e10);
            }
            f10778b = true;
        }
        Field field = f10777a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e11) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e11);
                f10777a = null;
            }
        }
        return null;
    }

    public static ColorStateList getButtonTintList(CompoundButton compoundButton) {
        return a.a(compoundButton);
    }

    public static PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton) {
        return a.b(compoundButton);
    }

    public static void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
        a.c(compoundButton, colorStateList);
    }

    public static void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode) {
        a.d(compoundButton, mode);
    }
}
