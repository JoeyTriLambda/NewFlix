package l8;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import r.x;

/* compiled from: EventBus.java */
/* loaded from: classes.dex */
public final class m implements f9.d, f9.c {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f15975a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public ArrayDeque f15976b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final Executor f15977c;

    public m(Executor executor) {
        this.f15977c = executor;
    }

    public final synchronized Set<Map.Entry<f9.b<Object>, Executor>> a(f9.a<?> aVar) {
        Map map;
        map = (Map) this.f15975a.get(aVar.getType());
        return map == null ? Collections.emptySet() : map.entrySet();
    }

    public void publish(f9.a<?> aVar) {
        q.checkNotNull(aVar);
        synchronized (this) {
            ArrayDeque arrayDeque = this.f15976b;
            if (arrayDeque != null) {
                arrayDeque.add(aVar);
                return;
            }
            for (Map.Entry<f9.b<Object>, Executor> entry : a(aVar)) {
                entry.getValue().execute(new x(14, entry, aVar));
            }
        }
    }

    @Override // f9.d
    public synchronized <T> void subscribe(Class<T> cls, Executor executor, f9.b<? super T> bVar) {
        q.checkNotNull(cls);
        q.checkNotNull(bVar);
        q.checkNotNull(executor);
        if (!this.f15975a.containsKey(cls)) {
            this.f15975a.put(cls, new ConcurrentHashMap());
        }
        ((ConcurrentHashMap) this.f15975a.get(cls)).put(bVar, executor);
    }
}
