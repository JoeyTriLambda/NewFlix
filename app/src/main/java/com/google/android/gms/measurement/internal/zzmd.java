package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzmd extends zzmy {

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f8476d;

    /* renamed from: e, reason: collision with root package name */
    public final zzgr f8477e;

    /* renamed from: f, reason: collision with root package name */
    public final zzgr f8478f;

    /* renamed from: g, reason: collision with root package name */
    public final zzgr f8479g;

    /* renamed from: h, reason: collision with root package name */
    public final zzgr f8480h;

    /* renamed from: i, reason: collision with root package name */
    public final zzgr f8481i;

    public zzmd(zznd zzndVar) {
        super(zzndVar);
        this.f8476d = new HashMap();
        zzgm zzgmVarZzk = zzk();
        Objects.requireNonNull(zzgmVarZzk);
        this.f8477e = new zzgr(zzgmVarZzk, "last_delete_stale", 0L);
        zzgm zzgmVarZzk2 = zzk();
        Objects.requireNonNull(zzgmVarZzk2);
        this.f8478f = new zzgr(zzgmVarZzk2, "backoff", 0L);
        zzgm zzgmVarZzk3 = zzk();
        Objects.requireNonNull(zzgmVarZzk3);
        this.f8479g = new zzgr(zzgmVarZzk3, "last_upload", 0L);
        zzgm zzgmVarZzk4 = zzk();
        Objects.requireNonNull(zzgmVarZzk4);
        this.f8480h = new zzgr(zzgmVarZzk4, "last_upload_attempt", 0L);
        zzgm zzgmVarZzk5 = zzk();
        Objects.requireNonNull(zzgmVarZzk5);
        this.f8481i = new zzgr(zzgmVarZzk5, "midnight_offset", 0L);
    }

    @Deprecated
    public final Pair<String, Boolean> a(String str) throws IllegalStateException {
        zzmc zzmcVar;
        AdvertisingIdClient.Info advertisingIdInfo;
        zzt();
        long jElapsedRealtime = zzb().elapsedRealtime();
        HashMap map = this.f8476d;
        zzmc zzmcVar2 = (zzmc) map.get(str);
        if (zzmcVar2 != null && jElapsedRealtime < zzmcVar2.f8475c) {
            return new Pair<>(zzmcVar2.f8473a, Boolean.valueOf(zzmcVar2.f8474b));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        zzae zzaeVarZze = zze();
        zzaeVarZze.getClass();
        long jZzc = zzaeVarZze.zzc(str, zzbh.f7728b) + jElapsedRealtime;
        try {
            long jZzc2 = zze().zzc(str, zzbh.f7731c);
            if (jZzc2 > 0) {
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza());
                } catch (PackageManager.NameNotFoundException unused) {
                    if (zzmcVar2 != null && jElapsedRealtime < zzmcVar2.f8475c + jZzc2) {
                        return new Pair<>(zzmcVar2.f8473a, Boolean.valueOf(zzmcVar2.f8474b));
                    }
                    advertisingIdInfo = null;
                }
            } else {
                advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza());
            }
        } catch (Exception e10) {
            zzj().zzc().zza("Unable to get advertising id", e10);
            zzmcVar = new zzmc(jZzc, "", false);
        }
        if (advertisingIdInfo == null) {
            return new Pair<>("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String id2 = advertisingIdInfo.getId();
        zzmcVar = id2 != null ? new zzmc(jZzc, id2, advertisingIdInfo.isLimitAdTrackingEnabled()) : new zzmc(jZzc, "", advertisingIdInfo.isLimitAdTrackingEnabled());
        map.put(str, zzmcVar);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(zzmcVar.f8473a, Boolean.valueOf(zzmcVar.f8474b));
    }

    @Deprecated
    public final String b(String str, boolean z10) throws NoSuchAlgorithmException {
        zzt();
        String str2 = z10 ? (String) a(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestS = zznt.S();
        if (messageDigestS == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestS.digest(str2.getBytes())));
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zznm g_() {
        return super.g_();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final boolean zzc() {
        return false;
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
}
