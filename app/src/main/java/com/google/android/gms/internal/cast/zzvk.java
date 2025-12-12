package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzvk {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzvz zzc;
    private static final zzvz zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzvz zzvzVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzvzVar = (zzvz) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzvzVar;
        zzd = new zzwb();
    }

    public static void zzA(int i10, List list, zzwq zzwqVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzwqVar.zzA(i10, list, z10);
    }

    public static void zzB(int i10, List list, zzwq zzwqVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzwqVar.zzC(i10, list, z10);
    }

    public static void zzC(int i10, List list, zzwq zzwqVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzwqVar.zzG(i10, list, z10);
    }

    public static void zzD(int i10, List list, zzwq zzwqVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzwqVar.zzI(i10, list, z10);
    }

    public static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int zza(List list) {
        int iZzu;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zztq) {
            zztq zztqVar = (zztq) list;
            iZzu = 0;
            while (i10 < size) {
                iZzu += zztc.zzu(zztqVar.zzd(i10));
                i10++;
            }
        } else {
            iZzu = 0;
            while (i10 < size) {
                iZzu += zztc.zzu(((Integer) list.get(i10)).intValue());
                i10++;
            }
        }
        return iZzu;
    }

    public static int zzb(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zztc.zzx(i10 << 3) + 4) * size;
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zztc.zzx(i10 << 3) + 8) * size;
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int iZzu;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zztq) {
            zztq zztqVar = (zztq) list;
            iZzu = 0;
            while (i10 < size) {
                iZzu += zztc.zzu(zztqVar.zzd(i10));
                i10++;
            }
        } else {
            iZzu = 0;
            while (i10 < size) {
                iZzu += zztc.zzu(((Integer) list.get(i10)).intValue());
                i10++;
            }
        }
        return iZzu;
    }

    public static int zzg(List list) {
        int iZzy;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzum) {
            zzum zzumVar = (zzum) list;
            iZzy = 0;
            while (i10 < size) {
                iZzy += zztc.zzy(zzumVar.zzd(i10));
                i10++;
            }
        } else {
            iZzy = 0;
            while (i10 < size) {
                iZzy += zztc.zzy(((Long) list.get(i10)).longValue());
                i10++;
            }
        }
        return iZzy;
    }

    public static int zzh(int i10, Object obj, zzvi zzviVar) {
        int i11 = i10 << 3;
        if (!(obj instanceof zzud)) {
            return zztc.zzx(i11) + zztc.zzv((zzux) obj, zzviVar);
        }
        int i12 = zztc.zzb;
        int iZza = ((zzud) obj).zza();
        return zztc.zzx(i11) + zztc.zzx(iZza) + iZza;
    }

    public static int zzi(List list) {
        int iZzx;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zztq) {
            zztq zztqVar = (zztq) list;
            iZzx = 0;
            while (i10 < size) {
                int iZzd = zztqVar.zzd(i10);
                iZzx += zztc.zzx((iZzd >> 31) ^ (iZzd + iZzd));
                i10++;
            }
        } else {
            iZzx = 0;
            while (i10 < size) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                iZzx += zztc.zzx((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i10++;
            }
        }
        return iZzx;
    }

    public static int zzj(List list) {
        int iZzy;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzum) {
            zzum zzumVar = (zzum) list;
            iZzy = 0;
            while (i10 < size) {
                long jZzd = zzumVar.zzd(i10);
                iZzy += zztc.zzy((jZzd >> 63) ^ (jZzd + jZzd));
                i10++;
            }
        } else {
            iZzy = 0;
            while (i10 < size) {
                long jLongValue = ((Long) list.get(i10)).longValue();
                iZzy += zztc.zzy((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i10++;
            }
        }
        return iZzy;
    }

    public static int zzk(List list) {
        int iZzx;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zztq) {
            zztq zztqVar = (zztq) list;
            iZzx = 0;
            while (i10 < size) {
                iZzx += zztc.zzx(zztqVar.zzd(i10));
                i10++;
            }
        } else {
            iZzx = 0;
            while (i10 < size) {
                iZzx += zztc.zzx(((Integer) list.get(i10)).intValue());
                i10++;
            }
        }
        return iZzx;
    }

    public static int zzl(List list) {
        int iZzy;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzum) {
            zzum zzumVar = (zzum) list;
            iZzy = 0;
            while (i10 < size) {
                iZzy += zztc.zzy(zzumVar.zzd(i10));
                i10++;
            }
        } else {
            iZzy = 0;
            while (i10 < size) {
                iZzy += zztc.zzy(((Long) list.get(i10)).longValue());
                i10++;
            }
        }
        return iZzy;
    }

    public static zzvz zzm() {
        return zzc;
    }

    public static zzvz zzn() {
        return zzd;
    }

    public static void zzo(zzvz zzvzVar, Object obj, Object obj2) {
        zzvzVar.zzf(obj, zzvzVar.zzd(zzvzVar.zzc(obj), zzvzVar.zzc(obj2)));
    }

    public static void zzp(Class cls) {
        Class cls2;
        if (!zztp.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzq(int i10, List list, zzwq zzwqVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzwqVar.zzc(i10, list, z10);
    }

    public static void zzr(int i10, List list, zzwq zzwqVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzwqVar.zzg(i10, list, z10);
    }

    public static void zzs(int i10, List list, zzwq zzwqVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzwqVar.zzi(i10, list, z10);
    }

    public static void zzt(int i10, List list, zzwq zzwqVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzwqVar.zzk(i10, list, z10);
    }

    public static void zzu(int i10, List list, zzwq zzwqVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzwqVar.zzm(i10, list, z10);
    }

    public static void zzv(int i10, List list, zzwq zzwqVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzwqVar.zzo(i10, list, z10);
    }

    public static void zzw(int i10, List list, zzwq zzwqVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzwqVar.zzr(i10, list, z10);
    }

    public static void zzx(int i10, List list, zzwq zzwqVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzwqVar.zzt(i10, list, z10);
    }

    public static void zzy(int i10, List list, zzwq zzwqVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzwqVar.zzw(i10, list, z10);
    }

    public static void zzz(int i10, List list, zzwq zzwqVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzwqVar.zzy(i10, list, z10);
    }
}
