package com.google.common.collect;

import com.google.common.collect.CompactHashMap;
import java.util.Map;

/* compiled from: CompactHashMap.java */
/* loaded from: classes.dex */
public final class b extends CompactHashMap<Object, Object>.b<Map.Entry<Object, Object>> {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ CompactHashMap f9726p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(CompactHashMap compactHashMap) {
        super();
        this.f9726p = compactHashMap;
    }

    @Override // com.google.common.collect.CompactHashMap.b
    public final Map.Entry<Object, Object> a(int i10) {
        return new CompactHashMap.d(i10);
    }
}
