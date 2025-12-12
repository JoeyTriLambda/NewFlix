package c;

import kg.g0;
import kg.h0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import l3.b;
import l3.w;

/* loaded from: classes.dex */
public final class a extends SuspendLambda implements yf.q {

    /* renamed from: b, reason: collision with root package name */
    public int f4936b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ oa.c f4937m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ l3.d f4938n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ w f4939o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(w wVar, qf.c cVar) {
        super(3, cVar);
        this.f4939o = wVar;
    }

    @Override // yf.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        a aVar = new a(this.f4939o, (qf.c) obj3);
        aVar.f4937m = (oa.c) obj;
        aVar.f4938n = (l3.d) obj2;
        return aVar.invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        g0 g0Var;
        Object objEmit;
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        switch (this.f4936b) {
            case 0:
                lf.f.throwOnFailure(obj);
                oa.c cVar = this.f4937m;
                l3.d dVar = this.f4938n;
                boolean zAreEqual = zf.i.areEqual(dVar, l3.f.f15732a);
                w wVar = this.f4939o;
                if (zAreEqual) {
                    this.f4937m = null;
                    this.f4936b = 1;
                    if (w.a(wVar, cVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (zf.i.areEqual(dVar, l3.h.f15734a)) {
                    this.f4937m = null;
                    this.f4936b = 2;
                    int i10 = w.C;
                    g0 g0Var2 = wVar.A;
                    if (g0Var2 != null) {
                        h0.cancel$default(g0Var2, null, 1, null);
                    }
                    wVar.A = null;
                    if (zf.i.areEqual(wVar.getState(), b.f15729b) || zf.i.areEqual(wVar.getState(), l3.i.f15735b)) {
                        g0 g0Var3 = wVar.f15754y;
                        if (g0Var3 == null) {
                            zf.i.throwUninitializedPropertyAccessException("socketScope");
                            g0Var = null;
                        } else {
                            g0Var = g0Var3;
                        }
                        kg.h.launch$default(g0Var, null, null, new g(wVar, null), 3, null);
                        objEmit = cVar.emit(l3.c.f15730b, this);
                        if (objEmit != rf.a.getCOROUTINE_SUSPENDED()) {
                            objEmit = lf.h.f16056a;
                        }
                    } else {
                        objEmit = cVar.emit(l3.c.f15730b, this);
                        if (objEmit != rf.a.getCOROUTINE_SUSPENDED()) {
                            objEmit = lf.h.f16056a;
                        }
                    }
                    if (objEmit == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (dVar instanceof l3.l) {
                    this.f4937m = null;
                    this.f4936b = 3;
                    if (w.a(wVar, (l3.l) dVar, cVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (dVar instanceof l3.k) {
                    this.f4937m = null;
                    this.f4936b = 4;
                    if (w.a(wVar, (l3.k) dVar, cVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (zf.i.areEqual(dVar, l3.n.f15740a)) {
                    this.f4937m = null;
                    this.f4936b = 5;
                    if (w.b(wVar, cVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (dVar instanceof l3.q) {
                    this.f4937m = null;
                    this.f4936b = 6;
                    if (w.a(wVar, (l3.q) dVar, cVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (dVar instanceof l3.j) {
                    this.f4937m = null;
                    this.f4936b = 7;
                    if (w.a(wVar, (l3.j) dVar, cVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (zf.i.areEqual(dVar, l3.a.f15728a)) {
                    this.f4937m = null;
                    this.f4936b = 8;
                    int i11 = w.C;
                    wVar.getClass();
                    k.c.a("Connection", "onConnectionComplete: ");
                    Object objEmit2 = cVar.emit(b.f15729b, this);
                    if (objEmit2 != rf.a.getCOROUTINE_SUSPENDED()) {
                        objEmit2 = lf.h.f16056a;
                    }
                    if (objEmit2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (dVar instanceof l3.p) {
                    this.f4937m = null;
                    this.f4936b = 9;
                    if (w.a(wVar, (l3.p) dVar, cVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                lf.f.throwOnFailure(obj);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return lf.h.f16056a;
    }
}
