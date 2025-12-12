package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
public class TaskCompletionSource<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final zzw f8658a = new zzw();

    public Task<TResult> getTask() {
        return this.f8658a;
    }

    public void setException(Exception exc) {
        this.f8658a.zza(exc);
    }

    public void setResult(TResult tresult) {
        this.f8658a.zzb(tresult);
    }

    public boolean trySetException(Exception exc) {
        return this.f8658a.zzd(exc);
    }

    public boolean trySetResult(TResult tresult) {
        return this.f8658a.zze(tresult);
    }
}
