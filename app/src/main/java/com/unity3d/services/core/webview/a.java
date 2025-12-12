package com.unity3d.services.core.webview;

import android.net.Uri;
import com.unity3d.services.core.webview.bridge.WebViewBridgeInterface;
import u2.c;
import u2.e;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements e.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10708a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebViewBridgeInterface f10709b;

    public /* synthetic */ a(WebViewBridgeInterface webViewBridgeInterface, int i10) {
        this.f10708a = i10;
        this.f10709b = webViewBridgeInterface;
    }

    public final void a(android.webkit.WebView webView, c cVar, Uri uri, boolean z10, u2.a aVar) {
        switch (this.f10708a) {
            case 0:
                this.f10709b.onHandleInvocation(webView, cVar, uri, z10, aVar);
                break;
            default:
                this.f10709b.onHandleCallback(webView, cVar, uri, z10, aVar);
                break;
        }
    }
}
