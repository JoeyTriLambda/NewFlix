package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ClassesInfoCache.java */
@Deprecated
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f3475c = new a();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3476a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3477b = new HashMap();

    /* compiled from: ClassesInfoCache.java */
    @Deprecated
    /* renamed from: androidx.lifecycle.a$a, reason: collision with other inner class name */
    public static class C0030a {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f3478a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final Map<b, Lifecycle.Event> f3479b;

        public C0030a(HashMap map) {
            this.f3479b = map;
            for (Map.Entry entry : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) entry.getValue();
                List arrayList = (List) this.f3478a.get(event);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f3478a.put(event, arrayList);
                }
                arrayList.add((b) entry.getKey());
            }
        }

        public static void a(List<b> list, l lVar, Lifecycle.Event event, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    b bVar = list.get(size);
                    bVar.getClass();
                    try {
                        int i10 = bVar.f3480a;
                        Method method = bVar.f3481b;
                        if (i10 == 0) {
                            method.invoke(obj, new Object[0]);
                        } else if (i10 == 1) {
                            method.invoke(obj, lVar);
                        } else if (i10 == 2) {
                            method.invoke(obj, lVar, event);
                        }
                    } catch (IllegalAccessException e10) {
                        throw new RuntimeException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new RuntimeException("Failed to call observer method", e11.getCause());
                    }
                }
            }
        }
    }

    /* compiled from: ClassesInfoCache.java */
    @Deprecated
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f3480a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f3481b;

        public b(Method method, int i10) throws SecurityException {
            this.f3480a = i10;
            this.f3481b = method;
            method.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3480a == bVar.f3480a && this.f3481b.getName().equals(bVar.f3481b.getName());
        }

        public int hashCode() {
            return this.f3481b.getName().hashCode() + (this.f3480a * 31);
        }
    }

    public static void c(HashMap map, b bVar, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = (Lifecycle.Event) map.get(bVar);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(bVar, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f3481b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }

    public final C0030a a(Class<?> cls, Method[] methodArr) throws SecurityException {
        int i10;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null) {
            map.putAll(b(superclass).f3479b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, Lifecycle.Event> entry : b(cls2).f3479b.entrySet()) {
                c(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e10) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
            }
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            t tVar = (t) method.getAnnotation(t.class);
            if (tVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i10 = 0;
                } else {
                    if (!l.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i10 = 1;
                }
                Lifecycle.Event eventValue = tVar.value();
                if (parameterTypes.length > 1) {
                    if (!Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (eventValue != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i10 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                c(map, new b(method, i10), eventValue, cls);
                z10 = true;
            }
        }
        C0030a c0030a = new C0030a(map);
        this.f3476a.put(cls, c0030a);
        this.f3477b.put(cls, Boolean.valueOf(z10));
        return c0030a;
    }

    public final C0030a b(Class<?> cls) {
        C0030a c0030a = (C0030a) this.f3476a.get(cls);
        return c0030a != null ? c0030a : a(cls, null);
    }
}
