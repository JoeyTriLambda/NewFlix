package com.google.android.gms.internal.cast;

import ac.c;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
abstract class zzrw extends AtomicReference implements Runnable {
    private static final Runnable zza = new zzrv(null);
    private static final Runnable zzb = new zzrv(null);

    private final void zzg(Thread thread) {
        Runnable runnable = (Runnable) get();
        zzrt zzrtVar = null;
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (!(runnable instanceof zzrt)) {
                if (runnable != zzb) {
                    break;
                }
            } else {
                zzrtVar = (zzrt) runnable;
            }
            i10++;
            if (i10 > 1000) {
                Runnable runnable2 = zzb;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z10 = Thread.interrupted() || z10;
                    LockSupport.park(zzrtVar);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z10) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        Object objZza = null;
        if (compareAndSet(null, threadCurrentThread)) {
            boolean z10 = !zzf();
            if (z10) {
                try {
                    objZza = zza();
                } catch (Throwable th2) {
                    try {
                        if (th2 instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        if (!compareAndSet(threadCurrentThread, zza)) {
                            zzg(threadCurrentThread);
                        }
                        zzc(th2);
                        return;
                    } catch (Throwable th3) {
                        if (!compareAndSet(threadCurrentThread, zza)) {
                            zzg(threadCurrentThread);
                        }
                        zzd(null);
                        throw th3;
                    }
                }
            }
            if (!compareAndSet(threadCurrentThread, zza)) {
                zzg(threadCurrentThread);
            }
            if (z10) {
                zzd(objZza);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        Runnable runnable = (Runnable) get();
        return c.C(runnable == zza ? "running=[DONE]" : runnable instanceof zzrt ? "running=[INTERRUPTED]" : runnable instanceof Thread ? c.k("running=[RUNNING ON ", ((Thread) runnable).getName(), "]") : "running=[NOT STARTED YET]", ", ", zzb());
    }

    public abstract Object zza() throws Exception;

    public abstract String zzb();

    public abstract void zzc(Throwable th2);

    public abstract void zzd(Object obj);

    public final void zze() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            zzrt zzrtVar = new zzrt(this, null);
            zzrtVar.setExclusiveOwnerThread(Thread.currentThread());
            if (compareAndSet(runnable, zzrtVar)) {
                try {
                    Thread thread = (Thread) runnable;
                    thread.interrupt();
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark(thread);
                    }
                } catch (Throwable th2) {
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark((Thread) runnable);
                    }
                    throw th2;
                }
            }
        }
    }

    public abstract boolean zzf();
}
