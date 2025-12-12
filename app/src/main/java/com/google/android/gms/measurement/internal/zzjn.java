package com.google.android.gms.measurement.internal;

import e8.a;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzjn implements a<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzmv f8270a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zziy f8271b;

    public zzjn(zziy zziyVar, zzmv zzmvVar) {
        this.f8270a = zzmvVar;
        this.f8271b = zziyVar;
    }

    @Override // e8.a
    public final void onFailure(Throwable th2) throws IllegalStateException {
        zziy zziyVar = this.f8271b;
        zziyVar.zzt();
        zziyVar.f8234i = false;
        zziyVar.k();
        zziyVar.zzj().zzg().zza("registerTriggerAsync failed with throwable", th2);
    }

    @Override // e8.a
    public final void onSuccess(Object obj) throws IllegalStateException {
        zziy zziyVar = this.f8271b;
        zziyVar.zzt();
        zziyVar.f8234i = false;
        zziyVar.k();
        zziyVar.zzj().zzc().zza("registerTriggerAsync ran. uri", this.f8270a.f8517b);
    }
}
