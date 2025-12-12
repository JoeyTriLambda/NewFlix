package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.util.List;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class RequestAcceptEncoding implements HttpRequestInterceptor {
    private final String acceptEncoding;

    public RequestAcceptEncoding(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.acceptEncoding = "gzip,deflate";
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (i10 > 0) {
                sb2.append(",");
            }
            sb2.append(list.get(i10));
        }
        this.acceptEncoding = sb2.toString();
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        RequestConfig requestConfig = HttpClientContext.adapt(httpContext).getRequestConfig();
        if (httpRequest.containsHeader("Accept-Encoding") || !requestConfig.isContentCompressionEnabled()) {
            return;
        }
        httpRequest.addHeader("Accept-Encoding", this.acceptEncoding);
    }

    public RequestAcceptEncoding() {
        this(null);
    }
}
