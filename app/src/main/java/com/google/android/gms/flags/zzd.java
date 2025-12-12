package com.google.android.gms.flags;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
/* loaded from: classes.dex */
public abstract class zzd extends com.google.android.gms.internal.flags.zzb implements zze {
    public zzd() {
        super("com.google.android.gms.flags.IFlagProvider");
    }

    public static zze asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
        return iInterfaceQueryLocalInterface instanceof zze ? (zze) iInterfaceQueryLocalInterface : new zzc(iBinder);
    }

    @Override // com.google.android.gms.internal.flags.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            init(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i10 == 2) {
            boolean booleanFlagValue = getBooleanFlagValue(parcel.readString(), com.google.android.gms.internal.flags.zzc.zzc(parcel), parcel.readInt());
            parcel2.writeNoException();
            com.google.android.gms.internal.flags.zzc.zza(parcel2, booleanFlagValue);
        } else if (i10 == 3) {
            int intFlagValue = getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeInt(intFlagValue);
        } else if (i10 == 4) {
            long longFlagValue = getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(longFlagValue);
        } else {
            if (i10 != 5) {
                return false;
            }
            String stringFlagValue = getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeString(stringFlagValue);
        }
        return true;
    }
}
