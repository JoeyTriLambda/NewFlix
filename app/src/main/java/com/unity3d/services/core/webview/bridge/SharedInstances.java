package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.webview.WebViewApp;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import u8.a;
import zf.i;

/* compiled from: SharedInstances.kt */
/* loaded from: classes2.dex */
public final class SharedInstances {
    public static final SharedInstances INSTANCE = new SharedInstances();
    private static final IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker = new a(10);
    private static final INativeCallbackSubject webViewAppNativeCallbackSubject = new INativeCallbackSubject() { // from class: com.unity3d.services.core.webview.bridge.SharedInstances$webViewAppNativeCallbackSubject$1
        @Override // com.unity3d.services.core.webview.bridge.INativeCallbackSubject
        public NativeCallback getCallback(String str) {
            i.checkNotNullParameter(str, "callbackId");
            NativeCallback callback = WebViewApp.getCurrentApp().getCallback(str);
            i.checkNotNullExpressionValue(callback, "getCurrentApp().getCallback(callbackId)");
            return callback;
        }

        @Override // com.unity3d.services.core.webview.bridge.INativeCallbackSubject
        public void remove(NativeCallback nativeCallback) {
            i.checkNotNullParameter(nativeCallback, "callback");
            WebViewApp.getCurrentApp().removeCallback(nativeCallback);
        }
    };
    private static final IEventSender webViewEventSender = new IEventSender() { // from class: com.unity3d.services.core.webview.bridge.SharedInstances$webViewEventSender$1
        @Override // com.unity3d.services.core.webview.bridge.IEventSender
        public boolean canSend() {
            return WebViewApp.getCurrentApp() != null;
        }

        @Override // com.unity3d.services.core.webview.bridge.IEventSender
        public boolean sendEvent(Enum<?> r32, Enum<?> r42, Object... objArr) {
            i.checkNotNullParameter(r32, "eventCategory");
            i.checkNotNullParameter(r42, "eventId");
            i.checkNotNullParameter(objArr, "params");
            WebViewApp currentApp = WebViewApp.getCurrentApp();
            if (currentApp != null) {
                return currentApp.sendEvent(r32, r42, Arrays.copyOf(objArr, objArr.length));
            }
            return false;
        }
    };
    private static final IWebViewBridge webViewBridge = new IWebViewBridge() { // from class: com.unity3d.services.core.webview.bridge.SharedInstances$webViewBridge$1
        @Override // com.unity3d.services.core.webview.bridge.IWebViewBridge
        public void handleCallback(String str, String str2, Object[] objArr) throws Exception {
            WebViewBridge.getInstance().handleCallback(str, str2, objArr);
        }

        @Override // com.unity3d.services.core.webview.bridge.IWebViewBridge
        public void handleInvocation(String str, String str2, Object[] objArr, WebViewCallback webViewCallback) throws Exception {
            WebViewBridge.getInstance().handleInvocation(str, str2, objArr, webViewCallback);
        }
    };

    private SharedInstances() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void webViewAppInvocationCallbackInvoker$lambda$0(Invocation invocation) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(invocation, "it");
        WebViewApp.getCurrentApp().invokeCallback(invocation);
    }

    public final IInvocationCallbackInvoker getWebViewAppInvocationCallbackInvoker() {
        return webViewAppInvocationCallbackInvoker;
    }

    public final INativeCallbackSubject getWebViewAppNativeCallbackSubject() {
        return webViewAppNativeCallbackSubject;
    }

    public final IWebViewBridge getWebViewBridge() {
        return webViewBridge;
    }

    public final IEventSender getWebViewEventSender() {
        return webViewEventSender;
    }
}
