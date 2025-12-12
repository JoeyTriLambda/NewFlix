package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzn implements zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f8696a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8697b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public OnSuccessListener f8698c;

    public zzn(Executor executor, OnSuccessListener onSuccessListener) {
        this.f8696a = executor;
        this.f8698c = onSuccessListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(Task task) {
        if (task.isSuccessful()) {
            synchronized (this.f8697b) {
                if (this.f8698c == null) {
                    return;
                }
                this.f8696a.execute(new zzm(this, task));
            }
        }
    }
}
