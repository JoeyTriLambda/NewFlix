package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzld extends zzav {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzla f8399e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzld(zzla zzlaVar, zzio zzioVar) {
        super(zzioVar);
        this.f8399e = zzlaVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzav
    public final void zzb() throws IllegalStateException {
        zzla zzlaVar = this.f8399e;
        zzlaVar.zzt();
        if (zzlaVar.zzah()) {
            zzlaVar.zzj().zzp().zza("Inactivity, disconnecting from the service");
            zzlaVar.zzae();
        }
    }
}
