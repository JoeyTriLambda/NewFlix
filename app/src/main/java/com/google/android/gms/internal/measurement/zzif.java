package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzif {
    public static double zza(byte[] bArr, int i10) {
        return Double.longBitsToDouble(zzd(bArr, i10));
    }

    public static float zzb(byte[] bArr, int i10) {
        return Float.intBitsToFloat(zzc(bArr, i10));
    }

    public static int zzc(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    public static int zzd(byte[] bArr, int i10, zzie zzieVar) {
        int i11 = i10 + 1;
        long j10 = bArr[i10];
        if (j10 >= 0) {
            zzieVar.zzb = j10;
            return i11;
        }
        int i12 = i11 + 1;
        byte b10 = bArr[i11];
        long j11 = (j10 & 127) | ((b10 & 127) << 7);
        int i13 = 7;
        while (b10 < 0) {
            int i14 = i12 + 1;
            i13 += 7;
            j11 |= (r10 & 127) << i13;
            b10 = bArr[i12];
            i12 = i14;
        }
        zzieVar.zzb = j11;
        return i12;
    }

    public static int zza(byte[] bArr, int i10, zzie zzieVar) throws zzkb {
        int iZzc = zzc(bArr, i10, zzieVar);
        int i11 = zzieVar.zza;
        if (i11 < 0) {
            throw zzkb.zzf();
        }
        if (i11 > bArr.length - iZzc) {
            throw zzkb.zzh();
        }
        if (i11 == 0) {
            zzieVar.zzc = zzij.zza;
            return iZzc;
        }
        zzieVar.zzc = zzij.zza(bArr, iZzc, i11);
        return iZzc + i11;
    }

    public static int zzb(byte[] bArr, int i10, zzie zzieVar) throws zzkb {
        int iZzc = zzc(bArr, i10, zzieVar);
        int i11 = zzieVar.zza;
        if (i11 < 0) {
            throw zzkb.zzf();
        }
        if (i11 == 0) {
            zzieVar.zzc = "";
            return iZzc;
        }
        zzieVar.zzc = zznd.zzb(bArr, iZzc, i11);
        return iZzc + i11;
    }

    public static int zzc(byte[] bArr, int i10, zzie zzieVar) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return zza(b10, bArr, i11, zzieVar);
        }
        zzieVar.zza = b10;
        return i11;
    }

    public static long zzd(byte[] bArr, int i10) {
        return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
    }

    public static int zza(zzly zzlyVar, byte[] bArr, int i10, int i11, int i12, zzie zzieVar) throws IOException {
        Object objZza = zzlyVar.zza();
        int iZza = zza(objZza, zzlyVar, bArr, i10, i11, i12, zzieVar);
        zzlyVar.zzc(objZza);
        zzieVar.zzc = objZza;
        return iZza;
    }

    public static int zza(zzly zzlyVar, byte[] bArr, int i10, int i11, zzie zzieVar) throws IOException {
        Object objZza = zzlyVar.zza();
        int iZza = zza(objZza, zzlyVar, bArr, i10, i11, zzieVar);
        zzlyVar.zzc(objZza);
        zzieVar.zzc = objZza;
        return iZza;
    }

    public static int zza(zzly<?> zzlyVar, int i10, byte[] bArr, int i11, int i12, zzkc<?> zzkcVar, zzie zzieVar) throws IOException {
        int iZza = zza(zzlyVar, bArr, i11, i12, zzieVar);
        zzkcVar.add(zzieVar.zzc);
        while (iZza < i12) {
            int iZzc = zzc(bArr, iZza, zzieVar);
            if (i10 != zzieVar.zza) {
                break;
            }
            iZza = zza(zzlyVar, bArr, iZzc, i12, zzieVar);
            zzkcVar.add(zzieVar.zzc);
        }
        return iZza;
    }

    public static int zza(byte[] bArr, int i10, zzkc<?> zzkcVar, zzie zzieVar) throws IOException {
        zzju zzjuVar = (zzju) zzkcVar;
        int iZzc = zzc(bArr, i10, zzieVar);
        int i11 = zzieVar.zza + iZzc;
        while (iZzc < i11) {
            iZzc = zzc(bArr, iZzc, zzieVar);
            zzjuVar.zzd(zzieVar.zza);
        }
        if (iZzc == i11) {
            return iZzc;
        }
        throw zzkb.zzh();
    }

    public static int zza(int i10, byte[] bArr, int i11, int i12, zzmw zzmwVar, zzie zzieVar) throws zzkb {
        if ((i10 >>> 3) == 0) {
            throw zzkb.zzc();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            int iZzd = zzd(bArr, i11, zzieVar);
            zzmwVar.zza(i10, Long.valueOf(zzieVar.zzb));
            return iZzd;
        }
        if (i13 == 1) {
            zzmwVar.zza(i10, Long.valueOf(zzd(bArr, i11)));
            return i11 + 8;
        }
        if (i13 == 2) {
            int iZzc = zzc(bArr, i11, zzieVar);
            int i14 = zzieVar.zza;
            if (i14 >= 0) {
                if (i14 > bArr.length - iZzc) {
                    throw zzkb.zzh();
                }
                if (i14 == 0) {
                    zzmwVar.zza(i10, zzij.zza);
                } else {
                    zzmwVar.zza(i10, zzij.zza(bArr, iZzc, i14));
                }
                return iZzc + i14;
            }
            throw zzkb.zzf();
        }
        if (i13 != 3) {
            if (i13 == 5) {
                zzmwVar.zza(i10, Integer.valueOf(zzc(bArr, i11)));
                return i11 + 4;
            }
            throw zzkb.zzc();
        }
        zzmw zzmwVarZzd = zzmw.zzd();
        int i15 = (i10 & (-8)) | 4;
        int i16 = 0;
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int iZzc2 = zzc(bArr, i11, zzieVar);
            int i17 = zzieVar.zza;
            i16 = i17;
            if (i17 == i15) {
                i11 = iZzc2;
                break;
            }
            int iZza = zza(i16, bArr, iZzc2, i12, zzmwVarZzd, zzieVar);
            i16 = i17;
            i11 = iZza;
        }
        if (i11 <= i12 && i16 == i15) {
            zzmwVar.zza(i10, zzmwVarZzd);
            return i11;
        }
        throw zzkb.zzg();
    }

    public static int zza(int i10, byte[] bArr, int i11, zzie zzieVar) {
        int i12 = i10 & 127;
        int i13 = i11 + 1;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            zzieVar.zza = i12 | (b10 << 7);
            return i13;
        }
        int i14 = i12 | ((b10 & 127) << 7);
        int i15 = i13 + 1;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            zzieVar.zza = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & 127) << 14);
        int i17 = i15 + 1;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            zzieVar.zza = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & 127) << 21);
        int i19 = i17 + 1;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            zzieVar.zza = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & 127) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] >= 0) {
                zzieVar.zza = i20;
                return i21;
            }
            i19 = i21;
        }
    }

    public static int zza(int i10, byte[] bArr, int i11, int i12, zzkc<?> zzkcVar, zzie zzieVar) {
        zzju zzjuVar = (zzju) zzkcVar;
        int iZzc = zzc(bArr, i11, zzieVar);
        zzjuVar.zzd(zzieVar.zza);
        while (iZzc < i12) {
            int iZzc2 = zzc(bArr, iZzc, zzieVar);
            if (i10 != zzieVar.zza) {
                break;
            }
            iZzc = zzc(bArr, iZzc2, zzieVar);
            zzjuVar.zzd(zzieVar.zza);
        }
        return iZzc;
    }

    public static int zza(Object obj, zzly zzlyVar, byte[] bArr, int i10, int i11, int i12, zzie zzieVar) throws IOException {
        int iZza = ((zzlk) zzlyVar).zza((zzlk) obj, bArr, i10, i11, i12, zzieVar);
        zzieVar.zzc = obj;
        return iZza;
    }

    public static int zza(Object obj, zzly zzlyVar, byte[] bArr, int i10, int i11, zzie zzieVar) throws IOException {
        int iZza = i10 + 1;
        int i12 = bArr[i10];
        if (i12 < 0) {
            iZza = zza(i12, bArr, iZza, zzieVar);
            i12 = zzieVar.zza;
        }
        int i13 = iZza;
        if (i12 >= 0 && i12 <= i11 - i13) {
            int i14 = i12 + i13;
            zzlyVar.zza(obj, bArr, i13, i14, zzieVar);
            zzieVar.zzc = obj;
            return i14;
        }
        throw zzkb.zzh();
    }

    public static int zza(int i10, byte[] bArr, int i11, int i12, zzie zzieVar) throws zzkb {
        if ((i10 >>> 3) == 0) {
            throw zzkb.zzc();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            return zzd(bArr, i11, zzieVar);
        }
        if (i13 == 1) {
            return i11 + 8;
        }
        if (i13 == 2) {
            return zzc(bArr, i11, zzieVar) + zzieVar.zza;
        }
        if (i13 != 3) {
            if (i13 == 5) {
                return i11 + 4;
            }
            throw zzkb.zzc();
        }
        int i14 = (i10 & (-8)) | 4;
        int i15 = 0;
        while (i11 < i12) {
            i11 = zzc(bArr, i11, zzieVar);
            i15 = zzieVar.zza;
            if (i15 == i14) {
                break;
            }
            i11 = zza(i15, bArr, i11, i12, zzieVar);
        }
        if (i11 > i12 || i15 != i14) {
            throw zzkb.zzg();
        }
        return i11;
    }
}
