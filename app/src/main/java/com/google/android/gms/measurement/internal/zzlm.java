package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlm extends zzav {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzla f8420e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzlm(zzla zzlaVar, zzio zzioVar) {
        super(zzioVar);
        this.f8420e = zzlaVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzav
    public final void zzb() throws IllegalStateException {
        this.f8420e.zzj().zzu().zza("Tasks have been queued for a long time");
    }
}
