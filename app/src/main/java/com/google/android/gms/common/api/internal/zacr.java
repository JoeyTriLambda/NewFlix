package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zacr implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.signin.internal.zak f7233b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zact f7234m;

    public zacr(zact zactVar, com.google.android.gms.signin.internal.zak zakVar) {
        this.f7234m = zactVar;
        this.f7233b = zakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> abstractClientBuilder = zact.f7235h;
        com.google.android.gms.signin.internal.zak zakVar = this.f7233b;
        ConnectionResult connectionResultZaa = zakVar.zaa();
        boolean zIsSuccess = connectionResultZaa.isSuccess();
        zact zactVar = this.f7234m;
        if (zIsSuccess) {
            com.google.android.gms.common.internal.zav zavVar = (com.google.android.gms.common.internal.zav) Preconditions.checkNotNull(zakVar.zab());
            ConnectionResult connectionResultZaa2 = zavVar.zaa();
            if (!connectionResultZaa2.isSuccess()) {
                String strValueOf = String.valueOf(connectionResultZaa2);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                zactVar.f7242g.zae(connectionResultZaa2);
                zactVar.f7241f.disconnect();
                return;
            }
            zactVar.f7242g.zaf(zavVar.zab(), zactVar.f7239d);
        } else {
            zactVar.f7242g.zae(connectionResultZaa);
        }
        zactVar.f7241f.disconnect();
    }
}
