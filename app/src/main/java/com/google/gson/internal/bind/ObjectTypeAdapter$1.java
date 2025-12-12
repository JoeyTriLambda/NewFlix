package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.v;
import com.google.gson.w;
import com.google.gson.x;

/* loaded from: classes.dex */
class ObjectTypeAdapter$1 implements x {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f10123b;

    public ObjectTypeAdapter$1(v vVar) {
        this.f10123b = vVar;
    }

    @Override // com.google.gson.x
    public <T> w<T> create(i iVar, y9.a<T> aVar) {
        if (aVar.getRawType() == Object.class) {
            return new e(iVar, this.f10123b);
        }
        return null;
    }
}
