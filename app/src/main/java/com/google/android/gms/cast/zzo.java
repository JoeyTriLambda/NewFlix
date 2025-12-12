package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzo implements Cast.ApplicationConnectionResult {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Status f7007b;

    public zzo(Status status) {
        this.f7007b = status;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final ApplicationMetadata getApplicationMetadata() {
        return null;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final String getApplicationStatus() {
        return null;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final String getSessionId() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f7007b;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final boolean getWasLaunched() {
        return false;
    }
}
