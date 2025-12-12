package e;

import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import xg.d0;
import yf.p;
import zf.i;

/* loaded from: classes2.dex */
public final class g extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rb.p f11085b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f11086m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f11087n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(rb.p pVar, int i10, long j10, qf.c cVar) {
        super(2, cVar);
        this.f11085b = pVar;
        this.f11086m = i10;
        this.f11087n = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new g(this.f11085b, this.f11086m, this.f11087n, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return ((g) create((g0) obj, (qf.c) obj2)).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        rf.a.getCOROUTINE_SUSPENDED();
        lf.f.throwOnFailure(obj);
        d0 d0Var = this.f11085b.f18912t;
        int i10 = this.f11086m;
        long j10 = this.f11087n;
        xg.o oVar = new xg.o(i10, j10);
        d0Var.getClass();
        i.checkNotNullParameter(oVar, "packet");
        d0Var.f21760a.a(new ee.j(((p000if.a) d0Var.f21761b.f13438a.getValue()).f13430c, i10, j10));
        return lf.h.f16056a;
    }
}
