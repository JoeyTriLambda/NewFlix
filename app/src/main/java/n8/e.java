package n8;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: FirebaseCrashlytics.java */
/* loaded from: classes.dex */
public final class e implements Continuation<Void, Object> {
    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task<Void> task) throws Exception {
        if (task.isSuccessful()) {
            return null;
        }
        o8.e.getLogger().e("Error fetching settings.", task.getException());
        return null;
    }
}
