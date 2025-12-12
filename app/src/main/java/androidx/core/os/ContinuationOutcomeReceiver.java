package androidx.core.os;

import android.os.OutcomeReceiver;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import lf.f;
import qf.c;

/* compiled from: OutcomeReceiver.kt */
/* loaded from: classes.dex */
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {

    /* renamed from: b, reason: collision with root package name */
    public final c<R> f2144b;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationOutcomeReceiver(c<? super R> cVar) {
        super(false);
        this.f2144b = cVar;
    }

    @Override // android.os.OutcomeReceiver
    public void onError(E e10) {
        if (compareAndSet(false, true)) {
            c<R> cVar = this.f2144b;
            int i10 = Result.f15189m;
            cVar.resumeWith(Result.m59constructorimpl(f.createFailure(e10)));
        }
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(R r10) {
        if (compareAndSet(false, true)) {
            this.f2144b.resumeWith(Result.m59constructorimpl(r10));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
