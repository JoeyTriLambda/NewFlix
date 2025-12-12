package com.google.android.gms.cast.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzaj extends com.google.android.gms.internal.cast.zza {
    public zzaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.internal.ICastService");
    }

    public final void zze(IStatusCallback iStatusCallback, String[] strArr, String str, List list) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.cast.zzc.zze(parcelZza, iStatusCallback);
        parcelZza.writeStringArray(strArr);
        parcelZza.writeString(str);
        parcelZza.writeTypedList(null);
        zzd(2, parcelZza);
    }

    public final void zzf(zzaf zzafVar, String[] strArr) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.cast.zzc.zze(parcelZza, zzafVar);
        parcelZza.writeStringArray(strArr);
        zzd(5, parcelZza);
    }

    public final void zzg(zzaf zzafVar, String[] strArr) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.cast.zzc.zze(parcelZza, zzafVar);
        parcelZza.writeStringArray(strArr);
        zzd(7, parcelZza);
    }

    public final void zzh(zzaf zzafVar, String[] strArr) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.cast.zzc.zze(parcelZza, zzafVar);
        parcelZza.writeStringArray(strArr);
        zzd(6, parcelZza);
    }
}
