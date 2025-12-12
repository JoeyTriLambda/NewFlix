package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzkg implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzax f8321b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zziy f8322m;

    public zzkg(zziy zziyVar, zzax zzaxVar) {
        this.f8321b = zzaxVar;
        this.f8322m = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        boolean z10;
        zziy zziyVar = this.f8322m;
        zzgm zzgmVarZzk = zziyVar.zzk();
        zzgmVarZzk.zzt();
        zzax zzaxVarD = zzgmVarZzk.d();
        zzax zzaxVar = this.f8321b;
        if (zziq.zza(zzaxVar.zza(), zzaxVarD.zza())) {
            SharedPreferences.Editor editorEdit = zzgmVarZzk.zzg().edit();
            editorEdit.putString("dma_consent_settings", zzaxVar.zzf());
            editorEdit.apply();
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            zziyVar.zzo().zza(false);
        } else {
            zziyVar.zzj().zzn().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzaxVar.zza()));
        }
    }
}
