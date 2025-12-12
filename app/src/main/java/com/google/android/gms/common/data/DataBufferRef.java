package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public abstract class DataBufferRef {

    /* renamed from: a, reason: collision with root package name */
    @KeepForSdk
    public int f7283a;

    @KeepForSdk
    public boolean equals(Object obj) {
        return (obj instanceof DataBufferRef) && Objects.equal(Integer.valueOf(((DataBufferRef) obj).f7283a), Integer.valueOf(this.f7283a)) && Objects.equal(0, 0);
    }

    @KeepForSdk
    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f7283a), 0, null);
    }

    public final void zaa(int i10) {
        if (i10 >= 0) {
            throw null;
        }
        Preconditions.checkState(false);
        this.f7283a = i10;
        throw null;
    }
}
