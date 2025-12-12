package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzgq {

    /* renamed from: a, reason: collision with root package name */
    public final String f8026a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8027b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8028c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8029d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzgm f8030e;

    public zzgq(zzgm zzgmVar, long j10) {
        this.f8030e = zzgmVar;
        Preconditions.checkNotEmpty("health_monitor");
        Preconditions.checkArgument(j10 > 0);
        this.f8026a = "health_monitor:start";
        this.f8027b = "health_monitor:count";
        this.f8028c = "health_monitor:value";
        this.f8029d = j10;
    }

    public final void a() {
        zzgm zzgmVar = this.f8030e;
        zzgmVar.zzt();
        long jCurrentTimeMillis = zzgmVar.zzb().currentTimeMillis();
        SharedPreferences.Editor editorEdit = zzgmVar.zzg().edit();
        editorEdit.remove(this.f8027b);
        editorEdit.remove(this.f8028c);
        editorEdit.putLong(this.f8026a, jCurrentTimeMillis);
        editorEdit.apply();
    }

    public final Pair<String, Long> zza() {
        long jAbs;
        zzgm zzgmVar = this.f8030e;
        zzgmVar.zzt();
        zzgmVar.zzt();
        long j10 = zzgmVar.zzg().getLong(this.f8026a, 0L);
        if (j10 == 0) {
            a();
            jAbs = 0;
        } else {
            jAbs = Math.abs(j10 - zzgmVar.zzb().currentTimeMillis());
        }
        long j11 = this.f8029d;
        if (jAbs < j11) {
            return null;
        }
        if (jAbs > (j11 << 1)) {
            a();
            return null;
        }
        String string = zzgmVar.zzg().getString(this.f8028c, null);
        long j12 = zzgmVar.zzg().getLong(this.f8027b, 0L);
        a();
        return (string == null || j12 <= 0) ? zzgm.A : new Pair<>(string, Long.valueOf(j12));
    }

    public final void zza(String str, long j10) {
        zzgm zzgmVar = this.f8030e;
        zzgmVar.zzt();
        if (zzgmVar.zzg().getLong(this.f8026a, 0L) == 0) {
            a();
        }
        if (str == null) {
            str = "";
        }
        SharedPreferences sharedPreferencesZzg = zzgmVar.zzg();
        String str2 = this.f8027b;
        long j11 = sharedPreferencesZzg.getLong(str2, 0L);
        String str3 = this.f8028c;
        if (j11 <= 0) {
            SharedPreferences.Editor editorEdit = zzgmVar.zzg().edit();
            editorEdit.putString(str3, str);
            editorEdit.putLong(str2, 1L);
            editorEdit.apply();
            return;
        }
        long j12 = j11 + 1;
        boolean z10 = (zzgmVar.zzq().T().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j12;
        SharedPreferences.Editor editorEdit2 = zzgmVar.zzg().edit();
        if (z10) {
            editorEdit2.putString(str3, str);
        }
        editorEdit2.putLong(str2, j12);
        editorEdit2.apply();
    }
}
