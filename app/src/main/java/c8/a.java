package c8;

import java.util.NoSuchElementException;

/* compiled from: AbstractIndexedListIterator.java */
/* loaded from: classes.dex */
public abstract class a<E> extends k<E> {

    /* renamed from: b, reason: collision with root package name */
    public final int f5246b;

    /* renamed from: m, reason: collision with root package name */
    public int f5247m;

    public a(int i10, int i11) {
        b8.e.checkPositionIndex(i11, i10);
        this.f5246b = i10;
        this.f5247m = i11;
    }

    public abstract E get(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f5247m < this.f5246b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f5247m > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f5247m;
        this.f5247m = i10 + 1;
        return get(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f5247m;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f5247m - 1;
        this.f5247m = i10;
        return get(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f5247m - 1;
    }
}
