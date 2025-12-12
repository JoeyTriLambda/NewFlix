package mg;

import yf.l;

/* compiled from: Channel.kt */
/* loaded from: classes2.dex */
public interface j<E> {

    /* compiled from: Channel.kt */
    public static final class a {
        public static /* synthetic */ boolean close$default(j jVar, Throwable th2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i10 & 1) != 0) {
                th2 = null;
            }
            return jVar.close(th2);
        }
    }

    boolean close(Throwable th2);

    void invokeOnClose(l<? super Throwable, lf.h> lVar);

    Object send(E e10, qf.c<? super lf.h> cVar);

    /* renamed from: trySend-JP2dKIU */
    Object mo70trySendJP2dKIU(E e10);
}
