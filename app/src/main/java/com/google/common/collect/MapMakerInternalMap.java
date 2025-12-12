package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.MapMakerInternalMap.h;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
class MapMakerInternalMap<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    private static final long serialVersionUID = 5;

    /* renamed from: u, reason: collision with root package name */
    public static final a f9648u = new a();

    /* renamed from: b, reason: collision with root package name */
    public final transient int f9649b;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f9650m;

    /* renamed from: n, reason: collision with root package name */
    public final transient Segment<K, V, E, S>[] f9651n;

    /* renamed from: o, reason: collision with root package name */
    public final int f9652o;

    /* renamed from: p, reason: collision with root package name */
    public final Equivalence<Object> f9653p;

    /* renamed from: q, reason: collision with root package name */
    public final transient i<K, V, E, S> f9654q;

    /* renamed from: r, reason: collision with root package name */
    public transient k f9655r;

    /* renamed from: s, reason: collision with root package name */
    public transient p f9656s;

    /* renamed from: t, reason: collision with root package name */
    public transient f f9657t;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class Strength {

        /* renamed from: b, reason: collision with root package name */
        public static final AnonymousClass1 f9665b;

        /* renamed from: m, reason: collision with root package name */
        public static final AnonymousClass2 f9666m;

        /* renamed from: n, reason: collision with root package name */
        public static final /* synthetic */ Strength[] f9667n;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.MapMakerInternalMap$Strength$1] */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.common.collect.MapMakerInternalMap$Strength$2] */
        static {
            ?? r02 = new Strength() { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
                @Override // com.google.common.collect.MapMakerInternalMap.Strength
                public final Equivalence<Object> a() {
                    return Equivalence.equals();
                }
            };
            f9665b = r02;
            ?? r12 = new Strength() { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
                @Override // com.google.common.collect.MapMakerInternalMap.Strength
                public final Equivalence<Object> a() {
                    return Equivalence.identity();
                }
            };
            f9666m = r12;
            f9667n = new Strength[]{r02, r12};
        }

        public Strength() {
            throw null;
        }

        public Strength(String str, int i10) {
        }

        public static Strength valueOf(String str) {
            return (Strength) Enum.valueOf(Strength.class, str);
        }

        public static Strength[] values() {
            return (Strength[]) f9667n.clone();
        }

        public abstract Equivalence<Object> a();
    }

    public static abstract class b<K, V, E extends h<K, V, E>> implements h<K, V, E> {

        /* renamed from: a, reason: collision with root package name */
        public final K f9672a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9673b;

        /* renamed from: c, reason: collision with root package name */
        public final E f9674c;

        public b(K k10, int i10, E e10) {
            this.f9672a = k10;
            this.f9673b = i10;
            this.f9674c = e10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            return this.f9673b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public K getKey() {
            return this.f9672a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public E getNext() {
            return this.f9674c;
        }
    }

    public static abstract class c<K, V, E extends h<K, V, E>> extends WeakReference<K> implements h<K, V, E> {

        /* renamed from: a, reason: collision with root package name */
        public final int f9675a;

        /* renamed from: b, reason: collision with root package name */
        public final E f9676b;

        public c(ReferenceQueue<K> referenceQueue, K k10, int i10, E e10) {
            super(k10, referenceQueue);
            this.f9675a = i10;
            this.f9676b = e10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            return this.f9675a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public E getNext() {
            return this.f9676b;
        }
    }

    public static final class d implements h<Object, Object, d> {
        public d() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getValue() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public d getNext() {
            throw new AssertionError();
        }
    }

    public final class e extends MapMakerInternalMap<K, V, E, S>.g<Map.Entry<K, V>> {
        public e(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    public final class f extends l<Map.Entry<K, V>> {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            MapMakerInternalMap mapMakerInternalMap;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = (mapMakerInternalMap = MapMakerInternalMap.this).get(key)) != null && mapMakerInternalMap.f9654q.valueStrength().a().equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    public abstract class g<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public int f9678b;

        /* renamed from: m, reason: collision with root package name */
        public int f9679m = -1;

        /* renamed from: n, reason: collision with root package name */
        public Segment<K, V, E, S> f9680n;

        /* renamed from: o, reason: collision with root package name */
        public AtomicReferenceArray<E> f9681o;

        /* renamed from: p, reason: collision with root package name */
        public E f9682p;

        /* renamed from: q, reason: collision with root package name */
        public MapMakerInternalMap<K, V, E, S>.v f9683q;

        /* renamed from: r, reason: collision with root package name */
        public MapMakerInternalMap<K, V, E, S>.v f9684r;

        public g() {
            this.f9678b = MapMakerInternalMap.this.f9651n.length - 1;
            a();
        }

        public final void a() {
            boolean z10;
            this.f9683q = null;
            E e10 = this.f9682p;
            if (e10 != null) {
                while (true) {
                    E e11 = (E) e10.getNext();
                    this.f9682p = e11;
                    if (e11 == null) {
                        break;
                    }
                    if (b(e11)) {
                        z10 = true;
                        break;
                    }
                    e10 = this.f9682p;
                }
            } else {
                z10 = false;
            }
            if (z10 || d()) {
                return;
            }
            while (true) {
                int i10 = this.f9678b;
                if (i10 < 0) {
                    return;
                }
                Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.f9651n;
                this.f9678b = i10 - 1;
                Segment<K, V, E, S> segment = segmentArr[i10];
                this.f9680n = segment;
                if (segment.f9660m != 0) {
                    this.f9681o = this.f9680n.f9663p;
                    this.f9679m = r0.length() - 1;
                    if (d()) {
                        return;
                    }
                }
            }
        }

        public final boolean b(E e10) {
            MapMakerInternalMap mapMakerInternalMap = MapMakerInternalMap.this;
            try {
                Object key = e10.getKey();
                mapMakerInternalMap.getClass();
                Object value = e10.getKey() == null ? null : e10.getValue();
                if (value == null) {
                    this.f9680n.g();
                    return false;
                }
                this.f9683q = new v(key, value);
                this.f9680n.g();
                return true;
            } catch (Throwable th2) {
                this.f9680n.g();
                throw th2;
            }
        }

        public final MapMakerInternalMap<K, V, E, S>.v c() {
            MapMakerInternalMap<K, V, E, S>.v vVar = this.f9683q;
            if (vVar == null) {
                throw new NoSuchElementException();
            }
            this.f9684r = vVar;
            a();
            return this.f9684r;
        }

        public final boolean d() {
            while (true) {
                int i10 = this.f9679m;
                boolean z10 = false;
                if (i10 < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f9681o;
                this.f9679m = i10 - 1;
                E e10 = atomicReferenceArray.get(i10);
                this.f9682p = e10;
                if (e10 != null) {
                    if (b(e10)) {
                        break;
                    }
                    E e11 = this.f9682p;
                    if (e11 != null) {
                        while (true) {
                            E e12 = (E) e11.getNext();
                            this.f9682p = e12;
                            if (e12 == null) {
                                break;
                            }
                            if (b(e12)) {
                                z10 = true;
                                break;
                            }
                            e11 = this.f9682p;
                        }
                    }
                    if (z10) {
                        break;
                    }
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9683q != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            b8.e.checkState(this.f9684r != null, "no calls to next() since the last call to remove()");
            MapMakerInternalMap.this.remove(this.f9684r.getKey());
            this.f9684r = null;
        }
    }

    public interface h<K, V, E extends h<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    public interface i<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> {
        E copy(S s10, E e10, E e11);

        E newEntry(S s10, K k10, int i10, E e10);

        S newSegment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i10, int i11);

        void setValue(S s10, E e10, V v10);

        Strength valueStrength();
    }

    public final class j extends MapMakerInternalMap<K, V, E, S>.g<K> {
        public j(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    public final class k extends l<K> {
        public k() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new j(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    public static abstract class l<E> extends AbstractSet<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.a(this).toArray(tArr);
        }
    }

    public static final class m<K, V> extends b<K, V, m<K, V>> {

        /* renamed from: d, reason: collision with root package name */
        public volatile V f9687d;

        public static final class a<K, V> implements i<K, V, m<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f9688a = new a<>();

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public m<K, V> copy(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, m<K, V> mVar, m<K, V> mVar2) {
                m<K, V> mVar3 = new m<>(mVar.f9672a, mVar.f9673b, mVar2);
                mVar3.f9687d = mVar.f9687d;
                return mVar3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            public /* bridge */ /* synthetic */ h newEntry(Segment segment, Object obj, int i10, h hVar) {
                return newEntry((StrongKeyStrongValueSegment<StrongKeyStrongValueSegment<K, V>, V>) segment, (StrongKeyStrongValueSegment<K, V>) obj, i10, (m<StrongKeyStrongValueSegment<K, V>, V>) hVar);
            }

            public void setValue(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, m<K, V> mVar, V v10) {
                mVar.f9687d = v10;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength valueStrength() {
                return Strength.f9665b;
            }

            public m<K, V> newEntry(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k10, int i10, m<K, V> mVar) {
                return new m<>(k10, i10, mVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public StrongKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, m<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            public /* bridge */ /* synthetic */ void setValue(Segment segment, h hVar, Object obj) {
                setValue((StrongKeyStrongValueSegment<K, m<K, V>>) segment, (m<K, m<K, V>>) hVar, (m<K, V>) obj);
            }
        }

        public m(K k10, int i10, m<K, V> mVar) {
            super(k10, i10, mVar);
            this.f9687d = null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            return this.f9687d;
        }
    }

    public static final class n<K, V> extends b<K, V, n<K, V>> implements s<K, V, n<K, V>> {

        /* renamed from: d, reason: collision with root package name */
        public volatile t<K, V, n<K, V>> f9689d;

        public static final class a<K, V> implements i<K, V, n<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f9690a = new a<>();

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            public /* bridge */ /* synthetic */ h newEntry(Segment segment, Object obj, int i10, h hVar) {
                return newEntry((StrongKeyWeakValueSegment<StrongKeyWeakValueSegment<K, V>, V>) segment, (StrongKeyWeakValueSegment<K, V>) obj, i10, (n<StrongKeyWeakValueSegment<K, V>, V>) hVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            public /* bridge */ /* synthetic */ void setValue(Segment segment, h hVar, Object obj) {
                setValue((StrongKeyWeakValueSegment<K, n<K, V>>) segment, (n<K, n<K, V>>) hVar, (n<K, V>) obj);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength valueStrength() {
                return Strength.f9666m;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public n<K, V> copy(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, n<K, V> nVar, n<K, V> nVar2) {
                int i10 = Segment.f9658r;
                if (nVar.getValue() == null) {
                    return null;
                }
                ReferenceQueue<V> referenceQueue = strongKeyWeakValueSegment.f9668s;
                n<K, V> nVar3 = new n<>(nVar.f9672a, nVar.f9673b, nVar2);
                nVar3.f9689d = nVar.f9689d.copyFor(referenceQueue, nVar3);
                return nVar3;
            }

            public n<K, V> newEntry(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k10, int i10, n<K, V> nVar) {
                return new n<>(k10, i10, nVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public StrongKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, n<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            public void setValue(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, n<K, V> nVar, V v10) {
                ReferenceQueue<V> referenceQueue = strongKeyWeakValueSegment.f9668s;
                t<K, V, n<K, V>> tVar = nVar.f9689d;
                nVar.f9689d = new u(referenceQueue, v10, nVar);
                tVar.clear();
            }
        }

        public n(K k10, int i10, n<K, V> nVar) {
            super(k10, i10, nVar);
            this.f9689d = MapMakerInternalMap.f9648u;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            return this.f9689d.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.s
        public t<K, V, n<K, V>> getValueReference() {
            return this.f9689d;
        }
    }

    public final class o extends MapMakerInternalMap<K, V, E, S>.g<V> {
        public o(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    public final class p extends AbstractCollection<V> {
        public p() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new o(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.a(this).toArray(tArr);
        }
    }

    public static final class q<K, V> extends c<K, V, q<K, V>> {

        /* renamed from: c, reason: collision with root package name */
        public volatile V f9692c;

        public static final class a<K, V> implements i<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f9693a = new a<>();

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            public /* bridge */ /* synthetic */ h newEntry(Segment segment, Object obj, int i10, h hVar) {
                return newEntry((WeakKeyStrongValueSegment<WeakKeyStrongValueSegment<K, V>, V>) segment, (WeakKeyStrongValueSegment<K, V>) obj, i10, (q<WeakKeyStrongValueSegment<K, V>, V>) hVar);
            }

            public void setValue(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, q<K, V> qVar, V v10) {
                qVar.f9692c = v10;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength valueStrength() {
                return Strength.f9665b;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public q<K, V> copy(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, q<K, V> qVar, q<K, V> qVar2) {
                if (qVar.getKey() == null) {
                    return null;
                }
                q<K, V> qVar3 = new q<>(weakKeyStrongValueSegment.f9669s, qVar.getKey(), qVar.f9675a, qVar2);
                qVar3.f9692c = qVar.f9692c;
                return qVar3;
            }

            public q<K, V> newEntry(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k10, int i10, q<K, V> qVar) {
                return new q<>(weakKeyStrongValueSegment.f9669s, k10, i10, qVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public WeakKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            public /* bridge */ /* synthetic */ void setValue(Segment segment, h hVar, Object obj) {
                setValue((WeakKeyStrongValueSegment<K, q<K, V>>) segment, (q<K, q<K, V>>) hVar, (q<K, V>) obj);
            }
        }

        public q(ReferenceQueue<K> referenceQueue, K k10, int i10, q<K, V> qVar) {
            super(referenceQueue, k10, i10, qVar);
            this.f9692c = null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            return this.f9692c;
        }
    }

    public static final class r<K, V> extends c<K, V, r<K, V>> implements s<K, V, r<K, V>> {

        /* renamed from: c, reason: collision with root package name */
        public volatile t<K, V, r<K, V>> f9694c;

        public static final class a<K, V> implements i<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f9695a = new a<>();

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            public /* bridge */ /* synthetic */ h newEntry(Segment segment, Object obj, int i10, h hVar) {
                return newEntry((WeakKeyWeakValueSegment<WeakKeyWeakValueSegment<K, V>, V>) segment, (WeakKeyWeakValueSegment<K, V>) obj, i10, (r<WeakKeyWeakValueSegment<K, V>, V>) hVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            public /* bridge */ /* synthetic */ void setValue(Segment segment, h hVar, Object obj) {
                setValue((WeakKeyWeakValueSegment<K, r<K, V>>) segment, (r<K, r<K, V>>) hVar, (r<K, V>) obj);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength valueStrength() {
                return Strength.f9666m;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public r<K, V> copy(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, r<K, V> rVar, r<K, V> rVar2) {
                if (rVar.getKey() == null) {
                    return null;
                }
                int i10 = Segment.f9658r;
                if (rVar.getValue() == null) {
                    return null;
                }
                ReferenceQueue<K> referenceQueue = weakKeyWeakValueSegment.f9670s;
                ReferenceQueue<V> referenceQueue2 = weakKeyWeakValueSegment.f9671t;
                r<K, V> rVar3 = new r<>(referenceQueue, rVar.getKey(), rVar.f9675a, rVar2);
                rVar3.f9694c = rVar.f9694c.copyFor(referenceQueue2, rVar3);
                return rVar3;
            }

            public r<K, V> newEntry(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k10, int i10, r<K, V> rVar) {
                return new r<>(weakKeyWeakValueSegment.f9670s, k10, i10, rVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public WeakKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            public void setValue(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, r<K, V> rVar, V v10) {
                ReferenceQueue<V> referenceQueue = weakKeyWeakValueSegment.f9671t;
                t<K, V, r<K, V>> tVar = rVar.f9694c;
                rVar.f9694c = new u(referenceQueue, v10, rVar);
                tVar.clear();
            }
        }

        public r(ReferenceQueue<K> referenceQueue, K k10, int i10, r<K, V> rVar) {
            super(referenceQueue, k10, i10, rVar);
            this.f9694c = MapMakerInternalMap.f9648u;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            return this.f9694c.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.s
        public t<K, V, r<K, V>> getValueReference() {
            return this.f9694c;
        }
    }

    public interface s<K, V, E extends h<K, V, E>> extends h<K, V, E> {
        t<K, V, E> getValueReference();
    }

    public interface t<K, V, E extends h<K, V, E>> {
        void clear();

        t<K, V, E> copyFor(ReferenceQueue<V> referenceQueue, E e10);

        V get();

        E getEntry();
    }

    public static final class u<K, V, E extends h<K, V, E>> extends WeakReference<V> implements t<K, V, E> {

        /* renamed from: a, reason: collision with root package name */
        public final E f9696a;

        public u(ReferenceQueue<V> referenceQueue, V v10, E e10) {
            super(v10, referenceQueue);
            this.f9696a = e10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public t<K, V, E> copyFor(ReferenceQueue<V> referenceQueue, E e10) {
            return new u(referenceQueue, get(), e10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public E getEntry() {
            return this.f9696a;
        }
    }

    public final class v extends c8.b<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final K f9697b;

        /* renamed from: m, reason: collision with root package name */
        public V f9698m;

        public v(K k10, V v10) {
            this.f9697b = k10;
            this.f9698m = v10;
        }

        @Override // c8.b, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f9697b.equals(entry.getKey()) && this.f9698m.equals(entry.getValue());
        }

        @Override // c8.b, java.util.Map.Entry
        public K getKey() {
            return this.f9697b;
        }

        @Override // c8.b, java.util.Map.Entry
        public V getValue() {
            return this.f9698m;
        }

        @Override // c8.b, java.util.Map.Entry
        public int hashCode() {
            return this.f9697b.hashCode() ^ this.f9698m.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            V v11 = (V) MapMakerInternalMap.this.put(this.f9697b, v10);
            this.f9698m = v10;
            return v11;
        }
    }

    public MapMakerInternalMap(com.google.common.collect.d dVar, i<K, V, E, S> iVar) {
        int i10 = dVar.f9730c;
        this.f9652o = Math.min(i10 == -1 ? 4 : i10, 65536);
        this.f9653p = (Equivalence) b8.c.firstNonNull(null, dVar.a().a());
        this.f9654q = iVar;
        int i11 = dVar.f9729b;
        int iMin = Math.min(i11 == -1 ? 16 : i11, 1073741824);
        int i12 = 0;
        int i13 = 1;
        int i14 = 1;
        int i15 = 0;
        while (i14 < this.f9652o) {
            i15++;
            i14 <<= 1;
        }
        this.f9650m = 32 - i15;
        this.f9649b = i14 - 1;
        this.f9651n = new Segment[i14];
        int i16 = iMin / i14;
        while (i13 < (i14 * i16 < iMin ? i16 + 1 : i16)) {
            i13 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.f9651n;
            if (i12 >= segmentArr.length) {
                return;
            }
            segmentArr[i12] = this.f9654q.newSegment(this, i13, -1);
            i12++;
        }
    }

    public static ArrayList a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        c8.e.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    public final int b(Object obj) {
        int iHash = this.f9653p.hash(obj);
        int i10 = iHash + ((iHash << 15) ^ (-12931));
        int i11 = i10 ^ (i10 >>> 10);
        int i12 = i11 + (i11 << 3);
        int i13 = i12 ^ (i12 >>> 6);
        int i14 = (i13 << 2) + (i13 << 14) + i13;
        return (i14 >>> 16) ^ i14;
    }

    public final Segment<K, V, E, S> c(int i10) {
        return this.f9651n[(i10 >>> this.f9650m) & this.f9649b];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Segment<K, V, E, S>[] segmentArr = this.f9651n;
        int length = segmentArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            Segment<K, V, E, S> segment = segmentArr[i10];
            if (segment.f9660m != 0) {
                segment.lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = segment.f9663p;
                    for (int i11 = 0; i11 < atomicReferenceArray.length(); i11++) {
                        atomicReferenceArray.set(i11, null);
                    }
                    segment.e();
                    segment.f9664q.set(0);
                    segment.f9661n++;
                    segment.f9660m = 0;
                } finally {
                    segment.unlock();
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        h hVarD;
        boolean z10 = false;
        if (obj == null) {
            return false;
        }
        int iB = b(obj);
        Segment<K, V, E, S> segmentC = c(iB);
        segmentC.getClass();
        try {
            if (segmentC.f9660m != 0 && (hVarD = segmentC.d(iB, obj)) != null) {
                if (hVarD.getValue() != null) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            segmentC.g();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Object value;
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.f9651n;
        long j10 = -1;
        int i10 = 0;
        while (i10 < 3) {
            int length = segmentArr.length;
            long j11 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                Segment<K, V, E, S> segment = segmentArr[i11];
                int i12 = segment.f9660m;
                AtomicReferenceArray<E> atomicReferenceArray = segment.f9663p;
                for (int i13 = 0; i13 < atomicReferenceArray.length(); i13++) {
                    for (E next = atomicReferenceArray.get(i13); next != null; next = next.getNext()) {
                        if (next.getKey() == null || (value = next.getValue()) == null) {
                            segment.m();
                            value = null;
                        }
                        if (value != null && this.f9654q.valueStrength().a().equivalent(obj, value)) {
                            return true;
                        }
                    }
                }
                j11 += segment.f9661n;
            }
            if (j11 == j10) {
                return false;
            }
            i10++;
            j10 = j11;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        f fVar = this.f9657t;
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f();
        this.f9657t = fVar2;
        return fVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        V v10 = null;
        if (obj == null) {
            return null;
        }
        int iB = b(obj);
        Segment<K, V, E, S> segmentC = c(iB);
        segmentC.getClass();
        try {
            h hVarD = segmentC.d(iB, obj);
            if (hVarD != null && (v10 = (V) hVarD.getValue()) == null) {
                segmentC.m();
            }
            return v10;
        } finally {
            segmentC.g();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.f9651n;
        long j10 = 0;
        for (int i10 = 0; i10 < segmentArr.length; i10++) {
            if (segmentArr[i10].f9660m != 0) {
                return false;
            }
            j10 += segmentArr[i10].f9661n;
        }
        if (j10 == 0) {
            return true;
        }
        for (int i11 = 0; i11 < segmentArr.length; i11++) {
            if (segmentArr[i11].f9660m != 0) {
                return false;
            }
            j10 -= segmentArr[i11].f9661n;
        }
        return j10 == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        k kVar = this.f9655r;
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k();
        this.f9655r = kVar2;
        return kVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        b8.e.checkNotNull(k10);
        b8.e.checkNotNull(v10);
        int iB = b(k10);
        return c(iB).h(k10, iB, v10, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k10, V v10) {
        b8.e.checkNotNull(k10);
        b8.e.checkNotNull(v10);
        int iB = b(k10);
        return c(iB).h(k10, iB, v10, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        r11 = (V) r7.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
    
        if (r11 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        if (r7.getValue() != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
    
        if (r1 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
    
        r2.f9661n++;
        r0 = r2.i(r6, r7);
        r1 = r2.f9660m - 1;
        r3.set(r4, r0);
        r2.f9660m = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
    
        return r11;
     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V remove(java.lang.Object r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L4
            return r0
        L4:
            int r1 = r10.b(r11)
            com.google.common.collect.MapMakerInternalMap$Segment r2 = r10.c(r1)
            r2.lock()
            r2.j()     // Catch: java.lang.Throwable -> L6b
            java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>> r3 = r2.f9663p     // Catch: java.lang.Throwable -> L6b
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L6b
            r5 = 1
            int r4 = r4 - r5
            r4 = r4 & r1
            java.lang.Object r6 = r3.get(r4)     // Catch: java.lang.Throwable -> L6b
            com.google.common.collect.MapMakerInternalMap$h r6 = (com.google.common.collect.MapMakerInternalMap.h) r6     // Catch: java.lang.Throwable -> L6b
            r7 = r6
        L22:
            if (r7 == 0) goto L67
            java.lang.Object r8 = r7.getKey()     // Catch: java.lang.Throwable -> L6b
            int r9 = r7.getHash()     // Catch: java.lang.Throwable -> L6b
            if (r9 != r1) goto L62
            if (r8 == 0) goto L62
            com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r9 = r2.f9659b     // Catch: java.lang.Throwable -> L6b
            com.google.common.base.Equivalence<java.lang.Object> r9 = r9.f9653p     // Catch: java.lang.Throwable -> L6b
            boolean r8 = r9.equivalent(r11, r8)     // Catch: java.lang.Throwable -> L6b
            if (r8 == 0) goto L62
            java.lang.Object r11 = r7.getValue()     // Catch: java.lang.Throwable -> L6b
            if (r11 == 0) goto L41
            goto L4c
        L41:
            java.lang.Object r1 = r7.getValue()     // Catch: java.lang.Throwable -> L6b
            if (r1 != 0) goto L49
            r1 = 1
            goto L4a
        L49:
            r1 = 0
        L4a:
            if (r1 == 0) goto L67
        L4c:
            int r0 = r2.f9661n     // Catch: java.lang.Throwable -> L6b
            int r0 = r0 + r5
            r2.f9661n = r0     // Catch: java.lang.Throwable -> L6b
            com.google.common.collect.MapMakerInternalMap$h r0 = r2.i(r6, r7)     // Catch: java.lang.Throwable -> L6b
            int r1 = r2.f9660m     // Catch: java.lang.Throwable -> L6b
            int r1 = r1 - r5
            r3.set(r4, r0)     // Catch: java.lang.Throwable -> L6b
            r2.f9660m = r1     // Catch: java.lang.Throwable -> L6b
            r2.unlock()
            r0 = r11
            goto L6a
        L62:
            com.google.common.collect.MapMakerInternalMap$h r7 = r7.getNext()     // Catch: java.lang.Throwable -> L6b
            goto L22
        L67:
            r2.unlock()
        L6a:
            return r0
        L6b:
            r11 = move-exception
            r2.unlock()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.remove(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k10, V v10, V v11) {
        b8.e.checkNotNull(k10);
        b8.e.checkNotNull(v11);
        if (v10 == null) {
            return false;
        }
        int iB = b(k10);
        Segment<K, V, E, S> segmentC = c(iB);
        segmentC.lock();
        try {
            segmentC.j();
            AtomicReferenceArray<E> atomicReferenceArray = segmentC.f9663p;
            int length = (atomicReferenceArray.length() - 1) & iB;
            h hVar = (h) atomicReferenceArray.get(length);
            h next = hVar;
            while (true) {
                if (next == null) {
                    break;
                }
                Object key = next.getKey();
                if (next.getHash() == iB && key != null && segmentC.f9659b.f9653p.equivalent(k10, key)) {
                    Object value = next.getValue();
                    if (value == null) {
                        if (next.getValue() == null) {
                            segmentC.f9661n++;
                            h hVarI = segmentC.i(hVar, next);
                            int i10 = segmentC.f9660m - 1;
                            atomicReferenceArray.set(length, hVarI);
                            segmentC.f9660m = i10;
                        }
                    } else if (segmentC.f9659b.f9654q.valueStrength().a().equivalent(v10, value)) {
                        segmentC.f9661n++;
                        segmentC.l(next, v11);
                        segmentC.unlock();
                        return true;
                    }
                } else {
                    next = next.getNext();
                }
            }
            return false;
        } finally {
            segmentC.unlock();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j10 = 0;
        for (int i10 = 0; i10 < this.f9651n.length; i10++) {
            j10 += r0[i10].f9660m;
        }
        return d8.a.saturatedCast(j10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        p pVar = this.f9656s;
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p();
        this.f9656s = pVar2;
        return pVar2;
    }

    public static abstract class Segment<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {

        /* renamed from: r, reason: collision with root package name */
        public static final /* synthetic */ int f9658r = 0;

        /* renamed from: b, reason: collision with root package name */
        public final MapMakerInternalMap<K, V, E, S> f9659b;

        /* renamed from: m, reason: collision with root package name */
        public volatile int f9660m;

        /* renamed from: n, reason: collision with root package name */
        public int f9661n;

        /* renamed from: o, reason: collision with root package name */
        public int f9662o;

        /* renamed from: p, reason: collision with root package name */
        public volatile AtomicReferenceArray<E> f9663p;

        /* renamed from: q, reason: collision with root package name */
        public final AtomicInteger f9664q = new AtomicInteger();

        public Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i10, int i11) {
            this.f9659b = mapMakerInternalMap;
            AtomicReferenceArray<E> atomicReferenceArray = new AtomicReferenceArray<>(i10);
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.f9662o = length;
            if (length == i11) {
                this.f9662o = length + 1;
            }
            this.f9663p = atomicReferenceArray;
        }

        public final void a(ReferenceQueue<K> referenceQueue) {
            int i10 = 0;
            do {
                Reference<? extends K> referencePoll = referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                h hVar = (h) referencePoll;
                MapMakerInternalMap<K, V, E, S> mapMakerInternalMap = this.f9659b;
                mapMakerInternalMap.getClass();
                int hash = hVar.getHash();
                Segment<K, V, E, S> segmentC = mapMakerInternalMap.c(hash);
                segmentC.lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = segmentC.f9663p;
                    int length = hash & (atomicReferenceArray.length() - 1);
                    h hVar2 = (h) atomicReferenceArray.get(length);
                    h next = hVar2;
                    while (true) {
                        if (next == null) {
                            break;
                        }
                        if (next == hVar) {
                            segmentC.f9661n++;
                            h hVarI = segmentC.i(hVar2, next);
                            int i11 = segmentC.f9660m - 1;
                            atomicReferenceArray.set(length, hVarI);
                            segmentC.f9660m = i11;
                            break;
                        }
                        next = next.getNext();
                    }
                    segmentC.unlock();
                    i10++;
                } catch (Throwable th2) {
                    segmentC.unlock();
                    throw th2;
                }
            } while (i10 != 16);
        }

        public final void b(ReferenceQueue<V> referenceQueue) {
            int i10 = 0;
            do {
                Reference<? extends V> referencePoll = referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                t<K, V, E> tVar = (t) referencePoll;
                MapMakerInternalMap<K, V, E, S> mapMakerInternalMap = this.f9659b;
                mapMakerInternalMap.getClass();
                h entry = tVar.getEntry();
                int hash = entry.getHash();
                Segment<K, V, E, S> segmentC = mapMakerInternalMap.c(hash);
                Object key = entry.getKey();
                segmentC.lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = segmentC.f9663p;
                    int length = (atomicReferenceArray.length() - 1) & hash;
                    h hVar = (h) atomicReferenceArray.get(length);
                    h next = hVar;
                    while (true) {
                        if (next == null) {
                            break;
                        }
                        Object key2 = next.getKey();
                        if (next.getHash() != hash || key2 == null || !segmentC.f9659b.f9653p.equivalent(key, key2)) {
                            next = next.getNext();
                        } else if (((s) next).getValueReference() == tVar) {
                            segmentC.f9661n++;
                            h hVarI = segmentC.i(hVar, next);
                            int i11 = segmentC.f9660m - 1;
                            atomicReferenceArray.set(length, hVarI);
                            segmentC.f9660m = i11;
                        }
                    }
                    segmentC.unlock();
                    i10++;
                } catch (Throwable th2) {
                    segmentC.unlock();
                    throw th2;
                }
            } while (i10 != 16);
        }

        public final void c() {
            AtomicReferenceArray<E> atomicReferenceArray = this.f9663p;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i10 = this.f9660m;
            ArrayCompositeDisposable arrayCompositeDisposable = (AtomicReferenceArray<E>) new AtomicReferenceArray(length << 1);
            this.f9662o = (arrayCompositeDisposable.length() * 3) / 4;
            int length2 = arrayCompositeDisposable.length() - 1;
            for (int i11 = 0; i11 < length; i11++) {
                E next = atomicReferenceArray.get(i11);
                if (next != null) {
                    h next2 = next.getNext();
                    int hash = next.getHash() & length2;
                    if (next2 == null) {
                        arrayCompositeDisposable.set(hash, next);
                    } else {
                        h hVar = next;
                        while (next2 != null) {
                            int hash2 = next2.getHash() & length2;
                            if (hash2 != hash) {
                                hVar = next2;
                                hash = hash2;
                            }
                            next2 = next2.getNext();
                        }
                        arrayCompositeDisposable.set(hash, hVar);
                        while (next != hVar) {
                            int hash3 = next.getHash() & length2;
                            h hVarCopy = this.f9659b.f9654q.copy(k(), next, (h) arrayCompositeDisposable.get(hash3));
                            if (hVarCopy != null) {
                                arrayCompositeDisposable.set(hash3, hVarCopy);
                            } else {
                                i10--;
                            }
                            next = next.getNext();
                        }
                    }
                }
            }
            this.f9663p = arrayCompositeDisposable;
            this.f9660m = i10;
        }

        public final h d(int i10, Object obj) {
            if (this.f9660m != 0) {
                for (E next = this.f9663p.get((r0.length() - 1) & i10); next != null; next = next.getNext()) {
                    if (next.getHash() == i10) {
                        Object key = next.getKey();
                        if (key == null) {
                            m();
                        } else if (this.f9659b.f9653p.equivalent(obj, key)) {
                            return next;
                        }
                    }
                }
            }
            return null;
        }

        public final void g() {
            if ((this.f9664q.incrementAndGet() & 63) == 0) {
                j();
            }
        }

        public final V h(K k10, int i10, V v10, boolean z10) {
            lock();
            try {
                j();
                int i11 = this.f9660m + 1;
                if (i11 > this.f9662o) {
                    c();
                    i11 = this.f9660m + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f9663p;
                int length = (atomicReferenceArray.length() - 1) & i10;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h next = hVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i10 && key != null && this.f9659b.f9653p.equivalent(k10, key)) {
                        V v11 = (V) next.getValue();
                        if (v11 == null) {
                            this.f9661n++;
                            l(next, v10);
                            this.f9660m = this.f9660m;
                            return null;
                        }
                        if (z10) {
                            return v11;
                        }
                        this.f9661n++;
                        l(next, v10);
                        return v11;
                    }
                }
                this.f9661n++;
                h hVarNewEntry = this.f9659b.f9654q.newEntry(k(), k10, i10, hVar);
                l(hVarNewEntry, v10);
                atomicReferenceArray.set(length, hVarNewEntry);
                this.f9660m = i11;
                return null;
            } finally {
                unlock();
            }
        }

        public final E i(E e10, E e11) {
            int i10 = this.f9660m;
            E e12 = (E) e11.getNext();
            while (e10 != e11) {
                h hVarCopy = this.f9659b.f9654q.copy(k(), e10, e12);
                if (hVarCopy != null) {
                    e12 = (E) hVarCopy;
                } else {
                    i10--;
                }
                e10 = (E) e10.getNext();
            }
            this.f9660m = i10;
            return e12;
        }

        public final void j() {
            if (tryLock()) {
                try {
                    f();
                    this.f9664q.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract S k();

        public final void l(E e10, V v10) {
            this.f9659b.f9654q.setValue(k(), e10, v10);
        }

        public final void m() {
            if (tryLock()) {
                try {
                    f();
                } finally {
                    unlock();
                }
            }
        }

        public void e() {
        }

        public void f() {
        }
    }

    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, m<K, V>, StrongKeyStrongValueSegment<K, V>> {
        public StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, m<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final Segment k() {
            return this;
        }
    }

    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, n<K, V>, StrongKeyWeakValueSegment<K, V>> {

        /* renamed from: s, reason: collision with root package name */
        public final ReferenceQueue<V> f9668s;

        public StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, n<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
            this.f9668s = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void e() {
            while (this.f9668s.poll() != null) {
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void f() {
            b(this.f9668s);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final Segment k() {
            return this;
        }
    }

    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> {

        /* renamed from: s, reason: collision with root package name */
        public final ReferenceQueue<K> f9669s;

        public WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
            this.f9669s = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void e() {
            while (this.f9669s.poll() != null) {
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void f() {
            a(this.f9669s);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final Segment k() {
            return this;
        }
    }

    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> {

        /* renamed from: s, reason: collision with root package name */
        public final ReferenceQueue<K> f9670s;

        /* renamed from: t, reason: collision with root package name */
        public final ReferenceQueue<V> f9671t;

        public WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
            this.f9670s = new ReferenceQueue<>();
            this.f9671t = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void e() {
            while (this.f9670s.poll() != null) {
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void f() {
            a(this.f9670s);
            b(this.f9671t);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final Segment k() {
            return this;
        }
    }

    public class a implements t<Object, Object, d> {
        @Override // com.google.common.collect.MapMakerInternalMap.t
        public t<Object, Object, d> copyFor(ReferenceQueue<Object> referenceQueue, d dVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public Object get() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public d getEntry() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public void clear() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        if (r2.f9659b.f9654q.valueStrength().a().equivalent(r12, r7.getValue()) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (r7.getValue() != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        if (r11 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        r2.f9661n++;
        r11 = r2.i(r6, r7);
        r12 = r2.f9660m - 1;
        r3.set(r4, r11);
        r2.f9660m = r12;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean remove(java.lang.Object r11, java.lang.Object r12) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L80
            if (r12 != 0) goto L7
            goto L80
        L7:
            int r1 = r10.b(r11)
            com.google.common.collect.MapMakerInternalMap$Segment r2 = r10.c(r1)
            r2.lock()
            r2.j()     // Catch: java.lang.Throwable -> L7b
            java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>> r3 = r2.f9663p     // Catch: java.lang.Throwable -> L7b
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L7b
            r5 = 1
            int r4 = r4 - r5
            r4 = r4 & r1
            java.lang.Object r6 = r3.get(r4)     // Catch: java.lang.Throwable -> L7b
            com.google.common.collect.MapMakerInternalMap$h r6 = (com.google.common.collect.MapMakerInternalMap.h) r6     // Catch: java.lang.Throwable -> L7b
            r7 = r6
        L25:
            if (r7 == 0) goto L77
            java.lang.Object r8 = r7.getKey()     // Catch: java.lang.Throwable -> L7b
            int r9 = r7.getHash()     // Catch: java.lang.Throwable -> L7b
            if (r9 != r1) goto L72
            if (r8 == 0) goto L72
            com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r9 = r2.f9659b     // Catch: java.lang.Throwable -> L7b
            com.google.common.base.Equivalence<java.lang.Object> r9 = r9.f9653p     // Catch: java.lang.Throwable -> L7b
            boolean r8 = r9.equivalent(r11, r8)     // Catch: java.lang.Throwable -> L7b
            if (r8 == 0) goto L72
            java.lang.Object r11 = r7.getValue()     // Catch: java.lang.Throwable -> L7b
            com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r1 = r2.f9659b     // Catch: java.lang.Throwable -> L7b
            com.google.common.collect.MapMakerInternalMap$i<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r1 = r1.f9654q     // Catch: java.lang.Throwable -> L7b
            com.google.common.collect.MapMakerInternalMap$Strength r1 = r1.valueStrength()     // Catch: java.lang.Throwable -> L7b
            com.google.common.base.Equivalence r1 = r1.a()     // Catch: java.lang.Throwable -> L7b
            boolean r11 = r1.equivalent(r12, r11)     // Catch: java.lang.Throwable -> L7b
            if (r11 == 0) goto L55
            r0 = 1
            goto L60
        L55:
            java.lang.Object r11 = r7.getValue()     // Catch: java.lang.Throwable -> L7b
            if (r11 != 0) goto L5d
            r11 = 1
            goto L5e
        L5d:
            r11 = 0
        L5e:
            if (r11 == 0) goto L77
        L60:
            int r11 = r2.f9661n     // Catch: java.lang.Throwable -> L7b
            int r11 = r11 + r5
            r2.f9661n = r11     // Catch: java.lang.Throwable -> L7b
            com.google.common.collect.MapMakerInternalMap$h r11 = r2.i(r6, r7)     // Catch: java.lang.Throwable -> L7b
            int r12 = r2.f9660m     // Catch: java.lang.Throwable -> L7b
            int r12 = r12 - r5
            r3.set(r4, r11)     // Catch: java.lang.Throwable -> L7b
            r2.f9660m = r12     // Catch: java.lang.Throwable -> L7b
            goto L77
        L72:
            com.google.common.collect.MapMakerInternalMap$h r7 = r7.getNext()     // Catch: java.lang.Throwable -> L7b
            goto L25
        L77:
            r2.unlock()
            return r0
        L7b:
            r11 = move-exception
            r2.unlock()
            throw r11
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.remove(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
    
        return null;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V replace(K r11, V r12) {
        /*
            r10 = this;
            b8.e.checkNotNull(r11)
            b8.e.checkNotNull(r12)
            int r0 = r10.b(r11)
            com.google.common.collect.MapMakerInternalMap$Segment r1 = r10.c(r0)
            r1.lock()
            r1.j()     // Catch: java.lang.Throwable -> L76
            java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>> r2 = r1.f9663p     // Catch: java.lang.Throwable -> L76
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L76
            r4 = 1
            int r3 = r3 - r4
            r3 = r3 & r0
            java.lang.Object r5 = r2.get(r3)     // Catch: java.lang.Throwable -> L76
            com.google.common.collect.MapMakerInternalMap$h r5 = (com.google.common.collect.MapMakerInternalMap.h) r5     // Catch: java.lang.Throwable -> L76
            r6 = r5
        L24:
            r7 = 0
            if (r6 == 0) goto L72
            java.lang.Object r8 = r6.getKey()     // Catch: java.lang.Throwable -> L76
            int r9 = r6.getHash()     // Catch: java.lang.Throwable -> L76
            if (r9 != r0) goto L6d
            if (r8 == 0) goto L6d
            com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r9 = r1.f9659b     // Catch: java.lang.Throwable -> L76
            com.google.common.base.Equivalence<java.lang.Object> r9 = r9.f9653p     // Catch: java.lang.Throwable -> L76
            boolean r8 = r9.equivalent(r11, r8)     // Catch: java.lang.Throwable -> L76
            if (r8 == 0) goto L6d
            java.lang.Object r11 = r6.getValue()     // Catch: java.lang.Throwable -> L76
            if (r11 != 0) goto L60
            java.lang.Object r11 = r6.getValue()     // Catch: java.lang.Throwable -> L76
            if (r11 != 0) goto L4b
            r11 = 1
            goto L4c
        L4b:
            r11 = 0
        L4c:
            if (r11 == 0) goto L72
            int r11 = r1.f9661n     // Catch: java.lang.Throwable -> L76
            int r11 = r11 + r4
            r1.f9661n = r11     // Catch: java.lang.Throwable -> L76
            com.google.common.collect.MapMakerInternalMap$h r11 = r1.i(r5, r6)     // Catch: java.lang.Throwable -> L76
            int r12 = r1.f9660m     // Catch: java.lang.Throwable -> L76
            int r12 = r12 - r4
            r2.set(r3, r11)     // Catch: java.lang.Throwable -> L76
            r1.f9660m = r12     // Catch: java.lang.Throwable -> L76
            goto L72
        L60:
            int r0 = r1.f9661n     // Catch: java.lang.Throwable -> L76
            int r0 = r0 + r4
            r1.f9661n = r0     // Catch: java.lang.Throwable -> L76
            r1.l(r6, r12)     // Catch: java.lang.Throwable -> L76
            r1.unlock()
            r7 = r11
            goto L75
        L6d:
            com.google.common.collect.MapMakerInternalMap$h r6 = r6.getNext()     // Catch: java.lang.Throwable -> L76
            goto L24
        L72:
            r1.unlock()
        L75:
            return r7
        L76:
            r11 = move-exception
            r1.unlock()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.replace(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
