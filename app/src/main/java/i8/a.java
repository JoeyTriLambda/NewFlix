package i8;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.firebase:firebase-measurement-connector@@19.0.0 */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: com.google.firebase:firebase-measurement-connector@@19.0.0 */
    @KeepForSdk
    /* renamed from: i8.a$a, reason: collision with other inner class name */
    public interface InterfaceC0166a {
    }

    /* compiled from: com.google.firebase:firebase-measurement-connector@@19.0.0 */
    @KeepForSdk
    public interface b {
    }

    @KeepForSdk
    void logEvent(String str, String str2, Bundle bundle);

    @KeepForSdk
    InterfaceC0166a registerAnalyticsConnectorListener(String str, b bVar);
}
