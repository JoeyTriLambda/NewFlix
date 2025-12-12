package cz.msebera.android.httpclient.client;

import java.io.IOException;

/* loaded from: classes2.dex */
public class ClientProtocolException extends IOException {
    private static final long serialVersionUID = -5596590843227115865L;

    public ClientProtocolException() {
    }

    public ClientProtocolException(String str) {
        super(str);
    }

    public ClientProtocolException(Throwable th2) {
        initCause(th2);
    }

    public ClientProtocolException(String str, Throwable th2) {
        super(str);
        initCause(th2);
    }
}
