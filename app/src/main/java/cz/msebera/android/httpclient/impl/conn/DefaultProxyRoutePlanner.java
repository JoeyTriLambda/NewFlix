package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes2.dex */
public class DefaultProxyRoutePlanner extends DefaultRoutePlanner {
    private final HttpHost proxy;

    public DefaultProxyRoutePlanner(HttpHost httpHost, SchemePortResolver schemePortResolver) {
        super(schemePortResolver);
        this.proxy = (HttpHost) Args.notNull(httpHost, "Proxy host");
    }

    @Override // cz.msebera.android.httpclient.impl.conn.DefaultRoutePlanner
    public HttpHost determineProxy(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        return this.proxy;
    }

    public DefaultProxyRoutePlanner(HttpHost httpHost) {
        this(httpHost, null);
    }
}
