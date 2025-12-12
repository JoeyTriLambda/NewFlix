package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzf extends com.google.android.gms.internal.cast.zzb implements zzg {
    public zzf() {
        super("com.google.android.gms.cast.framework.media.INotificationActionsProvider");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            parcel2.writeNoException();
            parcel2.writeInt(12451000);
        } else if (i10 == 2) {
            IObjectWrapper iObjectWrapperZze = zze();
            parcel2.writeNoException();
            com.google.android.gms.internal.cast.zzc.zze(parcel2, iObjectWrapperZze);
        } else if (i10 == 3) {
            List listZzf = zzf();
            parcel2.writeNoException();
            parcel2.writeTypedList(listZzf);
        } else {
            if (i10 != 4) {
                return false;
            }
            int[] iArrZzg = zzg();
            parcel2.writeNoException();
            parcel2.writeIntArray(iArrZzg);
        }
        return true;
    }
}
