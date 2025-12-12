package cz.msebera.android.httpclient.impl.execchain;

import java.io.InterruptedIOException;

/* loaded from: classes2.dex */
public class RequestAbortedException extends InterruptedIOException {
    private static final long serialVersionUID = 4973849966012490112L;

    public RequestAbortedException(String str) {
        super(str);
    }

    public RequestAbortedException(String str, Throwable th2) {
        super(str);
        if (th2 != null) {
            initCause(th2);
        }
    }
}
