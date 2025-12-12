package kotlin.collections.builders;

import fg.h;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import zf.i;

/* compiled from: MapBuilder.kt */
/* loaded from: classes2.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, ag.a {

    /* renamed from: x, reason: collision with root package name */
    public static final a f15216x = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public K[] f15217b;

    /* renamed from: m, reason: collision with root package name */
    public V[] f15218m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f15219n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f15220o;

    /* renamed from: p, reason: collision with root package name */
    public int f15221p;

    /* renamed from: q, reason: collision with root package name */
    public int f15222q;

    /* renamed from: r, reason: collision with root package name */
    public int f15223r;

    /* renamed from: s, reason: collision with root package name */
    public int f15224s;

    /* renamed from: t, reason: collision with root package name */
    public nf.d<K> f15225t;

    /* renamed from: u, reason: collision with root package name */
    public nf.e<V> f15226u;

    /* renamed from: v, reason: collision with root package name */
    public nf.c<K, V> f15227v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f15228w;

    /* compiled from: MapBuilder.kt */
    public static final class a {
        public a(zf.f fVar) {
        }

        public static final int access$computeHashSize(a aVar, int i10) {
            aVar.getClass();
            return Integer.highestOneBit(h.coerceAtLeast(i10, 1) * 3);
        }

        public static final int access$computeShift(a aVar, int i10) {
            aVar.getClass();
            return Integer.numberOfLeadingZeros(i10) + 1;
        }
    }

    /* compiled from: MapBuilder.kt */
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, ag.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            i.checkNotNullParameter(mapBuilder, "map");
        }

        public final void nextAppendString(StringBuilder sb2) {
            i.checkNotNullParameter(sb2, "sb");
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().f15222q) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object obj = getMap$kotlin_stdlib().f15217b[getLastIndex$kotlin_stdlib()];
            if (i.areEqual(obj, getMap$kotlin_stdlib())) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj);
            }
            sb2.append('=');
            Object[] objArr = getMap$kotlin_stdlib().f15218m;
            i.checkNotNull(objArr);
            Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
            if (i.areEqual(obj2, getMap$kotlin_stdlib())) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj2);
            }
            initNext$kotlin_stdlib();
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().f15222q) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object obj = getMap$kotlin_stdlib().f15217b[getLastIndex$kotlin_stdlib()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = getMap$kotlin_stdlib().f15218m;
            i.checkNotNull(objArr);
            Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            initNext$kotlin_stdlib();
            return iHashCode2;
        }

        @Override // java.util.Iterator
        public c<K, V> next() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().f15222q) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            c<K, V> cVar = new c<>(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
            initNext$kotlin_stdlib();
            return cVar;
        }
    }

    /* compiled from: MapBuilder.kt */
    public static final class c<K, V> implements Map.Entry<K, V>, ag.a {

        /* renamed from: b, reason: collision with root package name */
        public final MapBuilder<K, V> f15229b;

        /* renamed from: m, reason: collision with root package name */
        public final int f15230m;

        public c(MapBuilder<K, V> mapBuilder, int i10) {
            i.checkNotNullParameter(mapBuilder, "map");
            this.f15229b = mapBuilder;
            this.f15230m = i10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (i.areEqual(entry.getKey(), getKey()) && i.areEqual(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) this.f15229b.f15217b[this.f15230m];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = this.f15229b.f15218m;
            i.checkNotNull(objArr);
            return (V) objArr[this.f15230m];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            MapBuilder<K, V> mapBuilder = this.f15229b;
            mapBuilder.checkIsMutable$kotlin_stdlib();
            Object[] objArrAccess$allocateValuesArray = MapBuilder.access$allocateValuesArray(mapBuilder);
            int i10 = this.f15230m;
            V v11 = (V) objArrAccess$allocateValuesArray[i10];
            objArrAccess$allocateValuesArray[i10] = v10;
            return v11;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getKey());
            sb2.append('=');
            sb2.append(getValue());
            return sb2.toString();
        }
    }

    /* compiled from: MapBuilder.kt */
    public static class d<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final MapBuilder<K, V> f15231b;

        /* renamed from: m, reason: collision with root package name */
        public int f15232m;

        /* renamed from: n, reason: collision with root package name */
        public int f15233n;

        public d(MapBuilder<K, V> mapBuilder) {
            i.checkNotNullParameter(mapBuilder, "map");
            this.f15231b = mapBuilder;
            this.f15233n = -1;
            initNext$kotlin_stdlib();
        }

        public final int getIndex$kotlin_stdlib() {
            return this.f15232m;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.f15233n;
        }

        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.f15231b;
        }

        public final boolean hasNext() {
            return this.f15232m < this.f15231b.f15222q;
        }

        public final void initNext$kotlin_stdlib() {
            while (true) {
                int i10 = this.f15232m;
                MapBuilder<K, V> mapBuilder = this.f15231b;
                if (i10 >= mapBuilder.f15222q) {
                    return;
                }
                int[] iArr = mapBuilder.f15219n;
                int i11 = this.f15232m;
                if (iArr[i11] >= 0) {
                    return;
                } else {
                    this.f15232m = i11 + 1;
                }
            }
        }

        public final void remove() {
            if (!(this.f15233n != -1)) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            MapBuilder<K, V> mapBuilder = this.f15231b;
            mapBuilder.checkIsMutable$kotlin_stdlib();
            mapBuilder.e(this.f15233n);
            this.f15233n = -1;
        }

        public final void setIndex$kotlin_stdlib(int i10) {
            this.f15232m = i10;
        }

        public final void setLastIndex$kotlin_stdlib(int i10) {
            this.f15233n = i10;
        }
    }

    /* compiled from: MapBuilder.kt */
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, ag.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            i.checkNotNullParameter(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().f15222q) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            K k10 = (K) getMap$kotlin_stdlib().f15217b[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return k10;
        }
    }

    /* compiled from: MapBuilder.kt */
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, ag.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            i.checkNotNullParameter(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().f15222q) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object[] objArr = getMap$kotlin_stdlib().f15218m;
            i.checkNotNull(objArr);
            V v10 = (V) objArr[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return v10;
        }
    }

    public MapBuilder() {
        this(8);
    }

    public static final Object[] access$allocateValuesArray(MapBuilder mapBuilder) {
        V[] vArr = mapBuilder.f15218m;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) nf.b.arrayOfUninitializedElements(mapBuilder.getCapacity$kotlin_stdlib());
        mapBuilder.f15218m = vArr2;
        return vArr2;
    }

    public final void a(int i10) {
        int capacity$kotlin_stdlib = getCapacity$kotlin_stdlib();
        int i11 = this.f15222q;
        int i12 = capacity$kotlin_stdlib - i11;
        int size = i11 - size();
        if (i12 < i10 && i12 + size >= i10 && size >= getCapacity$kotlin_stdlib() / 4) {
            d(this.f15220o.length);
            return;
        }
        int i13 = this.f15222q + i10;
        if (i13 < 0) {
            throw new OutOfMemoryError();
        }
        if (i13 > getCapacity$kotlin_stdlib()) {
            int capacity$kotlin_stdlib2 = (getCapacity$kotlin_stdlib() * 3) / 2;
            if (i13 <= capacity$kotlin_stdlib2) {
                i13 = capacity$kotlin_stdlib2;
            }
            this.f15217b = (K[]) nf.b.copyOfUninitializedElements(this.f15217b, i13);
            V[] vArr = this.f15218m;
            this.f15218m = vArr != null ? (V[]) nf.b.copyOfUninitializedElements(vArr, i13) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.f15219n, i13);
            i.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.f15219n = iArrCopyOf;
            int iAccess$computeHashSize = a.access$computeHashSize(f15216x, i13);
            if (iAccess$computeHashSize > this.f15220o.length) {
                d(iAccess$computeHashSize);
            }
        }
    }

    public final int addKey$kotlin_stdlib(K k10) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int iC = c(k10);
            int iCoerceAtMost = h.coerceAtMost(this.f15221p * 2, this.f15220o.length / 2);
            int i10 = 0;
            while (true) {
                int i11 = this.f15220o[iC];
                if (i11 <= 0) {
                    if (this.f15222q < getCapacity$kotlin_stdlib()) {
                        int i12 = this.f15222q;
                        int i13 = i12 + 1;
                        this.f15222q = i13;
                        this.f15217b[i12] = k10;
                        this.f15219n[i12] = iC;
                        this.f15220o[iC] = i13;
                        this.f15224s = size() + 1;
                        if (i10 > this.f15221p) {
                            this.f15221p = i10;
                        }
                        return i12;
                    }
                    a(1);
                } else {
                    if (i.areEqual(this.f15217b[i11 - 1], k10)) {
                        return -i11;
                    }
                    i10++;
                    if (i10 > iCoerceAtMost) {
                        d(this.f15220o.length * 2);
                        break;
                    }
                    iC = iC == 0 ? this.f15220o.length - 1 : iC - 1;
                }
            }
        }
    }

    public final int b(K k10) {
        int iC = c(k10);
        int i10 = this.f15221p;
        while (true) {
            int i11 = this.f15220o[iC];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (i.areEqual(this.f15217b[i12], k10)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            iC = iC == 0 ? this.f15220o.length - 1 : iC - 1;
        }
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.f15228w = true;
        return this;
    }

    public final int c(K k10) {
        return ((k10 != null ? k10.hashCode() : 0) * (-1640531527)) >>> this.f15223r;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.f15228w) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator, mf.t] */
    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        ?? it = new fg.c(0, this.f15222q - 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            int[] iArr = this.f15219n;
            int i10 = iArr[iNextInt];
            if (i10 >= 0) {
                this.f15220o[i10] = 0;
                iArr[iNextInt] = -1;
            }
        }
        nf.b.resetRange(this.f15217b, 0, this.f15222q);
        V[] vArr = this.f15218m;
        if (vArr != null) {
            nf.b.resetRange(vArr, 0, this.f15222q);
        }
        this.f15224s = 0;
        this.f15222q = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> collection) {
        i.checkNotNullParameter(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        i.checkNotNullParameter(entry, "entry");
        int iB = b(entry.getKey());
        if (iB < 0) {
            return false;
        }
        V[] vArr = this.f15218m;
        i.checkNotNull(vArr);
        return i.areEqual(vArr[iB], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return b(obj) >= 0;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        int i10;
        int i11 = this.f15222q;
        while (true) {
            i10 = -1;
            i11--;
            if (i11 < 0) {
                break;
            }
            if (this.f15219n[i11] >= 0) {
                V[] vArr = this.f15218m;
                i.checkNotNull(vArr);
                if (i.areEqual(vArr[i11], obj)) {
                    i10 = i11;
                    break;
                }
            }
        }
        return i10 >= 0;
    }

    public final void d(int i10) {
        boolean z10;
        int i11;
        if (this.f15222q > size()) {
            V[] vArr = this.f15218m;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                i11 = this.f15222q;
                if (i12 >= i11) {
                    break;
                }
                if (this.f15219n[i12] >= 0) {
                    K[] kArr = this.f15217b;
                    kArr[i13] = kArr[i12];
                    if (vArr != null) {
                        vArr[i13] = vArr[i12];
                    }
                    i13++;
                }
                i12++;
            }
            nf.b.resetRange(this.f15217b, i13, i11);
            if (vArr != null) {
                nf.b.resetRange(vArr, i13, this.f15222q);
            }
            this.f15222q = i13;
        }
        int[] iArr = this.f15220o;
        if (i10 != iArr.length) {
            this.f15220o = new int[i10];
            this.f15223r = a.access$computeShift(f15216x, i10);
        } else {
            mf.h.fill(iArr, 0, 0, iArr.length);
        }
        int i14 = 0;
        while (i14 < this.f15222q) {
            int i15 = i14 + 1;
            int iC = c(this.f15217b[i14]);
            int i16 = this.f15221p;
            while (true) {
                int[] iArr2 = this.f15220o;
                z10 = true;
                if (iArr2[iC] == 0) {
                    iArr2[iC] = i15;
                    this.f15219n[i14] = iC;
                    break;
                } else {
                    i16--;
                    if (i16 < 0) {
                        z10 = false;
                        break;
                    }
                    iC = iC == 0 ? iArr2.length - 1 : iC - 1;
                }
            }
            if (!z10) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i14 = i15;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[LOOP:0: B:3:0x001a->B:27:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(int r12) {
        /*
            r11 = this;
            K[] r0 = r11.f15217b
            nf.b.resetAt(r0, r12)
            int[] r0 = r11.f15219n
            r0 = r0[r12]
            int r1 = r11.f15221p
            int r1 = r1 * 2
            int[] r2 = r11.f15220o
            int r2 = r2.length
            int r2 = r2 / 2
            int r1 = fg.h.coerceAtMost(r1, r2)
            r2 = 0
            r3 = r1
            r4 = 0
            r1 = r0
        L1a:
            int r5 = r0 + (-1)
            r6 = -1
            if (r0 != 0) goto L24
            int[] r0 = r11.f15220o
            int r0 = r0.length
            int r0 = r0 + r6
            goto L25
        L24:
            r0 = r5
        L25:
            int r4 = r4 + 1
            int r5 = r11.f15221p
            if (r4 <= r5) goto L30
            int[] r0 = r11.f15220o
            r0[r1] = r2
            goto L5f
        L30:
            int[] r5 = r11.f15220o
            r7 = r5[r0]
            if (r7 != 0) goto L39
            r5[r1] = r2
            goto L5f
        L39:
            if (r7 >= 0) goto L3e
            r5[r1] = r6
            goto L56
        L3e:
            K[] r5 = r11.f15217b
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.c(r5)
            int r5 = r5 - r0
            int[] r9 = r11.f15220o
            int r10 = r9.length
            int r10 = r10 + r6
            r5 = r5 & r10
            if (r5 < r4) goto L58
            r9[r1] = r7
            int[] r4 = r11.f15219n
            r4[r8] = r1
        L56:
            r1 = r0
            r4 = 0
        L58:
            int r3 = r3 + r6
            if (r3 >= 0) goto L1a
            int[] r0 = r11.f15220o
            r0[r1] = r6
        L5f:
            int[] r0 = r11.f15219n
            r0[r12] = r6
            int r12 = r11.size()
            int r12 = r12 + r6
            r11.f15224s = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.MapBuilder.e(int):void");
    }

    public final b<K, V> entriesIterator$kotlin_stdlib() {
        return new b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        int iB = b(obj);
        if (iB < 0) {
            return null;
        }
        V[] vArr = this.f15218m;
        i.checkNotNull(vArr);
        return vArr[iB];
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.f15217b.length;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        nf.c<K, V> cVar = this.f15227v;
        if (cVar != null) {
            return cVar;
        }
        nf.c<K, V> cVar2 = new nf.c<>(this);
        this.f15227v = cVar2;
        return cVar2;
    }

    public Set<K> getKeys() {
        nf.d<K> dVar = this.f15225t;
        if (dVar != null) {
            return dVar;
        }
        nf.d<K> dVar2 = new nf.d<>(this);
        this.f15225t = dVar2;
        return dVar2;
    }

    public int getSize() {
        return this.f15224s;
    }

    public Collection<V> getValues() {
        nf.e<V> eVar = this.f15226u;
        if (eVar != null) {
            return eVar;
        }
        nf.e<V> eVar2 = new nf.e<>(this);
        this.f15226u = eVar2;
        return eVar2;
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int iNextHashCode$kotlin_stdlib = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            iNextHashCode$kotlin_stdlib += bVarEntriesIterator$kotlin_stdlib.nextHashCode$kotlin_stdlib();
        }
        return iNextHashCode$kotlin_stdlib;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final e<K, V> keysIterator$kotlin_stdlib() {
        return new e<>(this);
    }

    @Override // java.util.Map
    public V put(K k10, V v10) {
        checkIsMutable$kotlin_stdlib();
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(k10);
        V[] vArr = this.f15218m;
        if (vArr == null) {
            vArr = (V[]) nf.b.arrayOfUninitializedElements(getCapacity$kotlin_stdlib());
            this.f15218m = vArr;
        }
        if (iAddKey$kotlin_stdlib >= 0) {
            vArr[iAddKey$kotlin_stdlib] = v10;
            return null;
        }
        int i10 = (-iAddKey$kotlin_stdlib) - 1;
        V v11 = vArr[i10];
        vArr[i10] = v10;
        return v11;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        i.checkNotNullParameter(map, "from");
        checkIsMutable$kotlin_stdlib();
        Set<Map.Entry<? extends K, ? extends V>> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        a(setEntrySet.size());
        for (Map.Entry<? extends K, ? extends V> entry : setEntrySet) {
            int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
            V[] vArr = this.f15218m;
            if (vArr == null) {
                vArr = (V[]) nf.b.arrayOfUninitializedElements(getCapacity$kotlin_stdlib());
                this.f15218m = vArr;
            }
            if (iAddKey$kotlin_stdlib >= 0) {
                vArr[iAddKey$kotlin_stdlib] = entry.getValue();
            } else {
                int i10 = (-iAddKey$kotlin_stdlib) - 1;
                if (!i.areEqual(entry.getValue(), vArr[i10])) {
                    vArr[i10] = entry.getValue();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object obj) {
        int iRemoveKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (iRemoveKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.f15218m;
        i.checkNotNull(vArr);
        V v10 = vArr[iRemoveKey$kotlin_stdlib];
        nf.b.resetAt(vArr, iRemoveKey$kotlin_stdlib);
        return v10;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        i.checkNotNullParameter(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int iB = b(entry.getKey());
        if (iB < 0) {
            return false;
        }
        V[] vArr = this.f15218m;
        i.checkNotNull(vArr);
        if (!i.areEqual(vArr[iB], entry.getValue())) {
            return false;
        }
        e(iB);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k10) {
        checkIsMutable$kotlin_stdlib();
        int iB = b(k10);
        if (iB < 0) {
            return -1;
        }
        e(iB);
        return iB;
    }

    public final boolean removeValue$kotlin_stdlib(V v10) {
        int i10;
        checkIsMutable$kotlin_stdlib();
        int i11 = this.f15222q;
        while (true) {
            i10 = -1;
            i11--;
            if (i11 < 0) {
                break;
            }
            if (this.f15219n[i11] >= 0) {
                V[] vArr = this.f15218m;
                i.checkNotNull(vArr);
                if (i.areEqual(vArr[i11], v10)) {
                    i10 = i11;
                    break;
                }
            }
        }
        if (i10 < 0) {
            return false;
        }
        e(i10);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((size() * 3) + 2);
        sb2.append("{");
        b<K, V> bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i10 = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            bVarEntriesIterator$kotlin_stdlib.nextAppendString(sb2);
            i10++;
        }
        sb2.append("}");
        String string = sb2.toString();
        i.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final f<K, V> valuesIterator$kotlin_stdlib() {
        return new f<>(this);
    }

    public MapBuilder(int i10) {
        K[] kArr = (K[]) nf.b.arrayOfUninitializedElements(i10);
        int[] iArr = new int[i10];
        a aVar = f15216x;
        int iAccess$computeHashSize = a.access$computeHashSize(aVar, i10);
        this.f15217b = kArr;
        this.f15218m = null;
        this.f15219n = iArr;
        this.f15220o = new int[iAccess$computeHashSize];
        this.f15221p = 2;
        this.f15222q = 0;
        this.f15223r = a.access$computeShift(aVar, iAccess$computeHashSize);
    }
}
