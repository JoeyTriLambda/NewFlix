package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzlk<T> implements zzly<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmz.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlg zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final zzlr zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzlo zzo;
    private final zzkl zzp;
    private final zzmt<?, ?> zzq;
    private final zzji<?> zzr;
    private final zzkz zzs;

    private zzlk(int[] iArr, Object[] objArr, int i10, int i11, zzlg zzlgVar, zzlr zzlrVar, boolean z10, int[] iArr2, int i12, int i13, zzlo zzloVar, zzkl zzklVar, zzmt<?, ?> zzmtVar, zzji<?> zzjiVar, zzkz zzkzVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i10;
        this.zzf = i11;
        this.zzi = zzlgVar instanceof zzjt;
        this.zzj = zzlrVar;
        this.zzh = zzjiVar != null && zzjiVar.zza(zzlgVar);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i12;
        this.zzn = i13;
        this.zzo = zzloVar;
        this.zzp = zzklVar;
        this.zzq = zzmtVar;
        this.zzr = zzjiVar;
        this.zzg = zzlgVar;
        this.zzs = zzkzVar;
    }

    private static <T> double zza(T t10, long j10) {
        return ((Double) zzmz.zze(t10, j10)).doubleValue();
    }

    private static <T> float zzb(T t10, long j10) {
        return ((Float) zzmz.zze(t10, j10)).floatValue();
    }

    private static <T> int zzc(T t10, long j10) {
        return ((Integer) zzmz.zze(t10, j10)).intValue();
    }

    private static <T> long zzd(T t10, long j10) {
        return ((Long) zzmz.zze(t10, j10)).longValue();
    }

    private final zzly zze(int i10) {
        int i11 = (i10 / 3) << 1;
        zzly zzlyVar = (zzly) this.zzd[i11];
        if (zzlyVar != null) {
            return zzlyVar;
        }
        zzly<T> zzlyVarZza = zzlu.zza().zza((Class) this.zzd[i11 + 1]);
        this.zzd[i11] = zzlyVarZza;
        return zzlyVarZza;
    }

    private final Object zzf(int i10) {
        return this.zzd[(i10 / 3) << 1];
    }

    private static boolean zzg(int i10) {
        return (i10 & 536870912) != 0;
    }

    private static int zza(byte[] bArr, int i10, int i11, zzng zzngVar, Class<?> cls, zzie zzieVar) throws IOException {
        switch (zzlj.zza[zzngVar.ordinal()]) {
            case 1:
                int iZzd = zzif.zzd(bArr, i10, zzieVar);
                zzieVar.zzc = Boolean.valueOf(zzieVar.zzb != 0);
                return iZzd;
            case 2:
                return zzif.zza(bArr, i10, zzieVar);
            case 3:
                zzieVar.zzc = Double.valueOf(zzif.zza(bArr, i10));
                return i10 + 8;
            case 4:
            case 5:
                zzieVar.zzc = Integer.valueOf(zzif.zzc(bArr, i10));
                return i10 + 4;
            case 6:
            case 7:
                zzieVar.zzc = Long.valueOf(zzif.zzd(bArr, i10));
                return i10 + 8;
            case 8:
                zzieVar.zzc = Float.valueOf(zzif.zzb(bArr, i10));
                return i10 + 4;
            case 9:
            case 10:
            case 11:
                int iZzc = zzif.zzc(bArr, i10, zzieVar);
                zzieVar.zzc = Integer.valueOf(zzieVar.zza);
                return iZzc;
            case 12:
            case 13:
                int iZzd2 = zzif.zzd(bArr, i10, zzieVar);
                zzieVar.zzc = Long.valueOf(zzieVar.zzb);
                return iZzd2;
            case 14:
                return zzif.zza(zzlu.zza().zza((Class) cls), bArr, i10, i11, zzieVar);
            case 15:
                int iZzc2 = zzif.zzc(bArr, i10, zzieVar);
                zzieVar.zzc = Integer.valueOf(zziu.zza(zzieVar.zza));
                return iZzc2;
            case 16:
                int iZzd3 = zzif.zzd(bArr, i10, zzieVar);
                zzieVar.zzc = Long.valueOf(zziu.zza(zzieVar.zzb));
                return iZzd3;
            case 17:
                return zzif.zzb(bArr, i10, zzieVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final int zzc(int i10) {
        return this.zzc[i10 + 1];
    }

    private final zzjx zzd(int i10) {
        return (zzjx) this.zzd[((i10 / 3) << 1) + 1];
    }

    private static void zzf(Object obj) {
        if (!zzg(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzjt) {
            return ((zzjt) obj).zzch();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzly
    public final int zzb(T t10) {
        int i10;
        int iZza;
        int i11;
        int iZzc;
        int length = this.zzc.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13 += 3) {
            int iZzc2 = zzc(i13);
            int i14 = this.zzc[i13];
            long j10 = 1048575 & iZzc2;
            int iHashCode = 37;
            switch ((iZzc2 & 267386880) >>> 20) {
                case 0:
                    i10 = i12 * 53;
                    iZza = zzjw.zza(Double.doubleToLongBits(zzmz.zza(t10, j10)));
                    i12 = iZza + i10;
                    break;
                case 1:
                    i10 = i12 * 53;
                    iZza = Float.floatToIntBits(zzmz.zzb(t10, j10));
                    i12 = iZza + i10;
                    break;
                case 2:
                    i10 = i12 * 53;
                    iZza = zzjw.zza(zzmz.zzd(t10, j10));
                    i12 = iZza + i10;
                    break;
                case 3:
                    i10 = i12 * 53;
                    iZza = zzjw.zza(zzmz.zzd(t10, j10));
                    i12 = iZza + i10;
                    break;
                case 4:
                    i11 = i12 * 53;
                    iZzc = zzmz.zzc(t10, j10);
                    i12 = i11 + iZzc;
                    break;
                case 5:
                    i10 = i12 * 53;
                    iZza = zzjw.zza(zzmz.zzd(t10, j10));
                    i12 = iZza + i10;
                    break;
                case 6:
                    i11 = i12 * 53;
                    iZzc = zzmz.zzc(t10, j10);
                    i12 = i11 + iZzc;
                    break;
                case 7:
                    i10 = i12 * 53;
                    iZza = zzjw.zza(zzmz.zzh(t10, j10));
                    i12 = iZza + i10;
                    break;
                case 8:
                    i10 = i12 * 53;
                    iZza = ((String) zzmz.zze(t10, j10)).hashCode();
                    i12 = iZza + i10;
                    break;
                case 9:
                    Object objZze = zzmz.zze(t10, j10);
                    if (objZze != null) {
                        iHashCode = objZze.hashCode();
                    }
                    i12 = (i12 * 53) + iHashCode;
                    break;
                case 10:
                    i10 = i12 * 53;
                    iZza = zzmz.zze(t10, j10).hashCode();
                    i12 = iZza + i10;
                    break;
                case 11:
                    i11 = i12 * 53;
                    iZzc = zzmz.zzc(t10, j10);
                    i12 = i11 + iZzc;
                    break;
                case 12:
                    i11 = i12 * 53;
                    iZzc = zzmz.zzc(t10, j10);
                    i12 = i11 + iZzc;
                    break;
                case 13:
                    i11 = i12 * 53;
                    iZzc = zzmz.zzc(t10, j10);
                    i12 = i11 + iZzc;
                    break;
                case 14:
                    i10 = i12 * 53;
                    iZza = zzjw.zza(zzmz.zzd(t10, j10));
                    i12 = iZza + i10;
                    break;
                case 15:
                    i11 = i12 * 53;
                    iZzc = zzmz.zzc(t10, j10);
                    i12 = i11 + iZzc;
                    break;
                case 16:
                    i10 = i12 * 53;
                    iZza = zzjw.zza(zzmz.zzd(t10, j10));
                    i12 = iZza + i10;
                    break;
                case 17:
                    Object objZze2 = zzmz.zze(t10, j10);
                    if (objZze2 != null) {
                        iHashCode = objZze2.hashCode();
                    }
                    i12 = (i12 * 53) + iHashCode;
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
                    i10 = i12 * 53;
                    iZza = zzmz.zze(t10, j10).hashCode();
                    i12 = iZza + i10;
                    break;
                case 50:
                    i10 = i12 * 53;
                    iZza = zzmz.zze(t10, j10).hashCode();
                    i12 = iZza + i10;
                    break;
                case 51:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i10 = i12 * 53;
                        iZza = zzjw.zza(Double.doubleToLongBits(zza(t10, j10)));
                        i12 = iZza + i10;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i10 = i12 * 53;
                        iZza = Float.floatToIntBits(zzb(t10, j10));
                        i12 = iZza + i10;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i10 = i12 * 53;
                        iZza = zzjw.zza(zzd(t10, j10));
                        i12 = iZza + i10;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i10 = i12 * 53;
                        iZza = zzjw.zza(zzd(t10, j10));
                        i12 = iZza + i10;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzc(t10, j10);
                        i12 = i11 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i10 = i12 * 53;
                        iZza = zzjw.zza(zzd(t10, j10));
                        i12 = iZza + i10;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzc(t10, j10);
                        i12 = i11 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i10 = i12 * 53;
                        iZza = zzjw.zza(zze(t10, j10));
                        i12 = iZza + i10;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i10 = i12 * 53;
                        iZza = ((String) zzmz.zze(t10, j10)).hashCode();
                        i12 = iZza + i10;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i10 = i12 * 53;
                        iZza = zzmz.zze(t10, j10).hashCode();
                        i12 = iZza + i10;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i10 = i12 * 53;
                        iZza = zzmz.zze(t10, j10).hashCode();
                        i12 = iZza + i10;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzc(t10, j10);
                        i12 = i11 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzc(t10, j10);
                        i12 = i11 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzc(t10, j10);
                        i12 = i11 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i10 = i12 * 53;
                        iZza = zzjw.zza(zzd(t10, j10));
                        i12 = iZza + i10;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzc(t10, j10);
                        i12 = i11 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i10 = i12 * 53;
                        iZza = zzjw.zza(zzd(t10, j10));
                        i12 = iZza + i10;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzc((zzlk<T>) t10, i14, i13)) {
                        i10 = i12 * 53;
                        iZza = zzmz.zze(t10, j10).hashCode();
                        i12 = iZza + i10;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = this.zzq.zzd(t10).hashCode() + (i12 * 53);
        return this.zzh ? (iHashCode2 * 53) + this.zzr.zza(t10).hashCode() : iHashCode2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    @Override // com.google.android.gms.internal.measurement.zzly
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzc(T r8) {
        /*
            r7 = this;
            boolean r0 = zzg(r8)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r8 instanceof com.google.android.gms.internal.measurement.zzjt
            r1 = 0
            if (r0 == 0) goto L1a
            r0 = r8
            com.google.android.gms.internal.measurement.zzjt r0 = (com.google.android.gms.internal.measurement.zzjt) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.zzc(r2)
            r0.zza = r1
            r0.zzcg()
        L1a:
            int[] r0 = r7.zzc
            int r0 = r0.length
        L1d:
            if (r1 >= r0) goto L83
            int r2 = r7.zzc(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            long r3 = (long) r3
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r2 = r2 & r5
            int r2 = r2 >>> 20
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
            sun.misc.Unsafe r2 = com.google.android.gms.internal.measurement.zzlk.zzb
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L80
            com.google.android.gms.internal.measurement.zzkz r6 = r7.zzs
            java.lang.Object r5 = r6.zzc(r5)
            r2.putObject(r8, r3, r5)
            goto L80
        L4f:
            com.google.android.gms.internal.measurement.zzkl r2 = r7.zzp
            r2.zzb(r8, r3)
            goto L80
        L55:
            int[] r2 = r7.zzc
            r2 = r2[r1]
            boolean r2 = r7.zzc(r8, r2, r1)
            if (r2 == 0) goto L80
            com.google.android.gms.internal.measurement.zzly r2 = r7.zze(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.measurement.zzlk.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzc(r3)
            goto L80
        L6d:
            boolean r2 = r7.zzc(r8, r1)
            if (r2 == 0) goto L80
            com.google.android.gms.internal.measurement.zzly r2 = r7.zze(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.measurement.zzlk.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzc(r3)
        L80:
            int r1 = r1 + 3
            goto L1d
        L83:
            com.google.android.gms.internal.measurement.zzmt<?, ?> r0 = r7.zzq
            r0.zzf(r8)
            boolean r0 = r7.zzh
            if (r0 == 0) goto L91
            com.google.android.gms.internal.measurement.zzji<?> r0 = r7.zzr
            r0.zzc(r8)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlk.zzc(java.lang.Object):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00df  */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.measurement.zzly] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzly] */
    @Override // com.google.android.gms.internal.measurement.zzly
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzd(T r19) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlk.zzd(java.lang.Object):boolean");
    }

    private static zzmw zze(Object obj) {
        zzjt zzjtVar = (zzjt) obj;
        zzmw zzmwVar = zzjtVar.zzb;
        if (zzmwVar != zzmw.zzc()) {
            return zzmwVar;
        }
        zzmw zzmwVarZzd = zzmw.zzd();
        zzjtVar.zzb = zzmwVarZzd;
        return zzmwVarZzd;
    }

    private static <T> boolean zze(T t10, long j10) {
        return ((Boolean) zzmz.zze(t10, j10)).booleanValue();
    }

    private final boolean zzc(T t10, T t11, int i10) {
        return zzc((zzlk<T>) t10, i10) == zzc((zzlk<T>) t11, i10);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v11 */
    @Override // com.google.android.gms.internal.measurement.zzly
    public final int zza(T t10) {
        int i10;
        int i11;
        int i12;
        int iZza;
        int iZza2;
        int iZza3;
        int iZzd;
        int iZzf;
        int iZzg;
        Unsafe unsafe = zzb;
        ?? r92 = 0;
        int i13 = 1048575;
        int i14 = 1048575;
        int i15 = 0;
        int i16 = 0;
        int iZzd2 = 0;
        while (i16 < this.zzc.length) {
            int iZzc = zzc(i16);
            int i17 = (267386880 & iZzc) >>> 20;
            int[] iArr = this.zzc;
            int i18 = iArr[i16];
            int i19 = iArr[i16 + 2];
            int i20 = i19 & i13;
            if (i17 <= 17) {
                if (i20 != i14) {
                    i15 = i20 == i13 ? 0 : unsafe.getInt(t10, i20);
                    i14 = i20;
                }
                i10 = i14;
                i11 = i15;
                i12 = 1 << (i19 >>> 20);
            } else {
                i10 = i14;
                i11 = i15;
                i12 = 0;
            }
            long j10 = iZzc & i13;
            if (i17 >= zzjo.zza.zza()) {
                zzjo.zzb.zza();
            }
            int i21 = i12;
            switch (i17) {
                case 0:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza = zzja.zza(i18, 0.0d);
                        iZzd2 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza = zzja.zza(i18, 0.0f);
                        iZzd2 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza = zzja.zzb(i18, unsafe.getLong(t10, j10));
                        iZzd2 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza = zzja.zze(i18, unsafe.getLong(t10, j10));
                        iZzd2 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza = zzja.zzc(i18, unsafe.getInt(t10, j10));
                        iZzd2 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza = zzja.zza(i18, 0L);
                        iZzd2 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza = zzja.zzb(i18, 0);
                        iZzd2 += iZza;
                        break;
                    }
                    break;
                case 7:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza2 = zzja.zza(i18, true);
                        iZzd2 += iZza2;
                    }
                    break;
                case 8:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        Object object = unsafe.getObject(t10, j10);
                        if (object instanceof zzij) {
                            iZza2 = zzja.zza(i18, (zzij) object);
                        } else {
                            iZza2 = zzja.zza(i18, (String) object);
                        }
                        iZzd2 += iZza2;
                    }
                    break;
                case 9:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza3 = zzma.zza(i18, unsafe.getObject(t10, j10), zze(i16));
                        iZzd2 += iZza3;
                    }
                    break;
                case 10:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza2 = zzja.zza(i18, (zzij) unsafe.getObject(t10, j10));
                        iZzd2 += iZza2;
                    }
                    break;
                case 11:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza2 = zzja.zzf(i18, unsafe.getInt(t10, j10));
                        iZzd2 += iZza2;
                    }
                    break;
                case 12:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza2 = zzja.zza(i18, unsafe.getInt(t10, j10));
                        iZzd2 += iZza2;
                    }
                    break;
                case 13:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZzd2 += zzja.zzd(i18, 0);
                    }
                    break;
                case 14:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza2 = zzja.zzc(i18, 0L);
                        iZzd2 += iZza2;
                    }
                    break;
                case 15:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza2 = zzja.zze(i18, unsafe.getInt(t10, j10));
                        iZzd2 += iZza2;
                    }
                    break;
                case 16:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza2 = zzja.zzd(i18, unsafe.getLong(t10, j10));
                        iZzd2 += iZza2;
                    }
                    break;
                case 17:
                    if (zza((zzlk<T>) t10, i16, i10, i11, i21)) {
                        iZza2 = zzja.zza(i18, (zzlg) unsafe.getObject(t10, j10), zze(i16));
                        iZzd2 += iZza2;
                    }
                    break;
                case 18:
                    iZza3 = zzma.zzd(i18, (List) unsafe.getObject(t10, j10), r92);
                    iZzd2 += iZza3;
                    break;
                case 19:
                    iZza3 = zzma.zzc(i18, (List) unsafe.getObject(t10, j10), r92);
                    iZzd2 += iZza3;
                    break;
                case 20:
                    iZza3 = zzma.zzf(i18, (List) unsafe.getObject(t10, j10), r92);
                    iZzd2 += iZza3;
                    break;
                case 21:
                    iZza3 = zzma.zzj(i18, (List) unsafe.getObject(t10, j10), r92);
                    iZzd2 += iZza3;
                    break;
                case 22:
                    iZza3 = zzma.zze(i18, (List) unsafe.getObject(t10, j10), r92);
                    iZzd2 += iZza3;
                    break;
                case 23:
                    iZza3 = zzma.zzd(i18, (List) unsafe.getObject(t10, j10), r92);
                    iZzd2 += iZza3;
                    break;
                case 24:
                    iZza3 = zzma.zzc(i18, (List) unsafe.getObject(t10, j10), r92);
                    iZzd2 += iZza3;
                    break;
                case 25:
                    iZza3 = zzma.zza(i18, (List<?>) unsafe.getObject(t10, j10), (boolean) r92);
                    iZzd2 += iZza3;
                    break;
                case 26:
                    iZza3 = zzma.zzb(i18, (List) unsafe.getObject(t10, j10));
                    iZzd2 += iZza3;
                    break;
                case 27:
                    iZza3 = zzma.zzb(i18, (List<?>) unsafe.getObject(t10, j10), zze(i16));
                    iZzd2 += iZza3;
                    break;
                case 28:
                    iZza3 = zzma.zza(i18, (List<zzij>) unsafe.getObject(t10, j10));
                    iZzd2 += iZza3;
                    break;
                case 29:
                    iZza3 = zzma.zzi(i18, (List) unsafe.getObject(t10, j10), r92);
                    iZzd2 += iZza3;
                    break;
                case 30:
                    iZza3 = zzma.zzb(i18, (List<Integer>) unsafe.getObject(t10, j10), (boolean) r92);
                    iZzd2 += iZza3;
                    break;
                case 31:
                    iZza3 = zzma.zzc(i18, (List) unsafe.getObject(t10, j10), r92);
                    iZzd2 += iZza3;
                    break;
                case 32:
                    iZza3 = zzma.zzd(i18, (List) unsafe.getObject(t10, j10), r92);
                    iZzd2 += iZza3;
                    break;
                case 33:
                    iZza3 = zzma.zzg(i18, (List) unsafe.getObject(t10, j10), r92);
                    iZzd2 += iZza3;
                    break;
                case 34:
                    iZza3 = zzma.zzh(i18, (List) unsafe.getObject(t10, j10), r92);
                    iZzd2 += iZza3;
                    break;
                case 35:
                    iZzd = zzma.zzd((List) unsafe.getObject(t10, j10));
                    if (iZzd > 0) {
                        iZzf = zzja.zzf(i18);
                        iZzg = zzja.zzg(iZzd);
                        iZzd2 += iZzg + iZzf + iZzd;
                    }
                    break;
                case 36:
                    iZzd = zzma.zzc((List) unsafe.getObject(t10, j10));
                    if (iZzd > 0) {
                        iZzf = zzja.zzf(i18);
                        iZzg = zzja.zzg(iZzd);
                        iZzd2 += iZzg + iZzf + iZzd;
                    }
                    break;
                case 37:
                    iZzd = zzma.zzf((List) unsafe.getObject(t10, j10));
                    if (iZzd > 0) {
                        iZzf = zzja.zzf(i18);
                        iZzg = zzja.zzg(iZzd);
                        iZzd2 += iZzg + iZzf + iZzd;
                    }
                    break;
                case 38:
                    iZzd = zzma.zzj((List) unsafe.getObject(t10, j10));
                    if (iZzd > 0) {
                        iZzf = zzja.zzf(i18);
                        iZzg = zzja.zzg(iZzd);
                        iZzd2 += iZzg + iZzf + iZzd;
                    }
                    break;
                case 39:
                    iZzd = zzma.zze((List) unsafe.getObject(t10, j10));
                    if (iZzd > 0) {
                        iZzf = zzja.zzf(i18);
                        iZzg = zzja.zzg(iZzd);
                        iZzd2 += iZzg + iZzf + iZzd;
                    }
                    break;
                case 40:
                    iZzd = zzma.zzd((List) unsafe.getObject(t10, j10));
                    if (iZzd > 0) {
                        iZzf = zzja.zzf(i18);
                        iZzg = zzja.zzg(iZzd);
                        iZzd2 += iZzg + iZzf + iZzd;
                    }
                    break;
                case 41:
                    iZzd = zzma.zzc((List) unsafe.getObject(t10, j10));
                    if (iZzd > 0) {
                        iZzf = zzja.zzf(i18);
                        iZzg = zzja.zzg(iZzd);
                        iZzd2 += iZzg + iZzf + iZzd;
                    }
                    break;
                case 42:
                    iZzd = zzma.zza((List<?>) unsafe.getObject(t10, j10));
                    if (iZzd > 0) {
                        iZzf = zzja.zzf(i18);
                        iZzg = zzja.zzg(iZzd);
                        iZzd2 += iZzg + iZzf + iZzd;
                    }
                    break;
                case 43:
                    iZzd = zzma.zzi((List) unsafe.getObject(t10, j10));
                    if (iZzd > 0) {
                        iZzf = zzja.zzf(i18);
                        iZzg = zzja.zzg(iZzd);
                        iZzd2 += iZzg + iZzf + iZzd;
                    }
                    break;
                case 44:
                    iZzd = zzma.zzb((List) unsafe.getObject(t10, j10));
                    if (iZzd > 0) {
                        iZzf = zzja.zzf(i18);
                        iZzg = zzja.zzg(iZzd);
                        iZzd2 += iZzg + iZzf + iZzd;
                    }
                    break;
                case 45:
                    iZzd = zzma.zzc((List) unsafe.getObject(t10, j10));
                    if (iZzd > 0) {
                        iZzf = zzja.zzf(i18);
                        iZzg = zzja.zzg(iZzd);
                        iZzd2 += iZzg + iZzf + iZzd;
                    }
                    break;
                case 46:
                    iZzd = zzma.zzd((List) unsafe.getObject(t10, j10));
                    if (iZzd > 0) {
                        iZzf = zzja.zzf(i18);
                        iZzg = zzja.zzg(iZzd);
                        iZzd2 += iZzg + iZzf + iZzd;
                    }
                    break;
                case 47:
                    iZzd = zzma.zzg((List) unsafe.getObject(t10, j10));
                    if (iZzd > 0) {
                        iZzf = zzja.zzf(i18);
                        iZzg = zzja.zzg(iZzd);
                        iZzd2 += iZzg + iZzf + iZzd;
                    }
                    break;
                case 48:
                    iZzd = zzma.zzh((List) unsafe.getObject(t10, j10));
                    if (iZzd > 0) {
                        iZzf = zzja.zzf(i18);
                        iZzg = zzja.zzg(iZzd);
                        iZzd2 += iZzg + iZzf + iZzd;
                    }
                    break;
                case 49:
                    iZza3 = zzma.zza(i18, (List<zzlg>) unsafe.getObject(t10, j10), zze(i16));
                    iZzd2 += iZza3;
                    break;
                case 50:
                    iZza3 = this.zzs.zza(i18, unsafe.getObject(t10, j10), zzf(i16));
                    iZzd2 += iZza3;
                    break;
                case 51:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zza(i18, 0.0d);
                        iZzd2 += iZza2;
                    }
                    break;
                case 52:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zza(i18, 0.0f);
                        iZzd2 += iZza2;
                    }
                    break;
                case 53:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zzb(i18, zzd(t10, j10));
                        iZzd2 += iZza2;
                    }
                    break;
                case 54:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zze(i18, zzd(t10, j10));
                        iZzd2 += iZza2;
                    }
                    break;
                case 55:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zzc(i18, zzc(t10, j10));
                        iZzd2 += iZza2;
                    }
                    break;
                case 56:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zza(i18, 0L);
                        iZzd2 += iZza2;
                    }
                    break;
                case 57:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zzb(i18, (int) r92);
                        iZzd2 += iZza2;
                    }
                    break;
                case 58:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zza(i18, true);
                        iZzd2 += iZza2;
                    }
                    break;
                case 59:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        Object object2 = unsafe.getObject(t10, j10);
                        if (object2 instanceof zzij) {
                            iZza2 = zzja.zza(i18, (zzij) object2);
                        } else {
                            iZza2 = zzja.zza(i18, (String) object2);
                        }
                        iZzd2 += iZza2;
                    }
                    break;
                case 60:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza3 = zzma.zza(i18, unsafe.getObject(t10, j10), zze(i16));
                        iZzd2 += iZza3;
                    }
                    break;
                case 61:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zza(i18, (zzij) unsafe.getObject(t10, j10));
                        iZzd2 += iZza2;
                    }
                    break;
                case 62:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zzf(i18, zzc(t10, j10));
                        iZzd2 += iZza2;
                    }
                    break;
                case 63:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zza(i18, zzc(t10, j10));
                        iZzd2 += iZza2;
                    }
                    break;
                case 64:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zzd(i18, (int) r92);
                        iZzd2 += iZza2;
                    }
                    break;
                case 65:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zzc(i18, 0L);
                        iZzd2 += iZza2;
                    }
                    break;
                case 66:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zze(i18, zzc(t10, j10));
                        iZzd2 += iZza2;
                    }
                    break;
                case 67:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zzd(i18, zzd(t10, j10));
                        iZzd2 += iZza2;
                    }
                    break;
                case 68:
                    if (zzc((zzlk<T>) t10, i18, i16)) {
                        iZza2 = zzja.zza(i18, (zzlg) unsafe.getObject(t10, j10), zze(i16));
                        iZzd2 += iZza2;
                    }
                    break;
            }
            i16 += 3;
            i14 = i10;
            i15 = i11;
            r92 = 0;
            i13 = 1048575;
        }
        int iZza4 = 0;
        zzmt<?, ?> zzmtVar = this.zzq;
        int iZza5 = iZzd2 + zzmtVar.zza((zzmt<?, ?>) zzmtVar.zzd(t10));
        if (!this.zzh) {
            return iZza5;
        }
        zzjj<T> zzjjVarZza = this.zzr.zza(t10);
        for (int i22 = 0; i22 < zzjjVarZza.zza.zza(); i22++) {
            Map.Entry entryZzb = zzjjVarZza.zza.zzb(i22);
            iZza4 += zzjj.zza((zzjl<?>) entryZzb.getKey(), entryZzb.getValue());
        }
        for (Map.Entry entry : zzjjVarZza.zza.zzb()) {
            iZza4 += zzjj.zza((zzjl<?>) entry.getKey(), entry.getValue());
        }
        return iZza5 + iZza4;
    }

    private final boolean zzc(T t10, int i10) {
        int iZzb = zzb(i10);
        long j10 = iZzb & 1048575;
        if (j10 != 1048575) {
            return (zzmz.zzc(t10, j10) & (1 << (iZzb >>> 20))) != 0;
        }
        int iZzc = zzc(i10);
        long j11 = iZzc & 1048575;
        switch ((iZzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzmz.zza(t10, j11)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmz.zzb(t10, j11)) != 0;
            case 2:
                return zzmz.zzd(t10, j11) != 0;
            case 3:
                return zzmz.zzd(t10, j11) != 0;
            case 4:
                return zzmz.zzc(t10, j11) != 0;
            case 5:
                return zzmz.zzd(t10, j11) != 0;
            case 6:
                return zzmz.zzc(t10, j11) != 0;
            case 7:
                return zzmz.zzh(t10, j11);
            case 8:
                Object objZze = zzmz.zze(t10, j11);
                if (objZze instanceof String) {
                    return !((String) objZze).isEmpty();
                }
                if (objZze instanceof zzij) {
                    return !zzij.zza.equals(objZze);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmz.zze(t10, j11) != null;
            case 10:
                return !zzij.zza.equals(zzmz.zze(t10, j11));
            case 11:
                return zzmz.zzc(t10, j11) != 0;
            case 12:
                return zzmz.zzc(t10, j11) != 0;
            case 13:
                return zzmz.zzc(t10, j11) != 0;
            case 14:
                return zzmz.zzd(t10, j11) != 0;
            case 15:
                return zzmz.zzc(t10, j11) != 0;
            case 16:
                return zzmz.zzd(t10, j11) != 0;
            case 17:
                return zzmz.zze(t10, j11) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzc(T t10, int i10, int i11) {
        return zzmz.zzc(t10, (long) (zzb(i11) & 1048575)) == i10;
    }

    private final int zzb(int i10) {
        return this.zzc[i10 + 2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t10, T t11, int i10) {
        int i11 = this.zzc[i10];
        if (zzc((zzlk<T>) t11, i11, i10)) {
            long jZzc = zzc(i10) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t11, jZzc);
            if (object != null) {
                zzly zzlyVarZze = zze(i10);
                if (!zzc((zzlk<T>) t10, i11, i10)) {
                    if (!zzg(object)) {
                        unsafe.putObject(t10, jZzc, object);
                    } else {
                        Object objZza = zzlyVarZze.zza();
                        zzlyVarZze.zza(objZza, object);
                        unsafe.putObject(t10, jZzc, objZza);
                    }
                    zzb((zzlk<T>) t10, i11, i10);
                    return;
                }
                Object object2 = unsafe.getObject(t10, jZzc);
                if (!zzg(object2)) {
                    Object objZza2 = zzlyVarZze.zza();
                    zzlyVarZze.zza(objZza2, object2);
                    unsafe.putObject(t10, jZzc, objZza2);
                    object2 = objZza2;
                }
                zzlyVarZze.zza(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + this.zzc[i10] + " is present but null: " + String.valueOf(t11));
        }
    }

    private final void zzb(T t10, int i10) {
        int iZzb = zzb(i10);
        long j10 = 1048575 & iZzb;
        if (j10 == 1048575) {
            return;
        }
        zzmz.zza((Object) t10, j10, (1 << (iZzb >>> 20)) | zzmz.zzc(t10, j10));
    }

    private final void zzb(T t10, int i10, int i11) {
        zzmz.zza((Object) t10, zzb(i11) & 1048575, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.measurement.zzly
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzb(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlk.zzb(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:428:0x09dc, code lost:
    
        throw com.google.android.gms.internal.measurement.zzkb.zzh();
     */
    /* JADX WARN: Code restructure failed: missing block: B:525:0x0ce8, code lost:
    
        if (r14 == r0) goto L527;
     */
    /* JADX WARN: Code restructure failed: missing block: B:526:0x0cea, code lost:
    
        r28.putInt(r7, r14, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:527:0x0cf0, code lost:
    
        r10 = r9.zzm;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:529:0x0cf7, code lost:
    
        if (r10 >= r9.zzn) goto L644;
     */
    /* JADX WARN: Code restructure failed: missing block: B:530:0x0cf9, code lost:
    
        r3 = (com.google.android.gms.internal.measurement.zzmw) zza((java.lang.Object) r32, r9.zzl[r10], (int) r3, (com.google.android.gms.internal.measurement.zzmt<UT, int>) r9.zzq, (java.lang.Object) r32);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:531:0x0d0f, code lost:
    
        if (r3 == null) goto L533;
     */
    /* JADX WARN: Code restructure failed: missing block: B:532:0x0d11, code lost:
    
        r9.zzq.zzb((java.lang.Object) r7, (T) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:533:0x0d16, code lost:
    
        if (r6 != 0) goto L539;
     */
    /* JADX WARN: Code restructure failed: missing block: B:535:0x0d1a, code lost:
    
        if (r8 != r35) goto L537;
     */
    /* JADX WARN: Code restructure failed: missing block: B:538:0x0d21, code lost:
    
        throw com.google.android.gms.internal.measurement.zzkb.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:540:0x0d24, code lost:
    
        if (r8 > r35) goto L543;
     */
    /* JADX WARN: Code restructure failed: missing block: B:541:0x0d26, code lost:
    
        if (r11 != r6) goto L543;
     */
    /* JADX WARN: Code restructure failed: missing block: B:542:0x0d28, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:544:0x0d2d, code lost:
    
        throw com.google.android.gms.internal.measurement.zzkb.zzg();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:504:0x0c5c A[PHI: r4 r5 r6 r8 r13 r14 r19
  0x0c5c: PHI (r4v96 int) = 
  (r4v70 int)
  (r4v71 int)
  (r4v72 int)
  (r4v73 int)
  (r4v74 int)
  (r4v76 int)
  (r4v77 int)
  (r4v78 int)
  (r4v85 int)
  (r4v92 int)
  (r4v97 int)
 binds: [B:501:0x0c48, B:498:0x0c28, B:495:0x0c08, B:492:0x0be8, B:489:0x0bc8, B:486:0x0ba7, B:479:0x0b7d, B:465:0x0b3f, B:463:0x0b2e, B:437:0x0a46, B:433:0x0a05] A[DONT_GENERATE, DONT_INLINE]
  0x0c5c: PHI (r5v99 com.google.android.gms.internal.measurement.zzlk<T>) = 
  (r5v74 com.google.android.gms.internal.measurement.zzlk<T>)
  (r5v75 com.google.android.gms.internal.measurement.zzlk<T>)
  (r5v76 com.google.android.gms.internal.measurement.zzlk<T>)
  (r5v77 com.google.android.gms.internal.measurement.zzlk<T>)
  (r5v78 com.google.android.gms.internal.measurement.zzlk<T>)
  (r5v80 com.google.android.gms.internal.measurement.zzlk<T>)
  (r5v81 com.google.android.gms.internal.measurement.zzlk<T>)
  (r5v82 com.google.android.gms.internal.measurement.zzlk<T>)
  (r5v89 com.google.android.gms.internal.measurement.zzlk<T>)
  (r5v95 com.google.android.gms.internal.measurement.zzlk<T>)
  (r5v100 com.google.android.gms.internal.measurement.zzlk<T>)
 binds: [B:501:0x0c48, B:498:0x0c28, B:495:0x0c08, B:492:0x0be8, B:489:0x0bc8, B:486:0x0ba7, B:479:0x0b7d, B:465:0x0b3f, B:463:0x0b2e, B:437:0x0a46, B:433:0x0a05] A[DONT_GENERATE, DONT_INLINE]
  0x0c5c: PHI (r6v36 int) = 
  (r6v12 int)
  (r6v13 int)
  (r6v14 int)
  (r6v15 int)
  (r6v16 int)
  (r6v18 int)
  (r6v19 int)
  (r6v20 int)
  (r6v25 int)
  (r6v31 int)
  (r6v37 int)
 binds: [B:501:0x0c48, B:498:0x0c28, B:495:0x0c08, B:492:0x0be8, B:489:0x0bc8, B:486:0x0ba7, B:479:0x0b7d, B:465:0x0b3f, B:463:0x0b2e, B:437:0x0a46, B:433:0x0a05] A[DONT_GENERATE, DONT_INLINE]
  0x0c5c: PHI (r8v102 int) = 
  (r8v78 int)
  (r8v79 int)
  (r8v80 int)
  (r8v81 int)
  (r8v82 int)
  (r8v84 int)
  (r8v85 int)
  (r8v86 int)
  (r8v94 int)
  (r8v98 int)
  (r8v103 int)
 binds: [B:501:0x0c48, B:498:0x0c28, B:495:0x0c08, B:492:0x0be8, B:489:0x0bc8, B:486:0x0ba7, B:479:0x0b7d, B:465:0x0b3f, B:463:0x0b2e, B:437:0x0a46, B:433:0x0a05] A[DONT_GENERATE, DONT_INLINE]
  0x0c5c: PHI (r13v89 com.google.android.gms.internal.measurement.zzie) = 
  (r13v65 com.google.android.gms.internal.measurement.zzie)
  (r13v66 com.google.android.gms.internal.measurement.zzie)
  (r13v67 com.google.android.gms.internal.measurement.zzie)
  (r13v68 com.google.android.gms.internal.measurement.zzie)
  (r13v69 com.google.android.gms.internal.measurement.zzie)
  (r13v71 com.google.android.gms.internal.measurement.zzie)
  (r13v72 com.google.android.gms.internal.measurement.zzie)
  (r13v73 com.google.android.gms.internal.measurement.zzie)
  (r13v78 com.google.android.gms.internal.measurement.zzie)
  (r13v84 com.google.android.gms.internal.measurement.zzie)
  (r13v90 com.google.android.gms.internal.measurement.zzie)
 binds: [B:501:0x0c48, B:498:0x0c28, B:495:0x0c08, B:492:0x0be8, B:489:0x0bc8, B:486:0x0ba7, B:479:0x0b7d, B:465:0x0b3f, B:463:0x0b2e, B:437:0x0a46, B:433:0x0a05] A[DONT_GENERATE, DONT_INLINE]
  0x0c5c: PHI (r14v83 byte[]) = 
  (r14v56 byte[])
  (r14v57 byte[])
  (r14v58 byte[])
  (r14v59 byte[])
  (r14v60 byte[])
  (r14v62 byte[])
  (r14v63 byte[])
  (r14v64 byte[])
  (r14v69 byte[])
  (r14v78 byte[])
  (r14v84 byte[])
 binds: [B:501:0x0c48, B:498:0x0c28, B:495:0x0c08, B:492:0x0be8, B:489:0x0bc8, B:486:0x0ba7, B:479:0x0b7d, B:465:0x0b3f, B:463:0x0b2e, B:437:0x0a46, B:433:0x0a05] A[DONT_GENERATE, DONT_INLINE]
  0x0c5c: PHI (r19v48 int) = 
  (r19v27 int)
  (r19v28 int)
  (r19v29 int)
  (r19v30 int)
  (r19v31 int)
  (r19v33 int)
  (r19v34 int)
  (r19v35 int)
  (r19v39 int)
  (r19v45 int)
  (r19v49 int)
 binds: [B:501:0x0c48, B:498:0x0c28, B:495:0x0c08, B:492:0x0be8, B:489:0x0bc8, B:486:0x0ba7, B:479:0x0b7d, B:465:0x0b3f, B:463:0x0b2e, B:437:0x0a46, B:433:0x0a05] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:506:0x0c5f  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x0ca9  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x0ccb  */
    /* JADX WARN: Removed duplicated region for block: B:582:0x08c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:627:0x08b3 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v135, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(T r32, byte[] r33, int r34, int r35, int r36, com.google.android.gms.internal.measurement.zzie r37) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlk.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzie):int");
    }

    private final int zza(int i10) {
        if (i10 < this.zze || i10 > this.zzf) {
            return -1;
        }
        return zza(i10, 0);
    }

    private final int zza(int i10, int i11) {
        int length = (this.zzc.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = this.zzc[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0275  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> com.google.android.gms.internal.measurement.zzlk<T> zza(java.lang.Class<T> r32, com.google.android.gms.internal.measurement.zzle r33, com.google.android.gms.internal.measurement.zzlo r34, com.google.android.gms.internal.measurement.zzkl r35, com.google.android.gms.internal.measurement.zzmt<?, ?> r36, com.google.android.gms.internal.measurement.zzji<?> r37, com.google.android.gms.internal.measurement.zzkz r38) {
        /*
            Method dump skipped, instructions count: 1021
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlk.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzle, com.google.android.gms.internal.measurement.zzlo, com.google.android.gms.internal.measurement.zzkl, com.google.android.gms.internal.measurement.zzmt, com.google.android.gms.internal.measurement.zzji, com.google.android.gms.internal.measurement.zzkz):com.google.android.gms.internal.measurement.zzlk");
    }

    private final <UT, UB> UB zza(Object obj, int i10, UB ub2, zzmt<UT, UB> zzmtVar, Object obj2) {
        zzjx zzjxVarZzd;
        int i11 = this.zzc[i10];
        Object objZze = zzmz.zze(obj, zzc(i10) & 1048575);
        return (objZze == null || (zzjxVarZzd = zzd(i10)) == null) ? ub2 : (UB) zza(i10, i11, this.zzs.zze(objZze), zzjxVarZzd, (zzjx) ub2, (zzmt<UT, zzjx>) zzmtVar, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i10, int i11, Map<K, V> map, zzjx zzjxVar, UB ub2, zzmt<UT, UB> zzmtVar, Object obj) {
        zzkx<?, ?> zzkxVarZza = this.zzs.zza(zzf(i10));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzjxVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = zzmtVar.zzc(obj);
                }
                zzio zzioVarZzc = zzij.zzc(zzky.zza(zzkxVarZza, next.getKey(), next.getValue()));
                try {
                    zzky.zza(zzioVarZzc.zzb(), zzkxVarZza, next.getKey(), next.getValue());
                    zzmtVar.zza((zzmt<UT, UB>) ub2, i11, zzioVarZzc.zza());
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return ub2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t10, int i10) {
        zzly zzlyVarZze = zze(i10);
        long jZzc = zzc(i10) & 1048575;
        if (!zzc((zzlk<T>) t10, i10)) {
            return zzlyVarZze.zza();
        }
        Object object = zzb.getObject(t10, jZzc);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzlyVarZze.zza();
        if (object != null) {
            zzlyVarZze.zza(objZza, object);
        }
        return objZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t10, int i10, int i11) {
        zzly zzlyVarZze = zze(i11);
        if (!zzc((zzlk<T>) t10, i10, i11)) {
            return zzlyVarZze.zza();
        }
        Object object = zzb.getObject(t10, zzc(i11) & 1048575);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzlyVarZze.zza();
        if (object != null) {
            zzlyVarZze.zza(objZza, object);
        }
        return objZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzly
    public final T zza() {
        return (T) this.zzo.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
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

    @Override // com.google.android.gms.internal.measurement.zzly
    public final void zza(T t10, T t11) {
        zzf(t10);
        t11.getClass();
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int iZzc = zzc(i10);
            long j10 = 1048575 & iZzc;
            int i11 = this.zzc[i10];
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza(t10, j10, zzmz.zza(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza((Object) t10, j10, zzmz.zzb(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza((Object) t10, j10, zzmz.zzd(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza((Object) t10, j10, zzmz.zzd(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza((Object) t10, j10, zzmz.zzc(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza((Object) t10, j10, zzmz.zzd(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza((Object) t10, j10, zzmz.zzc(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zzc(t10, j10, zzmz.zzh(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza(t10, j10, zzmz.zze(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t10, t11, i10);
                    break;
                case 10:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza(t10, j10, zzmz.zze(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza((Object) t10, j10, zzmz.zzc(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza((Object) t10, j10, zzmz.zzc(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza((Object) t10, j10, zzmz.zzc(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza((Object) t10, j10, zzmz.zzd(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza((Object) t10, j10, zzmz.zzc(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzc((zzlk<T>) t11, i10)) {
                        zzmz.zza((Object) t10, j10, zzmz.zzd(t11, j10));
                        zzb((zzlk<T>) t10, i10);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t10, t11, i10);
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
                    this.zzp.zza(t10, t11, j10);
                    break;
                case 50:
                    zzma.zza(this.zzs, t10, t11, j10);
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
                    if (zzc((zzlk<T>) t11, i11, i10)) {
                        zzmz.zza(t10, j10, zzmz.zze(t11, j10));
                        zzb((zzlk<T>) t10, i11, i10);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(t10, t11, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzc((zzlk<T>) t11, i11, i10)) {
                        zzmz.zza(t10, j10, zzmz.zze(t11, j10));
                        zzb((zzlk<T>) t10, i11, i10);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t10, t11, i10);
                    break;
            }
        }
        zzma.zza(this.zzq, t10, t11);
        if (this.zzh) {
            zzma.zza(this.zzr, t10, t11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0624 A[Catch: all -> 0x0297, TryCatch #2 {all -> 0x0297, blocks: (B:156:0x05f8, B:166:0x061f, B:168:0x0624, B:169:0x0629, B:51:0x00cb, B:52:0x00dd, B:53:0x00ef, B:54:0x0101, B:55:0x0112, B:56:0x0123, B:58:0x012d, B:61:0x0134, B:62:0x013b, B:63:0x0148, B:64:0x0159, B:65:0x0166, B:66:0x0177, B:68:0x0182, B:69:0x0193, B:70:0x01a4, B:71:0x01b5, B:72:0x01c6, B:73:0x01d7, B:74:0x01e8, B:75:0x01f9, B:76:0x020b, B:78:0x021b, B:82:0x023c, B:79:0x0225, B:81:0x022d, B:83:0x024d, B:84:0x025f, B:85:0x026d, B:86:0x027b, B:87:0x0289), top: B:192:0x05f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x065b A[LOOP:3: B:184:0x0657->B:186:0x065b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x062f A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.google.android.gms.internal.measurement.zzlv] */
    @Override // com.google.android.gms.internal.measurement.zzly
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r18, com.google.android.gms.internal.measurement.zzlv r19, com.google.android.gms.internal.measurement.zzjg r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1794
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlk.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzlv, com.google.android.gms.internal.measurement.zzjg):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzly
    public final void zza(T t10, byte[] bArr, int i10, int i11, zzie zzieVar) throws IOException {
        zza((zzlk<T>) t10, bArr, i10, i11, 0, zzieVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t10, T t11, int i10) {
        if (zzc((zzlk<T>) t11, i10)) {
            long jZzc = zzc(i10) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t11, jZzc);
            if (object != null) {
                zzly zzlyVarZze = zze(i10);
                if (!zzc((zzlk<T>) t10, i10)) {
                    if (!zzg(object)) {
                        unsafe.putObject(t10, jZzc, object);
                    } else {
                        Object objZza = zzlyVarZze.zza();
                        zzlyVarZze.zza(objZza, object);
                        unsafe.putObject(t10, jZzc, objZza);
                    }
                    zzb((zzlk<T>) t10, i10);
                    return;
                }
                Object object2 = unsafe.getObject(t10, jZzc);
                if (!zzg(object2)) {
                    Object objZza2 = zzlyVarZze.zza();
                    zzlyVarZze.zza(objZza2, object2);
                    unsafe.putObject(t10, jZzc, objZza2);
                    object2 = objZza2;
                }
                zzlyVarZze.zza(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + this.zzc[i10] + " is present but null: " + String.valueOf(t11));
        }
    }

    private final void zza(Object obj, int i10, zzlv zzlvVar) throws IOException {
        if (zzg(i10)) {
            zzmz.zza(obj, i10 & 1048575, zzlvVar.zzr());
        } else if (this.zzi) {
            zzmz.zza(obj, i10 & 1048575, zzlvVar.zzq());
        } else {
            zzmz.zza(obj, i10 & 1048575, zzlvVar.zzp());
        }
    }

    private final void zza(T t10, int i10, Object obj) {
        zzb.putObject(t10, zzc(i10) & 1048575, obj);
        zzb((zzlk<T>) t10, i10);
    }

    private final void zza(T t10, int i10, int i11, Object obj) {
        zzb.putObject(t10, zzc(i11) & 1048575, obj);
        zzb((zzlk<T>) t10, i10, i11);
    }

    private final <K, V> void zza(zznt zzntVar, int i10, Object obj, int i11) throws IOException {
        if (obj != null) {
            zzntVar.zza(i10, this.zzs.zza(zzf(i11)), this.zzs.zzd(obj));
        }
    }

    private static void zza(int i10, Object obj, zznt zzntVar) throws IOException {
        if (obj instanceof String) {
            zzntVar.zza(i10, (String) obj);
        } else {
            zzntVar.zza(i10, (zzij) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
    @Override // com.google.android.gms.internal.measurement.zzly
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r24, com.google.android.gms.internal.measurement.zznt r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlk.zza(java.lang.Object, com.google.android.gms.internal.measurement.zznt):void");
    }

    private static <UT, UB> void zza(zzmt<UT, UB> zzmtVar, T t10, zznt zzntVar) throws IOException {
        zzmtVar.zzb((zzmt<UT, UB>) zzmtVar.zzd(t10), zzntVar);
    }

    private final boolean zza(T t10, int i10, int i11, int i12, int i13) {
        if (i11 == 1048575) {
            return zzc((zzlk<T>) t10, i10);
        }
        return (i12 & i13) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i10, zzly zzlyVar) {
        return zzlyVar.zzd(zzmz.zze(obj, i10 & 1048575));
    }
}
