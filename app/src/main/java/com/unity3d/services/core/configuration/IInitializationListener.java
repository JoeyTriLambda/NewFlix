package com.unity3d.services.core.configuration;

/* loaded from: classes2.dex */
public interface IInitializationListener {
    void onSdkInitializationFailed(String str, ErrorState errorState, int i10);

    void onSdkInitialized();
}
