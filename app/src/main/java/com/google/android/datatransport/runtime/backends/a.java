package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

/* compiled from: AutoValue_BackendResponse.java */
/* loaded from: classes.dex */
public final class a extends BackendResponse {

    /* renamed from: a, reason: collision with root package name */
    public final BackendResponse.Status f5673a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5674b;

    public a(BackendResponse.Status status, long j10) {
        this.f5673a = status;
        this.f5674b = j10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        return this.f5673a.equals(backendResponse.getStatus()) && this.f5674b == backendResponse.getNextRequestWaitMillis();
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public long getNextRequestWaitMillis() {
        return this.f5674b;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public BackendResponse.Status getStatus() {
        return this.f5673a;
    }

    public int hashCode() {
        int iHashCode = (this.f5673a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f5674b;
        return iHashCode ^ ((int) ((j10 >>> 32) ^ j10));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f5673a + ", nextRequestWaitMillis=" + this.f5674b + "}";
    }
}
