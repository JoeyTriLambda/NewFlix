package com.google.android.gms.common.api;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class BatchResult implements Result {

    /* renamed from: b, reason: collision with root package name */
    public final Status f7051b;

    public BatchResult(Status status) {
        this.f7051b = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f7051b;
    }
}
