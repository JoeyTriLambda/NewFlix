package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: UnmodifiableLazyStringList.java */
/* loaded from: classes.dex */
public final class i1 extends AbstractList<String> implements a0, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public final a0 f2482b;

    /* compiled from: UnmodifiableLazyStringList.java */
    public class a implements ListIterator<String> {

        /* renamed from: b, reason: collision with root package name */
        public final ListIterator<String> f2483b;

        public a(i1 i1Var, int i10) {
            this.f2483b = i1Var.f2482b.listIterator(i10);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f2483b.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f2483b.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f2483b.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f2483b.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public String next() {
            return this.f2483b.next();
        }

        @Override // java.util.ListIterator
        public String previous() {
            return this.f2483b.previous();
        }

        @Override // java.util.ListIterator
        public void set(String str) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: UnmodifiableLazyStringList.java */
    public class b implements Iterator<String> {

        /* renamed from: b, reason: collision with root package name */
        public final Iterator<String> f2484b;

        public b(i1 i1Var) {
            this.f2484b = i1Var.f2482b.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2484b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public String next() {
            return this.f2484b.next();
        }
    }

    public i1(a0 a0Var) {
        this.f2482b = a0Var;
    }

    @Override // androidx.datastore.preferences.protobuf.a0
    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.datastore.preferences.protobuf.a0
    public Object getRaw(int i10) {
        return this.f2482b.getRaw(i10);
    }

    @Override // androidx.datastore.preferences.protobuf.a0
    public List<?> getUnderlyingElements() {
        return this.f2482b.getUnderlyingElements();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i10) {
        return new a(this, i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2482b.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i10) {
        return (String) this.f2482b.get(i10);
    }

    @Override // androidx.datastore.preferences.protobuf.a0
    public a0 getUnmodifiableView() {
        return this;
    }
}
