package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.c;
import com.unity3d.scar.adapter.common.j;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;

/* loaded from: classes2.dex */
public class WebViewErrorHandler implements c<j> {
    private final IEventSender _eventSender;

    public WebViewErrorHandler() {
        this(SharedInstances.INSTANCE.getWebViewEventSender());
    }

    public WebViewErrorHandler(IEventSender iEventSender) {
        this._eventSender = iEventSender;
    }

    @Override // com.unity3d.scar.adapter.common.c
    public void handleError(j jVar) {
        this._eventSender.sendEvent(WebViewEventCategory.valueOf(jVar.getDomain()), jVar.getErrorCategory(), jVar.getErrorArguments());
    }
}
