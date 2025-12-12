package okhttp3.internal.http;

import cz.msebera.android.httpclient.client.methods.HttpPatch;
import zf.i;

/* compiled from: HttpMethod.kt */
/* loaded from: classes2.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean permitsRequestBody(String str) {
        i.checkNotNullParameter(str, "method");
        return (i.areEqual(str, "GET") || i.areEqual(str, "HEAD")) ? false : true;
    }

    public static final boolean requiresRequestBody(String str) {
        i.checkNotNullParameter(str, "method");
        return i.areEqual(str, "POST") || i.areEqual(str, "PUT") || i.areEqual(str, HttpPatch.METHOD_NAME) || i.areEqual(str, "PROPPATCH") || i.areEqual(str, "REPORT");
    }

    public final boolean invalidatesCache(String str) {
        i.checkNotNullParameter(str, "method");
        return i.areEqual(str, "POST") || i.areEqual(str, HttpPatch.METHOD_NAME) || i.areEqual(str, "PUT") || i.areEqual(str, "DELETE") || i.areEqual(str, "MOVE");
    }

    public final boolean redirectsToGet(String str) {
        i.checkNotNullParameter(str, "method");
        return !i.areEqual(str, "PROPFIND");
    }

    public final boolean redirectsWithBody(String str) {
        i.checkNotNullParameter(str, "method");
        return i.areEqual(str, "PROPFIND");
    }
}
