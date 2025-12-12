package com.google.android.gms.internal.cast;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzwa {
    private static final zzwa zza = new zzwa(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzwa(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.zze = -1;
        this.zzb = 0;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z10;
    }

    public static zzwa zzc() {
        return zza;
    }

    public static zzwa zze(zzwa zzwaVar, zzwa zzwaVar2) {
        int i10 = zzwaVar.zzb;
        int i11 = zzwaVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzwaVar.zzc, 0);
        System.arraycopy(zzwaVar2.zzc, 0, iArrCopyOf, 0, 0);
        Object[] objArrCopyOf = Arrays.copyOf(zzwaVar.zzd, 0);
        System.arraycopy(zzwaVar2.zzd, 0, objArrCopyOf, 0, 0);
        return new zzwa(0, iArrCopyOf, objArrCopyOf, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzwa)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 506991;
    }

    public final int zza() {
        int i10 = this.zze;
        if (i10 != -1) {
            return i10;
        }
        this.zze = 0;
        return 0;
    }

    public final int zzb() {
        int i10 = this.zze;
        if (i10 != -1) {
            return i10;
        }
        this.zze = 0;
        return 0;
    }

    public final zzwa zzd(zzwa zzwaVar) {
        if (zzwaVar.equals(zza)) {
            return this;
        }
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
        int[] iArr = this.zzc;
        int length = iArr.length;
        System.arraycopy(zzwaVar.zzc, 0, iArr, 0, 0);
        System.arraycopy(zzwaVar.zzd, 0, this.zzd, 0, 0);
        this.zzb = 0;
        return this;
    }

    public final void zzf() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    private zzwa() {
        this(0, new int[8], new Object[8], true);
    }

    public final void zzg(StringBuilder sb2, int i10) {
    }
}
