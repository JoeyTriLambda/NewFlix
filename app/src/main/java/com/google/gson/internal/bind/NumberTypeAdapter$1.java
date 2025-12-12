package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.w;
import com.google.gson.x;

/* loaded from: classes.dex */
class NumberTypeAdapter$1 implements x {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f10122b;

    public NumberTypeAdapter$1(d dVar) {
        this.f10122b = dVar;
    }

    @Override // com.google.gson.x
    public <T> w<T> create(i iVar, y9.a<T> aVar) {
        if (aVar.getRawType() == Number.class) {
            return this.f10122b;
        }
        return null;
    }
}
