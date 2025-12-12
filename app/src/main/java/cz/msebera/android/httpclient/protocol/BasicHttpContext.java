package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.Args;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: classes2.dex */
public class BasicHttpContext implements HttpContext {
    private final Map<String, Object> map;
    private final HttpContext parentContext;

    public BasicHttpContext() {
        this(null);
    }

    public void clear() {
        this.map.clear();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object getAttribute(String str) {
        HttpContext httpContext;
        Args.notNull(str, "Id");
        Object obj = this.map.get(str);
        return (obj != null || (httpContext = this.parentContext) == null) ? obj : httpContext.getAttribute(str);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object removeAttribute(String str) {
        Args.notNull(str, "Id");
        return this.map.remove(str);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public void setAttribute(String str, Object obj) {
        Args.notNull(str, "Id");
        if (obj != null) {
            this.map.put(str, obj);
        } else {
            this.map.remove(str);
        }
    }

    public String toString() {
        return this.map.toString();
    }

    public BasicHttpContext(HttpContext httpContext) {
        this.map = new ConcurrentHashMap();
        this.parentContext = httpContext;
    }
}
