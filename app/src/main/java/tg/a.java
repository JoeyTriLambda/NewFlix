package tg;

import lf.h;

/* compiled from: Mutex.kt */
/* loaded from: classes2.dex */
public interface a {

    /* compiled from: Mutex.kt */
    /* renamed from: tg.a$a, reason: collision with other inner class name */
    public static final class C0282a {
        public static /* synthetic */ void unlock$default(a aVar, Object obj, int i10, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            }
            if ((i10 & 1) != 0) {
                obj = null;
            }
            aVar.unlock(obj);
        }
    }

    boolean isLocked();

    Object lock(Object obj, qf.c<? super h> cVar);

    void unlock(Object obj);
}
