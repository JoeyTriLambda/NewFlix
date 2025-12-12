package c;

import kg.m0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import l3.w;

/* loaded from: classes.dex */
public final class y extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f5003b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f5004m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(w wVar, qf.c cVar) {
        super(2, cVar);
        this.f5004m = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new y(this.f5004m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new y(this.f5004m, (qf.c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f5003b;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            this.f5003b = 1;
            if (m0.delay(10000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lf.f.throwOnFailure(obj);
        }
        this.f5004m.add(l3.f.f15732a);
        return lf.h.f16056a;
    }
}
