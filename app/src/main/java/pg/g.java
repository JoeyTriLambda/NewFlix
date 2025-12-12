package pg;

import java.util.Collection;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Collection<kg.e0> f17697a = hg.f.toList(hg.e.asSequence(o1.a.f()));

    public static final Collection<kg.e0> getPlatformExceptionHandlers() {
        return f17697a;
    }

    public static final void propagateExceptionFinalResort(Throwable th2) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
    }
}
