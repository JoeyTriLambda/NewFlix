package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.request.metrics.AdOperationError;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import com.unity3d.services.core.timer.BaseTimer;
import com.unity3d.services.core.timer.ITimerListener;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class LoadModuleDecoratorTimeout extends LoadModuleDecorator {
    private static final String errorMsgTimeoutLoading = "[UnityAds] Timeout while loading ";

    public LoadModuleDecoratorTimeout(ILoadModule iLoadModule, ConfigurationReader configurationReader) {
        super(iLoadModule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOperationTimeout(LoadOperationState loadOperationState) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (loadOperationState != null) {
            getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(AdOperationError.timeout, Long.valueOf(loadOperationState.duration()), loadOperationState.isBanner()));
            remove(loadOperationState.f10705id);
            loadOperationState.onUnityAdsFailedToLoad(UnityAds.UnityAdsLoadError.TIMEOUT, errorMsgTimeoutLoading + loadOperationState.placementId);
        }
    }

    private void releaseOperationTimeoutLock(String str) {
        LoadOperationState loadOperationState;
        BaseTimer baseTimer;
        ILoadOperation iLoadOperation = get(str);
        if (iLoadOperation == null || (loadOperationState = iLoadOperation.getLoadOperationState()) == null || (baseTimer = loadOperationState.timeoutTimer) == null) {
            return;
        }
        baseTimer.kill();
    }

    private void startLoadTimeout(final LoadOperationState loadOperationState) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (loadOperationState == null) {
            return;
        }
        BaseTimer baseTimer = new BaseTimer(Integer.valueOf(loadOperationState.configuration.getLoadTimeout()), new ITimerListener() { // from class: com.unity3d.services.ads.operation.load.LoadModuleDecoratorTimeout.1
            @Override // com.unity3d.services.core.timer.ITimerListener
            public void onTimerFinished() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                LoadModuleDecoratorTimeout.this.onOperationTimeout(loadOperationState);
            }
        });
        loadOperationState.timeoutTimer = baseTimer;
        baseTimer.start(Executors.newSingleThreadScheduledExecutor());
    }

    @Override // com.unity3d.services.ads.operation.load.LoadModuleDecorator, com.unity3d.services.ads.operation.load.ILoadModule
    public void onUnityAdsAdLoaded(String str) {
        releaseOperationTimeoutLock(str);
        super.onUnityAdsAdLoaded(str);
    }

    @Override // com.unity3d.services.ads.operation.load.LoadModuleDecorator, com.unity3d.services.ads.operation.load.ILoadModule
    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        releaseOperationTimeoutLock(str);
        super.onUnityAdsFailedToLoad(str, unityAdsLoadError, str2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.unity3d.services.ads.operation.load.LoadModuleDecorator, com.unity3d.services.ads.operation.IAdModule
    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, LoadOperationState loadOperationState) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadStart());
        loadOperationState.start();
        startLoadTimeout(loadOperationState);
        super.executeAdOperation(iWebViewBridgeInvoker, loadOperationState);
    }
}
