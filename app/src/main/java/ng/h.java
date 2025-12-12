package ng;

import kotlinx.coroutines.flow.AbstractFlow;
import yf.p;

/* compiled from: Builders.kt */
/* loaded from: classes2.dex */
public final class h<T> extends AbstractFlow<T> {

    /* renamed from: b, reason: collision with root package name */
    public final p<b<? super T>, qf.c<? super lf.h>, Object> f16827b;

    /* JADX WARN: Multi-variable type inference failed */
    public h(p<? super b<? super T>, ? super qf.c<? super lf.h>, ? extends Object> pVar) {
        this.f16827b = pVar;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public Object collectSafely(b<? super T> bVar, qf.c<? super lf.h> cVar) {
        Object objInvoke = this.f16827b.invoke(bVar, cVar);
        return objInvoke == rf.a.getCOROUTINE_SUSPENDED() ? objInvoke : lf.h.f16056a;
    }
}
