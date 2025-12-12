package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.n;
import com.google.gson.u;
import com.google.gson.w;
import com.google.gson.x;
import v9.l;

/* loaded from: classes.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements x {

    /* renamed from: b, reason: collision with root package name */
    public final l f10115b;

    public JsonAdapterAnnotationTypeAdapterFactory(l lVar) {
        this.f10115b = lVar;
    }

    public static w a(l lVar, i iVar, y9.a aVar, u9.a aVar2) {
        w treeTypeAdapter;
        Object objConstruct = lVar.get(y9.a.get((Class) aVar2.value())).construct();
        if (objConstruct instanceof w) {
            treeTypeAdapter = (w) objConstruct;
        } else if (objConstruct instanceof x) {
            treeTypeAdapter = ((x) objConstruct).create(iVar, aVar);
        } else {
            boolean z10 = objConstruct instanceof u;
            if (!z10 && !(objConstruct instanceof n)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objConstruct.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            treeTypeAdapter = new TreeTypeAdapter(z10 ? (u) objConstruct : null, objConstruct instanceof n ? (n) objConstruct : null, iVar, aVar, null);
        }
        return (treeTypeAdapter == null || !aVar2.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.nullSafe();
    }

    @Override // com.google.gson.x
    public <T> w<T> create(i iVar, y9.a<T> aVar) {
        u9.a aVar2 = (u9.a) aVar.getRawType().getAnnotation(u9.a.class);
        if (aVar2 == null) {
            return null;
        }
        return a(this.f10115b, iVar, aVar, aVar2);
    }
}
