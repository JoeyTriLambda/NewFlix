package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzf<TResult, TContinuationResult> implements OnSuccessListener<TContinuationResult>, OnFailureListener, OnCanceledListener, zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f8677a;

    /* renamed from: b, reason: collision with root package name */
    public final Continuation f8678b;

    /* renamed from: c, reason: collision with root package name */
    public final zzw f8679c;

    public zzf(Executor executor, Continuation continuation, zzw zzwVar) {
        this.f8677a = executor;
        this.f8678b = continuation;
        this.f8679c = zzwVar;
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.f8679c.zzc();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f8679c.zza(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f8679c.zzb(tcontinuationresult);
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(Task task) {
        this.f8677a.execute(new zze(this, task));
    }
}
