package cf;

/* compiled from: OpenHashSet.java */
/* loaded from: classes2.dex */
public final class h<T> {

    /* renamed from: a, reason: collision with root package name */
    public final float f5276a;

    /* renamed from: b, reason: collision with root package name */
    public int f5277b;

    /* renamed from: c, reason: collision with root package name */
    public int f5278c;

    /* renamed from: d, reason: collision with root package name */
    public int f5279d;

    /* renamed from: e, reason: collision with root package name */
    public T[] f5280e;

    public h() {
        this(16, 0.75f);
    }

    public final void a(int i10, int i11, Object[] objArr) {
        int i12;
        Object obj;
        this.f5278c--;
        while (true) {
            int i13 = i10 + 1;
            while (true) {
                i12 = i13 & i11;
                obj = objArr[i12];
                if (obj == null) {
                    objArr[i10] = null;
                    return;
                }
                int iHashCode = obj.hashCode() * (-1640531527);
                int i14 = (iHashCode ^ (iHashCode >>> 16)) & i11;
                if (i10 <= i12) {
                    if (i10 >= i14 || i14 > i12) {
                        break;
                    } else {
                        i13 = i12 + 1;
                    }
                } else if (i10 < i14 || i14 <= i12) {
                    i13 = i12 + 1;
                }
            }
            objArr[i10] = obj;
            i10 = i12;
        }
    }

    public boolean add(T t10) {
        T t11;
        T t12;
        T[] tArr = this.f5280e;
        int i10 = this.f5277b;
        int iHashCode = t10.hashCode() * (-1640531527);
        int i11 = (iHashCode ^ (iHashCode >>> 16)) & i10;
        T t13 = tArr[i11];
        if (t13 != null) {
            if (t13.equals(t10)) {
                return false;
            }
            do {
                i11 = (i11 + 1) & i10;
                t12 = tArr[i11];
                if (t12 == null) {
                }
            } while (!t12.equals(t10));
            return false;
        }
        tArr[i11] = t10;
        int i12 = this.f5278c + 1;
        this.f5278c = i12;
        if (i12 >= this.f5279d) {
            T[] tArr2 = this.f5280e;
            int length = tArr2.length;
            int i13 = length << 1;
            int i14 = i13 - 1;
            T[] tArr3 = (T[]) new Object[i13];
            while (true) {
                int i15 = i12 - 1;
                if (i12 == 0) {
                    break;
                }
                do {
                    length--;
                    t11 = tArr2[length];
                } while (t11 == null);
                int iHashCode2 = t11.hashCode() * (-1640531527);
                int i16 = (iHashCode2 ^ (iHashCode2 >>> 16)) & i14;
                if (tArr3[i16] != null) {
                    do {
                        i16 = (i16 + 1) & i14;
                    } while (tArr3[i16] != null);
                }
                tArr3[i16] = tArr2[length];
                i12 = i15;
            }
            this.f5277b = i14;
            this.f5279d = (int) (i13 * this.f5276a);
            this.f5280e = tArr3;
        }
        return true;
    }

    public Object[] keys() {
        return this.f5280e;
    }

    public boolean remove(T t10) {
        T t11;
        T[] tArr = this.f5280e;
        int i10 = this.f5277b;
        int iHashCode = t10.hashCode() * (-1640531527);
        int i11 = (iHashCode ^ (iHashCode >>> 16)) & i10;
        T t12 = tArr[i11];
        if (t12 == null) {
            return false;
        }
        if (t12.equals(t10)) {
            a(i11, i10, tArr);
            return true;
        }
        do {
            i11 = (i11 + 1) & i10;
            t11 = tArr[i11];
            if (t11 == null) {
                return false;
            }
        } while (!t11.equals(t10));
        a(i11, i10, tArr);
        return true;
    }

    public int size() {
        return this.f5278c;
    }

    public h(int i10, float f10) {
        this.f5276a = f10;
        int iRoundToPowerOfTwo = i.roundToPowerOfTwo(i10);
        this.f5277b = iRoundToPowerOfTwo - 1;
        this.f5279d = (int) (f10 * iRoundToPowerOfTwo);
        this.f5280e = (T[]) new Object[iRoundToPowerOfTwo];
    }
}
