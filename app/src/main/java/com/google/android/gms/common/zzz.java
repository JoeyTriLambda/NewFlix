package com.google.android.gms.common;

import com.google.android.gms.internal.common.zzag;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zzz {

    /* renamed from: a, reason: collision with root package name */
    public String f7558a = null;

    /* renamed from: b, reason: collision with root package name */
    public long f7559b = -1;

    /* renamed from: c, reason: collision with root package name */
    public zzag f7560c = zzag.zzl();

    /* renamed from: d, reason: collision with root package name */
    public zzag f7561d = zzag.zzl();

    public final void a() {
        if (this.f7558a == null) {
            throw new IllegalStateException("packageName must be defined");
        }
        if (this.f7559b < 0) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        }
        if (this.f7560c.isEmpty() && this.f7561d.isEmpty()) {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
    }
}
