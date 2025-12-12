package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzl implements zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f8691a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8692b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public OnFailureListener f8693c;

    public zzl(Executor executor, OnFailureListener onFailureListener) {
        this.f8691a = executor;
        this.f8693c = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(Task task) {
        if (task.isSuccessful() || task.isCanceled()) {
            return;
        }
        synchronized (this.f8692b) {
            if (this.f8693c == null) {
                return;
            }
            this.f8691a.execute(new zzk(this, task));
        }
    }
}
