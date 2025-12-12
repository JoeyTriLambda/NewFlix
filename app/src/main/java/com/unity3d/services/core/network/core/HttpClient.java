package com.unity3d.services.core.network.core;

import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import qf.c;

/* compiled from: HttpClient.kt */
/* loaded from: classes2.dex */
public interface HttpClient {
    Object execute(HttpRequest httpRequest, c<? super HttpResponse> cVar);

    HttpResponse executeBlocking(HttpRequest httpRequest) throws Exception;
}
