package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import ng.b;

/* compiled from: FlowExceptions.kt */
/* loaded from: classes2.dex */
public final class AbortFlowException extends CancellationException {

    /* renamed from: b, reason: collision with root package name */
    public final transient b<?> f15487b;

    public AbortFlowException(b<?> bVar) {
        super("Flow was aborted, no more elements needed");
        this.f15487b = bVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
