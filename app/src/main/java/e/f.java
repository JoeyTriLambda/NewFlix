package e;

import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import xg.d0;
import xg.t;
import yf.p;
import zf.i;

/* loaded from: classes2.dex */
public final class f extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11082b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ byte[] f11083m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ rb.p f11084n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(int i10, byte[] bArr, rb.p pVar, qf.c cVar) {
        super(2, cVar);
        this.f11082b = i10;
        this.f11083m = bArr;
        this.f11084n = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new f(this.f11082b, this.f11083m, this.f11084n, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return ((f) create((g0) obj, (qf.c) obj2)).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        rf.a.getCOROUTINE_SUSPENDED();
        lf.f.throwOnFailure(obj);
        ng.g gVar = k.c.f14701a;
        StringBuilder sb2 = new StringBuilder("onSendPacket: [");
        int i10 = this.f11082b;
        sb2.append(i10);
        sb2.append("], ");
        byte[] bArr = this.f11083m;
        sb2.append(bArr.length);
        sb2.append(" bytes");
        k.c.a("ProxyBloc", sb2.toString());
        d0 d0Var = this.f11084n.f18912t;
        t tVar = new t(i10, bArr);
        d0Var.getClass();
        i.checkNotNullParameter(tVar, "packet");
        d0Var.f21760a.a(new ee.x(((p000if.a) d0Var.f21761b.f13438a.getValue()).f13430c, i10, bArr));
        return lf.h.f16056a;
    }
}
