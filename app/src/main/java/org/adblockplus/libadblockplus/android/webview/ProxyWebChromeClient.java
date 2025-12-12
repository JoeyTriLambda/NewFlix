package org.adblockplus.libadblockplus.android.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
class ProxyWebChromeClient extends WebChromeClient {
    private final AtomicReference<WebChromeClient> extWebChromeClient;

    public ProxyWebChromeClient(WebChromeClient webChromeClient) {
        this.extWebChromeClient = new AtomicReference<>(webChromeClient);
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        return webChromeClient != null ? webChromeClient.getDefaultVideoPoster() : super.getDefaultVideoPoster();
    }

    public WebChromeClient getExtWebChromeClient() {
        return this.extWebChromeClient.get();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        return webChromeClient != null ? webChromeClient.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.getVisitedHistory(valueCallback);
        } else {
            super.getVisitedHistory(valueCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onCloseWindow(webView);
        } else {
            super.onCloseWindow(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i10, String str2) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onConsoleMessage(str, i10, str2);
        } else {
            super.onConsoleMessage(str, i10, str2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        return webChromeClient != null ? webChromeClient.onCreateWindow(webView, z10, z11, message) : super.onCreateWindow(webView, z10, z11, message);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j10, long j11, long j12, WebStorage.QuotaUpdater quotaUpdater) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onExceededDatabaseQuota(str, str2, j10, j11, j12, quotaUpdater);
        } else {
            super.onExceededDatabaseQuota(str, str2, j10, j11, j12, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onGeolocationPermissionsHidePrompt();
        } else {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        return webChromeClient != null ? webChromeClient.onJsAlert(webView, str, str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        return webChromeClient != null ? webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        return webChromeClient != null ? webChromeClient.onJsConfirm(webView, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        return webChromeClient != null ? webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult) : super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        return webChromeClient != null ? webChromeClient.onJsTimeout() : super.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onPermissionRequest(permissionRequest);
        } else {
            super.onPermissionRequest(permissionRequest);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onPermissionRequestCanceled(permissionRequest);
        } else {
            super.onPermissionRequestCanceled(permissionRequest);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i10) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onProgressChanged(webView, i10);
        } else {
            super.onProgressChanged(webView, i10);
        }
    }

    public void onReachedMaxAppCacheSize(long j10, long j11, WebStorage.QuotaUpdater quotaUpdater) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onReachedMaxAppCacheSize(j10, j11, quotaUpdater);
        } else {
            super.onReachedMaxAppCacheSize(j10, j11, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onReceivedIcon(webView, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onReceivedTitle(webView, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z10) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onReceivedTouchIconUrl(webView, str, z10);
        } else {
            super.onReceivedTouchIconUrl(webView, str, z10);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onRequestFocus(webView);
        } else {
            super.onRequestFocus(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view, customViewCallback);
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        return webChromeClient != null ? webChromeClient.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }

    public void setExtWebChromeClient(WebChromeClient webChromeClient) {
        this.extWebChromeClient.set(webChromeClient);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            return webChromeClient.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i10, WebChromeClient.CustomViewCallback customViewCallback) {
        WebChromeClient webChromeClient = this.extWebChromeClient.get();
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view, i10, customViewCallback);
        } else {
            super.onShowCustomView(view, i10, customViewCallback);
        }
    }
}
