package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import b8.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzho {
    final String zza;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final b<Context, Boolean> zzh;
    private final boolean zzi;

    public zzho(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    public final zzho zza() {
        return new zzho(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, true, this.zzg, this.zzh);
    }

    public final zzho zzb() {
        if (!this.zzc.isEmpty()) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        b<Context, Boolean> bVar = this.zzh;
        if (bVar == null) {
            return new zzho(this.zza, this.zzb, this.zzc, this.zzd, true, this.zzf, this.zzi, this.zzg, bVar);
        }
        throw new IllegalStateException("Cannot skip gservices both always and conditionally");
    }

    private zzho(String str, Uri uri, String str2, String str3, boolean z10, boolean z11, boolean z12, boolean z13, b<Context, Boolean> bVar) {
        this.zza = str;
        this.zzb = uri;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z10;
        this.zzf = z11;
        this.zzi = z12;
        this.zzg = z13;
        this.zzh = bVar;
    }

    public final zzhg<Double> zza(String str, double d10) {
        return zzhg.zza(this, str, Double.valueOf(-3.0d), true);
    }

    public final zzhg<Long> zza(String str, long j10) {
        return zzhg.zza(this, str, Long.valueOf(j10), true);
    }

    public final zzhg<String> zza(String str, String str2) {
        return zzhg.zza(this, str, str2, true);
    }

    public final zzhg<Boolean> zza(String str, boolean z10) {
        return zzhg.zza(this, str, Boolean.valueOf(z10), true);
    }
}
