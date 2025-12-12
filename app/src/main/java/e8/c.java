package e8;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: ListenableFuture.java */
/* loaded from: classes.dex */
public interface c<V> extends Future<V> {
    void addListener(Runnable runnable, Executor executor);
}
