package m;

import kg.g0;
import kg.h0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import qf.c;
import rf.a;

/* loaded from: classes2.dex */
public final class n extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f16079b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f16080m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ wg.i f16081n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(wg.i iVar, c cVar) {
        super(2, cVar);
        this.f16081n = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        n nVar = new n(this.f16081n, cVar);
        nVar.f16080m = obj;
        return nVar;
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        n nVar = new n(this.f16081n, (c) obj2);
        nVar.f16080m = (g0) obj;
        return nVar.invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        g0 g0Var;
        boolean zIsActive;
        wg.i iVar = this.f16081n;
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f16079b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            g0Var = (g0) this.f16080m;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g0Var = (g0) this.f16080m;
            try {
                f.throwOnFailure(obj);
            } finally {
                if (zIsActive) {
                }
                return lf.h.f16056a;
            }
        }
        while (h0.isActive(g0Var)) {
            yg.c cVar = iVar.f21178f;
            if (cVar == null) {
                zf.i.throwUninitializedPropertyAccessException("connection");
                cVar = null;
            }
            byte[] bArrA = cVar.a();
            ng.g gVar = k.c.f14701a;
            k.c.a("UdpProxySession", '[' + iVar.f21149a + "] <- [" + bArrA.length + " bytes]");
            wg.c cVar2 = iVar.f21152d;
            int i11 = iVar.f21149a;
            this.f16080m = g0Var;
            this.f16079b = 1;
            rb.p pVar = (rb.p) cVar2;
            if (kg.h.launch$default(pVar.f18916x, new kotlinx.coroutines.c("onDataPacket[" + i11 + "]-" + bArrA.length), null, new e.f(i11, bArrA, pVar, null), 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return lf.h.f16056a;
    }
}
