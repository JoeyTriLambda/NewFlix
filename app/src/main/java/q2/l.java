package q2;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi19.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f17791a = true;

    /* renamed from: b, reason: collision with root package name */
    public static Method f17792b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f17793c;

    /* renamed from: d, reason: collision with root package name */
    public static Field f17794d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f17795e;

    /* compiled from: ViewUtilsApi19.java */
    public static class a {
        public static float a(View view) {
            return view.getTransitionAlpha();
        }

        public static void b(View view, float f10) {
            view.setTransitionAlpha(f10);
        }
    }

    @SuppressLint({"NewApi"})
    public float getTransitionAlpha(View view) {
        if (f17791a) {
            try {
                return a.a(view);
            } catch (NoSuchMethodError unused) {
                f17791a = false;
            }
        }
        return view.getAlpha();
    }

    @SuppressLint({"BanUncheckedReflection"})
    public void setLeftTopRightBottom(View view, int i10, int i11, int i12, int i13) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!f17793c) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
                f17792b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e10) {
                Log.i("ViewUtilsApi19", "Failed to retrieve setFrame method", e10);
            }
            f17793c = true;
        }
        Method method = f17792b;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11.getCause());
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void setTransitionAlpha(View view, float f10) {
        if (f17791a) {
            try {
                a.b(view, f10);
                return;
            } catch (NoSuchMethodError unused) {
                f17791a = false;
            }
        }
        view.setAlpha(f10);
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public void setTransitionVisibility(View view, int i10) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (!f17795e) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f17794d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            f17795e = true;
        }
        Field field = f17794d;
        if (field != null) {
            try {
                f17794d.setInt(view, i10 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void clearNonTransitionAlpha(View view) {
    }

    public void saveNonTransitionAlpha(View view) {
    }
}
