package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zziw {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8218a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8219b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8220c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8221d;

    /* renamed from: e, reason: collision with root package name */
    public final Boolean f8222e;

    /* renamed from: f, reason: collision with root package name */
    public final long f8223f;

    /* renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.zzdq f8224g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f8225h;

    /* renamed from: i, reason: collision with root package name */
    public final Long f8226i;

    /* renamed from: j, reason: collision with root package name */
    public final String f8227j;

    public zziw(Context context, com.google.android.gms.internal.measurement.zzdq zzdqVar, Long l10) {
        this.f8225h = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.f8218a = applicationContext;
        this.f8226i = l10;
        if (zzdqVar != null) {
            this.f8224g = zzdqVar;
            this.f8219b = zzdqVar.zzf;
            this.f8220c = zzdqVar.zze;
            this.f8221d = zzdqVar.zzd;
            this.f8225h = zzdqVar.zzc;
            this.f8223f = zzdqVar.zzb;
            this.f8227j = zzdqVar.zzh;
            Bundle bundle = zzdqVar.zzg;
            if (bundle != null) {
                this.f8222e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
