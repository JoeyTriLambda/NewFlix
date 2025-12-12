package com.google.android.gms.measurement.internal;

import ac.c;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import b0.b;
import b0.i;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.measurement.internal.zziq;
import com.unity3d.services.core.request.metrics.MetricCommonTags;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzgy extends zzmy implements zzag {

    /* renamed from: d, reason: collision with root package name */
    public final b f8046d;

    /* renamed from: e, reason: collision with root package name */
    public final b f8047e;

    /* renamed from: f, reason: collision with root package name */
    public final b f8048f;

    /* renamed from: g, reason: collision with root package name */
    public final b f8049g;

    /* renamed from: h, reason: collision with root package name */
    public final b f8050h;

    /* renamed from: i, reason: collision with root package name */
    public final b f8051i;

    /* renamed from: j, reason: collision with root package name */
    public final i<String, com.google.android.gms.internal.measurement.zzb> f8052j;

    /* renamed from: k, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.zzv f8053k;

    /* renamed from: l, reason: collision with root package name */
    public final b f8054l;

    /* renamed from: m, reason: collision with root package name */
    public final b f8055m;

    /* renamed from: n, reason: collision with root package name */
    public final b f8056n;

    public zzgy(zznd zzndVar) {
        super(zzndVar);
        this.f8046d = new b();
        this.f8047e = new b();
        this.f8048f = new b();
        this.f8049g = new b();
        this.f8050h = new b();
        this.f8054l = new b();
        this.f8055m = new b();
        this.f8056n = new b();
        this.f8051i = new b();
        this.f8052j = new zzhe(this);
        this.f8053k = new zzhd(this);
    }

    public static b a(zzfn.zzd zzdVar) {
        b bVar = new b();
        if (zzdVar != null) {
            for (zzfn.zzg zzgVar : zzdVar.zzn()) {
                bVar.put(zzgVar.zzb(), zzgVar.zzc());
            }
        }
        return bVar;
    }

    public static zziq.zza d(zzfn.zza.zze zzeVar) {
        int i10 = zzhf.f8069b[zzeVar.ordinal()];
        if (i10 == 1) {
            return zziq.zza.AD_STORAGE;
        }
        if (i10 == 2) {
            return zziq.zza.ANALYTICS_STORAGE;
        }
        if (i10 == 3) {
            return zziq.zza.AD_USER_DATA;
        }
        if (i10 != 4) {
            return null;
        }
        return zziq.zza.AD_PERSONALIZATION;
    }

    public final zzfn.zzd b(String str, byte[] bArr) throws IllegalStateException {
        if (bArr == null) {
            return zzfn.zzd.zzg();
        }
        try {
            zzfn.zzd zzdVar = (zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) ((zzfn.zzd.zza) zznm.g(zzfn.zzd.zze(), bArr)).zzah());
            zzj().zzp().zza("Parsed config. version, gmp_app_id", zzdVar.zzs() ? Long.valueOf(zzdVar.zzc()) : null, zzdVar.zzq() ? zzdVar.zzi() : null);
            return zzdVar;
        } catch (com.google.android.gms.internal.measurement.zzkb e10) {
            zzj().zzu().zza("Unable to merge remote config. appId", zzgb.zza(str), e10);
            return zzfn.zzd.zzg();
        } catch (RuntimeException e11) {
            zzj().zzu().zza("Unable to merge remote config. appId", zzgb.zza(str), e11);
            return zzfn.zzd.zzg();
        }
    }

    public final zzip c(String str, zziq.zza zzaVar) {
        zzt();
        p(str);
        zzfn.zza zzaVarH = h(str);
        zzip zzipVar = zzip.UNINITIALIZED;
        if (zzaVarH == null) {
            return zzipVar;
        }
        for (zzfn.zza.zzb zzbVar : zzaVarH.zzf()) {
            if (d(zzbVar.zzc()) == zzaVar) {
                int i10 = zzhf.f8070c[zzbVar.zzb().ordinal()];
                return i10 != 1 ? i10 != 2 ? zzipVar : zzip.GRANTED : zzip.DENIED;
            }
        }
        return zzipVar;
    }

    public final void e(String str, zzfn.zzd.zza zzaVar) throws IllegalStateException {
        HashSet hashSet = new HashSet();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        if (zzaVar != null) {
            Iterator<zzfn.zzb> it = zzaVar.zze().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().zzb());
            }
            for (int i10 = 0; i10 < zzaVar.zza(); i10++) {
                zzfn.zzc.zza zzaVarZzby = zzaVar.zza(i10).zzby();
                if (zzaVarZzby.zzb().isEmpty()) {
                    zzj().zzu().zza("EventConfig contained null event name");
                } else {
                    String strZzb = zzaVarZzby.zzb();
                    String strZzb2 = zzit.zzb(zzaVarZzby.zzb());
                    if (!TextUtils.isEmpty(strZzb2)) {
                        zzaVarZzby = zzaVarZzby.zza(strZzb2);
                        zzaVar.zza(i10, zzaVarZzby);
                    }
                    if (zzaVarZzby.zze() && zzaVarZzby.zzc()) {
                        bVar.put(strZzb, Boolean.TRUE);
                    }
                    if (zzaVarZzby.zzf() && zzaVarZzby.zzd()) {
                        bVar2.put(zzaVarZzby.zzb(), Boolean.TRUE);
                    }
                    if (zzaVarZzby.zzg()) {
                        if (zzaVarZzby.zza() < 2 || zzaVarZzby.zza() > 65535) {
                            zzj().zzu().zza("Invalid sampling rate. Event name, sample rate", zzaVarZzby.zzb(), Integer.valueOf(zzaVarZzby.zza()));
                        } else {
                            bVar3.put(zzaVarZzby.zzb(), Integer.valueOf(zzaVarZzby.zza()));
                        }
                    }
                }
            }
        }
        this.f8047e.put(str, hashSet);
        this.f8048f.put(str, bVar);
        this.f8049g.put(str, bVar2);
        this.f8051i.put(str, bVar3);
    }

    public final void f(final String str, zzfn.zzd zzdVar) {
        int iZza = zzdVar.zza();
        i<String, com.google.android.gms.internal.measurement.zzb> iVar = this.f8052j;
        if (iZza == 0) {
            iVar.remove(str);
            return;
        }
        zzj().zzp().zza("EES programs found", Integer.valueOf(zzdVar.zza()));
        zzgb.zzc zzcVar = zzdVar.zzm().get(0);
        try {
            com.google.android.gms.internal.measurement.zzb zzbVar = new com.google.android.gms.internal.measurement.zzb();
            zzbVar.zza("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzgz
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzm("internal.remoteConfig", new zzhg(this.f8057b, str));
                }
            });
            zzbVar.zza("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhc
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    final zzgy zzgyVar = this.f8064b;
                    final String str2 = str;
                    return new com.google.android.gms.internal.measurement.zzx("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzha
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            zzan zzanVarZzh = zzgyVar.zzh();
                            String str3 = str2;
                            zzf zzfVarZze = zzanVarZzh.zze(str3);
                            HashMap mapX = c.x("platform", MetricCommonTags.METRIC_COMMON_TAG_PLATFORM_ANDROID, "package_name", str3);
                            mapX.put("gmp_version", 87000L);
                            if (zzfVarZze != null) {
                                String strZzad = zzfVarZze.zzad();
                                if (strZzad != null) {
                                    mapX.put("app_version", strZzad);
                                }
                                mapX.put("app_version_int", Long.valueOf(zzfVarZze.zze()));
                                mapX.put("dynamite_version", Long.valueOf(zzfVarZze.zzo()));
                            }
                            return mapX;
                        }
                    });
                }
            });
            zzbVar.zza("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhb
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzr(this.f8063b.f8053k);
                }
            });
            zzbVar.zza(zzcVar);
            iVar.put(str, zzbVar);
            zzj().zzp().zza("EES program loaded for appId, activities", str, Integer.valueOf(zzcVar.zza().zza()));
            Iterator<zzgb.zzb> it = zzcVar.zza().zzd().iterator();
            while (it.hasNext()) {
                zzj().zzp().zza("EES program activity", it.next().zzb());
            }
        } catch (com.google.android.gms.internal.measurement.zzc unused) {
            zzj().zzg().zza("Failed to load EES program. appId", str);
        }
    }

    public final int g(String str, String str2) {
        Integer num;
        zzt();
        p(str);
        Map map = (Map) this.f8051i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zznm g_() {
        return super.g_();
    }

    public final zzfn.zza h(String str) {
        zzt();
        p(str);
        zzfn.zzd zzdVarZzc = zzc(str);
        if (zzdVarZzc == null || !zzdVarZzc.zzp()) {
            return null;
        }
        return zzdVarZzc.zzd();
    }

    public final zziq.zza i(String str) {
        zziq.zza zzaVar = zziq.zza.AD_USER_DATA;
        zzt();
        p(str);
        zzfn.zza zzaVarH = h(str);
        if (zzaVarH == null) {
            return null;
        }
        for (zzfn.zza.zzc zzcVar : zzaVarH.zze()) {
            if (zzaVar == d(zzcVar.zzc())) {
                return d(zzcVar.zzb());
            }
        }
        return null;
    }

    public final boolean j(String str, zziq.zza zzaVar) {
        zzt();
        p(str);
        zzfn.zza zzaVarH = h(str);
        if (zzaVarH == null) {
            return false;
        }
        Iterator<zzfn.zza.zzb> it = zzaVarH.zzd().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzfn.zza.zzb next = it.next();
            if (zzaVar == d(next.zzc())) {
                if (next.zzb() == zzfn.zza.zzd.GRANTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean k(String str, String str2) {
        Boolean bool;
        zzt();
        p(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f8049g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean l(String str, String str2) {
        Boolean bool;
        zzt();
        p(str);
        if ("1".equals(zza(str, "measurement.upload.blacklist_internal")) && zznt.N(str2)) {
            return true;
        }
        if ("1".equals(zza(str, "measurement.upload.blacklist_public")) && zznt.O(str2)) {
            return true;
        }
        Map map = (Map) this.f8048f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean m(String str) {
        zzt();
        p(str);
        zzfn.zza zzaVarH = h(str);
        return zzaVarH == null || !zzaVarH.zzh() || zzaVarH.zzg();
    }

    public final boolean n(String str) {
        zzt();
        p(str);
        b bVar = this.f8047e;
        return bVar.get(str) != 0 && ((Set) bVar.get(str)).contains("app_instance_id");
    }

    public final boolean o(String str) {
        zzt();
        p(str);
        b bVar = this.f8047e;
        if (bVar.get(str) != 0) {
            return ((Set) bVar.get(str)).contains("os_version") || ((Set) bVar.get(str)).contains("device_info");
        }
        return false;
    }

    public final void p(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        b bVar = this.f8050h;
        if (bVar.get(str) == 0) {
            zzap zzapVarZzf = zzh().zzf(str);
            b bVar2 = this.f8056n;
            b bVar3 = this.f8055m;
            b bVar4 = this.f8054l;
            b bVar5 = this.f8046d;
            if (zzapVarZzf != null) {
                zzfn.zzd.zza zzaVarZzby = b(str, zzapVarZzf.f7676a).zzby();
                e(str, zzaVarZzby);
                bVar5.put(str, a((zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah())));
                bVar.put(str, (zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah()));
                f(str, (zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah()));
                bVar4.put(str, zzaVarZzby.zzc());
                bVar3.put(str, zzapVarZzf.f7677b);
                bVar2.put(str, zzapVarZzf.f7678c);
                return;
            }
            bVar5.put(str, null);
            this.f8048f.put(str, null);
            this.f8047e.put(str, null);
            this.f8049g.put(str, null);
            bVar.put(str, null);
            bVar4.put(str, null);
            bVar3.put(str, null);
            bVar2.put(str, null);
            this.f8051i.put(str, null);
        }
    }

    public final long zza(String str) throws IllegalStateException {
        String strZza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strZza)) {
            return 0L;
        }
        try {
            return Long.parseLong(strZza);
        } catch (NumberFormatException e10) {
            zzj().zzu().zza("Unable to parse timezone offset. appId", zzgb.zza(str), e10);
            return 0L;
        }
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

    /* JADX WARN: Multi-variable type inference failed */
    public final zzfn.zzd zzc(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        p(str);
        return (zzfn.zzd) this.f8050h.get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String zzd(String str) {
        zzt();
        return (String) this.f8056n.get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String zze(String str) {
        zzt();
        return (String) this.f8055m.get(str);
    }

    public final void zzi(String str) {
        zzt();
        this.f8055m.put(str, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zzl(String str) {
        zzfn.zzd zzdVar;
        return (TextUtils.isEmpty(str) || (zzdVar = (zzfn.zzd) this.f8050h.get(str)) == null || zzdVar.zza() == 0) ? false : true;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzag
    public final String zza(String str, String str2) {
        zzt();
        p(str);
        Map map = (Map) this.f8046d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final boolean zza(String str, byte[] bArr, String str2, String str3) throws IllegalStateException {
        byte[] bArrZzbv;
        boolean z10;
        boolean z11;
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        zzfn.zzd.zza zzaVarZzby = b(str, bArr).zzby();
        int i10 = 0;
        if (zzaVarZzby == null) {
            return false;
        }
        e(str, zzaVarZzby);
        f(str, (zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah()));
        zzfn.zzd zzdVar = (zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah());
        b bVar = this.f8050h;
        bVar.put(str, zzdVar);
        this.f8054l.put(str, zzaVarZzby.zzc());
        this.f8055m.put(str, str2);
        this.f8056n.put(str, str3);
        this.f8046d.put(str, a((zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah())));
        zzan zzanVarZzh = zzh();
        ArrayList arrayList = new ArrayList(zzaVarZzby.zzd());
        zzanVarZzh.getClass();
        Preconditions.checkNotNull(arrayList);
        int i11 = 0;
        while (i11 < arrayList.size()) {
            zzfh.zza.C0075zza c0075zzaZzby = ((zzfh.zza) arrayList.get(i11)).zzby();
            if (c0075zzaZzby.zza() != 0) {
                while (i10 < c0075zzaZzby.zza()) {
                    zzfh.zzb.zza zzaVarZzby2 = c0075zzaZzby.zza(i10).zzby();
                    zzfh.zzb.zza zzaVar = (zzfh.zzb.zza) ((zzjt.zza) zzaVarZzby2.clone());
                    b bVar2 = bVar;
                    String strZzb = zzit.zzb(zzaVarZzby2.zzb());
                    if (strZzb != null) {
                        zzaVar.zza(strZzb);
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    boolean z12 = z11;
                    int i12 = 0;
                    while (i12 < zzaVarZzby2.zza()) {
                        zzfh.zzc zzcVarZza = zzaVarZzby2.zza(i12);
                        zzfh.zzb.zza zzaVar2 = zzaVarZzby2;
                        String strZza = zzis.zza(zzcVarZza.zze());
                        if (strZza != null) {
                            zzaVar.zza(i12, (zzfh.zzc) ((com.google.android.gms.internal.measurement.zzjt) zzcVarZza.zzby().zza(strZza).zzah()));
                            z12 = true;
                        }
                        i12++;
                        zzaVarZzby2 = zzaVar2;
                    }
                    if (z12) {
                        c0075zzaZzby = c0075zzaZzby.zza(i10, zzaVar);
                        arrayList.set(i11, (zzfh.zza) ((com.google.android.gms.internal.measurement.zzjt) c0075zzaZzby.zzah()));
                    }
                    i10++;
                    bVar = bVar2;
                }
            }
            b bVar3 = bVar;
            if (c0075zzaZzby.zzb() != 0) {
                for (int i13 = 0; i13 < c0075zzaZzby.zzb(); i13++) {
                    zzfh.zze zzeVarZzb = c0075zzaZzby.zzb(i13);
                    String strZza2 = zziv.zza(zzeVarZzb.zze());
                    if (strZza2 != null) {
                        zzfh.zza.C0075zza c0075zzaZza = c0075zzaZzby.zza(i13, zzeVarZzb.zzby().zza(strZza2));
                        arrayList.set(i11, (zzfh.zza) ((com.google.android.gms.internal.measurement.zzjt) c0075zzaZza.zzah()));
                        c0075zzaZzby = c0075zzaZza;
                    }
                }
            }
            i11++;
            bVar = bVar3;
            i10 = 0;
        }
        b bVar4 = bVar;
        zzanVarZzh.zzak();
        zzanVarZzh.zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(arrayList);
        SQLiteDatabase sQLiteDatabaseA = zzanVarZzh.a();
        sQLiteDatabaseA.beginTransaction();
        try {
            zzanVarZzh.zzak();
            zzanVarZzh.zzt();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase sQLiteDatabaseA2 = zzanVarZzh.a();
            sQLiteDatabaseA2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseA2.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                zzfh.zza zzaVar3 = (zzfh.zza) it.next();
                zzanVarZzh.zzak();
                zzanVarZzh.zzt();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzaVar3);
                if (!zzaVar3.zzg()) {
                    zzanVarZzh.zzj().zzu().zza("Audience with no ID. appId", zzgb.zza(str));
                } else {
                    int iZza = zzaVar3.zza();
                    Iterator<zzfh.zzb> it2 = zzaVar3.zze().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!it2.next().zzl()) {
                                zzanVarZzh.zzj().zzu().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzgb.zza(str), Integer.valueOf(iZza));
                                break;
                            }
                        } else {
                            Iterator<zzfh.zze> it3 = zzaVar3.zzf().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    if (!it3.next().zzi()) {
                                        zzanVarZzh.zzj().zzu().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzgb.zza(str), Integer.valueOf(iZza));
                                        break;
                                    }
                                } else {
                                    Iterator<zzfh.zzb> it4 = zzaVar3.zze().iterator();
                                    while (true) {
                                        if (!it4.hasNext()) {
                                            z10 = true;
                                            break;
                                        }
                                        if (!zzanVarZzh.h(str, iZza, it4.next())) {
                                            z10 = false;
                                            break;
                                        }
                                    }
                                    if (z10) {
                                        Iterator<zzfh.zze> it5 = zzaVar3.zzf().iterator();
                                        while (true) {
                                            if (!it5.hasNext()) {
                                                break;
                                            }
                                            if (!zzanVarZzh.i(str, iZza, it5.next())) {
                                                z10 = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (!z10) {
                                        zzanVarZzh.zzak();
                                        zzanVarZzh.zzt();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase sQLiteDatabaseA3 = zzanVarZzh.a();
                                        sQLiteDatabaseA3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZza)});
                                        sQLiteDatabaseA3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZza)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it6 = arrayList.iterator();
            while (it6.hasNext()) {
                zzfh.zza zzaVar4 = (zzfh.zza) it6.next();
                arrayList2.add(zzaVar4.zzg() ? Integer.valueOf(zzaVar4.zza()) : null);
            }
            zzanVarZzh.k(str, arrayList2);
            sQLiteDatabaseA.setTransactionSuccessful();
            try {
                zzaVarZzby.zzb();
                bArrZzbv = ((zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah())).zzbv();
            } catch (RuntimeException e10) {
                zzj().zzu().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzgb.zza(str), e10);
                bArrZzbv = bArr;
            }
            zzan zzanVarZzh2 = zzh();
            Preconditions.checkNotEmpty(str);
            zzanVarZzh2.zzt();
            zzanVarZzh2.zzak();
            ContentValues contentValues = new ContentValues();
            contentValues.put("remote_config", bArrZzbv);
            contentValues.put("config_last_modified_time", str2);
            contentValues.put("e_tag", str3);
            try {
                if (zzanVarZzh2.a().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                    zzanVarZzh2.zzj().zzg().zza("Failed to update remote config (got 0). appId", zzgb.zza(str));
                }
            } catch (SQLiteException e11) {
                zzanVarZzh2.zzj().zzg().zza("Error storing remote config. appId", zzgb.zza(str), e11);
            }
            bVar4.put(str, (zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah()));
            return true;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }
}
