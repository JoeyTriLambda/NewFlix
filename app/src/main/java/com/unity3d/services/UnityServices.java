package com.unity3d.services;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.configuration.EnvironmentCheck;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.properties.Session;
import com.unity3d.services.core.request.metrics.InitMetric;
import ig.k;
import zf.i;

/* compiled from: UnityServices.kt */
/* loaded from: classes2.dex */
public final class UnityServices {
    public static final UnityServices INSTANCE = new UnityServices();
    private static final boolean isSupported = true;

    /* compiled from: UnityServices.kt */
    public enum UnityServicesError {
        INVALID_ARGUMENT,
        INIT_SANITY_CHECK_FAIL
    }

    /* compiled from: UnityServices.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SdkProperties.InitializationState.values().length];
            try {
                iArr[SdkProperties.InitializationState.INITIALIZED_SUCCESSFULLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SdkProperties.InitializationState.INITIALIZED_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SdkProperties.InitializationState.INITIALIZING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private UnityServices() {
    }

    private final String createExpectedParametersString(String str, Object obj, Object obj2) {
        return "- " + str + " Current: " + obj + " | Received: " + obj2;
    }

    public static final boolean getDebugMode() {
        return SdkProperties.getDebugMode();
    }

    public static final String getVersion() {
        String versionName = SdkProperties.getVersionName();
        i.checkNotNullExpressionValue(versionName, "getVersionName()");
        return versionName;
    }

    public static final void initialize(Context context, String str, boolean z10, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        Integer intOrNull;
        String str2;
        DeviceLog.entered();
        if (str == null || (intOrNull = k.toIntOrNull(str)) == null) {
            if (iUnityAdsInitializationListener != null) {
                iUnityAdsInitializationListener.onInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "gameId \"" + str + "\" should be a number.");
                return;
            }
            return;
        }
        intOrNull.intValue();
        if (SdkProperties.getCurrentInitializationState() != SdkProperties.InitializationState.NOT_INITIALIZED) {
            String gameId = ClientProperties.getGameId();
            boolean zIsTestMode = SdkProperties.isTestMode();
            StringBuilder sb2 = new StringBuilder();
            if (gameId != null && !i.areEqual(gameId, str)) {
                sb2.append(INSTANCE.createExpectedParametersString("Game ID", gameId, str));
                i.checkNotNullExpressionValue(sb2, "append(value)");
                sb2.append('\n');
                i.checkNotNullExpressionValue(sb2, "append('\\n')");
            }
            if (zIsTestMode != z10) {
                sb2.append(INSTANCE.createExpectedParametersString("Test Mode", Boolean.valueOf(zIsTestMode), Boolean.valueOf(z10)));
                i.checkNotNullExpressionValue(sb2, "append(value)");
                sb2.append('\n');
                i.checkNotNullExpressionValue(sb2, "append('\\n')");
            }
            String string = sb2.toString();
            i.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            if (string.length() > 0) {
                InitializeEventsMetricSender.getInstance().sendMetric(InitMetric.newInitDiffParams());
                str2 = "different parameters: \n" + string;
            } else {
                InitializeEventsMetricSender.getInstance().sendMetric(InitMetric.newInitSameParams());
                str2 = "the same Game ID: " + str + " and Test Mode: " + z10 + " values.";
            }
            DeviceLog.warning("Unity Ads SDK initialize has already been called with " + str2 + " Responding with first initialization result.");
        }
        SdkProperties.addInitializationListener(iUnityAdsInitializationListener);
        SdkProperties.InitializationState currentInitializationState = SdkProperties.getCurrentInitializationState();
        int i10 = currentInitializationState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[currentInitializationState.ordinal()];
        if (i10 == 1) {
            SdkProperties.notifyInitializationComplete();
            return;
        }
        if (i10 == 2) {
            SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to previous failed reason");
            return;
        }
        if (i10 != 3) {
            SdkProperties.setInitializeState(SdkProperties.InitializationState.INITIALIZING);
            ClientProperties.setGameId(str);
            SdkProperties.setTestMode(z10);
            if (!isSupported) {
                DeviceLog.error("Error while initializing Unity Services: device is not supported");
                SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to device is not supported");
                return;
            }
            SdkProperties.setInitializationTime(Device.getElapsedRealtime());
            SdkProperties.setInitializationTimeSinceEpoch(System.currentTimeMillis());
            if (str.length() == 0) {
                DeviceLog.error("Error while initializing Unity Services: empty game ID, halting Unity Ads init");
                SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to empty game ID");
                return;
            }
            if (context == null) {
                DeviceLog.error("Error while initializing Unity Services: null context, halting Unity Ads init");
                SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to null context");
                return;
            }
            if (context instanceof Application) {
                ClientProperties.setApplication((Application) context);
            } else {
                if (!(context instanceof Activity)) {
                    DeviceLog.error("Error while initializing Unity Services: invalid context, halting Unity Ads init");
                    SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to invalid context");
                    return;
                }
                Activity activity = (Activity) context;
                if (activity.getApplication() == null) {
                    DeviceLog.error("Error while initializing Unity Services: cannot retrieve application from context, halting Unity Ads init");
                    SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to inability to retrieve application from context");
                    return;
                }
                ClientProperties.setApplication(activity.getApplication());
            }
            DeviceLog.info("Initializing Unity Services " + SdkProperties.getVersionName() + " (" + SdkProperties.getVersionCode() + ") with game id " + str + " in " + (z10 ? "test mode" : "production mode") + ", session " + Session.Default.getId());
            SdkProperties.setDebugMode(SdkProperties.getDebugMode());
            if (context.getApplicationContext() == null) {
                DeviceLog.error("Error while initializing Unity Services: cannot retrieve application context, halting Unity Ads init");
                SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to inability to retrieve application context");
                return;
            }
            ClientProperties.setApplicationContext(context.getApplicationContext());
            if (EnvironmentCheck.isEnvironmentOk()) {
                DeviceLog.info("Unity Services environment check OK");
                UnityAdsSDK.INSTANCE.initialize();
            } else {
                DeviceLog.error("Error during Unity Services environment check, halting Unity Services init");
                SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to environment check failed");
            }
        }
    }

    public static final boolean isInitialized() {
        return SdkProperties.isInitialized();
    }

    public static final boolean isSupported() {
        return isSupported;
    }

    public static final void setDebugMode(boolean z10) {
        SdkProperties.setDebugMode(z10);
    }

    public static /* synthetic */ void getDebugMode$annotations() {
    }

    public static /* synthetic */ void getVersion$annotations() {
    }

    public static /* synthetic */ void isInitialized$annotations() {
    }

    public static /* synthetic */ void isSupported$annotations() {
    }
}
