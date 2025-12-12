package com.google.common.collect;

import c8.i;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.RegularImmutableMap;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public transient ImmutableSet<Map.Entry<K, V>> f9636b;

    /* renamed from: m, reason: collision with root package name */
    public transient ImmutableSet<K> f9637m;

    /* renamed from: n, reason: collision with root package name */
    public transient ImmutableCollection<V> f9638n;

    public static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public Object[] f9639a;

        /* renamed from: b, reason: collision with root package name */
        public int f9640b = 0;

        /* renamed from: c, reason: collision with root package name */
        public C0098a f9641c;

        /* renamed from: com.google.common.collect.ImmutableMap$a$a, reason: collision with other inner class name */
        public static final class C0098a {

            /* renamed from: a, reason: collision with root package name */
            public final Object f9642a;

            /* renamed from: b, reason: collision with root package name */
            public final Object f9643b;

            /* renamed from: c, reason: collision with root package name */
            public final Object f9644c;

            public C0098a(Object obj, Object obj2, Object obj3) {
                this.f9642a = obj;
                this.f9643b = obj2;
                this.f9644c = obj3;
            }

            public final IllegalArgumentException a() {
                Object obj = this.f9642a;
                String strValueOf = String.valueOf(obj);
                String strValueOf2 = String.valueOf(this.f9643b);
                String strValueOf3 = String.valueOf(obj);
                String strValueOf4 = String.valueOf(this.f9644c);
                StringBuilder sb2 = new StringBuilder(strValueOf4.length() + strValueOf3.length() + strValueOf2.length() + strValueOf.length() + 39);
                sb2.append("Multiple entries with same key: ");
                sb2.append(strValueOf);
                sb2.append("=");
                sb2.append(strValueOf2);
                sb2.append(" and ");
                sb2.append(strValueOf3);
                sb2.append("=");
                sb2.append(strValueOf4);
                return new IllegalArgumentException(sb2.toString());
            }
        }

        public a(int i10) {
            this.f9639a = new Object[i10 * 2];
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:71:0x018f  */
        /* JADX WARN: Type inference failed for: r15v0 */
        /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r4v2, types: [int[]] */
        /* JADX WARN: Type inference failed for: r4v8 */
        /* JADX WARN: Type inference failed for: r6v11 */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object[]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.common.collect.ImmutableMap<K, V> buildOrThrow() {
            /*
                Method dump skipped, instructions count: 446
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableMap.a.buildOrThrow():com.google.common.collect.ImmutableMap");
        }

        public a<K, V> put(K k10, V v10) {
            int i10 = (this.f9640b + 1) * 2;
            Object[] objArr = this.f9639a;
            if (i10 > objArr.length) {
                this.f9639a = Arrays.copyOf(objArr, ImmutableCollection.b.a(objArr.length, i10));
            }
            if (k10 == null) {
                String strValueOf = String.valueOf(v10);
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 24);
                sb2.append("null key in entry: null=");
                sb2.append(strValueOf);
                throw new NullPointerException(sb2.toString());
            }
            if (v10 == null) {
                String strValueOf2 = String.valueOf(k10);
                StringBuilder sb3 = new StringBuilder(strValueOf2.length() + 26);
                sb3.append("null value in entry: ");
                sb3.append(strValueOf2);
                sb3.append("=null");
                throw new NullPointerException(sb3.toString());
            }
            Object[] objArr2 = this.f9639a;
            int i11 = this.f9640b;
            int i12 = i11 * 2;
            objArr2[i12] = k10;
            objArr2[i12 + 1] = v10;
            this.f9640b = i11 + 1;
            return this;
        }
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.f9703r;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v10) {
        V v11 = get(obj);
        return v11 != null ? v11 : v10;
    }

    @Override // java.util.Map
    public int hashCode() {
        return i.c(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        i.a(size, "size");
        StringBuilder sb2 = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb2.append('{');
        boolean z10 = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
            z10 = false;
        }
        sb2.append('}');
        return sb2.toString();
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.f9636b;
        if (immutableSet != null) {
            return immutableSet;
        }
        RegularImmutableMap regularImmutableMap = (RegularImmutableMap) this;
        RegularImmutableMap.EntrySet entrySet = new RegularImmutableMap.EntrySet(regularImmutableMap, regularImmutableMap.f9705p, regularImmutableMap.f9706q);
        this.f9636b = entrySet;
        return entrySet;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.f9637m;
        if (immutableSet != null) {
            return immutableSet;
        }
        RegularImmutableMap regularImmutableMap = (RegularImmutableMap) this;
        RegularImmutableMap.KeySet keySet = new RegularImmutableMap.KeySet(regularImmutableMap, new RegularImmutableMap.KeysOrValuesAsList(regularImmutableMap.f9705p, 0, regularImmutableMap.f9706q));
        this.f9637m = keySet;
        return keySet;
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.f9638n;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        RegularImmutableMap regularImmutableMap = (RegularImmutableMap) this;
        RegularImmutableMap.KeysOrValuesAsList keysOrValuesAsList = new RegularImmutableMap.KeysOrValuesAsList(regularImmutableMap.f9705p, 1, regularImmutableMap.f9706q);
        this.f9638n = keysOrValuesAsList;
        return keysOrValuesAsList;
    }
}
