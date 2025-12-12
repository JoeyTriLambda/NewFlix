package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
/* loaded from: classes.dex */
final class zze implements Callable<SharedPreferences> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f7602b;

    public zze(Context context) {
        this.f7602b = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ SharedPreferences call() throws Exception {
        return this.f7602b.getSharedPreferences("google_sdk_flags", 0);
    }
}
