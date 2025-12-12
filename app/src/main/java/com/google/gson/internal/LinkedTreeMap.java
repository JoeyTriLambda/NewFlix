package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: s, reason: collision with root package name */
    public static final a f10085s = new a();

    /* renamed from: b, reason: collision with root package name */
    public final Comparator<? super K> f10086b;

    /* renamed from: m, reason: collision with root package name */
    public e<K, V> f10087m;

    /* renamed from: n, reason: collision with root package name */
    public int f10088n;

    /* renamed from: o, reason: collision with root package name */
    public int f10089o;

    /* renamed from: p, reason: collision with root package name */
    public final e<K, V> f10090p;

    /* renamed from: q, reason: collision with root package name */
    public LinkedTreeMap<K, V>.b f10091q;

    /* renamed from: r, reason: collision with root package name */
    public LinkedTreeMap<K, V>.c f10092r;

    public class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public class b extends AbstractSet<Map.Entry<K, V>> {

        public class a extends LinkedTreeMap<K, V>.d<Map.Entry<K, V>> {
            public a(b bVar) {
                super();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.b((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            LinkedTreeMap linkedTreeMap;
            e<K, V> eVarB;
            if (!(obj instanceof Map.Entry) || (eVarB = (linkedTreeMap = LinkedTreeMap.this).b((Map.Entry) obj)) == null) {
                return false;
            }
            linkedTreeMap.d(eVarB, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.f10088n;
        }
    }

    public final class c extends AbstractSet<K> {

        public class a extends LinkedTreeMap<K, V>.d<K> {
            public a(c cVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f10104q;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> eVarA;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            linkedTreeMap.getClass();
            if (obj != null) {
                try {
                    eVarA = linkedTreeMap.a(obj, false);
                } catch (ClassCastException unused) {
                }
            } else {
                eVarA = null;
            }
            if (eVarA != null) {
                linkedTreeMap.d(eVarA, true);
            }
            return eVarA != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.f10088n;
        }
    }

    public abstract class d<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public e<K, V> f10095b;

        /* renamed from: m, reason: collision with root package name */
        public e<K, V> f10096m = null;

        /* renamed from: n, reason: collision with root package name */
        public int f10097n;

        public d() {
            this.f10095b = LinkedTreeMap.this.f10090p.f10102o;
            this.f10097n = LinkedTreeMap.this.f10089o;
        }

        public final e<K, V> a() {
            e<K, V> eVar = this.f10095b;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (eVar == linkedTreeMap.f10090p) {
                throw new NoSuchElementException();
            }
            if (linkedTreeMap.f10089o != this.f10097n) {
                throw new ConcurrentModificationException();
            }
            this.f10095b = eVar.f10102o;
            this.f10096m = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f10095b != LinkedTreeMap.this.f10090p;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f10096m;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            linkedTreeMap.d(eVar, true);
            this.f10096m = null;
            this.f10097n = linkedTreeMap.f10089o;
        }
    }

    public LinkedTreeMap() {
        this(f10085s);
    }

    public final e<K, V> a(K k10, boolean z10) {
        int iCompareTo;
        e<K, V> eVar;
        e<K, V> eVar2 = this.f10087m;
        a aVar = f10085s;
        Comparator<? super K> comparator = this.f10086b;
        if (eVar2 != null) {
            Comparable comparable = comparator == aVar ? (Comparable) k10 : null;
            while (true) {
                K k11 = eVar2.f10104q;
                iCompareTo = comparable != null ? comparable.compareTo(k11) : comparator.compare(k10, k11);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = iCompareTo < 0 ? eVar2.f10100m : eVar2.f10101n;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z10) {
            return null;
        }
        e<K, V> eVar4 = this.f10090p;
        if (eVar2 != null) {
            eVar = new e<>(eVar2, k10, eVar4, eVar4.f10103p);
            if (iCompareTo < 0) {
                eVar2.f10100m = eVar;
            } else {
                eVar2.f10101n = eVar;
            }
            c(eVar2, true);
        } else {
            if (comparator == aVar && !(k10 instanceof Comparable)) {
                throw new ClassCastException(k10.getClass().getName().concat(" is not Comparable"));
            }
            eVar = new e<>(eVar2, k10, eVar4, eVar4.f10103p);
            this.f10087m = eVar;
        }
        this.f10088n++;
        this.f10089o++;
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e<K, V> b(Map.Entry<?, ?> entry) {
        e<K, V> eVarA;
        Object key = entry.getKey();
        boolean z10 = false;
        if (key != null) {
            try {
                eVarA = a(key, false);
            } catch (ClassCastException unused) {
            }
        } else {
            eVarA = null;
        }
        if (eVarA != null) {
            V v10 = eVarA.f10105r;
            Object value = entry.getValue();
            if (v10 == value || (v10 != null && v10.equals(value))) {
                z10 = true;
            }
        }
        if (z10) {
            return eVarA;
        }
        return null;
    }

    public final void c(e<K, V> eVar, boolean z10) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f10100m;
            e<K, V> eVar3 = eVar.f10101n;
            int i10 = eVar2 != null ? eVar2.f10106s : 0;
            int i11 = eVar3 != null ? eVar3.f10106s : 0;
            int i12 = i10 - i11;
            if (i12 == -2) {
                e<K, V> eVar4 = eVar3.f10100m;
                e<K, V> eVar5 = eVar3.f10101n;
                int i13 = (eVar4 != null ? eVar4.f10106s : 0) - (eVar5 != null ? eVar5.f10106s : 0);
                if (i13 == -1 || (i13 == 0 && !z10)) {
                    f(eVar);
                } else {
                    g(eVar3);
                    f(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i12 == 2) {
                e<K, V> eVar6 = eVar2.f10100m;
                e<K, V> eVar7 = eVar2.f10101n;
                int i14 = (eVar6 != null ? eVar6.f10106s : 0) - (eVar7 != null ? eVar7.f10106s : 0);
                if (i14 == 1 || (i14 == 0 && !z10)) {
                    g(eVar);
                } else {
                    f(eVar2);
                    g(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i12 == 0) {
                eVar.f10106s = i10 + 1;
                if (z10) {
                    return;
                }
            } else {
                eVar.f10106s = Math.max(i10, i11) + 1;
                if (!z10) {
                    return;
                }
            }
            eVar = eVar.f10099b;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f10087m = null;
        this.f10088n = 0;
        this.f10089o++;
        e<K, V> eVar = this.f10090p;
        eVar.f10103p = eVar;
        eVar.f10102o = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        e<K, V> eVarA;
        if (obj != 0) {
            try {
                eVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            eVarA = null;
        }
        return eVarA != null;
    }

    public final void d(e<K, V> eVar, boolean z10) {
        int i10;
        if (z10) {
            e<K, V> eVar2 = eVar.f10103p;
            eVar2.f10102o = eVar.f10102o;
            eVar.f10102o.f10103p = eVar2;
        }
        e<K, V> eVar3 = eVar.f10100m;
        e<K, V> eVar4 = eVar.f10101n;
        e<K, V> eVar5 = eVar.f10099b;
        int i11 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                e(eVar, eVar3);
                eVar.f10100m = null;
            } else if (eVar4 != null) {
                e(eVar, eVar4);
                eVar.f10101n = null;
            } else {
                e(eVar, null);
            }
            c(eVar5, false);
            this.f10088n--;
            this.f10089o++;
            return;
        }
        e<K, V> eVarLast = eVar3.f10106s > eVar4.f10106s ? eVar3.last() : eVar4.first();
        d(eVarLast, false);
        e<K, V> eVar6 = eVar.f10100m;
        if (eVar6 != null) {
            i10 = eVar6.f10106s;
            eVarLast.f10100m = eVar6;
            eVar6.f10099b = eVarLast;
            eVar.f10100m = null;
        } else {
            i10 = 0;
        }
        e<K, V> eVar7 = eVar.f10101n;
        if (eVar7 != null) {
            i11 = eVar7.f10106s;
            eVarLast.f10101n = eVar7;
            eVar7.f10099b = eVarLast;
            eVar.f10101n = null;
        }
        eVarLast.f10106s = Math.max(i10, i11) + 1;
        e(eVar, eVarLast);
    }

    public final void e(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f10099b;
        eVar.f10099b = null;
        if (eVar2 != null) {
            eVar2.f10099b = eVar3;
        }
        if (eVar3 == null) {
            this.f10087m = eVar2;
        } else if (eVar3.f10100m == eVar) {
            eVar3.f10100m = eVar2;
        } else {
            eVar3.f10101n = eVar2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.b bVar = this.f10091q;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.b bVar2 = new b();
        this.f10091q = bVar2;
        return bVar2;
    }

    public final void f(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f10100m;
        e<K, V> eVar3 = eVar.f10101n;
        e<K, V> eVar4 = eVar3.f10100m;
        e<K, V> eVar5 = eVar3.f10101n;
        eVar.f10101n = eVar4;
        if (eVar4 != null) {
            eVar4.f10099b = eVar;
        }
        e(eVar, eVar3);
        eVar3.f10100m = eVar;
        eVar.f10099b = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f10106s : 0, eVar4 != null ? eVar4.f10106s : 0) + 1;
        eVar.f10106s = iMax;
        eVar3.f10106s = Math.max(iMax, eVar5 != null ? eVar5.f10106s : 0) + 1;
    }

    public final void g(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f10100m;
        e<K, V> eVar3 = eVar.f10101n;
        e<K, V> eVar4 = eVar2.f10100m;
        e<K, V> eVar5 = eVar2.f10101n;
        eVar.f10100m = eVar5;
        if (eVar5 != null) {
            eVar5.f10099b = eVar;
        }
        e(eVar, eVar2);
        eVar2.f10101n = eVar;
        eVar.f10099b = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f10106s : 0, eVar5 != null ? eVar5.f10106s : 0) + 1;
        eVar.f10106s = iMax;
        eVar2.f10106s = Math.max(iMax, eVar4 != null ? eVar4.f10106s : 0) + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> eVarA;
        if (obj != 0) {
            try {
                eVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            eVarA = null;
        }
        if (eVarA != null) {
            return eVarA.f10105r;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.c cVar = this.f10092r;
        if (cVar != null) {
            return cVar;
        }
        LinkedTreeMap<K, V>.c cVar2 = new c();
        this.f10092r = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        if (k10 == null) {
            throw new NullPointerException("key == null");
        }
        e<K, V> eVarA = a(k10, true);
        V v11 = eVarA.f10105r;
        eVarA.f10105r = v10;
        return v11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> eVarA;
        if (obj != 0) {
            try {
                eVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            eVarA = null;
        }
        if (eVarA != null) {
            d(eVarA, true);
        }
        if (eVarA != null) {
            return eVarA.f10105r;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f10088n;
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.f10088n = 0;
        this.f10089o = 0;
        this.f10090p = new e<>();
        this.f10086b = comparator == null ? f10085s : comparator;
    }

    public static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public e<K, V> f10099b;

        /* renamed from: m, reason: collision with root package name */
        public e<K, V> f10100m;

        /* renamed from: n, reason: collision with root package name */
        public e<K, V> f10101n;

        /* renamed from: o, reason: collision with root package name */
        public e<K, V> f10102o;

        /* renamed from: p, reason: collision with root package name */
        public e<K, V> f10103p;

        /* renamed from: q, reason: collision with root package name */
        public final K f10104q;

        /* renamed from: r, reason: collision with root package name */
        public V f10105r;

        /* renamed from: s, reason: collision with root package name */
        public int f10106s;

        public e() {
            this.f10104q = null;
            this.f10103p = this;
            this.f10102o = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k10 = this.f10104q;
            if (k10 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k10.equals(entry.getKey())) {
                return false;
            }
            V v10 = this.f10105r;
            if (v10 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v10.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public e<K, V> first() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f10100m; eVar2 != null; eVar2 = eVar2.f10100m) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f10104q;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f10105r;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f10104q;
            int iHashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f10105r;
            return (v10 != null ? v10.hashCode() : 0) ^ iHashCode;
        }

        public e<K, V> last() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f10101n; eVar2 != null; eVar2 = eVar2.f10101n) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            V v11 = this.f10105r;
            this.f10105r = v10;
            return v11;
        }

        public String toString() {
            return this.f10104q + "=" + this.f10105r;
        }

        public e(e<K, V> eVar, K k10, e<K, V> eVar2, e<K, V> eVar3) {
            this.f10099b = eVar;
            this.f10104q = k10;
            this.f10106s = 1;
            this.f10102o = eVar2;
            this.f10103p = eVar3;
            eVar3.f10102o = this;
            eVar2.f10103p = this;
        }
    }
}
