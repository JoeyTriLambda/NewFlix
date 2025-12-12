package com.google.android.gms.measurement.api;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.measurement.internal.zziu;
import com.google.android.gms.measurement.internal.zzix;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class AppMeasurementSdk {

    /* renamed from: a, reason: collision with root package name */
    public final zzds f7609a;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
    @KeepForSdk
    public static final class ConditionalUserProperty {
        private ConditionalUserProperty() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
    @ShowFirstParty
    @KeepForSdk
    public interface EventInterceptor extends zziu {
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
    @ShowFirstParty
    @KeepForSdk
    public interface OnEventListener extends zzix {
    }

    public AppMeasurementSdk(zzds zzdsVar) {
        this.f7609a = zzdsVar;
    }

    @KeepForSdk
    public void logEvent(String str, String str2, Bundle bundle) {
        this.f7609a.zzb(str, str2, bundle);
    }

    @ShowFirstParty
    @KeepForSdk
    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.f7609a.zza(onEventListener);
    }

    public final void zza(boolean z10) {
        this.f7609a.zza(z10);
    }
}
