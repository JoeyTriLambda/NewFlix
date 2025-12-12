package com.unity3d.services.ads.gmascar.listeners;

import com.unity3d.services.ads.gmascar.models.BiddingSignals;

/* loaded from: classes2.dex */
public interface IBiddingSignalsListener {
    void onSignalsFailure(String str);

    void onSignalsReady(BiddingSignals biddingSignals);
}
