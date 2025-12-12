package com.google.android.gms.cast.internal;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class Logger {

    /* renamed from: a, reason: collision with root package name */
    public final String f6802a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6803b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6804c;

    @KeepForSdk
    public Logger(String str) {
        this(str, null);
    }

    @KeepForSdk
    public void d(String str, Object... objArr) {
        if (zzc()) {
            Log.d(this.f6802a, zza(str, objArr));
        }
    }

    @KeepForSdk
    public void e(String str, Object... objArr) {
        Log.e(this.f6802a, zza(str, objArr));
    }

    @KeepForSdk
    public void i(String str, Object... objArr) {
        Log.i(this.f6802a, zza(str, objArr));
    }

    @KeepForSdk
    public void w(String str, Object... objArr) {
        Log.w(this.f6802a, zza(str, objArr));
    }

    public final String zza(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(Locale.ROOT, str, objArr);
        }
        String str2 = this.f6804c;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return String.valueOf(str2).concat(String.valueOf(str));
    }

    public final boolean zzc() {
        return !Build.TYPE.equals("user") && this.f6803b && Log.isLoggable(this.f6802a, 3);
    }

    public Logger(String str, String str2) {
        Preconditions.checkNotEmpty(str, "The log tag cannot be null or empty.");
        this.f6802a = str;
        this.f6803b = str.length() <= 23;
        this.f6804c = TextUtils.isEmpty(str2) ? null : String.format("[%s] ", str2);
    }

    @KeepForSdk
    public void e(Throwable th2, String str, Object... objArr) {
        Log.e(this.f6802a, zza(str, objArr), th2);
    }

    @KeepForSdk
    public void w(Throwable th2, String str, Object... objArr) {
        Log.w(this.f6802a, zza(str, objArr), th2);
    }

    @KeepForSdk
    public void d(Throwable th2, String str, Object... objArr) {
        if (zzc()) {
            Log.d(this.f6802a, zza(str, objArr), th2);
        }
    }
}
