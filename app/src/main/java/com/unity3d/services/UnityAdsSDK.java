package com.unity3d.services;

import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.di.ServiceProvider;
import com.unity3d.services.core.domain.task.EmptyParams;
import com.unity3d.services.core.domain.task.InitializeSDK;
import kg.g0;
import kg.k1;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.e;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;
import zf.k;

/* compiled from: UnityAdsSDK.kt */
/* loaded from: classes2.dex */
public final class UnityAdsSDK implements IServiceComponent {
    public static final UnityAdsSDK INSTANCE;
    private static final e initializeSDK$delegate;
    private static final e sdkScope$delegate;

    /* compiled from: UnityAdsSDK.kt */
    @d(c = "com.unity3d.services.UnityAdsSDK$initialize$1", f = "UnityAdsSDK.kt", l = {23}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.UnityAdsSDK$initialize$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<g0, c<? super h>, Object> {
        int label;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
            int i10 = this.label;
            if (i10 == 0) {
                f.throwOnFailure(obj);
                InitializeSDK initializeSDK = UnityAdsSDK.INSTANCE.getInitializeSDK();
                EmptyParams emptyParams = EmptyParams.INSTANCE;
                this.label = 1;
                if (initializeSDK.invoke(emptyParams, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
            }
            return h.f16056a;
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super h> cVar) {
            return ((AnonymousClass1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    static {
        final UnityAdsSDK unityAdsSDK = new UnityAdsSDK();
        INSTANCE = unityAdsSDK;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        final String str = ServiceProvider.NAMED_SDK;
        sdkScope$delegate = kotlin.a.lazy(lazyThreadSafetyMode, new yf.a<g0>() { // from class: com.unity3d.services.UnityAdsSDK$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, kg.g0] */
            @Override // yf.a
            public final g0 invoke() {
                IServiceComponent iServiceComponent = unityAdsSDK;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, k.getOrCreateKotlinClass(g0.class));
            }
        });
        final String str2 = "";
        initializeSDK$delegate = kotlin.a.lazy(lazyThreadSafetyMode, new yf.a<InitializeSDK>() { // from class: com.unity3d.services.UnityAdsSDK$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.services.core.domain.task.InitializeSDK, java.lang.Object] */
            @Override // yf.a
            public final InitializeSDK invoke() {
                IServiceComponent iServiceComponent = unityAdsSDK;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str2, k.getOrCreateKotlinClass(InitializeSDK.class));
            }
        });
    }

    private UnityAdsSDK() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InitializeSDK getInitializeSDK() {
        return (InitializeSDK) initializeSDK$delegate.getValue();
    }

    private final g0 getSdkScope() {
        return (g0) sdkScope$delegate.getValue();
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    public final k1 initialize() {
        return kg.h.launch$default(getSdkScope(), null, null, new AnonymousClass1(null), 3, null);
    }
}
