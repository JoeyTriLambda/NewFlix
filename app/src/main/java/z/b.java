package z;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap.java */
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: b, reason: collision with root package name */
    public c<K, V> f22545b;

    /* renamed from: m, reason: collision with root package name */
    public c<K, V> f22546m;

    /* renamed from: n, reason: collision with root package name */
    public final WeakHashMap<f<K, V>, Boolean> f22547n = new WeakHashMap<>();

    /* renamed from: o, reason: collision with root package name */
    public int f22548o = 0;

    /* compiled from: SafeIterableMap.java */
    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // z.b.e
        public final c<K, V> a(c<K, V> cVar) {
            return cVar.f22552o;
        }

        @Override // z.b.e
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.f22551n;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: z.b$b, reason: collision with other inner class name */
    public static class C0328b<K, V> extends e<K, V> {
        public C0328b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // z.b.e
        public final c<K, V> a(c<K, V> cVar) {
            return cVar.f22551n;
        }

        @Override // z.b.e
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.f22552o;
        }
    }

    /* compiled from: SafeIterableMap.java */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final K f22549b;

        /* renamed from: m, reason: collision with root package name */
        public final V f22550m;

        /* renamed from: n, reason: collision with root package name */
        public c<K, V> f22551n;

        /* renamed from: o, reason: collision with root package name */
        public c<K, V> f22552o;

        public c(K k10, V v10) {
            this.f22549b = k10;
            this.f22550m = v10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f22549b.equals(cVar.f22549b) && this.f22550m.equals(cVar.f22550m);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f22549b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f22550m;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f22549b.hashCode() ^ this.f22550m.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f22549b + "=" + this.f22550m;
        }
    }

    /* compiled from: SafeIterableMap.java */
    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public c<K, V> f22553b;

        /* renamed from: m, reason: collision with root package name */
        public boolean f22554m = true;

        public d() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f22554m) {
                return b.this.f22545b != null;
            }
            c<K, V> cVar = this.f22553b;
            return (cVar == null || cVar.f22551n == null) ? false : true;
        }

        @Override // z.b.f
        public final void supportRemove(c<K, V> cVar) {
            c<K, V> cVar2 = this.f22553b;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f22552o;
                this.f22553b = cVar3;
                this.f22554m = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.f22554m) {
                this.f22554m = false;
                this.f22553b = b.this.f22545b;
            } else {
                c<K, V> cVar = this.f22553b;
                this.f22553b = cVar != null ? cVar.f22551n : null;
            }
            return this.f22553b;
        }
    }

    /* compiled from: SafeIterableMap.java */
    public static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public c<K, V> f22556b;

        /* renamed from: m, reason: collision with root package name */
        public c<K, V> f22557m;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f22556b = cVar2;
            this.f22557m = cVar;
        }

        public abstract c<K, V> a(c<K, V> cVar);

        public abstract c<K, V> b(c<K, V> cVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f22557m != null;
        }

        @Override // z.b.f
        public void supportRemove(c<K, V> cVar) {
            c<K, V> cVarB = null;
            if (this.f22556b == cVar && cVar == this.f22557m) {
                this.f22557m = null;
                this.f22556b = null;
            }
            c<K, V> cVar2 = this.f22556b;
            if (cVar2 == cVar) {
                this.f22556b = a(cVar2);
            }
            c<K, V> cVar3 = this.f22557m;
            if (cVar3 == cVar) {
                c<K, V> cVar4 = this.f22556b;
                if (cVar3 != cVar4 && cVar4 != null) {
                    cVarB = b(cVar3);
                }
                this.f22557m = cVarB;
            }
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f22557m;
            c<K, V> cVar2 = this.f22556b;
            this.f22557m = (cVar == cVar2 || cVar2 == null) ? null : b(cVar);
            return cVar;
        }
    }

    /* compiled from: SafeIterableMap.java */
    public static abstract class f<K, V> {
        public abstract void supportRemove(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0328b c0328b = new C0328b(this.f22546m, this.f22545b);
        this.f22547n.put(c0328b, Boolean.FALSE);
        return c0328b;
    }

    public Map.Entry<K, V> eldest() {
        return this.f22545b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public c<K, V> get(K k10) {
        c<K, V> cVar = this.f22545b;
        while (cVar != null && !cVar.f22549b.equals(k10)) {
            cVar = cVar.f22551n;
        }
        return cVar;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f22545b, this.f22546m);
        this.f22547n.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public b<K, V>.d iteratorWithAdditions() {
        b<K, V>.d dVar = new d();
        this.f22547n.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> newest() {
        return this.f22546m;
    }

    public V putIfAbsent(K k10, V v10) {
        c<K, V> cVar = get(k10);
        if (cVar != null) {
            return cVar.f22550m;
        }
        c<K, V> cVar2 = new c<>(k10, v10);
        this.f22548o++;
        c<K, V> cVar3 = this.f22546m;
        if (cVar3 == null) {
            this.f22545b = cVar2;
            this.f22546m = cVar2;
            return null;
        }
        cVar3.f22551n = cVar2;
        cVar2.f22552o = cVar3;
        this.f22546m = cVar2;
        return null;
    }

    public V remove(K k10) {
        c<K, V> cVar = get(k10);
        if (cVar == null) {
            return null;
        }
        this.f22548o--;
        WeakHashMap<f<K, V>, Boolean> weakHashMap = this.f22547n;
        if (!weakHashMap.isEmpty()) {
            Iterator<f<K, V>> it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                it.next().supportRemove(cVar);
            }
        }
        c<K, V> cVar2 = cVar.f22552o;
        if (cVar2 != null) {
            cVar2.f22551n = cVar.f22551n;
        } else {
            this.f22545b = cVar.f22551n;
        }
        c<K, V> cVar3 = cVar.f22551n;
        if (cVar3 != null) {
            cVar3.f22552o = cVar2;
        } else {
            this.f22546m = cVar2;
        }
        cVar.f22551n = null;
        cVar.f22552o = null;
        return cVar.f22550m;
    }

    public int size() {
        return this.f22548o;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb2.append(it.next().toString());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
