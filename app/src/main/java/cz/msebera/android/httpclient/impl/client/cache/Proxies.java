package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.util.Args;
import java.lang.reflect.Proxy;

/* loaded from: classes2.dex */
class Proxies {
    public static CloseableHttpResponse enhanceResponse(HttpResponse httpResponse) {
        Args.notNull(httpResponse, "HTTP response");
        return httpResponse instanceof CloseableHttpResponse ? (CloseableHttpResponse) httpResponse : (CloseableHttpResponse) Proxy.newProxyInstance(ResponseProxyHandler.class.getClassLoader(), new Class[]{CloseableHttpResponse.class}, new ResponseProxyHandler(httpResponse));
    }
}
