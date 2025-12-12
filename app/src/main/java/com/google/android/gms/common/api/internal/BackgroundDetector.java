package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: p, reason: collision with root package name */
    public static final BackgroundDetector f7083p = new BackgroundDetector();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f7084b = new AtomicBoolean();

    /* renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f7085m = new AtomicBoolean();

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f7086n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public boolean f7087o = false;

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z10);
    }

    @KeepForSdk
    private BackgroundDetector() {
    }

    @KeepForSdk
    public static BackgroundDetector getInstance() {
        return f7083p;
    }

    @KeepForSdk
    public static void initialize(Application application) {
        BackgroundDetector backgroundDetector = f7083p;
        synchronized (backgroundDetector) {
            if (!backgroundDetector.f7087o) {
                application.registerActivityLifecycleCallbacks(backgroundDetector);
                application.registerComponentCallbacks(backgroundDetector);
                backgroundDetector.f7087o = true;
            }
        }
    }

    public final void a(boolean z10) {
        synchronized (f7083p) {
            Iterator it = this.f7086n.iterator();
            while (it.hasNext()) {
                ((BackgroundStateChangeListener) it.next()).onBackgroundStateChanged(z10);
            }
        }
    }

    @KeepForSdk
    public void addListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (f7083p) {
            this.f7086n.add(backgroundStateChangeListener);
        }
    }

    @KeepForSdk
    public boolean isInBackground() {
        return this.f7084b.get();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f7085m;
        boolean zCompareAndSet = this.f7084b.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            a(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f7085m;
        boolean zCompareAndSet = this.f7084b.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            a(false);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i10) {
        if (i10 == 20 && this.f7084b.compareAndSet(false, true)) {
            this.f7085m.set(true);
            a(true);
        }
    }

    @KeepForSdk
    @TargetApi(16)
    public boolean readCurrentStateIfPossible(boolean z10) {
        AtomicBoolean atomicBoolean = this.f7085m;
        if (!atomicBoolean.get()) {
            if (!PlatformVersion.isAtLeastJellyBean()) {
                return z10;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!atomicBoolean.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f7084b.set(true);
            }
        }
        return isInBackground();
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
