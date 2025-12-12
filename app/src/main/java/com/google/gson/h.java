package com.google.gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson.java */
/* loaded from: classes.dex */
public final class h extends w<AtomicLongArray> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f10048a;

    public h(w wVar) {
        this.f10048a = wVar;
    }

    @Override // com.google.gson.w
    public AtomicLongArray read(z9.a aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        aVar.beginArray();
        while (aVar.hasNext()) {
            arrayList.add(Long.valueOf(((Number) this.f10048a.read(aVar)).longValue()));
        }
        aVar.endArray();
        int size = arrayList.size();
        AtomicLongArray atomicLongArray = new AtomicLongArray(size);
        for (int i10 = 0; i10 < size; i10++) {
            atomicLongArray.set(i10, ((Long) arrayList.get(i10)).longValue());
        }
        return atomicLongArray;
    }

    @Override // com.google.gson.w
    public void write(z9.b bVar, AtomicLongArray atomicLongArray) throws IOException {
        bVar.beginArray();
        int length = atomicLongArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            this.f10048a.write(bVar, Long.valueOf(atomicLongArray.get(i10)));
        }
        bVar.endArray();
    }
}
