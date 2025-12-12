package com.unity3d.services.core.cache;

import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import java.io.Serializable;
import java.util.Arrays;
import zf.i;

/* compiled from: CacheEventSender.kt */
/* loaded from: classes2.dex */
public final class CacheEventSender implements Serializable {
    private final IEventSender eventSender;

    public CacheEventSender(IEventSender iEventSender) {
        i.checkNotNullParameter(iEventSender, "eventSender");
        this.eventSender = iEventSender;
    }

    public final boolean sendEvent(CacheEvent cacheEvent, Object... objArr) {
        i.checkNotNullParameter(cacheEvent, "eventId");
        i.checkNotNullParameter(objArr, "params");
        return this.eventSender.sendEvent(WebViewEventCategory.CACHE, cacheEvent, Arrays.copyOf(objArr, objArr.length));
    }
}
