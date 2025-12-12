package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public final class ExceptionHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final Throwable f14544a = new Termination();

    public static <T> boolean addThrowable(AtomicReference<Throwable> atomicReference, Throwable th2) {
        boolean z10;
        do {
            Throwable th3 = atomicReference.get();
            z10 = false;
            if (th3 == f14544a) {
                return false;
            }
            Throwable compositeException = th3 == null ? th2 : new CompositeException(th3, th2);
            while (true) {
                if (atomicReference.compareAndSet(th3, compositeException)) {
                    z10 = true;
                    break;
                }
                if (atomicReference.get() != th3) {
                    break;
                }
            }
        } while (!z10);
        return true;
    }

    public static <T> Throwable terminate(AtomicReference<Throwable> atomicReference) {
        Throwable th2 = atomicReference.get();
        Throwable th3 = f14544a;
        return th2 != th3 ? atomicReference.getAndSet(th3) : th2;
    }

    public static String timeoutMessage(long j10, TimeUnit timeUnit) {
        return "The source did not signal an event for " + j10 + StringUtils.SPACE + timeUnit.toString().toLowerCase() + " and has been terminated.";
    }

    public static RuntimeException wrapOrThrow(Throwable th2) {
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        return th2 instanceof RuntimeException ? (RuntimeException) th2 : new RuntimeException(th2);
    }

    public static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        public Termination() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }
}
