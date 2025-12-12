package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class ImmutableMultimap<K, V> extends c8.d<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: b, reason: collision with root package name */
    public final transient ImmutableMap<K, ? extends ImmutableCollection<V>> f9645b;

    public static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Map<K, Collection<V>> f9646a = CompactHashMap.create();
    }

    public ImmutableMultimap(ImmutableMap immutableMap) {
        this.f9645b = immutableMap;
    }

    @Override // c8.c
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // c8.c
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // c8.c
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // c8.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // c8.c, c8.g
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.f9645b;
    }
}
