package androidx.mediarouter.app;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

/* compiled from: DeviceUtils.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f3593a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f3594b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f3595c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f3596d;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f3597e;

    /* renamed from: f, reason: collision with root package name */
    public static Boolean f3598f;

    /* renamed from: g, reason: collision with root package name */
    public static Boolean f3599g;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f3598f == null) {
            f3598f = Boolean.valueOf(Build.VERSION.SDK_INT >= 26 && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        return f3598f.booleanValue();
    }

    public static boolean b(Resources resources) {
        boolean z10 = false;
        if (resources == null) {
            return false;
        }
        if (f3596d == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z10 = true;
            }
            f3596d = Boolean.valueOf(z10);
        }
        return f3596d.booleanValue();
    }

    public static boolean c(Context context) {
        Resources resources = context.getResources();
        if (resources == null) {
            return false;
        }
        if (f3594b == null) {
            f3594b = Boolean.valueOf(((resources.getConfiguration().screenLayout & 15) > 3) || b(resources));
        }
        return f3594b.booleanValue();
    }

    public static boolean d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f3599g == null) {
            f3599g = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback"));
        }
        return f3599g.booleanValue();
    }
}
