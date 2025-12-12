package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;

/* loaded from: classes2.dex */
public class BiddingEagerManager extends BiddingBaseManager {
    public BiddingEagerManager(IUnityAdsTokenListener iUnityAdsTokenListener) {
        super(iUnityAdsTokenListener);
    }

    @Override // com.unity3d.services.ads.gmascar.managers.BiddingBaseManager
    public void start() {
        permitSignalsUpload();
        fetchSignals();
    }

    @Override // com.unity3d.services.ads.gmascar.managers.BiddingBaseManager
    public void onUnityTokenSuccessfullyFetched() {
    }
}
