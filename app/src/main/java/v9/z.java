package v9;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* compiled from: UnsafeAllocator.java */
/* loaded from: classes.dex */
public abstract class z {

    /* compiled from: UnsafeAllocator.java */
    public class a extends z {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f20645a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f20646b;

        public a(Method method, Object obj) {
            this.f20645a = method;
            this.f20646b = obj;
        }

        @Override // v9.z
        public <T> T newInstance(Class<T> cls) throws Exception {
            z.a(cls);
            return (T) this.f20645a.invoke(this.f20646b, cls);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    public class b extends z {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f20647a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f20648b;

        public b(Method method, int i10) {
            this.f20647a = method;
            this.f20648b = i10;
        }

        @Override // v9.z
        public <T> T newInstance(Class<T> cls) throws Exception {
            z.a(cls);
            return (T) this.f20647a.invoke(null, cls, Integer.valueOf(this.f20648b));
        }
    }

    /* compiled from: UnsafeAllocator.java */
    public class c extends z {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f20649a;

        public c(Method method) {
            this.f20649a = method;
        }

        @Override // v9.z
        public <T> T newInstance(Class<T> cls) throws Exception {
            z.a(cls);
            return (T) this.f20649a.invoke(null, cls, Object.class);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    public class d extends z {
        @Override // v9.z
        public <T> T newInstance(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    public static void a(Class cls) {
        String strB = b(cls);
        if (strB != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strB));
        }
    }

    public static String b(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ".concat(cls.getName());
        }
        return null;
    }

    public static z create() throws NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    return new d();
                }
            } catch (Exception unused3) {
                Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                return new c(declaredMethod3);
            }
        }
    }

    public abstract <T> T newInstance(Class<T> cls) throws Exception;
}
