package androidx.datastore.preferences.protobuf;

/* compiled from: ExtensionRegistryFactory.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f2497a;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        f2497a = cls;
    }

    public static n createEmpty() {
        Class<?> cls = f2497a;
        if (cls != null) {
            try {
                return (n) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return n.f2499c;
    }
}
