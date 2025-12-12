package com.google.android.gms.cast;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@Deprecated
/* loaded from: classes.dex */
public final class CastRemoteDisplay {

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @Deprecated
    public static final class CastRemoteDisplayOptions implements Api.ApiOptions.HasOptions {

        /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
        @Deprecated
        public static final class Builder {
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @Deprecated
    public interface CastRemoteDisplaySessionCallbacks {
        void onRemoteDisplayEnded(Status status);
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @Deprecated
    public interface CastRemoteDisplaySessionResult extends Result {
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public @interface Configuration {
    }

    static {
        new com.google.android.gms.internal.cast.zzdn(new Api("CastRemoteDisplay.API", new zzx(), com.google.android.gms.cast.internal.zzak.f6818c));
    }

    private CastRemoteDisplay() {
    }

    public static CastRemoteDisplayClient getClient(Context context) {
        return new CastRemoteDisplayClient(context);
    }
}
