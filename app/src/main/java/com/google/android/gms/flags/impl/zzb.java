package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
/* loaded from: classes.dex */
final class zzb implements Callable<Integer> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f7593b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f7594m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Integer f7595n;

    public zzb(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f7593b = sharedPreferences;
        this.f7594m = str;
        this.f7595n = num;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Integer call() throws Exception {
        return Integer.valueOf(this.f7593b.getInt(this.f7594m, this.f7595n.intValue()));
    }
}
