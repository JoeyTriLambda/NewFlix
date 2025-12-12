package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
public final class zzdk extends zzbu implements zzdi {
    public zzdk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzdi
    public final void zza(Bundle bundle) throws RemoteException {
        Parcel parcelA_ = a_();
        zzbw.zza(parcelA_, bundle);
        zzb(1, parcelA_);
    }
}
