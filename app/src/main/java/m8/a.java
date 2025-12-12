package m8;

import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import r.x;

/* compiled from: CustomThreadFactory.java */
/* loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* renamed from: p, reason: collision with root package name */
    public static final ThreadFactory f16201p = Executors.defaultThreadFactory();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicLong f16202b = new AtomicLong();

    /* renamed from: m, reason: collision with root package name */
    public final String f16203m;

    /* renamed from: n, reason: collision with root package name */
    public final int f16204n;

    /* renamed from: o, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f16205o;

    public a(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        this.f16203m = str;
        this.f16204n = i10;
        this.f16205o = threadPolicy;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = f16201p.newThread(new x(15, this, runnable));
        threadNewThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f16203m, Long.valueOf(this.f16202b.getAndIncrement())));
        return threadNewThread;
    }
}
