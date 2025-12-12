package com.unity3d.services.core.webview.bridge.invocation;

import com.unity3d.services.core.webview.bridge.CallbackStatus;

/* loaded from: classes2.dex */
public interface IWebViewBridgeInvocationCallback {
    void onFailure(String str, CallbackStatus callbackStatus);

    void onSuccess();

    void onTimeout();
}
