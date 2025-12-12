package com.unity3d.services.core.webview.bridge;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public interface IWebViewBridgeInvoker {
    boolean invokeMethod(String str, String str2, Method method, Object... objArr);
}
