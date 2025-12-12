package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzi implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Task f8684b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzj f8685m;

    public zzi(zzj zzjVar, Task task) {
        this.f8685m = zzjVar;
        this.f8684b = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8685m.f8687b) {
            OnCompleteListener onCompleteListener = this.f8685m.f8688c;
            if (onCompleteListener != null) {
                onCompleteListener.onComplete(this.f8684b);
            }
        }
    }
}
