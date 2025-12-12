package r8;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: CrashlyticsBackgroundWorker.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f18716a;

    /* renamed from: b, reason: collision with root package name */
    public Task<Void> f18717b = Tasks.forResult(null);

    /* renamed from: c, reason: collision with root package name */
    public final Object f18718c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final ThreadLocal<Boolean> f18719d = new ThreadLocal<>();

    /* compiled from: CrashlyticsBackgroundWorker.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.f18719d.set(Boolean.TRUE);
        }
    }

    public l(Executor executor) {
        this.f18716a = executor;
        executor.execute(new a());
    }

    public void checkRunningOnThread() {
        if (!Boolean.TRUE.equals(this.f18719d.get())) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public Executor getExecutor() {
        return this.f18716a;
    }

    public <T> Task<T> submit(Callable<T> callable) {
        Task<T> task;
        synchronized (this.f18718c) {
            task = (Task<T>) this.f18717b.continueWith(this.f18716a, new m(callable));
            this.f18717b = task.continueWith(this.f18716a, new n());
        }
        return task;
    }

    public <T> Task<T> submitTask(Callable<Task<T>> callable) {
        Task<T> task;
        synchronized (this.f18718c) {
            task = (Task<T>) this.f18717b.continueWithTask(this.f18716a, new m(callable));
            this.f18717b = task.continueWith(this.f18716a, new n());
        }
        return task;
    }
}
