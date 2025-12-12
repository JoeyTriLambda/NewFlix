package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zabp implements BaseGmsClient.SignOutCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zabq f7183a;

    public zabp(zabq zabqVar) {
        this.f7183a = zabqVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void onSignOutComplete() {
        this.f7183a.f7196m.f7101y.post(new zabo(this));
    }
}
