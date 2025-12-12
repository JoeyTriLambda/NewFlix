package l8;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: LazySet.java */
/* loaded from: classes.dex */
public final class o<T> implements h9.b<Set<T>> {

    /* renamed from: b, reason: collision with root package name */
    public volatile Set<T> f15982b = null;

    /* renamed from: a, reason: collision with root package name */
    public volatile Set<h9.b<T>> f15981a = Collections.newSetFromMap(new ConcurrentHashMap());

    public o(Collection<h9.b<T>> collection) {
        this.f15981a.addAll(collection);
    }

    public final synchronized void a() {
        Iterator<h9.b<T>> it = this.f15981a.iterator();
        while (it.hasNext()) {
            this.f15982b.add(it.next().get());
        }
        this.f15981a = null;
    }

    @Override // h9.b
    public Set<T> get() {
        if (this.f15982b == null) {
            synchronized (this) {
                if (this.f15982b == null) {
                    this.f15982b = Collections.newSetFromMap(new ConcurrentHashMap());
                    a();
                }
            }
        }
        return Collections.unmodifiableSet(this.f15982b);
    }
}
