package okhttp3.internal.concurrent;

import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.Http2Connection;
import yf.a;
import zf.h;
import zf.i;

/* compiled from: TaskLogger.kt */
/* loaded from: classes2.dex */
public final class TaskLoggerKt {
    public static final String formatDuration(long j10) {
        String str;
        if (j10 <= -999500000) {
            str = ((j10 - 500000000) / Http2Connection.DEGRADED_PONG_TIMEOUT_NS) + " s ";
        } else if (j10 <= -999500) {
            str = ((j10 - 500000) / 1000000) + " ms";
        } else if (j10 <= 0) {
            str = ((j10 - 500) / 1000) + " µs";
        } else if (j10 < 999500) {
            str = ((j10 + 500) / 1000) + " µs";
        } else if (j10 < 999500000) {
            str = ((j10 + 500000) / 1000000) + " ms";
        } else {
            str = ((j10 + 500000000) / Http2Connection.DEGRADED_PONG_TIMEOUT_NS) + " s ";
        }
        String str2 = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        i.checkNotNullExpressionValue(str2, "format(format, *args)");
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.Companion.getLogger();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(taskQueue.getName$okhttp());
        sb2.append(TokenParser.SP);
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        i.checkNotNullExpressionValue(str2, "format(format, *args)");
        sb2.append(str2);
        sb2.append(": ");
        sb2.append(task.getName());
        logger.fine(sb2.toString());
    }

    public static final <T> T logElapsed(Task task, TaskQueue taskQueue, a<? extends T> aVar) {
        long jNanoTime;
        i.checkNotNullParameter(task, "task");
        i.checkNotNullParameter(taskQueue, "queue");
        i.checkNotNullParameter(aVar, "block");
        boolean zIsLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (zIsLoggable) {
            jNanoTime = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, taskQueue, "starting");
        } else {
            jNanoTime = -1;
        }
        try {
            T tInvoke = aVar.invoke();
            h.finallyStart(1);
            if (zIsLoggable) {
                log(task, taskQueue, i.stringPlus("finished run in ", formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - jNanoTime)));
            }
            h.finallyEnd(1);
            return tInvoke;
        } catch (Throwable th2) {
            h.finallyStart(1);
            if (zIsLoggable) {
                log(task, taskQueue, i.stringPlus("failed a run in ", formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - jNanoTime)));
            }
            h.finallyEnd(1);
            throw th2;
        }
    }

    public static final void taskLog(Task task, TaskQueue taskQueue, a<String> aVar) {
        i.checkNotNullParameter(task, "task");
        i.checkNotNullParameter(taskQueue, "queue");
        i.checkNotNullParameter(aVar, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, taskQueue, aVar.invoke());
        }
    }
}
