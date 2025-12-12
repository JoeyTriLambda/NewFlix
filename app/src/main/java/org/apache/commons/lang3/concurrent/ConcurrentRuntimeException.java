package org.apache.commons.lang3.concurrent;

/* loaded from: classes2.dex */
public class ConcurrentRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -6582182735562919670L;

    public ConcurrentRuntimeException() {
    }

    public ConcurrentRuntimeException(Throwable th2) {
        super(ConcurrentUtils.checkedException(th2));
    }

    public ConcurrentRuntimeException(String str, Throwable th2) {
        super(str, ConcurrentUtils.checkedException(th2));
    }
}
