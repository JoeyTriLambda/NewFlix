package com.google.android.gms.measurement.internal;

import b0.b;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzc implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7797b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f7798m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zza f7799n;

    public zzc(zza zzaVar, String str, long j10) {
        this.f7797b = str;
        this.f7798m = j10;
        this.f7799n = zzaVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zza zzaVar = this.f7799n;
        zzaVar.zzt();
        String str = this.f7797b;
        Preconditions.checkNotEmpty(str);
        b bVar = zzaVar.f7617c;
        boolean zIsEmpty = bVar.isEmpty();
        long j10 = this.f7798m;
        if (zIsEmpty) {
            zzaVar.f7618d = j10;
        }
        Integer num = (Integer) bVar.get(str);
        if (num != null) {
            bVar.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (bVar.size() >= 100) {
            zzaVar.zzj().zzu().zza("Too many ads visible");
        } else {
            bVar.put(str, 1);
            zzaVar.f7616b.put(str, Long.valueOf(j10));
        }
    }
}
