package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzcg extends zzcm {
    private String zza;
    private boolean zzb;
    private boolean zzc;
    private zzcl zzd;
    private byte zze;

    public final zzcm zza(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzcm
    public final zzcm zzb(boolean z10) {
        this.zzc = false;
        this.zze = (byte) (this.zze | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzcm
    public final zzcm zza(zzcl zzclVar) {
        if (zzclVar == null) {
            throw new NullPointerException("Null filePurpose");
        }
        this.zzd = zzclVar;
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzcm
    public final zzcm zza(boolean z10) {
        this.zzb = false;
        this.zze = (byte) (this.zze | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzcm
    public final zzcj zza() {
        if (this.zze == 3 && this.zza != null && this.zzd != null) {
            return new zzcd(this.zza, this.zzd);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" fileOwner");
        }
        if ((this.zze & 1) == 0) {
            sb2.append(" hasDifferentDmaOwner");
        }
        if ((this.zze & 2) == 0) {
            sb2.append(" skipChecks");
        }
        if (this.zzd == null) {
            sb2.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:".concat(String.valueOf(sb2)));
    }
}
