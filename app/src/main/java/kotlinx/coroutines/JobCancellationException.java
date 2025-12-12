package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kg.k1;

/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public final class JobCancellationException extends CancellationException {

    /* renamed from: b, reason: collision with root package name */
    public final transient k1 f15295b;

    public JobCancellationException(String str, Throwable th2, k1 k1Var) {
        super(str);
        this.f15295b = k1Var;
        if (th2 != null) {
            initCause(th2);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!zf.i.areEqual(jobCancellationException.getMessage(), getMessage()) || !zf.i.areEqual(jobCancellationException.f15295b, this.f15295b) || !zf.i.areEqual(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        zf.i.checkNotNull(message);
        int iHashCode = (this.f15295b.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f15295b;
    }
}
