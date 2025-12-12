package b0;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ArraySet.java */
/* loaded from: classes.dex */
public final class d<E> implements Collection<E>, Set<E> {

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f4649p = new int[0];

    /* renamed from: q, reason: collision with root package name */
    public static final Object[] f4650q = new Object[0];

    /* renamed from: r, reason: collision with root package name */
    public static Object[] f4651r;

    /* renamed from: s, reason: collision with root package name */
    public static int f4652s;

    /* renamed from: t, reason: collision with root package name */
    public static Object[] f4653t;

    /* renamed from: u, reason: collision with root package name */
    public static int f4654u;

    /* renamed from: b, reason: collision with root package name */
    public int[] f4655b;

    /* renamed from: m, reason: collision with root package name */
    public Object[] f4656m;

    /* renamed from: n, reason: collision with root package name */
    public int f4657n;

    /* renamed from: o, reason: collision with root package name */
    public c f4658o;

    public d() {
        this(0);
    }

    public static void b(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (d.class) {
                if (f4654u < 10) {
                    objArr[0] = f4653t;
                    objArr[1] = iArr;
                    for (int i11 = i10 - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    f4653t = objArr;
                    f4654u++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (d.class) {
                if (f4652s < 10) {
                    objArr[0] = f4651r;
                    objArr[1] = iArr;
                    for (int i12 = i10 - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f4651r = objArr;
                    f4652s++;
                }
            }
        }
    }

    public final void a(int i10) {
        if (i10 == 8) {
            synchronized (d.class) {
                Object[] objArr = f4653t;
                if (objArr != null) {
                    this.f4656m = objArr;
                    f4653t = (Object[]) objArr[0];
                    this.f4655b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f4654u--;
                    return;
                }
            }
        } else if (i10 == 4) {
            synchronized (d.class) {
                Object[] objArr2 = f4651r;
                if (objArr2 != null) {
                    this.f4656m = objArr2;
                    f4651r = (Object[]) objArr2[0];
                    this.f4655b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f4652s--;
                    return;
                }
            }
        }
        this.f4655b = new int[i10];
        this.f4656m = new Object[i10];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e10) {
        int i10;
        int iC;
        if (e10 == null) {
            iC = d();
            i10 = 0;
        } else {
            int iHashCode = e10.hashCode();
            i10 = iHashCode;
            iC = c(iHashCode, e10);
        }
        if (iC >= 0) {
            return false;
        }
        int i11 = ~iC;
        int i12 = this.f4657n;
        int[] iArr = this.f4655b;
        if (i12 >= iArr.length) {
            int i13 = 8;
            if (i12 >= 8) {
                i13 = (i12 >> 1) + i12;
            } else if (i12 < 4) {
                i13 = 4;
            }
            Object[] objArr = this.f4656m;
            a(i13);
            int[] iArr2 = this.f4655b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f4656m, 0, objArr.length);
            }
            b(iArr, objArr, this.f4657n);
        }
        int i14 = this.f4657n;
        if (i11 < i14) {
            int[] iArr3 = this.f4655b;
            int i15 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i15, i14 - i11);
            Object[] objArr2 = this.f4656m;
            System.arraycopy(objArr2, i11, objArr2, i15, this.f4657n - i11);
        }
        this.f4655b[i11] = i10;
        this.f4656m[i11] = e10;
        this.f4657n++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        ensureCapacity(collection.size() + this.f4657n);
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final int c(int i10, Object obj) {
        int i11 = this.f4657n;
        if (i11 == 0) {
            return -1;
        }
        int iA = g.a(i11, i10, this.f4655b);
        if (iA < 0 || obj.equals(this.f4656m[iA])) {
            return iA;
        }
        int i12 = iA + 1;
        while (i12 < i11 && this.f4655b[i12] == i10) {
            if (obj.equals(this.f4656m[i12])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iA - 1; i13 >= 0 && this.f4655b[i13] == i10; i13--) {
            if (obj.equals(this.f4656m[i13])) {
                return i13;
            }
        }
        return ~i12;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i10 = this.f4657n;
        if (i10 != 0) {
            b(this.f4655b, this.f4656m, i10);
            this.f4655b = f4649p;
            this.f4656m = f4650q;
            this.f4657n = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int d() {
        int i10 = this.f4657n;
        if (i10 == 0) {
            return -1;
        }
        int iA = g.a(i10, 0, this.f4655b);
        if (iA < 0 || this.f4656m[iA] == null) {
            return iA;
        }
        int i11 = iA + 1;
        while (i11 < i10 && this.f4655b[i11] == 0) {
            if (this.f4656m[i11] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iA - 1; i12 >= 0 && this.f4655b[i12] == 0; i12--) {
            if (this.f4656m[i12] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    public void ensureCapacity(int i10) {
        int[] iArr = this.f4655b;
        if (iArr.length < i10) {
            Object[] objArr = this.f4656m;
            a(i10);
            int i11 = this.f4657n;
            if (i11 > 0) {
                System.arraycopy(iArr, 0, this.f4655b, 0, i11);
                System.arraycopy(objArr, 0, this.f4656m, 0, this.f4657n);
            }
            b(iArr, objArr, this.f4657n);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f4657n; i10++) {
                try {
                    if (!set.contains(valueAt(i10))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f4655b;
        int i10 = this.f4657n;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    public int indexOf(Object obj) {
        return obj == null ? d() : c(obj.hashCode(), obj);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f4657n <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        if (this.f4658o == null) {
            this.f4658o = new c(this);
        }
        return (Iterator<E>) this.f4658o.getKeySet().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    public E removeAt(int i10) {
        Object[] objArr = this.f4656m;
        E e10 = (E) objArr[i10];
        int i11 = this.f4657n;
        if (i11 <= 1) {
            b(this.f4655b, objArr, i11);
            this.f4655b = f4649p;
            this.f4656m = f4650q;
            this.f4657n = 0;
        } else {
            int[] iArr = this.f4655b;
            if (iArr.length <= 8 || i11 >= iArr.length / 3) {
                int i12 = i11 - 1;
                this.f4657n = i12;
                if (i10 < i12) {
                    int i13 = i10 + 1;
                    System.arraycopy(iArr, i13, iArr, i10, i12 - i10);
                    Object[] objArr2 = this.f4656m;
                    System.arraycopy(objArr2, i13, objArr2, i10, this.f4657n - i10);
                }
                this.f4656m[this.f4657n] = null;
            } else {
                a(i11 > 8 ? i11 + (i11 >> 1) : 8);
                this.f4657n--;
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.f4655b, 0, i10);
                    System.arraycopy(objArr, 0, this.f4656m, 0, i10);
                }
                int i14 = this.f4657n;
                if (i10 < i14) {
                    int i15 = i10 + 1;
                    System.arraycopy(iArr, i15, this.f4655b, i10, i14 - i10);
                    System.arraycopy(objArr, i15, this.f4656m, i10, this.f4657n - i10);
                }
            }
        }
        return e10;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z10 = false;
        for (int i10 = this.f4657n - 1; i10 >= 0; i10--) {
            if (!collection.contains(this.f4656m[i10])) {
                removeAt(i10);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f4657n;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i10 = this.f4657n;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.f4656m, 0, objArr, 0, i10);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f4657n * 14);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f4657n; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            E eValueAt = valueAt(i10);
            if (eValueAt != this) {
                sb2.append(eValueAt);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public E valueAt(int i10) {
        return (E) this.f4656m[i10];
    }

    public d(int i10) {
        if (i10 == 0) {
            this.f4655b = f4649p;
            this.f4656m = f4650q;
        } else {
            a(i10);
        }
        this.f4657n = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f4657n) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f4657n));
        }
        System.arraycopy(this.f4656m, 0, tArr, 0, this.f4657n);
        int length = tArr.length;
        int i10 = this.f4657n;
        if (length > i10) {
            tArr[i10] = null;
        }
        return tArr;
    }
}
