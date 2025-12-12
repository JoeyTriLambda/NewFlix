package com.unity3d.services.core.di;

import lf.e;
import yf.a;
import zf.i;

/* compiled from: ServiceFactory.kt */
/* loaded from: classes2.dex */
public final class ServiceFactoryKt {
    public static final <T> e<T> factoryOf(a<? extends T> aVar) {
        i.checkNotNullParameter(aVar, "initializer");
        return new Factory(aVar);
    }
}
