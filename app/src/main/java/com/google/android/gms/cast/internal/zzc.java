package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzc extends BaseImplementation.ApiMethodImpl {
    public zzc(GoogleApiClient googleApiClient) {
        super(Cast.f6137a, googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    @KeepForSdk
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zzc) obj);
    }

    public final void zzc(int i10) {
        setResult((zzc) createFailedResult(new Status(2001)));
    }
}
