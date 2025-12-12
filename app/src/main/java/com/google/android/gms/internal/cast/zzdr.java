package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzdr extends zzb implements zzds {
    public zzdr() {
        super("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            int i12 = parcel.readInt();
            int i13 = parcel.readInt();
            Surface surface = (Surface) zzc.zza(parcel, Surface.CREATOR);
            zzc.zzb(parcel);
            zzb(i12, i13, surface);
        } else if (i10 == 2) {
            int i14 = parcel.readInt();
            zzc.zzb(parcel);
            zzd(i14);
        } else if (i10 == 3) {
            zzf();
        } else if (i10 == 4) {
            zzc();
        } else {
            if (i10 != 5) {
                return false;
            }
            boolean zZzf = zzc.zzf(parcel);
            zzc.zzb(parcel);
            zze(zZzf);
        }
        parcel2.writeNoException();
        return true;
    }
}
