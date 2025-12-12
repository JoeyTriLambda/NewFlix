package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzk implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Task f8689b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzl f8690m;

    public zzk(zzl zzlVar, Task task) {
        this.f8690m = zzlVar;
        this.f8689b = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8690m.f8692b) {
            OnFailureListener onFailureListener = this.f8690m.f8693c;
            if (onFailureListener != null) {
                onFailureListener.onFailure((Exception) Preconditions.checkNotNull(this.f8689b.getException()));
            }
        }
    }
}
