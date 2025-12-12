package b0;

/* compiled from: SparseArrayCompat.java */
/* loaded from: classes.dex */
public final class l<E> implements Cloneable {

    /* renamed from: o, reason: collision with root package name */
    public static final Object f4696o = new Object();

    /* renamed from: b, reason: collision with root package name */
    public int[] f4697b;

    /* renamed from: m, reason: collision with root package name */
    public Object[] f4698m;

    /* renamed from: n, reason: collision with root package name */
    public int f4699n;

    public l() {
        this(10);
    }

    public void append(int i10, E e10) {
        int i11 = this.f4699n;
        if (i11 != 0 && i10 <= this.f4697b[i11 - 1]) {
            put(i10, e10);
            return;
        }
        if (i11 >= this.f4697b.length) {
            int iIdealIntArraySize = g.idealIntArraySize(i11 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            Object[] objArr = new Object[iIdealIntArraySize];
            int[] iArr2 = this.f4697b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f4698m;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f4697b = iArr;
            this.f4698m = objArr;
        }
        this.f4697b[i11] = i10;
        this.f4698m[i11] = e10;
        this.f4699n = i11 + 1;
    }

    public void clear() {
        int i10 = this.f4699n;
        Object[] objArr = this.f4698m;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f4699n = 0;
    }

    public E get(int i10) {
        return get(i10, null);
    }

    public int indexOfValue(E e10) {
        for (int i10 = 0; i10 < this.f4699n; i10++) {
            if (this.f4698m[i10] == e10) {
                return i10;
            }
        }
        return -1;
    }

    public int keyAt(int i10) {
        return this.f4697b[i10];
    }

    public void put(int i10, E e10) {
        int iA = g.a(this.f4699n, i10, this.f4697b);
        if (iA >= 0) {
            this.f4698m[iA] = e10;
            return;
        }
        int i11 = ~iA;
        int i12 = this.f4699n;
        if (i11 < i12) {
            Object[] objArr = this.f4698m;
            if (objArr[i11] == f4696o) {
                this.f4697b[i11] = i10;
                objArr[i11] = e10;
                return;
            }
        }
        if (i12 >= this.f4697b.length) {
            int iIdealIntArraySize = g.idealIntArraySize(i12 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            Object[] objArr2 = new Object[iIdealIntArraySize];
            int[] iArr2 = this.f4697b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f4698m;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f4697b = iArr;
            this.f4698m = objArr2;
        }
        int i13 = this.f4699n;
        if (i13 - i11 != 0) {
            int[] iArr3 = this.f4697b;
            int i14 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i14, i13 - i11);
            Object[] objArr4 = this.f4698m;
            System.arraycopy(objArr4, i11, objArr4, i14, this.f4699n - i11);
        }
        this.f4697b[i11] = i10;
        this.f4698m[i11] = e10;
        this.f4699n++;
    }

    public int size() {
        return this.f4699n;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f4699n * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f4699n; i10++) {
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
        return (E) this.f4698m[i10];
    }

    public l(int i10) {
        if (i10 == 0) {
            this.f4697b = g.f4666a;
            this.f4698m = g.f4668c;
        } else {
            int iIdealIntArraySize = g.idealIntArraySize(i10);
            this.f4697b = new int[iIdealIntArraySize];
            this.f4698m = new Object[iIdealIntArraySize];
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public l<E> m12clone() {
        try {
            l<E> lVar = (l) super.clone();
            lVar.f4697b = (int[]) this.f4697b.clone();
            lVar.f4698m = (Object[]) this.f4698m.clone();
            return lVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public E get(int i10, E e10) {
        E e11;
        int iA = g.a(this.f4699n, i10, this.f4697b);
        return (iA < 0 || (e11 = (E) this.f4698m[iA]) == f4696o) ? e10 : e11;
    }
}
