package p8;

import android.os.Bundle;

/* compiled from: UnavailableAnalyticsEventLogger.java */
/* loaded from: classes.dex */
public final class f implements a {
    @Override // p8.a
    public void logEvent(String str, Bundle bundle) {
        o8.e.getLogger().d("Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
    }
}
