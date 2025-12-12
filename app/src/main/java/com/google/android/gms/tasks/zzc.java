package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzc implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Task f8670b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzd f8671m;

    public zzc(zzd zzdVar, Task task) {
        this.f8671m = zzdVar;
        this.f8670b = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Task task = this.f8670b;
        boolean zIsCanceled = task.isCanceled();
        zzd zzdVar = this.f8671m;
        if (zIsCanceled) {
            zzdVar.f8674c.zzc();
            return;
        }
        try {
            zzdVar.f8674c.zzb(zzdVar.f8673b.then(task));
        } catch (RuntimeExecutionException e10) {
            if (e10.getCause() instanceof Exception) {
                zzdVar.f8674c.zza((Exception) e10.getCause());
            } else {
                zzdVar.f8674c.zza(e10);
            }
        } catch (Exception e11) {
            zzdVar.f8674c.zza(e11);
        }
    }
}
