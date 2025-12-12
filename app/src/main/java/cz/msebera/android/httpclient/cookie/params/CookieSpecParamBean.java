package cz.msebera.android.httpclient.cookie.params;

import cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import cz.msebera.android.httpclient.params.HttpParams;
import java.util.Collection;

@Deprecated
/* loaded from: classes2.dex */
public class CookieSpecParamBean extends HttpAbstractParamBean {
    public CookieSpecParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setDatePatterns(Collection<String> collection) {
        this.params.setParameter(CookieSpecPNames.DATE_PATTERNS, collection);
    }

    public void setSingleHeader(boolean z10) {
        this.params.setBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, z10);
    }
}
