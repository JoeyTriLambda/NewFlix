package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzva<T> implements zzvi<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzwj.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final zzux zze;
    private final boolean zzf;
    private final int[] zzg;
    private final int zzh;
    private final zzul zzi;
    private final zzvz zzj;
    private final zztf zzk;
    private final zzvc zzl;
    private final zzus zzm;

    private zzva(int[] iArr, Object[] objArr, int i10, int i11, zzux zzuxVar, int i12, boolean z10, int[] iArr2, int i13, int i14, zzvc zzvcVar, zzul zzulVar, zzvz zzvzVar, zztf zztfVar, zzus zzusVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        boolean z11 = false;
        if (zztfVar != null && zztfVar.zzc(zzuxVar)) {
            z11 = true;
        }
        this.zzf = z11;
        this.zzg = iArr2;
        this.zzh = i13;
        this.zzl = zzvcVar;
        this.zzi = zzulVar;
        this.zzj = zzvzVar;
        this.zzk = zztfVar;
        this.zze = zzuxVar;
        this.zzm = zzusVar;
    }

    private static boolean zzA(Object obj, int i10, zzvi zzviVar) {
        return zzviVar.zzh(zzwj.zzf(obj, i10 & 1048575));
    }

    private static boolean zzB(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zztp) {
            return ((zztp) obj).zzK();
        }
        return true;
    }

    private final boolean zzC(Object obj, int i10, int i11) {
        return zzwj.zzc(obj, (long) (zzm(i11) & 1048575)) == i10;
    }

    private static boolean zzD(Object obj, long j10) {
        return ((Boolean) zzwj.zzf(obj, j10)).booleanValue();
    }

    private static final void zzE(int i10, Object obj, zzwq zzwqVar) throws IOException {
        if (obj instanceof String) {
            zzwqVar.zzD(i10, (String) obj);
        } else {
            zzwqVar.zzd(i10, (zzsu) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0281  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.cast.zzva zzi(java.lang.Class r33, com.google.android.gms.internal.cast.zzuu r34, com.google.android.gms.internal.cast.zzvc r35, com.google.android.gms.internal.cast.zzul r36, com.google.android.gms.internal.cast.zzvz r37, com.google.android.gms.internal.cast.zztf r38, com.google.android.gms.internal.cast.zzus r39) {
        /*
            Method dump skipped, instructions count: 1029
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzva.zzi(java.lang.Class, com.google.android.gms.internal.cast.zzuu, com.google.android.gms.internal.cast.zzvc, com.google.android.gms.internal.cast.zzul, com.google.android.gms.internal.cast.zzvz, com.google.android.gms.internal.cast.zztf, com.google.android.gms.internal.cast.zzus):com.google.android.gms.internal.cast.zzva");
    }

    private static double zzj(Object obj, long j10) {
        return ((Double) zzwj.zzf(obj, j10)).doubleValue();
    }

    private static float zzk(Object obj, long j10) {
        return ((Float) zzwj.zzf(obj, j10)).floatValue();
    }

    private static int zzl(Object obj, long j10) {
        return ((Integer) zzwj.zzf(obj, j10)).intValue();
    }

    private final int zzm(int i10) {
        return this.zzc[i10 + 2];
    }

    private static int zzn(int i10) {
        return (i10 >>> 20) & 255;
    }

    private final int zzo(int i10) {
        return this.zzc[i10 + 1];
    }

    private static long zzp(Object obj, long j10) {
        return ((Long) zzwj.zzf(obj, j10)).longValue();
    }

    private final zzvi zzq(int i10) {
        Object[] objArr = this.zzd;
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        zzvi zzviVar = (zzvi) objArr[i12];
        if (zzviVar != null) {
            return zzviVar;
        }
        zzvi zzviVarZzb = zzvf.zza().zzb((Class) objArr[i12 + 1]);
        this.zzd[i12] = zzviVarZzb;
        return zzviVarZzb;
    }

    private final Object zzr(int i10) {
        int i11 = i10 / 3;
        return this.zzd[i11 + i11];
    }

    private static Field zzs(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private final void zzt(Object obj, Object obj2, int i10) {
        if (zzy(obj2, i10)) {
            int iZzo = zzo(i10) & 1048575;
            Unsafe unsafe = zzb;
            long j10 = iZzo;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i10] + " is present but null: " + obj2.toString());
            }
            zzvi zzviVarZzq = zzq(i10);
            if (!zzy(obj, i10)) {
                if (zzB(object)) {
                    Object objZzc = zzviVarZzq.zzc();
                    zzviVarZzq.zze(objZzc, object);
                    unsafe.putObject(obj, j10, objZzc);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                zzv(obj, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!zzB(object2)) {
                Object objZzc2 = zzviVarZzq.zzc();
                zzviVarZzq.zze(objZzc2, object2);
                unsafe.putObject(obj, j10, objZzc2);
                object2 = objZzc2;
            }
            zzviVarZzq.zze(object2, object);
        }
    }

    private final void zzu(Object obj, Object obj2, int i10) {
        int i11 = this.zzc[i10];
        if (zzC(obj2, i11, i10)) {
            int iZzo = zzo(i10) & 1048575;
            Unsafe unsafe = zzb;
            long j10 = iZzo;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i10] + " is present but null: " + obj2.toString());
            }
            zzvi zzviVarZzq = zzq(i10);
            if (!zzC(obj, i11, i10)) {
                if (zzB(object)) {
                    Object objZzc = zzviVarZzq.zzc();
                    zzviVarZzq.zze(objZzc, object);
                    unsafe.putObject(obj, j10, objZzc);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                zzw(obj, i11, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!zzB(object2)) {
                Object objZzc2 = zzviVarZzq.zzc();
                zzviVarZzq.zze(objZzc2, object2);
                unsafe.putObject(obj, j10, objZzc2);
                object2 = objZzc2;
            }
            zzviVarZzq.zze(object2, object);
        }
    }

    private final void zzv(Object obj, int i10) {
        int iZzm = zzm(i10);
        long j10 = 1048575 & iZzm;
        if (j10 == 1048575) {
            return;
        }
        zzwj.zzq(obj, j10, (1 << (iZzm >>> 20)) | zzwj.zzc(obj, j10));
    }

    private final void zzw(Object obj, int i10, int i11) {
        zzwj.zzq(obj, zzm(i11) & 1048575, i10);
    }

    private final boolean zzx(Object obj, Object obj2, int i10) {
        return zzy(obj, i10) == zzy(obj2, i10);
    }

    private final boolean zzy(Object obj, int i10) {
        int iZzm = zzm(i10);
        long j10 = iZzm & 1048575;
        if (j10 != 1048575) {
            return (zzwj.zzc(obj, j10) & (1 << (iZzm >>> 20))) != 0;
        }
        int iZzo = zzo(i10);
        long j11 = iZzo & 1048575;
        switch (zzn(iZzo)) {
            case 0:
                return Double.doubleToRawLongBits(zzwj.zza(obj, j11)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzwj.zzb(obj, j11)) != 0;
            case 2:
                return zzwj.zzd(obj, j11) != 0;
            case 3:
                return zzwj.zzd(obj, j11) != 0;
            case 4:
                return zzwj.zzc(obj, j11) != 0;
            case 5:
                return zzwj.zzd(obj, j11) != 0;
            case 6:
                return zzwj.zzc(obj, j11) != 0;
            case 7:
                return zzwj.zzw(obj, j11);
            case 8:
                Object objZzf = zzwj.zzf(obj, j11);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzsu) {
                    return !zzsu.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzwj.zzf(obj, j11) != null;
            case 10:
                return !zzsu.zzb.equals(zzwj.zzf(obj, j11));
            case 11:
                return zzwj.zzc(obj, j11) != 0;
            case 12:
                return zzwj.zzc(obj, j11) != 0;
            case 13:
                return zzwj.zzc(obj, j11) != 0;
            case 14:
                return zzwj.zzd(obj, j11) != 0;
            case 15:
                return zzwj.zzc(obj, j11) != 0;
            case 16:
                return zzwj.zzd(obj, j11) != 0;
            case 17:
                return zzwj.zzf(obj, j11) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzz(Object obj, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? zzy(obj, i10) : (i12 & i13) != 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:167:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x056d  */
    @Override // com.google.android.gms.internal.cast.zzvi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 2198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzva.zza(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.cast.zzvi
    public final int zzb(Object obj) {
        int i10;
        long jDoubleToLongBits;
        int i11;
        int iFloatToIntBits;
        int i12;
        int iZzc;
        int i13;
        int i14 = 0;
        for (int i15 = 0; i15 < this.zzc.length; i15 += 3) {
            int iZzo = zzo(i15);
            int[] iArr = this.zzc;
            int i16 = 1048575 & iZzo;
            int iZzn = zzn(iZzo);
            int i17 = iArr[i15];
            long j10 = i16;
            int iHashCode = 37;
            switch (iZzn) {
                case 0:
                    i10 = i14 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzwj.zza(obj, j10));
                    byte[] bArr = zzty.zzd;
                    i14 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 1:
                    i11 = i14 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzwj.zzb(obj, j10));
                    i14 = iFloatToIntBits + i11;
                    break;
                case 2:
                    i10 = i14 * 53;
                    jDoubleToLongBits = zzwj.zzd(obj, j10);
                    byte[] bArr2 = zzty.zzd;
                    i14 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 3:
                    i10 = i14 * 53;
                    jDoubleToLongBits = zzwj.zzd(obj, j10);
                    byte[] bArr3 = zzty.zzd;
                    i14 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 4:
                    i12 = i14 * 53;
                    iZzc = zzwj.zzc(obj, j10);
                    i14 = i12 + iZzc;
                    break;
                case 5:
                    i10 = i14 * 53;
                    jDoubleToLongBits = zzwj.zzd(obj, j10);
                    byte[] bArr4 = zzty.zzd;
                    i14 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 6:
                    i12 = i14 * 53;
                    iZzc = zzwj.zzc(obj, j10);
                    i14 = i12 + iZzc;
                    break;
                case 7:
                    i11 = i14 * 53;
                    iFloatToIntBits = zzty.zza(zzwj.zzw(obj, j10));
                    i14 = iFloatToIntBits + i11;
                    break;
                case 8:
                    i11 = i14 * 53;
                    iFloatToIntBits = ((String) zzwj.zzf(obj, j10)).hashCode();
                    i14 = iFloatToIntBits + i11;
                    break;
                case 9:
                    i13 = i14 * 53;
                    Object objZzf = zzwj.zzf(obj, j10);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i14 = i13 + iHashCode;
                    break;
                case 10:
                    i11 = i14 * 53;
                    iFloatToIntBits = zzwj.zzf(obj, j10).hashCode();
                    i14 = iFloatToIntBits + i11;
                    break;
                case 11:
                    i12 = i14 * 53;
                    iZzc = zzwj.zzc(obj, j10);
                    i14 = i12 + iZzc;
                    break;
                case 12:
                    i12 = i14 * 53;
                    iZzc = zzwj.zzc(obj, j10);
                    i14 = i12 + iZzc;
                    break;
                case 13:
                    i12 = i14 * 53;
                    iZzc = zzwj.zzc(obj, j10);
                    i14 = i12 + iZzc;
                    break;
                case 14:
                    i10 = i14 * 53;
                    jDoubleToLongBits = zzwj.zzd(obj, j10);
                    byte[] bArr5 = zzty.zzd;
                    i14 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 15:
                    i12 = i14 * 53;
                    iZzc = zzwj.zzc(obj, j10);
                    i14 = i12 + iZzc;
                    break;
                case 16:
                    i10 = i14 * 53;
                    jDoubleToLongBits = zzwj.zzd(obj, j10);
                    byte[] bArr6 = zzty.zzd;
                    i14 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 17:
                    i13 = i14 * 53;
                    Object objZzf2 = zzwj.zzf(obj, j10);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i14 = i13 + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i11 = i14 * 53;
                    iFloatToIntBits = zzwj.zzf(obj, j10).hashCode();
                    i14 = iFloatToIntBits + i11;
                    break;
                case 50:
                    i11 = i14 * 53;
                    iFloatToIntBits = zzwj.zzf(obj, j10).hashCode();
                    i14 = iFloatToIntBits + i11;
                    break;
                case 51:
                    if (zzC(obj, i17, i15)) {
                        i10 = i14 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzj(obj, j10));
                        byte[] bArr7 = zzty.zzd;
                        i14 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzC(obj, i17, i15)) {
                        i11 = i14 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzk(obj, j10));
                        i14 = iFloatToIntBits + i11;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzC(obj, i17, i15)) {
                        i10 = i14 * 53;
                        jDoubleToLongBits = zzp(obj, j10);
                        byte[] bArr8 = zzty.zzd;
                        i14 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzC(obj, i17, i15)) {
                        i10 = i14 * 53;
                        jDoubleToLongBits = zzp(obj, j10);
                        byte[] bArr9 = zzty.zzd;
                        i14 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzC(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iZzc = zzl(obj, j10);
                        i14 = i12 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzC(obj, i17, i15)) {
                        i10 = i14 * 53;
                        jDoubleToLongBits = zzp(obj, j10);
                        byte[] bArr10 = zzty.zzd;
                        i14 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzC(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iZzc = zzl(obj, j10);
                        i14 = i12 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzC(obj, i17, i15)) {
                        i11 = i14 * 53;
                        iFloatToIntBits = zzty.zza(zzD(obj, j10));
                        i14 = iFloatToIntBits + i11;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzC(obj, i17, i15)) {
                        i11 = i14 * 53;
                        iFloatToIntBits = ((String) zzwj.zzf(obj, j10)).hashCode();
                        i14 = iFloatToIntBits + i11;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzC(obj, i17, i15)) {
                        i11 = i14 * 53;
                        iFloatToIntBits = zzwj.zzf(obj, j10).hashCode();
                        i14 = iFloatToIntBits + i11;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzC(obj, i17, i15)) {
                        i11 = i14 * 53;
                        iFloatToIntBits = zzwj.zzf(obj, j10).hashCode();
                        i14 = iFloatToIntBits + i11;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzC(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iZzc = zzl(obj, j10);
                        i14 = i12 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzC(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iZzc = zzl(obj, j10);
                        i14 = i12 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzC(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iZzc = zzl(obj, j10);
                        i14 = i12 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzC(obj, i17, i15)) {
                        i10 = i14 * 53;
                        jDoubleToLongBits = zzp(obj, j10);
                        byte[] bArr11 = zzty.zzd;
                        i14 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzC(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iZzc = zzl(obj, j10);
                        i14 = i12 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzC(obj, i17, i15)) {
                        i10 = i14 * 53;
                        jDoubleToLongBits = zzp(obj, j10);
                        byte[] bArr12 = zzty.zzd;
                        i14 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzC(obj, i17, i15)) {
                        i11 = i14 * 53;
                        iFloatToIntBits = zzwj.zzf(obj, j10).hashCode();
                        i14 = iFloatToIntBits + i11;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = this.zzj.zzc(obj).hashCode() + (i14 * 53);
        if (!this.zzf) {
            return iHashCode2;
        }
        this.zzk.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.cast.zzvi
    public final Object zzc() {
        return ((zztp) this.zze).zzx();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    @Override // com.google.android.gms.internal.cast.zzvi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = zzB(r8)
            if (r0 != 0) goto L8
            goto L91
        L8:
            boolean r0 = r8 instanceof com.google.android.gms.internal.cast.zztp
            r1 = 0
            if (r0 == 0) goto L1b
            r0 = r8
            com.google.android.gms.internal.cast.zztp r0 = (com.google.android.gms.internal.cast.zztp) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.zzI(r2)
            r0.zza = r1
            r0.zzG()
        L1b:
            int[] r0 = r7.zzc
        L1d:
            int r2 = r0.length
            if (r1 >= r2) goto L83
            int r2 = r7.zzo(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            int r2 = zzn(r2)
            long r3 = (long) r3
            r5 = 9
            if (r2 == r5) goto L6d
            r5 = 60
            if (r2 == r5) goto L55
            r5 = 68
            if (r2 == r5) goto L55
            switch(r2) {
                case 17: goto L6d;
                case 18: goto L4f;
                case 19: goto L4f;
                case 20: goto L4f;
                case 21: goto L4f;
                case 22: goto L4f;
                case 23: goto L4f;
                case 24: goto L4f;
                case 25: goto L4f;
                case 26: goto L4f;
                case 27: goto L4f;
                case 28: goto L4f;
                case 29: goto L4f;
                case 30: goto L4f;
                case 31: goto L4f;
                case 32: goto L4f;
                case 33: goto L4f;
                case 34: goto L4f;
                case 35: goto L4f;
                case 36: goto L4f;
                case 37: goto L4f;
                case 38: goto L4f;
                case 39: goto L4f;
                case 40: goto L4f;
                case 41: goto L4f;
                case 42: goto L4f;
                case 43: goto L4f;
                case 44: goto L4f;
                case 45: goto L4f;
                case 46: goto L4f;
                case 47: goto L4f;
                case 48: goto L4f;
                case 49: goto L4f;
                case 50: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L80
        L3d:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.cast.zzva.zzb
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L80
            r6 = r5
            com.google.android.gms.internal.cast.zzur r6 = (com.google.android.gms.internal.cast.zzur) r6
            r6.zzb()
            r2.putObject(r8, r3, r5)
            goto L80
        L4f:
            com.google.android.gms.internal.cast.zzul r2 = r7.zzi
            r2.zza(r8, r3)
            goto L80
        L55:
            int[] r2 = r7.zzc
            r2 = r2[r1]
            boolean r2 = r7.zzC(r8, r2, r1)
            if (r2 == 0) goto L80
            com.google.android.gms.internal.cast.zzvi r2 = r7.zzq(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.cast.zzva.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzd(r3)
            goto L80
        L6d:
            boolean r2 = r7.zzy(r8, r1)
            if (r2 == 0) goto L80
            com.google.android.gms.internal.cast.zzvi r2 = r7.zzq(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.cast.zzva.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzd(r3)
        L80:
            int r1 = r1 + 3
            goto L1d
        L83:
            com.google.android.gms.internal.cast.zzvz r0 = r7.zzj
            r0.zze(r8)
            boolean r0 = r7.zzf
            if (r0 == 0) goto L91
            com.google.android.gms.internal.cast.zztf r0 = r7.zzk
            r0.zzb(r8)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzva.zzd(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.cast.zzvi
    public final void zze(Object obj, Object obj2) {
        if (!zzB(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
        obj2.getClass();
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int iZzo = zzo(i10);
            int i11 = 1048575 & iZzo;
            int[] iArr = this.zzc;
            int iZzn = zzn(iZzo);
            int i12 = iArr[i10];
            long j10 = i11;
            switch (iZzn) {
                case 0:
                    if (zzy(obj2, i10)) {
                        zzwj.zzo(obj, j10, zzwj.zza(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzy(obj2, i10)) {
                        zzwj.zzp(obj, j10, zzwj.zzb(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzy(obj2, i10)) {
                        zzwj.zzr(obj, j10, zzwj.zzd(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzy(obj2, i10)) {
                        zzwj.zzr(obj, j10, zzwj.zzd(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzy(obj2, i10)) {
                        zzwj.zzq(obj, j10, zzwj.zzc(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzy(obj2, i10)) {
                        zzwj.zzr(obj, j10, zzwj.zzd(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzy(obj2, i10)) {
                        zzwj.zzq(obj, j10, zzwj.zzc(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzy(obj2, i10)) {
                        zzwj.zzm(obj, j10, zzwj.zzw(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzy(obj2, i10)) {
                        zzwj.zzs(obj, j10, zzwj.zzf(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzt(obj, obj2, i10);
                    break;
                case 10:
                    if (zzy(obj2, i10)) {
                        zzwj.zzs(obj, j10, zzwj.zzf(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzy(obj2, i10)) {
                        zzwj.zzq(obj, j10, zzwj.zzc(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzy(obj2, i10)) {
                        zzwj.zzq(obj, j10, zzwj.zzc(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzy(obj2, i10)) {
                        zzwj.zzq(obj, j10, zzwj.zzc(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzy(obj2, i10)) {
                        zzwj.zzr(obj, j10, zzwj.zzd(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzy(obj2, i10)) {
                        zzwj.zzq(obj, j10, zzwj.zzc(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzy(obj2, i10)) {
                        zzwj.zzr(obj, j10, zzwj.zzd(obj2, j10));
                        zzv(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzt(obj, obj2, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzi.zzb(obj, obj2, j10);
                    break;
                case 50:
                    int i13 = zzvk.zza;
                    zzur zzurVarZza = (zzur) zzwj.zzf(obj, j10);
                    zzur zzurVar = (zzur) zzwj.zzf(obj2, j10);
                    if (!zzurVar.isEmpty()) {
                        if (!zzurVarZza.zzd()) {
                            zzurVarZza = zzurVarZza.zza();
                        }
                        zzurVarZza.zzc(zzurVar);
                    }
                    zzwj.zzs(obj, j10, zzurVarZza);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzC(obj2, i12, i10)) {
                        zzwj.zzs(obj, j10, zzwj.zzf(obj2, j10));
                        zzw(obj, i12, i10);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzu(obj, obj2, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzC(obj2, i12, i10)) {
                        zzwj.zzs(obj, j10, zzwj.zzf(obj2, j10));
                        zzw(obj, i12, i10);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzu(obj, obj2, i10);
                    break;
            }
        }
        zzvk.zzo(this.zzj, obj, obj2);
        if (this.zzf) {
            this.zzk.zza(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.cast.zzvi
    public final void zzf(Object obj, zzwq zzwqVar) throws IOException {
        int i10;
        int i11;
        int i12;
        if (this.zzf) {
            this.zzk.zza(obj);
            throw null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i13 = 1048575;
        int i14 = 1048575;
        int i15 = 0;
        int i16 = 0;
        while (i16 < iArr.length) {
            int iZzo = zzo(i16);
            int[] iArr2 = this.zzc;
            int iZzn = zzn(iZzo);
            int i17 = iArr2[i16];
            if (iZzn <= 17) {
                int i18 = iArr2[i16 + 2];
                int i19 = i18 & i13;
                if (i19 != i14) {
                    i15 = i19 == i13 ? 0 : unsafe.getInt(obj, i19);
                    i14 = i19;
                }
                i10 = i14;
                i11 = i15;
                i12 = 1 << (i18 >>> 20);
            } else {
                i10 = i14;
                i11 = i15;
                i12 = 0;
            }
            long j10 = iZzo & i13;
            switch (iZzn) {
                case 0:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzf(i17, zzwj.zza(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzn(i17, zzwj.zzb(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzs(i17, unsafe.getLong(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzH(i17, unsafe.getLong(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzq(i17, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzl(i17, unsafe.getLong(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzj(i17, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzb(i17, zzwj.zzw(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzE(i17, unsafe.getObject(obj, j10), zzwqVar);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzu(i17, unsafe.getObject(obj, j10), zzq(i16));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzd(i17, (zzsu) unsafe.getObject(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzF(i17, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzh(i17, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzv(i17, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzx(i17, unsafe.getLong(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzz(i17, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzB(i17, unsafe.getLong(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzz(obj, i16, i10, i11, i12)) {
                        zzwqVar.zzp(i17, unsafe.getObject(obj, j10), zzq(i16));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzvk.zzr(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, false);
                    break;
                case 19:
                    zzvk.zzv(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, false);
                    break;
                case 20:
                    zzvk.zzx(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, false);
                    break;
                case 21:
                    zzvk.zzD(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, false);
                    break;
                case 22:
                    zzvk.zzw(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, false);
                    break;
                case 23:
                    zzvk.zzu(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, false);
                    break;
                case 24:
                    zzvk.zzt(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, false);
                    break;
                case 25:
                    zzvk.zzq(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, false);
                    break;
                case 26:
                    int i20 = this.zzc[i16];
                    List list = (List) unsafe.getObject(obj, j10);
                    int i21 = zzvk.zza;
                    if (list != null && !list.isEmpty()) {
                        zzwqVar.zzE(i20, list);
                        break;
                    } else {
                        break;
                    }
                case 27:
                    int i22 = this.zzc[i16];
                    List list2 = (List) unsafe.getObject(obj, j10);
                    zzvi zzviVarZzq = zzq(i16);
                    int i23 = zzvk.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i24 = 0; i24 < list2.size(); i24++) {
                            ((zztd) zzwqVar).zzu(i22, list2.get(i24), zzviVarZzq);
                        }
                        break;
                    } else {
                        break;
                    }
                    break;
                case 28:
                    int i25 = this.zzc[i16];
                    List list3 = (List) unsafe.getObject(obj, j10);
                    int i26 = zzvk.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzwqVar.zze(i25, list3);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 29:
                    zzvk.zzC(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, false);
                    break;
                case 30:
                    zzvk.zzs(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, false);
                    break;
                case 31:
                    zzvk.zzy(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, false);
                    break;
                case 32:
                    zzvk.zzz(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, false);
                    break;
                case 33:
                    zzvk.zzA(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, false);
                    break;
                case 34:
                    zzvk.zzB(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, false);
                    break;
                case 35:
                    zzvk.zzr(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, true);
                    break;
                case 36:
                    zzvk.zzv(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, true);
                    break;
                case 37:
                    zzvk.zzx(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, true);
                    break;
                case 38:
                    zzvk.zzD(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, true);
                    break;
                case 39:
                    zzvk.zzw(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, true);
                    break;
                case 40:
                    zzvk.zzu(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, true);
                    break;
                case 41:
                    zzvk.zzt(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, true);
                    break;
                case 42:
                    zzvk.zzq(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, true);
                    break;
                case 43:
                    zzvk.zzC(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, true);
                    break;
                case 44:
                    zzvk.zzs(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, true);
                    break;
                case 45:
                    zzvk.zzy(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, true);
                    break;
                case 46:
                    zzvk.zzz(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, true);
                    break;
                case 47:
                    zzvk.zzA(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, true);
                    break;
                case 48:
                    zzvk.zzB(this.zzc[i16], (List) unsafe.getObject(obj, j10), zzwqVar, true);
                    break;
                case 49:
                    int i27 = this.zzc[i16];
                    List list4 = (List) unsafe.getObject(obj, j10);
                    zzvi zzviVarZzq2 = zzq(i16);
                    int i28 = zzvk.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i29 = 0; i29 < list4.size(); i29++) {
                            ((zztd) zzwqVar).zzp(i27, list4.get(i29), zzviVarZzq2);
                        }
                        break;
                    } else {
                        break;
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j10) != null) {
                        throw null;
                    }
                    break;
                case 51:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzf(i17, zzj(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzn(i17, zzk(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzs(i17, zzp(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzH(i17, zzp(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzq(i17, zzl(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzl(i17, zzp(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzj(i17, zzl(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzb(i17, zzD(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzC(obj, i17, i16)) {
                        zzE(i17, unsafe.getObject(obj, j10), zzwqVar);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzu(i17, unsafe.getObject(obj, j10), zzq(i16));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzd(i17, (zzsu) unsafe.getObject(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzF(i17, zzl(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzh(i17, zzl(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzv(i17, zzl(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzx(i17, zzp(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzz(i17, zzl(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzB(i17, zzp(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzC(obj, i17, i16)) {
                        zzwqVar.zzp(i17, unsafe.getObject(obj, j10), zzq(i16));
                        break;
                    } else {
                        break;
                    }
            }
            i16 += 3;
            i14 = i10;
            i15 = i11;
            i13 = 1048575;
        }
        zzvz zzvzVar = this.zzj;
        zzvzVar.zzg(zzvzVar.zzc(obj), zzwqVar);
    }

    @Override // com.google.android.gms.internal.cast.zzvi
    public final boolean zzg(Object obj, Object obj2) {
        boolean zZzE;
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int iZzo = zzo(i10);
            long j10 = iZzo & 1048575;
            switch (zzn(iZzo)) {
                case 0:
                    if (!zzx(obj, obj2, i10) || Double.doubleToLongBits(zzwj.zza(obj, j10)) != Double.doubleToLongBits(zzwj.zza(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 1:
                    if (!zzx(obj, obj2, i10) || Float.floatToIntBits(zzwj.zzb(obj, j10)) != Float.floatToIntBits(zzwj.zzb(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 2:
                    if (!zzx(obj, obj2, i10) || zzwj.zzd(obj, j10) != zzwj.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 3:
                    if (!zzx(obj, obj2, i10) || zzwj.zzd(obj, j10) != zzwj.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 4:
                    if (!zzx(obj, obj2, i10) || zzwj.zzc(obj, j10) != zzwj.zzc(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 5:
                    if (!zzx(obj, obj2, i10) || zzwj.zzd(obj, j10) != zzwj.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 6:
                    if (!zzx(obj, obj2, i10) || zzwj.zzc(obj, j10) != zzwj.zzc(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 7:
                    if (!zzx(obj, obj2, i10) || zzwj.zzw(obj, j10) != zzwj.zzw(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 8:
                    if (!zzx(obj, obj2, i10) || !zzvk.zzE(zzwj.zzf(obj, j10), zzwj.zzf(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 9:
                    if (!zzx(obj, obj2, i10) || !zzvk.zzE(zzwj.zzf(obj, j10), zzwj.zzf(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 10:
                    if (!zzx(obj, obj2, i10) || !zzvk.zzE(zzwj.zzf(obj, j10), zzwj.zzf(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 11:
                    if (!zzx(obj, obj2, i10) || zzwj.zzc(obj, j10) != zzwj.zzc(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 12:
                    if (!zzx(obj, obj2, i10) || zzwj.zzc(obj, j10) != zzwj.zzc(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 13:
                    if (!zzx(obj, obj2, i10) || zzwj.zzc(obj, j10) != zzwj.zzc(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 14:
                    if (!zzx(obj, obj2, i10) || zzwj.zzd(obj, j10) != zzwj.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 15:
                    if (!zzx(obj, obj2, i10) || zzwj.zzc(obj, j10) != zzwj.zzc(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 16:
                    if (!zzx(obj, obj2, i10) || zzwj.zzd(obj, j10) != zzwj.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 17:
                    if (!zzx(obj, obj2, i10) || !zzvk.zzE(zzwj.zzf(obj, j10), zzwj.zzf(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzE = zzvk.zzE(zzwj.zzf(obj, j10), zzwj.zzf(obj2, j10));
                    break;
                case 50:
                    zZzE = zzvk.zzE(zzwj.zzf(obj, j10), zzwj.zzf(obj2, j10));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzm = zzm(i10) & 1048575;
                    if (zzwj.zzc(obj, jZzm) != zzwj.zzc(obj2, jZzm) || !zzvk.zzE(zzwj.zzf(obj, j10), zzwj.zzf(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                default:
            }
            if (!zZzE) {
                return false;
            }
        }
        if (!this.zzj.zzc(obj).equals(this.zzj.zzc(obj2))) {
            return false;
        }
        if (!this.zzf) {
            return true;
        }
        this.zzk.zza(obj);
        this.zzk.zza(obj2);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0  */
    @Override // com.google.android.gms.internal.cast.zzvi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzh(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzva.zzh(java.lang.Object):boolean");
    }
}
