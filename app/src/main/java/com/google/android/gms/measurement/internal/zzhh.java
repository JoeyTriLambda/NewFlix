package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzhh extends zzil {

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicLong f8073k = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: c, reason: collision with root package name */
    public zzhl f8074c;

    /* renamed from: d, reason: collision with root package name */
    public zzhl f8075d;

    /* renamed from: e, reason: collision with root package name */
    public final PriorityBlockingQueue<zzhm<?>> f8076e;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedBlockingQueue f8077f;

    /* renamed from: g, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f8078g;

    /* renamed from: h, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f8079h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f8080i;

    /* renamed from: j, reason: collision with root package name */
    public final Semaphore f8081j;

    public zzhh(zzho zzhoVar) {
        super(zzhoVar);
        this.f8080i = new Object();
        this.f8081j = new Semaphore(2);
        this.f8076e = new PriorityBlockingQueue<>();
        this.f8077f = new LinkedBlockingQueue();
        this.f8078g = new zzhj(this, "Thread death: Uncaught exception on worker thread");
        this.f8079h = new zzhj(this, "Thread death: Uncaught exception on network thread");
    }

    public final <T> T a(AtomicReference<T> atomicReference, long j10, String str, Runnable runnable) throws IllegalStateException {
        synchronized (atomicReference) {
            zzl().zzb(runnable);
            try {
                atomicReference.wait(j10);
            } catch (InterruptedException unused) {
                zzj().zzu().zza("Interrupted waiting for ".concat(str));
                return null;
            }
        }
        T t10 = atomicReference.get();
        if (t10 == null) {
            zzj().zzu().zza("Timed out waiting for ".concat(str));
        }
        return t10;
    }

    public final void b(zzhm<?> zzhmVar) {
        synchronized (this.f8080i) {
            this.f8076e.add(zzhmVar);
            zzhl zzhlVar = this.f8074c;
            if (zzhlVar == null) {
                zzhl zzhlVar2 = new zzhl(this, "Measurement Worker", this.f8076e);
                this.f8074c = zzhlVar2;
                zzhlVar2.setUncaughtExceptionHandler(this.f8078g);
                this.f8074c.start();
            } else {
                zzhlVar.zza();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public final void zzc(Runnable runnable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(runnable);
        b(new zzhm<>(this, runnable, true, "Task exception on worker thread"));
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    public final boolean zzg() {
        return Thread.currentThread() == this.f8074c;
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final boolean zzo() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final void zzr() {
        if (Thread.currentThread() != this.f8075d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final void zzt() {
        if (Thread.currentThread() != this.f8074c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final <V> Future<V> zza(Callable<V> callable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(callable);
        zzhm<?> zzhmVar = new zzhm<>(this, callable, false);
        if (Thread.currentThread() == this.f8074c) {
            if (!this.f8076e.isEmpty()) {
                zzj().zzu().zza("Callable skipped the worker queue.");
            }
            zzhmVar.run();
        } else {
            b(zzhmVar);
        }
        return zzhmVar;
    }

    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(callable);
        zzhm<?> zzhmVar = new zzhm<>(this, callable, true);
        if (Thread.currentThread() == this.f8074c) {
            zzhmVar.run();
        } else {
            b(zzhmVar);
        }
        return zzhmVar;
    }

    public final void zzb(Runnable runnable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(runnable);
        b(new zzhm<>(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zza(Runnable runnable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(runnable);
        zzhm zzhmVar = new zzhm(this, runnable, false, "Task exception on network thread");
        synchronized (this.f8080i) {
            this.f8077f.add(zzhmVar);
            zzhl zzhlVar = this.f8075d;
            if (zzhlVar == null) {
                zzhl zzhlVar2 = new zzhl(this, "Measurement Network", this.f8077f);
                this.f8075d = zzhlVar2;
                zzhlVar2.setUncaughtExceptionHandler(this.f8079h);
                this.f8075d.start();
            } else {
                zzhlVar.zza();
            }
        }
    }
}
