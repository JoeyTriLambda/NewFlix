package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzca extends zzbu implements zzby {
    public zzca(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.zzby
    public final Bundle zza(Bundle bundle) throws RemoteException {
        Parcel parcelA_ = a_();
        zzbw.zza(parcelA_, bundle);
        Parcel parcelZza = zza(1, parcelA_);
        Bundle bundle2 = (Bundle) zzbw.zza(parcelZza, Bundle.CREATOR);
        parcelZza.recycle();
        return bundle2;
    }
}
