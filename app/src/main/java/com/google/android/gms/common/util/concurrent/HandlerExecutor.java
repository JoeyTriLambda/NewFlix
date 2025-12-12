package com.google.android.gms.common.util.concurrent;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzi;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class HandlerExecutor implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final zzi f7510b;

    @KeepForSdk
    public HandlerExecutor(Looper looper) {
        this.f7510b = new zzi(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f7510b.post(runnable);
    }
}
