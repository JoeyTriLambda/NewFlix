package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzgw {

    /* renamed from: a, reason: collision with root package name */
    public final zza f8043a;

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    public zzgw(zza zzaVar) {
        Preconditions.checkNotNull(zzaVar);
        this.f8043a = zzaVar;
    }

    public final void zza(Context context, Intent intent) throws IllegalStateException {
        zzgb zzgbVarZzj = zzho.zza(context, null, null).zzj();
        if (intent == null) {
            zzgbVarZzj.zzu().zza("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzgbVarZzj.zzp().zza("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                zzgbVarZzj.zzu().zza("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzgbVarZzj.zzp().zza("Starting wakeful intent.");
            this.f8043a.doStartService(context, className);
        }
    }
}
