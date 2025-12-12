package androidx.fragment.app;

import androidx.fragment.app.Fragment;

/* compiled from: FragmentFactory.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public static final b0.k<ClassLoader, b0.k<String, Class<?>>> f2926a = new b0.k<>();

    public static Class<?> a(ClassLoader classLoader, String str) throws ClassNotFoundException {
        b0.k<ClassLoader, b0.k<String, Class<?>>> kVar = f2926a;
        b0.k<String, Class<?>> kVar2 = kVar.get(classLoader);
        if (kVar2 == null) {
            kVar2 = new b0.k<>();
            kVar.put(classLoader, kVar2);
        }
        Class<?> cls = kVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        kVar2.put(str, cls2);
        return cls2;
    }

    public static Class<? extends Fragment> loadFragmentClass(ClassLoader classLoader, String str) {
        try {
            return a(classLoader, str);
        } catch (ClassCastException e10) {
            throw new Fragment.InstantiationException(ac.c.k("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e10);
        } catch (ClassNotFoundException e11) {
            throw new Fragment.InstantiationException(ac.c.k("Unable to instantiate fragment ", str, ": make sure class name exists"), e11);
        }
    }

    public Fragment instantiate(ClassLoader classLoader, String str) {
        throw null;
    }
}
