package com.google.common.collect;

import c8.i;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: u, reason: collision with root package name */
    public static final Object f9606u = new Object();

    /* renamed from: b, reason: collision with root package name */
    public transient Object f9607b;

    /* renamed from: m, reason: collision with root package name */
    public transient int[] f9608m;

    /* renamed from: n, reason: collision with root package name */
    public transient Object[] f9609n;

    /* renamed from: o, reason: collision with root package name */
    public transient Object[] f9610o;

    /* renamed from: p, reason: collision with root package name */
    public transient int f9611p;

    /* renamed from: q, reason: collision with root package name */
    public transient int f9612q;

    /* renamed from: r, reason: collision with root package name */
    public transient c f9613r;

    /* renamed from: s, reason: collision with root package name */
    public transient a f9614s;

    /* renamed from: t, reason: collision with root package name */
    public transient e f9615t;

    public class a extends AbstractSet<Map.Entry<K, V>> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map<K, V> mapA = compactHashMap.a();
            if (mapA != null) {
                return mapA.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iB = compactHashMap.b(entry.getKey());
            return iB != -1 && b8.d.equal(compactHashMap.k(iB), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map<K, V> mapA = compactHashMap.a();
            return mapA != null ? mapA.entrySet().iterator() : new com.google.common.collect.b(compactHashMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map<K, V> mapA = compactHashMap.a();
            if (mapA != null) {
                return mapA.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (compactHashMap.e()) {
                return false;
            }
            int i10 = (1 << (compactHashMap.f9611p & 31)) - 1;
            Object key = entry.getKey();
            Object value = entry.getValue();
            Object obj2 = compactHashMap.f9607b;
            Objects.requireNonNull(obj2);
            int i11 = i.i(key, value, i10, obj2, compactHashMap.g(), compactHashMap.h(), compactHashMap.i());
            if (i11 == -1) {
                return false;
            }
            compactHashMap.d(i11, i10);
            compactHashMap.f9612q--;
            compactHashMap.f9611p += 32;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public abstract class b<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public int f9617b;

        /* renamed from: m, reason: collision with root package name */
        public int f9618m;

        /* renamed from: n, reason: collision with root package name */
        public int f9619n;

        public b() {
            this.f9617b = CompactHashMap.this.f9611p;
            this.f9618m = CompactHashMap.this.isEmpty() ? -1 : 0;
            this.f9619n = -1;
        }

        public abstract T a(int i10);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9618m >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            CompactHashMap compactHashMap = CompactHashMap.this;
            if (compactHashMap.f9611p != this.f9617b) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i10 = this.f9618m;
            this.f9619n = i10;
            T tA = a(i10);
            int i11 = this.f9618m + 1;
            if (i11 >= compactHashMap.f9612q) {
                i11 = -1;
            }
            this.f9618m = i11;
            return tA;
        }

        @Override // java.util.Iterator
        public void remove() {
            CompactHashMap compactHashMap = CompactHashMap.this;
            if (compactHashMap.f9611p != this.f9617b) {
                throw new ConcurrentModificationException();
            }
            b8.e.checkState(this.f9619n >= 0, "no calls to next() since the last call to remove()");
            this.f9617b += 32;
            compactHashMap.remove(compactHashMap.c(this.f9619n));
            this.f9618m--;
            this.f9619n = -1;
        }
    }

    public class c extends AbstractSet<K> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map<K, V> mapA = compactHashMap.a();
            return mapA != null ? mapA.keySet().iterator() : new com.google.common.collect.a(compactHashMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map<K, V> mapA = compactHashMap.a();
            return mapA != null ? mapA.keySet().remove(obj) : compactHashMap.f(obj) != CompactHashMap.f9606u;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public final class d extends c8.b<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final K f9622b;

        /* renamed from: m, reason: collision with root package name */
        public int f9623m;

        public d(int i10) {
            Object obj = CompactHashMap.f9606u;
            this.f9622b = (K) CompactHashMap.this.c(i10);
            this.f9623m = i10;
        }

        public final void a() {
            int i10 = this.f9623m;
            K k10 = this.f9622b;
            CompactHashMap compactHashMap = CompactHashMap.this;
            if (i10 == -1 || i10 >= compactHashMap.size() || !b8.d.equal(k10, compactHashMap.c(this.f9623m))) {
                Object obj = CompactHashMap.f9606u;
                this.f9623m = compactHashMap.b(k10);
            }
        }

        @Override // c8.b, java.util.Map.Entry
        public K getKey() {
            return this.f9622b;
        }

        @Override // c8.b, java.util.Map.Entry
        public V getValue() {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map<K, V> mapA = compactHashMap.a();
            if (mapA != null) {
                return mapA.get(this.f9622b);
            }
            a();
            int i10 = this.f9623m;
            if (i10 == -1) {
                return null;
            }
            return (V) compactHashMap.k(i10);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map<K, V> mapA = compactHashMap.a();
            K k10 = this.f9622b;
            if (mapA != null) {
                return mapA.put(k10, v10);
            }
            a();
            int i10 = this.f9623m;
            if (i10 == -1) {
                compactHashMap.put(k10, v10);
                return null;
            }
            V v11 = (V) compactHashMap.k(i10);
            compactHashMap.i()[this.f9623m] = v10;
            return v11;
        }
    }

    public class e extends AbstractCollection<V> {
        public e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map<K, V> mapA = compactHashMap.a();
            return mapA != null ? mapA.values().iterator() : new com.google.common.collect.c(compactHashMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public CompactHashMap() {
        b8.e.checkArgument(true, "Expected size must be >= 0");
        this.f9611p = d8.a.constrainToRange(3, 1, 1073741823);
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public final Map<K, V> a() {
        Object obj = this.f9607b;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final int b(Object obj) {
        if (e()) {
            return -1;
        }
        int iK = i.k(obj);
        int i10 = (1 << (this.f9611p & 31)) - 1;
        Object obj2 = this.f9607b;
        Objects.requireNonNull(obj2);
        int iL = i.l(iK & i10, obj2);
        if (iL == 0) {
            return -1;
        }
        int i11 = ~i10;
        int i12 = iK & i11;
        do {
            int i13 = iL - 1;
            int i14 = g()[i13];
            if ((i14 & i11) == i12 && b8.d.equal(obj, c(i13))) {
                return i13;
            }
            iL = i14 & i10;
        } while (iL != 0);
        return -1;
    }

    public final K c(int i10) {
        return (K) h()[i10];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (e()) {
            return;
        }
        this.f9611p += 32;
        Map<K, V> mapA = a();
        if (mapA != null) {
            this.f9611p = d8.a.constrainToRange(size(), 3, 1073741823);
            mapA.clear();
            this.f9607b = null;
            this.f9612q = 0;
            return;
        }
        Arrays.fill(h(), 0, this.f9612q, (Object) null);
        Arrays.fill(i(), 0, this.f9612q, (Object) null);
        Object obj = this.f9607b;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(g(), 0, this.f9612q, 0);
        this.f9612q = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<K, V> mapA = a();
        return mapA != null ? mapA.containsKey(obj) : b(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map<K, V> mapA = a();
        if (mapA != null) {
            return mapA.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.f9612q; i10++) {
            if (b8.d.equal(obj, k(i10))) {
                return true;
            }
        }
        return false;
    }

    public final void d(int i10, int i11) {
        Object obj = this.f9607b;
        Objects.requireNonNull(obj);
        int[] iArrG = g();
        Object[] objArrH = h();
        Object[] objArrI = i();
        int size = size() - 1;
        if (i10 >= size) {
            objArrH[i10] = null;
            objArrI[i10] = null;
            iArrG[i10] = 0;
            return;
        }
        Object obj2 = objArrH[size];
        objArrH[i10] = obj2;
        objArrI[i10] = objArrI[size];
        objArrH[size] = null;
        objArrI[size] = null;
        iArrG[i10] = iArrG[size];
        iArrG[size] = 0;
        int iK = i.k(obj2) & i11;
        int iL = i.l(iK, obj);
        int i12 = size + 1;
        if (iL == i12) {
            i.m(iK, i10 + 1, obj);
            return;
        }
        while (true) {
            int i13 = iL - 1;
            int i14 = iArrG[i13];
            int i15 = i14 & i11;
            if (i15 == i12) {
                iArrG[i13] = ((i10 + 1) & i11) | (i14 & (~i11));
                return;
            }
            iL = i15;
        }
    }

    public final boolean e() {
        return this.f9607b == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        a aVar = this.f9614s;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        this.f9614s = aVar2;
        return aVar2;
    }

    public final Object f(Object obj) {
        boolean zE = e();
        Object obj2 = f9606u;
        if (zE) {
            return obj2;
        }
        int i10 = (1 << (this.f9611p & 31)) - 1;
        Object obj3 = this.f9607b;
        Objects.requireNonNull(obj3);
        int i11 = i.i(obj, null, i10, obj3, g(), h(), null);
        if (i11 == -1) {
            return obj2;
        }
        V vK = k(i11);
        d(i11, i10);
        this.f9612q--;
        this.f9611p += 32;
        return vK;
    }

    public final int[] g() {
        int[] iArr = this.f9608m;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Map<K, V> mapA = a();
        if (mapA != null) {
            return mapA.get(obj);
        }
        int iB = b(obj);
        if (iB == -1) {
            return null;
        }
        return k(iB);
    }

    public final Object[] h() {
        Object[] objArr = this.f9609n;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object[] i() {
        Object[] objArr = this.f9610o;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final int j(int i10, int i11, int i12, int i13) {
        Object objB = i.b(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            i.m(i12 & i14, i13 + 1, objB);
        }
        Object obj = this.f9607b;
        Objects.requireNonNull(obj);
        int[] iArrG = g();
        for (int i15 = 0; i15 <= i10; i15++) {
            int iL = i.l(i15, obj);
            while (iL != 0) {
                int i16 = iL - 1;
                int i17 = iArrG[i16];
                int i18 = ((~i10) & i17) | i15;
                int i19 = i18 & i14;
                int iL2 = i.l(i19, objB);
                i.m(i19, iL, objB);
                iArrG[i16] = ((~i14) & i18) | (iL2 & i14);
                iL = i17 & i10;
            }
        }
        this.f9607b = objB;
        this.f9611p = ((32 - Integer.numberOfLeadingZeros(i14)) & 31) | (this.f9611p & (-32));
        return i14;
    }

    public final V k(int i10) {
        return (V) i()[i10];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        c cVar = this.f9613r;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f9613r = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        int iMin;
        if (e()) {
            b8.e.checkState(e(), "Arrays already allocated");
            int i10 = this.f9611p;
            int iMax = Math.max(i10 + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > ((int) (iHighestOneBit * 1.0d)) && (iHighestOneBit = iHighestOneBit << 1) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.f9607b = i.b(iMax2);
            this.f9611p = ((32 - Integer.numberOfLeadingZeros(iMax2 - 1)) & 31) | (this.f9611p & (-32));
            this.f9608m = new int[i10];
            this.f9609n = new Object[i10];
            this.f9610o = new Object[i10];
        }
        Map<K, V> mapA = a();
        if (mapA != null) {
            return mapA.put(k10, v10);
        }
        int[] iArrG = g();
        Object[] objArrH = h();
        Object[] objArrI = i();
        int i11 = this.f9612q;
        int i12 = i11 + 1;
        int iK = i.k(k10);
        int iJ = (1 << (this.f9611p & 31)) - 1;
        int i13 = iK & iJ;
        Object obj = this.f9607b;
        Objects.requireNonNull(obj);
        int iL = i.l(i13, obj);
        if (iL != 0) {
            int i14 = ~iJ;
            int i15 = iK & i14;
            int i16 = 0;
            while (true) {
                int i17 = iL - 1;
                int i18 = iArrG[i17];
                int i19 = i18 & i14;
                if (i19 == i15 && b8.d.equal(k10, objArrH[i17])) {
                    V v11 = (V) objArrI[i17];
                    objArrI[i17] = v10;
                    return v11;
                }
                int i20 = i18 & iJ;
                int i21 = i15;
                int i22 = i16 + 1;
                if (i20 != 0) {
                    iL = i20;
                    i16 = i22;
                    i15 = i21;
                } else {
                    if (i22 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(((1 << (this.f9611p & 31)) - 1) + 1, 1.0f);
                        int i23 = isEmpty() ? -1 : 0;
                        while (i23 >= 0) {
                            linkedHashMap.put(c(i23), k(i23));
                            i23++;
                            if (i23 >= this.f9612q) {
                                i23 = -1;
                            }
                        }
                        this.f9607b = linkedHashMap;
                        this.f9608m = null;
                        this.f9609n = null;
                        this.f9610o = null;
                        this.f9611p += 32;
                        return (V) linkedHashMap.put(k10, v10);
                    }
                    if (i12 > iJ) {
                        iJ = j(iJ, (iJ + 1) * (iJ < 32 ? 4 : 2), iK, i11);
                    } else {
                        iArrG[i17] = (i12 & iJ) | i19;
                    }
                }
            }
        } else if (i12 > iJ) {
            iJ = j(iJ, (iJ + 1) * (iJ < 32 ? 4 : 2), iK, i11);
        } else {
            Object obj2 = this.f9607b;
            Objects.requireNonNull(obj2);
            i.m(i13, i12, obj2);
        }
        int length = g().length;
        if (i12 > length && (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.f9608m = Arrays.copyOf(g(), iMin);
            this.f9609n = Arrays.copyOf(h(), iMin);
            this.f9610o = Arrays.copyOf(i(), iMin);
        }
        g()[i11] = ((~iJ) & iK) | (iJ & 0);
        h()[i11] = k10;
        i()[i11] = v10;
        this.f9612q = i12;
        this.f9611p += 32;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Map<K, V> mapA = a();
        if (mapA != null) {
            return mapA.remove(obj);
        }
        V v10 = (V) f(obj);
        if (v10 == f9606u) {
            return null;
        }
        return v10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> mapA = a();
        return mapA != null ? mapA.size() : this.f9612q;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        e eVar = this.f9615t;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        this.f9615t = eVar2;
        return eVar2;
    }
}
