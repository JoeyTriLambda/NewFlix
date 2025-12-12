package ah;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: Source.kt */
/* loaded from: classes2.dex */
public interface y extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(c cVar, long j10) throws IOException;

    z timeout();
}
