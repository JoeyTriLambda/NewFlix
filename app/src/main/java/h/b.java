package h;

import kg.h0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import rf.a;
import yf.p;

/* loaded from: classes2.dex */
public final class b extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public int f12868b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ de.c f12869m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(de.c cVar, qf.c cVar2) {
        super(2, cVar2);
        this.f12869m = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new b(this.f12869m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new b(this.f12869m, (qf.c) obj2).invokeSuspend(h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f12868b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            this.f12868b = 1;
            de.c cVar = this.f12869m;
            cVar.getClass();
            Object objCoroutineScope = h0.coroutineScope(new d(cVar, null), this);
            if (objCoroutineScope != a.getCOROUTINE_SUSPENDED()) {
                objCoroutineScope = h.f16056a;
            }
            if (objCoroutineScope == coroutine_suspended) {
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
