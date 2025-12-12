package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/* compiled from: Lifecycling.kt */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f3503a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f3504b = new HashMap();

    public static e a(Constructor constructor, Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            zf.i.checkNotNullExpressionValue(objNewInstance, "{\n            constructo…tance(`object`)\n        }");
            return (e) objNewInstance;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(java.lang.Class r12) throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.p.b(java.lang.Class):int");
    }

    public static final String getAdapterName(String str) {
        zf.i.checkNotNullParameter(str, "className");
        return ac.c.o(new StringBuilder(), ig.l.replace$default(str, ".", "_", false, 4, (Object) null), "_LifecycleAdapter");
    }

    public static final j lifecycleEventObserver(Object obj) {
        zf.i.checkNotNullParameter(obj, "object");
        boolean z10 = obj instanceof j;
        boolean z11 = obj instanceof c;
        if (z10 && z11) {
            return new DefaultLifecycleObserverAdapter((c) obj, (j) obj);
        }
        if (z11) {
            return new DefaultLifecycleObserverAdapter((c) obj, null);
        }
        if (z10) {
            return (j) obj;
        }
        Class<?> cls = obj.getClass();
        if (b(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        Object obj2 = f3504b.get(cls);
        zf.i.checkNotNull(obj2);
        List list = (List) obj2;
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a((Constructor) list.get(0), obj));
        }
        int size = list.size();
        e[] eVarArr = new e[size];
        for (int i10 = 0; i10 < size; i10++) {
            eVarArr[i10] = a((Constructor) list.get(i10), obj);
        }
        return new CompositeGeneratedAdaptersObserver(eVarArr);
    }
}
