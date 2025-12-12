package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zabl implements BackgroundDetector.BackgroundStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoogleApiManager f7178a;

    public zabl(GoogleApiManager googleApiManager) {
        this.f7178a = googleApiManager;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z10) {
        com.google.android.gms.internal.base.zaq zaqVar = this.f7178a.f7101y;
        zaqVar.sendMessage(zaqVar.obtainMessage(1, Boolean.valueOf(z10)));
    }
}
