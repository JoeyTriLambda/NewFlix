package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
abstract class zzmt<T, B> {
    public abstract int zza(T t10);

    public abstract B zza();

    public abstract T zza(T t10, T t11);

    public abstract void zza(B b10, int i10, int i11);

    public abstract void zza(B b10, int i10, long j10);

    public abstract void zza(B b10, int i10, zzij zzijVar);

    public abstract void zza(B b10, int i10, T t10);

    public abstract void zza(T t10, zznt zzntVar) throws IOException;

    public abstract boolean zza(zzlv zzlvVar);

    public final boolean zza(B b10, zzlv zzlvVar) throws IOException {
        int iZzd = zzlvVar.zzd();
        int i10 = iZzd >>> 3;
        int i11 = iZzd & 7;
        if (i11 == 0) {
            zzb(b10, i10, zzlvVar.zzl());
            return true;
        }
        if (i11 == 1) {
            zza((zzmt<T, B>) b10, i10, zzlvVar.zzk());
            return true;
        }
        if (i11 == 2) {
            zza((zzmt<T, B>) b10, i10, zzlvVar.zzp());
            return true;
        }
        if (i11 != 3) {
            if (i11 == 4) {
                return false;
            }
            if (i11 != 5) {
                throw zzkb.zza();
            }
            zza((zzmt<T, B>) b10, i10, zzlvVar.zzf());
            return true;
        }
        B bZza = zza();
        int i12 = 4 | (i10 << 3);
        while (zzlvVar.zzc() != Integer.MAX_VALUE && zza((zzmt<T, B>) bZza, zzlvVar)) {
        }
        if (i12 != zzlvVar.zzd()) {
            throw zzkb.zzb();
        }
        zza((zzmt<T, B>) b10, i10, (int) zze(bZza));
        return true;
    }

    public abstract int zzb(T t10);

    public abstract void zzb(B b10, int i10, long j10);

    public abstract void zzb(T t10, zznt zzntVar) throws IOException;

    public abstract void zzb(Object obj, B b10);

    public abstract B zzc(Object obj);

    public abstract void zzc(Object obj, T t10);

    public abstract T zzd(Object obj);

    public abstract T zze(B b10);

    public abstract void zzf(Object obj);
}
