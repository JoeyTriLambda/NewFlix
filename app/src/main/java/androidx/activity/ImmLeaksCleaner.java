package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.j {

    /* renamed from: m, reason: collision with root package name */
    public static int f771m;

    /* renamed from: n, reason: collision with root package name */
    public static Field f772n;

    /* renamed from: o, reason: collision with root package name */
    public static Field f773o;

    /* renamed from: p, reason: collision with root package name */
    public static Field f774p;

    /* renamed from: b, reason: collision with root package name */
    public final Activity f775b;

    public ImmLeaksCleaner(Activity activity) {
        this.f775b = activity;
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(androidx.lifecycle.l lVar, Lifecycle.Event event) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (f771m == 0) {
            try {
                f771m = 2;
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                f773o = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                f774p = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                f772n = declaredField3;
                declaredField3.setAccessible(true);
                f771m = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f771m == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f775b.getSystemService("input_method");
            try {
                Object obj = f772n.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f773o.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f774p.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused2) {
                            }
                        } catch (ClassCastException unused3) {
                        } catch (IllegalAccessException unused4) {
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (IllegalAccessException unused5) {
            }
        }
    }
}
