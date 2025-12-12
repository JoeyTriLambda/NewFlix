package com.unity3d.services.core.di;

import lf.h;
import yf.l;
import zf.i;

/* compiled from: ServicesRegistry.kt */
/* loaded from: classes2.dex */
public final class ServicesRegistryKt {
    public static final ServicesRegistry registry(l<? super ServicesRegistry, h> lVar) {
        i.checkNotNullParameter(lVar, "registry");
        ServicesRegistry servicesRegistry = new ServicesRegistry();
        lVar.invoke(servicesRegistry);
        return servicesRegistry;
    }
}
