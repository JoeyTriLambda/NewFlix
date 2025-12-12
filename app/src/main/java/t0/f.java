package t0;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: ExecutorCompat.java */
/* loaded from: classes.dex */
public final class f {

    /* compiled from: ExecutorCompat.java */
    public static class a implements Executor {

        /* renamed from: b, reason: collision with root package name */
        public final Handler f19361b;

        public a(Handler handler) {
            this.f19361b = (Handler) w0.h.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Runnable runnable2 = (Runnable) w0.h.checkNotNull(runnable);
            Handler handler = this.f19361b;
            if (handler.post(runnable2)) {
                return;
            }
            throw new RejectedExecutionException(handler + " is shutting down");
        }
    }

    public static Executor create(Handler handler) {
        return new a(handler);
    }
}
