package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzma {
    private static final Class<?> zza = zzd();
    private static final zzmt<?, ?> zzb = zzc();
    private static final zzmt<?, ?> zzc = new zzmv();

    public static int zza(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzja.zza(i10, true) * size;
    }

    public static int zzb(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzja.zzf(i10) * size) + zzb(list);
    }

    public static int zzc(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzja.zzb(i10, 0) * size;
    }

    public static int zzd(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzja.zza(i10, 0L) * size;
    }

    public static int zze(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzja.zzf(i10) * size) + zze(list);
    }

    public static int zzf(int i10, List<Long> list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return (zzja.zzf(i10) * list.size()) + zzf(list);
    }

    public static int zzg(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzja.zzf(i10) * size) + zzg(list);
    }

    public static int zzh(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzja.zzf(i10) * size) + zzh(list);
    }

    public static int zzi(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzja.zzf(i10) * size) + zzi(list);
    }

    public static int zzj(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzja.zzf(i10) * size) + zzj(list);
    }

    public static void zzk(int i10, List<Integer> list, zznt zzntVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zzk(i10, list, z10);
    }

    public static void zzl(int i10, List<Long> list, zznt zzntVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zzl(i10, list, z10);
    }

    public static void zzm(int i10, List<Integer> list, zznt zzntVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zzm(i10, list, z10);
    }

    public static void zzn(int i10, List<Long> list, zznt zzntVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zzn(i10, list, z10);
    }

    public static int zza(List<?> list) {
        return list.size();
    }

    public static int zzc(List<?> list) {
        return list.size() << 2;
    }

    public static int zzd(List<?> list) {
        return list.size() << 3;
    }

    public static int zza(int i10, List<zzij> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzf = zzja.zzf(i10) * size;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iZzf += zzja.zza(list.get(i11));
        }
        return iZzf;
    }

    public static int zzb(List<Integer> list) {
        int iZza;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzju) {
            zzju zzjuVar = (zzju) list;
            iZza = 0;
            while (i10 < size) {
                iZza += zzja.zza(zzjuVar.zzb(i10));
                i10++;
            }
        } else {
            iZza = 0;
            while (i10 < size) {
                iZza += zzja.zza(list.get(i10).intValue());
                i10++;
            }
        }
        return iZza;
    }

    private static zzmt<?, ?> zzc() {
        try {
            Class<?> clsZze = zze();
            if (clsZze == null) {
                return null;
            }
            return (zzmt) clsZze.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int zze(List<Integer> list) {
        int iZzc;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzju) {
            zzju zzjuVar = (zzju) list;
            iZzc = 0;
            while (i10 < size) {
                iZzc += zzja.zzc(zzjuVar.zzb(i10));
                i10++;
            }
        } else {
            iZzc = 0;
            while (i10 < size) {
                iZzc += zzja.zzc(list.get(i10).intValue());
                i10++;
            }
        }
        return iZzc;
    }

    public static int zzf(List<Long> list) {
        int iZzb;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkr) {
            zzkr zzkrVar = (zzkr) list;
            iZzb = 0;
            while (i10 < size) {
                iZzb += zzja.zzb(zzkrVar.zzb(i10));
                i10++;
            }
        } else {
            iZzb = 0;
            while (i10 < size) {
                iZzb += zzja.zzb(list.get(i10).longValue());
                i10++;
            }
        }
        return iZzb;
    }

    public static int zzg(List<Integer> list) {
        int iZze;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzju) {
            zzju zzjuVar = (zzju) list;
            iZze = 0;
            while (i10 < size) {
                iZze += zzja.zze(zzjuVar.zzb(i10));
                i10++;
            }
        } else {
            iZze = 0;
            while (i10 < size) {
                iZze += zzja.zze(list.get(i10).intValue());
                i10++;
            }
        }
        return iZze;
    }

    public static int zzh(List<Long> list) {
        int iZzd;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkr) {
            zzkr zzkrVar = (zzkr) list;
            iZzd = 0;
            while (i10 < size) {
                iZzd += zzja.zzd(zzkrVar.zzb(i10));
                i10++;
            }
        } else {
            iZzd = 0;
            while (i10 < size) {
                iZzd += zzja.zzd(list.get(i10).longValue());
                i10++;
            }
        }
        return iZzd;
    }

    public static int zzi(List<Integer> list) {
        int iZzg;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzju) {
            zzju zzjuVar = (zzju) list;
            iZzg = 0;
            while (i10 < size) {
                iZzg += zzja.zzg(zzjuVar.zzb(i10));
                i10++;
            }
        } else {
            iZzg = 0;
            while (i10 < size) {
                iZzg += zzja.zzg(list.get(i10).intValue());
                i10++;
            }
        }
        return iZzg;
    }

    public static int zzj(List<Long> list) {
        int iZze;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkr) {
            zzkr zzkrVar = (zzkr) list;
            iZze = 0;
            while (i10 < size) {
                iZze += zzja.zze(zzkrVar.zzb(i10));
                i10++;
            }
        } else {
            iZze = 0;
            while (i10 < size) {
                iZze += zzja.zze(list.get(i10).longValue());
                i10++;
            }
        }
        return iZze;
    }

    public static void zzd(int i10, List<Integer> list, zznt zzntVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zzd(i10, list, z10);
    }

    public static void zzc(int i10, List<Integer> list, zznt zzntVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zzc(i10, list, z10);
    }

    public static int zza(int i10, List<zzlg> list, zzly zzlyVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZza = 0;
        for (int i11 = 0; i11 < size; i11++) {
            iZza += zzja.zza(i10, list.get(i11), zzlyVar);
        }
        return iZza;
    }

    public static int zzb(int i10, List<?> list, zzly zzlyVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzf = zzja.zzf(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (obj instanceof zzkk) {
                iZza = zzja.zza((zzkk) obj);
            } else {
                iZza = zzja.zza((zzlg) obj, zzlyVar);
            }
            iZzf = iZza + iZzf;
        }
        return iZzf;
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzf(int i10, List<Float> list, zznt zzntVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zzf(i10, list, z10);
    }

    public static void zzg(int i10, List<Integer> list, zznt zzntVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zzg(i10, list, z10);
    }

    public static void zzh(int i10, List<Long> list, zznt zzntVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zzh(i10, list, z10);
    }

    public static void zzi(int i10, List<Integer> list, zznt zzntVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zzi(i10, list, z10);
    }

    public static void zzj(int i10, List<Long> list, zznt zzntVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zzj(i10, list, z10);
    }

    public static int zza(int i10, Object obj, zzly zzlyVar) {
        if (obj instanceof zzkk) {
            return zzja.zzb(i10, (zzkk) obj);
        }
        return zzja.zzb(i10, (zzlg) obj, zzlyVar);
    }

    public static void zze(int i10, List<Long> list, zznt zzntVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zze(i10, list, z10);
    }

    public static zzmt<?, ?> zza() {
        return zzb;
    }

    public static <UT, UB> UB zza(Object obj, int i10, List<Integer> list, zzjx zzjxVar, UB ub2, zzmt<UT, UB> zzmtVar) {
        if (zzjxVar == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int iIntValue = list.get(i12).intValue();
                if (zzjxVar.zza(iIntValue)) {
                    if (i12 != i11) {
                        list.set(i11, Integer.valueOf(iIntValue));
                    }
                    i11++;
                } else {
                    ub2 = (UB) zza(obj, i10, iIntValue, ub2, zzmtVar);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (!zzjxVar.zza(iIntValue2)) {
                    ub2 = (UB) zza(obj, i10, iIntValue2, ub2, zzmtVar);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    public static int zzb(int i10, List<?> list) {
        int iZza;
        int iZza2;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzf = zzja.zzf(i10) * size;
        if (list instanceof zzkm) {
            zzkm zzkmVar = (zzkm) list;
            while (i11 < size) {
                Object objZzb = zzkmVar.zzb(i11);
                if (objZzb instanceof zzij) {
                    iZza2 = zzja.zza((zzij) objZzb);
                } else {
                    iZza2 = zzja.zza((String) objZzb);
                }
                iZzf = iZza2 + iZzf;
                i11++;
            }
        } else {
            while (i11 < size) {
                Object obj = list.get(i11);
                if (obj instanceof zzij) {
                    iZza = zzja.zza((zzij) obj);
                } else {
                    iZza = zzja.zza((String) obj);
                }
                iZzf = iZza + iZzf;
                i11++;
            }
        }
        return iZzf;
    }

    public static <UT, UB> UB zza(Object obj, int i10, int i11, UB ub2, zzmt<UT, UB> zzmtVar) {
        if (ub2 == null) {
            ub2 = zzmtVar.zzc(obj);
        }
        zzmtVar.zzb(ub2, i10, i11);
        return ub2;
    }

    public static zzmt<?, ?> zzb() {
        return zzc;
    }

    public static <T, FT extends zzjl<FT>> void zza(zzji<FT> zzjiVar, T t10, T t11) {
        zzjj<T> zzjjVarZza = zzjiVar.zza(t11);
        if (zzjjVarZza.zza.isEmpty()) {
            return;
        }
        zzjiVar.zzb(t10).zza((zzjj) zzjjVarZza);
    }

    public static void zzb(int i10, List<Double> list, zznt zzntVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zzb(i10, list, z10);
    }

    public static void zzb(int i10, List<?> list, zznt zzntVar, zzly zzlyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zzb(i10, list, zzlyVar);
    }

    public static <T> void zza(zzkz zzkzVar, T t10, T t11, long j10) {
        zzmz.zza(t10, j10, zzkzVar.zza(zzmz.zze(t10, j10), zzmz.zze(t11, j10)));
    }

    public static void zzb(int i10, List<String> list, zznt zzntVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zzb(i10, list);
    }

    public static <T, UT, UB> void zza(zzmt<UT, UB> zzmtVar, T t10, T t11) {
        zzmtVar.zzc(t10, zzmtVar.zza(zzmtVar.zzd(t10), zzmtVar.zzd(t11)));
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzjt.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i10, List<Boolean> list, zznt zzntVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zza(i10, list, z10);
    }

    public static void zza(int i10, List<zzij> list, zznt zzntVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zza(i10, list);
    }

    public static void zza(int i10, List<?> list, zznt zzntVar, zzly zzlyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzntVar.zza(i10, list, zzlyVar);
    }

    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
