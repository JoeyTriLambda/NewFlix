package com.unity3d.services.core.domain.task;

import kg.g0;
import kg.m;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;

/* compiled from: InitializeStateNetworkError.kt */
@d(c = "com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2$success$1", f = "InitializeStateNetworkError.kt", l = {79}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class InitializeStateNetworkError$doWork$2$success$1 extends SuspendLambda implements p<g0, c<? super h>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ InitializeStateNetworkError this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateNetworkError$doWork$2$success$1(InitializeStateNetworkError initializeStateNetworkError, c<? super InitializeStateNetworkError$doWork$2$success$1> cVar) {
        super(2, cVar);
        this.this$0 = initializeStateNetworkError;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        return new InitializeStateNetworkError$doWork$2$success$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            InitializeStateNetworkError initializeStateNetworkError = this.this$0;
            this.L$0 = initializeStateNetworkError;
            this.label = 1;
            m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this), 1);
            mVar.initCancellability();
            initializeStateNetworkError.startListening(mVar);
            Object result = mVar.getResult();
            if (result == a.getCOROUTINE_SUSPENDED()) {
                sf.f.probeCoroutineSuspended(this);
            }
            if (result == coroutine_suspended) {
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
        return ((InitializeStateNetworkError$doWork$2$success$1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
    }
}
