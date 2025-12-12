package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class ApiKey<O extends Api.ApiOptions> {

    /* renamed from: a, reason: collision with root package name */
    public final int f7079a;

    /* renamed from: b, reason: collision with root package name */
    public final Api<O> f7080b;

    /* renamed from: c, reason: collision with root package name */
    public final O f7081c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7082d;

    public ApiKey(Api<O> api, O o6, String str) {
        this.f7080b = api;
        this.f7081c = o6;
        this.f7082d = str;
        this.f7079a = Objects.hashCode(api, o6, str);
    }

    public static <O extends Api.ApiOptions> ApiKey<O> zaa(Api<O> api, O o6, String str) {
        return new ApiKey<>(api, o6, str);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        return Objects.equal(this.f7080b, apiKey.f7080b) && Objects.equal(this.f7081c, apiKey.f7081c) && Objects.equal(this.f7082d, apiKey.f7082d);
    }

    public final int hashCode() {
        return this.f7079a;
    }

    public final String zab() {
        return this.f7080b.zad();
    }
}
