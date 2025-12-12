package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzgx implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzby f8044b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzgu f8045m;

    public zzgx(zzgu zzguVar, com.google.android.gms.internal.measurement.zzby zzbyVar, ServiceConnection serviceConnection) {
        this.f8044b = zzbyVar;
        this.f8045m = zzguVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzgu zzguVar = this.f8045m;
        zzgv zzgvVar = zzguVar.f8041b;
        zzho zzhoVar = zzgvVar.f8042a;
        zzhoVar.zzl().zzt();
        com.google.android.gms.internal.measurement.zzby zzbyVar = this.f8044b;
        if (zzbyVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", zzguVar.f8040a);
            try {
                if (zzbyVar.zza(bundle) == null) {
                    zzhoVar.zzj().zzg().zza("Install Referrer Service returned a null response");
                }
            } catch (Exception e10) {
                zzhoVar.zzj().zzg().zza("Exception occurred while retrieving the Install Referrer", e10.getMessage());
            }
        } else {
            zzhoVar.zzj().zzu().zza("Attempting to use Install Referrer Service while it is not initialized");
        }
        zzgvVar.f8042a.zzl().zzt();
        throw new IllegalStateException("Unexpected call on client side");
    }
}
