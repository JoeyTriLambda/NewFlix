package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzpy;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzo extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final zzho f8608a;

    public zzo(zzho zzhoVar) {
        this.f8608a = zzhoVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) throws IllegalStateException {
        final zzho zzhoVar = this.f8608a;
        if (intent == null) {
            zzhoVar.zzj().zzu().zza("App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            zzhoVar.zzj().zzu().zza("App receiver called with null action");
            return;
        }
        if (!action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
            zzhoVar.zzj().zzu().zza("App receiver called with unknown action");
        } else if (zzpy.zza() && zzhoVar.zzf().zzf(null, zzbh.F0)) {
            zzhoVar.zzj().zzp().zza("App receiver notified triggers are available");
            zzhoVar.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzq
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException {
                    zzho zzhoVar2 = zzhoVar;
                    if (!zzhoVar2.zzt().zzw()) {
                        zzhoVar2.zzj().zzu().zza("registerTrigger called but app not eligible");
                        return;
                    }
                    final zziy zziyVarZzp = zzhoVar2.zzp();
                    Objects.requireNonNull(zziyVarZzp);
                    new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzr
                        @Override // java.lang.Runnable
                        public final void run() throws IllegalStateException {
                            zziyVarZzp.zzal();
                        }
                    }).start();
                }
            });
        }
    }
}
