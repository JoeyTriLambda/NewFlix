package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
class zzgl extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final zznd f7989a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7990b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7991c;

    public zzgl(zznd zzndVar) {
        Preconditions.checkNotNull(zzndVar);
        this.f7989a = zzndVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws IllegalStateException {
        zznd zzndVar = this.f7989a;
        zzndVar.K();
        String action = intent.getAction();
        zzndVar.zzj().zzp().zza("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            zzndVar.zzj().zzu().zza("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zZzu = zzndVar.zzh().zzu();
        if (this.f7991c != zZzu) {
            this.f7991c = zZzu;
            zzndVar.zzl().zzb(new zzgk(this, zZzu));
        }
    }

    public final void zza() {
        zznd zzndVar = this.f7989a;
        zzndVar.K();
        zzndVar.zzl().zzt();
        if (this.f7990b) {
            return;
        }
        zzndVar.zza().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f7991c = zzndVar.zzh().zzu();
        zzndVar.zzj().zzp().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f7991c));
        this.f7990b = true;
    }

    public final void zzb() {
        zznd zzndVar = this.f7989a;
        zzndVar.K();
        zzndVar.zzl().zzt();
        zzndVar.zzl().zzt();
        if (this.f7990b) {
            zzndVar.zzj().zzp().zza("Unregistering connectivity change receiver");
            this.f7990b = false;
            this.f7991c = false;
            try {
                zzndVar.zza().unregisterReceiver(this);
            } catch (IllegalArgumentException e10) {
                zzndVar.zzj().zzg().zza("Failed to unregister the network broadcast receiver", e10);
            }
        }
    }
}
