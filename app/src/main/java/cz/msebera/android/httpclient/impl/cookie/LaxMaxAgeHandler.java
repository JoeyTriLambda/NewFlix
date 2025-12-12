package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.util.Date;
import java.util.regex.Pattern;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class LaxMaxAgeHandler extends AbstractCookieAttributeHandler implements CommonCookieAttributeHandler {
    private static final Pattern MAX_AGE_PATTERN = Pattern.compile("^\\-?[0-9]+$");

    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return "max-age";
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException, NumberFormatException {
        Date date;
        Args.notNull(setCookie, "Cookie");
        if (!TextUtils.isBlank(str) && MAX_AGE_PATTERN.matcher(str).matches()) {
            try {
                int i10 = Integer.parseInt(str);
                if (i10 >= 0) {
                    date = new Date((i10 * 1000) + System.currentTimeMillis());
                } else {
                    date = new Date(Long.MIN_VALUE);
                }
                setCookie.setExpiryDate(date);
            } catch (NumberFormatException unused) {
            }
        }
    }
}
