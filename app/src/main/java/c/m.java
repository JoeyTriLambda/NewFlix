package c;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import l3.w;

/* loaded from: classes.dex */
public final class m extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f4976b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f4977m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(w wVar, qf.c cVar) {
        super(2, cVar);
        this.f4977m = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new m(this.f4977m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new m(this.f4977m, (qf.c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f4976b;
        w wVar = this.f4977m;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            this.f4976b = 1;
            if (w.a(wVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lf.f.throwOnFailure(obj);
        }
        wVar.add(l3.a.f15728a);
        return lf.h.f16056a;
    }
}
