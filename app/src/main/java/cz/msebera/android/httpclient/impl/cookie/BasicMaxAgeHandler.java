package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import java.util.Date;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class BasicMaxAgeHandler extends AbstractCookieAttributeHandler implements CommonCookieAttributeHandler {
    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return "max-age";
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException, NumberFormatException {
        Args.notNull(setCookie, "Cookie");
        if (str == null) {
            throw new MalformedCookieException("Missing value for 'max-age' attribute");
        }
        try {
            int i10 = Integer.parseInt(str);
            if (i10 < 0) {
                throw new MalformedCookieException("Negative 'max-age' attribute: ".concat(str));
            }
            setCookie.setExpiryDate(new Date((i10 * 1000) + System.currentTimeMillis()));
        } catch (NumberFormatException unused) {
            throw new MalformedCookieException("Invalid 'max-age' attribute: ".concat(str));
        }
    }
}
