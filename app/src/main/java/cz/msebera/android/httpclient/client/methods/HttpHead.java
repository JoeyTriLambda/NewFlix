package cz.msebera.android.httpclient.client.methods;

import java.net.URI;

/* loaded from: classes2.dex */
public class HttpHead extends HttpRequestBase {
    public static final String METHOD_NAME = "HEAD";

    public HttpHead() {
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpRequestBase, cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public String getMethod() {
        return "HEAD";
    }

    public HttpHead(URI uri) {
        setURI(uri);
    }

    public HttpHead(String str) {
        setURI(URI.create(str));
    }
}
