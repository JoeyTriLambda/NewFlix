package f;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;

/* loaded from: classes2.dex */
public final class d extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f11339b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ sb.p f11340m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(sb.p pVar, c cVar) {
        super(2, cVar);
        this.f11340m = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new d(this.f11340m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new d(this.f11340m, (c) obj2).invokeSuspend(h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f11339b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            sb.p pVar = this.f11340m;
            ng.a<State> stateFlow = pVar.f19239t.getStateFlow();
            sb.h hVar = new sb.h(pVar);
            this.f11339b = 1;
            if (stateFlow.collect(hVar, this) == coroutine_suspended) {
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
}
