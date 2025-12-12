package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;

/* loaded from: classes2.dex */
public interface IBiddingManager extends IUnityAdsTokenListener {
    String getFormattedToken(String str);

    String getTokenIdentifier();
}
