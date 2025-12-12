package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class Batch extends BasePendingResult<BatchResult> {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7050a = 0;

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    public static final class Builder {
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.PendingResult
    public void cancel() {
        super.cancel();
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status);
    }
}
