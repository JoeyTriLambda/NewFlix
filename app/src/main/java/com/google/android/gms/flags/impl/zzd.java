package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
/* loaded from: classes.dex */
final class zzd implements Callable<String> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f7599b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f7600m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f7601n;

    public zzd(SharedPreferences sharedPreferences, String str, String str2) {
        this.f7599b = sharedPreferences;
        this.f7600m = str;
        this.f7601n = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ String call() throws Exception {
        return this.f7599b.getString(this.f7600m, this.f7601n);
    }
}
