package com.google.android.gms.internal.cast;

import e8.c;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzrq extends zzro implements c {
    @Override // e8.c
    public final void addListener(Runnable runnable, Executor executor) {
        zzc().addListener(runnable, executor);
    }

    @Override // com.google.android.gms.internal.cast.zzro
    public /* bridge */ /* synthetic */ Future zzb() {
        throw null;
    }

    public abstract c zzc();
}
