package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zze implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Task f8675b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzf f8676m;

    public zze(zzf zzfVar, Task task) {
        this.f8676m = zzfVar;
        this.f8675b = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzf zzfVar = this.f8676m;
        try {
            Task task = (Task) zzfVar.f8678b.then(this.f8675b);
            if (task == null) {
                zzfVar.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.f8660b;
            task.addOnSuccessListener(executor, zzfVar);
            task.addOnFailureListener(executor, zzfVar);
            task.addOnCanceledListener(executor, zzfVar);
        } catch (RuntimeExecutionException e10) {
            if (e10.getCause() instanceof Exception) {
                zzfVar.f8679c.zza((Exception) e10.getCause());
            } else {
                zzfVar.f8679c.zza(e10);
            }
        } catch (Exception e11) {
            zzfVar.f8679c.zza(e11);
        }
    }
}
