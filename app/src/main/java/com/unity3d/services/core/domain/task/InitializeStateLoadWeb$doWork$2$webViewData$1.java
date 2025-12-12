package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;

/* compiled from: InitializeStateLoadWeb.kt */
@d(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$webViewData$1", f = "InitializeStateLoadWeb.kt", l = {61}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class InitializeStateLoadWeb$doWork$2$webViewData$1 extends SuspendLambda implements p<g0, c<? super String>, Object> {
    final /* synthetic */ HttpRequest $request;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateLoadWeb$doWork$2$webViewData$1(InitializeStateLoadWeb initializeStateLoadWeb, HttpRequest httpRequest, c<? super InitializeStateLoadWeb$doWork$2$webViewData$1> cVar) {
        super(2, cVar);
        this.this$0 = initializeStateLoadWeb;
        this.$request = httpRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        return new InitializeStateLoadWeb$doWork$2$webViewData$1(this.this$0, this.$request, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            HttpClient httpClient = this.this$0.httpClient;
            HttpRequest httpRequest = this.$request;
            this.label = 1;
            obj = httpClient.execute(httpRequest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
        }
        return ((HttpResponse) obj).getBody().toString();
    }

    @Override // yf.p
    public final Object invoke(g0 g0Var, c<? super String> cVar) {
        return ((InitializeStateLoadWeb$doWork$2$webViewData$1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
    }
}
