package k2;

import android.app.ActivityManager;

/* compiled from: SupportSQLiteCompat.kt */
/* loaded from: classes.dex */
public final class c {
    public static final boolean isLowRamDevice(ActivityManager activityManager) {
        zf.i.checkNotNullParameter(activityManager, "activityManager");
        return activityManager.isLowRamDevice();
    }
}
