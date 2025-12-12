package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import kg.g0;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;

/* compiled from: InitializeSDK.kt */
@d(c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2$webViewData$1", f = "InitializeSDK.kt", l = {86}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class InitializeSDK$doWork$2$webViewData$1 extends SuspendLambda implements p<g0, c<? super h>, Object> {
    final /* synthetic */ Object $configResult;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeSDK$doWork$2$webViewData$1(InitializeSDK initializeSDK, Object obj, c<? super InitializeSDK$doWork$2$webViewData$1> cVar) {
        super(2, cVar);
        this.this$0 = initializeSDK;
        this.$configResult = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        InitializeSDK$doWork$2$webViewData$1 initializeSDK$doWork$2$webViewData$1 = new InitializeSDK$doWork$2$webViewData$1(this.this$0, this.$configResult, cVar);
        initializeSDK$doWork$2$webViewData$1.L$0 = obj;
        return initializeSDK$doWork$2$webViewData$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                f.throwOnFailure(obj);
                InitializeSDK initializeSDK = this.this$0;
                Object obj2 = this.$configResult;
                int i11 = Result.f15189m;
                InitializeStateLoadWeb initializeStateLoadWeb = initializeSDK.initializeStateLoadWeb;
                f.throwOnFailure(obj2);
                InitializeStateLoadWeb.Params params = new InitializeStateLoadWeb.Params((Configuration) obj2);
                this.label = 1;
                obj = initializeStateLoadWeb.invoke(params, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
            }
            Result.m59constructorimpl((InitializeStateLoadWeb.LoadWebResult) obj);
        } catch (Throwable th2) {
            int i12 = Result.f15189m;
            Result.m59constructorimpl(f.createFailure(th2));
        }
        return h.f16056a;
    }

    @Override // yf.p
    public final Object invoke(g0 g0Var, c<? super h> cVar) {
        return ((InitializeSDK$doWork$2$webViewData$1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
    }
}
