package a;

import k.h;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import qf.c;
import rf.a;

/* loaded from: classes.dex */
public final class k extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f8b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ h f9m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(h hVar, c cVar) {
        super(2, cVar);
        this.f9m = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new k(this.f9m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new k(this.f9m, (c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f8b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            ng.a<State> stateFlow = ((qb.h) this.f9m.f14710p.getValue()).getStateFlow();
            k.g gVar = k.g.f14705b;
            this.f8b = 1;
            if (stateFlow.collect(gVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
        }
        return lf.h.f16056a;
    }
}
