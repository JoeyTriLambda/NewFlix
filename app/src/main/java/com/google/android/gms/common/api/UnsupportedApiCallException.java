package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {

    /* renamed from: b, reason: collision with root package name */
    public final Feature f7078b;

    @KeepForSdk
    public UnsupportedApiCallException(Feature feature) {
        this.f7078b = feature;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.f7078b));
    }
}
