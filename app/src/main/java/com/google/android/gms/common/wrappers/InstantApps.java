package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class InstantApps {

    /* renamed from: a, reason: collision with root package name */
    public static Context f7517a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f7518b;

    @KeepForSdk
    public static synchronized boolean isInstantApp(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f7517a;
        if (context2 != null && (bool = f7518b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f7518b = null;
        if (PlatformVersion.isAtLeastO()) {
            f7518b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f7518b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f7518b = Boolean.FALSE;
            }
        }
        f7517a = applicationContext;
        return f7518b.booleanValue();
    }
}
