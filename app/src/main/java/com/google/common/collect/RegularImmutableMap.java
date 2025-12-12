package com.google.common.collect;

import b8.e;
import c8.j;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {

    /* renamed from: r, reason: collision with root package name */
    public static final ImmutableMap<Object, Object> f9703r = new RegularImmutableMap(null, new Object[0], 0);
    private static final long serialVersionUID = 0;

    /* renamed from: o, reason: collision with root package name */
    public final transient Object f9704o;

    /* renamed from: p, reason: collision with root package name */
    public final transient Object[] f9705p;

    /* renamed from: q, reason: collision with root package name */
    public final transient int f9706q;

    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* renamed from: n, reason: collision with root package name */
        public final transient ImmutableMap<K, V> f9707n;

        /* renamed from: o, reason: collision with root package name */
        public final transient Object[] f9708o;

        /* renamed from: p, reason: collision with root package name */
        public final transient int f9709p = 0;

        /* renamed from: q, reason: collision with root package name */
        public final transient int f9710q;

        public EntrySet(ImmutableMap immutableMap, Object[] objArr, int i10) {
            this.f9707n = immutableMap;
            this.f9708o = objArr;
            this.f9710q = i10;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int a(Object[] objArr) {
            return asList().a(objArr);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f9707n.get(key));
        }

        @Override // com.google.common.collect.ImmutableSet
        public final ImmutableList<Map.Entry<K, V>> g() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // java.util.List
                public Map.Entry<K, V> get(int i10) {
                    EntrySet entrySet = EntrySet.this;
                    e.checkElementIndex(i10, entrySet.f9710q);
                    int i11 = i10 * 2;
                    Object obj = entrySet.f9708o[entrySet.f9709p + i11];
                    Objects.requireNonNull(obj);
                    Object obj2 = entrySet.f9708o[i11 + (entrySet.f9709p ^ 1)];
                    Objects.requireNonNull(obj2);
                    return new AbstractMap.SimpleImmutableEntry(obj, obj2);
                }

                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return EntrySet.this.f9710q;
                }
            };
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f9710q;
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public j<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    public static final class KeySet<K> extends ImmutableSet<K> {

        /* renamed from: n, reason: collision with root package name */
        public final transient ImmutableMap<K, ?> f9712n;

        /* renamed from: o, reason: collision with root package name */
        public final transient ImmutableList<K> f9713o;

        public KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.f9712n = immutableMap;
            this.f9713o = immutableList;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int a(Object[] objArr) {
            return asList().a(objArr);
        }

        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<K> asList() {
            return this.f9713o;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f9712n.get(obj) != null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f9712n.size();
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public j<K> iterator() {
            return asList().iterator();
        }
    }

    public static final class KeysOrValuesAsList extends ImmutableList<Object> {

        /* renamed from: n, reason: collision with root package name */
        public final transient Object[] f9714n;

        /* renamed from: o, reason: collision with root package name */
        public final transient int f9715o;

        /* renamed from: p, reason: collision with root package name */
        public final transient int f9716p;

        public KeysOrValuesAsList(Object[] objArr, int i10, int i11) {
            this.f9714n = objArr;
            this.f9715o = i10;
            this.f9716p = i11;
        }

        @Override // java.util.List
        public Object get(int i10) {
            e.checkElementIndex(i10, this.f9716p);
            Object obj = this.f9714n[(i10 * 2) + this.f9715o];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f9716p;
        }
    }

    public RegularImmutableMap(Object obj, Object[] objArr, int i10) {
        this.f9704o = obj;
        this.f9705p = objArr;
        this.f9706q = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001e A[EDGE_INSN: B:45:0x001e->B:10:0x001e BREAK  A[LOOP:0: B:17:0x0039->B:23:0x004f], EDGE_INSN: B:47:0x001e->B:10:0x001e BREAK  A[LOOP:1: B:27:0x0064->B:33:0x007b], EDGE_INSN: B:49:0x001e->B:10:0x001e BREAK  A[LOOP:2: B:35:0x008a->B:44:0x00a0]] */
    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V get(java.lang.Object r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L4
            goto L1e
        L4:
            r1 = 1
            java.lang.Object[] r2 = r9.f9705p
            int r3 = r9.f9706q
            if (r3 != r1) goto L21
            r3 = 0
            r3 = r2[r3]
            java.util.Objects.requireNonNull(r3)
            boolean r10 = r3.equals(r10)
            if (r10 == 0) goto L1e
            r10 = r2[r1]
            java.util.Objects.requireNonNull(r10)
            goto L9c
        L1e:
            r10 = r0
            goto L9c
        L21:
            java.lang.Object r3 = r9.f9704o
            if (r3 != 0) goto L26
            goto L1e
        L26:
            boolean r4 = r3 instanceof byte[]
            r5 = -1
            if (r4 == 0) goto L52
            r4 = r3
            byte[] r4 = (byte[]) r4
            int r3 = r4.length
            int r6 = r3 + (-1)
            int r3 = r10.hashCode()
            int r3 = c8.i.j(r3)
        L39:
            r3 = r3 & r6
            r5 = r4[r3]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L42
            goto L1e
        L42:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L4f
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L9c
        L4f:
            int r3 = r3 + 1
            goto L39
        L52:
            boolean r4 = r3 instanceof short[]
            if (r4 == 0) goto L7e
            r4 = r3
            short[] r4 = (short[]) r4
            int r3 = r4.length
            int r6 = r3 + (-1)
            int r3 = r10.hashCode()
            int r3 = c8.i.j(r3)
        L64:
            r3 = r3 & r6
            short r5 = r4[r3]
            r7 = 65535(0xffff, float:9.1834E-41)
            r5 = r5 & r7
            if (r5 != r7) goto L6e
            goto L1e
        L6e:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L7b
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L9c
        L7b:
            int r3 = r3 + 1
            goto L64
        L7e:
            int[] r3 = (int[]) r3
            int r4 = r3.length
            int r4 = r4 - r1
            int r6 = r10.hashCode()
            int r6 = c8.i.j(r6)
        L8a:
            r6 = r6 & r4
            r7 = r3[r6]
            if (r7 != r5) goto L90
            goto L1e
        L90:
            r8 = r2[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto La0
            r10 = r7 ^ 1
            r10 = r2[r10]
        L9c:
            if (r10 != 0) goto L9f
            return r0
        L9f:
            return r10
        La0:
            int r6 = r6 + 1
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularImmutableMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public int size() {
        return this.f9706q;
    }
}
