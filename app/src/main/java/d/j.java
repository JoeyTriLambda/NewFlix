package d;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import qb.h;
import rf.a;
import yf.p;

/* loaded from: classes2.dex */
public final class j extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public int f10736b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ h f10737m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h hVar, qf.c cVar) {
        super(2, cVar);
        this.f10737m = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new j(this.f10737m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new j(this.f10737m, (qf.c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f10736b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            h hVar = this.f10737m;
            ng.a aVarDrop = ng.c.drop(ng.c.distinctUntilChanged(new qb.e(hVar.f18060u.f13438a)), 1);
            qb.c cVar = new qb.c(hVar);
            this.f10736b = 1;
            if (aVarDrop.collect(cVar, this) == coroutine_suspended) {
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
