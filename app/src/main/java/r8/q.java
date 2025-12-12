package r8;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* compiled from: CrashlyticsController.java */
/* loaded from: classes.dex */
public final class q implements SuccessContinuation<Void, Boolean> {
    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task<Boolean> then(Void r12) throws Exception {
        return Tasks.forResult(Boolean.TRUE);
    }
}
