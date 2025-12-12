package v9;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* compiled from: ReflectionAccessFilterHelper.java */
/* loaded from: classes.dex */
public final class x {

    /* compiled from: ReflectionAccessFilterHelper.java */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f20643a;

        /* compiled from: ReflectionAccessFilterHelper.java */
        /* renamed from: v9.x$a$a, reason: collision with other inner class name */
        public class C0297a extends a {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Method f20644b;

            public C0297a(Method method) {
                this.f20644b = method;
            }

            @Override // v9.x.a
            public boolean canAccess(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f20644b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e10) {
                    throw new RuntimeException("Failed invoking canAccess", e10);
                }
            }
        }

        /* compiled from: ReflectionAccessFilterHelper.java */
        public class b extends a {
            @Override // v9.x.a
            public boolean canAccess(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        static {
            a c0297a;
            if (s.isJava9OrLater()) {
                try {
                    c0297a = new C0297a(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
                } catch (NoSuchMethodException unused) {
                }
            } else {
                c0297a = null;
            }
            if (c0297a == null) {
                c0297a = new b();
            }
            f20643a = c0297a;
        }

        public abstract boolean canAccess(AccessibleObject accessibleObject, Object obj);
    }

    public static boolean canAccess(AccessibleObject accessibleObject, Object obj) {
        return a.f20643a.canAccess(accessibleObject, obj);
    }

    public static ReflectionAccessFilter.FilterResult getFilterResult(List<ReflectionAccessFilter> list, Class<?> cls) {
        Iterator<ReflectionAccessFilter> it = list.iterator();
        while (it.hasNext()) {
            ReflectionAccessFilter.FilterResult filterResultCheck = it.next().check(cls);
            if (filterResultCheck != ReflectionAccessFilter.FilterResult.INDECISIVE) {
                return filterResultCheck;
            }
        }
        return ReflectionAccessFilter.FilterResult.ALLOW;
    }
}
