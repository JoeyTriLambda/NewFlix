package ah;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: JvmOkio.kt */
/* loaded from: classes2.dex */
public final class q implements w {

    /* renamed from: b, reason: collision with root package name */
    public final OutputStream f708b;

    /* renamed from: m, reason: collision with root package name */
    public final z f709m;

    public q(OutputStream outputStream, z zVar) {
        zf.i.checkNotNullParameter(outputStream, "out");
        zf.i.checkNotNullParameter(zVar, "timeout");
        this.f708b = outputStream;
        this.f709m = zVar;
    }

    @Override // ah.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f708b.close();
    }

    @Override // ah.w, java.io.Flushable
    public void flush() throws IOException {
        this.f708b.flush();
    }

    @Override // ah.w
    public z timeout() {
        return this.f709m;
    }

    public String toString() {
        return "sink(" + this.f708b + ')';
    }

    @Override // ah.w
    public void write(c cVar, long j10) throws IOException {
        zf.i.checkNotNullParameter(cVar, "source");
        d0.checkOffsetAndCount(cVar.size(), 0L, j10);
        while (j10 > 0) {
            this.f709m.throwIfReached();
            u uVar = cVar.f676b;
            zf.i.checkNotNull(uVar);
            int iMin = (int) Math.min(j10, uVar.f725c - uVar.f724b);
            this.f708b.write(uVar.f723a, uVar.f724b, iMin);
            uVar.f724b += iMin;
            long j11 = iMin;
            j10 -= j11;
            cVar.setSize$okio(cVar.size() - j11);
            if (uVar.f724b == uVar.f725c) {
                cVar.f676b = uVar.pop();
                v.recycle(uVar);
            }
        }
    }
}
