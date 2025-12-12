package r8;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.List;

/* compiled from: AppData.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f18656a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18657b;

    /* renamed from: c, reason: collision with root package name */
    public final List<f> f18658c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18659d;

    /* renamed from: e, reason: collision with root package name */
    public final String f18660e;

    /* renamed from: f, reason: collision with root package name */
    public final String f18661f;

    /* renamed from: g, reason: collision with root package name */
    public final String f18662g;

    /* renamed from: h, reason: collision with root package name */
    public final o8.d f18663h;

    public a(String str, String str2, List<f> list, String str3, String str4, String str5, String str6, o8.d dVar) {
        this.f18656a = str;
        this.f18657b = str2;
        this.f18658c = list;
        this.f18659d = str3;
        this.f18660e = str4;
        this.f18661f = str5;
        this.f18662g = str6;
        this.f18663h = dVar;
    }

    public static a create(Context context, h0 h0Var, String str, String str2, List<f> list, o8.d dVar) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String installerPackageName = h0Var.getInstallerPackageName();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String string = Build.VERSION.SDK_INT >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : Integer.toString(packageInfo.versionCode);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new a(str, str2, list, installerPackageName, packageName, string, str3, dVar);
    }
}
