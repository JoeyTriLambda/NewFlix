package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
public abstract class zziu {
    private static volatile int zzd = 100;
    int zza;
    int zzb;
    zziy zzc;
    private int zze;
    private boolean zzf;

    public static int zza(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public abstract double zza() throws IOException;

    public abstract float zzb() throws IOException;

    public abstract int zzb(int i10) throws zzkb;

    public abstract int zzc();

    public abstract void zzc(int i10) throws zzkb;

    public abstract int zzd() throws IOException;

    public abstract void zzd(int i10);

    public abstract int zze() throws IOException;

    public abstract boolean zze(int i10) throws IOException;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract long zzk() throws IOException;

    public abstract long zzl() throws IOException;

    public abstract long zzm() throws IOException;

    public abstract long zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract zzij zzq() throws IOException;

    public abstract String zzr() throws IOException;

    public abstract String zzs() throws IOException;

    public abstract boolean zzt() throws IOException;

    public abstract boolean zzu() throws IOException;

    private zziu() {
        this.zzb = zzd;
        this.zze = Integer.MAX_VALUE;
        this.zzf = false;
    }

    public static long zza(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static zziu zza(byte[] bArr, int i10, int i11, boolean z10) {
        zzix zzixVar = new zzix(bArr, i11);
        try {
            zzixVar.zzb(i11);
            return zzixVar;
        } catch (zzkb e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}
