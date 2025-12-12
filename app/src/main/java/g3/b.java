package g3;

import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import w2.i;
import x2.e0;

/* compiled from: CancelWorkRunnable.java */
/* loaded from: classes.dex */
public abstract class b implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final x2.o f12635b = new x2.o();

    /* compiled from: CancelWorkRunnable.java */
    public class a extends b {

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ e0 f12636m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ UUID f12637n;

        public a(UUID uuid, e0 e0Var) {
            this.f12636m = e0Var;
            this.f12637n = uuid;
        }

        @Override // g3.b
        public final void b() {
            e0 e0Var = this.f12636m;
            WorkDatabase workDatabase = e0Var.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                b.a(e0Var, this.f12637n.toString());
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                x2.u.schedule(e0Var.getConfiguration(), e0Var.getWorkDatabase(), e0Var.getSchedulers());
            } catch (Throwable th2) {
                workDatabase.endTransaction();
                throw th2;
            }
        }
    }

    /* compiled from: CancelWorkRunnable.java */
    /* renamed from: g3.b$b, reason: collision with other inner class name */
    public class C0152b extends b {

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ e0 f12638m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f12639n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ boolean f12640o;

        public C0152b(String str, e0 e0Var, boolean z10) {
            this.f12638m = e0Var;
            this.f12639n = str;
            this.f12640o = z10;
        }

        @Override // g3.b
        public final void b() {
            e0 e0Var = this.f12638m;
            WorkDatabase workDatabase = e0Var.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                Iterator<String> it = workDatabase.workSpecDao().getUnfinishedWorkWithName(this.f12639n).iterator();
                while (it.hasNext()) {
                    b.a(e0Var, it.next());
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (this.f12640o) {
                    x2.u.schedule(e0Var.getConfiguration(), e0Var.getWorkDatabase(), e0Var.getSchedulers());
                }
            } catch (Throwable th2) {
                workDatabase.endTransaction();
                throw th2;
            }
        }
    }

    public static void a(e0 e0Var, String str) {
        WorkDatabase workDatabase = e0Var.getWorkDatabase();
        f3.u uVarWorkSpecDao = workDatabase.workSpecDao();
        f3.b bVarDependencyDao = workDatabase.dependencyDao();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo$State state = uVarWorkSpecDao.getState(str2);
            if (state != WorkInfo$State.SUCCEEDED && state != WorkInfo$State.FAILED) {
                uVarWorkSpecDao.setState(WorkInfo$State.CANCELLED, str2);
            }
            linkedList.addAll(bVarDependencyDao.getDependentWorkIds(str2));
        }
        e0Var.getProcessor().stopAndCancelWork(str);
        Iterator<x2.t> it = e0Var.getSchedulers().iterator();
        while (it.hasNext()) {
            it.next().cancel(str);
        }
    }

    public static b forId(UUID uuid, e0 e0Var) {
        return new a(uuid, e0Var);
    }

    public static b forName(String str, e0 e0Var, boolean z10) {
        return new C0152b(str, e0Var, z10);
    }

    public abstract void b();

    public w2.i getOperation() {
        return this.f12635b;
    }

    @Override // java.lang.Runnable
    public void run() {
        x2.o oVar = this.f12635b;
        try {
            b();
            oVar.markState(w2.i.f20882a);
        } catch (Throwable th2) {
            oVar.markState(new i.a.C0303a(th2));
        }
    }
}
