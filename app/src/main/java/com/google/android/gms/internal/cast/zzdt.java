package com.google.android.gms.internal.cast;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzdt extends zza {
    public zzdt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
    }

    public final void zze() throws RemoteException {
        zzd(3, zza());
    }

    public final void zzf(zzds zzdsVar, int i10) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzdsVar);
        parcelZza.writeInt(i10);
        zzd(5, parcelZza);
    }

    public final void zzg(zzds zzdsVar, zzdv zzdvVar, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzdsVar);
        zzc.zze(parcelZza, zzdvVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzc.zzc(parcelZza, bundle);
        zzd(7, parcelZza);
    }

    public final void zzh(zzds zzdsVar, PendingIntent pendingIntent, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzdsVar);
        zzc.zzc(parcelZza, pendingIntent);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzc.zzc(parcelZza, bundle);
        zzd(8, parcelZza);
    }

    public final void zzi(zzds zzdsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzdsVar);
        zzd(6, parcelZza);
    }
}
