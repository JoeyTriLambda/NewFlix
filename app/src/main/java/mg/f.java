package mg;

import kg.f0;
import kotlin.coroutines.CoroutineContext;
import mg.j;

/* compiled from: Produce.kt */
/* loaded from: classes2.dex */
public final class f<E> extends b<E> implements g<E> {
    public f(CoroutineContext coroutineContext, a<E> aVar) {
        super(coroutineContext, aVar, true, true);
    }

    @Override // mg.g
    public /* bridge */ /* synthetic */ j getChannel() {
        return getChannel();
    }

    @Override // kg.a, kg.r1, kg.k1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kg.a
    public void onCancelled(Throwable th2, boolean z10) {
        if (get_channel().close(th2) || z10) {
            return;
        }
        f0.handleCoroutineException(getContext(), th2);
    }

    @Override // kg.a
    public void onCompleted(lf.h hVar) {
        j.a.close$default(get_channel(), null, 1, null);
    }
}
