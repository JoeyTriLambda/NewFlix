package l8;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.InvalidRegistrarException;
import com.google.firebase.components.MissingDependencyException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import r.x;

/* compiled from: ComponentRuntime.java */
/* loaded from: classes.dex */
public final class j implements d, a9.a {

    /* renamed from: h, reason: collision with root package name */
    public static final i f15955h = new i(0);

    /* renamed from: e, reason: collision with root package name */
    public final m f15960e;

    /* renamed from: g, reason: collision with root package name */
    public final h f15962g;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f15956a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f15957b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f15958c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f15959d = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference<Boolean> f15961f = new AtomicReference<>();

    /* compiled from: ComponentRuntime.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Executor f15963a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f15964b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f15965c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public h f15966d = h.f15953j;

        public a(Executor executor) {
            this.f15963a = executor;
        }

        public a addComponent(b<?> bVar) {
            this.f15965c.add(bVar);
            return this;
        }

        public a addComponentRegistrar(ComponentRegistrar componentRegistrar) {
            this.f15964b.add(new e(componentRegistrar, 1));
            return this;
        }

        public a addLazyComponentRegistrars(Collection<h9.b<ComponentRegistrar>> collection) {
            this.f15964b.addAll(collection);
            return this;
        }

        public j build() {
            return new j(this.f15963a, this.f15964b, this.f15965c, this.f15966d);
        }

        public a setProcessor(h hVar) {
            this.f15966d = hVar;
            return this;
        }
    }

    public j(Executor executor, ArrayList arrayList, ArrayList arrayList2, h hVar) {
        m mVar = new m(executor);
        this.f15960e = mVar;
        this.f15962g = hVar;
        ArrayList arrayList3 = new ArrayList();
        int i10 = 1;
        arrayList3.add(b.of(mVar, m.class, f9.d.class, f9.c.class));
        arrayList3.add(b.of(this, a9.a.class, new Class[0]));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null) {
                arrayList3.add(bVar);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList4.add(it2.next());
        }
        ArrayList arrayList5 = new ArrayList();
        synchronized (this) {
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((h9.b) it3.next()).get();
                    if (componentRegistrar != null) {
                        arrayList3.addAll(this.f15962g.processRegistrar(componentRegistrar));
                        it3.remove();
                    }
                } catch (InvalidRegistrarException e10) {
                    it3.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e10);
                }
            }
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                Object[] array = ((b) it4.next()).getProvidedInterfaces().toArray();
                int length = array.length;
                int i11 = 0;
                while (true) {
                    if (i11 < length) {
                        Object obj = array[i11];
                        if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f15959d.contains(obj.toString())) {
                                it4.remove();
                                break;
                            }
                            this.f15959d.add(obj.toString());
                        }
                        i11++;
                    }
                }
            }
            if (this.f15956a.isEmpty()) {
                k.a(arrayList3);
            } else {
                ArrayList arrayList6 = new ArrayList(this.f15956a.keySet());
                arrayList6.addAll(arrayList3);
                k.a(arrayList6);
            }
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                b bVar2 = (b) it5.next();
                this.f15956a.put(bVar2, new n(new g8.d(i10, this, bVar2)));
            }
            arrayList5.addAll(c(arrayList3));
            arrayList5.addAll(d());
            b();
        }
        Iterator it6 = arrayList5.iterator();
        while (it6.hasNext()) {
            ((Runnable) it6.next()).run();
        }
        Boolean bool = this.f15961f.get();
        if (bool != null) {
            a(this.f15956a, bool.booleanValue());
        }
    }

    public static a builder(Executor executor) {
        return new a(executor);
    }

    public final void a(Map<b<?>, h9.b<?>> map, boolean z10) {
        ArrayDeque arrayDeque;
        for (Map.Entry<b<?>, h9.b<?>> entry : map.entrySet()) {
            b<?> key = entry.getKey();
            h9.b<?> value = entry.getValue();
            if (key.isAlwaysEager() || (key.isEagerInDefaultApp() && z10)) {
                value.get();
            }
        }
        m mVar = this.f15960e;
        synchronized (mVar) {
            try {
                arrayDeque = mVar.f15976b;
                if (arrayDeque != null) {
                    mVar.f15976b = null;
                } else {
                    arrayDeque = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                mVar.publish((f9.a) it.next());
            }
        }
    }

    public final void b() {
        for (b bVar : this.f15956a.keySet()) {
            for (l lVar : bVar.getDependencies()) {
                if (lVar.isSet()) {
                    r<?> rVar = lVar.getInterface();
                    HashMap map = this.f15958c;
                    if (!map.containsKey(rVar)) {
                        map.put(lVar.getInterface(), new o(Collections.emptySet()));
                    }
                }
                r<?> rVar2 = lVar.getInterface();
                HashMap map2 = this.f15957b;
                if (map2.containsKey(rVar2)) {
                    continue;
                } else {
                    if (lVar.isRequired()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", bVar, lVar.getInterface()));
                    }
                    if (!lVar.isSet()) {
                        map2.put(lVar.getInterface(), new p(p.f15983c, p.f15984d));
                    }
                }
            }
        }
    }

    public final ArrayList c(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.isValue()) {
                h9.b bVar2 = (h9.b) this.f15956a.get(bVar);
                for (r rVar : bVar.getProvidedInterfaces()) {
                    HashMap map = this.f15957b;
                    if (map.containsKey(rVar)) {
                        arrayList2.add(new x(12, (p) ((h9.b) map.get(rVar)), bVar2));
                    } else {
                        map.put(rVar, bVar2);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f15956a.entrySet()) {
            b bVar = (b) entry.getKey();
            if (!bVar.isValue()) {
                h9.b bVar2 = (h9.b) entry.getValue();
                for (r rVar : bVar.getProvidedInterfaces()) {
                    if (!map.containsKey(rVar)) {
                        map.put(rVar, new HashSet());
                    }
                    ((Set) map.get(rVar)).add(bVar2);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            Object key = entry2.getKey();
            HashMap map2 = this.f15958c;
            if (map2.containsKey(key)) {
                o oVar = (o) map2.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new x(13, oVar, (h9.b) it.next()));
                }
            } else {
                map2.put((r) entry2.getKey(), new o((Set) ((Collection) entry2.getValue())));
            }
        }
        return arrayList;
    }

    @Override // l8.d
    public final /* synthetic */ Object get(Class cls) {
        return c.a(this, cls);
    }

    @Override // l8.d
    public final /* synthetic */ h9.a getDeferred(Class cls) {
        return c.c(this, cls);
    }

    @Override // l8.d
    public final /* synthetic */ h9.b getProvider(Class cls) {
        return c.d(this, cls);
    }

    public void initializeEagerComponents(boolean z10) {
        boolean z11;
        HashMap map;
        AtomicReference<Boolean> atomicReference = this.f15961f;
        Boolean boolValueOf = Boolean.valueOf(z10);
        while (true) {
            if (atomicReference.compareAndSet(null, boolValueOf)) {
                z11 = true;
                break;
            } else if (atomicReference.get() != null) {
                z11 = false;
                break;
            }
        }
        if (z11) {
            synchronized (this) {
                map = new HashMap(this.f15956a);
            }
            a(map, z10);
        }
    }

    @Override // l8.d
    public final /* synthetic */ Set setOf(Class cls) {
        return c.e(this, cls);
    }

    @Override // l8.d
    public synchronized <T> h9.b<Set<T>> setOfProvider(r<T> rVar) {
        o oVar = (o) this.f15958c.get(rVar);
        if (oVar != null) {
            return oVar;
        }
        return f15955h;
    }

    @Override // l8.d
    public final /* synthetic */ Object get(r rVar) {
        return c.b(this, rVar);
    }

    @Override // l8.d
    public <T> h9.a<T> getDeferred(r<T> rVar) {
        h9.b<T> provider = getProvider(rVar);
        return provider == null ? new p(p.f15983c, p.f15984d) : provider instanceof p ? (p) provider : new p(null, provider);
    }

    @Override // l8.d
    public synchronized <T> h9.b<T> getProvider(r<T> rVar) {
        q.checkNotNull(rVar, "Null interface requested.");
        return (h9.b) this.f15957b.get(rVar);
    }

    @Override // l8.d
    public final /* synthetic */ Set setOf(r rVar) {
        return c.f(this, rVar);
    }
}
