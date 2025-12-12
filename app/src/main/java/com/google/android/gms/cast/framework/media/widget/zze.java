package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zze {

    /* renamed from: a, reason: collision with root package name */
    public int f6701a;

    /* renamed from: b, reason: collision with root package name */
    public int f6702b;

    /* renamed from: c, reason: collision with root package name */
    public int f6703c;

    /* renamed from: d, reason: collision with root package name */
    public int f6704d;

    /* renamed from: e, reason: collision with root package name */
    public int f6705e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6706f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze zzeVar = (zze) obj;
        return this.f6701a == zzeVar.f6701a && this.f6702b == zzeVar.f6702b && this.f6703c == zzeVar.f6703c && this.f6704d == zzeVar.f6704d && this.f6705e == zzeVar.f6705e && this.f6706f == zzeVar.f6706f;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f6701a), Integer.valueOf(this.f6702b), Integer.valueOf(this.f6703c), Integer.valueOf(this.f6704d), Integer.valueOf(this.f6705e), Boolean.valueOf(this.f6706f));
    }
}
