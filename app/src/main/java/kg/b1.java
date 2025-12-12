package kg;

import java.util.concurrent.CancellationException;

/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public final class b1 {
    public static final CancellationException CancellationException(String str, Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }
}
