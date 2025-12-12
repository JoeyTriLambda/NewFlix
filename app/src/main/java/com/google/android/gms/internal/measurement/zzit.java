package com.google.android.gms.internal.measurement;

import ac.c;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
class zzit extends zziq {
    protected final byte[] zzb;

    public zzit(byte[] bArr) {
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzij
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzij) || zzb() != ((zzij) obj).zzb()) {
            return false;
        }
        if (zzb() == 0) {
            return true;
        }
        if (!(obj instanceof zzit)) {
            return obj.equals(this);
        }
        zzit zzitVar = (zzit) obj;
        int iZza = zza();
        int iZza2 = zzitVar.zza();
        if (iZza == 0 || iZza2 == 0 || iZza == iZza2) {
            return zza(zzitVar, 0, zzb());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzij
    public byte zza(int i10) {
        return this.zzb[i10];
    }

    @Override // com.google.android.gms.internal.measurement.zzij
    public byte zzb(int i10) {
        return this.zzb[i10];
    }

    @Override // com.google.android.gms.internal.measurement.zzij
    public final boolean zzd() {
        int iZze = zze();
        return zznd.zzc(this.zzb, iZze, zzb() + iZze);
    }

    public int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzij
    public final zzij zza(int i10, int i11) {
        int iZza = zzij.zza(0, i11, zzb());
        return iZza == 0 ? zzij.zza : new zzin(this.zzb, zze(), iZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzij
    public final int zzb(int i10, int i11, int i12) {
        return zzjw.zza(i10, this.zzb, zze(), i12);
    }

    @Override // com.google.android.gms.internal.measurement.zzij
    public int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzij
    public final String zza(Charset charset) {
        return new String(this.zzb, zze(), zzb(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzij
    public final void zza(zzig zzigVar) throws IOException {
        zzigVar.zza(this.zzb, zze(), zzb());
    }

    @Override // com.google.android.gms.internal.measurement.zziq
    public final boolean zza(zzij zzijVar, int i10, int i11) {
        if (i11 <= zzijVar.zzb()) {
            if (i11 <= zzijVar.zzb()) {
                if (zzijVar instanceof zzit) {
                    zzit zzitVar = (zzit) zzijVar;
                    byte[] bArr = this.zzb;
                    byte[] bArr2 = zzitVar.zzb;
                    int iZze = zze() + i11;
                    int iZze2 = zze();
                    int iZze3 = zzitVar.zze();
                    while (iZze2 < iZze) {
                        if (bArr[iZze2] != bArr2[iZze3]) {
                            return false;
                        }
                        iZze2++;
                        iZze3++;
                    }
                    return true;
                }
                return zzijVar.zza(0, i11).equals(zza(0, i11));
            }
            throw new IllegalArgumentException(c.g("Ran off end of other: 0, ", i11, ", ", zzijVar.zzb()));
        }
        throw new IllegalArgumentException("Length too large: " + i11 + zzb());
    }
}
