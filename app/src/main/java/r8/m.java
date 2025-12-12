package r8;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* compiled from: CrashlyticsBackgroundWorker.java */
/* loaded from: classes.dex */
public final class m implements Continuation<Void, Object> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f18723b;

    public m(Callable callable) {
        this.f18723b = callable;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task<Void> task) throws Exception {
        return this.f18723b.call();
    }
}
