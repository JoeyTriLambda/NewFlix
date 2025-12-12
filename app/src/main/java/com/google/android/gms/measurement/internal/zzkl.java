package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzkl implements Application.ActivityLifecycleCallbacks {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zziy f8341b;

    public zzkl(zziy zziyVar) {
        this.f8341b = zziyVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onActivityCreated(android.app.Activity r10, android.os.Bundle r11) {
        /*
            r9 = this;
            com.google.android.gms.measurement.internal.zziy r0 = r9.f8341b
            com.google.android.gms.measurement.internal.zzgb r1 = r0.zzj()     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzp()     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            java.lang.String r2 = "onActivityCreated"
            r1.zza(r2)     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            android.content.Intent r1 = r10.getIntent()     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            if (r1 != 0) goto L1d
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzn()
            r0.zza(r10, r11)
            return
        L1d:
            android.net.Uri r2 = r1.getData()     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            if (r2 == 0) goto L2a
            boolean r3 = r2.isHierarchical()     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            if (r3 == 0) goto L2a
            goto L42
        L2a:
            android.os.Bundle r2 = r1.getExtras()     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            if (r2 == 0) goto L41
            java.lang.String r3 = "com.android.vending.referral_url"
            java.lang.String r2 = r2.getString(r3)     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            if (r3 != 0) goto L41
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            goto L42
        L41:
            r2 = 0
        L42:
            r6 = r2
            if (r6 == 0) goto L7e
            boolean r2 = r6.isHierarchical()     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            if (r2 != 0) goto L4c
            goto L7e
        L4c:
            r0.zzq()     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            boolean r1 = com.google.android.gms.measurement.internal.zznt.r(r1)     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            if (r1 == 0) goto L58
            java.lang.String r1 = "gs"
            goto L5a
        L58:
            java.lang.String r1 = "auto"
        L5a:
            r7 = r1
            java.lang.String r1 = "referrer"
            java.lang.String r8 = r6.getQueryParameter(r1)     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            if (r11 != 0) goto L66
            r1 = 1
            r5 = 1
            goto L68
        L66:
            r1 = 0
            r5 = 0
        L68:
            com.google.android.gms.measurement.internal.zzhh r1 = r0.zzl()     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            com.google.android.gms.measurement.internal.zzkk r2 = new com.google.android.gms.measurement.internal.zzkk     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            r3 = r2
            r4 = r9
            r3.<init>(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            r1.zzb(r2)     // Catch: java.lang.Throwable -> L86 java.lang.RuntimeException -> L88
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzn()
            r0.zza(r10, r11)
            return
        L7e:
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzn()
            r0.zza(r10, r11)
            return
        L86:
            r1 = move-exception
            goto L9e
        L88:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzgb r2 = r0.zzj()     // Catch: java.lang.Throwable -> L86
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzg()     // Catch: java.lang.Throwable -> L86
            java.lang.String r3 = "Throwable caught in onActivityCreated"
            r2.zza(r3, r1)     // Catch: java.lang.Throwable -> L86
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzn()
            r0.zza(r10, r11)
            return
        L9e:
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzn()
            r0.zza(r10, r11)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.f8341b.zzn().zza(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) throws IllegalStateException {
        zziy zziyVar = this.f8341b;
        zziyVar.zzn().zzb(activity);
        zzmi zzmiVarZzp = zziyVar.zzp();
        zzmiVarZzp.zzl().zzb(new zzmk(zzmiVarZzp, zzmiVarZzp.zzb().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) throws IllegalStateException {
        zziy zziyVar = this.f8341b;
        zzmi zzmiVarZzp = zziyVar.zzp();
        zzmiVarZzp.zzl().zzb(new zzml(zzmiVarZzp, zzmiVarZzp.zzb().elapsedRealtime()));
        zziyVar.zzn().zzc(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f8341b.zzn().zzb(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
