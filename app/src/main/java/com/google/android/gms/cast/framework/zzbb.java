package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzbb extends com.google.android.gms.internal.cast.zzb implements zzbc {
    public zzbb() {
        super("com.google.android.gms.cast.framework.ISessionProvider");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            String string = parcel.readString();
            com.google.android.gms.internal.cast.zzc.zzb(parcel);
            IObjectWrapper iObjectWrapperZzb = zzb(string);
            parcel2.writeNoException();
            com.google.android.gms.internal.cast.zzc.zze(parcel2, iObjectWrapperZzb);
        } else if (i10 == 2) {
            boolean zZzd = zzd();
            parcel2.writeNoException();
            int i12 = com.google.android.gms.internal.cast.zzc.zza;
            parcel2.writeInt(zZzd ? 1 : 0);
        } else if (i10 == 3) {
            String strZzc = zzc();
            parcel2.writeNoException();
            parcel2.writeString(strZzc);
        } else {
            if (i10 != 4) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(12451000);
        }
        return true;
    }
}
