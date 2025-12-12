package x0;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.core.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;
import x0.j0;

/* compiled from: KeyEventDispatcher.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f21265a = false;

    /* renamed from: b, reason: collision with root package name */
    public static Method f21266b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f21267c = false;

    /* renamed from: d, reason: collision with root package name */
    public static Field f21268d;

    /* compiled from: KeyEventDispatcher.java */
    public interface a {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    public static boolean dispatchBeforeHierarchy(View view, KeyEvent keyEvent) {
        WeakReference<View> weakReferenceValueAt;
        int iIndexOfKey;
        WeakHashMap<View, r0> weakHashMap = j0.f21269a;
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList<WeakReference<View>> arrayList = j0.n.f21285d;
            int i10 = R.id.tag_unhandled_key_event_manager;
            j0.n nVar = (j0.n) view.getTag(i10);
            if (nVar == null) {
                nVar = new j0.n();
                view.setTag(i10, nVar);
            }
            WeakReference<KeyEvent> weakReference = nVar.f21288c;
            if (weakReference == null || weakReference.get() != keyEvent) {
                nVar.f21288c = new WeakReference<>(keyEvent);
                if (nVar.f21287b == null) {
                    nVar.f21287b = new SparseArray<>();
                }
                SparseArray<WeakReference<View>> sparseArray = nVar.f21287b;
                if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) < 0) {
                    weakReferenceValueAt = null;
                } else {
                    weakReferenceValueAt = sparseArray.valueAt(iIndexOfKey);
                    sparseArray.removeAt(iIndexOfKey);
                }
                if (weakReferenceValueAt == null) {
                    weakReferenceValueAt = sparseArray.get(keyEvent.getKeyCode());
                }
                if (weakReferenceValueAt != null) {
                    View view2 = weakReferenceValueAt.get();
                    if (view2 == null || !view2.isAttachedToWindow()) {
                        return true;
                    }
                    j0.n.b(view2, keyEvent);
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressLint({"LambdaLast"})
    public static boolean dispatchKeyEvent(a aVar, View view, Window.Callback callback, KeyEvent keyEvent) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, InvocationTargetException {
        DialogInterface.OnKeyListener onKeyListener;
        boolean zBooleanValue = false;
        if (aVar == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return aVar.superDispatchKeyEvent(keyEvent);
        }
        if (!(callback instanceof Activity)) {
            if (!(callback instanceof Dialog)) {
                return (view != null && j0.a(view, keyEvent)) || aVar.superDispatchKeyEvent(keyEvent);
            }
            Dialog dialog = (Dialog) callback;
            if (!f21267c) {
                try {
                    Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                    f21268d = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                f21267c = true;
            }
            Field field = f21268d;
            if (field != null) {
                try {
                    onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                } catch (IllegalAccessException unused2) {
                }
            } else {
                onKeyListener = null;
            }
            if (onKeyListener != null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                return true;
            }
            Window window = dialog.getWindow();
            if (window.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            View decorView = window.getDecorView();
            if (j0.a(decorView, keyEvent)) {
                return true;
            }
            return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
        }
        Activity activity = (Activity) callback;
        activity.onUserInteraction();
        Window window2 = activity.getWindow();
        if (window2.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                if (!f21265a) {
                    try {
                        f21266b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                    } catch (NoSuchMethodException unused3) {
                    }
                    f21265a = true;
                }
                Method method = f21266b;
                if (method != null) {
                    try {
                        Object objInvoke = method.invoke(actionBar, keyEvent);
                        if (objInvoke != null) {
                            zBooleanValue = ((Boolean) objInvoke).booleanValue();
                        }
                    } catch (IllegalAccessException | InvocationTargetException unused4) {
                    }
                }
                if (zBooleanValue) {
                    return true;
                }
            }
        }
        if (window2.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView2 = window2.getDecorView();
        if (j0.a(decorView2, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView2 != null ? decorView2.getKeyDispatcherState() : null, activity);
    }
}
