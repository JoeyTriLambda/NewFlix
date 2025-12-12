package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzo implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Task f8699b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzp f8700m;

    public zzo(zzp zzpVar, Task task) {
        this.f8700m = zzpVar;
        this.f8699b = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzp zzpVar = this.f8700m;
        try {
            Task taskThen = zzpVar.f8702b.then(this.f8699b.getResult());
            if (taskThen == null) {
                zzpVar.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.f8660b;
            taskThen.addOnSuccessListener(executor, zzpVar);
            taskThen.addOnFailureListener(executor, zzpVar);
            taskThen.addOnCanceledListener(executor, zzpVar);
        } catch (RuntimeExecutionException e10) {
            if (e10.getCause() instanceof Exception) {
                zzpVar.onFailure((Exception) e10.getCause());
            } else {
                zzpVar.onFailure(e10);
            }
        } catch (CancellationException unused) {
            zzpVar.onCanceled();
        } catch (Exception e11) {
            zzpVar.onFailure(e11);
        }
    }
}
