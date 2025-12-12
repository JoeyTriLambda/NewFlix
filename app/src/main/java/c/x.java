package c;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import l3.w;

/* loaded from: classes.dex */
public final class x extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f5001b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f5002m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(w wVar, qf.c cVar) {
        super(2, cVar);
        this.f5002m = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new x(this.f5002m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new x(this.f5002m, (qf.c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f5001b;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            w wVar = this.f5002m;
            de.c cVar = wVar.f15752w.f21760a.f11018b;
            if (cVar == null) {
                zf.i.throwUninitializedPropertyAccessException("receiver");
                cVar = null;
            }
            ng.a aVarFilterNotNull = ng.c.filterNotNull(cVar.f11015c);
            l3.v vVar = new l3.v(wVar);
            this.f5001b = 1;
            Object objCollect = aVarFilterNotNull.collect(new xg.g(new xg.h(vVar)), this);
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
