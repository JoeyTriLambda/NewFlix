package r8;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.concurrent.Executor;

/* compiled from: DataCollectionArbiter.java */
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final g8.f f18674a;

    /* renamed from: d, reason: collision with root package name */
    public boolean f18677d;

    /* renamed from: e, reason: collision with root package name */
    public final Boolean f18678e;

    /* renamed from: b, reason: collision with root package name */
    public final Object f18675b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final TaskCompletionSource<Void> f18676c = new TaskCompletionSource<>();

    /* renamed from: f, reason: collision with root package name */
    public final TaskCompletionSource<Void> f18679f = new TaskCompletionSource<>();

    public d0(g8.f fVar) {
        Boolean boolValueOf;
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        this.f18677d = false;
        Context applicationContext = fVar.getApplicationContext();
        this.f18674a = fVar;
        SharedPreferences sharedPrefs = CommonUtils.getSharedPrefs(applicationContext);
        if (sharedPrefs.contains("firebase_crashlytics_collection_enabled")) {
            this.f18677d = false;
            boolValueOf = Boolean.valueOf(sharedPrefs.getBoolean("firebase_crashlytics_collection_enabled", true));
        } else {
            boolValueOf = null;
        }
        if (boolValueOf == null) {
            try {
                packageManager = applicationContext.getPackageManager();
            } catch (PackageManager.NameNotFoundException e10) {
                o8.e.getLogger().e("Could not read data collection permission from manifest", e10);
            }
            Boolean boolValueOf2 = (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) ? null : Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
            if (boolValueOf2 == null) {
                this.f18677d = false;
                boolValueOf = null;
            } else {
                this.f18677d = true;
                boolValueOf = Boolean.valueOf(Boolean.TRUE.equals(boolValueOf2));
            }
        }
        this.f18678e = boolValueOf;
        synchronized (this.f18675b) {
            if (isAutomaticDataCollectionEnabled()) {
                this.f18676c.trySetResult(null);
            }
        }
    }

    public void grantDataCollectionPermission(boolean z10) {
        if (!z10) {
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        this.f18679f.trySetResult(null);
    }

    public synchronized boolean isAutomaticDataCollectionEnabled() {
        boolean zIsDataCollectionDefaultEnabled;
        Boolean bool = this.f18678e;
        if (bool != null) {
            zIsDataCollectionDefaultEnabled = bool.booleanValue();
        } else {
            try {
                zIsDataCollectionDefaultEnabled = this.f18674a.isDataCollectionDefaultEnabled();
            } catch (IllegalStateException unused) {
                zIsDataCollectionDefaultEnabled = false;
            }
        }
        o8.e.getLogger().d(String.format("Crashlytics automatic data collection %s by %s.", zIsDataCollectionDefaultEnabled ? "ENABLED" : "DISABLED", this.f18678e == null ? "global Firebase setting" : this.f18677d ? "firebase_crashlytics_collection_enabled manifest flag" : "API"));
        return zIsDataCollectionDefaultEnabled;
    }

    public Task<Void> waitForAutomaticDataCollectionEnabled() {
        Task<Void> task;
        synchronized (this.f18675b) {
            task = this.f18676c.getTask();
        }
        return task;
    }

    public Task<Void> waitForDataCollectionPermission(Executor executor) {
        return p0.race(executor, this.f18679f.getTask(), waitForAutomaticDataCollectionEnabled());
    }
}
