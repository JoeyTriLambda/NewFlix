package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public class HashAccumulator {

    /* renamed from: a, reason: collision with root package name */
    public int f6097a = 1;

    @KeepForSdk
    public HashAccumulator addObject(Object obj) {
        this.f6097a = (31 * this.f6097a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    @KeepForSdk
    public int hash() {
        return this.f6097a;
    }

    public final HashAccumulator zaa(boolean z10) {
        this.f6097a = (31 * this.f6097a) + (z10 ? 1 : 0);
        return this;
    }
}
