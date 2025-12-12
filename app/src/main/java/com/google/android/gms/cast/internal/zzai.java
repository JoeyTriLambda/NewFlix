package com.google.android.gms.cast.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public interface zzai extends IInterface {
    void zzb(ApplicationMetadata applicationMetadata, String str, String str2, boolean z10) throws RemoteException;

    void zzc(int i10) throws RemoteException;

    void zzd(int i10) throws RemoteException;

    void zze(int i10) throws RemoteException;

    void zzf(zza zzaVar) throws RemoteException;

    void zzg(int i10) throws RemoteException;

    void zzh(String str, byte[] bArr) throws RemoteException;

    void zzi(int i10) throws RemoteException;

    void zzj(zzab zzabVar) throws RemoteException;

    void zzk(int i10) throws RemoteException;

    void zzl(String str, long j10) throws RemoteException;

    void zzm(String str, long j10, int i10) throws RemoteException;

    void zzn(String str, double d10, boolean z10) throws RemoteException;

    void zzo(int i10) throws RemoteException;

    void zzp(String str, String str2) throws RemoteException;
}
