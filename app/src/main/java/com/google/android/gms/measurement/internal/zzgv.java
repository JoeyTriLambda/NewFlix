package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzgv {

    /* renamed from: a, reason: collision with root package name */
    public final zzho f8042a;

    public zzgv(zznd zzndVar) {
        this.f8042a = zzndVar.f8555l;
    }

    public final boolean a() throws IllegalStateException {
        zzho zzhoVar = this.f8042a;
        try {
            PackageManagerWrapper packageManagerWrapperPackageManager = Wrappers.packageManager(zzhoVar.zza());
            if (packageManagerWrapperPackageManager != null) {
                return packageManagerWrapperPackageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            zzhoVar.zzj().zzp().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e10) {
            zzhoVar.zzj().zzp().zza("Failed to retrieve Play Store version for Install Referrer", e10);
            return false;
        }
    }
}
