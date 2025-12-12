package com.google.android.gms.cast.framework.media.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzj extends com.google.android.gms.internal.cast.zzb implements zzk {
    public zzj() {
        super("com.google.android.gms.cast.framework.media.internal.IFetchBitmapTaskProgressPublisher");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            long j10 = parcel.readLong();
            long j11 = parcel.readLong();
            com.google.android.gms.internal.cast.zzc.zzb(parcel);
            zzb(j10, j11);
            parcel2.writeNoException();
        } else {
            if (i10 != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(12451000);
        }
        return true;
    }
}
