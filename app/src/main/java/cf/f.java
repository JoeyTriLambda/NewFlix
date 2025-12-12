package cf;

import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import ne.q;

/* compiled from: HalfSerializer.java */
/* loaded from: classes2.dex */
public final class f {
    public static void onComplete(zh.b<?> bVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thTerminate = atomicThrowable.terminate();
            if (thTerminate != null) {
                bVar.onError(thTerminate);
            } else {
                bVar.onComplete();
            }
        }
    }

    public static void onError(zh.b<?> bVar, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th2)) {
            ff.a.onError(th2);
        } else if (atomicInteger.getAndIncrement() == 0) {
            bVar.onError(atomicThrowable.terminate());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void onNext(zh.b<? super T> bVar, T t10, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            bVar.onNext(t10);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thTerminate = atomicThrowable.terminate();
                if (thTerminate != null) {
                    bVar.onError(thTerminate);
                } else {
                    bVar.onComplete();
                }
            }
        }
    }

    public static void onComplete(q<?> qVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thTerminate = atomicThrowable.terminate();
            if (thTerminate != null) {
                qVar.onError(thTerminate);
            } else {
                qVar.onComplete();
            }
        }
    }

    public static void onError(q<?> qVar, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.addThrowable(th2)) {
            if (atomicInteger.getAndIncrement() == 0) {
                qVar.onError(atomicThrowable.terminate());
                return;
            }
            return;
        }
        ff.a.onError(th2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void onNext(q<? super T> qVar, T t10, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            qVar.onNext(t10);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thTerminate = atomicThrowable.terminate();
                if (thTerminate != null) {
                    qVar.onError(thTerminate);
                } else {
                    qVar.onComplete();
                }
            }
        }
    }
}
