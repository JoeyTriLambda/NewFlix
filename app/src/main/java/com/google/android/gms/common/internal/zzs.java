package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Looper;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zzs extends GmsClientSupervisor {

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f7434d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final Context f7435e;

    /* renamed from: f, reason: collision with root package name */
    public volatile com.google.android.gms.internal.common.zzi f7436f;

    /* renamed from: g, reason: collision with root package name */
    public final ConnectionTracker f7437g;

    /* renamed from: h, reason: collision with root package name */
    public final long f7438h;

    /* renamed from: i, reason: collision with root package name */
    public final long f7439i;

    /* renamed from: j, reason: collision with root package name */
    public volatile Executor f7440j;

    public zzs(Context context, Looper looper) {
        zzr zzrVar = new zzr(this);
        this.f7435e = context.getApplicationContext();
        this.f7436f = new com.google.android.gms.internal.common.zzi(looper, zzrVar);
        this.f7437g = ConnectionTracker.getInstance();
        this.f7438h = 5000L;
        this.f7439i = 300000L;
        this.f7440j = null;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final void zza(zzo zzoVar, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f7434d) {
            zzp zzpVar = (zzp) this.f7434d.get(zzoVar);
            if (zzpVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + zzoVar.toString());
            }
            if (!zzpVar.zzh(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zzoVar.toString());
            }
            zzpVar.zzf(serviceConnection, str);
            if (zzpVar.zzi()) {
                this.f7436f.sendMessageDelayed(this.f7436f.obtainMessage(0, zzoVar), this.f7438h);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean zzc(zzo zzoVar, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean zZzj;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f7434d) {
            zzp zzpVar = (zzp) this.f7434d.get(zzoVar);
            if (executor == null) {
                executor = this.f7440j;
            }
            if (zzpVar == null) {
                zzpVar = new zzp(this, zzoVar);
                zzpVar.zzd(serviceConnection, serviceConnection, str);
                zzpVar.zze(str, executor);
                this.f7434d.put(zzoVar, zzpVar);
            } else {
                this.f7436f.removeMessages(0, zzoVar);
                if (zzpVar.zzh(serviceConnection)) {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zzoVar.toString());
                }
                zzpVar.zzd(serviceConnection, serviceConnection, str);
                int iZza = zzpVar.zza();
                if (iZza == 1) {
                    serviceConnection.onServiceConnected(zzpVar.zzb(), zzpVar.zzc());
                } else if (iZza == 2) {
                    zzpVar.zze(str, executor);
                }
            }
            zZzj = zzpVar.zzj();
        }
        return zZzj;
    }
}
