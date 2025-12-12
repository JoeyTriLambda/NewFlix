package ah;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: Sink.kt */
/* loaded from: classes2.dex */
public interface w extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    z timeout();

    void write(c cVar, long j10) throws IOException;
}
