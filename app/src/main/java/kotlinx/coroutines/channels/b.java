package kotlinx.coroutines.channels;

import kotlinx.coroutines.channels.a;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import lf.h;
import qf.c;
import yf.l;
import zf.k;

/* compiled from: ConflatedBufferedChannel.kt */
/* loaded from: classes2.dex */
public final class b<E> extends BufferedChannel<E> {

    /* renamed from: w, reason: collision with root package name */
    public final BufferOverflow f15362w;

    public b(int i10, BufferOverflow bufferOverflow, l<? super E, h> lVar) {
        super(i10, lVar);
        this.f15362w = bufferOverflow;
        if (bufferOverflow != BufferOverflow.SUSPEND) {
            if (!(i10 >= 1)) {
                throw new IllegalArgumentException(o1.a.d("Buffered channel capacity must be at least 1, but ", i10, " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + k.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead").toString());
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean isConflatedDropOldest() {
        return this.f15362w == BufferOverflow.DROP_OLDEST;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
    
        return kotlinx.coroutines.channels.a.f15358b.m81closedJP2dKIU(getSendException());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r(E r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.b.r(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, mg.j
    public Object send(E e10, c<? super h> cVar) throws Throwable {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        Object objR = r(e10, true);
        if (!(objR instanceof a.C0181a)) {
            return h.f16056a;
        }
        a.m74exceptionOrNullimpl(objR);
        l<E, h> lVar = this.f15327m;
        if (lVar == null || (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(lVar, e10, null, 2, null)) == null) {
            throw getSendException();
        }
        lf.a.addSuppressed(undeliveredElementExceptionCallUndeliveredElementCatchingException$default, getSendException());
        throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, mg.j
    /* renamed from: trySend-JP2dKIU */
    public Object mo70trySendJP2dKIU(E e10) {
        return r(e10, false);
    }
}
