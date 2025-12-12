package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class ConcurrentUtils {

    public static final class ConstantFuture<T> implements Future<T> {
        private final T value;

        public ConstantFuture(T t10) {
            this.value = t10;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            return false;
        }

        @Override // java.util.concurrent.Future
        public T get() {
            return this.value;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public T get(long j10, TimeUnit timeUnit) {
            return this.value;
        }
    }

    private ConcurrentUtils() {
    }

    public static Throwable checkedException(Throwable th2) {
        Validate.isTrue((th2 == null || (th2 instanceof RuntimeException) || (th2 instanceof Error)) ? false : true, "Not a checked exception: " + th2, new Object[0]);
        return th2;
    }

    public static <T> Future<T> constantFuture(T t10) {
        return new ConstantFuture(t10);
    }

    public static <K, V> V createIfAbsent(ConcurrentMap<K, V> concurrentMap, K k10, ConcurrentInitializer<V> concurrentInitializer) throws ConcurrentException {
        if (concurrentMap == null || concurrentInitializer == null) {
            return null;
        }
        V v10 = concurrentMap.get(k10);
        return v10 == null ? (V) putIfAbsent(concurrentMap, k10, concurrentInitializer.get()) : v10;
    }

    public static <K, V> V createIfAbsentUnchecked(ConcurrentMap<K, V> concurrentMap, K k10, ConcurrentInitializer<V> concurrentInitializer) {
        try {
            return (V) createIfAbsent(concurrentMap, k10, concurrentInitializer);
        } catch (ConcurrentException e10) {
            throw new ConcurrentRuntimeException(e10.getCause());
        }
    }

    public static ConcurrentException extractCause(ExecutionException executionException) {
        if (executionException == null || executionException.getCause() == null) {
            return null;
        }
        throwCause(executionException);
        return new ConcurrentException(executionException.getMessage(), executionException.getCause());
    }

    public static ConcurrentRuntimeException extractCauseUnchecked(ExecutionException executionException) {
        if (executionException == null || executionException.getCause() == null) {
            return null;
        }
        throwCause(executionException);
        return new ConcurrentRuntimeException(executionException.getMessage(), executionException.getCause());
    }

    public static void handleCause(ExecutionException executionException) throws ConcurrentException {
        ConcurrentException concurrentExceptionExtractCause = extractCause(executionException);
        if (concurrentExceptionExtractCause != null) {
            throw concurrentExceptionExtractCause;
        }
    }

    public static void handleCauseUnchecked(ExecutionException executionException) {
        ConcurrentRuntimeException concurrentRuntimeExceptionExtractCauseUnchecked = extractCauseUnchecked(executionException);
        if (concurrentRuntimeExceptionExtractCauseUnchecked != null) {
            throw concurrentRuntimeExceptionExtractCauseUnchecked;
        }
    }

    public static <T> T initialize(ConcurrentInitializer<T> concurrentInitializer) throws ConcurrentException {
        if (concurrentInitializer != null) {
            return concurrentInitializer.get();
        }
        return null;
    }

    public static <T> T initializeUnchecked(ConcurrentInitializer<T> concurrentInitializer) {
        try {
            return (T) initialize(concurrentInitializer);
        } catch (ConcurrentException e10) {
            throw new ConcurrentRuntimeException(e10.getCause());
        }
    }

    public static <K, V> V putIfAbsent(ConcurrentMap<K, V> concurrentMap, K k10, V v10) {
        if (concurrentMap == null) {
            return null;
        }
        V vPutIfAbsent = concurrentMap.putIfAbsent(k10, v10);
        return vPutIfAbsent != null ? vPutIfAbsent : v10;
    }

    private static void throwCause(ExecutionException executionException) {
        if (executionException.getCause() instanceof RuntimeException) {
            throw ((RuntimeException) executionException.getCause());
        }
        if (executionException.getCause() instanceof Error) {
            throw ((Error) executionException.getCause());
        }
    }
}
