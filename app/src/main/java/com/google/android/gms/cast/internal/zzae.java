package com.google.android.gms.cast.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzae extends com.google.android.gms.internal.cast.zzb implements zzaf {
    public zzae() {
        super("com.google.android.gms.cast.internal.IBundleCallback");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return false;
        }
        Bundle bundle = (Bundle) com.google.android.gms.internal.cast.zzc.zza(parcel, Bundle.CREATOR);
        com.google.android.gms.internal.cast.zzc.zzb(parcel);
        zzb(bundle);
        return true;
    }
}
