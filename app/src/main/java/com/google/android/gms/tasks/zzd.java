package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzd implements zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f8672a;

    /* renamed from: b, reason: collision with root package name */
    public final Continuation f8673b;

    /* renamed from: c, reason: collision with root package name */
    public final zzw f8674c;

    public zzd(Executor executor, Continuation continuation, zzw zzwVar) {
        this.f8672a = executor;
        this.f8673b = continuation;
        this.f8674c = zzwVar;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(Task task) {
        this.f8672a.execute(new zzc(this, task));
    }
}
