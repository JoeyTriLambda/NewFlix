package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.internal.measurement.zzob;
import com.google.android.gms.internal.measurement.zzoc;
import com.google.android.gms.internal.measurement.zzoh;
import com.google.android.gms.internal.measurement.zzoi;
import com.google.android.gms.internal.measurement.zzon;
import com.google.android.gms.internal.measurement.zzoo;
import com.google.android.gms.internal.measurement.zzot;
import com.google.android.gms.internal.measurement.zzou;
import com.google.android.gms.internal.measurement.zzoz;
import com.google.android.gms.internal.measurement.zzpa;
import com.google.android.gms.internal.measurement.zzpf;
import com.google.android.gms.internal.measurement.zzpg;
import com.google.android.gms.internal.measurement.zzpl;
import com.google.android.gms.internal.measurement.zzpm;
import com.google.android.gms.internal.measurement.zzpr;
import com.google.android.gms.internal.measurement.zzps;
import com.google.android.gms.internal.measurement.zzpx;
import com.google.android.gms.internal.measurement.zzpy;
import com.google.android.gms.internal.measurement.zzqd;
import com.google.android.gms.internal.measurement.zzqe;
import com.google.android.gms.internal.measurement.zzqj;
import com.google.android.gms.internal.measurement.zzqk;
import com.google.android.gms.internal.measurement.zzqp;
import com.google.android.gms.internal.measurement.zzqq;
import com.google.android.gms.internal.measurement.zzqv;
import com.google.android.gms.internal.measurement.zzqw;
import com.google.android.gms.internal.measurement.zzrb;
import com.google.android.gms.internal.measurement.zzrc;
import com.loopj.android.http.AsyncHttpClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzbh {
    public static final zzfo<Long> A;
    public static final zzfo<Boolean> A0;
    public static final zzfo<Long> B;
    public static final zzfo<Boolean> B0;
    public static final zzfo<Long> C;
    public static final zzfo<Boolean> C0;
    public static final zzfo<Integer> D;
    public static final zzfo<Boolean> D0;
    public static final zzfo<Long> E;
    public static final zzfo<Boolean> E0;
    public static final zzfo<Integer> F;
    public static final zzfo<Boolean> F0;
    public static final zzfo<Integer> G;
    public static final zzfo<Boolean> G0;
    public static final zzfo<Integer> H;
    public static final zzfo<Boolean> H0;
    public static final zzfo<Integer> I;
    public static final zzfo<Boolean> I0;
    public static final zzfo<Integer> J;
    public static final zzfo<Boolean> J0;
    public static final zzfo<Long> K;
    public static final zzfo<Boolean> K0;
    public static final zzfo<Boolean> L;
    public static final zzfo<Boolean> L0;
    public static final zzfo<String> M;
    public static final zzfo<Boolean> M0;
    public static final zzfo<Long> N;
    public static final zzfo<Boolean> N0;
    public static final zzfo<Integer> O;
    public static final zzfo<Boolean> O0;
    public static final zzfo<Double> P;
    public static final zzfo<Boolean> P0;
    public static final zzfo<Integer> Q;
    public static final zzfo<Boolean> Q0;
    public static final zzfo<Integer> R;
    public static final zzfo<Boolean> R0;
    public static final zzfo<Integer> S;
    public static final zzfo<Boolean> S0;
    public static final zzfo<Integer> T;
    public static final zzfo<Boolean> T0;
    public static final zzfo<Long> U;
    public static final zzfo<Boolean> U0;
    public static final zzfo<Long> V;
    public static final zzfo<Boolean> V0;
    public static final zzfo<Integer> W;
    public static final zzfo<Boolean> W0;
    public static final zzfo<Integer> X;
    public static final zzfo<Boolean> X0;
    public static final zzfo<String> Y;
    public static final zzfo<Boolean> Y0;
    public static final zzfo<String> Z;
    public static final zzfo<Boolean> Z0;

    /* renamed from: a, reason: collision with root package name */
    public static final List<zzfo<?>> f7725a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a0, reason: collision with root package name */
    public static final zzfo<String> f7726a0;

    /* renamed from: a1, reason: collision with root package name */
    public static final zzfo<Boolean> f7727a1;

    /* renamed from: b, reason: collision with root package name */
    public static final zzfo<Long> f7728b;

    /* renamed from: b0, reason: collision with root package name */
    public static final zzfo<String> f7729b0;

    /* renamed from: b1, reason: collision with root package name */
    public static final zzfo<Boolean> f7730b1;

    /* renamed from: c, reason: collision with root package name */
    public static final zzfo<Long> f7731c;

    /* renamed from: c0, reason: collision with root package name */
    public static final zzfo<String> f7732c0;

    /* renamed from: d, reason: collision with root package name */
    public static final zzfo<Long> f7733d;

    /* renamed from: d0, reason: collision with root package name */
    public static final zzfo<String> f7734d0;

    /* renamed from: e, reason: collision with root package name */
    public static final zzfo<Long> f7735e;

    /* renamed from: e0, reason: collision with root package name */
    public static final zzfo<String> f7736e0;

    /* renamed from: f, reason: collision with root package name */
    public static final zzfo<String> f7737f;

    /* renamed from: f0, reason: collision with root package name */
    public static final zzfo<Boolean> f7738f0;

    /* renamed from: g, reason: collision with root package name */
    public static final zzfo<String> f7739g;

    /* renamed from: g0, reason: collision with root package name */
    public static final zzfo<Boolean> f7740g0;

    /* renamed from: h, reason: collision with root package name */
    public static final zzfo<Integer> f7741h;

    /* renamed from: h0, reason: collision with root package name */
    public static final zzfo<Boolean> f7742h0;

    /* renamed from: i, reason: collision with root package name */
    public static final zzfo<Integer> f7743i;

    /* renamed from: i0, reason: collision with root package name */
    public static final zzfo<Boolean> f7744i0;

    /* renamed from: j, reason: collision with root package name */
    public static final zzfo<Integer> f7745j;

    /* renamed from: j0, reason: collision with root package name */
    public static final zzfo<Boolean> f7746j0;

    /* renamed from: k, reason: collision with root package name */
    public static final zzfo<Integer> f7747k;

    /* renamed from: k0, reason: collision with root package name */
    public static final zzfo<Boolean> f7748k0;

    /* renamed from: l, reason: collision with root package name */
    public static final zzfo<Integer> f7749l;

    /* renamed from: l0, reason: collision with root package name */
    public static final zzfo<Boolean> f7750l0;

    /* renamed from: m, reason: collision with root package name */
    public static final zzfo<Integer> f7751m;

    /* renamed from: m0, reason: collision with root package name */
    public static final zzfo<Boolean> f7752m0;

    /* renamed from: n, reason: collision with root package name */
    public static final zzfo<Integer> f7753n;

    /* renamed from: n0, reason: collision with root package name */
    public static final zzfo<Integer> f7754n0;

    /* renamed from: o, reason: collision with root package name */
    public static final zzfo<Integer> f7755o;

    /* renamed from: o0, reason: collision with root package name */
    public static final zzfo<Boolean> f7756o0;

    /* renamed from: p, reason: collision with root package name */
    public static final zzfo<Integer> f7757p;

    /* renamed from: p0, reason: collision with root package name */
    public static final zzfo<Boolean> f7758p0;

    /* renamed from: q, reason: collision with root package name */
    public static final zzfo<Integer> f7759q;

    /* renamed from: q0, reason: collision with root package name */
    public static final zzfo<Boolean> f7760q0;

    /* renamed from: r, reason: collision with root package name */
    public static final zzfo<String> f7761r;

    /* renamed from: r0, reason: collision with root package name */
    public static final zzfo<Boolean> f7762r0;

    /* renamed from: s, reason: collision with root package name */
    public static final zzfo<Long> f7763s;

    /* renamed from: s0, reason: collision with root package name */
    public static final zzfo<Boolean> f7764s0;

    /* renamed from: t, reason: collision with root package name */
    public static final zzfo<Long> f7765t;

    /* renamed from: t0, reason: collision with root package name */
    public static final zzfo<Boolean> f7766t0;

    /* renamed from: u, reason: collision with root package name */
    public static final zzfo<Long> f7767u;

    /* renamed from: u0, reason: collision with root package name */
    public static final zzfo<Boolean> f7768u0;

    /* renamed from: v, reason: collision with root package name */
    public static final zzfo<Long> f7769v;

    /* renamed from: v0, reason: collision with root package name */
    public static final zzfo<String> f7770v0;

    /* renamed from: w, reason: collision with root package name */
    public static final zzfo<Long> f7771w;

    /* renamed from: w0, reason: collision with root package name */
    public static final zzfo<Boolean> f7772w0;

    /* renamed from: x, reason: collision with root package name */
    public static final zzfo<Long> f7773x;

    /* renamed from: x0, reason: collision with root package name */
    public static final zzfo<Boolean> f7774x0;

    /* renamed from: y, reason: collision with root package name */
    public static final zzfo<Long> f7775y;

    /* renamed from: y0, reason: collision with root package name */
    public static final zzfo<Boolean> f7776y0;

    /* renamed from: z, reason: collision with root package name */
    public static final zzfo<Long> f7777z;

    /* renamed from: z0, reason: collision with root package name */
    public static final zzfo<Boolean> f7778z0;

    static {
        Collections.synchronizedSet(new HashSet());
        f7728b = a("measurement.ad_id_cache_time", 10000L, 10000L, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbj
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zza());
            }
        });
        Long lValueOf = Long.valueOf(DateUtils.MILLIS_PER_HOUR);
        f7731c = a("measurement.app_uninstalled_additional_ad_id_cache_time", lValueOf, lValueOf, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzce
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzb());
            }
        });
        Long lValueOf2 = Long.valueOf(DateUtils.MILLIS_PER_DAY);
        f7733d = a("measurement.monitoring.sample_period_millis", lValueOf2, lValueOf2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcq
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzp());
            }
        });
        f7735e = a("measurement.config.cache_time", lValueOf2, lValueOf, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdc
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzd());
            }
        });
        f7737f = a("measurement.config.url_scheme", "https", "https", new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdo
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return zznv.zzan();
            }
        });
        f7739g = a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", new zzfm() { // from class: com.google.android.gms.measurement.internal.zzea
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return zznv.zzam();
            }
        });
        f7741h = a("measurement.upload.max_bundles", 100, 100, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzem
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzaa());
            }
        });
        f7743i = a("measurement.upload.max_batch_size", 65536, 65536, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzey
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzai());
            }
        });
        f7745j = a("measurement.upload.max_bundle_size", 65536, 65536, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzfk
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzz());
            }
        });
        f7747k = a("measurement.upload.max_events_per_bundle", 1000, 1000, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbs
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzad());
            }
        });
        f7749l = a("measurement.upload.max_events_per_day", 100000, 100000, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbv
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzae());
            }
        });
        f7751m = a("measurement.upload.max_error_events_per_day", 1000, 1000, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbu
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzac());
            }
        });
        f7753n = a("measurement.upload.max_public_events_per_day", 50000, 50000, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbx
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzaf());
            }
        });
        Integer numValueOf = Integer.valueOf(AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
        f7755o = a("measurement.upload.max_conversions_per_day", numValueOf, numValueOf, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbw
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzab());
            }
        });
        f7757p = a("measurement.upload.max_realtime_events_per_day", 10, 10, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbz
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzah());
            }
        });
        f7759q = a("measurement.store.max_stored_events_per_app", 100000, 100000, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzby
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzi());
            }
        });
        f7761r = a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcb
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return zznv.zzav();
            }
        });
        f7763s = a("measurement.upload.backoff_period", 43200000L, 43200000L, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzca
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzw());
            }
        });
        f7765t = a("measurement.upload.window_interval", lValueOf, lValueOf, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcd
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzal());
            }
        });
        f7767u = a("measurement.upload.interval", lValueOf, lValueOf, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcf
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzy());
            }
        });
        f7769v = a("measurement.upload.realtime_upload_interval", 10000L, 10000L, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzch
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzq());
            }
        });
        f7771w = a("measurement.upload.debug_upload_interval", 1000L, 1000L, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcg
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zze());
            }
        });
        f7773x = a("measurement.upload.minimum_delay", 500L, 500L, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcj
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzo());
            }
        });
        Long lValueOf3 = Long.valueOf(DateUtils.MILLIS_PER_MINUTE);
        f7775y = a("measurement.alarm_manager.minimum_interval", lValueOf3, lValueOf3, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzci
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzn());
            }
        });
        f7777z = a("measurement.upload.stale_data_deletion_interval", lValueOf2, lValueOf2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcl
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzt());
            }
        });
        A = a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzck
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzr());
            }
        });
        B = a("measurement.upload.initial_upload_delay_time", 15000L, 15000L, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcn
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzx());
            }
        });
        C = a("measurement.upload.retry_time", 1800000L, 1800000L, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcm
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzak());
            }
        });
        D = a("measurement.upload.retry_count", 6, 6, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzco
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzaj());
            }
        });
        E = a("measurement.upload.max_queue_time", 2419200000L, 2419200000L, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcr
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzag());
            }
        });
        F = a("measurement.lifetimevalue.max_currency_tracked", 4, 4, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzct
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzf());
            }
        });
        G = a("measurement.audience.filter_result_max_count", 200, 200, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcs
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzk());
            }
        });
        H = a("measurement.upload.max_public_user_properties", 25, 25, null);
        I = a("measurement.upload.max_event_name_cardinality", 500, 500, null);
        J = a("measurement.upload.max_public_event_params", 25, 25, null);
        K = a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcv
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzs());
            }
        });
        Boolean bool = Boolean.FALSE;
        L = a("measurement.test.boolean_flag", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcu
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzps.zze());
            }
        });
        M = a("measurement.test.string_flag", "---", "---", new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcx
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return zzps.zzd();
            }
        });
        N = a("measurement.test.long_flag", -1L, -1L, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcw
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zzps.zzc());
            }
        });
        O = a("measurement.test.int_flag", -2, -2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcz
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zzps.zzb());
            }
        });
        Double dValueOf = Double.valueOf(-3.0d);
        P = a("measurement.test.double_flag", dValueOf, dValueOf, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdb
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Double.valueOf(zzps.zza());
            }
        });
        Q = a("measurement.experiment.max_ids", 50, 50, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzda
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzj());
            }
        });
        R = a("measurement.upload.max_item_scoped_custom_parameters", 27, 27, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdd
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzl());
            }
        });
        S = a("measurement.upload.max_event_parameter_value_length", 100, 100, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdf
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzh());
            }
        });
        T = a("measurement.max_bundles_per_iteration", 100, 100, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzde
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzc());
            }
        });
        U = a("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdh
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzu());
            }
        });
        V = a("measurement.redaction.app_instance_id.ttl", 7200000L, 7200000L, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdg
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Long.valueOf(zznv.zzv());
            }
        });
        W = a("measurement.rb.attribution.client.min_ad_services_version", 7, 7, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdj
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzm());
            }
        });
        X = a("measurement.dma_consent.max_daily_dcu_realtime_events", 1, 1, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdi
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zznv.zzg());
            }
        });
        Y = a("measurement.rb.attribution.uri_scheme", "https", "https", new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdk
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return zznv.zzau();
            }
        });
        Z = a("measurement.rb.attribution.uri_authority", "google-analytics.com", "google-analytics.com", new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdn
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return zznv.zzar();
            }
        });
        f7726a0 = a("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion", "privacy-sandbox/register-app-conversion", new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdm
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return zznv.zzas();
            }
        });
        f7729b0 = a("measurement.rb.attribution.app_allowlist", "com.labpixies.flood,com.sofascore.results,games.spearmint.triplecrush,com.block.juggle,io.supercent.linkedcubic,com.cdtg.gunsound,com.corestudios.storemanagementidle,com.cdgames.fidget3d,io.supercent.burgeridle,io.supercent.pizzaidle,jp.ne.ibis.ibispaintx.app,com.dencreak.dlcalculator,com.ebay.kleinanzeigen,de.wetteronline.wetterapp,com.game.shape.shift,com.champion.cubes,bubbleshooter.orig,com.wolt.android,com.master.hotelmaster,com.games.bus.arrival,com.playstrom.dop2,com.huuuge.casino.slots,com.ig.spider.fighting,com.jura.coloring.page,com.rikkogame.ragdoll2,com.ludo.king,com.sigma.prank.sound.haircut,com.crazy.block.robo.monster.cliffs.craft,com.fugo.wow,com.maps.locator.gps.gpstracker.phone,com.gamovation.tileclub,com.pronetis.ironball2,com.meesho.supply,pdf.pdfreader.viewer.editor.free,com.dino.race.master,com.ig.moto.racing,com.callapp.contacts,ai.photo.enhancer.photoclear,com.duolingo,com.candle.magic_piano,com.free.vpn.super.hotspot.open,sg.bigo.live,com.cdg.tictactoe,com.zhiliaoapp.musically.go,com.wildspike.wormszone,com.mast.status.video.edit,com.vyroai.photoeditorone,com.pujiagames.deeeersimulator,com.superbinogo.jungleboyadventure,com.trustedapp.pdfreaderpdfviewer,com.artimind.aiart.artgenerator.artavatar,de.cellular.ottohybrid", "com.labpixies.flood,com.sofascore.results,games.spearmint.triplecrush,com.block.juggle,io.supercent.linkedcubic,com.cdtg.gunsound,com.corestudios.storemanagementidle,com.cdgames.fidget3d,io.supercent.burgeridle,io.supercent.pizzaidle,jp.ne.ibis.ibispaintx.app,com.dencreak.dlcalculator,com.ebay.kleinanzeigen,de.wetteronline.wetterapp,com.game.shape.shift,com.champion.cubes,bubbleshooter.orig,com.wolt.android,com.master.hotelmaster,com.games.bus.arrival,com.playstrom.dop2,com.huuuge.casino.slots,com.ig.spider.fighting,com.jura.coloring.page,com.rikkogame.ragdoll2,com.ludo.king,com.sigma.prank.sound.haircut,com.crazy.block.robo.monster.cliffs.craft,com.fugo.wow,com.maps.locator.gps.gpstracker.phone,com.gamovation.tileclub,com.pronetis.ironball2,com.meesho.supply,pdf.pdfreader.viewer.editor.free,com.dino.race.master,com.ig.moto.racing,com.callapp.contacts,ai.photo.enhancer.photoclear,com.duolingo,com.candle.magic_piano,com.free.vpn.super.hotspot.open,sg.bigo.live,com.cdg.tictactoe,com.zhiliaoapp.musically.go,com.wildspike.wormszone,com.mast.status.video.edit,com.vyroai.photoeditorone,com.pujiagames.deeeersimulator,com.superbinogo.jungleboyadventure,com.trustedapp.pdfreaderpdfviewer,com.artimind.aiart.artgenerator.artavatar,de.cellular.ottohybrid", new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdp
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return zznv.zzap();
            }
        });
        f7732c0 = a("measurement.rb.attribution.user_properties", "_npa,npa", "_npa,npa", new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdr
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return zznv.zzaw();
            }
        });
        f7734d0 = a("measurement.rb.attribution.event_params", "value|currency", "value|currency", new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdq
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return zznv.zzao();
            }
        });
        f7736e0 = a("measurement.rb.attribution.query_parameters_to_remove", "", "", new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdt
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return zznv.zzat();
            }
        });
        Boolean bool2 = Boolean.TRUE;
        a("measurement.collection.log_event_and_bundle_v2", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzds
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpx.zza());
            }
        });
        f7738f0 = a("measurement.quality.checksum", bool, bool, null);
        f7740g0 = a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdv
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzou.zzc());
            }
        });
        f7742h0 = a("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdx
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzou.zzb());
            }
        });
        f7744i0 = a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdw
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzou.zzd());
            }
        });
        f7746j0 = a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdz
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpr.zza());
            }
        });
        f7748k0 = a("measurement.integration.disable_firebase_instance_id", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdy
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzrb.zzb());
            }
        });
        f7750l0 = a("measurement.collection.service.update_with_analytics_fix", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzeb
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzrc.zza());
            }
        });
        f7752m0 = a("measurement.client.sessions.check_on_reset_and_enable2", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzed
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpa.zzb());
            }
        });
        f7754n0 = a("measurement.service.storage_consent_support_version", 203600, 203600, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzec
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Integer.valueOf((int) zzob.zza());
            }
        });
        f7756o0 = a("measurement.service.store_null_safelist", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzef
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzoo.zzb());
            }
        });
        f7758p0 = a("measurement.service.store_safelist", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzee
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzoo.zzc());
            }
        });
        f7760q0 = a("measurement.collection.enable_session_stitching_token.first_open_fix", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzeg
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzqk.zzc());
            }
        });
        f7762r0 = a("measurement.collection.enable_session_stitching_token.client.dev", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzej
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzqk.zzb());
            }
        });
        f7764s0 = a("measurement.session_stitching_token_enabled", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzei
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzqk.zzd());
            }
        });
        a("measurement.sgtm.client.dev", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzel
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzqv.zzb());
            }
        });
        f7766t0 = a("measurement.sgtm.service", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzek
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzqv.zzd());
            }
        });
        f7768u0 = a("measurement.sgtm.preview_mode_enabled.dev", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzen
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzqv.zzc());
            }
        });
        f7770v0 = a("measurement.sgtm.app_allowlist", "", "", new zzfm() { // from class: com.google.android.gms.measurement.internal.zzep
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return zznv.zzaq();
            }
        });
        f7772w0 = a("measurement.redaction.retain_major_os_version", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzeo
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzqd.zza());
            }
        });
        a("measurement.redaction.scion_payload_generator", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzer
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzqd.zzb());
            }
        });
        f7774x0 = a("measurement.sessionid.enable_client_session_id", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzet
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzqj.zzb());
            }
        });
        f7776y0 = a("measurement.sfmc.client", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzes
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzqq.zzb());
            }
        });
        a("measurement.sfmc.service", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzev
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzqq.zzc());
            }
        });
        f7778z0 = a("measurement.gmscore_feature_tracking", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzeu
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpg.zzb());
            }
        });
        A0 = a("measurement.fix_health_monitor_stack_trace", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzex
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzoz.zzb());
            }
        });
        B0 = a("measurement.item_scoped_custom_parameters.client", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzew
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpm.zzb());
            }
        });
        C0 = a("measurement.item_scoped_custom_parameters.service", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzez
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpm.zzc());
            }
        });
        D0 = a("measurement.remove_app_background.client", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzfb
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzqe.zzb());
            }
        });
        E0 = a("measurement.rb.attribution.service", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzfa
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpy.zzf());
            }
        });
        F0 = a("measurement.rb.attribution.client2", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzfc
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpy.zzb());
            }
        });
        G0 = a("measurement.rb.attribution.uuid_generation", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzff
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpy.zzh());
            }
        });
        H0 = a("measurement.rb.attribution.enable_trigger_redaction", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzfe
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpy.zzg());
            }
        });
        a("measurement.rb.attribution.followup1.service", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzfh
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpy.zzd());
            }
        });
        I0 = a("measurement.rb.attribution.dma_fix", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzfg
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpy.zzc());
            }
        });
        J0 = a("measurement.rb.attribution.index_out_of_bounds_fix", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzfj
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpy.zze());
            }
        });
        K0 = a("measurement.client.sessions.enable_fix_background_engagement", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzfi
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                return Boolean.valueOf(zzqp.zza());
            }
        });
        L0 = a("measurement.dma_consent.client", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzfl
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzon.zzb());
            }
        });
        M0 = a("measurement.dma_consent.service", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzfn
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzon.zzd());
            }
        });
        N0 = a("measurement.dma_consent.client_bow_check2", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbl
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzon.zzc());
            }
        });
        O0 = a("measurement.dma_consent.service_npa_remote_default", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbk
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzon.zzf());
            }
        });
        P0 = a("measurement.dma_consent.service_split_batch_on_consent", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbn
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzon.zzg());
            }
        });
        Q0 = a("measurement.dma_consent.service_dcu_event", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbm
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzon.zze());
            }
        });
        R0 = a("measurement.service.deferred_first_open", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbp
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzoh.zzb());
            }
        });
        S0 = a("measurement.gbraid_campaign.gbraid.client.dev", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbo
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpf.zzb());
            }
        });
        a("measurement.gbraid_campaign.gbraid.service", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbr
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpf.zzc());
            }
        });
        T0 = a("measurement.increase_param_lengths", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbq
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzpl.zzb());
            }
        });
        U0 = a("measurement.disable_npa_for_dasher_and_unicorn", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbt
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzoi.zzb());
            }
        });
        V0 = a("measurement.tcf.client", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcc
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzqw.zzb());
            }
        });
        W0 = a("measurement.tcf.service", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcp
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzqw.zzc());
            }
        });
        X0 = a("measurement.consent_regional_defaults.service", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzcy
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zznw.zzc());
            }
        });
        Y0 = a("measurement.consent_regional_defaults.client", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdl
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zznw.zzb());
            }
        });
        Z0 = a("measurement.service.consent.aiid_reset_fix", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzdu
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzot.zza());
            }
        });
        f7727a1 = a("measurement.service.consent.pfo_on_fx", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzeh
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzot.zzc());
            }
        });
        f7730b1 = a("measurement.service.consent.app_start_fix", bool2, bool2, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzeq
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzot.zzb());
            }
        });
        a("measurement.consent.stop_reset_on_ads_storage_denied.client.dev", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzfd
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzoc.zza());
            }
        });
        a("measurement.consent.stop_reset_on_ads_storage_denied.service", bool, bool, new zzfm() { // from class: com.google.android.gms.measurement.internal.zzbi
            @Override // com.google.android.gms.measurement.internal.zzfm
            public final Object zza() {
                List<zzfo<?>> list = zzbh.f7725a;
                return Boolean.valueOf(zzoc.zzb());
            }
        });
    }

    public static <V> zzfo<V> a(String str, V v10, V v11, zzfm<V> zzfmVar) {
        zzfo<V> zzfoVar = new zzfo<>(str, v10, v11, zzfmVar);
        f7725a.add(zzfoVar);
        return zzfoVar;
    }

    public static Map<String, String> zza(Context context) {
        com.google.android.gms.internal.measurement.zzgr zzgrVarZza = com.google.android.gms.internal.measurement.zzgr.zza(context.getContentResolver(), com.google.android.gms.internal.measurement.zzhh.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbg
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.internal.measurement.zzhg.zzc();
            }
        });
        return zzgrVarZza == null ? Collections.emptyMap() : zzgrVarZza.zza();
    }
}
