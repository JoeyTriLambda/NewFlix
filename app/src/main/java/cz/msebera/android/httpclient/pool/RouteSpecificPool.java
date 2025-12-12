package cz.msebera.android.httpclient.pool;

import cz.msebera.android.httpclient.pool.PoolEntry;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
abstract class RouteSpecificPool<T, C, E extends PoolEntry<T, C>> {
    private final T route;
    private final Set<E> leased = new HashSet();
    private final LinkedList<E> available = new LinkedList<>();
    private final LinkedList<Future<E>> pending = new LinkedList<>();

    public RouteSpecificPool(T t10) {
        this.route = t10;
    }

    public E add(C c10) {
        E e10 = (E) createEntry(c10);
        this.leased.add(e10);
        return e10;
    }

    public abstract E createEntry(C c10);

    public void free(E e10, boolean z10) {
        Args.notNull(e10, "Pool entry");
        Asserts.check(this.leased.remove(e10), "Entry %s has not been leased from this pool", e10);
        if (z10) {
            this.available.addFirst(e10);
        }
    }

    public int getAllocatedCount() {
        return this.leased.size() + this.available.size();
    }

    public int getAvailableCount() {
        return this.available.size();
    }

    public E getFree(Object obj) {
        if (this.available.isEmpty()) {
            return null;
        }
        if (obj != null) {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (obj.equals(next.getState())) {
                    it.remove();
                    this.leased.add(next);
                    return next;
                }
            }
        }
        Iterator<E> it2 = this.available.iterator();
        while (it2.hasNext()) {
            E next2 = it2.next();
            if (next2.getState() == null) {
                it2.remove();
                this.leased.add(next2);
                return next2;
            }
        }
        return null;
    }

    public E getLastUsed() {
        if (this.available.isEmpty()) {
            return null;
        }
        return this.available.getLast();
    }

    public int getLeasedCount() {
        return this.leased.size();
    }

    public int getPendingCount() {
        return this.pending.size();
    }

    public final T getRoute() {
        return this.route;
    }

    public Future<E> nextPending() {
        return this.pending.poll();
    }

    public void queue(Future<E> future) {
        if (future == null) {
            return;
        }
        this.pending.add(future);
    }

    public boolean remove(E e10) {
        Args.notNull(e10, "Pool entry");
        return this.available.remove(e10) || this.leased.remove(e10);
    }

    public void shutdown() {
        Iterator<Future<E>> it = this.pending.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
        this.pending.clear();
        Iterator<E> it2 = this.available.iterator();
        while (it2.hasNext()) {
            it2.next().close();
        }
        this.available.clear();
        Iterator<E> it3 = this.leased.iterator();
        while (it3.hasNext()) {
            it3.next().close();
        }
        this.leased.clear();
    }

    public String toString() {
        return "[route: " + this.route + "][leased: " + this.leased.size() + "][available: " + this.available.size() + "][pending: " + this.pending.size() + "]";
    }

    public void unqueue(Future<E> future) {
        if (future == null) {
            return;
        }
        this.pending.remove(future);
    }
}
