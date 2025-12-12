package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzbb {

    /* renamed from: a, reason: collision with root package name */
    public final String f7708a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7709b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7710c;

    /* renamed from: d, reason: collision with root package name */
    public final long f7711d;

    /* renamed from: e, reason: collision with root package name */
    public final long f7712e;

    /* renamed from: f, reason: collision with root package name */
    public final long f7713f;

    /* renamed from: g, reason: collision with root package name */
    public final long f7714g;

    /* renamed from: h, reason: collision with root package name */
    public final Long f7715h;

    /* renamed from: i, reason: collision with root package name */
    public final Long f7716i;

    /* renamed from: j, reason: collision with root package name */
    public final Long f7717j;

    /* renamed from: k, reason: collision with root package name */
    public final Boolean f7718k;

    public zzbb(String str, String str2, long j10) {
        this(str, str2, 0L, 0L, 0L, j10, 0L, null, null, null, null);
    }

    public final zzbb a(long j10, long j11) {
        return new zzbb(this.f7708a, this.f7709b, this.f7710c, this.f7711d, this.f7712e, this.f7713f, j10, Long.valueOf(j11), this.f7716i, this.f7717j, this.f7718k);
    }

    public final zzbb b(Long l10, Long l11, Boolean bool) {
        return new zzbb(this.f7708a, this.f7709b, this.f7710c, this.f7711d, this.f7712e, this.f7713f, this.f7714g, this.f7715h, l10, l11, (bool == null || bool.booleanValue()) ? bool : null);
    }

    public zzbb(String str, String str2, long j10, long j11, long j12, long j13, long j14, Long l10, Long l11, Long l12, Boolean bool) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkArgument(j10 >= 0);
        Preconditions.checkArgument(j11 >= 0);
        Preconditions.checkArgument(j12 >= 0);
        Preconditions.checkArgument(j14 >= 0);
        this.f7708a = str;
        this.f7709b = str2;
        this.f7710c = j10;
        this.f7711d = j11;
        this.f7712e = j12;
        this.f7713f = j13;
        this.f7714g = j14;
        this.f7715h = l10;
        this.f7716i = l11;
        this.f7717j = l12;
        this.f7718k = bool;
    }
}
