package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.c;
import zf.i;

/* compiled from: CombineContinuationsWorker.kt */
/* loaded from: classes.dex */
public final class CombineContinuationsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineContinuationsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        i.checkNotNullParameter(context, "context");
        i.checkNotNullParameter(workerParameters, "workerParams");
    }

    @Override // androidx.work.Worker
    public c.a doWork() {
        c.a aVarSuccess = c.a.success(getInputData());
        i.checkNotNullExpressionValue(aVarSuccess, "success(inputData)");
        return aVarSuccess;
    }
}
