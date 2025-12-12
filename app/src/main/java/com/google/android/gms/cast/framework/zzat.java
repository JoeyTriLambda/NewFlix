package com.google.android.gms.cast.framework;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public interface zzat extends IInterface {
    int zze(Intent intent, int i10, int i11) throws RemoteException;

    IBinder zzf(Intent intent) throws RemoteException;

    void zzg() throws RemoteException;

    void zzh() throws RemoteException;
}
