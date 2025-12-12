package ah;

import java.io.EOFException;

/* compiled from: Okio.kt */
/* loaded from: classes2.dex */
public final class b implements w {
    @Override // ah.w
    public z timeout() {
        return z.NONE;
    }

    @Override // ah.w
    public void write(c cVar, long j10) throws EOFException {
        zf.i.checkNotNullParameter(cVar, "source");
        cVar.skip(j10);
    }

    @Override // ah.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // ah.w, java.io.Flushable
    public void flush() {
    }
}
