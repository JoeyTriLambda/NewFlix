package com.unity3d.services.core.network.mapper;

import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.RequestType;
import com.unity3d.services.core.request.WebRequest;
import java.util.List;
import java.util.Map;
import zf.i;

/* compiled from: WebRequestToHttpRequest.kt */
/* loaded from: classes2.dex */
public final class WebRequestToHttpRequestKt {
    public static final HttpRequest toHttpRequest(WebRequest webRequest) {
        i.checkNotNullParameter(webRequest, "<this>");
        String string = webRequest.getUrl().toString();
        String requestType = webRequest.getRequestType();
        i.checkNotNullExpressionValue(requestType, "requestType");
        RequestType requestTypeValueOf = RequestType.valueOf(requestType);
        Map<String, List<String>> headers = webRequest.getHeaders();
        byte[] body = webRequest.getBody();
        i.checkNotNullExpressionValue(string, "toString()");
        i.checkNotNullExpressionValue(headers, "headers");
        return new HttpRequest(string, null, requestTypeValueOf, body, headers, null, null, null, null, 0, 0, 0, 0, 8162, null);
    }
}
