package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzmw extends zzav {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzmx f8520e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzmw(zzmx zzmxVar, zzho zzhoVar) {
        super(zzhoVar);
        this.f8520e = zzmxVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzav
    public final void zzb() throws IllegalStateException {
        zzmx zzmxVar = this.f8520e;
        zzmxVar.zzu();
        zzmxVar.zzj().zzp().zza("Starting upload from DelayedRunnable");
        zzmxVar.f8525b.L();
    }
}
