package ug;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import kg.m;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import sf.f;

/* compiled from: Tasks.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final <T> Object await(Task<T> task, qf.c<? super T> cVar) throws Exception {
        if (!task.isComplete()) {
            m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
            mVar.initCancellability();
            task.addOnCompleteListener(a.f20377b, new b(mVar));
            Object result = mVar.getResult();
            if (result != rf.a.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            f.probeCoroutineSuspended(cVar);
            return result;
        }
        Exception exception = task.getException();
        if (exception != null) {
            throw exception;
        }
        if (!task.isCanceled()) {
            return task.getResult();
        }
        throw new CancellationException("Task " + task + " was cancelled normally.");
    }
}
