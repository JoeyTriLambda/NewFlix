package mg;

import java.util.concurrent.CancellationException;

/* compiled from: Channel.kt */
/* loaded from: classes2.dex */
public interface i<E> {

    /* compiled from: Channel.kt */
    public static final class a {
        public static /* synthetic */ void cancel$default(i iVar, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            iVar.cancel(cancellationException);
        }
    }

    void cancel(CancellationException cancellationException);

    Object receive(qf.c<? super E> cVar);

    /* renamed from: receiveCatching-JP2dKIU */
    Object mo68receiveCatchingJP2dKIU(qf.c<? super kotlinx.coroutines.channels.a<? extends E>> cVar);

    /* renamed from: tryReceive-PtdJZtk */
    Object mo69tryReceivePtdJZtk();
}
