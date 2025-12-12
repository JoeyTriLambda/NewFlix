package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzgn {

    /* renamed from: a, reason: collision with root package name */
    public final zzip f8016a;

    public zzgn(zzip zzipVar) {
        this.f8016a = zzipVar;
    }

    public static zzgn a(String str) {
        return new zzgn((TextUtils.isEmpty(str) || str.length() > 1) ? zzip.UNINITIALIZED : zziq.b(str.charAt(0)));
    }
}
