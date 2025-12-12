package ai;

import java.lang.Thread;

/* compiled from: SafeRunnable.java */
/* loaded from: classes2.dex */
public abstract class e implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final pl.droidsonroids.gif.a f738b;

    public e(pl.droidsonroids.gif.a aVar) {
        this.f738b = aVar;
    }

    public abstract void doWork();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f738b.isRecycled()) {
                return;
            }
            doWork();
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th2);
            }
            throw th2;
        }
    }
}
