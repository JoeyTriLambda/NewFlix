package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class ConnectionTracker {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f7482b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static volatile ConnectionTracker f7483c;

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f7484a = new ConcurrentHashMap();

    private ConnectionTracker() {
    }

    @KeepForSdk
    public static ConnectionTracker getInstance() {
        if (f7483c == null) {
            synchronized (f7482b) {
                if (f7483c == null) {
                    f7483c = new ConnectionTracker();
                }
            }
        }
        ConnectionTracker connectionTracker = f7483c;
        Preconditions.checkNotNull(connectionTracker);
        return connectionTracker;
    }

    public final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i10, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((Wrappers.packageManager(context).getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!(!(serviceConnection instanceof zzt))) {
            if (executor == null) {
                executor = null;
            }
            return (!PlatformVersion.isAtLeastQ() || executor == null) ? context.bindService(intent, serviceConnection, i10) : context.bindService(intent, i10, executor, serviceConnection);
        }
        ConcurrentHashMap concurrentHashMap = this.f7484a;
        ServiceConnection serviceConnection2 = (ServiceConnection) concurrentHashMap.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        if (executor == null) {
            executor = null;
        }
        try {
            boolean zBindService = (!PlatformVersion.isAtLeastQ() || executor == null) ? context.bindService(intent, serviceConnection, i10) : context.bindService(intent, i10, executor, serviceConnection);
            if (zBindService) {
                return zBindService;
            }
            concurrentHashMap.remove(serviceConnection, serviceConnection);
            return false;
        } catch (Throwable th2) {
            concurrentHashMap.remove(serviceConnection, serviceConnection);
            throw th2;
        }
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i10) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i10, null);
    }

    @KeepForSdk
    public void unbindService(Context context, ServiceConnection serviceConnection) {
        if (!(serviceConnection instanceof zzt)) {
            ConcurrentHashMap concurrentHashMap = this.f7484a;
            if (concurrentHashMap.containsKey(serviceConnection)) {
                try {
                    try {
                        context.unbindService((ServiceConnection) concurrentHashMap.get(serviceConnection));
                    } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
                    }
                    return;
                } finally {
                    concurrentHashMap.remove(serviceConnection);
                }
            }
        }
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused2) {
        }
    }

    @ResultIgnorabilityUnspecified
    public final boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i10, Executor executor) {
        return a(context, str, intent, serviceConnection, 4225, executor);
    }
}
