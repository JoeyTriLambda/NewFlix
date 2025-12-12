package g3;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import w2.i;
import x2.e0;

/* compiled from: EnqueueRunnable.java */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: n, reason: collision with root package name */
    public static final String f12641n = w2.g.tagWithPrefix("EnqueueRunnable");

    /* renamed from: b, reason: collision with root package name */
    public final x2.x f12642b;

    /* renamed from: m, reason: collision with root package name */
    public final x2.o f12643m;

    public c(x2.x xVar) {
        this(xVar, new x2.o());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01e7  */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(x2.x r24) {
        /*
            Method dump skipped, instructions count: 614
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.c.a(x2.x):boolean");
    }

    public boolean addToDatabase() {
        x2.x xVar = this.f12642b;
        WorkDatabase workDatabase = xVar.getWorkManagerImpl().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            boolean zA = a(xVar);
            workDatabase.setTransactionSuccessful();
            return zA;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public w2.i getOperation() {
        return this.f12643m;
    }

    @Override // java.lang.Runnable
    public void run() {
        x2.o oVar = this.f12643m;
        x2.x xVar = this.f12642b;
        try {
            if (xVar.hasCycles()) {
                throw new IllegalStateException("WorkContinuation has cycles (" + xVar + ")");
            }
            if (addToDatabase()) {
                m.setComponentEnabled(xVar.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                scheduleWorkInBackground();
            }
            oVar.markState(w2.i.f20882a);
        } catch (Throwable th2) {
            oVar.markState(new i.a.C0303a(th2));
        }
    }

    public void scheduleWorkInBackground() {
        e0 workManagerImpl = this.f12642b.getWorkManagerImpl();
        x2.u.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    public c(x2.x xVar, x2.o oVar) {
        this.f12642b = xVar;
        this.f12643m = oVar;
    }
}
