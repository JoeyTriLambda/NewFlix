package ah;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource.kt */
/* loaded from: classes2.dex */
public final class k implements y {

    /* renamed from: b, reason: collision with root package name */
    public final e f698b;

    /* renamed from: m, reason: collision with root package name */
    public final Inflater f699m;

    /* renamed from: n, reason: collision with root package name */
    public int f700n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f701o;

    public k(e eVar, Inflater inflater) {
        zf.i.checkNotNullParameter(eVar, "source");
        zf.i.checkNotNullParameter(inflater, "inflater");
        this.f698b = eVar;
        this.f699m = inflater;
    }

    @Override // ah.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f701o) {
            return;
        }
        this.f699m.end();
        this.f701o = true;
        this.f698b.close();
    }

    @Override // ah.y
    public long read(c cVar, long j10) throws DataFormatException, IOException {
        zf.i.checkNotNullParameter(cVar, "sink");
        do {
            long orInflate = readOrInflate(cVar, j10);
            if (orInflate > 0) {
                return orInflate;
            }
            Inflater inflater = this.f699m;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.f698b.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public final long readOrInflate(c cVar, long j10) throws DataFormatException, IOException {
        Inflater inflater = this.f699m;
        zf.i.checkNotNullParameter(cVar, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(zf.i.stringPlus("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        if (!(!this.f701o)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j10 == 0) {
            return 0L;
        }
        try {
            u uVarWritableSegment$okio = cVar.writableSegment$okio(1);
            int iMin = (int) Math.min(j10, 8192 - uVarWritableSegment$okio.f725c);
            refill();
            int iInflate = inflater.inflate(uVarWritableSegment$okio.f723a, uVarWritableSegment$okio.f725c, iMin);
            int i10 = this.f700n;
            if (i10 != 0) {
                int remaining = i10 - inflater.getRemaining();
                this.f700n -= remaining;
                this.f698b.skip(remaining);
            }
            if (iInflate > 0) {
                uVarWritableSegment$okio.f725c += iInflate;
                long j11 = iInflate;
                cVar.setSize$okio(cVar.size() + j11);
                return j11;
            }
            if (uVarWritableSegment$okio.f724b == uVarWritableSegment$okio.f725c) {
                cVar.f676b = uVarWritableSegment$okio.pop();
                v.recycle(uVarWritableSegment$okio);
            }
            return 0L;
        } catch (DataFormatException e10) {
            throw new IOException(e10);
        }
    }

    public final boolean refill() throws IOException {
        Inflater inflater = this.f699m;
        if (!inflater.needsInput()) {
            return false;
        }
        e eVar = this.f698b;
        if (eVar.exhausted()) {
            return true;
        }
        u uVar = eVar.getBuffer().f676b;
        zf.i.checkNotNull(uVar);
        int i10 = uVar.f725c;
        int i11 = uVar.f724b;
        int i12 = i10 - i11;
        this.f700n = i12;
        inflater.setInput(uVar.f723a, i11, i12);
        return false;
    }

    @Override // ah.y
    public z timeout() {
        return this.f698b.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(y yVar, Inflater inflater) {
        this(m.buffer(yVar), inflater);
        zf.i.checkNotNullParameter(yVar, "source");
        zf.i.checkNotNullParameter(inflater, "inflater");
    }
}
