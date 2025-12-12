package ff;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import ne.b;
import ne.e;
import ne.g;
import ne.h;
import ne.k;
import ne.q;
import ne.r;
import ne.s;
import ne.t;

/* compiled from: RxJavaPlugins.java */
/* loaded from: classes2.dex */
public final class a {
    public static r a(Callable<r> callable) {
        try {
            return (r) ue.a.requireNonNull(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th2) {
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    public static r initComputationScheduler(Callable<r> callable) {
        ue.a.requireNonNull(callable, "Scheduler Callable can't be null");
        return a(callable);
    }

    public static r initIoScheduler(Callable<r> callable) {
        ue.a.requireNonNull(callable, "Scheduler Callable can't be null");
        return a(callable);
    }

    public static r initNewThreadScheduler(Callable<r> callable) {
        ue.a.requireNonNull(callable, "Scheduler Callable can't be null");
        return a(callable);
    }

    public static r initSingleScheduler(Callable<r> callable) {
        ue.a.requireNonNull(callable, "Scheduler Callable can't be null");
        return a(callable);
    }

    public static boolean isFailOnNonBlockingScheduler() {
        return false;
    }

    public static <T> df.a<T> onAssembly(df.a<T> aVar) {
        return aVar;
    }

    public static boolean onBeforeBlocking() {
        return false;
    }

    public static void onError(Throwable th2) {
        if (th2 == null) {
            th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else {
            if (!((th2 instanceof OnErrorNotImplementedException) || (th2 instanceof MissingBackpressureException) || (th2 instanceof IllegalStateException) || (th2 instanceof NullPointerException) || (th2 instanceof IllegalArgumentException) || (th2 instanceof CompositeException))) {
                th2 = new UndeliverableException(th2);
            }
        }
        th2.printStackTrace();
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
    }

    public static Runnable onSchedule(Runnable runnable) {
        ue.a.requireNonNull(runnable, "run is null");
        return runnable;
    }

    public static b onSubscribe(ne.a aVar, b bVar) {
        return bVar;
    }

    public static ne.a onAssembly(ne.a aVar) {
        return aVar;
    }

    public static <T> h<? super T> onSubscribe(g<T> gVar, h<? super T> hVar) {
        return hVar;
    }

    public static <T> e<T> onAssembly(e<T> eVar) {
        return eVar;
    }

    public static <T> q<? super T> onSubscribe(k<T> kVar, q<? super T> qVar) {
        return qVar;
    }

    public static <T> g<T> onAssembly(g<T> gVar) {
        return gVar;
    }

    public static <T> t<? super T> onSubscribe(s<T> sVar, t<? super T> tVar) {
        return tVar;
    }

    public static <T> k<T> onAssembly(k<T> kVar) {
        return kVar;
    }

    public static <T> zh.b<? super T> onSubscribe(e<T> eVar, zh.b<? super T> bVar) {
        return bVar;
    }

    public static <T> s<T> onAssembly(s<T> sVar) {
        return sVar;
    }

    public static r onComputationScheduler(r rVar) {
        return rVar;
    }

    public static r onNewThreadScheduler(r rVar) {
        return rVar;
    }
}
