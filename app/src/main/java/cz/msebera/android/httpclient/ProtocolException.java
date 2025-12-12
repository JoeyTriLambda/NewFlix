package cz.msebera.android.httpclient;

/* loaded from: classes2.dex */
public class ProtocolException extends HttpException {
    private static final long serialVersionUID = -2143571074341228994L;

    public ProtocolException() {
    }

    public ProtocolException(String str) {
        super(str);
    }

    public ProtocolException(String str, Throwable th2) {
        super(str, th2);
    }
}
