package org.adblockplus.libadblockplus;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class HttpRequest {
    private final boolean followRedirect;
    private final List<HeaderEntry> headers;
    private final String method;
    private final boolean skipInputStreamReading;
    private final String url;

    public HttpRequest(String str, String str2, List<HeaderEntry> list, boolean z10, boolean z11) {
        this.url = str;
        this.method = str2;
        this.headers = list;
        this.followRedirect = z10;
        this.skipInputStreamReading = z11;
    }

    public boolean getFollowRedirect() {
        return this.followRedirect;
    }

    public List<HeaderEntry> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean skipInputStreamReading() {
        return this.skipInputStreamReading;
    }

    public HttpRequest(String str) {
        this(str, "GET", Collections.emptyList(), true, false);
    }
}
