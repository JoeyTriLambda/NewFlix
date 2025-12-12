package com.google.android.gms.internal.cast;

import ac.c;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
class zzsr extends zzsq {
    protected final byte[] zza;

    public zzsr(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.cast.zzsu
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzsu) || zzd() != ((zzsu) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzsr)) {
            return obj.equals(this);
        }
        zzsr zzsrVar = (zzsr) obj;
        int iZzk = zzk();
        int iZzk2 = zzsrVar.zzk();
        if (iZzk != 0 && iZzk2 != 0 && iZzk != iZzk2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzsrVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzsrVar.zzd()) {
            throw new IllegalArgumentException(c.g("Ran off end of other: 0, ", iZzd, ", ", zzsrVar.zzd()));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzsrVar.zza;
        zzsrVar.zzc();
        int i10 = 0;
        int i11 = 0;
        while (i10 < iZzd) {
            if (bArr[i10] != bArr2[i11]) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.cast.zzsu
    public byte zza(int i10) {
        return this.zza[i10];
    }

    @Override // com.google.android.gms.internal.cast.zzsu
    public byte zzb(int i10) {
        return this.zza[i10];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzsu
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.cast.zzsu
    public final int zze(int i10, int i11, int i12) {
        return zzty.zzb(i10, this.zza, 0, i12);
    }

    @Override // com.google.android.gms.internal.cast.zzsu
    public final zzsu zzf(int i10, int i11) {
        zzsu.zzj(0, i11, zzd());
        return i11 == 0 ? zzsu.zzb : new zzso(this.zza, 0, i11);
    }

    @Override // com.google.android.gms.internal.cast.zzsu
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.cast.zzsu
    public final void zzh(zzsk zzskVar) throws IOException {
        ((zzsz) zzskVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.cast.zzsu
    public final boolean zzi() {
        return zzwn.zze(this.zza, 0, zzd());
    }
}
