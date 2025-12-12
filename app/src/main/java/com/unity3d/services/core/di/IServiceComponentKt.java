package com.unity3d.services.core.di;

import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Lambda;
import lf.e;
import yf.a;
import zf.i;
import zf.k;

/* compiled from: IServiceComponent.kt */
/* loaded from: classes2.dex */
public final class IServiceComponentKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: IServiceComponent.kt */
    /* renamed from: com.unity3d.services.core.di.IServiceComponentKt$inject$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends Lambda implements a<T> {
        final /* synthetic */ String $named;
        final /* synthetic */ IServiceComponent $this_inject;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(IServiceComponent iServiceComponent, String str) {
            super(0);
            this.$this_inject = iServiceComponent;
            this.$named = str;
        }

        @Override // yf.a
        public final T invoke() {
            IServiceComponent iServiceComponent = this.$this_inject;
            String str = this.$named;
            IServicesRegistry registry = iServiceComponent.getServiceProvider().getRegistry();
            i.reifiedOperationMarker(4, "T");
            return (T) registry.getService(str, k.getOrCreateKotlinClass(Object.class));
        }
    }

    public static final /* synthetic */ <T> T get(IServiceComponent iServiceComponent, String str) {
        i.checkNotNullParameter(iServiceComponent, "<this>");
        i.checkNotNullParameter(str, "named");
        IServicesRegistry registry = iServiceComponent.getServiceProvider().getRegistry();
        i.reifiedOperationMarker(4, "T");
        return (T) registry.getService(str, k.getOrCreateKotlinClass(Object.class));
    }

    public static /* synthetic */ Object get$default(IServiceComponent iServiceComponent, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        i.checkNotNullParameter(iServiceComponent, "<this>");
        i.checkNotNullParameter(str, "named");
        IServicesRegistry registry = iServiceComponent.getServiceProvider().getRegistry();
        i.reifiedOperationMarker(4, "T");
        return registry.getService(str, k.getOrCreateKotlinClass(Object.class));
    }

    public static final /* synthetic */ <T> e<T> inject(IServiceComponent iServiceComponent, String str, LazyThreadSafetyMode lazyThreadSafetyMode) {
        i.checkNotNullParameter(iServiceComponent, "<this>");
        i.checkNotNullParameter(str, "named");
        i.checkNotNullParameter(lazyThreadSafetyMode, "mode");
        i.needClassReification();
        return kotlin.a.lazy(lazyThreadSafetyMode, new AnonymousClass1(iServiceComponent, str));
    }

    public static /* synthetic */ e inject$default(IServiceComponent iServiceComponent, String str, LazyThreadSafetyMode lazyThreadSafetyMode, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        if ((i10 & 2) != 0) {
            lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        }
        i.checkNotNullParameter(iServiceComponent, "<this>");
        i.checkNotNullParameter(str, "named");
        i.checkNotNullParameter(lazyThreadSafetyMode, "mode");
        i.needClassReification();
        return kotlin.a.lazy(lazyThreadSafetyMode, new AnonymousClass1(iServiceComponent, str));
    }
}
