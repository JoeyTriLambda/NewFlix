package com.google.android.gms.cast.internal;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzam implements zzas {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzas f6822a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzaq f6823b;

    public zzam(zzaq zzaqVar, zzas zzasVar) {
        this.f6823b = zzaqVar;
        this.f6822a = zzasVar;
    }

    @Override // com.google.android.gms.cast.internal.zzas
    public final void zza(String str, long j10, int i10, Object obj, long j11, long j12) {
        int i11;
        if (this.f6822a != null) {
            if (i10 == 2001) {
                zzaq zzaqVar = this.f6823b;
                zzaqVar.f6863a.w("Possibility of local queue out of sync with receiver queue. Refetching sequence number. Current Local Sequence Number = %d", Integer.valueOf(zzaqVar.f6829i));
                zzaqVar.f6828h.zzl();
                i11 = 2001;
            } else {
                i11 = i10;
            }
            this.f6822a.zza(str, j10, i11, obj, j11, j12);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzas
    public final void zzb(String str, long j10, long j11, long j12) {
        zzas zzasVar = this.f6822a;
        if (zzasVar != null) {
            zzasVar.zzb(str, j10, j11, j12);
        }
    }
}
