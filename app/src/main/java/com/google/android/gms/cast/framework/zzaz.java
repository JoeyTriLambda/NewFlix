package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzaz extends com.google.android.gms.internal.cast.zzb implements zzba {
    public zzaz() {
        super("com.google.android.gms.cast.framework.ISessionManagerListener");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        switch (i10) {
            case 1:
                IObjectWrapper iObjectWrapperZzb = zzb();
                parcel2.writeNoException();
                com.google.android.gms.internal.cast.zzc.zze(parcel2, iObjectWrapperZzb);
                return true;
            case 2:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzj(iObjectWrapperAsInterface);
                parcel2.writeNoException();
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string = parcel.readString();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzi(iObjectWrapperAsInterface2, string);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int i12 = parcel.readInt();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzh(iObjectWrapperAsInterface3, i12);
                parcel2.writeNoException();
                return true;
            case 5:
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzd(iObjectWrapperAsInterface4);
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int i13 = parcel.readInt();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzc(iObjectWrapperAsInterface5, i13);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string2 = parcel.readString();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzg(iObjectWrapperAsInterface6, string2);
                parcel2.writeNoException();
                return true;
            case 8:
                IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                boolean zZzf = com.google.android.gms.internal.cast.zzc.zzf(parcel);
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzf(iObjectWrapperAsInterface7, zZzf);
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int i14 = parcel.readInt();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zze(iObjectWrapperAsInterface8, i14);
                parcel2.writeNoException();
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int i15 = parcel.readInt();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzk(iObjectWrapperAsInterface9, i15);
                parcel2.writeNoException();
                return true;
            case 11:
                parcel2.writeNoException();
                parcel2.writeInt(12451000);
                return true;
            default:
                return false;
        }
    }
}
