package com.unity3d.services.banners.bridge;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.services.ads.operation.load.LoadBannerModule;
import com.unity3d.services.ads.operation.load.LoadBannerOperationState;
import com.unity3d.services.banners.BannerErrorCode;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.BannerViewCache;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.WebViewBridgeInvoker;

/* loaded from: classes2.dex */
public class BannerBridge {

    public enum BannerEvent {
        BANNER_VISIBILITY_CHANGED,
        BANNER_RESIZED,
        BANNER_LOADED,
        BANNER_DESTROYED,
        BANNER_ATTACHED,
        BANNER_DETACHED,
        BANNER_LOAD_PLACEMENT,
        BANNER_DESTROY_BANNER
    }

    public static void destroy(String str) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_DESTROY_BANNER, str);
        }
    }

    public static void didAttach(String str) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_ATTACHED, str);
        }
    }

    public static void didDestroy(String str) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_DESTROYED, str);
        }
    }

    public static void didDetach(String str) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_DETACHED, str);
        }
    }

    public static void didLoad(String str) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_LOADED, str);
        }
    }

    public static void load(String str, String str2, UnityBannerSize unityBannerSize) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_LOAD_PLACEMENT, str, str2, Integer.valueOf(unityBannerSize.getWidth()), Integer.valueOf(unityBannerSize.getHeight()));
            return;
        }
        BannerView bannerView = BannerViewCache.getInstance().getBannerView(str2);
        if (bannerView == null || bannerView.getListener() == null) {
            return;
        }
        bannerView.getListener().onBannerFailedToLoad(bannerView, new BannerErrorInfo("WebViewApp was not available, this is likely because UnityAds has not been initialized", BannerErrorCode.WEBVIEW_ERROR));
    }

    public static void resize(String str, int i10, int i11, int i12, int i13, float f10) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_RESIZED, str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Float.valueOf(f10));
        }
    }

    public static void visibilityChanged(String str, int i10) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_VISIBILITY_CHANGED, str, Integer.valueOf(i10));
        }
    }

    public static void load(String str, final String str2, UnityBannerSize unityBannerSize, UnityAdsLoadOptions unityAdsLoadOptions) {
        if (BannerViewCache.getInstance().getBannerView(str2) == null) {
            return;
        }
        LoadBannerModule.getInstance().executeAdOperation(new WebViewBridgeInvoker(), new LoadBannerOperationState(str, str2, unityBannerSize, new IUnityAdsLoadListener() { // from class: com.unity3d.services.banners.bridge.BannerBridge.1
            @Override // com.unity3d.ads.IUnityAdsLoadListener
            public void onUnityAdsFailedToLoad(String str3, UnityAds.UnityAdsLoadError unityAdsLoadError, String str4) {
                BannerView bannerView = BannerViewCache.getInstance().getBannerView(str2);
                if (bannerView == null || bannerView.getListener() == null) {
                    return;
                }
                bannerView.getListener().onBannerFailedToLoad(bannerView, BannerErrorInfo.fromLoadError(unityAdsLoadError, str4));
            }

            @Override // com.unity3d.ads.IUnityAdsLoadListener
            public void onUnityAdsAdLoaded(String str3) {
            }
        }, unityAdsLoadOptions, new ConfigurationReader().getCurrentConfiguration()));
    }
}
