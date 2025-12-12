package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: classes2.dex */
public class RFC6265LaxSpec extends RFC6265CookieSpecBase {
    public RFC6265LaxSpec() {
        super(new BasicPathHandler(), new BasicDomainHandler(), new LaxMaxAgeHandler(), new BasicSecureHandler(), new LaxExpiresHandler());
    }

    public String toString() {
        return "rfc6265-lax";
    }

    public RFC6265LaxSpec(CommonCookieAttributeHandler... commonCookieAttributeHandlerArr) {
        super(commonCookieAttributeHandlerArr);
    }
}
