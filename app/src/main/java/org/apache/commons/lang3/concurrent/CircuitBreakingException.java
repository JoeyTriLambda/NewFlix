package org.apache.commons.lang3.concurrent;

/* loaded from: classes2.dex */
public class CircuitBreakingException extends RuntimeException {
    private static final long serialVersionUID = 1408176654686913340L;

    public CircuitBreakingException() {
    }

    public CircuitBreakingException(String str, Throwable th2) {
        super(str, th2);
    }

    public CircuitBreakingException(String str) {
        super(str);
    }

    public CircuitBreakingException(Throwable th2) {
        super(th2);
    }
}
