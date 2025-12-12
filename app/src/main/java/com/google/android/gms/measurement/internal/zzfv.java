package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.internal.zziq;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzfv extends zzg {

    /* renamed from: c, reason: collision with root package name */
    public String f7929c;

    /* renamed from: d, reason: collision with root package name */
    public String f7930d;

    /* renamed from: e, reason: collision with root package name */
    public int f7931e;

    /* renamed from: f, reason: collision with root package name */
    public String f7932f;

    /* renamed from: g, reason: collision with root package name */
    public long f7933g;

    /* renamed from: h, reason: collision with root package name */
    public final long f7934h;

    /* renamed from: i, reason: collision with root package name */
    public List<String> f7935i;

    /* renamed from: j, reason: collision with root package name */
    public String f7936j;

    /* renamed from: k, reason: collision with root package name */
    public int f7937k;

    /* renamed from: l, reason: collision with root package name */
    public String f7938l;

    /* renamed from: m, reason: collision with root package name */
    public String f7939m;

    /* renamed from: n, reason: collision with root package name */
    public String f7940n;

    /* renamed from: o, reason: collision with root package name */
    public long f7941o;

    /* renamed from: p, reason: collision with root package name */
    public String f7942p;

    public zzfv(zzho zzhoVar, long j10) {
        super(zzhoVar);
        this.f7941o = 0L;
        this.f7942p = null;
        this.f7934h = j10;
    }

    public final String a() {
        zzu();
        Preconditions.checkNotNull(this.f7929c);
        return this.f7929c;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public final String zzae() {
        zzt();
        zzu();
        Preconditions.checkNotNull(this.f7938l);
        return this.f7938l;
    }

    public final void zzag() {
        String str;
        zzt();
        if (zzk().e().zza(zziq.zza.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            zzq().T().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            zzj().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        }
        zzgd zzgdVarZzc = zzj().zzc();
        Object[] objArr = new Object[1];
        objArr[0] = str == null ? "null" : "not null";
        zzgdVarZzc.zza(String.format("Resetting session stitching token to %s", objArr));
        this.f7940n = str;
        this.f7941o = zzb().currentTimeMillis();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
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

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0189 A[Catch: IllegalStateException -> 0x01bd, TryCatch #4 {IllegalStateException -> 0x01bd, blocks: (B:49:0x0166, B:53:0x0181, B:55:0x0189, B:57:0x01a0, B:59:0x01b4, B:61:0x01b9, B:60:0x01b7), top: B:107:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a0 A[Catch: IllegalStateException -> 0x01bd, TryCatch #4 {IllegalStateException -> 0x01bd, blocks: (B:49:0x0166, B:53:0x0181, B:55:0x0189, B:57:0x01a0, B:59:0x01b4, B:61:0x01b9, B:60:0x01b7), top: B:107:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0270  */
    @Override // com.google.android.gms.measurement.internal.zzg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzx() throws java.lang.IllegalStateException, android.content.res.Resources.NotFoundException, android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 650
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfv.zzx():void");
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zzz() {
        return true;
    }
}
