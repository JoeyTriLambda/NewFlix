package r8;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: CrashlyticsUncaughtExceptionHandler.java */
/* loaded from: classes.dex */
public final class b0 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final a f18667a;

    /* renamed from: b, reason: collision with root package name */
    public final y8.g f18668b;

    /* renamed from: c, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f18669c;

    /* renamed from: d, reason: collision with root package name */
    public final o8.a f18670d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f18671e = new AtomicBoolean(false);

    /* compiled from: CrashlyticsUncaughtExceptionHandler.java */
    public interface a {
    }

    public b0(a aVar, y8.g gVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, o8.a aVar2) {
        this.f18667a = aVar;
        this.f18668b = gVar;
        this.f18669c = uncaughtExceptionHandler;
        this.f18670d = aVar2;
    }

    public final boolean a(Thread thread, Throwable th2) {
        if (thread == null) {
            o8.e.getLogger().e("Crashlytics will not record uncaught exception; null thread");
            return false;
        }
        if (th2 == null) {
            o8.e.getLogger().e("Crashlytics will not record uncaught exception; null throwable");
            return false;
        }
        if (!this.f18670d.hasCrashDataForCurrentSession()) {
            return true;
        }
        o8.e.getLogger().d("Crashlytics will not record uncaught exception; native crash exists for session.");
        return false;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f18669c;
        AtomicBoolean atomicBoolean = this.f18671e;
        atomicBoolean.set(true);
        try {
            try {
                if (a(thread, th2)) {
                    ((o) this.f18667a).onUncaughtException(this.f18668b, thread, th2);
                } else {
                    o8.e.getLogger().d("Uncaught exception will not be recorded by Crashlytics.");
                }
            } catch (Exception e10) {
                o8.e.getLogger().e("An error occurred in the uncaught exception handler", e10);
            }
        } finally {
            o8.e.getLogger().d("Completed exception processing. Invoking default exception handler.");
            uncaughtExceptionHandler.uncaughtException(thread, th2);
            atomicBoolean.set(false);
        }
    }
}
