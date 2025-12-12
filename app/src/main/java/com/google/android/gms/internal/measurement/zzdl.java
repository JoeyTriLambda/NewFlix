package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
public final class zzdl extends zzbu implements zzdj {
    public zzdl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final int zza() throws RemoteException {
        Parcel parcelZza = zza(2, a_());
        int i10 = parcelZza.readInt();
        parcelZza.recycle();
        return i10;
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void zza(String str, String str2, Bundle bundle, long j10) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        zzbw.zza(parcelA_, bundle);
        parcelA_.writeLong(j10);
        zzb(1, parcelA_);
    }
}
