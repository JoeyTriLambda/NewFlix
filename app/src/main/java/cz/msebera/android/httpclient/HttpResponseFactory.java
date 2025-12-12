package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.protocol.HttpContext;

/* loaded from: classes2.dex */
public interface HttpResponseFactory {
    HttpResponse newHttpResponse(ProtocolVersion protocolVersion, int i10, HttpContext httpContext);

    HttpResponse newHttpResponse(StatusLine statusLine, HttpContext httpContext);
}
