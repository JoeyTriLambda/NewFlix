package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzak extends com.google.android.gms.internal.cast.zza implements zzam {
    public zzak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ICastSession");
    }

    @Override // com.google.android.gms.cast.framework.zzam
    public final void zze(boolean z10, int i10) throws RemoteException {
        Parcel parcelZza = zza();
        int i11 = com.google.android.gms.internal.cast.zzc.zza;
        parcelZza.writeInt(z10 ? 1 : 0);
        parcelZza.writeInt(0);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzam
    public final void zzf(ApplicationMetadata applicationMetadata, String str, String str2, boolean z10) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.cast.zzc.zzc(parcelZza, applicationMetadata);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeInt(z10 ? 1 : 0);
        zzc(4, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzam
    public final void zzg(int i10) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i10);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzam
    public final void zzh(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.cast.zzc.zzc(parcelZza, null);
        zzc(1, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzam
    public final void zzi(ConnectionResult connectionResult) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.cast.zzc.zzc(parcelZza, connectionResult);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzam
    public final void zzj(int i10) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i10);
        zzc(2, parcelZza);
    }
}
