package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public final class HttpVersion extends ProtocolVersion {
    public static final String HTTP = "HTTP";
    public static final HttpVersion HTTP_0_9 = new HttpVersion(0, 9);
    public static final HttpVersion HTTP_1_0 = new HttpVersion(1, 0);
    public static final HttpVersion HTTP_1_1 = new HttpVersion(1, 1);
    private static final long serialVersionUID = -5856653513894415344L;

    public HttpVersion(int i10, int i11) {
        super(HTTP, i10, i11);
    }

    @Override // cz.msebera.android.httpclient.ProtocolVersion
    public ProtocolVersion forVersion(int i10, int i11) {
        if (i10 == this.major && i11 == this.minor) {
            return this;
        }
        if (i10 == 1) {
            if (i11 == 0) {
                return HTTP_1_0;
            }
            if (i11 == 1) {
                return HTTP_1_1;
            }
        }
        return (i10 == 0 && i11 == 9) ? HTTP_0_9 : new HttpVersion(i10, i11);
    }
}
