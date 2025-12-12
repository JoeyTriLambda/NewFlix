package com.google.android.gms.tasks;

import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzaf<T> implements zzae<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8662a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final int f8663b;

    /* renamed from: c, reason: collision with root package name */
    public final zzw f8664c;

    /* renamed from: d, reason: collision with root package name */
    public int f8665d;

    /* renamed from: e, reason: collision with root package name */
    public int f8666e;

    /* renamed from: f, reason: collision with root package name */
    public int f8667f;

    /* renamed from: g, reason: collision with root package name */
    public Exception f8668g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8669h;

    public zzaf(int i10, zzw zzwVar) {
        this.f8663b = i10;
        this.f8664c = zzwVar;
    }

    public final void a() {
        int i10 = this.f8665d + this.f8666e + this.f8667f;
        int i11 = this.f8663b;
        if (i10 == i11) {
            Exception exc = this.f8668g;
            zzw zzwVar = this.f8664c;
            if (exc == null) {
                if (this.f8669h) {
                    zzwVar.zzc();
                    return;
                } else {
                    zzwVar.zzb(null);
                    return;
                }
            }
            zzwVar.zza(new ExecutionException(this.f8666e + " out of " + i11 + " underlying tasks failed", this.f8668g));
        }
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.f8662a) {
            this.f8667f++;
            this.f8669h = true;
            a();
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.f8662a) {
            this.f8666e++;
            this.f8668g = exc;
            a();
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(T t10) {
        synchronized (this.f8662a) {
            this.f8665d++;
            a();
        }
    }
}
