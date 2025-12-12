package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class zzg extends zza {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f7416g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(BaseGmsClient baseGmsClient, int i10, Bundle bundle) {
        super(baseGmsClient, i10, null);
        this.f7416g = baseGmsClient;
    }

    @Override // com.google.android.gms.common.internal.zza
    public final void zzb(ConnectionResult connectionResult) {
        BaseGmsClient baseGmsClient = this.f7416g;
        if (baseGmsClient.enableLocalFallback() && BaseGmsClient.zzo(baseGmsClient)) {
            BaseGmsClient.zzk(baseGmsClient, 16);
        } else {
            baseGmsClient.zzc.onReportServiceBinding(connectionResult);
            baseGmsClient.onConnectionFailed(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.internal.zza
    public final boolean zzd() {
        this.f7416g.zzc.onReportServiceBinding(ConnectionResult.f7014p);
        return true;
    }
}
