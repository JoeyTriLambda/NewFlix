package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.zada;
import java.util.Collections;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public abstract class GoogleApiClient {

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @KeepForSdk
    @Deprecated
    public static final class Builder {
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @Deprecated
    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks {
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @Deprecated
    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener {
    }

    static {
        Collections.newSetFromMap(new WeakHashMap());
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t10) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public void zao(zada zadaVar) {
        throw new UnsupportedOperationException();
    }

    public void zap(zada zadaVar) {
        throw new UnsupportedOperationException();
    }
}
