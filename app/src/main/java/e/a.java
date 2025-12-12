package e;

import kg.h0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import rb.p;
import zf.i;

/* loaded from: classes2.dex */
public final class a extends SuspendLambda implements yf.q {

    /* renamed from: b, reason: collision with root package name */
    public int f11068b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ oa.c f11069m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ rb.a f11070n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ p f11071o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(p pVar, qf.c cVar) {
        super(3, cVar);
        this.f11071o = pVar;
    }

    @Override // yf.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        a aVar = new a(this.f11071o, (qf.c) obj3);
        aVar.f11069m = (oa.c) obj;
        aVar.f11070n = (rb.a) obj2;
        return aVar.invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f11068b;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            oa.c cVar = this.f11069m;
            rb.a aVar = this.f11070n;
            boolean zAreEqual = i.areEqual(aVar, rb.c.f18901a);
            p pVar = this.f11071o;
            if (zAreEqual) {
                this.f11069m = null;
                this.f11068b = 1;
                if (p.a(pVar, cVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i.areEqual(aVar, rb.e.f18902a)) {
                this.f11069m = null;
                this.f11068b = 2;
                kg.h.launch$default(pVar.f18916x, null, null, new y(pVar, null), 3, null);
                h0.cancel$default(pVar.f18916x, null, 1, null);
                Object objEmit = cVar.emit(rb.f.f18903a, this);
                if (objEmit != rf.a.getCOROUTINE_SUSPENDED()) {
                    objEmit = lf.h.f16056a;
                }
                if (objEmit == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i10 != 1 && i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lf.f.throwOnFailure(obj);
        }
        return lf.h.f16056a;
    }
}
