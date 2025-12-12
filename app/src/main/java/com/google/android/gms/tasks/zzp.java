package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzp<TResult, TContinuationResult> implements OnSuccessListener<TContinuationResult>, OnFailureListener, OnCanceledListener, zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f8701a;

    /* renamed from: b, reason: collision with root package name */
    public final SuccessContinuation f8702b;

    /* renamed from: c, reason: collision with root package name */
    public final zzw f8703c;

    public zzp(Executor executor, SuccessContinuation successContinuation, zzw zzwVar) {
        this.f8701a = executor;
        this.f8702b = successContinuation;
        this.f8703c = zzwVar;
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.f8703c.zzc();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f8703c.zza(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f8703c.zzb(tcontinuationresult);
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(Task task) {
        this.f8701a.execute(new zzo(this, task));
    }
}
