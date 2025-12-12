package com.google.android.gms.tasks;

import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzu implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.internal.tasks.zza f8707b = new com.google.android.gms.internal.tasks.zza(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f8707b.post(runnable);
    }
}
