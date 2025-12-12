package e;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import rb.k;
import xg.j0;
import xg.k0;
import xg.l0;
import yf.p;
import zf.i;

/* loaded from: classes2.dex */
public final class o extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public int f11097b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ rb.p f11098m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(rb.p pVar, qf.c cVar) {
        super(2, cVar);
        this.f11098m = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new o(this.f11098m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new o(this.f11098m, (qf.c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f11097b;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            rb.p pVar = this.f11098m;
            de.c cVar = pVar.f18912t.f21760a.f11018b;
            if (cVar == null) {
                i.throwUninitializedPropertyAccessException("receiver");
                cVar = null;
            }
            ng.a aVarFilterNotNull = ng.c.filterNotNull(cVar.f11015c);
            k kVar = new k(pVar);
            this.f11097b = 1;
            Object objCollect = aVarFilterNotNull.collect(new k0(new l0(new j0(kVar))), this);
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
