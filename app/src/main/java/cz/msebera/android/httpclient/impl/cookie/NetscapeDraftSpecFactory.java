package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecFactory;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.cookie.params.CookieSpecPNames;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Collection;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: classes2.dex */
public class NetscapeDraftSpecFactory implements CookieSpecFactory, CookieSpecProvider {
    private final CookieSpec cookieSpec;

    public NetscapeDraftSpecFactory(String[] strArr) {
        this.cookieSpec = new NetscapeDraftSpec(strArr);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpecProvider
    public CookieSpec create(HttpContext httpContext) {
        return this.cookieSpec;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpecFactory
    public CookieSpec newInstance(HttpParams httpParams) {
        if (httpParams == null) {
            return new NetscapeDraftSpec();
        }
        Collection collection = (Collection) httpParams.getParameter(CookieSpecPNames.DATE_PATTERNS);
        return new NetscapeDraftSpec(collection != null ? (String[]) collection.toArray(new String[collection.size()]) : null);
    }

    public NetscapeDraftSpecFactory() {
        this(null);
    }
}
