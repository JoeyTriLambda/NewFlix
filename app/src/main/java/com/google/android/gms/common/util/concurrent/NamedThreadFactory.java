package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class NamedThreadFactory implements ThreadFactory {

    /* renamed from: b, reason: collision with root package name */
    public final String f7511b;

    /* renamed from: m, reason: collision with root package name */
    public final ThreadFactory f7512m = Executors.defaultThreadFactory();

    @KeepForSdk
    public NamedThreadFactory(String str) {
        Preconditions.checkNotNull(str, "Name must not be null");
        this.f7511b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f7512m.newThread(new zza(runnable, 0));
        threadNewThread.setName(this.f7511b);
        return threadNewThread;
    }
}
