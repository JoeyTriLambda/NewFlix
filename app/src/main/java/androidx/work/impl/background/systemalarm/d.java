package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import f3.m;
import g3.p;
import g3.t;
import g3.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import w2.g;
import x2.e;
import x2.e0;
import x2.r;
import x2.w;

/* compiled from: SystemAlarmDispatcher.java */
/* loaded from: classes.dex */
public final class d implements e {

    /* renamed from: u, reason: collision with root package name */
    public static final String f4561u = g.tagWithPrefix("SystemAlarmDispatcher");

    /* renamed from: b, reason: collision with root package name */
    public final Context f4562b;

    /* renamed from: m, reason: collision with root package name */
    public final i3.c f4563m;

    /* renamed from: n, reason: collision with root package name */
    public final y f4564n;

    /* renamed from: o, reason: collision with root package name */
    public final r f4565o;

    /* renamed from: p, reason: collision with root package name */
    public final e0 f4566p;

    /* renamed from: q, reason: collision with root package name */
    public final androidx.work.impl.background.systemalarm.a f4567q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f4568r;

    /* renamed from: s, reason: collision with root package name */
    public Intent f4569s;

    /* renamed from: t, reason: collision with root package name */
    public c f4570t;

    /* compiled from: SystemAlarmDispatcher.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Executor mainThreadExecutor;
            RunnableC0050d runnableC0050d;
            synchronized (d.this.f4568r) {
                d dVar = d.this;
                dVar.f4569s = (Intent) dVar.f4568r.get(0);
            }
            Intent intent = d.this.f4569s;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = d.this.f4569s.getIntExtra("KEY_START_ID", 0);
                g gVar = g.get();
                String str = d.f4561u;
                gVar.debug(str, "Processing command " + d.this.f4569s + ", " + intExtra);
                PowerManager.WakeLock wakeLockNewWakeLock = t.newWakeLock(d.this.f4562b, action + " (" + intExtra + ")");
                try {
                    g.get().debug(str, "Acquiring operation wake lock (" + action + ") " + wakeLockNewWakeLock);
                    wakeLockNewWakeLock.acquire();
                    d dVar2 = d.this;
                    dVar2.f4567q.b(intExtra, dVar2.f4569s, dVar2);
                    g.get().debug(str, "Releasing operation wake lock (" + action + ") " + wakeLockNewWakeLock);
                    wakeLockNewWakeLock.release();
                    mainThreadExecutor = ((i3.d) d.this.f4563m).getMainThreadExecutor();
                    runnableC0050d = new RunnableC0050d(d.this);
                } catch (Throwable th2) {
                    try {
                        g gVar2 = g.get();
                        String str2 = d.f4561u;
                        gVar2.error(str2, "Unexpected error in onHandleIntent", th2);
                        g.get().debug(str2, "Releasing operation wake lock (" + action + ") " + wakeLockNewWakeLock);
                        wakeLockNewWakeLock.release();
                        mainThreadExecutor = ((i3.d) d.this.f4563m).getMainThreadExecutor();
                        runnableC0050d = new RunnableC0050d(d.this);
                    } catch (Throwable th3) {
                        g.get().debug(d.f4561u, "Releasing operation wake lock (" + action + ") " + wakeLockNewWakeLock);
                        wakeLockNewWakeLock.release();
                        ((i3.d) d.this.f4563m).getMainThreadExecutor().execute(new RunnableC0050d(d.this));
                        throw th3;
                    }
                }
                mainThreadExecutor.execute(runnableC0050d);
            }
        }
    }

    /* compiled from: SystemAlarmDispatcher.java */
    public static class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final d f4572b;

        /* renamed from: m, reason: collision with root package name */
        public final Intent f4573m;

        /* renamed from: n, reason: collision with root package name */
        public final int f4574n;

        public b(int i10, Intent intent, d dVar) {
            this.f4572b = dVar;
            this.f4573m = intent;
            this.f4574n = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4572b.add(this.f4573m, this.f4574n);
        }
    }

    /* compiled from: SystemAlarmDispatcher.java */
    public interface c {
        void onAllCommandsCompleted();
    }

    /* compiled from: SystemAlarmDispatcher.java */
    /* renamed from: androidx.work.impl.background.systemalarm.d$d, reason: collision with other inner class name */
    public static class RunnableC0050d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final d f4575b;

        public RunnableC0050d(d dVar) {
            this.f4575b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.f4575b;
            dVar.getClass();
            g gVar = g.get();
            String str = d.f4561u;
            gVar.debug(str, "Checking if commands are complete.");
            d.a();
            synchronized (dVar.f4568r) {
                if (dVar.f4569s != null) {
                    g.get().debug(str, "Removing command " + dVar.f4569s);
                    if (!((Intent) dVar.f4568r.remove(0)).equals(dVar.f4569s)) {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                    dVar.f4569s = null;
                }
                i3.a aVarM31getSerialTaskExecutor = ((i3.d) dVar.f4563m).m31getSerialTaskExecutor();
                if (!dVar.f4567q.a() && dVar.f4568r.isEmpty() && !((p) aVarM31getSerialTaskExecutor).hasPendingTasks()) {
                    g.get().debug(str, "No more commands & intents.");
                    c cVar = dVar.f4570t;
                    if (cVar != null) {
                        cVar.onAllCommandsCompleted();
                    }
                } else if (!dVar.f4568r.isEmpty()) {
                    dVar.c();
                }
            }
        }
    }

    public d(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f4562b = applicationContext;
        this.f4567q = new androidx.work.impl.background.systemalarm.a(applicationContext, new w());
        e0 e0Var = e0.getInstance(context);
        this.f4566p = e0Var;
        this.f4564n = new y(e0Var.getConfiguration().getRunnableScheduler());
        r processor = e0Var.getProcessor();
        this.f4565o = processor;
        this.f4563m = e0Var.getWorkTaskExecutor();
        processor.addExecutionListener(this);
        this.f4568r = new ArrayList();
        this.f4569s = null;
    }

    public static void a() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public boolean add(Intent intent, int i10) {
        g gVar = g.get();
        String str = f4561u;
        gVar.debug(str, "Adding command " + intent + " (" + i10 + ")");
        a();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            g.get().warning(str, "Unknown command. Ignoring");
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && b()) {
            return false;
        }
        intent.putExtra("KEY_START_ID", i10);
        synchronized (this.f4568r) {
            boolean z10 = !this.f4568r.isEmpty();
            this.f4568r.add(intent);
            if (!z10) {
                c();
            }
        }
        return true;
    }

    public final boolean b() {
        a();
        synchronized (this.f4568r) {
            Iterator it = this.f4568r.iterator();
            while (it.hasNext()) {
                if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) it.next()).getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    public final void c() {
        a();
        PowerManager.WakeLock wakeLockNewWakeLock = t.newWakeLock(this.f4562b, "ProcessCommand");
        try {
            wakeLockNewWakeLock.acquire();
            i3.c workTaskExecutor = this.f4566p.getWorkTaskExecutor();
            a aVar = new a();
            i3.d dVar = (i3.d) workTaskExecutor;
            dVar.getClass();
            i3.b.a(dVar, aVar);
        } finally {
            wakeLockNewWakeLock.release();
        }
    }

    @Override // x2.e
    public void onExecuted(m mVar, boolean z10) {
        Executor mainThreadExecutor = ((i3.d) this.f4563m).getMainThreadExecutor();
        String str = androidx.work.impl.background.systemalarm.a.f4539p;
        Intent intent = new Intent(this.f4562b, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z10);
        androidx.work.impl.background.systemalarm.a.d(intent, mVar);
        mainThreadExecutor.execute(new b(0, intent, this));
    }
}
