package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzho;
import com.google.android.gms.measurement.internal.zziy;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzb extends AppMeasurement.zza {

    /* renamed from: a, reason: collision with root package name */
    public final zzho f8634a;

    /* renamed from: b, reason: collision with root package name */
    public final zziy f8635b;

    public zzb(zzho zzhoVar) {
        super(0);
        Preconditions.checkNotNull(zzhoVar);
        this.f8634a = zzhoVar;
        this.f8635b = zzhoVar.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final int zza(String str) {
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final void zzb(String str) throws IllegalStateException {
        zzho zzhoVar = this.f8634a;
        zzhoVar.zze().zza(str, zzhoVar.zzb().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final void zzc(String str) throws IllegalStateException {
        zzho zzhoVar = this.f8634a;
        zzhoVar.zze().zzb(str, zzhoVar.zzb().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final long zzf() {
        return this.f8634a.zzt().zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final String zzg() {
        return this.f8635b.zzae();
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final String zzh() {
        return this.f8635b.zzaf();
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final String zzi() {
        return this.f8635b.zzag();
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final String zzj() {
        return this.f8635b.zzae();
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final List<Bundle> zza(String str, String str2) {
        return this.f8635b.zza(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final Map<String, Object> zza(String str, String str2, boolean z10) {
        return this.f8635b.zza(str, str2, z10);
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final void zzb(String str, String str2, Bundle bundle) throws IllegalStateException {
        this.f8635b.zzb(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final void zza(String str, String str2, Bundle bundle) throws IllegalStateException {
        this.f8634a.zzp().zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final void zza(Bundle bundle) throws IllegalStateException {
        this.f8635b.zzb(bundle);
    }
}
