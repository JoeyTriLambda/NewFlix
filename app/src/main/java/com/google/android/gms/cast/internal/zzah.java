package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzah extends com.google.android.gms.internal.cast.zzb implements zzai {
    public zzah() {
        super("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        switch (i10) {
            case 1:
                int i12 = parcel.readInt();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzk(i12);
                return true;
            case 2:
                ApplicationMetadata applicationMetadata = (ApplicationMetadata) com.google.android.gms.internal.cast.zzc.zza(parcel, ApplicationMetadata.CREATOR);
                String string = parcel.readString();
                String string2 = parcel.readString();
                boolean zZzf = com.google.android.gms.internal.cast.zzc.zzf(parcel);
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzb(applicationMetadata, string, string2, zZzf);
                return true;
            case 3:
                int i13 = parcel.readInt();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzc(i13);
                return true;
            case 4:
                String string3 = parcel.readString();
                double d10 = parcel.readDouble();
                boolean zZzf2 = com.google.android.gms.internal.cast.zzc.zzf(parcel);
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzn(string3, d10, zZzf2);
                return true;
            case 5:
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzp(string4, string5);
                return true;
            case 6:
                String string6 = parcel.readString();
                byte[] bArrCreateByteArray = parcel.createByteArray();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzh(string6, bArrCreateByteArray);
                return true;
            case 7:
                int i14 = parcel.readInt();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zze(i14);
                return true;
            case 8:
                int i15 = parcel.readInt();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzg(i15);
                return true;
            case 9:
                int i16 = parcel.readInt();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzd(i16);
                return true;
            case 10:
                String string7 = parcel.readString();
                long j10 = parcel.readLong();
                int i17 = parcel.readInt();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzm(string7, j10, i17);
                return true;
            case 11:
                String string8 = parcel.readString();
                long j11 = parcel.readLong();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzl(string8, j11);
                return true;
            case 12:
                zza zzaVar = (zza) com.google.android.gms.internal.cast.zzc.zza(parcel, zza.CREATOR);
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzf(zzaVar);
                return true;
            case 13:
                zzab zzabVar = (zzab) com.google.android.gms.internal.cast.zzc.zza(parcel, zzab.CREATOR);
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzj(zzabVar);
                return true;
            case 14:
                int i18 = parcel.readInt();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzi(i18);
                return true;
            case 15:
                int i19 = parcel.readInt();
                com.google.android.gms.internal.cast.zzc.zzb(parcel);
                zzo(i19);
                return true;
            default:
                return false;
        }
    }
}
