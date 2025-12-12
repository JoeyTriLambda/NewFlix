package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzhs extends zzft {

    /* renamed from: a, reason: collision with root package name */
    public final zznd f8127a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f8128b;

    /* renamed from: c, reason: collision with root package name */
    public String f8129c;

    public zzhs(zznd zzndVar) {
        Preconditions.checkNotNull(zzndVar);
        this.f8127a = zzndVar;
        this.f8129c = null;
    }

    public final void a(Runnable runnable) throws IllegalStateException {
        Preconditions.checkNotNull(runnable);
        zznd zzndVar = this.f8127a;
        if (zzndVar.zzl().zzg()) {
            runnable.run();
        } else {
            zzndVar.zzl().zzb(runnable);
        }
    }

    public final void b(String str, boolean z10) throws IllegalStateException {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        zznd zzndVar = this.f8127a;
        if (zIsEmpty) {
            zzndVar.zzj().zzg().zza("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z10) {
            try {
                if (this.f8128b == null) {
                    this.f8128b = Boolean.valueOf("com.google.android.gms".equals(this.f8129c) || UidVerifier.isGooglePlayServicesUid(zzndVar.zza(), Binder.getCallingUid()) || GoogleSignatureVerifier.getInstance(zzndVar.zza()).isUidGoogleSigned(Binder.getCallingUid()));
                }
                if (this.f8128b.booleanValue()) {
                    return;
                }
            } catch (SecurityException e10) {
                zzndVar.zzj().zzg().zza("Measurement Service called with invalid calling package. appId", zzgb.zza(str));
                throw e10;
            }
        }
        if (this.f8129c == null && GooglePlayServicesUtilLight.uidHasPackageName(zzndVar.zza(), Binder.getCallingUid(), str)) {
            this.f8129c = str;
        }
        if (str.equals(this.f8129c)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    public final void c(zzn zznVar) throws IllegalStateException {
        Preconditions.checkNotNull(zznVar);
        Preconditions.checkNotEmpty(zznVar.f8526b);
        b(zznVar.f8526b, false);
        this.f8127a.zzq().u(zznVar.f8527m, zznVar.B);
    }

    public final void d(zzbf zzbfVar, zzn zznVar) {
        zznd zzndVar = this.f8127a;
        zzndVar.J();
        zzndVar.k(zzbfVar, zznVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final zzal zza(zzn zznVar) throws IllegalStateException {
        c(zznVar);
        String str = zznVar.f8526b;
        Preconditions.checkNotEmpty(str);
        zznd zzndVar = this.f8127a;
        try {
            return (zzal) zzndVar.zzl().zzb(new zzid(this, zznVar)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            zzndVar.zzj().zzg().zza("Failed to get consent. appId", zzgb.zza(str), e10);
            return new zzal(null);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final String zzb(zzn zznVar) throws IllegalStateException {
        c(zznVar);
        zznd zzndVar = this.f8127a;
        try {
            return (String) zzndVar.zzl().zza(new zznh(zzndVar, zznVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            zzndVar.zzj().zzg().zza("Failed to get app instance id. appId", zzgb.zza(zznVar.f8526b), e10);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zzc(zzn zznVar) throws IllegalStateException {
        c(zznVar);
        a(new zzht(this, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zzd(zzn zznVar) throws IllegalStateException {
        Preconditions.checkNotEmpty(zznVar.f8526b);
        b(zznVar.f8526b, false);
        a(new zzib(this, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zze(zzn zznVar) throws IllegalStateException {
        Preconditions.checkNotEmpty(zznVar.f8526b);
        Preconditions.checkNotNull(zznVar.G);
        zzie zzieVar = new zzie(this, zznVar);
        Preconditions.checkNotNull(zzieVar);
        zznd zzndVar = this.f8127a;
        if (zzndVar.zzl().zzg()) {
            zzieVar.run();
        } else {
            zzndVar.zzl().zzc(zzieVar);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zzf(zzn zznVar) throws IllegalStateException {
        c(zznVar);
        a(new zzhu(this, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzmv> zza(zzn zznVar, Bundle bundle) throws IllegalStateException {
        c(zznVar);
        String str = zznVar.f8526b;
        Preconditions.checkNotNull(str);
        zznd zzndVar = this.f8127a;
        try {
            return (List) zzndVar.zzl().zza(new zzik(this, zznVar, bundle)).get();
        } catch (InterruptedException | ExecutionException e10) {
            zzndVar.zzj().zzg().zza("Failed to get trigger URIs. appId", zzgb.zza(str), e10);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzno> zza(zzn zznVar, boolean z10) throws IllegalStateException {
        c(zznVar);
        String str = zznVar.f8526b;
        Preconditions.checkNotNull(str);
        zznd zzndVar = this.f8127a;
        try {
            List<zznq> list = (List) zzndVar.zzl().zza(new zzij(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznq zznqVar : list) {
                if (z10 || !zznt.N(zznqVar.f8597c)) {
                    arrayList.add(new zzno(zznqVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            zzndVar.zzj().zzg().zza("Failed to get user properties. appId", zzgb.zza(str), e10);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzac> zza(String str, String str2, zzn zznVar) throws IllegalStateException {
        c(zznVar);
        String str3 = zznVar.f8526b;
        Preconditions.checkNotNull(str3);
        zznd zzndVar = this.f8127a;
        try {
            return (List) zzndVar.zzl().zza(new zzhz(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e10) {
            zzndVar.zzj().zzg().zza("Failed to get conditional user properties", e10);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzac> zza(String str, String str2, String str3) throws IllegalStateException {
        b(str, true);
        zznd zzndVar = this.f8127a;
        try {
            return (List) zzndVar.zzl().zza(new zzic(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e10) {
            zzndVar.zzj().zzg().zza("Failed to get conditional user properties as", e10);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzno> zza(String str, String str2, boolean z10, zzn zznVar) throws IllegalStateException {
        c(zznVar);
        String str3 = zznVar.f8526b;
        Preconditions.checkNotNull(str3);
        zznd zzndVar = this.f8127a;
        try {
            List<zznq> list = (List) zzndVar.zzl().zza(new zzhx(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznq zznqVar : list) {
                if (z10 || !zznt.N(zznqVar.f8597c)) {
                    arrayList.add(new zzno(zznqVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            zzndVar.zzj().zzg().zza("Failed to query user properties. appId", zzgb.zza(str3), e10);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzno> zza(String str, String str2, String str3, boolean z10) throws IllegalStateException {
        b(str, true);
        zznd zzndVar = this.f8127a;
        try {
            List<zznq> list = (List) zzndVar.zzl().zza(new zzia(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznq zznqVar : list) {
                if (z10 || !zznt.N(zznqVar.f8597c)) {
                    arrayList.add(new zzno(zznqVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            zzndVar.zzj().zzg().zza("Failed to get user properties as. appId", zzgb.zza(str), e10);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zzbf zzbfVar, zzn zznVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzbfVar);
        c(zznVar);
        a(new zzig(this, zzbfVar, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zzbf zzbfVar, String str, String str2) throws IllegalStateException {
        Preconditions.checkNotNull(zzbfVar);
        Preconditions.checkNotEmpty(str);
        b(str, true);
        a(new zzif(this, zzbfVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zzac zzacVar, zzn zznVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotNull(zzacVar.f7629n);
        c(zznVar);
        zzac zzacVar2 = new zzac(zzacVar);
        zzacVar2.f7627b = zznVar.f8526b;
        a(new zzhv(this, zzacVar2, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zzac zzacVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotNull(zzacVar.f7629n);
        Preconditions.checkNotEmpty(zzacVar.f7627b);
        b(zzacVar.f7627b, true);
        a(new zzhy(this, new zzac(zzacVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(long j10, String str, String str2, String str3) throws IllegalStateException {
        a(new zzhw(this, str2, str3, str, j10));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(final Bundle bundle, zzn zznVar) throws IllegalStateException {
        c(zznVar);
        final String str = zznVar.f8526b;
        Preconditions.checkNotNull(str);
        a(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhr
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                String str2 = str;
                Bundle bundle2 = bundle;
                zzan zzanVarZzf = this.f8124b.f8127a.zzf();
                zzanVarZzf.zzt();
                zzanVarZzf.zzak();
                byte[] bArrZzbv = zzanVarZzf.g_().e(new zzay(zzanVarZzf.f8189a, "", str2, "dep", 0L, bundle2)).zzbv();
                zzanVarZzf.zzj().zzp().zza("Saving default event parameters, appId, data size", zzanVarZzf.zzi().zza(str2), Integer.valueOf(bArrZzbv.length));
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str2);
                contentValues.put("parameters", bArrZzbv);
                try {
                    if (zzanVarZzf.a().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                        zzanVarZzf.zzj().zzg().zza("Failed to insert default event parameters (got -1). appId", zzgb.zza(str2));
                    }
                } catch (SQLiteException e10) {
                    zzanVarZzf.zzj().zzg().zza("Error storing default event parameters. appId", zzgb.zza(str2), e10);
                }
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zzno zznoVar, zzn zznVar) throws IllegalStateException {
        Preconditions.checkNotNull(zznoVar);
        c(zznVar);
        a(new zzih(this, zznoVar, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final byte[] zza(zzbf zzbfVar, String str) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbfVar);
        b(str, true);
        zznd zzndVar = this.f8127a;
        zzgd zzgdVarZzc = zzndVar.zzj().zzc();
        zzfw zzfwVarZzg = zzndVar.zzg();
        String str2 = zzbfVar.f7720b;
        String str3 = zzbfVar.f7720b;
        zzgdVarZzc.zza("Log and bundle. event", zzfwVarZzg.zza(str2));
        long jNanoTime = zzndVar.zzb().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) zzndVar.zzl().zzb(new zzii(this, zzbfVar, str)).get();
            if (bArr == null) {
                zzndVar.zzj().zzg().zza("Log and bundle returned null. appId", zzgb.zza(str));
                bArr = new byte[0];
            }
            zzndVar.zzj().zzc().zza("Log and bundle processed. event, size, time_ms", zzndVar.zzg().zza(str3), Integer.valueOf(bArr.length), Long.valueOf((zzndVar.zzb().nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e10) {
            zzndVar.zzj().zzg().zza("Failed to log and bundle. appId, event, error", zzgb.zza(str), zzndVar.zzg().zza(str3), e10);
            return null;
        }
    }
}
