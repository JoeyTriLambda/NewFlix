package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class WebViewBridgeSharedObjectStore<T extends IWebViewSharedObject> implements IWebViewBridgeSharedObjectStore<T> {
    private ConcurrentHashMap<String, T> _sharedObjects = new ConcurrentHashMap<>();

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore
    public T get(String str) {
        if (str == null) {
            return null;
        }
        return this._sharedObjects.get(str);
    }

    public void remove(T t10) {
        if (t10 == null) {
            return;
        }
        remove(t10.getId());
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore
    public void set(T t10) {
        if (t10 == null) {
            return;
        }
        this._sharedObjects.put(t10.getId(), t10);
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore
    public void remove(String str) {
        this._sharedObjects.remove(str);
    }
}
