package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.w;
import java.io.IOException;
import java.lang.reflect.Field;

/* compiled from: ReflectiveTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class f extends ReflectiveTypeAdapterFactory.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f10202d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Field f10203e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f10204f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ w f10205g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i f10206h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ y9.a f10207i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f10208j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, boolean z10, boolean z11, boolean z12, Field field, boolean z13, w wVar, i iVar, y9.a aVar, boolean z14) {
        super(str, z10, z11);
        this.f10202d = z12;
        this.f10203e = field;
        this.f10204f = z13;
        this.f10205g = wVar;
        this.f10206h = iVar;
        this.f10207i = aVar;
        this.f10208j = z14;
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
    public final void a(z9.a aVar, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException {
        Object obj2 = this.f10205g.read(aVar);
        if (obj2 == null && this.f10208j) {
            return;
        }
        boolean z10 = this.f10202d;
        Field field = this.f10203e;
        if (z10) {
            ReflectiveTypeAdapterFactory.a(obj, field);
        }
        field.set(obj, obj2);
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
    public final void b(z9.b bVar, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException {
        if (this.f10132b) {
            boolean z10 = this.f10202d;
            Field field = this.f10203e;
            if (z10) {
                ReflectiveTypeAdapterFactory.a(obj, field);
            }
            Object obj2 = field.get(obj);
            if (obj2 == obj) {
                return;
            }
            bVar.name(this.f10131a);
            boolean z11 = this.f10204f;
            w gVar = this.f10205g;
            if (!z11) {
                gVar = new g(this.f10206h, gVar, this.f10207i.getType());
            }
            gVar.write(bVar, obj2);
        }
    }
}
