package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.b;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;

/* compiled from: InitializeStateLoadWeb.kt */
@d(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1", f = "InitializeStateLoadWeb.kt", l = {53}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1 extends SuspendLambda implements p<Integer, c<? super HttpResponse>, Object> {
    final /* synthetic */ HttpRequest $request;
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* compiled from: InitializeStateLoadWeb.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1$1", f = "InitializeStateLoadWeb.kt", l = {53}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<g0, c<? super HttpResponse>, Object> {
        final /* synthetic */ HttpRequest $request;
        int label;
        final /* synthetic */ InitializeStateLoadWeb this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InitializeStateLoadWeb initializeStateLoadWeb, HttpRequest httpRequest, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = initializeStateLoadWeb;
            this.$request = httpRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.this$0, this.$request, cVar);
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
            return obj;
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super HttpResponse> cVar) {
            return ((AnonymousClass1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1(InitializeStateLoadWeb initializeStateLoadWeb, HttpRequest httpRequest, c<? super InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1> cVar) {
        super(2, cVar);
        this.this$0 = initializeStateLoadWeb;
        this.$request = httpRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1 initializeStateLoadWeb$doWork$2$webViewDataResult$1$1 = new InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1(this.this$0, this.$request, cVar);
        initializeStateLoadWeb$doWork$2$webViewDataResult$1$1.I$0 = ((Number) obj).intValue();
        return initializeStateLoadWeb$doWork$2$webViewDataResult$1$1;
    }

    public final Object invoke(int i10, c<? super HttpResponse> cVar) {
        return ((InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1) create(Integer.valueOf(i10), cVar)).invokeSuspend(h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            if (this.I$0 > 0) {
                InitializeEventsMetricSender.getInstance().onRetryWebview();
            }
            b io2 = this.this$0.dispatchers.getIo();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$request, null);
            this.label = 1;
            obj = kg.f.withContext(io2, anonymousClass1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
        }
        return obj;
    }

    @Override // yf.p
    public /* bridge */ /* synthetic */ Object invoke(Integer num, c<? super HttpResponse> cVar) {
        return invoke(num.intValue(), cVar);
    }
}
