package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public abstract class ResultTransform<R extends Result, S extends Result> {
    public abstract PendingResult<S> onSuccess(R r10);

    public Status onFailure(Status status) {
        return status;
    }
}
