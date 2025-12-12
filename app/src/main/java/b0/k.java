package b0;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: SimpleArrayMap.java */
/* loaded from: classes.dex */
public class k<K, V> {

    /* renamed from: o, reason: collision with root package name */
    public static Object[] f4689o;

    /* renamed from: p, reason: collision with root package name */
    public static int f4690p;

    /* renamed from: q, reason: collision with root package name */
    public static Object[] f4691q;

    /* renamed from: r, reason: collision with root package name */
    public static int f4692r;

    /* renamed from: b, reason: collision with root package name */
    public int[] f4693b;

    /* renamed from: m, reason: collision with root package name */
    public Object[] f4694m;

    /* renamed from: n, reason: collision with root package name */
    public int f4695n;

    public k() {
        this.f4693b = g.f4666a;
        this.f4694m = g.f4668c;
        this.f4695n = 0;
    }

    private void a(int i10) {
        if (i10 == 8) {
            synchronized (k.class) {
                Object[] objArr = f4691q;
                if (objArr != null) {
                    this.f4694m = objArr;
                    f4691q = (Object[]) objArr[0];
                    this.f4693b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f4692r--;
                    return;
                }
            }
        } else if (i10 == 4) {
            synchronized (k.class) {
                Object[] objArr2 = f4689o;
                if (objArr2 != null) {
                    this.f4694m = objArr2;
                    f4689o = (Object[]) objArr2[0];
                    this.f4693b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f4690p--;
                    return;
                }
            }
        }
        this.f4693b = new int[i10];
        this.f4694m = new Object[i10 << 1];
    }

    public static void b(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (k.class) {
                if (f4692r < 10) {
                    objArr[0] = f4691q;
                    objArr[1] = iArr;
                    for (int i11 = (i10 << 1) - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    f4691q = objArr;
                    f4692r++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (k.class) {
                if (f4690p < 10) {
                    objArr[0] = f4689o;
                    objArr[1] = iArr;
                    for (int i12 = (i10 << 1) - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f4689o = objArr;
                    f4690p++;
                }
            }
        }
    }

    public final int c(int i10, Object obj) {
        int i11 = this.f4695n;
        if (i11 == 0) {
            return -1;
        }
        try {
            int iA = g.a(i11, i10, this.f4693b);
            if (iA < 0 || obj.equals(this.f4694m[iA << 1])) {
                return iA;
            }
            int i12 = iA + 1;
            while (i12 < i11 && this.f4693b[i12] == i10) {
                if (obj.equals(this.f4694m[i12 << 1])) {
                    return i12;
                }
                i12++;
            }
            for (int i13 = iA - 1; i13 >= 0 && this.f4693b[i13] == i10; i13--) {
                if (obj.equals(this.f4694m[i13 << 1])) {
                    return i13;
                }
            }
            return ~i12;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i10 = this.f4695n;
        if (i10 > 0) {
            int[] iArr = this.f4693b;
            Object[] objArr = this.f4694m;
            this.f4693b = g.f4666a;
            this.f4694m = g.f4668c;
            this.f4695n = 0;
            b(iArr, objArr, i10);
        }
        if (this.f4695n > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return e(obj) >= 0;
    }

    public final int d() {
        int i10 = this.f4695n;
        if (i10 == 0) {
            return -1;
        }
        try {
            int iA = g.a(i10, 0, this.f4693b);
            if (iA < 0 || this.f4694m[iA << 1] == null) {
                return iA;
            }
            int i11 = iA + 1;
            while (i11 < i10 && this.f4693b[i11] == 0) {
                if (this.f4694m[i11 << 1] == null) {
                    return i11;
                }
                i11++;
            }
            for (int i12 = iA - 1; i12 >= 0 && this.f4693b[i12] == 0; i12--) {
                if (this.f4694m[i12 << 1] == null) {
                    return i12;
                }
            }
            return ~i11;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    final int e(Object obj) {
        int i10 = this.f4695n * 2;
        Object[] objArr = this.f4694m;
        if (obj == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (obj.equals(objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public void ensureCapacity(int i10) {
        int i11 = this.f4695n;
        int[] iArr = this.f4693b;
        if (iArr.length < i10) {
            Object[] objArr = this.f4694m;
            a(i10);
            if (this.f4695n > 0) {
                System.arraycopy(iArr, 0, this.f4693b, 0, i11);
                System.arraycopy(objArr, 0, this.f4694m, 0, i11 << 1);
            }
            b(iArr, objArr, i11);
        }
        if (this.f4695n != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (size() != kVar.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f4695n; i10++) {
                try {
                    K kKeyAt = keyAt(i10);
                    V vValueAt = valueAt(i10);
                    Object obj2 = kVar.get(kKeyAt);
                    if (vValueAt == null) {
                        if (obj2 != null || !kVar.containsKey(kKeyAt)) {
                            return false;
                        }
                    } else if (!vValueAt.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i11 = 0; i11 < this.f4695n; i11++) {
                try {
                    K kKeyAt2 = keyAt(i11);
                    V vValueAt2 = valueAt(i11);
                    Object obj3 = map.get(kKeyAt2);
                    if (vValueAt2 == null) {
                        if (obj3 != null || !map.containsKey(kKeyAt2)) {
                            return false;
                        }
                    } else if (!vValueAt2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v10) {
        int iIndexOfKey = indexOfKey(obj);
        return iIndexOfKey >= 0 ? (V) this.f4694m[(iIndexOfKey << 1) + 1] : v10;
    }

    public int hashCode() {
        int[] iArr = this.f4693b;
        Object[] objArr = this.f4694m;
        int i10 = this.f4695n;
        int i11 = 1;
        int i12 = 0;
        int iHashCode = 0;
        while (i12 < i10) {
            Object obj = objArr[i11];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i12];
            i12++;
            i11 += 2;
        }
        return iHashCode;
    }

    public int indexOfKey(Object obj) {
        return obj == null ? d() : c(obj.hashCode(), obj);
    }

    public boolean isEmpty() {
        return this.f4695n <= 0;
    }

    public K keyAt(int i10) {
        return (K) this.f4694m[i10 << 1];
    }

    public V put(K k10, V v10) {
        int i10;
        int iC;
        int i11 = this.f4695n;
        if (k10 == null) {
            iC = d();
            i10 = 0;
        } else {
            int iHashCode = k10.hashCode();
            i10 = iHashCode;
            iC = c(iHashCode, k10);
        }
        if (iC >= 0) {
            int i12 = (iC << 1) + 1;
            Object[] objArr = this.f4694m;
            V v11 = (V) objArr[i12];
            objArr[i12] = v10;
            return v11;
        }
        int i13 = ~iC;
        int[] iArr = this.f4693b;
        if (i11 >= iArr.length) {
            int i14 = 8;
            if (i11 >= 8) {
                i14 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i14 = 4;
            }
            Object[] objArr2 = this.f4694m;
            a(i14);
            if (i11 != this.f4695n) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f4693b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f4694m, 0, objArr2.length);
            }
            b(iArr, objArr2, i11);
        }
        if (i13 < i11) {
            int[] iArr3 = this.f4693b;
            int i15 = i13 + 1;
            System.arraycopy(iArr3, i13, iArr3, i15, i11 - i13);
            Object[] objArr3 = this.f4694m;
            System.arraycopy(objArr3, i13 << 1, objArr3, i15 << 1, (this.f4695n - i13) << 1);
        }
        int i16 = this.f4695n;
        if (i11 == i16) {
            int[] iArr4 = this.f4693b;
            if (i13 < iArr4.length) {
                iArr4[i13] = i10;
                Object[] objArr4 = this.f4694m;
                int i17 = i13 << 1;
                objArr4[i17] = k10;
                objArr4[i17 + 1] = v10;
                this.f4695n = i16 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(k<? extends K, ? extends V> kVar) {
        int i10 = kVar.f4695n;
        ensureCapacity(this.f4695n + i10);
        if (this.f4695n != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                put(kVar.keyAt(i11), kVar.valueAt(i11));
            }
        } else if (i10 > 0) {
            System.arraycopy(kVar.f4693b, 0, this.f4693b, 0, i10);
            System.arraycopy(kVar.f4694m, 0, this.f4694m, 0, i10 << 1);
            this.f4695n = i10;
        }
    }

    public V putIfAbsent(K k10, V v10) {
        V v11 = get(k10);
        return v11 == null ? put(k10, v10) : v11;
    }

    public V remove(Object obj) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey >= 0) {
            return removeAt(iIndexOfKey);
        }
        return null;
    }

    public V removeAt(int i10) {
        Object[] objArr = this.f4694m;
        int i11 = i10 << 1;
        V v10 = (V) objArr[i11 + 1];
        int i12 = this.f4695n;
        int i13 = 0;
        if (i12 <= 1) {
            b(this.f4693b, objArr, i12);
            this.f4693b = g.f4666a;
            this.f4694m = g.f4668c;
        } else {
            int i14 = i12 - 1;
            int[] iArr = this.f4693b;
            if (iArr.length <= 8 || i12 >= iArr.length / 3) {
                if (i10 < i14) {
                    int i15 = i10 + 1;
                    int i16 = i14 - i10;
                    System.arraycopy(iArr, i15, iArr, i10, i16);
                    Object[] objArr2 = this.f4694m;
                    System.arraycopy(objArr2, i15 << 1, objArr2, i11, i16 << 1);
                }
                Object[] objArr3 = this.f4694m;
                int i17 = i14 << 1;
                objArr3[i17] = null;
                objArr3[i17 + 1] = null;
            } else {
                a(i12 > 8 ? i12 + (i12 >> 1) : 8);
                if (i12 != this.f4695n) {
                    throw new ConcurrentModificationException();
                }
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.f4693b, 0, i10);
                    System.arraycopy(objArr, 0, this.f4694m, 0, i11);
                }
                if (i10 < i14) {
                    int i18 = i10 + 1;
                    int i19 = i14 - i10;
                    System.arraycopy(iArr, i18, this.f4693b, i10, i19);
                    System.arraycopy(objArr, i18 << 1, this.f4694m, i11, i19 << 1);
                }
            }
            i13 = i14;
        }
        if (i12 != this.f4695n) {
            throw new ConcurrentModificationException();
        }
        this.f4695n = i13;
        return v10;
    }

    public V replace(K k10, V v10) {
        int iIndexOfKey = indexOfKey(k10);
        if (iIndexOfKey >= 0) {
            return setValueAt(iIndexOfKey, v10);
        }
        return null;
    }

    public V setValueAt(int i10, V v10) {
        int i11 = (i10 << 1) + 1;
        Object[] objArr = this.f4694m;
        V v11 = (V) objArr[i11];
        objArr[i11] = v10;
        return v11;
    }

    public int size() {
        return this.f4695n;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f4695n * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f4695n; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            K kKeyAt = keyAt(i10);
            if (kKeyAt != this) {
                sb2.append(kKeyAt);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            V vValueAt = valueAt(i10);
            if (vValueAt != this) {
                sb2.append(vValueAt);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public V valueAt(int i10) {
        return (V) this.f4694m[(i10 << 1) + 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey < 0) {
            return false;
        }
        V vValueAt = valueAt(iIndexOfKey);
        if (obj2 != vValueAt && (obj2 == null || !obj2.equals(vValueAt))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public boolean replace(K k10, V v10, V v11) {
        int iIndexOfKey = indexOfKey(k10);
        if (iIndexOfKey < 0) {
            return false;
        }
        V vValueAt = valueAt(iIndexOfKey);
        if (vValueAt != v10 && (v10 == null || !v10.equals(vValueAt))) {
            return false;
        }
        setValueAt(iIndexOfKey, v11);
        return true;
    }

    public k(int i10) {
        if (i10 == 0) {
            this.f4693b = g.f4666a;
            this.f4694m = g.f4668c;
        } else {
            a(i10);
        }
        this.f4695n = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(k<K, V> kVar) {
        this();
        if (kVar != 0) {
            putAll(kVar);
        }
    }
}
