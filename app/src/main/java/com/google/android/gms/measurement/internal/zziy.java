package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.internal.measurement.zzon;
import com.google.android.gms.internal.measurement.zzpa;
import com.google.android.gms.internal.measurement.zzpy;
import com.google.android.gms.internal.measurement.zzqk;
import com.google.android.gms.measurement.internal.zziq;
import com.unity3d.ads.metadata.MediationMetaData;
import e8.b;
import e8.c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import lf.h;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zziy extends zzg {

    /* renamed from: c, reason: collision with root package name */
    public zzkl f8228c;

    /* renamed from: d, reason: collision with root package name */
    public zziu f8229d;

    /* renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArraySet f8230e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8231f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReference<String> f8232g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f8233h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8234i;

    /* renamed from: j, reason: collision with root package name */
    public PriorityQueue<zzmv> f8235j;

    /* renamed from: k, reason: collision with root package name */
    public zziq f8236k;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicLong f8237l;

    /* renamed from: m, reason: collision with root package name */
    public long f8238m;

    /* renamed from: n, reason: collision with root package name */
    public final zzt f8239n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8240o;

    /* renamed from: p, reason: collision with root package name */
    public zzjv f8241p;

    /* renamed from: q, reason: collision with root package name */
    public zzjg f8242q;

    /* renamed from: r, reason: collision with root package name */
    public zzjr f8243r;

    /* renamed from: s, reason: collision with root package name */
    public final zzkd f8244s;

    public zziy(zzho zzhoVar) {
        super(zzhoVar);
        this.f8230e = new CopyOnWriteArraySet();
        this.f8233h = new Object();
        this.f8234i = false;
        this.f8240o = true;
        this.f8244s = new zzkd(this);
        this.f8232g = new AtomicReference<>();
        this.f8236k = zziq.f8195c;
        this.f8238m = -1L;
        this.f8237l = new AtomicLong(0L);
        this.f8239n = new zzt(zzhoVar);
    }

    public static void e(zziy zziyVar, zziq zziqVar, long j10, boolean z10, boolean z11) throws IllegalStateException {
        boolean z12;
        zziyVar.zzt();
        zziyVar.zzu();
        zziq zziqVarE = zziyVar.zzk().e();
        if (j10 <= zziyVar.f8238m && zziq.zza(zziqVarE.zza(), zziqVar.zza())) {
            zziyVar.zzj().zzn().zza("Dropped out-of-date consent setting, proposed settings", zziqVar);
            return;
        }
        zzgm zzgmVarZzk = zziyVar.zzk();
        zzgmVarZzk.zzt();
        int iZza = zziqVar.zza();
        if (zzgmVarZzk.zza(iZza)) {
            SharedPreferences.Editor editorEdit = zzgmVarZzk.zzg().edit();
            editorEdit.putString("consent_settings", zziqVar.zzh());
            editorEdit.putInt("consent_source", iZza);
            editorEdit.apply();
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            zziyVar.zzj().zzn().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(zziqVar.zza()));
            return;
        }
        zziyVar.f8238m = j10;
        zziyVar.zzo().zza(z10);
        if (z11) {
            zziyVar.zzo().zza(new AtomicReference<>());
        }
    }

    public static /* synthetic */ void f(zziy zziyVar, zziq zziqVar, zziq zziqVar2) {
        zziq.zza zzaVar = zziq.zza.ANALYTICS_STORAGE;
        zziq.zza zzaVar2 = zziq.zza.AD_STORAGE;
        boolean zZza = zziqVar.zza(zziqVar2, zzaVar, zzaVar2);
        boolean zZzb = zziqVar.zzb(zziqVar2, zzaVar, zzaVar2);
        if (zZza || zZzb) {
            zziyVar.zzg().zzag();
        }
    }

    public final void a(long j10, boolean z10) throws IllegalStateException {
        zzt();
        zzu();
        zzj().zzc().zza("Resetting analytics data (FE)");
        zzmi zzmiVarZzp = zzp();
        zzmiVarZzp.zzt();
        zzmo zzmoVar = zzmiVarZzp.f8495f;
        zzmoVar.f8508c.a();
        zzmoVar.f8506a = 0L;
        zzmoVar.f8507b = 0L;
        if (zzqk.zza() && zze().zza(zzbh.f7762r0)) {
            zzg().zzag();
        }
        boolean zZzac = this.f8189a.zzac();
        zzgm zzgmVarZzk = zzk();
        zzgmVarZzk.f7996g.zza(j10);
        if (!TextUtils.isEmpty(zzgmVarZzk.zzk().f8012w.zza())) {
            zzgmVarZzk.f8012w.zza(null);
        }
        if (zzpa.zza() && zzgmVarZzk.zze().zza(zzbh.f7752m0)) {
            zzgmVarZzk.f8006q.zza(0L);
        }
        zzgmVarZzk.f8007r.zza(0L);
        if (!zzgmVarZzk.zze().zzw()) {
            zzgmVarZzk.b(!zZzac);
        }
        zzgmVarZzk.f8013x.zza(null);
        zzgmVarZzk.f8014y.zza(0L);
        zzgmVarZzk.f8015z.zza(null);
        if (z10) {
            zzo().zzaf();
        }
        if (zzpa.zza() && zze().zza(zzbh.f7752m0)) {
            zzp().f8494e.a();
        }
        this.f8240o = !zZzac;
    }

    public final void b(Bundle bundle, int i10, long j10) throws IllegalStateException {
        zzu();
        String strZza = zziq.zza(bundle);
        if (strZza != null) {
            zzj().zzv().zza("Ignoring invalid consent setting", strZza);
            zzj().zzv().zza("Valid consent values are 'granted', 'denied'");
        }
        zziq zziqVarZza = zziq.zza(bundle, i10);
        if (!zzon.zza() || !zze().zza(zzbh.L0)) {
            zza(zziqVarZza, j10, false);
            return;
        }
        if (zziqVarZza.zzk()) {
            zza(zziqVarZza, j10, false);
        }
        zzax zzaxVarZza = zzax.zza(bundle, i10);
        if (zzaxVarZza.zzg()) {
            c(zzaxVarZza, false);
        }
        Boolean boolZza = zzax.zza(bundle);
        if (boolZza != null) {
            zza(i10 == -30 ? "tcf" : "app", "allow_personalized_ads", (Object) boolZza.toString(), false);
        }
    }

    public final void c(zzax zzaxVar, boolean z10) {
        zzkg zzkgVar = new zzkg(this, zzaxVar);
        if (!z10) {
            zzl().zzb(zzkgVar);
        } else {
            zzt();
            zzkgVar.run();
        }
    }

    public final void d(zziq zziqVar) {
        zzt();
        boolean z10 = (zziqVar.zzj() && zziqVar.zzi()) || zzo().c();
        zzho zzhoVar = this.f8189a;
        if (z10 != zzhoVar.zzad()) {
            zzhoVar.zzb(z10);
            zzgm zzgmVarZzk = zzk();
            zzgmVarZzk.zzt();
            Boolean boolValueOf = zzgmVarZzk.zzg().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzgmVarZzk.zzg().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z10 || boolValueOf == null || boolValueOf.booleanValue()) {
                g(Boolean.valueOf(z10), false);
            }
        }
    }

    public final void g(Boolean bool, boolean z10) throws IllegalStateException {
        zzt();
        zzu();
        zzj().zzc().zza("Setting app measurement enabled (FE)", bool);
        zzk().zza(bool);
        if (z10) {
            zzgm zzgmVarZzk = zzk();
            zzgmVarZzk.zzt();
            SharedPreferences.Editor editorEdit = zzgmVarZzk.zzg().edit();
            if (bool != null) {
                editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit.remove("measurement_enabled_from_api");
            }
            editorEdit.apply();
        }
        if (this.f8189a.zzad() || !(bool == null || bool.booleanValue())) {
            m();
        }
    }

    public final void h(String str) {
        this.f8232g.set(str);
    }

    public final void i(String str, String str2, Bundle bundle, long j10) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        zzt();
        zza(str, str2, j10, bundle, true, this.f8229d == null || zznt.N(str2), true, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) throws java.lang.IllegalStateException {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzt()
            r8.zzu()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L60
            boolean r0 = r11 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L50
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L50
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L35
            r4 = r2
            goto L37
        L35:
            r4 = 0
        L37:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzgm r0 = r8.zzk()
            com.google.android.gms.measurement.internal.zzgs r0 = r0.f8003n
            long r4 = r10.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L4b
            java.lang.String r11 = "true"
        L4b:
            r0.zza(r11)
            r7 = r10
            goto L5e
        L50:
            if (r11 != 0) goto L60
            com.google.android.gms.measurement.internal.zzgm r10 = r8.zzk()
            com.google.android.gms.measurement.internal.zzgs r10 = r10.f8003n
            java.lang.String r0 = "unset"
            r10.zza(r0)
            r7 = r11
        L5e:
            r3 = r1
            goto L62
        L60:
            r3 = r10
            r7 = r11
        L62:
            com.google.android.gms.measurement.internal.zzho r10 = r8.f8189a
            boolean r11 = r10.zzac()
            if (r11 != 0) goto L78
            com.google.android.gms.measurement.internal.zzgb r9 = r8.zzj()
            com.google.android.gms.measurement.internal.zzgd r9 = r9.zzp()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L78:
            boolean r10 = r10.zzaf()
            if (r10 != 0) goto L7f
            return
        L7f:
            com.google.android.gms.measurement.internal.zzno r10 = new com.google.android.gms.measurement.internal.zzno
            r2 = r10
            r4 = r9
            r5 = r12
            r2.<init>(r3, r4, r5, r7)
            com.google.android.gms.measurement.internal.zzla r9 = r8.zzo()
            r9.zza(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziy.j(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    @TargetApi(30)
    public final void k() throws IllegalStateException {
        zzmv zzmvVarPoll;
        zzt();
        if (l().isEmpty() || this.f8234i || (zzmvVarPoll = l().poll()) == null) {
            return;
        }
        zznt zzntVarZzq = zzq();
        if (zzntVarZzq.f8605f == null) {
            zzntVarZzq.f8605f = MeasurementManagerFutures.from(zzntVarZzq.zza());
        }
        MeasurementManagerFutures measurementManagerFutures = zzntVarZzq.f8605f;
        if (measurementManagerFutures == null) {
            return;
        }
        this.f8234i = true;
        zzgd zzgdVarZzp = zzj().zzp();
        String str = zzmvVarPoll.f8517b;
        zzgdVarZzp.zza("Registering trigger URI", str);
        c<h> cVarRegisterTriggerAsync = measurementManagerFutures.registerTriggerAsync(Uri.parse(str));
        if (cVarRegisterTriggerAsync == null) {
            this.f8234i = false;
            l().add(zzmvVarPoll);
            return;
        }
        SparseArray<Long> sparseArrayC = zzk().c();
        sparseArrayC.put(zzmvVarPoll.f8519n, Long.valueOf(zzmvVarPoll.f8518m));
        zzgm zzgmVarZzk = zzk();
        int[] iArr = new int[sparseArrayC.size()];
        long[] jArr = new long[sparseArrayC.size()];
        for (int i10 = 0; i10 < sparseArrayC.size(); i10++) {
            iArr[i10] = sparseArrayC.keyAt(i10);
            jArr[i10] = sparseArrayC.valueAt(i10).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        zzgmVarZzk.f8004o.zza(bundle);
        b.addCallback(cVarRegisterTriggerAsync, new zzjn(this, zzmvVarPoll), new zzjk(this));
    }

    @TargetApi(30)
    public final PriorityQueue<zzmv> l() {
        if (this.f8235j == null) {
            this.f8235j = new PriorityQueue<>(Comparator.comparing(new Function() { // from class: com.google.android.gms.measurement.internal.zzjb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((zzmv) obj).f8518m);
                }
            }, new Comparator() { // from class: com.google.android.gms.measurement.internal.zzja
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            }));
        }
        return this.f8235j;
    }

    public final void m() throws IllegalStateException {
        zzt();
        String strZza = zzk().f8003n.zza();
        if (strZza != null) {
            if ("unset".equals(strZza)) {
                j("app", "_npa", null, zzb().currentTimeMillis());
            } else {
                j("app", "_npa", Long.valueOf("true".equals(strZza) ? 1L : 0L), zzb().currentTimeMillis());
            }
        }
        if (!this.f8189a.zzac() || !this.f8240o) {
            zzj().zzc().zza("Updating Scion state (FE)");
            zzo().zzag();
            return;
        }
        zzj().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzaj();
        if (zzpa.zza() && zze().zza(zzbh.f7752m0)) {
            zzp().f8494e.a();
        }
        zzl().zzb(new zzjp(this));
    }

    public final void n(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) throws IllegalStateException {
        zzl().zzb(new zzjq(this, str, str2, j10, zznt.zza(bundle), z10, z11, z12, str3));
    }

    public final void o(String str, String str2, Bundle bundle) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        zzt();
        i(str, str2, bundle, zzb().currentTimeMillis());
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public final Boolean zzaa() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzl().a(atomicReference, 15000L, "boolean test flag value", new zzjl(this, atomicReference));
    }

    public final Double zzab() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzl().a(atomicReference, 15000L, "double test flag value", new zzke(this, atomicReference));
    }

    public final Integer zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzl().a(atomicReference, 15000L, "int test flag value", new zzkf(this, atomicReference));
    }

    public final Long zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzl().a(atomicReference, 15000L, "long test flag value", new zzkc(this, atomicReference));
    }

    public final String zzae() {
        return this.f8232g.get();
    }

    public final String zzaf() {
        zzks zzksVarZzaa = this.f8189a.zzq().zzaa();
        if (zzksVarZzaa != null) {
            return zzksVarZzaa.f8352b;
        }
        return null;
    }

    public final String zzag() {
        zzks zzksVarZzaa = this.f8189a.zzq().zzaa();
        if (zzksVarZzaa != null) {
            return zzksVarZzaa.f8351a;
        }
        return null;
    }

    public final String zzah() throws IllegalStateException {
        zzho zzhoVar = this.f8189a;
        if (zzhoVar.zzu() != null) {
            return zzhoVar.zzu();
        }
        try {
            return new zzhi(zza(), zzhoVar.zzx()).zza("google_app_id");
        } catch (IllegalStateException e10) {
            zzhoVar.zzj().zzg().zza("getGoogleAppId failed with exception", e10);
            return null;
        }
    }

    public final String zzai() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzl().a(atomicReference, 15000L, "String test flag value", new zzju(this, atomicReference));
    }

    public final void zzaj() {
        zzt();
        zzu();
        if (this.f8189a.zzaf()) {
            Boolean boolC = zze().c("google_analytics_deferred_deep_link_enabled");
            if (boolC != null && boolC.booleanValue()) {
                zzj().zzc().zza("Deferred Deep Link feature enabled.");
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjh
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalStateException {
                        this.f8262b.zzam();
                    }
                });
            }
            zzo().zzac();
            this.f8240o = false;
            String strZzw = zzk().zzw();
            if (TextUtils.isEmpty(strZzw)) {
                return;
            }
            zzf().zzac();
            if (strZzw.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", strZzw);
            o("auto", "_ou", bundle);
        }
    }

    public final void zzak() {
        if (!(zza().getApplicationContext() instanceof Application) || this.f8228c == null) {
            return;
        }
        ((Application) zza().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f8228c);
    }

    public final void zzal() throws IllegalStateException {
        if (zzpy.zza() && zze().zza(zzbh.F0)) {
            if (zzl().zzg()) {
                zzj().zzg().zza("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (zzad.zza()) {
                zzj().zzg().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzu();
            zzj().zzp().zza("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzl().a(atomicReference, 5000L, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjd
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException {
                    zziy zziyVar = this.f8254b;
                    Bundle bundleZza = zziyVar.zzk().f8004o.zza();
                    zzla zzlaVarZzo = zziyVar.zzo();
                    if (bundleZza == null) {
                        bundleZza = new Bundle();
                    }
                    zzlaVarZzo.zza(atomicReference, bundleZza);
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                zzj().zzg().zza("Timed out waiting for get trigger URIs");
            } else {
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjc
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalStateException {
                        zziy zziyVar = this.f8252b;
                        zziyVar.zzt();
                        if (Build.VERSION.SDK_INT >= 30) {
                            SparseArray<Long> sparseArrayC = zziyVar.zzk().c();
                            for (zzmv zzmvVar : list) {
                                if (!sparseArrayC.contains(zzmvVar.f8519n) || sparseArrayC.get(zzmvVar.f8519n).longValue() < zzmvVar.f8518m) {
                                    zziyVar.l().add(zzmvVar);
                                }
                            }
                            zziyVar.k();
                        }
                    }
                });
            }
        }
    }

    public final void zzam() throws IllegalStateException {
        zzt();
        if (zzk().f8010u.zza()) {
            zzj().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long jZza = zzk().f8011v.zza();
        zzk().f8011v.zza(1 + jZza);
        if (jZza >= 5) {
            zzj().zzu().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzk().f8010u.zza(true);
            return;
        }
        boolean zZza = zzon.zza();
        zzho zzhoVar = this.f8189a;
        if (!zZza || !zze().zza(zzbh.N0)) {
            zzhoVar.zzah();
            return;
        }
        if (this.f8241p == null) {
            this.f8241p = new zzjv(this, zzhoVar);
        }
        this.f8241p.zza(0L);
    }

    public final void zzan() {
        zzt();
        zzj().zzc().zza("Handle tcf update.");
        zzmt zzmtVarZza = zzmt.zza(zzk().zzc());
        zzj().zzp().zza("Tcf preferences read", zzmtVarZza);
        if (zzk().zza(zzmtVarZza)) {
            Bundle bundleZza = zzmtVarZza.zza();
            zzj().zzp().zza("Consent generated from Tcf", bundleZza);
            if (bundleZza != Bundle.EMPTY) {
                b(bundleZza, -30, zzb().currentTimeMillis());
            }
            Bundle bundle = new Bundle();
            bundle.putString("_tcfd", zzmtVarZza.zzb());
            o("auto", "_tcf", bundle);
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.google.android.gms.measurement.internal.zzjg] */
    public final void zzap() {
        zzt();
        zzj().zzc().zza("Register tcfPrefChangeListener.");
        if (this.f8242q == null) {
            this.f8243r = new zzjr(this, this.f8189a);
            this.f8242q = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzjg
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) throws IllegalStateException {
                    zziy zziyVar = this.f8261a;
                    zziyVar.getClass();
                    if ("IABTCF_TCString".equals(str)) {
                        zziyVar.zzj().zzp().zza("IABTCF_TCString change picked up in listener.");
                        ((zzav) Preconditions.checkNotNull(zziyVar.f8243r)).zza(500L);
                    }
                }
            };
        }
        zzk().zzc().registerOnSharedPreferenceChangeListener(this.f8242q);
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

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfv zzg() {
        return super.zzg();
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

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzkv zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzla zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzmi zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zzz() {
        return false;
    }

    public final ArrayList<Bundle> zza(String str, String str2) throws IllegalStateException {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (zzad.zza()) {
            zzj().zzg().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f8189a.zzl().a(atomicReference, 5000L, "get conditional user properties", new zzjy(this, atomicReference, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zznt.zzb((List<zzac>) list);
        }
        zzj().zzg().zza("Timed out waiting for get conditional user properties", null);
        return new ArrayList<>();
    }

    public final void zzb(String str, String str2, Bundle bundle) throws IllegalStateException {
        zza(str, str2, bundle, true, true, zzb().currentTimeMillis());
    }

    public final void zzb(Bundle bundle) throws IllegalStateException {
        zza(bundle, zzb().currentTimeMillis());
    }

    public final void zzb(zzix zzixVar) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(zzixVar);
        if (this.f8230e.remove(zzixVar)) {
            return;
        }
        zzj().zzu().zza("OnEventListener had not been registered");
    }

    public final Map<String, Object> zza(String str, String str2, boolean z10) throws IllegalStateException {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzad.zza()) {
            zzj().zzg().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f8189a.zzl().a(atomicReference, 5000L, "get user properties", new zzkb(this, atomicReference, str, str2, z10));
        List<zzno> list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z10));
            return Collections.emptyMap();
        }
        b0.b bVar = new b0.b(list.size());
        for (zzno zznoVar : list) {
            Object objZza = zznoVar.zza();
            if (objZza != null) {
                bVar.put(zznoVar.f8589m, objZza);
            }
        }
        return bVar;
    }

    public final void zza(String str, String str2, Bundle bundle) throws IllegalStateException {
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString(MediationMetaData.KEY_NAME, str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        zzl().zzb(new zzjz(this, bundle2));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) throws IllegalStateException {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (Objects.equals(str2, "screen_view")) {
            zzn().zza(bundle2, j10);
        } else {
            n(str3, str2, j10, bundle2, z11, !z11 || this.f8229d == null || zznt.N(str2), z10, null);
        }
    }

    public final void zza(String str, String str2, Bundle bundle, String str3) throws IllegalStateException {
        zzs();
        n(str, str2, zzb().currentTimeMillis(), bundle, false, true, true, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0142  */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.String r25, java.lang.String r26, long r27, android.os.Bundle r29, boolean r30, boolean r31, boolean r32, java.lang.String r33) throws java.lang.IllegalStateException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 1173
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziy.zza(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zza(zzix zzixVar) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(zzixVar);
        if (this.f8230e.add(zzixVar)) {
            return;
        }
        zzj().zzu().zza("OnEventListener already registered");
    }

    public final void zza(Bundle bundle, long j10) throws IllegalStateException {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzj().zzu().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzin.zza(bundle2, "app_id", String.class, null);
        zzin.zza(bundle2, "origin", String.class, null);
        zzin.zza(bundle2, MediationMetaData.KEY_NAME, String.class, null);
        zzin.zza(bundle2, "value", Object.class, null);
        zzin.zza(bundle2, "trigger_event_name", String.class, null);
        zzin.zza(bundle2, "trigger_timeout", Long.class, 0L);
        zzin.zza(bundle2, "timed_out_event_name", String.class, null);
        zzin.zza(bundle2, "timed_out_event_params", Bundle.class, null);
        zzin.zza(bundle2, "triggered_event_name", String.class, null);
        zzin.zza(bundle2, "triggered_event_params", Bundle.class, null);
        zzin.zza(bundle2, "time_to_live", Long.class, 0L);
        zzin.zza(bundle2, "expired_event_name", String.class, null);
        zzin.zza(bundle2, "expired_event_params", Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString(MediationMetaData.KEY_NAME));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j10);
        String string = bundle2.getString(MediationMetaData.KEY_NAME);
        Object obj = bundle2.get("value");
        if (zzq().zzb(string) != 0) {
            zzj().zzg().zza("Invalid conditional user property name", zzi().zzc(string));
            return;
        }
        if (zzq().a(obj, string) != 0) {
            zzj().zzg().zza("Invalid conditional user property value", zzi().zzc(string), obj);
            return;
        }
        Object objH = zzq().H(obj, string);
        if (objH == null) {
            zzj().zzg().zza("Unable to normalize conditional user property value", zzi().zzc(string), obj);
            return;
        }
        zzin.zza(bundle2, objH);
        long j11 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j11 > 15552000000L || j11 < 1)) {
            zzj().zzg().zza("Invalid conditional user property timeout", zzi().zzc(string), Long.valueOf(j11));
            return;
        }
        long j12 = bundle2.getLong("time_to_live");
        if (j12 <= 15552000000L && j12 >= 1) {
            zzl().zzb(new zzjw(this, bundle2));
        } else {
            zzj().zzg().zza("Invalid conditional user property time to live", zzi().zzc(string), Long.valueOf(j12));
        }
    }

    public final void zza(zziq zziqVar, long j10, boolean z10) {
        zziq zziqVar2;
        boolean z11;
        boolean zZzc;
        boolean z12;
        zziq zziqVarZzb = zziqVar;
        zzu();
        int iZza = zziqVar.zza();
        if (zznw.zza() && zze().zza(zzbh.Y0)) {
            if (iZza != -10) {
                zzip zzipVarZzc = zziqVar.zzc();
                zzip zzipVar = zzip.UNINITIALIZED;
                if (zzipVarZzc == zzipVar && zziqVar.zzd() == zzipVar) {
                    zzj().zzv().zza("Ignoring empty consent settings");
                    return;
                }
            }
        } else if (iZza != -10 && zziqVar.zze() == null && zziqVar.zzf() == null) {
            zzj().zzv().zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.f8233h) {
            zziqVar2 = this.f8236k;
            z11 = false;
            if (zziq.zza(iZza, zziqVar2.zza())) {
                zZzc = zziqVar.zzc(this.f8236k);
                if (zziqVar.zzj() && !this.f8236k.zzj()) {
                    z11 = true;
                }
                zziqVarZzb = zziqVar.zzb(this.f8236k);
                this.f8236k = zziqVarZzb;
                z12 = z11;
                z11 = true;
            } else {
                zZzc = false;
                z12 = false;
            }
        }
        if (!z11) {
            zzj().zzn().zza("Ignoring lower-priority consent settings, proposed settings", zziqVarZzb);
            return;
        }
        long andIncrement = this.f8237l.getAndIncrement();
        if (zZzc) {
            h(null);
            zzkj zzkjVar = new zzkj(this, zziqVarZzb, j10, andIncrement, z12, zziqVar2);
            if (z10) {
                zzt();
                zzkjVar.run();
                return;
            } else {
                zzl().zzc(zzkjVar);
                return;
            }
        }
        zzki zzkiVar = new zzki(this, zziqVarZzb, andIncrement, z12, zziqVar2);
        if (z10) {
            zzt();
            zzkiVar.run();
        } else if (iZza != 30 && iZza != -10) {
            zzl().zzb(zzkiVar);
        } else {
            zzl().zzc(zzkiVar);
        }
    }

    public final void zza(zziu zziuVar) {
        zziu zziuVar2;
        zzt();
        zzu();
        if (zziuVar != null && zziuVar != (zziuVar2 = this.f8229d)) {
            Preconditions.checkState(zziuVar2 == null, "EventInterceptor already set.");
        }
        this.f8229d = zziuVar;
    }

    public final void zza(Boolean bool) throws IllegalStateException {
        zzu();
        zzl().zzb(new zzkh(this, bool));
    }

    public final void zza(String str, String str2, Object obj, boolean z10) {
        zza(str, str2, obj, z10, zzb().currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.String r8, java.lang.String r9, java.lang.Object r10, boolean r11, long r12) throws java.lang.IllegalStateException {
        /*
            r7 = this;
            if (r8 != 0) goto L4
            java.lang.String r8 = "app"
        L4:
            r2 = r8
            r8 = 0
            r0 = 24
            if (r11 == 0) goto L13
            com.google.android.gms.measurement.internal.zznt r11 = r7.zzq()
            int r11 = r11.zzb(r9)
            goto L35
        L13:
            com.google.android.gms.measurement.internal.zznt r11 = r7.zzq()
            java.lang.String r1 = "user property"
            boolean r3 = r11.I(r1, r9)
            if (r3 != 0) goto L20
            goto L32
        L20:
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.zziv.f8216a
            r4 = 0
            boolean r3 = r11.y(r1, r3, r4, r9)
            if (r3 != 0) goto L2c
            r11 = 15
            goto L35
        L2c:
            boolean r11 = r11.p(r0, r1, r9)
            if (r11 != 0) goto L34
        L32:
            r11 = 6
            goto L35
        L34:
            r11 = 0
        L35:
            java.lang.String r1 = "_ev"
            com.google.android.gms.measurement.internal.zzkd r3 = r7.f8244s
            com.google.android.gms.measurement.internal.zzho r4 = r7.f8189a
            r5 = 1
            if (r11 == 0) goto L52
            r7.zzq()
            java.lang.String r10 = com.google.android.gms.measurement.internal.zznt.zza(r9, r0, r5)
            if (r9 == 0) goto L4b
            int r8 = r9.length()
        L4b:
            r4.zzt()
            com.google.android.gms.measurement.internal.zznt.zza(r3, r11, r1, r10, r8)
            return
        L52:
            if (r10 == 0) goto L97
            com.google.android.gms.measurement.internal.zznt r11 = r7.zzq()
            int r11 = r11.a(r10, r9)
            if (r11 == 0) goto L7c
            r7.zzq()
            java.lang.String r9 = com.google.android.gms.measurement.internal.zznt.zza(r9, r0, r5)
            boolean r12 = r10 instanceof java.lang.String
            if (r12 != 0) goto L6d
            boolean r12 = r10 instanceof java.lang.CharSequence
            if (r12 == 0) goto L75
        L6d:
            java.lang.String r8 = java.lang.String.valueOf(r10)
            int r8 = r8.length()
        L75:
            r4.zzt()
            com.google.android.gms.measurement.internal.zznt.zza(r3, r11, r1, r9, r8)
            return
        L7c:
            com.google.android.gms.measurement.internal.zznt r8 = r7.zzq()
            java.lang.Object r4 = r8.H(r10, r9)
            if (r4 == 0) goto L96
            com.google.android.gms.measurement.internal.zzhh r8 = r7.zzl()
            com.google.android.gms.measurement.internal.zzjt r10 = new com.google.android.gms.measurement.internal.zzjt
            r0 = r10
            r1 = r7
            r3 = r9
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r8.zzb(r10)
        L96:
            return
        L97:
            r4 = 0
            com.google.android.gms.measurement.internal.zzhh r8 = r7.zzl()
            com.google.android.gms.measurement.internal.zzjt r10 = new com.google.android.gms.measurement.internal.zzjt
            r0 = r10
            r1 = r7
            r3 = r9
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r8.zzb(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziy.zza(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }
}
