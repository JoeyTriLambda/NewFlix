package com.google.firebase.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class SequentialExecutor implements Executor {

    /* renamed from: q, reason: collision with root package name */
    public static final Logger f9743q = Logger.getLogger(SequentialExecutor.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public final Executor f9744b;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayDeque f9745m = new ArrayDeque();

    /* renamed from: n, reason: collision with root package name */
    public WorkerRunningState f9746n = WorkerRunningState.IDLE;

    /* renamed from: o, reason: collision with root package name */
    public long f9747o = 0;

    /* renamed from: p, reason: collision with root package name */
    public final b f9748p = new b();

    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f9754b;

        public a(Runnable runnable) {
            this.f9754b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9754b.run();
        }

        public String toString() {
            return this.f9754b.toString();
        }
    }

    public final class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public Runnable f9755b;

        public b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        
            r9.f9755b.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
        
            com.google.firebase.concurrent.SequentialExecutor.f9743q.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r9.f9755b, (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
        
            r9.f9755b = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() {
            /*
                r9 = this;
                r0 = 0
                r1 = 0
            L2:
                com.google.firebase.concurrent.SequentialExecutor r2 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L78
                java.util.ArrayDeque r2 = r2.f9745m     // Catch: java.lang.Throwable -> L78
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L78
                if (r0 != 0) goto L26
                com.google.firebase.concurrent.SequentialExecutor r0 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L75
                com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r3 = r0.f9746n     // Catch: java.lang.Throwable -> L75
                com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r4 = com.google.firebase.concurrent.SequentialExecutor.WorkerRunningState.RUNNING     // Catch: java.lang.Throwable -> L75
                if (r3 != r4) goto L1c
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L75
                if (r1 == 0) goto L1b
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L1b:
                return
            L1c:
                long r5 = r0.f9747o     // Catch: java.lang.Throwable -> L75
                r7 = 1
                long r5 = r5 + r7
                r0.f9747o = r5     // Catch: java.lang.Throwable -> L75
                r0.f9746n = r4     // Catch: java.lang.Throwable -> L75
                r0 = 1
            L26:
                com.google.firebase.concurrent.SequentialExecutor r3 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L75
                java.util.ArrayDeque r3 = r3.f9745m     // Catch: java.lang.Throwable -> L75
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L75
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L75
                r9.f9755b = r3     // Catch: java.lang.Throwable -> L75
                if (r3 != 0) goto L45
                com.google.firebase.concurrent.SequentialExecutor r0 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L75
                com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.firebase.concurrent.SequentialExecutor.WorkerRunningState.IDLE     // Catch: java.lang.Throwable -> L75
                r0.f9746n = r3     // Catch: java.lang.Throwable -> L75
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L75
                if (r1 == 0) goto L44
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L44:
                return
            L45:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L75
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L78
                r1 = r1 | r2
                r2 = 0
                java.lang.Runnable r3 = r9.f9755b     // Catch: java.lang.Throwable -> L52 java.lang.RuntimeException -> L54
                r3.run()     // Catch: java.lang.Throwable -> L52 java.lang.RuntimeException -> L54
                goto L6f
            L52:
                r0 = move-exception
                goto L72
            L54:
                r3 = move-exception
                java.util.logging.Logger r4 = com.google.firebase.concurrent.SequentialExecutor.f9743q     // Catch: java.lang.Throwable -> L52
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L52
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
                r6.<init>()     // Catch: java.lang.Throwable -> L52
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)     // Catch: java.lang.Throwable -> L52
                java.lang.Runnable r7 = r9.f9755b     // Catch: java.lang.Throwable -> L52
                r6.append(r7)     // Catch: java.lang.Throwable -> L52
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L52
                r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L52
            L6f:
                r9.f9755b = r2     // Catch: java.lang.Throwable -> L78
                goto L2
            L72:
                r9.f9755b = r2     // Catch: java.lang.Throwable -> L78
                throw r0     // Catch: java.lang.Throwable -> L78
            L75:
                r0 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L75
                throw r0     // Catch: java.lang.Throwable -> L78
            L78:
                r0 = move-exception
                if (r1 == 0) goto L82
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L82:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.concurrent.SequentialExecutor.b.a():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Error e10) {
                synchronized (SequentialExecutor.this.f9745m) {
                    SequentialExecutor.this.f9746n = WorkerRunningState.IDLE;
                    throw e10;
                }
            }
        }

        public String toString() {
            Runnable runnable = this.f9755b;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + SequentialExecutor.this.f9746n + "}";
        }
    }

    public SequentialExecutor(Executor executor) {
        this.f9744b = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        WorkerRunningState workerRunningState;
        Preconditions.checkNotNull(runnable);
        synchronized (this.f9745m) {
            WorkerRunningState workerRunningState2 = this.f9746n;
            if (workerRunningState2 != WorkerRunningState.RUNNING && workerRunningState2 != (workerRunningState = WorkerRunningState.QUEUED)) {
                long j10 = this.f9747o;
                a aVar = new a(runnable);
                this.f9745m.add(aVar);
                WorkerRunningState workerRunningState3 = WorkerRunningState.QUEUING;
                this.f9746n = workerRunningState3;
                try {
                    this.f9744b.execute(this.f9748p);
                    if (this.f9746n != workerRunningState3) {
                        return;
                    }
                    synchronized (this.f9745m) {
                        if (this.f9747o == j10 && this.f9746n == workerRunningState3) {
                            this.f9746n = workerRunningState;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e10) {
                    synchronized (this.f9745m) {
                        WorkerRunningState workerRunningState4 = this.f9746n;
                        if ((workerRunningState4 == WorkerRunningState.IDLE || workerRunningState4 == WorkerRunningState.QUEUING) && this.f9745m.removeLastOccurrence(aVar)) {
                            z = true;
                        }
                        if (!(e10 instanceof RejectedExecutionException) || z) {
                            throw e10;
                        }
                    }
                    return;
                }
            }
            this.f9745m.add(runnable);
        }
    }

    public String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f9744b + "}";
    }
}
