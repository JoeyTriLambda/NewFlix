package io.reactivex.internal.schedulers;

import ac.c;
import bf.e;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;

    /* renamed from: b, reason: collision with root package name */
    public final String f14513b;

    /* renamed from: m, reason: collision with root package name */
    public final int f14514m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f14515n;

    public static final class a extends Thread implements e {
        public a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.f14513b + '-' + incrementAndGet();
        Thread aVar = this.f14515n ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.f14514m);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return c.o(new StringBuilder("RxThreadFactory["), this.f14513b, "]");
    }

    public RxThreadFactory(String str, int i10) {
        this(str, i10, false);
    }

    public RxThreadFactory(String str, int i10, boolean z10) {
        this.f14513b = str;
        this.f14514m = i10;
        this.f14515n = z10;
    }
}
