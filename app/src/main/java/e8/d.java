package e8;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: Uninterruptibles.java */
/* loaded from: classes.dex */
public final class d {
    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }
}
