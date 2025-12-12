package c8;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Iterators.java */
/* loaded from: classes.dex */
public final class e {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterators.java */
    public class a<T> extends j<T> {

        /* renamed from: b, reason: collision with root package name */
        public boolean f5248b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Object f5249m;

        public a(Object obj) {
            this.f5249m = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f5248b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f5248b) {
                throw new NoSuchElementException();
            }
            this.f5248b = true;
            return (T) this.f5249m;
        }
    }

    public static <T> boolean addAll(Collection<T> collection, Iterator<? extends T> it) {
        b8.e.checkNotNull(collection);
        b8.e.checkNotNull(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static boolean elementsEqual(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !b8.d.equal(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static <T> j<T> singletonIterator(T t10) {
        return new a(t10);
    }
}
