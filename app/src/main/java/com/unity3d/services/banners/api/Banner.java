package com.unity3d.services.banners.api;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.load.ILoadOperation;
import com.unity3d.services.ads.operation.load.LoadBannerModule;
import com.unity3d.services.ads.operation.load.LoadBannerOperationState;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.banners.properties.BannerRefreshInfo;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class Banner {

    /* renamed from: com.unity3d.services.banners.api.Banner$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$banners$api$Banner$BannerViewType;

        static {
            int[] iArr = new int[BannerViewType.values().length];
            $SwitchMap$com$unity3d$services$banners$api$Banner$BannerViewType = iArr;
            try {
                iArr[BannerViewType.WEB_PLAYER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$services$banners$api$Banner$BannerViewType[BannerViewType.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum BannerViewType {
        WEB_PLAYER,
        UNKNOWN;

        public static BannerViewType fromString(String str) {
            try {
                return valueOf(str);
            } catch (IllegalArgumentException unused) {
                return UNKNOWN;
            }
        }
    }

    @WebViewExposed
    public static void load(String str, Integer num, Integer num2, String str2, WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i10 = AnonymousClass1.$SwitchMap$com$unity3d$services$banners$api$Banner$BannerViewType[BannerViewType.fromString(str).ordinal()];
        if (i10 == 1) {
            Object obj = (ILoadOperation) LoadBannerModule.getInstance().get(str2);
            if (obj instanceof LoadBannerOperationState) {
                ((LoadBannerOperationState) obj).setSize(new UnityBannerSize(num.intValue(), num2.intValue()));
            }
            LoadBannerModule.getInstance().onUnityAdsAdLoaded(str2);
        } else if (i10 == 2) {
            LoadBannerModule.getInstance().onUnityAdsFailedToLoad(str2, UnityAds.UnityAdsLoadError.INTERNAL_ERROR, "Unknown banner type");
        }
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void setRefreshRate(String str, Integer num, WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (str != null && num != null) {
            BannerRefreshInfo.getInstance().setRefreshRate(str, num);
        }
        webViewCallback.invoke(new Object[0]);
    }
}
