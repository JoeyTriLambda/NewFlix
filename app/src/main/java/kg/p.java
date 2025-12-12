package kg;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: CompletionState.kt */
/* loaded from: classes2.dex */
public final class p extends z {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f15130c = AtomicIntegerFieldUpdater.newUpdater(p.class, "_resumed");
    private volatile int _resumed;

    public p(qf.c<?> cVar, Throwable th2, boolean z10) {
        if (th2 == null) {
            th2 = new CancellationException("Continuation " + cVar + " was cancelled normally");
        }
        super(th2, z10);
        this._resumed = 0;
    }

    public final boolean makeResumed() {
        return f15130c.compareAndSet(this, 0, 1);
    }
}
