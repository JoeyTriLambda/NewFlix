package g3;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: SerialExecutorImpl.java */
/* loaded from: classes.dex */
public final class p implements i3.a {

    /* renamed from: m, reason: collision with root package name */
    public final Executor f12654m;

    /* renamed from: n, reason: collision with root package name */
    public Runnable f12655n;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque<a> f12653b = new ArrayDeque<>();

    /* renamed from: o, reason: collision with root package name */
    public final Object f12656o = new Object();

    /* compiled from: SerialExecutorImpl.java */
    public static class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final p f12657b;

        /* renamed from: m, reason: collision with root package name */
        public final Runnable f12658m;

        public a(p pVar, Runnable runnable) {
            this.f12657b = pVar;
            this.f12658m = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f12658m.run();
                synchronized (this.f12657b.f12656o) {
                    this.f12657b.a();
                }
            } catch (Throwable th2) {
                synchronized (this.f12657b.f12656o) {
                    this.f12657b.a();
                    throw th2;
                }
            }
        }
    }

    public p(Executor executor) {
        this.f12654m = executor;
    }

    public final void a() {
        a aVarPoll = this.f12653b.poll();
        this.f12655n = aVarPoll;
        if (aVarPoll != null) {
            this.f12654m.execute(aVarPoll);
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.f12656o) {
            this.f12653b.add(new a(this, runnable));
            if (this.f12655n == null) {
                a();
            }
        }
    }

    public boolean hasPendingTasks() {
        boolean z10;
        synchronized (this.f12656o) {
            z10 = !this.f12653b.isEmpty();
        }
        return z10;
    }
}
