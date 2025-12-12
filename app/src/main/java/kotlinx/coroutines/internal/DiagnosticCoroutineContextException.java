package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* loaded from: classes2.dex */
public final class DiagnosticCoroutineContextException extends RuntimeException {

    /* renamed from: b, reason: collision with root package name */
    public final transient CoroutineContext f15557b;

    public DiagnosticCoroutineContextException(CoroutineContext coroutineContext) {
        this.f15557b = coroutineContext;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f15557b.toString();
    }
}
