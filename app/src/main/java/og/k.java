package og;

import kotlin.coroutines.CoroutineContext;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes2.dex */
public final class k<T> implements qf.c<T>, sf.c {

    /* renamed from: b, reason: collision with root package name */
    public final qf.c<T> f17097b;

    /* renamed from: m, reason: collision with root package name */
    public final CoroutineContext f17098m;

    /* JADX WARN: Multi-variable type inference failed */
    public k(qf.c<? super T> cVar, CoroutineContext coroutineContext) {
        this.f17097b = cVar;
        this.f17098m = coroutineContext;
    }

    @Override // sf.c
    public sf.c getCallerFrame() {
        qf.c<T> cVar = this.f17097b;
        if (cVar instanceof sf.c) {
            return (sf.c) cVar;
        }
        return null;
    }

    @Override // qf.c
    public CoroutineContext getContext() {
        return this.f17098m;
    }

    @Override // qf.c
    public void resumeWith(Object obj) {
        this.f17097b.resumeWith(obj);
    }
}
