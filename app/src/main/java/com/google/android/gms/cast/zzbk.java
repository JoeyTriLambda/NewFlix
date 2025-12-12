package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzbk extends Api.AbstractClientBuilder {
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* bridge */ /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Cast.CastOptions castOptions = (Cast.CastOptions) obj;
        Preconditions.checkNotNull(castOptions, "Setting the API options is required.");
        return new com.google.android.gms.cast.internal.zzx(context, looper, clientSettings, castOptions.f6139b, 0, castOptions.f6141n, castOptions.f6142o, connectionCallbacks, onConnectionFailedListener);
    }
}
