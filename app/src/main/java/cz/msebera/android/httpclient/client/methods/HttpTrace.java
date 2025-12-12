package cz.msebera.android.httpclient.client.methods;

import java.net.URI;

/* loaded from: classes2.dex */
public class HttpTrace extends HttpRequestBase {
    public static final String METHOD_NAME = "TRACE";

    public HttpTrace() {
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpRequestBase, cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public String getMethod() {
        return "TRACE";
    }

    public HttpTrace(URI uri) {
        setURI(uri);
    }

    public HttpTrace(String str) {
        setURI(URI.create(str));
    }
}
