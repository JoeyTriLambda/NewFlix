package com.google.android.gms.cast.internal;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzal implements zzas {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzas f6820a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzaq f6821b;

    public zzal(zzaq zzaqVar, zzas zzasVar) {
        this.f6821b = zzaqVar;
        this.f6820a = zzasVar;
    }

    @Override // com.google.android.gms.cast.internal.zzas
    public final void zza(String str, long j10, int i10, Object obj, long j11, long j12) {
        this.f6821b.f6827g = null;
        zzas zzasVar = this.f6820a;
        if (zzasVar != null) {
            zzasVar.zza(str, j10, i10, obj, j11, j12);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzas
    public final void zzb(String str, long j10, long j11, long j12) {
        zzas zzasVar = this.f6820a;
        if (zzasVar != null) {
            zzasVar.zzb(str, j10, j11, j12);
        }
    }
}
