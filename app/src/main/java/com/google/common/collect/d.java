package com.google.common.collect;

import b8.c;
import b8.e;
import com.google.common.collect.MapMakerInternalMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: MapMaker.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9728a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9729b = -1;

    /* renamed from: c, reason: collision with root package name */
    public final int f9730c = -1;

    /* renamed from: d, reason: collision with root package name */
    public MapMakerInternalMap.Strength f9731d;

    public final MapMakerInternalMap.Strength a() {
        return (MapMakerInternalMap.Strength) b8.c.firstNonNull(this.f9731d, MapMakerInternalMap.Strength.f9665b);
    }

    public <K, V> ConcurrentMap<K, V> makeMap() {
        if (!this.f9728a) {
            int i10 = this.f9729b;
            if (i10 == -1) {
                i10 = 16;
            }
            int i11 = this.f9730c;
            if (i11 == -1) {
                i11 = 4;
            }
            return new ConcurrentHashMap(i10, 0.75f, i11);
        }
        MapMakerInternalMap.a aVar = MapMakerInternalMap.f9648u;
        MapMakerInternalMap.Strength strengthA = a();
        MapMakerInternalMap.Strength.AnonymousClass1 anonymousClass1 = MapMakerInternalMap.Strength.f9665b;
        if (strengthA == anonymousClass1 && ((MapMakerInternalMap.Strength) b8.c.firstNonNull(null, anonymousClass1)) == anonymousClass1) {
            return new MapMakerInternalMap(this, MapMakerInternalMap.m.a.f9688a);
        }
        MapMakerInternalMap.Strength strengthA2 = a();
        MapMakerInternalMap.Strength.AnonymousClass2 anonymousClass2 = MapMakerInternalMap.Strength.f9666m;
        if (strengthA2 == anonymousClass1 && ((MapMakerInternalMap.Strength) b8.c.firstNonNull(null, anonymousClass1)) == anonymousClass2) {
            return new MapMakerInternalMap(this, MapMakerInternalMap.n.a.f9690a);
        }
        if (a() == anonymousClass2 && ((MapMakerInternalMap.Strength) b8.c.firstNonNull(null, anonymousClass1)) == anonymousClass1) {
            return new MapMakerInternalMap(this, MapMakerInternalMap.q.a.f9693a);
        }
        if (a() == anonymousClass2 && ((MapMakerInternalMap.Strength) b8.c.firstNonNull(null, anonymousClass1)) == anonymousClass2) {
            return new MapMakerInternalMap(this, MapMakerInternalMap.r.a.f9695a);
        }
        throw new AssertionError();
    }

    public String toString() {
        c.a stringHelper = b8.c.toStringHelper(this);
        int i10 = this.f9729b;
        if (i10 != -1) {
            stringHelper.add("initialCapacity", i10);
        }
        int i11 = this.f9730c;
        if (i11 != -1) {
            stringHelper.add("concurrencyLevel", i11);
        }
        MapMakerInternalMap.Strength strength = this.f9731d;
        if (strength != null) {
            stringHelper.add("keyStrength", b8.a.toLowerCase(strength.toString()));
        }
        return stringHelper.toString();
    }

    public d weakKeys() {
        MapMakerInternalMap.Strength.AnonymousClass2 anonymousClass2 = MapMakerInternalMap.Strength.f9666m;
        MapMakerInternalMap.Strength strength = this.f9731d;
        e.checkState(strength == null, "Key strength was already set to %s", strength);
        this.f9731d = (MapMakerInternalMap.Strength) e.checkNotNull(anonymousClass2);
        this.f9728a = true;
        return this;
    }
}
