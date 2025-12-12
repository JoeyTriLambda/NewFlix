package cf;

import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingHelper.java */
/* loaded from: classes2.dex */
public final class c {
    public static void awaitForComplete(CountDownLatch countDownLatch, qe.b bVar) throws InterruptedException {
        if (countDownLatch.getCount() == 0) {
            return;
        }
        try {
            verifyNonBlocking();
            countDownLatch.await();
        } catch (InterruptedException e10) {
            bVar.dispose();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e10);
        }
    }

    public static void verifyNonBlocking() {
        if (ff.a.isFailOnNonBlockingScheduler()) {
            if ((Thread.currentThread() instanceof bf.e) || ff.a.onBeforeBlocking()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
