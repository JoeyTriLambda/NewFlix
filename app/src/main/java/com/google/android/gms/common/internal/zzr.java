package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zzr implements Handler.Callback {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzs f7433b;

    public /* synthetic */ zzr(zzs zzsVar) {
        this.f7433b = zzsVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            synchronized (this.f7433b.f7434d) {
                try {
                    zzo zzoVar = (zzo) message.obj;
                    zzp zzpVar = (zzp) this.f7433b.f7434d.get(zzoVar);
                    if (zzpVar != null && zzpVar.zzi()) {
                        if (zzpVar.zzj()) {
                            zzpVar.zzg("GmsClientSupervisor");
                        }
                        this.f7433b.f7434d.remove(zzoVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return true;
        }
        if (i10 != 1) {
            return false;
        }
        synchronized (this.f7433b.f7434d) {
            zzo zzoVar2 = (zzo) message.obj;
            zzp zzpVar2 = (zzp) this.f7433b.f7434d.get(zzoVar2);
            if (zzpVar2 != null && zzpVar2.zza() == 3) {
                Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(zzoVar2)), new Exception());
                ComponentName componentNameZzb = zzpVar2.zzb();
                if (componentNameZzb == null) {
                    componentNameZzb = zzoVar2.zza();
                }
                if (componentNameZzb == null) {
                    String strZzc = zzoVar2.zzc();
                    Preconditions.checkNotNull(strZzc);
                    componentNameZzb = new ComponentName(strZzc, "unknown");
                }
                zzpVar2.onServiceDisconnected(componentNameZzb);
            }
        }
        return true;
    }
}
