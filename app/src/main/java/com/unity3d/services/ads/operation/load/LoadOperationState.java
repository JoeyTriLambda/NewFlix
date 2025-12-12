package com.unity3d.services.ads.operation.load;

import androidx.activity.d;
import androidx.emoji2.text.g;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.services.ads.operation.OperationState;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.misc.Utilities;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class LoadOperationState extends OperationState {
    public IUnityAdsLoadListener listener;
    public UnityAdsLoadOptions loadOptions;

    public LoadOperationState(String str, IUnityAdsLoadListener iUnityAdsLoadListener, UnityAdsLoadOptions unityAdsLoadOptions, Configuration configuration) {
        super(str, configuration);
        this.listener = iUnityAdsLoadListener;
        this.loadOptions = unityAdsLoadOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUnityAdsAdLoaded$1() {
        this.listener.onUnityAdsAdLoaded(this.placementId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUnityAdsFailedToLoad$0(UnityAds.UnityAdsLoadError unityAdsLoadError, String str) {
        this.listener.onUnityAdsFailedToLoad(this.placementId, unityAdsLoadError, str);
    }

    public boolean isBanner() {
        return this instanceof LoadBannerOperationState;
    }

    public void onUnityAdsAdLoaded() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new d(this, 22));
        }
    }

    public void onUnityAdsFailedToLoad(UnityAds.UnityAdsLoadError unityAdsLoadError, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new g(3, this, unityAdsLoadError, str));
        }
    }
}
