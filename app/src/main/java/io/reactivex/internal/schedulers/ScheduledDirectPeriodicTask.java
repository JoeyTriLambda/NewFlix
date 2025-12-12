package io.reactivex.internal.schedulers;

/* loaded from: classes2.dex */
public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14512m = Thread.currentThread();
        try {
            this.f14511b.run();
            this.f14512m = null;
        } catch (Throwable th2) {
            this.f14512m = null;
            lazySet(AbstractDirectTask.f14509n);
            ff.a.onError(th2);
        }
    }
}
