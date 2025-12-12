package com.unity3d.services.store.core;

import com.unity3d.scar.adapter.common.j;
import com.unity3d.services.ads.gmascar.handlers.WebViewErrorHandler;
import com.unity3d.services.store.StoreError;
import com.unity3d.services.store.StoreEvent;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class StoreExceptionHandler {
    private final WebViewErrorHandler _webViewErrorHandler;

    public StoreExceptionHandler(WebViewErrorHandler webViewErrorHandler) {
        this._webViewErrorHandler = webViewErrorHandler;
    }

    private StoreError getStoreError(Exception exc) {
        return exc instanceof NoSuchMethodException ? StoreError.NO_SUCH_METHOD : exc instanceof IllegalAccessException ? StoreError.ILLEGAL_ACCESS : exc instanceof JSONException ? StoreError.JSON_ERROR : exc instanceof InvocationTargetException ? StoreError.INVOCATION_TARGET : exc instanceof ClassNotFoundException ? StoreError.CLASS_NOT_FOUND : StoreError.UNKNOWN_ERROR;
    }

    private void sendErrorToWebView(StoreEvent storeEvent, StoreError storeError, int i10, Exception exc) {
        this._webViewErrorHandler.handleError((j) new StoreWebViewError(storeEvent, exc.getMessage(), Integer.valueOf(i10), storeError, exc.getMessage()));
    }

    public void handleStoreException(StoreEvent storeEvent, int i10, Exception exc) {
        sendErrorToWebView(storeEvent, getStoreError(exc), i10, exc);
    }
}
