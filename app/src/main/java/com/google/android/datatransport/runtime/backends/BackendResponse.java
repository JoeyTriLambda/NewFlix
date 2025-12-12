package com.google.android.datatransport.runtime.backends;

import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class BackendResponse {

    public enum Status {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR,
        INVALID_PAYLOAD
    }

    public static BackendResponse fatalError() {
        return new a(Status.FATAL_ERROR, -1L);
    }

    public static BackendResponse invalidPayload() {
        return new a(Status.INVALID_PAYLOAD, -1L);
    }

    public static BackendResponse ok(long j10) {
        return new a(Status.OK, j10);
    }

    public static BackendResponse transientError() {
        return new a(Status.TRANSIENT_ERROR, -1L);
    }

    public abstract long getNextRequestWaitMillis();

    public abstract Status getStatus();
}
