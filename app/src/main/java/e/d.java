package e;

import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import xg.r;
import yf.p;

/* loaded from: classes2.dex */
public final class d extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rb.p f11075b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f11076m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Throwable f11077n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(rb.p pVar, int i10, Throwable th2, qf.c cVar) {
        super(2, cVar);
        this.f11075b = pVar;
        this.f11076m = i10;
        this.f11077n = th2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new d(this.f11075b, this.f11076m, this.f11077n, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return ((d) create((g0) obj, (qf.c) obj2)).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        rf.a.getCOROUTINE_SUSPENDED();
        lf.f.throwOnFailure(obj);
        rb.p pVar = this.f11075b;
        pVar.f18918z.remove(sf.a.boxInt(this.f11076m));
        pVar.f18912t.a(new r(this.f11076m, false, null, 0, this.f11077n.getMessage(), 12));
        return lf.h.f16056a;
    }
}
