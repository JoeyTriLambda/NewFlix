package com.google.android.gms.internal.cast;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzal extends zzb implements zzam {
    public zzal() {
        super("com.google.android.gms.cast.framework.internal.IMediaRouter");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        zzao zzanVar;
        switch (i10) {
            case 1:
                Bundle bundle = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzanVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.internal.IMediaRouterCallback");
                    zzanVar = iInterfaceQueryLocalInterface instanceof zzao ? (zzao) iInterfaceQueryLocalInterface : new zzan(strongBinder);
                }
                zzc.zzb(parcel);
                zze(bundle, zzanVar);
                parcel2.writeNoException();
                return true;
            case 2:
                Bundle bundle2 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                int i12 = parcel.readInt();
                zzc.zzb(parcel);
                zzd(bundle2, i12);
                parcel2.writeNoException();
                return true;
            case 3:
                Bundle bundle3 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                zzc.zzb(parcel);
                zzg(bundle3);
                parcel2.writeNoException();
                return true;
            case 4:
                Bundle bundle4 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                int i13 = parcel.readInt();
                zzc.zzb(parcel);
                boolean zZzm = zzm(bundle4, i13);
                parcel2.writeNoException();
                parcel2.writeInt(zZzm ? 1 : 0);
                return true;
            case 5:
                String string = parcel.readString();
                zzc.zzb(parcel);
                zzi(string);
                parcel2.writeNoException();
                return true;
            case 6:
                zzh();
                parcel2.writeNoException();
                return true;
            case 7:
                boolean zZzl = zzl();
                parcel2.writeNoException();
                int i14 = zzc.zza;
                parcel2.writeInt(zZzl ? 1 : 0);
                return true;
            case 8:
                String string2 = parcel.readString();
                zzc.zzb(parcel);
                Bundle bundleZzb = zzb(string2);
                parcel2.writeNoException();
                zzc.zzd(parcel2, bundleZzb);
                return true;
            case 9:
                String strZzc = zzc();
                parcel2.writeNoException();
                parcel2.writeString(strZzc);
                return true;
            case 10:
                parcel2.writeNoException();
                parcel2.writeInt(12451000);
                return true;
            case 11:
                zzf();
                parcel2.writeNoException();
                return true;
            case 12:
                boolean zZzk = zzk();
                parcel2.writeNoException();
                int i15 = zzc.zza;
                parcel2.writeInt(zZzk ? 1 : 0);
                return true;
            case 13:
                int i16 = parcel.readInt();
                zzc.zzb(parcel);
                zzj(i16);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
