package x2;

import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import java.util.List;

/* compiled from: Schedulers.java */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final String f21482a = w2.g.tagWithPrefix("Schedulers");

    public static void schedule(androidx.work.a aVar, WorkDatabase workDatabase, List<t> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        f3.u uVarWorkSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            List<f3.t> eligibleWorkForScheduling = uVarWorkSpecDao.getEligibleWorkForScheduling(aVar.getMaxSchedulerLimit());
            List<f3.t> allEligibleWorkSpecsForScheduling = uVarWorkSpecDao.getAllEligibleWorkSpecsForScheduling(200);
            if (eligibleWorkForScheduling != null && eligibleWorkForScheduling.size() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Iterator<f3.t> it = eligibleWorkForScheduling.iterator();
                while (it.hasNext()) {
                    uVarWorkSpecDao.markWorkSpecScheduled(it.next().f11426a, jCurrentTimeMillis);
                }
            }
            workDatabase.setTransactionSuccessful();
            if (eligibleWorkForScheduling != null && eligibleWorkForScheduling.size() > 0) {
                f3.t[] tVarArr = (f3.t[]) eligibleWorkForScheduling.toArray(new f3.t[eligibleWorkForScheduling.size()]);
                for (t tVar : list) {
                    if (tVar.hasLimitedSchedulingSlots()) {
                        tVar.schedule(tVarArr);
                    }
                }
            }
            if (allEligibleWorkSpecsForScheduling == null || allEligibleWorkSpecsForScheduling.size() <= 0) {
                return;
            }
            f3.t[] tVarArr2 = (f3.t[]) allEligibleWorkSpecsForScheduling.toArray(new f3.t[allEligibleWorkSpecsForScheduling.size()]);
            for (t tVar2 : list) {
                if (!tVar2.hasLimitedSchedulingSlots()) {
                    tVar2.schedule(tVarArr2);
                }
            }
        } finally {
            workDatabase.endTransaction();
        }
    }
}
