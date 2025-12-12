package b0;

/* compiled from: LongSparseArray.java */
/* loaded from: classes.dex */
public final class h<E> implements Cloneable {

    /* renamed from: p, reason: collision with root package name */
    public static final Object f4669p = new Object();

    /* renamed from: b, reason: collision with root package name */
    public boolean f4670b;

    /* renamed from: m, reason: collision with root package name */
    public long[] f4671m;

    /* renamed from: n, reason: collision with root package name */
    public Object[] f4672n;

    /* renamed from: o, reason: collision with root package name */
    public int f4673o;

    public h() {
        this(10);
    }

    public final void a() {
        int i10 = this.f4673o;
        long[] jArr = this.f4671m;
        Object[] objArr = this.f4672n;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f4669p) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f4670b = false;
        this.f4673o = i11;
    }

    public void append(long j10, E e10) {
        int i10 = this.f4673o;
        if (i10 != 0 && j10 <= this.f4671m[i10 - 1]) {
            put(j10, e10);
            return;
        }
        if (this.f4670b && i10 >= this.f4671m.length) {
            a();
        }
        int i11 = this.f4673o;
        if (i11 >= this.f4671m.length) {
            int iIdealLongArraySize = g.idealLongArraySize(i11 + 1);
            long[] jArr = new long[iIdealLongArraySize];
            Object[] objArr = new Object[iIdealLongArraySize];
            long[] jArr2 = this.f4671m;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f4672n;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f4671m = jArr;
            this.f4672n = objArr;
        }
        this.f4671m[i11] = j10;
        this.f4672n[i11] = e10;
        this.f4673o = i11 + 1;
    }

    public void clear() {
        int i10 = this.f4673o;
        Object[] objArr = this.f4672n;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f4673o = 0;
        this.f4670b = false;
    }

    public boolean containsKey(long j10) {
        return indexOfKey(j10) >= 0;
    }

    public E get(long j10) {
        return get(j10, null);
    }

    public int indexOfKey(long j10) {
        if (this.f4670b) {
            a();
        }
        return g.b(this.f4671m, this.f4673o, j10);
    }

    public long keyAt(int i10) {
        if (this.f4670b) {
            a();
        }
        return this.f4671m[i10];
    }

    public void put(long j10, E e10) {
        int iB = g.b(this.f4671m, this.f4673o, j10);
        if (iB >= 0) {
            this.f4672n[iB] = e10;
            return;
        }
        int i10 = ~iB;
        int i11 = this.f4673o;
        if (i10 < i11) {
            Object[] objArr = this.f4672n;
            if (objArr[i10] == f4669p) {
                this.f4671m[i10] = j10;
                objArr[i10] = e10;
                return;
            }
        }
        if (this.f4670b && i11 >= this.f4671m.length) {
            a();
            i10 = ~g.b(this.f4671m, this.f4673o, j10);
        }
        int i12 = this.f4673o;
        if (i12 >= this.f4671m.length) {
            int iIdealLongArraySize = g.idealLongArraySize(i12 + 1);
            long[] jArr = new long[iIdealLongArraySize];
            Object[] objArr2 = new Object[iIdealLongArraySize];
            long[] jArr2 = this.f4671m;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f4672n;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f4671m = jArr;
            this.f4672n = objArr2;
        }
        int i13 = this.f4673o;
        if (i13 - i10 != 0) {
            long[] jArr3 = this.f4671m;
            int i14 = i10 + 1;
            System.arraycopy(jArr3, i10, jArr3, i14, i13 - i10);
            Object[] objArr4 = this.f4672n;
            System.arraycopy(objArr4, i10, objArr4, i14, this.f4673o - i10);
        }
        this.f4671m[i10] = j10;
        this.f4672n[i10] = e10;
        this.f4673o++;
    }

    public void remove(long j10) {
        int iB = g.b(this.f4671m, this.f4673o, j10);
        if (iB >= 0) {
            Object[] objArr = this.f4672n;
            Object obj = objArr[iB];
            Object obj2 = f4669p;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f4670b = true;
            }
        }
    }

    public void removeAt(int i10) {
        Object[] objArr = this.f4672n;
        Object obj = objArr[i10];
        Object obj2 = f4669p;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.f4670b = true;
        }
    }

    public int size() {
        if (this.f4670b) {
            a();
        }
        return this.f4673o;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f4673o * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f4673o; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(keyAt(i10));
            sb2.append('=');
            E eValueAt = valueAt(i10);
            if (eValueAt != this) {
                sb2.append(eValueAt);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public E valueAt(int i10) {
        if (this.f4670b) {
            a();
        }
        return (E) this.f4672n[i10];
    }

    public h(int i10) {
        this.f4670b = false;
        if (i10 == 0) {
            this.f4671m = g.f4667b;
            this.f4672n = g.f4668c;
        } else {
            int iIdealLongArraySize = g.idealLongArraySize(i10);
            this.f4671m = new long[iIdealLongArraySize];
            this.f4672n = new Object[iIdealLongArraySize];
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public h<E> m11clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f4671m = (long[]) this.f4671m.clone();
            hVar.f4672n = (Object[]) this.f4672n.clone();
            return hVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public E get(long j10, E e10) {
        E e11;
        int iB = g.b(this.f4671m, this.f4673o, j10);
        return (iB < 0 || (e11 = (E) this.f4672n[iB]) == f4669p) ? e10 : e11;
    }
}
