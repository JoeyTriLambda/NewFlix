package e;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import rb.l;
import xg.k;
import yf.p;
import zf.i;

/* loaded from: classes2.dex */
public final class q extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public int f11099b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ rb.p f11100m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(rb.p pVar, qf.c cVar) {
        super(2, cVar);
        this.f11100m = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new q(this.f11100m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new q(this.f11100m, (qf.c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f11099b;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            rb.p pVar = this.f11100m;
            de.c cVar = pVar.f18912t.f21760a.f11018b;
            if (cVar == null) {
                i.throwUninitializedPropertyAccessException("receiver");
                cVar = null;
            }
            ng.a aVarFilterNotNull = ng.c.filterNotNull(cVar.f11015c);
            l lVar = new l(pVar);
            this.f11099b = 1;
            Object objCollect = aVarFilterNotNull.collect(new xg.j(new k(new xg.i(lVar))), this);
            if (objCollect != rf.a.getCOROUTINE_SUSPENDED()) {
                objCollect = lf.h.f16056a;
            }
            if (objCollect != rf.a.getCOROUTINE_SUSPENDED()) {
                objCollect = lf.h.f16056a;
            }
            if (objCollect != rf.a.getCOROUTINE_SUSPENDED()) {
                objCollect = lf.h.f16056a;
            }
            if (objCollect == coroutine_suspended) {
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
