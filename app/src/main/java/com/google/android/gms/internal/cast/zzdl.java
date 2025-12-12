package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
class zzdl extends BaseImplementation.ApiMethodImpl {
    final /* synthetic */ zzdn zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdl(zzdn zzdnVar, GoogleApiClient googleApiClient) {
        super((Api<?>) zzdnVar.zzb, googleApiClient);
        this.zzc = zzdnVar;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzdm(status);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    @KeepForSdk
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zzdl) obj);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    /* renamed from: zza */
    public void doExecute(zzdq zzdqVar) throws RemoteException {
        throw null;
    }
}
