package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.Obsolete;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.protocol.HttpContext;

@Obsolete
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class NetscapeDraftSpecProvider implements CookieSpecProvider {
    private volatile CookieSpec cookieSpec;
    private final String[] datepatterns;

    public NetscapeDraftSpecProvider(String[] strArr) {
        this.datepatterns = strArr;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpecProvider
    public CookieSpec create(HttpContext httpContext) {
        if (this.cookieSpec == null) {
            synchronized (this) {
                if (this.cookieSpec == null) {
                    this.cookieSpec = new NetscapeDraftSpec(this.datepatterns);
                }
            }
        }
        return this.cookieSpec;
    }

    public NetscapeDraftSpecProvider() {
        this(null);
    }
}
