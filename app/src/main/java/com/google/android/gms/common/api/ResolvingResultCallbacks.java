package com.google.android.gms.common.api;

import android.content.IntentSender;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    @Override // com.google.android.gms.common.api.ResultCallbacks
    @KeepForSdk
    public final void onFailure(Status status) {
        if (!status.hasResolution()) {
            onUnresolvableFailure(status);
            return;
        }
        try {
            status.startResolutionForResult(null, 0);
        } catch (IntentSender.SendIntentException e10) {
            Log.e("ResolvingResultCallback", "Failed to start resolution", e10);
            onUnresolvableFailure(new Status(8));
        }
    }

    public abstract void onUnresolvableFailure(Status status);
}
