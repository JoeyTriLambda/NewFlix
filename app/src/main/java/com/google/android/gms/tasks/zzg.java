package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzg implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzh f8680b;

    public zzg(zzh zzhVar) {
        this.f8680b = zzhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8680b.f8682b) {
            OnCanceledListener onCanceledListener = this.f8680b.f8683c;
            if (onCanceledListener != null) {
                onCanceledListener.onCanceled();
            }
        }
    }
}
