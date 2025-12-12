package com.unity3d.services.core.request.metrics;

import com.unity3d.ads.UnityAds;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class AdOperationMetric {
    private static final String AD_LOAD_FAIL = "native_load_time_failure";
    private static final String AD_LOAD_START = "native_load_started";
    private static final String AD_LOAD_SUCCESS = "native_load_time_success";
    private static final String AD_LOAD_TYPE = "type";
    private static final String AD_SHOW_FAIL = "native_show_time_failure";
    private static final String AD_SHOW_START = "native_show_started";
    private static final String AD_SHOW_SUCCESS = "native_show_time_success";
    private static final String AD_TYPE_BANNER = "banner";
    private static final String AD_TYPE_VIDEO = "video";
    public static final String INIT_STATE = "state";
    private static final String REASON = "reason";
    private static final String UNKNOWN = "unknown";

    /* renamed from: com.unity3d.services.core.request.metrics.AdOperationMetric$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError;
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError;

        static {
            int[] iArr = new int[UnityAds.UnityAdsShowError.values().length];
            $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError = iArr;
            try {
                iArr[UnityAds.UnityAdsShowError.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.NOT_READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.VIDEO_PLAYER_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.INVALID_ARGUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.NO_CONNECTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.ALREADY_SHOWING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.INTERNAL_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[UnityAds.UnityAdsLoadError.values().length];
            $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError = iArr2;
            try {
                iArr2[UnityAds.UnityAdsLoadError.INITIALIZE_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.INTERNAL_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.INVALID_ARGUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.TIMEOUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private static HashMap<String, String> getTags(AdOperationError adOperationError, boolean z10, boolean z11) {
        return new HashMap<String, String>(z10, adOperationError == null ? UNKNOWN : adOperationError.toString(), z11 ? AD_TYPE_BANNER : "video") { // from class: com.unity3d.services.core.request.metrics.AdOperationMetric.1
            final /* synthetic */ String val$errorMetric;
            final /* synthetic */ boolean val$isFailure;
            final /* synthetic */ String val$type;

            {
                this.val$isFailure = z10;
                this.val$errorMetric = str;
                this.val$type = str;
                if (z10) {
                    put(AdOperationMetric.REASON, str);
                }
                put(AdOperationMetric.AD_LOAD_TYPE, str);
            }
        };
    }

    private static AdOperationError mapUnityAdsLoadError(UnityAds.UnityAdsLoadError unityAdsLoadError) {
        int i10 = AnonymousClass2.$SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[unityAdsLoadError.ordinal()];
        if (i10 == 1) {
            return AdOperationError.init_failed;
        }
        if (i10 == 2) {
            return AdOperationError.internal;
        }
        if (i10 == 3) {
            return AdOperationError.invalid;
        }
        if (i10 == 4) {
            return AdOperationError.no_fill;
        }
        if (i10 != 5) {
            return null;
        }
        return AdOperationError.timeout;
    }

    private static AdOperationError mapUnityAdsShowError(UnityAds.UnityAdsShowError unityAdsShowError) {
        switch (AnonymousClass2.$SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[unityAdsShowError.ordinal()]) {
            case 1:
                return AdOperationError.init_failed;
            case 2:
                return AdOperationError.not_ready;
            case 3:
                return AdOperationError.player;
            case 4:
                return AdOperationError.invalid;
            case 5:
                return AdOperationError.no_connection;
            case 6:
                return AdOperationError.already_showing;
            case 7:
                return AdOperationError.internal;
            default:
                return null;
        }
    }

    public static Metric newAdLoadFailure(AdOperationError adOperationError, Long l10, boolean z10) {
        return new Metric(AD_LOAD_FAIL, l10, getTags(adOperationError, true, z10));
    }

    public static Metric newAdLoadStart() {
        return new Metric(AD_LOAD_START, null);
    }

    public static Metric newAdLoadSuccess(Long l10, boolean z10) {
        return new Metric(AD_LOAD_SUCCESS, l10, getTags(null, false, z10));
    }

    public static Metric newAdShowFailure(AdOperationError adOperationError, Long l10) {
        return new Metric(AD_SHOW_FAIL, l10, getTags(adOperationError, true, false));
    }

    public static Metric newAdShowStart() {
        return new Metric(AD_SHOW_START, null);
    }

    public static Metric newAdShowSuccess(Long l10) {
        return new Metric(AD_SHOW_SUCCESS, l10);
    }

    public static Metric newAdLoadFailure(UnityAds.UnityAdsLoadError unityAdsLoadError, Long l10, boolean z10) {
        return newAdLoadFailure(mapUnityAdsLoadError(unityAdsLoadError), l10, z10);
    }

    public static Metric newAdShowFailure(UnityAds.UnityAdsShowError unityAdsShowError, Long l10) {
        return newAdShowFailure(mapUnityAdsShowError(unityAdsShowError), l10);
    }
}
