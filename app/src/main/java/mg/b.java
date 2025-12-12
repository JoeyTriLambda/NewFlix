package mg;

import java.util.concurrent.CancellationException;
import kg.r1;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.JobCancellationException;
import yf.l;

/* compiled from: ChannelCoroutine.kt */
/* loaded from: classes2.dex */
public class b<E> extends kg.a<lf.h> implements a<E> {

    /* renamed from: o, reason: collision with root package name */
    public final a<E> f16315o;

    public b(CoroutineContext coroutineContext, a<E> aVar, boolean z10, boolean z11) {
        super(coroutineContext, z10, z11);
        this.f16315o = aVar;
    }

    @Override // kg.r1, kg.k1
    public final void cancel(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    @Override // kg.r1
    public void cancelInternal(Throwable th2) {
        CancellationException cancellationException$default = r1.toCancellationException$default(this, th2, null, 1, null);
        this.f16315o.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    @Override // mg.j
    public boolean close(Throwable th2) {
        return this.f16315o.close(th2);
    }

    public final a<E> get_channel() {
        return this.f16315o;
    }

    @Override // mg.j
    public void invokeOnClose(l<? super Throwable, lf.h> lVar) {
        this.f16315o.invokeOnClose(lVar);
    }

    @Override // mg.i
    public Object receive(qf.c<? super E> cVar) {
        return this.f16315o.receive(cVar);
    }

    @Override // mg.i
    /* renamed from: receiveCatching-JP2dKIU */
    public Object mo68receiveCatchingJP2dKIU(qf.c<? super kotlinx.coroutines.channels.a<? extends E>> cVar) {
        Object objMo68receiveCatchingJP2dKIU = this.f16315o.mo68receiveCatchingJP2dKIU(cVar);
        rf.a.getCOROUTINE_SUSPENDED();
        return objMo68receiveCatchingJP2dKIU;
    }

    @Override // mg.j
    public Object send(E e10, qf.c<? super lf.h> cVar) {
        return this.f16315o.send(e10, cVar);
    }

    @Override // mg.i
    /* renamed from: tryReceive-PtdJZtk */
    public Object mo69tryReceivePtdJZtk() {
        return this.f16315o.mo69tryReceivePtdJZtk();
    }

    @Override // mg.j
    /* renamed from: trySend-JP2dKIU */
    public Object mo70trySendJP2dKIU(E e10) {
        return this.f16315o.mo70trySendJP2dKIU(e10);
    }

    public final a<E> getChannel() {
        return this;
    }
}
