package a;

import k.h;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import qf.c;
import rf.a;

/* loaded from: classes.dex */
public final class g extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f4b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ h f5m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, c cVar) {
        super(2, cVar);
        this.f5m = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new g(this.f5m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new g(this.f5m, (c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f4b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            ng.a<State> stateFlow = ((sb.p) this.f5m.f14709o.getValue()).getStateFlow();
            k.e eVar = k.e.f14703b;
            this.f4b = 1;
            if (stateFlow.collect(eVar, this) == coroutine_suspended) {
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
