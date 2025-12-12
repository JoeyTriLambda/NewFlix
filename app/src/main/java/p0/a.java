package p0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: DrawableCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static Method f17404a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f17405b;

    /* renamed from: c, reason: collision with root package name */
    public static Method f17406c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f17407d;

    /* compiled from: DrawableCompat.java */
    /* renamed from: p0.a$a, reason: collision with other inner class name */
    public static class C0219a {
        public static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        public static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        public static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        public static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        public static void e(Drawable drawable, float f10, float f11) {
            drawable.setHotspot(f10, f11);
        }

        public static void f(Drawable drawable, int i10, int i11, int i12, int i13) {
            drawable.setHotspotBounds(i10, i11, i12, i13);
        }

        public static void g(Drawable drawable, int i10) {
            drawable.setTint(i10);
        }

        public static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    /* compiled from: DrawableCompat.java */
    public static class b {
        public static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        public static boolean b(Drawable drawable, int i10) {
            return drawable.setLayoutDirection(i10);
        }
    }

    public static void applyTheme(Drawable drawable, Resources.Theme theme) {
        C0219a.a(drawable, theme);
    }

    public static boolean canApplyTheme(Drawable drawable) {
        return C0219a.b(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void clearColorFilter(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            clearColorFilter(((InsetDrawable) drawable).getDrawable());
            return;
        }
        if (drawable instanceof d) {
            clearColorFilter(((d) drawable).getWrappedDrawable());
            return;
        }
        if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
            return;
        }
        int childCount = drawableContainerState.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            Drawable child = drawableContainerState.getChild(i10);
            if (child != null) {
                clearColorFilter(child);
            }
        }
    }

    public static int getAlpha(Drawable drawable) {
        return drawable.getAlpha();
    }

    public static ColorFilter getColorFilter(Drawable drawable) {
        return C0219a.c(drawable);
    }

    public static int getLayoutDirection(Drawable drawable) throws NoSuchMethodException, SecurityException {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.a(drawable);
        }
        if (!f17407d) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f17406c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e10) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e10);
            }
            f17407d = true;
        }
        Method method = f17406c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e11) {
                Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e11);
                f17406c = null;
            }
        }
        return 0;
    }

    public static void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C0219a.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    @Deprecated
    public static void jumpToCurrentState(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void setAutoMirrored(Drawable drawable, boolean z10) {
        drawable.setAutoMirrored(z10);
    }

    public static void setHotspot(Drawable drawable, float f10, float f11) {
        C0219a.e(drawable, f10, f11);
    }

    public static void setHotspotBounds(Drawable drawable, int i10, int i11, int i12, int i13) {
        C0219a.f(drawable, i10, i11, i12, i13);
    }

    public static boolean setLayoutDirection(Drawable drawable, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.b(drawable, i10);
        }
        if (!f17405b) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f17404a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e10) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e10);
            }
            f17405b = true;
        }
        Method method = f17404a;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i10));
                return true;
            } catch (Exception e11) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e11);
                f17404a = null;
            }
        }
        return false;
    }

    public static void setTint(Drawable drawable, int i10) {
        C0219a.g(drawable, i10);
    }

    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        C0219a.h(drawable, colorStateList);
    }

    public static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
        C0219a.i(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(Drawable drawable) {
        return drawable instanceof d ? (T) ((d) drawable).getWrappedDrawable() : drawable;
    }

    public static Drawable wrap(Drawable drawable) {
        return (Build.VERSION.SDK_INT < 23 && !(drawable instanceof c)) ? new f(drawable) : drawable;
    }
}
