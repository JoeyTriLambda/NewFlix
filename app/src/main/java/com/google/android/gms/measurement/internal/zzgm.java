package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzgm extends zzil {
    public static final Pair<String, Long> A = new Pair<>("", 0L);

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f7992c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f7993d;

    /* renamed from: e, reason: collision with root package name */
    public SharedPreferences f7994e;

    /* renamed from: f, reason: collision with root package name */
    public zzgq f7995f;

    /* renamed from: g, reason: collision with root package name */
    public final zzgr f7996g;

    /* renamed from: h, reason: collision with root package name */
    public final zzgs f7997h;

    /* renamed from: i, reason: collision with root package name */
    public String f7998i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7999j;

    /* renamed from: k, reason: collision with root package name */
    public long f8000k;

    /* renamed from: l, reason: collision with root package name */
    public final zzgr f8001l;

    /* renamed from: m, reason: collision with root package name */
    public final zzgp f8002m;

    /* renamed from: n, reason: collision with root package name */
    public final zzgs f8003n;

    /* renamed from: o, reason: collision with root package name */
    public final zzgo f8004o;

    /* renamed from: p, reason: collision with root package name */
    public final zzgp f8005p;

    /* renamed from: q, reason: collision with root package name */
    public final zzgr f8006q;

    /* renamed from: r, reason: collision with root package name */
    public final zzgr f8007r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8008s;

    /* renamed from: t, reason: collision with root package name */
    public final zzgp f8009t;

    /* renamed from: u, reason: collision with root package name */
    public final zzgp f8010u;

    /* renamed from: v, reason: collision with root package name */
    public final zzgr f8011v;

    /* renamed from: w, reason: collision with root package name */
    public final zzgs f8012w;

    /* renamed from: x, reason: collision with root package name */
    public final zzgs f8013x;

    /* renamed from: y, reason: collision with root package name */
    public final zzgr f8014y;

    /* renamed from: z, reason: collision with root package name */
    public final zzgo f8015z;

    public zzgm(zzho zzhoVar) {
        super(zzhoVar);
        this.f7993d = new Object();
        this.f8001l = new zzgr(this, "session_timeout", 1800000L);
        this.f8002m = new zzgp(this, "start_new_session", true);
        this.f8006q = new zzgr(this, "last_pause_time", 0L);
        this.f8007r = new zzgr(this, "session_id", 0L);
        this.f8003n = new zzgs(this, "non_personalized_ads", null);
        this.f8004o = new zzgo(this, "last_received_uri_timestamps_by_source", null);
        this.f8005p = new zzgp(this, "allow_remote_dynamite", false);
        this.f7996g = new zzgr(this, "first_open_time", 0L);
        new zzgr(this, "app_install_time", 0L);
        this.f7997h = new zzgs(this, "app_instance_id", null);
        this.f8009t = new zzgp(this, "app_backgrounded", false);
        this.f8010u = new zzgp(this, "deep_link_retrieval_complete", false);
        this.f8011v = new zzgr(this, "deep_link_retrieval_attempts", 0L);
        this.f8012w = new zzgs(this, "firebase_feature_rollouts", null);
        this.f8013x = new zzgs(this, "deferred_attribution_cache", null);
        this.f8014y = new zzgr(this, "deferred_attribution_cache_timestamp", 0L);
        this.f8015z = new zzgo(this, "default_event_parameters", null);
    }

    public final boolean a(long j10) {
        return j10 - this.f8001l.zza() > this.f8006q.zza();
    }

    public final void b(boolean z10) {
        zzt();
        zzj().zzp().zza("App measurement setting deferred collection", Boolean.valueOf(z10));
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z10);
        editorEdit.apply();
    }

    public final SparseArray<Long> c() throws IllegalStateException {
        Bundle bundleZza = this.f8004o.zza();
        if (bundleZza == null) {
            return new SparseArray<>();
        }
        int[] intArray = bundleZza.getIntArray("uriSources");
        long[] longArray = bundleZza.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray<>();
        }
        if (intArray.length != longArray.length) {
            zzj().zzg().zza("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray<>();
        }
        SparseArray<Long> sparseArray = new SparseArray<>();
        for (int i10 = 0; i10 < intArray.length; i10++) {
            sparseArray.put(intArray[i10], Long.valueOf(longArray[i10]));
        }
        return sparseArray;
    }

    public final zzax d() {
        zzt();
        return zzax.zza(zzg().getString("dma_consent_settings", null));
    }

    public final zziq e() {
        zzt();
        return zziq.zza(zzg().getString("consent_settings", "G1"), zzg().getInt("consent_source", 100));
    }

    public final Boolean f() {
        zzt();
        if (zzg().contains("measurement_enabled")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    public final void zza(Boolean bool) {
        zzt();
        SharedPreferences.Editor editorEdit = zzg().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzaa() {
        SharedPreferences sharedPreferences = zza().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f7992c = sharedPreferences;
        boolean z10 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f8008s = z10;
        if (!z10) {
            SharedPreferences.Editor editorEdit = this.f7992c.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.f7995f = new zzgq(this, Math.max(0L, zzbh.f7733d.zza(null).longValue()));
    }

    public final SharedPreferences zzc() {
        zzt();
        zzac();
        if (this.f7994e == null) {
            synchronized (this.f7993d) {
                if (this.f7994e == null) {
                    String str = zza().getPackageName() + "_preferences";
                    zzj().zzp().zza("Default prefs file", str);
                    this.f7994e = zza().getSharedPreferences(str, 0);
                }
            }
        }
        return this.f7994e;
    }

    public final SharedPreferences zzg() {
        zzt();
        zzac();
        Preconditions.checkNotNull(this.f7992c);
        return this.f7992c;
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final boolean zzo() {
        return true;
    }

    public final String zzw() {
        zzt();
        String string = zzg().getString("previous_os_version", null);
        zzf().zzac();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor editorEdit = zzg().edit();
            editorEdit.putString("previous_os_version", str);
            editorEdit.apply();
        }
        return string;
    }

    public final boolean zza(int i10) {
        return zziq.zza(i10, zzg().getInt("consent_source", 100));
    }

    public final boolean zza(zzmt zzmtVar) {
        zzt();
        String string = zzg().getString("stored_tcf_param", "");
        String strA = zzmtVar.a();
        if (strA.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("stored_tcf_param", strA);
        editorEdit.apply();
        return true;
    }
}
