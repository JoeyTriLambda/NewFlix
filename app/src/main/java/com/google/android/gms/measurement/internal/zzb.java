package com.google.android.gms.measurement.internal;

import b0.b;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzb implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7704b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f7705m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zza f7706n;

    public zzb(zza zzaVar, String str, long j10) {
        this.f7704b = str;
        this.f7705m = j10;
        this.f7706n = zzaVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zza zzaVar = this.f7706n;
        zzaVar.zzt();
        String str = this.f7704b;
        Preconditions.checkNotEmpty(str);
        b bVar = zzaVar.f7617c;
        Integer num = (Integer) bVar.get(str);
        if (num == null) {
            zzaVar.zzj().zzg().zza("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        zzks zzksVarZza = zzaVar.zzn().zza(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            bVar.put(str, Integer.valueOf(iIntValue));
            return;
        }
        bVar.remove(str);
        b bVar2 = zzaVar.f7616b;
        Long l10 = (Long) bVar2.get(str);
        long j10 = this.f7705m;
        if (l10 == null) {
            zzaVar.zzj().zzg().zza("First ad unit exposure time was never set");
        } else {
            long jLongValue = j10 - l10.longValue();
            bVar2.remove(str);
            zzaVar.b(str, jLongValue, zzksVarZza);
        }
        if (bVar.isEmpty()) {
            long j11 = zzaVar.f7618d;
            if (j11 == 0) {
                zzaVar.zzj().zzg().zza("First ad exposure time was never set");
            } else {
                zzaVar.a(j10 - j11, zzksVarZza);
                zzaVar.f7618d = 0L;
            }
        }
    }
}
