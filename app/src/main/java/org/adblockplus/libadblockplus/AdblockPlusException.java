package org.adblockplus.libadblockplus;

/* loaded from: classes2.dex */
public class AdblockPlusException extends RuntimeException {
    private static final long serialVersionUID = -8127654134450836743L;

    public AdblockPlusException(String str) {
        super(str);
    }

    public AdblockPlusException(String str, Throwable th2) {
        super(str, th2);
    }

    public AdblockPlusException(Throwable th2) {
        super(th2);
    }
}
