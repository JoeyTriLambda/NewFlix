package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.Args;
import java.util.Map;

@Contract(threading = ThreadingBehavior.SAFE)
@Deprecated
/* loaded from: classes2.dex */
public class HttpRequestHandlerRegistry implements HttpRequestHandlerResolver {
    private final UriPatternMatcher<HttpRequestHandler> matcher = new UriPatternMatcher<>();

    public Map<String, HttpRequestHandler> getHandlers() {
        return this.matcher.getObjects();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestHandlerResolver
    public HttpRequestHandler lookup(String str) {
        return this.matcher.lookup(str);
    }

    public void register(String str, HttpRequestHandler httpRequestHandler) {
        Args.notNull(str, "URI request pattern");
        Args.notNull(httpRequestHandler, "Request handler");
        this.matcher.register(str, httpRequestHandler);
    }

    public void setHandlers(Map<String, HttpRequestHandler> map) {
        this.matcher.setObjects(map);
    }

    public void unregister(String str) {
        this.matcher.unregister(str);
    }
}
