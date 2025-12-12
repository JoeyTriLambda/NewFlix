package cz.msebera.android.httpclient.protocol;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: classes2.dex */
final class ChainBuilder<E> {
    private final LinkedList<E> list = new LinkedList<>();
    private final Map<Class<?>, E> uniqueClasses = new HashMap();

    private void ensureUnique(E e10) {
        E eRemove = this.uniqueClasses.remove(e10.getClass());
        if (eRemove != null) {
            this.list.remove(eRemove);
        }
        this.uniqueClasses.put(e10.getClass(), e10);
    }

    public ChainBuilder<E> addAllFirst(Collection<E> collection) {
        if (collection == null) {
            return this;
        }
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            addFirst(it.next());
        }
        return this;
    }

    public ChainBuilder<E> addAllLast(Collection<E> collection) {
        if (collection == null) {
            return this;
        }
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            addLast(it.next());
        }
        return this;
    }

    public ChainBuilder<E> addFirst(E e10) {
        if (e10 == null) {
            return this;
        }
        ensureUnique(e10);
        this.list.addFirst(e10);
        return this;
    }

    public ChainBuilder<E> addLast(E e10) {
        if (e10 == null) {
            return this;
        }
        ensureUnique(e10);
        this.list.addLast(e10);
        return this;
    }

    public LinkedList<E> build() {
        return new LinkedList<>(this.list);
    }

    public ChainBuilder<E> addAllFirst(E... eArr) {
        if (eArr == null) {
            return this;
        }
        for (E e10 : eArr) {
            addFirst(e10);
        }
        return this;
    }

    public ChainBuilder<E> addAllLast(E... eArr) {
        if (eArr == null) {
            return this;
        }
        for (E e10 : eArr) {
            addLast(e10);
        }
        return this;
    }
}
