package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.ProtocolException;

/* loaded from: classes2.dex */
public class MalformedCookieException extends ProtocolException {
    private static final long serialVersionUID = -6695462944287282185L;

    public MalformedCookieException() {
    }

    public MalformedCookieException(String str) {
        super(str);
    }

    public MalformedCookieException(String str, Throwable th2) {
        super(str, th2);
    }
}
