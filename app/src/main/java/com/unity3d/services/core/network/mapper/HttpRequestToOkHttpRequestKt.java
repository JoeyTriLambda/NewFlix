package com.unity3d.services.core.network.mapper;

import com.fasterxml.jackson.core.JsonPointer;
import com.unity3d.services.core.network.model.HttpRequest;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt__StringsKt;
import mf.q;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import zf.i;

/* compiled from: HttpRequestToOkHttpRequest.kt */
/* loaded from: classes2.dex */
public final class HttpRequestToOkHttpRequestKt {
    private static final RequestBody generateOkHttpBody(Object obj) {
        if (obj instanceof byte[]) {
            RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), (byte[]) obj);
            i.checkNotNullExpressionValue(requestBodyCreate, "create(MediaType.parse(\"…in;charset=utf-8\"), body)");
            return requestBodyCreate;
        }
        if (obj instanceof String) {
            RequestBody requestBodyCreate2 = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), (String) obj);
            i.checkNotNullExpressionValue(requestBodyCreate2, "create(MediaType.parse(\"…in;charset=utf-8\"), body)");
            return requestBodyCreate2;
        }
        RequestBody requestBodyCreate3 = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), "");
        i.checkNotNullExpressionValue(requestBodyCreate3, "create(MediaType.parse(\"…lain;charset=utf-8\"), \"\")");
        return requestBodyCreate3;
    }

    private static final Headers generateOkHttpHeaders(HttpRequest httpRequest) {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry<String, List<String>> entry : httpRequest.getHeaders().entrySet()) {
            builder.add(entry.getKey(), q.joinToString$default(entry.getValue(), ",", null, null, 0, null, null, 62, null));
        }
        Headers headersBuild = builder.build();
        i.checkNotNullExpressionValue(headersBuild, "Builder()\n    .also { he…ng(\",\")) } }\n    .build()");
        return headersBuild;
    }

    public static final Request toOkHttpRequest(HttpRequest httpRequest) {
        i.checkNotNullParameter(httpRequest, "<this>");
        Request.Builder builderUrl = new Request.Builder().url(StringsKt__StringsKt.removeSuffix(StringsKt__StringsKt.trim(httpRequest.getBaseURL(), JsonPointer.SEPARATOR) + JsonPointer.SEPARATOR + StringsKt__StringsKt.trim(httpRequest.getPath(), JsonPointer.SEPARATOR), "/"));
        String string = httpRequest.getMethod().toString();
        Object body = httpRequest.getBody();
        Request requestBuild = builderUrl.method(string, body != null ? generateOkHttpBody(body) : null).headers(generateOkHttpHeaders(httpRequest)).build();
        i.checkNotNullExpressionValue(requestBuild, "Builder()\n    .url(\"${ba…tpHeaders())\n    .build()");
        return requestBuild;
    }
}
