package org.apache.commons.lang3;

/* loaded from: classes2.dex */
public class NotImplementedException extends UnsupportedOperationException {
    private static final long serialVersionUID = 20131021;
    private final String code;

    public NotImplementedException(String str) {
        this(str, (String) null);
    }

    public String getCode() {
        return this.code;
    }

    public NotImplementedException(Throwable th2) {
        this(th2, (String) null);
    }

    public NotImplementedException(String str, Throwable th2) {
        this(str, th2, null);
    }

    public NotImplementedException(String str, String str2) {
        super(str);
        this.code = str2;
    }

    public NotImplementedException(Throwable th2, String str) {
        super(th2);
        this.code = str;
    }

    public NotImplementedException(String str, Throwable th2, String str2) {
        super(str, th2);
        this.code = str2;
    }
}
