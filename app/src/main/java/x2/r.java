package x2;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import org.apache.commons.lang3.StringUtils;
import x2.k0;

/* compiled from: Processor.java */
/* loaded from: classes.dex */
public final class r implements e, e3.a {

    /* renamed from: x, reason: collision with root package name */
    public static final String f21465x = w2.g.tagWithPrefix("Processor");

    /* renamed from: m, reason: collision with root package name */
    public final Context f21467m;

    /* renamed from: n, reason: collision with root package name */
    public final androidx.work.a f21468n;

    /* renamed from: o, reason: collision with root package name */
    public final i3.c f21469o;

    /* renamed from: p, reason: collision with root package name */
    public final WorkDatabase f21470p;

    /* renamed from: t, reason: collision with root package name */
    public final List<t> f21474t;

    /* renamed from: r, reason: collision with root package name */
    public final HashMap f21472r = new HashMap();

    /* renamed from: q, reason: collision with root package name */
    public final HashMap f21471q = new HashMap();

    /* renamed from: u, reason: collision with root package name */
    public final HashSet f21475u = new HashSet();

    /* renamed from: v, reason: collision with root package name */
    public final ArrayList f21476v = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public PowerManager.WakeLock f21466b = null;

    /* renamed from: w, reason: collision with root package name */
    public final Object f21477w = new Object();

    /* renamed from: s, reason: collision with root package name */
    public final HashMap f21473s = new HashMap();

    /* compiled from: Processor.java */
    public static class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final e f21478b;

        /* renamed from: m, reason: collision with root package name */
        public final f3.m f21479m;

        /* renamed from: n, reason: collision with root package name */
        public final e8.c<Boolean> f21480n;

        public a(e eVar, f3.m mVar, e8.c<Boolean> cVar) {
            this.f21478b = eVar;
            this.f21479m = mVar;
            this.f21480n = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zBooleanValue;
            try {
                zBooleanValue = this.f21480n.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                zBooleanValue = true;
            }
            this.f21478b.onExecuted(this.f21479m, zBooleanValue);
        }
    }

    public r(Context context, androidx.work.a aVar, i3.c cVar, WorkDatabase workDatabase, List<t> list) {
        this.f21467m = context;
        this.f21468n = aVar;
        this.f21469o = cVar;
        this.f21470p = workDatabase;
        this.f21474t = list;
    }

    public static boolean a(k0 k0Var, String str) {
        String str2 = f21465x;
        if (k0Var == null) {
            w2.g.get().debug(str2, "WorkerWrapper could not be found for " + str);
            return false;
        }
        k0Var.interrupt();
        w2.g.get().debug(str2, "WorkerWrapper interrupted for " + str);
        return true;
    }

    public void addExecutionListener(e eVar) {
        synchronized (this.f21477w) {
            this.f21476v.add(eVar);
        }
    }

    public final void b(final f3.m mVar) {
        ((i3.d) this.f21469o).getMainThreadExecutor().execute(new Runnable() { // from class: x2.q

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ boolean f21464n = false;

            @Override // java.lang.Runnable
            public final void run() {
                this.f21462b.onExecuted(mVar, this.f21464n);
            }
        });
    }

    public final void c() {
        synchronized (this.f21477w) {
            if (!(!this.f21471q.isEmpty())) {
                try {
                    this.f21467m.startService(androidx.work.impl.foreground.a.createStopForegroundIntent(this.f21467m));
                } catch (Throwable th2) {
                    w2.g.get().error(f21465x, "Unable to stop foreground service", th2);
                }
                PowerManager.WakeLock wakeLock = this.f21466b;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.f21466b = null;
                }
            }
        }
    }

    public f3.t getRunningWorkSpec(String str) {
        synchronized (this.f21477w) {
            k0 k0Var = (k0) this.f21471q.get(str);
            if (k0Var == null) {
                k0Var = (k0) this.f21472r.get(str);
            }
            if (k0Var == null) {
                return null;
            }
            return k0Var.getWorkSpec();
        }
    }

    public boolean isCancelled(String str) {
        boolean zContains;
        synchronized (this.f21477w) {
            zContains = this.f21475u.contains(str);
        }
        return zContains;
    }

    public boolean isEnqueued(String str) {
        boolean z10;
        synchronized (this.f21477w) {
            z10 = this.f21472r.containsKey(str) || this.f21471q.containsKey(str);
        }
        return z10;
    }

    public boolean isEnqueuedInForeground(String str) {
        boolean zContainsKey;
        synchronized (this.f21477w) {
            zContainsKey = this.f21471q.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // x2.e
    public void onExecuted(f3.m mVar, boolean z10) {
        synchronized (this.f21477w) {
            k0 k0Var = (k0) this.f21472r.get(mVar.getWorkSpecId());
            if (k0Var != null && mVar.equals(k0Var.getWorkGenerationalId())) {
                this.f21472r.remove(mVar.getWorkSpecId());
            }
            w2.g.get().debug(f21465x, r.class.getSimpleName() + StringUtils.SPACE + mVar.getWorkSpecId() + " executed; reschedule = " + z10);
            Iterator it = this.f21476v.iterator();
            while (it.hasNext()) {
                ((e) it.next()).onExecuted(mVar, z10);
            }
        }
    }

    public void removeExecutionListener(e eVar) {
        synchronized (this.f21477w) {
            this.f21476v.remove(eVar);
        }
    }

    public void startForeground(String str, w2.c cVar) {
        synchronized (this.f21477w) {
            w2.g.get().info(f21465x, "Moving WorkSpec (" + str + ") to the foreground");
            k0 k0Var = (k0) this.f21472r.remove(str);
            if (k0Var != null) {
                if (this.f21466b == null) {
                    PowerManager.WakeLock wakeLockNewWakeLock = g3.t.newWakeLock(this.f21467m, "ProcessorForegroundLck");
                    this.f21466b = wakeLockNewWakeLock;
                    wakeLockNewWakeLock.acquire();
                }
                this.f21471q.put(str, k0Var);
                m0.a.startForegroundService(this.f21467m, androidx.work.impl.foreground.a.createStartForegroundIntent(this.f21467m, k0Var.getWorkGenerationalId(), cVar));
            }
        }
    }

    public boolean startWork(v vVar) {
        return startWork(vVar, null);
    }

    public boolean stopAndCancelWork(String str) {
        k0 k0Var;
        boolean z10;
        synchronized (this.f21477w) {
            w2.g.get().debug(f21465x, "Processor cancelling " + str);
            this.f21475u.add(str);
            k0Var = (k0) this.f21471q.remove(str);
            z10 = k0Var != null;
            if (k0Var == null) {
                k0Var = (k0) this.f21472r.remove(str);
            }
            if (k0Var != null) {
                this.f21473s.remove(str);
            }
        }
        boolean zA = a(k0Var, str);
        if (z10) {
            c();
        }
        return zA;
    }

    public void stopForeground(String str) {
        synchronized (this.f21477w) {
            this.f21471q.remove(str);
            c();
        }
    }

    public boolean stopForegroundWork(v vVar) {
        k0 k0Var;
        String workSpecId = vVar.getId().getWorkSpecId();
        synchronized (this.f21477w) {
            w2.g.get().debug(f21465x, "Processor stopping foreground work " + workSpecId);
            k0Var = (k0) this.f21471q.remove(workSpecId);
            if (k0Var != null) {
                this.f21473s.remove(workSpecId);
            }
        }
        return a(k0Var, workSpecId);
    }

    public boolean stopWork(v vVar) {
        String workSpecId = vVar.getId().getWorkSpecId();
        synchronized (this.f21477w) {
            k0 k0Var = (k0) this.f21472r.remove(workSpecId);
            if (k0Var == null) {
                w2.g.get().debug(f21465x, "WorkerWrapper could not be found for " + workSpecId);
                return false;
            }
            Set set = (Set) this.f21473s.get(workSpecId);
            if (set != null && set.contains(vVar)) {
                w2.g.get().debug(f21465x, "Processor stopping background work " + workSpecId);
                this.f21473s.remove(workSpecId);
                return a(k0Var, workSpecId);
            }
            return false;
        }
    }

    public boolean startWork(v vVar, WorkerParameters.a aVar) {
        f3.m id2 = vVar.getId();
        String workSpecId = id2.getWorkSpecId();
        ArrayList arrayList = new ArrayList();
        f3.t tVar = (f3.t) this.f21470p.runInTransaction(new p(0, this, arrayList, workSpecId));
        if (tVar == null) {
            w2.g.get().warning(f21465x, "Didn't find WorkSpec for id " + id2);
            b(id2);
            return false;
        }
        synchronized (this.f21477w) {
            if (isEnqueued(workSpecId)) {
                Set set = (Set) this.f21473s.get(workSpecId);
                if (((v) set.iterator().next()).getId().getGeneration() == id2.getGeneration()) {
                    set.add(vVar);
                    w2.g.get().debug(f21465x, "Work " + id2 + " is already enqueued for processing");
                } else {
                    b(id2);
                }
                return false;
            }
            if (tVar.getGeneration() != id2.getGeneration()) {
                b(id2);
                return false;
            }
            k0 k0VarBuild = new k0.a(this.f21467m, this.f21468n, this.f21469o, this, this.f21470p, tVar, arrayList).withSchedulers(this.f21474t).withRuntimeExtras(aVar).build();
            e8.c<Boolean> future = k0VarBuild.getFuture();
            future.addListener(new a(this, vVar.getId(), future), ((i3.d) this.f21469o).getMainThreadExecutor());
            this.f21472r.put(workSpecId, k0VarBuild);
            HashSet hashSet = new HashSet();
            hashSet.add(vVar);
            this.f21473s.put(workSpecId, hashSet);
            ((g3.p) ((i3.d) this.f21469o).m31getSerialTaskExecutor()).execute(k0VarBuild);
            w2.g.get().debug(f21465x, r.class.getSimpleName() + ": processing " + id2);
            return true;
        }
    }
}
