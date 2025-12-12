package com.google.android.gms.cast.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzbu;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzag extends com.google.android.gms.internal.cast.zza {
    public zzag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.internal.ICastDeviceController");
    }

    public final void zze() throws RemoteException {
        zzd(17, zza());
    }

    public final void zzf() throws RemoteException {
        zzd(1, zza());
    }

    public final void zzg(String str, String str2, zzbu zzbuVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        com.google.android.gms.internal.cast.zzc.zzc(parcelZza, zzbuVar);
        zzd(14, parcelZza);
    }

    public final void zzh(String str, LaunchOptions launchOptions) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        com.google.android.gms.internal.cast.zzc.zzc(parcelZza, launchOptions);
        zzd(13, parcelZza);
    }

    public final void zzi() throws RemoteException {
        zzd(4, zza());
    }

    public final void zzj(zzai zzaiVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.cast.zzc.zze(parcelZza, zzaiVar);
        zzd(18, parcelZza);
    }

    public final void zzk(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzd(11, parcelZza);
    }

    public final void zzl() throws RemoteException {
        zzd(6, zza());
    }

    public final void zzm(String str, String str2, long j10) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeLong(j10);
        zzd(9, parcelZza);
    }

    public final void zzn(boolean z10, double d10, boolean z11) throws RemoteException {
        Parcel parcelZza = zza();
        int i10 = com.google.android.gms.internal.cast.zzc.zza;
        parcelZza.writeInt(z10 ? 1 : 0);
        parcelZza.writeDouble(d10);
        parcelZza.writeInt(z11 ? 1 : 0);
        zzd(8, parcelZza);
    }

    public final void zzp(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzd(5, parcelZza);
    }

    public final void zzq() throws RemoteException {
        zzd(19, zza());
    }

    public final void zzr(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzd(12, parcelZza);
    }
}
