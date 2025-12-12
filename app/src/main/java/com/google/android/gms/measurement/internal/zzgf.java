package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzgf {

    /* renamed from: a, reason: collision with root package name */
    public final String f7972a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7973b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7974c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f7975d;

    public zzgf(String str, String str2, Bundle bundle, long j10) {
        this.f7972a = str;
        this.f7973b = str2;
        this.f7975d = bundle == null ? new Bundle() : bundle;
        this.f7974c = j10;
    }

    public final String toString() {
        return "origin=" + this.f7973b + ",name=" + this.f7972a + ",params=" + String.valueOf(this.f7975d);
    }

    public final zzbf zza() {
        return new zzbf(this.f7972a, new zzba(new Bundle(this.f7975d)), this.f7973b, this.f7974c);
    }

    public static zzgf zza(zzbf zzbfVar) {
        return new zzgf(zzbfVar.f7720b, zzbfVar.f7722n, zzbfVar.f7721m.zzb(), zzbfVar.f7723o);
    }
}
