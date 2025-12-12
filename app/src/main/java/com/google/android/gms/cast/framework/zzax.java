package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzax extends com.google.android.gms.internal.cast.zza implements zzay {
    public zzax(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ISessionManager");
    }

    @Override // com.google.android.gms.cast.framework.zzay
    public final IObjectWrapper zzf() throws RemoteException {
        Parcel parcelZzb = zzb(1, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.cast.framework.zzay
    public final IObjectWrapper zzg() throws RemoteException {
        Parcel parcelZzb = zzb(7, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.cast.framework.zzay
    public final void zzi(zzba zzbaVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.cast.zzc.zze(parcelZza, zzbaVar);
        zzc(2, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzay
    public final void zzj(boolean z10, boolean z11) throws RemoteException {
        Parcel parcelZza = zza();
        int i10 = com.google.android.gms.internal.cast.zzc.zza;
        parcelZza.writeInt(1);
        parcelZza.writeInt(z11 ? 1 : 0);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzay
    public final void zzl(zzba zzbaVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.cast.zzc.zze(parcelZza, zzbaVar);
        zzc(3, parcelZza);
    }
}
