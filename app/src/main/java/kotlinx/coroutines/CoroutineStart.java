package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;
import yf.p;

/* compiled from: CoroutineStart.kt */
/* loaded from: classes2.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    /* JADX INFO: Fake field, exist only in values array */
    ATOMIC,
    /* JADX INFO: Fake field, exist only in values array */
    UNDISPATCHED;

    public final <R, T> void invoke(p<? super R, ? super qf.c<? super T>, ? extends Object> pVar, R r10, qf.c<? super T> cVar) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            qg.a.startCoroutineCancellable$default(pVar, r10, cVar, null, 4, null);
            return;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                qf.e.startCoroutine(pVar, r10, cVar);
            } else {
                if (iOrdinal != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                qg.b.startCoroutineUndispatched(pVar, r10, cVar);
            }
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }
}
