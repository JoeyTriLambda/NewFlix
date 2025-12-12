package org.chromium.support_lib_boundary.util;

import android.os.Build;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

/* loaded from: classes2.dex */
public class BoundaryInterfaceReflectionUtil {

    public static class InvocationHandlerWithDelegateGetter implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final Object f17114a;

        public InvocationHandlerWithDelegateGetter(Object obj) {
            this.f17114a = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Object obj2 = this.f17114a;
            try {
                return BoundaryInterfaceReflectionUtil.dupeMethod(method, obj2.getClass().getClassLoader()).invoke(obj2, objArr);
            } catch (InvocationTargetException e10) {
                throw e10.getTargetException();
            } catch (ReflectiveOperationException e11) {
                throw new RuntimeException("Reflection failed for method " + method, e11);
            }
        }
    }

    public static <T> T castToSuppLibClass(Class<T> cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(BoundaryInterfaceReflectionUtil.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static boolean containsFeature(Collection<String> collection, String str) {
        if (collection.contains(str)) {
            return true;
        }
        String str2 = Build.TYPE;
        if ("eng".equals(str2) || "userdebug".equals(str2)) {
            if (collection.contains(str + ":dev")) {
                return true;
            }
        }
        return false;
    }

    public static InvocationHandler createInvocationHandlerFor(Object obj) {
        if (obj == null) {
            return null;
        }
        return new InvocationHandlerWithDelegateGetter(obj);
    }

    public static Method dupeMethod(Method method, ClassLoader classLoader) throws NoSuchMethodException, ClassNotFoundException {
        return Class.forName(method.getDeclaringClass().getName(), true, classLoader).getDeclaredMethod(method.getName(), method.getParameterTypes());
    }
}
