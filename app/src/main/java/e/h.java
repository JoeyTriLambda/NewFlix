package e;

import ee.r;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import xg.d0;
import yf.p;

/* loaded from: classes2.dex */
public final class h extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rb.p f11088b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f11089m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(rb.p pVar, int i10, qf.c cVar) {
        super(2, cVar);
        this.f11088b = pVar;
        this.f11089m = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new h(this.f11088b, this.f11089m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new h(this.f11088b, this.f11089m, (qf.c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        rf.a.getCOROUTINE_SUSPENDED();
        lf.f.throwOnFailure(obj);
        rb.p pVar = this.f11088b;
        d0 d0Var = pVar.f18912t;
        de.f fVar = d0Var.f21760a;
        byte[] bArr = ((p000if.a) d0Var.f21761b.f13438a.getValue()).f13430c;
        int i10 = this.f11089m;
        fVar.a(new r(i10, bArr));
        rb.p.a(pVar, i10);
        return lf.h.f16056a;
    }
}
