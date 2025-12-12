package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzfs extends com.google.android.gms.internal.measurement.zzbu implements zzfq {
    public zzfs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final zzal zza(zzn zznVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznVar);
        Parcel parcelZza = zza(21, parcelA_);
        zzal zzalVar = (zzal) com.google.android.gms.internal.measurement.zzbw.zza(parcelZza, zzal.CREATOR);
        parcelZza.recycle();
        return zzalVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final String zzb(zzn zznVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznVar);
        Parcel parcelZza = zza(11, parcelA_);
        String string = parcelZza.readString();
        parcelZza.recycle();
        return string;
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zzc(zzn zznVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznVar);
        zzb(4, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zzd(zzn zznVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznVar);
        zzb(18, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zze(zzn zznVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznVar);
        zzb(20, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zzf(zzn zznVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznVar);
        zzb(6, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzmv> zza(zzn zznVar, Bundle bundle) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, bundle);
        Parcel parcelZza = zza(24, parcelA_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzmv.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzno> zza(zzn zznVar, boolean z10) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, z10);
        Parcel parcelZza = zza(7, parcelA_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzno.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzac> zza(String str, String str2, zzn zznVar) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznVar);
        Parcel parcelZza = zza(16, parcelA_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzac.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzac> zza(String str, String str2, String str3) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        parcelA_.writeString(str3);
        Parcel parcelZza = zza(17, parcelA_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzac.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzno> zza(String str, String str2, boolean z10, zzn zznVar) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, z10);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznVar);
        Parcel parcelZza = zza(14, parcelA_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzno.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzno> zza(String str, String str2, String str3, boolean z10) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        parcelA_.writeString(str3);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, z10);
        Parcel parcelZza = zza(15, parcelA_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzno.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zzbf zzbfVar, zzn zznVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zzbfVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznVar);
        zzb(1, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zzbf zzbfVar, String str, String str2) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zzbfVar);
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        zzb(5, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zzac zzacVar, zzn zznVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zzacVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznVar);
        zzb(12, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zzac zzacVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zzacVar);
        zzb(13, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(long j10, String str, String str2, String str3) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeLong(j10);
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        parcelA_.writeString(str3);
        zzb(10, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(Bundle bundle, zzn zznVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, bundle);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznVar);
        zzb(19, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zzno zznoVar, zzn zznVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznoVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zznVar);
        zzb(2, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final byte[] zza(zzbf zzbfVar, String str) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelA_, zzbfVar);
        parcelA_.writeString(str);
        Parcel parcelZza = zza(9, parcelA_);
        byte[] bArrCreateByteArray = parcelZza.createByteArray();
        parcelZza.recycle();
        return bArrCreateByteArray;
    }
}
