package com.google.android.gms.cast;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzg extends zzp {
    @Override // com.google.android.gms.cast.zzp, com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    /* renamed from: zza */
    public final void doExecute(com.google.android.gms.cast.internal.zzw zzwVar) throws RemoteException {
        try {
            LaunchOptions launchOptions = new LaunchOptions();
            launchOptions.setRelaunchIfRunning(false);
            zzwVar.zzM(null, launchOptions, this);
        } catch (IllegalStateException unused) {
            zzc(2001);
        }
    }
}
