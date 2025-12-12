package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzgu implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final String f8040a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzgv f8041b;

    public zzgu(zzgv zzgvVar, String str) {
        this.f8041b = zzgvVar;
        this.f8040a = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) throws IllegalStateException {
        zzgv zzgvVar = this.f8041b;
        if (iBinder == null) {
            zzgvVar.f8042a.zzj().zzu().zza("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.zzby zzbyVarZza = com.google.android.gms.internal.measurement.zzcb.zza(iBinder);
            if (zzbyVarZza == null) {
                zzgvVar.f8042a.zzj().zzu().zza("Install Referrer Service implementation was not found");
            } else {
                zzgvVar.f8042a.zzj().zzp().zza("Install Referrer Service connected");
                zzgvVar.f8042a.zzl().zzb(new zzgx(this, zzbyVarZza, this));
            }
        } catch (RuntimeException e10) {
            zzgvVar.f8042a.zzj().zzu().zza("Exception occurred while calling Install Referrer API", e10);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) throws IllegalStateException {
        this.f8041b.f8042a.zzj().zzp().zza("Install Referrer Service disconnected");
    }
}
