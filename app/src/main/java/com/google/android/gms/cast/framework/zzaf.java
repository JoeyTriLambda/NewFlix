package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzaf extends com.google.android.gms.internal.cast.zzb implements zzag {
    public zzaf() {
        super("com.google.android.gms.cast.framework.ICastConnectionController");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            String string = parcel.readString();
            String string2 = parcel.readString();
            com.google.android.gms.internal.cast.zzc.zzb(parcel);
            zzc(string, string2);
            parcel2.writeNoException();
        } else if (i10 == 2) {
            String string3 = parcel.readString();
            LaunchOptions launchOptions = (LaunchOptions) com.google.android.gms.internal.cast.zzc.zza(parcel, LaunchOptions.CREATOR);
            com.google.android.gms.internal.cast.zzc.zzb(parcel);
            zzd(string3, launchOptions);
            parcel2.writeNoException();
        } else if (i10 == 3) {
            String string4 = parcel.readString();
            com.google.android.gms.internal.cast.zzc.zzb(parcel);
            zze(string4);
            parcel2.writeNoException();
        } else if (i10 == 4) {
            int i12 = parcel.readInt();
            com.google.android.gms.internal.cast.zzc.zzb(parcel);
            zzb(i12);
            parcel2.writeNoException();
        } else {
            if (i10 != 5) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(12451000);
        }
        return true;
    }
}
