package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.services.ads.gmascar.GMA;
import com.unity3d.services.core.configuration.IExperiments;

/* loaded from: classes2.dex */
public class BiddingManagerFactory {
    private static BiddingManagerFactory instance;

    /* renamed from: com.unity3d.services.ads.gmascar.managers.BiddingManagerFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$ads$gmascar$managers$SCARBiddingManagerType;

        static {
            int[] iArr = new int[SCARBiddingManagerType.values().length];
            $SwitchMap$com$unity3d$services$ads$gmascar$managers$SCARBiddingManagerType = iArr;
            try {
                iArr[SCARBiddingManagerType.EAGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$services$ads$gmascar$managers$SCARBiddingManagerType[SCARBiddingManagerType.LAZY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$unity3d$services$ads$gmascar$managers$SCARBiddingManagerType[SCARBiddingManagerType.HYBRID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$unity3d$services$ads$gmascar$managers$SCARBiddingManagerType[SCARBiddingManagerType.DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private BiddingManagerFactory() {
    }

    private BiddingBaseManager getExperiment(IUnityAdsTokenListener iUnityAdsTokenListener, IExperiments iExperiments) {
        if (iExperiments == null || iExperiments.getScarBiddingManager() == null) {
            return new BiddingDisabledManager(iUnityAdsTokenListener);
        }
        SCARBiddingManagerType sCARBiddingManagerTypeFromName = SCARBiddingManagerType.fromName(iExperiments.getScarBiddingManager());
        if (iUnityAdsTokenListener == null && sCARBiddingManagerTypeFromName != SCARBiddingManagerType.DISABLED) {
            return new BiddingEagerManager(null);
        }
        int i10 = AnonymousClass1.$SwitchMap$com$unity3d$services$ads$gmascar$managers$SCARBiddingManagerType[sCARBiddingManagerTypeFromName.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? new BiddingDisabledManager(iUnityAdsTokenListener) : new BiddingOnDemandManager(iUnityAdsTokenListener) : new BiddingLazyManager(iUnityAdsTokenListener) : new BiddingEagerManager(iUnityAdsTokenListener);
    }

    public static BiddingManagerFactory getInstance() {
        if (instance == null) {
            instance = new BiddingManagerFactory();
        }
        return instance;
    }

    public BiddingBaseManager createManager(IUnityAdsTokenListener iUnityAdsTokenListener, IExperiments iExperiments) {
        return GMA.getInstance().hasSCARBiddingSupport() ? getExperiment(iUnityAdsTokenListener, iExperiments) : new BiddingDisabledManager(iUnityAdsTokenListener);
    }
}
