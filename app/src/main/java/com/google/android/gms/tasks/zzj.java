package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzj implements zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f8686a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8687b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public OnCompleteListener f8688c;

    public zzj(Executor executor, OnCompleteListener onCompleteListener) {
        this.f8686a = executor;
        this.f8688c = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(Task task) {
        synchronized (this.f8687b) {
            if (this.f8688c == null) {
                return;
            }
            this.f8686a.execute(new zzi(this, task));
        }
    }
}
