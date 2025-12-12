package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import mf.q;
import yf.l;
import zf.e;
import zf.i;

/* compiled from: AbstractCollection.kt */
/* loaded from: classes2.dex */
public abstract class AbstractCollection<E> implements Collection<E>, ag.a {
    @Override // java.util.Collection
    public boolean add(E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean contains(E e10) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (i.areEqual(it.next(), e10)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        i.checkNotNullParameter(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract int getSize();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return e.toArray(this);
    }

    public String toString() {
        return q.joinToString$default(this, ", ", "[", "]", 0, null, new l<E, CharSequence>(this) { // from class: kotlin.collections.AbstractCollection.toString.1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbstractCollection<E> f15203b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.f15203b = this;
            }

            @Override // yf.l
            public /* bridge */ /* synthetic */ CharSequence invoke(Object obj) {
                return invoke((AnonymousClass1) obj);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // yf.l
            public final CharSequence invoke(E e10) {
                return e10 == this.f15203b ? "(this Collection)" : String.valueOf(e10);
            }
        }, 24, null);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        i.checkNotNullParameter(tArr, "array");
        return (T[]) e.toArray(this, tArr);
    }
}
