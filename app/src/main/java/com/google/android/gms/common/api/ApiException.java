package com.google.android.gms.common.api;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class ApiException extends Exception {

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public final Status f7049b;

    public ApiException(Status status) {
        super(status.getStatusCode() + ": " + (status.getStatusMessage() != null ? status.getStatusMessage() : ""));
        this.f7049b = status;
    }

    public Status getStatus() {
        return this.f7049b;
    }

    public int getStatusCode() {
        return this.f7049b.getStatusCode();
    }
}
