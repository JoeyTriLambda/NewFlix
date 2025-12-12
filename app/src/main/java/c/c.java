package c;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import l3.r;
import l3.w;

/* loaded from: classes.dex */
public final class c extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f4940b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f4941m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(w wVar, qf.c cVar) {
        super(2, cVar);
        this.f4941m = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new c(this.f4941m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new c(this.f4941m, (qf.c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f4940b;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            w wVar = this.f4941m;
            ng.a<State> stateFlow = wVar.f15753x.getStateFlow();
            r rVar = new r(wVar);
            this.f4940b = 1;
            if (stateFlow.collect(rVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lf.f.throwOnFailure(obj);
        }
        return lf.h.f16056a;
    }
}
