package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;

/* loaded from: classes2.dex */
public class BiddingOnDemandManager extends BiddingBaseManager {
    public BiddingOnDemandManager(IUnityAdsTokenListener iUnityAdsTokenListener) {
        super(iUnityAdsTokenListener);
    }

    @Override // com.unity3d.services.ads.gmascar.managers.BiddingBaseManager
    public void onUnityTokenSuccessfullyFetched() {
        permitSignalsUpload();
    }

    @Override // com.unity3d.services.ads.gmascar.managers.BiddingBaseManager
    public void start() {
        fetchSignals();
    }
}
