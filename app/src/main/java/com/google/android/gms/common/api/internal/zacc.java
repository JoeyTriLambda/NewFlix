package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.CancellationException;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zacc extends zap {
    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onDestroy() {
        super.onDestroy();
        new CancellationException("Host activity was destroyed before Google Play services could be made available.");
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zab(ConnectionResult connectionResult, int i10) {
        String errorMessage = connectionResult.getErrorMessage();
        if (errorMessage == null) {
            errorMessage = "Error connecting to Google Play services";
        }
        new ApiException(new Status(connectionResult, errorMessage, connectionResult.getErrorCode()));
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zac() {
        throw null;
    }
}
