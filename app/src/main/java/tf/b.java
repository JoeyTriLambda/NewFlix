package tf;

import zf.i;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f19915a;

    static {
        a aVar;
        Object objNewInstance;
        try {
            objNewInstance = vf.a.class.newInstance();
            i.checkNotNullExpressionValue(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                } catch (ClassCastException e10) {
                    ClassLoader classLoader = objNewInstance.getClass().getClassLoader();
                    ClassLoader classLoader2 = a.class.getClassLoader();
                    if (i.areEqual(classLoader, classLoader2)) {
                        throw e10;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e10);
                }
            } catch (ClassNotFoundException unused) {
                Object objNewInstance2 = uf.a.class.newInstance();
                i.checkNotNullExpressionValue(objNewInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                        if (objNewInstance2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        aVar = (a) objNewInstance2;
                    } catch (ClassCastException e11) {
                        ClassLoader classLoader3 = objNewInstance2.getClass().getClassLoader();
                        ClassLoader classLoader4 = a.class.getClassLoader();
                        if (i.areEqual(classLoader3, classLoader4)) {
                            throw e11;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e11);
                    }
                } catch (ClassNotFoundException unused2) {
                    aVar = new a();
                }
            }
        } catch (ClassNotFoundException unused3) {
            Object objNewInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
            i.checkNotNullExpressionValue(objNewInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                    if (objNewInstance3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) objNewInstance3;
                } catch (ClassCastException e12) {
                    ClassLoader classLoader5 = objNewInstance3.getClass().getClassLoader();
                    ClassLoader classLoader6 = a.class.getClassLoader();
                    if (i.areEqual(classLoader5, classLoader6)) {
                        throw e12;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e12);
                }
            } catch (ClassNotFoundException unused4) {
                Object objNewInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                i.checkNotNullExpressionValue(objNewInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (objNewInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) objNewInstance4;
                } catch (ClassCastException e13) {
                    ClassLoader classLoader7 = objNewInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = a.class.getClassLoader();
                    if (i.areEqual(classLoader7, classLoader8)) {
                        throw e13;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e13);
                }
            }
        }
        if (objNewInstance == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        }
        aVar = (a) objNewInstance;
        f19915a = aVar;
    }
}
