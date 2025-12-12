package com.unity3d.services.banners;

import com.unity3d.ads.UnityAds;

/* loaded from: classes2.dex */
public class BannerErrorInfo {
    public BannerErrorCode errorCode;
    public String errorMessage;

    /* renamed from: com.unity3d.services.banners.BannerErrorInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError;

        static {
            int[] iArr = new int[UnityAds.UnityAdsLoadError.values().length];
            $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError = iArr;
            try {
                iArr[UnityAds.UnityAdsLoadError.INITIALIZE_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.INVALID_ARGUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.TIMEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.INTERNAL_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BannerErrorInfo(String str, BannerErrorCode bannerErrorCode) {
        this.errorCode = bannerErrorCode;
        this.errorMessage = str;
    }

    public static BannerErrorInfo fromLoadError(UnityAds.UnityAdsLoadError unityAdsLoadError, String str) {
        int i10 = AnonymousClass1.$SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[unityAdsLoadError.ordinal()];
        return (i10 == 1 || i10 == 2 || i10 == 3) ? new BannerErrorInfo(str, BannerErrorCode.NATIVE_ERROR) : i10 != 4 ? new BannerErrorInfo(str, BannerErrorCode.UNKNOWN) : new BannerErrorInfo(str, BannerErrorCode.WEBVIEW_ERROR);
    }
}
