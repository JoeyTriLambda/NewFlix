package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zabs {

    /* renamed from: a, reason: collision with root package name */
    public final ApiKey<?> f7197a;

    /* renamed from: b, reason: collision with root package name */
    public final Feature f7198b;

    public /* synthetic */ zabs(ApiKey apiKey, Feature feature) {
        this.f7197a = apiKey;
        this.f7198b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zabs)) {
            zabs zabsVar = (zabs) obj;
            if (Objects.equal(this.f7197a, zabsVar.f7197a) && Objects.equal(this.f7198b, zabsVar.f7198b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f7197a, this.f7198b);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("key", this.f7197a).add("feature", this.f7198b).toString();
    }
}
