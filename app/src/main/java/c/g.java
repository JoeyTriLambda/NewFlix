package c;

import kg.g0;
import kg.h0;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import l3.w;
import xg.d0;

/* loaded from: classes.dex */
public final class g extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f4952b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f4953m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(w wVar, qf.c cVar) {
        super(2, cVar);
        this.f4953m = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new g(this.f4953m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new g(this.f4953m, (qf.c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        w wVar = this.f4953m;
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f4952b;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            try {
                int i11 = Result.f15189m;
                d0 d0Var = wVar.f15752w;
                d0Var.f21760a.a(new ee.l(((p000if.a) d0Var.f21761b.f13438a.getValue()).f13430c));
                Result.m59constructorimpl(sf.a.boxBoolean(true));
            } catch (Throwable th2) {
                int i12 = Result.f15189m;
                Result.m59constructorimpl(lf.f.createFailure(th2));
            }
            int i13 = w.C;
            g0 g0Var = wVar.f15755z;
            if (g0Var != null) {
                h0.cancel$default(g0Var, null, 1, null);
            }
            wVar.f15755z = null;
            wVar.getClass();
            this.f4952b = 1;
            if (wVar.a(this) == coroutine_suspended) {
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
