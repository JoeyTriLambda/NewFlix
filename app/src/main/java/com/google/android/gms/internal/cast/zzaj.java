package com.google.android.gms.internal.cast;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.loopj.android.http.AsyncHttpClient;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzaj extends zza implements zzak {
    public zzaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
    }

    @Override // com.google.android.gms.internal.cast.zzak
    public final int zze() throws RemoteException {
        Parcel parcelZzb = zzb(8, zza());
        int i10 = parcelZzb.readInt();
        parcelZzb.recycle();
        return i10;
    }

    @Override // com.google.android.gms.internal.cast.zzak
    public final com.google.android.gms.cast.framework.zzaj zzf(IObjectWrapper iObjectWrapper, CastOptions castOptions, zzam zzamVar, Map map) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zzc(parcelZza, castOptions);
        zzc.zze(parcelZza, zzamVar);
        parcelZza.writeMap(map);
        Parcel parcelZzb = zzb(1, parcelZza);
        com.google.android.gms.cast.framework.zzaj zzajVarZzb = com.google.android.gms.cast.framework.zzai.zzb(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return zzajVarZzb;
    }

    @Override // com.google.android.gms.internal.cast.zzak
    public final com.google.android.gms.cast.framework.zzam zzg(CastOptions castOptions, IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.zzag zzagVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, castOptions);
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zze(parcelZza, zzagVar);
        Parcel parcelZzb = zzb(3, parcelZza);
        com.google.android.gms.cast.framework.zzam zzamVarZzb = com.google.android.gms.cast.framework.zzal.zzb(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return zzamVarZzb;
    }

    @Override // com.google.android.gms.internal.cast.zzak
    public final com.google.android.gms.cast.framework.zzat zzh(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zze(parcelZza, iObjectWrapper2);
        zzc.zze(parcelZza, iObjectWrapper3);
        Parcel parcelZzb = zzb(5, parcelZza);
        com.google.android.gms.cast.framework.zzat zzatVarZzb = com.google.android.gms.cast.framework.zzas.zzb(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return zzatVarZzb;
    }

    @Override // com.google.android.gms.internal.cast.zzak
    public final com.google.android.gms.cast.framework.zzaw zzi(String str, String str2, com.google.android.gms.cast.framework.zzbe zzbeVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzc.zze(parcelZza, zzbeVar);
        Parcel parcelZzb = zzb(2, parcelZza);
        com.google.android.gms.cast.framework.zzaw zzawVarZzb = com.google.android.gms.cast.framework.zzav.zzb(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return zzawVarZzb;
    }

    @Override // com.google.android.gms.internal.cast.zzak
    public final com.google.android.gms.cast.framework.media.internal.zzi zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.media.internal.zzk zzkVar, int i10, int i11, boolean z10, long j10, int i12, int i13, int i14) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zze(parcelZza, zzkVar);
        parcelZza.writeInt(i10);
        parcelZza.writeInt(i11);
        parcelZza.writeInt(0);
        parcelZza.writeLong(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        parcelZza.writeInt(5);
        parcelZza.writeInt(333);
        parcelZza.writeInt(AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
        Parcel parcelZzb = zzb(6, parcelZza);
        com.google.android.gms.cast.framework.media.internal.zzi zziVarZzb = com.google.android.gms.cast.framework.media.internal.zzh.zzb(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return zziVarZzb;
    }

    @Override // com.google.android.gms.internal.cast.zzak
    public final com.google.android.gms.cast.framework.media.internal.zzi zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, com.google.android.gms.cast.framework.media.internal.zzk zzkVar, int i10, int i11, boolean z10, long j10, int i12, int i13, int i14) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zze(parcelZza, iObjectWrapper2);
        zzc.zze(parcelZza, zzkVar);
        parcelZza.writeInt(i10);
        parcelZza.writeInt(i11);
        parcelZza.writeInt(0);
        parcelZza.writeLong(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        parcelZza.writeInt(5);
        parcelZza.writeInt(333);
        parcelZza.writeInt(AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
        Parcel parcelZzb = zzb(7, parcelZza);
        com.google.android.gms.cast.framework.media.internal.zzi zziVarZzb = com.google.android.gms.cast.framework.media.internal.zzh.zzb(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return zziVarZzb;
    }
}
