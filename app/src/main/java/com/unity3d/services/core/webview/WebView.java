package com.unity3d.services.core.webview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import androidx.emoji2.text.g;
import com.unity3d.services.core.configuration.Experiments;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.IInvocationCallbackInvoker;
import com.unity3d.services.core.webview.bridge.IWebViewBridge;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import com.unity3d.services.core.webview.bridge.WebViewBridgeInterface;
import java.lang.reflect.InvocationTargetException;
import kotlin.LazyThreadSafetyMode;
import lf.e;
import mf.y;
import zf.f;
import zf.i;
import zf.k;

/* compiled from: WebView.kt */
/* loaded from: classes2.dex */
public class WebView extends android.webkit.WebView implements IServiceComponent {
    private final e sdkMetricsSender$delegate;
    private final WebViewBridgeInterface webViewBridgeInterface;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context) {
        this(context, false, null, null, null, 30, null);
        i.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void evaluateJavascript$lambda$1(WebView webView, String str, ValueCallback valueCallback) {
        i.checkNotNullParameter(webView, "this$0");
        i.checkNotNullParameter(str, "$script");
        super.evaluateJavascript(str, valueCallback);
    }

    private final SDKMetricsSender getSdkMetricsSender() {
        return (SDKMetricsSender) this.sdkMetricsSender$delegate.getValue();
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        i.checkNotNullParameter(str, "script");
        Utilities.runOnUiThread(new g(6, this, str, valueCallback));
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        i.checkNotNullParameter(str, "url");
        DeviceLog.debug("Loading url: " + str);
        super.loadUrl(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z10) {
        this(context, z10, null, null, null, 28, null);
        i.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z10, IWebViewBridge iWebViewBridge) {
        this(context, z10, iWebViewBridge, null, null, 24, null);
        i.checkNotNullParameter(context, "context");
        i.checkNotNullParameter(iWebViewBridge, "webViewBridge");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z10, IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker) {
        this(context, z10, iWebViewBridge, iInvocationCallbackInvoker, null, 16, null);
        i.checkNotNullParameter(context, "context");
        i.checkNotNullParameter(iWebViewBridge, "webViewBridge");
        i.checkNotNullParameter(iInvocationCallbackInvoker, "callbackInvoker");
    }

    public /* synthetic */ WebView(Context context, boolean z10, IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, IExperiments iExperiments, int i10, f fVar) {
        this(context, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? SharedInstances.INSTANCE.getWebViewBridge() : iWebViewBridge, (i10 & 8) != 0 ? SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker() : iInvocationCallbackInvoker, (i10 & 16) != 0 ? new Experiments() : iExperiments);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z10, IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, IExperiments iExperiments) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super(context);
        i.checkNotNullParameter(context, "context");
        i.checkNotNullParameter(iWebViewBridge, "webViewBridge");
        i.checkNotNullParameter(iInvocationCallbackInvoker, "callbackInvoker");
        i.checkNotNullParameter(iExperiments, "experiments");
        final String str = "";
        this.sdkMetricsSender$delegate = kotlin.a.lazy(LazyThreadSafetyMode.NONE, new yf.a<SDKMetricsSender>() { // from class: com.unity3d.services.core.webview.WebView$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.services.core.request.metrics.SDKMetricsSender, java.lang.Object] */
            @Override // yf.a
            public final SDKMetricsSender invoke() {
                IServiceComponent iServiceComponent = this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, k.getOrCreateKotlinClass(SDKMetricsSender.class));
            }
        });
        WebViewBridgeInterface webViewBridgeInterface = new WebViewBridgeInterface(iWebViewBridge, iInvocationCallbackInvoker);
        this.webViewBridgeInterface = webViewBridgeInterface;
        WebSettings settings = getSettings();
        int i10 = 1;
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowFileAccess(true);
        int i11 = 0;
        settings.setBlockNetworkImage(false);
        settings.setBlockNetworkLoads(false);
        settings.setBuiltInZoomControls(false);
        settings.setCacheMode(2);
        settings.setDatabaseEnabled(false);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(false);
        settings.setEnableSmoothTransition(false);
        settings.setGeolocationEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setJavaScriptEnabled(true);
        settings.setLightTouchEnabled(false);
        settings.setLoadWithOverviewMode(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(1);
        settings.setNeedInitialFocus(true);
        settings.setPluginState(WebSettings.PluginState.OFF);
        settings.setRenderPriority(WebSettings.RenderPriority.NORMAL);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(false);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(true);
        settings.setMediaPlaybackRequiresUserGesture(!z10);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setInitialScale(0);
        setBackgroundColor(0);
        ViewUtilities.setBackground(this, new ColorDrawable(0));
        setBackgroundResource(0);
        boolean zIsWebMessageEnabled = iExperiments.isWebMessageEnabled();
        if (zIsWebMessageEnabled) {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerEnabledMetric());
        } else {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerDisabledMetric());
        }
        boolean zIsFeatureSupported = u2.f.isFeatureSupported("WEB_MESSAGE_LISTENER");
        if (zIsFeatureSupported) {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerSupportedMetric());
        } else {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerUnsupportedMetric());
        }
        if (zIsWebMessageEnabled && zIsFeatureSupported) {
            u2.e.addWebMessageListener(this, "handleInvocation", y.setOf("*"), new a(webViewBridgeInterface, i11));
            u2.e.addWebMessageListener(this, "handleCallback", y.setOf("*"), new a(webViewBridgeInterface, i10));
        } else {
            addJavascriptInterface(webViewBridgeInterface, "webviewbridge");
        }
    }
}
