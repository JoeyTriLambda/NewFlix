package androidx.work;

import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import w2.f;
import w2.l;
import w2.p;
import x2.d;

/* compiled from: Configuration.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f4494a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f4495b;

    /* renamed from: c, reason: collision with root package name */
    public final p f4496c;

    /* renamed from: d, reason: collision with root package name */
    public final f f4497d;

    /* renamed from: e, reason: collision with root package name */
    public final d f4498e;

    /* renamed from: f, reason: collision with root package name */
    public final int f4499f;

    /* renamed from: g, reason: collision with root package name */
    public final int f4500g;

    /* renamed from: h, reason: collision with root package name */
    public final int f4501h;

    /* compiled from: Configuration.java */
    /* renamed from: androidx.work.a$a, reason: collision with other inner class name */
    public static final class C0047a {

        /* renamed from: a, reason: collision with root package name */
        public final int f4502a = 4;

        /* renamed from: b, reason: collision with root package name */
        public final int f4503b = Integer.MAX_VALUE;

        /* renamed from: c, reason: collision with root package name */
        public final int f4504c = 20;

        public a build() {
            return new a(this);
        }
    }

    /* compiled from: Configuration.java */
    public interface b {
        a getWorkManagerConfiguration();
    }

    public a(C0047a c0047a) {
        c0047a.getClass();
        this.f4494a = a(false);
        this.f4495b = a(true);
        this.f4496c = p.getDefaultWorkerFactory();
        this.f4497d = f.getDefaultInputMergerFactory();
        this.f4498e = new d();
        this.f4499f = c0047a.f4502a;
        this.f4500g = c0047a.f4503b;
        this.f4501h = c0047a.f4504c;
    }

    public static ExecutorService a(boolean z10) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new w2.a(z10));
    }

    public String getDefaultProcessName() {
        return null;
    }

    public Executor getExecutor() {
        return this.f4494a;
    }

    public w0.a<Throwable> getInitializationExceptionHandler() {
        return null;
    }

    public f getInputMergerFactory() {
        return this.f4497d;
    }

    public int getMaxJobSchedulerId() {
        return this.f4500g;
    }

    public int getMaxSchedulerLimit() {
        int i10 = Build.VERSION.SDK_INT;
        int i11 = this.f4501h;
        return i10 == 23 ? i11 / 2 : i11;
    }

    public int getMinJobSchedulerId() {
        return 0;
    }

    public int getMinimumLoggingLevel() {
        return this.f4499f;
    }

    public l getRunnableScheduler() {
        return this.f4498e;
    }

    public w0.a<Throwable> getSchedulingExceptionHandler() {
        return null;
    }

    public Executor getTaskExecutor() {
        return this.f4495b;
    }

    public p getWorkerFactory() {
        return this.f4496c;
    }
}
