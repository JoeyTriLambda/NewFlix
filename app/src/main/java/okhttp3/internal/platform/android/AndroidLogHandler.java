package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import zf.i;

/* compiled from: AndroidLog.kt */
/* loaded from: classes2.dex */
public final class AndroidLogHandler extends Handler {
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    private AndroidLogHandler() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        i.checkNotNullParameter(logRecord, "record");
        AndroidLog androidLog = AndroidLog.INSTANCE;
        String loggerName = logRecord.getLoggerName();
        i.checkNotNullExpressionValue(loggerName, "record.loggerName");
        int androidLevel = AndroidLogKt.getAndroidLevel(logRecord);
        String message = logRecord.getMessage();
        i.checkNotNullExpressionValue(message, "record.message");
        androidLog.androidLog$okhttp(loggerName, androidLevel, message, logRecord.getThrown());
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }
}
