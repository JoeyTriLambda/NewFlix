package com.unity3d.services.core.di;

import gg.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lf.e;
import yf.a;
import zf.i;
import zf.k;

/* compiled from: ServicesRegistry.kt */
/* loaded from: classes2.dex */
public final class ServicesRegistry implements IServicesRegistry {
    private final ConcurrentHashMap<ServiceKey, e<?>> _services = new ConcurrentHashMap<>();

    public static /* synthetic */ ServiceKey factory$default(ServicesRegistry servicesRegistry, String str, a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        i.checkNotNullParameter(str, "named");
        i.checkNotNullParameter(aVar, "instance");
        i.reifiedOperationMarker(4, "T");
        ServiceKey serviceKey = new ServiceKey(str, k.getOrCreateKotlinClass(Object.class));
        servicesRegistry.updateService(serviceKey, ServiceFactoryKt.factoryOf(aVar));
        return serviceKey;
    }

    public static /* synthetic */ Object get$default(ServicesRegistry servicesRegistry, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        i.checkNotNullParameter(str, "named");
        i.reifiedOperationMarker(4, "T");
        return servicesRegistry.resolveService(new ServiceKey(str, k.getOrCreateKotlinClass(Object.class)));
    }

    public static /* synthetic */ Object getOrNull$default(ServicesRegistry servicesRegistry, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        i.checkNotNullParameter(str, "named");
        i.reifiedOperationMarker(4, "T");
        return servicesRegistry.resolveServiceOrNull(new ServiceKey(str, k.getOrCreateKotlinClass(Object.class)));
    }

    public static /* synthetic */ ServiceKey single$default(ServicesRegistry servicesRegistry, String str, a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        i.checkNotNullParameter(str, "named");
        i.checkNotNullParameter(aVar, "instance");
        i.reifiedOperationMarker(4, "T");
        ServiceKey serviceKey = new ServiceKey(str, k.getOrCreateKotlinClass(Object.class));
        servicesRegistry.updateService(serviceKey, kotlin.a.lazy(aVar));
        return serviceKey;
    }

    public final /* synthetic */ <T> ServiceKey factory(String str, a<? extends T> aVar) {
        i.checkNotNullParameter(str, "named");
        i.checkNotNullParameter(aVar, "instance");
        i.reifiedOperationMarker(4, "T");
        ServiceKey serviceKey = new ServiceKey(str, k.getOrCreateKotlinClass(Object.class));
        updateService(serviceKey, ServiceFactoryKt.factoryOf(aVar));
        return serviceKey;
    }

    public final /* synthetic */ <T> T get(String str) {
        i.checkNotNullParameter(str, "named");
        i.reifiedOperationMarker(4, "T");
        return (T) resolveService(new ServiceKey(str, k.getOrCreateKotlinClass(Object.class)));
    }

    public final /* synthetic */ <T> T getOrNull(String str) {
        i.checkNotNullParameter(str, "named");
        i.reifiedOperationMarker(4, "T");
        return (T) resolveServiceOrNull(new ServiceKey(str, k.getOrCreateKotlinClass(Object.class)));
    }

    @Override // com.unity3d.services.core.di.IServicesRegistry
    public <T> T getService(String str, b<?> bVar) {
        i.checkNotNullParameter(str, "named");
        i.checkNotNullParameter(bVar, "instance");
        return (T) resolveService(new ServiceKey(str, bVar));
    }

    @Override // com.unity3d.services.core.di.IServicesRegistry
    public Map<ServiceKey, e<?>> getServices() {
        return this._services;
    }

    @Override // com.unity3d.services.core.di.IServicesRegistry
    public <T> T resolveService(ServiceKey serviceKey) {
        i.checkNotNullParameter(serviceKey, "key");
        e<?> eVar = getServices().get(serviceKey);
        if (eVar != null) {
            return (T) eVar.getValue();
        }
        throw new IllegalStateException("No service instance found for " + serviceKey);
    }

    @Override // com.unity3d.services.core.di.IServicesRegistry
    public <T> T resolveServiceOrNull(ServiceKey serviceKey) {
        i.checkNotNullParameter(serviceKey, "key");
        e<?> eVar = getServices().get(serviceKey);
        if (eVar == null) {
            return null;
        }
        return (T) eVar.getValue();
    }

    public final /* synthetic */ <T> ServiceKey single(String str, a<? extends T> aVar) {
        i.checkNotNullParameter(str, "named");
        i.checkNotNullParameter(aVar, "instance");
        i.reifiedOperationMarker(4, "T");
        ServiceKey serviceKey = new ServiceKey(str, k.getOrCreateKotlinClass(Object.class));
        updateService(serviceKey, kotlin.a.lazy(aVar));
        return serviceKey;
    }

    @Override // com.unity3d.services.core.di.IServicesRegistry
    public <T> void updateService(ServiceKey serviceKey, e<? extends T> eVar) {
        i.checkNotNullParameter(serviceKey, "key");
        i.checkNotNullParameter(eVar, "instance");
        if (!(!getServices().containsKey(serviceKey))) {
            throw new IllegalStateException("Cannot have multiple identical services".toString());
        }
        this._services.put(serviceKey, eVar);
    }
}
