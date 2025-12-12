package com.unity3d.ads;

import android.app.Activity;
import android.content.Context;
import com.unity3d.services.ads.UnityAdsImplementation;

/* loaded from: classes2.dex */
public final class UnityAds {

    public enum UnityAdsInitializationError {
        INTERNAL_ERROR,
        INVALID_ARGUMENT,
        AD_BLOCKER_DETECTED
    }

    public enum UnityAdsLoadError {
        INITIALIZE_FAILED,
        INTERNAL_ERROR,
        INVALID_ARGUMENT,
        NO_FILL,
        TIMEOUT
    }

    public enum UnityAdsShowCompletionState {
        SKIPPED,
        COMPLETED
    }

    public enum UnityAdsShowError {
        NOT_INITIALIZED,
        NOT_READY,
        VIDEO_PLAYER_ERROR,
        INVALID_ARGUMENT,
        NO_CONNECTION,
        ALREADY_SHOWING,
        INTERNAL_ERROR,
        TIMEOUT
    }

    public static boolean getDebugMode() {
        return UnityAdsImplementation.getInstance().getDebugMode();
    }

    public static String getToken() {
        return UnityAdsImplementation.getInstance().getToken();
    }

    public static String getVersion() {
        return UnityAdsImplementation.getInstance().getVersion();
    }

    public static void initialize(Context context, String str) {
        UnityAdsImplementation.getInstance().initialize(context, str, false, null);
    }

    public static boolean isInitialized() {
        return UnityAdsImplementation.getInstance().isInitialized();
    }

    public static boolean isSupported() {
        return UnityAdsImplementation.getInstance().isSupported();
    }

    @Deprecated
    public static void load(String str) {
        load(str, new IUnityAdsLoadListener() { // from class: com.unity3d.ads.UnityAds.1
            @Override // com.unity3d.ads.IUnityAdsLoadListener
            public void onUnityAdsAdLoaded(String str2) {
            }

            @Override // com.unity3d.ads.IUnityAdsLoadListener
            public void onUnityAdsFailedToLoad(String str2, UnityAdsLoadError unityAdsLoadError, String str3) {
            }
        });
    }

    public static void setDebugMode(boolean z10) {
        UnityAdsImplementation.getInstance().setDebugMode(z10);
    }

    @Deprecated
    public static void show(Activity activity, String str) {
        UnityAdsImplementation.getInstance().show(activity, str, new UnityAdsShowOptions(), null);
    }

    public static void getToken(IUnityAdsTokenListener iUnityAdsTokenListener) {
        UnityAdsImplementation.getInstance().getToken(iUnityAdsTokenListener);
    }

    public static void initialize(Context context, String str, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        UnityAdsImplementation.getInstance().initialize(context, str, false, iUnityAdsInitializationListener);
    }

    public static void load(String str, IUnityAdsLoadListener iUnityAdsLoadListener) {
        UnityAdsImplementation.getInstance().load(str, new UnityAdsLoadOptions(), iUnityAdsLoadListener);
    }

    public static void show(Activity activity, String str, IUnityAdsShowListener iUnityAdsShowListener) {
        UnityAdsImplementation.getInstance().show(activity, str, new UnityAdsShowOptions(), iUnityAdsShowListener);
    }

    public static void initialize(Context context, String str, boolean z10) {
        UnityAdsImplementation.getInstance().initialize(context, str, z10, null);
    }

    public static void load(String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener) {
        UnityAdsImplementation.getInstance().load(str, unityAdsLoadOptions, iUnityAdsLoadListener);
    }

    @Deprecated
    public static void show(Activity activity, String str, UnityAdsShowOptions unityAdsShowOptions) {
        UnityAdsImplementation.getInstance().show(activity, str, unityAdsShowOptions, null);
    }

    public static void initialize(Context context, String str, boolean z10, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        UnityAdsImplementation.getInstance().initialize(context, str, z10, iUnityAdsInitializationListener);
    }

    public static void show(Activity activity, String str, UnityAdsShowOptions unityAdsShowOptions, IUnityAdsShowListener iUnityAdsShowListener) {
        UnityAdsImplementation.getInstance().show(activity, str, unityAdsShowOptions, iUnityAdsShowListener);
    }
}
