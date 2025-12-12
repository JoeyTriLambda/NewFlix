package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
public final class zzmw {
    private static final zzmw zza = new zzmw(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzmw() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzmw zzc() {
        return zza;
    }

    public static zzmw zzd() {
        return new zzmw();
    }

    private final void zzf() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzmw)) {
            return false;
        }
        zzmw zzmwVar = (zzmw) obj;
        int i10 = this.zzb;
        if (i10 == zzmwVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzmwVar.zzc;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    z10 = true;
                    break;
                }
                if (iArr[i11] != iArr2[i11]) {
                    z10 = false;
                    break;
                }
                i11++;
            }
            if (z10) {
                Object[] objArr = this.zzd;
                Object[] objArr2 = zzmwVar.zzd;
                int i12 = this.zzb;
                int i13 = 0;
                while (true) {
                    if (i13 >= i12) {
                        z11 = true;
                        break;
                    }
                    if (!objArr[i13].equals(objArr2[i13])) {
                        z11 = false;
                        break;
                    }
                    i13++;
                }
                if (z11) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.zzb;
        int i11 = (i10 + 527) * 31;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i12 = 17;
        for (int i13 = 0; i13 < i10; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        int i14 = (i11 + i12) * 31;
        Object[] objArr = this.zzd;
        int i15 = this.zzb;
        for (int i16 = 0; i16 < i15; i16++) {
            iHashCode = (iHashCode * 31) + objArr[i16].hashCode();
        }
        return i14 + iHashCode;
    }

    public final int zza() {
        int iZze;
        int i10 = this.zze;
        if (i10 != -1) {
            return i10;
        }
        int iZza = 0;
        for (int i11 = 0; i11 < this.zzb; i11++) {
            int i12 = this.zzc[i11];
            int i13 = i12 >>> 3;
            int i14 = i12 & 7;
            if (i14 == 0) {
                iZze = zzja.zze(i13, ((Long) this.zzd[i11]).longValue());
            } else if (i14 == 1) {
                iZze = zzja.zza(i13, ((Long) this.zzd[i11]).longValue());
            } else if (i14 == 2) {
                iZze = zzja.zza(i13, (zzij) this.zzd[i11]);
            } else if (i14 == 3) {
                iZza = ((zzmw) this.zzd[i11]).zza() + (zzja.zzf(i13) << 1) + iZza;
            } else {
                if (i14 != 5) {
                    throw new IllegalStateException(zzkb.zza());
                }
                iZze = zzja.zzb(i13, ((Integer) this.zzd[i11]).intValue());
            }
            iZza = iZze + iZza;
        }
        this.zze = iZza;
        return iZza;
    }

    public final int zzb() {
        int i10 = this.zze;
        if (i10 != -1) {
            return i10;
        }
        int iZzb = 0;
        for (int i11 = 0; i11 < this.zzb; i11++) {
            iZzb += zzja.zzb(this.zzc[i11] >>> 3, (zzij) this.zzd[i11]);
        }
        this.zze = iZzb;
        return iZzb;
    }

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    private zzmw(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.zze = -1;
        this.zzb = i10;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z10;
    }

    public final void zzb(zznt zzntVar) throws IOException {
        if (this.zzb == 0) {
            return;
        }
        if (zzntVar.zza() == zzns.zza) {
            for (int i10 = 0; i10 < this.zzb; i10++) {
                zza(this.zzc[i10], this.zzd[i10], zzntVar);
            }
            return;
        }
        for (int i11 = this.zzb - 1; i11 >= 0; i11--) {
            zza(this.zzc[i11], this.zzd[i11], zzntVar);
        }
    }

    public final zzmw zza(zzmw zzmwVar) {
        if (zzmwVar.equals(zza)) {
            return this;
        }
        zzf();
        int i10 = this.zzb + zzmwVar.zzb;
        zza(i10);
        System.arraycopy(zzmwVar.zzc, 0, this.zzc, this.zzb, zzmwVar.zzb);
        System.arraycopy(zzmwVar.zzd, 0, this.zzd, this.zzb, zzmwVar.zzb);
        this.zzb = i10;
        return this;
    }

    public static zzmw zza(zzmw zzmwVar, zzmw zzmwVar2) {
        int i10 = zzmwVar.zzb + zzmwVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzmwVar.zzc, i10);
        System.arraycopy(zzmwVar2.zzc, 0, iArrCopyOf, zzmwVar.zzb, zzmwVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzmwVar.zzd, i10);
        System.arraycopy(zzmwVar2.zzd, 0, objArrCopyOf, zzmwVar.zzb, zzmwVar2.zzb);
        return new zzmw(i10, iArrCopyOf, objArrCopyOf, true);
    }

    private final void zza(int i10) {
        int[] iArr = this.zzc;
        if (i10 > iArr.length) {
            int i11 = this.zzb;
            int i12 = (i11 / 2) + i11;
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i10);
            this.zzd = Arrays.copyOf(this.zzd, i10);
        }
    }

    public final void zza(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.zzb; i11++) {
            zzlh.zza(sb2, i10, String.valueOf(this.zzc[i11] >>> 3), this.zzd[i11]);
        }
    }

    public final void zza(int i10, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i11 = this.zzb;
        iArr[i11] = i10;
        this.zzd[i11] = obj;
        this.zzb = i11 + 1;
    }

    public final void zza(zznt zzntVar) throws IOException {
        if (zzntVar.zza() == zzns.zzb) {
            for (int i10 = this.zzb - 1; i10 >= 0; i10--) {
                zzntVar.zza(this.zzc[i10] >>> 3, this.zzd[i10]);
            }
            return;
        }
        for (int i11 = 0; i11 < this.zzb; i11++) {
            zzntVar.zza(this.zzc[i11] >>> 3, this.zzd[i11]);
        }
    }

    private static void zza(int i10, Object obj, zznt zzntVar) throws IOException {
        int i11 = i10 >>> 3;
        int i12 = i10 & 7;
        if (i12 == 0) {
            zzntVar.zzb(i11, ((Long) obj).longValue());
            return;
        }
        if (i12 == 1) {
            zzntVar.zza(i11, ((Long) obj).longValue());
            return;
        }
        if (i12 == 2) {
            zzntVar.zza(i11, (zzij) obj);
            return;
        }
        if (i12 != 3) {
            if (i12 == 5) {
                zzntVar.zzb(i11, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzkb.zza());
        }
        if (zzntVar.zza() == zzns.zza) {
            zzntVar.zzb(i11);
            ((zzmw) obj).zzb(zzntVar);
            zzntVar.zza(i11);
        } else {
            zzntVar.zza(i11);
            ((zzmw) obj).zzb(zzntVar);
            zzntVar.zzb(i11);
        }
    }
}
