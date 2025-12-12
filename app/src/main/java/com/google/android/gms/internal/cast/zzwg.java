package com.google.android.gms.internal.cast;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzwg extends zzwi {
    public zzwg(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.cast.zzwi
    public final double zza(Object obj, long j10) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j10));
    }

    @Override // com.google.android.gms.internal.cast.zzwi
    public final float zzb(Object obj, long j10) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j10));
    }

    @Override // com.google.android.gms.internal.cast.zzwi
    public final void zzc(Object obj, long j10, boolean z10) {
        if (zzwj.zzb) {
            zzwj.zzD(obj, j10, z10 ? (byte) 1 : (byte) 0);
        } else {
            zzwj.zzE(obj, j10, z10 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzwi
    public final void zzd(Object obj, long j10, byte b10) {
        if (zzwj.zzb) {
            zzwj.zzD(obj, j10, b10);
        } else {
            zzwj.zzE(obj, j10, b10);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzwi
    public final void zze(Object obj, long j10, double d10) {
        this.zza.putLong(obj, j10, Double.doubleToLongBits(d10));
    }

    @Override // com.google.android.gms.internal.cast.zzwi
    public final void zzf(Object obj, long j10, float f10) {
        this.zza.putInt(obj, j10, Float.floatToIntBits(f10));
    }

    @Override // com.google.android.gms.internal.cast.zzwi
    public final boolean zzg(Object obj, long j10) {
        return zzwj.zzb ? zzwj.zzt(obj, j10) : zzwj.zzu(obj, j10);
    }
}
