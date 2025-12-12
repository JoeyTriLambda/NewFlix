package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzhy implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzac f8146b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzhs f8147m;

    public zzhy(zzhs zzhsVar, zzac zzacVar) {
        this.f8146b = zzacVar;
        this.f8147m = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzhs zzhsVar = this.f8147m;
        zzhsVar.f8127a.J();
        zzac zzacVar = this.f8146b;
        if (zzacVar.f7629n.zza() == null) {
            zznd zzndVar = zzhsVar.f8127a;
            zzndVar.getClass();
            zzn zznVarC = zzndVar.C((String) Preconditions.checkNotNull(zzacVar.f7627b));
            if (zznVarC != null) {
                zzndVar.j(zzacVar, zznVarC);
                return;
            }
            return;
        }
        zznd zzndVar2 = zzhsVar.f8127a;
        zzndVar2.getClass();
        zzn zznVarC2 = zzndVar2.C((String) Preconditions.checkNotNull(zzacVar.f7627b));
        if (zznVarC2 != null) {
            zzndVar2.z(zzacVar, zznVarC2);
        }
    }
}
