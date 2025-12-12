package com.unity3d.services.ads.operation.show;

import android.app.Activity;
import androidx.activity.d;
import androidx.emoji2.text.g;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.ads.operation.OperationState;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.misc.Utilities;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import r.x;

/* loaded from: classes2.dex */
public class ShowOperationState extends OperationState {
    public WeakReference<Activity> activity;
    public IUnityAdsShowListener listener;
    public UnityAdsShowOptions showOptions;

    public ShowOperationState(String str, IUnityAdsShowListener iUnityAdsShowListener, Activity activity, UnityAdsShowOptions unityAdsShowOptions, Configuration configuration) {
        super(str, configuration);
        this.listener = iUnityAdsShowListener;
        this.activity = new WeakReference<>(activity);
        this.showOptions = unityAdsShowOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUnityAdsShowClick$1() {
        this.listener.onUnityAdsShowClick(this.placementId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUnityAdsShowComplete$3(UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        this.listener.onUnityAdsShowComplete(this.placementId, unityAdsShowCompletionState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUnityAdsShowFailure$0(UnityAds.UnityAdsShowError unityAdsShowError, String str) {
        this.listener.onUnityAdsShowFailure(this.placementId, unityAdsShowError, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUnityAdsShowStart$2(String str) {
        this.listener.onUnityAdsShowStart(str);
    }

    public void onUnityAdsShowClick() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new d(this, 23));
        }
    }

    public void onUnityAdsShowComplete(UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new x(19, this, unityAdsShowCompletionState));
        }
    }

    public void onUnityAdsShowFailure(UnityAds.UnityAdsShowError unityAdsShowError, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new g(4, this, unityAdsShowError, str));
        }
    }

    public void onUnityAdsShowStart(String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new x(20, this, str));
        }
    }
}
