package com.google.android.gms.internal.cast;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public interface zzak extends IInterface {
    int zze() throws RemoteException;

    com.google.android.gms.cast.framework.zzaj zzf(IObjectWrapper iObjectWrapper, CastOptions castOptions, zzam zzamVar, Map map) throws RemoteException;

    com.google.android.gms.cast.framework.zzam zzg(CastOptions castOptions, IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.zzag zzagVar) throws RemoteException;

    com.google.android.gms.cast.framework.zzat zzh(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    com.google.android.gms.cast.framework.zzaw zzi(String str, String str2, com.google.android.gms.cast.framework.zzbe zzbeVar) throws RemoteException;

    com.google.android.gms.cast.framework.media.internal.zzi zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.media.internal.zzk zzkVar, int i10, int i11, boolean z10, long j10, int i12, int i13, int i14) throws RemoteException;

    com.google.android.gms.cast.framework.media.internal.zzi zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, com.google.android.gms.cast.framework.media.internal.zzk zzkVar, int i10, int i11, boolean z10, long j10, int i12, int i13, int i14) throws RemoteException;
}
