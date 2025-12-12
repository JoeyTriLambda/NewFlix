package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class StandardHttpRequestRetryHandler extends DefaultHttpRequestRetryHandler {
    private final Map<String, Boolean> idempotentMethods;

    public StandardHttpRequestRetryHandler(int i10, boolean z10) {
        super(i10, z10);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.idempotentMethods = concurrentHashMap;
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put("GET", bool);
        concurrentHashMap.put("HEAD", bool);
        concurrentHashMap.put("PUT", bool);
        concurrentHashMap.put("DELETE", bool);
        concurrentHashMap.put("OPTIONS", bool);
        concurrentHashMap.put("TRACE", bool);
    }

    @Override // cz.msebera.android.httpclient.impl.client.DefaultHttpRequestRetryHandler
    public boolean handleAsIdempotent(HttpRequest httpRequest) {
        Boolean bool = this.idempotentMethods.get(httpRequest.getRequestLine().getMethod().toUpperCase(Locale.ROOT));
        return bool != null && bool.booleanValue();
    }

    public StandardHttpRequestRetryHandler() {
        this(3, false);
    }
}
