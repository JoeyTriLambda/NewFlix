package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
/* loaded from: classes.dex */
public final class zzf {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f7603a;

    public static SharedPreferences zza(Context context) throws Exception {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f7603a == null) {
                f7603a = (SharedPreferences) com.google.android.gms.internal.flags.zzd.zza(new zze(context));
            }
            sharedPreferences = f7603a;
        }
        return sharedPreferences;
    }
}
