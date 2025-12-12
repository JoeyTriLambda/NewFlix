package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzm implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Task f8694b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzn f8695m;

    public zzm(zzn zznVar, Task task) {
        this.f8695m = zznVar;
        this.f8694b = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8695m.f8697b) {
            OnSuccessListener onSuccessListener = this.f8695m.f8698c;
            if (onSuccessListener != null) {
                onSuccessListener.onSuccess(this.f8694b.getResult());
            }
        }
    }
}
