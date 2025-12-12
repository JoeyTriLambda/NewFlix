package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public abstract class zzac extends com.google.android.gms.internal.common.zzb implements IGmsCallbacks {
    public zzac() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.internal.common.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            int i12 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) com.google.android.gms.internal.common.zzc.zza(parcel, Bundle.CREATOR);
            com.google.android.gms.internal.common.zzc.zzb(parcel);
            onPostInitComplete(i12, strongBinder, bundle);
        } else if (i10 == 2) {
            int i13 = parcel.readInt();
            Bundle bundle2 = (Bundle) com.google.android.gms.internal.common.zzc.zza(parcel, Bundle.CREATOR);
            com.google.android.gms.internal.common.zzc.zzb(parcel);
            zzb(i13, bundle2);
        } else {
            if (i10 != 3) {
                return false;
            }
            int i14 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzk zzkVar = (zzk) com.google.android.gms.internal.common.zzc.zza(parcel, zzk.CREATOR);
            com.google.android.gms.internal.common.zzc.zzb(parcel);
            zzc(i14, strongBinder2, zzkVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
