package a8;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.net.Uri;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f381a;

    static {
        Uri.parse("http://play.google.com/store/apps/details");
        f381a = new String[]{"com.google.android.youtube", "com.google.android.youtube.tv", "com.google.android.youtube.googletv", "com.google.android.gms", null};
    }

    public static String a(Context context) {
        ServiceInfo serviceInfo;
        String str;
        PackageManager packageManager = context.getPackageManager();
        for (String str2 : f381a) {
            ResolveInfo resolveInfoResolveService = packageManager.resolveService(new Intent("com.google.android.youtube.api.service.START").setPackage(str2), 0);
            if (resolveInfoResolveService != null && (serviceInfo = resolveInfoResolveService.serviceInfo) != null && (str = serviceInfo.packageName) != null) {
                return str;
            }
        }
        return packageManager.hasSystemFeature("android.software.leanback") ? "com.google.android.youtube.tv" : packageManager.hasSystemFeature("com.google.android.tv") ? "com.google.android.youtube.googletv" : "com.google.android.youtube";
    }

    public static Context b(Context context) {
        try {
            return context.createPackageContext(a(context), 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static int c(Context context) {
        Context contextB = b(context);
        int identifier = contextB != null ? contextB.getResources().getIdentifier("clientTheme", "style", a(context)) : 0;
        return identifier == 0 ? R.style.Theme.DeviceDefault : identifier;
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            throw new IllegalStateException("Cannot retrieve calling Context's PackageInfo", e10);
        }
    }

    public static boolean a(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(str);
            if (str.equals("com.google.android.youtube.googletvdev")) {
                str = "com.google.android.youtube.googletv";
            }
            int identifier = resourcesForApplication.getIdentifier("youtube_api_version_code", "integer", str);
            return identifier == 0 || 12 > resourcesForApplication.getInteger(identifier) / 100;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }
}
