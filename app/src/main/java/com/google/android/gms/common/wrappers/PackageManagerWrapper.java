package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class PackageManagerWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7519a;

    public PackageManagerWrapper(Context context) {
        this.f7519a = context;
    }

    @KeepForSdk
    public int checkCallingOrSelfPermission(String str) {
        return this.f7519a.checkCallingOrSelfPermission(str);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public ApplicationInfo getApplicationInfo(String str, int i10) throws PackageManager.NameNotFoundException {
        return this.f7519a.getPackageManager().getApplicationInfo(str, i10);
    }

    @KeepForSdk
    public CharSequence getApplicationLabel(String str) throws PackageManager.NameNotFoundException {
        Context context = this.f7519a;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public PackageInfo getPackageInfo(String str, int i10) throws PackageManager.NameNotFoundException {
        return this.f7519a.getPackageManager().getPackageInfo(str, i10);
    }

    @KeepForSdk
    public boolean isCallerInstantApp() {
        String nameForUid;
        int callingUid = Binder.getCallingUid();
        int iMyUid = Process.myUid();
        Context context = this.f7519a;
        if (callingUid == iMyUid) {
            return InstantApps.isInstantApp(context);
        }
        if (!PlatformVersion.isAtLeastO() || (nameForUid = context.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return context.getPackageManager().isInstantApp(nameForUid);
    }

    @TargetApi(19)
    public final boolean zza(int i10, String str) {
        boolean zIsAtLeastKitKat = PlatformVersion.isAtLeastKitKat();
        Context context = this.f7519a;
        if (zIsAtLeastKitKat) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                if (appOpsManager == null) {
                    throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
                }
                appOpsManager.checkPackage(i10, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i10);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
