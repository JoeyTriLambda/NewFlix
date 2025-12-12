package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzf {
    public long A;
    public String B;
    public int C;
    public int D;
    public long E;
    public String F;
    public long G;
    public long H;
    public long I;
    public long J;
    public long K;
    public long L;
    public String M;
    public boolean N;
    public long O;
    public long P;

    /* renamed from: a, reason: collision with root package name */
    public final zzho f7880a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7881b;

    /* renamed from: c, reason: collision with root package name */
    public String f7882c;

    /* renamed from: d, reason: collision with root package name */
    public String f7883d;

    /* renamed from: e, reason: collision with root package name */
    public String f7884e;

    /* renamed from: f, reason: collision with root package name */
    public String f7885f;

    /* renamed from: g, reason: collision with root package name */
    public long f7886g;

    /* renamed from: h, reason: collision with root package name */
    public long f7887h;

    /* renamed from: i, reason: collision with root package name */
    public long f7888i;

    /* renamed from: j, reason: collision with root package name */
    public String f7889j;

    /* renamed from: k, reason: collision with root package name */
    public long f7890k;

    /* renamed from: l, reason: collision with root package name */
    public String f7891l;

    /* renamed from: m, reason: collision with root package name */
    public long f7892m;

    /* renamed from: n, reason: collision with root package name */
    public long f7893n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f7894o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f7895p;

    /* renamed from: q, reason: collision with root package name */
    public String f7896q;

    /* renamed from: r, reason: collision with root package name */
    public Boolean f7897r;

    /* renamed from: s, reason: collision with root package name */
    public long f7898s;

    /* renamed from: t, reason: collision with root package name */
    public ArrayList f7899t;

    /* renamed from: u, reason: collision with root package name */
    public String f7900u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f7901v;

    /* renamed from: w, reason: collision with root package name */
    public long f7902w;

    /* renamed from: x, reason: collision with root package name */
    public long f7903x;

    /* renamed from: y, reason: collision with root package name */
    public int f7904y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f7905z;

    public zzf(zzho zzhoVar, String str) {
        Preconditions.checkNotNull(zzhoVar);
        Preconditions.checkNotEmpty(str);
        this.f7880a = zzhoVar;
        this.f7881b = str;
        zzhoVar.zzl().zzt();
    }

    public final int zza() {
        this.f7880a.zzl().zzt();
        return this.f7904y;
    }

    public final String zzaa() {
        this.f7880a.zzl().zzt();
        return this.f7881b;
    }

    public final String zzab() {
        this.f7880a.zzl().zzt();
        return this.f7882c;
    }

    public final String zzac() {
        this.f7880a.zzl().zzt();
        return this.f7891l;
    }

    public final String zzad() {
        this.f7880a.zzl().zzt();
        return this.f7889j;
    }

    public final String zzae() {
        this.f7880a.zzl().zzt();
        return this.f7885f;
    }

    public final String zzaf() {
        this.f7880a.zzl().zzt();
        return this.f7883d;
    }

    public final String zzag() {
        this.f7880a.zzl().zzt();
        return this.M;
    }

    public final String zzah() {
        this.f7880a.zzl().zzt();
        return this.f7884e;
    }

    public final String zzai() {
        this.f7880a.zzl().zzt();
        return this.F;
    }

    public final String zzaj() {
        this.f7880a.zzl().zzt();
        return this.f7900u;
    }

    public final String zzak() {
        this.f7880a.zzl().zzt();
        return this.B;
    }

    public final List<String> zzal() {
        this.f7880a.zzl().zzt();
        return this.f7899t;
    }

    public final void zzam() {
        this.f7880a.zzl().zzt();
        this.N = false;
    }

    public final void zzan() throws IllegalStateException {
        zzho zzhoVar = this.f7880a;
        zzhoVar.zzl().zzt();
        long j10 = this.f7886g + 1;
        if (j10 > 2147483647L) {
            zzhoVar.zzj().zzu().zza("Bundle index overflow. appId", zzgb.zza(this.f7881b));
            j10 = 0;
        }
        this.N = true;
        this.f7886g = j10;
    }

    public final boolean zzao() {
        this.f7880a.zzl().zzt();
        return this.f7895p;
    }

    public final boolean zzap() {
        this.f7880a.zzl().zzt();
        return this.f7894o;
    }

    public final boolean zzaq() {
        this.f7880a.zzl().zzt();
        return this.N;
    }

    public final boolean zzar() {
        this.f7880a.zzl().zzt();
        return this.f7901v;
    }

    public final boolean zzas() {
        this.f7880a.zzl().zzt();
        return this.f7905z;
    }

    public final int zzb() {
        this.f7880a.zzl().zzt();
        return this.D;
    }

    public final int zzc() {
        this.f7880a.zzl().zzt();
        return this.C;
    }

    public final long zzd() {
        this.f7880a.zzl().zzt();
        return 0L;
    }

    public final long zze() {
        this.f7880a.zzl().zzt();
        return this.f7890k;
    }

    public final long zzf() {
        this.f7880a.zzl().zzt();
        return this.A;
    }

    public final long zzg() {
        this.f7880a.zzl().zzt();
        return this.O;
    }

    public final long zzh() {
        this.f7880a.zzl().zzt();
        return this.J;
    }

    public final long zzi() {
        this.f7880a.zzl().zzt();
        return this.K;
    }

    public final long zzj() {
        this.f7880a.zzl().zzt();
        return this.I;
    }

    public final long zzk() {
        this.f7880a.zzl().zzt();
        return this.H;
    }

    public final long zzl() {
        this.f7880a.zzl().zzt();
        return this.L;
    }

    public final long zzm() {
        this.f7880a.zzl().zzt();
        return this.G;
    }

    public final long zzn() {
        this.f7880a.zzl().zzt();
        return this.f7893n;
    }

    public final long zzo() {
        this.f7880a.zzl().zzt();
        return this.f7898s;
    }

    public final long zzp() {
        this.f7880a.zzl().zzt();
        return this.P;
    }

    public final long zzq() {
        this.f7880a.zzl().zzt();
        return this.f7892m;
    }

    public final long zzr() {
        this.f7880a.zzl().zzt();
        return this.E;
    }

    public final long zzs() {
        this.f7880a.zzl().zzt();
        return this.f7888i;
    }

    public final long zzt() {
        this.f7880a.zzl().zzt();
        return this.f7886g;
    }

    public final long zzu() {
        this.f7880a.zzl().zzt();
        return this.f7887h;
    }

    public final long zzv() {
        this.f7880a.zzl().zzt();
        return this.f7903x;
    }

    public final long zzw() {
        this.f7880a.zzl().zzt();
        return this.f7902w;
    }

    public final Boolean zzx() {
        this.f7880a.zzl().zzt();
        return this.f7897r;
    }

    public final String zzy() {
        this.f7880a.zzl().zzt();
        return this.f7896q;
    }

    public final String zzz() {
        this.f7880a.zzl().zzt();
        String str = this.M;
        zzg((String) null);
        return str;
    }

    public final void zzd(String str) {
        this.f7880a.zzl().zzt();
        this.N |= !Objects.equals(this.f7889j, str);
        this.f7889j = str;
    }

    public final void zza(long j10) throws IllegalStateException {
        zzho zzhoVar = this.f7880a;
        zzhoVar.zzl().zzt();
        long j11 = this.f7886g + j10;
        String str = this.f7881b;
        if (j11 > 2147483647L) {
            zzhoVar.zzj().zzu().zza("Bundle index overflow. appId", zzgb.zza(str));
            j11 = j10 - 1;
        }
        long j12 = this.E + 1;
        if (j12 > 2147483647L) {
            zzhoVar.zzj().zzu().zza("Delivery index overflow. appId", zzgb.zza(str));
            j12 = 0;
        }
        this.N = true;
        this.f7886g = j11;
        this.E = j12;
    }

    public final void zzb(String str) {
        this.f7880a.zzl().zzt();
        this.N |= !Objects.equals(this.f7882c, str);
        this.f7882c = str;
    }

    public final void zzc(String str) {
        this.f7880a.zzl().zzt();
        this.N |= !Objects.equals(this.f7891l, str);
        this.f7891l = str;
    }

    public final void zze(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.J != j10;
        this.J = j10;
    }

    public final void zzf(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.K != j10;
        this.K = j10;
    }

    public final void zzg(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.I != j10;
        this.I = j10;
    }

    public final void zzh(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.H != j10;
        this.H = j10;
    }

    public final void zzi(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.L != j10;
        this.L = j10;
    }

    public final void zzj(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.G != j10;
        this.G = j10;
    }

    public final void zzk(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.f7893n != j10;
        this.f7893n = j10;
    }

    public final void zzl(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.f7898s != j10;
        this.f7898s = j10;
    }

    public final void zzm(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.P != j10;
        this.P = j10;
    }

    public final void zzn(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.f7892m != j10;
        this.f7892m = j10;
    }

    public final void zzo(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.E != j10;
        this.E = j10;
    }

    public final void zzp(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.f7888i != j10;
        this.f7888i = j10;
    }

    public final void zzq(long j10) {
        Preconditions.checkArgument(j10 >= 0);
        this.f7880a.zzl().zzt();
        this.N |= this.f7886g != j10;
        this.f7886g = j10;
    }

    public final void zzr(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.f7887h != j10;
        this.f7887h = j10;
    }

    public final void zzs(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.f7903x != j10;
        this.f7903x = j10;
    }

    public final void zzt(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.f7902w != j10;
        this.f7902w = j10;
    }

    public final void zzd(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.O != j10;
        this.O = j10;
    }

    public final void zzb(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.f7890k != j10;
        this.f7890k = j10;
    }

    public final void zzc(long j10) {
        this.f7880a.zzl().zzt();
        this.N |= this.A != j10;
        this.A = j10;
    }

    public final void zze(String str) {
        this.f7880a.zzl().zzt();
        this.N |= !Objects.equals(this.f7885f, str);
        this.f7885f = str;
    }

    public final void zzf(String str) {
        this.f7880a.zzl().zzt();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.N |= !Objects.equals(this.f7883d, str);
        this.f7883d = str;
    }

    public final void zzg(String str) {
        this.f7880a.zzl().zzt();
        this.N |= !Objects.equals(this.M, str);
        this.M = str;
    }

    public final void zzh(String str) {
        this.f7880a.zzl().zzt();
        this.N |= !Objects.equals(this.f7884e, str);
        this.f7884e = str;
    }

    public final void zzi(String str) {
        this.f7880a.zzl().zzt();
        this.N |= this.F != str;
        this.F = str;
    }

    public final void zzj(String str) {
        this.f7880a.zzl().zzt();
        this.N |= !Objects.equals(this.f7900u, str);
        this.f7900u = str;
    }

    public final void zzk(String str) {
        this.f7880a.zzl().zzt();
        this.N |= this.B != str;
        this.B = str;
    }

    public final void zzd(boolean z10) {
        this.f7880a.zzl().zzt();
        this.N |= this.f7905z != z10;
        this.f7905z = z10;
    }

    public final void zzb(int i10) {
        this.f7880a.zzl().zzt();
        this.N |= this.D != i10;
        this.D = i10;
    }

    public final void zzc(int i10) {
        this.f7880a.zzl().zzt();
        this.N |= this.C != i10;
        this.C = i10;
    }

    public final void zza(String str) {
        this.f7880a.zzl().zzt();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.N |= !Objects.equals(this.f7896q, str);
        this.f7896q = str;
    }

    public final void zzb(boolean z10) {
        this.f7880a.zzl().zzt();
        this.N |= this.f7894o != z10;
        this.f7894o = z10;
    }

    public final void zzc(boolean z10) {
        this.f7880a.zzl().zzt();
        this.N |= this.f7901v != z10;
        this.f7901v = z10;
    }

    public final void zza(int i10) {
        this.f7880a.zzl().zzt();
        this.N |= this.f7904y != i10;
        this.f7904y = i10;
    }

    public final void zza(boolean z10) {
        this.f7880a.zzl().zzt();
        this.N |= this.f7895p != z10;
        this.f7895p = z10;
    }

    public final void zza(Boolean bool) {
        this.f7880a.zzl().zzt();
        this.N |= !Objects.equals(this.f7897r, bool);
        this.f7897r = bool;
    }

    public final void zza(List<String> list) {
        this.f7880a.zzl().zzt();
        if (Objects.equals(this.f7899t, list)) {
            return;
        }
        this.N = true;
        this.f7899t = list != null ? new ArrayList(list) : null;
    }
}
