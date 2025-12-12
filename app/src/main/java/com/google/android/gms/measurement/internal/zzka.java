package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzka implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzdi f8307b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zziy f8308m;

    public zzka(zziy zziyVar, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.f8307b = zzdiVar;
        this.f8308m = zziyVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.IllegalStateException {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zziy r0 = r8.f8308m
            com.google.android.gms.measurement.internal.zzmi r1 = r0.zzp()
            boolean r2 = com.google.android.gms.internal.measurement.zzqj.zza()
            r3 = 0
            if (r2 == 0) goto L67
            com.google.android.gms.measurement.internal.zzae r2 = r1.zze()
            com.google.android.gms.measurement.internal.zzfo<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzbh.f7774x0
            boolean r2 = r2.zza(r4)
            if (r2 == 0) goto L67
            com.google.android.gms.measurement.internal.zzgm r2 = r1.zzk()
            com.google.android.gms.measurement.internal.zziq r2 = r2.e()
            boolean r2 = r2.zzj()
            if (r2 != 0) goto L35
            com.google.android.gms.measurement.internal.zzgb r1 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzv()
            java.lang.String r2 = "Analytics storage consent denied; will not get session id"
            r1.zza(r2)
            goto L74
        L35:
            com.google.android.gms.measurement.internal.zzgm r2 = r1.zzk()
            com.google.android.gms.common.util.Clock r4 = r1.zzb()
            long r4 = r4.currentTimeMillis()
            boolean r2 = r2.a(r4)
            if (r2 != 0) goto L74
            com.google.android.gms.measurement.internal.zzgm r2 = r1.zzk()
            com.google.android.gms.measurement.internal.zzgr r2 = r2.f8007r
            long r4 = r2.zza()
            r6 = 0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L58
            goto L74
        L58:
            com.google.android.gms.measurement.internal.zzgm r1 = r1.zzk()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.f8007r
            long r1 = r1.zza()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            goto L75
        L67:
            com.google.android.gms.measurement.internal.zzgb r1 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzv()
            java.lang.String r2 = "getSessionId has been disabled."
            r1.zza(r2)
        L74:
            r1 = r3
        L75:
            com.google.android.gms.internal.measurement.zzdi r2 = r8.f8307b
            if (r1 == 0) goto L87
            com.google.android.gms.measurement.internal.zzho r0 = r0.f8189a
            com.google.android.gms.measurement.internal.zznt r0 = r0.zzt()
            long r3 = r1.longValue()
            r0.zza(r2, r3)
            return
        L87:
            r2.zza(r3)     // Catch: android.os.RemoteException -> L8b
            return
        L8b:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzho r0 = r0.f8189a
            com.google.android.gms.measurement.internal.zzgb r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzg()
            java.lang.String r2 = "getSessionId failed with exception"
            r0.zza(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzka.run():void");
    }
}
