package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public interface zzfq extends IInterface {
    zzal zza(zzn zznVar) throws RemoteException;

    List<zzmv> zza(zzn zznVar, Bundle bundle) throws RemoteException;

    List<zzno> zza(zzn zznVar, boolean z10) throws RemoteException;

    List<zzac> zza(String str, String str2, zzn zznVar) throws RemoteException;

    List<zzac> zza(String str, String str2, String str3) throws RemoteException;

    List<zzno> zza(String str, String str2, String str3, boolean z10) throws RemoteException;

    List<zzno> zza(String str, String str2, boolean z10, zzn zznVar) throws RemoteException;

    void zza(long j10, String str, String str2, String str3) throws RemoteException;

    void zza(Bundle bundle, zzn zznVar) throws RemoteException;

    void zza(zzac zzacVar) throws RemoteException;

    void zza(zzac zzacVar, zzn zznVar) throws RemoteException;

    void zza(zzbf zzbfVar, zzn zznVar) throws RemoteException;

    void zza(zzbf zzbfVar, String str, String str2) throws RemoteException;

    void zza(zzno zznoVar, zzn zznVar) throws RemoteException;

    byte[] zza(zzbf zzbfVar, String str) throws RemoteException;

    String zzb(zzn zznVar) throws RemoteException;

    void zzc(zzn zznVar) throws RemoteException;

    void zzd(zzn zznVar) throws RemoteException;

    void zze(zzn zznVar) throws RemoteException;

    void zzf(zzn zznVar) throws RemoteException;
}
