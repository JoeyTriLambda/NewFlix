package com.google.android.gms.cast.framework.media.widget;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzb {

    /* renamed from: a, reason: collision with root package name */
    public final int f6696a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6697b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6698c;

    public zzb(int i10, int i11, boolean z10) {
        this.f6696a = i10;
        this.f6697b = i11;
        this.f6698c = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzb) && this.f6696a == ((zzb) obj).f6696a;
    }

    public final int hashCode() {
        return Integer.valueOf(this.f6696a).hashCode();
    }
}
