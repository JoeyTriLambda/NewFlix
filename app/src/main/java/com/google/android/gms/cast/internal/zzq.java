package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzq implements Cast.ApplicationConnectionResult {

    /* renamed from: b, reason: collision with root package name */
    public final Status f6866b;

    /* renamed from: m, reason: collision with root package name */
    public final ApplicationMetadata f6867m;

    /* renamed from: n, reason: collision with root package name */
    public final String f6868n;

    /* renamed from: o, reason: collision with root package name */
    public final String f6869o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f6870p;

    public zzq(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z10) {
        this.f6866b = status;
        this.f6867m = applicationMetadata;
        this.f6868n = str;
        this.f6869o = str2;
        this.f6870p = z10;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final ApplicationMetadata getApplicationMetadata() {
        return this.f6867m;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final String getApplicationStatus() {
        return this.f6868n;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final String getSessionId() {
        return this.f6869o;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f6866b;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final boolean getWasLaunched() {
        return this.f6870p;
    }
}
