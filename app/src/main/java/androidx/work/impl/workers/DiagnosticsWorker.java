package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.c;
import androidx.work.impl.WorkDatabase;
import f3.j;
import f3.o;
import f3.t;
import f3.u;
import f3.y;
import j3.b;
import java.util.List;
import java.util.concurrent.TimeUnit;
import w2.g;
import x2.e0;
import zf.i;

/* compiled from: DiagnosticsWorker.kt */
/* loaded from: classes.dex */
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        i.checkNotNullParameter(context, "context");
        i.checkNotNullParameter(workerParameters, "parameters");
    }

    @Override // androidx.work.Worker
    public c.a doWork() {
        e0 e0Var = e0.getInstance(getApplicationContext());
        i.checkNotNullExpressionValue(e0Var, "getInstance(applicationContext)");
        WorkDatabase workDatabase = e0Var.getWorkDatabase();
        i.checkNotNullExpressionValue(workDatabase, "workManager.workDatabase");
        u uVarWorkSpecDao = workDatabase.workSpecDao();
        o oVarWorkNameDao = workDatabase.workNameDao();
        y yVarWorkTagDao = workDatabase.workTagDao();
        j jVarSystemIdInfoDao = workDatabase.systemIdInfoDao();
        List<t> recentlyCompletedWork = uVarWorkSpecDao.getRecentlyCompletedWork(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List<t> runningWork = uVarWorkSpecDao.getRunningWork();
        List<t> allEligibleWorkSpecsForScheduling = uVarWorkSpecDao.getAllEligibleWorkSpecsForScheduling(200);
        if (!recentlyCompletedWork.isEmpty()) {
            g.get().info(b.f14583a, "Recently completed work:\n\n");
            g.get().info(b.f14583a, b.access$workSpecRows(oVarWorkNameDao, yVarWorkTagDao, jVarSystemIdInfoDao, recentlyCompletedWork));
        }
        if (!runningWork.isEmpty()) {
            g.get().info(b.f14583a, "Running work:\n\n");
            g.get().info(b.f14583a, b.access$workSpecRows(oVarWorkNameDao, yVarWorkTagDao, jVarSystemIdInfoDao, runningWork));
        }
        if (!allEligibleWorkSpecsForScheduling.isEmpty()) {
            g.get().info(b.f14583a, "Enqueued work:\n\n");
            g.get().info(b.f14583a, b.access$workSpecRows(oVarWorkNameDao, yVarWorkTagDao, jVarSystemIdInfoDao, allEligibleWorkSpecsForScheduling));
        }
        c.a aVarSuccess = c.a.success();
        i.checkNotNullExpressionValue(aVarSuccess, "success()");
        return aVarSuccess;
    }
}
