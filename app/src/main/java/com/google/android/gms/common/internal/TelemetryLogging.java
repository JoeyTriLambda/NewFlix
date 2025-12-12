package com.google.android.gms.common.internal;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public class TelemetryLogging {
    private TelemetryLogging() {
    }

    @KeepForSdk
    public static TelemetryLoggingClient getClient(Context context) {
        return getClient(context, TelemetryLoggingOptions.f7367m);
    }

    @KeepForSdk
    public static TelemetryLoggingClient getClient(Context context, TelemetryLoggingOptions telemetryLoggingOptions) {
        return new com.google.android.gms.common.internal.service.zao(context, telemetryLoggingOptions);
    }
}
