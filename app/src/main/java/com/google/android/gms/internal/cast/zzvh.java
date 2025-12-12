package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzvh implements zzuu {
    private final zzux zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzvh(zzux zzuxVar, String str, Object[] objArr) {
        this.zza = zzuxVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i10 = cCharAt & 8191;
        int i11 = 1;
        int i12 = 13;
        while (true) {
            int i13 = i11 + 1;
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 < 55296) {
                this.zzd = i10 | (cCharAt2 << i12);
                return;
            } else {
                i10 |= (cCharAt2 & 8191) << i12;
                i12 += 13;
                i11 = i13;
            }
        }
    }

    @Override // com.google.android.gms.internal.cast.zzuu
    public final zzux zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.cast.zzuu
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.cast.zzuu
    public final int zzc() {
        int i10 = this.zzd;
        if ((i10 & 1) != 0) {
            return 1;
        }
        return (i10 & 4) == 4 ? 3 : 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
