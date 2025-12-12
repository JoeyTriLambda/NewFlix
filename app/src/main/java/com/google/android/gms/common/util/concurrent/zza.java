package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zza implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f7516b;

    public zza(Runnable runnable, int i10) {
        this.f7516b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(0);
        this.f7516b.run();
    }
}
