package com.unity3d.services.core.network.mapper;

import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.request.WebRequest;
import zf.i;

/* compiled from: HttpRequestToWebRequest.kt */
/* loaded from: classes2.dex */
public final class HttpRequestToWebRequestKt {
    public static final WebRequest toWebRequest(HttpRequest httpRequest) {
        i.checkNotNullParameter(httpRequest, "<this>");
        WebRequest webRequest = new WebRequest(httpRequest.getBaseURL(), httpRequest.getMethod().toString(), httpRequest.getHeaders(), httpRequest.getConnectTimeout(), httpRequest.getReadTimeout());
        Object body = httpRequest.getBody();
        if (body instanceof String) {
            webRequest.setBody((String) httpRequest.getBody());
        } else if (body instanceof byte[]) {
            webRequest.setBody((byte[]) httpRequest.getBody());
        }
        return webRequest;
    }
}
