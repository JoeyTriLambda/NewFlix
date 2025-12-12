package org.apache.commons.lang3.exception;

/* loaded from: classes2.dex */
public class CloneFailedException extends RuntimeException {
    private static final long serialVersionUID = 20091223;

    public CloneFailedException(String str) {
        super(str);
    }

    public CloneFailedException(Throwable th2) {
        super(th2);
    }

    public CloneFailedException(String str, Throwable th2) {
        super(str, th2);
    }
}
