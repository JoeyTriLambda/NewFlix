package com.unity3d.services.core.di;

import lf.e;
import yf.a;
import zf.i;

/* compiled from: ServiceFactory.kt */
/* loaded from: classes2.dex */
final class Factory<T> implements e<T> {
    private final a<T> initializer;

    /* JADX WARN: Multi-variable type inference failed */
    public Factory(a<? extends T> aVar) {
        i.checkNotNullParameter(aVar, "initializer");
        this.initializer = aVar;
    }

    @Override // lf.e
    public T getValue() {
        return this.initializer.invoke();
    }

    @Override // lf.e
    public boolean isInitialized() {
        return false;
    }
}
