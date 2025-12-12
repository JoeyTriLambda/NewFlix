package com.unity3d.services.core.di;

import gg.b;
import java.util.Map;
import lf.e;

/* compiled from: IServicesRegistry.kt */
/* loaded from: classes2.dex */
public interface IServicesRegistry {

    /* compiled from: IServicesRegistry.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getService$default(IServicesRegistry iServicesRegistry, String str, b bVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getService");
            }
            if ((i10 & 1) != 0) {
                str = "";
            }
            return iServicesRegistry.getService(str, bVar);
        }
    }

    <T> T getService(String str, b<?> bVar);

    Map<ServiceKey, e<?>> getServices();

    <T> T resolveService(ServiceKey serviceKey);

    <T> T resolveServiceOrNull(ServiceKey serviceKey);

    <T> void updateService(ServiceKey serviceKey, e<? extends T> eVar);
}
