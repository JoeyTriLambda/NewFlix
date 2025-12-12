package androidx.work.impl;

import ac.c;
import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkInfo$State;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkerUpdater;
import com.unity3d.ads.metadata.MediationMetaData;
import f3.t;
import g3.p;
import i3.d;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lf.h;
import mf.j;
import okhttp3.internal.http2.Http2;
import w2.i;
import w2.o;
import x2.e0;
import x2.r;
import x2.u;
import x2.x;
import yf.l;
import zf.i;

/* compiled from: WorkerUpdater.kt */
/* loaded from: classes.dex */
public final class WorkerUpdater {
    public static final void a(r rVar, final WorkDatabase workDatabase, a aVar, final List list, final t tVar, final Set set) {
        final String str = tVar.f11426a;
        final t workSpec = workDatabase.workSpecDao().getWorkSpec(str);
        if (workSpec == null) {
            throw new IllegalArgumentException(c.k("Worker with ", str, " doesn't exist"));
        }
        if (workSpec.f11427b.isFinished()) {
            return;
        }
        if (workSpec.isPeriodic() ^ tVar.isPeriodic()) {
            StringBuilder sb2 = new StringBuilder("Can't update ");
            WorkerUpdater$updateWorkImpl$type$1 workerUpdater$updateWorkImpl$type$1 = new l<t, String>() { // from class: androidx.work.impl.WorkerUpdater$updateWorkImpl$type$1
                @Override // yf.l
                public final String invoke(t tVar2) {
                    i.checkNotNullParameter(tVar2, "spec");
                    return tVar2.isPeriodic() ? "Periodic" : "OneTime";
                }
            };
            sb2.append(workerUpdater$updateWorkImpl$type$1.invoke((WorkerUpdater$updateWorkImpl$type$1) workSpec));
            sb2.append(" Worker to ");
            throw new UnsupportedOperationException(c.o(sb2, workerUpdater$updateWorkImpl$type$1.invoke((WorkerUpdater$updateWorkImpl$type$1) tVar), " Worker. Update operation must preserve worker's type."));
        }
        final boolean zIsEnqueued = rVar.isEnqueued(str);
        if (!zIsEnqueued) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((x2.t) it.next()).cancel(str);
            }
        }
        workDatabase.runInTransaction(new Runnable() { // from class: x2.h0
            @Override // java.lang.Runnable
            public final void run() {
                f3.t tVar2 = tVar;
                WorkDatabase workDatabase2 = workDatabase;
                zf.i.checkNotNullParameter(workDatabase2, "$workDatabase");
                zf.i.checkNotNullParameter(tVar2, "$newWorkSpec");
                f3.t tVar3 = workSpec;
                zf.i.checkNotNullParameter(tVar3, "$oldWorkSpec");
                List list2 = list;
                zf.i.checkNotNullParameter(list2, "$schedulers");
                String str2 = str;
                zf.i.checkNotNullParameter(str2, "$workSpecId");
                Set<String> set2 = set;
                zf.i.checkNotNullParameter(set2, "$tags");
                f3.u uVarWorkSpecDao = workDatabase2.workSpecDao();
                f3.y yVarWorkTagDao = workDatabase2.workTagDao();
                uVarWorkSpecDao.updateWorkSpec(g3.d.wrapInConstraintTrackingWorkerIfNeeded(list2, tVar2.copy((1048555 & 1) != 0 ? tVar2.f11426a : null, (1048555 & 2) != 0 ? tVar2.f11427b : tVar3.f11427b, (1048555 & 4) != 0 ? tVar2.f11428c : null, (1048555 & 8) != 0 ? tVar2.f11429d : null, (1048555 & 16) != 0 ? tVar2.f11430e : null, (1048555 & 32) != 0 ? tVar2.f11431f : null, (1048555 & 64) != 0 ? tVar2.f11432g : 0L, (1048555 & 128) != 0 ? tVar2.f11433h : 0L, (1048555 & 256) != 0 ? tVar2.f11434i : 0L, (1048555 & 512) != 0 ? tVar2.f11435j : null, (1048555 & 1024) != 0 ? tVar2.f11436k : tVar3.f11436k, (1048555 & 2048) != 0 ? tVar2.f11437l : null, (1048555 & 4096) != 0 ? tVar2.f11438m : 0L, (1048555 & 8192) != 0 ? tVar2.f11439n : tVar3.f11439n, (1048555 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? tVar2.f11440o : 0L, (1048555 & 32768) != 0 ? tVar2.f11441p : 0L, (1048555 & 65536) != 0 ? tVar2.f11442q : false, (131072 & 1048555) != 0 ? tVar2.f11443r : null, (1048555 & 262144) != 0 ? tVar2.f11444s : 0, (1048555 & 524288) != 0 ? tVar2.f11445t : tVar3.getGeneration() + 1)));
                yVarWorkTagDao.deleteByWorkSpecId(str2);
                yVarWorkTagDao.insertTags(str2, set2);
                if (zIsEnqueued) {
                    return;
                }
                uVarWorkSpecDao.markWorkSpecScheduled(str2, -1L);
                workDatabase2.workProgressDao().delete(str2);
            }
        });
        if (zIsEnqueued) {
            return;
        }
        u.schedule(aVar, workDatabase, list);
    }

    public static final w2.i enqueueUniquelyNamedPeriodic(final e0 e0Var, final String str, final o oVar) {
        i.checkNotNullParameter(e0Var, "<this>");
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        i.checkNotNullParameter(oVar, "workRequest");
        final x2.o oVar2 = new x2.o();
        final yf.a<h> aVar = new yf.a<h>() { // from class: androidx.work.impl.WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // yf.a
            public /* bridge */ /* synthetic */ h invoke() {
                invoke2();
                return h.f16056a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List listListOf = j.listOf(oVar);
                new g3.c(new x(e0Var, str, ExistingWorkPolicy.KEEP, listListOf), oVar2).run();
            }
        };
        ((p) ((d) e0Var.getWorkTaskExecutor()).m31getSerialTaskExecutor()).execute(new Runnable() { // from class: x2.g0
            @Override // java.lang.Runnable
            public final void run() {
                e0 e0Var2 = e0Var;
                zf.i.checkNotNullParameter(e0Var2, "$this_enqueueUniquelyNamedPeriodic");
                String str2 = str;
                zf.i.checkNotNullParameter(str2, "$name");
                o oVar3 = oVar2;
                zf.i.checkNotNullParameter(oVar3, "$operation");
                yf.a aVar2 = aVar;
                zf.i.checkNotNullParameter(aVar2, "$enqueueNew");
                w2.o oVar4 = oVar;
                zf.i.checkNotNullParameter(oVar4, "$workRequest");
                f3.u uVarWorkSpecDao = e0Var2.getWorkDatabase().workSpecDao();
                List<t.b> workSpecIdAndStatesForName = uVarWorkSpecDao.getWorkSpecIdAndStatesForName(str2);
                if (workSpecIdAndStatesForName.size() > 1) {
                    oVar3.markState(new i.a.C0303a(new UnsupportedOperationException("Can't apply UPDATE policy to the chains of work.")));
                    return;
                }
                t.b bVar = (t.b) mf.q.firstOrNull(workSpecIdAndStatesForName);
                if (bVar == null) {
                    aVar2.invoke();
                    return;
                }
                String str3 = bVar.f11446a;
                f3.t workSpec = uVarWorkSpecDao.getWorkSpec(str3);
                if (workSpec == null) {
                    oVar3.markState(new i.a.C0303a(new IllegalStateException("WorkSpec with " + str3 + ", that matches a name \"" + str2 + "\", wasn't found")));
                    return;
                }
                if (!workSpec.isPeriodic()) {
                    oVar3.markState(new i.a.C0303a(new UnsupportedOperationException("Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.")));
                    return;
                }
                if (bVar.f11447b == WorkInfo$State.CANCELLED) {
                    uVarWorkSpecDao.delete(str3);
                    aVar2.invoke();
                    return;
                }
                f3.t workSpec2 = oVar4.getWorkSpec();
                f3.t tVarCopy = workSpec2.copy((1048555 & 1) != 0 ? workSpec2.f11426a : bVar.f11446a, (1048555 & 2) != 0 ? workSpec2.f11427b : null, (1048555 & 4) != 0 ? workSpec2.f11428c : null, (1048555 & 8) != 0 ? workSpec2.f11429d : null, (1048555 & 16) != 0 ? workSpec2.f11430e : null, (1048555 & 32) != 0 ? workSpec2.f11431f : null, (1048555 & 64) != 0 ? workSpec2.f11432g : 0L, (1048555 & 128) != 0 ? workSpec2.f11433h : 0L, (1048555 & 256) != 0 ? workSpec2.f11434i : 0L, (1048555 & 512) != 0 ? workSpec2.f11435j : null, (1048555 & 1024) != 0 ? workSpec2.f11436k : 0, (1048555 & 2048) != 0 ? workSpec2.f11437l : null, (1048555 & 4096) != 0 ? workSpec2.f11438m : 0L, (1048555 & 8192) != 0 ? workSpec2.f11439n : 0L, (1048555 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? workSpec2.f11440o : 0L, (1048555 & 32768) != 0 ? workSpec2.f11441p : 0L, (1048555 & 65536) != 0 ? workSpec2.f11442q : false, (131072 & 1048555) != 0 ? workSpec2.f11443r : null, (1048555 & 262144) != 0 ? workSpec2.f11444s : 0, (1048555 & 524288) != 0 ? workSpec2.f11445t : 0);
                try {
                    r processor = e0Var2.getProcessor();
                    zf.i.checkNotNullExpressionValue(processor, "processor");
                    WorkDatabase workDatabase = e0Var2.getWorkDatabase();
                    zf.i.checkNotNullExpressionValue(workDatabase, "workDatabase");
                    androidx.work.a configuration = e0Var2.getConfiguration();
                    zf.i.checkNotNullExpressionValue(configuration, "configuration");
                    List<t> schedulers = e0Var2.getSchedulers();
                    zf.i.checkNotNullExpressionValue(schedulers, "schedulers");
                    WorkerUpdater.a(processor, workDatabase, configuration, schedulers, tVarCopy, oVar4.getTags());
                    oVar3.markState(w2.i.f20882a);
                } catch (Throwable th2) {
                    oVar3.markState(new i.a.C0303a(th2));
                }
            }
        });
        return oVar2;
    }
}
