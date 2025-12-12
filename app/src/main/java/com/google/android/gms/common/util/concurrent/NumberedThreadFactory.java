package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class NumberedThreadFactory implements ThreadFactory {

    /* renamed from: b, reason: collision with root package name */
    public final String f7513b;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicInteger f7514m = new AtomicInteger();

    /* renamed from: n, reason: collision with root package name */
    public final ThreadFactory f7515n = Executors.defaultThreadFactory();

    @KeepForSdk
    public NumberedThreadFactory(String str) {
        Preconditions.checkNotNull(str, "Name must not be null");
        this.f7513b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f7515n.newThread(new zza(runnable, 0));
        threadNewThread.setName(this.f7513b + "[" + this.f7514m.getAndIncrement() + "]");
        return threadNewThread;
    }
}
