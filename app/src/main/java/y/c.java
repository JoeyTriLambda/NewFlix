package y;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultTaskExecutor.java */
/* loaded from: classes.dex */
public final class c extends d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f21808a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f21809b = Executors.newFixedThreadPool(4, new a());

    /* renamed from: c, reason: collision with root package name */
    public volatile Handler f21810c;

    /* compiled from: DefaultTaskExecutor.java */
    public class a implements ThreadFactory {

        /* renamed from: b, reason: collision with root package name */
        public final AtomicInteger f21811b = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.f21811b.getAndIncrement());
            return thread;
        }
    }

    /* compiled from: DefaultTaskExecutor.java */
    public static class b {
        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static Handler a(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.createAsync(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    public void executeOnDiskIO(Runnable runnable) {
        this.f21809b.execute(runnable);
    }

    public boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void postToMainThread(Runnable runnable) {
        if (this.f21810c == null) {
            synchronized (this.f21808a) {
                if (this.f21810c == null) {
                    this.f21810c = a(Looper.getMainLooper());
                }
            }
        }
        this.f21810c.post(runnable);
    }
}
