package androidx.work;

import android.content.Context;
import androidx.work.c;

/* loaded from: classes.dex */
public abstract class Worker extends c {

    /* renamed from: p, reason: collision with root package name */
    public h3.a<c.a> f4483p;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Worker worker = Worker.this;
            try {
                worker.f4483p.set(worker.doWork());
            } catch (Throwable th2) {
                worker.f4483p.setException(th2);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h3.a f4485b;

        public b(h3.a aVar) {
            this.f4485b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h3.a aVar = this.f4485b;
            try {
                aVar.set(Worker.this.getForegroundInfo());
            } catch (Throwable th2) {
                aVar.setException(th2);
            }
        }
    }

    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract c.a doWork();

    public w2.c getForegroundInfo() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
    }

    @Override // androidx.work.c
    public e8.c<w2.c> getForegroundInfoAsync() {
        h3.a aVarCreate = h3.a.create();
        getBackgroundExecutor().execute(new b(aVarCreate));
        return aVarCreate;
    }

    @Override // androidx.work.c
    public final e8.c<c.a> startWork() {
        this.f4483p = h3.a.create();
        getBackgroundExecutor().execute(new a());
        return this.f4483p;
    }
}
