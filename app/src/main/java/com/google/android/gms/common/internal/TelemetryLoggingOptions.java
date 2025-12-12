package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public class TelemetryLoggingOptions implements Api.ApiOptions.Optional {

    /* renamed from: m, reason: collision with root package name */
    public static final TelemetryLoggingOptions f7367m = builder().build();

    /* renamed from: b, reason: collision with root package name */
    public final String f7368b = null;

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @KeepForSdk
    public static class Builder {
        private Builder() {
        }

        public /* synthetic */ Builder(int i10) {
        }

        @KeepForSdk
        public TelemetryLoggingOptions build() {
            return new TelemetryLoggingOptions();
        }
    }

    @KeepForSdk
    public static Builder builder() {
        return new Builder(0);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TelemetryLoggingOptions) {
            return Objects.equal(this.f7368b, ((TelemetryLoggingOptions) obj).f7368b);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f7368b);
    }

    public final Bundle zaa() {
        Bundle bundle = new Bundle();
        String str = this.f7368b;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }
}
