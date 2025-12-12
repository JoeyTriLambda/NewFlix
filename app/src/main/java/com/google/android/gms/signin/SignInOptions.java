package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class SignInOptions implements Api.ApiOptions.Optional {

    /* renamed from: b, reason: collision with root package name */
    public static final SignInOptions f8640b = new SignInOptions();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInOptions)) {
            return false;
        }
        ((SignInOptions) obj).getClass();
        return Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Objects.hashCode(bool, bool, null, bool, bool, null, null, null, null);
    }
}
