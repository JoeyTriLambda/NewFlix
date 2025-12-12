package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzh implements zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f8681a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8682b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public OnCanceledListener f8683c;

    public zzh(Executor executor, OnCanceledListener onCanceledListener) {
        this.f8681a = executor;
        this.f8683c = onCanceledListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(Task task) {
        if (task.isCanceled()) {
            synchronized (this.f8682b) {
                if (this.f8683c == null) {
                    return;
                }
                this.f8681a.execute(new zzg(this));
            }
        }
    }
}
