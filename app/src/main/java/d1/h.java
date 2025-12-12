package d1;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: PopupWindowCompat.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static Method f10779a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f10780b;

    /* renamed from: c, reason: collision with root package name */
    public static Field f10781c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f10782d;

    /* compiled from: PopupWindowCompat.java */
    public static class a {
        public static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        public static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        public static void c(PopupWindow popupWindow, boolean z10) {
            popupWindow.setOverlapAnchor(z10);
        }

        public static void d(PopupWindow popupWindow, int i10) {
            popupWindow.setWindowLayoutType(i10);
        }
    }

    public static void setOverlapAnchor(PopupWindow popupWindow, boolean z10) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 23) {
            a.c(popupWindow, z10);
            return;
        }
        if (!f10782d) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f10781c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e10);
            }
            f10782d = true;
        }
        Field field = f10781c;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z10));
            } catch (IllegalAccessException e11) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e11);
            }
        }
    }

    public static void setWindowLayoutType(PopupWindow popupWindow, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 23) {
            a.d(popupWindow, i10);
            return;
        }
        if (!f10780b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f10779a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f10780b = true;
        }
        Method method = f10779a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i10));
            } catch (Exception unused2) {
            }
        }
    }

    public static void showAsDropDown(PopupWindow popupWindow, View view, int i10, int i11, int i12) {
        popupWindow.showAsDropDown(view, i10, i11, i12);
    }
}
