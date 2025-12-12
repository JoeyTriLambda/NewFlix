package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzau extends com.google.android.gms.internal.cast.zza implements zzaw {
    public zzau(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ISession");
    }

    @Override // com.google.android.gms.cast.framework.zzaw
    public final int zze() throws RemoteException {
        Parcel parcelZzb = zzb(17, zza());
        int i10 = parcelZzb.readInt();
        parcelZzb.recycle();
        return i10;
    }

    @Override // com.google.android.gms.cast.framework.zzaw
    public final int zzf() throws RemoteException {
        Parcel parcelZzb = zzb(18, zza());
        int i10 = parcelZzb.readInt();
        parcelZzb.recycle();
        return i10;
    }

    @Override // com.google.android.gms.cast.framework.zzaw
    public final IObjectWrapper zzg() throws RemoteException {
        Parcel parcelZzb = zzb(1, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.cast.framework.zzaw
    public final void zzj(int i10) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i10);
        zzc(15, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzaw
    public final void zzk(int i10) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i10);
        zzc(12, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzaw
    public final void zzl(int i10) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i10);
        zzc(13, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzaw
    public final boolean zzp() throws RemoteException {
        Parcel parcelZzb = zzb(5, zza());
        boolean zZzf = com.google.android.gms.internal.cast.zzc.zzf(parcelZzb);
        parcelZzb.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.cast.framework.zzaw
    public final boolean zzq() throws RemoteException {
        Parcel parcelZzb = zzb(6, zza());
        boolean zZzf = com.google.android.gms.internal.cast.zzc.zzf(parcelZzb);
        parcelZzb.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.cast.framework.zzaw
    public final boolean zzt() throws RemoteException {
        Parcel parcelZzb = zzb(9, zza());
        boolean zZzf = com.google.android.gms.internal.cast.zzc.zzf(parcelZzb);
        parcelZzb.recycle();
        return zZzf;
    }
}
