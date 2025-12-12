package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
/* loaded from: classes.dex */
final class zza implements Callable<Boolean> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f7590b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f7591m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Boolean f7592n;

    public zza(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f7590b = sharedPreferences;
        this.f7591m = str;
        this.f7592n = bool;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Boolean call() throws Exception {
        return Boolean.valueOf(this.f7590b.getBoolean(this.f7591m, this.f7592n.booleanValue()));
    }
}
