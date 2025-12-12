package com.unity3d.services.ads;

import android.app.Activity;
import android.content.Context;
import androidx.activity.d;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.UnityServices;
import com.unity3d.services.ads.gmascar.managers.BiddingBaseManager;
import com.unity3d.services.ads.gmascar.managers.BiddingManagerFactory;
import com.unity3d.services.ads.operation.load.LoadModule;
import com.unity3d.services.ads.operation.load.LoadOperationState;
import com.unity3d.services.ads.operation.show.ShowModule;
import com.unity3d.services.ads.operation.show.ShowOperationState;
import com.unity3d.services.ads.token.AsyncTokenStorage;
import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.bridge.WebViewBridgeInvoker;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class UnityAdsImplementation implements IUnityAds {
    private static Configuration configuration;
    private static IUnityAds instance;
    private static WebViewBridgeInvoker webViewBridgeInvoker = new WebViewBridgeInvoker();
    private final TokenStorage tokenStorage = (TokenStorage) Utilities.getService(TokenStorage.class);
    private final AsyncTokenStorage asyncTokenStorage = (AsyncTokenStorage) Utilities.getService(AsyncTokenStorage.class);
    private final SDKMetricsSender sdkMetricsSender = (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);

    public static IUnityAds getInstance() {
        if (instance == null) {
            instance = new UnityAdsImplementation();
        }
        return instance;
    }

    private void handleShowError(IUnityAdsShowListener iUnityAdsShowListener, String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
        this.sdkMetricsSender.sendMetricWithInitState(AdOperationMetric.newAdShowFailure(unityAdsShowError, (Long) 0L));
        if (iUnityAdsShowListener == null) {
            return;
        }
        iUnityAdsShowListener.onUnityAdsShowFailure(str, unityAdsShowError, str2);
    }

    public static void setConfiguration(Configuration configuration2) {
        configuration = configuration2;
    }

    @Override // com.unity3d.services.ads.IUnityAds
    public boolean getDebugMode() {
        return UnityServices.getDebugMode();
    }

    @Override // com.unity3d.services.ads.IUnityAds
    public String getToken() {
        String token = this.tokenStorage.getToken();
        if (token == null || token.isEmpty()) {
            return null;
        }
        Configuration currentConfiguration = configuration;
        if (currentConfiguration == null) {
            currentConfiguration = new ConfigurationReader().getCurrentConfiguration();
        }
        BiddingBaseManager biddingBaseManagerCreateManager = BiddingManagerFactory.getInstance().createManager(null, currentConfiguration.getExperiments());
        biddingBaseManagerCreateManager.start();
        return biddingBaseManagerCreateManager.getFormattedToken(token);
    }

    @Override // com.unity3d.services.ads.IUnityAds
    public String getVersion() {
        return UnityServices.getVersion();
    }

    @Override // com.unity3d.services.ads.IUnityAds
    public void initialize(Context context, String str, boolean z10, IUnityAdsInitializationListener iUnityAdsInitializationListener) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        DeviceLog.entered();
        UnityServices.initialize(context, str, z10, iUnityAdsInitializationListener);
    }

    @Override // com.unity3d.services.ads.IUnityAds
    public boolean isInitialized() {
        return UnityServices.isInitialized();
    }

    @Override // com.unity3d.services.ads.IUnityAds
    public boolean isSupported() {
        return UnityServices.isSupported();
    }

    @Override // com.unity3d.services.ads.IUnityAds
    public void load(String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener) {
        Configuration configuration2 = configuration;
        if (configuration2 == null) {
            configuration2 = new Configuration();
        }
        LoadModule.getInstance().executeAdOperation(webViewBridgeInvoker, new LoadOperationState(str, iUnityAdsLoadListener, unityAdsLoadOptions, configuration2));
    }

    @Override // com.unity3d.services.ads.IUnityAds
    public void setDebugMode(boolean z10) {
        UnityServices.setDebugMode(z10);
    }

    public void show(Activity activity, String str) {
        show(activity, str, new UnityAdsShowOptions(), null);
    }

    public void show(Activity activity, String str, IUnityAdsShowListener iUnityAdsShowListener) {
        show(activity, str, new UnityAdsShowOptions(), iUnityAdsShowListener);
    }

    @Override // com.unity3d.services.ads.IUnityAds
    public void show(Activity activity, String str, UnityAdsShowOptions unityAdsShowOptions, IUnityAdsShowListener iUnityAdsShowListener) {
        if (!isSupported()) {
            handleShowError(iUnityAdsShowListener, str, UnityAds.UnityAdsShowError.NOT_INITIALIZED, "Unity Ads is not supported for this device");
            return;
        }
        if (!isInitialized()) {
            handleShowError(iUnityAdsShowListener, str, UnityAds.UnityAdsShowError.NOT_INITIALIZED, "Unity Ads is not initialized");
            return;
        }
        if (activity == null) {
            handleShowError(iUnityAdsShowListener, str, UnityAds.UnityAdsShowError.INVALID_ARGUMENT, "Activity must not be null");
            return;
        }
        Configuration configuration2 = configuration;
        if (configuration2 == null) {
            configuration2 = new Configuration();
        }
        ClientProperties.setActivity(activity);
        ShowModule.getInstance().executeAdOperation(WebViewApp.getCurrentApp(), new ShowOperationState(str, iUnityAdsShowListener, activity, unityAdsShowOptions, configuration2));
    }

    @Override // com.unity3d.services.ads.IUnityAds
    public void getToken(IUnityAdsTokenListener iUnityAdsTokenListener) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (iUnityAdsTokenListener == null) {
            DeviceLog.info("Please provide non-null listener to UnityAds.GetToken method");
            return;
        }
        if (ClientProperties.getApplicationContext() == null) {
            Utilities.wrapCustomerListener(new d(iUnityAdsTokenListener, 21));
            return;
        }
        Configuration currentConfiguration = configuration;
        if (currentConfiguration == null) {
            currentConfiguration = new ConfigurationReader().getCurrentConfiguration();
        }
        BiddingBaseManager biddingBaseManagerCreateManager = BiddingManagerFactory.getInstance().createManager(iUnityAdsTokenListener, currentConfiguration.getExperiments());
        biddingBaseManagerCreateManager.start();
        this.asyncTokenStorage.getToken(biddingBaseManagerCreateManager);
    }
}
