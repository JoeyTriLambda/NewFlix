package e;

import java.util.Collection;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import yf.p;
import zf.i;

/* loaded from: classes2.dex */
public final class y extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rb.p f11111b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(rb.p pVar, qf.c cVar) {
        super(2, cVar);
        this.f11111b = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new y(this.f11111b, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new y(this.f11111b, (qf.c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        rf.a.getCOROUTINE_SUSPENDED();
        lf.f.throwOnFailure(obj);
        Collection<wg.a> collectionValues = this.f11111b.f18918z.values();
        i.checkNotNullExpressionValue(collectionValues, "sessions.values");
        for (wg.a aVar : collectionValues) {
            ng.g gVar = k.c.f14701a;
            k.c.a("ProxyBloc", "stop: session[" + aVar.f21149a + ']');
            aVar.b();
        }
        return lf.h.f16056a;
    }
}
