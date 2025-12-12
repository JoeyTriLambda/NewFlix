package com.google.android.gms.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzad<T> implements zzae<T> {

    /* renamed from: a, reason: collision with root package name */
    public final CountDownLatch f8661a = new CountDownLatch(1);

    private zzad() {
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.f8661a.countDown();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f8661a.countDown();
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(T t10) {
        this.f8661a.countDown();
    }

    public final void zza() throws InterruptedException {
        this.f8661a.await();
    }

    public final boolean zzb(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f8661a.await(j10, timeUnit);
    }

    public /* synthetic */ zzad(int i10) {
    }
}
