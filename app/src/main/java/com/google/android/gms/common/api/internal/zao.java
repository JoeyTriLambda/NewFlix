package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zao implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final zam f7268b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zap f7269m;

    public zao(zap zapVar, zam zamVar) {
        this.f7269m = zapVar;
        this.f7268b = zamVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f7269m.f7270b) {
            ConnectionResult connectionResult = this.f7268b.f7265b;
            if (connectionResult.hasResolution()) {
                zap zapVar = this.f7269m;
                zapVar.getClass();
                GoogleApiActivity.zaa(zapVar.getActivity(), (PendingIntent) Preconditions.checkNotNull(connectionResult.getResolution()), this.f7268b.f7264a, false);
                throw null;
            }
            zap zapVar2 = this.f7269m;
            zapVar2.getClass();
            zapVar2.getActivity();
            connectionResult.getErrorCode();
            throw null;
        }
    }
}
