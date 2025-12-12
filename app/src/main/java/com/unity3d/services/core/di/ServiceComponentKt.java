package com.unity3d.services.core.di;

import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Lambda;
import lf.e;
import yf.a;
import zf.i;
import zf.k;

/* compiled from: ServiceComponent.kt */
/* loaded from: classes2.dex */
public final class ServiceComponentKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ServiceComponent.kt */
    /* renamed from: com.unity3d.services.core.di.ServiceComponentKt$inject$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends Lambda implements a<T> {
        final /* synthetic */ String $named;
        final /* synthetic */ ServiceComponent $this_inject;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ServiceComponent serviceComponent, String str) {
            super(0);
            this.$this_inject = serviceComponent;
            this.$named = str;
        }

        @Override // yf.a
        public final T invoke() {
            ServiceComponent serviceComponent = this.$this_inject;
            String str = this.$named;
            IServicesRegistry registry = serviceComponent.getServiceProvider().getRegistry();
            i.reifiedOperationMarker(4, "T");
            return (T) registry.getService(str, k.getOrCreateKotlinClass(Object.class));
        }
    }

    public static final /* synthetic */ <T> T get(ServiceComponent serviceComponent, String str) {
        i.checkNotNullParameter(serviceComponent, "<this>");
        i.checkNotNullParameter(str, "named");
        IServicesRegistry registry = serviceComponent.getServiceProvider().getRegistry();
        i.reifiedOperationMarker(4, "T");
        return (T) registry.getService(str, k.getOrCreateKotlinClass(Object.class));
    }

    public static /* synthetic */ Object get$default(ServiceComponent serviceComponent, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        i.checkNotNullParameter(serviceComponent, "<this>");
        i.checkNotNullParameter(str, "named");
        IServicesRegistry registry = serviceComponent.getServiceProvider().getRegistry();
        i.reifiedOperationMarker(4, "T");
        return registry.getService(str, k.getOrCreateKotlinClass(Object.class));
    }

    public static final /* synthetic */ <T> e<T> inject(ServiceComponent serviceComponent, String str, LazyThreadSafetyMode lazyThreadSafetyMode) {
        i.checkNotNullParameter(serviceComponent, "<this>");
        i.checkNotNullParameter(str, "named");
        i.checkNotNullParameter(lazyThreadSafetyMode, "mode");
        i.needClassReification();
        return kotlin.a.lazy(lazyThreadSafetyMode, new AnonymousClass1(serviceComponent, str));
    }

    public static /* synthetic */ e inject$default(ServiceComponent serviceComponent, String str, LazyThreadSafetyMode lazyThreadSafetyMode, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        if ((i10 & 2) != 0) {
            lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        }
        i.checkNotNullParameter(serviceComponent, "<this>");
        i.checkNotNullParameter(str, "named");
        i.checkNotNullParameter(lazyThreadSafetyMode, "mode");
        i.needClassReification();
        return kotlin.a.lazy(lazyThreadSafetyMode, new AnonymousClass1(serviceComponent, str));
    }
}
