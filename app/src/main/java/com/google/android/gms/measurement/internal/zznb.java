package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zznb extends zzmz {
    public zznb(zznd zzndVar) {
        super(zzndVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Uri.Builder a(String str) {
        zzgy zzgyVarZzm = zzm();
        zzgyVarZzm.zzt();
        zzgyVarZzm.p(str);
        String str2 = (String) zzgyVarZzm.f8054l.get(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(zze().zzd(str, zzbh.Y));
        if (TextUtils.isEmpty(str2)) {
            builder.authority(zze().zzd(str, zzbh.Z));
        } else {
            builder.authority(str2 + "." + zze().zzd(str, zzbh.Z));
        }
        builder.path(zze().zzd(str, zzbh.f7726a0));
        return builder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String b(String str) {
        zzgy zzgyVarZzm = zzm();
        zzgyVarZzm.zzt();
        zzgyVarZzm.p(str);
        String str2 = (String) zzgyVarZzm.f8054l.get(str);
        if (TextUtils.isEmpty(str2)) {
            return zzbh.f7761r.zza(null);
        }
        Uri uri = Uri.parse(zzbh.f7761r.zza(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.authority(str2 + "." + uri.getAuthority());
        return builderBuildUpon.build().toString();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zznm g_() {
        return super.g_();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<com.google.android.gms.measurement.internal.zzna, java.lang.Boolean> zzb(java.lang.String r7) throws java.lang.IllegalStateException {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznb.zzb(java.lang.String):android.util.Pair");
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzan zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzgy zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzmd zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }
}
