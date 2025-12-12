package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: ProtobufArrayList.java */
/* loaded from: classes.dex */
public final class v0<E> extends c<E> implements RandomAccess {

    /* renamed from: o, reason: collision with root package name */
    public static final v0<Object> f2542o;

    /* renamed from: m, reason: collision with root package name */
    public E[] f2543m;

    /* renamed from: n, reason: collision with root package name */
    public int f2544n;

    static {
        v0<Object> v0Var = new v0<>(new Object[0], 0);
        f2542o = v0Var;
        v0Var.makeImmutable();
    }

    public v0(E[] eArr, int i10) {
        this.f2543m = eArr;
        this.f2544n = i10;
    }

    public static <E> v0<E> emptyList() {
        return (v0<E>) f2542o;
    }

    public final void a(int i10) {
        if (i10 < 0 || i10 >= this.f2544n) {
            StringBuilder sbS = ac.c.s("Index:", i10, ", Size:");
            sbS.append(this.f2544n);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        ensureIsMutable();
        int i10 = this.f2544n;
        E[] eArr = this.f2543m;
        if (i10 == eArr.length) {
            this.f2543m = (E[]) Arrays.copyOf(eArr, ((i10 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f2543m;
        int i11 = this.f2544n;
        this.f2544n = i11 + 1;
        eArr2[i11] = e10;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        a(i10);
        return this.f2543m[i10];
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i10) {
        ensureIsMutable();
        a(i10);
        E[] eArr = this.f2543m;
        E e10 = eArr[i10];
        if (i10 < this.f2544n - 1) {
            System.arraycopy(eArr, i10 + 1, eArr, i10, (r2 - i10) - 1);
        }
        this.f2544n--;
        ((AbstractList) this).modCount++;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        ensureIsMutable();
        a(i10);
        E[] eArr = this.f2543m;
        E e11 = eArr[i10];
        eArr[i10] = e10;
        ((AbstractList) this).modCount++;
        return e11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2544n;
    }

    @Override // androidx.datastore.preferences.protobuf.w.h
    public v0<E> mutableCopyWithCapacity(int i10) {
        if (i10 >= this.f2544n) {
            return new v0<>(Arrays.copyOf(this.f2543m, i10), this.f2544n);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        int i11;
        ensureIsMutable();
        if (i10 >= 0 && i10 <= (i11 = this.f2544n)) {
            E[] eArr = this.f2543m;
            if (i11 < eArr.length) {
                System.arraycopy(eArr, i10, eArr, i10 + 1, i11 - i10);
            } else {
                E[] eArr2 = (E[]) new Object[ac.c.a(i11, 3, 2, 1)];
                System.arraycopy(eArr, 0, eArr2, 0, i10);
                System.arraycopy(this.f2543m, i10, eArr2, i10 + 1, this.f2544n - i10);
                this.f2543m = eArr2;
            }
            this.f2543m[i10] = e10;
            this.f2544n++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbS = ac.c.s("Index:", i10, ", Size:");
        sbS.append(this.f2544n);
        throw new IndexOutOfBoundsException(sbS.toString());
    }
}
