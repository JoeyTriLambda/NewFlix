package androidx.datastore.preferences.protobuf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: SmallSortedMap.java */
/* loaded from: classes.dex */
public class c1<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f2407s = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f2408b;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2411o;

    /* renamed from: p, reason: collision with root package name */
    public volatile c1<K, V>.f f2412p;

    /* renamed from: r, reason: collision with root package name */
    public volatile c1<K, V>.b f2414r;

    /* renamed from: m, reason: collision with root package name */
    public List<c1<K, V>.d> f2409m = Collections.emptyList();

    /* renamed from: n, reason: collision with root package name */
    public Map<K, V> f2410n = Collections.emptyMap();

    /* renamed from: q, reason: collision with root package name */
    public Map<K, V> f2413q = Collections.emptyMap();

    /* compiled from: SmallSortedMap.java */
    public class a implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public int f2415b;

        /* renamed from: m, reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f2416m;

        public a() {
            this.f2415b = c1.this.f2409m.size();
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f2416m == null) {
                this.f2416m = c1.this.f2413q.entrySet().iterator();
            }
            return this.f2416m;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i10 = this.f2415b;
            return (i10 > 0 && i10 <= c1.this.f2409m.size()) || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (a().hasNext()) {
                return a().next();
            }
            List<c1<K, V>.d> list = c1.this.f2409m;
            int i10 = this.f2415b - 1;
            this.f2415b = i10;
            return list.get(i10);
        }
    }

    /* compiled from: SmallSortedMap.java */
    public class b extends c1<K, V>.f {
        public b() {
            super();
        }

        @Override // androidx.datastore.preferences.protobuf.c1.f, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }
    }

    /* compiled from: SmallSortedMap.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f2419a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final b f2420b = new b();

        /* compiled from: SmallSortedMap.java */
        public static class a implements Iterator<Object> {
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* compiled from: SmallSortedMap.java */
        public static class b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return c.f2419a;
            }
        }
    }

    /* compiled from: SmallSortedMap.java */
    public class d implements Map.Entry<K, V>, Comparable<c1<K, V>.d> {

        /* renamed from: b, reason: collision with root package name */
        public final K f2421b;

        /* renamed from: m, reason: collision with root package name */
        public V f2422m;

        public d() {
            throw null;
        }

        public d(K k10, V v10) {
            this.f2421b = k10;
            this.f2422m = v10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            K k10 = this.f2421b;
            if (k10 == null ? key == null : k10.equals(key)) {
                V v10 = this.f2422m;
                Object value = entry.getValue();
                if (v10 == null ? value == null : v10.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f2422m;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f2421b;
            int iHashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f2422m;
            return (v10 != null ? v10.hashCode() : 0) ^ iHashCode;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            int i10 = c1.f2407s;
            c1.this.b();
            V v11 = this.f2422m;
            this.f2422m = v10;
            return v11;
        }

        public String toString() {
            return this.f2421b + "=" + this.f2422m;
        }

        @Override // java.lang.Comparable
        public int compareTo(c1<K, V>.d dVar) {
            return getKey().compareTo(dVar.getKey());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f2421b;
        }
    }

    /* compiled from: SmallSortedMap.java */
    public class e implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public int f2424b = -1;

        /* renamed from: m, reason: collision with root package name */
        public boolean f2425m;

        /* renamed from: n, reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f2426n;

        public e() {
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f2426n == null) {
                this.f2426n = c1.this.f2410n.entrySet().iterator();
            }
            return this.f2426n;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i10 = this.f2424b + 1;
            c1 c1Var = c1.this;
            if (i10 >= c1Var.f2409m.size()) {
                return !c1Var.f2410n.isEmpty() && a().hasNext();
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f2425m) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f2425m = false;
            int i10 = c1.f2407s;
            c1 c1Var = c1.this;
            c1Var.b();
            if (this.f2424b >= c1Var.f2409m.size()) {
                a().remove();
                return;
            }
            int i11 = this.f2424b;
            this.f2424b = i11 - 1;
            c1Var.d(i11);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.f2425m = true;
            int i10 = this.f2424b + 1;
            this.f2424b = i10;
            c1 c1Var = c1.this;
            return i10 < c1Var.f2409m.size() ? c1Var.f2409m.get(this.f2424b) : a().next();
        }
    }

    /* compiled from: SmallSortedMap.java */
    public class f extends AbstractSet<Map.Entry<K, V>> {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c1.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = c1.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            c1.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c1.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            c1.this.put((c1) entry.getKey(), (K) entry.getValue());
            return true;
        }
    }

    public c1(int i10) {
        this.f2408b = i10;
    }

    public final int a(K k10) {
        int size = this.f2409m.size() - 1;
        if (size >= 0) {
            int iCompareTo = k10.compareTo(this.f2409m.get(size).getKey());
            if (iCompareTo > 0) {
                return -(size + 2);
            }
            if (iCompareTo == 0) {
                return size;
            }
        }
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) / 2;
            int iCompareTo2 = k10.compareTo(this.f2409m.get(i11).getKey());
            if (iCompareTo2 < 0) {
                size = i11 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i11;
                }
                i10 = i11 + 1;
            }
        }
        return -(i10 + 1);
    }

    public final void b() {
        if (this.f2411o) {
            throw new UnsupportedOperationException();
        }
    }

    public final SortedMap<K, V> c() {
        b();
        if (this.f2410n.isEmpty() && !(this.f2410n instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f2410n = treeMap;
            this.f2413q = treeMap.descendingMap();
        }
        return (SortedMap) this.f2410n;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        b();
        if (!this.f2409m.isEmpty()) {
            this.f2409m.clear();
        }
        if (this.f2410n.isEmpty()) {
            return;
        }
        this.f2410n.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f2410n.containsKey(comparable);
    }

    public final V d(int i10) {
        b();
        V value = this.f2409m.remove(i10).getValue();
        if (!this.f2410n.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = c().entrySet().iterator();
            List<c1<K, V>.d> list = this.f2409m;
            Map.Entry<K, V> next = it.next();
            list.add(new d(next.getKey(), next.getValue()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f2412p == null) {
            this.f2412p = new f();
        }
        return this.f2412p;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return super.equals(obj);
        }
        c1 c1Var = (c1) obj;
        int size = size();
        if (size != c1Var.size()) {
            return false;
        }
        int numArrayEntries = getNumArrayEntries();
        if (numArrayEntries != c1Var.getNumArrayEntries()) {
            return entrySet().equals(c1Var.entrySet());
        }
        for (int i10 = 0; i10 < numArrayEntries; i10++) {
            if (!getArrayEntryAt(i10).equals(c1Var.getArrayEntryAt(i10))) {
                return false;
            }
        }
        if (numArrayEntries != size) {
            return this.f2410n.equals(c1Var.f2410n);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? this.f2409m.get(iA).getValue() : this.f2410n.get(comparable);
    }

    public Map.Entry<K, V> getArrayEntryAt(int i10) {
        return this.f2409m.get(i10);
    }

    public int getNumArrayEntries() {
        return this.f2409m.size();
    }

    public int getNumOverflowEntries() {
        return this.f2410n.size();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        return this.f2410n.isEmpty() ? c.f2420b : this.f2410n.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int numArrayEntries = getNumArrayEntries();
        int iHashCode = 0;
        for (int i10 = 0; i10 < numArrayEntries; i10++) {
            iHashCode += this.f2409m.get(i10).hashCode();
        }
        return getNumOverflowEntries() > 0 ? iHashCode + this.f2410n.hashCode() : iHashCode;
    }

    public boolean isImmutable() {
        return this.f2411o;
    }

    public void makeImmutable() {
        if (this.f2411o) {
            return;
        }
        this.f2410n = this.f2410n.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f2410n);
        this.f2413q = this.f2413q.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f2413q);
        this.f2411o = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((c1<K, V>) obj, (Comparable) obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return d(iA);
        }
        if (this.f2410n.isEmpty()) {
            return null;
        }
        return this.f2410n.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f2410n.size() + this.f2409m.size();
    }

    public V put(K k10, V v10) {
        b();
        int iA = a(k10);
        if (iA >= 0) {
            return this.f2409m.get(iA).setValue(v10);
        }
        b();
        boolean zIsEmpty = this.f2409m.isEmpty();
        int i10 = this.f2408b;
        if (zIsEmpty && !(this.f2409m instanceof ArrayList)) {
            this.f2409m = new ArrayList(i10);
        }
        int i11 = -(iA + 1);
        if (i11 >= i10) {
            return c().put(k10, v10);
        }
        if (this.f2409m.size() == i10) {
            c1<K, V>.d dVarRemove = this.f2409m.remove(i10 - 1);
            c().put(dVarRemove.getKey(), dVarRemove.getValue());
        }
        this.f2409m.add(i11, new d(k10, v10));
        return null;
    }
}
