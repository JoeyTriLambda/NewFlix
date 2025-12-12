package com.google.android.gms.internal.cast;

import ac.c;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzso extends zzsr {
    private final int zzc;

    public zzso(byte[] bArr, int i10, int i11) {
        super(bArr);
        zzsu.zzj(0, i11, bArr.length);
        this.zzc = i11;
    }

    @Override // com.google.android.gms.internal.cast.zzsr, com.google.android.gms.internal.cast.zzsu
    public final byte zza(int i10) {
        int i11 = this.zzc;
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return this.zza[i10];
        }
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException(c.f("Index < 0: ", i10));
        }
        throw new ArrayIndexOutOfBoundsException(c.g("Index > length: ", i10, ", ", i11));
    }

    @Override // com.google.android.gms.internal.cast.zzsr, com.google.android.gms.internal.cast.zzsu
    public final byte zzb(int i10) {
        return this.zza[i10];
    }

    @Override // com.google.android.gms.internal.cast.zzsr
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzsr, com.google.android.gms.internal.cast.zzsu
    public final int zzd() {
        return this.zzc;
    }
}
