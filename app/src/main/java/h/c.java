package h;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import rf.a;
import yf.p;

/* loaded from: classes2.dex */
public final class c extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f12870b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Throwable th2, qf.c cVar) {
        super(2, cVar);
        this.f12870b = th2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new c(this.f12870b, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        Throwable th2 = this.f12870b;
        new c(th2, (qf.c) obj2);
        h hVar = h.f16056a;
        a.getCOROUTINE_SUSPENDED();
        f.throwOnFailure(hVar);
        throw th2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        a.getCOROUTINE_SUSPENDED();
        f.throwOnFailure(obj);
        throw this.f12870b;
    }
}
