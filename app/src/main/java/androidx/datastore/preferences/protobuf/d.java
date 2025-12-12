package androidx.datastore.preferences.protobuf;

/* compiled from: Android.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f2429a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f2430b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f2429a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f2430b = cls2 != null;
    }

    public static boolean a() {
        return (f2429a == null || f2430b) ? false : true;
    }
}
