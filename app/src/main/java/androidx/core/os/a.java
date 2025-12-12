package androidx.core.os;

import android.os.OutcomeReceiver;
import qf.c;

/* compiled from: OutcomeReceiver.kt */
/* loaded from: classes.dex */
public final class a {
    public static final <R, E extends Throwable> OutcomeReceiver<R, E> asOutcomeReceiver(c<? super R> cVar) {
        return new ContinuationOutcomeReceiver(cVar);
    }
}
