package m;

import java.util.Timer;
import kg.h0;
import kg.k1;
import kg.n1;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import qf.c;
import rf.a;
import yg.b;

/* loaded from: classes2.dex */
public final class i extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f16073b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ wg.e f16074m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(wg.e eVar, c cVar) {
        super(2, cVar);
        this.f16074m = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new i(this.f16074m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new i(this.f16074m, (c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f16073b;
        wg.e eVar = this.f16074m;
        try {
        } catch (Throwable th2) {
            ng.g gVar = k.c.f14701a;
            k.c.a("TcpProxySession", "TcpProxySession: stopped error: [" + eVar.f21149a + "]: " + th2);
        }
        if (i10 == 0) {
            f.throwOnFailure(obj);
            k1 k1Var = eVar.f21163l;
            if (k1Var != null) {
                this.f16073b = 1;
                if (n1.cancelAndJoin(k1Var, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
                ng.g gVar2 = k.c.f14701a;
                k.c.a("TcpProxySession", "TcpProxySession: stopped: [" + eVar.f21149a + ']');
                return lf.h.f16056a;
            }
            f.throwOnFailure(obj);
        }
        h0.cancel$default(eVar.f21161j, null, 1, null);
        if (eVar.c()) {
            wg.g gVar3 = eVar.f21158g;
            if (gVar3 == null) {
                zf.i.throwUninitializedPropertyAccessException("tcpWindowHandler");
                gVar3 = null;
            }
            Timer timer = gVar3.f21175k;
            if (timer != null) {
                timer.cancel();
            }
            gVar3.f21175k = null;
        }
        b bVar = eVar.f21153e;
        String strValueOf = String.valueOf(eVar.f21149a);
        this.f16073b = 2;
        bVar.getClass();
        if (h0.coroutineScope(new o.g(bVar, strValueOf, null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        ng.g gVar22 = k.c.f14701a;
        k.c.a("TcpProxySession", "TcpProxySession: stopped: [" + eVar.f21149a + ']');
        return lf.h.f16056a;
    }
}
