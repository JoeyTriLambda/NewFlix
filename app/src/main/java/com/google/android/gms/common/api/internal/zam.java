package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zam {

    /* renamed from: a, reason: collision with root package name */
    public final int f7264a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectionResult f7265b;

    public zam(ConnectionResult connectionResult, int i10) {
        Preconditions.checkNotNull(connectionResult);
        this.f7265b = connectionResult;
        this.f7264a = i10;
    }
}
