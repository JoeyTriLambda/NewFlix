package r8;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class o0 implements Continuation {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18731b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f18732m;

    public /* synthetic */ o0(int i10, TaskCompletionSource taskCompletionSource) {
        this.f18731b = i10;
        this.f18732m = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        int i10 = this.f18731b;
        TaskCompletionSource taskCompletionSource = this.f18732m;
        switch (i10) {
            case 0:
                if (!task.isSuccessful()) {
                    if (task.getException() != null) {
                        taskCompletionSource.trySetException(task.getException());
                        break;
                    }
                } else {
                    taskCompletionSource.trySetResult(task.getResult());
                    break;
                }
                break;
            case 1:
                if (!task.isSuccessful()) {
                    if (task.getException() != null) {
                        taskCompletionSource.setException(task.getException());
                        break;
                    }
                } else {
                    taskCompletionSource.setResult(task.getResult());
                    break;
                }
                break;
            default:
                if (!task.isSuccessful()) {
                    if (task.getException() != null) {
                        taskCompletionSource.trySetException(task.getException());
                        break;
                    }
                } else {
                    taskCompletionSource.trySetResult(task.getResult());
                    break;
                }
                break;
        }
        return null;
    }
}
