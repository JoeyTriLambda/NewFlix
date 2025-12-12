package e;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import yf.p;

/* loaded from: classes2.dex */
public final class c extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public int f11072b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ sb.p f11073m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ rb.p f11074n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(sb.p pVar, rb.p pVar2, qf.c cVar) {
        super(2, cVar);
        this.f11073m = pVar;
        this.f11074n = pVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new c(this.f11073m, this.f11074n, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new c(this.f11073m, this.f11074n, (qf.c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f11072b;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            ng.a<State> stateFlow = this.f11073m.getStateFlow();
            rb.g gVar = new rb.g(this.f11074n);
            this.f11072b = 1;
            if (stateFlow.collect(gVar, this) == coroutine_suspended) {
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
