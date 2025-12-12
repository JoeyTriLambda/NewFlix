package cz.msebera.android.httpclient.client.methods;

import java.net.URI;

/* loaded from: classes2.dex */
public class HttpPut extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "PUT";

    public HttpPut() {
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpRequestBase, cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public String getMethod() {
        return "PUT";
    }

    public HttpPut(URI uri) {
        setURI(uri);
    }

    public HttpPut(String str) {
        setURI(URI.create(str));
    }
}
