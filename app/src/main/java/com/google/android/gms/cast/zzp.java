package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
class zzp extends com.google.android.gms.cast.internal.zzc {
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzo(status);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public void doExecute(com.google.android.gms.cast.internal.zzw zzwVar) throws RemoteException {
        throw null;
    }
}
