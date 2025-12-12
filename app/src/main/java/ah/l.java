package ah;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: JvmOkio.kt */
/* loaded from: classes2.dex */
public final class l implements y {

    /* renamed from: b, reason: collision with root package name */
    public final InputStream f702b;

    /* renamed from: m, reason: collision with root package name */
    public final z f703m;

    public l(InputStream inputStream, z zVar) {
        zf.i.checkNotNullParameter(inputStream, "input");
        zf.i.checkNotNullParameter(zVar, "timeout");
        this.f702b = inputStream;
        this.f703m = zVar;
    }

    @Override // ah.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f702b.close();
    }

    @Override // ah.y
    public long read(c cVar, long j10) throws IOException {
        zf.i.checkNotNullParameter(cVar, "sink");
        if (j10 == 0) {
            return 0L;
        }
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(zf.i.stringPlus("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        try {
            this.f703m.throwIfReached();
            u uVarWritableSegment$okio = cVar.writableSegment$okio(1);
            int i10 = this.f702b.read(uVarWritableSegment$okio.f723a, uVarWritableSegment$okio.f725c, (int) Math.min(j10, 8192 - uVarWritableSegment$okio.f725c));
            if (i10 != -1) {
                uVarWritableSegment$okio.f725c += i10;
                long j11 = i10;
                cVar.setSize$okio(cVar.size() + j11);
                return j11;
            }
            if (uVarWritableSegment$okio.f724b != uVarWritableSegment$okio.f725c) {
                return -1L;
            }
            cVar.f676b = uVarWritableSegment$okio.pop();
            v.recycle(uVarWritableSegment$okio);
            return -1L;
        } catch (AssertionError e10) {
            if (m.isAndroidGetsocknameError(e10)) {
                throw new IOException(e10);
            }
            throw e10;
        }
    }

    @Override // ah.y
    public z timeout() {
        return this.f703m;
    }

    public String toString() {
        return "source(" + this.f702b + ')';
    }
}
