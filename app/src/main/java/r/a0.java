package r;

import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;

/* compiled from: ResourcesFlusher.java */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static Field f18155a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f18156b;

    /* renamed from: c, reason: collision with root package name */
    public static Class<?> f18157c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f18158d;

    /* renamed from: e, reason: collision with root package name */
    public static Field f18159e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f18160f;

    /* renamed from: g, reason: collision with root package name */
    public static Field f18161g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f18162h;

    /* compiled from: ResourcesFlusher.java */
    public static class a {
        public static void a(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }

    public static void a(Object obj) throws NoSuchFieldException, SecurityException {
        LongSparseArray longSparseArray;
        if (!f18158d) {
            try {
                f18157c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e10) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e10);
            }
            f18158d = true;
        }
        Class<?> cls = f18157c;
        if (cls == null) {
            return;
        }
        if (!f18160f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f18159e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e11);
            }
            f18160f = true;
        }
        Field field = f18159e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e12) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e12);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            a.a(longSparseArray);
        }
    }
}
