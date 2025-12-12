package a;

import k.d;
import k.h;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import qf.c;
import rf.a;

/* loaded from: classes.dex */
public final class e extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f2b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ h f3m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, c cVar) {
        super(2, cVar);
        this.f3m = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new e(this.f3m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new e(this.f3m, (c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f2b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            ng.a<State> stateFlow = ((l3.w) this.f3m.f14708n.getValue()).getStateFlow();
            d dVar = d.f14702b;
            this.f2b = 1;
            if (stateFlow.collect(dVar, this) == coroutine_suspended) {
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
