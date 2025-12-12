package mg;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.BufferedChannel;
import yf.l;

/* compiled from: Channel.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final <E> a<E> Channel(int i10, BufferOverflow bufferOverflow, l<? super E, lf.h> lVar) {
        a<E> bufferedChannel;
        BufferOverflow bufferOverflow2 = BufferOverflow.SUSPEND;
        if (i10 != -2) {
            if (i10 == -1) {
                if (bufferOverflow == bufferOverflow2) {
                    return new kotlinx.coroutines.channels.b(1, BufferOverflow.DROP_OLDEST, lVar);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
            if (i10 != 0) {
                return i10 != Integer.MAX_VALUE ? bufferOverflow == bufferOverflow2 ? new BufferedChannel(i10, lVar) : new kotlinx.coroutines.channels.b(i10, bufferOverflow, lVar) : new BufferedChannel(Integer.MAX_VALUE, lVar);
            }
            bufferedChannel = bufferOverflow == bufferOverflow2 ? new BufferedChannel<>(0, lVar) : new kotlinx.coroutines.channels.b<>(1, bufferOverflow, lVar);
        } else {
            bufferedChannel = bufferOverflow == bufferOverflow2 ? new BufferedChannel<>(a.f16312k.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core(), lVar) : new kotlinx.coroutines.channels.b<>(1, bufferOverflow, lVar);
        }
        return bufferedChannel;
    }

    public static /* synthetic */ a Channel$default(int i10, BufferOverflow bufferOverflow, l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        return Channel(i10, bufferOverflow, lVar);
    }
}
