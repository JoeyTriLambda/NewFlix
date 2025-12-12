package mf;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ArrayDeque.kt */
/* loaded from: classes2.dex */
public final class f<E> extends c<E> {

    /* renamed from: o, reason: collision with root package name */
    public static final a f16303o = new a(null);

    /* renamed from: p, reason: collision with root package name */
    public static final Object[] f16304p = new Object[0];

    /* renamed from: b, reason: collision with root package name */
    public int f16305b;

    /* renamed from: m, reason: collision with root package name */
    public Object[] f16306m = f16304p;

    /* renamed from: n, reason: collision with root package name */
    public int f16307n;

    /* compiled from: ArrayDeque.kt */
    public static final class a {
        public a(zf.f fVar) {
        }

        public final int newCapacity$kotlin_stdlib(int i10, int i11) {
            int i12 = i10 + (i10 >> 1);
            if (i12 - i11 < 0) {
                i12 = i11;
            }
            return i12 - 2147483639 > 0 ? i11 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i12;
        }
    }

    public final void a(int i10, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f16306m.length;
        while (i10 < length && it.hasNext()) {
            this.f16306m[i10] = it.next();
            i10++;
        }
        int i11 = this.f16305b;
        for (int i12 = 0; i12 < i11 && it.hasNext(); i12++) {
            this.f16306m[i12] = it.next();
        }
        this.f16307n = collection.size() + size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        addLast(e10);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        zf.i.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        b(collection.size() + size());
        a(d(size() + this.f16305b), collection);
        return true;
    }

    public final void addFirst(E e10) {
        b(size() + 1);
        int i10 = this.f16305b;
        int lastIndex = i10 == 0 ? i.getLastIndex(this.f16306m) : i10 - 1;
        this.f16305b = lastIndex;
        this.f16306m[lastIndex] = e10;
        this.f16307n = size() + 1;
    }

    public final void addLast(E e10) {
        b(size() + 1);
        this.f16306m[d(size() + this.f16305b)] = e10;
        this.f16307n = size() + 1;
    }

    public final void b(int i10) {
        if (i10 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f16306m;
        if (i10 <= objArr.length) {
            return;
        }
        if (objArr == f16304p) {
            this.f16306m = new Object[fg.h.coerceAtLeast(i10, 10)];
            return;
        }
        Object[] objArr2 = new Object[f16303o.newCapacity$kotlin_stdlib(objArr.length, i10)];
        Object[] objArr3 = this.f16306m;
        h.copyInto(objArr3, objArr2, 0, this.f16305b, objArr3.length);
        Object[] objArr4 = this.f16306m;
        int length = objArr4.length;
        int i11 = this.f16305b;
        h.copyInto(objArr4, objArr2, length - i11, 0, i11);
        this.f16305b = 0;
        this.f16306m = objArr2;
    }

    public final int c(int i10) {
        if (i10 == i.getLastIndex(this.f16306m)) {
            return 0;
        }
        return i10 + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int iD = d(size() + this.f16305b);
        int i10 = this.f16305b;
        if (i10 < iD) {
            h.fill(this.f16306m, (Object) null, i10, iD);
        } else if (!isEmpty()) {
            Object[] objArr = this.f16306m;
            h.fill(objArr, (Object) null, this.f16305b, objArr.length);
            h.fill(this.f16306m, (Object) null, 0, iD);
        }
        this.f16305b = 0;
        this.f16307n = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int d(int i10) {
        Object[] objArr = this.f16306m;
        return i10 >= objArr.length ? i10 - objArr.length : i10;
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f16306m[this.f16305b];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        mf.a.f16294b.checkElementIndex$kotlin_stdlib(i10, size());
        return (E) this.f16306m[d(this.f16305b + i10)];
    }

    @Override // mf.c
    public int getSize() {
        return this.f16307n;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i10;
        int iD = d(size() + this.f16305b);
        int length = this.f16305b;
        if (length < iD) {
            while (length < iD) {
                if (zf.i.areEqual(obj, this.f16306m[length])) {
                    i10 = this.f16305b;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iD) {
            return -1;
        }
        int length2 = this.f16306m.length;
        while (true) {
            if (length >= length2) {
                for (int i11 = 0; i11 < iD; i11++) {
                    if (zf.i.areEqual(obj, this.f16306m[i11])) {
                        length = i11 + this.f16306m.length;
                        i10 = this.f16305b;
                    }
                }
                return -1;
            }
            if (zf.i.areEqual(obj, this.f16306m[length])) {
                i10 = this.f16305b;
                break;
            }
            length++;
        }
        return length - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int lastIndex;
        int i10;
        int iD = d(size() + this.f16305b);
        int i11 = this.f16305b;
        if (i11 < iD) {
            lastIndex = iD - 1;
            if (i11 <= lastIndex) {
                while (!zf.i.areEqual(obj, this.f16306m[lastIndex])) {
                    if (lastIndex != i11) {
                        lastIndex--;
                    }
                }
                i10 = this.f16305b;
                return lastIndex - i10;
            }
            return -1;
        }
        if (i11 > iD) {
            int i12 = iD - 1;
            while (true) {
                if (-1 >= i12) {
                    lastIndex = i.getLastIndex(this.f16306m);
                    int i13 = this.f16305b;
                    if (i13 <= lastIndex) {
                        while (!zf.i.areEqual(obj, this.f16306m[lastIndex])) {
                            if (lastIndex != i13) {
                                lastIndex--;
                            }
                        }
                        i10 = this.f16305b;
                    }
                } else {
                    if (zf.i.areEqual(obj, this.f16306m[i12])) {
                        lastIndex = i12 + this.f16306m.length;
                        i10 = this.f16305b;
                        break;
                    }
                    i12--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> collection) {
        int iD;
        zf.i.checkNotNullParameter(collection, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty()) {
            if (!(this.f16306m.length == 0)) {
                int iD2 = d(size() + this.f16305b);
                int i10 = this.f16305b;
                if (i10 < iD2) {
                    iD = i10;
                    while (i10 < iD2) {
                        Object obj = this.f16306m[i10];
                        if (!collection.contains(obj)) {
                            this.f16306m[iD] = obj;
                            iD++;
                        } else {
                            z10 = true;
                        }
                        i10++;
                    }
                    h.fill(this.f16306m, (Object) null, iD, iD2);
                } else {
                    int length = this.f16306m.length;
                    int i11 = i10;
                    boolean z11 = false;
                    while (i10 < length) {
                        Object[] objArr = this.f16306m;
                        Object obj2 = objArr[i10];
                        objArr[i10] = null;
                        if (!collection.contains(obj2)) {
                            this.f16306m[i11] = obj2;
                            i11++;
                        } else {
                            z11 = true;
                        }
                        i10++;
                    }
                    iD = d(i11);
                    for (int i12 = 0; i12 < iD2; i12++) {
                        Object[] objArr2 = this.f16306m;
                        Object obj3 = objArr2[i12];
                        objArr2[i12] = null;
                        if (!collection.contains(obj3)) {
                            this.f16306m[iD] = obj3;
                            iD = c(iD);
                        } else {
                            z11 = true;
                        }
                    }
                    z10 = z11;
                }
                if (z10) {
                    int length2 = iD - this.f16305b;
                    if (length2 < 0) {
                        length2 += this.f16306m.length;
                    }
                    this.f16307n = length2;
                }
            }
        }
        return z10;
    }

    @Override // mf.c
    public E removeAt(int i10) {
        mf.a.f16294b.checkElementIndex$kotlin_stdlib(i10, size());
        if (i10 == k.getLastIndex(this)) {
            return removeLast();
        }
        if (i10 == 0) {
            return removeFirst();
        }
        int iD = d(this.f16305b + i10);
        E e10 = (E) this.f16306m[iD];
        if (i10 < (size() >> 1)) {
            int i11 = this.f16305b;
            if (iD >= i11) {
                Object[] objArr = this.f16306m;
                h.copyInto(objArr, objArr, i11 + 1, i11, iD);
            } else {
                Object[] objArr2 = this.f16306m;
                h.copyInto(objArr2, objArr2, 1, 0, iD);
                Object[] objArr3 = this.f16306m;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i12 = this.f16305b;
                h.copyInto(objArr3, objArr3, i12 + 1, i12, objArr3.length - 1);
            }
            Object[] objArr4 = this.f16306m;
            int i13 = this.f16305b;
            objArr4[i13] = null;
            this.f16305b = c(i13);
        } else {
            int iD2 = d(k.getLastIndex(this) + this.f16305b);
            if (iD <= iD2) {
                Object[] objArr5 = this.f16306m;
                h.copyInto(objArr5, objArr5, iD, iD + 1, iD2 + 1);
            } else {
                Object[] objArr6 = this.f16306m;
                h.copyInto(objArr6, objArr6, iD, iD + 1, objArr6.length);
                Object[] objArr7 = this.f16306m;
                objArr7[objArr7.length - 1] = objArr7[0];
                h.copyInto(objArr7, objArr7, 0, 1, iD2 + 1);
            }
            this.f16306m[iD2] = null;
        }
        this.f16307n = size() - 1;
        return e10;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f16306m;
        int i10 = this.f16305b;
        E e10 = (E) objArr[i10];
        objArr[i10] = null;
        this.f16305b = c(i10);
        this.f16307n = size() - 1;
        return e10;
    }

    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int iD = d(k.getLastIndex(this) + this.f16305b);
        Object[] objArr = this.f16306m;
        E e10 = (E) objArr[iD];
        objArr[iD] = null;
        this.f16307n = size() - 1;
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> collection) {
        int iD;
        zf.i.checkNotNullParameter(collection, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty()) {
            if (!(this.f16306m.length == 0)) {
                int iD2 = d(size() + this.f16305b);
                int i10 = this.f16305b;
                if (i10 < iD2) {
                    iD = i10;
                    while (i10 < iD2) {
                        Object obj = this.f16306m[i10];
                        if (collection.contains(obj)) {
                            this.f16306m[iD] = obj;
                            iD++;
                        } else {
                            z10 = true;
                        }
                        i10++;
                    }
                    h.fill(this.f16306m, (Object) null, iD, iD2);
                } else {
                    int length = this.f16306m.length;
                    int i11 = i10;
                    boolean z11 = false;
                    while (i10 < length) {
                        Object[] objArr = this.f16306m;
                        Object obj2 = objArr[i10];
                        objArr[i10] = null;
                        if (collection.contains(obj2)) {
                            this.f16306m[i11] = obj2;
                            i11++;
                        } else {
                            z11 = true;
                        }
                        i10++;
                    }
                    iD = d(i11);
                    for (int i12 = 0; i12 < iD2; i12++) {
                        Object[] objArr2 = this.f16306m;
                        Object obj3 = objArr2[i12];
                        objArr2[i12] = null;
                        if (collection.contains(obj3)) {
                            this.f16306m[iD] = obj3;
                            iD = c(iD);
                        } else {
                            z11 = true;
                        }
                    }
                    z10 = z11;
                }
                if (z10) {
                    int length2 = iD - this.f16305b;
                    if (length2 < 0) {
                        length2 += this.f16306m.length;
                    }
                    this.f16307n = length2;
                }
            }
        }
        return z10;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        mf.a.f16294b.checkElementIndex$kotlin_stdlib(i10, size());
        int iD = d(this.f16305b + i10);
        Object[] objArr = this.f16306m;
        E e11 = (E) objArr[iD];
        objArr[iD] = e10;
        return e11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        zf.i.checkNotNullParameter(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) g.arrayOfNulls(tArr, size());
        }
        int iD = d(size() + this.f16305b);
        int i10 = this.f16305b;
        if (i10 < iD) {
            h.copyInto$default(this.f16306m, tArr, 0, i10, iD, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f16306m;
            h.copyInto(objArr, tArr, 0, this.f16305b, objArr.length);
            Object[] objArr2 = this.f16306m;
            h.copyInto(objArr2, tArr, objArr2.length - this.f16305b, 0, iD);
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        mf.a.f16294b.checkPositionIndex$kotlin_stdlib(i10, size());
        if (i10 == size()) {
            addLast(e10);
            return;
        }
        if (i10 == 0) {
            addFirst(e10);
            return;
        }
        b(size() + 1);
        int iD = d(this.f16305b + i10);
        if (i10 < ((size() + 1) >> 1)) {
            int lastIndex = iD == 0 ? i.getLastIndex(this.f16306m) : iD - 1;
            int i11 = this.f16305b;
            int lastIndex2 = i11 == 0 ? i.getLastIndex(this.f16306m) : i11 - 1;
            int i12 = this.f16305b;
            if (lastIndex >= i12) {
                Object[] objArr = this.f16306m;
                objArr[lastIndex2] = objArr[i12];
                h.copyInto(objArr, objArr, i12, i12 + 1, lastIndex + 1);
            } else {
                Object[] objArr2 = this.f16306m;
                h.copyInto(objArr2, objArr2, i12 - 1, i12, objArr2.length);
                Object[] objArr3 = this.f16306m;
                objArr3[objArr3.length - 1] = objArr3[0];
                h.copyInto(objArr3, objArr3, 0, 1, lastIndex + 1);
            }
            this.f16306m[lastIndex] = e10;
            this.f16305b = lastIndex2;
        } else {
            int iD2 = d(size() + this.f16305b);
            if (iD < iD2) {
                Object[] objArr4 = this.f16306m;
                h.copyInto(objArr4, objArr4, iD + 1, iD, iD2);
            } else {
                Object[] objArr5 = this.f16306m;
                h.copyInto(objArr5, objArr5, 1, 0, iD2);
                Object[] objArr6 = this.f16306m;
                objArr6[0] = objArr6[objArr6.length - 1];
                h.copyInto(objArr6, objArr6, iD + 1, iD, objArr6.length - 1);
            }
            this.f16306m[iD] = e10;
        }
        this.f16307n = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        zf.i.checkNotNullParameter(collection, "elements");
        mf.a.f16294b.checkPositionIndex$kotlin_stdlib(i10, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i10 == size()) {
            return addAll(collection);
        }
        b(collection.size() + size());
        int iD = d(size() + this.f16305b);
        int iD2 = d(this.f16305b + i10);
        int size = collection.size();
        if (i10 < ((size() + 1) >> 1)) {
            int i11 = this.f16305b;
            int length = i11 - size;
            if (iD2 < i11) {
                Object[] objArr = this.f16306m;
                h.copyInto(objArr, objArr, length, i11, objArr.length);
                if (size >= iD2) {
                    Object[] objArr2 = this.f16306m;
                    h.copyInto(objArr2, objArr2, objArr2.length - size, 0, iD2);
                } else {
                    Object[] objArr3 = this.f16306m;
                    h.copyInto(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f16306m;
                    h.copyInto(objArr4, objArr4, 0, size, iD2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f16306m;
                h.copyInto(objArr5, objArr5, length, i11, iD2);
            } else {
                Object[] objArr6 = this.f16306m;
                length += objArr6.length;
                int i12 = iD2 - i11;
                int length2 = objArr6.length - length;
                if (length2 >= i12) {
                    h.copyInto(objArr6, objArr6, length, i11, iD2);
                } else {
                    h.copyInto(objArr6, objArr6, length, i11, i11 + length2);
                    Object[] objArr7 = this.f16306m;
                    h.copyInto(objArr7, objArr7, 0, this.f16305b + length2, iD2);
                }
            }
            this.f16305b = length;
            int length3 = iD2 - size;
            if (length3 < 0) {
                length3 += this.f16306m.length;
            }
            a(length3, collection);
        } else {
            int i13 = iD2 + size;
            if (iD2 < iD) {
                int i14 = size + iD;
                Object[] objArr8 = this.f16306m;
                if (i14 <= objArr8.length) {
                    h.copyInto(objArr8, objArr8, i13, iD2, iD);
                } else if (i13 >= objArr8.length) {
                    h.copyInto(objArr8, objArr8, i13 - objArr8.length, iD2, iD);
                } else {
                    int length4 = iD - (i14 - objArr8.length);
                    h.copyInto(objArr8, objArr8, 0, length4, iD);
                    Object[] objArr9 = this.f16306m;
                    h.copyInto(objArr9, objArr9, i13, iD2, length4);
                }
            } else {
                Object[] objArr10 = this.f16306m;
                h.copyInto(objArr10, objArr10, size, 0, iD);
                Object[] objArr11 = this.f16306m;
                if (i13 >= objArr11.length) {
                    h.copyInto(objArr11, objArr11, i13 - objArr11.length, iD2, objArr11.length);
                } else {
                    h.copyInto(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f16306m;
                    h.copyInto(objArr12, objArr12, i13, iD2, objArr12.length - size);
                }
            }
            a(iD2, collection);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
