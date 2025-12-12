package org.adblockplus.libadblockplus;

import android.annotation.SuppressLint;
import android.util.Log;
import bi.a;
import java.util.concurrent.LinkedBlockingQueue;
import org.adblockplus.libadblockplus.android.Utils;

/* loaded from: classes2.dex */
public final class JniExceptionHandler {
    private static final String TAG = Utils.getTag(JniExceptionHandler.class);
    private static LogWorker logWorker;

    public static final class LogWorker implements Runnable {
        LinkedBlockingQueue<Throwable> exceptionQueue;

        private LogWorker() {
            this.exceptionQueue = new LinkedBlockingQueue<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void logException(Throwable th2) {
            this.exceptionQueue.offer(th2);
        }

        @Override // java.lang.Runnable
        @SuppressLint({"LogNotTimber"})
        public void run() {
            while (true) {
                try {
                    Throwable thTake = this.exceptionQueue.take();
                    if (a.treeCount() > 0) {
                        a.e(thTake, "Exception from JNI", new Object[0]);
                    } else {
                        Log.e(JniExceptionHandler.TAG, "Exception from JNI", thTake);
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Throwable unused2) {
                }
            }
        }
    }

    static {
        logWorker = null;
        logWorker = new LogWorker();
        Thread thread = new Thread(logWorker);
        thread.setDaemon(true);
        thread.start();
    }

    public static void logException(Throwable th2) {
        logWorker.logException(th2);
    }
}
