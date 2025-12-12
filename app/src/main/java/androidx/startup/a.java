package androidx.startup;

import android.content.Context;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: AppInitializer.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f4350d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f4351e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f4354c;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f4353b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f4352a = new HashMap();

    public a(Context context) {
        this.f4354c = context.getApplicationContext();
    }

    public static a getInstance(Context context) {
        if (f4350d == null) {
            synchronized (f4351e) {
                if (f4350d == null) {
                    f4350d = new a(context);
                }
            }
        }
        return f4350d;
    }

    public final void a(Bundle bundle) throws ClassNotFoundException {
        HashSet hashSet;
        String string = this.f4354c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    hashSet = this.f4353b;
                    if (!zHasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (n2.a.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b(hashSet2, (Class) it2.next());
                }
            } catch (ClassNotFoundException e10) {
                throw new StartupException(e10);
            }
        }
    }

    public final Object b(HashSet hashSet, Class cls) {
        Object objCreate;
        if (p2.a.isEnabled()) {
            try {
                p2.a.beginSection(cls.getSimpleName());
            } finally {
                p2.a.endSection();
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        HashMap map = this.f4352a;
        if (map.containsKey(cls)) {
            objCreate = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                n2.a aVar = (n2.a) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends n2.a<?>>> listDependencies = aVar.dependencies();
                if (!listDependencies.isEmpty()) {
                    for (Class<? extends n2.a<?>> cls2 : listDependencies) {
                        if (!map.containsKey(cls2)) {
                            b(hashSet, cls2);
                        }
                    }
                }
                objCreate = aVar.create(this.f4354c);
                hashSet.remove(cls);
                map.put(cls, objCreate);
            } catch (Throwable th2) {
                throw new StartupException(th2);
            }
        }
        return objCreate;
    }

    public <T> T initializeComponent(Class<? extends n2.a<T>> cls) {
        T t10;
        synchronized (f4351e) {
            t10 = (T) this.f4352a.get(cls);
            if (t10 == null) {
                t10 = (T) b(new HashSet(), cls);
            }
        }
        return t10;
    }

    public boolean isEagerlyInitialized(Class<? extends n2.a<?>> cls) {
        return this.f4353b.contains(cls);
    }
}
