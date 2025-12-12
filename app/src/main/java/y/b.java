package y;

import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor.java */
/* loaded from: classes.dex */
public final class b extends d {

    /* renamed from: b, reason: collision with root package name */
    public static volatile b f21805b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f21806c = new a(1);

    /* renamed from: a, reason: collision with root package name */
    public final c f21807a = new c();

    public static Executor getIOThreadExecutor() {
        return f21806c;
    }

    public static b getInstance() {
        if (f21805b != null) {
            return f21805b;
        }
        synchronized (b.class) {
            if (f21805b == null) {
                f21805b = new b();
            }
        }
        return f21805b;
    }

    public void executeOnDiskIO(Runnable runnable) {
        this.f21807a.executeOnDiskIO(runnable);
    }

    public boolean isMainThread() {
        return this.f21807a.isMainThread();
    }

    public void postToMainThread(Runnable runnable) {
        this.f21807a.postToMainThread(runnable);
    }
}
