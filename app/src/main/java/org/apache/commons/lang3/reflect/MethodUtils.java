package org.apache.commons.lang3.reflect;

import ac.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class MethodUtils {
    private static int distance(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (!ClassUtils.isAssignable(clsArr, clsArr2, true)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < clsArr.length; i11++) {
            if (!clsArr[i11].equals(clsArr2[i11])) {
                i10 = (!ClassUtils.isAssignable(clsArr[i11], clsArr2[i11], true) || ClassUtils.isAssignable(clsArr[i11], clsArr2[i11], false)) ? i10 + 2 : i10 + 1;
            }
        }
        return i10;
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return getAccessibleMethod(cls.getMethod(str, clsArr));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (Modifier.isPublic(cls2.getModifiers())) {
                    try {
                        return cls2.getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(cls2, str, clsArr);
                        if (accessibleMethodFromInterfaceNest != null) {
                            return accessibleMethodFromInterfaceNest;
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static Method getAccessibleMethodFromSuperclass(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (Modifier.isPublic(superclass.getModifiers())) {
                try {
                    return superclass.getMethod(str, clsArr);
                } catch (NoSuchMethodException unused) {
                    return null;
                }
            }
        }
        return null;
    }

    private static List<Class<?>> getAllSuperclassesAndInterfaces(Class<?> cls) {
        int i10;
        Class<?> cls2;
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<Class<?>> allSuperclasses = ClassUtils.getAllSuperclasses(cls);
        List<Class<?>> allInterfaces = ClassUtils.getAllInterfaces(cls);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= allInterfaces.size() && i12 >= allSuperclasses.size()) {
                return arrayList;
            }
            if (i11 >= allInterfaces.size()) {
                i10 = i12 + 1;
                cls2 = allSuperclasses.get(i12);
            } else if (i12 < allSuperclasses.size() && i11 >= i12 && i12 < i11) {
                i10 = i12 + 1;
                cls2 = allSuperclasses.get(i12);
            } else {
                int i13 = i11 + 1;
                Class<?> cls3 = allInterfaces.get(i11);
                int i14 = i12;
                cls2 = cls3;
                i11 = i13;
                i10 = i14;
            }
            arrayList.add(cls2);
            i12 = i10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.annotation.Annotation] */
    /* JADX WARN: Type inference failed for: r0v3, types: [A extends java.lang.annotation.Annotation] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.annotation.Annotation] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static <A extends Annotation> A getAnnotation(Method method, Class<A> cls, boolean z10, boolean z11) throws NoSuchMethodException, SecurityException {
        Validate.isTrue(method != null, "The method must not be null", new Object[0]);
        Validate.isTrue(cls != null, "The annotation class must not be null", new Object[0]);
        if (!z11 && !MemberUtils.isAccessible(method)) {
            return null;
        }
        ?? method2 = (A) method.getAnnotation(cls);
        if (method2 == 0 && z10) {
            for (Class<?> cls2 : getAllSuperclassesAndInterfaces(method.getDeclaringClass())) {
                if (z11) {
                    try {
                        method2 = (A) cls2.getDeclaredMethod(method.getName(), method.getParameterTypes());
                    } catch (NoSuchMethodException unused) {
                    }
                } else {
                    method2 = cls2.getMethod(method.getName(), method.getParameterTypes());
                }
                method2 = (A) method2.getAnnotation(cls);
                if (method2 != 0) {
                    break;
                }
            }
        }
        return (A) method2;
    }

    public static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        Method accessibleMethod;
        try {
            Method method = cls.getMethod(str, clsArr);
            MemberUtils.setAccessibleWorkaround(method);
            return method;
        } catch (NoSuchMethodException unused) {
            Method method2 = null;
            for (Method method3 : cls.getMethods()) {
                if (method3.getName().equals(str) && MemberUtils.isMatchingMethod(method3, clsArr) && (accessibleMethod = getAccessibleMethod(method3)) != null && (method2 == null || MemberUtils.compareMethodFit(accessibleMethod, method2, clsArr) < 0)) {
                    method2 = accessibleMethod;
                }
            }
            if (method2 != null) {
                MemberUtils.setAccessibleWorkaround(method2);
            }
            if (method2 != null && method2.isVarArgs() && method2.getParameterTypes().length > 0 && clsArr.length > 0) {
                String name = ClassUtils.primitiveToWrapper(method2.getParameterTypes()[r6.length - 1].getComponentType()).getName();
                String name2 = clsArr[clsArr.length - 1].getName();
                String name3 = clsArr[clsArr.length - 1].getSuperclass().getName();
                if (!name.equals(name2) && !name.equals(name3)) {
                    return null;
                }
            }
            return method2;
        }
    }

    public static Method getMatchingMethod(Class<?> cls, String str, Class<?>... clsArr) throws SecurityException {
        Validate.notNull(cls, "Null class not allowed.", new Object[0]);
        Validate.notEmpty(str, "Null or blank methodName not allowed.", new Object[0]);
        Method[] declaredMethods = cls.getDeclaredMethods();
        Iterator<Class<?>> it = ClassUtils.getAllSuperclasses(cls).iterator();
        while (it.hasNext()) {
            declaredMethods = (Method[]) ArrayUtils.addAll(declaredMethods, it.next().getDeclaredMethods());
        }
        Method method = null;
        for (Method method2 : declaredMethods) {
            if (str.equals(method2.getName()) && Objects.deepEquals(clsArr, method2.getParameterTypes())) {
                return method2;
            }
            if (str.equals(method2.getName()) && ClassUtils.isAssignable(clsArr, method2.getParameterTypes(), true) && (method == null || distance(clsArr, method2.getParameterTypes()) < distance(clsArr, method.getParameterTypes()))) {
                method = method2;
            }
        }
        return method;
    }

    public static List<Method> getMethodsListWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        return getMethodsListWithAnnotation(cls, cls2, false, false);
    }

    public static Method[] getMethodsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        return getMethodsWithAnnotation(cls, cls2, false, false);
    }

    public static Set<Method> getOverrideHierarchy(Method method, ClassUtils.Interfaces interfaces) throws NoSuchMethodException, SecurityException {
        Validate.notNull(method);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(method);
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> declaringClass = method.getDeclaringClass();
        Iterator<Class<?>> it = ClassUtils.hierarchy(declaringClass, interfaces).iterator();
        it.next();
        while (it.hasNext()) {
            Method matchingAccessibleMethod = getMatchingAccessibleMethod(it.next(), method.getName(), parameterTypes);
            if (matchingAccessibleMethod != null) {
                if (!Arrays.equals(matchingAccessibleMethod.getParameterTypes(), parameterTypes)) {
                    Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(declaringClass, matchingAccessibleMethod.getDeclaringClass());
                    int i10 = 0;
                    while (true) {
                        if (i10 >= parameterTypes.length) {
                            linkedHashSet.add(matchingAccessibleMethod);
                            break;
                        }
                        if (!TypeUtils.equals(TypeUtils.unrollVariables(typeArguments, method.getGenericParameterTypes()[i10]), TypeUtils.unrollVariables(typeArguments, matchingAccessibleMethod.getGenericParameterTypes()[i10]))) {
                            break;
                        }
                        i10++;
                    }
                } else {
                    linkedHashSet.add(matchingAccessibleMethod);
                }
            }
        }
        return linkedHashSet;
    }

    public static Object[] getVarArgs(Object[] objArr, Class<?>[] clsArr) throws NegativeArraySizeException {
        if (objArr.length == clsArr.length && objArr[objArr.length - 1].getClass().equals(clsArr[clsArr.length - 1])) {
            return objArr;
        }
        Object[] objArr2 = new Object[clsArr.length];
        System.arraycopy(objArr, 0, objArr2, 0, clsArr.length - 1);
        Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
        int length = (objArr.length - clsArr.length) + 1;
        Object objNewInstance = Array.newInstance(ClassUtils.primitiveToWrapper(componentType), length);
        System.arraycopy(objArr, clsArr.length - 1, objNewInstance, 0, length);
        if (componentType.isPrimitive()) {
            objNewInstance = ArrayUtils.toPrimitive(objNewInstance);
        }
        objArr2[clsArr.length - 1] = objNewInstance;
        return objArr2;
    }

    public static Object invokeExactMethod(Object obj, String str) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return invokeExactMethod(obj, str, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method accessibleMethod = getAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArr));
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(null, objArrNullToEmpty);
        }
        StringBuilder sbV = c.v("No such accessible method: ", str, "() on class: ");
        sbV.append(cls.getName());
        throw new NoSuchMethodException(sbV.toString());
    }

    public static Object invokeMethod(Object obj, String str) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return invokeMethod(obj, str, ArrayUtils.EMPTY_OBJECT_ARRAY, (Class<?>[]) null);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeStaticMethod(cls, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    private static Object[] toVarArgs(Method method, Object[] objArr) {
        return method.isVarArgs() ? getVarArgs(objArr, method.getParameterTypes()) : objArr;
    }

    public static Method getAccessibleMethod(Method method) {
        if (!MemberUtils.isAccessible(method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (Modifier.isPublic(declaringClass.getModifiers())) {
            return method;
        }
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(declaringClass, name, parameterTypes);
        return accessibleMethodFromInterfaceNest == null ? getAccessibleMethodFromSuperclass(declaringClass, name, parameterTypes) : accessibleMethodFromInterfaceNest;
    }

    public static List<Method> getMethodsListWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2, boolean z10, boolean z11) {
        Validate.isTrue(cls != null, "The class must not be null", new Object[0]);
        Validate.isTrue(cls2 != null, "The annotation class must not be null", new Object[0]);
        List<Class> allSuperclassesAndInterfaces = z10 ? getAllSuperclassesAndInterfaces(cls) : new ArrayList();
        allSuperclassesAndInterfaces.add(0, cls);
        ArrayList arrayList = new ArrayList();
        for (Class cls3 : allSuperclassesAndInterfaces) {
            for (Method method : z11 ? cls3.getDeclaredMethods() : cls3.getMethods()) {
                if (method.getAnnotation(cls2) != null) {
                    arrayList.add(method);
                }
            }
        }
        return arrayList;
    }

    public static Method[] getMethodsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2, boolean z10, boolean z11) {
        List<Method> methodsListWithAnnotation = getMethodsListWithAnnotation(cls, cls2, z10, z11);
        return (Method[]) methodsListWithAnnotation.toArray(new Method[methodsListWithAnnotation.size()]);
    }

    public static Object invokeExactMethod(Object obj, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeExactMethod(obj, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    public static Object invokeMethod(Object obj, boolean z10, String str) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return invokeMethod(obj, z10, str, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeMethod(obj, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArr));
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke(null, toVarArgs(matchingAccessibleMethod, objArrNullToEmpty));
        }
        StringBuilder sbV = c.v("No such accessible method: ", str, "() on class: ");
        sbV.append(cls.getName());
        throw new NoSuchMethodException(sbV.toString());
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, ArrayUtils.nullToEmpty(clsArr));
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(obj, objArrNullToEmpty);
        }
        StringBuilder sbV = c.v("No such accessible method: ", str, "() on object: ");
        sbV.append(obj.getClass().getName());
        throw new NoSuchMethodException(sbV.toString());
    }

    public static Object invokeMethod(Object obj, boolean z10, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeMethod(obj, z10, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    public static Object invokeMethod(Object obj, boolean z10, String str, Object[] objArr, Class<?>[] clsArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
        Method matchingAccessibleMethod;
        String str2;
        Class<?>[] clsArrNullToEmpty = ArrayUtils.nullToEmpty(clsArr);
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        if (z10) {
            matchingAccessibleMethod = getMatchingMethod(obj.getClass(), str, clsArrNullToEmpty);
            if (matchingAccessibleMethod != null && !matchingAccessibleMethod.isAccessible()) {
                matchingAccessibleMethod.setAccessible(true);
            }
            str2 = "No such method: ";
        } else {
            matchingAccessibleMethod = getMatchingAccessibleMethod(obj.getClass(), str, clsArrNullToEmpty);
            str2 = "No such accessible method: ";
        }
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke(obj, toVarArgs(matchingAccessibleMethod, objArrNullToEmpty));
        }
        throw new NoSuchMethodException(str2 + str + "() on object: " + obj.getClass().getName());
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeExactStaticMethod(cls, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return invokeMethod(obj, false, str, objArr, clsArr);
    }
}
