package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzhj implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final String f8084a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzhh f8085b;

    public zzhj(zzhh zzhhVar, String str) {
        this.f8085b = zzhhVar;
        Preconditions.checkNotNull(str);
        this.f8084a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th2) {
        this.f8085b.zzj().zzg().zza(this.f8084a, th2);
    }
}
