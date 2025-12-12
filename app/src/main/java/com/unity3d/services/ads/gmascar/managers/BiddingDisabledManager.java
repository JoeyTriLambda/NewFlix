package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;

/* loaded from: classes2.dex */
public class BiddingDisabledManager extends BiddingBaseManager {
    public BiddingDisabledManager(IUnityAdsTokenListener iUnityAdsTokenListener) {
        super(iUnityAdsTokenListener);
    }

    @Override // com.unity3d.services.ads.gmascar.managers.BiddingBaseManager, com.unity3d.services.ads.gmascar.managers.IBiddingManager
    public String getTokenIdentifier() {
        return null;
    }

    @Override // com.unity3d.services.ads.gmascar.managers.BiddingBaseManager
    public void onUnityTokenSuccessfullyFetched() {
    }

    @Override // com.unity3d.services.ads.gmascar.managers.BiddingBaseManager
    public void start() {
    }
}
