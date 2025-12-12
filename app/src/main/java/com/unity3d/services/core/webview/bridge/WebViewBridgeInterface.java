package com.unity3d.services.core.webview.bridge;

import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.unity3d.services.core.log.DeviceLog;
import cz.msebera.android.httpclient.message.TokenParser;
import fg.c;
import fg.h;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import mf.l;
import mf.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u2.a;
import zf.f;
import zf.i;

/* compiled from: WebViewBridgeInterface.kt */
/* loaded from: classes2.dex */
public final class WebViewBridgeInterface {
    private final IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker;
    private final IWebViewBridge webViewBridge;

    public WebViewBridgeInterface() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final Object[] toTypedArray(JSONArray jSONArray) {
        c cVarUntil = h.until(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(l.collectionSizeOrDefault(cVarUntil, 10));
        Iterator<Integer> it = cVarUntil.iterator();
        while (it.hasNext()) {
            arrayList.add(jSONArray.get(((t) it).nextInt()));
        }
        return arrayList.toArray(new Object[0]);
    }

    @JavascriptInterface
    public final void handleCallback(String str, String str2, String str3) throws Exception {
        i.checkNotNullParameter(str, "callbackId");
        i.checkNotNullParameter(str2, "callbackStatus");
        i.checkNotNullParameter(str3, "rawParameters");
        DeviceLog.debug("handleCallback " + str + TokenParser.SP + str2 + TokenParser.SP + str3);
        this.webViewBridge.handleCallback(str, str2, toTypedArray(new JSONArray(str3)));
    }

    @JavascriptInterface
    public final void handleInvocation(String str) throws IllegalAccessException, JSONException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(str, JsonStorageKeyNames.DATA_KEY);
        DeviceLog.debug("handleInvocation " + str);
        JSONArray jSONArray = new JSONArray(str);
        Invocation invocation = new Invocation(this.webViewAppInvocationCallbackInvoker, this.webViewBridge);
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = jSONArray.get(i10);
            i.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray2 = (JSONArray) obj;
            Object obj2 = jSONArray2.get(0);
            i.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = jSONArray2.get(1);
            i.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            Object obj4 = jSONArray2.get(2);
            i.checkNotNull(obj4, "null cannot be cast to non-null type org.json.JSONArray");
            Object obj5 = jSONArray2.get(3);
            i.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
            invocation.addInvocation((String) obj2, (String) obj3, toTypedArray((JSONArray) obj4), new WebViewCallback((String) obj5, invocation.getId()));
            invocation.nextInvocation();
        }
        invocation.sendInvocationCallback();
    }

    public final void onHandleCallback(WebView webView, u2.c cVar, Uri uri, boolean z10, a aVar) {
        i.checkNotNullParameter(webView, "view");
        i.checkNotNullParameter(cVar, "message");
        i.checkNotNullParameter(uri, "sourceOrigin");
        i.checkNotNullParameter(aVar, "replyProxy");
        String data = cVar.getData();
        if (z10) {
            if (data == null || ig.l.isBlank(data)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(data);
            String string = jSONObject.getString("id");
            String string2 = jSONObject.getString("status");
            String string3 = jSONObject.getString("parameters");
            i.checkNotNullExpressionValue(string, "callbackId");
            i.checkNotNullExpressionValue(string2, "callbackStatus");
            i.checkNotNullExpressionValue(string3, "rawParameters");
            handleCallback(string, string2, string3);
        }
    }

    public final void onHandleInvocation(WebView webView, u2.c cVar, Uri uri, boolean z10, a aVar) {
        i.checkNotNullParameter(webView, "view");
        i.checkNotNullParameter(cVar, "message");
        i.checkNotNullParameter(uri, "sourceOrigin");
        i.checkNotNullParameter(aVar, "replyProxy");
        String data = cVar.getData();
        if (z10) {
            if (data == null || ig.l.isBlank(data)) {
                return;
            }
            handleInvocation(data);
        }
    }

    public WebViewBridgeInterface(IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker) {
        i.checkNotNullParameter(iWebViewBridge, "webViewBridge");
        i.checkNotNullParameter(iInvocationCallbackInvoker, "webViewAppInvocationCallbackInvoker");
        this.webViewBridge = iWebViewBridge;
        this.webViewAppInvocationCallbackInvoker = iInvocationCallbackInvoker;
    }

    public /* synthetic */ WebViewBridgeInterface(IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, int i10, f fVar) {
        this((i10 & 1) != 0 ? SharedInstances.INSTANCE.getWebViewBridge() : iWebViewBridge, (i10 & 2) != 0 ? SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker() : iInvocationCallbackInvoker);
    }
}
