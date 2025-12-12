package com.google.common.collect;

/* compiled from: CompactHashMap.java */
/* loaded from: classes.dex */
public final class c extends CompactHashMap<Object, Object>.b<Object> {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ CompactHashMap f9727p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(CompactHashMap compactHashMap) {
        super();
        this.f9727p = compactHashMap;
    }

    @Override // com.google.common.collect.CompactHashMap.b
    public final Object a(int i10) {
        Object obj = CompactHashMap.f9606u;
        return this.f9727p.k(i10);
    }
}
