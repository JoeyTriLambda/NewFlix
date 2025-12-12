package cz.msebera.android.httpclient.auth;

/* loaded from: classes2.dex */
public class InvalidCredentialsException extends AuthenticationException {
    private static final long serialVersionUID = -4834003835215460648L;

    public InvalidCredentialsException() {
    }

    public InvalidCredentialsException(String str) {
        super(str);
    }

    public InvalidCredentialsException(String str, Throwable th2) {
        super(str, th2);
    }
}
