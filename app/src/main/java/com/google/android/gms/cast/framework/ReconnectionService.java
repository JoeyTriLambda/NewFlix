package com.google.android.gms.cast.framework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public class ReconnectionService extends Service {

    /* renamed from: m, reason: collision with root package name */
    public static final Logger f6389m = new Logger("ReconnectionService");

    /* renamed from: b, reason: collision with root package name */
    public zzat f6390b;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        zzat zzatVar = this.f6390b;
        if (zzatVar != null) {
            try {
                return zzatVar.zzf(intent);
            } catch (RemoteException e10) {
                f6389m.d(e10, "Unable to call %s on %s.", "onBind", "zzat");
            }
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() throws IllegalStateException {
        CastContext sharedInstance = CastContext.getSharedInstance(this);
        zzat zzatVarZzc = com.google.android.gms.internal.cast.zzag.zzc(this, sharedInstance.getSessionManager().zzb(), sharedInstance.zzc().zza());
        this.f6390b = zzatVarZzc;
        if (zzatVarZzc != null) {
            try {
                zzatVarZzc.zzg();
            } catch (RemoteException e10) {
                f6389m.d(e10, "Unable to call %s on %s.", "onCreate", "zzat");
            }
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        zzat zzatVar = this.f6390b;
        if (zzatVar != null) {
            try {
                zzatVar.zzh();
            } catch (RemoteException e10) {
                f6389m.d(e10, "Unable to call %s on %s.", "onDestroy", "zzat");
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        zzat zzatVar = this.f6390b;
        if (zzatVar != null) {
            try {
                return zzatVar.zze(intent, i10, i11);
            } catch (RemoteException e10) {
                f6389m.d(e10, "Unable to call %s on %s.", "onStartCommand", "zzat");
            }
        }
        return 2;
    }
}
