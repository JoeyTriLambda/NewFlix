package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public final class RootTelemetryConfigManager {

    /* renamed from: b, reason: collision with root package name */
    public static RootTelemetryConfigManager f7355b;

    /* renamed from: c, reason: collision with root package name */
    public static final RootTelemetryConfiguration f7356c = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public RootTelemetryConfiguration f7357a;

    private RootTelemetryConfigManager() {
    }

    @KeepForSdk
    public static synchronized RootTelemetryConfigManager getInstance() {
        if (f7355b == null) {
            f7355b = new RootTelemetryConfigManager();
        }
        return f7355b;
    }

    @KeepForSdk
    public RootTelemetryConfiguration getConfig() {
        return this.f7357a;
    }

    public final synchronized void zza(RootTelemetryConfiguration rootTelemetryConfiguration) {
        if (rootTelemetryConfiguration == null) {
            this.f7357a = f7356c;
            return;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f7357a;
        if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.getVersion() < rootTelemetryConfiguration.getVersion()) {
            this.f7357a = rootTelemetryConfiguration;
        }
    }
}
