package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzw<TResult> extends Task<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8708a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final zzr f8709b = new zzr();

    /* renamed from: c, reason: collision with root package name */
    public boolean f8710c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f8711d;

    /* renamed from: e, reason: collision with root package name */
    public Object f8712e;

    /* renamed from: f, reason: collision with root package name */
    public Exception f8713f;

    public final void a() {
        synchronized (this.f8708a) {
            if (this.f8710c) {
                this.f8709b.zzb(this);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        this.f8709b.zza(new zzh(executor, onCanceledListener));
        a();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        this.f8709b.zza(new zzj(TaskExecutors.f8659a, onCompleteListener));
        a();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.f8659a, onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> onSuccessListener) {
        addOnSuccessListener(TaskExecutors.f8659a, onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.f8659a, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzw zzwVar = new zzw();
        this.f8709b.zza(new zzf(executor, continuation, zzwVar));
        a();
        return zzwVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception getException() {
        Exception exc;
        synchronized (this.f8708a) {
            exc = this.f8713f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final TResult getResult() {
        TResult tresult;
        synchronized (this.f8708a) {
            Preconditions.checkState(this.f8710c, "Task is not yet complete");
            if (this.f8711d) {
                throw new CancellationException("Task is already canceled.");
            }
            Exception exc = this.f8713f;
            if (exc != null) {
                throw new RuntimeExecutionException(exc);
            }
            tresult = (TResult) this.f8712e;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isCanceled() {
        return this.f8711d;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isComplete() {
        boolean z10;
        synchronized (this.f8708a) {
            z10 = this.f8710c;
        }
        return z10;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isSuccessful() {
        boolean z10;
        synchronized (this.f8708a) {
            z10 = false;
            if (this.f8710c && !this.f8711d && this.f8713f == null) {
                z10 = true;
            }
        }
        return z10;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        Executor executor = TaskExecutors.f8659a;
        zzw zzwVar = new zzw();
        this.f8709b.zza(new zzp(executor, successContinuation, zzwVar));
        a();
        return zzwVar;
    }

    public final void zza(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.f8708a) {
            if (this.f8710c) {
                throw DuplicateTaskCompletionException.of(this);
            }
            this.f8710c = true;
            this.f8713f = exc;
        }
        this.f8709b.zzb(this);
    }

    public final void zzb(Object obj) {
        synchronized (this.f8708a) {
            if (this.f8710c) {
                throw DuplicateTaskCompletionException.of(this);
            }
            this.f8710c = true;
            this.f8712e = obj;
        }
        this.f8709b.zzb(this);
    }

    public final boolean zzc() {
        synchronized (this.f8708a) {
            if (this.f8710c) {
                return false;
            }
            this.f8710c = true;
            this.f8711d = true;
            this.f8709b.zzb(this);
            return true;
        }
    }

    public final boolean zzd(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.f8708a) {
            if (this.f8710c) {
                return false;
            }
            this.f8710c = true;
            this.f8713f = exc;
            this.f8709b.zzb(this);
            return true;
        }
    }

    public final boolean zze(Object obj) {
        synchronized (this.f8708a) {
            if (this.f8710c) {
                return false;
            }
            this.f8710c = true;
            this.f8712e = obj;
            this.f8709b.zzb(this);
            return true;
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.f8709b.zza(new zzl(executor, onFailureListener));
        a();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f8709b.zza(new zzn(executor, onSuccessListener));
        a();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        zzw zzwVar = new zzw();
        this.f8709b.zza(new zzd(executor, continuation, zzwVar));
        a();
        return zzwVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f8709b.zza(new zzj(executor, onCompleteListener));
        a();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        zzw zzwVar = new zzw();
        this.f8709b.zza(new zzp(executor, successContinuation, zzwVar));
        a();
        return zzwVar;
    }
}
