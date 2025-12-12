package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* loaded from: classes.dex */
public final class g<T> extends w<T> {

    /* renamed from: a, reason: collision with root package name */
    public final i f10209a;

    /* renamed from: b, reason: collision with root package name */
    public final w<T> f10210b;

    /* renamed from: c, reason: collision with root package name */
    public final Type f10211c;

    public g(i iVar, w<T> wVar, Type type) {
        this.f10209a = iVar;
        this.f10210b = wVar;
        this.f10211c = type;
    }

    @Override // com.google.gson.w
    public T read(z9.a aVar) throws IOException {
        return this.f10210b.read(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.reflect.Type] */
    @Override // com.google.gson.w
    public void write(z9.b bVar, T t10) throws IOException {
        ?? r02 = this.f10211c;
        Class<?> cls = (t10 == null || !(r02 == Object.class || (r02 instanceof TypeVariable) || (r02 instanceof Class))) ? r02 : t10.getClass();
        w<T> wVar = this.f10210b;
        if (cls != r02) {
            w<T> adapter = this.f10209a.getAdapter(y9.a.get((Type) cls));
            if (!(adapter instanceof ReflectiveTypeAdapterFactory.a) || (wVar instanceof ReflectiveTypeAdapterFactory.a)) {
                wVar = adapter;
            }
        }
        wVar.write(bVar, t10);
    }
}
