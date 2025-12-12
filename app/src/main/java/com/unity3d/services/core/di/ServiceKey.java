package com.unity3d.services.core.di;

import gg.b;
import zf.f;
import zf.i;

/* compiled from: ServiceKey.kt */
/* loaded from: classes2.dex */
public final class ServiceKey {
    private final b<?> instanceClass;
    private final String named;

    public ServiceKey(String str, b<?> bVar) {
        i.checkNotNullParameter(str, "named");
        i.checkNotNullParameter(bVar, "instanceClass");
        this.named = str;
        this.instanceClass = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServiceKey copy$default(ServiceKey serviceKey, String str, b bVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = serviceKey.named;
        }
        if ((i10 & 2) != 0) {
            bVar = serviceKey.instanceClass;
        }
        return serviceKey.copy(str, bVar);
    }

    public final String component1() {
        return this.named;
    }

    public final b<?> component2() {
        return this.instanceClass;
    }

    public final ServiceKey copy(String str, b<?> bVar) {
        i.checkNotNullParameter(str, "named");
        i.checkNotNullParameter(bVar, "instanceClass");
        return new ServiceKey(str, bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServiceKey)) {
            return false;
        }
        ServiceKey serviceKey = (ServiceKey) obj;
        return i.areEqual(this.named, serviceKey.named) && i.areEqual(this.instanceClass, serviceKey.instanceClass);
    }

    public final b<?> getInstanceClass() {
        return this.instanceClass;
    }

    public final String getNamed() {
        return this.named;
    }

    public int hashCode() {
        return this.instanceClass.hashCode() + (this.named.hashCode() * 31);
    }

    public String toString() {
        return "ServiceKey(named=" + this.named + ", instanceClass=" + this.instanceClass + ')';
    }

    public /* synthetic */ ServiceKey(String str, b bVar, int i10, f fVar) {
        this((i10 & 1) != 0 ? "" : str, bVar);
    }
}
