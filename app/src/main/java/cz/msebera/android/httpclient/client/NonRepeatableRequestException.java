package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.ProtocolException;

/* loaded from: classes2.dex */
public class NonRepeatableRequestException extends ProtocolException {
    private static final long serialVersionUID = 82685265288806048L;

    public NonRepeatableRequestException() {
    }

    public NonRepeatableRequestException(String str) {
        super(str);
    }

    public NonRepeatableRequestException(String str, Throwable th2) {
        super(str, th2);
    }
}
