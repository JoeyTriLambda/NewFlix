package com.unity3d.services.core.di;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import kg.g0;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;

/* compiled from: ServiceProvider.kt */
@d(c = "com.unity3d.services.core.di.ServiceProvider$provideHttpClient$config$1", f = "ServiceProvider.kt", l = {134}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ServiceProvider$provideHttpClient$config$1 extends SuspendLambda implements p<g0, c<? super Configuration>, Object> {
    final /* synthetic */ ConfigFileFromLocalStorage $configFileFromLocalStorage;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceProvider$provideHttpClient$config$1(ConfigFileFromLocalStorage configFileFromLocalStorage, c<? super ServiceProvider$provideHttpClient$config$1> cVar) {
        super(2, cVar);
        this.$configFileFromLocalStorage = configFileFromLocalStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        ServiceProvider$provideHttpClient$config$1 serviceProvider$provideHttpClient$config$1 = new ServiceProvider$provideHttpClient$config$1(this.$configFileFromLocalStorage, cVar);
        serviceProvider$provideHttpClient$config$1.L$0 = obj;
        return serviceProvider$provideHttpClient$config$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM59constructorimpl;
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                f.throwOnFailure(obj);
                ConfigFileFromLocalStorage configFileFromLocalStorage = this.$configFileFromLocalStorage;
                int i11 = Result.f15189m;
                ConfigFileFromLocalStorage.Params params = new ConfigFileFromLocalStorage.Params();
                this.label = 1;
                obj = configFileFromLocalStorage.invoke(params, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
            }
            objM59constructorimpl = Result.m59constructorimpl((Configuration) obj);
        } catch (Throwable th2) {
            int i12 = Result.f15189m;
            objM59constructorimpl = Result.m59constructorimpl(f.createFailure(th2));
        }
        if (Result.m63isFailureimpl(objM59constructorimpl)) {
            return null;
        }
        return objM59constructorimpl;
    }

    @Override // yf.p
    public final Object invoke(g0 g0Var, c<? super Configuration> cVar) {
        return ((ServiceProvider$provideHttpClient$config$1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
    }
}
