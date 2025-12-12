package com.google.android.gms.security;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class ProviderInstaller {

    /* renamed from: a, reason: collision with root package name */
    public static final GoogleApiAvailabilityLight f8636a = GoogleApiAvailabilityLight.getInstance();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f8637b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static Method f8638c = null;

    /* renamed from: d, reason: collision with root package name */
    public static Method f8639d = null;

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public interface ProviderInstallListener {
    }

    public static void a(Context context, String str) throws IllegalAccessException, GooglePlayServicesNotAvailableException, IllegalArgumentException, InvocationTargetException {
        try {
            if (f8638c == null) {
                f8638c = context.getClassLoader().loadClass(str).getMethod("insertProvider", Context.class);
            }
            f8638c.invoke(null, context);
        } catch (Exception e10) {
            Throwable cause = e10.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e10.getMessage() : cause.getMessage())));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Context moduleContext;
        Preconditions.checkNotNull(context, "Context must not be null");
        f8636a.verifyGooglePlayServicesIsAvailable(context, 11925000);
        synchronized (f8637b) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                moduleContext = DynamiteModule.load(context, DynamiteModule.f7569d, "com.google.android.gms.providerinstaller.dynamite").getModuleContext();
            } catch (DynamiteModule.LoadingException e10) {
                Log.w("ProviderInstaller", "Failed to load providerinstaller module: ".concat(String.valueOf(e10.getMessage())));
                moduleContext = null;
            }
            if (moduleContext != null) {
                a(moduleContext, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                return;
            }
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext != null) {
                try {
                    if (f8639d == null) {
                        Class<?> cls = Long.TYPE;
                        f8639d = remoteContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("reportRequestStats", Context.class, cls, cls);
                    }
                    f8639d.invoke(null, context, Long.valueOf(jElapsedRealtime), Long.valueOf(jElapsedRealtime2));
                } catch (Exception e11) {
                    Log.w("ProviderInstaller", "Failed to report request stats: ".concat(String.valueOf(e11.getMessage())));
                }
            }
            if (remoteContext != null) {
                a(remoteContext, "com.google.android.gms.common.security.ProviderInstallerImpl");
            } else {
                Log.e("ProviderInstaller", "Failed to get remote context");
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }
}
