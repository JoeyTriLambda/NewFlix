package com.google.gson;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Gson.java */
/* loaded from: classes.dex */
public final class g extends w<AtomicLong> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f10047a;

    public g(w wVar) {
        this.f10047a = wVar;
    }

    @Override // com.google.gson.w
    public AtomicLong read(z9.a aVar) throws IOException {
        return new AtomicLong(((Number) this.f10047a.read(aVar)).longValue());
    }

    @Override // com.google.gson.w
    public void write(z9.b bVar, AtomicLong atomicLong) throws IOException {
        this.f10047a.write(bVar, Long.valueOf(atomicLong.get()));
    }
}
