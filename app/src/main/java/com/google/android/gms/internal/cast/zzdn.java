package com.google.android.gms.internal.cast;

import ac.c;
import android.hardware.display.VirtualDisplay;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@Deprecated
/* loaded from: classes.dex */
public final class zzdn implements CastRemoteDisplayApi {
    private static final Logger zza = new Logger("CastRemoteDisplayApiImpl");
    private final Api zzb;
    private VirtualDisplay zzc;
    private final zzdv zzd = new zzdf(this);

    public zzdn(Api api) {
        this.zzb = api;
    }

    public static /* bridge */ /* synthetic */ void zzf(zzdn zzdnVar) {
        VirtualDisplay virtualDisplay = zzdnVar.zzc;
        if (virtualDisplay != null) {
            if (virtualDisplay.getDisplay() != null) {
                zza.d(c.f("releasing virtual display: ", virtualDisplay.getDisplay().getDisplayId()), new Object[0]);
            }
            virtualDisplay.release();
        }
        zzdnVar.zzc = null;
    }

    public final PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient googleApiClient, String str) {
        zza.d("startRemoteDisplay", new Object[0]);
        return googleApiClient.execute(new zzdg(this, googleApiClient, str));
    }

    public final PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient googleApiClient) {
        zza.d("stopRemoteDisplay", new Object[0]);
        return googleApiClient.execute(new zzdh(this, googleApiClient));
    }
}
