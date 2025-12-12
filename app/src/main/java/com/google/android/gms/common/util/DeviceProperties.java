package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.apps.common.proguard.SideEffectFree;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public final class DeviceProperties {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f7501a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f7502b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f7503c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f7504d;

    private DeviceProperties() {
    }

    @KeepForSdk
    public static boolean isAuto(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f7504d == null) {
            boolean z10 = false;
            if (PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z10 = true;
            }
            f7504d = Boolean.valueOf(z10);
        }
        return f7504d.booleanValue();
    }

    @KeepForSdk
    public static boolean isUserBuild() {
        AtomicBoolean atomicBoolean = GooglePlayServicesUtilLight.f7031a;
        return "user".equals(Build.TYPE);
    }

    @SideEffectFree
    @KeepForSdk
    @TargetApi(20)
    public static boolean isWearable(Context context) {
        return zzd(context.getPackageManager());
    }

    @KeepForSdk
    @TargetApi(26)
    public static boolean isWearableWithoutPlayStore(Context context) {
        if (isWearable(context) && !PlatformVersion.isAtLeastN()) {
            return true;
        }
        if (zza(context)) {
            return !PlatformVersion.isAtLeastO() || PlatformVersion.isAtLeastR();
        }
        return false;
    }

    @TargetApi(21)
    public static boolean zza(Context context) {
        if (f7502b == null) {
            boolean z10 = false;
            if (PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z10 = true;
            }
            f7502b = Boolean.valueOf(z10);
        }
        return f7502b.booleanValue();
    }

    public static boolean zzb(Context context) {
        if (f7503c == null) {
            boolean z10 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z10 = false;
            }
            f7503c = Boolean.valueOf(z10);
        }
        return f7503c.booleanValue();
    }

    @SideEffectFree
    @TargetApi(20)
    public static boolean zzd(PackageManager packageManager) {
        if (f7501a == null) {
            boolean z10 = false;
            if (PlatformVersion.isAtLeastKitKatWatch() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z10 = true;
            }
            f7501a = Boolean.valueOf(z10);
        }
        return f7501a.booleanValue();
    }
}
