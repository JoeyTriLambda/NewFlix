package g3;

import androidx.work.impl.WorkDatabase;
import java.util.concurrent.Callable;

/* compiled from: IdGenerator.kt */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase f12649a;

    public g(WorkDatabase workDatabase) {
        zf.i.checkNotNullParameter(workDatabase, "workDatabase");
        this.f12649a = workDatabase;
    }

    public final int nextAlarmManagerId() {
        Object objRunInTransaction = this.f12649a.runInTransaction(new e(this, 0));
        zf.i.checkNotNullExpressionValue(objRunInTransaction, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        return ((Number) objRunInTransaction).intValue();
    }

    public final int nextJobSchedulerIdWithRange(final int i10, final int i11) {
        Object objRunInTransaction = this.f12649a.runInTransaction((Callable<Object>) new Callable() { // from class: g3.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                g gVar = this.f12646b;
                zf.i.checkNotNullParameter(gVar, "this$0");
                int iAccess$nextId = h.access$nextId(gVar.f12649a, "next_job_scheduler_id");
                int i12 = i10;
                if (!(i12 <= iAccess$nextId && iAccess$nextId <= i11)) {
                    gVar.f12649a.preferenceDao().insertPreference(new f3.d("next_job_scheduler_id", Long.valueOf(i12 + 1)));
                    iAccess$nextId = i12;
                }
                return Integer.valueOf(iAccess$nextId);
            }
        });
        zf.i.checkNotNullExpressionValue(objRunInTransaction, "workDatabase.runInTransa…            id\n        })");
        return ((Number) objRunInTransaction).intValue();
    }
}
