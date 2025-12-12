package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzhm<V> extends FutureTask<V> implements Comparable<zzhm<V>> {

    /* renamed from: b, reason: collision with root package name */
    public final long f8090b;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f8091m;

    /* renamed from: n, reason: collision with root package name */
    public final String f8092n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zzhh f8093o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhm(zzhh zzhhVar, Runnable runnable, boolean z10, String str) throws IllegalStateException {
        super(com.google.android.gms.internal.measurement.zzcy.zza().zza(runnable), null);
        this.f8093o = zzhhVar;
        Preconditions.checkNotNull(str);
        long andIncrement = zzhh.f8073k.getAndIncrement();
        this.f8090b = andIncrement;
        this.f8092n = str;
        this.f8091m = z10;
        if (andIncrement == Long.MAX_VALUE) {
            zzhhVar.zzj().zzg().zza("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) throws IllegalStateException {
        zzhm zzhmVar = (zzhm) obj;
        boolean z10 = zzhmVar.f8091m;
        boolean z11 = this.f8091m;
        if (z11 != z10) {
            return z11 ? -1 : 1;
        }
        long j10 = this.f8090b;
        long j11 = zzhmVar.f8090b;
        if (j10 < j11) {
            return -1;
        }
        if (j10 > j11) {
            return 1;
        }
        this.f8093o.zzj().zzm().zza("Two tasks share the same index. index", Long.valueOf(j10));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th2) throws IllegalStateException {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.f8093o.zzj().zzg().zza(this.f8092n, th2);
        if ((th2 instanceof zzhk) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th2);
        }
        super.setException(th2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhm(zzhh zzhhVar, Callable callable, boolean z10) throws IllegalStateException {
        super(com.google.android.gms.internal.measurement.zzcy.zza().zza(callable));
        this.f8093o = zzhhVar;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzhh.f8073k.getAndIncrement();
        this.f8090b = andIncrement;
        this.f8092n = "Task exception on worker thread";
        this.f8091m = z10;
        if (andIncrement == Long.MAX_VALUE) {
            zzhhVar.zzj().zzg().zza("Tasks index overflow");
        }
    }
}
