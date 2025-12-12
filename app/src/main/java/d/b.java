package d;

import kg.g0;
import kg.h0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import qb.h;
import qb.i;
import qb.l;
import qb.m;
import qb.o;
import qb.p;
import rf.a;
import yf.q;

/* loaded from: classes2.dex */
public final class b extends SuspendLambda implements q {

    /* renamed from: b, reason: collision with root package name */
    public int f10723b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ oa.c f10724m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ qb.j f10725n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ h f10726o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(h hVar, qf.c cVar) {
        super(3, cVar);
        this.f10726o = hVar;
    }

    @Override // yf.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        b bVar = new b(this.f10726o, (qf.c) obj3);
        bVar.f10724m = (oa.c) obj;
        bVar.f10725n = (qb.j) obj2;
        return bVar.invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f10723b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            oa.c cVar = this.f10724m;
            qb.j jVar = this.f10725n;
            boolean z10 = jVar instanceof m;
            h hVar = this.f10726o;
            if (z10) {
                this.f10724m = null;
                this.f10723b = 1;
                if (h.a(hVar, cVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (jVar instanceof o) {
                this.f10724m = null;
                this.f10723b = 2;
                int i11 = h.f18058x;
                hVar.getClass();
                k.c.a("ConnectivityBloc", "onStop");
                g0 g0Var = hVar.f18061v;
                if (g0Var != null) {
                    h0.cancel$default(g0Var, null, 1, null);
                }
                g0 g0Var2 = hVar.f18062w;
                if (g0Var2 != null) {
                    h0.cancel$default(g0Var2, null, 1, null);
                }
                Object objEmit = cVar.emit(qb.k.f18064b, this);
                if (objEmit != a.getCOROUTINE_SUSPENDED()) {
                    objEmit = lf.h.f16056a;
                }
                if (objEmit == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (jVar instanceof i) {
                i iVar = (i) jVar;
                this.f10724m = null;
                this.f10723b = 3;
                int i12 = h.f18058x;
                hVar.getClass();
                ng.g gVar = k.c.f14701a;
                StringBuilder sb2 = new StringBuilder("onConfigChanged wifiOnly = ");
                sb2.append(iVar.f18063a);
                sb2.append(", wifi = ");
                kf.b bVar = hVar.f18059t;
                sb2.append(((Boolean) bVar.f15090b.getValue()).booleanValue());
                k.c.a("ConnectivityBloc", sb2.toString());
                qb.n nVar = (iVar.f18063a && !((Boolean) bVar.f15090b.getValue()).booleanValue()) ? l.f18065b : qb.a.f18051b;
                Object objEmit2 = cVar.emit(nVar, this);
                if (objEmit2 != a.getCOROUTINE_SUSPENDED()) {
                    objEmit2 = lf.h.f16056a;
                }
                if (objEmit2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (jVar instanceof p) {
                p pVar = (p) jVar;
                this.f10724m = null;
                this.f10723b = 4;
                int i13 = h.f18058x;
                hVar.getClass();
                ng.g gVar2 = k.c.f14701a;
                StringBuilder sb3 = new StringBuilder("onWifiChanged wifiOnly = ");
                p000if.b bVar2 = hVar.f18060u;
                sb3.append(((p000if.a) bVar2.f13438a.getValue()).f13429b);
                sb3.append(", wifi = ");
                sb3.append(pVar.f18069a);
                k.c.a("ConnectivityBloc", sb3.toString());
                qb.n nVar2 = (((p000if.a) bVar2.f13438a.getValue()).f13429b && !pVar.f18069a) ? l.f18065b : qb.a.f18051b;
                Object objEmit3 = cVar.emit(nVar2, this);
                if (objEmit3 != a.getCOROUTINE_SUSPENDED()) {
                    objEmit3 = lf.h.f16056a;
                }
                if (objEmit3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
        }
        return lf.h.f16056a;
    }
}
