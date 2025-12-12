package com.unity3d.services.store.gpbl;

import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;

/* loaded from: classes2.dex */
public interface IBillingClientStateListener {
    void onBillingServiceDisconnected();

    void onBillingSetupFinished(BillingResultBridge billingResultBridge);
}
