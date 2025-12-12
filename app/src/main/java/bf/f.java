package bf;

import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import se.n;

/* compiled from: SchedulerPoolFactory.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f4913a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f4914b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference<ScheduledExecutorService> f4915c = new AtomicReference<>();

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f4916d = new ConcurrentHashMap();

    /* compiled from: SchedulerPoolFactory.java */
    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(f.f4916d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    f.f4916d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    /* compiled from: SchedulerPoolFactory.java */
    public static final class b implements n<String, String> {
        @Override // se.n
        public String apply(String str) throws Exception {
            return System.getProperty(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            bf.f.f4915c = r0
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            bf.f.f4916d = r0
            bf.f$b r0 = new bf.f$b
            r0.<init>()
            java.lang.String r1 = "rx2.purge-enabled"
            r2 = 1
            java.lang.Object r1 = r0.apply(r1)     // Catch: java.lang.Throwable -> L26
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L26
            if (r1 != 0) goto L1f
            goto L27
        L1f:
            java.lang.String r3 = "true"
            boolean r1 = r3.equals(r1)     // Catch: java.lang.Throwable -> L26
            goto L28
        L26:
        L27:
            r1 = 1
        L28:
            bf.f.f4913a = r1
            java.lang.String r3 = "rx2.purge-period-seconds"
            if (r1 == 0) goto L3b
            java.lang.Object r0 = r0.apply(r3)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L3b
            if (r0 != 0) goto L37
            goto L3b
        L37:
            int r2 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L3b
        L3b:
            bf.f.f4914b = r2
            start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bf.f.<clinit>():void");
    }

    public static ScheduledExecutorService create(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (f4913a && (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            f4916d.put((ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool, scheduledExecutorServiceNewScheduledThreadPool);
        }
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static void start() {
        if (!f4913a) {
            return;
        }
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f4915c;
            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            boolean z10 = true;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            while (true) {
                if (atomicReference.compareAndSet(scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                    break;
                } else if (atomicReference.get() != scheduledExecutorService) {
                    z10 = false;
                    break;
                }
            }
            if (z10) {
                a aVar = new a();
                long j10 = f4914b;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(aVar, j10, j10, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }
}
