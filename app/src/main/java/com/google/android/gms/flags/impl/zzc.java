package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
/* loaded from: classes.dex */
final class zzc implements Callable<Long> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f7596b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f7597m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Long f7598n;

    public zzc(SharedPreferences sharedPreferences, String str, Long l10) {
        this.f7596b = sharedPreferences;
        this.f7597m = str;
        this.f7598n = l10;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Long call() throws Exception {
        return Long.valueOf(this.f7596b.getLong(this.f7597m, this.f7598n.longValue()));
    }
}
