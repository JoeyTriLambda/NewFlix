package com.google.android.gms.cast.framework;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzar extends com.google.android.gms.internal.cast.zza implements zzat {
    public zzar(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.IReconnectionService");
    }

    @Override // com.google.android.gms.cast.framework.zzat
    public final int zze(Intent intent, int i10, int i11) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.cast.zzc.zzc(parcelZza, intent);
        parcelZza.writeInt(i10);
        parcelZza.writeInt(i11);
        Parcel parcelZzb = zzb(2, parcelZza);
        int i12 = parcelZzb.readInt();
        parcelZzb.recycle();
        return i12;
    }

    @Override // com.google.android.gms.cast.framework.zzat
    public final IBinder zzf(Intent intent) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.cast.zzc.zzc(parcelZza, intent);
        Parcel parcelZzb = zzb(3, parcelZza);
        IBinder strongBinder = parcelZzb.readStrongBinder();
        parcelZzb.recycle();
        return strongBinder;
    }

    @Override // com.google.android.gms.cast.framework.zzat
    public final void zzg() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.cast.framework.zzat
    public final void zzh() throws RemoteException {
        zzc(4, zza());
    }
}
