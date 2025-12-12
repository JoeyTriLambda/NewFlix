package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.IAccountAccessor;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zabt implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConnectionResult f7199b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zabu f7200m;

    public zabt(zabu zabuVar, ConnectionResult connectionResult) {
        this.f7200m = zabuVar;
        this.f7199b = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAccountAccessor iAccountAccessor;
        zabu zabuVar = this.f7200m;
        zabq zabqVar = (zabq) zabuVar.f7206f.f7097u.get(zabuVar.f7202b);
        if (zabqVar == null) {
            return;
        }
        ConnectionResult connectionResult = this.f7199b;
        if (!connectionResult.isSuccess()) {
            zabqVar.zar(connectionResult, null);
            return;
        }
        zabuVar.f7205e = true;
        Api.Client client = zabuVar.f7201a;
        if (client.requiresSignIn()) {
            if (!zabuVar.f7205e || (iAccountAccessor = zabuVar.f7203c) == null) {
                return;
            }
            client.getRemoteService(iAccountAccessor, zabuVar.f7204d);
            return;
        }
        try {
            client.getRemoteService(null, client.getScopesForConnectionlessNonSignIn());
        } catch (SecurityException e10) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e10);
            client.disconnect("Failed to get service from broker.");
            zabqVar.zar(new ConnectionResult(10), null);
        }
    }
}
