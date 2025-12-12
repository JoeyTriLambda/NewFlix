package b0;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: MapCollections.java */
/* loaded from: classes.dex */
public abstract class j<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public j<K, V>.b f4674a;

    /* renamed from: b, reason: collision with root package name */
    public j<K, V>.c f4675b;

    /* renamed from: c, reason: collision with root package name */
    public j<K, V>.e f4676c;

    /* compiled from: MapCollections.java */
    public final class a<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public final int f4677b;

        /* renamed from: m, reason: collision with root package name */
        public int f4678m;

        /* renamed from: n, reason: collision with root package name */
        public int f4679n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f4680o = false;

        public a(int i10) {
            this.f4677b = i10;
            this.f4678m = j.this.colGetSize();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4679n < this.f4678m;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t10 = (T) j.this.colGetEntry(this.f4679n, this.f4677b);
            this.f4679n++;
            this.f4680o = true;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f4680o) {
                throw new IllegalStateException();
            }
            int i10 = this.f4679n - 1;
            this.f4679n = i10;
            this.f4678m--;
            this.f4680o = false;
            j.this.colRemoveAt(i10);
        }
    }

    /* compiled from: MapCollections.java */
    public final class b implements Set<Map.Entry<K, V>> {
        public b() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            j jVar = j.this;
            int iColGetSize = jVar.colGetSize();
            for (Map.Entry<K, V> entry : collection) {
                jVar.colPut(entry.getKey(), entry.getValue());
            }
            return iColGetSize != jVar.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            j.this.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            j jVar = j.this;
            int iColIndexOfKey = jVar.colIndexOfKey(key);
            if (iColIndexOfKey < 0) {
                return false;
            }
            return g.equal(jVar.colGetEntry(iColIndexOfKey, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return j.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            j jVar = j.this;
            int iHashCode = 0;
            for (int iColGetSize = jVar.colGetSize() - 1; iColGetSize >= 0; iColGetSize--) {
                Object objColGetEntry = jVar.colGetEntry(iColGetSize, 0);
                Object objColGetEntry2 = jVar.colGetEntry(iColGetSize, 1);
                iHashCode += (objColGetEntry == null ? 0 : objColGetEntry.hashCode()) ^ (objColGetEntry2 == null ? 0 : objColGetEntry2.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return j.this.colGetSize() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return j.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: MapCollections.java */
    public final class c implements Set<K> {
        public c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            j.this.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return j.this.colIndexOfKey(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return j.containsAllHelper(j.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return j.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            j jVar = j.this;
            int iHashCode = 0;
            for (int iColGetSize = jVar.colGetSize() - 1; iColGetSize >= 0; iColGetSize--) {
                Object objColGetEntry = jVar.colGetEntry(iColGetSize, 0);
                iHashCode += objColGetEntry == null ? 0 : objColGetEntry.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return j.this.colGetSize() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            j jVar = j.this;
            int iColIndexOfKey = jVar.colIndexOfKey(obj);
            if (iColIndexOfKey < 0) {
                return false;
            }
            jVar.colRemoveAt(iColIndexOfKey);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return j.removeAllHelper(j.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return j.retainAllHelper(j.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return j.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return j.this.toArrayHelper(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) j.this.toArrayHelper(tArr, 0);
        }
    }

    /* compiled from: MapCollections.java */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public int f4684b;

        /* renamed from: n, reason: collision with root package name */
        public boolean f4686n = false;

        /* renamed from: m, reason: collision with root package name */
        public int f4685m = -1;

        public d() {
            this.f4684b = j.this.colGetSize() - 1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f4686n) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            int i10 = this.f4685m;
            j jVar = j.this;
            return g.equal(key, jVar.colGetEntry(i10, 0)) && g.equal(entry.getValue(), jVar.colGetEntry(this.f4685m, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (!this.f4686n) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (K) j.this.colGetEntry(this.f4685m, 0);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (!this.f4686n) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) j.this.colGetEntry(this.f4685m, 1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4685m < this.f4684b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f4686n) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            int i10 = this.f4685m;
            j jVar = j.this;
            Object objColGetEntry = jVar.colGetEntry(i10, 0);
            Object objColGetEntry2 = jVar.colGetEntry(this.f4685m, 1);
            return (objColGetEntry == null ? 0 : objColGetEntry.hashCode()) ^ (objColGetEntry2 != null ? objColGetEntry2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f4686n) {
                throw new IllegalStateException();
            }
            j.this.colRemoveAt(this.f4685m);
            this.f4685m--;
            this.f4684b--;
            this.f4686n = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            if (this.f4686n) {
                return (V) j.this.colSetValue(this.f4685m, v10);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f4685m++;
            this.f4686n = true;
            return this;
        }
    }

    /* compiled from: MapCollections.java */
    public final class e implements Collection<V> {
        public e() {
        }

        @Override // java.util.Collection
        public boolean add(V v10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            j.this.colClear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return j.this.colIndexOfValue(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return j.this.colGetSize() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            j jVar = j.this;
            int iColIndexOfValue = jVar.colIndexOfValue(obj);
            if (iColIndexOfValue < 0) {
                return false;
            }
            jVar.colRemoveAt(iColIndexOfValue);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            j jVar = j.this;
            int iColGetSize = jVar.colGetSize();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < iColGetSize) {
                if (collection.contains(jVar.colGetEntry(i10, 1))) {
                    jVar.colRemoveAt(i10);
                    i10--;
                    iColGetSize--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            j jVar = j.this;
            int iColGetSize = jVar.colGetSize();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < iColGetSize) {
                if (!collection.contains(jVar.colGetEntry(i10, 1))) {
                    jVar.colRemoveAt(i10);
                    i10--;
                    iColGetSize--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        @Override // java.util.Collection
        public int size() {
            return j.this.colGetSize();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return j.this.toArrayHelper(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) j.this.toArrayHelper(tArr, 1);
        }
    }

    public static <K, V> boolean containsAllHelper(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equalsSetHelper(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean removeAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean retainAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract void colClear();

    public abstract Object colGetEntry(int i10, int i11);

    public abstract Map<K, V> colGetMap();

    public abstract int colGetSize();

    public abstract int colIndexOfKey(Object obj);

    public abstract int colIndexOfValue(Object obj);

    public abstract void colPut(K k10, V v10);

    public abstract void colRemoveAt(int i10);

    public abstract V colSetValue(int i10, V v10);

    public Set<Map.Entry<K, V>> getEntrySet() {
        if (this.f4674a == null) {
            this.f4674a = new b();
        }
        return this.f4674a;
    }

    public Set<K> getKeySet() {
        if (this.f4675b == null) {
            this.f4675b = new c();
        }
        return this.f4675b;
    }

    public Collection<V> getValues() {
        if (this.f4676c == null) {
            this.f4676c = new e();
        }
        return this.f4676c;
    }

    public Object[] toArrayHelper(int i10) {
        int iColGetSize = colGetSize();
        Object[] objArr = new Object[iColGetSize];
        for (int i11 = 0; i11 < iColGetSize; i11++) {
            objArr[i11] = colGetEntry(i11, i10);
        }
        return objArr;
    }

    public <T> T[] toArrayHelper(T[] tArr, int i10) {
        int iColGetSize = colGetSize();
        if (tArr.length < iColGetSize) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iColGetSize));
        }
        for (int i11 = 0; i11 < iColGetSize; i11++) {
            tArr[i11] = colGetEntry(i11, i10);
        }
        if (tArr.length > iColGetSize) {
            tArr[iColGetSize] = null;
        }
        return tArr;
    }
}
