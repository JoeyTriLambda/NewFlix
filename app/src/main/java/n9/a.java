package n9;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import f9.c;

/* compiled from: DataCollectionConfigStorage.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final c f16766a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16767b;

    public a(Context context, String str, c cVar) {
        boolean z10;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        context = Build.VERSION.SDK_INT >= 24 ? m0.a.createDeviceProtectedStorageContext(context) : context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f16766a = cVar;
        boolean z11 = true;
        if (sharedPreferences.contains("firebase_data_collection_default_enabled")) {
            z10 = sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
        } else {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                    z11 = applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            z10 = z11;
        }
        this.f16767b = z10;
    }

    public synchronized boolean isEnabled() {
        return this.f16767b;
    }
}
