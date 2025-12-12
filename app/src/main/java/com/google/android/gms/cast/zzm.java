package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzm implements Cast.CastApi {
    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.execute(new zzf(googleApiClient, str, str2));
    }
}
