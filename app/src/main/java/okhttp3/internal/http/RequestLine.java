package okhttp3.internal.http;

import cz.msebera.android.httpclient.message.TokenParser;
import java.net.Proxy;
import okhttp3.HttpUrl;
import okhttp3.Request;
import zf.i;

/* compiled from: RequestLine.kt */
/* loaded from: classes2.dex */
public final class RequestLine {
    public static final RequestLine INSTANCE = new RequestLine();

    private RequestLine() {
    }

    private final boolean includeAuthorityInRequestLine(Request request, Proxy.Type type) {
        return !request.isHttps() && type == Proxy.Type.HTTP;
    }

    public final String get(Request request, Proxy.Type type) {
        i.checkNotNullParameter(request, "request");
        i.checkNotNullParameter(type, "proxyType");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(request.method());
        sb2.append(TokenParser.SP);
        RequestLine requestLine = INSTANCE;
        if (requestLine.includeAuthorityInRequestLine(request, type)) {
            sb2.append(request.url());
        } else {
            sb2.append(requestLine.requestPath(request.url()));
        }
        sb2.append(" HTTP/1.1");
        String string = sb2.toString();
        i.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String requestPath(HttpUrl httpUrl) {
        i.checkNotNullParameter(httpUrl, "url");
        String strEncodedPath = httpUrl.encodedPath();
        String strEncodedQuery = httpUrl.encodedQuery();
        if (strEncodedQuery == null) {
            return strEncodedPath;
        }
        return strEncodedPath + '?' + ((Object) strEncodedQuery);
    }
}
