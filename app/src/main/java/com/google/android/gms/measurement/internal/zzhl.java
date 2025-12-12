package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzhl extends Thread {

    /* renamed from: b, reason: collision with root package name */
    public final Object f8086b;

    /* renamed from: m, reason: collision with root package name */
    public final BlockingQueue<zzhm<?>> f8087m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8088n = false;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zzhh f8089o;

    public zzhl(zzhh zzhhVar, String str, BlockingQueue<zzhm<?>> blockingQueue) {
        this.f8089o = zzhhVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.f8086b = new Object();
        this.f8087m = blockingQueue;
        setName(str);
    }

    public final void a(InterruptedException interruptedException) throws IllegalStateException {
        this.f8089o.zzj().zzu().zza(getName() + " was interrupted", interruptedException);
    }

    public final void b() {
        synchronized (this.f8089o.f8080i) {
            if (!this.f8088n) {
                this.f8089o.f8081j.release();
                this.f8089o.f8080i.notifyAll();
                zzhh zzhhVar = this.f8089o;
                if (this == zzhhVar.f8074c) {
                    zzhhVar.f8074c = null;
                } else if (this == zzhhVar.f8075d) {
                    zzhhVar.f8075d = null;
                } else {
                    zzhhVar.zzj().zzg().zza("Current scheduler thread is neither worker nor network");
                }
                this.f8088n = true;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws IllegalStateException, InterruptedException {
        boolean z10 = false;
        while (!z10) {
            try {
                this.f8089o.f8081j.acquire();
                z10 = true;
            } catch (InterruptedException e10) {
                a(e10);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzhm<?> zzhmVarPoll = this.f8087m.poll();
                if (zzhmVarPoll != null) {
                    Process.setThreadPriority(zzhmVarPoll.f8091m ? threadPriority : 10);
                    zzhmVarPoll.run();
                } else {
                    synchronized (this.f8086b) {
                        if (this.f8087m.peek() == null) {
                            zzhh zzhhVar = this.f8089o;
                            AtomicLong atomicLong = zzhh.f8073k;
                            zzhhVar.getClass();
                            try {
                                this.f8086b.wait(30000L);
                            } catch (InterruptedException e11) {
                                a(e11);
                            }
                        }
                    }
                    synchronized (this.f8089o.f8080i) {
                        if (this.f8087m.peek() == null) {
                            b();
                            return;
                        }
                    }
                }
            }
        } finally {
            b();
        }
    }

    public final void zza() {
        synchronized (this.f8086b) {
            this.f8086b.notifyAll();
        }
    }
}
