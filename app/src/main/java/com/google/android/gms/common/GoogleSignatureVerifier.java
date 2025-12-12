package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.RestrictedInheritance;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes.dex */
public class GoogleSignatureVerifier {

    /* renamed from: c, reason: collision with root package name */
    public static GoogleSignatureVerifier f7035c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f7036a;

    /* renamed from: b, reason: collision with root package name */
    public volatile String f7037b;

    public GoogleSignatureVerifier(Context context) {
        this.f7036a = context.getApplicationContext();
    }

    public static final zzj a(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i10 = 0; i10 < zzjVarArr.length; i10++) {
                if (zzjVarArr[i10].equals(zzkVar)) {
                    return zzjVarArr[i10];
                }
            }
        }
        return null;
    }

    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (f7035c == null) {
                zzn.a(context);
                f7035c = new GoogleSignatureVerifier(context);
            }
        }
        return f7035c;
    }

    public static final boolean zzb(PackageInfo packageInfo, boolean z10) {
        PackageInfo packageInfo2;
        if (!z10) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z10 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z10 ? a(packageInfo2, zzm.f7531a) : a(packageInfo2, zzm.f7531a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.f7036a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x0162  */
    /* JADX WARN: Type inference failed for: r11v1, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isUidGoogleSigned(int r21) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.isUidGoogleSigned(int):boolean");
    }
}
