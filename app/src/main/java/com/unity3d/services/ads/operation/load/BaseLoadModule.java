package com.unity3d.services.ads.operation.load;

import android.text.TextUtils;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.AdModule;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.AdOperationError;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.CallbackStatus;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback;
import com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocation;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class BaseLoadModule extends AdModule<ILoadOperation, LoadOperationState> implements ILoadModule {
    static final String errorMsgFailedToCreateLoadRequest = "[UnityAds] Failed to create load request";
    static final String errorMsgInternalCommunicationFailure = "[UnityAds] Internal communication failure";
    static final String errorMsgInternalCommunicationTimeout = "[UnityAds] Internal communication timeout";
    static final String errorMsgPlacementIdNull = "[UnityAds] Placement ID cannot be null";

    public BaseLoadModule(SDKMetricsSender sDKMetricsSender) {
        super(sDKMetricsSender);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOnUnityAdsFailedToLoad(final LoadOperationState loadOperationState, final UnityAds.UnityAdsLoadError unityAdsLoadError, final String str, boolean z10) {
        if (loadOperationState == null || loadOperationState.listener == null) {
            return;
        }
        if (z10) {
            getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(unityAdsLoadError, Long.valueOf(loadOperationState.duration()), loadOperationState.isBanner()));
        }
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.operation.load.BaseLoadModule.2
            @Override // java.lang.Runnable
            public void run() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                loadOperationState.onUnityAdsFailedToLoad(unityAdsLoadError, str);
            }
        });
    }

    public abstract void addOptionalParameters(LoadOperationState loadOperationState, JSONObject jSONObject) throws JSONException;

    public JSONObject buildBaseOptions(LoadOperationState loadOperationState) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("headerBiddingOptions", loadOperationState.loadOptions.getData());
        return jSONObject;
    }

    public JSONObject buildBaseParameters(LoadOperationState loadOperationState, LoadOperation loadOperation) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectBuildBaseOptions = buildBaseOptions(loadOperationState);
        jSONObjectBuildBaseOptions.put("headerBiddingOptions", loadOperationState.loadOptions.getData());
        jSONObject.put("options", jSONObjectBuildBaseOptions);
        jSONObject.put("listenerId", loadOperation.getId());
        jSONObject.put("placementId", loadOperationState.placementId);
        jSONObject.put("time", Device.getElapsedRealtime());
        addOptionalParameters(loadOperationState, jSONObject);
        return jSONObject;
    }

    @Override // com.unity3d.services.ads.operation.load.ILoadModule
    public void onUnityAdsAdLoaded(String str) {
        ILoadOperation iLoadOperation = (ILoadOperation) get(str);
        if (iLoadOperation == null || iLoadOperation.getLoadOperationState() == null) {
            return;
        }
        LoadOperationState loadOperationState = iLoadOperation.getLoadOperationState();
        getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadSuccess(Long.valueOf(loadOperationState.duration()), loadOperationState.isBanner()));
        iLoadOperation.onUnityAdsAdLoaded(loadOperationState.placementId);
        remove(str);
    }

    @Override // com.unity3d.services.ads.operation.load.ILoadModule
    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        ILoadOperation iLoadOperation = (ILoadOperation) get(str);
        if (iLoadOperation == null || iLoadOperation.getLoadOperationState() == null) {
            return;
        }
        LoadOperationState loadOperationState = iLoadOperation.getLoadOperationState();
        getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(unityAdsLoadError, Long.valueOf(loadOperationState.duration()), loadOperationState.isBanner()));
        iLoadOperation.onUnityAdsFailedToLoad(loadOperationState.placementId, unityAdsLoadError, str2);
        remove(str);
    }

    @Override // com.unity3d.services.ads.operation.IAdModule
    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, final LoadOperationState loadOperationState) {
        if (TextUtils.isEmpty(loadOperationState.placementId)) {
            sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INVALID_ARGUMENT, errorMsgPlacementIdNull, true);
            return;
        }
        LoadOperation loadOperation = new LoadOperation(loadOperationState, new WebViewBridgeInvocation(this._executorService, iWebViewBridgeInvoker, new IWebViewBridgeInvocationCallback() { // from class: com.unity3d.services.ads.operation.load.BaseLoadModule.1
            @Override // com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback
            public void onFailure(String str, CallbackStatus callbackStatus) {
                BaseLoadModule.this.getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(AdOperationError.callback_error, Long.valueOf(loadOperationState.duration()), loadOperationState.isBanner()));
                BaseLoadModule.this.sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INTERNAL_ERROR, BaseLoadModule.errorMsgInternalCommunicationFailure, false);
                BaseLoadModule.this.remove(loadOperationState.getId());
            }

            @Override // com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback
            public void onTimeout() {
                BaseLoadModule.this.getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(AdOperationError.callback_timeout, Long.valueOf(loadOperationState.duration()), loadOperationState.isBanner()));
                BaseLoadModule.this.sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INTERNAL_ERROR, BaseLoadModule.errorMsgInternalCommunicationTimeout, false);
                BaseLoadModule.this.remove(loadOperationState.getId());
            }

            @Override // com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback
            public void onSuccess() {
            }
        }));
        try {
            JSONObject jSONObjectBuildBaseParameters = buildBaseParameters(loadOperationState, loadOperation);
            set(loadOperation);
            loadOperation.invoke(loadOperationState.configuration.getWebViewBridgeTimeout(), jSONObjectBuildBaseParameters);
        } catch (NullPointerException | JSONException unused) {
            sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INTERNAL_ERROR, errorMsgFailedToCreateLoadRequest, true);
        }
    }
}
