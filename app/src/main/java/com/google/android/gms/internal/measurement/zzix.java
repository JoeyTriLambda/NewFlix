package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzix extends zziu {
    private final byte[] zzd;
    private final boolean zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    private final void zzaa() {
        int i10 = this.zzf + this.zzg;
        this.zzf = i10;
        int i11 = i10 - this.zzi;
        int i12 = this.zzk;
        if (i11 <= i12) {
            this.zzg = 0;
            return;
        }
        int i13 = i11 - i12;
        this.zzg = i13;
        this.zzf = i10 - i13;
    }

    private final byte zzv() throws IOException {
        int i10 = this.zzh;
        if (i10 == this.zzf) {
            throw zzkb.zzh();
        }
        byte[] bArr = this.zzd;
        this.zzh = i10 + 1;
        return bArr[i10];
    }

    private final int zzw() throws IOException {
        int i10 = this.zzh;
        if (this.zzf - i10 < 4) {
            throw zzkb.zzh();
        }
        byte[] bArr = this.zzd;
        this.zzh = i10 + 4;
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
    
        if (r2[r3] >= 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzx() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzh
            int r1 = r5.zzf
            if (r1 == r0) goto L6b
            byte[] r2 = r5.zzd
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.zzh = r3
            return r0
        L11:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6b
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L22
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L68
        L22:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L2f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2d:
            r1 = r3
            goto L68
        L2f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L68
        L3d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6b
        L68:
            r5.zzh = r1
            return r0
        L6b:
            long r0 = r5.zzm()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzix.zzx():int");
    }

    private final long zzy() throws IOException {
        int i10 = this.zzh;
        if (this.zzf - i10 < 8) {
            throw zzkb.zzh();
        }
        byte[] bArr = this.zzd;
        this.zzh = i10 + 8;
        return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b0, code lost:
    
        if (r2[r0] >= 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long zzz() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 189
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzix.zzz():long");
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzw());
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final int zzc() {
        return this.zzh - this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final int zzd() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final int zze() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final int zzf() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final int zzg() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final int zzh() throws IOException {
        return zziu.zza(zzx());
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final int zzi() throws IOException {
        if (zzt()) {
            this.zzj = 0;
            return 0;
        }
        int iZzx = zzx();
        this.zzj = iZzx;
        if ((iZzx >>> 3) != 0) {
            return iZzx;
        }
        throw zzkb.zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final int zzj() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final long zzk() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final long zzl() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final long zzm() throws IOException {
        long j10 = 0;
        for (int i10 = 0; i10 < 64; i10 += 7) {
            j10 |= (r3 & 127) << i10;
            if ((zzv() & 128) == 0) {
                return j10;
            }
        }
        throw zzkb.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final long zzn() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final long zzo() throws IOException {
        return zziu.zza(zzz());
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final long zzp() throws IOException {
        return zzz();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    @Override // com.google.android.gms.internal.measurement.zziu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.measurement.zzij zzq() throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.zzx()
            if (r0 <= 0) goto L19
            int r1 = r3.zzf
            int r2 = r3.zzh
            int r1 = r1 - r2
            if (r0 > r1) goto L19
            byte[] r1 = r3.zzd
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza(r1, r2, r0)
            int r2 = r3.zzh
            int r2 = r2 + r0
            r3.zzh = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.google.android.gms.internal.measurement.zzij r0 = com.google.android.gms.internal.measurement.zzij.zza
            return r0
        L1e:
            if (r0 <= 0) goto L31
            int r1 = r3.zzf
            int r2 = r3.zzh
            int r1 = r1 - r2
            if (r0 > r1) goto L31
            int r0 = r0 + r2
            r3.zzh = r0
            byte[] r1 = r3.zzd
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r2, r0)
            goto L37
        L31:
            if (r0 > 0) goto L41
            if (r0 != 0) goto L3c
            byte[] r0 = com.google.android.gms.internal.measurement.zzjw.zzb
        L37:
            com.google.android.gms.internal.measurement.zzij r0 = com.google.android.gms.internal.measurement.zzij.zza(r0)
            return r0
        L3c:
            com.google.android.gms.internal.measurement.zzkb r0 = com.google.android.gms.internal.measurement.zzkb.zzf()
            throw r0
        L41:
            com.google.android.gms.internal.measurement.zzkb r0 = com.google.android.gms.internal.measurement.zzkb.zzh()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzix.zzq():com.google.android.gms.internal.measurement.zzij");
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final String zzr() throws IOException {
        int iZzx = zzx();
        if (iZzx > 0) {
            int i10 = this.zzf;
            int i11 = this.zzh;
            if (iZzx <= i10 - i11) {
                String str = new String(this.zzd, i11, iZzx, zzjw.zza);
                this.zzh += iZzx;
                return str;
            }
        }
        if (iZzx == 0) {
            return "";
        }
        if (iZzx < 0) {
            throw zzkb.zzf();
        }
        throw zzkb.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final String zzs() throws IOException {
        int iZzx = zzx();
        if (iZzx > 0) {
            int i10 = this.zzf;
            int i11 = this.zzh;
            if (iZzx <= i10 - i11) {
                String strZzb = zznd.zzb(this.zzd, i11, iZzx);
                this.zzh += iZzx;
                return strZzb;
            }
        }
        if (iZzx == 0) {
            return "";
        }
        if (iZzx <= 0) {
            throw zzkb.zzf();
        }
        throw zzkb.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final boolean zzt() throws IOException {
        return this.zzh == this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final boolean zzu() throws IOException {
        return zzz() != 0;
    }

    private zzix(byte[] bArr, int i10, int i11, boolean z10) {
        super();
        this.zzk = Integer.MAX_VALUE;
        this.zzd = bArr;
        this.zzf = i11 + i10;
        this.zzh = i10;
        this.zzi = i10;
        this.zze = z10;
    }

    private final void zzf(int i10) throws IOException {
        if (i10 >= 0) {
            int i11 = this.zzf;
            int i12 = this.zzh;
            if (i10 <= i11 - i12) {
                this.zzh = i12 + i10;
                return;
            }
        }
        if (i10 >= 0) {
            throw zzkb.zzh();
        }
        throw zzkb.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final int zzb(int i10) throws zzkb {
        if (i10 < 0) {
            throw zzkb.zzf();
        }
        int iZzc = i10 + zzc();
        if (iZzc < 0) {
            throw zzkb.zzg();
        }
        int i11 = this.zzk;
        if (iZzc > i11) {
            throw zzkb.zzh();
        }
        this.zzk = iZzc;
        zzaa();
        return i11;
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final void zzc(int i10) throws zzkb {
        if (this.zzj != i10) {
            throw zzkb.zzb();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final void zzd(int i10) {
        this.zzk = i10;
        zzaa();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final boolean zze(int i10) throws IOException {
        int iZzi;
        int i11 = i10 & 7;
        int i12 = 0;
        if (i11 == 0) {
            if (this.zzf - this.zzh < 10) {
                while (i12 < 10) {
                    if (zzv() < 0) {
                        i12++;
                    }
                }
                throw zzkb.zze();
            }
            while (i12 < 10) {
                byte[] bArr = this.zzd;
                int i13 = this.zzh;
                this.zzh = i13 + 1;
                if (bArr[i13] < 0) {
                    i12++;
                }
            }
            throw zzkb.zze();
            return true;
        }
        if (i11 == 1) {
            zzf(8);
            return true;
        }
        if (i11 == 2) {
            zzf(zzx());
            return true;
        }
        if (i11 != 3) {
            if (i11 == 4) {
                return false;
            }
            if (i11 != 5) {
                throw zzkb.zza();
            }
            zzf(4);
            return true;
        }
        do {
            iZzi = zzi();
            if (iZzi == 0) {
                break;
            }
        } while (zze(iZzi));
        zzc(((i10 >>> 3) << 3) | 4);
        return true;
    }
}
